package com.google.firebase.perf.config;

import com.google.android.gms.tasks.f;

/* loaded from: classes2.dex */
public final class c implements f {

    public final com.google.firebase.perf.config.RemoteConfigManager a;
    public c(com.google.firebase.perf.config.RemoteConfigManager remoteConfigManager) {
        super();
        this.a = remoteConfigManager;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        this.a.d(exception);
    }
}
