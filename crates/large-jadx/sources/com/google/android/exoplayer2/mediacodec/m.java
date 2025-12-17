package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.p0;
import com.google.common.base.b;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
class m {

    private static final ArrayDeque<com.google.android.exoplayer2.mediacodec.m.b> h;
    private static final Object i;
    private final MediaCodec a;
    private final HandlerThread b;
    private Handler c;
    private final AtomicReference<RuntimeException> d;
    private final l e;
    private final boolean f;
    private boolean g;

    class a extends Handler {

        final com.google.android.exoplayer2.mediacodec.m a;
        a(com.google.android.exoplayer2.mediacodec.m m, Looper looper2) {
            this.a = m;
            super(looper2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            m.a(this.a, message);
        }
    }

    private static class b {

        public int a;
        public int b;
        public int c;
        public final MediaCodec.CryptoInfo d;
        public long e;
        public int f;
        b() {
            super();
            MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
            this.d = cryptoInfo;
        }

        public void a(int i, int i2, int i3, long l4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.e = l4;
            this.f = obj6;
        }
    }
    static {
        ArrayDeque arrayDeque = new ArrayDeque();
        m.h = arrayDeque;
        Object object = new Object();
        m.i = object;
    }

    public m(MediaCodec mediaCodec, HandlerThread handlerThread2, boolean z3) {
        l lVar = new l();
        super(mediaCodec, handlerThread2, z3, lVar);
    }

    m(MediaCodec mediaCodec, HandlerThread handlerThread2, boolean z3, l l4) {
        int obj1;
        super();
        this.a = mediaCodec;
        this.b = handlerThread2;
        this.e = l4;
        obj1 = new AtomicReference();
        this.d = obj1;
        if (!z3) {
            if (m.m()) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        this.f = obj1;
    }

    static void a(com.google.android.exoplayer2.mediacodec.m m, Message message2) {
        m.f(message2);
    }

    private void b() {
        this.e.c();
        Handler handler = this.c;
        p0.i(handler);
        (Handler)handler.obtainMessage(2).sendToTarget();
        this.e.a();
    }

    private static void c(b b, MediaCodec.CryptoInfo mediaCodec$CryptoInfo2) {
        int pattern;
        int i;
        Object obj2;
        cryptoInfo2.numSubSamples = b.f;
        cryptoInfo2.numBytesOfClearData = m.e(b.d, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = m.e(b.e, cryptoInfo2.numBytesOfEncryptedData);
        byte[] bArr2 = m.d(b.b, cryptoInfo2.key);
        g.e(bArr2);
        cryptoInfo2.key = (byte[])bArr2;
        byte[] bArr4 = m.d(b.a, cryptoInfo2.iv);
        g.e(bArr4);
        cryptoInfo2.iv = (byte[])bArr4;
        cryptoInfo2.mode = b.c;
        if (p0.a >= 24) {
            pattern = new MediaCodec.CryptoInfo.Pattern(b.g, b.h);
            cryptoInfo2.setPattern(pattern);
        }
    }

    private static byte[] d(byte[] bArr, byte[] b2Arr2) {
        int length;
        int length2;
        if (bArr == null) {
            return b2Arr2;
        }
        if (b2Arr2 != null && b2Arr2.length < bArr.length) {
            if (b2Arr2.length < bArr.length) {
            }
            int i = 0;
            System.arraycopy(bArr, i, b2Arr2, i, bArr.length);
            return b2Arr2;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    private static int[] e(int[] iArr, int[] i2Arr2) {
        int length2;
        int length;
        if (iArr == null) {
            return i2Arr2;
        }
        if (i2Arr2 != null && i2Arr2.length < iArr.length) {
            if (i2Arr2.length < iArr.length) {
            }
            int i = 0;
            System.arraycopy(iArr, i, i2Arr2, i, iArr.length);
            return i2Arr2;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    private void f(Message message) {
        java.lang.IllegalStateException illegalStateException;
        int i2;
        int i4;
        int i3;
        long l;
        int i;
        Object obj8;
        illegalStateException = message.what;
        if (illegalStateException != null) {
            if (illegalStateException != 1) {
                if (illegalStateException != 2) {
                    illegalStateException = new IllegalStateException(String.valueOf(message.what));
                    q(illegalStateException);
                } else {
                    this.e.d();
                }
                obj8 = 0;
            } else {
                obj8 = message.obj;
                this.h(obj8.a, obj8.b, obj8.d, obj8.e, obj5);
            }
        } else {
            obj8 = message.obj;
            this.g(obj8.a, obj8.b, obj8.c, obj8.e, obj5);
        }
        if (obj8 != null) {
            m.p(obj8);
        }
    }

    private void g(int i, int i2, int i3, long l4, int i5) {
        Throwable obj8;
        try {
            this.a.queueInputBuffer(i, i2, i3, l4, obj5);
            q(i);
        }
    }

    private void h(int i, int i2, MediaCodec.CryptoInfo mediaCodec$CryptoInfo3, long l4, int i5) {
        Object mediaCodec;
        Object th;
        int i6;
        MediaCodec.CryptoInfo cryptoInfo;
        long l2;
        int l;
        int i3;
        int i4;
        Throwable obj9;
        try {
            if (this.f) {
            } else {
            }
            mediaCodec = m.i;
            this.a.queueSecureInputBuffer(i, i2, cryptoInfo3, l4, obj6);
            throw i;
            this.a.queueSecureInputBuffer(i, i2, cryptoInfo3, l4, obj5);
            q(i);
        } catch (Throwable th) {
        }
    }

    private void j() {
        final Handler handler = this.c;
        p0.i(handler);
        (Handler)handler.removeCallbacksAndMessages(0);
        b();
        l();
    }

    private static com.google.android.exoplayer2.mediacodec.m.b k() {
        final ArrayDeque queue = m.h;
        synchronized (queue) {
            m.b bVar = new m.b();
            return bVar;
        }
    }

    private void l() {
        Object andSet = this.d.getAndSet(0);
        if ((RuntimeException)andSet != null) {
        } else {
        }
        throw (RuntimeException)andSet;
    }

    private static boolean m() {
        int i;
        String contains;
        String contains2;
        contains = b.c(p0.c);
        if (!contains.contains("samsung")) {
            if (contains.contains("motorola")) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static void p(com.google.android.exoplayer2.mediacodec.m.b m$b) {
        final ArrayDeque queue = m.h;
        queue.add(b);
        return;
        synchronized (queue) {
            queue = m.h;
            queue.add(b);
        }
    }

    public void i() {
        if (this.g) {
            j();
        }
    }

    public void n(int i, int i2, int i3, long l4, int i5) {
        l();
        final com.google.android.exoplayer2.mediacodec.m.b bVar2 = m.k();
        bVar2.a(i, i2, i3, l4, obj5);
        Handler obj9 = this.c;
        p0.i(obj9);
        (Handler)obj9.obtainMessage(0, bVar2).sendToTarget();
    }

    public void o(int i, int i2, b b3, long l4, int i5) {
        l();
        final com.google.android.exoplayer2.mediacodec.m.b bVar2 = m.k();
        bVar2.a(i, i2, 0, l4, obj5);
        m.c(b3, bVar2.d);
        Handler obj9 = this.c;
        p0.i(obj9);
        (Handler)obj9.obtainMessage(1, bVar2).sendToTarget();
    }

    void q(RuntimeException runtimeException) {
        this.d.set(runtimeException);
    }

    public void r() {
        boolean z;
        if (this.g) {
            i();
            this.b.quit();
        }
        this.g = false;
    }

    public void s() {
        boolean z;
        Looper looper;
        if (!this.g) {
            this.b.start();
            m.a aVar = new m.a(this, this.b.getLooper());
            this.c = aVar;
            this.g = true;
        }
    }

    public void t() {
        b();
    }
}
