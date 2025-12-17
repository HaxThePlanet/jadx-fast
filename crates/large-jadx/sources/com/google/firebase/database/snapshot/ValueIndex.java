package com.google.firebase.database.snapshot;

/* loaded from: classes2.dex */
public class ValueIndex extends com.google.firebase.database.snapshot.Index {

    private static final com.google.firebase.database.snapshot.ValueIndex INSTANCE;
    static {
        ValueIndex valueIndex = new ValueIndex();
        ValueIndex.INSTANCE = valueIndex;
    }

    public static com.google.firebase.database.snapshot.ValueIndex getInstance() {
        return ValueIndex.INSTANCE;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int compare(com.google.firebase.database.snapshot.NamedNode namedNode, com.google.firebase.database.snapshot.NamedNode namedNode2) {
        int compareTo = namedNode.getNode().compareTo(namedNode2.getNode());
        if (compareTo == 0) {
            return namedNode.getName().compareTo(namedNode2.getName());
        }
        return compareTo;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int compare(Object object, Object object2) {
        return compare((NamedNode)object, (NamedNode)object2);
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean equals(Object object) {
        return object instanceof ValueIndex;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String getQueryDefinition() {
        return ".value";
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int hashCode() {
        return 4;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean isDefinedOn(com.google.firebase.database.snapshot.Node node) {
        return 1;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public com.google.firebase.database.snapshot.NamedNode makePost(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2) {
        NamedNode namedNode = new NamedNode(childKey, node2);
        return namedNode;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public com.google.firebase.database.snapshot.NamedNode maxPost() {
        NamedNode namedNode = new NamedNode(ChildKey.getMaxName(), Node.MAX_NODE);
        return namedNode;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String toString() {
        return "ValueIndex";
    }
}
