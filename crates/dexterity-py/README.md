# Dexterity Python Bindings

High-performance Android resource extraction for Python via Rust/PyO3.

## Features

- **ARSC Parser**: Extract package names, resource IDs, and generate resource XML files
- **AXML Parser**: Decode binary Android XML to text (AndroidManifest.xml, layouts, etc.)
- **Zero-copy**: Direct Rust ↔ Python data transfer for maximum performance
- **Type-safe**: Compile-time guarantees with PyO3

## Installation

```bash
# Development mode (requires Rust toolchain)
cd crates/dexterity-py
maturin develop --release

# Production build
maturin build --release
pip install target/wheels/dexterity_py-*.whl
```

## Usage

### Extract Package Name

```python
import dexterity_py
import zipfile

# Extract resources.arsc from APK
with zipfile.ZipFile("app.apk") as zf:
    arsc_data = zf.read("resources.arsc")

# Parse ARSC
parser = dexterity_py.ArscParser(arsc_data)
package_name = parser.get_package_name()
print(f"Package: {package_name}")
```

### Parse AndroidManifest.xml

```python
import dexterity_py
import zipfile

with zipfile.ZipFile("app.apk") as zf:
    # Extract resources
    arsc_data = zf.read("resources.arsc")
    manifest_data = zf.read("AndroidManifest.xml")

# Parse ARSC for resource names
arsc_parser = dexterity_py.ArscParser(arsc_data)
res_map = arsc_parser.get_resource_map()

# Parse manifest with resource resolution
manifest_xml = dexterity_py.AxmlParser.parse_with_resources(
    manifest_data,
    res_map
)
print(manifest_xml)
```

### Generate Resource XML Files

```python
import dexterity_py

# Parse ARSC
parser = dexterity_py.ArscParser(arsc_data)

# Generate all resource XML files
resources = parser.generate_values_xml()
for path, content in resources.items():
    print(f"{path}:\n{content}\n")
```

## Performance

Dexterity resource extraction is **2-4x faster** than aapt/aapt2:

- No subprocess overhead
- Pure Rust implementation
- Parallelized extraction with rayon
- Zero-copy data transfer to Python

## License

Apache-2.0
