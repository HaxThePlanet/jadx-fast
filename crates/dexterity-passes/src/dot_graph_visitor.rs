//! DOT Graph Visitor - CFG Visualization
//!
//! JADX Clone: jadx-core/src/main/java/jadx/core/dex/visitors/DotGraphVisitor.java
//! Original Author: Skylot
//! Clone Date: Dec 2025
//! Lines: 332
//!
//! Generates DOT format (GraphViz) output for visualizing control flow graphs
//! and regions. Useful for debugging the decompiler.

use std::fmt::Write;
use dexterity_ir::regions::{Region, RegionContent};

/// Configuration for DOT graph output
#[derive(Debug, Clone, Default)]
pub struct DotGraphConfig {
    /// Include regions as subgraphs
    pub use_regions: bool,
    /// Show raw instruction format
    pub raw_insn: bool,
    /// Show dominator information
    pub print_dominators: bool,
}

impl DotGraphConfig {
    /// Create config for basic CFG dump
    pub fn dump() -> Self {
        Self::default()
    }

    /// Create config for raw instruction CFG dump
    pub fn dump_raw() -> Self {
        Self {
            raw_insn: true,
            ..Default::default()
        }
    }

    /// Create config for region-based dump
    pub fn dump_regions() -> Self {
        Self {
            use_regions: true,
            ..Default::default()
        }
    }

    /// Create config for raw region-based dump
    pub fn dump_raw_regions() -> Self {
        Self {
            use_regions: true,
            raw_insn: true,
            ..Default::default()
        }
    }
}

/// Result of DOT graph generation
#[derive(Debug, Clone)]
pub struct DotGraphResult {
    /// The generated DOT format string
    pub dot_content: String,
    /// Number of nodes in the graph
    pub node_count: usize,
    /// Number of edges in the graph
    pub edge_count: usize,
}

/// Generate DOT format output for a method's CFG
///
/// JADX Reference: DotGraphVisitor.process()
pub fn generate_dot_graph(
    method_name: &str,
    blocks: &[(u32, Vec<u32>)], // (block_id, successor_ids)
    config: &DotGraphConfig,
) -> DotGraphResult {
    let mut dot = String::new();
    let mut edge_count = 0;

    // Graph header
    writeln!(dot, "digraph \"CFG for {}\" {{", escape(method_name)).unwrap();

    // Method node
    writeln!(dot, "  MethodNode[shape=record,label=\"{}\"];", escape(method_name)).unwrap();

    if let Some((first_block, _)) = blocks.first() {
        writeln!(dot, "  MethodNode -> Node_{};", first_block).unwrap();
        edge_count += 1;
    }

    // Process each block
    for (block_id, successors) in blocks {
        // Block node
        writeln!(
            dot,
            "  Node_{}[shape=record,label=\"{{Block {}}}\"];",
            block_id, block_id
        )
        .unwrap();

        // Edges to successors
        for succ in successors {
            writeln!(dot, "  Node_{} -> Node_{};", block_id, succ).unwrap();
            edge_count += 1;
        }
    }

    writeln!(dot, "}}").unwrap();

    DotGraphResult {
        dot_content: dot,
        node_count: blocks.len() + 1, // blocks + method node
        edge_count,
    }
}

/// Generate DOT format output for a region tree
///
/// JADX Reference: DotGraphVisitor.processRegion()
pub fn generate_region_dot(
    method_name: &str,
    region: &Region,
    _config: &DotGraphConfig,
) -> DotGraphResult {
    let mut dot = String::new();
    let mut node_count = 0;
    let mut edge_count = 0;
    let mut cluster_id = 0;

    // Graph header
    writeln!(dot, "digraph \"Region tree for {}\" {{", escape(method_name)).unwrap();
    writeln!(dot, "  node [shape=record];").unwrap();

    // Process the region tree
    process_region(&mut dot, region, &mut node_count, &mut edge_count, &mut cluster_id, 1);

    writeln!(dot, "}}").unwrap();

    DotGraphResult {
        dot_content: dot,
        node_count,
        edge_count,
    }
}

fn process_region(
    dot: &mut String,
    region: &Region,
    node_count: &mut usize,
    edge_count: &mut usize,
    cluster_id: &mut usize,
    indent: usize,
) {
    process_region_with_depth(dot, region, node_count, edge_count, cluster_id, indent, 0);
}

fn process_region_with_depth(
    dot: &mut String,
    region: &Region,
    node_count: &mut usize,
    edge_count: &mut usize,
    cluster_id: &mut usize,
    indent: usize,
    depth: usize,
) {
    // Prevent stack overflow from deeply nested regions
    const MAX_DEPTH: usize = 100;
    if depth > MAX_DEPTH {
        tracing::error!(
            depth = depth,
            limit = MAX_DEPTH,
            "LIMIT_EXCEEDED: DOT graph visitor max depth reached"
        );
        let indent_str = "  ".repeat(indent);
        writeln!(dot, "{}/* Depth limit exceeded */", indent_str).unwrap();
        return;
    }

    let indent_str = "  ".repeat(indent);
    let current_cluster = *cluster_id;
    *cluster_id += 1;

    match region {
        Region::Sequence(contents) => {
            writeln!(dot, "{}subgraph cluster_{} {{", indent_str, current_cluster).unwrap();
            writeln!(dot, "{}  label=\"Sequence\";", indent_str).unwrap();
            writeln!(dot, "{}  color=blue;", indent_str).unwrap();

            for content in contents {
                match content {
                    RegionContent::Block(block_id) => {
                        writeln!(dot, "{}  Block_{}[label=\"Block {}\"];", indent_str, block_id, block_id).unwrap();
                        *node_count += 1;
                    }
                    RegionContent::Region(sub_region) => {
                        process_region_with_depth(dot, sub_region, node_count, edge_count, cluster_id, indent + 1, depth + 1);
                    }
                }
            }

            writeln!(dot, "{}}}", indent_str).unwrap();
        }
        Region::If { then_region, else_region, .. } => {
            writeln!(dot, "{}subgraph cluster_{} {{", indent_str, current_cluster).unwrap();
            writeln!(dot, "{}  label=\"If\";", indent_str).unwrap();
            writeln!(dot, "{}  color=green;", indent_str).unwrap();

            // Then branch
            writeln!(dot, "{}  subgraph cluster_{}_then {{", indent_str, current_cluster).unwrap();
            writeln!(dot, "{}    label=\"then\";", indent_str).unwrap();
            process_region_with_depth(dot, then_region, node_count, edge_count, cluster_id, indent + 2, depth + 1);
            writeln!(dot, "{}  }}", indent_str).unwrap();

            // Else branch
            if let Some(else_r) = else_region {
                writeln!(dot, "{}  subgraph cluster_{}_else {{", indent_str, current_cluster).unwrap();
                writeln!(dot, "{}    label=\"else\";", indent_str).unwrap();
                process_region_with_depth(dot, else_r, node_count, edge_count, cluster_id, indent + 2, depth + 1);
                writeln!(dot, "{}  }}", indent_str).unwrap();
            }

            writeln!(dot, "{}}}", indent_str).unwrap();
        }
        Region::Loop { body, kind, .. } => {
            writeln!(dot, "{}subgraph cluster_{} {{", indent_str, current_cluster).unwrap();
            writeln!(dot, "{}  label=\"Loop ({:?})\";", indent_str, kind).unwrap();
            writeln!(dot, "{}  color=red;", indent_str).unwrap();

            process_region_with_depth(dot, body, node_count, edge_count, cluster_id, indent + 1, depth + 1);

            writeln!(dot, "{}}}", indent_str).unwrap();
        }
        Region::Switch { header_block, cases, .. } => {
            writeln!(dot, "{}subgraph cluster_{} {{", indent_str, current_cluster).unwrap();
            writeln!(dot, "{}  label=\"Switch (header={})\";", indent_str, header_block).unwrap();
            writeln!(dot, "{}  color=purple;", indent_str).unwrap();

            writeln!(dot, "{}  Switch_{}[label=\"switch\"];", indent_str, header_block).unwrap();
            *node_count += 1;

            for (i, case) in cases.iter().enumerate() {
                writeln!(dot, "{}  subgraph cluster_{}_case_{} {{", indent_str, current_cluster, i).unwrap();
                writeln!(dot, "{}    label=\"case {:?}\";", indent_str, case.keys).unwrap();
                process_region_with_depth(dot, &case.container, node_count, edge_count, cluster_id, indent + 2, depth + 1);
                writeln!(dot, "{}  }}", indent_str).unwrap();
            }

            writeln!(dot, "{}}}", indent_str).unwrap();
        }
        Region::TryCatch { try_region, handlers, finally, .. } => {
            writeln!(dot, "{}subgraph cluster_{} {{", indent_str, current_cluster).unwrap();
            writeln!(dot, "{}  label=\"TryCatch\";", indent_str).unwrap();
            writeln!(dot, "{}  color=orange;", indent_str).unwrap();

            // Try block
            writeln!(dot, "{}  subgraph cluster_{}_try {{", indent_str, current_cluster).unwrap();
            writeln!(dot, "{}    label=\"try\";", indent_str).unwrap();
            process_region_with_depth(dot, try_region, node_count, edge_count, cluster_id, indent + 2, depth + 1);
            writeln!(dot, "{}  }}", indent_str).unwrap();

            // Catch handlers
            for (i, handler) in handlers.iter().enumerate() {
                writeln!(dot, "{}  subgraph cluster_{}_catch_{} {{", indent_str, current_cluster, i).unwrap();
                writeln!(dot, "{}    label=\"catch {:?}\";", indent_str, handler.exception_types).unwrap();
                process_region_with_depth(dot, &handler.region, node_count, edge_count, cluster_id, indent + 2, depth + 1);
                writeln!(dot, "{}  }}", indent_str).unwrap();
            }

            // Finally
            if let Some(finally_r) = finally {
                writeln!(dot, "{}  subgraph cluster_{}_finally {{", indent_str, current_cluster).unwrap();
                writeln!(dot, "{}    label=\"finally\";", indent_str).unwrap();
                process_region_with_depth(dot, finally_r, node_count, edge_count, cluster_id, indent + 2, depth + 1);
                writeln!(dot, "{}  }}", indent_str).unwrap();
            }

            writeln!(dot, "{}}}", indent_str).unwrap();
        }
        Region::Synchronized { body, enter_block, .. } => {
            writeln!(dot, "{}subgraph cluster_{} {{", indent_str, current_cluster).unwrap();
            writeln!(dot, "{}  label=\"Synchronized (enter={})\";", indent_str, enter_block).unwrap();
            writeln!(dot, "{}  color=cyan;", indent_str).unwrap();

            process_region_with_depth(dot, body, node_count, edge_count, cluster_id, indent + 1, depth + 1);

            writeln!(dot, "{}}}", indent_str).unwrap();
        }
        Region::Break { label, .. } => {
            writeln!(dot, "{}Break_{}[label=\"break{}\",shape=ellipse,color=gray];",
                indent_str, current_cluster,
                label.as_ref().map(|l| format!(" {}", l)).unwrap_or_default()
            ).unwrap();
            *node_count += 1;
        }
        Region::Continue { label, .. } => {
            writeln!(dot, "{}Continue_{}[label=\"continue{}\",shape=ellipse,color=gray];",
                indent_str, current_cluster,
                label.as_ref().map(|l| format!(" {}", l)).unwrap_or_default()
            ).unwrap();
            *node_count += 1;
        }
        Region::TernaryAssignment { .. } => {
            writeln!(dot, "{}Ternary_{}[label=\"ternary assignment\",shape=diamond];", indent_str, current_cluster).unwrap();
            *node_count += 1;
        }
        Region::TernaryReturn { .. } => {
            writeln!(dot, "{}Ternary_{}[label=\"ternary return\",shape=diamond];", indent_str, current_cluster).unwrap();
            *node_count += 1;
        }
    }
}

/// Escape a string for DOT format
///
/// JADX Reference: DotGraphVisitor.escape()
fn escape(s: &str) -> String {
    s.replace('\\', "")
        .replace('/', "\\/")
        .replace('>', "\\>")
        .replace('<', "\\<")
        .replace('{', "\\{")
        .replace('}', "\\}")
        .replace('"', "\\\"")
        .replace('-', "\\-")
        .replace('|', "\\|")
        .replace('\n', "\\l")
        .replace('\r', "")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_escape() {
        assert_eq!(escape("hello>world"), "hello\\>world");
        assert_eq!(escape("{block}"), "\\{block\\}");
        assert_eq!(escape("a|b"), "a\\|b");
    }

    #[test]
    fn test_generate_dot_graph() {
        let blocks = vec![
            (0, vec![1, 2]),
            (1, vec![3]),
            (2, vec![3]),
            (3, vec![]),
        ];

        let result = generate_dot_graph("test_method", &blocks, &DotGraphConfig::dump());

        assert!(result.dot_content.contains("digraph"));
        assert!(result.dot_content.contains("Node_0"));
        assert!(result.dot_content.contains("Node_1"));
        assert!(result.dot_content.contains("Node_2"));
        assert!(result.dot_content.contains("Node_3"));
        assert_eq!(result.node_count, 5); // 4 blocks + method node
        assert_eq!(result.edge_count, 5); // method->0, 0->1, 0->2, 1->3, 2->3
    }

    #[test]
    fn test_generate_region_dot() {
        let region = Region::Sequence(vec![
            RegionContent::Block(0),
            RegionContent::Block(1),
        ]);

        let result = generate_region_dot("test_method", &region, &DotGraphConfig::dump_regions());

        assert!(result.dot_content.contains("digraph"));
        assert!(result.dot_content.contains("Sequence"));
        assert!(result.dot_content.contains("Block_0"));
        assert!(result.dot_content.contains("Block_1"));
    }
}
