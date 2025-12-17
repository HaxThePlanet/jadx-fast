package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public enum o0 implements com.google.android.play.core.splitinstall.g0 {

    INSTANCE;
    @Override // java.lang.Enum
    public final com.google.android.play.core.splitinstall.h0 zza() {
        return (h0)o0.zzb.get();
    }

    @Override // java.lang.Enum
    public final void zzb(com.google.android.play.core.splitinstall.h0 h0) {
        o0.zzb.set(h0);
    }
}
