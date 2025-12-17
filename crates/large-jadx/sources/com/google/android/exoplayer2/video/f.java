package com.google.android.exoplayer2.video;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    public final com.google.android.exoplayer2.video.z.a a;
    public final Object b;
    public final long c;
    public f(com.google.android.exoplayer2.video.z.a z$a, Object object2, long l3) {
        super();
        this.a = a;
        this.b = object2;
        this.c = l3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.t(this.b, this.c);
    }
}
