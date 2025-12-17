package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

/* loaded from: classes2.dex */
public class KeyIndex extends com.google.firebase.database.snapshot.Index {

    private static final com.google.firebase.database.snapshot.KeyIndex INSTANCE;
    static {
        KeyIndex keyIndex = new KeyIndex();
        KeyIndex.INSTANCE = keyIndex;
    }

    public static com.google.firebase.database.snapshot.KeyIndex getInstance() {
        return KeyIndex.INSTANCE;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int compare(com.google.firebase.database.snapshot.NamedNode namedNode, com.google.firebase.database.snapshot.NamedNode namedNode2) {
        return namedNode.getName().compareTo(namedNode2.getName());
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int compare(Object object, Object object2) {
        return compare((NamedNode)object, (NamedNode)object2);
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean equals(Object object) {
        return object instanceof KeyIndex;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String getQueryDefinition() {
        return ".key";
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int hashCode() {
        return 37;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean isDefinedOn(com.google.firebase.database.snapshot.Node node) {
        return 1;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public com.google.firebase.database.snapshot.NamedNode makePost(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2) {
        Utilities.hardAssert(node2 instanceof StringNode);
        NamedNode obj2 = new NamedNode(ChildKey.fromString((String)node2.getValue()), EmptyNode.Empty());
        return obj2;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public com.google.firebase.database.snapshot.NamedNode maxPost() {
        return NamedNode.getMaxNode();
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String toString() {
        return "KeyIndex";
    }
}
