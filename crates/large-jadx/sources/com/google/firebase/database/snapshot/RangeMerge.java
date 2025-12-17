package com.google.firebase.database.snapshot;

import com.google.firebase.database.connection.RangeMerge;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class RangeMerge {

    private final Path optExclusiveStart;
    private final Path optInclusiveEnd;
    private final com.google.firebase.database.snapshot.Node snap;
    public RangeMerge(RangeMerge rangeMerge) {
        int path;
        Path path2;
        super();
        List optExclusiveStart = rangeMerge.getOptExclusiveStart();
        if (optExclusiveStart != null) {
            path2 = new Path(optExclusiveStart);
        } else {
            path2 = path;
        }
        this.optExclusiveStart = path2;
        List optInclusiveEnd = rangeMerge.getOptInclusiveEnd();
        if (optInclusiveEnd != null) {
            path = new Path(optInclusiveEnd);
        }
        this.optInclusiveEnd = path;
        this.snap = NodeUtilities.NodeFromJSON(rangeMerge.getSnap());
    }

    public RangeMerge(Path path, Path path2, com.google.firebase.database.snapshot.Node node3) {
        super();
        this.optExclusiveStart = path;
        this.optInclusiveEnd = path2;
        this.snap = node3;
    }

    private com.google.firebase.database.snapshot.Node updateRangeInNode(Path path, com.google.firebase.database.snapshot.Node node2, com.google.firebase.database.snapshot.Node node3) {
        int compareTo2;
        com.google.firebase.database.snapshot.ChildKey priorityKey;
        int i;
        com.google.firebase.database.snapshot.Node immediateChild;
        int compareTo;
        ArrayList arrayList;
        Path optExclusiveStart;
        int name;
        boolean next;
        int immediateChild4;
        int rangeInNode;
        int immediateChild2;
        Path optInclusiveEnd;
        boolean immediateChild3;
        Path optExclusiveStart2 = this.optExclusiveStart;
        i = 1;
        if (optExclusiveStart2 == null) {
            compareTo2 = i;
        } else {
            compareTo2 = path.compareTo(optExclusiveStart2);
        }
        Path optInclusiveEnd2 = this.optInclusiveEnd;
        if (optInclusiveEnd2 == null) {
            compareTo = -1;
        } else {
            compareTo = path.compareTo(optInclusiveEnd2);
        }
        optExclusiveStart = this.optExclusiveStart;
        rangeInNode = 0;
        if (optExclusiveStart != null && path.contains(optExclusiveStart)) {
            name = path.contains(optExclusiveStart) ? i : rangeInNode;
        } else {
        }
        optInclusiveEnd = this.optInclusiveEnd;
        if (optInclusiveEnd != null && path.contains(optInclusiveEnd)) {
            immediateChild2 = path.contains(optInclusiveEnd) ? i : rangeInNode;
        } else {
        }
        if (compareTo2 > 0 && compareTo < 0 && immediateChild2 == 0) {
            if (compareTo < 0) {
                if (immediateChild2 == 0) {
                    return node3;
                }
            }
        }
        if (compareTo2 > 0 && immediateChild2 != 0 && node3.isLeafNode()) {
            if (immediateChild2 != 0) {
                if (node3.isLeafNode()) {
                    return node3;
                }
            }
        }
        Utilities.hardAssert(immediateChild2);
        Utilities.hardAssert(obj8 ^= i);
        if (compareTo2 > 0 && compareTo == 0 && node2.isLeafNode()) {
            if (compareTo == 0) {
                Utilities.hardAssert(immediateChild2);
                Utilities.hardAssert(obj8 ^= i);
                if (node2.isLeafNode()) {
                    return EmptyNode.Empty();
                }
                return node2;
            }
        }
        if (name == null) {
            if (immediateChild2 != 0) {
            } else {
                if (compareTo <= 0) {
                    if (compareTo2 <= 0) {
                    } else {
                        i = rangeInNode;
                    }
                }
            }
            Utilities.hardAssert(i);
            return node2;
        }
        HashSet hashSet = new HashSet();
        Iterator iterator2 = node2.iterator();
        for (NamedNode next3 : iterator2) {
            hashSet.add(next3.getName());
        }
        Iterator iterator3 = node3.iterator();
        for (NamedNode next5 : iterator3) {
            hashSet.add(next5.getName());
        }
        arrayList = new ArrayList(size += i);
        arrayList.addAll(hashSet);
        if (node3.getPriority().isEmpty()) {
            if (!node2.getPriority().isEmpty()) {
                arrayList.add(ChildKey.getPriorityKey());
            }
        } else {
        }
        Iterator iterator = arrayList.iterator();
        immediateChild = node2;
        while (iterator.hasNext()) {
            arrayList = iterator.next();
            rangeInNode = updateRangeInNode(path.child(arrayList), node2.getImmediateChild(arrayList), node3.getImmediateChild(arrayList));
            if (rangeInNode != node2.getImmediateChild((ChildKey)arrayList)) {
            }
            immediateChild = immediateChild.updateImmediateChild(arrayList, rangeInNode);
        }
        return immediateChild;
    }

    public com.google.firebase.database.snapshot.Node applyTo(com.google.firebase.database.snapshot.Node node) {
        return updateRangeInNode(Path.getEmptyPath(), node, this.snap);
    }

    Path getEnd() {
        return this.optInclusiveEnd;
    }

    Path getStart() {
        return this.optExclusiveStart;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RangeMerge{optExclusiveStart=");
        stringBuilder.append(this.optExclusiveStart);
        stringBuilder.append(", optInclusiveEnd=");
        stringBuilder.append(this.optInclusiveEnd);
        stringBuilder.append(", snap=");
        stringBuilder.append(this.snap);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
