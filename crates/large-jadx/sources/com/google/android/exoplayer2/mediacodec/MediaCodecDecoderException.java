package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec.CodecException;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
public class MediaCodecDecoderException extends DecoderException {

    public final com.google.android.exoplayer2.mediacodec.r codecInfo;
    public final String diagnosticInfo;
    public MediaCodecDecoderException(Throwable throwable, com.google.android.exoplayer2.mediacodec.r r2) {
        int i;
        String str;
        String string;
        str = r2 == null ? i : r2.a;
        String valueOf = String.valueOf(str);
        final String str2 = "Decoder failed: ";
        if (valueOf.length() != 0) {
            string = str2.concat(valueOf);
        } else {
            string = new String(str2);
        }
        super(string, throwable);
        this.codecInfo = r2;
        if (p0.a >= 21) {
            i = MediaCodecDecoderException.a(throwable);
        }
        this.diagnosticInfo = i;
    }

    private static String a(Throwable throwable) {
        if (throwable instanceof MediaCodec.CodecException != null) {
            return (MediaCodec.CodecException)throwable.getDiagnosticInfo();
        }
        return null;
    }
}
