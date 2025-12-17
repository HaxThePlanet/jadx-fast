package net.time4j;

import java.util.Objects;
import net.time4j.engine.ChronoException;
import net.time4j.engine.d0;
import net.time4j.engine.h;
import net.time4j.engine.i0;
import net.time4j.engine.l;
import net.time4j.engine.m;
import net.time4j.engine.m0;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.tz.k;
import net.time4j.tz.l;

/* loaded from: classes3.dex */
public final class s<C>  implements o, m0 {

    private final l<?> a = null;
    private final m<?, ?> b = null;
    private final net.time4j.h0 c = null;
    private s(l<?> l, m<?, ?> m2, net.time4j.h0 h03) {
        int i;
        q obj3;
        h obj4;
        int obj5;
        super();
        final int i2 = 24;
        if (h03.s() == i2) {
            obj5 = 0;
            i = 1;
            if (l == null) {
                this.b = m2.T(h.e(i));
            } else {
                this.a = l.L(h.e(i));
            }
            this.c = h0.H0();
        } else {
            this.a = l;
            this.b = m2;
        }
    }

    public static <C extends l<C>> net.time4j.s<C> b(C c, net.time4j.h0 h02) {
        Objects.requireNonNull(c, "Missing date component.");
        s sVar = new s(c, 0, h02);
        return sVar;
    }

    public static <C extends m<?, C>> net.time4j.s<C> c(C c, net.time4j.h0 h02) {
        Objects.requireNonNull(c, "Missing date component.");
        s sVar = new s(0, c, h02);
        return sVar;
    }

    private o f() {
        q lVar;
        if (this.a == null) {
            lVar = this.b;
        }
        return lVar;
    }

    @Override // net.time4j.engine.o
    public net.time4j.b0 a(l l, d0 d02) {
        net.time4j.i0 i0Var;
        net.time4j.h0 h0Var;
        int obj6;
        l lVar = this.a;
        if (lVar == null) {
            i0Var = (g0)this.b.W(g0.class).r0(this.c);
        } else {
            i0Var = (g0)lVar.N(g0.class).r0(this.c);
        }
        intValue -= obj6;
        int i2 = 1;
        if (i >= 86400) {
            i0Var = obj6;
        } else {
            if (i < 0) {
                i0Var = obj6;
            }
        }
        return i0Var.a0(l);
    }

    public C d() {
        q lVar;
        if (this.a == null) {
            lVar = this.b;
        }
        return lVar;
    }

    public int e(p<Integer> p) {
        o oVar;
        int obj2;
        if (p.isDateElement()) {
            obj2 = f().e(p);
        } else {
            obj2 = this.c.e(p);
        }
        return obj2;
    }

    @Override // net.time4j.engine.o
    public boolean equals(Object object) {
        int i;
        q lVar;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        obj5 = s.class.cast(object);
        if (object instanceof s && !this.c.equals(obj5.c)) {
            obj5 = s.class.cast(object);
            if (!this.c.equals(obj5.c)) {
                return i2;
            }
            l lVar2 = this.a;
            if (lVar2 == null) {
                if (obj5.a == null && this.b.equals(obj5.b)) {
                    if (this.b.equals(obj5.b)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
                return i;
            }
            if (obj5.b == null && lVar2.equals(obj5.a)) {
                if (lVar2.equals(obj5.a)) {
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
    public int hashCode() {
        int i;
        l lVar = this.a;
        if (lVar == null) {
            i = this.b.hashCode();
        } else {
            i = lVar.hashCode();
        }
        return i += i3;
    }

    @Override // net.time4j.engine.o
    public boolean j() {
        return 0;
    }

    public <V> V p(p<V> p) {
        o oVar;
        Object obj2;
        if (p.isDateElement()) {
            obj2 = f().p(p);
        } else {
            obj2 = this.c.p(p);
        }
        return obj2;
    }

    public <V> V r(p<V> p) {
        o oVar;
        Object obj2;
        if (p.isDateElement()) {
            obj2 = f().r(p);
        } else {
            obj2 = this.c.r(p);
        }
        return obj2;
    }

    @Override // net.time4j.engine.o
    public k t() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Timezone not available: ");
        stringBuilder.append(this);
        ChronoException chronoException = new ChronoException(stringBuilder.toString());
        throw chronoException;
    }

    @Override // net.time4j.engine.o
    public String toString() {
        q lVar;
        StringBuilder stringBuilder = new StringBuilder();
        lVar = this.a;
        if (lVar == null) {
            stringBuilder.append(this.b);
        } else {
            stringBuilder.append(lVar);
        }
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    public boolean v(p<?> p) {
        o oVar;
        boolean obj2;
        if (p.isDateElement()) {
            obj2 = f().v(p);
        } else {
            obj2 = this.c.v(p);
        }
        return obj2;
    }

    public <V> V w(p<V> p) {
        o oVar;
        Object obj2;
        if (p.isDateElement()) {
            obj2 = f().w(p);
        } else {
            obj2 = this.c.w(p);
        }
        return obj2;
    }
}
