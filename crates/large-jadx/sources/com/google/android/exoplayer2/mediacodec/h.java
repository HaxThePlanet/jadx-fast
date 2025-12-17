package com.google.android.exoplayer2.mediacodec;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class h implements Comparator {

    public final com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f a;
    public h(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f mediaCodecUtil$f) {
        super();
        this.a = f;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return MediaCodecUtil.H(this.a, object, object2);
    }
}
