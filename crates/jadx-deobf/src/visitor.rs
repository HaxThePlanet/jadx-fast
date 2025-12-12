//! Deobfuscation visitor
//!
//! Ported from jadx-core/src/main/java/jadx/core/deobf/DeobfuscatorVisitor.java

use jadx_ir::ClassData;
use crate::conditions::{DeobfCondition, Action};
use crate::alias_provider::AliasProvider;

/// Deobfuscation visitor that applies renaming to classes
pub struct DeobfuscatorVisitor<C, A>
where
    C: DeobfCondition,
    A: AliasProvider,
{
    condition: C,
    alias_provider: A,
}

impl<C, A> DeobfuscatorVisitor<C, A>
where
    C: DeobfCondition,
    A: AliasProvider,
{
    pub fn new(condition: C, alias_provider: A) -> Self {
        Self {
            condition,
            alias_provider,
        }
    }

    /// Process a single class, applying deobfuscation
    pub fn process_class(&self, cls: &mut ClassData) {
        // Check if class should be renamed
        let class_action = self.condition.check_class(cls);
        if class_action.should_rename() && cls.alias.is_none() {
            cls.alias = Some(self.alias_provider.for_class(cls));
        }

        // Process fields
        for field in &mut cls.static_fields {
            let action = self.condition.check_field(field);
            if action.should_rename() && field.alias.is_none() {
                field.alias = Some(self.alias_provider.for_field(field));
            }
        }
        for field in &mut cls.instance_fields {
            let action = self.condition.check_field(field);
            if action.should_rename() && field.alias.is_none() {
                field.alias = Some(self.alias_provider.for_field(field));
            }
        }

        // Process methods
        for method in &mut cls.methods {
            let action = self.condition.check_method(method);
            if action.should_rename() && method.alias.is_none() {
                // TODO: Check if method is an override
                let is_override = Self::is_likely_override(method);
                method.alias = Some(self.alias_provider.for_method(method, is_override));
            }
        }
    }

    /// Check if a method is likely an override (has @Override annotation)
    fn is_likely_override(method: &jadx_ir::MethodData) -> bool {
        method.annotations.iter().any(|a| {
            a.annotation_type.ends_with("/Override;")
                || a.annotation_type == "Ljava/lang/Override;"
        })
    }

    /// Process multiple classes
    pub fn process_classes(&self, classes: &mut [ClassData]) {
        for cls in classes {
            self.process_class(cls);
        }
    }
}

/// Configuration for deobfuscation
#[derive(Debug, Clone)]
pub struct DeobfConfig {
    /// Minimum name length (shorter names are renamed)
    pub min_length: usize,
    /// Maximum name length (longer names get hashed)
    pub max_length: usize,
    /// Whether deobfuscation is enabled
    pub enabled: bool,
}

impl Default for DeobfConfig {
    fn default() -> Self {
        Self {
            min_length: 3,
            max_length: 64,
            enabled: false,
        }
    }
}

impl DeobfConfig {
    pub fn new(enabled: bool, min_length: usize, max_length: usize) -> Self {
        Self {
            min_length,
            max_length,
            enabled,
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::conditions::{CombinedCondition, LengthCondition, ValidityCondition};
    use crate::alias_provider::DeobfAliasProvider;
    use jadx_ir::{ArgType, FieldData, MethodData};

    #[test]
    fn test_visitor() {
        let condition = CombinedCondition::default_jadx(3, 64);
        let provider = DeobfAliasProvider::new(64);
        let visitor = DeobfuscatorVisitor::new(condition, provider);

        // Create a class with short names
        let mut cls = ClassData::new("La/b/C;".to_string(), 0);
        cls.methods.push(MethodData::new("a".to_string(), 0, ArgType::Void));
        cls.instance_fields.push(FieldData::new("x".to_string(), 0, ArgType::Int));

        // Process
        visitor.process_class(&mut cls);

        // Class should be renamed (name "C" is only 1 char)
        assert!(cls.alias.is_some(), "Class should have alias");

        // Method should be renamed (name "a" is only 1 char)
        assert!(cls.methods[0].alias.is_some(), "Method should have alias");

        // Field should be renamed (name "x" is only 1 char)
        assert!(cls.instance_fields[0].alias.is_some(), "Field should have alias");
    }

    #[test]
    fn test_no_rename_valid_names() {
        let condition = CombinedCondition::default_jadx(3, 64);
        let provider = DeobfAliasProvider::new(64);
        let visitor = DeobfuscatorVisitor::new(condition, provider);

        // Create a class with valid names
        let mut cls = ClassData::new("Lcom/example/MainActivity;".to_string(), 0);
        cls.methods.push(MethodData::new("onCreate".to_string(), 0, ArgType::Void));
        cls.instance_fields.push(FieldData::new("count".to_string(), 0, ArgType::Int));

        // Process
        visitor.process_class(&mut cls);

        // Nothing should be renamed
        assert!(cls.alias.is_none(), "Class should not have alias");
        assert!(cls.methods[0].alias.is_none(), "Method should not have alias");
        assert!(cls.instance_fields[0].alias.is_none(), "Field should not have alias");
    }
}
