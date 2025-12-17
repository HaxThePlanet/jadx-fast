package net.time4j;

import java.io.Serializable;
import net.time4j.engine.f;
import net.time4j.engine.k0;
import net.time4j.engine.w;

/* loaded from: classes3.dex */
public final class w0 extends f implements net.time4j.v, Serializable {

    public static final net.time4j.w0 a = null;
    private static final long serialVersionUID = -4981215347844372171L;
    static {
        w0 w0Var = new w0();
        w0.a = w0Var;
    }

    private Object readResolve() {
        return w0.a;
    }

    protected <T extends net.time4j.engine.q<T>> k0<T> a(w<T> w) {
        if (w.w(g0.F)) {
            return a1.B();
        }
        return 0;
    }

    @Override // net.time4j.engine.f
    public double getLength() {
        return f.YEARS.getLength();
    }

    @Override // net.time4j.engine.f
    public char getSymbol() {
        return 89;
    }

    @Override // net.time4j.engine.f
    public boolean isCalendrical() {
        return 1;
    }

    @Override // net.time4j.engine.f
    public String toString() {
        return "WEEK_BASED_YEARS";
    }
}
