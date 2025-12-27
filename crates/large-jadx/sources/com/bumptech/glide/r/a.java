package com.bumptech.glide.r;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.s.c;
import java.util.Map;

/* compiled from: BaseRequestOptions.java */
/* loaded from: classes.dex */
public abstract class a<T extends a<T>> implements java.lang.Cloneable {

    private boolean A = true;
    private int B = -1;
    private int C = -1;
    private com.bumptech.glide.load.f D;
    private boolean E;
    private boolean F = true;
    private Drawable G;
    private int H;
    private com.bumptech.glide.load.h I = new h();
    private Map<Class<?>, com.bumptech.glide.load.l<?>> J = new b<>();
    private Class<?> K = Object.class;
    private boolean L;
    private Resources.Theme M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q = true;
    private boolean R;
    private int a;
    private float b = 1f;
    private com.bumptech.glide.load.engine.j c;
    private com.bumptech.glide.h v;
    private Drawable w;
    private int x;
    private Drawable y;
    private int z;
    public a() {
        super();
        this.c = j.c;
        this.v = h.NORMAL;
        this.D = c.c();
        com.bumptech.glide.load.h hVar = new h();
        com.bumptech.glide.t.b bVar = new b();
    }

    private boolean M(int i) {
        return a.N(this.a, i);
    }

    private T W(com.bumptech.glide.load.resource.bitmap.l lVar, com.bumptech.glide.load.l<Bitmap> lVar2) {
        return c0(lVar, lVar2, false);
    }

    private T c0(com.bumptech.glide.load.resource.bitmap.l lVar, com.bumptech.glide.load.l<Bitmap> lVar2, boolean z) {
        com.bumptech.glide.r.a aVar;
        if (z) {
            aVar = n0(lVar, lVar2);
        } else {
            aVar = X(lVar, lVar2);
        }
        aVar.Q = true;
        return aVar;
    }

    public final com.bumptech.glide.h A() {
        return this.v;
    }

    public final Class<?> B() {
        return this.K;
    }

    public final com.bumptech.glide.load.f C() {
        return this.D;
    }

    public final float D() {
        return this.b;
    }

    public final Resources.Theme E() {
        return this.M;
    }

    public final Map<Class<?>, com.bumptech.glide.load.l<?>> F() {
        return this.J;
    }

    public final boolean G() {
        return this.R;
    }

    public final boolean H() {
        return this.O;
    }

    protected final boolean I() {
        return this.N;
    }

    public final boolean J() {
        return this.A;
    }

    public final boolean K() {
        return M(8);
    }

    boolean L() {
        return this.Q;
    }

    public final boolean O() {
        return this.F;
    }

    public final boolean P() {
        return this.E;
    }

    public final boolean Q() {
        return M(2048);
    }

    public final boolean R() {
        return l.t(this.C, this.B);
    }

    public T S() {
        this.L = true;
        d0();
        return this;
    }

    public T T() {
        return X(l.c, new i());
    }

    public T U() {
        return W(l.b, new j());
    }

    public T V() {
        return W(l.a, new q());
    }

    final T X(com.bumptech.glide.load.resource.bitmap.l lVar, com.bumptech.glide.load.l<Bitmap> lVar2) {
        if (this.N) {
            return d().X(lVar, lVar2);
        }
        h(lVar);
        return m0(lVar2, false);
    }

    public T Y(int i, int i2) {
        if (this.N) {
            return d().Y(i, i2);
        }
        this.C = i;
        this.B = i2;
        this.a |= 512;
        e0();
        return this;
    }

    public T Z(int i) {
        if (this.N) {
            return d().Z(i);
        }
        this.z = i;
        this.a |= 128;
        this.y = null;
        this.a = i4 & (-65);
        e0();
        return this;
    }

    public T a(a<?> aVar) {
        if (this.N) {
            return d().a(aVar);
        }
        if (a.N(aVar.a, 2)) {
            this.b = aVar.b;
        }
        if (a.N(aVar.a, 262144)) {
            this.O = aVar.O;
        }
        if (a.N(aVar.a, 1048576)) {
            this.R = aVar.R;
        }
        if (a.N(aVar.a, 4)) {
            this.c = aVar.c;
        }
        if (a.N(aVar.a, 8)) {
            this.v = aVar.v;
        }
        int i = 0;
        if (a.N(aVar.a, 16)) {
            this.w = aVar.w;
            this.x = i;
            this.a &= -33;
        }
        Drawable drawable4 = null;
        if (a.N(aVar.a, 32)) {
            this.x = aVar.x;
            this.w = drawable4;
            this.a &= -17;
        }
        if (a.N(aVar.a, 64)) {
            this.y = aVar.y;
            this.z = i;
            this.a &= -129;
        }
        if (a.N(aVar.a, 128)) {
            this.z = aVar.z;
            this.y = drawable4;
            this.a &= -65;
        }
        if (a.N(aVar.a, 256)) {
            this.A = aVar.A;
        }
        if (a.N(aVar.a, 512)) {
            this.C = aVar.C;
            this.B = aVar.B;
        }
        if (a.N(aVar.a, 1024)) {
            this.D = aVar.D;
        }
        if (a.N(aVar.a, 4096)) {
            this.K = aVar.K;
        }
        if (a.N(aVar.a, 8192)) {
            this.G = aVar.G;
            this.H = i;
            this.a &= -16385;
        }
        if (a.N(aVar.a, 16384)) {
            this.H = aVar.H;
            this.G = drawable4;
            this.a &= -8193;
        }
        if (a.N(aVar.a, 32768)) {
            this.M = aVar.M;
        }
        if (a.N(aVar.a, 65536)) {
            this.F = aVar.F;
        }
        if (a.N(aVar.a, 131072)) {
            this.E = aVar.E;
        }
        int i2 = 2048;
        if (a.N(aVar.a, i2)) {
            this.J.putAll(aVar.J);
            this.Q = aVar.Q;
        }
        if (a.N(aVar.a, 524288)) {
            this.P = aVar.P;
        }
        if (!this.F) {
            this.J.clear();
            this.a &= -2049;
            this.E = false;
            i = -131073;
            this.a = i32 & i;
            boolean z21 = true;
            this.Q = z21;
        }
        this.a |= i51;
        this.I.d(aVar.I);
        e0();
        return this;
    }

    public T a0(Drawable drawable) {
        if (this.N) {
            return d().a0(drawable);
        }
        this.y = drawable;
        this.a |= 64;
        this.z = 0;
        this.a = i3 & (-129);
        e0();
        return this;
    }

    public T b() {
        this.N = true;
        return S();
    }

    public T b0(com.bumptech.glide.h hVar) {
        if (this.N) {
            return d().b0(hVar);
        }
        k.d(hVar);
        this.v = hVar;
        this.a |= 8;
        e0();
        return this;
    }

    public T c() {
        return n0(l.b, new k());
    }

    public T d() {
        try {
            final Object clone = super.clone();
            com.bumptech.glide.load.h hVar = new h();
            clone.I = hVar;
            hVar.d(this.I);
            com.bumptech.glide.t.b bVar = new b();
            clone.J = bVar;
            bVar.putAll(this.J);
            boolean z = false;
            clone.L = z;
            clone.N = z;
        } catch (java.lang.CloneNotSupportedException cloneNotSupported) {
            throw new RuntimeException(cloneNotSupported);
        }
        return clone;
    }

    public T e(Class<?> cls) {
        if (this.N) {
            return d().e(cls);
        }
        k.d(cls);
        this.K = cls;
        this.a |= 4096;
        e0();
        return this;
    }

    protected final T e0() {
        if (this.L) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        } else {
            d0();
            return this;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z2 = false;
        equals = object instanceof a;
        int i6 = 0;
        if (object instanceof a) {
            if (Float.compare(object.b, this.b) == 0) {
                if (this.x == object.x) {
                    if (l.c(this.w, object.w)) {
                        if (this.z == object.z) {
                            if (l.c(this.y, object.y)) {
                                if (this.H == object.H) {
                                    if (l.c(this.G, object.G)) {
                                        if (this.A == object.A) {
                                            if (this.B == object.B) {
                                                if (this.C == object.C) {
                                                    if (this.E == object.E) {
                                                        if (this.F == object.F) {
                                                            if (this.O == object.O) {
                                                                if (this.P == object.P) {
                                                                    if (this.c.equals(object.c)) {
                                                                        if (this.v == object.v) {
                                                                            if (this.I.equals(object.I)) {
                                                                                if (this.J.equals(object.J)) {
                                                                                    if (this.K.equals(object.K)) {
                                                                                        if (l.c(this.D, object.D)) {
                                                                                            if (l.c(this.M, object.M)) {
                                                                                                int i7 = 1;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z2;
    }

    public T f(com.bumptech.glide.load.engine.j jVar) {
        if (this.N) {
            return d().f(jVar);
        }
        k.d(jVar);
        this.c = jVar;
        this.a |= 4;
        e0();
        return this;
    }

    public <Y> T f0(g<Y> gVar, Y y) {
        if (this.N) {
            return d().f0(gVar, y);
        }
        k.d(gVar);
        k.d(y);
        this.I.e(gVar, y);
        e0();
        return this;
    }

    public T g() {
        return f0(i.b, Boolean.TRUE);
    }

    public T g0(com.bumptech.glide.load.f fVar) {
        if (this.N) {
            return d().g0(fVar);
        }
        k.d(fVar);
        this.D = fVar;
        this.a |= 1024;
        e0();
        return this;
    }

    public T h(com.bumptech.glide.load.resource.bitmap.l lVar) {
        k.d(lVar);
        return f0(l.f, lVar);
    }

    public T h0(float f) {
        if (this.N) {
            return d().h0(f);
        }
        if (f < 0) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        } else {
            if (f <= 1065353216) {
                this.b = f;
                this.a |= 2;
                e0();
                return this;
            }
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return l.o(this.M, l.o(this.D, l.o(this.K, l.o(this.J, l.o(this.I, l.o(this.v, l.o(this.c, l.p(this.P, l.p(this.O, l.p(this.F, l.p(this.E, l.n(this.C, l.n(this.B, l.p(this.A, l.o(this.G, l.n(this.H, l.o(this.y, l.n(this.z, l.o(this.w, l.n(this.x, l.k(this.b)))))))))))))))))))));
    }

    public T i0(boolean z) {
        final boolean z3 = true;
        if (this.N) {
            return d().i0(z3);
        }
        this.A = z ^ z3;
        this.a |= 256;
        e0();
        return this;
    }

    public T j(int i) {
        if (this.N) {
            return d().j(i);
        }
        this.x = i;
        this.a |= 32;
        this.w = null;
        this.a = i4 & (-17);
        e0();
        return this;
    }

    public T k(Drawable drawable) {
        if (this.N) {
            return d().k(drawable);
        }
        this.w = drawable;
        this.a |= 16;
        this.x = 0;
        this.a = i3 & (-33);
        e0();
        return this;
    }

    public T k0(com.bumptech.glide.load.l<Bitmap> lVar) {
        return m0(lVar, true);
    }

    public T l(int i) {
        if (this.N) {
            return d().l(i);
        }
        this.H = i;
        this.a |= 16384;
        this.G = null;
        this.a = i4 & (-8193);
        e0();
        return this;
    }

    public T m(Drawable drawable) {
        if (this.N) {
            return d().m(drawable);
        }
        this.G = drawable;
        this.a |= 8192;
        this.H = 0;
        this.a = i3 & (-16385);
        e0();
        return this;
    }

    T m0(com.bumptech.glide.load.l<Bitmap> lVar, boolean z) {
        if (this.N) {
            return d().m0(lVar, z);
        }
        o oVar = new o(lVar, z);
        o0(Bitmap.class, lVar, z);
        o0(Drawable.class, oVar, z);
        oVar.c();
        o0(BitmapDrawable.class, oVar, z);
        o0(c.class, new f(lVar), z);
        e0();
        return this;
    }

    public T n(com.bumptech.glide.load.b bVar) {
        k.d(bVar);
        return f0(m.f, bVar).f0(i.a, bVar);
    }

    final T n0(com.bumptech.glide.load.resource.bitmap.l lVar, com.bumptech.glide.load.l<Bitmap> lVar2) {
        if (this.N) {
            return d().n0(lVar, lVar2);
        }
        h(lVar);
        return k0(lVar2);
    }

    public final com.bumptech.glide.load.engine.j o() {
        return this.c;
    }

    <Y> T o0(Class<Y> cls, com.bumptech.glide.load.l<Y> lVar, boolean z) {
        if (this.N) {
            return d().o0(cls, lVar, z);
        }
        k.d(cls);
        k.d(lVar);
        this.J.put(cls, lVar);
        this.a |= 2048;
        final boolean z2 = true;
        this.F = z2;
        i = i6 | 65536;
        this.a = i;
        this.Q = false;
        if (z) {
            int i2 = 131072;
            i = i | i2;
            this.a = i;
            this.E = z2;
        }
        e0();
        return this;
    }

    public final int p() {
        return this.x;
    }

    public T p0(boolean z) {
        if (this.N) {
            return d().p0(z);
        }
        this.R = z;
        this.a |= 1048576;
        e0();
        return this;
    }

    public final Drawable r() {
        return this.w;
    }

    public final Drawable s() {
        return this.G;
    }

    public final int t() {
        return this.H;
    }

    public final boolean u() {
        return this.P;
    }

    public final com.bumptech.glide.load.h v() {
        return this.I;
    }

    public final int w() {
        return this.B;
    }

    public final int x() {
        return this.C;
    }

    public final Drawable y() {
        return this.y;
    }

    public final int z() {
        return this.z;
    }

    private static boolean N(int i, int i2) {
        boolean z = true;
        i = i & i2 != 0 ? 1 : 0;
        return (i & i2 != 0 ? 1 : 0);
    }

    private T d0() {
        return this;
    }
}
