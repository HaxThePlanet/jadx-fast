#!/usr/bin/env python3
"""
Automatically generate Rust integration tests from Java JADX tests.

This script reads Java test files from jadx-core/src/test/java/jadx/tests/integration/
and generates corresponding Rust test files in crates/jadx-passes/tests/integration/
"""

import re
import os
from pathlib import Path
from typing import List, Dict, Optional

class JavaTestParser:
    """Parse Java JADX integration tests"""

    def __init__(self, java_file: Path):
        self.java_file = java_file
        self.content = java_file.read_text()
        self.package = self._extract_package()
        self.class_name = self._extract_class_name()
        self.tests = self._extract_tests()

    def _extract_package(self) -> str:
        match = re.search(r'package\s+([\w.]+);', self.content)
        return match.group(1) if match else ""

    def _extract_class_name(self) -> str:
        match = re.search(r'public\s+class\s+(\w+)', self.content)
        return match.group(1) if match else ""

    def _extract_tests(self) -> List[Dict]:
        """Extract all @Test methods and their corresponding TestCls code"""
        tests = []

        # Extract all TestCls classes first
        test_cls_map = self._extract_all_test_cls()

        # Find all @Test methods
        test_pattern = r'@Test\s+public\s+void\s+(\w+)\(\)\s*\{'
        for match in re.finditer(test_pattern, self.content):
            test_name = match.group(1)
            test_start = match.start()

            # Extract test body (find matching closing brace)
            test_body = self._extract_method_body(test_start)

            # Determine which TestCls this test uses
            test_cls_name = self._find_test_cls_name(test_body, test_name)
            test_cls_code = test_cls_map.get(test_cls_name, "")

            # Extract assertions
            assertions = self._extract_assertions(test_body)

            # Extract test options (noDebugInfo, etc.)
            options = self._extract_test_options(test_body)

            tests.append({
                'name': test_name,
                'test_cls': test_cls_code,
                'test_cls_name': test_cls_name,
                'assertions': assertions,
                'options': options
            })

        return tests

    def _extract_all_test_cls(self) -> Dict[str, str]:
        """Extract all TestCls variants (TestCls, TestCls2, TestCls3, etc.)"""
        test_cls_map = {}

        # Pattern for TestCls classes
        pattern = r'public\s+static\s+class\s+(TestCls\d*)\s*\{'

        for match in re.finditer(pattern, self.content):
            cls_name = match.group(1)
            start = match.start()

            # Extract class body
            body_start = self.content.find('{', start)
            class_body = self._extract_class_body(body_start)

            test_cls_map[cls_name] = class_body

        return test_cls_map

    def _extract_class_body(self, start: int) -> str:
        """Extract class body from opening { to closing }"""
        brace_count = 0
        body_lines = []
        in_body = False

        for i in range(start, len(self.content)):
            char = self.content[i]

            if char == '{':
                if brace_count == 0:
                    in_body = True
                    body_lines.append("public class TestCls {")
                brace_count += 1
            elif char == '}':
                brace_count -= 1
                if brace_count == 0:
                    body_lines.append("}")
                    return '\n'.join(body_lines)
            elif in_body and brace_count == 1 and char == '\n':
                # Capture line content between braces
                continue

            if in_body and brace_count >= 1 and char != '{':
                if not body_lines:
                    body_lines.append("public class TestCls {")

                # Collect the content
                line_start = self.content.rfind('\n', start, i) + 1
                line_end = self.content.find('\n', i)
                if line_end == -1:
                    line_end = len(self.content)

                line = self.content[line_start:line_end].lstrip()
                if line and not any(line.startswith(x) for x in ['public static class', 'private static class']):
                    if line not in body_lines:
                        body_lines.append(line)

        # Simpler extraction - just grab everything between { }
        brace_count = 0
        content_start = start
        for i in range(start, len(self.content)):
            if self.content[i] == '{':
                if brace_count == 0:
                    content_start = i + 1
                brace_count += 1
            elif self.content[i] == '}':
                brace_count -= 1
                if brace_count == 0:
                    inner_content = self.content[content_start:i].strip()
                    return f"public class TestCls {{\n{inner_content}\n}}"

        return ""

    def _find_test_cls_name(self, test_body: str, test_name: str) -> str:
        """Determine which TestCls variant this test uses"""
        # Look for getClassNode(TestClsN.class)
        match = re.search(r'getClassNode\((TestCls\d*)\.class\)', test_body)
        if match:
            return match.group(1)

        # Default mapping based on test name
        if 'test2' in test_name.lower():
            return 'TestCls2'
        elif 'test3' in test_name.lower():
            return 'TestCls3'
        elif 'test4' in test_name.lower():
            return 'TestCls4'
        elif 'test5' in test_name.lower():
            return 'TestCls5'

        return 'TestCls'

    def _extract_method_body(self, start: int) -> str:
        """Extract method body from opening { to closing }"""
        brace_count = 0
        body_start = self.content.find('{', start)

        for i in range(body_start, len(self.content)):
            if self.content[i] == '{':
                brace_count += 1
            elif self.content[i] == '}':
                brace_count -= 1
                if brace_count == 0:
                    return self.content[body_start:i+1]

        return ""

    def _extract_test_cls(self) -> Optional[str]:
        """Extract the TestCls inner class"""
        match = re.search(r'public\s+static\s+class\s+TestCls\s*\{', self.content)
        if not match:
            return None

        start = match.start()
        body = self._extract_method_body(start)

        # Clean up and extract just the methods/fields
        return body

    def _extract_assertions(self, test_body: str) -> List[Dict]:
        """Extract assertion patterns from test body"""
        assertions = []

        # .contains("...")
        for match in re.finditer(r'\.contains\("([^"]+)"\)', test_body):
            assertions.append({
                'type': 'contains',
                'value': match.group(1)
            })

        # .containsOne("...")
        for match in re.finditer(r'\.containsOne\("([^"]+)"\)', test_body):
            assertions.append({
                'type': 'contains_one',
                'value': match.group(1)
            })

        # .doesNotContain("...")
        for match in re.finditer(r'\.doesNotContain\("([^"]+)"\)', test_body):
            assertions.append({
                'type': 'does_not_contain',
                'value': match.group(1)
            })

        # .countString(N, "...")
        for match in re.finditer(r'\.countString\((\d+),\s*"([^"]+)"\)', test_body):
            assertions.append({
                'type': 'count_string',
                'count': int(match.group(1)),
                'value': match.group(2)
            })

        return assertions

    def _extract_test_options(self, test_body: str) -> Dict:
        """Extract test options like noDebugInfo()"""
        options = {}

        if 'noDebugInfo()' in test_body:
            options['no_debug_info'] = True
        if 'disableCompilation()' in test_body:
            options['disable_compilation'] = True
        if 'enableDeobfuscation()' in test_body:
            options['enable_deobf'] = True

        return options

class RustTestGenerator:
    """Generate Rust test code from parsed Java tests"""

    def __init__(self, category: str):
        self.category = category

    def generate_test_file(self, java_tests: List[JavaTestParser]) -> str:
        """Generate a Rust test file from multiple Java test classes"""

        lines = []
        lines.append(f"//! {self.category.capitalize()} integration tests")
        lines.append(f"//! Ported from jadx-core/src/test/java/jadx/tests/integration/{self.category}/")
        lines.append("")
        lines.append("mod integration_test_framework;")
        lines.append("use integration_test_framework::{IntegrationTestHelper, CodeAssertions};")
        lines.append("")

        for java_test in java_tests:
            for test in java_test.tests:
                lines.append(self._generate_test_function(java_test, test))
                lines.append("")

        return "\n".join(lines)

    def _generate_test_function(self, java_test: JavaTestParser, test: Dict) -> str:
        """Generate a single Rust #[test] function"""

        lines = []

        # Test function header
        test_name = self._rust_test_name(java_test.class_name, test['name'])
        lines.append("#[test]")
        lines.append(f"fn {test_name}() {{")

        # Create helper
        lines.append(f"    let helper = IntegrationTestHelper::new(\"{test_name}\");")

        # Java source code
        if test['test_cls']:
            java_source = self._format_java_source(test['test_cls'])
            lines.append(f"    let source = r#\"")
            for line in java_source.split('\n'):
                lines.append(f"{line}")
            lines.append(f"\"#;")
        else:
            lines.append("    // TODO: Extract test source")
            lines.append("    let source = r#\"")
            lines.append("public class TestCls {")
            lines.append("    // Add test code here")
            lines.append("}")
            lines.append("\"#;")

        lines.append("")

        # Decompile
        lines.append("    let result = helper.test_decompilation(source)")
        lines.append("        .expect(\"Decompilation failed\");")
        lines.append("")

        # Assertions
        if test['assertions']:
            lines.append("    result")
            for i, assertion in enumerate(test['assertions']):
                is_last = (i == len(test['assertions']) - 1)
                assertion_code = self._generate_assertion(assertion, is_last)
                lines.append(f"        {assertion_code}")
        else:
            lines.append("    // TODO: Add assertions")

        lines.append("}")

        return "\n".join(lines)

    def _rust_test_name(self, class_name: str, test_name: str) -> str:
        """Generate Rust test function name"""
        # Convert TestSomething -> test_something
        class_part = re.sub(r'Test(\w+)', r'\1', class_name)
        class_part = re.sub(r'([A-Z])', r'_\1', class_part).lower().strip('_')

        # Convert testMethod -> test_method
        test_part = re.sub(r'([A-Z])', r'_\1', test_name).lower()

        return f"{class_part}_{test_part}"

    def _format_java_source(self, test_cls: str) -> str:
        """Format TestCls code as standalone class"""
        # Extract methods from TestCls
        return test_cls.replace("public static class TestCls", "public class TestCls")

    def _generate_assertion(self, assertion: Dict, is_last: bool) -> str:
        """Generate Rust assertion code"""
        suffix = ";" if is_last else ""

        if assertion['type'] == 'contains':
            value = assertion['value'].replace('\\', '\\\\').replace('"', '\\"')
            return f'.contains("{value}"){suffix}'
        elif assertion['type'] == 'contains_one':
            value = assertion['value'].replace('\\', '\\\\').replace('"', '\\"')
            return f'.contains_one("{value}"){suffix}'
        elif assertion['type'] == 'does_not_contain':
            value = assertion['value'].replace('\\', '\\\\').replace('"', '\\"')
            return f'.does_not_contain("{value}"){suffix}'
        elif assertion['type'] == 'count_string':
            value = assertion['value'].replace('\\', '\\\\').replace('"', '\\"')
            count = assertion['count']
            return f'.count_string({count}, "{value}"){suffix}'

        return f"// TODO: Implement {assertion['type']}{suffix}"

def main():
    """Main entry point"""

    # Paths
    java_test_root = Path("jadx-core/src/test/java/jadx/tests/integration")
    rust_test_root = Path("crates/jadx-passes/tests/integration")

    # Create Rust test directory
    rust_test_root.mkdir(parents=True, exist_ok=True)

    # Process each category
    categories = [
        "conditions", "loops", "types", "trycatch", "others",
        "inner", "switches", "invoke", "enums", "generics",
        "inline", "arith", "java8", "arrays", "names",
        "rename", "variables", "annotations", "android",
        "deobf", "synchronize", "debuginfo", "usethis",
        "code", "fallback", "jbc", "special"
    ]

    total_tests = 0

    for category in categories:
        category_dir = java_test_root / category
        if not category_dir.exists():
            print(f"Skipping {category} (not found)")
            continue

        # Parse all Java test files in category
        java_tests = []
        for java_file in sorted(category_dir.glob("*.java")):
            try:
                parser = JavaTestParser(java_file)
                java_tests.append(parser)
                total_tests += len(parser.tests)
            except Exception as e:
                print(f"Error parsing {java_file}: {e}")

        if not java_tests:
            continue

        # Generate Rust test file
        generator = RustTestGenerator(category)
        rust_code = generator.generate_test_file(java_tests)

        # Write to file
        rust_file = rust_test_root / f"{category}_tests.rs"
        rust_file.write_text(rust_code)

        print(f"Generated {rust_file} ({len(java_tests)} test classes, {sum(len(t.tests) for t in java_tests)} tests)")

    print(f"\nTotal: {total_tests} tests generated")

if __name__ == "__main__":
    main()
