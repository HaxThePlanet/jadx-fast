package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final class w implements Consumer {

    public final com.google.firebase.firestore.remote.RemoteStore a;
    public final AsyncQueue b;
    public w(com.google.firebase.firestore.remote.RemoteStore remoteStore, AsyncQueue asyncQueue2) {
        super();
        this.a = remoteStore;
        this.b = asyncQueue2;
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public final void accept(Object object) {
        this.a.d(this.b, (ConnectivityMonitor.NetworkStatus)object);
    }
}
