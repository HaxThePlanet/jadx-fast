/*!
 * Error handling for Python bindings
 */

use pyo3::exceptions::PyException;
use pyo3::prelude::*;

/// Custom error type for Dexterity Python bindings
#[derive(Debug)]
pub struct DexterityError(pub String);

impl std::fmt::Display for DexterityError {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        write!(f, "DexterityError: {}", self.0)
    }
}

impl std::error::Error for DexterityError {}

// Convert Rust errors to Python exceptions
impl From<DexterityError> for PyErr {
    fn from(err: DexterityError) -> PyErr {
        PyException::new_err(err.0)
    }
}
