package com.google.firebase.database.core.view;

import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public class ViewCache {

    private final com.google.firebase.database.core.view.CacheNode eventSnap;
    private final com.google.firebase.database.core.view.CacheNode serverSnap;
    public ViewCache(com.google.firebase.database.core.view.CacheNode cacheNode, com.google.firebase.database.core.view.CacheNode cacheNode2) {
        super();
        this.eventSnap = cacheNode;
        this.serverSnap = cacheNode2;
    }

    public Node getCompleteEventSnap() {
        Node node;
        if (this.eventSnap.isFullyInitialized()) {
            node = this.eventSnap.getNode();
        } else {
            node = 0;
        }
        return node;
    }

    public Node getCompleteServerSnap() {
        Node node;
        if (this.serverSnap.isFullyInitialized()) {
            node = this.serverSnap.getNode();
        } else {
            node = 0;
        }
        return node;
    }

    public com.google.firebase.database.core.view.CacheNode getEventCache() {
        return this.eventSnap;
    }

    public com.google.firebase.database.core.view.CacheNode getServerCache() {
        return this.serverSnap;
    }

    public com.google.firebase.database.core.view.ViewCache updateEventSnap(IndexedNode indexedNode, boolean z2, boolean z3) {
        CacheNode cacheNode = new CacheNode(indexedNode, z2, z3);
        ViewCache viewCache = new ViewCache(cacheNode, this.serverSnap);
        return viewCache;
    }

    public com.google.firebase.database.core.view.ViewCache updateServerSnap(IndexedNode indexedNode, boolean z2, boolean z3) {
        CacheNode cacheNode = new CacheNode(indexedNode, z2, z3);
        ViewCache viewCache = new ViewCache(this.eventSnap, cacheNode);
        return viewCache;
    }
}
