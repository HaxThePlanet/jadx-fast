package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.util.g;
import java.util.ArrayDeque;

/* loaded from: classes2.dex */
public abstract class g<I extends com.google.android.exoplayer2.decoder.DecoderInputBuffer, O extends com.google.android.exoplayer2.decoder.f, E extends com.google.android.exoplayer2.decoder.DecoderException>  implements com.google.android.exoplayer2.decoder.c<I, O, E> {

    private final Thread a;
    private final Object b;
    private final ArrayDeque<I> c;
    private final ArrayDeque<O> d;
    private final I[] e;
    private final O[] f;
    private int g;
    private int h;
    private I i;
    private E j;
    private boolean k;
    private boolean l;
    private int m;

    class a extends Thread {

        final com.google.android.exoplayer2.decoder.g a;
        a(com.google.android.exoplayer2.decoder.g g, String string2) {
            this.a = g;
            super(string2);
        }

        @Override // java.lang.Thread
        public void run() {
            g.f(this.a);
        }
    }
    protected g(I[] iArr, O[] o2Arr2) {
        int i;
        com.google.android.exoplayer2.decoder.DecoderInputBuffer[] objArr;
        com.google.android.exoplayer2.decoder.DecoderInputBuffer buf;
        int obj4;
        int obj5;
        super();
        Object object = new Object();
        this.b = object;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.c = arrayDeque;
        ArrayDeque arrayDeque2 = new ArrayDeque();
        this.d = arrayDeque2;
        this.e = iArr;
        this.g = iArr.length;
        i = obj4;
        while (i < this.g) {
            this.e[i] = h();
            i++;
        }
        this.f = o2Arr2;
        this.h = o2Arr2.length;
        while (obj4 < this.h) {
            this.f[obj4] = i();
            obj4++;
        }
        obj4 = new g.a(this, "ExoPlayer:SimpleDecoder");
        this.a = obj4;
        obj4.start();
    }

    static void f(com.google.android.exoplayer2.decoder.g g) {
        g.u();
    }

    private boolean g() {
        boolean empty;
        int i;
        if (!this.c.isEmpty() && this.h > 0) {
            i = this.h > 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    private boolean l() {
        int i;
        boolean z3;
        boolean z2;
        Object th;
        boolean z;
        Object obj = this.b;
        synchronized (obj) {
            while (!this.l) {
                if (!g()) {
                }
                this.b.wait();
            }
            final int i4 = 0;
            if (this.l) {
                return i4;
            }
            Object first = this.c.removeFirst();
            final int i7 = 1;
            i5 -= i7;
            this.h = i6;
            com.google.android.exoplayer2.decoder.f fVar = this.f[i6];
            this.k = i4;
            if ((DecoderInputBuffer)first.p()) {
            } else {
                if (first.o()) {
                    fVar.i(Integer.MIN_VALUE);
                }
                i = k(first, fVar, this.k);
                if (i != null) {
                    Object obj3 = this.b;
                    this.j = i;
                    return i4;
                    synchronized (obj3) {
                        obj3 = this.b;
                        this.j = i;
                        return i4;
                    }
                }
            }
            Object obj2 = this.b;
            synchronized (obj2) {
                fVar.s();
                r(first);
                return i7;
            }
        }
        fVar.i(4);
    }

    private void o() {
        boolean z;
        if (g()) {
            this.b.notify();
        }
    }

    private void p() {
        final com.google.android.exoplayer2.decoder.DecoderException exc = this.j;
        if (exc != null) {
        } else {
        }
        throw exc;
    }

    private void r(I i) {
        i.j();
        final int i2 = this.g;
        this.g = i2 + 1;
        this.e[i2] = i;
    }

    private void t(O o) {
        o.j();
        final int i = this.h;
        this.h = i + 1;
        this.f[i] = o;
    }

    private void u() {
        try {
            while (l()) {
            }
            IllegalStateException illegalStateException = new IllegalStateException(th);
            throw illegalStateException;
        }
    }

    @Override // com.google.android.exoplayer2.decoder.c
    public void a() {
        Thread thread;
        Object obj = this.b;
        this.l = true;
        this.b.notify();
        this.a.join();
        synchronized (obj) {
            obj = this.b;
            this.l = true;
            this.b.notify();
            this.a.join();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.c
    public Object c() {
        return n();
    }

    @Override // com.google.android.exoplayer2.decoder.c
    public Object d() {
        return m();
    }

    @Override // com.google.android.exoplayer2.decoder.c
    public void e(Object object) {
        q((DecoderInputBuffer)object);
    }

    @Override // com.google.android.exoplayer2.decoder.c
    public final void flush() {
        com.google.android.exoplayer2.decoder.DecoderInputBuffer first;
        boolean empty;
        final Object obj = this.b;
        this.k = true;
        this.m = 0;
        first = this.i;
        synchronized (obj) {
            r(first);
            this.i = 0;
            while (!this.c.isEmpty()) {
                r((DecoderInputBuffer)this.c.removeFirst());
            }
            try {
                while (!this.d.isEmpty()) {
                    (f)this.d.removeFirst().s();
                }
                (f)this.d.removeFirst().s();
                throw th;
            }
        }
    }

    protected abstract I h();

    protected abstract O i();

    protected abstract E j(Throwable throwable);

    protected abstract E k(I i, O o2, boolean z3);

    public final I m() {
        int i;
        com.google.android.exoplayer2.decoder.DecoderInputBuffer buf;
        com.google.android.exoplayer2.decoder.DecoderInputBuffer[] objArr;
        final Object obj = this.b;
        p();
        final int i4 = 1;
        synchronized (obj) {
            i = i4;
            try {
                g.f(i);
                int i2 = this.g;
                if (i2 == 0) {
                } else {
                }
                buf = 0;
                i2 -= i4;
                this.g = i3;
                buf = this.e[i3];
                this.i = buf;
                return buf;
                throw th;
            }
        }
    }

    public final O n() {
        final Object obj = this.b;
        p();
        synchronized (obj) {
            return 0;
        }
    }

    public final void q(I i) {
        int i2;
        final Object obj = this.b;
        p();
        synchronized (obj) {
            i2 = 1;
            try {
                g.a(i2);
                this.c.addLast(i);
                o();
                this.i = 0;
                throw i;
            }
        }
    }

    protected void s(O o) {
        final Object obj = this.b;
        t(o);
        o();
        return;
        synchronized (obj) {
            obj = this.b;
            t(o);
            o();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.c
    protected final void v(int i) {
        int i3;
        int i2;
        com.google.android.exoplayer2.decoder.DecoderInputBuffer buf;
        i3 = this.g == objArr2.length ? 1 : i2;
        g.f(i3);
        com.google.android.exoplayer2.decoder.DecoderInputBuffer[] objArr = this.e;
        while (i2 < objArr.length) {
            objArr[i2].t(i);
            i2++;
        }
    }
}
