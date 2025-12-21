/*!
 * ARSC (Android Resource Table) Python bindings
 */

use pyo3::prelude::*;
use pyo3::types::PyDict;
use dexterity_resources::arsc::ArscParser as RustArscParser;
use crate::error::DexterityError;

/// Python wrapper for ARSC (Android Resource Table) parser
///
/// Example:
/// ```python
/// parser = PyArscParser(arsc_bytes)
/// package = parser.get_package_name()
/// res_map = parser.get_resource_map()
/// ```
#[pyclass(name = "ArscParser")]
pub struct PyArscParser {
    parser: RustArscParser,
}

#[pymethods]
impl PyArscParser {
    /// Create a new ARSC parser from binary data
    ///
    /// Args:
    ///     data: Raw bytes from resources.arsc file
    ///
    /// Returns:
    ///     ArscParser instance
    ///
    /// Raises:
    ///     DexterityError: If parsing fails
    #[new]
    fn new(py: Python, data: &[u8]) -> PyResult<Self> {
        // Allow Python's GIL to be released during parsing (CPU-bound operation)
        py.allow_threads(|| {
            let mut parser = RustArscParser::new();
            parser
                .parse(data)
                .map_err(|e| DexterityError(format!("ARSC parse error: {}", e)))?;
            Ok(PyArscParser { parser })
        })
    }

    /// Get the app package name from ARSC
    ///
    /// Returns:
    ///     Package name (e.g., "com.example.app") or None if not found
    fn get_package_name(&self) -> Option<String> {
        self.parser.get_package_name()
    }

    /// Get resource ID to name mapping
    ///
    /// Returns:
    ///     Dictionary mapping resource IDs (int) to resource names (str)
    ///     Example: {0x7f0a0001: "string/app_name", 0x7f020001: "drawable/icon"}
    fn get_resource_map(&self, py: Python) -> PyResult<PyObject> {
        let res_names = self.parser.get_res_names();
        let dict = PyDict::new_bound(py);

        for (id, name) in res_names {
            dict.set_item(id, name)?;
        }

        Ok(dict.into_any().unbind())
    }

    /// Generate all resource XML files
    ///
    /// Returns:
    ///     Dictionary mapping file paths to XML content
    ///     Example: {"values/strings.xml": "<resources>...</resources>", ...}
    fn generate_values_xml(&self, py: Python) -> PyResult<PyObject> {
        let values = py.allow_threads(|| self.parser.generate_values_xml());
        let dict = PyDict::new_bound(py);

        for (path, content) in values {
            dict.set_item(path, content)?;
        }

        Ok(dict.into_any().unbind())
    }

    /// Get the number of parsed resource entries
    ///
    /// Returns:
    ///     Number of resource entries
    fn entry_count(&self) -> usize {
        self.parser.get_entries().len()
    }

    /// Python repr
    fn __repr__(&self) -> String {
        let package = self
            .parser
            .get_package_name()
            .unwrap_or_else(|| "unknown".to_string());
        let count = self.parser.get_entries().len();
        format!(
            "ArscParser(package='{}', entries={})",
            package, count
        )
    }
}
