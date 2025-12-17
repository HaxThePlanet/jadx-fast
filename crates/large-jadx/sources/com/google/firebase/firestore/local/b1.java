package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class b1 implements Function {

    public final com.google.firebase.firestore.local.SQLiteRemoteDocumentCache a;
    public b1(com.google.firebase.firestore.local.SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache) {
        super();
        this.a = sQLiteRemoteDocumentCache;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return this.a.b((Cursor)object);
    }
}
