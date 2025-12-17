package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class h1 implements Function {

    public static final com.google.firebase.firestore.local.h1 a;
    static {
        h1 h1Var = new h1();
        h1.a = h1Var;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return SQLiteSchema.t((Cursor)object);
    }
}
