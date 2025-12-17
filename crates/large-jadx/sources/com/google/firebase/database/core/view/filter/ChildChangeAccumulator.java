package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ChildChangeAccumulator {

    private final Map<ChildKey, Change> changeMap;
    public ChildChangeAccumulator() {
        super();
        HashMap hashMap = new HashMap();
        this.changeMap = hashMap;
    }

    public List<Change> getChanges() {
        ArrayList arrayList = new ArrayList(this.changeMap.values());
        return arrayList;
    }

    public void trackChildChange(Change change) {
        Object childRemovedChange;
        ChildKey childKey;
        Object oldIndexedNode;
        boolean indexedNode;
        int i;
        boolean priorityChildName;
        Event.EventType cHILD_CHANGED;
        Object cHILD_REMOVED;
        Object obj7;
        childRemovedChange = change.getEventType();
        childKey = change.getChildKey();
        oldIndexedNode = Event.EventType.CHILD_ADDED;
        int i2 = 1;
        if (childRemovedChange != oldIndexedNode && childRemovedChange != Event.EventType.CHILD_CHANGED) {
            if (childRemovedChange != Event.EventType.CHILD_CHANGED) {
                if (childRemovedChange == Event.EventType.CHILD_REMOVED) {
                    i = i2;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        Utilities.hardAssert(i, "Only child changes supported for tracking");
        Utilities.hardAssert(i2 ^= priorityChildName);
        if (this.changeMap.containsKey(childKey)) {
            indexedNode = this.changeMap.get(childKey);
            priorityChildName = (Change)indexedNode.getEventType();
            if (childRemovedChange == oldIndexedNode && priorityChildName == Event.EventType.CHILD_REMOVED) {
                if (priorityChildName == Event.EventType.CHILD_REMOVED) {
                    this.changeMap.put(change.getChildKey(), Change.childChangedChange(childKey, change.getIndexedNode(), indexedNode.getIndexedNode()));
                } else {
                    cHILD_REMOVED = Event.EventType.CHILD_REMOVED;
                    if (childRemovedChange == cHILD_REMOVED && priorityChildName == oldIndexedNode) {
                        if (priorityChildName == oldIndexedNode) {
                            this.changeMap.remove(childKey);
                        } else {
                            if (childRemovedChange == cHILD_REMOVED && priorityChildName == Event.EventType.CHILD_CHANGED) {
                                if (priorityChildName == Event.EventType.CHILD_CHANGED) {
                                    this.changeMap.put(childKey, Change.childRemovedChange(childKey, indexedNode.getOldIndexedNode()));
                                } else {
                                    cHILD_REMOVED = Event.EventType.CHILD_CHANGED;
                                    if (childRemovedChange == cHILD_REMOVED && priorityChildName == oldIndexedNode) {
                                        if (priorityChildName == oldIndexedNode) {
                                            this.changeMap.put(childKey, Change.childAddedChange(childKey, change.getIndexedNode()));
                                        } else {
                                            if (childRemovedChange != cHILD_REMOVED) {
                                            } else {
                                                if (priorityChildName != cHILD_REMOVED) {
                                                } else {
                                                    this.changeMap.put(childKey, Change.childChangedChange(childKey, change.getIndexedNode(), indexedNode.getOldIndexedNode()));
                                                }
                                            }
                                        }
                                    } else {
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal combination of changes: ");
            stringBuilder.append(change);
            stringBuilder.append(" occurred after ");
            stringBuilder.append(indexedNode);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        this.changeMap.put(change.getChildKey(), change);
    }
}
