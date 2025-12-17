package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;

/* loaded from: classes2.dex */
public final class i implements MediaCodec.OnFrameRenderedListener {

    public final com.google.android.exoplayer2.mediacodec.t a;
    public final com.google.android.exoplayer2.mediacodec.q.c b;
    public i(com.google.android.exoplayer2.mediacodec.t t, com.google.android.exoplayer2.mediacodec.q.c q$c2) {
        super();
        this.a = t;
        this.b = c2;
    }

    @Override // android.media.MediaCodec$OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long l2, long l3) {
        this.a.q(this.b, mediaCodec, l2, obj4);
    }
}
