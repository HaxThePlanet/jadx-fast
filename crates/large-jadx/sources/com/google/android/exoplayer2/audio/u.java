package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.w0;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class u {

    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;
    private final com.google.android.exoplayer2.audio.u.a a;
    private final long[] b;
    private AudioTrack c;
    private int d;
    private int e;
    private com.google.android.exoplayer2.audio.t f;
    private int g;
    private boolean h;
    private long i;
    private float j;
    private boolean k;
    private long l;
    private long m;
    private Method n;
    private long o;
    private boolean p;
    private boolean q;
    private long r;
    private long s;
    private long t;
    private long u;
    private int v;
    private int w;
    private long x;
    private long y;
    private long z;

    public interface a {
        public abstract void a(int i, long l2);

        public abstract void b(long l);

        public abstract void c(long l);

        public abstract void d(long l, long l2, long l3, long l4);

        public abstract void e(long l, long l2, long l3, long l4);
    }
    public u(com.google.android.exoplayer2.audio.u.a u$a) {
        int str;
        int i;
        int obj3;
        super();
        g.e(a);
        this.a = (u.a)a;
        if (p0.a >= 18) {
            this.n = AudioTrack.class.getMethod("getLatency", 0);
        }
        this.b = new long[10];
    }

    private boolean a() {
        int i3;
        boolean playState;
        int i;
        int i2;
        AudioTrack audioTrack = this.c;
        g.e(audioTrack);
        if (this.h && (AudioTrack)audioTrack.getPlayState() == 2 && Long.compare(l, i2) == 0) {
            audioTrack = this.c;
            g.e(audioTrack);
            if ((AudioTrack)audioTrack.getPlayState() == 2) {
                i3 = Long.compare(l, i2) == 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i3;
    }

    private long b(long l) {
        return obj3 /= l2;
    }

    private long f() {
        boolean cmp3;
        int cmp2;
        int cmp;
        int elapsedRealtime;
        int i;
        int i2;
        long l;
        AudioTrack audioTrack = this.c;
        g.e(audioTrack);
        final long l12 = -9223372036854775807L;
        if (Long.compare(l8, l12) != 0) {
            return Math.min(this.A, l12);
        }
        int playState = (AudioTrack)audioTrack.getPlayState();
        final int i14 = 0;
        if (playState == 1) {
            return i14;
        }
        l14 &= l;
        if (this.h && playState == 2 && Long.compare(i2, i14) == 0) {
            if (playState == 2) {
                if (Long.compare(i2, i14) == 0) {
                    this.u = this.s;
                }
            }
            i2 += l;
        }
        if (p0.a <= 29 && Long.compare(i2, i14) == 0 && Long.compare(l, i14) > 0 && playState == 3 && Long.compare(l6, l12) == 0) {
            if (Long.compare(i2, i14) == 0) {
                if (Long.compare(l, i14) > 0) {
                    if (playState == 3) {
                        if (Long.compare(l6, l12) == 0) {
                            this.y = SystemClock.elapsedRealtime();
                        }
                        return this.s;
                    }
                }
            }
            this.y = l12;
        }
        if (Long.compare(l3, i2) > 0) {
            this.t = l4 += i;
        }
        this.s = i2;
        return i2 += i7;
    }

    private long g() {
        return b(f());
    }

    private void m(long l, long l2) {
        int cmp;
        com.google.android.exoplayer2.audio.u.a aVar;
        long i2;
        int i;
        final com.google.android.exoplayer2.audio.t tVar = this.f;
        g.e(tVar);
        if (!(t)tVar.e(l)) {
        }
        final long l7 = tVar.c();
        final long l6 = tVar.b();
        i2 = 5000000;
        if (Long.compare(l3, i2) > 0) {
            this.a.e(l6, obj4, l7, obj6);
            tVar.f();
        } else {
            if (Long.compare(l5, i2) > 0) {
                this.a.d(l6, obj4, l7, obj6);
                tVar.f();
            } else {
                tVar.a();
            }
        }
    }

    private void n() {
        int i5;
        int i4;
        int cmp;
        int i3;
        int i;
        int i2;
        long l;
        final long l2 = g();
        i5 = 0;
        if (Long.compare(l2, i5) == 0) {
        }
        nanoTime /= i7;
        int i9 = this.v;
        this.b[i9] = l2 - i6;
        cmp = 10;
        this.v = i10 %= cmp;
        i3 = this.w;
        if (Long.compare(i8, i) >= 0 && i3 < cmp) {
            i9 = this.v;
            this.b[i9] = l2 - i6;
            cmp = 10;
            this.v = i10 %= cmp;
            i3 = this.w;
            if (i3 < cmp) {
                this.w = i3++;
            }
            this.m = i6;
            this.l = i5;
            i5 = 0;
            i4 = this.w;
            while (i5 < i4) {
                this.l = l4 += i2;
                i5++;
                i4 = this.w;
            }
        }
        if (this.h) {
        }
        m(i6, obj5);
        o(i6);
    }

    private void o(long l) {
        boolean z;
        int cmp;
        int i;
        int i2;
        int cmp2;
        z = this.n;
        i2 = 500000;
        cmp = this.c;
        g.e(cmp);
        Object invoke = z.invoke(cmp, new Object[0]);
        p0.i((Integer)invoke);
        i4 -= l4;
        this.o = i5;
        i = 0;
        z = Math.max(i5, cmp);
        this.o = z;
        if (this.q && z != null && Long.compare(i6, i2) >= 0 && Long.compare(z, i9) > 0) {
            z = this.n;
            if (z != null) {
                i2 = 500000;
                if (Long.compare(i6, i2) >= 0) {
                    cmp = this.c;
                    g.e(cmp);
                    invoke = z.invoke(cmp, new Object[0]);
                    p0.i((Integer)invoke);
                    i4 -= l4;
                    this.o = i5;
                    i = 0;
                    z = Math.max(i5, cmp);
                    this.o = z;
                    if (Long.compare(z, i9) > 0) {
                        this.a.c(z);
                        this.o = i;
                    }
                    this.r = l;
                }
            }
        }
    }

    private static boolean p(int i) {
        int i2;
        int obj2;
        if (p0.a < 23) {
            if (i != 5) {
                obj2 = i == 6 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private void s() {
        final int i = 0;
        this.l = i;
        final int i2 = 0;
        this.w = i2;
        this.v = i2;
        this.m = i;
        this.C = i;
        this.F = i;
        this.k = i2;
    }

    public int c(long l) {
        return obj6 -= obj5;
    }

    public long d(boolean z) {
        boolean z2;
        float f;
        int cmp;
        int i2;
        long l2;
        int i3;
        long l;
        int i;
        long l3;
        final Object obj = this;
        AudioTrack audioTrack = obj.c;
        g.e(audioTrack);
        if ((AudioTrack)audioTrack.getPlayState() == 3) {
            n();
        }
        int i6 = 1000;
        nanoTime /= i6;
        com.google.android.exoplayer2.audio.t tVar = obj.f;
        g.e(tVar);
        final boolean z4 = (t)tVar.d();
        if (z4) {
            l8 += l2;
        } else {
            if (obj.w == 0) {
                i2 = g();
            } else {
                l9 += i4;
            }
            if (!z) {
                i2 = Math.max(0, obj10);
            }
        }
        if (obj.D != z4) {
            obj.F = obj.C;
            obj.E = obj.B;
        }
        i3 = i4 - l11;
        int i16 = 1000000;
        if (Long.compare(i3, i16) < 0) {
            i13 /= i16;
            i10 /= i6;
        }
        z2 = obj.B;
        if (!obj.k && Long.compare(i2, z2) > 0) {
            z2 = obj.B;
            if (Long.compare(i2, z2) > 0) {
                obj.k = true;
                obj.a.b(currentTimeMillis -= l6);
            }
        }
        obj.C = i4;
        obj.B = i2;
        obj.D = z4;
        return i2;
    }

    public long e(long l) {
        return w0.e(b(l -= l2));
    }

    public void h(long l) {
        this.z = f();
        this.x = elapsedRealtime *= i2;
        this.A = l;
    }

    public boolean i(long l) {
        int obj3;
        if (Long.compare(l, l2) <= 0) {
            if (a()) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }

    public boolean j() {
        int i;
        AudioTrack audioTrack = this.c;
        g.e(audioTrack);
        i = (AudioTrack)audioTrack.getPlayState() == 3 ? 1 : 0;
        return i;
    }

    public boolean k(long l) {
        int cmp;
        int obj5;
        if (Long.compare(l2, l4) != 0 && Long.compare(l, cmp) > 0 && Long.compare(obj5, cmp) >= 0) {
            if (Long.compare(l, cmp) > 0) {
                obj5 = Long.compare(obj5, cmp) >= 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj5;
    }

    public boolean l(long l) {
        int playState;
        boolean cmp;
        int i2;
        long l2;
        int i;
        boolean obj9;
        int obj10;
        AudioTrack audioTrack = this.c;
        g.e(audioTrack);
        playState = (AudioTrack)audioTrack.getPlayState();
        final int i3 = 1;
        i2 = 0;
        if (this.h && playState == 2) {
            i2 = 0;
            if (playState == 2) {
                this.p = i2;
                return i2;
            }
            if (playState == i3 && Long.compare(l2, i) == 0) {
                if (Long.compare(l2, i) == 0) {
                    return i2;
                }
            }
        }
        boolean z = this.p;
        obj9 = i(l);
        this.p = obj9;
        if (z && obj9 == null && playState != i3) {
            if (obj9 == null) {
                if (playState != i3) {
                    this.a.a(this.e, w0.e(this.i));
                }
            }
        }
        return i3;
    }

    public boolean q() {
        s();
        if (Long.compare(l, l2) == 0) {
            com.google.android.exoplayer2.audio.t tVar = this.f;
            g.e(tVar);
            (t)tVar.g();
            return 1;
        }
        return 0;
    }

    public void r() {
        s();
        final int i = 0;
        this.c = i;
        this.f = i;
    }

    public void t(AudioTrack audioTrack, boolean z2, int i3, int i4, int i5) {
        boolean obj4;
        int obj7;
        this.c = audioTrack;
        this.d = i4;
        this.e = i5;
        t tVar = new t(audioTrack);
        this.f = tVar;
        this.g = audioTrack.getSampleRate();
        int obj3 = 0;
        if (z2 && u.p(i3)) {
            obj4 = u.p(i3) ? 1 : obj3;
        } else {
        }
        this.h = obj4;
        obj4 = p0.g0(i3);
        this.q = obj4;
        long l = -9223372036854775807L;
        if (obj4 != null) {
            obj4 = b((long)obj7);
        } else {
            obj4 = l;
        }
        this.i = obj4;
        obj4 = 0;
        this.s = obj4;
        this.t = obj4;
        this.u = obj4;
        this.p = obj3;
        this.x = l;
        this.y = l;
        this.r = obj4;
        this.o = obj4;
        this.j = 1065353216;
    }

    public void u(float f) {
        this.j = f;
        final com.google.android.exoplayer2.audio.t obj1 = this.f;
        if (obj1 != null) {
            obj1.g();
        }
    }

    public void v() {
        final com.google.android.exoplayer2.audio.t tVar = this.f;
        g.e(tVar);
        (t)tVar.g();
    }
}
