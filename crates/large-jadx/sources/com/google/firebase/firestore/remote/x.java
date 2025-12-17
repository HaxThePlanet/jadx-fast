package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
public final class x implements Runnable {

    public final com.google.firebase.firestore.remote.RemoteStore a;
    public final com.google.firebase.firestore.remote.ConnectivityMonitor.NetworkStatus b;
    public x(com.google.firebase.firestore.remote.RemoteStore remoteStore, com.google.firebase.firestore.remote.ConnectivityMonitor.NetworkStatus connectivityMonitor$NetworkStatus2) {
        super();
        this.a = remoteStore;
        this.b = networkStatus2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
