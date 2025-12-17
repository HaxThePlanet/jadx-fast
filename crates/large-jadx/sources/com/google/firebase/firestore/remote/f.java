package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    public final com.google.firebase.firestore.remote.AbstractStream a;
    public f(com.google.firebase.firestore.remote.AbstractStream abstractStream) {
        super();
        this.a = abstractStream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
