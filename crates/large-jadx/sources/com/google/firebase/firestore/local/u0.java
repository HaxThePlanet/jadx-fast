package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class u0 implements Function {

    public static final com.google.firebase.firestore.local.u0 a;
    static {
        u0 u0Var = new u0();
        u0.a = u0Var;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return SQLiteMutationQueue.j((Cursor)object);
    }
}
