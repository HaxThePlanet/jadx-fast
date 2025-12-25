# Multi-stage Dockerfile for Dexterity - Fast Android DEX/APK Decompiler
# Stage 1: Builder - Compile Rust binary
FROM rust:1.83-bookworm AS builder

# Install build dependencies
RUN apt-get update && apt-get install -y \
    build-essential \
    pkg-config \
    libssl-dev \
    protobuf-compiler \
    && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /build

# Copy workspace configuration first for better layer caching
COPY crates/Cargo.toml crates/Cargo.lock ./crates/

# Copy all crate manifests to prepare dependency layer
COPY crates/dexterity-cli/Cargo.toml ./crates/dexterity-cli/
COPY crates/dexterity-dex/Cargo.toml ./crates/dexterity-dex/
COPY crates/dexterity-ir/Cargo.toml ./crates/dexterity-ir/
COPY crates/dexterity-passes/Cargo.toml ./crates/dexterity-passes/
COPY crates/dexterity-codegen/Cargo.toml ./crates/dexterity-codegen/
COPY crates/dexterity-resources/Cargo.toml ./crates/dexterity-resources/
COPY crates/dexterity-deobf/Cargo.toml ./crates/dexterity-deobf/
COPY crates/dexterity-kotlin/Cargo.toml ./crates/dexterity-kotlin/
COPY crates/dexterity-qa/Cargo.toml ./crates/dexterity-qa/
COPY crates/dexterity-llm-postproc/Cargo.toml ./crates/dexterity-llm-postproc/
COPY crates/dexterity-py/Cargo.toml ./crates/dexterity-py/

# Create dummy source files to cache dependencies
RUN mkdir -p crates/dexterity-cli/src && echo "fn main() {}" > crates/dexterity-cli/src/main.rs && \
    mkdir -p crates/dexterity-dex/src && echo "" > crates/dexterity-dex/src/lib.rs && \
    mkdir -p crates/dexterity-ir/src && echo "" > crates/dexterity-ir/src/lib.rs && \
    mkdir -p crates/dexterity-passes/src && echo "" > crates/dexterity-passes/src/lib.rs && \
    mkdir -p crates/dexterity-codegen/src && echo "" > crates/dexterity-codegen/src/lib.rs && \
    mkdir -p crates/dexterity-resources/src && echo "" > crates/dexterity-resources/src/lib.rs && \
    mkdir -p crates/dexterity-deobf/src && echo "" > crates/dexterity-deobf/src/lib.rs && \
    mkdir -p crates/dexterity-kotlin/src && echo "" > crates/dexterity-kotlin/src/lib.rs && \
    mkdir -p crates/dexterity-qa/src && echo "fn main() {}" > crates/dexterity-qa/src/main.rs && echo "" > crates/dexterity-qa/src/lib.rs && \
    mkdir -p crates/dexterity-llm-postproc/src && echo "" > crates/dexterity-llm-postproc/src/lib.rs && \
    mkdir -p crates/dexterity-py/src && echo "" > crates/dexterity-py/src/lib.rs

# Build dependencies only (will be cached)
WORKDIR /build/crates
RUN cargo build --release --package dexterity-cli

# Remove dummy build artifacts
RUN rm -rf target/release/.fingerprint/dexterity-* target/release/build/dexterity-* \
    target/release/deps/libdexterity_* target/release/deps/dexterity-* \
    target/release/dexterity target/release/dexterity.d

# Copy actual source code
COPY crates/ /build/crates/

# Build the actual binary with all optimizations
RUN cargo build --release --package dexterity-cli

# Verify the binary was built
RUN ls -lh /build/crates/target/release/dexterity && \
    /build/crates/target/release/dexterity --version

# Stage 2: Runtime - Minimal image with just the binary
FROM debian:bookworm-slim AS runtime

# Install runtime dependencies
RUN apt-get update && apt-get install -y \
    ca-certificates \
    libssl3 \
    && rm -rf /var/lib/apt/lists/*

# Create non-root user for security
RUN useradd -m -u 1000 -s /bin/bash dexterity

# Copy binary from builder
COPY --from=builder /build/crates/target/release/dexterity /usr/local/bin/dexterity

# Set proper permissions
RUN chmod +x /usr/local/bin/dexterity

# Create working directories
RUN mkdir -p /workspace /output && \
    chown -R dexterity:dexterity /workspace /output

# Switch to non-root user
USER dexterity
WORKDIR /workspace

# Set environment variables
ENV RUST_LOG=info
ENV RUST_BACKTRACE=1

# Default command - show help
ENTRYPOINT ["/usr/local/bin/dexterity"]
CMD ["--help"]

# Labels for metadata
LABEL org.opencontainers.image.title="Dexterity"
LABEL org.opencontainers.image.description="Fast Android DEX/APK Decompiler written in Rust"
LABEL org.opencontainers.image.version="1.0.0"
LABEL org.opencontainers.image.authors="Dexterity Team"
LABEL org.opencontainers.image.licenses="Apache-2.0"
