# Dexterity Docker Deployment Guide

This guide explains how to build, deploy, and run Dexterity in Docker containers for production use.

## Quick Start

### 1. Build the Docker Image

```bash
./docker-deploy.sh build
```

Or using docker-compose directly:

```bash
docker-compose build
```

### 2. Run Decompilation

```bash
# Decompile APKs from ./apks directory to ./output
./docker-deploy.sh run

# Decompile from custom directories
./docker-deploy.sh run /path/to/apks /path/to/output
```

### 3. Test the Image

```bash
./docker-deploy.sh test
```

## Detailed Usage

### Building Images

The Dockerfile uses a multi-stage build process:

1. **Builder Stage**: Compiles the Rust binary with all optimizations
2. **Runtime Stage**: Creates a minimal Debian-based image with only the binary

```bash
# Build default image
docker-compose build

# Build with multi-architecture support (amd64, arm64)
docker buildx build --platform linux/amd64,linux/arm64 -t dexterity:latest .

# Build for development (includes source and build tools)
docker-compose --profile dev build dexterity-builder
```

### Running Single APK Decompilation

```bash
# Using the deployment script
./docker-deploy.sh run ./apks ./output

# Using docker run directly
docker run --rm \
  -v $(pwd)/apks:/workspace/apks:ro \
  -v $(pwd)/output:/output:rw \
  -e RUST_LOG=info \
  --user $(id -u):$(id -g) \
  dexterity:latest \
  --input /workspace/apks/app.apk \
  --output /output \
  --threads 8 \
  --deobf
```

### Batch Processing (Parallel Workers)

For processing multiple APKs in parallel:

```bash
# Start 4 parallel workers
./docker-deploy.sh batch

# Or with docker-compose
docker-compose --profile batch up dexterity-batch

# Customize worker count in docker-compose.yml:
#   deploy:
#     replicas: 8  # Change to desired number
```

### Interactive Shell

Get a shell inside the container for debugging:

```bash
./docker-deploy.sh shell
```

### Resource Management

#### CPU and Memory Limits

Edit `docker-compose.yml` to adjust resource limits:

```yaml
deploy:
  resources:
    limits:
      cpus: '16'        # Maximum CPUs
      memory: 32G       # Maximum RAM
    reservations:
      cpus: '8'         # Reserved CPUs
      memory: 16G       # Reserved RAM
```

#### Monitoring Resources

```bash
# Show current resource usage
./docker-deploy.sh stats

# Watch in real-time
watch -n 1 docker stats
```

## Production Deployment

### 1. Build Optimized Image

```bash
# Build with distribution profile (maximum optimization)
docker build --target runtime \
  --build-arg CARGO_PROFILE=dist \
  -t dexterity:dist .
```

### 2. Push to Container Registry

```bash
# Tag for registry
export DOCKER_REGISTRY=ghcr.io/yourorg
./docker-deploy.sh push

# Or manually
docker tag dexterity:latest ghcr.io/yourorg/dexterity:latest
docker push ghcr.io/yourorg/dexterity:latest
```

### 3. Deploy to Production

#### Docker Swarm

```bash
# Initialize swarm
docker swarm init

# Deploy stack
docker stack deploy -c docker-compose.yml dexterity

# Scale workers
docker service scale dexterity_dexterity-batch=8
```

#### Kubernetes

Create a deployment YAML:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: dexterity
spec:
  replicas: 4
  selector:
    matchLabels:
      app: dexterity
  template:
    metadata:
      labels:
        app: dexterity
    spec:
      containers:
      - name: dexterity
        image: ghcr.io/yourorg/dexterity:latest
        resources:
          limits:
            cpu: "16"
            memory: "32Gi"
          requests:
            cpu: "8"
            memory: "16Gi"
        volumeMounts:
        - name: apks
          mountPath: /workspace/apks
          readOnly: true
        - name: output
          mountPath: /output
        env:
        - name: RUST_LOG
          value: "info"
      volumes:
      - name: apks
        persistentVolumeClaim:
          claimName: apks-pvc
      - name: output
        persistentVolumeClaim:
          claimName: output-pvc
```

Deploy:

```bash
kubectl apply -f dexterity-deployment.yaml
```

## Integration with Knox-Vision

To integrate with Knox-Vision, update the config:

```yaml
# In knox-vision/config.yaml
tools:
  jadx_rust: "/usr/local/bin/dexterity"  # Path in container
  use_jadx_rust: true
```

Or run knox-vision in the same network:

```yaml
# docker-compose.yml (in knox-vision)
services:
  knox-vision:
    depends_on:
      - dexterity
    networks:
      - apk-processing

  dexterity:
    image: dexterity:latest
    networks:
      - apk-processing

networks:
  apk-processing:
    driver: bridge
```

## Configuration

### Environment Variables

- `RUST_LOG`: Logging level (`debug`, `info`, `warn`, `error`)
- `RUST_BACKTRACE`: Enable backtraces (`0`, `1`, `full`)
- `DEXTERITY_THREADS`: Number of threads (default: number of CPUs)

### Command-Line Options

See available options:

```bash
docker run --rm dexterity:latest --help
```

Common options:
- `--input <PATH>`: Input APK or directory
- `--output <PATH>`: Output directory
- `--threads <N>`: Number of threads
- `--deobf`: Enable deobfuscation (off by default)
- `--export-gradle`: Export Gradle project
- `--resources`: Export resources

## Performance Tuning

### For Knox-Vision Integration

Optimal configuration for parallel APK processing:

```yaml
# docker-compose.yml
services:
  dexterity:
    deploy:
      mode: replicated
      replicas: 7              # 7 parallel workers
      resources:
        limits:
          cpus: '16'            # 16 threads per worker
          memory: 32G
```

This matches the optimal knox-vision config (7 workers × 16 threads).

### Build Cache

To speed up rebuilds, the Dockerfile uses layer caching:

1. Dependencies are built first (rarely change)
2. Source code is copied last (changes frequently)

Rebuild only dependencies:

```bash
docker-compose build --no-cache dexterity
```

## Troubleshooting

### Build Failures

```bash
# Clean everything and rebuild
./docker-deploy.sh clean
./docker-deploy.sh build
```

### Permission Issues

Ensure the container runs with correct UID/GID:

```bash
docker run --rm \
  --user $(id -u):$(id -g) \
  -v $(pwd)/output:/output:rw \
  dexterity:latest
```

### Memory Issues

If containers are killed (OOM):

1. Increase memory limits in `docker-compose.yml`
2. Reduce thread count: `--threads 8`
3. Process fewer APKs in parallel

### Slow Builds

Use BuildKit for faster builds:

```bash
export DOCKER_BUILDKIT=1
docker-compose build
```

## Maintenance

### Cleanup

```bash
# Remove all dexterity containers and images
./docker-deploy.sh clean

# Remove unused Docker resources
docker system prune -a
```

### Updates

```bash
# Pull latest code
git pull

# Rebuild image
./docker-deploy.sh build

# Test new image
./docker-deploy.sh test
```

## Security

The Docker image follows security best practices:

1. **Non-root user**: Runs as `dexterity` user (UID 1000)
2. **Minimal image**: Based on `debian:bookworm-slim`
3. **No secrets**: No hardcoded credentials or API keys
4. **Read-only input**: Input volumes mounted as read-only
5. **Resource limits**: CPU and memory limits enforced

## Support

For issues or questions:

1. Check logs: `docker logs <container_id>`
2. Run with debug: `RUST_LOG=debug ./docker-deploy.sh run`
3. Open an issue on GitHub

## License

Apache 2.0 - See LICENSE file for details.
