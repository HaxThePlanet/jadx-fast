package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.y.a;
import com.google.common.collect.v.a;

/* loaded from: classes.dex */
public final class g0 implements Runnable {

    public final com.google.android.exoplayer2.q1 a;
    public final v.a b;
    public final y.a c;
    public g0(com.google.android.exoplayer2.q1 q1, v.a v$a2, y.a y$a3) {
        super();
        this.a = q1;
        this.b = a2;
        this.c = a3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.w(this.b, this.c);
    }
}
