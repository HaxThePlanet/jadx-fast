package com.google.android.exoplayer2.source;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    public final com.google.android.exoplayer2.source.z.a a;
    public final com.google.android.exoplayer2.source.z b;
    public final com.google.android.exoplayer2.source.s c;
    public final com.google.android.exoplayer2.source.v v;
    public g(com.google.android.exoplayer2.source.z.a z$a, com.google.android.exoplayer2.source.z z2, com.google.android.exoplayer2.source.s s3, com.google.android.exoplayer2.source.v v4) {
        super();
        this.a = a;
        this.b = z2;
        this.c = s3;
        this.v = v4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h(this.b, this.c, this.v);
    }
}
