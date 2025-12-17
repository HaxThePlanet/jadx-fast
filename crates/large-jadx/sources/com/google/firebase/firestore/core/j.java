package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.k;
import java.util.List;

/* loaded from: classes2.dex */
public final class j implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final List b;
    public final k c;
    public j(com.google.firebase.firestore.core.FirestoreClient firestoreClient, List list2, k k3) {
        super();
        this.a = firestoreClient;
        this.b = list2;
        this.c = k3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.L(this.b, this.c);
    }
}
