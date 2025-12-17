package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.util.n0;
import com.google.common.base.s;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes2.dex */
final class l implements com.google.android.exoplayer2.mediacodec.q {

    private final MediaCodec a;
    private final com.google.android.exoplayer2.mediacodec.n b;
    private final com.google.android.exoplayer2.mediacodec.m c;
    private final boolean d;
    private boolean e;
    private int f;

    static class a {
    }

    public static final class b implements com.google.android.exoplayer2.mediacodec.q.b {

        private final s<HandlerThread> b;
        private final s<HandlerThread> c;
        private final boolean d;
        private final boolean e;
        public b(int i, boolean z2, boolean z3) {
            a aVar = new a(i);
            b bVar = new b(i);
            super(aVar, bVar, z2, z3);
        }

        b(s<HandlerThread> s, s<HandlerThread> s2, boolean z3, boolean z4) {
            super();
            this.b = s;
            this.c = s2;
            this.d = z3;
            this.e = z4;
        }

        static HandlerThread c(int i) {
            HandlerThread handlerThread = new HandlerThread(l.r(i));
            return handlerThread;
        }

        static HandlerThread d(int i) {
            HandlerThread handlerThread = new HandlerThread(l.q(i));
            return handlerThread;
        }

        @Override // com.google.android.exoplayer2.mediacodec.q$b
        public com.google.android.exoplayer2.mediacodec.q a(com.google.android.exoplayer2.mediacodec.q.a q$a) {
            return b(a);
        }

        @Override // com.google.android.exoplayer2.mediacodec.q$b
        public com.google.android.exoplayer2.mediacodec.l b(com.google.android.exoplayer2.mediacodec.q.a q$a) {
            Object obj2;
            String concat;
            String valueOf;
            String str = rVar.a;
            int i = 0;
            String str2 = "createCodec:";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                concat = str2.concat(valueOf);
            } else {
                valueOf = new String(str2);
                concat = valueOf;
            }
            n0.a(concat);
            super(MediaCodec.createByCodecName(str), (HandlerThread)this.b.get(), (HandlerThread)this.c.get(), this.d, this.e, 0);
            n0.c();
            l.p(lVar, a.b, a.c, a.d, a.e);
            return lVar;
        }
    }
    private l(MediaCodec mediaCodec, HandlerThread handlerThread2, HandlerThread handlerThread3, boolean z4, boolean z5) {
        super();
        this.a = mediaCodec;
        n nVar = new n(handlerThread2);
        this.b = nVar;
        m obj3 = new m(mediaCodec, handlerThread3, z4);
        this.c = obj3;
        this.d = z5;
        this.f = 0;
    }

    l(MediaCodec mediaCodec, HandlerThread handlerThread2, HandlerThread handlerThread3, boolean z4, boolean z5, com.google.android.exoplayer2.mediacodec.l.a l$a6) {
        super(mediaCodec, handlerThread2, handlerThread3, z4, z5);
    }

    static void p(com.google.android.exoplayer2.mediacodec.l l, MediaFormat mediaFormat2, Surface surface3, MediaCrypto mediaCrypto4, int i5) {
        l.v(mediaFormat2, surface3, mediaCrypto4, i5);
    }

    static String q(int i) {
        return l.t(i);
    }

    static String r(int i) {
        return l.s(i);
    }

    private static String s(int i) {
        return l.u(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    private static String t(int i) {
        return l.u(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String u(int i, String string2) {
        String obj1;
        int obj2;
        StringBuilder stringBuilder = new StringBuilder(string2);
        if (i == 1) {
            stringBuilder.append("Audio");
        } else {
            if (i == 2) {
                stringBuilder.append("Video");
            } else {
                stringBuilder.append("Unknown(");
                stringBuilder.append(i);
                stringBuilder.append(")");
            }
        }
        return stringBuilder.toString();
    }

    private void v(MediaFormat mediaFormat, Surface surface2, MediaCrypto mediaCrypto3, int i4) {
        this.b.g(this.a);
        n0.a("configureCodec");
        this.a.configure(mediaFormat, surface2, mediaCrypto3, i4);
        n0.c();
        this.c.s();
        n0.a("startCodec");
        this.a.start();
        n0.c();
        this.f = 1;
    }

    private void w(com.google.android.exoplayer2.mediacodec.q.c q$c, MediaCodec mediaCodec2, long l3, long l4) {
        c.a(this, l3, obj3);
    }

    private void y() {
        boolean z;
        if (this.d) {
            this.c.t();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void a() {
        Throwable th;
        int i;
        boolean z;
        boolean z2;
        final int i2 = 1;
        if (this.f == i2) {
            try {
                this.c.r();
                this.b.q();
                this.f = 2;
                if (!this.e) {
                }
                this.a.release();
                this.e = i2;
                z2 = this.e;
                if (z2) {
                } else {
                }
                z2 = this.a;
                z2.release();
                this.e = obj0;
                throw th;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public boolean b() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void c(int i, int i2, b b3, long l4, int i5) {
        this.c.o(i, i2, b3, l4, obj5);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public MediaFormat d() {
        return this.b.f();
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void e(Bundle bundle) {
        y();
        this.a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void f(int i, long l2) {
        this.a.releaseOutputBuffer(i, l2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void flush() {
        this.c.i();
        this.a.flush();
        final MediaCodec mediaCodec2 = this.a;
        Objects.requireNonNull(mediaCodec2);
        j jVar = new j(mediaCodec2);
        this.b.d(jVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public int g() {
        return this.b.b();
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public int h(MediaCodec.BufferInfo mediaCodec$BufferInfo) {
        return this.b.c(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void i(com.google.android.exoplayer2.mediacodec.q.c q$c, Handler handler2) {
        y();
        c cVar = new c(this, c);
        this.a.setOnFrameRenderedListener(cVar, handler2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void j(int i, boolean z2) {
        this.a.releaseOutputBuffer(i, z2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void k(int i) {
        y();
        this.a.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public ByteBuffer l(int i) {
        return this.a.getInputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void m(Surface surface) {
        y();
        this.a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void n(int i, int i2, int i3, long l4, int i5) {
        this.c.n(i, i2, i3, l4, obj5);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public ByteBuffer o(int i) {
        return this.a.getOutputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.q
    public void x(com.google.android.exoplayer2.mediacodec.q.c q$c, MediaCodec mediaCodec2, long l3, long l4) {
        w(c, mediaCodec2, l3, l4);
    }
}
