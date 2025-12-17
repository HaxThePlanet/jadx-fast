package com.google.android.exoplayer2.video;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    public final com.google.android.exoplayer2.video.z.a a;
    public final Exception b;
    public d(com.google.android.exoplayer2.video.z.a z$a, Exception exception2) {
        super();
        this.a = a;
        this.b = exception2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.x(this.b);
    }
}
