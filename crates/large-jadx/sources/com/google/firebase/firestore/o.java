package com.google.firebase.firestore;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class o implements c {

    public final com.google.firebase.firestore.Query a;
    public o(com.google.firebase.firestore.Query query) {
        super();
        this.a = query;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.d(j);
    }
}
