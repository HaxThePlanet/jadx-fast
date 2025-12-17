package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class a0 implements e {

    public final com.google.firebase.firestore.core.TransactionRunner a;
    public final j b;
    public a0(com.google.firebase.firestore.core.TransactionRunner transactionRunner, j j2) {
        super();
        this.a = transactionRunner;
        this.b = j2;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        this.a.b(this.b, j);
    }
}
