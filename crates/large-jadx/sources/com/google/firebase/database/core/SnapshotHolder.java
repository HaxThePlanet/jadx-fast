package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public class SnapshotHolder {

    private Node rootNode;
    SnapshotHolder() {
        super();
        this.rootNode = EmptyNode.Empty();
    }

    public SnapshotHolder(Node node) {
        super();
        this.rootNode = node;
    }

    public Node getNode(com.google.firebase.database.core.Path path) {
        return this.rootNode.getChild(path);
    }

    public Node getRootNode() {
        return this.rootNode;
    }

    public void update(com.google.firebase.database.core.Path path, Node node2) {
        this.rootNode = this.rootNode.updateChild(path, node2);
    }
}
