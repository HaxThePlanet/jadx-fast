/*!
 * AXML (Android Binary XML) Python bindings
 */

use pyo3::prelude::*;
use pyo3::types::{PyDict, PyDictMethods};
use dexterity_resources::axml::AxmlParser as RustAxmlParser;
use crate::error::DexterityError;
use std::collections::HashMap;

/// Python wrapper for AXML (Android Binary XML) parser
///
/// Example:
/// ```python
/// # Parse without resource names
/// xml = PyAxmlParser.parse(axml_bytes)
///
/// # Parse with resource names from ARSC
/// arsc_parser = PyArscParser(arsc_bytes)
/// res_map = arsc_parser.get_resource_map()
/// xml = PyAxmlParser.parse_with_resources(axml_bytes, res_map)
/// ```
#[pyclass(name = "AxmlParser")]
pub struct PyAxmlParser;

#[pymethods]
impl PyAxmlParser {
    /// Parse binary XML to text XML
    ///
    /// Args:
    ///     data: Raw bytes from binary XML file (e.g., AndroidManifest.xml)
    ///
    /// Returns:
    ///     Decoded XML as string
    ///
    /// Raises:
    ///     DexterityError: If parsing fails
    #[staticmethod]
    fn parse(py: Python, data: &[u8]) -> PyResult<String> {
        py.allow_threads(|| {
            let mut parser = RustAxmlParser::new();
            parser
                .parse(data)
                .map_err(|e| DexterityError(format!("AXML parse error: {}", e)).into())
        })
    }

    /// Parse binary XML with resource name resolution
    ///
    /// Args:
    ///     data: Raw bytes from binary XML file
    ///     res_map: Dictionary mapping resource IDs (int) to names (str)
    ///              from ArscParser.get_resource_map()
    ///
    /// Returns:
    ///     Decoded XML as string with resource references resolved
    ///
    /// Raises:
    ///     DexterityError: If parsing fails
    #[staticmethod]
    fn parse_with_resources(
        py: Python,
        data: &[u8],
        res_map: &Bound<'_, PyDict>,
    ) -> PyResult<String> {
        // Convert Python dict to Rust HashMap
        let mut resource_names: HashMap<u32, String> = HashMap::new();

        for (key, value) in res_map.iter() {
            let id: u32 = key.extract()?;
            let name: String = value.extract()?;
            resource_names.insert(id, name);
        }

        // Parse with resource names
        py.allow_threads(move || {
            let mut parser = RustAxmlParser::new();
            parser.set_res_names(resource_names);
            parser
                .parse(data)
                .map_err(|e| DexterityError(format!("AXML parse error: {}", e)).into())
        })
    }

    /// Parse AndroidManifest.xml with full resource resolution
    ///
    /// Convenience method that combines AXML parsing with resource resolution.
    ///
    /// Args:
    ///     manifest_data: Raw bytes from AndroidManifest.xml
    ///     res_map: Optional resource map from ArscParser
    ///
    /// Returns:
    ///     Decoded AndroidManifest.xml as string
    ///
    /// Raises:
    ///     DexterityError: If parsing fails
    #[staticmethod]
    #[pyo3(signature = (manifest_data, res_map=None))]
    fn parse_manifest(
        py: Python,
        manifest_data: &[u8],
        res_map: Option<&Bound<'_, PyDict>>,
    ) -> PyResult<String> {
        if let Some(res_map) = res_map {
            Self::parse_with_resources(py, manifest_data, res_map)
        } else {
            Self::parse(py, manifest_data)
        }
    }
}
