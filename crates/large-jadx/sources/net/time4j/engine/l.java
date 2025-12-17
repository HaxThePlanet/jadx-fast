package net.time4j.engine;

import java.io.Serializable;
import net.time4j.f1.c;

/* loaded from: classes3.dex */
public abstract class l<D extends net.time4j.engine.l<D>>  extends net.time4j.engine.q<D> implements net.time4j.engine.g, net.time4j.engine.m0, Comparable<D>, Serializable {
    private <T> T M(net.time4j.engine.k<T> k, String string2) {
        int cmp;
        long l = c();
        if (Long.compare(l2, l) > 0) {
        } else {
            if (Long.compare(l3, l) < 0) {
            } else {
                return k.a(l);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot transform <");
        stringBuilder.append(l);
        stringBuilder.append("> to: ");
        stringBuilder.append(string2);
        ArithmeticException obj5 = new ArithmeticException(stringBuilder.toString());
        throw obj5;
    }

    <V> net.time4j.engine.y<D, V> B(net.time4j.engine.p<V> p) {
        if (p instanceof z) {
            return (z)z.class.cast(p).derive(J());
        }
        return super.B(p);
    }

    public int I(D d) {
        int cmp = Long.compare(l, l2);
        if (cmp < 0) {
            return -1;
        }
        if (cmp > 0) {
            return 1;
        }
        return k().compareTo(d.k());
    }

    protected net.time4j.engine.k<D> J() {
        return K().k(k());
    }

    protected abstract net.time4j.engine.j<D> K();

    public D L(net.time4j.engine.h h) {
        return (l)J().a(c.f(c(), obj1));
    }

    public <T extends net.time4j.engine.m<?, T>> T N(Class<T> class) {
        String name = class.getName();
        net.time4j.engine.w obj4 = w.y(class);
        if (obj4 == null) {
        } else {
            return (m)M(obj4.j(), name);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find any chronology for given target type: ");
        stringBuilder.append(name);
        obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    @Override // net.time4j.engine.q
    public long c() {
        return J().b(z());
    }

    @Override // net.time4j.engine.q
    public int compareTo(Object object) {
        return I((l)object);
    }

    @Override // net.time4j.engine.q
    public abstract boolean equals(Object object);

    @Override // net.time4j.engine.q
    public abstract int hashCode();

    @Override // net.time4j.engine.q
    protected net.time4j.engine.w y() {
        return K();
    }
}
