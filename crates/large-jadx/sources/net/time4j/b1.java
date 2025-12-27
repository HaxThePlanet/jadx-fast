package net.time4j;

import net.time4j.engine.o;
import net.time4j.engine.q;
import net.time4j.i1.f;
import net.time4j.i1.g;
import net.time4j.tz.k;
import net.time4j.tz.l;

/* compiled from: ZonalDateTime.java */
/* loaded from: classes3.dex */
public final class b1 implements o, g {

    private final b0 a = new IllegalArgumentException();
    private final l b;
    private final transient i0 c;
    private b1(b0 b0Var, l lVar) {
        super();
        this.b = lVar;
        net.time4j.tz.p pVar = lVar.B(b0Var);
        if (pVar.n() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Leap second can only be represented  with timezone-offset in full minutes: ";
            lVar = str + pVar;
            throw new IllegalArgumentException(lVar);
        }
    }

    static b1 d(b0 b0Var, l lVar) {
        return new b1(b0Var, lVar);
    }

    public int a() {
        return this.a.a();
    }

    public net.time4j.tz.p b() {
        return this.b.B(this.a);
    }

    public boolean c() {
        return this.a.m0();
    }

    public int e(net.time4j.engine.p<Integer> pVar) {
        int i;
        if (this.a.m0() && pVar == h0.Q) {
            return 60;
        }
        if (this.c.e(pVar) == -2147483648) {
            i = this.a.e(pVar);
        }
        return i;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        boolean equals2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof b1) {
            if (this.a.equals(object.a)) {
                if (!(this.b.equals(object.b))) {
                }
            }
            return z;
        }
        return false;
    }

    public long f(f fVar) {
        return this.a.f(fVar);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public int n(f fVar) {
        return this.a.n(fVar);
    }

    public <V> V p(net.time4j.engine.p<V> pVar) {
        if (this.a.m0() && pVar == h0.Q) {
            return pVar.getType().cast(60);
        }
        if (this.c.v(pVar)) {
            return this.c.p(pVar);
        }
        return this.a.p(pVar);
    }

    public <V> V r(net.time4j.engine.p<V> pVar) {
        Object obj;
        if (this.c.v(pVar)) {
            obj = this.c.r(pVar);
        } else {
            obj = this.a.r(pVar);
        }
        if (pVar == h0.Q) {
            int i = 1972;
            if (this.c.m() >= 1972) {
                q qVar = this.c.G(pVar, obj);
                if (!this.b.K(qVar, qVar)) {
                    if (qVar.a0(this.b).q0(1L, n0.SECONDS).m0()) {
                        return pVar.getType().cast(60);
                    }
                }
            }
        }
        return obj;
    }

    public k t() {
        return this.b.z();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append(this.c.X());
        stringBuilder.append('T');
        int i4 = this.c.s();
        char c3 = '0';
        final int i6 = 10;
        if (i4 < i6) {
            stringBuilder.append(c3);
        }
        stringBuilder.append(i4);
        char c = ':';
        stringBuilder.append(c);
        int i7 = this.c.i();
        if (i7 < i6) {
            stringBuilder.append(c3);
        }
        stringBuilder.append(i7);
        stringBuilder.append(c);
        if (c()) {
            stringBuilder.append("60");
        } else {
            int i = this.c.u();
            if (i < i6) {
                stringBuilder.append(c3);
            }
            stringBuilder.append(i);
        }
        int i5 = this.c.a();
        if (i5 != 0) {
            h0.O0(stringBuilder, i5);
        }
        stringBuilder.append(b());
        k kVar = t();
        z = kVar instanceof p;
        if (!(kVar instanceof p)) {
            stringBuilder.append('[');
            stringBuilder.append(kVar.a());
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    public boolean v(net.time4j.engine.p<?> pVar) {
        boolean z;
        boolean z3 = false;
        if (!this.c.v(pVar)) {
            if (this.a.v(pVar)) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z3;
    }

    public <V> V w(net.time4j.engine.p<V> pVar) {
        if (this.c.v(pVar)) {
            return this.c.w(pVar);
        }
        return this.a.w(pVar);
    }

    public long x() {
        return this.a.x();
    }

    public boolean j() {
        return true;
    }
}
