"""
Dexterity Python Bindings

Provides high-performance Android resource extraction (ARSC, AXML) via Rust/PyO3.
"""

from typing import Optional, Dict

class ArscParser:
    """
    Parser for ARSC (Android Resource Table) files.

    Example:
        >>> with open("resources.arsc", "rb") as f:
        >>>     arsc_data = f.read()
        >>> parser = ArscParser(arsc_data)
        >>> package = parser.get_package_name()
        >>> print(f"Package: {package}")
    """

    def __init__(self, data: bytes) -> None:
        """
        Create a new ARSC parser from binary data.

        Args:
            data: Raw bytes from resources.arsc file

        Raises:
            DexterityError: If parsing fails
        """
        ...

    def get_package_name(self) -> Optional[str]:
        """
        Get the app package name from ARSC.

        Returns:
            Package name (e.g., "com.example.app") or None if not found
        """
        ...

    def get_resource_map(self) -> Dict[int, str]:
        """
        Get resource ID to name mapping.

        Returns:
            Dictionary mapping resource IDs to resource names
            Example: {0x7f0a0001: "string/app_name", 0x7f020001: "drawable/icon"}
        """
        ...

    def generate_values_xml(self) -> Dict[str, str]:
        """
        Generate all resource XML files.

        Returns:
            Dictionary mapping file paths to XML content
            Example: {"values/strings.xml": "<resources>...</resources>", ...}
        """
        ...

    def entry_count(self) -> int:
        """
        Get the number of parsed resource entries.

        Returns:
            Number of resource entries
        """
        ...

class AxmlParser:
    """
    Parser for AXML (Android Binary XML) files.

    Example:
        >>> with open("AndroidManifest.xml", "rb") as f:
        >>>     manifest_data = f.read()
        >>> xml = AxmlParser.parse(manifest_data)
        >>> print(xml)
    """

    @staticmethod
    def parse(data: bytes) -> str:
        """
        Parse binary XML to text XML.

        Args:
            data: Raw bytes from binary XML file (e.g., AndroidManifest.xml)

        Returns:
            Decoded XML as string

        Raises:
            DexterityError: If parsing fails
        """
        ...

    @staticmethod
    def parse_with_resources(data: bytes, res_map: Dict[int, str]) -> str:
        """
        Parse binary XML with resource name resolution.

        Args:
            data: Raw bytes from binary XML file
            res_map: Dictionary mapping resource IDs to names from ArscParser.get_resource_map()

        Returns:
            Decoded XML as string with resource references resolved

        Raises:
            DexterityError: If parsing fails
        """
        ...

    @staticmethod
    def parse_manifest(
        manifest_data: bytes,
        res_map: Optional[Dict[int, str]] = None,
    ) -> str:
        """
        Parse AndroidManifest.xml with full resource resolution.

        Convenience method that combines AXML parsing with resource resolution.

        Args:
            manifest_data: Raw bytes from AndroidManifest.xml
            res_map: Optional resource map from ArscParser

        Returns:
            Decoded AndroidManifest.xml as string

        Raises:
            DexterityError: If parsing fails
        """
        ...

class DexterityError(Exception):
    """Exception raised by Dexterity parsers"""
    ...
