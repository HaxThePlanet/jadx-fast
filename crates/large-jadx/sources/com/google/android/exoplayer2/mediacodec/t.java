package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.p0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class t implements com.google.android.exoplayer2.mediacodec.q {

    private final MediaCodec a;
    private ByteBuffer[] b;
    private ByteBuffer[] c;

    static class a {
    }

    public static class b implements com.google.android.exoplayer2.mediacodec.q.b {
        @Override // com.google.android.exoplayer2.mediacodec.q$b
        public com.google.android.exoplayer2.mediacodec.q a(com.google.android.exoplayer2.mediacodec.q.a q$a) {
            final MediaCodec mediaCodec = b(a);
            n0.a("configureCodec");
            mediaCodec.configure(a.b, a.c, a.d, a.e);
            n0.c();
            n0.a("startCodec");
            mediaCodec.start();
            n0.c();
            t obj6 = new t(mediaCodec, 0);
            return obj6;
        }

        @Override // com.google.android.exoplayer2.mediacodec.q$b
        protected MediaCodec b(com.google.android.exoplayer2.mediacodec.q.a q$a) {
            String concat;
            g.e(a.a);
            String obj4 = obj4.a;
            String valueOf = String.valueOf(obj4);
            final String str = "createCodec:";
            if (valueOf.length() != 0) {
                concat = str.concat(valueOf);
            } else {
                concat = new String(str);
            }
            n0.a(concat);
            n0.c();
            return MediaCodec.createByCodecName(obj4);
        }
    }
    private t(MediaCodec mediaCodec) {
        int inputBuffers;
        MediaCodec obj3;
        super();
        this.a = mediaCodec;
        if (p0.a < 21) {
            this.b = mediaCodec.getInputBuffers();
            this.c = mediaCodec.getOutputBuffers();
        }
    }

    t(MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.t.a t$a2) {
        super(mediaCodec);
    }

    private void p(com.google.android.exoplayer2.mediacodec.q.c q$c, MediaCodec mediaCodec2, long l3, long l4) {
        c.a(this, l3, obj3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void a() {
        int i = 0;
        this.b = i;
        this.c = i;
        this.a.release();
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public boolean b() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void c(int i, int i2, b b3, long l4, int i5) {
        this.a.queueSecureInputBuffer(i, i2, b3.a(), l4, obj5);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public MediaFormat d() {
        return this.a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void e(Bundle bundle) {
        this.a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void f(int i, long l2) {
        this.a.releaseOutputBuffer(i, l2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void flush() {
        this.a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public int g() {
        return this.a.dequeueInputBuffer(0);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public int h(MediaCodec.BufferInfo mediaCodec$BufferInfo) {
        int outputBuffers;
        int i;
        int dequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 0);
        int i3 = -3;
        do {
            dequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 0);
            i3 = -3;
            if (dequeueOutputBuffer == i3) {
            }
            if (p0.a < 21) {
            }
            this.c = this.a.getOutputBuffers();
        } while (dequeueOutputBuffer == i3);
        return dequeueOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void i(com.google.android.exoplayer2.mediacodec.q.c q$c, Handler handler2) {
        i iVar = new i(this, c);
        this.a.setOnFrameRenderedListener(iVar, handler2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void j(int i, boolean z2) {
        this.a.releaseOutputBuffer(i, z2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void k(int i) {
        this.a.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public ByteBuffer l(int i) {
        if (p0.a >= 21) {
            return this.a.getInputBuffer(i);
        }
        ByteBuffer[] objArr = this.b;
        p0.i(objArr);
        return (ByteBuffer[])objArr[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void m(Surface surface) {
        this.a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void n(int i, int i2, int i3, long l4, int i5) {
        this.a.queueInputBuffer(i, i2, i3, l4, obj5);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public ByteBuffer o(int i) {
        if (p0.a >= 21) {
            return this.a.getOutputBuffer(i);
        }
        ByteBuffer[] objArr = this.c;
        p0.i(objArr);
        return (ByteBuffer[])objArr[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void q(com.google.android.exoplayer2.mediacodec.q.c q$c, MediaCodec mediaCodec2, long l3, long l4) {
        p(c, mediaCodec2, l3, l4);
    }
}
