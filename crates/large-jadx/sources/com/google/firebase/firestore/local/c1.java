package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c1 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteRemoteDocumentCache a;
    public final Map b;
    public c1(com.google.firebase.firestore.local.SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, Map map2) {
        super();
        this.a = sQLiteRemoteDocumentCache;
        this.b = map2;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.d(this.b, (Cursor)object);
    }
}
