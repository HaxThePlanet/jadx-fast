package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class x implements c {

    public static final com.google.firebase.firestore.core.x a;
    static {
        x xVar = new x();
        x.a = xVar;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return Transaction.a(j);
    }
}
