fn main() {
    let mut config = prost_build::Config::new();

    // Configure prost for better code generation
    config.bytes([".kotlin.metadata"]);

    // Compile the proto files
    config
        .compile_protos(
            &["proto/metadata.proto"],
            &["proto/"],
        )
        .unwrap();

    println!("cargo:rerun-if-changed=proto/metadata.proto");
    println!("cargo:rerun-if-changed=proto/ext_options.proto");
}
