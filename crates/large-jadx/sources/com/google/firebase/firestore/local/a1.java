package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class a1 implements Function {

    public static final com.google.firebase.firestore.local.a1 a;
    static {
        a1 a1Var = new a1();
        a1.a = a1Var;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return SQLitePersistence.a((Cursor)object);
    }
}
