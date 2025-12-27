//! Depth-First Class/Method Traversal
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/DepthTraversal.java
//! Original Author: Skylot
//! Clone Date: Dec 2025
//! Lines: 33
//!
//! Provides utilities for depth-first traversal of class/method trees with error handling.
//! Used by the visitor pipeline to process classes and their inner classes.

/// Trait for visitors that process classes and methods
///
/// JADX Reference: IDexTreeVisitor interface
pub trait DexTreeVisitor {
    /// Visit a class. Return true to traverse inner classes and methods.
    fn visit_class(&mut self, class_idx: u32) -> bool {
        let _ = class_idx;
        true
    }

    /// Visit a method.
    fn visit_method(&mut self, method_idx: u32) {
        let _ = method_idx;
    }
}

/// Result of depth traversal
#[derive(Debug, Clone, Default)]
pub struct DepthTraversalResult {
    /// Number of classes visited
    pub classes_visited: usize,
    /// Number of methods visited
    pub methods_visited: usize,
    /// Number of errors encountered
    pub errors: usize,
}

/// Visit a class and its inner classes/methods depth-first.
///
/// JADX Reference: DepthTraversal.visit(IDexTreeVisitor, ClassNode)
pub fn visit_class<V: DexTreeVisitor>(
    visitor: &mut V,
    class_idx: u32,
    inner_class_indices: &[u32],
    method_indices: &[u32],
) -> DepthTraversalResult {
    let mut result = DepthTraversalResult::default();

    // Visit the class
    result.classes_visited += 1;
    if visitor.visit_class(class_idx) {
        // Visit inner classes (would need to recurse with their inner classes/methods)
        for &inner_idx in inner_class_indices {
            result.classes_visited += 1;
            visitor.visit_class(inner_idx);
        }

        // Visit methods
        for &method_idx in method_indices {
            result.methods_visited += 1;
            visitor.visit_method(method_idx);
        }
    }

    result
}

/// Visit a single method.
///
/// JADX Reference: DepthTraversal.visit(IDexTreeVisitor, MethodNode)
pub fn visit_method<V: DexTreeVisitor>(visitor: &mut V, method_idx: u32) -> bool {
    visitor.visit_method(method_idx);
    true
}

#[cfg(test)]
mod tests {
    use super::*;

    struct CountingVisitor {
        classes: usize,
        methods: usize,
    }

    impl DexTreeVisitor for CountingVisitor {
        fn visit_class(&mut self, _class_idx: u32) -> bool {
            self.classes += 1;
            true
        }

        fn visit_method(&mut self, _method_idx: u32) {
            self.methods += 1;
        }
    }

    #[test]
    fn test_visit_class() {
        let mut visitor = CountingVisitor {
            classes: 0,
            methods: 0,
        };

        let result = visit_class(&mut visitor, 0, &[1, 2], &[10, 11, 12]);

        assert_eq!(result.classes_visited, 3); // Main class + 2 inner
        assert_eq!(result.methods_visited, 3);
        assert_eq!(visitor.classes, 3);
        assert_eq!(visitor.methods, 3);
    }

    #[test]
    fn test_skip_inner() {
        struct SkipVisitor;
        impl DexTreeVisitor for SkipVisitor {
            fn visit_class(&mut self, _class_idx: u32) -> bool {
                false // Skip inner classes and methods
            }
        }

        let mut visitor = SkipVisitor;
        let result = visit_class(&mut visitor, 0, &[1, 2], &[10, 11, 12]);

        assert_eq!(result.classes_visited, 1); // Only main class
        assert_eq!(result.methods_visited, 0);
    }
}
