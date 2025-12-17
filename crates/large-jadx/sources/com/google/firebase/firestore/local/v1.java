package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class v1 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteTargetCache.DocumentKeysHolder a;
    public v1(com.google.firebase.firestore.local.SQLiteTargetCache.DocumentKeysHolder sQLiteTargetCache$DocumentKeysHolder) {
        super();
        this.a = documentKeysHolder;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        SQLiteTargetCache.c(this.a, (Cursor)object);
    }
}
