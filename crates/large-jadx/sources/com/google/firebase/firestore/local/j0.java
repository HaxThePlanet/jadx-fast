package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class j0 implements Function {

    public static final com.google.firebase.firestore.local.j0 a;
    static {
        j0 j0Var = new j0();
        j0.a = j0Var;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return SQLiteLruReferenceDelegate.b((Cursor)object);
    }
}
