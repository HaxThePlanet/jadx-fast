package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;

/* loaded from: classes2.dex */
public final class j implements Runnable {

    public final MediaCodec a;
    public j(MediaCodec mediaCodec) {
        super();
        this.a = mediaCodec;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.start();
    }
}
