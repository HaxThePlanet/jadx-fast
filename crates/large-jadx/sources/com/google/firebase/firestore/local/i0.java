package com.google.firebase.firestore.local;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class i0 implements Comparator {

    public static final com.google.firebase.firestore.local.i0 a;
    static {
        i0 i0Var = new i0();
        i0.a = i0Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return SQLiteIndexManager.j((FieldIndex)object, (FieldIndex)object2);
    }
}
