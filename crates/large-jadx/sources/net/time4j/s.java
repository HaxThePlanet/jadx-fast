package net.time4j;

import java.util.Objects;
import net.time4j.engine.ChronoException;
import net.time4j.engine.d0;
import net.time4j.engine.h;
import net.time4j.engine.i0;
import net.time4j.engine.m;
import net.time4j.engine.m0;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.tz.k;

/* compiled from: GeneralTimestamp.java */
/* loaded from: classes3.dex */
public final class s<C> implements o, m0 {

    private final net.time4j.engine.l<?> a = null;
    private final m<?, ?> b = null;
    private final h0 c = null;
    private s(net.time4j.engine.l<?> lVar, m<?, ?> mVar, h0 h0Var) {
        h hVar;
        super();
        final int i3 = 24;
        if (h0Var.s() == i3) {
            int i2 = 0;
            int i = 1;
            if (lVar == null) {
                this.b = mVar.T(h.e(i));
            } else {
                this.a = lVar.L(h.e(i));
            }
            this.c = h0.H0();
        } else {
            this.a = lVar;
            this.b = mVar;
        }
    }

    public static <C extends net.time4j.engine.l<C>> s<C> b(C c, h0 h0Var) {
        Objects.requireNonNull(c, "Missing date component.");
        return new s(c, null, h0Var);
    }

    public static <C extends m<?, C>> s<C> c(C c, h0 h0Var) {
        Objects.requireNonNull(c, "Missing date component.");
        return new s(null, c, h0Var);
    }

    private o f() {
        net.time4j.engine.l lVar;
        if (this.a == null) {
        }
        return lVar;
    }

    public b0 a(net.time4j.tz.l lVar, d0 d0Var) {
        net.time4j.i0 i0Var;
        if (this.a == null) {
            i0Var = (g0)this.b.W(g0.class).r0(this.c);
        } else {
            i0Var = (g0)this.a.N(g0.class).r0(this.c);
        }
        int i2 = (Integer)this.c.p(h0.R).intValue() - (d0Var.b(i0Var.X(), lVar.z()));
        int i = 86400;
        long l = 1L;
        if (g0.class >= 86400) {
        } else {
            if (g0.class < 0) {
            }
        }
        return i0Var.a0(lVar);
    }

    public C d() {
        net.time4j.engine.l lVar;
        if (this.a == null) {
        }
        return lVar;
    }

    public int e(p<Integer> pVar) {
        int i;
        if (pVar.isDateElement()) {
            i = f().e(pVar);
        } else {
            i = this.c.e(pVar);
        }
        return i;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        net.time4j.engine.l lVar;
        Object cast;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof s) {
            cast = s.class.cast(object);
            if (!this.c.equals(cast.c)) {
                return false;
            }
            if (this.a == null) {
                if (cast.a == null) {
                    if (!(this.b.equals(cast.b))) {
                    }
                }
                return z;
            }
            if (cast.b == null) {
                if (!(this.a.equals(cast.a))) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        if (this.a == null) {
            i = this.b.hashCode();
        } else {
            i = this.a.hashCode();
        }
        return i + this.c.hashCode();
    }

    public <V> V p(p<V> pVar) {
        Object obj;
        if (pVar.isDateElement()) {
            obj = f().p(pVar);
        } else {
            obj = this.c.p(pVar);
        }
        return obj;
    }

    public <V> V r(p<V> pVar) {
        Object obj;
        if (pVar.isDateElement()) {
            obj = f().r(pVar);
        } else {
            obj = this.c.r(pVar);
        }
        return obj;
    }

    public k t() throws ChronoException {
        StringBuilder stringBuilder = new StringBuilder();
        final String str = "Timezone not available: ";
        r1 = str + this;
        throw new ChronoException(r1);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.a == null) {
            stringBuilder.append(this.b);
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    public boolean v(p<?> pVar) {
        boolean z;
        if (pVar.isDateElement()) {
            z = f().v(pVar);
        } else {
            z = this.c.v(pVar);
        }
        return z;
    }

    public <V> V w(p<V> pVar) {
        Object obj;
        if (pVar.isDateElement()) {
            obj = f().w(pVar);
        } else {
            obj = this.c.w(pVar);
        }
        return obj;
    }

    public boolean j() {
        return false;
    }
}
