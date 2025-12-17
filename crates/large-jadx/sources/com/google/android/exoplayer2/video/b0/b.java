package com.google.android.exoplayer2.video.b0;

import android.graphics.SurfaceTexture;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final com.google.android.exoplayer2.video.b0.l a;
    public final SurfaceTexture b;
    public b(com.google.android.exoplayer2.video.b0.l l, SurfaceTexture surfaceTexture2) {
        super();
        this.a = l;
        this.b = surfaceTexture2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f(this.b);
    }
}
