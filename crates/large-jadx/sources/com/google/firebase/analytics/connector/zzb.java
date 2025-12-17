package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzb implements Executor {

    public static final com.google.firebase.analytics.connector.zzb zza;
    static {
        zzb zzb = new zzb();
        zzb.zza = zzb;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
