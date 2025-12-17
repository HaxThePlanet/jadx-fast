package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;

/* loaded from: classes2.dex */
public final class c implements MediaCodec.OnFrameRenderedListener {

    public final com.google.android.exoplayer2.mediacodec.l a;
    public final com.google.android.exoplayer2.mediacodec.q.c b;
    public c(com.google.android.exoplayer2.mediacodec.l l, com.google.android.exoplayer2.mediacodec.q.c q$c2) {
        super();
        this.a = l;
        this.b = c2;
    }

    @Override // android.media.MediaCodec$OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long l2, long l3) {
        this.a.x(this.b, mediaCodec, l2, obj4);
    }
}
