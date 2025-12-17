package com.google.firebase.database.snapshot;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.Path;

/* loaded from: classes2.dex */
public class PriorityUtilities {
    public static com.google.firebase.database.snapshot.Node NullPriority() {
        return EmptyNode.Empty();
    }

    public static boolean isValidPriority(com.google.firebase.database.snapshot.Node node) {
        boolean empty;
        int obj1;
        if (node.getPriority().isEmpty()) {
            if (!node.isEmpty() && !node instanceof DoubleNode && !node instanceof StringNode) {
                if (!node instanceof DoubleNode) {
                    if (!node instanceof StringNode) {
                        obj1 = node instanceof DeferredValueNode ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    public static com.google.firebase.database.snapshot.Node parsePriority(Path path, Object object2) {
        boolean doubleNode;
        com.google.firebase.database.snapshot.Node stringBuilder;
        double str;
        String obj3;
        com.google.firebase.database.snapshot.Node obj4;
        obj4 = NodeUtilities.NodeFromJSON(object2);
        if (obj4 instanceof LongNode) {
            doubleNode = new DoubleNode(Double.valueOf((double)longValue), PriorityUtilities.NullPriority());
            obj4 = doubleNode;
        }
        if (!PriorityUtilities.isValidPriority(obj4)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            if (path != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Path '");
                stringBuilder.append(path);
                stringBuilder.append("'");
                obj3 = stringBuilder.toString();
            } else {
                obj3 = "Node";
            }
            stringBuilder2.append(obj3);
            stringBuilder2.append(" contains invalid priority: Must be a string, double, ServerValue, or null");
            obj4 = new DatabaseException(stringBuilder2.toString());
            throw obj4;
        }
        return obj4;
    }

    public static com.google.firebase.database.snapshot.Node parsePriority(Object object) {
        return PriorityUtilities.parsePriority(0, object);
    }
}
