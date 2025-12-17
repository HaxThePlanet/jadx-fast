package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class p1 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteSchema a;
    public p1(com.google.firebase.firestore.local.SQLiteSchema sQLiteSchema) {
        super();
        this.a = sQLiteSchema;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.y((Cursor)object);
    }
}
