package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;

/* loaded from: classes2.dex */
public final class d1 implements Runnable {

    public final com.google.firebase.firestore.local.SQLiteRemoteDocumentCache a;
    public final byte[] b;
    public final Query c;
    public final ImmutableSortedMap[] v;
    public d1(com.google.firebase.firestore.local.SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, byte[] b2Arr2, Query query3, ImmutableSortedMap[] immutableSortedMap4Arr4) {
        super();
        this.a = sQLiteRemoteDocumentCache;
        this.b = b2Arr2;
        this.c = query3;
        this.v = immutableSortedMap4Arr4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f(this.b, this.c, this.v);
    }
}
