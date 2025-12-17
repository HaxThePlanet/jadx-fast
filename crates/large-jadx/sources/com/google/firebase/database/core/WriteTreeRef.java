package com.google.firebase.database.core;

import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class WriteTreeRef {

    private final com.google.firebase.database.core.Path treePath;
    private final com.google.firebase.database.core.WriteTree writeTree;
    public WriteTreeRef(com.google.firebase.database.core.Path path, com.google.firebase.database.core.WriteTree writeTree2) {
        super();
        this.treePath = path;
        this.writeTree = writeTree2;
    }

    public Node calcCompleteChild(ChildKey childKey, CacheNode cacheNode2) {
        return this.writeTree.calcCompleteChild(this.treePath, childKey, cacheNode2);
    }

    public Node calcCompleteEventCache(Node node) {
        return calcCompleteEventCache(node, Collections.emptyList());
    }

    public Node calcCompleteEventCache(Node node, List<Long> list2) {
        return calcCompleteEventCache(node, list2, false);
    }

    public Node calcCompleteEventCache(Node node, List<Long> list2, boolean z3) {
        return this.writeTree.calcCompleteEventCache(this.treePath, node, list2, z3);
    }

    public Node calcCompleteEventChildren(Node node) {
        return this.writeTree.calcCompleteEventChildren(this.treePath, node);
    }

    public Node calcEventCacheAfterServerOverwrite(com.google.firebase.database.core.Path path, Node node2, Node node3) {
        return this.writeTree.calcEventCacheAfterServerOverwrite(this.treePath, path, node2, node3);
    }

    public NamedNode calcNextNodeAfterPost(Node node, NamedNode namedNode2, boolean z3, Index index4) {
        return this.writeTree.calcNextNodeAfterPost(this.treePath, node, namedNode2, z3, index4);
    }

    public com.google.firebase.database.core.WriteTreeRef child(ChildKey childKey) {
        WriteTreeRef writeTreeRef = new WriteTreeRef(this.treePath.child(childKey), this.writeTree);
        return writeTreeRef;
    }

    public Node shadowingWrite(com.google.firebase.database.core.Path path) {
        return this.writeTree.shadowingWrite(this.treePath.child(path));
    }
}
