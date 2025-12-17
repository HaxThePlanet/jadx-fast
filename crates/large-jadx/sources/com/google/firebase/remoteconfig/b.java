package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class b implements Callable {

    public final com.google.firebase.remoteconfig.FirebaseRemoteConfig a;
    public final com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings b;
    public b(com.google.firebase.remoteconfig.FirebaseRemoteConfig firebaseRemoteConfig, com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings firebaseRemoteConfigSettings2) {
        super();
        this.a = firebaseRemoteConfig;
        this.b = firebaseRemoteConfigSettings2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.l(this.b);
    }
}
