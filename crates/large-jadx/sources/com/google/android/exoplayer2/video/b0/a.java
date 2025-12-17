package com.google.android.exoplayer2.video.b0;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

/* loaded from: classes2.dex */
public final class a implements SurfaceTexture.OnFrameAvailableListener {

    public final com.google.android.exoplayer2.video.b0.k a;
    public a(com.google.android.exoplayer2.video.b0.k k) {
        super();
        this.a = k;
    }

    @Override // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.a.g(surfaceTexture);
    }
}
