package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.i1;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface q {

    public static final class a {

        public final com.google.android.exoplayer2.mediacodec.r a;
        public final MediaFormat b;
        public final Surface c;
        public final MediaCrypto d;
        public final int e;
        public a(com.google.android.exoplayer2.mediacodec.r r, MediaFormat mediaFormat2, i1 i13, Surface surface4, MediaCrypto mediaCrypto5, int i6) {
            super();
            this.a = r;
            this.b = mediaFormat2;
            this.c = surface4;
            this.d = mediaCrypto5;
            this.e = i6;
        }
    }

    public interface b {

        public static final com.google.android.exoplayer2.mediacodec.q.b a;
        static {
            t.b bVar = new t.b();
            q.b.a = bVar;
        }

        public abstract com.google.android.exoplayer2.mediacodec.q a(com.google.android.exoplayer2.mediacodec.q.a q$a);
    }

    public interface c {
        public abstract void a(com.google.android.exoplayer2.mediacodec.q q, long l2, long l3);
    }
    public abstract void a();

    public abstract boolean b();

    public abstract void c(int i, int i2, b b3, long l4, int i5);

    public abstract MediaFormat d();

    public abstract void e(Bundle bundle);

    public abstract void f(int i, long l2);

    public abstract void flush();

    public abstract int g();

    public abstract int h(MediaCodec.BufferInfo mediaCodec$BufferInfo);

    public abstract void i(com.google.android.exoplayer2.mediacodec.q.c q$c, Handler handler2);

    public abstract void j(int i, boolean z2);

    public abstract void k(int i);

    public abstract ByteBuffer l(int i);

    public abstract void m(Surface surface);

    public abstract void n(int i, int i2, int i3, long l4, int i5);

    public abstract ByteBuffer o(int i);
}
