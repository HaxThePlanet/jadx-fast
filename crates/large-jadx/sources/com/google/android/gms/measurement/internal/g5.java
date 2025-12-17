package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class g5 {

    private long A;
    private long B;
    private String C;
    private boolean D;
    private long E;
    private long F;
    private final com.google.android.gms.measurement.internal.b5 a;
    private final String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;
    private long h;
    private long i;
    private String j;
    private long k;
    private String l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private boolean q;
    private String r;
    private Boolean s;
    private long t;
    private List<String> u;
    private String v;
    private long w;
    private long x;
    private long y;
    private long z;
    g5(com.google.android.gms.measurement.internal.b5 b5, String string2) {
        super();
        r.j(b5);
        r.f(string2);
        this.a = b5;
        this.b = string2;
        b5.a().h();
    }

    public final long A() {
        this.a.a().h();
        return this.p;
    }

    public final void B(String string) {
        this.a.a().h();
        this.D = z |= i2;
        this.C = string;
    }

    public final void C(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.i = l;
    }

    public final void D(long l) {
        int i2;
        int i;
        final int i5 = 0;
        i2 = Long.compare(l, i3) >= 0 ? i : i5;
        r.a(i2);
        this.a.a().h();
        if (Long.compare(l2, l) != 0) {
        } else {
            i = i5;
        }
        this.D = z |= i;
        this.g = l;
    }

    public final void E(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.h = l;
    }

    public final void F(boolean z) {
        int i;
        this.a.a().h();
        i = this.o != z ? 1 : 0;
        this.D = z2 |= i;
        this.o = z;
    }

    public final void G(Boolean boolean) {
        boolean equals;
        this.a.a().h();
        Boolean bool = this.s;
        int i3 = ia.i;
        int i4 = 1;
        if (bool == null && boolean == null) {
            if (boolean == null) {
                equals = i4;
            } else {
                if (bool == null) {
                    equals = 0;
                } else {
                    equals = bool.equals(boolean);
                }
            }
        } else {
        }
        this.D = z |= i2;
        this.s = boolean;
    }

    public final void H(String string) {
        this.a.a().h();
        this.D = z |= i2;
        this.e = string;
    }

    public final void I(List<String> list) {
        List equals;
        ArrayList arrayList;
        this.a.a().h();
        equals = this.u;
        final int i2 = ia.i;
        if (equals == null) {
            if (list != null) {
                if (equals == null) {
                } else {
                    if (equals.equals(list)) {
                    }
                }
            }
        } else {
        }
        this.D = true;
        if (list != null) {
            arrayList = new ArrayList(list);
        } else {
            arrayList = 0;
        }
        this.u = arrayList;
    }

    public final boolean J() {
        this.a.a().h();
        return this.q;
    }

    public final boolean K() {
        this.a.a().h();
        return this.o;
    }

    public final boolean L() {
        this.a.a().h();
        return this.D;
    }

    public final long M() {
        this.a.a().h();
        return this.k;
    }

    public final long N() {
        this.a.a().h();
        return this.E;
    }

    public final long O() {
        this.a.a().h();
        return this.z;
    }

    public final long P() {
        this.a.a().h();
        return this.A;
    }

    public final long Q() {
        this.a.a().h();
        return this.y;
    }

    public final long R() {
        this.a.a().h();
        return this.x;
    }

    public final long S() {
        this.a.a().h();
        return this.B;
    }

    public final long T() {
        this.a.a().h();
        return this.w;
    }

    public final long U() {
        this.a.a().h();
        return this.n;
    }

    public final long V() {
        this.a.a().h();
        return this.t;
    }

    public final long W() {
        this.a.a().h();
        return this.F;
    }

    public final long X() {
        this.a.a().h();
        return this.m;
    }

    public final long Y() {
        this.a.a().h();
        return this.i;
    }

    public final long Z() {
        this.a.a().h();
        return this.g;
    }

    public final String a() {
        this.a.a().h();
        return this.C;
    }

    public final long a0() {
        this.a.a().h();
        return this.h;
    }

    public final String b() {
        this.a.a().h();
        return this.e;
    }

    public final Boolean b0() {
        this.a.a().h();
        return this.s;
    }

    public final List<String> c() {
        this.a.a().h();
        return this.u;
    }

    public final String c0() {
        this.a.a().h();
        return this.r;
    }

    public final void d() {
        this.a.a().h();
        this.D = false;
    }

    public final String d0() {
        this.a.a().h();
        B(0);
        return this.C;
    }

    public final void e() {
        int i;
        Object obj;
        int cmp;
        this.a.a().h();
        if (Long.compare(i, i3) > 0) {
            this.a.b().w().b("Bundle index overflow. appId", q3.z(this.b));
            i = 0;
        }
        this.D = true;
        this.g = i;
    }

    public final String e0() {
        this.a.a().h();
        return this.b;
    }

    public final void f(String string) {
        java.lang.CharSequence obj4;
        this.a.a().h();
        int i2 = 1;
        if (i2 == TextUtils.isEmpty(string)) {
            obj4 = 0;
        }
        this.D = z |= i3;
        this.r = obj4;
    }

    public final String f0() {
        this.a.a().h();
        return this.c;
    }

    public final void g(boolean z) {
        int i;
        this.a.a().h();
        i = this.q != z ? 1 : 0;
        this.D = z2 |= i;
        this.q = z;
    }

    public final String g0() {
        this.a.a().h();
        return this.l;
    }

    public final void h(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.p = l;
    }

    public final String h0() {
        this.a.a().h();
        return this.j;
    }

    public final void i(String string) {
        this.a.a().h();
        this.D = z |= i2;
        this.c = string;
    }

    public final String i0() {
        this.a.a().h();
        return this.f;
    }

    public final void j(String string) {
        this.a.a().h();
        this.D = z |= i2;
        this.l = string;
    }

    public final String j0() {
        this.a.a().h();
        return this.v;
    }

    public final void k(String string) {
        this.a.a().h();
        this.D = z |= i2;
        this.j = string;
    }

    public final String k0() {
        this.a.a().h();
        return this.d;
    }

    public final void l(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.k = l;
    }

    public final void m(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.E = l;
    }

    public final void n(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.z = l;
    }

    public final void o(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.A = l;
    }

    public final void p(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.y = l;
    }

    public final void q(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.x = l;
    }

    public final void r(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.B = l;
    }

    public final void s(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.w = l;
    }

    public final void t(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.n = l;
    }

    public final void u(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.t = l;
    }

    public final void v(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.F = l;
    }

    public final void w(String string) {
        this.a.a().h();
        this.D = z |= i2;
        this.f = string;
    }

    public final void x(String string) {
        java.lang.CharSequence obj4;
        this.a.a().h();
        int i2 = 1;
        if (i2 == TextUtils.isEmpty(string)) {
            obj4 = 0;
        }
        this.D = z |= i3;
        this.v = obj4;
    }

    public final void y(String string) {
        java.lang.CharSequence obj4;
        this.a.a().h();
        int i2 = 1;
        if (i2 == TextUtils.isEmpty(string)) {
            obj4 = 0;
        }
        this.D = z |= i3;
        this.d = obj4;
    }

    public final void z(long l) {
        int i;
        this.a.a().h();
        i = Long.compare(l2, l) != 0 ? 1 : 0;
        this.D = z |= i;
        this.m = l;
    }
}
