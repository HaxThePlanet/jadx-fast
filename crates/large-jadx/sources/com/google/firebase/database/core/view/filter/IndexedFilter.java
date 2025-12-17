package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class IndexedFilter implements com.google.firebase.database.core.view.filter.NodeFilter {

    private final Index index;
    public IndexedFilter(Index index) {
        super();
        this.index = index;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public boolean filtersNodes() {
        return 0;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public Index getIndex() {
        return this.index;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public com.google.firebase.database.core.view.filter.NodeFilter getIndexedFilter() {
        return this;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updateChild(IndexedNode indexedNode, ChildKey childKey2, Node node3, Path path4, com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource nodeFilter$CompleteChildSource5, com.google.firebase.database.core.view.filter.ChildChangeAccumulator childChangeAccumulator6) {
        Node child;
        boolean obj6;
        String obj8;
        Utilities.hardAssert(indexedNode.hasIndex(this.index), "The index must match the filter");
        Node obj7 = indexedNode.getNode();
        Node immediateChild = obj7.getImmediateChild(childKey2);
        if (immediateChild.getChild(path4).equals(node3.getChild(path4)) && immediateChild.isEmpty() == node3.isEmpty()) {
            if (immediateChild.isEmpty() == node3.isEmpty()) {
                return indexedNode;
            }
        }
        if (childChangeAccumulator6 != null) {
            if (node3.isEmpty()) {
                if (obj7.hasChild(childKey2)) {
                    childChangeAccumulator6.trackChildChange(Change.childRemovedChange(childKey2, immediateChild));
                } else {
                    Utilities.hardAssert(obj7.isLeafNode(), "A child remove without an old child only makes sense on a leaf node");
                }
            } else {
                if (immediateChild.isEmpty()) {
                    childChangeAccumulator6.trackChildChange(Change.childAddedChange(childKey2, node3));
                } else {
                    childChangeAccumulator6.trackChildChange(Change.childChangedChange(childKey2, node3, immediateChild));
                }
            }
        }
        if (obj7.isLeafNode() && node3.isEmpty()) {
            if (node3.isEmpty()) {
                return indexedNode;
            }
        }
        return indexedNode.updateChild(childKey2, node3);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updateFullNode(IndexedNode indexedNode, IndexedNode indexedNode2, com.google.firebase.database.core.view.filter.ChildChangeAccumulator childChangeAccumulator3) {
        boolean leafNode;
        String childRemovedChange;
        boolean immediateChild;
        ChildKey equals;
        Utilities.hardAssert(indexedNode2.hasIndex(this.index), "Can't use IndexedNode that doesn't have filter's index");
        if (childChangeAccumulator3 != null) {
            Iterator iterator = indexedNode.getNode().iterator();
            while (iterator.hasNext()) {
                childRemovedChange = iterator.next();
                if (!indexedNode2.getNode().hasChild((NamedNode)childRemovedChange.getName())) {
                }
                childChangeAccumulator3.trackChildChange(Change.childRemovedChange(childRemovedChange.getName(), childRemovedChange.getNode()));
            }
            if (!indexedNode2.getNode().isLeafNode()) {
                leafNode = indexedNode2.getNode().iterator();
                while (leafNode.hasNext()) {
                    childRemovedChange = leafNode.next();
                    if (indexedNode.getNode().hasChild((NamedNode)childRemovedChange.getName())) {
                    } else {
                    }
                    childChangeAccumulator3.trackChildChange(Change.childAddedChange(childRemovedChange.getName(), childRemovedChange.getNode()));
                    immediateChild = indexedNode.getNode().getImmediateChild(childRemovedChange.getName());
                    if (!immediateChild.equals(childRemovedChange.getNode())) {
                    }
                    childChangeAccumulator3.trackChildChange(Change.childChangedChange(childRemovedChange.getName(), childRemovedChange.getNode(), immediateChild));
                }
            }
        }
        return indexedNode2;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updatePriority(IndexedNode indexedNode, Node node2) {
        if (indexedNode.getNode().isEmpty()) {
            return indexedNode;
        }
        return indexedNode.updatePriority(node2);
    }
}
