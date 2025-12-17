package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: classes2.dex */
final class ar implements com.google.android.gms.internal.firebase-auth-api.k0 {

    private final com.google.android.gms.internal.firebase-auth-api.zq a;
    private int b;
    private int c;
    private int d = 0;
    private ar(com.google.android.gms.internal.firebase-auth-api.zq zq) {
        super();
        int i = 0;
        e.f(zq, "input");
        this.a = zq;
        zq.b = this;
    }

    private static final void M(int i) {
        if (i &= 7 != 0) {
        } else {
        }
        throw zzaae.g();
    }

    public static com.google.android.gms.internal.firebase-auth-api.ar N(com.google.android.gms.internal.firebase-auth-api.zq zq) {
        com.google.android.gms.internal.firebase-auth-api.ar arVar = zq.b;
        if (arVar != null) {
            return arVar;
        }
        ar arVar2 = new ar(zq);
        return arVar2;
    }

    private final <T> T k(com.google.android.gms.internal.firebase-auth-api.l0<T> l0, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        this.c = i4 |= 4;
        Object obj = l0.a();
        l0.h(obj, this, lr2);
        l0.c(obj);
        if (this.b != this.c) {
        } else {
            this.c = this.c;
            return obj;
        }
        throw zzaae.g();
    }

    private final <T> T l(com.google.android.gms.internal.firebase-auth-api.l0<T> l0, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        com.google.android.gms.internal.firebase-auth-api.zq zqVar2 = this.a;
        if (zqVar2.a >= 100) {
        } else {
            Object obj = l0.a();
            com.google.android.gms.internal.firebase-auth-api.zq zqVar3 = this.a;
            zqVar3.a = i5++;
            l0.h(obj, this, lr2);
            l0.c(obj);
            this.a.g(0);
            com.google.android.gms.internal.firebase-auth-api.zq obj5 = this.a;
            obj5.a = obj6--;
            obj5.h(zqVar2.b((yq)this.a.q()));
            return obj;
        }
        obj5 = new zzaae("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        throw obj5;
    }

    private final void n(int i) {
        if (this.a.a() != i) {
        } else {
        }
        throw zzaae.i();
    }

    private final void o(int i) {
        if (i2 &= 7 != i) {
        } else {
        }
        throw zzaae.a();
    }

    private static final void p(int i) {
        if (i &= 3 != 0) {
        } else {
        }
        throw zzaae.g();
    }

    public final <T> T A(com.google.android.gms.internal.firebase-auth-api.l0<T> l0, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        o(3);
        return k(l0, lr2);
    }

    public final void B(List<Long> list) {
        int i3;
        int i;
        int i5;
        int i4;
        int i2;
        int obj5;
        i5 = 2;
        i2 = 1;
        i = list;
        obj5 &= 7;
        if (list instanceof n && obj5 != i2) {
            i = list;
            obj5 &= 7;
            if (obj5 != i2) {
                if (obj5 != i5) {
                } else {
                    obj5 = (yq)this.a.q();
                    ar.M(obj5);
                    (n)(n)i.g((yq)this.a.r());
                    while (this.a.a() >= i8 += obj5) {
                        i.g((yq)this.a.r());
                    }
                }
                throw zzaae.a();
            }
            i.g((yq)this.a.r());
            while (this.a.i()) {
                obj5 = this.a.c();
                i.g((yq)this.a.r());
            }
        }
        i6 &= 7;
        if (i3 != i2) {
            if (i3 != i5) {
            } else {
                i = (yq)this.a.q();
                ar.M(i);
                list.add(Long.valueOf((yq)this.a.r()));
                while (this.a.a() >= i7 += i) {
                    list.add(Long.valueOf((yq)this.a.r()));
                }
            }
            throw zzaae.a();
        }
        list.add(Long.valueOf((yq)this.a.r()));
        while (this.a.i()) {
            i3 = this.a.c();
            list.add(Long.valueOf((yq)this.a.r()));
        }
    }

    public final void C(List<Integer> list) {
        int i2;
        int i3;
        int i5;
        int i4;
        int i;
        Object obj5;
        i5 = 5;
        final int i10 = 2;
        if (list instanceof yr) {
            i3 = list;
            obj5 &= 7;
            if (obj5 != i10 && obj5 == i5) {
                if (obj5 != i5) {
                }
                throw zzaae.a();
            }
            obj5 = (yq)this.a.q();
            ar.p(obj5);
            (yr)i3.g((yq)this.a.p());
            while (this.a.a() >= i4 + obj5) {
                i3.g((yq)this.a.p());
            }
        } else {
            i6 &= 7;
            if (i2 != i10 && i2 == i5) {
                if (i2 != i5) {
                }
                throw zzaae.a();
            }
            i3 = (yq)this.a.q();
            ar.p(i3);
            list.add(Integer.valueOf((yq)this.a.p()));
            while (this.a.a() >= i9 += i3) {
                list.add(Integer.valueOf((yq)this.a.p()));
            }
        }
    }

    public final <T> void D(List<T> list, com.google.android.gms.internal.firebase-auth-api.l0<T> l02, com.google.android.gms.internal.firebase-auth-api.lr lr3) {
        int i;
        final int i2 = this.b;
        if (i2 & 7 != 3) {
        }
        throw zzaae.a();
    }

    public final void E(List<Integer> list) {
        int i5;
        int i2;
        int i;
        int i4;
        int i3;
        Object obj5;
        i = 5;
        final int i10 = 2;
        if (list instanceof yr) {
            i2 = list;
            obj5 &= 7;
            if (obj5 != i10 && obj5 == i) {
                if (obj5 != i) {
                }
                throw zzaae.a();
            }
            obj5 = (yq)this.a.q();
            ar.p(obj5);
            (yr)i2.g((yq)this.a.p());
            while (this.a.a() >= i4 + obj5) {
                i2.g((yq)this.a.p());
            }
        } else {
            i6 &= 7;
            if (i5 != i10 && i5 == i) {
                if (i5 != i) {
                }
                throw zzaae.a();
            }
            i2 = (yq)this.a.q();
            ar.p(i2);
            list.add(Integer.valueOf((yq)this.a.p()));
            while (this.a.a() >= i9 += i2) {
                list.add(Integer.valueOf((yq)this.a.p()));
            }
        }
    }

    public final void F(List<Long> list) {
        int i;
        int i3;
        int i2;
        long l;
        int obj5;
        i2 = 2;
        Object obj = list;
        obj5 &= 7;
        if (list instanceof n && obj5 != null) {
            obj = list;
            obj5 &= 7;
            if (obj5 != null) {
                if (obj5 != i2) {
                } else {
                    i7 += obj5;
                    (n)(n)obj.g(zq.m((yq)this.a.s()));
                    while (this.a.a() >= i8) {
                        obj.g(zq.m((yq)this.a.s()));
                    }
                    n(i8);
                }
                throw zzaae.a();
            }
            obj.g(zq.m((yq)this.a.s()));
            while (this.a.i()) {
                obj5 = this.a.c();
                obj.g(zq.m((yq)this.a.s()));
            }
        }
        i4 &= 7;
        if (i != 0) {
            if (i != i2) {
            } else {
                i5 += i3;
                list.add(Long.valueOf(zq.m((yq)this.a.s())));
                while (this.a.a() >= i6) {
                    list.add(Long.valueOf(zq.m((yq)this.a.s())));
                }
                n(i6);
            }
            throw zzaae.a();
        }
        list.add(Long.valueOf(zq.m((yq)this.a.s())));
        while (this.a.i()) {
            i = this.a.c();
            list.add(Long.valueOf(zq.m((yq)this.a.s())));
        }
    }

    public final void G(List<Long> list) {
        int i3;
        int i2;
        int i4;
        int i;
        int i5;
        int obj5;
        i4 = 2;
        i5 = 1;
        i2 = list;
        obj5 &= 7;
        if (list instanceof n && obj5 != i5) {
            i2 = list;
            obj5 &= 7;
            if (obj5 != i5) {
                if (obj5 != i4) {
                } else {
                    obj5 = (yq)this.a.q();
                    ar.M(obj5);
                    (n)(n)i2.g((yq)this.a.r());
                    while (this.a.a() >= i8 += obj5) {
                        i2.g((yq)this.a.r());
                    }
                }
                throw zzaae.a();
            }
            i2.g((yq)this.a.r());
            while (this.a.i()) {
                obj5 = this.a.c();
                i2.g((yq)this.a.r());
            }
        }
        i6 &= 7;
        if (i3 != i5) {
            if (i3 != i4) {
            } else {
                i2 = (yq)this.a.q();
                ar.M(i2);
                list.add(Long.valueOf((yq)this.a.r()));
                while (this.a.a() >= i7 += i2) {
                    list.add(Long.valueOf((yq)this.a.r()));
                }
            }
            throw zzaae.a();
        }
        list.add(Long.valueOf((yq)this.a.r()));
        while (this.a.i()) {
            i3 = this.a.c();
            list.add(Long.valueOf((yq)this.a.r()));
        }
    }

    public final void H(List<Integer> list) {
        int i2;
        int i3;
        int i;
        int obj3;
        i = 2;
        Object obj = list;
        obj3 &= 7;
        if (list instanceof yr && obj3 != null) {
            obj = list;
            obj3 &= 7;
            if (obj3 != null) {
                if (obj3 != i) {
                } else {
                    i11 += obj3;
                    (yr)(yr)obj.g(zq.l((yq)this.a.q()));
                    while (this.a.a() >= i12) {
                        obj.g(zq.l((yq)this.a.q()));
                    }
                    n(i12);
                }
                throw zzaae.a();
            }
            obj.g(zq.l((yq)this.a.q()));
            while (this.a.i()) {
                obj3 = this.a.c();
                obj.g(zq.l((yq)this.a.q()));
            }
        }
        i4 &= 7;
        if (i2 != 0) {
            if (i2 != i) {
            } else {
                i9 += i3;
                list.add(Integer.valueOf(zq.l((yq)this.a.q())));
                while (this.a.a() >= i10) {
                    list.add(Integer.valueOf(zq.l((yq)this.a.q())));
                }
                n(i10);
            }
            throw zzaae.a();
        }
        list.add(Integer.valueOf(zq.l((yq)this.a.q())));
        while (this.a.i()) {
            i2 = this.a.c();
            list.add(Integer.valueOf(zq.l((yq)this.a.q())));
        }
    }

    public final void I(List<Integer> list) {
        int i2;
        int i;
        int i3;
        int obj3;
        i3 = 2;
        Object obj = list;
        obj3 &= 7;
        if (list instanceof yr && obj3 != null) {
            obj = list;
            obj3 &= 7;
            if (obj3 != null) {
                if (obj3 != i3) {
                } else {
                    i9 += obj3;
                    (yr)(yr)obj.g((yq)this.a.q());
                    while (this.a.a() >= i10) {
                        obj.g((yq)this.a.q());
                    }
                    n(i10);
                }
                throw zzaae.a();
            }
            obj.g((yq)this.a.q());
            while (this.a.i()) {
                obj3 = this.a.c();
                obj.g((yq)this.a.q());
            }
        }
        i4 &= 7;
        if (i2 != 0) {
            if (i2 != i3) {
            } else {
                i7 += i;
                list.add(Integer.valueOf((yq)this.a.q()));
                while (this.a.a() >= i8) {
                    list.add(Integer.valueOf((yq)this.a.q()));
                }
                n(i8);
            }
            throw zzaae.a();
        }
        list.add(Integer.valueOf((yq)this.a.q()));
        while (this.a.i()) {
            i2 = this.a.c();
            list.add(Integer.valueOf((yq)this.a.q()));
        }
    }

    public final void J(List<Boolean> list) {
        int i2;
        int i;
        int i3;
        int obj3;
        i3 = 2;
        Object obj = list;
        obj3 &= 7;
        if (list instanceof oq && obj3 != null) {
            obj = list;
            obj3 &= 7;
            if (obj3 != null) {
                if (obj3 != i3) {
                } else {
                    i7 += obj3;
                    (oq)(oq)obj.d(this.a.j());
                    while (this.a.a() >= i8) {
                        obj.d(this.a.j());
                    }
                    n(i8);
                }
                throw zzaae.a();
            }
            obj.d(this.a.j());
            while (this.a.i()) {
                obj3 = this.a.c();
                obj.d(this.a.j());
            }
        }
        i4 &= 7;
        if (i2 != 0) {
            if (i2 != i3) {
            } else {
                i5 += i;
                list.add(Boolean.valueOf(this.a.j()));
                while (this.a.a() >= i6) {
                    list.add(Boolean.valueOf(this.a.j()));
                }
                n(i6);
            }
            throw zzaae.a();
        }
        list.add(Boolean.valueOf(this.a.j()));
        while (this.a.i()) {
            i2 = this.a.c();
            list.add(Boolean.valueOf(this.a.j()));
        }
    }

    public final <T> void K(List<T> list, com.google.android.gms.internal.firebase-auth-api.l0<T> l02, com.google.android.gms.internal.firebase-auth-api.lr lr3) {
        int i;
        final int i2 = this.b;
        if (i2 & 7 != 2) {
        }
        throw zzaae.a();
    }

    public final void L(List<Float> list) {
        int i3;
        int i2;
        int i4;
        int i5;
        int i;
        Object obj5;
        i4 = 5;
        final int i10 = 2;
        if (list instanceof sr) {
            i2 = list;
            obj5 &= 7;
            if (obj5 != i10 && obj5 == i4) {
                if (obj5 != i4) {
                }
                throw zzaae.a();
            }
            obj5 = (yq)this.a.q();
            ar.p(obj5);
            (sr)i2.d(Float.intBitsToFloat((yq)this.a.p()));
            while (this.a.a() >= i5 + obj5) {
                i2.d(Float.intBitsToFloat((yq)this.a.p()));
            }
        } else {
            i6 &= 7;
            if (i3 != i10 && i3 == i4) {
                if (i3 != i4) {
                }
                throw zzaae.a();
            }
            i2 = (yq)this.a.q();
            ar.p(i2);
            list.add(Float.valueOf(Float.intBitsToFloat((yq)this.a.p())));
            while (this.a.a() >= i9 += i2) {
                list.add(Float.valueOf(Float.intBitsToFloat((yq)this.a.p())));
            }
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final int a() {
        o(0);
        return (yq)this.a.q();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final int c() {
        o(5);
        return (yq)this.a.p();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final int d() {
        o(0);
        return (yq)this.a.q();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final com.google.android.gms.internal.firebase-auth-api.wq e() {
        o(2);
        return this.a.d();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final long f() {
        o(0);
        return zq.m((yq)this.a.s());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final long g() {
        o(0);
        return (yq)this.a.s();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final long h() {
        o(0);
        return (yq)this.a.s();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final long i() {
        o(1);
        return (yq)this.a.r();
    }

    public final void j(List<String> list, boolean z2) {
        boolean z;
        String str;
        int i;
        Object obj3;
        int obj4;
        if (i2 &= 7 != 2) {
        } else {
            if (!list instanceof i) {
            } else {
                if (z2 == 0) {
                    (i)list.x(e());
                    while (this.a.i()) {
                        obj3 = this.a.c();
                        obj.x(e());
                    }
                }
            }
            while (z2 != 0) {
                str = m();
                list.add(str);
                z = this.a.c();
                str = q();
            }
        }
        throw zzaae.a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final String m() {
        o(2);
        return this.a.f();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final String q() {
        o(2);
        return this.a.e();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final boolean r() {
        o(0);
        return this.a.j();
    }

    public final void s(List<Integer> list) {
        int i3;
        int i;
        int i2;
        int obj3;
        i2 = 2;
        Object obj = list;
        obj3 &= 7;
        if (list instanceof yr && obj3 != null) {
            obj = list;
            obj3 &= 7;
            if (obj3 != null) {
                if (obj3 != i2) {
                } else {
                    i9 += obj3;
                    (yr)(yr)obj.g((yq)this.a.q());
                    while (this.a.a() >= i10) {
                        obj.g((yq)this.a.q());
                    }
                    n(i10);
                }
                throw zzaae.a();
            }
            obj.g((yq)this.a.q());
            while (this.a.i()) {
                obj3 = this.a.c();
                obj.g((yq)this.a.q());
            }
        }
        i4 &= 7;
        if (i3 != 0) {
            if (i3 != i2) {
            } else {
                i7 += i;
                list.add(Integer.valueOf((yq)this.a.q()));
                while (this.a.a() >= i8) {
                    list.add(Integer.valueOf((yq)this.a.q()));
                }
                n(i8);
            }
            throw zzaae.a();
        }
        list.add(Integer.valueOf((yq)this.a.q()));
        while (this.a.i()) {
            i3 = this.a.c();
            list.add(Integer.valueOf((yq)this.a.q()));
        }
    }

    public final void t(List<Long> list) {
        int i3;
        int i2;
        int i;
        long l;
        int obj5;
        i = 2;
        Object obj = list;
        obj5 &= 7;
        if (list instanceof n && obj5 != null) {
            obj = list;
            obj5 &= 7;
            if (obj5 != null) {
                if (obj5 != i) {
                } else {
                    i7 += obj5;
                    (n)(n)obj.g((yq)this.a.s());
                    while (this.a.a() >= i8) {
                        obj.g((yq)this.a.s());
                    }
                    n(i8);
                }
                throw zzaae.a();
            }
            obj.g((yq)this.a.s());
            while (this.a.i()) {
                obj5 = this.a.c();
                obj.g((yq)this.a.s());
            }
        }
        i4 &= 7;
        if (i3 != 0) {
            if (i3 != i) {
            } else {
                i5 += i2;
                list.add(Long.valueOf((yq)this.a.s()));
                while (this.a.a() >= i6) {
                    list.add(Long.valueOf((yq)this.a.s()));
                }
                n(i6);
            }
            throw zzaae.a();
        }
        list.add(Long.valueOf((yq)this.a.s()));
        while (this.a.i()) {
            i3 = this.a.c();
            list.add(Long.valueOf((yq)this.a.s()));
        }
    }

    public final <T> T u(com.google.android.gms.internal.firebase-auth-api.l0<T> l0, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        o(2);
        return l(l0, lr2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final boolean v() {
        boolean z;
        int i;
        z = this.b;
        if (!this.a.i() && z == this.c) {
            z = this.b;
            if (z == this.c) {
            }
            return this.a.k(z);
        }
        return 0;
    }

    public final void w(List<Long> list) {
        int i;
        int i3;
        int i2;
        long l;
        int obj5;
        i2 = 2;
        Object obj = list;
        obj5 &= 7;
        if (list instanceof n && obj5 != null) {
            obj = list;
            obj5 &= 7;
            if (obj5 != null) {
                if (obj5 != i2) {
                } else {
                    i7 += obj5;
                    (n)(n)obj.g((yq)this.a.s());
                    while (this.a.a() >= i8) {
                        obj.g((yq)this.a.s());
                    }
                    n(i8);
                }
                throw zzaae.a();
            }
            obj.g((yq)this.a.s());
            while (this.a.i()) {
                obj5 = this.a.c();
                obj.g((yq)this.a.s());
            }
        }
        i4 &= 7;
        if (i != 0) {
            if (i != i2) {
            } else {
                i5 += i3;
                list.add(Long.valueOf((yq)this.a.s()));
                while (this.a.a() >= i6) {
                    list.add(Long.valueOf((yq)this.a.s()));
                }
                n(i6);
            }
            throw zzaae.a();
        }
        list.add(Long.valueOf((yq)this.a.s()));
        while (this.a.i()) {
            i = this.a.c();
            list.add(Long.valueOf((yq)this.a.s()));
        }
    }

    public final void x(List<Double> list) {
        int i2;
        int i4;
        int i;
        int i3;
        int longBitsToDouble;
        int obj5;
        i = 2;
        longBitsToDouble = 1;
        i4 = list;
        obj5 &= 7;
        if (list instanceof ir && obj5 != longBitsToDouble) {
            i4 = list;
            obj5 &= 7;
            if (obj5 != longBitsToDouble) {
                if (obj5 != i) {
                } else {
                    obj5 = (yq)this.a.q();
                    ar.M(obj5);
                    (ir)(ir)i4.d(Double.longBitsToDouble((yq)this.a.r()));
                    while (this.a.a() >= i7 += obj5) {
                        i4.d(Double.longBitsToDouble((yq)this.a.r()));
                    }
                }
                throw zzaae.a();
            }
            i4.d(Double.longBitsToDouble((yq)this.a.r()));
            while (this.a.i()) {
                obj5 = this.a.c();
                i4.d(Double.longBitsToDouble((yq)this.a.r()));
            }
        }
        i5 &= 7;
        if (i2 != longBitsToDouble) {
            if (i2 != i) {
            } else {
                i4 = (yq)this.a.q();
                ar.M(i4);
                list.add(Double.valueOf(Double.longBitsToDouble((yq)this.a.r())));
                while (this.a.a() >= i6 += i4) {
                    list.add(Double.valueOf(Double.longBitsToDouble((yq)this.a.r())));
                }
            }
            throw zzaae.a();
        }
        list.add(Double.valueOf(Double.longBitsToDouble((yq)this.a.r())));
        while (this.a.i()) {
            i2 = this.a.c();
            list.add(Double.valueOf(Double.longBitsToDouble((yq)this.a.r())));
        }
    }

    public final void y(List<com.google.android.gms.internal.firebase-auth-api.wq> list) {
        int i2;
        int i;
        if (i3 &= 7 != 2) {
        }
        throw zzaae.a();
    }

    public final void z(List<Integer> list) {
        int i3;
        int i2;
        int i;
        int obj3;
        i = 2;
        Object obj = list;
        obj3 &= 7;
        if (list instanceof yr && obj3 != null) {
            obj = list;
            obj3 &= 7;
            if (obj3 != null) {
                if (obj3 != i) {
                } else {
                    i9 += obj3;
                    (yr)(yr)obj.g((yq)this.a.q());
                    while (this.a.a() >= i10) {
                        obj.g((yq)this.a.q());
                    }
                    n(i10);
                }
                throw zzaae.a();
            }
            obj.g((yq)this.a.q());
            while (this.a.i()) {
                obj3 = this.a.c();
                obj.g((yq)this.a.q());
            }
        }
        i4 &= 7;
        if (i3 != 0) {
            if (i3 != i) {
            } else {
                i7 += i2;
                list.add(Integer.valueOf((yq)this.a.q()));
                while (this.a.a() >= i8) {
                    list.add(Integer.valueOf((yq)this.a.q()));
                }
                n(i8);
            }
            throw zzaae.a();
        }
        list.add(Integer.valueOf((yq)this.a.q()));
        while (this.a.i()) {
            i3 = this.a.c();
            list.add(Integer.valueOf((yq)this.a.q()));
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final double zza() {
        o(1);
        return Double.longBitsToDouble((yq)this.a.r());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final float zzb() {
        o(5);
        return Float.intBitsToFloat((yq)this.a.p());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final int zzc() {
        int i;
        int i2;
        i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.c();
        }
        if (i != 0 && i == this.c) {
            if (i == this.c) {
            }
            return i >>>= 3;
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final int zzh() {
        o(5);
        return (yq)this.a.p();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final int zzi() {
        o(0);
        return zq.l((yq)this.a.q());
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final int zzj() {
        o(0);
        return (yq)this.a.q();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.k0
    public final long zzk() {
        o(1);
        return (yq)this.a.r();
    }
}
