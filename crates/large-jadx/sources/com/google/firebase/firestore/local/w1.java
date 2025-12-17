package com.google.firebase.firestore.local;

import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class w1 implements Consumer {

    public final com.google.firebase.firestore.local.SQLiteTargetCache a;
    public final Target b;
    public final com.google.firebase.firestore.local.SQLiteTargetCache.TargetDataHolder c;
    public w1(com.google.firebase.firestore.local.SQLiteTargetCache sQLiteTargetCache, Target target2, com.google.firebase.firestore.local.SQLiteTargetCache.TargetDataHolder sQLiteTargetCache$TargetDataHolder3) {
        super();
        this.a = sQLiteTargetCache;
        this.b = target2;
        this.c = targetDataHolder3;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.e(this.b, this.c, (Cursor)object);
    }
}
