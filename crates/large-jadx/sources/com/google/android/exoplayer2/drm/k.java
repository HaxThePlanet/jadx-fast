package com.google.android.exoplayer2.drm;

/* loaded from: classes2.dex */
public final class k implements Runnable {

    public final com.google.android.exoplayer2.drm.u.a a;
    public final com.google.android.exoplayer2.drm.u b;
    public final Exception c;
    public k(com.google.android.exoplayer2.drm.u.a u$a, com.google.android.exoplayer2.drm.u u2, Exception exception3) {
        super();
        this.a = a;
        this.b = u2;
        this.c = exception3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.q(this.b, this.c);
    }
}
