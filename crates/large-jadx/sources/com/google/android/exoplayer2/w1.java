package com.google.android.exoplayer2;

import android.os.Looper;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class w1 {

    private final com.google.android.exoplayer2.w1.b a;
    private final com.google.android.exoplayer2.w1.a b;
    private final i c;
    private final com.google.android.exoplayer2.g2 d;
    private int e;
    private Object f;
    private Looper g;
    private int h;
    private long i = -9223372036854775807L;
    private boolean j = true;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;

    public interface a {
        public abstract void a(com.google.android.exoplayer2.w1 w1);
    }

    public interface b {
        public abstract void v(int i, Object object2);
    }
    public w1(com.google.android.exoplayer2.w1.a w1$a, com.google.android.exoplayer2.w1.b w1$b2, com.google.android.exoplayer2.g2 g23, int i4, i i5, Looper looper6) {
        super();
        this.b = a;
        this.a = b2;
        this.d = g23;
        this.g = looper6;
        this.c = i5;
        this.h = i4;
        long obj1 = -9223372036854775807L;
        obj1 = 1;
    }

    public boolean a(long l) {
        int i;
        i iVar;
        int cmp;
        int obj6;
        g.f(this.k);
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                g.f(i);
                boolean z2 = this.m;
                while (!z2) {
                    if (Long.compare(obj6, i3) > 0) {
                    }
                    this.c.d();
                    wait(obj6);
                    obj6 = i2 - obj6;
                    z2 = this.m;
                }
                if (Long.compare(obj6, i3) > 0) {
                }
                this.c.d();
                wait(obj6);
                obj6 = i2 - obj6;
                if (!z2) {
                } else {
                }
                return this.l;
                obj6 = new TimeoutException("Message delivery timed out.");
                throw obj6;
                throw l;
            }
        }
    }

    public boolean b() {
        return this.j;
    }

    public Looper c() {
        return this.g;
    }

    public Object d() {
        return this.f;
    }

    public long e() {
        return this.i;
    }

    public com.google.android.exoplayer2.w1.b f() {
        return this.a;
    }

    public com.google.android.exoplayer2.g2 g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public int i() {
        return this.h;
    }

    public boolean j() {
        return this.n;
        synchronized (this) {
            return this.n;
        }
    }

    public void k(boolean z) {
        this.l = z |= z2;
        this.m = true;
        notifyAll();
        return;
        synchronized (this) {
            this.l = z |= z2;
            this.m = true;
            notifyAll();
        }
    }

    public com.google.android.exoplayer2.w1 l() {
        int cmp;
        final int i2 = 1;
        g.f(z ^= i2);
        if (Long.compare(l, l2) == 0) {
            g.a(this.j);
        }
        this.k = i2;
        this.b.a(this);
        return this;
    }

    public com.google.android.exoplayer2.w1 m(Object object) {
        g.f(z ^= 1);
        this.f = object;
        return this;
    }

    public com.google.android.exoplayer2.w1 n(int i) {
        g.f(z ^= 1);
        this.e = i;
        return this;
    }
}
