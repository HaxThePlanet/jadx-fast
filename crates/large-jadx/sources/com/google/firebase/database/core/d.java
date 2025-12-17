package com.google.firebase.database.core;

import com.google.firebase.database.core.view.QuerySpec;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class d implements Callable {

    public final com.google.firebase.database.core.SyncTree a;
    public final QuerySpec b;
    public d(com.google.firebase.database.core.SyncTree syncTree, QuerySpec querySpec2) {
        super();
        this.a = syncTree;
        this.b = querySpec2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.b(this.b);
    }
}
