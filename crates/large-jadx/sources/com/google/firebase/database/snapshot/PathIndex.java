package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;

/* loaded from: classes2.dex */
public final class PathIndex extends com.google.firebase.database.snapshot.Index {

    private final Path indexPath;
    public PathIndex(Path path) {
        int priorityChildName;
        super();
        if (path.size() == 1) {
            if (path.getFront().isPriorityChildName()) {
            } else {
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
            throw obj3;
        }
        this.indexPath = path;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int compare(com.google.firebase.database.snapshot.NamedNode namedNode, com.google.firebase.database.snapshot.NamedNode namedNode2) {
        int compareTo = namedNode.getNode().getChild(this.indexPath).compareTo(namedNode2.getNode().getChild(this.indexPath));
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
        Class<com.google.firebase.database.snapshot.PathIndex> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (PathIndex.class != object.getClass()) {
            } else {
                if (!this.indexPath.equals(object.indexPath)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String getQueryDefinition() {
        return this.indexPath.wireFormat();
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int hashCode() {
        return this.indexPath.hashCode();
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean isDefinedOn(com.google.firebase.database.snapshot.Node node) {
        return obj2 ^= 1;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public com.google.firebase.database.snapshot.NamedNode makePost(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2) {
        NamedNode namedNode = new NamedNode(childKey, EmptyNode.Empty().updateChild(this.indexPath, node2));
        return namedNode;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public com.google.firebase.database.snapshot.NamedNode maxPost() {
        NamedNode namedNode = new NamedNode(ChildKey.getMaxName(), EmptyNode.Empty().updateChild(this.indexPath, Node.MAX_NODE));
        return namedNode;
    }
}
