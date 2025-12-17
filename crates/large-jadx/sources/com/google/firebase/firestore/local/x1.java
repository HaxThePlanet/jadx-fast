package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class x1 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteTargetCache a;
    public final Consumer b;
    public x1(com.google.firebase.firestore.local.SQLiteTargetCache sQLiteTargetCache, Consumer consumer2) {
        super();
        this.a = sQLiteTargetCache;
        this.b = consumer2;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.b(this.b, (Cursor)object);
    }
}
