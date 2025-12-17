package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class EmptyNode extends com.google.firebase.database.snapshot.ChildrenNode implements com.google.firebase.database.snapshot.Node {

    private static final com.google.firebase.database.snapshot.EmptyNode empty;
    static {
        EmptyNode emptyNode = new EmptyNode();
        EmptyNode.empty = emptyNode;
    }

    public static com.google.firebase.database.snapshot.EmptyNode Empty() {
        return EmptyNode.empty;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public int compareTo(com.google.firebase.database.snapshot.Node node) {
        int obj1;
        obj1 = node.isEmpty() ? 0 : -1;
        return obj1;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public int compareTo(Object object) {
        return compareTo((Node)object);
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public boolean equals(Object object) {
        com.google.firebase.database.snapshot.Node priority;
        int i;
        boolean obj3;
        if (object instanceof EmptyNode) {
            return 1;
        }
        if (object instanceof Node && (Node)object.isEmpty() && getPriority().equals(object.getPriority())) {
            if ((Node)object.isEmpty()) {
                if (getPriority().equals(object.getPriority())) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public com.google.firebase.database.snapshot.Node getChild(Path path) {
        return this;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public int getChildCount() {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public String getHash() {
        return "";
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public String getHashRepresentation(com.google.firebase.database.snapshot.Node.HashVersion node$HashVersion) {
        return "";
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public com.google.firebase.database.snapshot.Node getImmediateChild(com.google.firebase.database.snapshot.ChildKey childKey) {
        return this;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public com.google.firebase.database.snapshot.ChildKey getPredecessorChildKey(com.google.firebase.database.snapshot.ChildKey childKey) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public com.google.firebase.database.snapshot.Node getPriority() {
        return this;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public com.google.firebase.database.snapshot.ChildKey getSuccessorChildKey(com.google.firebase.database.snapshot.ChildKey childKey) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public Object getValue() {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public Object getValue(boolean z) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public boolean hasChild(com.google.firebase.database.snapshot.ChildKey childKey) {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public int hashCode() {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public boolean isEmpty() {
        return 1;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public boolean isLeafNode() {
        return 0;
    }

    public Iterator<com.google.firebase.database.snapshot.NamedNode> iterator() {
        return Collections.emptyList().iterator();
    }

    public Iterator<com.google.firebase.database.snapshot.NamedNode> reverseIterator() {
        return Collections.emptyList().iterator();
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public String toString() {
        return "<Empty Node>";
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public com.google.firebase.database.snapshot.Node updateChild(Path path, com.google.firebase.database.snapshot.Node node2) {
        if (path.isEmpty()) {
            return node2;
        }
        com.google.firebase.database.snapshot.ChildKey front = path.getFront();
        return updateImmediateChild(front, getImmediateChild(front).updateChild(path.popFront(), node2));
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public com.google.firebase.database.snapshot.Node updateImmediateChild(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2) {
        if (node2.isEmpty()) {
            return this;
        }
        if (childKey.isPriorityChildName()) {
            return this;
        }
        ChildrenNode childrenNode = new ChildrenNode();
        return childrenNode.updateImmediateChild(childKey, node2);
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public com.google.firebase.database.snapshot.EmptyNode updatePriority(com.google.firebase.database.snapshot.Node node) {
        return this;
    }

    @Override // com.google.firebase.database.snapshot.ChildrenNode
    public com.google.firebase.database.snapshot.Node updatePriority(com.google.firebase.database.snapshot.Node node) {
        return updatePriority(node);
    }
}
