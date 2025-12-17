package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.Path;
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
public class RangedFilter implements com.google.firebase.database.core.view.filter.NodeFilter {

    private final NamedNode endPost;
    private final Index index;
    private final com.google.firebase.database.core.view.filter.IndexedFilter indexedFilter;
    private final NamedNode startPost;
    public RangedFilter(QueryParams queryParams) {
        super();
        IndexedFilter indexedFilter = new IndexedFilter(queryParams.getIndex());
        this.indexedFilter = indexedFilter;
        this.index = queryParams.getIndex();
        this.startPost = RangedFilter.getStartPost(queryParams);
        this.endPost = RangedFilter.getEndPost(queryParams);
    }

    private static NamedNode getEndPost(QueryParams queryParams) {
        if (queryParams.hasEnd()) {
            return queryParams.getIndex().makePost(queryParams.getIndexEndName(), queryParams.getIndexEndValue());
        }
        return queryParams.getIndex().maxPost();
    }

    private static NamedNode getStartPost(QueryParams queryParams) {
        if (queryParams.hasStart()) {
            return queryParams.getIndex().makePost(queryParams.getIndexStartName(), queryParams.getIndexStartValue());
        }
        return queryParams.getIndex().minPost();
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public boolean filtersNodes() {
        return 1;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public NamedNode getEndPost() {
        return this.endPost;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public Index getIndex() {
        return this.index;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public com.google.firebase.database.core.view.filter.NodeFilter getIndexedFilter() {
        return this.indexedFilter;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public NamedNode getStartPost() {
        return this.startPost;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public boolean matches(NamedNode namedNode) {
        int compare;
        NamedNode startPost;
        Object obj3;
        if (this.index.compare(getStartPost(), namedNode) <= 0 && this.index.compare(namedNode, getEndPost()) <= 0) {
            if (this.index.compare(namedNode, getEndPost()) <= 0) {
                return 1;
            }
        }
        return 0;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updateChild(IndexedNode indexedNode, ChildKey childKey2, Node node3, Path path4, com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource nodeFilter$CompleteChildSource5, com.google.firebase.database.core.view.filter.ChildChangeAccumulator childChangeAccumulator6) {
        Node obj10;
        NamedNode namedNode = new NamedNode(childKey2, node3);
        if (!matches(namedNode)) {
            obj10 = EmptyNode.Empty();
        }
        return this.indexedFilter.updateChild(indexedNode, childKey2, obj10, path4, completeChildSource5, childChangeAccumulator6);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updateFullNode(IndexedNode indexedNode, IndexedNode indexedNode2, com.google.firebase.database.core.view.filter.ChildChangeAccumulator childChangeAccumulator3) {
        Object priority;
        boolean next;
        boolean matches;
        IndexedNode obj5;
        if (indexedNode2.getNode().isLeafNode()) {
            obj5 = IndexedNode.from(EmptyNode.Empty(), this.index);
        } else {
            priority = indexedNode2.updatePriority(PriorityUtilities.NullPriority());
            obj5 = indexedNode2.iterator();
            while (obj5.hasNext()) {
                next = obj5.next();
                if (!matches((NamedNode)next)) {
                }
                priority = priority.updateChild(next.getName(), EmptyNode.Empty());
            }
            obj5 = priority;
        }
        return this.indexedFilter.updateFullNode(indexedNode, obj5, childChangeAccumulator3);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updatePriority(IndexedNode indexedNode, Node node2) {
        return indexedNode;
    }
}
