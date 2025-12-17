package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor;
import com.google.firebase.database.snapshot.Node;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
class SparseSnapshotTree {

    private Map<ChildKey, com.google.firebase.database.core.SparseSnapshotTree> children = null;
    private Node value = null;

    public interface SparseSnapshotChildVisitor {
        public abstract void visitChild(ChildKey childKey, com.google.firebase.database.core.SparseSnapshotTree sparseSnapshotTree2);
    }

    public interface SparseSnapshotTreeVisitor {
        public abstract void visitTree(com.google.firebase.database.core.Path path, Node node2);
    }
    public SparseSnapshotTree() {
        super();
        final int i = 0;
    }

    public void forEachChild(com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotChildVisitor sparseSnapshotTree$SparseSnapshotChildVisitor) {
        Object children;
        Object value;
        Object key;
        children = this.children;
        if (children != null) {
            children = children.entrySet().iterator();
            for (Map.Entry next : children) {
                sparseSnapshotChildVisitor.visitChild((ChildKey)next.getKey(), (SparseSnapshotTree)next.getValue());
            }
        }
    }

    public void forEachTree(com.google.firebase.database.core.Path path, com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotTreeVisitor sparseSnapshotTree$SparseSnapshotTreeVisitor2) {
        Object value;
        value = this.value;
        if (value != null) {
            sparseSnapshotTreeVisitor2.visitTree(path, value);
        } else {
            value = new SparseSnapshotTree.2(this, path, sparseSnapshotTreeVisitor2);
            forEachChild(value);
        }
    }

    public boolean forget(com.google.firebase.database.core.Path path) {
        boolean key;
        com.google.firebase.database.core.Path obj6;
        int i = 1;
        final int i2 = 0;
        if (path.isEmpty()) {
            this.value = i2;
            this.children = i2;
            return i;
        }
        Node value = this.value;
        final int i3 = 0;
        if (value != null && value.isLeafNode()) {
            if (value.isLeafNode()) {
                return i3;
            }
            this.value = i2;
            SparseSnapshotTree.1 anon = new SparseSnapshotTree.1(this, path);
            (ChildrenNode)this.value.forEachChild(anon);
            return forget(path);
        }
        ChildKey front = path.getFront();
        if (this.children != null && this.children.containsKey(front) && (SparseSnapshotTree)this.children.get(front).forget(path.popFront())) {
            front = path.getFront();
            if (this.children.containsKey(front)) {
                if ((SparseSnapshotTree)this.children.get(front).forget(path.popFront())) {
                    this.children.remove(front);
                }
            }
            if (this.children.isEmpty()) {
                this.children = i2;
                return i;
            }
            return i3;
        }
        return i;
    }

    public void remember(com.google.firebase.database.core.Path path, Node node2) {
        Object hashMap;
        Node empty;
        boolean children;
        Map children2;
        com.google.firebase.database.core.SparseSnapshotTree sparseSnapshotTree;
        Node obj4;
        if (path.isEmpty()) {
            this.value = node2;
            this.children = 0;
        } else {
            empty = this.value;
            if (empty != null) {
                this.value = empty.updateChild(path, node2);
            } else {
                if (this.children == null) {
                    hashMap = new HashMap();
                    this.children = hashMap;
                }
                ChildKey front = path.getFront();
                if (!this.children.containsKey(front)) {
                    sparseSnapshotTree = new SparseSnapshotTree();
                    this.children.put(front, sparseSnapshotTree);
                }
                (SparseSnapshotTree)this.children.get(front).remember(path.popFront(), node2);
            }
        }
    }
}
