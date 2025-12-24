fn main() {
    // First, compile JVM metadata proto separately
    // JADX Reference: This generates JVM signature types needed for KmExt.kt:shortId
    let mut jvm_config = prost_build::Config::new();
    jvm_config
        .compile_protos(
            &["proto/jvm_metadata.proto"],
            &["proto/"],
        )
        .unwrap();

    // Now compile main metadata proto with reference to JVM types
    let mut config = prost_build::Config::new();
    config.bytes([".kotlin.metadata"]);

    // Map jvm package types to the already-generated jvm_proto module
    // JADX Reference: This allows cross-package references for JVM signature types
    // needed by KmExt.kt:shortId equivalent functionality
    config.extern_path(
        ".org.jetbrains.kotlin.metadata.jvm",
        "crate::jvm_proto",
    );

    config
        .compile_protos(
            &["proto/metadata.proto"],
            &["proto/"],
        )
        .unwrap();

    println!("cargo:rerun-if-changed=proto/metadata.proto");
    println!("cargo:rerun-if-changed=proto/ext_options.proto");
    println!("cargo:rerun-if-changed=proto/jvm_metadata.proto");
}
