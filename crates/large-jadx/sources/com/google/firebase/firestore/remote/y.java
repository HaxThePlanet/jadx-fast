package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.core.OnlineState;

/* loaded from: classes2.dex */
public final class y implements com.google.firebase.firestore.remote.OnlineStateTracker.OnlineStateCallback {

    public final com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback a;
    public y(com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback remoteStore$RemoteStoreCallback) {
        super();
        this.a = remoteStoreCallback;
    }

    @Override // com.google.firebase.firestore.remote.OnlineStateTracker$OnlineStateCallback
    public final void handleOnlineStateChange(OnlineState onlineState) {
        this.a.handleOnlineStateChange(onlineState);
    }
}
