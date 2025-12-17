package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    public final com.google.firebase.firestore.remote.AndroidConnectivityMonitor a;
    public final com.google.firebase.firestore.remote.AndroidConnectivityMonitor.NetworkReceiver b;
    public g(com.google.firebase.firestore.remote.AndroidConnectivityMonitor androidConnectivityMonitor, com.google.firebase.firestore.remote.AndroidConnectivityMonitor.NetworkReceiver androidConnectivityMonitor$NetworkReceiver2) {
        super();
        this.a = androidConnectivityMonitor;
        this.b = networkReceiver2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b);
    }
}
