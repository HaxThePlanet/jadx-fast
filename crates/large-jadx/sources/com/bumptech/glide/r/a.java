package com.bumptech.glide.r;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.h;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.n.g.f;
import com.bumptech.glide.load.n.g.i;
import com.bumptech.glide.load.resource.bitmap.i;
import com.bumptech.glide.load.resource.bitmap.j;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.s.c;
import com.bumptech.glide.t.b;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a<T extends com.bumptech.glide.r.a<T>>  implements java.lang.Cloneable {

    private boolean A = true;
    private int B = -1;
    private int C = -1;
    private f D;
    private boolean E;
    private boolean F = true;
    private Drawable G;
    private int H;
    private h I;
    private Map<Class<?>, l<?>> J;
    private Class<?> K;
    private boolean L;
    private Resources.Theme M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q = true;
    private boolean R;
    private int a;
    private float b = 1f;
    private j c = 1065353216;
    private h v = 1065353216;
    private Drawable w;
    private int x;
    private Drawable y;
    private int z;
    public a() {
        super();
        int i = 1065353216;
        j jVar = j.c;
        h nORMAL = h.NORMAL;
        int i2 = 1;
        int i3 = -1;
        this.D = c.c();
        h hVar = new h();
        this.I = hVar;
        b bVar = new b();
        this.J = bVar;
        this.K = Object.class;
    }

    private boolean M(int i) {
        return a.N(this.a, i);
    }

    private static boolean N(int i, int i2) {
        int obj0;
        obj0 = i &= i2 != 0 ? 1 : 0;
        return obj0;
    }

    private T W(l l, l<Bitmap> l2) {
        return c0(l, l2, false);
    }

    private T c0(l l, l<Bitmap> l2, boolean z3) {
        com.bumptech.glide.r.a obj1;
        if (z3) {
            obj1 = n0(l, l2);
        } else {
            obj1 = X(l, l2);
        }
        obj1.Q = true;
        return obj1;
    }

    private T d0() {
        return this;
    }

    @Override // java.lang.Cloneable
    public final h A() {
        return this.v;
    }

    public final Class<?> B() {
        return this.K;
    }

    @Override // java.lang.Cloneable
    public final f C() {
        return this.D;
    }

    @Override // java.lang.Cloneable
    public final float D() {
        return this.b;
    }

    @Override // java.lang.Cloneable
    public final Resources.Theme E() {
        return this.M;
    }

    public final Map<Class<?>, l<?>> F() {
        return this.J;
    }

    @Override // java.lang.Cloneable
    public final boolean G() {
        return this.R;
    }

    @Override // java.lang.Cloneable
    public final boolean H() {
        return this.O;
    }

    @Override // java.lang.Cloneable
    protected final boolean I() {
        return this.N;
    }

    @Override // java.lang.Cloneable
    public final boolean J() {
        return this.A;
    }

    @Override // java.lang.Cloneable
    public final boolean K() {
        return M(8);
    }

    @Override // java.lang.Cloneable
    boolean L() {
        return this.Q;
    }

    @Override // java.lang.Cloneable
    public final boolean O() {
        return this.F;
    }

    @Override // java.lang.Cloneable
    public final boolean P() {
        return this.E;
    }

    @Override // java.lang.Cloneable
    public final boolean Q() {
        return M(2048);
    }

    @Override // java.lang.Cloneable
    public final boolean R() {
        return l.t(this.C, this.B);
    }

    public T S() {
        this.L = true;
        d0();
        return this;
    }

    public T T() {
        i iVar = new i();
        return X(l.c, iVar);
    }

    public T U() {
        j jVar = new j();
        return W(l.b, jVar);
    }

    public T V() {
        q qVar = new q();
        return W(l.a, qVar);
    }

    final T X(l l, l<Bitmap> l2) {
        if (this.N) {
            return d().X(l, l2);
        }
        h(l);
        return m0(l2, false);
    }

    public T Y(int i, int i2) {
        if (this.N) {
            return d().Y(i, i2);
        }
        this.C = i;
        this.B = i2;
        this.a = obj2 |= 512;
        e0();
        return this;
    }

    public T Z(int i) {
        if (this.N) {
            return d().Z(i);
        }
        this.z = i;
        obj2 |= 128;
        this.a = obj2;
        this.y = 0;
        this.a = obj2 &= -65;
        e0();
        return this;
    }

    public T a(com.bumptech.glide.r.a<?> a) {
        boolean z8;
        boolean z9;
        boolean z14;
        boolean z12;
        boolean z10;
        boolean z11;
        boolean z19;
        boolean z;
        boolean z15;
        boolean z5;
        boolean z20;
        boolean z18;
        boolean z2;
        boolean z7;
        boolean z13;
        boolean z17;
        boolean z16;
        boolean z3;
        boolean z4;
        boolean z6;
        boolean z21;
        int i;
        int i2;
        if (this.N) {
            return d().a(a);
        }
        if (a.N(a.a, 2)) {
            this.b = a.b;
        }
        if (a.N(a.a, 262144)) {
            this.O = a.O;
        }
        if (a.N(a.a, 1048576)) {
            this.R = a.R;
        }
        if (a.N(a.a, 4)) {
            this.c = a.c;
        }
        if (a.N(a.a, 8)) {
            this.v = a.v;
        }
        i = 0;
        if (a.N(a.a, 16)) {
            this.w = a.w;
            this.x = i;
            this.a = i37 &= -33;
        }
        int i46 = 0;
        if (a.N(a.a, 32)) {
            this.x = a.x;
            this.w = i46;
            this.a = i11 &= -17;
        }
        if (a.N(a.a, 64)) {
            this.y = a.y;
            this.z = i;
            this.a = i36 &= -129;
        }
        if (a.N(a.a, 128)) {
            this.z = a.z;
            this.y = i46;
            this.a = i35 &= -65;
        }
        if (a.N(a.a, 256)) {
            this.A = a.A;
        }
        if (a.N(a.a, 512)) {
            this.C = a.C;
            this.B = a.B;
        }
        if (a.N(a.a, 1024)) {
            this.D = a.D;
        }
        if (a.N(a.a, 4096)) {
            this.K = a.K;
        }
        if (a.N(a.a, 8192)) {
            this.G = a.G;
            this.H = i;
            this.a = i32 &= -16385;
        }
        if (a.N(a.a, 16384)) {
            this.H = a.H;
            this.G = i46;
            this.a = i21 &= -8193;
        }
        if (a.N(a.a, 32768)) {
            this.M = a.M;
        }
        if (a.N(a.a, 65536)) {
            this.F = a.F;
        }
        if (a.N(a.a, 131072)) {
            this.E = a.E;
        }
        if (a.N(a.a, 2048)) {
            this.J.putAll(a.J);
            this.Q = a.Q;
        }
        if (a.N(a.a, 524288)) {
            this.P = a.P;
        }
        if (!this.F) {
            this.J.clear();
            i29 &= -2049;
            this.a = i30;
            this.E = i;
            this.a = i30 &= i;
            this.Q = true;
        }
        this.a = i27 |= i44;
        this.I.d(a.I);
        e0();
        return this;
    }

    public T a0(Drawable drawable) {
        if (this.N) {
            return d().a0(drawable);
        }
        this.y = drawable;
        obj2 |= 64;
        this.a = obj2;
        this.z = 0;
        this.a = obj2 &= -129;
        e0();
        return this;
    }

    public T b() {
        boolean z;
        if (this.L) {
            if (!this.N) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            throw illegalStateException;
        }
        this.N = true;
        return S();
    }

    public T b0(h h) {
        if (this.N) {
            return d().b0(h);
        }
        k.d(h);
        this.v = (h)h;
        this.a = obj2 |= 8;
        e0();
        return this;
    }

    public T c() {
        k kVar = new k();
        return n0(l.b, kVar);
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return d();
    }

    public T d() {
        try {
            final Object clone = super.clone();
            h hVar = new h();
            clone.I = hVar;
            hVar.d(this.I);
            b bVar = new b();
            clone.J = bVar;
            bVar.putAll(this.J);
            int i = 0;
            clone.L = i;
            clone.N = i;
            return (a)clone;
            RuntimeException runtimeException = new RuntimeException(th);
            throw runtimeException;
        }
    }

    public T e(Class<?> class) {
        if (this.N) {
            return d().e(class);
        }
        k.d(class);
        this.K = (Class)class;
        this.a = obj2 |= 4096;
        e0();
        return this;
    }

    protected final T e0() {
        if (this.L) {
        } else {
            d0();
            return this;
        }
        IllegalStateException illegalStateException = new IllegalStateException("You cannot modify locked T, consider clone()");
        throw illegalStateException;
    }

    @Override // java.lang.Cloneable
    public boolean equals(Object object) {
        boolean compare;
        int i;
        float f;
        Object obj4;
        i = 0;
        if (object instanceof a && Float.compare(object.b, this.b) == 0 && this.x == object.x && l.c(this.w, object.w) && this.z == object.z && l.c(this.y, object.y) && this.H == object.H && l.c(this.G, object.G) && this.A == object.A && this.B == object.B && this.C == object.C && this.E == object.E && this.F == object.F && this.O == object.O && this.P == object.P && this.c.equals(object.c) && this.v == object.v && this.I.equals(object.I) && this.J.equals(object.J) && this.K.equals(object.K) && l.c(this.D, object.D) && l.c(this.M, object.M)) {
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
                                                                                                i = 1;
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
        return i;
    }

    public T f(j j) {
        if (this.N) {
            return d().f(j);
        }
        k.d(j);
        this.c = (j)j;
        this.a = obj2 |= 4;
        e0();
        return this;
    }

    public <Y> T f0(g<Y> g, Y y2) {
        if (this.N) {
            return d().f0(g, y2);
        }
        k.d(g);
        k.d(y2);
        this.I.e(g, y2);
        e0();
        return this;
    }

    public T g() {
        return f0(i.b, Boolean.TRUE);
    }

    public T g0(f f) {
        if (this.N) {
            return d().g0(f);
        }
        k.d(f);
        this.D = (f)f;
        this.a = obj2 |= 1024;
        e0();
        return this;
    }

    public T h(l l) {
        k.d(l);
        return f0(l.f, l);
    }

    public T h0(float f) {
        int cmp;
        if (this.N) {
            return d().h0(f);
        }
        if (Float.compare(f, i) < 0) {
        } else {
            if (Float.compare(f, i2) > 0) {
            } else {
                this.b = f;
                this.a = obj2 |= 2;
                e0();
                return this;
            }
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        throw obj2;
    }

    @Override // java.lang.Cloneable
    public int hashCode() {
        return l.o(this.M, l.o(this.D, l.o(this.K, l.o(this.J, l.o(this.I, l.o(this.v, l.o(this.c, l.p(this.P, l.p(this.O, l.p(this.F, l.p(this.E, l.n(this.C, l.n(this.B, l.p(this.A, l.o(this.G, l.n(this.H, l.o(this.y, l.n(this.z, l.o(this.w, l.n(this.x, l.k(this.b)))))))))))))))))))));
    }

    public T i0(boolean z) {
        final int i = 1;
        if (this.N) {
            return d().i0(i);
        }
        this.A = z ^= i;
        this.a = obj3 |= 256;
        e0();
        return this;
    }

    public T j(int i) {
        if (this.N) {
            return d().j(i);
        }
        this.x = i;
        obj2 |= 32;
        this.a = obj2;
        this.w = 0;
        this.a = obj2 &= -17;
        e0();
        return this;
    }

    public T k(Drawable drawable) {
        if (this.N) {
            return d().k(drawable);
        }
        this.w = drawable;
        obj2 |= 16;
        this.a = obj2;
        this.x = 0;
        this.a = obj2 &= -33;
        e0();
        return this;
    }

    public T k0(l<Bitmap> l) {
        return m0(l, true);
    }

    public T l(int i) {
        if (this.N) {
            return d().l(i);
        }
        this.H = i;
        obj2 |= 16384;
        this.a = obj2;
        this.G = 0;
        this.a = obj2 &= -8193;
        e0();
        return this;
    }

    public T m(Drawable drawable) {
        if (this.N) {
            return d().m(drawable);
        }
        this.G = drawable;
        obj2 |= 8192;
        this.a = obj2;
        this.H = 0;
        this.a = obj2 &= -16385;
        e0();
        return this;
    }

    T m0(l<Bitmap> l, boolean z2) {
        if (this.N) {
            return d().m0(l, z2);
        }
        o oVar = new o(l, z2);
        o0(Bitmap.class, l, z2);
        o0(Drawable.class, oVar, z2);
        oVar.c();
        o0(BitmapDrawable.class, oVar, z2);
        f fVar = new f(l);
        o0(c.class, fVar, z2);
        e0();
        return this;
    }

    public T n(b b) {
        k.d(b);
        return f0(m.f, b).f0(i.a, b);
    }

    final T n0(l l, l<Bitmap> l2) {
        if (this.N) {
            return d().n0(l, l2);
        }
        h(l);
        return k0(l2);
    }

    @Override // java.lang.Cloneable
    public final j o() {
        return this.c;
    }

    <Y> T o0(Class<Y> class, l<Y> l2, boolean z3) {
        int obj2;
        boolean obj4;
        if (this.N) {
            return d().o0(class, l2, z3);
        }
        k.d(class);
        k.d(l2);
        this.J.put(class, l2);
        obj2 |= 2048;
        this.a = obj2;
        final int obj3 = 1;
        this.F = obj3;
        obj2 |= i;
        this.a = obj2;
        this.Q = false;
        if (z3) {
            this.a = obj2 |= obj4;
            this.E = obj3;
        }
        e0();
        return this;
    }

    @Override // java.lang.Cloneable
    public final int p() {
        return this.x;
    }

    public T p0(boolean z) {
        if (this.N) {
            return d().p0(z);
        }
        this.R = z;
        this.a = obj2 |= i;
        e0();
        return this;
    }

    @Override // java.lang.Cloneable
    public final Drawable r() {
        return this.w;
    }

    @Override // java.lang.Cloneable
    public final Drawable s() {
        return this.G;
    }

    @Override // java.lang.Cloneable
    public final int t() {
        return this.H;
    }

    @Override // java.lang.Cloneable
    public final boolean u() {
        return this.P;
    }

    @Override // java.lang.Cloneable
    public final h v() {
        return this.I;
    }

    @Override // java.lang.Cloneable
    public final int w() {
        return this.B;
    }

    @Override // java.lang.Cloneable
    public final int x() {
        return this.C;
    }

    @Override // java.lang.Cloneable
    public final Drawable y() {
        return this.y;
    }

    @Override // java.lang.Cloneable
    public final int z() {
        return this.z;
    }
}
