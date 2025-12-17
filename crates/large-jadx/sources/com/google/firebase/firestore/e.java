package com.google.firebase.firestore;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class e implements c {

    public final com.google.firebase.firestore.FirebaseFirestore a;
    public e(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore) {
        super();
        this.a = firebaseFirestore;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.g(j);
    }
}
