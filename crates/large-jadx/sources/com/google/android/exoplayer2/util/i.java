package com.google.android.exoplayer2.util;

import android.os.Handler.Callback;
import android.os.Looper;

/* loaded from: classes2.dex */
public interface i {

    public static final com.google.android.exoplayer2.util.i a;
    static {
        j0 j0Var = new j0();
        i.a = j0Var;
    }

    public abstract long a();

    public abstract long b();

    public abstract com.google.android.exoplayer2.util.s c(Looper looper, Handler.Callback handler$Callback2);

    public abstract void d();
}
