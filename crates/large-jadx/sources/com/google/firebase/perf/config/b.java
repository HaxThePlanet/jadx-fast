package com.google.firebase.perf.config;

import com.google.android.gms.tasks.g;

/* loaded from: classes2.dex */
public final class b implements g {

    public final com.google.firebase.perf.config.RemoteConfigManager a;
    public b(com.google.firebase.perf.config.RemoteConfigManager remoteConfigManager) {
        super();
        this.a = remoteConfigManager;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.b((Boolean)object);
    }
}
