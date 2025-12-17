package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.firebase-auth-api.v9;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbj implements Executor {

    private static final com.google.firebase.auth.internal.zzbj zza;
    private final Handler zzb;
    static {
        zzbj zzbj = new zzbj();
        zzbj.zza = zzbj;
    }

    private zzbj() {
        super();
        v9 v9Var = new v9(Looper.getMainLooper());
        this.zzb = v9Var;
    }

    public static com.google.firebase.auth.internal.zzbj zza() {
        return zzbj.zza;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zzb.post(runnable);
    }
}
