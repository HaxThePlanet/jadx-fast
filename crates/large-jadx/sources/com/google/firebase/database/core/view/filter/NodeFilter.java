package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public interface NodeFilter {

    public interface CompleteChildSource {
        public abstract NamedNode getChildAfterChild(Index index, NamedNode namedNode2, boolean z3);

        public abstract Node getCompleteChild(ChildKey childKey);
    }
    public abstract boolean filtersNodes();

    public abstract Index getIndex();

    public abstract com.google.firebase.database.core.view.filter.NodeFilter getIndexedFilter();

    public abstract IndexedNode updateChild(IndexedNode indexedNode, ChildKey childKey2, Node node3, Path path4, com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource nodeFilter$CompleteChildSource5, com.google.firebase.database.core.view.filter.ChildChangeAccumulator childChangeAccumulator6);

    public abstract IndexedNode updateFullNode(IndexedNode indexedNode, IndexedNode indexedNode2, com.google.firebase.database.core.view.filter.ChildChangeAccumulator childChangeAccumulator3);

    public abstract IndexedNode updatePriority(IndexedNode indexedNode, Node node2);
}
