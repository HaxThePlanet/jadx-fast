package com.google.firebase.database.core.view;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public class Change {

    private final ChildKey childKey;
    private final com.google.firebase.database.core.view.Event.EventType eventType;
    private final IndexedNode indexedNode;
    private final IndexedNode oldIndexedNode;
    private final ChildKey prevName;
    private Change(com.google.firebase.database.core.view.Event.EventType event$EventType, IndexedNode indexedNode2, ChildKey childKey3, ChildKey childKey4, IndexedNode indexedNode5) {
        super();
        this.eventType = eventType;
        this.indexedNode = indexedNode2;
        this.childKey = childKey3;
        this.prevName = childKey4;
        this.oldIndexedNode = indexedNode5;
    }

    public static com.google.firebase.database.core.view.Change childAddedChange(ChildKey childKey, IndexedNode indexedNode2) {
        super(Event.EventType.CHILD_ADDED, indexedNode2, childKey, 0, 0);
        return change2;
    }

    public static com.google.firebase.database.core.view.Change childAddedChange(ChildKey childKey, Node node2) {
        return Change.childAddedChange(childKey, IndexedNode.from(node2));
    }

    public static com.google.firebase.database.core.view.Change childChangedChange(ChildKey childKey, IndexedNode indexedNode2, IndexedNode indexedNode3) {
        super(Event.EventType.CHILD_CHANGED, indexedNode2, childKey, 0, indexedNode3);
        return change2;
    }

    public static com.google.firebase.database.core.view.Change childChangedChange(ChildKey childKey, Node node2, Node node3) {
        return Change.childChangedChange(childKey, IndexedNode.from(node2), IndexedNode.from(node3));
    }

    public static com.google.firebase.database.core.view.Change childMovedChange(ChildKey childKey, IndexedNode indexedNode2) {
        super(Event.EventType.CHILD_MOVED, indexedNode2, childKey, 0, 0);
        return change2;
    }

    public static com.google.firebase.database.core.view.Change childMovedChange(ChildKey childKey, Node node2) {
        return Change.childMovedChange(childKey, IndexedNode.from(node2));
    }

    public static com.google.firebase.database.core.view.Change childRemovedChange(ChildKey childKey, IndexedNode indexedNode2) {
        super(Event.EventType.CHILD_REMOVED, indexedNode2, childKey, 0, 0);
        return change2;
    }

    public static com.google.firebase.database.core.view.Change childRemovedChange(ChildKey childKey, Node node2) {
        return Change.childRemovedChange(childKey, IndexedNode.from(node2));
    }

    public static com.google.firebase.database.core.view.Change valueChange(IndexedNode indexedNode) {
        super(Event.EventType.VALUE, indexedNode, 0, 0, 0);
        return change2;
    }

    public com.google.firebase.database.core.view.Change changeWithPrevName(ChildKey childKey) {
        super(this.eventType, this.indexedNode, this.childKey, childKey, this.oldIndexedNode);
        return change2;
    }

    public ChildKey getChildKey() {
        return this.childKey;
    }

    public com.google.firebase.database.core.view.Event.EventType getEventType() {
        return this.eventType;
    }

    public IndexedNode getIndexedNode() {
        return this.indexedNode;
    }

    public IndexedNode getOldIndexedNode() {
        return this.oldIndexedNode;
    }

    public ChildKey getPrevName() {
        return this.prevName;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Change: ");
        stringBuilder.append(this.eventType);
        stringBuilder.append(" ");
        stringBuilder.append(this.childKey);
        return stringBuilder.toString();
    }
}
