package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class j implements Callable {

    public final com.google.firebase.remoteconfig.RemoteConfigComponent a;
    public j(com.google.firebase.remoteconfig.RemoteConfigComponent remoteConfigComponent) {
        super();
        this.a = remoteConfigComponent;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.getDefault();
    }
}
