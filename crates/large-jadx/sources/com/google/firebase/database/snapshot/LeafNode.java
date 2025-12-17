package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class LeafNode<T extends com.google.firebase.database.snapshot.LeafNode>  implements com.google.firebase.database.snapshot.Node {

    private String lazyHash;
    protected final com.google.firebase.database.snapshot.Node priority;

    protected static enum LeafType {

        DeferredValue,
        Boolean,
        Number,
        String;
    }
    LeafNode(com.google.firebase.database.snapshot.Node node) {
        super();
        this.priority = node;
    }

    private static int compareLongDoubleNodes(com.google.firebase.database.snapshot.LongNode longNode, com.google.firebase.database.snapshot.DoubleNode doubleNode2) {
        return Double.valueOf((double)longValue).compareTo((Double)doubleNode2.getValue());
    }

    protected abstract int compareLeafValues(T t);

    @Override // com.google.firebase.database.snapshot.Node
    public int compareTo(com.google.firebase.database.snapshot.Node node) {
        boolean z2;
        boolean z;
        if (node.isEmpty()) {
            return 1;
        }
        final int i = -1;
        if (node instanceof ChildrenNode) {
            return i;
        }
        Utilities.hardAssert(node.isLeafNode(), "Node is not leaf node!");
        if (this instanceof LongNode && node instanceof DoubleNode) {
            if (node instanceof DoubleNode) {
                return LeafNode.compareLongDoubleNodes((LongNode)this, (DoubleNode)node);
            }
        }
        if (this instanceof DoubleNode && node instanceof LongNode) {
            if (node instanceof LongNode) {
                return obj4 *= i;
            }
        }
        return leafCompare((LeafNode)node);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int compareTo(Object object) {
        return compareTo((Node)object);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public abstract boolean equals(Object object);

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node getChild(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        if (path.getFront().isPriorityChildName()) {
            return this.priority;
        }
        return EmptyNode.Empty();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int getChildCount() {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHash() {
        String sha1HexDigest;
        if (this.lazyHash == null) {
            this.lazyHash = Utilities.sha1HexDigest(getHashRepresentation(Node.HashVersion.V1));
        }
        return this.lazyHash;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node getImmediateChild(com.google.firebase.database.snapshot.ChildKey childKey) {
        if (childKey.isPriorityChildName()) {
            return this.priority;
        }
        return EmptyNode.Empty();
    }

    @Override // com.google.firebase.database.snapshot.Node
    protected abstract com.google.firebase.database.snapshot.LeafNode.LeafType getLeafType();

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.ChildKey getPredecessorChildKey(com.google.firebase.database.snapshot.ChildKey childKey) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node getPriority() {
        return this.priority;
    }

    @Override // com.google.firebase.database.snapshot.Node
    protected String getPriorityHash(com.google.firebase.database.snapshot.Node.HashVersion node$HashVersion) {
        int i;
        int i2 = LeafNode.1.$SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion[hashVersion.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
            } else {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unknown hash version: ");
            stringBuilder2.append(hashVersion);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException;
        }
        if (this.priority.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("priority:");
        stringBuilder.append(this.priority.getHashRepresentation(hashVersion));
        stringBuilder.append(":");
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.ChildKey getSuccessorChildKey(com.google.firebase.database.snapshot.ChildKey childKey) {
        return null;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue(boolean z) {
        boolean obj3;
        if (z && this.priority.isEmpty()) {
            if (this.priority.isEmpty()) {
            }
            obj3 = new HashMap();
            obj3.put(".value", getValue());
            obj3.put(".priority", this.priority.getValue());
            return obj3;
        }
        return getValue();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean hasChild(com.google.firebase.database.snapshot.ChildKey childKey) {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public abstract int hashCode();

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isEmpty() {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isLeafNode() {
        return 1;
    }

    public Iterator<com.google.firebase.database.snapshot.NamedNode> iterator() {
        return Collections.emptyList().iterator();
    }

    protected int leafCompare(com.google.firebase.database.snapshot.LeafNode<?> leafNode) {
        final com.google.firebase.database.snapshot.LeafNode.LeafType leafType = getLeafType();
        final com.google.firebase.database.snapshot.LeafNode.LeafType leafType2 = leafNode.getLeafType();
        if (leafType.equals(leafType2)) {
            return compareLeafValues(leafNode);
        }
        return leafType.compareTo(leafType2);
    }

    public Iterator<com.google.firebase.database.snapshot.NamedNode> reverseIterator() {
        return Collections.emptyList().iterator();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String toString() {
        String string;
        int stringBuilder;
        int i;
        string = getValue(true).toString();
        final int i3 = 100;
        if (string.length() <= i3) {
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string.substring(0, i3));
            stringBuilder.append("...");
            string = stringBuilder.toString();
        }
        return string;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node updateChild(Path path, com.google.firebase.database.snapshot.Node node2) {
        boolean priorityChildName;
        boolean priorityChildName2;
        int i;
        final com.google.firebase.database.snapshot.ChildKey front = path.getFront();
        if (front == null) {
            return node2;
        }
        if (node2.isEmpty() && !front.isPriorityChildName()) {
            if (!front.isPriorityChildName()) {
                return this;
            }
        }
        if (path.getFront().isPriorityChildName()) {
            if (path.size() == 1) {
            } else {
                i = 0;
            }
        }
        Utilities.hardAssert(i);
        return updateImmediateChild(front, EmptyNode.Empty().updateChild(path.popFront(), node2));
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node updateImmediateChild(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2) {
        if (childKey.isPriorityChildName()) {
            return updatePriority(node2);
        }
        if (node2.isEmpty()) {
            return this;
        }
        return EmptyNode.Empty().updateImmediateChild(childKey, node2).updatePriority(this.priority);
    }
}
