package com.google.android.exoplayer2.video;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    public final com.google.android.exoplayer2.video.z.a a;
    public final int b;
    public final long c;
    public g(com.google.android.exoplayer2.video.z.a z$a, int i2, long l3) {
        super();
        this.a = a;
        this.b = i2;
        this.c = l3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.n(this.b, this.c);
    }
}
