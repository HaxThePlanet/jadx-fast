package com.google.firebase.firestore;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class q implements c {

    public final com.google.firebase.firestore.Transaction a;
    public q(com.google.firebase.firestore.Transaction transaction) {
        super();
        this.a = transaction;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.b(j);
    }
}
