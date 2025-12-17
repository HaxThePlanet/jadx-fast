package com.google.firebase.firestore.remote;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class r implements Callable {

    public final com.google.firebase.firestore.remote.GrpcCallProvider a;
    public r(com.google.firebase.firestore.remote.GrpcCallProvider grpcCallProvider) {
        super();
        this.a = grpcCallProvider;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.f();
    }
}
