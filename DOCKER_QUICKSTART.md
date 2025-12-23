# Dexterity Docker Quick Start

## What Was Created

Your Dexterity project now includes complete Docker deployment support:

### Files Created

1. **`Dockerfile`** - Multi-stage build configuration
   - Builder stage: Compiles Rust binary with optimizations
   - Runtime stage: Minimal Debian image with just the binary
   - Security: Runs as non-root user (UID 1000)

2. **`.dockerignore`** - Optimizes build context
   - Excludes build artifacts, tests, docs, and unnecessary files
   - Reduces build time and image size

3. **`docker-compose.yml`** - Orchestration configuration
   - Single APK processing service
   - Batch processing with parallel workers
   - Development builder service
   - Resource limits and health checks

4. **`docker-deploy.sh`** - Deployment automation script
   - Build, run, test, clean, and push commands
   - Multi-architecture support
   - Interactive shell access

5. **`DOCKER_DEPLOYMENT.md`** - Comprehensive documentation
   - Detailed usage instructions
   - Production deployment guides
   - Knox-Vision integration
   - Troubleshooting tips

## Quick Commands

### Build

```bash
# Using deployment script (recommended)
./docker-deploy.sh build

# Or with Docker directly
docker build -t dexterity:latest .

# Multi-architecture build
docker buildx build --platform linux/amd64,linux/arm64 -t dexterity:latest .
```

### Run

```bash
# Decompile APKs from ./apks to ./output
./docker-deploy.sh run

# Custom directories
./docker-deploy.sh run /path/to/apks /path/to/output

# Direct Docker command
docker run --rm \
  -v $(pwd)/apks:/workspace/apks:ro \
  -v $(pwd)/output:/output:rw \
  dexterity:latest \
  --input /workspace/apks \
  --output /output \
  --threads 16
```

### Test

```bash
./docker-deploy.sh test
```

### Clean Up

```bash
./docker-deploy.sh clean
```

## Integration with Knox-Vision

### Option 1: Local Binary (Current Setup)

Knox-Vision is already configured to use the local binary:

```yaml
# /mnt/nvme4tb/knox-vision/config.yaml
tools:
  jadx_rust: "/mnt/nvme4tb/dexterity/crates/target/release/dexterity"
  use_jadx_rust: true
```

### Option 2: Docker Container

Update Knox-Vision to use the Docker container:

```yaml
# config.yaml
tools:
  jadx_rust: "docker"
  jadx_rust_args:
    - "run"
    - "--rm"
    - "-v"
    - "${APK_PATH}:/workspace/apk.apk:ro"
    - "-v"
    - "${OUTPUT_PATH}:/output:rw"
    - "dexterity:latest"
  use_jadx_rust: true
```

### Option 3: Docker Compose Network

Run both services in the same Docker network:

```yaml
# In knox-vision directory
version: '3.8'

services:
  knox-vision:
    build: .
    depends_on:
      - dexterity
    networks:
      - apk-processing

  dexterity:
    image: dexterity:latest
    networks:
      - apk-processing
    volumes:
      - ./apks:/workspace/apks:ro
      - ./output:/output:rw

networks:
  apk-processing:
    driver: bridge
```

## Performance Configuration

### Knox-Vision Optimal Settings

For parallel APK processing (7 workers × 16 threads):

```yaml
# docker-compose.yml
services:
  dexterity:
    deploy:
      mode: replicated
      replicas: 7              # Match knox-vision worker count
      resources:
        limits:
          cpus: '16'            # 16 threads per worker
          memory: 32G
```

### Single Large APK

For processing very large APKs:

```bash
docker run --rm \
  -v $(pwd)/large-apk.apk:/workspace/app.apk:ro \
  -v $(pwd)/output:/output:rw \
  --cpus 56 \
  --memory 64g \
  dexterity:latest \
  --input /workspace/app.apk \
  --output /output \
  --threads 56
```

## Production Deployment

### 1. Build Production Image

```bash
# Build with maximum optimization
docker build -t dexterity:dist \
  --build-arg CARGO_PROFILE=dist \
  .
```

### 2. Push to Registry

```bash
# GitHub Container Registry
export DOCKER_REGISTRY=ghcr.io/yourorg
./docker-deploy.sh push

# Docker Hub
docker tag dexterity:latest yourorg/dexterity:latest
docker push yourorg/dexterity:latest
```

### 3. Deploy

```bash
# Docker Swarm
docker stack deploy -c docker-compose.yml dexterity

# Kubernetes
kubectl apply -f dexterity-deployment.yaml
```

## Environment Variables

Configure runtime behavior:

- `RUST_LOG`: `debug`, `info`, `warn`, `error` (default: `info`)
- `RUST_BACKTRACE`: `0`, `1`, `full` (default: `1`)
- `DEXTERITY_THREADS`: Number of threads (default: CPU count)

Example:

```bash
docker run --rm \
  -e RUST_LOG=debug \
  -e RUST_BACKTRACE=full \
  -v $(pwd)/apks:/workspace/apks:ro \
  -v $(pwd)/output:/output:rw \
  dexterity:latest \
  --input /workspace/apks \
  --output /output
```

## Troubleshooting

### Docker daemon not running

```bash
# Start Docker service
sudo systemctl start docker

# Enable on boot
sudo systemctl enable docker
```

### Permission denied errors

```bash
# Run as current user
docker run --rm \
  --user $(id -u):$(id -g) \
  ...
```

### Out of memory

```bash
# Increase memory limit
docker run --rm \
  --memory 32g \
  ...

# Or reduce threads
docker run --rm \
  dexterity:latest \
  --threads 8 \
  ...
```

### Build fails

```bash
# Clean and rebuild
./docker-deploy.sh clean
./docker-deploy.sh build

# Use BuildKit for faster builds
export DOCKER_BUILDKIT=1
docker build -t dexterity:latest .
```

## Next Steps

1. **Test the build** once Docker daemon is running:
   ```bash
   ./docker-deploy.sh build
   ./docker-deploy.sh test
   ```

2. **Run sample decompilation**:
   ```bash
   ./docker-deploy.sh run ./test-apks ./output
   ```

3. **Integrate with Knox-Vision** using one of the options above

4. **Deploy to production** using Docker Swarm or Kubernetes

## Support

For detailed documentation, see:
- `DOCKER_DEPLOYMENT.md` - Comprehensive deployment guide
- `README.md` - Main project documentation
- `./docker-deploy.sh help` - Deployment script usage

For issues:
- Check logs: `docker logs <container_id>`
- Debug mode: `RUST_LOG=debug ./docker-deploy.sh run`
- Open an issue on GitHub
