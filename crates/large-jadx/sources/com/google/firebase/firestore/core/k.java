package com.google.firebase.firestore.core;

import android.content.Context;
import com.google.android.gms.tasks.k;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

/* loaded from: classes2.dex */
public final class k implements Runnable {

    public final com.google.firebase.firestore.core.FirestoreClient a;
    public final k b;
    public final Context c;
    public final FirebaseFirestoreSettings v;
    public k(com.google.firebase.firestore.core.FirestoreClient firestoreClient, k k2, Context context3, FirebaseFirestoreSettings firebaseFirestoreSettings4) {
        super();
        this.a = firestoreClient;
        this.b = k2;
        this.c = context3;
        this.v = firebaseFirestoreSettings4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.u(this.b, this.c, this.v);
    }
}
