package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class LimitedFilter implements com.google.firebase.database.core.view.filter.NodeFilter {

    private final Index index;
    private final int limit;
    private final com.google.firebase.database.core.view.filter.RangedFilter rangedFilter;
    private final boolean reverse;
    public LimitedFilter(QueryParams queryParams) {
        super();
        RangedFilter rangedFilter = new RangedFilter(queryParams);
        this.rangedFilter = rangedFilter;
        this.index = queryParams.getIndex();
        this.limit = queryParams.getLimit();
        this.reverse = obj2 ^= 1;
    }

    private IndexedNode fullLimitUpdateChild(IndexedNode indexedNode, ChildKey childKey2, Node node3, com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource nodeFilter$CompleteChildSource4, com.google.firebase.database.core.view.filter.ChildChangeAccumulator childChangeAccumulator5) {
        int i;
        Object namedNode;
        NamedNode firstChild;
        NamedNode childAfterChild;
        int reverse2;
        Index reverse3;
        boolean reverse;
        IndexedNode obj9;
        ChildKey obj10;
        Node obj11;
        int obj12;
        reverse2 = 0;
        final int i2 = 1;
        i = indexedNode.getNode().getChildCount() == this.limit ? i2 : reverse2;
        Utilities.hardAssert(i);
        namedNode = new NamedNode(childKey2, node3);
        if (this.reverse) {
            firstChild = indexedNode.getFirstChild();
        } else {
            firstChild = indexedNode.getLastChild();
        }
        boolean matches = this.rangedFilter.matches(namedNode);
        if (indexedNode.getNode().hasChild(childKey2)) {
            Node immediateChild = indexedNode.getNode().getImmediateChild(childKey2);
            childAfterChild = completeChildSource4.getChildAfterChild(this.index, firstChild, this.reverse);
            while (childAfterChild != null) {
                if (!childAfterChild.getName().equals(childKey2)) {
                } else {
                }
                childAfterChild = completeChildSource4.getChildAfterChild(this.index, childAfterChild, this.reverse);
                if (indexedNode.getNode().hasChild(childAfterChild.getName())) {
                }
            }
            if (childAfterChild == null) {
                obj12 = i2;
            } else {
                obj12 = this.index.compare(childAfterChild, namedNode, this.reverse);
            }
            if (matches && !node3.isEmpty() && obj12 >= 0) {
                if (!node3.isEmpty()) {
                    obj12 = obj12 >= 0 ? i2 : reverse2;
                } else {
                }
            } else {
            }
            if (obj12 != null && childChangeAccumulator5 != null) {
                if (childChangeAccumulator5 != null) {
                    childChangeAccumulator5.trackChildChange(Change.childChangedChange(childKey2, node3, immediateChild));
                }
                return indexedNode.updateChild(childKey2, node3);
            }
            if (childChangeAccumulator5 != null) {
                childChangeAccumulator5.trackChildChange(Change.childRemovedChange(childKey2, immediateChild));
            }
            if (childAfterChild != null && this.rangedFilter.matches(childAfterChild)) {
                if (this.rangedFilter.matches(childAfterChild)) {
                    reverse2 = i2;
                }
            }
            if (reverse2 != 0 && childChangeAccumulator5 != null) {
                if (childChangeAccumulator5 != null) {
                    childChangeAccumulator5.trackChildChange(Change.childAddedChange(childAfterChild.getName(), childAfterChild.getNode()));
                }
                obj9 = indexedNode.updateChild(childKey2, EmptyNode.Empty()).updateChild(childAfterChild.getName(), childAfterChild.getNode());
            }
            return obj9;
        }
        if (node3.isEmpty()) {
            return indexedNode;
        }
        if (matches && this.index.compare(firstChild, namedNode, this.reverse) >= 0 && childChangeAccumulator5 != null) {
            if (this.index.compare(firstChild, namedNode, this.reverse) >= 0) {
                if (childChangeAccumulator5 != null) {
                    childChangeAccumulator5.trackChildChange(Change.childRemovedChange(firstChild.getName(), firstChild.getNode()));
                    childChangeAccumulator5.trackChildChange(Change.childAddedChange(childKey2, node3));
                }
                obj9 = indexedNode.updateChild(childKey2, node3).updateChild(firstChild.getName(), EmptyNode.Empty());
            }
        }
        return obj9;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public boolean filtersNodes() {
        return 1;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public Index getIndex() {
        return this.index;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public com.google.firebase.database.core.view.filter.NodeFilter getIndexedFilter() {
        return this.rangedFilter.getIndexedFilter();
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updateChild(IndexedNode indexedNode, ChildKey childKey2, Node node3, Path path4, com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource nodeFilter$CompleteChildSource5, com.google.firebase.database.core.view.filter.ChildChangeAccumulator childChangeAccumulator6) {
        Node obj10;
        NamedNode namedNode = new NamedNode(childKey2, node3);
        if (!this.rangedFilter.matches(namedNode)) {
            obj10 = EmptyNode.Empty();
        }
        final Node node = obj10;
        if (indexedNode.getNode().getImmediateChild(childKey2).equals(node)) {
            return indexedNode;
        }
        if (indexedNode.getNode().getChildCount() < this.limit) {
            return this.rangedFilter.getIndexedFilter().updateChild(indexedNode, childKey2, node, path4, completeChildSource5, childChangeAccumulator6);
        }
        return this.fullLimitUpdateChild(indexedNode, childKey2, node, completeChildSource5, childChangeAccumulator6);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updateFullNode(IndexedNode indexedNode, IndexedNode indexedNode2, com.google.firebase.database.core.view.filter.ChildChangeAccumulator childChangeAccumulator3) {
        IndexedNode priority;
        boolean leafNode;
        NamedNode startPost;
        int i2;
        NamedNode startPost2;
        int i;
        int i3;
        int i4;
        int i5;
        boolean next;
        int limit;
        Object obj12;
        if (!indexedNode2.getNode().isLeafNode()) {
            if (indexedNode2.getNode().isEmpty()) {
                priority = IndexedNode.from(EmptyNode.Empty(), this.index);
            } else {
                priority = indexedNode2.updatePriority(PriorityUtilities.NullPriority());
                i2 = 1;
                if (this.reverse) {
                    obj12 = indexedNode2.reverseIterator();
                    startPost = this.rangedFilter.getEndPost();
                    startPost2 = this.rangedFilter.getStartPost();
                    i = -1;
                } else {
                    obj12 = indexedNode2.iterator();
                    startPost = this.rangedFilter.getStartPost();
                    startPost2 = this.rangedFilter.getEndPost();
                    i = i2;
                }
                i3 = 0;
                i5 = i4;
                while (obj12.hasNext()) {
                    next = obj12.next();
                    if (i4 == 0 && compare2 *= i <= 0) {
                    }
                    if (i4 != 0 && i5 < this.limit && compare *= i <= 0) {
                    } else {
                    }
                    limit = i3;
                    if (limit != 0) {
                    } else {
                    }
                    priority = priority.updateChild(next.getName(), EmptyNode.Empty());
                    i5++;
                    if (i5 < this.limit) {
                    } else {
                    }
                    if (compare *= i <= 0) {
                    } else {
                    }
                    limit = i2;
                    if (compare2 *= i <= 0) {
                    }
                    i4 = i2;
                }
            }
        } else {
        }
        return this.rangedFilter.getIndexedFilter().updateFullNode(indexedNode, priority, childChangeAccumulator3);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updatePriority(IndexedNode indexedNode, Node node2) {
        return indexedNode;
    }
}
