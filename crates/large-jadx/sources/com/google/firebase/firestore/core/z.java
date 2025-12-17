package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class z implements e {

    public final com.google.firebase.firestore.core.TransactionRunner a;
    public final com.google.firebase.firestore.core.Transaction b;
    public z(com.google.firebase.firestore.core.TransactionRunner transactionRunner, com.google.firebase.firestore.core.Transaction transaction2) {
        super();
        this.a = transactionRunner;
        this.b = transaction2;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        this.a.d(this.b, j);
    }
}
