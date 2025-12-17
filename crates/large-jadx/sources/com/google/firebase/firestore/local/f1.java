package com.google.firebase.firestore.local;

/* loaded from: classes2.dex */
public final class f1 implements Runnable {

    public final com.google.firebase.firestore.local.SQLiteSchema a;
    public f1(com.google.firebase.firestore.local.SQLiteSchema sQLiteSchema) {
        super();
        this.a = sQLiteSchema;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.j();
    }
}
