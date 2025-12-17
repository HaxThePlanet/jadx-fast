package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.d;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final com.google.android.exoplayer2.video.z.a a;
    public final d b;
    public b(com.google.android.exoplayer2.video.z.a z$a, d d2) {
        super();
        this.a = a;
        this.b = d2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.l(this.b);
    }
}
