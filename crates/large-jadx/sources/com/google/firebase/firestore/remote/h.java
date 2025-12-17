package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
public final class h implements Runnable {

    public final com.google.firebase.firestore.remote.AndroidConnectivityMonitor a;
    public final com.google.firebase.firestore.remote.AndroidConnectivityMonitor.DefaultNetworkCallback b;
    public h(com.google.firebase.firestore.remote.AndroidConnectivityMonitor androidConnectivityMonitor, com.google.firebase.firestore.remote.AndroidConnectivityMonitor.DefaultNetworkCallback androidConnectivityMonitor$DefaultNetworkCallback2) {
        super();
        this.a = androidConnectivityMonitor;
        this.b = defaultNetworkCallback2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
