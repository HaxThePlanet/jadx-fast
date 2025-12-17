package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class b0 implements Runnable {

    public final com.google.android.exoplayer2.g1 a;
    public final com.google.android.exoplayer2.w1 b;
    public b0(com.google.android.exoplayer2.g1 g1, com.google.android.exoplayer2.w1 w12) {
        super();
        this.a = g1;
        this.b = w12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.T(this.b);
    }
}
