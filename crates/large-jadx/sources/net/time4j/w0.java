package net.time4j;

import java.io.Serializable;
import net.time4j.engine.f;
import net.time4j.engine.k0;
import net.time4j.engine.q;
import net.time4j.engine.w;

/* compiled from: Weekcycle.java */
/* loaded from: classes3.dex */
public final class w0 extends f implements v, Serializable {

    public static final w0 a = null;
    private static final long serialVersionUID = -4981215347844372171L;
    static {
        w0.a = new w0();
    }

    private w0() {
        super();
    }

    private Object readResolve() {
        return w0.a;
    }

    @Override // net.time4j.engine.f
    protected <T extends q<T>> k0<T> a(w<T> wVar) {
        if (wVar.w(g0.F)) {
            return a1.B();
        }
        return null;
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
        return true;
    }

    @Override // net.time4j.engine.f
    public String toString() {
        return "WEEK_BASED_YEARS";
    }
}
