package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class e1 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteRemoteDocumentCache a;
    public final int b;
    public final BackgroundQueue c;
    public final Query d;
    public final ImmutableSortedMap[] e;
    public e1(com.google.firebase.firestore.local.SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, int i2, BackgroundQueue backgroundQueue3, Query query4, ImmutableSortedMap[] immutableSortedMap5Arr5) {
        super();
        this.a = sQLiteRemoteDocumentCache;
        this.b = i2;
        this.c = backgroundQueue3;
        this.d = query4;
        this.e = immutableSortedMap5Arr5;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.h(this.b, this.c, this.d, this.e, (Cursor)object);
    }
}
