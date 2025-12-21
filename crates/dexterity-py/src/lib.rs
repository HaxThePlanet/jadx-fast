/*!
 * Python bindings for Dexterity resource extraction
 *
 * Provides high-performance ARSC and AXML parsing via PyO3.
 * Exposes Dexterity's resource extraction capabilities to Python for Knox Vision integration.
 */

use pyo3::prelude::*;
use pyo3::types::PyModule;

mod arsc;
mod axml;
mod error;

/// Dexterity Python Module
///
/// Provides Android resource parsing (ARSC, AXML) for Python.
#[pymodule]
fn dexterity_py(m: &Bound<'_, PyModule>) -> PyResult<()> {
    // Register ARSC parser
    m.add_class::<arsc::PyArscParser>()?;

    // Register AXML parser
    m.add_class::<axml::PyAxmlParser>()?;

    Ok(())
}
