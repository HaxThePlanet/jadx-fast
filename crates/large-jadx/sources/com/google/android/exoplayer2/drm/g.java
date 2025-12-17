package com.google.android.exoplayer2.drm;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    public final com.google.android.exoplayer2.drm.u.a a;
    public final com.google.android.exoplayer2.drm.u b;
    public g(com.google.android.exoplayer2.drm.u.a u$a, com.google.android.exoplayer2.drm.u u2) {
        super();
        this.a = a;
        this.b = u2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.s(this.b);
    }
}
