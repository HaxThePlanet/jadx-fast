package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class l0 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteLruReferenceDelegate a;
    public final int[] b;
    public l0(com.google.firebase.firestore.local.SQLiteLruReferenceDelegate sQLiteLruReferenceDelegate, int[] i2Arr2) {
        super();
        this.a = sQLiteLruReferenceDelegate;
        this.b = i2Arr2;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.d(this.b, (Cursor)object);
    }
}
