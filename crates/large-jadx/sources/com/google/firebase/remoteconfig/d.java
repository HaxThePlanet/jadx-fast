package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class d implements Callable {

    public final com.google.firebase.remoteconfig.FirebaseRemoteConfig a;
    public d(com.google.firebase.remoteconfig.FirebaseRemoteConfig firebaseRemoteConfig) {
        super();
        this.a = firebaseRemoteConfig;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.j();
    }
}
