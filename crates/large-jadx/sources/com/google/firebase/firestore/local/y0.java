package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class y0 implements Function {

    public static final com.google.firebase.firestore.local.y0 a;
    static {
        y0 y0Var = new y0();
        y0.a = y0Var;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return SQLitePersistence.b((Cursor)object);
    }
}
