package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class b implements Runnable {

    public final com.google.android.exoplayer2.s0.a a;
    public final int b;
    public b(com.google.android.exoplayer2.s0.a s0$a, int i2) {
        super();
        this.a = a;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
