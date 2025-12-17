package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class u3 implements Runnable {

    private final com.google.android.gms.measurement.internal.s3 a;
    private final int b;
    private final Throwable c;
    private final byte[] v;
    private final String w;
    private final Map<String, List<String>> x;
    u3(String string, com.google.android.gms.measurement.internal.s3 s32, int i3, Throwable throwable4, byte[] b5Arr5, Map map6, com.google.android.gms.measurement.internal.t3 t37) {
        super();
        r.j(s32);
        this.a = s32;
        this.b = i3;
        this.c = throwable4;
        this.v = b5Arr5;
        this.w = string;
        this.x = map6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.w, this.b, this.c, this.v, this.x);
    }
}
