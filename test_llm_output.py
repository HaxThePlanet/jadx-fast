#!/usr/bin/env python3
"""
Test script to show LLM enhancement of real decompiled code from output/
"""

import os
import sys
from pathlib import Path

def find_java_files(directory, limit=5):
    """Find Java files in decompiled output"""
    java_files = []
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith('.java'):
                java_files.append(os.path.join(root, file))
                if len(java_files) >= limit:
                    return java_files
    return java_files

def show_code(filepath, title):
    """Show code from a Java file"""
    print(f"\n{title}:")
    print("=" * 80)
    try:
        with open(filepath, 'r') as f:
            lines = f.readlines()
            # Show first 50 lines or whole file if smaller
            for i, line in enumerate(lines[:50]):
                print(f"{i+1:3d} | {line}", end='')
            if len(lines) > 50:
                print(f"... ({len(lines) - 50} more lines)")
    except Exception as e:
        print(f"Error reading file: {e}")

def main():
    output_dir = "/mnt/nvme4tb/jadx-rust/output"

    print("╔════════════════════════════════════════════════════════════╗")
    print("║  REAL DECOMPILED CODE FROM DEXTERITY OUTPUT               ║")
    print("╚════════════════════════════════════════════════════════════╝\n")

    # Check small APK
    print("\n📦 SMALL APK - Dexterity Decompilation:")
    print("─" * 80)
    small_files = find_java_files(f"{output_dir}/small/dexterity", limit=10)
    for f in small_files:
        show_code(f, f"File: {Path(f).name}")

    # Check medium APK
    print("\n\n📦 MEDIUM APK - Sample Decompiled Code:")
    print("─" * 80)
    medium_files = find_java_files(f"{output_dir}/medium/dexterity", limit=3)
    for f in medium_files[:2]:  # Show first 2 files
        show_code(f, f"File: {Path(f).relative_to(f'{output_dir}/medium/dexterity')}")

    # Show where output is
    print("\n\n📁 OUTPUT LOCATIONS:")
    print("─" * 80)
    print(f"Small APK:  {output_dir}/small/dexterity/sources/")
    print(f"Medium APK: {output_dir}/medium/dexterity/sources/")
    print(f"Large APK:  {output_dir}/large/dexterity/sources/")

    print("\n\n📊 STATISTICS:")
    print("─" * 80)
    for size in ['small', 'medium', 'large']:
        path = f"{output_dir}/{size}/dexterity/sources"
        if os.path.exists(path):
            count = sum(1 for root, dirs, files in os.walk(path) for f in files if f.endswith('.java'))
            print(f"{size.upper():10} - {count} Java files")

if __name__ == "__main__":
    main()
