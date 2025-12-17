package com.google.android.gms.common.util;

import android.os.SystemClock;
import androidx.annotation.RecentlyNonNull;

/* loaded from: classes2.dex */
public class h implements com.google.android.gms.common.util.e {

    private static final com.google.android.gms.common.util.h a;
    static {
        h hVar = new h();
        h.a = hVar;
    }

    public static com.google.android.gms.common.util.e b() {
        return h.a;
    }

    @Override // com.google.android.gms.common.util.e
    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.e
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.e
    public final long nanoTime() {
        return System.nanoTime();
    }
}
