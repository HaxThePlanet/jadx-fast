package net.time4j;

import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.i1.f;
import net.time4j.i1.g;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
public final class b1 implements o, g {

    private final net.time4j.b0 a;
    private final l b;
    private final transient net.time4j.i0 c;
    private b1(net.time4j.b0 b0, l l2) {
        int z;
        super();
        this.b = l2;
        p obj4 = l2.B(b0);
        if (b0.m0()) {
            if (obj4.n() != 0) {
            } else {
                if (i %= 60 != 0) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Leap second can only be represented  with timezone-offset in full minutes: ");
            stringBuilder.append(obj4);
            IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
            throw obj3;
        }
        this.a = b0;
        this.c = i0.W(b0, obj4);
    }

    static net.time4j.b1 d(net.time4j.b0 b0, l l2) {
        b1 b1Var = new b1(b0, l2);
        return b1Var;
    }

    @Override // net.time4j.engine.o
    public int a() {
        return this.a.a();
    }

    @Override // net.time4j.engine.o
    public p b() {
        return this.b.B(this.a);
    }

    @Override // net.time4j.engine.o
    public boolean c() {
        return this.a.m0();
    }

    public int e(p<Integer> p) {
        boolean z;
        int i;
        if (this.a.m0() && p == h0.Q) {
            if (p == h0.Q) {
                return 60;
            }
        }
        if (this.c.e(p) == Integer.MIN_VALUE) {
            i = this.a.e(p);
        }
        return i;
    }

    @Override // net.time4j.engine.o
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof b1) {
            if (this.a.equals(object.a) && this.b.equals(object.b)) {
                if (this.b.equals(object.b)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.engine.o
    public long f(f f) {
        return this.a.f(f);
    }

    @Override // net.time4j.engine.o
    public int hashCode() {
        return i ^= i3;
    }

    @Override // net.time4j.engine.o
    public boolean j() {
        return 1;
    }

    @Override // net.time4j.engine.o
    public int n(f f) {
        return this.a.n(f);
    }

    public <V> V p(p<V> p) {
        boolean z;
        if (this.a.m0() && p == h0.Q) {
            if (p == h0.Q) {
                return p.getType().cast(60);
            }
        }
        if (this.c.v(p)) {
            return this.c.p(p);
        }
        return this.a.p(p);
    }

    public <V> V r(p<V> p) {
        Object obj;
        net.time4j.l0 l0Var;
        int i;
        net.time4j.n0 sECONDS;
        if (this.c.v(p)) {
            obj = this.c.r(p);
        } else {
            obj = this.a.r(p);
        }
        l0Var = this.c.G(p, obj);
        if (p == h0.Q && this.c.m() >= 1972 && !this.b.K((i0)l0Var, l0Var) && l0Var.a0(this.b).q0(1, obj3).m0()) {
            if (this.c.m() >= 1972) {
                l0Var = this.c.G(p, obj);
                if (!this.b.K((i0)l0Var, l0Var)) {
                    if (l0Var.a0(this.b).q0(1, obj3).m0()) {
                        return p.getType().cast(60);
                    }
                }
            }
        }
        return obj;
    }

    @Override // net.time4j.engine.o
    public k t() {
        return this.b.z();
    }

    @Override // net.time4j.engine.o
    public String toString() {
        int str;
        k kVar;
        boolean z;
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append(this.c.X());
        stringBuilder.append('T');
        int i3 = this.c.s();
        int i6 = 48;
        final int i7 = 10;
        if (i3 < i7) {
            stringBuilder.append(i6);
        }
        stringBuilder.append(i3);
        int i4 = 58;
        stringBuilder.append(i4);
        int i8 = this.c.i();
        if (i8 < i7) {
            stringBuilder.append(i6);
        }
        stringBuilder.append(i8);
        stringBuilder.append(i4);
        if (c()) {
            stringBuilder.append("60");
        } else {
            str = this.c.u();
            if (str < i7) {
                stringBuilder.append(i6);
            }
            stringBuilder.append(str);
        }
        int i5 = this.c.a();
        if (i5 != 0) {
            h0.O0(stringBuilder, i5);
        }
        stringBuilder.append(b());
        kVar = t();
        if (!kVar instanceof p) {
            stringBuilder.append('[');
            stringBuilder.append(kVar.a());
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    public boolean v(p<?> p) {
        net.time4j.b0 z;
        int obj2;
        if (!this.c.v(p)) {
            if (this.a.v(p)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public <V> V w(p<V> p) {
        if (this.c.v(p)) {
            return this.c.w(p);
        }
        return this.a.w(p);
    }

    @Override // net.time4j.engine.o
    public long x() {
        return this.a.x();
    }
}
