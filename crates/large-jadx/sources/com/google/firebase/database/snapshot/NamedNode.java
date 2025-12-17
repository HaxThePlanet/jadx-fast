package com.google.firebase.database.snapshot;

/* loaded from: classes2.dex */
public final class NamedNode {

    private static final com.google.firebase.database.snapshot.NamedNode MAX_NODE;
    private static final com.google.firebase.database.snapshot.NamedNode MIN_NODE;
    private final com.google.firebase.database.snapshot.ChildKey name;
    private final com.google.firebase.database.snapshot.Node node;
    static {
        NamedNode namedNode = new NamedNode(ChildKey.getMinName(), EmptyNode.Empty());
        NamedNode.MIN_NODE = namedNode;
        NamedNode namedNode2 = new NamedNode(ChildKey.getMaxName(), Node.MAX_NODE);
        NamedNode.MAX_NODE = namedNode2;
    }

    public NamedNode(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2) {
        super();
        this.name = childKey;
        this.node = node2;
    }

    public static com.google.firebase.database.snapshot.NamedNode getMaxNode() {
        return NamedNode.MAX_NODE;
    }

    public static com.google.firebase.database.snapshot.NamedNode getMinNode() {
        return NamedNode.MIN_NODE;
    }

    public boolean equals(Object object) {
        Class<com.google.firebase.database.snapshot.NamedNode> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (NamedNode.class != object.getClass()) {
            } else {
                if (!this.name.equals(object.name)) {
                    return i2;
                }
                if (!this.node.equals(object.node)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public com.google.firebase.database.snapshot.ChildKey getName() {
        return this.name;
    }

    public com.google.firebase.database.snapshot.Node getNode() {
        return this.node;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NamedNode{name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", node=");
        stringBuilder.append(this.node);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
