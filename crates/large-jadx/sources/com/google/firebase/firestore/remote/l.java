package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class l implements e {

    public final com.google.firebase.firestore.remote.FirestoreChannel a;
    public final k b;
    public final Object c;
    public l(com.google.firebase.firestore.remote.FirestoreChannel firestoreChannel, k k2, Object object3) {
        super();
        this.a = firestoreChannel;
        this.b = k2;
        this.c = object3;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        this.a.d(this.b, this.c, j);
    }
}
