package com.google.android.exoplayer2.video;

/* loaded from: classes2.dex */
public final class k implements Runnable {

    public final com.google.android.exoplayer2.video.z.a a;
    public final long b;
    public final int c;
    public k(com.google.android.exoplayer2.video.z.a z$a, long l2, int i3) {
        super();
        this.a = a;
        this.b = l2;
        this.c = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.v(this.b, obj2);
    }
}
