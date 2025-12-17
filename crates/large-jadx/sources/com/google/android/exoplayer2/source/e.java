package com.google.android.exoplayer2.source;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    public final com.google.android.exoplayer2.source.z.a a;
    public final com.google.android.exoplayer2.source.z b;
    public final com.google.android.exoplayer2.source.v c;
    public e(com.google.android.exoplayer2.source.z.a z$a, com.google.android.exoplayer2.source.z z2, com.google.android.exoplayer2.source.v v3) {
        super();
        this.a = a;
        this.b = z2;
        this.c = v3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f(this.b, this.c);
    }
}
