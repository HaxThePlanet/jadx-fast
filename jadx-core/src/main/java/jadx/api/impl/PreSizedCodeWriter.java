package jadx.api.impl;

import jadx.api.JadxArgs;
import jadx.core.dex.nodes.ClassNode;

/**
 * CodeWriter implementation with pre-sized StringBuilder for better performance
 */
public class PreSizedCodeWriter extends SimpleCodeWriter {

	public PreSizedCodeWriter(JadxArgs args) {
		super(args);
		// Default constructor behavior
	}

	public PreSizedCodeWriter(JadxArgs args, ClassNode cls) {
		super(args);
		// Pre-size the StringBuilder based on class complexity
		int estimatedSize = estimateClassSize(cls);
		this.buf = new StringBuilder(estimatedSize);

		// Re-apply initial setup if needed
		if (insertLineNumbers) {
			add(indentStr);
		}
	}

	private int estimateClassSize(ClassNode cls) {
		// Base size for class declaration, imports, package
		int baseSize = 500;

		// Estimate based on methods (average method ~500 chars)
		int methodsSize = cls.getMethods().size() * 500;

		// Estimate based on fields (average field ~100 chars)
		int fieldsSize = cls.getFields().size() * 100;

		// Estimate based on inner classes (recursive, but simplified)
		int innerClassesSize = cls.getInnerClasses().size() * 1000;

		// Add buffer for safety
		int totalSize = baseSize + methodsSize + fieldsSize + innerClassesSize;

		// Add 20% buffer to avoid resizing
		return (int) (totalSize * 1.2);
	}
}
