package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.t;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
final class n extends MediaCodec.Callback {

    private final Object a;
    private final HandlerThread b;
    private Handler c;
    private final t d;
    private final t e;
    private final ArrayDeque<MediaCodec.BufferInfo> f;
    private final ArrayDeque<MediaFormat> g;
    private MediaFormat h;
    private MediaFormat i;
    private MediaCodec.CodecException j;
    private long k;
    private boolean l;
    private java.lang.IllegalStateException m;
    n(HandlerThread handlerThread) {
        super();
        Object object = new Object();
        this.a = object;
        this.b = handlerThread;
        t obj2 = new t();
        this.d = obj2;
        obj2 = new t();
        this.e = obj2;
        obj2 = new ArrayDeque();
        this.f = obj2;
        obj2 = new ArrayDeque();
        this.g = obj2;
    }

    private void a(MediaFormat mediaFormat) {
        this.e.a(-2);
        this.g.add(mediaFormat);
    }

    private void e() {
        boolean empty;
        if (!this.g.isEmpty()) {
            this.i = (MediaFormat)this.g.getLast();
        }
        this.d.b();
        this.e.b();
        this.f.clear();
        this.g.clear();
        this.j = 0;
    }

    private boolean h() {
        int i;
        int cmp;
        if (Long.compare(l, i2) <= 0) {
            if (this.l) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private void i(Runnable runnable) {
        n(runnable);
    }

    private void k() {
        l();
        m();
    }

    private void l() {
        final java.lang.IllegalStateException exc = this.m;
        if (exc != null) {
        } else {
        }
        this.m = 0;
        throw exc;
    }

    private void m() {
        final MediaCodec.CodecException exc = this.j;
        if (exc != null) {
        } else {
        }
        this.j = 0;
        throw exc;
    }

    private void n(Runnable runnable) {
        final Object obj = this.a;
        o(runnable);
        return;
        synchronized (obj) {
            obj = this.a;
            o(runnable);
        }
    }

    private void o(Runnable runnable) {
        int cmp;
        Throwable obj6;
        if (this.l) {
        }
        l -= i2;
        this.k = i;
        int i3 = 0;
        if (Long.compare(i, i3) > 0) {
        }
        if (Long.compare(i, i3) < 0) {
            obj6 = new IllegalStateException();
            p(obj6);
        }
        e();
        runnable.run();
    }

    private void p(java.lang.IllegalStateException illegalStateException) {
        final Object obj = this.a;
        this.m = illegalStateException;
        return;
        synchronized (obj) {
            obj = this.a;
            this.m = illegalStateException;
        }
    }

    @Override // android.media.MediaCodec$Callback
    public int b() {
        boolean z;
        int i;
        final Object obj = this.a;
        synchronized (obj) {
            return -1;
        }
    }

    @Override // android.media.MediaCodec$Callback
    public int c(MediaCodec.BufferInfo mediaCodec$BufferInfo) {
        int remove;
        int i;
        int offset;
        int size;
        long presentationTimeUs;
        int flags;
        int obj10;
        final Object obj = this.a;
        remove = -1;
        synchronized (obj) {
            return remove;
        }
    }

    @Override // android.media.MediaCodec$Callback
    public void d(Runnable runnable) {
        final Object obj = this.a;
        this.k = l += i2;
        Handler handler = this.c;
        p0.i(handler);
        d dVar = new d(this, runnable);
        (Handler)handler.post(dVar);
        return;
        synchronized (obj) {
            obj = this.a;
            this.k = l += i2;
            handler = this.c;
            p0.i(handler);
            dVar = new d(this, runnable);
            (Handler)handler.post(dVar);
        }
    }

    @Override // android.media.MediaCodec$Callback
    public MediaFormat f() {
        final Object obj = this.a;
        MediaFormat mediaFormat = this.h;
        synchronized (obj) {
            return mediaFormat;
        }
    }

    @Override // android.media.MediaCodec$Callback
    public void g(MediaCodec mediaCodec) {
        int i;
        i = this.c == null ? 1 : 0;
        g.f(i);
        this.b.start();
        Handler handler3 = new Handler(this.b.getLooper());
        mediaCodec.setCallback(this, handler3);
        this.c = handler3;
    }

    @Override // android.media.MediaCodec$Callback
    public void j(Runnable runnable) {
        i(runnable);
    }

    @Override // android.media.MediaCodec$Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException mediaCodec$CodecException2) {
        final Object obj1 = this.a;
        this.j = codecException2;
        return;
        synchronized (obj1) {
            obj1 = this.a;
            this.j = codecException2;
        }
    }

    @Override // android.media.MediaCodec$Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
        final Object obj2 = this.a;
        this.d.a(i2);
        return;
        synchronized (obj2) {
            obj2 = this.a;
            this.d.a(i2);
        }
    }

    @Override // android.media.MediaCodec$Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo mediaCodec$BufferInfo3) {
        MediaFormat mediaFormat;
        final Object obj2 = this.a;
        mediaFormat = this.i;
        synchronized (obj2) {
            a(mediaFormat);
            this.i = 0;
            this.e.a(i2);
            this.f.add(bufferInfo3);
        }
    }

    @Override // android.media.MediaCodec$Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat2) {
        final Object obj1 = this.a;
        a(mediaFormat2);
        this.i = 0;
        return;
        synchronized (obj1) {
            obj1 = this.a;
            a(mediaFormat2);
            this.i = 0;
        }
    }

    @Override // android.media.MediaCodec$Callback
    public void q() {
        final Object obj = this.a;
        this.l = true;
        this.b.quit();
        e();
        return;
        synchronized (obj) {
            obj = this.a;
            this.l = true;
            this.b.quit();
            e();
        }
    }
}
