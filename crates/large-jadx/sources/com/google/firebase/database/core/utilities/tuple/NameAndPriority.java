package com.google.firebase.database.core.utilities.tuple;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;

/* loaded from: classes2.dex */
public class NameAndPriority implements Comparable<com.google.firebase.database.core.utilities.tuple.NameAndPriority> {

    private ChildKey name;
    private Node priority;
    public NameAndPriority(ChildKey childKey, Node node2) {
        super();
        this.name = childKey;
        this.priority = node2;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.firebase.database.core.utilities.tuple.NameAndPriority nameAndPriority) {
        return NodeUtilities.nameAndPriorityCompare(this.name, this.priority, nameAndPriority.name, nameAndPriority.priority);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((NameAndPriority)object);
    }

    @Override // java.lang.Comparable
    public ChildKey getName() {
        return this.name;
    }

    @Override // java.lang.Comparable
    public Node getPriority() {
        return this.priority;
    }
}
