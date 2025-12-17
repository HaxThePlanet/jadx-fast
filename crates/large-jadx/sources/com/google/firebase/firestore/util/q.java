package com.google.firebase.firestore.util;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class q implements c {

    public static final com.google.firebase.firestore.util.q a;
    static {
        q qVar = new q();
        q.a = qVar;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return Util.b(j);
    }
}
