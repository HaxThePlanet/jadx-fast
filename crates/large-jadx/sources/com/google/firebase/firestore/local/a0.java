package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class a0 implements Function {

    public final com.google.firebase.firestore.local.SQLiteBundleCache a;
    public final String b;
    public a0(com.google.firebase.firestore.local.SQLiteBundleCache sQLiteBundleCache, String string2) {
        super();
        this.a = sQLiteBundleCache;
        this.b = string2;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return this.a.c(this.b, (Cursor)object);
    }
}
