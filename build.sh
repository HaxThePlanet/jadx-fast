#!/bin/bash
#===============================================================================
# Dexterity Build & Deployment Script
#
# A robust build and packaging script for Dexterity decompiler.
# Designed to match knox-vision's deployment patterns.
#
# Usage: ./build.sh [OPTIONS]
#   (no args)   Build release binary
#   --build     Force clean rebuild
#   --export    Create deployment package (tar.gz with binary)
#   --docker    Build Docker image
#   --clean     Clean build artifacts
#   --test      Run tests
#   --status    Show build status
#   --help      Show help
#
# Author: Dexterity Team
# Version: 1.0.0
#
# Output: dexterity-deploy.tar.gz containing ready-to-run binary
#===============================================================================

set -o pipefail

#===============================================================================
# CONFIGURATION
#===============================================================================
readonly VERSION="1.0.0"
readonly SCRIPT_NAME="$(basename "$0")"
readonly SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
readonly CRATES_DIR="${SCRIPT_DIR}/crates"
readonly TARGET_DIR="${CRATES_DIR}/target/release"
readonly LOG_DIR="${SCRIPT_DIR}/logs"
readonly LOG_FILE="${LOG_DIR}/build-$(date '+%Y%m%d-%H%M%S').log"

# Package info
readonly PACKAGE_NAME="dexterity"
readonly BINARY_NAME="dexterity"

#===============================================================================
# TERMINAL COLORS & FORMATTING
#===============================================================================
if [[ -t 1 ]]; then
    readonly RED='\033[0;31m'
    readonly GREEN='\033[0;32m'
    readonly YELLOW='\033[1;33m'
    readonly BLUE='\033[0;34m'
    readonly CYAN='\033[0;36m'
    readonly MAGENTA='\033[0;35m'
    readonly BOLD='\033[1m'
    readonly DIM='\033[2m'
    readonly NC='\033[0m'
else
    readonly RED='' GREEN='' YELLOW='' BLUE='' CYAN='' MAGENTA='' BOLD='' DIM='' NC=''
fi

#===============================================================================
# LOGGING SYSTEM
#===============================================================================
init_logging() {
    mkdir -p "$LOG_DIR"

    # Rotate old logs (keep last 10)
    local log_count
    log_count=$(find "$LOG_DIR" -name "build-*.log" -type f 2>/dev/null | wc -l)
    if [[ $log_count -gt 10 ]]; then
        find "$LOG_DIR" -name "build-*.log" -type f | sort | head -n -10 | xargs rm -f 2>/dev/null || true
    fi

    # Create new log file
    cat > "$LOG_FILE" << EOF
================================================================================
Dexterity Build Log
================================================================================
Timestamp:    $(date '+%Y-%m-%d %H:%M:%S %Z')
Script:       $SCRIPT_NAME v$VERSION
Working Dir:  $SCRIPT_DIR
User:         $(whoami)
Hostname:     $(hostname)
Args:         $*
================================================================================

EOF
}

log() {
    local level="$1"
    local msg="$2"
    local timestamp
    timestamp=$(date '+%Y-%m-%d %H:%M:%S')
    printf "[%s] [%-5s] %s\n" "$timestamp" "$level" "$msg" >> "$LOG_FILE"
}

log_output() {
    tee -a "$LOG_FILE"
}

# Console output functions
info() {
    log "INFO" "$1"
    printf "${BLUE}[INFO]${NC}  %s\n" "$1"
}

success() {
    log "OK" "$1"
    printf "${GREEN}[OK]${NC}    %s\n" "$1"
}

warn() {
    log "WARN" "$1"
    printf "${YELLOW}[WARN]${NC}  %s\n" "$1" >&2
}

error() {
    log "ERROR" "$1"
    printf "${RED}[ERROR]${NC} %s\n" "$1" >&2
}

fatal() {
    log "FATAL" "$1"
    printf "\n${RED}${BOLD}[FATAL]${NC} %s\n" "$1" >&2
    printf "\n${DIM}See log: %s${NC}\n\n" "$LOG_FILE" >&2
    exit 1
}

phase() {
    local msg="$1"
    log "PHASE" "========== $msg =========="
    printf "\n${CYAN}${BOLD}▶ %s${NC}\n\n" "$msg"
}

step() {
    local msg="$1"
    log "STEP" "$msg"
    printf "  ${DIM}→${NC} %s" "$msg"
}

step_ok() {
    printf " ${GREEN}✓${NC}\n"
}

step_fail() {
    printf " ${RED}✗${NC}\n"
}

step_skip() {
    printf " ${YELLOW}(skipped)${NC}\n"
}

#===============================================================================
# UTILITY FUNCTIONS
#===============================================================================
command_exists() {
    command -v "$1" &> /dev/null
}

file_exists() {
    [[ -f "$1" ]]
}

dir_exists() {
    [[ -d "$1" ]]
}

get_binary_version() {
    if file_exists "$TARGET_DIR/$BINARY_NAME"; then
        "$TARGET_DIR/$BINARY_NAME" --version 2>/dev/null | head -1 || echo "unknown"
    else
        echo "not built"
    fi
}

get_binary_size() {
    if file_exists "$TARGET_DIR/$BINARY_NAME"; then
        du -h "$TARGET_DIR/$BINARY_NAME" | cut -f1
    else
        echo "N/A"
    fi
}

#===============================================================================
# PRE-FLIGHT CHECKS
#===============================================================================
preflight_checks() {
    phase "Pre-flight Checks"
    local errors=0

    # Check Rust/Cargo
    step "Cargo installed"
    if command_exists cargo; then
        local cargo_version
        cargo_version=$(cargo --version | cut -d' ' -f2)
        log "INFO" "Cargo version: $cargo_version"
        step_ok
    else
        step_fail
        error "Cargo is not installed. Install Rust: https://rustup.rs"
        ((errors++))
    fi

    # Check Cargo.toml exists
    step "Cargo.toml found"
    if file_exists "$CRATES_DIR/Cargo.toml"; then
        step_ok
    else
        step_fail
        error "crates/Cargo.toml not found"
        ((errors++))
    fi

    # Check available memory
    step "System resources"
    local mem_gb
    mem_gb=$(free -g 2>/dev/null | awk '/^Mem:/{print $2}' || echo "0")
    local cpu_cores
    cpu_cores=$(nproc 2>/dev/null || echo "1")
    log "INFO" "Memory: ${mem_gb}GB, CPUs: $cpu_cores"

    if [[ $mem_gb -lt 4 ]]; then
        warn "Low memory (${mem_gb}GB). Build may be slow or fail."
    fi
    step_ok

    if [[ $errors -gt 0 ]]; then
        fatal "$errors pre-flight check(s) failed"
    fi

    success "All pre-flight checks passed"
}

#===============================================================================
# BUILD FUNCTIONS
#===============================================================================
build_release() {
    phase "Building Release Binary"

    cd "$CRATES_DIR" || fatal "Cannot change to $CRATES_DIR"

    local cpu_cores
    cpu_cores=$(nproc 2>/dev/null || echo "8")

    info "Building with $cpu_cores parallel jobs..."
    info "This may take 2-5 minutes..."

    local start_time
    start_time=$(date +%s)

    if cargo build --release --package dexterity-cli 2>&1 | log_output; then
        local end_time
        end_time=$(date +%s)
        local duration=$((end_time - start_time))

        if file_exists "$TARGET_DIR/$BINARY_NAME"; then
            local size
            size=$(get_binary_size)
            success "Build completed in ${duration}s"
            success "Binary: $TARGET_DIR/$BINARY_NAME ($size)"
            return 0
        else
            fatal "Build completed but binary not found"
        fi
    else
        fatal "Build failed. Check log: $LOG_FILE"
    fi
}

build_dist() {
    phase "Building Distribution Binary (Maximum Optimization)"

    cd "$CRATES_DIR" || fatal "Cannot change to $CRATES_DIR"

    info "Building with full LTO (this takes longer)..."
    info "This may take 5-15 minutes..."

    local start_time
    start_time=$(date +%s)

    if cargo build --profile dist --package dexterity-cli 2>&1 | log_output; then
        local end_time
        end_time=$(date +%s)
        local duration=$((end_time - start_time))

        local dist_binary="${CRATES_DIR}/target/dist/$BINARY_NAME"
        if file_exists "$dist_binary"; then
            local size
            size=$(du -h "$dist_binary" | cut -f1)
            success "Distribution build completed in ${duration}s"
            success "Binary: $dist_binary ($size)"
            # Copy to release dir for consistency
            cp "$dist_binary" "$TARGET_DIR/$BINARY_NAME"
            return 0
        fi
    fi

    warn "Distribution build failed, falling back to release build"
    build_release
}

clean_build() {
    phase "Cleaning Build Artifacts"

    cd "$CRATES_DIR" || fatal "Cannot change to $CRATES_DIR"

    step "Cleaning Cargo target"
    if cargo clean 2>&1 | log_output; then
        step_ok
    else
        step_fail
        warn "Clean had issues"
    fi

    success "Clean completed"
}

run_tests() {
    phase "Running Tests"

    cd "$CRATES_DIR" || fatal "Cannot change to $CRATES_DIR"

    info "Running cargo test..."

    if cargo test --release 2>&1 | log_output; then
        success "All tests passed"
        return 0
    else
        error "Some tests failed"
        return 1
    fi
}

#===============================================================================
# EXPORT PACKAGE
#===============================================================================
export_package() {
    phase "Creating Deployment Package"

    # Ensure binary is built
    if ! file_exists "$TARGET_DIR/$BINARY_NAME"; then
        info "Binary not found, building first..."
        build_release
    fi

    local export_dir="$SCRIPT_DIR/dexterity-deploy"
    local package_file="$SCRIPT_DIR/dexterity-deploy.tar.gz"

    # Clean previous
    rm -rf "$export_dir"
    mkdir -p "$export_dir/bin"

    # Copy binary
    step "Copying binary"
    cp "$TARGET_DIR/$BINARY_NAME" "$export_dir/bin/"
    chmod +x "$export_dir/bin/$BINARY_NAME"
    step_ok

    local bin_size
    bin_size=$(du -h "$export_dir/bin/$BINARY_NAME" | cut -f1)
    info "Binary size: $bin_size"

    # Get version
    local bin_version
    bin_version=$("$export_dir/bin/$BINARY_NAME" --version 2>/dev/null | head -1 || echo "1.0.0")

    # Create install script
    step "Creating install script"
    cat > "$export_dir/install.sh" << 'INSTALL_EOF'
#!/bin/bash
# Dexterity Installation Script
set -e

INSTALL_DIR="${INSTALL_DIR:-/opt/dexterity}"
BIN_DIR="${BIN_DIR:-/usr/local/bin}"

echo "Installing Dexterity to $INSTALL_DIR..."

# Create directories
sudo mkdir -p "$INSTALL_DIR/bin"

# Copy binary
sudo cp bin/dexterity "$INSTALL_DIR/bin/"
sudo chmod +x "$INSTALL_DIR/bin/dexterity"

# Create symlink
sudo ln -sf "$INSTALL_DIR/bin/dexterity" "$BIN_DIR/dexterity"

echo ""
echo "Installation complete!"
echo ""
echo "  Binary:  $INSTALL_DIR/bin/dexterity"
echo "  Symlink: $BIN_DIR/dexterity"
echo ""
echo "  Test: dexterity --version"
echo "  Help: dexterity --help"
echo ""
INSTALL_EOF
    chmod +x "$export_dir/install.sh"
    step_ok

    # Create README
    step "Creating README"
    cat > "$export_dir/README.md" << README_EOF
# Dexterity Deployment Package

Fast Android DEX/APK Decompiler written in Rust.

## Quick Install

\`\`\`bash
sudo ./install.sh
\`\`\`

## Manual Install

\`\`\`bash
# Copy binary to desired location
sudo cp bin/dexterity /usr/local/bin/

# Or add to your PATH
export PATH="\$PATH:\$(pwd)/bin"
\`\`\`

## Usage

\`\`\`bash
# Show help
dexterity --help

# Decompile an APK
dexterity --input app.apk --output ./output

# Decompile with deobfuscation
dexterity --input app.apk --output ./output --deobfuscate

# Use multiple threads
dexterity --input app.apk --output ./output --threads 16
\`\`\`

## Knox-Vision Integration

Update knox-vision config.yaml:

\`\`\`yaml
tools:
  jadx_rust: "/opt/dexterity/bin/dexterity"
  use_jadx_rust: true
\`\`\`

## Version

$bin_version

## System Requirements

- Linux x86_64
- glibc 2.31+ (Ubuntu 20.04+, Debian 11+)
README_EOF
    step_ok

    # Create version file
    echo "$bin_version" > "$export_dir/VERSION"

    # Create tarball
    step "Creating tarball"
    cd "$SCRIPT_DIR"

    # Use pigz for parallel compression if available
    if command_exists pigz; then
        tar -cf - "dexterity-deploy" | pigz -p "$(nproc)" > "$package_file"
    else
        tar -czf "$package_file" "dexterity-deploy"
    fi

    rm -rf "$export_dir"
    step_ok

    local pkg_size
    pkg_size=$(du -h "$package_file" | cut -f1)

    echo ""
    success "Deployment package created!"
    echo ""
    echo "  File: $package_file"
    echo "  Size: $pkg_size"
    echo ""
    echo "  Deploy to remote:"
    echo "    scp dexterity-deploy.tar.gz user@host:/tmp/"
    echo "    ssh user@host 'cd /tmp && tar xzf dexterity-deploy.tar.gz && cd dexterity-deploy && sudo ./install.sh'"
    echo ""
    echo "  Deploy locally:"
    echo "    tar xzf dexterity-deploy.tar.gz"
    echo "    cd dexterity-deploy && sudo ./install.sh"
    echo ""
}

#===============================================================================
# DOCKER BUILD
#===============================================================================
build_docker() {
    phase "Building Docker Image"

    if ! command_exists docker; then
        fatal "Docker is not installed"
    fi

    cd "$SCRIPT_DIR" || fatal "Cannot change to $SCRIPT_DIR"

    info "Building Docker image..."
    info "This may take 5-10 minutes..."

    if docker build -t dexterity:latest . 2>&1 | log_output; then
        success "Docker image built: dexterity:latest"

        # Show image info
        local image_size
        image_size=$(docker images dexterity:latest --format "{{.Size}}")
        info "Image size: $image_size"

        # Test the image
        step "Testing Docker image"
        if docker run --rm dexterity:latest --version &>/dev/null; then
            step_ok
        else
            step_fail
            warn "Image built but test failed"
        fi
    else
        fatal "Docker build failed"
    fi
}

#===============================================================================
# STATUS
#===============================================================================
show_status() {
    phase "Dexterity Build Status"

    echo ""
    printf "  ${CYAN}%-20s${NC} %s\n" "Version:" "$VERSION"
    printf "  ${CYAN}%-20s${NC} %s\n" "Script Dir:" "$SCRIPT_DIR"
    printf "  ${CYAN}%-20s${NC} %s\n" "Crates Dir:" "$CRATES_DIR"
    echo ""

    # Binary status
    printf "  ${CYAN}%-20s${NC} " "Binary:"
    if file_exists "$TARGET_DIR/$BINARY_NAME"; then
        local size
        size=$(get_binary_size)
        local version
        version=$(get_binary_version)
        printf "${GREEN}Built${NC} ($size)\n"
        printf "  ${CYAN}%-20s${NC} %s\n" "Binary Version:" "$version"
        printf "  ${CYAN}%-20s${NC} %s\n" "Binary Path:" "$TARGET_DIR/$BINARY_NAME"
    else
        printf "${YELLOW}Not built${NC}\n"
    fi
    echo ""

    # Package status
    printf "  ${CYAN}%-20s${NC} " "Deploy Package:"
    if file_exists "$SCRIPT_DIR/dexterity-deploy.tar.gz"; then
        local pkg_size
        pkg_size=$(du -h "$SCRIPT_DIR/dexterity-deploy.tar.gz" | cut -f1)
        local pkg_date
        pkg_date=$(stat -c %y "$SCRIPT_DIR/dexterity-deploy.tar.gz" 2>/dev/null | cut -d. -f1)
        printf "${GREEN}Available${NC} ($pkg_size, $pkg_date)\n"
    else
        printf "${YELLOW}Not created${NC}\n"
    fi
    echo ""

    # Docker status
    printf "  ${CYAN}%-20s${NC} " "Docker Image:"
    if command_exists docker; then
        if docker images dexterity:latest --format "{{.Size}}" 2>/dev/null | grep -q .; then
            local img_size
            img_size=$(docker images dexterity:latest --format "{{.Size}}")
            printf "${GREEN}Available${NC} ($img_size)\n"
        else
            printf "${YELLOW}Not built${NC}\n"
        fi
    else
        printf "${DIM}Docker not installed${NC}\n"
    fi
    echo ""

    # Cargo info
    printf "  ${CYAN}%-20s${NC} " "Cargo:"
    if command_exists cargo; then
        local cargo_ver
        cargo_ver=$(cargo --version | cut -d' ' -f2)
        printf "${GREEN}$cargo_ver${NC}\n"
    else
        printf "${RED}Not installed${NC}\n"
    fi

    printf "  ${CYAN}%-20s${NC} " "Rust:"
    if command_exists rustc; then
        local rust_ver
        rust_ver=$(rustc --version | cut -d' ' -f2)
        printf "${GREEN}$rust_ver${NC}\n"
    else
        printf "${RED}Not installed${NC}\n"
    fi
    echo ""
}

#===============================================================================
# SUCCESS BANNER
#===============================================================================
print_success_banner() {
    cat << EOF

${GREEN}╔══════════════════════════════════════════════════════════════╗
║                                                              ║
║   ${BOLD}Dexterity Build Complete!${NC}${GREEN}                                ║
║                                                              ║
╠══════════════════════════════════════════════════════════════╣
║                                                              ║
║   ${CYAN}Binary:${NC}${GREEN}  $TARGET_DIR/$BINARY_NAME${NC}${GREEN}
║                                                              ║
║   ${CYAN}Size:${NC}${GREEN}    $(get_binary_size)                                             ${NC}${GREEN}
║                                                              ║
╠══════════════════════════════════════════════════════════════╣
║                                                              ║
║   ${YELLOW}Test:${NC}${GREEN}    $TARGET_DIR/$BINARY_NAME --version${NC}${GREEN}
║   ${YELLOW}Help:${NC}${GREEN}    $TARGET_DIR/$BINARY_NAME --help              ${NC}${GREEN}
║   ${YELLOW}Export:${NC}${GREEN}  ./build.sh --export                           ${NC}${GREEN}
║                                                              ║
╚══════════════════════════════════════════════════════════════╝${NC}

${DIM}Log file: $LOG_FILE${NC}

EOF
}

#===============================================================================
# HELP
#===============================================================================
show_help() {
    cat << EOF
${BOLD}Dexterity Build Script v$VERSION${NC}

${CYAN}USAGE:${NC}
  $SCRIPT_NAME [OPTIONS]

${CYAN}OPTIONS:${NC}
  (no args)     Build release binary
  --build       Force clean rebuild
  --dist        Build with maximum optimization (slower)
  --export      Create deployment package (tar.gz)
  --docker      Build Docker image
  --test        Run tests
  --clean       Clean build artifacts
  --status      Show build status
  --help        Show this help

${CYAN}EXAMPLES:${NC}
  # Normal build
  ./build.sh

  # Clean rebuild
  ./build.sh --clean && ./build.sh

  # Create deployment package
  ./build.sh --export

  # Build Docker image
  ./build.sh --docker

  # Run tests
  ./build.sh --test

${CYAN}DEPLOYMENT:${NC}
  # Create package
  ./build.sh --export

  # Copy to remote
  scp dexterity-deploy.tar.gz user@host:/tmp/

  # Install on remote
  ssh user@host 'cd /tmp && tar xzf dexterity-deploy.tar.gz && cd dexterity-deploy && sudo ./install.sh'

${CYAN}KNOX-VISION INTEGRATION:${NC}
  # After install, update knox-vision config.yaml:
  tools:
    jadx_rust: "/opt/dexterity/bin/dexterity"
    use_jadx_rust: true

EOF
}

#===============================================================================
# MAIN
#===============================================================================
main() {
    # Initialize logging
    init_logging "$@"

    # Parse arguments
    local action="build"
    local do_clean=false

    while [[ $# -gt 0 ]]; do
        case "$1" in
            --build)  action="build"; shift ;;
            --dist)   action="dist"; shift ;;
            --export) action="export"; shift ;;
            --docker) action="docker"; shift ;;
            --test)   action="test"; shift ;;
            --clean)  action="clean"; shift ;;
            --status) action="status"; shift ;;
            --help|-h) show_help; exit 0 ;;
            *)
                error "Unknown option: $1"
                show_help
                exit 1
                ;;
        esac
    done

    # Header
    echo ""
    echo -e "${BOLD}Dexterity Build Script v$VERSION${NC}"
    echo "═══════════════════════════════════════"
    echo ""

    log "INFO" "Action: $action"

    # Quick actions (no preflight needed)
    case "$action" in
        status)
            show_status
            exit 0
            ;;
        clean)
            preflight_checks
            clean_build
            exit 0
            ;;
    esac

    # Full preflight for other actions
    preflight_checks

    case "$action" in
        build)
            build_release
            print_success_banner
            ;;
        dist)
            build_dist
            print_success_banner
            ;;
        export)
            export_package
            ;;
        docker)
            build_docker
            ;;
        test)
            run_tests
            ;;
    esac

    log "INFO" "Completed successfully"
}

# Run main with all arguments
main "$@"
