package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.audio.r;
import com.google.android.exoplayer2.k2.b;
import com.google.android.exoplayer2.k2.c;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.e;
import com.google.android.exoplayer2.n2.k;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.k;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.video.a0;
import com.google.android.exoplayer2.video.y;
import com.google.common.base.k;
import java.util.List;

/* loaded from: classes.dex */
public interface v1 {

    static class a {
    }

    public static final class b {

        public static final com.google.android.exoplayer2.v1.b b;
        private final q a;
        static {
            v1.b.a aVar = new v1.b.a();
            v1.b.b = aVar.e();
            com.google.android.exoplayer2.j0 j0Var = j0.a;
        }

        private b(q q) {
            super();
            this.a = q;
        }

        b(q q, com.google.android.exoplayer2.v1.a v1$a2) {
            super(q);
        }

        static q a(com.google.android.exoplayer2.v1.b v1$b) {
            return b.a;
        }

        public boolean b(int i) {
            return this.a.a(i);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return 1;
            }
            if (!object instanceof v1.b) {
                return 0;
            }
            return this.a.equals(object.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    @Deprecated
    public interface c {
        public void A(boolean z) {
        }

        @Deprecated
        public void B(boolean z) {
        }

        @Deprecated
        public void C(int i) {
        }

        @Deprecated
        public void G(List<a> list) {
        }

        @Deprecated
        public void L() {
        }

        @Deprecated
        public void S(boolean z, int i2) {
        }

        public void c(com.google.android.exoplayer2.u1 u1) {
        }

        public void d(com.google.android.exoplayer2.v1.f v1$f, com.google.android.exoplayer2.v1.f v1$f2, int i3) {
        }

        public void e(int i) {
        }

        public void f(boolean z) {
        }

        public void g(com.google.android.exoplayer2.PlaybackException playbackException) {
        }

        public void h(com.google.android.exoplayer2.v1.b v1$b) {
        }

        public void i(int i) {
        }

        public void j(com.google.android.exoplayer2.g2 g2, int i2) {
        }

        public void l(int i) {
        }

        public void m(com.google.android.exoplayer2.n1 n1) {
        }

        public void n(boolean z) {
        }

        public void p(com.google.android.exoplayer2.v1 v1, com.google.android.exoplayer2.v1.d v1$d2) {
        }

        public void s(com.google.android.exoplayer2.m1 m1, int i2) {
        }

        public void v(boolean z, int i2) {
        }

        public void w(l0 l0, k k2) {
        }

        public void y(com.google.android.exoplayer2.PlaybackException playbackException) {
        }
    }

    public static final class d {

        private final q a;
        public d(q q) {
            super();
            this.a = q;
        }

        public boolean a(int i) {
            return this.a.a(i);
        }

        public boolean b(int... iArr) {
            return this.a.b(iArr);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return 1;
            }
            if (!object instanceof v1.d) {
                return 0;
            }
            return this.a.equals(object.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static final class f {

        public final Object a;
        public final int b;
        public final Object c;
        public final int d;
        public final long e;
        public final long f;
        public final int g;
        public final int h;
        static {
            final com.google.android.exoplayer2.k0 k0Var = k0.a;
        }

        public f(Object object, int i2, Object object3, int i4, long l5, long l6, int i7, int i8) {
            super();
            this.a = object;
            this.b = i2;
            this.c = object3;
            this.d = i4;
            this.e = l5;
            this.f = i7;
            this.g = obj9;
            this.h = obj10;
        }

        public boolean equals(Object object) {
            int i;
            int cmp;
            Class<com.google.android.exoplayer2.v1.f> obj;
            int i2;
            Class class;
            long l;
            Object obj7;
            if (this == object) {
                return 1;
            }
            final int i3 = 0;
            if (object != null) {
                if (v1.f.class != object.getClass()) {
                } else {
                    if (this.b == object.b && this.d == object.d && Long.compare(l2, l) == 0 && Long.compare(l3, l) == 0 && this.g == object.g && this.h == object.h && k.a(this.a, object.a) && k.a(this.c, object.c)) {
                        if (this.d == object.d) {
                            if (Long.compare(l2, l) == 0) {
                                if (Long.compare(l3, l) == 0) {
                                    if (this.g == object.g) {
                                        if (this.h == object.h) {
                                            if (k.a(this.a, object.a)) {
                                                if (k.a(this.c, object.c)) {
                                                } else {
                                                    i = i3;
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
                return i;
            }
            return i3;
        }

        public int hashCode() {
            Object[] arr = new Object[9];
            int i12 = 4;
            arr[i12] = Integer.valueOf(this.b);
            int i13 = 5;
            arr[i13] = Long.valueOf(this.e);
            arr[6] = Long.valueOf(this.f);
            arr[7] = Integer.valueOf(this.g);
            arr[8] = Integer.valueOf(this.h);
            return k.b(arr);
        }
    }

    public interface e extends y, r, k, e, c, com.google.android.exoplayer2.v1.c {
        @Override // com.google.android.exoplayer2.video.y
        public void A(boolean z) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void a(boolean z) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void b(a0 a0) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void c(com.google.android.exoplayer2.u1 u1) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void d(com.google.android.exoplayer2.v1.f v1$f, com.google.android.exoplayer2.v1.f v1$f2, int i3) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void e(int i) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void f(boolean z) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void g(com.google.android.exoplayer2.PlaybackException playbackException) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void h(com.google.android.exoplayer2.v1.b v1$b) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void i(int i) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void j(com.google.android.exoplayer2.g2 g2, int i2) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void k(float f) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void l(int i) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void m(com.google.android.exoplayer2.n1 n1) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void n(boolean z) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void o(a a) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void p(com.google.android.exoplayer2.v1 v1, com.google.android.exoplayer2.v1.d v1$d2) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void q(int i, boolean z2) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void r() {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void s(com.google.android.exoplayer2.m1 m1, int i2) {
        }

        public void u(List<c> list) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void v(boolean z, int i2) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void w(l0 l0, k k2) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void x(int i, int i2) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void y(com.google.android.exoplayer2.PlaybackException playbackException) {
        }

        @Override // com.google.android.exoplayer2.video.y
        public void z(b b) {
        }
    }
    public abstract void A(boolean z);

    public abstract long B();

    public abstract long C();

    public abstract void D(com.google.android.exoplayer2.v1.e v1$e);

    public abstract int E();

    public abstract boolean F();

    public abstract List<c> G();

    public abstract int H();

    public abstract boolean I(int i);

    public abstract void J(int i);

    public abstract void K(SurfaceView surfaceView);

    public abstract int L();

    public abstract l0 M();

    public abstract int N();

    public abstract com.google.android.exoplayer2.g2 O();

    public abstract Looper P();

    public abstract boolean Q();

    public abstract long R();

    public abstract void S();

    public abstract void T();

    public abstract void U(TextureView textureView);

    public abstract k V();

    public abstract void W();

    public abstract com.google.android.exoplayer2.n1 X();

    public abstract long Y();

    public abstract long Z();

    public abstract void a();

    public abstract long d();

    public abstract com.google.android.exoplayer2.u1 e();

    public abstract void f();

    public abstract boolean h();

    public abstract long i();

    public abstract void j(int i, long l2);

    public abstract com.google.android.exoplayer2.v1.b k();

    public abstract boolean l();

    public abstract void m(boolean z);

    @Deprecated
    public abstract void n(boolean z);

    public abstract int o();

    public abstract int p();

    public abstract boolean q();

    public abstract void r(TextureView textureView);

    public abstract a0 s();

    public abstract void stop();

    public abstract void t(com.google.android.exoplayer2.v1.e v1$e);

    public abstract int u();

    public abstract void v(SurfaceView surfaceView);

    public abstract void w(long l);

    public abstract int x();

    public abstract void y();

    public abstract com.google.android.exoplayer2.PlaybackException z();
}
