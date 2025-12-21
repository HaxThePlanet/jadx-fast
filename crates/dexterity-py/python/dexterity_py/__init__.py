"""
Dexterity Python Bindings

High-performance Android resource extraction (ARSC, AXML) via Rust/PyO3.
"""

from .dexterity_py import ArscParser, AxmlParser

__all__ = ["ArscParser", "AxmlParser"]
__version__ = "1.0.0"

# Exception alias (Rust exceptions are raised as PyException)
DexterityError = Exception
