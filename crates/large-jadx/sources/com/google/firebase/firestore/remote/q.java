package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import io.grpc.u0;

/* loaded from: classes2.dex */
public final class q implements c {

    public final com.google.firebase.firestore.remote.GrpcCallProvider a;
    public final u0 b;
    public q(com.google.firebase.firestore.remote.GrpcCallProvider grpcCallProvider, u0 u02) {
        super();
        this.a = grpcCallProvider;
        this.b = u02;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.b(this.b, j);
    }
}
