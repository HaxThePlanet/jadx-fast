#!/usr/bin/env python3
import re

with open('RootNode.java', 'r') as f:
    content = f.read()

# Fix patterns where || is missing between conditions
# Look for patterns like:
#   condition1
#   condition2
# and replace with:
#   condition1
#   || condition2

lines = content.split('\n')
fixed_lines = []

for i, line in enumerate(lines):
    fixed_lines.append(line)
    
    # Check if this line is a condition (contains certain patterns and is indented with tabs)
    if i > 0 and '\t\t\t\t\t' in line and ('clsName.' in line or 'name == null' in line):
        # Check if previous line also has conditions but doesn't end with ||
        prev_line = lines[i-1]
        if '\t\t\t\t' in prev_line and ('clsName.' in prev_line or '.isEmpty()' in prev_line) and not prev_line.strip().endswith('||') and not prev_line.strip().endswith('{'):
            # This line needs || prefix
            # Count tabs to match indentation
            tabs = len(line) - len(line.lstrip('\t'))
            fixed_lines[-1] = '\t' * tabs + '|| ' + line.lstrip()

# Also fix the specific cases we know about
fixed_content = '\n'.join(fixed_lines)

# Fix the args.isDeobfuscationOn case
fixed_content = fixed_content.replace(
    'if (args.isDeobfuscationOn()\n\t\t||  !args.getRenameFlags().isEmpty())',
    'if (args.isDeobfuscationOn()\n\t\t\t|| !args.getRenameFlags().isEmpty())'
)

# Fix name == null case
fixed_content = fixed_content.replace(
    'if (name == null\n\t\t\t||  name.isEmpty())',
    'if (name == null\n\t\t\t\t\t|| name.isEmpty())'
)

# Fix DecompilationMode case
fixed_content = fixed_content.replace(
    'if (mode == DecompilationMode.FALLBACK\n\t\t||  mode == DecompilationMode.SIMPLE)',
    'if (mode == DecompilationMode.FALLBACK\n\t\t\t\t|| mode == DecompilationMode.SIMPLE)'
)

# Fix isTypeKnown case
fixed_content = fixed_content.replace(
    'if (!clsType.isTypeKnown()\n\t\t||  clsType.isGenericType())',
    'if (!clsType.isTypeKnown()\n\t\t\t\t|| clsType.isGenericType())'
)

with open('RootNode.java', 'w') as f:
    f.write(fixed_content)

print("Fixed || operators in RootNode.java")