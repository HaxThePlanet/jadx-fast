//! Type Listener Registry for instruction-specific type refinement
//!
//! This module provides a pluggable system for instruction-specific type constraints
//! during type inference, matching JADX's ITypeListener system.

use dexterity_ir::instructions::{InsnType, InvokeKind, RegisterArg};
use dexterity_ir::types::{ArgType, TypeCompare};
use std::collections::HashMap;

/// Result of a type update operation
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum TypeUpdateResult {
    /// Type update was rejected (conflict)
    Reject,
    /// Type unchanged (already matches)
    Same,
    /// Type successfully updated
    Changed,
}

/// Discriminant enum for instruction types
///
/// This provides a hashable key for the listener registry, since
/// InsnType itself contains data that makes it non-hashable.
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum InsnKind {
    Phi,
    Move,
    ArrayGet,
    ArrayPut,
    CheckCast,
    InvokeVirtual,
    InvokeInterface,
    InvokeDirect,
    InvokeStatic,
    InvokeSuper,
    InvokeCustom,
    Other,
}

impl InsnKind {
    /// Extract the kind discriminant from an instruction type
    pub fn from_insn_type(insn: &InsnType) -> Self {
        match insn {
            InsnType::Phi { .. } => InsnKind::Phi,
            InsnType::Move { .. } => InsnKind::Move,
            InsnType::ArrayGet { .. } => InsnKind::ArrayGet,
            InsnType::ArrayPut { .. } => InsnKind::ArrayPut,
            InsnType::CheckCast { .. } => InsnKind::CheckCast,
            InsnType::Invoke { kind, .. } => match kind {
                InvokeKind::Virtual => InsnKind::InvokeVirtual,
                InvokeKind::Interface => InsnKind::InvokeInterface,
                InvokeKind::Direct => InsnKind::InvokeDirect,
                InvokeKind::Static => InsnKind::InvokeStatic,
                InvokeKind::Super => InsnKind::InvokeSuper,
                InvokeKind::Custom | InvokeKind::Polymorphic => InsnKind::InvokeCustom,
            },
            InsnType::InvokeCustom { .. } => InsnKind::InvokeCustom,
            _ => InsnKind::Other,
        }
    }
}

/// Context for type updates (passed to listeners)
///
/// This provides access to the current state of type inference
/// and allows listeners to query and update related variables.
pub struct TypeUpdateContext<'a> {
    /// Current variable types (RegisterArg -> ArgType)
    pub current_types: &'a HashMap<RegisterArg, ArgType>,
    /// Pending type updates (to be applied if validation succeeds)
    pub pending_updates: &'a mut HashMap<RegisterArg, ArgType>,
    /// Class hierarchy for subtype queries
    pub hierarchy: Option<&'a dexterity_ir::ClassHierarchy>,
}

impl<'a> TypeUpdateContext<'a> {
    /// Get the current type of a register argument
    pub fn get_type(&self, arg: &RegisterArg) -> ArgType {
        // Check pending updates first, then current types
        self.pending_updates
            .get(arg)
            .or_else(|| self.current_types.get(arg))
            .cloned()
            .unwrap_or(ArgType::Unknown)
    }

    /// Request a type update (adds to pending updates)
    pub fn request_update(&mut self, arg: RegisterArg, new_type: ArgType) {
        self.pending_updates.insert(arg, new_type);
    }

    /// Compare two types using class hierarchy
    pub fn compare_types(&self, first: &ArgType, second: &ArgType) -> TypeCompare {
        dexterity_ir::types::compare_types(first, second, self.hierarchy)
    }
}

/// Trait for instruction-specific type listeners
///
/// Each instruction type can have custom type propagation logic
/// by implementing this trait.
pub trait TypeListener: Send + Sync {
    /// Called when a type is being updated
    ///
    /// The listener should:
    /// 1. Check if the update is valid for this instruction
    /// 2. Request related type updates via context
    /// 3. Return REJECT if the update conflicts with constraints
    ///
    /// # Arguments
    /// * `arg` - The register argument being updated
    /// * `new_type` - The new type being assigned
    /// * `context` - Context for querying and updating related types
    fn on_type_update(
        &self,
        arg: &RegisterArg,
        new_type: &ArgType,
        context: &mut TypeUpdateContext,
    ) -> TypeUpdateResult;
}

/// Listener that requires all arguments to have the same type
///
/// Used for: PHI nodes, some arithmetic operations
struct AllSameListener;

impl TypeListener for AllSameListener {
    fn on_type_update(
        &self,
        _arg: &RegisterArg,
        _new_type: &ArgType,
        _context: &mut TypeUpdateContext,
    ) -> TypeUpdateResult {
        // For PHI and certain operations, all arguments must match exactly
        // This is a simplified version - full implementation would check all phi args

        // If updating result, propagate to all uses
        // If updating arg, verify compatibility with result

        // This is a placeholder - actual implementation needs access to instruction structure
        TypeUpdateResult::Changed
    }
}

/// Listener for MOVE instructions with special widening rules
///
/// MOVE allows the result to be wider than the argument (implicit upcast)
struct MoveListener;

impl TypeListener for MoveListener {
    fn on_type_update(
        &self,
        _arg: &RegisterArg,
        new_type: &ArgType,
        _context: &mut TypeUpdateContext,
    ) -> TypeUpdateResult {
        // MOVE special rules:
        // - If updating result: arg can be narrower (upcast)
        // - If updating arg: result can be wider

        // Check if result type is wider-or-equal to arg type
        // This is a simplified version

        if new_type.is_unknown() {
            return TypeUpdateResult::Same;
        }

        TypeUpdateResult::Changed
    }
}

/// Listener for array get/put operations with bidirectional propagation
///
/// Array operations constrain both array type and element type:
/// - array.get(idx) -> element type
/// - array.put(idx, value) -> array of value type
struct ArrayListener {
    is_get: bool, // true for AGET, false for APUT
}

impl TypeListener for ArrayListener {
    fn on_type_update(
        &self,
        _arg: &RegisterArg,
        new_type: &ArgType,
        _context: &mut TypeUpdateContext,
    ) -> TypeUpdateResult {
        // Bidirectional array/element type propagation

        if self.is_get {
            // AGET: If array type is known, result type = element type
            // If result type is known, array type = Array(result)

            match new_type {
                ArgType::Array(_elem) => {
                    // Array type known - propagate element type to result
                    // context.request_update(result_arg, *elem.clone());
                    TypeUpdateResult::Changed
                }
                _ if !new_type.is_array() => {
                    // Result type known - propagate Array(result) to array arg
                    TypeUpdateResult::Changed
                }
                _ => TypeUpdateResult::Same,
            }
        } else {
            // APUT: value type constrains array element type
            TypeUpdateResult::Changed
        }
    }
}

/// Listener for CHECK_CAST with generic type propagation
struct CheckCastListener;

impl TypeListener for CheckCastListener {
    fn on_type_update(
        &self,
        _arg: &RegisterArg,
        new_type: &ArgType,
        _context: &mut TypeUpdateContext,
    ) -> TypeUpdateResult {
        // CHECK_CAST propagates generic type parameters
        // e.g., (List<String>) obj -> subsequent uses know generic type

        if matches!(new_type, ArgType::Generic { .. }) {
            TypeUpdateResult::Changed
        } else {
            TypeUpdateResult::Same
        }
    }
}

/// Listener for INVOKE with generic return type resolution
struct InvokeListener;

impl TypeListener for InvokeListener {
    fn on_type_update(
        &self,
        _arg: &RegisterArg,
        _new_type: &ArgType,
        _context: &mut TypeUpdateContext,
    ) -> TypeUpdateResult {
        // INVOKE generic return type resolution:
        // 1. Get instance type
        // 2. Extract type variable mappings (T -> String for List<String>)
        // 3. Resolve return type using mappings

        // This requires access to method signature and instance type
        // Placeholder for now
        TypeUpdateResult::Changed
    }
}

/// Registry of type listeners for instruction kinds
pub struct TypeListenerRegistry {
    listeners: HashMap<InsnKind, Box<dyn TypeListener>>,
}

impl TypeListenerRegistry {
    /// Create a new registry with default listeners
    pub fn new() -> Self {
        let mut registry = TypeListenerRegistry {
            listeners: HashMap::new(),
        };

        // Register default listeners
        registry.register_default_listeners();
        registry
    }

    /// Register default listeners for common instruction types
    fn register_default_listeners(&mut self) {
        // PHI nodes require all arguments to match
        self.listeners
            .insert(InsnKind::Phi, Box::new(AllSameListener));

        // MOVE has special widening rules
        self.listeners
            .insert(InsnKind::Move, Box::new(MoveListener));

        // Array operations have bidirectional propagation
        self.listeners
            .insert(InsnKind::ArrayGet, Box::new(ArrayListener { is_get: true }));
        self.listeners
            .insert(InsnKind::ArrayPut, Box::new(ArrayListener { is_get: false }));

        // CHECK_CAST propagates generic types
        self.listeners
            .insert(InsnKind::CheckCast, Box::new(CheckCastListener));

        // INVOKE resolves generic return types
        self.listeners
            .insert(InsnKind::InvokeVirtual, Box::new(InvokeListener));
        self.listeners
            .insert(InsnKind::InvokeInterface, Box::new(InvokeListener));
        self.listeners
            .insert(InsnKind::InvokeDirect, Box::new(InvokeListener));
        self.listeners
            .insert(InsnKind::InvokeStatic, Box::new(InvokeListener));
    }

    /// Get the listener for an instruction type
    pub fn get_listener(&self, insn_type: &InsnType) -> Option<&dyn TypeListener> {
        let kind = InsnKind::from_insn_type(insn_type);
        self.listeners.get(&kind).map(|b| b.as_ref())
    }

    /// Get the listener for an instruction kind directly
    pub fn get_listener_by_kind(&self, kind: InsnKind) -> Option<&dyn TypeListener> {
        self.listeners.get(&kind).map(|b| b.as_ref())
    }

    /// Register a custom listener for an instruction kind
    pub fn register(&mut self, kind: InsnKind, listener: Box<dyn TypeListener>) {
        self.listeners.insert(kind, listener);
    }
}

impl Default for TypeListenerRegistry {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use dexterity_ir::instructions::RegisterArg;

    #[test]
    fn test_registry_creation() {
        let registry = TypeListenerRegistry::new();

        // Check that default listeners are registered
        assert!(registry.get_listener_by_kind(InsnKind::Phi).is_some());
        assert!(registry.get_listener_by_kind(InsnKind::Move).is_some());
        assert!(registry.get_listener_by_kind(InsnKind::ArrayGet).is_some());
    }

    #[test]
    fn test_custom_listener_registration() {
        let mut registry = TypeListenerRegistry::new();

        struct CustomListener;
        impl TypeListener for CustomListener {
            fn on_type_update(
                &self,
                _arg: &RegisterArg,
                _new_type: &ArgType,
                _context: &mut TypeUpdateContext,
            ) -> TypeUpdateResult {
                TypeUpdateResult::Changed
            }
        }

        registry.register(InsnKind::Other, Box::new(CustomListener));
        assert!(registry.get_listener_by_kind(InsnKind::Other).is_some());
    }
}
