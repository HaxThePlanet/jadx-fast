package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final com.google.firebase.firestore.remote.AbstractStream.StreamObserver a;
    public final Object b;
    public c(com.google.firebase.firestore.remote.AbstractStream.StreamObserver abstractStream$StreamObserver, Object object2) {
        super();
        this.a = streamObserver;
        this.b = object2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f(this.b);
    }
}
