package net.time4j.engine;

import java.io.Serializable;
import net.time4j.f1.c;

/* loaded from: classes3.dex */
public abstract class i0<U, T extends net.time4j.engine.i0<U, T>>  extends net.time4j.engine.q<T> implements Comparable<T>, Serializable {
    private net.time4j.engine.k0<T> K(U u) {
        return J().J(u);
    }

    public abstract int I(T t);

    protected abstract net.time4j.engine.f0<U, T> J();

    public T L(long l, U u2) {
        return M(c.k(l), u2);
    }

    public T M(long l, U u2) {
        if (Long.compare(l, i) == 0) {
            return (i0)z();
        }
        return (i0)K(obj5).b(z(), l);
    }

    public long N(T t, U u2) {
        return K(u2).a(z(), t);
    }

    @Override // net.time4j.engine.q
    public int compareTo(Object object) {
        return I((i0)object);
    }

    @Override // net.time4j.engine.q
    protected net.time4j.engine.w y() {
        return J();
    }
}
