package com.google.android.exoplayer2.drm;

/* loaded from: classes2.dex */
public final class l implements Runnable {

    public final com.google.android.exoplayer2.drm.u.a a;
    public final com.google.android.exoplayer2.drm.u b;
    public final int c;
    public l(com.google.android.exoplayer2.drm.u.a u$a, com.google.android.exoplayer2.drm.u u2, int i3) {
        super();
        this.a = a;
        this.b = u2;
        this.c = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.o(this.b, this.c);
    }
}
