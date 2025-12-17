package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public class j0 implements com.google.android.exoplayer2.util.i {
    @Override // com.google.android.exoplayer2.util.i
    public long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.util.i
    public long b() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.google.android.exoplayer2.util.i
    public com.google.android.exoplayer2.util.s c(Looper looper, Handler.Callback handler$Callback2) {
        Handler handler = new Handler(looper, callback2);
        k0 k0Var = new k0(handler);
        return k0Var;
    }

    @Override // com.google.android.exoplayer2.util.i
    public void d() {
    }
}
