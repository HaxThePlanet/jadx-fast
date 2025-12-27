package net.time4j.engine;

import java.io.Serializable;
import net.time4j.f1.c;

/* compiled from: TimePoint.java */
/* loaded from: classes3.dex */
public abstract class i0<U, T extends i0<U, T>> extends q<T> implements Comparable<T>, Serializable {
    private k0<T> K(U u) {
        return J().J(u);
    }

    @Override // net.time4j.engine.q
    public T L(long j, U u) {
        return M(c.k(j), u);
    }

    @Override // net.time4j.engine.q
    public T M(long j, U u) {
        if (j == 0) {
            return (i0)z();
        }
        try {
        } catch (java.lang.IllegalArgumentException iae) {
            u = "Result beyond boundaries of time axis.";
            r4 = new ArithmeticException(u);
            r4.initCause(iae);
            throw r4;
        }
        return (i0)K(u).b(z(), j);
    }

    @Override // net.time4j.engine.q
    public long N(T t, U u) {
        return K(u).a(z(), t);
    }

    @Override // net.time4j.engine.q
    public abstract int I(T t);

    @Override // net.time4j.engine.q
    protected abstract f0<U, T> J();
}
