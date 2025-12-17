package com.google.android.exoplayer2.video;

import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.r;

/* loaded from: classes2.dex */
public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {

    public final boolean isSurfaceValid = true;
    public final int surfaceIdentityHashCode;
    public MediaCodecVideoDecoderException(Throwable throwable, r r2, Surface surface3) {
        int obj1;
        super(throwable, r2);
        this.surfaceIdentityHashCode = System.identityHashCode(surface3);
        if (surface3 != null && surface3.isValid()) {
            obj1 = !surface3.isValid() ? 0 : obj1;
        }
        obj1 = 1;
    }
}
