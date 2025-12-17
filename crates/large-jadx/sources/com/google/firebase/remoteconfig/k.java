package com.google.firebase.remoteconfig;

import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class k implements Provider {

    public static final com.google.firebase.remoteconfig.k a;
    static {
        k kVar = new k();
        k.a = kVar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return RemoteConfigComponent.a();
    }
}
