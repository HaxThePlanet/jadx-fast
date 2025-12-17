package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final com.google.firebase.firestore.remote.AbstractStream.StreamObserver a;
    public b(com.google.firebase.firestore.remote.AbstractStream.StreamObserver abstractStream$StreamObserver) {
        super();
        this.a = streamObserver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h();
    }
}
