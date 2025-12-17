package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class s1 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteSchema a;
    public final String b;
    public s1(com.google.firebase.firestore.local.SQLiteSchema sQLiteSchema, String string2) {
        super();
        this.a = sQLiteSchema;
        this.b = string2;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.w(this.b, (Cursor)object);
    }
}
