//! Deobfuscation conditions
//!
//! Ported from jadx-core/src/main/java/jadx/core/deobf/conditions/

use std::collections::HashSet;
use dexterity_ir::{ClassData, FieldData, MethodData};
use crate::name_mapper::NameMapper;

/// Rename flags that control deobfuscation behavior
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum RenameFlag {
    /// Rename for case-insensitive filesystem safety
    Case,
    /// Rename invalid Java identifiers
    Valid,
    /// Rename non-printable characters
    Printable,
}

/// Action to take for a node
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum Action {
    /// No action needed
    NoAction,
    /// Rename is suggested but can be overridden
    Rename,
    /// Force rename (e.g., invalid identifier)
    ForceRename,
    /// Do not rename under any circumstances
    DontRename,
}

impl Action {
    /// Check if this action should trigger renaming
    pub fn should_rename(&self) -> bool {
        matches!(self, Action::Rename | Action::ForceRename)
    }

    /// Combine two actions (more restrictive wins)
    pub fn combine(self, other: Action) -> Action {
        match (self, other) {
            (Action::DontRename, _) | (_, Action::DontRename) => Action::DontRename,
            (Action::ForceRename, _) | (_, Action::ForceRename) => Action::ForceRename,
            (Action::Rename, _) | (_, Action::Rename) => Action::Rename,
            _ => Action::NoAction,
        }
    }
}

/// Trait for deobfuscation conditions
pub trait DeobfCondition: Send + Sync {
    /// Check if a package should be renamed
    fn check_package(&self, name: &str) -> Action {
        let _ = name;
        Action::NoAction
    }

    /// Check if a class should be renamed
    fn check_class(&self, cls: &ClassData) -> Action {
        let _ = cls;
        Action::NoAction
    }

    /// Check if a field should be renamed
    fn check_field(&self, field: &FieldData) -> Action {
        let _ = field;
        Action::NoAction
    }

    /// Check if a method should be renamed
    fn check_method(&self, method: &MethodData) -> Action {
        let _ = method;
        Action::NoAction
    }
}

/// Condition based on name length (min/max)
pub struct LengthCondition {
    min_length: usize,
    max_length: usize,
}

impl LengthCondition {
    pub fn new(min_length: usize, max_length: usize) -> Self {
        Self { min_length, max_length }
    }

    fn check_name(&self, name: &str) -> Action {
        let len = name.len();
        if len < self.min_length || len > self.max_length {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }
}

impl DeobfCondition for LengthCondition {
    fn check_package(&self, name: &str) -> Action {
        self.check_name(name)
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        self.check_name(cls.simple_name())
    }

    fn check_field(&self, field: &FieldData) -> Action {
        self.check_name(&field.name)
    }

    fn check_method(&self, method: &MethodData) -> Action {
        self.check_name(&method.name)
    }
}

/// Condition based on identifier validity
pub struct ValidityCondition;

impl ValidityCondition {
    pub fn new() -> Self {
        Self
    }

    fn check_name(&self, name: &str) -> Action {
        if !NameMapper::is_valid_and_printable(name) {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }
}

impl Default for ValidityCondition {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for ValidityCondition {
    fn check_package(&self, name: &str) -> Action {
        self.check_name(name)
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        self.check_name(cls.simple_name())
    }

    fn check_field(&self, field: &FieldData) -> Action {
        self.check_name(&field.name)
    }

    fn check_method(&self, method: &MethodData) -> Action {
        self.check_name(&method.name)
    }
}

/// Combined condition that applies multiple conditions
pub struct CombinedCondition {
    conditions: Vec<Box<dyn DeobfCondition>>,
}

impl CombinedCondition {
    pub fn new(conditions: Vec<Box<dyn DeobfCondition>>) -> Self {
        Self { conditions }
    }

    /// Build default JADX conditions (length + validity)
    pub fn default_jadx(min_length: usize, max_length: usize) -> Self {
        Self::new(vec![
            Box::new(ValidityCondition::new()),
            Box::new(LengthCondition::new(min_length, max_length)),
        ])
    }

    fn combine_actions<F>(&self, f: F) -> Action
    where
        F: Fn(&dyn DeobfCondition) -> Action,
    {
        let mut result = Action::NoAction;
        for cond in &self.conditions {
            let action = f(cond.as_ref());
            if action == Action::DontRename {
                return Action::DontRename;
            }
            result = result.combine(action);
        }
        result
    }
}

impl DeobfCondition for CombinedCondition {
    fn check_package(&self, name: &str) -> Action {
        self.combine_actions(|c| c.check_package(name))
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        self.combine_actions(|c| c.check_class(cls))
    }

    fn check_field(&self, field: &FieldData) -> Action {
        self.combine_actions(|c| c.check_field(field))
    }

    fn check_method(&self, method: &MethodData) -> Action {
        self.combine_actions(|c| c.check_method(method))
    }
}

/// Condition based on printable characters only
pub struct PrintableCondition;

impl PrintableCondition {
    pub fn new() -> Self {
        Self
    }

    fn check_name(&self, name: &str) -> Action {
        if !NameMapper::is_all_chars_printable(name) {
            Action::ForceRename
        } else {
            Action::NoAction
        }
    }
}

impl Default for PrintableCondition {
    fn default() -> Self {
        Self::new()
    }
}

impl DeobfCondition for PrintableCondition {
    fn check_package(&self, name: &str) -> Action {
        self.check_name(name)
    }

    fn check_class(&self, cls: &ClassData) -> Action {
        self.check_name(cls.simple_name())
    }

    fn check_field(&self, field: &FieldData) -> Action {
        self.check_name(&field.name)
    }

    fn check_method(&self, method: &MethodData) -> Action {
        self.check_name(&method.name)
    }
}

/// Build conditions from a set of rename flags
///
/// This allows CLI flags to configure which conditions are applied.
pub fn build_conditions_from_flags(
    flags: &HashSet<RenameFlag>,
    min_length: usize,
    max_length: usize,
) -> CombinedCondition {
    let mut conditions: Vec<Box<dyn DeobfCondition>> = Vec::new();

    // If no flags specified, use default JADX behavior
    if flags.is_empty() {
        return CombinedCondition::default_jadx(min_length, max_length);
    }

    // Add conditions based on flags
    if flags.contains(&RenameFlag::Valid) {
        conditions.push(Box::new(ValidityCondition::new()));
        conditions.push(Box::new(LengthCondition::new(min_length, max_length)));
    }

    if flags.contains(&RenameFlag::Printable) {
        conditions.push(Box::new(PrintableCondition::new()));
    }

    // Note: Case flag would need filesystem context to implement properly
    // For now, it doesn't add any conditions (case sensitivity is OS-dependent)
    // In Java JADX, this is handled by checking for class name collisions
    if flags.contains(&RenameFlag::Case) {
        // Case-insensitive collision detection would need access to all class names
        // This is typically handled at a higher level in the pipeline
    }

    // If only Case flag and nothing else, still use default behavior
    if conditions.is_empty() {
        return CombinedCondition::default_jadx(min_length, max_length);
    }

    CombinedCondition::new(conditions)
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_length_condition() {
        let cond = LengthCondition::new(3, 64);

        // Short names should be renamed
        let mut method = MethodData::new("a".to_string(), 0, dexterity_ir::ArgType::Void);
        assert_eq!(cond.check_method(&method), Action::ForceRename);

        // Normal names should not be renamed
        method.name = "onCreate".to_string();
        assert_eq!(cond.check_method(&method), Action::NoAction);
    }

    #[test]
    fn test_validity_condition() {
        let cond = ValidityCondition::new();

        // Valid name
        let mut method = MethodData::new("onCreate".to_string(), 0, dexterity_ir::ArgType::Void);
        assert_eq!(cond.check_method(&method), Action::NoAction);

        // Invalid name (starts with number)
        method.name = "123test".to_string();
        assert_eq!(cond.check_method(&method), Action::ForceRename);

        // Reserved word
        method.name = "class".to_string();
        assert_eq!(cond.check_method(&method), Action::ForceRename);
    }
}
