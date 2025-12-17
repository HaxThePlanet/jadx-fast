package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import java.util.Comparator;

/* loaded from: classes2.dex */
public abstract class Index implements Comparator<com.google.firebase.database.snapshot.NamedNode> {
    public static com.google.firebase.database.snapshot.Index fromQueryDefinition(String string) {
        if (string.equals(".value")) {
            return ValueIndex.getInstance();
        }
        if (string.equals(".key")) {
            return KeyIndex.getInstance();
        }
        if (string.equals(".priority")) {
        } else {
            Path path = new Path(string);
            PathIndex pathIndex = new PathIndex(path);
            return pathIndex;
        }
        IllegalStateException obj2 = new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
        throw obj2;
    }

    @Override // java.util.Comparator
    public int compare(com.google.firebase.database.snapshot.NamedNode namedNode, com.google.firebase.database.snapshot.NamedNode namedNode2, boolean z3) {
        if (z3) {
            return compare(namedNode2, namedNode);
        }
        return compare(namedNode, namedNode2);
    }

    @Override // java.util.Comparator
    public abstract String getQueryDefinition();

    @Override // java.util.Comparator
    public boolean indexedValueChanged(com.google.firebase.database.snapshot.Node node, com.google.firebase.database.snapshot.Node node2) {
        int obj3;
        NamedNode namedNode = new NamedNode(ChildKey.getMinName(), node);
        obj3 = new NamedNode(ChildKey.getMinName(), node2);
        obj3 = compare(namedNode, obj3) != 0 ? 1 : 0;
        return obj3;
    }

    @Override // java.util.Comparator
    public abstract boolean isDefinedOn(com.google.firebase.database.snapshot.Node node);

    @Override // java.util.Comparator
    public abstract com.google.firebase.database.snapshot.NamedNode makePost(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2);

    @Override // java.util.Comparator
    public abstract com.google.firebase.database.snapshot.NamedNode maxPost();

    @Override // java.util.Comparator
    public com.google.firebase.database.snapshot.NamedNode minPost() {
        return NamedNode.getMinNode();
    }
}
