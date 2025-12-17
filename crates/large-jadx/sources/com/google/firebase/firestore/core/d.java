package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class d implements c {

    public static final com.google.firebase.firestore.core.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return FirestoreClient.i(j);
    }
}
