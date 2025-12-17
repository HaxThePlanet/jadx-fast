package com.google.android.exoplayer2.video;

/* loaded from: classes2.dex */
public final class i implements Runnable {

    public final com.google.android.exoplayer2.video.z.a a;
    public final com.google.android.exoplayer2.video.a0 b;
    public i(com.google.android.exoplayer2.video.z.a z$a, com.google.android.exoplayer2.video.a0 a02) {
        super();
        this.a = a;
        this.b = a02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.z(this.b);
    }
}
