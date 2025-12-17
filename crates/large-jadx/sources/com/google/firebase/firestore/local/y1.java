package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class y1 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteTargetCache a;
    public final SparseArray b;
    public final int[] c;
    public y1(com.google.firebase.firestore.local.SQLiteTargetCache sQLiteTargetCache, SparseArray sparseArray2, int[] i3Arr3) {
        super();
        this.a = sQLiteTargetCache;
        this.b = sparseArray2;
        this.c = i3Arr3;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.g(this.b, this.c, (Cursor)object);
    }
}
