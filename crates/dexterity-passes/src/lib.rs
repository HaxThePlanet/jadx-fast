//! Decompilation passes for dexterity
//!
//! This crate contains the visitor passes that transform the IR.

pub mod algorithms;
pub mod anonymous_class_visitor;
pub mod attach_method_details;
pub mod block_exception_handler; // NEW: JADX BlockExceptionHandler clone (P0 Critical - 640 lines)
pub mod block_split;
pub mod clean_regions;
pub mod check_code;
pub mod check_regions;
pub mod class_modifier;  // NEW: JADX ClassModifier clone
pub mod constructor_visitor;
pub mod debug_info;  // NEW: JADX DebugInfoAttachVisitor + DebugInfoApplyVisitor clone (P1)
pub mod process_instructions;
pub mod cfg;
pub mod code_shrink;
pub mod conditionals;
pub mod const_inline;
pub mod deboxing;
pub mod enum_visitor;
pub mod exc_handlers_region;  // NEW: JADX ExcHandlersRegionMaker clone
pub mod extract_field_init;
pub mod finally_extract;
pub mod finish_type_inference;
pub mod fix_multi_entry_loops; // NEW: JADX FixMultiEntryLoops clone
pub mod fix_switch_over_enum;  // NEW: JADX FixSwitchOverEnum clone
pub mod fix_types;
pub mod generic_types;
pub mod if_region_visitor;
pub mod init_code_vars;
pub mod inline_methods;  // NEW: JADX InlineMethods clone
pub mod kotlin_intrinsics;
pub mod loop_analysis;
pub mod loops;
pub mod method_inline;
pub mod method_invoke;
pub mod method_throws_visitor;
pub mod mod_visitor;
pub mod move_inline;
pub mod override_method;
pub mod post_process_regions;
pub mod prepare_for_codegen;
pub mod process_anonymous;
pub mod process_try_catch_regions; // NEW: JADX ProcessTryCatchRegions clone
pub mod process_variables;
pub mod region_builder;
pub mod rename_visitor;     // NEW: JADX RenameVisitor + NameMapper clone (deobfuscation)
pub mod replace_new_array;  // NEW: JADX ReplaceNewArray clone
pub mod return_visitor;
pub mod shadow_field;
pub mod signature_processor;   // NEW: JADX SignatureProcessor clone
pub mod simplify;
pub mod ssa;
pub mod switch_break_visitor;  // NEW: JADX SwitchBreakVisitor clone
pub mod switch_over_string;    // NEW: JADX SwitchOverStringVisitor clone
pub mod synchronized_region;   // NEW: JADX SynchronizedRegionMaker clone
pub mod ternary_mod;
pub mod type_bound;
pub mod type_inference;
pub mod type_search;
pub mod type_update;
pub mod usage_info;
pub mod var_naming;
pub mod visitor;

// Re-exports
pub use algorithms::{compute_dominators, DominatorInfo, LiveVarAnalysis, LivenessInfo};
pub use block_split::{split_blocks, split_blocks_with_handlers, BasicBlock, BlockSplitResult};
pub use process_instructions::{process_instructions, process_instructions_with_stats, ProcessInstructionsResult};
pub use cfg::CFG;
pub use conditionals::{
    detect_conditionals, detect_ternary_assignment, find_condition_chains, is_ternary_candidate,
    merge_nested_conditions, IfInfo, MergeMode, MergedCondition, TernaryInfo,
};
pub use extract_field_init::{extract_field_init, extract_instance_field_init};
pub use finally_extract::{apply_finally_marking, extract_finally, FinallyExtractInfo, InsnsSlice};
pub use kotlin_intrinsics::{process_kotlin_intrinsics, process_kotlin_intrinsics_with_context, IntrinsicsContext};
pub use loops::{detect_loops, LoopInfo};
pub use loop_analysis::{analyze_loop_patterns, ArrayForEachPattern, ForLoopPattern, LoopPatternResult, UpperBound};
pub use method_inline::{
    analyze_method_for_inline, mark_methods_for_inline, should_skip_method,
};
pub use region_builder::{
    build_regions, build_regions_with_try_catch, build_regions_with_method_flags,
    detect_all_loop_edges, detect_loop_edge_insns,
    mark_duplicated_finally, refine_loops_with_patterns,
    EdgeInsn, EdgeInsnKind, LoopEdgeInsns,
};
pub use ssa::{transform_to_ssa, transform_to_ssa_owned, DominatorTree, PhiNode, SsaBlock, SsaResult};
pub use type_inference::{
    infer_types, infer_types_with_context, infer_types_with_context_and_hierarchy,
    infer_types_with_hierarchy, infer_types_with_full_context, infer_types_with_context_and_return_type,
    Constraint, InferredType, TypeInference, TypeInferenceResult,
    TypeVar,
};
pub use var_naming::{assign_var_names, assign_var_names_with_lookups, FieldNameInfo, MethodNameInfo, VarNaming, VarNamingResult};
pub use simplify::{simplify_instructions, SimplifyResult};
pub use const_inline::{inline_constants, ConstInlineResult};
pub use code_shrink::{shrink_code, CodeShrinkResult, WrapTarget};
pub use ternary_mod::{
    analyze_ternary_opportunities, process_ternary_mod, TernaryKind, TernaryModResult,
    TernaryPattern,
};
pub use enum_visitor::{
    analyze_enum_class, analyze_enum_class_with_strings, is_enum_synthetic_method, is_values_field,
    EnumArg, EnumClassInfo, EnumFieldInfo, EnumVisitorResult,
};
pub use prepare_for_codegen::{prepare_for_codegen, PrepareForCodeGenResult};
pub use mod_visitor::{run_mod_visitor, ModVisitorResult};
pub use type_bound::{
    BoundEnum, TypeBound, TypeBoundConst, TypeBoundCheckCastAssign,
    TypeBoundDynamic, TypeBoundFieldGetAssign, TypeBoundInvokeAssign,
    TypeBoundInvokeUse, TypeInfo, TypeUpdateContext,
};
pub use type_update::{
    InsnKind, TypeListener, TypeUpdateEngine, TypeUpdateEntry, TypeUpdateFlags,
    TypeUpdateInfo, TypeUpdateResult,
};
pub use type_search::{
    collect_constraints, TypeSearch, TypeSearchConstraint, TypeSearchResult,
    TypeSearchState, TypeSearchVarInfo,
};
pub use finish_type_inference::{
    finish_type_inference, finish_type_inference_with_names, FinishTypeInferenceResult,
};
pub use fix_types::{
    fix_types, fix_types_with_context, FixStrategy, FixTypes, FixTypesResult,
};
pub use deboxing::{
    debox_primitives, debox_primitives_with_lookup, is_unboxing_method, is_wrapper_class,
    primitive_for_wrapper, wrapper_for_primitive, Deboxing, DeboxingResult, MethodInfo as DeboxingMethodInfo,
};
pub use generic_types::{
    attach_generic_types, class_has_generics, resolve_constructor_generics, GenericTypesResult,
};
pub use if_region_visitor::{process_if_regions, IfRegionVisitorResult};
pub use init_code_vars::{init_code_variables, rerun_code_variables};
pub use process_variables::{process_variables, get_code_var_name, merge_code_var_type, ProcessVariablesResult};
pub use shadow_field::{
    apply_shadow_field_fixes, get_field_fix, is_instance_field_access, search_shadowed_fields,
    FieldFixInfo, FieldFixType, ShadowFieldResult,
};
pub use method_invoke::{
    compare_types, detect_vararg_call, find_required_casts, get_compiler_var_type, process_invoke,
    MethodDetails, MethodInvokeResult, TypeCompareResult,
};
pub use override_method::{
    analyze_overrides, collect_super_types, find_overridden_methods, fix_method_arg_types,
    fix_method_return_type, make_method_signature, should_add_override, MethodOverrideAttr,
    OverriddenMethod, OverrideAnalysisResult, SuperTypesData,
};

// New passes for JADX parity
pub use check_code::{check_code, CheckCodeError, CheckCodeResult, CheckCodeWarning};
pub use check_regions::{check_regions, has_missing_blocks, CheckRegionsResult, LoopWarning, MissingBlock};
pub use usage_info::{collect_usage_from_instructions, FieldRef, MethodRef, UsageInfo};
pub use process_anonymous::{
    process_anonymous, AnonymousClassInfo, ClassInfo, InlineType, ProcessAnonymousResult,
};
pub use anonymous_class_visitor::{
    is_anonymous_class, process_anonymous_class, AnonymousClassVisitorResult, ArgToFieldMapping,
};
pub use clean_regions::{clean_regions, CleanRegionsResult};
pub use method_throws_visitor::{
    collect_invoke_throws, process_method_throws, MethodThrowsResult,
};
pub use move_inline::{inline_moves, MoveInlineResult};
pub use post_process_regions::{
    insert_edge_insn, post_process_regions, region_ends_with_return_or_throw,
    PostProcessRegionsResult,
};
pub use return_visitor::{
    block_ends_with_return, ends_with_return, is_void_return_block, optimize_returns,
    ReturnVisitorResult,
};
pub use constructor_visitor::{
    analyze_class_constructors, is_constructor, is_implicit_default_constructor,
    is_static_initializer, process_constructor, ClassConstructorAnalysis, ConstructorCallType,
    ConstructorInfo, ConstructorVisitorResult, FieldInit,
};
pub use attach_method_details::{
    attach_param_names, is_lambda_impl, is_synthetic_accessor, parse_method_signature,
    AttachMethodDetailsResult, MethodDetails as AttachedMethodDetails, MethodSignature, TypeParameter,
};

// NEW: JADX parity passes (Dec 23, 2025)
// See: jadx-fast/jadx-core/src/main/java/jadx/core/dex/visitors/

pub use fix_switch_over_enum::{
    init_class_enum_map, is_ordinal_call, is_switch_map_field, process_enum_switch,
    should_hide_synthetic_class, EnumMapAttr, EnumMapInfo, EnumSwitchFix, EnumSwitchMap,
    FixSwitchOverEnumResult,
};
pub use switch_break_visitor::{
    block_contains_exit_insn, extract_common_break, is_break_block, is_break_for_switch,
    is_exit_edge_insn, optimize_switch_breaks, region_ends_with_exit, remove_unreachable_break,
    ExtractCommonBreakResult, SwitchBreakVisitorResult,
};
pub use class_modifier::{
    find_methods_to_hide, find_synthetic_fields_to_hide, is_bridge_method, is_captured_variable,
    is_empty_synthetic_class, is_outer_class_reference, is_removable_empty_clinit,
    is_removable_empty_constructor, is_synthetic_accessor_wrapper, process_class_modifiers,
    ClassModifierResult, FieldReplaceAttr, HideElement, MethodReplaceAttr,
};
pub use inline_methods::{
    analyze_method_for_inlining, inline_invoke, process_method_inlines,
    InlineMethodsResult, InlinePattern, MethodInlineAttr,
};
pub use loop_analysis::{
    analyze_loop_patterns_with_iterables, detect_iterator_foreach, EnhancedLoopPatternResult,
    IteratorForEachPattern,
};
pub use switch_over_string::{
    process_switch_over_string, SwitchOverStringResult,
};
pub use replace_new_array::{
    build_filled_array, process_replace_new_array, FilledArrayData, ReplaceNewArrayResult,
};
pub use fix_multi_entry_loops::{
    detect_special_edges, fix_multi_entry_loops, FixMultiEntryLoopsResult, SpecialEdge, SpecialEdgeType,
};
pub use process_try_catch_regions::{
    process_try_catch_regions, HandlerInfo, ProcessTryCatchRegionsResult, TryCatchBlockInfo,
};
pub use exc_handlers_region::{
    find_handlers_out_blocks, get_top_splitter_for_handler, process_exc_handlers,
    ExcHandlersRegionResult, ExceptionHandlerInfo, TryCatchBlockAttr as ExcTryCatchBlockAttr,
};
pub use signature_processor::{
    check_method_arg_types, fix_type_param_declarations, process_interfaces, process_super_type,
    validate_full_class_name, validate_inner_type, validate_parsed_type,
    InnerClassInfo, SignatureProcessorResult,
};
pub use synchronized_region::{
    can_remove_sync_block, create_synchronized_region, process_synchronized_regions,
    remove_synchronized_from_method, MonitorInfo, SyncBlockInfo, SynchronizedRegionResult,
};
pub use rename_visitor::{
    // NameMapper functions (JADX clone)
    is_reserved, is_valid_identifier, is_valid_full_identifier,
    is_valid_identifier_start, is_valid_identifier_part,
    is_printable_ascii, is_all_chars_printable, is_valid_and_printable,
    remove_invalid_chars, remove_invalid_chars_middle, remove_non_printable_chars,
    // RenameVisitor functions (JADX clone)
    fix_class_short_name, fix_field_name, fix_method_name, fix_package_name,
    check_class_name, check_case_insensitive_collision,
    // Types
    AliasProvider, RenameReason, RenameReasonType, RenameResult,
    // Constants
    ANONYMOUS_CLASS_PREFIX, DEFAULT_PACKAGE_NAME,
};

/// Pass trait for decompilation passes
pub trait Pass: Send + Sync {
    /// Name of this pass
    fn name(&self) -> &'static str;

    /// Passes that must run before this one
    fn run_after(&self) -> &[&'static str] {
        &[]
    }
}
