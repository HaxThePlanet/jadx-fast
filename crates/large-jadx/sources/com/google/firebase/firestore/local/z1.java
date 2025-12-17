package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class z1 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteTargetCache a;
    public z1(com.google.firebase.firestore.local.SQLiteTargetCache sQLiteTargetCache) {
        super();
        this.a = sQLiteTargetCache;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.i((Cursor)object);
    }
}
