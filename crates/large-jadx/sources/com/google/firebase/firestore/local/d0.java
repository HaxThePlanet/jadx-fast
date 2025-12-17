package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class d0 implements Function {

    public static final com.google.firebase.firestore.local.d0 a;
    static {
        d0 d0Var = new d0();
        d0.a = d0Var;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return SQLiteIndexManager.a((Cursor)object);
    }
}
