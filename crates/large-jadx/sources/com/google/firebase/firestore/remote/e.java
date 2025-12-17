package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    public final com.google.firebase.firestore.remote.AbstractStream a;
    public e(com.google.firebase.firestore.remote.AbstractStream abstractStream) {
        super();
        this.a = abstractStream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d();
    }
}
