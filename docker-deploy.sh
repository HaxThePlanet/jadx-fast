#!/bin/bash
# Dexterity Docker Deployment Script
# Usage: ./docker-deploy.sh [build|run|batch|clean|push|help]

set -e  # Exit on error

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Configuration
IMAGE_NAME="dexterity"
IMAGE_TAG="latest"
REGISTRY="${DOCKER_REGISTRY:-}"  # Set DOCKER_REGISTRY env var for custom registry

# Helper functions
log_info() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

log_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

log_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

log_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# Command functions
cmd_build() {
    log_info "Building Dexterity Docker image..."
    docker-compose build dexterity

    # Also build multi-arch if buildx is available
    if docker buildx version &> /dev/null; then
        log_info "Building multi-architecture images (amd64, arm64)..."
        docker buildx build \
            --platform linux/amd64,linux/arm64 \
            -t ${IMAGE_NAME}:${IMAGE_TAG} \
            --target runtime \
            .
    fi

    log_success "Build completed successfully!"
    docker images | grep ${IMAGE_NAME}
}

cmd_run() {
    local input_path="${1:-./apks}"
    local output_path="${2:-./output}"

    log_info "Running Dexterity on APKs from: ${input_path}"
    log_info "Output will be saved to: ${output_path}"

    # Create output directory if it doesn't exist
    mkdir -p "${output_path}"

    docker run --rm \
        -v "$(realpath ${input_path}):/workspace/apks:ro" \
        -v "$(realpath ${output_path}):/output:rw" \
        -e RUST_LOG=info \
        -e RUST_BACKTRACE=1 \
        --user "$(id -u):$(id -g)" \
        ${IMAGE_NAME}:${IMAGE_TAG} \
        --input /workspace/apks \
        --output /output \
        --threads $(nproc) \
        --deobfuscate

    log_success "Decompilation completed! Check ${output_path}"
}

cmd_batch() {
    log_info "Starting batch processing with 4 parallel workers..."
    docker-compose --profile batch up dexterity-batch
    log_success "Batch processing completed!"
}

cmd_shell() {
    log_info "Starting interactive shell in Dexterity container..."
    docker run --rm -it \
        -v "$(pwd)/apks:/workspace/apks:ro" \
        -v "$(pwd)/output:/output:rw" \
        --user "$(id -u):$(id -g)" \
        --entrypoint /bin/bash \
        ${IMAGE_NAME}:${IMAGE_TAG}
}

cmd_test() {
    log_info "Testing Dexterity Docker image..."

    # Test 1: Show version
    log_info "Test 1: Checking version..."
    docker run --rm ${IMAGE_NAME}:${IMAGE_TAG} --version

    # Test 2: Show help
    log_info "Test 2: Checking help output..."
    docker run --rm ${IMAGE_NAME}:${IMAGE_TAG} --help

    log_success "All tests passed!"
}

cmd_clean() {
    log_warning "Cleaning up Docker resources..."

    # Stop and remove containers
    docker-compose down -v

    # Remove images
    docker rmi ${IMAGE_NAME}:${IMAGE_TAG} 2>/dev/null || true
    docker rmi ${IMAGE_NAME}:builder 2>/dev/null || true

    # Clean up dangling images
    docker image prune -f

    log_success "Cleanup completed!"
}

cmd_push() {
    if [ -z "${REGISTRY}" ]; then
        log_error "DOCKER_REGISTRY environment variable not set!"
        log_info "Example: export DOCKER_REGISTRY=ghcr.io/username"
        exit 1
    fi

    local full_image="${REGISTRY}/${IMAGE_NAME}:${IMAGE_TAG}"

    log_info "Tagging image as: ${full_image}"
    docker tag ${IMAGE_NAME}:${IMAGE_TAG} ${full_image}

    log_info "Pushing to registry: ${REGISTRY}"
    docker push ${full_image}

    log_success "Image pushed successfully: ${full_image}"
}

cmd_stats() {
    log_info "Docker resource usage:"
    docker stats --no-stream --format "table {{.Container}}\t{{.CPUPerc}}\t{{.MemUsage}}\t{{.NetIO}}\t{{.BlockIO}}"
}

cmd_help() {
    cat << EOF
Dexterity Docker Deployment Script

Usage: $0 [COMMAND] [OPTIONS]

Commands:
    build           Build the Dexterity Docker image
    run [IN] [OUT]  Run decompilation on APKs (default: ./apks -> ./output)
    batch           Start batch processing with parallel workers
    shell           Start interactive shell in container
    test            Test the Docker image
    stats           Show Docker resource usage
    clean           Remove all Docker containers and images
    push            Push image to registry (requires DOCKER_REGISTRY env var)
    help            Show this help message

Examples:
    # Build the image
    $0 build

    # Decompile APKs from ./apks to ./output
    $0 run

    # Decompile APKs from custom directories
    $0 run /path/to/apks /path/to/output

    # Run batch processing
    $0 batch

    # Test the image
    $0 test

    # Push to registry
    export DOCKER_REGISTRY=ghcr.io/username
    $0 push

    # Clean up everything
    $0 clean

Environment Variables:
    DOCKER_REGISTRY     Docker registry URL for pushing images
    RUST_LOG           Logging level (debug, info, warn, error)

For more information, see README.md
EOF
}

# Main script logic
main() {
    local command="${1:-help}"
    shift || true

    case "${command}" in
        build)
            cmd_build "$@"
            ;;
        run)
            cmd_run "$@"
            ;;
        batch)
            cmd_batch "$@"
            ;;
        shell)
            cmd_shell "$@"
            ;;
        test)
            cmd_test "$@"
            ;;
        stats)
            cmd_stats "$@"
            ;;
        clean)
            cmd_clean "$@"
            ;;
        push)
            cmd_push "$@"
            ;;
        help|--help|-h)
            cmd_help
            ;;
        *)
            log_error "Unknown command: ${command}"
            cmd_help
            exit 1
            ;;
    esac
}

# Run main function
main "$@"
