package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class NodeSizeEstimator {

    private static final int LEAF_PRIORITY_OVERHEAD = 24;
    private static long estimateLeafNodeSize(LeafNode<?> leafNode) {
        boolean i2;
        int i;
        long l;
        i = 8;
        if (leafNode instanceof DoubleNode) {
            if (leafNode.getPriority().isEmpty()) {
                return i;
            }
            return i3 += estimateLeafNodeSize;
        } else {
            if (leafNode instanceof LongNode) {
            } else {
                if (leafNode instanceof BooleanNode) {
                    i = 4;
                } else {
                    if (!leafNode instanceof StringNode) {
                    } else {
                        i = l + i2;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown leaf node type: ");
        stringBuilder.append(leafNode.getClass());
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static long estimateSerializedNodeSize(Node node) {
        boolean estimateLeafNodeSize;
        int i;
        long estimateSerializedNodeSize;
        long l;
        Node obj8;
        final int i3 = 4;
        if (node.isEmpty()) {
            return i3;
        }
        if (node.isLeafNode()) {
            return NodeSizeEstimator.estimateLeafNodeSize((LeafNode)node);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected node type: ");
        stringBuilder.append(node.getClass());
        Utilities.hardAssert(node instanceof ChildrenNode, stringBuilder.toString());
        i = 1;
        Iterator iterator = node.iterator();
        for (NamedNode next2 : iterator) {
            i6 += estimateSerializedNodeSize;
        }
        if (!node.getPriority().isEmpty()) {
            i4 += estimateLeafNodeSize;
        }
        return i;
    }

    public static int nodeCount(Node node) {
        boolean nodeCount;
        int i;
        if (node.isEmpty()) {
            return 0;
        }
        if (node.isLeafNode()) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected node type: ");
        stringBuilder.append(node.getClass());
        Utilities.hardAssert(node instanceof ChildrenNode, stringBuilder.toString());
        Iterator obj4 = node.iterator();
        for (NamedNode next2 : obj4) {
            i += nodeCount;
        }
        return i;
    }
}
