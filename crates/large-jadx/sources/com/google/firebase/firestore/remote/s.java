package com.google.firebase.firestore.remote;

import io.grpc.r0;

/* loaded from: classes2.dex */
public final class s implements Runnable {

    public final com.google.firebase.firestore.remote.GrpcCallProvider a;
    public final r0 b;
    public s(com.google.firebase.firestore.remote.GrpcCallProvider grpcCallProvider, r0 r02) {
        super();
        this.a = grpcCallProvider;
        this.b = r02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h(this.b);
    }
}
