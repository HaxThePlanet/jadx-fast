//! Method code generation
//!
//! Generates Java source code for methods.

use std::collections::BTreeSet;

/// Sanitize a method name to be a valid Java identifier
/// R8/D8 optimizer creates synthetic methods with hyphens (e.g., $r8$lambda$...-...)
/// which are invalid Java identifiers. This converts hyphens to underscores.
fn sanitize_method_name(name: &str) -> String {
    if !name.contains('-') {
        return name.to_string();
    }
    // Replace hyphens with underscores (simpler than camelCase for method names)
    name.replace('-', "_")
}

/// Check if a method is too complex to decompile cleanly
/// Returns Some(reason) if method should be skipped, None if it should be decompiled normally
///
/// NOTE: This is more conservative than before - we only skip methods with extreme
/// instruction counts. JADX handles Compose UI code and long methods fine, so we do too.
fn should_skip_complex_method(method: &MethodData) -> Option<String> {
    // Only skip methods with extremely high instruction counts (10000+)
    // JADX handles most methods regardless of size, so we should too
    if let Some(ref bytecode_ref) = method.bytecode_ref {
        if bytecode_ref.insns_count > 10000 {
            return Some(format!("instructions count: {}", bytecode_ref.insns_count));
        }
    }

    // NOTE: We no longer skip methods based on:
    // - Composer parameter (Compose UI code) - JADX handles these fine
    // - @Composable annotation - JADX handles these fine
    // The previous checks were too aggressive and caused unnecessary skipping

    None
}

/// Check if a static initializer (clinit) is empty and should be skipped
/// A clinit is considered empty if all its instructions are "non-output" instructions:
/// - Nop instructions
/// - Return void
/// - Const/ConstString/ConstClass (no output without subsequent use)
/// - Marked with DontGenerate flag
///
/// GAP-04 FIX: After field extraction, clinit may only have Nop/Const/DontGenerate
/// instructions left. These should NOT generate an empty `static {}` block.
///
/// The key insight is that CONST instructions by themselves don't produce output -
/// they only define register values. After extract_field_init removes SPUT instructions,
/// the CONST instructions become orphaned (unused) but are left in the method.
fn is_empty_clinit(method: &MethodData) -> bool {
    use dexterity_ir::instructions::InsnType;
    use dexterity_ir::attributes::AFlag;

    if let Some(insns) = method.instructions() {
        // Check if all instructions are "non-output" (don't produce any code by themselves)
        let has_meaningful_instruction = insns.iter().any(|insn| {
            // Skip DontGenerate instructions
            if insn.has_flag(AFlag::DontGenerate) {
                return false;
            }
            // Skip control flow and value-defining instructions that don't produce output
            match &insn.insn_type {
                InsnType::Nop => false,
                InsnType::Return { value: None } => false,
                // Const instructions don't produce output by themselves - they just define register values
                // After field extraction, orphaned CONST instructions remain but have no effect
                InsnType::Const { .. } => false,
                InsnType::ConstString { .. } => false,
                InsnType::ConstClass { .. } => false,
                // Move instructions also don't produce output by themselves
                InsnType::Move { .. } => false,
                // NewInstance without a following constructor call/use is orphaned
                InsnType::NewInstance { .. } => false,
                // Any other instruction is "meaningful" and should produce output
                _ => true,
            }
        });

        !has_meaningful_instruction
    } else {
        // No instructions at all (native or abstract - unusual for clinit)
        true
    }
}

/// Check if a constructor argument type is synthetic and should be filtered
///
/// JADX Reference: ClassModifier.java:181-208 - isRemovedClassInArgs()
/// Synthetic constructor arguments include:
/// - Outer class reference (first arg for inner class constructors)
/// - Anonymous class markers (e.g., Outer$1, Outer$$Lambda$1)
/// - Synthetic helper classes (empty synthetic classes)
///
/// Returns true if the argument should be skipped in parameter list.
fn is_synthetic_constructor_arg(arg_type: &ArgType, arg_index: usize, method: &MethodData, class: &ClassData) -> bool {
    // Only filter for constructors
    if !method.is_constructor() {
        return false;
    }

    // Only filter if the method is synthetic
    if !crate::access_flags::is_synthetic(method.access_flags) {
        return false;
    }

    // Get the type descriptor for analysis
    let type_desc = match arg_type {
        ArgType::Object(desc) => desc,
        _ => return false,
    };

    // Pattern 1: First arg is the outer class reference
    // For inner class constructors, the first arg is typically the outer class
    if arg_index == 0 {
        // Check if class is an inner class and arg type is the parent
        let class_name = &class.class_type;
        if class_name.contains('$') {
            // Extract potential outer class: Lcom/example/Outer$Inner; -> Lcom/example/Outer;
            if let Some(dollar_pos) = class_name.rfind('$') {
                let outer_prefix = &class_name[..dollar_pos];
                let outer_type = format!("{};", outer_prefix);
                if type_desc == &outer_type {
                    return true;
                }
            }
        }
    }

    // Pattern 2: Anonymous class markers (Outer$1, Outer$2, $$Lambda$, etc.)
    // These are compiler-generated classes used as constructor markers
    if type_desc.contains("$") {
        // Check for numeric suffix pattern: Outer$1, Outer$2, etc.
        if let Some(dollar_pos) = type_desc.rfind('$') {
            let suffix = &type_desc[dollar_pos + 1..];
            // Remove trailing semicolon
            let suffix_trimmed = suffix.trim_end_matches(';');
            // If suffix is all digits, it's an anonymous class marker
            if !suffix_trimmed.is_empty() && suffix_trimmed.chars().all(|c| c.is_ascii_digit()) {
                return true;
            }
            // Lambda markers
            if suffix.contains("Lambda") {
                return true;
            }
        }
    }

    false
}

use dexterity_ir::{Annotation, AnnotationValue, AnnotationVisibility, ArgType, ClassData, MethodData, TypeParameter};

use crate::access_flags::{self, flags::*, AccessContext};
use crate::body_gen::{generate_body_with_dex, generate_body_with_dex_and_imports, generate_body_with_inner_classes, generate_body_with_inner_classes_and_lambdas};
use crate::class_gen::CommentsLevel;
use crate::dex_info::DexInfoProvider;
use crate::type_gen::{get_innermost_name, get_package, get_simple_name, type_to_string_with_imports_and_package};
use crate::writer::CodeWriter;

/// Add a rename comment if the method was renamed during deobfuscation
/// JADX Clone: jadx-core/src/main/java/jadx/core/dex/attributes/RenameReasonAttr.java:31-50
fn add_renamed_comment<W: CodeWriter>(code: &mut W, original_name: &str, comments_level: CommentsLevel) {
    add_renamed_comment_with_reasons(code, original_name, &[], comments_level)
}

/// Add a rename comment with reasons (JADX parity)
/// JADX Clone: RenameReasonAttr.buildReason() joins reasons with " and "
fn add_renamed_comment_with_reasons<W: CodeWriter>(
    code: &mut W,
    original_name: &str,
    reasons: &[String],
    comments_level: CommentsLevel,
) {
    if !comments_level.show_info() {
        return;
    }
    code.start_line()
        .add("/* renamed from: ")
        .add(original_name);
    if !reasons.is_empty() {
        // JADX Clone: "reason: " + String.join(" and ", reasons)
        code.add(", reason: ");
        code.add(&reasons.join(" and "));
    }
    code.add(" */")
        .newline();
}

/// Generate type parameters declaration (e.g., "<T, E extends Number>")
/// Supports Kotlin variance annotations (in/out modifiers)
/// Like JADX's ClassGen.addGenericTypeParameters()
pub fn generate_type_parameters<W: CodeWriter>(
    type_params: &[TypeParameter],
    imports: Option<&BTreeSet<String>>,
    current_package: Option<&str>,
    code: &mut W,
) {
    if type_params.is_empty() {
        return;
    }

    code.add("<");
    for (i, param) in type_params.iter().enumerate() {
        if i > 0 {
            code.add(", ");
        }

        // Add Kotlin variance modifier if present (in/out)
        // This produces declarations like `<in T>` or `<out E>`
        if let Some(keyword) = param.variance.kotlin_keyword() {
            code.add(keyword);
            code.add(" ");
        }

        // Add reified modifier if present (for Kotlin inline functions)
        if param.reified {
            code.add("reified ");
        }

        code.add(&param.name);

        // Add bounds if present (e.g., "extends Number & Comparable<T>")
        if !param.bounds.is_empty() {
            code.add(" extends ");
            for (j, bound) in param.bounds.iter().enumerate() {
                if j > 0 {
                    code.add(" & ");
                }
                code.add(&type_to_string_with_imports_and_package(bound, imports, current_package));
            }
        }
    }
    code.add(">");
}

/// Database of known interface/class methods for @Override detection
/// Maps interface/class names to their known method names
fn get_known_interface_methods() -> &'static std::collections::HashMap<&'static str, &'static [&'static str]> {
    use std::collections::HashMap;
    use std::sync::OnceLock;

    static KNOWN_METHODS: OnceLock<HashMap<&'static str, &'static [&'static str]>> = OnceLock::new();

    KNOWN_METHODS.get_or_init(|| {
        let mut m = HashMap::new();

        // java.lang.*
        m.insert("java/lang/Object", &["equals", "hashCode", "toString", "clone", "finalize"][..]);
        m.insert("java/lang/Runnable", &["run"][..]);
        m.insert("java/lang/Comparable", &["compareTo"][..]);
        m.insert("java/lang/CharSequence", &["length", "charAt", "subSequence", "toString"][..]);
        m.insert("java/lang/Appendable", &["append"][..]);
        m.insert("java/lang/Readable", &["read"][..]);
        m.insert("java/lang/AutoCloseable", &["close"][..]);
        m.insert("java/lang/Iterable", &["iterator", "forEach", "spliterator"][..]);
        m.insert("java/lang/Thread$UncaughtExceptionHandler", &["uncaughtException"][..]);

        // java.util.*
        m.insert("java/util/Iterator", &["hasNext", "next", "remove", "forEachRemaining"][..]);
        m.insert("java/util/ListIterator", &["hasNext", "next", "hasPrevious", "previous", "nextIndex", "previousIndex", "remove", "set", "add"][..]);
        m.insert("java/util/Enumeration", &["hasMoreElements", "nextElement"][..]);
        m.insert("java/util/Comparator", &["compare", "equals", "reversed", "thenComparing"][..]);
        m.insert("java/util/Collection", &["size", "isEmpty", "contains", "iterator", "toArray", "add", "remove", "containsAll", "addAll", "removeAll", "retainAll", "clear"][..]);
        m.insert("java/util/List", &["size", "isEmpty", "contains", "iterator", "toArray", "add", "remove", "containsAll", "addAll", "removeAll", "retainAll", "clear", "get", "set", "indexOf", "lastIndexOf", "listIterator", "subList"][..]);
        m.insert("java/util/Set", &["size", "isEmpty", "contains", "iterator", "toArray", "add", "remove", "containsAll", "addAll", "removeAll", "retainAll", "clear"][..]);
        m.insert("java/util/Map", &["size", "isEmpty", "containsKey", "containsValue", "get", "put", "remove", "putAll", "clear", "keySet", "values", "entrySet"][..]);
        m.insert("java/util/Map$Entry", &["getKey", "getValue", "setValue", "equals", "hashCode"][..]);
        m.insert("java/util/EventListener", &[][..]);
        m.insert("java/util/Observer", &["update"][..]);

        // java.util.concurrent.*
        m.insert("java/util/concurrent/Callable", &["call"][..]);
        m.insert("java/util/concurrent/Future", &["cancel", "isCancelled", "isDone", "get"][..]);
        m.insert("java/util/concurrent/Executor", &["execute"][..]);
        m.insert("java/util/concurrent/ThreadFactory", &["newThread"][..]);
        m.insert("java/util/concurrent/RejectedExecutionHandler", &["rejectedExecution"][..]);

        // java.util.function.*
        m.insert("java/util/function/Function", &["apply", "andThen", "compose"][..]);
        m.insert("java/util/function/Consumer", &["accept", "andThen"][..]);
        m.insert("java/util/function/Supplier", &["get"][..]);
        m.insert("java/util/function/Predicate", &["test", "and", "or", "negate"][..]);
        m.insert("java/util/function/BiFunction", &["apply", "andThen"][..]);
        m.insert("java/util/function/BiConsumer", &["accept", "andThen"][..]);
        m.insert("java/util/function/BiPredicate", &["test", "and", "or", "negate"][..]);
        m.insert("java/util/function/UnaryOperator", &["apply"][..]);
        m.insert("java/util/function/BinaryOperator", &["apply"][..]);

        // java.io.*
        m.insert("java/io/Closeable", &["close"][..]);
        m.insert("java/io/Flushable", &["flush"][..]);
        m.insert("java/io/Serializable", &[][..]);
        m.insert("java/io/Externalizable", &["writeExternal", "readExternal"][..]);
        m.insert("java/io/ObjectInputValidation", &["validateObject"][..]);
        m.insert("java/io/FilenameFilter", &["accept"][..]);
        m.insert("java/io/FileFilter", &["accept"][..]);
        m.insert("java/io/DataInput", &["readFully", "skipBytes", "readBoolean", "readByte", "readUnsignedByte", "readShort", "readUnsignedShort", "readChar", "readInt", "readLong", "readFloat", "readDouble", "readLine", "readUTF"][..]);
        m.insert("java/io/DataOutput", &["write", "writeBoolean", "writeByte", "writeShort", "writeChar", "writeInt", "writeLong", "writeFloat", "writeDouble", "writeBytes", "writeChars", "writeUTF"][..]);

        // java.io streams (inheritance-based, so methods may be overridden)
        m.insert("java/io/InputStream", &["read", "skip", "available", "close", "mark", "reset", "markSupported"][..]);
        m.insert("java/io/OutputStream", &["write", "flush", "close"][..]);
        m.insert("java/io/Reader", &["read", "skip", "ready", "close", "mark", "reset", "markSupported"][..]);
        m.insert("java/io/Writer", &["write", "append", "flush", "close"][..]);

        // java.net.*
        m.insert("java/net/URLStreamHandlerFactory", &["createURLStreamHandler"][..]);
        m.insert("java/net/ContentHandlerFactory", &["createContentHandler"][..]);
        m.insert("java/net/SocketImplFactory", &["createSocketImpl"][..]);

        // Android core
        m.insert("android/app/Activity", &["onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onRestart", "onSaveInstanceState", "onRestoreInstanceState", "onNewIntent", "onActivityResult", "onRequestPermissionsResult", "onCreateOptionsMenu", "onOptionsItemSelected", "onBackPressed", "finish"][..]);
        m.insert("android/app/Fragment", &["onAttach", "onCreate", "onCreateView", "onViewCreated", "onActivityCreated", "onStart", "onResume", "onPause", "onStop", "onDestroyView", "onDestroy", "onDetach", "onSaveInstanceState"][..]);
        m.insert("android/app/Service", &["onCreate", "onStartCommand", "onBind", "onUnbind", "onRebind", "onDestroy"][..]);
        m.insert("android/content/BroadcastReceiver", &["onReceive"][..]);
        m.insert("android/content/ContentProvider", &["onCreate", "query", "getType", "insert", "delete", "update"][..]);
        m.insert("android/app/Application", &["onCreate", "onTerminate", "onConfigurationChanged", "onLowMemory", "onTrimMemory"][..]);

        // AndroidX/Support
        m.insert("androidx/fragment/app/Fragment", &["onAttach", "onCreate", "onCreateView", "onViewCreated", "onActivityCreated", "onStart", "onResume", "onPause", "onStop", "onDestroyView", "onDestroy", "onDetach", "onSaveInstanceState"][..]);
        m.insert("androidx/appcompat/app/AppCompatActivity", &["onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy"][..]);
        m.insert("androidx/recyclerview/widget/RecyclerView$Adapter", &["onCreateViewHolder", "onBindViewHolder", "getItemCount", "getItemViewType", "getItemId", "onViewRecycled", "onViewAttachedToWindow", "onViewDetachedFromWindow"][..]);
        m.insert("androidx/recyclerview/widget/RecyclerView$ViewHolder", &[][..]);
        m.insert("androidx/lifecycle/LifecycleObserver", &[][..]);
        m.insert("androidx/lifecycle/ViewModel", &["onCleared"][..]);

        // Android View
        m.insert("android/view/View", &["onDraw", "onMeasure", "onLayout", "onSizeChanged", "onAttachedToWindow", "onDetachedFromWindow", "onTouchEvent", "onClick", "onLongClick", "onFocusChanged"][..]);
        m.insert("android/view/View$OnClickListener", &["onClick"][..]);
        m.insert("android/view/View$OnLongClickListener", &["onLongClick"][..]);
        m.insert("android/view/View$OnTouchListener", &["onTouch"][..]);
        m.insert("android/view/View$OnFocusChangeListener", &["onFocusChange"][..]);
        m.insert("android/view/ViewGroup", &["onLayout", "onMeasure", "onInterceptTouchEvent"][..]);

        // Android TextWatcher and adapters
        m.insert("android/text/TextWatcher", &["beforeTextChanged", "onTextChanged", "afterTextChanged"][..]);
        m.insert("android/widget/AdapterView$OnItemClickListener", &["onItemClick"][..]);
        m.insert("android/widget/AdapterView$OnItemSelectedListener", &["onItemSelected", "onNothingSelected"][..]);
        m.insert("android/widget/BaseAdapter", &["getCount", "getItem", "getItemId", "getView"][..]);
        m.insert("android/widget/ArrayAdapter", &["getCount", "getItem", "getItemId", "getView", "getDropDownView"][..]);

        // Android Dialog
        m.insert("android/content/DialogInterface$OnClickListener", &["onClick"][..]);
        m.insert("android/content/DialogInterface$OnDismissListener", &["onDismiss"][..]);
        m.insert("android/content/DialogInterface$OnCancelListener", &["onCancel"][..]);
        m.insert("android/content/DialogInterface$OnShowListener", &["onShow"][..]);

        // Android Handler/Looper
        m.insert("android/os/Handler$Callback", &["handleMessage"][..]);
        m.insert("android/os/Parcelable", &["describeContents", "writeToParcel"][..]);
        m.insert("android/os/Parcelable$Creator", &["createFromParcel", "newArray"][..]);

        // OkHttp (commonly used)
        m.insert("okhttp3/Interceptor", &["intercept"][..]);
        m.insert("okhttp3/Callback", &["onFailure", "onResponse"][..]);
        m.insert("okhttp3/WebSocketListener", &["onOpen", "onMessage", "onClosing", "onClosed", "onFailure"][..]);
        m.insert("okhttp3/RequestBody", &["contentType", "contentLength", "writeTo"][..]);
        m.insert("okhttp3/ResponseBody", &["contentType", "contentLength", "source", "close"][..]);
        m.insert("okhttp3/CookieJar", &["saveFromResponse", "loadForRequest"][..]);
        m.insert("okhttp3/Dns", &["lookup"][..]);
        m.insert("okhttp3/Authenticator", &["authenticate"][..]);
        m.insert("okhttp3/Call$Factory", &["newCall"][..]);
        m.insert("okhttp3/WebSocket$Factory", &["newWebSocket"][..]);

        // Okio
        m.insert("okio/Source", &["read", "timeout", "close"][..]);
        m.insert("okio/Sink", &["write", "flush", "timeout", "close"][..]);
        m.insert("okio/BufferedSource", &["buffer", "exhausted", "require", "request"][..]);
        m.insert("okio/BufferedSink", &["buffer", "write", "writeUtf8", "emit", "emitCompleteSegments"][..]);

        // RxJava
        m.insert("io/reactivex/Observer", &["onSubscribe", "onNext", "onError", "onComplete"][..]);
        m.insert("io/reactivex/SingleObserver", &["onSubscribe", "onSuccess", "onError"][..]);
        m.insert("io/reactivex/CompletableObserver", &["onSubscribe", "onComplete", "onError"][..]);
        m.insert("io/reactivex/MaybeObserver", &["onSubscribe", "onSuccess", "onError", "onComplete"][..]);
        m.insert("io/reactivex/functions/Function", &["apply"][..]);
        m.insert("io/reactivex/functions/Consumer", &["accept"][..]);
        m.insert("io/reactivex/functions/Action", &["run"][..]);

        // Glide
        m.insert("com/bumptech/glide/load/Key", &["updateDiskCacheKey", "equals", "hashCode"][..]);
        m.insert("com/bumptech/glide/load/Transformation", &["transform", "updateDiskCacheKey"][..]);
        m.insert("com/bumptech/glide/module/GlideModule", &["applyOptions", "registerComponents"][..]);
        m.insert("com/bumptech/glide/manager/Lifecycle", &["addListener", "removeListener"][..]);
        m.insert("com/bumptech/glide/manager/LifecycleListener", &["onStart", "onStop", "onDestroy"][..]);
        m.insert("com/bumptech/glide/manager/ConnectivityMonitor$ConnectivityListener", &["onConnectivityChanged"][..]);
        m.insert("com/bumptech/glide/manager/ConnectivityMonitor", &["onStart", "onStop", "onDestroy"][..]);
        m.insert("com/bumptech/glide/gifdecoder/GifDecoder", &["getWidth", "getHeight", "getData", "getStatus", "advance", "getDelay", "getNextDelay", "getFrameCount", "getCurrentFrameIndex", "resetFrameIndex", "getLoopCount", "getNetscapeLoopCount", "getTotalIterationCount", "getByteSize", "getNextFrame", "read", "clear", "setData"][..]);

        m
    })
}

/// Get the declaring class for an @Override annotation based on method name and class hierarchy
fn find_override_source(method_name: &str, class: &ClassData) -> Option<String> {
    let known_methods = get_known_interface_methods();

    // Check superclass (skip java/lang/Object for common methods)
    if let Some(superclass) = &class.superclass {
        if superclass != "java/lang/Object" {
            if let Some(methods) = known_methods.get(superclass.as_str()) {
                if methods.contains(&method_name) {
                    return Some(superclass.replace('/', "."));
                }
            }
            // Even if not in known methods database, if we have a non-Object superclass,
            // it's likely an override
            return Some(superclass.replace('/', "."));
        }
    }

    // Check interfaces
    for iface in &class.interfaces {
        let iface_name = match iface {
            ArgType::Object(name) => name.as_str(),
            ArgType::Generic { base, .. } => base.as_str(),
            _ => continue,
        };

        if let Some(methods) = known_methods.get(iface_name) {
            if methods.contains(&method_name) {
                return Some(iface_name.replace('/', "."));
            }
        }
    }

    // Check for java.lang.Object methods (equals, hashCode, toString, clone, finalize)
    // These are always overrideable if the class has any parent or interface
    let object_methods = ["equals", "hashCode", "toString", "clone", "finalize"];
    if object_methods.contains(&method_name) {
        // If class has a superclass (not Object) or interfaces, this is likely an override
        if class.superclass.as_ref().map(|s| s != "java/lang/Object").unwrap_or(false)
            || !class.interfaces.is_empty() {
            return Some("java.lang.Object".to_string());
        }
    }

    None
}

/// Check if a method should have @Override annotation
///
/// Uses the method's override_attr if set (from override analysis), otherwise
/// falls back to enhanced heuristic using known interface methods database.
///
/// Returns Option<String> with the declaring class name for the comment
fn should_add_override_heuristic(method: &MethodData, class: &ClassData) -> Option<String> {
    // BUG-009 fix: Annotation interface methods can't override anything
    if class.is_annotation() {
        return None;
    }

    // Check if method has explicit override attribute from analysis pass
    if let Some(ref override_attr) = method.override_attr {
        // Convert "java/lang/Object" to "java.lang.Object"
        let declaring_class = override_attr.base_class.replace('/', ".");
        return Some(declaring_class);
    }

    // If method already has @Override annotation from DEX, let the annotation system handle it
    for ann in &method.annotations {
        if ann.annotation_type.ends_with("/Override") || ann.annotation_type == "java/lang/Override" {
            return None;
        }
    }

    // Don't add @Override to constructors or static initializers
    if method.is_constructor() || method.is_class_init() {
        return None;
    }
    // Don't add @Override to static or private methods
    if method.is_static() || (method.access_flags & ACC_PRIVATE) != 0 {
        return None;
    }

    // Enhanced heuristic: check known interface methods database
    find_override_source(&method.name, class)
}

/// Generate annotation code for an annotation
pub fn generate_annotation<W: CodeWriter>(annotation: &Annotation, code: &mut W) {
    code.add("@");
    code.add(annotation.simple_name());

    // Add annotation elements if present
    if !annotation.elements.is_empty() {
        code.add("(");
        for (i, elem) in annotation.elements.iter().enumerate() {
            if i > 0 {
                code.add(", ");
            }
            // Single "value" element can omit the name
            if annotation.elements.len() == 1 && elem.name == "value" {
                code.add(&annotation_value_to_string(&elem.value));
            } else {
                code.add(&elem.name);
                code.add(" = ");
                code.add(&annotation_value_to_string(&elem.value));
            }
        }
        code.add(")");
    }
}

/// Convert an annotation value to its string representation
fn annotation_value_to_string(value: &AnnotationValue) -> String {
    match value {
        AnnotationValue::Byte(v) => format!("(byte) {}", v),
        AnnotationValue::Short(v) => format!("(short) {}", v),
        AnnotationValue::Char(v) => {
            if *v >= 32 && *v < 127 {
                format!("'{}'", char::from_u32(*v as u32).unwrap_or('?'))
            } else {
                format!("'\\u{:04x}'", v)
            }
        }
        AnnotationValue::Int(v) => v.to_string(),
        AnnotationValue::Long(v) => format!("{}L", v),
        AnnotationValue::Float(v) => {
            if v.is_nan() {
                "Float.NaN".to_string()
            } else if *v == f32::INFINITY {
                "Float.POSITIVE_INFINITY".to_string()
            } else if *v == f32::NEG_INFINITY {
                "Float.NEGATIVE_INFINITY".to_string()
            } else {
                format!("{}f", v)
            }
        }
        AnnotationValue::Double(v) => {
            if v.is_nan() {
                "Double.NaN".to_string()
            } else if *v == f64::INFINITY {
                "Double.POSITIVE_INFINITY".to_string()
            } else if *v == f64::NEG_INFINITY {
                "Double.NEGATIVE_INFINITY".to_string()
            } else {
                format!("{}d", v)
            }
        }
        AnnotationValue::String(s) => format!("\"{}\"", escape_string(s)),
        AnnotationValue::Type(t) => format!("{}.class", get_simple_name(t)),
        AnnotationValue::Enum(class_name, field_name) => {
            format!("{}.{}", get_simple_name(class_name), field_name)
        }
        AnnotationValue::Annotation(nested) => {
            // Nested annotation - recursively render elements
            let mut s = String::from("@");
            s.push_str(nested.simple_name());
            if !nested.elements.is_empty() {
                s.push('(');
                for (i, elem) in nested.elements.iter().enumerate() {
                    if i > 0 {
                        s.push_str(", ");
                    }
                    // Single "value" element can omit the name
                    if nested.elements.len() == 1 && elem.name == "value" {
                        s.push_str(&annotation_value_to_string(&elem.value));
                    } else {
                        s.push_str(&elem.name);
                        s.push_str(" = ");
                        s.push_str(&annotation_value_to_string(&elem.value));
                    }
                }
                s.push(')');
            }
            s
        }
        AnnotationValue::Array(values) => {
            if values.len() == 1 {
                // Single-element array can omit braces
                annotation_value_to_string(&values[0])
            } else {
                let items: Vec<_> = values.iter().map(annotation_value_to_string).collect();
                format!("{{{}}}", items.join(", "))
            }
        }
        AnnotationValue::Boolean(v) => v.to_string(),
        AnnotationValue::Null => "null".to_string(),
    }
}

/// Escape special characters in a string
fn escape_string(s: &str) -> String {
    let mut result = String::with_capacity(s.len());
    for c in s.chars() {
        match c {
            '\\' => result.push_str("\\\\"),
            '"' => result.push_str("\\\""),
            '\n' => result.push_str("\\n"),
            '\r' => result.push_str("\\r"),
            '\t' => result.push_str("\\t"),
            _ if c.is_control() => result.push_str(&format!("\\u{:04x}", c as u32)),
            _ => result.push(c),
        }
    }
    result
}

/// Check if an annotation should be emitted in generated code
pub fn should_emit_annotation(annotation: &Annotation) -> bool {
    // Don't emit build-time only annotations
    if matches!(annotation.visibility, AnnotationVisibility::Build) {
        return false;
    }

    // Filter out some common internal annotations that shouldn't be emitted
    let type_name = &annotation.annotation_type;
    if type_name.contains("dalvik/annotation/")
        || type_name.contains("kotlin/jvm/internal/SourceDebugExtension")
    {
        return false;
    }

    // KEEP kotlin/Metadata annotations - they are important for Kotlin reflection
    // This is different from other Kotlin internal annotations

    true
}

/// Generate a method into a writer
#[allow(dead_code)]
pub fn generate_method<W: CodeWriter>(
    method: &MethodData,
    class: &ClassData,
    fallback: bool,
    code: &mut W,
) {
    generate_method_with_dex(method, class, fallback, None, None, code)
}

/// Generate a method into a writer with DEX info for name resolution
pub fn generate_method_with_dex<W: CodeWriter>(
    method: &MethodData,
    class: &ClassData,
    _fallback: bool,
    imports: Option<&BTreeSet<String>>,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    code: &mut W,
) {
    // Skip empty static initializers (JADX behavior)
    // A clinit is considered empty if it has no instructions or only a return-void
    if method.is_class_init() && is_empty_clinit(method) {
        return;
    }

    // Get current package for simple type names
    let current_package = get_package(&class.class_type);
    let pkg = current_package.as_deref();

    // Emit method annotations from DEX
    for annotation in &method.annotations {
        if should_emit_annotation(annotation) {
            code.start_line();
            generate_annotation(annotation, code);
            code.newline();
        }
    }

    // Fallback: Add @Override annotation heuristically if no annotations present
    // (non-constructor, non-static, non-private methods in classes with superclass)
    if let Some(declaring_class) = should_add_override_heuristic(method, class) {
        code.start_line().add("@Override // ").add(&declaring_class).newline();
    }

    // Add rename comment if method was renamed during deobfuscation (skip constructors)
    // JADX Clone: Include rename reasons from Kotlin metadata, etc.
    if let Some(ref alias) = method.alias {
        if alias != &method.name && !method.is_constructor() {
            add_renamed_comment_with_reasons(code, &method.name, &method.rename_reasons, CommentsLevel::Info);
        }
    }

    code.start_line();

    // Kotlin function modifiers (emitted as comments for Java output)
    // These appear before Java modifiers to mirror Kotlin syntax order
    let mut kotlin_mods = Vec::new();
    if method.is_suspend {
        kotlin_mods.push("suspend");
    }
    if method.is_inline_function {
        kotlin_mods.push("inline");
    }
    if method.is_infix {
        kotlin_mods.push("infix");
    }
    if method.is_operator {
        kotlin_mods.push("operator");
    }
    if method.is_tailrec {
        kotlin_mods.push("tailrec");
    }
    if !kotlin_mods.is_empty() {
        code.add("/* ").add(&kotlin_mods.join(" ")).add(" */ ");
    }

    // Method modifiers (skip for static initializers since we handle them specially)
    if !method.is_class_init() {
        // JADX parity: Don't add 'public' and 'abstract' to methods in interfaces
        // Also don't add 'public' for annotation methods
        let is_interface = access_flags::is_interface(class.access_flags);
        let is_annotation = access_flags::is_annotation(class.access_flags);

        let effective_flags = if is_interface {
            // Remove PUBLIC and ABSTRACT for interface methods
            method.access_flags & !(access_flags::flags::ACC_PUBLIC | access_flags::flags::ACC_ABSTRACT)
        } else if is_annotation {
            // Remove PUBLIC for annotation methods
            method.access_flags & !access_flags::flags::ACC_PUBLIC
        } else {
            method.access_flags
        };

        let mods = access_flags::access_flags_to_string(effective_flags, AccessContext::Method);
        if !mods.is_empty() {
            code.add(&mods);
        }

        // Clone of JADX MethodGen.java - synthetic method comment (CG-019)
        // Reference: jadx-core/src/main/java/jadx/core/codegen/MethodGen.java
        // JADX adds /* synthetic */ inline for methods with ACC_SYNTHETIC flag
        if access_flags::is_synthetic(method.access_flags) {
            code.add("/* synthetic */ ");
        }

        // JADX parity: Add 'default' for interface methods with code (non-static, non-abstract)
        if is_interface && !method.is_abstract() && !method.is_static() && method.bytecode_ref.is_some() {
            code.add("default ");
        }
    }

    // Type parameters (e.g., <T, E extends Number>)
    let has_type_params = !method.is_constructor() && !method.is_class_init() && !method.type_parameters.is_empty();
    if has_type_params {
        generate_type_parameters(&method.type_parameters, imports, pkg, code);
        code.add(" "); // Space before return type
    }

    // Return type and name
    if method.is_constructor() {
        // Constructor - use innermost class name (handles inner classes)
        let class_name = get_innermost_name(&class.class_type);
        code.add(class_name);
    } else if method.is_class_init() {
        // Static initializer
        code.add("static");
    } else {
        // Regular method (use simple names when imports available or same package)
        code.add(&type_to_string_with_imports_and_package(&method.return_type, imports, pkg));
        code.add(" ");
        // Use alias if available from deobfuscation, sanitize for valid Java identifier
        code.add(&sanitize_method_name(method.display_name()));
    }

    // Parameters (except for static initializer)
    if !method.is_class_init() {
        add_parameters(method, class, imports, pkg, code);
    }

    // Throws clause (except for static initializer)
    if !method.is_class_init() {
        // Get throws from both annotations and instruction scanning
        let mut throws = get_throws_from_annotations(&method.annotations);
        let insn_throws = collect_throws_from_instructions(method, dex_info.as_ref().map(|d| d.as_ref()));

        // Merge instruction-based throws (avoid duplicates)
        for exc in insn_throws {
            if !throws.contains(&exc) {
                throws.push(exc);
            }
        }

        add_throws_clause(&throws, imports, pkg, code);
    }

    // Method body
    if method.is_abstract() || method.is_native() {
        // Abstract/native methods have no body
        // For annotation methods, emit default value if present
        // Like JADX's MethodGen.java lines 172-179
        if class.is_annotation() {
            if let Some(ref default_value) = method.annotation_default {
                code.add(" default ");
                code.add(&annotation_value_to_string(default_value));
            }
        }
        code.add(";").newline();
    } else if method.is_class_init() {
        // Static initializer block
        code.add(" {").newline();
        code.inc_indent();
        add_method_body_with_dex_and_imports(method, dex_info.clone(), imports, code);
        code.dec_indent();
        code.start_line().add("}").newline();
    } else {
        // Regular method with body
        code.add(" {").newline();
        code.inc_indent();
        add_method_body_with_dex_and_imports(method, dex_info.clone(), imports, code);
        code.dec_indent();
        code.start_line().add("}").newline();
    }
}

/// Generate a method into a writer with inner classes for anonymous class inlining
pub fn generate_method_with_inner_classes<W: CodeWriter>(
    method: &MethodData,
    class: &ClassData,
    fallback: bool,
    imports: Option<&BTreeSet<String>>,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    inner_classes: Option<&std::collections::HashMap<String, std::sync::Arc<ClassData>>>,
    // P1-LAMBDA-FIX: Lambda methods for inlining synthetic lambda$ methods
    lambda_methods: Option<&std::collections::HashMap<String, std::sync::Arc<MethodData>>>,
    hierarchy: Option<&dexterity_ir::ClassHierarchy>,
    deobf_min_length: usize,
    deobf_max_length: usize,
    res_names: &std::collections::HashMap<u32, String>,
    replace_consts: bool,
    comments_level: CommentsLevel,
    add_debug_lines: bool,
    code: &mut W,
) {
    // Skip empty static initializers (JADX behavior)
    // A clinit is considered empty if it has no instructions or only a return-void
    if method.is_class_init() && is_empty_clinit(method) {
        return;
    }

    // Get current package for simple type names
    let current_package = get_package(&class.class_type);
    let pkg = current_package.as_deref();

    // Emit method annotations from DEX
    for annotation in &method.annotations {
        if should_emit_annotation(annotation) {
            code.start_line();
            generate_annotation(annotation, code);
            code.newline();
        }
    }

    // Fallback: Add @Override annotation heuristically if no annotations present
    if let Some(declaring_class) = should_add_override_heuristic(method, class) {
        code.start_line()
            .add("@Override // ")
            .add(&declaring_class)
            .newline();
    }

    // Add rename comment if method was renamed during deobfuscation (skip constructors)
    // JADX Clone: Include rename reasons from Kotlin metadata, etc.
    if let Some(ref alias) = method.alias {
        if alias != &method.name && !method.is_constructor() {
            add_renamed_comment_with_reasons(code, &method.name, &method.rename_reasons, comments_level);
        }
    }

    code.start_line();

    // Kotlin function modifiers (emitted as comments for Java output)
    // These appear before Java modifiers to mirror Kotlin syntax order
    let mut kotlin_mods = Vec::new();
    if method.is_suspend {
        kotlin_mods.push("suspend");
    }
    if method.is_inline_function {
        kotlin_mods.push("inline");
    }
    if method.is_infix {
        kotlin_mods.push("infix");
    }
    if method.is_operator {
        kotlin_mods.push("operator");
    }
    if method.is_tailrec {
        kotlin_mods.push("tailrec");
    }
    if !kotlin_mods.is_empty() {
        code.add("/* ").add(&kotlin_mods.join(" ")).add(" */ ");
    }

    // Method modifiers (skip for static initializers since we handle them specially)
    if !method.is_class_init() {
        // JADX parity: Don't add 'public' and 'abstract' to methods in interfaces
        // Also don't add 'public' for annotation methods
        let is_interface = access_flags::is_interface(class.access_flags);
        let is_annotation = access_flags::is_annotation(class.access_flags);

        let effective_flags = if is_interface {
            // Remove PUBLIC and ABSTRACT for interface methods
            method.access_flags & !(access_flags::flags::ACC_PUBLIC | access_flags::flags::ACC_ABSTRACT)
        } else if is_annotation {
            // Remove PUBLIC for annotation methods
            method.access_flags & !access_flags::flags::ACC_PUBLIC
        } else {
            method.access_flags
        };

        let mods = access_flags::access_flags_to_string(effective_flags, AccessContext::Method);
        if !mods.is_empty() {
            code.add(&mods);
        }

        // Clone of JADX MethodGen.java - synthetic method comment (CG-019)
        // Reference: jadx-core/src/main/java/jadx/core/codegen/MethodGen.java
        // JADX adds /* synthetic */ inline for methods with ACC_SYNTHETIC flag
        if access_flags::is_synthetic(method.access_flags) {
            code.add("/* synthetic */ ");
        }

        // JADX parity: Add 'default' for interface methods with code (non-static, non-abstract)
        if is_interface && !method.is_abstract() && !method.is_static() && method.bytecode_ref.is_some() {
            code.add("default ");
        }
    }

    // Type parameters (e.g., <T, E extends Number>)
    let has_type_params = !method.is_constructor() && !method.is_class_init() && !method.type_parameters.is_empty();
    if has_type_params {
        generate_type_parameters(&method.type_parameters, imports, pkg, code);
        code.add(" "); // Space before return type
    }

    // Return type and name
    if method.is_constructor() {
        // Constructor - use innermost class name (handles inner classes)
        let class_name = get_innermost_name(&class.class_type);
        code.add(class_name);
    } else if method.is_class_init() {
        // Static initializer
        code.add("static");
    } else {
        code.add(&type_to_string_with_imports_and_package(&method.return_type, imports, pkg));
        code.add(" ");
        // Use alias if available from deobfuscation, sanitize for valid Java identifier
        code.add(&sanitize_method_name(method.display_name()));
    }

    // Parameters (except for static initializer)
    if !method.is_class_init() {
        add_parameters(method, class, imports, pkg, code);
    }

    // Throws clause (except for static initializer)
    if !method.is_class_init() {
        // Get throws from both annotations and instruction scanning
        let mut throws = get_throws_from_annotations(&method.annotations);
        let insn_throws = collect_throws_from_instructions(method, dex_info.as_ref().map(|d| d.as_ref()));

        // Merge instruction-based throws (avoid duplicates)
        for exc in insn_throws {
            if !throws.contains(&exc) {
                throws.push(exc);
            }
        }

        add_throws_clause(&throws, imports, pkg, code);
    }

    // Method body
    if method.is_abstract() || method.is_native() {
        // Abstract/native methods have no body
        // For annotation methods, emit default value if present
        // Like JADX's MethodGen.java lines 172-179
        if class.is_annotation() {
            if let Some(ref default_value) = method.annotation_default {
                code.add(" default ");
                code.add(&annotation_value_to_string(default_value));
            }
        }
        code.add(";").newline();
    } else if method.is_class_init() {
        code.add(" {").newline();
        code.inc_indent();
        add_method_body_with_inner_classes(method, dex_info.clone(), imports, inner_classes, lambda_methods, hierarchy, Some(class), deobf_min_length, deobf_max_length, fallback, res_names, replace_consts, add_debug_lines, code);
        code.dec_indent();
        code.start_line().add("}").newline();
    } else {
        // Check if method is too complex to decompile cleanly
        // Match JADX behavior: emit stub for extremely complex methods
        if let Some(reason) = should_skip_complex_method(method) {
            code.add(" {").newline();
            code.inc_indent();
            code.start_line().add("/*").newline();
            code.start_line().add("    Method decompilation skipped: too complex").newline();
            code.start_line().add("    Reason: ").add(&reason).newline();
            code.start_line().add("    To view this dump add '--show-bad-code' option").newline();
            code.start_line().add("*/").newline();
            code.start_line().add("throw new UnsupportedOperationException(\"Method not decompiled: ")
                .add(&get_simple_name(&class.class_type))
                .add(".")
                .add(&sanitize_method_name(method.display_name()))
                .add("()\");")
                .newline();
            code.dec_indent();
            code.start_line().add("}").newline();
        } else {
            // Regular method with body
            code.add(" {").newline();
            code.inc_indent();
            add_method_body_with_inner_classes(method, dex_info.clone(), imports, inner_classes, lambda_methods, hierarchy, Some(class), deobf_min_length, deobf_max_length, fallback, res_names, replace_consts, add_debug_lines, code);
            code.dec_indent();
            code.start_line().add("}").newline();
        }
    }
}

/// Add method body with inner classes for anonymous class inlining
fn add_method_body_with_inner_classes<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    imports: Option<&BTreeSet<String>>,
    inner_classes: Option<&std::collections::HashMap<String, std::sync::Arc<ClassData>>>,
    // P1-LAMBDA-FIX: Lambda methods for inlining synthetic lambda$ methods
    lambda_methods: Option<&std::collections::HashMap<String, std::sync::Arc<MethodData>>>,
    hierarchy: Option<&dexterity_ir::ClassHierarchy>,
    current_class: Option<&ClassData>,
    deobf_min_length: usize,
    deobf_max_length: usize,
    fallback: bool,
    res_names: &std::collections::HashMap<u32, String>,
    replace_consts: bool,
    add_debug_lines: bool,
    code: &mut W,
) {
    let current_class_type = current_class.map(|c| c.class_type.as_str());
    // P1-LAMBDA-FIX: Use the _and_lambdas variant to enable synthetic lambda method inlining
    generate_body_with_inner_classes_and_lambdas(method, dex_info, imports, inner_classes, lambda_methods, hierarchy, current_class_type, deobf_min_length, deobf_max_length, fallback, res_names, replace_consts, add_debug_lines, code);
}

/// Extract throws types from dalvik/annotation/Throws annotation
fn get_throws_from_annotations(annotations: &[Annotation]) -> Vec<String> {
    for annotation in annotations {
        if annotation.annotation_type == "dalvik/annotation/Throws" {
            // The throws annotation has a single "value" element containing an array of Type values
            for elem in &annotation.elements {
                if elem.name == "value" {
                    if let AnnotationValue::Array(values) = &elem.value {
                        return values.iter().filter_map(|v| {
                            if let AnnotationValue::Type(type_name) = v {
                                Some(type_name.clone())
                            } else {
                                None
                            }
                        }).collect();
                    }
                }
            }
        }
    }
    Vec::new()
}

/// Static mapping of library methods that throw checked exceptions
/// Format: "class_internal_name->method_name" => ["exception_internal_name", ...]
fn get_library_method_throws(class: &str, method: &str) -> Option<&'static [&'static str]> {
    // Common exception-throwing library methods
    // This is a simplified version - JADX uses a full classpath database
    match (class, method) {
        // org.json
        ("org/json/JSONObject", "put") => Some(&["org/json/JSONException"]),
        ("org/json/JSONObject", "get") => Some(&["org/json/JSONException"]),
        ("org/json/JSONObject", "getString") => Some(&["org/json/JSONException"]),
        ("org/json/JSONObject", "getInt") => Some(&["org/json/JSONException"]),
        ("org/json/JSONObject", "getLong") => Some(&["org/json/JSONException"]),
        ("org/json/JSONObject", "getDouble") => Some(&["org/json/JSONException"]),
        ("org/json/JSONObject", "getBoolean") => Some(&["org/json/JSONException"]),
        ("org/json/JSONObject", "getJSONObject") => Some(&["org/json/JSONException"]),
        ("org/json/JSONObject", "getJSONArray") => Some(&["org/json/JSONException"]),
        ("org/json/JSONArray", "put") => Some(&["org/json/JSONException"]),
        ("org/json/JSONArray", "get") => Some(&["org/json/JSONException"]),
        ("org/json/JSONArray", "getString") => Some(&["org/json/JSONException"]),
        ("org/json/JSONArray", "getInt") => Some(&["org/json/JSONException"]),
        ("org/json/JSONArray", "getJSONObject") => Some(&["org/json/JSONException"]),

        // java.io
        ("java/io/InputStream", "read") => Some(&["java/io/IOException"]),
        ("java/io/InputStream", "close") => Some(&["java/io/IOException"]),
        ("java/io/OutputStream", "write") => Some(&["java/io/IOException"]),
        ("java/io/OutputStream", "flush") => Some(&["java/io/IOException"]),
        ("java/io/OutputStream", "close") => Some(&["java/io/IOException"]),
        ("java/io/Reader", "read") => Some(&["java/io/IOException"]),
        ("java/io/Reader", "close") => Some(&["java/io/IOException"]),
        ("java/io/Writer", "write") => Some(&["java/io/IOException"]),
        ("java/io/Writer", "flush") => Some(&["java/io/IOException"]),
        ("java/io/Writer", "close") => Some(&["java/io/IOException"]),
        ("java/io/File", "createNewFile") => Some(&["java/io/IOException"]),
        ("java/io/File", "createTempFile") => Some(&["java/io/IOException"]),
        ("java/io/FileInputStream", "<init>") => Some(&["java/io/FileNotFoundException"]),
        ("java/io/FileOutputStream", "<init>") => Some(&["java/io/FileNotFoundException"]),
        ("java/io/FileReader", "<init>") => Some(&["java/io/FileNotFoundException"]),
        ("java/io/FileWriter", "<init>") => Some(&["java/io/IOException"]),
        ("java/io/RandomAccessFile", "<init>") => Some(&["java/io/FileNotFoundException"]),
        ("java/io/RandomAccessFile", "read") => Some(&["java/io/IOException"]),
        ("java/io/RandomAccessFile", "write") => Some(&["java/io/IOException"]),
        ("java/io/RandomAccessFile", "seek") => Some(&["java/io/IOException"]),
        ("java/io/RandomAccessFile", "close") => Some(&["java/io/IOException"]),
        ("java/io/ObjectInputStream", "<init>") => Some(&["java/io/IOException"]),
        ("java/io/ObjectInputStream", "readObject") => Some(&["java/io/IOException", "java/lang/ClassNotFoundException"]),
        ("java/io/ObjectOutputStream", "<init>") => Some(&["java/io/IOException"]),
        ("java/io/ObjectOutputStream", "writeObject") => Some(&["java/io/IOException"]),

        // java.net
        ("java/net/URL", "<init>") => Some(&["java/net/MalformedURLException"]),
        ("java/net/URL", "openConnection") => Some(&["java/io/IOException"]),
        ("java/net/URL", "openStream") => Some(&["java/io/IOException"]),
        ("java/net/URLConnection", "connect") => Some(&["java/io/IOException"]),
        ("java/net/URLConnection", "getInputStream") => Some(&["java/io/IOException"]),
        ("java/net/URLConnection", "getOutputStream") => Some(&["java/io/IOException"]),
        ("java/net/HttpURLConnection", "getResponseCode") => Some(&["java/io/IOException"]),
        ("java/net/Socket", "<init>") => Some(&["java/io/IOException"]),
        ("java/net/Socket", "connect") => Some(&["java/io/IOException"]),
        ("java/net/Socket", "getInputStream") => Some(&["java/io/IOException"]),
        ("java/net/Socket", "getOutputStream") => Some(&["java/io/IOException"]),
        ("java/net/Socket", "close") => Some(&["java/io/IOException"]),
        ("java/net/ServerSocket", "<init>") => Some(&["java/io/IOException"]),
        ("java/net/ServerSocket", "accept") => Some(&["java/io/IOException"]),
        ("java/net/ServerSocket", "close") => Some(&["java/io/IOException"]),

        // java.security
        ("java/security/MessageDigest", "getInstance") => Some(&["java/security/NoSuchAlgorithmException"]),
        ("java/security/Signature", "getInstance") => Some(&["java/security/NoSuchAlgorithmException"]),
        ("java/security/Signature", "initSign") => Some(&["java/security/InvalidKeyException"]),
        ("java/security/Signature", "initVerify") => Some(&["java/security/InvalidKeyException"]),
        ("java/security/Signature", "sign") => Some(&["java/security/SignatureException"]),
        ("java/security/Signature", "verify") => Some(&["java/security/SignatureException"]),
        ("java/security/KeyFactory", "getInstance") => Some(&["java/security/NoSuchAlgorithmException"]),
        ("java/security/KeyFactory", "generatePublic") => Some(&["java/security/spec/InvalidKeySpecException"]),
        ("java/security/KeyFactory", "generatePrivate") => Some(&["java/security/spec/InvalidKeySpecException"]),
        ("java/security/KeyPairGenerator", "getInstance") => Some(&["java/security/NoSuchAlgorithmException"]),
        ("java/security/SecureRandom", "getInstance") => Some(&["java/security/NoSuchAlgorithmException"]),

        // javax.crypto
        ("javax/crypto/Cipher", "getInstance") => Some(&["java/security/NoSuchAlgorithmException", "javax/crypto/NoSuchPaddingException"]),
        ("javax/crypto/Cipher", "init") => Some(&["java/security/InvalidKeyException"]),
        ("javax/crypto/Cipher", "doFinal") => Some(&["javax/crypto/IllegalBlockSizeException", "javax/crypto/BadPaddingException"]),
        ("javax/crypto/Mac", "getInstance") => Some(&["java/security/NoSuchAlgorithmException"]),
        ("javax/crypto/Mac", "init") => Some(&["java/security/InvalidKeyException"]),
        ("javax/crypto/SecretKeyFactory", "getInstance") => Some(&["java/security/NoSuchAlgorithmException"]),

        // java.lang
        ("java/lang/Class", "forName") => Some(&["java/lang/ClassNotFoundException"]),
        ("java/lang/Class", "newInstance") => Some(&["java/lang/InstantiationException", "java/lang/IllegalAccessException"]),
        ("java/lang/Class", "getMethod") => Some(&["java/lang/NoSuchMethodException"]),
        ("java/lang/Class", "getDeclaredMethod") => Some(&["java/lang/NoSuchMethodException"]),
        ("java/lang/Class", "getField") => Some(&["java/lang/NoSuchFieldException"]),
        ("java/lang/Class", "getDeclaredField") => Some(&["java/lang/NoSuchFieldException"]),
        ("java/lang/Class", "getConstructor") => Some(&["java/lang/NoSuchMethodException"]),
        ("java/lang/Class", "getDeclaredConstructor") => Some(&["java/lang/NoSuchMethodException"]),
        ("java/lang/reflect/Method", "invoke") => Some(&["java/lang/IllegalAccessException", "java/lang/reflect/InvocationTargetException"]),
        ("java/lang/reflect/Constructor", "newInstance") => Some(&["java/lang/InstantiationException", "java/lang/IllegalAccessException", "java/lang/reflect/InvocationTargetException"]),
        ("java/lang/reflect/Field", "get") => Some(&["java/lang/IllegalAccessException"]),
        ("java/lang/reflect/Field", "set") => Some(&["java/lang/IllegalAccessException"]),
        ("java/lang/Thread", "sleep") => Some(&["java/lang/InterruptedException"]),
        ("java/lang/Thread", "join") => Some(&["java/lang/InterruptedException"]),
        ("java/lang/Object", "wait") => Some(&["java/lang/InterruptedException"]),
        ("java/lang/Object", "clone") => Some(&["java/lang/CloneNotSupportedException"]),

        // java.util.concurrent
        ("java/util/concurrent/Future", "get") => Some(&["java/lang/InterruptedException", "java/util/concurrent/ExecutionException"]),
        ("java/util/concurrent/BlockingQueue", "put") => Some(&["java/lang/InterruptedException"]),
        ("java/util/concurrent/BlockingQueue", "take") => Some(&["java/lang/InterruptedException"]),
        ("java/util/concurrent/Semaphore", "acquire") => Some(&["java/lang/InterruptedException"]),
        ("java/util/concurrent/CountDownLatch", "await") => Some(&["java/lang/InterruptedException"]),
        ("java/util/concurrent/CyclicBarrier", "await") => Some(&["java/lang/InterruptedException", "java/util/concurrent/BrokenBarrierException"]),

        // java.sql
        ("java/sql/Connection", "createStatement") => Some(&["java/sql/SQLException"]),
        ("java/sql/Connection", "prepareStatement") => Some(&["java/sql/SQLException"]),
        ("java/sql/Connection", "prepareCall") => Some(&["java/sql/SQLException"]),
        ("java/sql/Connection", "commit") => Some(&["java/sql/SQLException"]),
        ("java/sql/Connection", "rollback") => Some(&["java/sql/SQLException"]),
        ("java/sql/Connection", "close") => Some(&["java/sql/SQLException"]),
        ("java/sql/Statement", "executeQuery") => Some(&["java/sql/SQLException"]),
        ("java/sql/Statement", "executeUpdate") => Some(&["java/sql/SQLException"]),
        ("java/sql/Statement", "execute") => Some(&["java/sql/SQLException"]),
        ("java/sql/Statement", "close") => Some(&["java/sql/SQLException"]),
        ("java/sql/PreparedStatement", "executeQuery") => Some(&["java/sql/SQLException"]),
        ("java/sql/PreparedStatement", "executeUpdate") => Some(&["java/sql/SQLException"]),
        ("java/sql/PreparedStatement", "setString") => Some(&["java/sql/SQLException"]),
        ("java/sql/PreparedStatement", "setInt") => Some(&["java/sql/SQLException"]),
        ("java/sql/ResultSet", "next") => Some(&["java/sql/SQLException"]),
        ("java/sql/ResultSet", "getString") => Some(&["java/sql/SQLException"]),
        ("java/sql/ResultSet", "getInt") => Some(&["java/sql/SQLException"]),
        ("java/sql/ResultSet", "close") => Some(&["java/sql/SQLException"]),
        ("java/sql/DriverManager", "getConnection") => Some(&["java/sql/SQLException"]),

        _ => None,
    }
}

/// Check if an exception type is a checked exception (requires throws declaration)
/// RuntimeException and Error subclasses are unchecked
fn is_checked_exception(exception_type: &str) -> bool {
    // Common unchecked exception types
    let unchecked = [
        "java/lang/RuntimeException",
        "java/lang/NullPointerException",
        "java/lang/IllegalArgumentException",
        "java/lang/IllegalStateException",
        "java/lang/IndexOutOfBoundsException",
        "java/lang/ArrayIndexOutOfBoundsException",
        "java/lang/StringIndexOutOfBoundsException",
        "java/lang/ClassCastException",
        "java/lang/ArithmeticException",
        "java/lang/NumberFormatException",
        "java/lang/UnsupportedOperationException",
        "java/lang/SecurityException",
        "java/lang/Error",
        "java/lang/AssertionError",
        "java/lang/OutOfMemoryError",
        "java/lang/StackOverflowError",
        "java/lang/NoClassDefFoundError",
        "java/lang/LinkageError",
        "java/lang/VirtualMachineError",
    ];
    !unchecked.contains(&exception_type)
}

/// Collect throws from method instructions by scanning for INVOKE calls
/// to known exception-throwing library methods
fn collect_throws_from_instructions(
    method: &MethodData,
    dex_info: Option<&dyn DexInfoProvider>,
) -> Vec<String> {
    use dexterity_ir::InsnType;
    use std::collections::HashSet;

    let mut throws: HashSet<String> = HashSet::new();

    // Get method instructions
    let Some(insns) = method.instructions() else {
        return Vec::new();
    };

    // Need dex_info to look up method details
    let Some(dex_info) = dex_info else {
        return Vec::new();
    };

    // Collect caught exception types from try-catch blocks
    // For catch-all handlers, we add a marker to skip all exceptions in that try block
    let mut caught_types: HashSet<String> = HashSet::new();
    let mut has_catch_all = false;
    for try_block in &method.try_blocks {
        for handler in &try_block.handlers {
            if handler.exception_type.is_none() {
                has_catch_all = true;
            } else if let Some(ref exc_type) = handler.exception_type {
                caught_types.insert(exc_type.clone());
            }
        }
    }

    // If there's a catch-all in the method, no throws needed (all caught)
    if has_catch_all {
        return Vec::new();
    }

    // Scan instructions for INVOKE calls
    for insn in insns {
        if let InsnType::Invoke { method_idx, .. } = &insn.insn_type {
            // Get method info from dex_info
            if let Some(method_info) = dex_info.get_method(*method_idx) {
                // class_type is in internal format (e.g., "org/json/JSONObject")
                let class = &*method_info.class_type;
                let name = &*method_info.method_name;

                // Check if this method throws checked exceptions from our static mapping
                if let Some(exceptions) = get_library_method_throws(class, name) {
                    for exc in exceptions {
                        // Skip if this exception is caught
                        if !caught_types.contains(*exc) && is_checked_exception(exc) {
                            throws.insert(exc.to_string());
                        }
                    }
                }

                // NOTE: Additional throws from DEX method annotations not yet extracted
                // Current implementation uses KNOWN_THROWING_METHODS for common cases
            }
        }
    }

    throws.into_iter().collect()
}

/// Add throws clause to method signature
fn add_throws_clause<W: CodeWriter>(throws: &[String], imports: Option<&BTreeSet<String>>, current_package: Option<&str>, code: &mut W) {
    if throws.is_empty() {
        return;
    }
    code.add(" throws ");
    for (i, exception) in throws.iter().enumerate() {
        if i > 0 {
            code.add(", ");
        }
        // Use simple name if imported or same package
        code.add(&type_to_string_with_imports_and_package(&ArgType::Object(exception.clone()), imports, current_package));
    }
}

/// Add method parameters
///
/// JADX parity: Filters synthetic constructor arguments for inner class constructors.
/// Reference: ClassModifier.java:181-208 - isRemovedClassInArgs()
fn add_parameters<W: CodeWriter>(
    method: &MethodData,
    class: &ClassData,
    imports: Option<&BTreeSet<String>>,
    current_package: Option<&str>,
    code: &mut W,
) {
    code.add("(");

    let is_varargs = method.access_flags & ACC_VARARGS != 0;
    let params = &method.arg_types;

    // JADX parity: Filter synthetic constructor arguments
    // Build list of (original_index, param_type) for non-synthetic params
    let filtered_params: Vec<(usize, &ArgType)> = params
        .iter()
        .enumerate()
        .filter(|(i, param_type)| !is_synthetic_constructor_arg(param_type, *i, method, class))
        .collect();

    let param_count = filtered_params.len();

    // Generate parameter names only for non-filtered params
    // First, collect the filtered arg_types for naming
    let filtered_types: Vec<ArgType> = filtered_params.iter().map(|(_, t)| (*t).clone()).collect();
    let filtered_names: Vec<Option<String>> = filtered_params
        .iter()
        .map(|(orig_idx, _)| method.arg_names.get(*orig_idx).cloned().flatten())
        .collect();
    let param_names = generate_param_names(&filtered_types, &filtered_names);

    for (output_idx, (orig_idx, param_type)) in filtered_params.iter().enumerate() {
        if output_idx > 0 {
            code.add(", ");
        }

        // Parameter annotations (emit before the type, like JADX)
        if *orig_idx < method.parameter_annotations.len() {
            for annotation in &method.parameter_annotations[*orig_idx] {
                if should_emit_annotation(annotation) {
                    generate_annotation(annotation, code);
                    code.add(" ");
                }
            }
        }

        let is_last = output_idx == param_count - 1;
        let is_last_vararg = is_last && is_varargs;

        // Type (convert last array to varargs if needed, use simple names when imports available or same package)
        if is_last_vararg {
            if let ArgType::Array(elem) = param_type {
                code.add(&type_to_string_with_imports_and_package(elem, imports, current_package));
                code.add("...");
            } else {
                // Fallback - shouldn't happen but handle gracefully
                code.add(&type_to_string_with_imports_and_package(param_type, imports, current_package));
            }
        } else {
            code.add(&type_to_string_with_imports_and_package(param_type, imports, current_package));
        }

        // Parameter name: use collision-detected name
        code.add(" ");
        code.add(&param_names[output_idx]);
    }

    code.add(")");
}

/// Java reserved keywords that cannot be used as identifiers
const JAVA_RESERVED_WORDS: &[&str] = &[
    "abstract", "assert", "boolean", "break", "byte", "case", "catch",
    "char", "class", "const", "continue", "default", "do", "double",
    "else", "enum", "extends", "false", "final", "finally", "float",
    "for", "goto", "if", "implements", "import", "instanceof", "int",
    "interface", "long", "native", "new", "null", "package", "private",
    "protected", "public", "return", "short", "static", "strictfp",
    "super", "switch", "synchronized", "this", "throw", "throws",
    "transient", "true", "try", "void", "volatile", "while", "_",
];

/// Escape Java reserved words to valid identifier names (P0-KEYWORD01 fix)
/// Uses JADX-compatible escape patterns:
/// - `class` → `clazz` (standard Java convention)
/// - Other reserved words get underscore suffix (e.g., `new` → `new_`)
fn escape_reserved_word(name: &str) -> String {
    if !JAVA_RESERVED_WORDS.contains(&name) {
        return name.to_string();
    }

    // JADX convention: class -> clazz
    if name == "class" {
        return "clazz".to_string();
    }

    // For other reserved words, add underscore suffix
    format!("{}_", name)
}

/// Generate base parameter name from type (with "Var" suffix for short class names)
/// This matches JADX's ApplyVariableNames.fromName() logic
fn generate_base_param_name(ty: &ArgType) -> String {
    match ty {
        ArgType::Object(name) => {
            // JADX PARITY: Use OBJ_ALIAS mappings for common types first
            if name.contains("StringBuilder") || name.contains("StringBuffer") {
                return "sb".to_string();
            }
            if name.contains("String") {
                return "str".to_string();
            }
            if name.contains("Throwable") || name.contains("Error") {
                return "th".to_string();
            }
            if name.contains("Exception") {
                return "exc".to_string();
            }
            if name.contains("Class") && !name.contains("ClassLoader") {
                return "cls".to_string();
            }
            if name.contains("Iterator") {
                return "it".to_string();
            }
            if name.contains("Map") {
                return "map".to_string();
            }
            if name.contains("Set") {
                return "set".to_string();
            }
            if name.contains("List") || name.contains("Collection") || name.contains("Iterable") {
                return "list".to_string();
            }

            // JADX PARITY: Use innermost name (strip $ for inner classes)
            let simple = get_innermost_name(name);

            // Check if all uppercase (like "URL" → "url")
            let is_all_uppercase = simple.chars().all(|c| !c.is_ascii_lowercase());

            let base = if is_all_uppercase {
                simple.to_lowercase()
            } else {
                let mut chars = simple.chars();
                match chars.next() {
                    Some(c) => c.to_lowercase().chain(chars).collect(),
                    None => return "obj".to_string(),
                }
            };

            // JADX PARITY: Add "Var" suffix for short names (< 3 chars)
            if base.len() < 3 {
                format!("{}Var", base)
            } else {
                base
            }
        }
        ArgType::Array(elem) => {
            let elem_name = generate_base_param_name(elem);
            format!("{}Arr", elem_name)
        }
        ArgType::Int => "i".to_string(),
        ArgType::Long => "j".to_string(),
        ArgType::Float => "f".to_string(),
        ArgType::Double => "d".to_string(),
        ArgType::Boolean => "z".to_string(),
        ArgType::Byte => "b".to_string(),
        ArgType::Char => "c".to_string(),
        ArgType::Short => "s".to_string(),
        ArgType::Generic { base, .. } => {
            // P0-KEYWORD01: Apply same type-based mappings as Object case
            // e.g., Class<T> should become "cls" not "class"
            if base.contains("Class") && !base.contains("ClassLoader") {
                return "cls".to_string();
            }
            if base.contains("StringBuilder") || base.contains("StringBuffer") {
                return "sb".to_string();
            }
            if base.contains("String") {
                return "str".to_string();
            }
            if base.contains("Exception") {
                return "exc".to_string();
            }
            if base.contains("Throwable") || base.contains("Error") {
                return "th".to_string();
            }

            let simple = get_innermost_name(base);
            let mut chars = simple.chars();
            match chars.next() {
                Some(c) => {
                    let base_name: String = c.to_lowercase().chain(chars).collect();
                    // P0-KEYWORD01: Escape reserved words
                    let escaped = escape_reserved_word(&base_name);
                    if escaped.len() < 3 && !escaped.ends_with('_') {
                        format!("{}Var", escaped)
                    } else {
                        escaped
                    }
                }
                None => "obj".to_string(),
            }
        }
        ArgType::TypeVariable { name, .. } => name.to_lowercase(),
        ArgType::Wildcard { inner: Some(inner), .. } => generate_base_param_name(inner),
        ArgType::Wildcard { inner: None, .. } => "obj".to_string(),
        ArgType::OuterGeneric { inner, .. } => generate_base_param_name(inner),
        ArgType::Void => "v".to_string(),
        ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownWide
        | ArgType::UnknownObject | ArgType::UnknownArray | ArgType::UnknownIntegral
        | ArgType::UnknownNarrowNumbers | ArgType::UnknownNumbersNoBool
        | ArgType::UnknownNumbersNoFloat | ArgType::UnknownIntFloat | ArgType::UnknownIntBoolean
        | ArgType::UnknownByteBoolean | ArgType::UnknownObjectNoArray
        | ArgType::UnknownInt => "obj".to_string(),
    }
}

/// Generate parameter names with collision detection (JADX parity)
/// This matches JADX's NameGen.getUniqueVarName() logic
fn generate_param_names(arg_types: &[ArgType], arg_names: &[Option<String>]) -> Vec<String> {
    use std::collections::HashSet;

    // First, generate base names for all parameters
    // P0-KEYWORD01 fix: Escape reserved words from debug info (e.g., "class" -> "clazz")
    let base_names: Vec<String> = arg_types.iter().enumerate().map(|(i, ty)| {
        arg_names.get(i)
            .and_then(|n| n.clone())
            .map(|n| escape_reserved_word(&n))
            .unwrap_or_else(|| generate_base_param_name(ty))
    }).collect();

    // Then apply collision detection (JADX uses suffix starting at 2)
    let mut used: HashSet<String> = HashSet::new();
    let mut result = Vec::with_capacity(base_names.len());

    for base in base_names {
        if !used.contains(&base) {
            used.insert(base.clone());
            result.push(base);
        } else {
            // Find next available suffix starting at 2
            let mut suffix = 2;
            loop {
                let name = format!("{}{}", base, suffix);
                if !used.contains(&name) {
                    used.insert(name.clone());
                    result.push(name);
                    break;
                }
                suffix += 1;
            }
        }
    }

    result
}

/// Generate a parameter name based on type and index (legacy - kept for compatibility)
fn generate_param_name(index: usize, ty: &ArgType) -> String {
    // Try to generate a meaningful name from the type
    // NOTE: Must match body_gen.rs generate_param_name for consistency between signature and body
    let base = match ty {
        ArgType::Object(name) => {
            // JADX PARITY: Use OBJ_ALIAS mappings for common types first
            if name.contains("StringBuilder") || name.contains("StringBuffer") {
                return if index == 0 { "sb".to_string() } else { format!("sb{}", index + 1) };
            }
            if name.contains("String") {
                return if index == 0 { "str".to_string() } else { format!("str{}", index + 1) };
            }
            if name.contains("Throwable") || name.contains("Error") {
                return if index == 0 { "th".to_string() } else { format!("th{}", index + 1) };
            }
            if name.contains("Exception") {
                return if index == 0 { "exc".to_string() } else { format!("exc{}", index + 1) };
            }
            if name.contains("Class") && !name.contains("ClassLoader") {
                return if index == 0 { "cls".to_string() } else { format!("cls{}", index + 1) };
            }
            if name.contains("Iterator") {
                return if index == 0 { "it".to_string() } else { format!("it{}", index + 1) };
            }
            if name.contains("Map") {
                return if index == 0 { "map".to_string() } else { format!("map{}", index + 1) };
            }
            if name.contains("List") {
                return if index == 0 { "list".to_string() } else { format!("list{}", index + 1) };
            }
            if name.contains("Set") {
                return if index == 0 { "set".to_string() } else { format!("set{}", index + 1) };
            }
            if name.contains("Integer") || name.contains("Long") || name.contains("Double")
               || name.contains("Float") || name.contains("Number") {
                return if index == 0 { "num".to_string() } else { format!("num{}", index + 1) };
            }
            if name.contains("Boolean") {
                return if index == 0 { "bool".to_string() } else { format!("bool{}", index + 1) };
            }
            // Use innermost name (strip $ for inner classes) to match JADX
            let simple = get_innermost_name(name);
            // Lowercase first letter
            let mut chars = simple.chars();
            match chars.next() {
                Some(c) => c.to_lowercase().chain(chars).collect(),
                None => "obj".to_string(),
            }
        }
        ArgType::Array(elem) => {
            let elem_name = generate_param_name(index, elem);
            format!("{}Arr", elem_name)
        }
        ArgType::Int => "i".to_string(),
        ArgType::Long => "j".to_string(),  // JADX uses 'j' for long
        ArgType::Float => "f".to_string(),
        ArgType::Double => "d".to_string(),
        ArgType::Boolean => "z".to_string(),
        ArgType::Byte => "b".to_string(),
        ArgType::Char => "c".to_string(),
        ArgType::Short => "s".to_string(),
        // Handle generic types by extracting base class name
        ArgType::Generic { base, .. } => {
            // Use innermost name (strip $ for inner classes) to match JADX
            let simple = get_innermost_name(base);
            let mut chars = simple.chars();
            match chars.next() {
                Some(c) => c.to_lowercase().chain(chars).collect(),
                None => "obj".to_string(),
            }
        }
        // Handle type variables by using the variable name lowercase
        ArgType::TypeVariable { name, .. } => name.to_lowercase(),
        // Handle wildcards by using the bound type if available
        ArgType::Wildcard { inner: Some(inner), .. } => generate_param_name(index, inner),
        ArgType::Wildcard { inner: None, .. } => "obj".to_string(),
        ArgType::OuterGeneric { inner, .. } => generate_param_name(index, inner),
        ArgType::Void => "v".to_string(),
        ArgType::Unknown | ArgType::UnknownNarrow | ArgType::UnknownWide
        | ArgType::UnknownObject | ArgType::UnknownArray | ArgType::UnknownIntegral
        | ArgType::UnknownNarrowNumbers | ArgType::UnknownNumbersNoBool
        | ArgType::UnknownNumbersNoFloat | ArgType::UnknownIntFloat | ArgType::UnknownIntBoolean
        | ArgType::UnknownByteBoolean | ArgType::UnknownObjectNoArray
        | ArgType::UnknownInt => "obj".to_string(),
    };

    // Add numeric suffix for params after the first
    // JADX uses index+1 for suffixes: first param no suffix, second param suffix "2", etc.
    // This ensures consistency between method signature and body generation
    if index == 0 {
        base
    } else {
        format!("{}{}", base, index + 1)
    }
}

/// Add method body using region-based code generation
#[allow(dead_code)]
fn add_method_body<W: CodeWriter>(method: &MethodData, code: &mut W) {
    add_method_body_with_dex_and_imports(method, None, None, code)
}

/// Add method body with DEX info for name resolution
#[allow(dead_code)]
fn add_method_body_with_dex<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    code: &mut W,
) {
    // Use the body generator with DEX info for proper name resolution
    generate_body_with_dex(method, dex_info, code);
}

/// Add method body with DEX info and imports for name resolution
fn add_method_body_with_dex_and_imports<W: CodeWriter>(
    method: &MethodData,
    dex_info: Option<std::sync::Arc<dyn DexInfoProvider>>,
    imports: Option<&BTreeSet<String>>,
    code: &mut W,
) {
    // Use the body generator with DEX info and imports for proper name resolution
    generate_body_with_dex_and_imports(method, dex_info, imports, code);
}


#[cfg(test)]
mod tests {
    use super::*;
    use crate::writer::SimpleCodeWriter;

    fn make_class() -> ClassData {
        ClassData::new("Lcom/example/Test;".to_string(), 0x0001)
    }

    fn make_method(name: &str, return_type: ArgType, flags: u32) -> MethodData {
        MethodData::new(name.to_string(), flags, return_type)
    }

    #[test]
    fn test_simple_method() {
        let class = make_class();
        let method = make_method("foo", ArgType::Void, ACC_PUBLIC);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("public void foo()"));
    }

    #[test]
    fn test_method_with_params() {
        let class = make_class();
        let mut method = make_method("bar", ArgType::Int, ACC_PUBLIC);
        method.arg_types.push(ArgType::Int);
        method.arg_types.push(ArgType::Object("java/lang/String".to_string()));
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        // Check that method signature has correct modifiers, return type, name and parameter types
        // JADX PARITY: String → "str" (from OBJ_ALIAS mappings)
        assert!(code.contains("public int bar(int i, String str)"), "Code was: {}", code);
    }

    #[test]
    fn test_constructor() {
        let class = make_class();
        let method = make_method("<init>", ArgType::Void, ACC_PUBLIC);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("public Test()"));
    }

    #[test]
    fn test_abstract_method() {
        let class = make_class();
        let method = make_method("abstractMethod", ArgType::Void, ACC_PUBLIC | ACC_ABSTRACT);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("public abstract void abstractMethod();"));
        // Should NOT have a body
        assert!(!code.contains("{"));
    }

    #[test]
    fn test_native_method() {
        let class = make_class();
        let method = make_method("nativeMethod", ArgType::Int, ACC_PUBLIC | ACC_NATIVE);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("public native int nativeMethod();"));
    }

    #[test]
    fn test_varargs_method() {
        let class = make_class();
        let mut method = make_method("varargs", ArgType::Void, ACC_PUBLIC | ACC_VARARGS);
        method.arg_types.push(ArgType::Array(Box::new(ArgType::Object("java/lang/String".to_string()))));
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        // JADX PARITY: String[] → "strArr" (from OBJ_ALIAS mappings + Arr suffix)
        assert!(code.contains("public void varargs(String... strArr)"), "Code was: {}", code);
    }

    #[test]
    fn test_static_initializer() {
        use dexterity_ir::instructions::{InsnNode, InsnType, InsnArg, RegisterArg};

        let class = make_class();
        let mut method = make_method("<clinit>", ArgType::Void, ACC_STATIC);
        // Add a meaningful instruction so clinit isn't considered "empty"
        // GAP-04 FIX: Nop-only clinit is now considered empty, so use a real instruction
        method.set_instructions(vec![
            InsnNode::new(InsnType::StaticPut {
                field_idx: 0,
                value: InsnArg::Register(RegisterArg { reg_num: 0, ssa_version: 0 }),
            }, 0),
            InsnNode::new(InsnType::Return { value: None }, 1),
        ]);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();

        assert!(code.contains("static {"));
    }

    #[test]
    fn test_empty_clinit_is_skipped() {
        use dexterity_ir::instructions::{InsnNode, InsnType};
        use dexterity_ir::attributes::AFlag;

        let class = make_class();

        // Case 1: No instructions at all
        let method = make_method("<clinit>", ArgType::Void, ACC_STATIC);
        let mut writer = SimpleCodeWriter::new();
        generate_method(&method, &class, false, &mut writer);
        let code = writer.finish();
        assert!(!code.contains("static"), "Empty clinit (no instructions) should not generate output");

        // Case 2: Only return-void
        let mut method2 = make_method("<clinit>", ArgType::Void, ACC_STATIC);
        method2.set_instructions(vec![
            InsnNode::new(InsnType::Return { value: None }, 0),
        ]);
        let mut writer2 = SimpleCodeWriter::new();
        generate_method(&method2, &class, false, &mut writer2);
        let code2 = writer2.finish();
        assert!(!code2.contains("static"), "Empty clinit (only return-void) should not generate output");

        // Case 3: Only Nop instructions (GAP-04 FIX)
        let mut method3 = make_method("<clinit>", ArgType::Void, ACC_STATIC);
        method3.set_instructions(vec![
            InsnNode::new(InsnType::Nop, 0),
            InsnNode::new(InsnType::Nop, 1),
            InsnNode::new(InsnType::Return { value: None }, 2),
        ]);
        let mut writer3 = SimpleCodeWriter::new();
        generate_method(&method3, &class, false, &mut writer3);
        let code3 = writer3.finish();
        assert!(!code3.contains("static"), "Clinit with only Nop+return should not generate output");

        // Case 4: Instructions marked with DontGenerate (GAP-04 FIX)
        let mut method4 = make_method("<clinit>", ArgType::Void, ACC_STATIC);
        let mut dont_gen_insn = InsnNode::new(InsnType::StaticPut {
            field_idx: 0,
            value: dexterity_ir::instructions::InsnArg::Register(
                dexterity_ir::instructions::RegisterArg { reg_num: 0, ssa_version: 0 }
            ),
        }, 0);
        dont_gen_insn.add_flag(AFlag::DontGenerate);
        method4.set_instructions(vec![
            dont_gen_insn,
            InsnNode::new(InsnType::Return { value: None }, 1),
        ]);
        let mut writer4 = SimpleCodeWriter::new();
        generate_method(&method4, &class, false, &mut writer4);
        let code4 = writer4.finish();
        assert!(!code4.contains("static"), "Clinit with only DontGenerate+return should not generate output");

        // Case 5: Orphaned Const instructions after field extraction (GAP-04 FIX)
        // After extract_field_init removes SPUT, CONST instructions are left orphaned
        let mut method5 = make_method("<clinit>", ArgType::Void, ACC_STATIC);
        method5.set_instructions(vec![
            InsnNode::new(InsnType::Const {
                dest: dexterity_ir::instructions::RegisterArg { reg_num: 0, ssa_version: 0 },
                value: dexterity_ir::instructions::LiteralArg::Int(42),
            }, 0),
            InsnNode::new(InsnType::ConstString {
                dest: dexterity_ir::instructions::RegisterArg { reg_num: 1, ssa_version: 0 },
                string_idx: 0,
            }, 1),
            InsnNode::new(InsnType::Return { value: None }, 2),
        ]);
        let mut writer5 = SimpleCodeWriter::new();
        generate_method(&method5, &class, false, &mut writer5);
        let code5 = writer5.finish();
        assert!(!code5.contains("static"), "Clinit with only orphaned Const+return should not generate output");
    }

    #[test]
    fn test_type_parameters_with_variance() {
        use dexterity_ir::info::TypeVariance;

        // Test invariant (default) - no modifier
        let invariant_params = vec![TypeParameter {
            name: "T".to_string(),
            bounds: vec![],
            variance: TypeVariance::Invariant,
            reified: false,
        }];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&invariant_params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<T>");

        // Test covariant (out) - Kotlin producer
        let out_params = vec![TypeParameter {
            name: "E".to_string(),
            bounds: vec![],
            variance: TypeVariance::Covariant,
            reified: false,
        }];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&out_params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<out E>");

        // Test contravariant (in) - Kotlin consumer
        let in_params = vec![TypeParameter {
            name: "K".to_string(),
            bounds: vec![],
            variance: TypeVariance::Contravariant,
            reified: false,
        }];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&in_params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<in K>");

        // Test reified type parameter
        let reified_params = vec![TypeParameter {
            name: "T".to_string(),
            bounds: vec![],
            variance: TypeVariance::Invariant,
            reified: true,
        }];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&reified_params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<reified T>");

        // Test combined: out + reified
        let combined_params = vec![TypeParameter {
            name: "R".to_string(),
            bounds: vec![],
            variance: TypeVariance::Covariant,
            reified: true,
        }];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&combined_params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<out reified R>");
    }

    #[test]
    fn test_multiple_type_parameters_with_variance() {
        use dexterity_ir::info::TypeVariance;

        let params = vec![
            TypeParameter {
                name: "K".to_string(),
                bounds: vec![],
                variance: TypeVariance::Contravariant, // in
                reified: false,
            },
            TypeParameter {
                name: "V".to_string(),
                bounds: vec![],
                variance: TypeVariance::Covariant, // out
                reified: false,
            },
        ];
        let mut writer = SimpleCodeWriter::new();
        generate_type_parameters(&params, None, None, &mut writer);
        assert_eq!(writer.finish(), "<in K, out V>");
    }
}
