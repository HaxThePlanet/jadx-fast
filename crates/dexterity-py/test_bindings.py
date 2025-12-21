#!/usr/bin/env python3
"""
Simple test for Dexterity Python bindings

Run with: python3 test_bindings.py
"""

import sys
import zipfile
from pathlib import Path

# Add the built module to path (after running: maturin develop)
sys.path.insert(0, str(Path(__file__).parent / "target/release"))

try:
    import dexterity_py
    print("✓ Successfully imported dexterity_py")
except ImportError as e:
    print(f"✗ Failed to import dexterity_py: {e}")
    print("\nRun 'maturin develop --release' first!")
    sys.exit(1)

# Test with a sample APK
apk_path = Path("/mnt/nvme4tb/dexterity/badboy/app/badboy-debug.apk")

if not apk_path.exists():
    print(f"✗ Test APK not found at: {apk_path}")
    sys.exit(1)

print(f"\nTesting with APK: {apk_path.name}")

try:
    with zipfile.ZipFile(apk_path) as zf:
        # Test ARSC parsing
        print("\n=== ARSC Parser Test ===")
        arsc_data = zf.read("resources.arsc")
        print(f"ARSC size: {len(arsc_data)} bytes")

        parser = dexterity_py.ArscParser(arsc_data)
        print(f"Parser created: {parser}")

        package = parser.get_package_name()
        print(f"Package name: {package}")

        res_count = parser.entry_count()
        print(f"Resource entries: {res_count}")

        res_map = parser.get_resource_map()
        print(f"Resource map size: {len(res_map)} entries")
        print(f"Sample resources: {list(res_map.items())[:5]}")

        # Test AXML parsing
        print("\n=== AXML Parser Test ===")
        manifest_data = zf.read("AndroidManifest.xml")
        print(f"Manifest size: {len(manifest_data)} bytes")

        # Parse without resource names
        manifest_xml = dexterity_py.AxmlParser.parse(manifest_data)
        print(f"Manifest XML length: {len(manifest_xml)} chars")
        print(f"First 200 chars:\n{manifest_xml[:200]}...")

        # Parse with resource names
        manifest_xml_resolved = dexterity_py.AxmlParser.parse_with_resources(
            manifest_data, res_map
        )
        print(f"\nWith resources: {len(manifest_xml_resolved)} chars")

        print("\n✓ All tests passed!")

except Exception as e:
    print(f"\n✗ Test failed: {e}")
    import traceback
    traceback.print_exc()
    sys.exit(1)
