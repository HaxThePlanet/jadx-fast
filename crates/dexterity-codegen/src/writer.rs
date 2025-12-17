//! Code writer abstraction

use tracing::error;

/// Code writer trait
pub trait CodeWriter {
    /// Start a new line with current indentation
    fn start_line(&mut self) -> &mut Self;

    /// Add a string at current position
    fn add(&mut self, s: &str) -> &mut Self;

    /// Add a newline
    fn newline(&mut self) -> &mut Self;

    /// Increase indentation
    fn inc_indent(&mut self);

    /// Decrease indentation
    fn dec_indent(&mut self);

    /// Get current indentation level
    fn indent(&self) -> u32;

    /// Finish writing and return the result
    fn finish(self) -> String;
}

/// Simple code writer implementation
pub struct SimpleCodeWriter {
    buf: String,
    indent_level: u32,
    indent_str: &'static str,
    at_line_start: bool,
}

impl SimpleCodeWriter {
    pub fn new() -> Self {
        SimpleCodeWriter {
            buf: String::new(),
            indent_level: 0,
            indent_str: "    ",
            at_line_start: true,
        }
    }

    fn write_indent(&mut self) {
        for _ in 0..self.indent_level {
            self.buf.push_str(self.indent_str);
        }
    }
}

impl Default for SimpleCodeWriter {
    fn default() -> Self {
        Self::new()
    }
}

impl CodeWriter for SimpleCodeWriter {
    fn start_line(&mut self) -> &mut Self {
        if !self.at_line_start {
            self.buf.push('\n');
        }
        self.write_indent();
        self.at_line_start = false;
        self
    }

    fn add(&mut self, s: &str) -> &mut Self {
        if s.len() > 10_000_000 {
             error!(
                 string_len = s.len(),
                 limit = 10_000_000,
                 "LIMIT_EXCEEDED: SimpleCodeWriter adding huge string"
             );
             panic!("SimpleCodeWriter adding huge string! len={} start={:.50}...", s.len(), s);
        }
        if self.buf.len() > 100_000_000 { // 100MB limit check BEFORE allocation
             error!(
                 buf_len = self.buf.len(),
                 limit = 100_000_000,
                 "LIMIT_EXCEEDED: SimpleCodeWriter buffer limit exceeded (100MB)"
             );
             panic!("SimpleCodeWriter limit exceeded (100MB) while adding: {:.50}...", s);
        }
        if self.at_line_start {
            self.write_indent();
            self.at_line_start = false;
        }
        self.buf.push_str(s);
        self
    }

    fn newline(&mut self) -> &mut Self {
        self.buf.push('\n');
        self.at_line_start = true;
        self
    }

    fn inc_indent(&mut self) {
        self.indent_level += 1;
    }

    fn dec_indent(&mut self) {
        if self.indent_level > 0 {
            self.indent_level -= 1;
        }
    }

    fn indent(&self) -> u32 {
        self.indent_level
    }

    fn finish(self) -> String {
        self.buf
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_simple_code() {
        let mut w = SimpleCodeWriter::new();
        w.add("public class Test {").newline();
        w.inc_indent();
        w.start_line().add("public void method() {").newline();
        w.inc_indent();
        w.start_line().add("// body").newline();
        w.dec_indent();
        w.start_line().add("}").newline();
        w.dec_indent();
        w.start_line().add("}").newline();

        let result = w.finish();
        assert!(result.contains("public class Test"));
        assert!(result.contains("    public void method()")); // 4-space indent
    }
}
