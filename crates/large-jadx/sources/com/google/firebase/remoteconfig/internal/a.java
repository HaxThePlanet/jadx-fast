package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class a implements Callable {

    public final com.google.firebase.remoteconfig.internal.ConfigCacheClient a;
    public final com.google.firebase.remoteconfig.internal.ConfigContainer b;
    public a(com.google.firebase.remoteconfig.internal.ConfigCacheClient configCacheClient, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer2) {
        super();
        this.a = configCacheClient;
        this.b = configContainer2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.b(this.b);
    }
}
