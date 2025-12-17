package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class y implements c {

    public final com.google.firebase.firestore.core.Transaction a;
    public y(com.google.firebase.firestore.core.Transaction transaction) {
        super();
        this.a = transaction;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        this.a.c(j);
        return j;
    }
}
