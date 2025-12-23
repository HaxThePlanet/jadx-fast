fn main() {
    let mut config = prost_build::Config::new();

    // Configure prost for better code generation
    config.bytes([".kotlin.metadata"]);

    // Map jvm package types to crate::jvm_proto module
    // JADX Reference: This allows cross-package references for JVM signature types
    // needed by KmExt.kt:shortId equivalent functionality
    config.extern_path(
        ".org.jetbrains.kotlin.metadata.jvm",
        "crate::jvm_proto",
    );

    // Compile the proto files
    config
        .compile_protos(
            &["proto/metadata.proto", "proto/jvm_metadata.proto"],
            &["proto/"],
        )
        .unwrap();

    println!("cargo:rerun-if-changed=proto/metadata.proto");
    println!("cargo:rerun-if-changed=proto/ext_options.proto");
    println!("cargo:rerun-if-changed=proto/jvm_metadata.proto");
}
