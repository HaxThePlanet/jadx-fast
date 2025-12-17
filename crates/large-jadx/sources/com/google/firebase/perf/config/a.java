package com.google.firebase.perf.config;

import android.content.Context;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    public final com.google.firebase.perf.config.DeviceCacheManager a;
    public final Context b;
    public a(com.google.firebase.perf.config.DeviceCacheManager deviceCacheManager, Context context2) {
        super();
        this.a = deviceCacheManager;
        this.b = context2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
