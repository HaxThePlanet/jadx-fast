package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
public final class v implements Runnable {

    public final com.google.firebase.firestore.remote.OnlineStateTracker a;
    public v(com.google.firebase.firestore.remote.OnlineStateTracker onlineStateTracker) {
        super();
        this.a = onlineStateTracker;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
