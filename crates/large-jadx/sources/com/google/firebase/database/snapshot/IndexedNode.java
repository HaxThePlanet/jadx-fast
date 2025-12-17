package com.google.firebase.database.snapshot;

import com.google.android.gms.common.internal.p;
import com.google.firebase.database.collection.ImmutableSortedSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class IndexedNode implements Iterable<com.google.firebase.database.snapshot.NamedNode> {

    private static final ImmutableSortedSet<com.google.firebase.database.snapshot.NamedNode> FALLBACK_INDEX;
    private final com.google.firebase.database.snapshot.Index index;
    private ImmutableSortedSet<com.google.firebase.database.snapshot.NamedNode> indexed;
    private final com.google.firebase.database.snapshot.Node node;
    static {
        ImmutableSortedSet immutableSortedSet = new ImmutableSortedSet(Collections.emptyList(), 0);
        IndexedNode.FALLBACK_INDEX = immutableSortedSet;
    }

    private IndexedNode(com.google.firebase.database.snapshot.Node node, com.google.firebase.database.snapshot.Index index2) {
        super();
        this.index = index2;
        this.node = node;
        this.indexed = 0;
    }

    private IndexedNode(com.google.firebase.database.snapshot.Node node, com.google.firebase.database.snapshot.Index index2, ImmutableSortedSet<com.google.firebase.database.snapshot.NamedNode> immutableSortedSet3) {
        super();
        this.index = index2;
        this.node = node;
        this.indexed = immutableSortedSet3;
    }

    private void ensureIndexed() {
        Object fALLBACK_INDEX;
        Object immutableSortedSet;
        com.google.firebase.database.snapshot.Index index;
        int definedOn;
        boolean next;
        com.google.firebase.database.snapshot.NamedNode namedNode;
        com.google.firebase.database.snapshot.ChildKey name;
        if (this.indexed == null) {
            if (this.index.equals(KeyIndex.getInstance())) {
                this.indexed = IndexedNode.FALLBACK_INDEX;
            } else {
                fALLBACK_INDEX = new ArrayList();
                immutableSortedSet = this.node.iterator();
                index = 0;
                definedOn = index;
                while (immutableSortedSet.hasNext()) {
                    Object next2 = immutableSortedSet.next();
                    if (definedOn == 0) {
                    } else {
                    }
                    definedOn = 1;
                    namedNode = new NamedNode((NamedNode)next2.getName(), next2.getNode());
                    fALLBACK_INDEX.add(namedNode);
                    if (this.index.isDefinedOn(next2.getNode())) {
                    } else {
                    }
                    definedOn = index;
                }
                if (definedOn != 0) {
                    immutableSortedSet = new ImmutableSortedSet(fALLBACK_INDEX, this.index);
                    this.indexed = immutableSortedSet;
                } else {
                    this.indexed = IndexedNode.FALLBACK_INDEX;
                }
            }
        }
    }

    public static com.google.firebase.database.snapshot.IndexedNode from(com.google.firebase.database.snapshot.Node node) {
        IndexedNode indexedNode = new IndexedNode(node, PriorityIndex.getInstance());
        return indexedNode;
    }

    public static com.google.firebase.database.snapshot.IndexedNode from(com.google.firebase.database.snapshot.Node node, com.google.firebase.database.snapshot.Index index2) {
        IndexedNode indexedNode = new IndexedNode(node, index2);
        return indexedNode;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.snapshot.NamedNode getFirstChild() {
        if (!node instanceof ChildrenNode) {
            return null;
        }
        ensureIndexed();
        if (p.a(this.indexed, IndexedNode.FALLBACK_INDEX)) {
            com.google.firebase.database.snapshot.ChildKey firstChildKey = (ChildrenNode)this.node.getFirstChildKey();
            NamedNode namedNode = new NamedNode(firstChildKey, this.node.getImmediateChild(firstChildKey));
            return namedNode;
        }
        return (NamedNode)this.indexed.getMinEntry();
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.snapshot.NamedNode getLastChild() {
        if (!node instanceof ChildrenNode) {
            return null;
        }
        ensureIndexed();
        if (p.a(this.indexed, IndexedNode.FALLBACK_INDEX)) {
            com.google.firebase.database.snapshot.ChildKey lastChildKey = (ChildrenNode)this.node.getLastChildKey();
            NamedNode namedNode = new NamedNode(lastChildKey, this.node.getImmediateChild(lastChildKey));
            return namedNode;
        }
        return (NamedNode)this.indexed.getMaxEntry();
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.snapshot.Node getNode() {
        return this.node;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.snapshot.ChildKey getPredecessorChildName(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2, com.google.firebase.database.snapshot.Index index3) {
        boolean equals;
        com.google.firebase.database.snapshot.ChildKey obj3;
        Object obj5;
        if (!this.index.equals(KeyIndex.getInstance())) {
            if (!this.index.equals(index3)) {
            } else {
            }
            obj3 = new IllegalArgumentException("Index not available in IndexedNode!");
            throw obj3;
        }
        ensureIndexed();
        if (p.a(this.indexed, IndexedNode.FALLBACK_INDEX)) {
            return this.node.getPredecessorChildKey(childKey);
        }
        NamedNode namedNode = new NamedNode(childKey, node2);
        obj3 = this.indexed.getPredecessorEntry(namedNode);
        if ((NamedNode)obj3 != null) {
            obj3 = (NamedNode)obj3.getName();
        } else {
            obj3 = 0;
        }
        return obj3;
    }

    @Override // java.lang.Iterable
    public boolean hasIndex(com.google.firebase.database.snapshot.Index index) {
        int obj2;
        obj2 = this.index == index ? 1 : 0;
        return obj2;
    }

    public Iterator<com.google.firebase.database.snapshot.NamedNode> iterator() {
        ensureIndexed();
        if (p.a(this.indexed, IndexedNode.FALLBACK_INDEX)) {
            return this.node.iterator();
        }
        return this.indexed.iterator();
    }

    public Iterator<com.google.firebase.database.snapshot.NamedNode> reverseIterator() {
        ensureIndexed();
        if (p.a(this.indexed, IndexedNode.FALLBACK_INDEX)) {
            return this.node.reverseIterator();
        }
        return this.indexed.reverseIterator();
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.snapshot.IndexedNode updateChild(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2) {
        boolean definedOn;
        ImmutableSortedSet indexed;
        ImmutableSortedSet remove;
        boolean namedNode;
        com.google.firebase.database.snapshot.Node immediateChild = this.node.updateImmediateChild(childKey, node2);
        ImmutableSortedSet fALLBACK_INDEX = IndexedNode.FALLBACK_INDEX;
        if (p.a(this.indexed, fALLBACK_INDEX) && !this.index.isDefinedOn(node2)) {
            if (!this.index.isDefinedOn(node2)) {
                IndexedNode obj5 = new IndexedNode(immediateChild, this.index, fALLBACK_INDEX);
                return obj5;
            }
        }
        indexed = this.indexed;
        if (indexed != null) {
            if (p.a(indexed, fALLBACK_INDEX)) {
            } else {
                NamedNode namedNode2 = new NamedNode(childKey, this.node.getImmediateChild(childKey));
                if (!node2.isEmpty()) {
                    namedNode = new NamedNode(childKey, node2);
                    remove = this.indexed.remove(namedNode2).insert(namedNode);
                }
            }
            obj5 = new IndexedNode(immediateChild, this.index, remove);
            return obj5;
        }
        obj5 = new IndexedNode(immediateChild, this.index, 0);
        return obj5;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.snapshot.IndexedNode updatePriority(com.google.firebase.database.snapshot.Node node) {
        IndexedNode indexedNode = new IndexedNode(this.node.updatePriority(node), this.index, this.indexed);
        return indexedNode;
    }
}
