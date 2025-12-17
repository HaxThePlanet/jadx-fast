package com.google.firebase.firestore.remote;

import io.grpc.t0;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    public final com.google.firebase.firestore.remote.AbstractStream.StreamObserver a;
    public final t0 b;
    public a(com.google.firebase.firestore.remote.AbstractStream.StreamObserver abstractStream$StreamObserver, t0 t02) {
        super();
        this.a = streamObserver;
        this.b = t02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b);
    }
}
