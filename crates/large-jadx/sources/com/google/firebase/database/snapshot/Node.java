package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import java.util.Iterator;

/* loaded from: classes2.dex */
public interface Node extends Comparable<com.google.firebase.database.snapshot.Node>, Iterable<com.google.firebase.database.snapshot.NamedNode> {

    public static final com.google.firebase.database.snapshot.ChildrenNode MAX_NODE;

    public static enum HashVersion {

        V1,
        V2;
    }
    static {
        Node.1 anon = new Node.1();
        Node.MAX_NODE = anon;
    }

    @Override // java.lang.Comparable
    public abstract com.google.firebase.database.snapshot.Node getChild(Path path);

    @Override // java.lang.Comparable
    public abstract int getChildCount();

    @Override // java.lang.Comparable
    public abstract String getHash();

    @Override // java.lang.Comparable
    public abstract String getHashRepresentation(com.google.firebase.database.snapshot.Node.HashVersion node$HashVersion);

    @Override // java.lang.Comparable
    public abstract com.google.firebase.database.snapshot.Node getImmediateChild(com.google.firebase.database.snapshot.ChildKey childKey);

    @Override // java.lang.Comparable
    public abstract com.google.firebase.database.snapshot.ChildKey getPredecessorChildKey(com.google.firebase.database.snapshot.ChildKey childKey);

    @Override // java.lang.Comparable
    public abstract com.google.firebase.database.snapshot.Node getPriority();

    @Override // java.lang.Comparable
    public abstract com.google.firebase.database.snapshot.ChildKey getSuccessorChildKey(com.google.firebase.database.snapshot.ChildKey childKey);

    @Override // java.lang.Comparable
    public abstract Object getValue();

    @Override // java.lang.Comparable
    public abstract Object getValue(boolean z);

    @Override // java.lang.Comparable
    public abstract boolean hasChild(com.google.firebase.database.snapshot.ChildKey childKey);

    @Override // java.lang.Comparable
    public abstract boolean isEmpty();

    @Override // java.lang.Comparable
    public abstract boolean isLeafNode();

    public abstract Iterator<com.google.firebase.database.snapshot.NamedNode> reverseIterator();

    @Override // java.lang.Comparable
    public abstract com.google.firebase.database.snapshot.Node updateChild(Path path, com.google.firebase.database.snapshot.Node node2);

    @Override // java.lang.Comparable
    public abstract com.google.firebase.database.snapshot.Node updateImmediateChild(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2);

    @Override // java.lang.Comparable
    public abstract com.google.firebase.database.snapshot.Node updatePriority(com.google.firebase.database.snapshot.Node node);
}
