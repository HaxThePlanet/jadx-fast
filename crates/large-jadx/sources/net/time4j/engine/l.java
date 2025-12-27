package net.time4j.engine;

import java.io.Serializable;
import net.time4j.f1.c;

/* compiled from: CalendarVariant.java */
/* loaded from: classes3.dex */
public abstract class l<D extends l<D>> extends q<D> implements g, m0, Comparable<D>, Serializable {
    private <T> T M(k<T> kVar, String str) {
        long l = c();
        long l2 = kVar.d();
        if (l2 > l) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str3 = "Cannot transform <";
            str = "> to: ";
            str = str3 + l + str + str;
            throw new ArithmeticException(str);
        } else {
            long l3 = kVar.c();
            if (l3 >= l) {
                return kVar.a(l);
            }
        }
    }

    @Override // net.time4j.engine.q
    <V> y<D, V> B(p<V> pVar) {
        if (pVar instanceof z) {
            return (z)z.class.cast(pVar).derive(J());
        }
        return super.B(pVar);
    }

    @Override // net.time4j.engine.q
    public int I(D d) {
        long l = c();
        final long l2 = d.c();
        if (l < l2) {
            return -1;
        }
        if (l > l2) {
            return 1;
        }
        return k().compareTo(d.k());
    }

    @Override // net.time4j.engine.q
    protected k<D> J() {
        return K().k(k());
    }

    @Override // net.time4j.engine.q
    public D L(h hVar) {
        try {
        } catch (java.lang.IllegalArgumentException iae) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Out of range: ");
            stringBuilder.append(str);
            long str = stringBuilder.toString();
            java.lang.ArithmeticException arithmeticException = new ArithmeticException(str);
            arithmeticException.initCause(iae);
            throw arithmeticException;
        }
        return (l)J().a(c.f(c(), hVar.c()));
    }

    @Override // net.time4j.engine.q
    public <T extends m<?, T>> T N(Class<T> cls) {
        String name = cls.getName();
        net.time4j.engine.w wVar = w.y(cls);
        if (wVar == null) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Cannot find any chronology for given target type: ";
            r0 = str + name;
            throw new IllegalArgumentException(r0);
        } else {
            return (m)M(wVar.j(), name);
        }
    }

    @Override // net.time4j.engine.q
    public long c() {
        return J().b(z());
    }

    @Override // net.time4j.engine.q
    protected abstract j<D> K();

    @Override // net.time4j.engine.q
    public abstract boolean equals(Object object);

    @Override // net.time4j.engine.q
    public abstract int hashCode();
}
