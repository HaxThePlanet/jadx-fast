package com.google.firebase.firestore;

import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class h implements Runnable {

    public final com.google.firebase.firestore.FirebaseFirestore a;
    public final k b;
    public h(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, k k2) {
        super();
        this.a = firebaseFirestore;
        this.b = k2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e(this.b);
    }
}
