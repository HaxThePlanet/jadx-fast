package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public class CacheNode {

    private final boolean filtered;
    private final boolean fullyInitialized;
    private final IndexedNode indexedNode;
    public CacheNode(IndexedNode indexedNode, boolean z2, boolean z3) {
        super();
        this.indexedNode = indexedNode;
        this.fullyInitialized = z2;
        this.filtered = z3;
    }

    public IndexedNode getIndexedNode() {
        return this.indexedNode;
    }

    public Node getNode() {
        return this.indexedNode.getNode();
    }

    public boolean isCompleteForChild(ChildKey childKey) {
        boolean fullyInitialized;
        ChildKey obj2;
        if (isFullyInitialized()) {
            if (this.filtered) {
                obj2 = this.indexedNode.getNode().hasChild(childKey) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    public boolean isCompleteForPath(Path path) {
        int obj2;
        if (path.isEmpty()) {
            if (isFullyInitialized() && !this.filtered) {
                obj2 = !this.filtered ? 1 : 0;
            } else {
            }
            return obj2;
        }
        return isCompleteForChild(path.getFront());
    }

    public boolean isFiltered() {
        return this.filtered;
    }

    public boolean isFullyInitialized() {
        return this.fullyInitialized;
    }
}
