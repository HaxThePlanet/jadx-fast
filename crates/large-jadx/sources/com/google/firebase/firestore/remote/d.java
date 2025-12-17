package com.google.firebase.firestore.remote;

import io.grpc.d1;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    public final com.google.firebase.firestore.remote.AbstractStream.StreamObserver a;
    public final d1 b;
    public d(com.google.firebase.firestore.remote.AbstractStream.StreamObserver abstractStream$StreamObserver, d1 d12) {
        super();
        this.a = streamObserver;
        this.b = d12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
