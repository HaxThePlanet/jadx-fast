package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import io.grpc.c.a;

/* loaded from: classes2.dex */
public final class k implements e {

    public final j a;
    public final c.a b;
    public final j c;
    public k(j j, c.a c$a2, j j3) {
        super();
        this.a = j;
        this.b = a2;
        this.c = j3;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        FirestoreCallCredentials.a(this.a, this.b, this.c, j);
    }
}
