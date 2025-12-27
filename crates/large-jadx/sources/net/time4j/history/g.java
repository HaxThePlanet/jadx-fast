package net.time4j.history;

import java.io.DataInput;
import java.io.DataOutput;
import net.time4j.engine.f0;
import net.time4j.engine.m;
import net.time4j.engine.q;
import net.time4j.engine.z;
import net.time4j.g0;

/* compiled from: EraPreference.java */
/* loaded from: classes3.dex */
public final class g {

    static final g d = new g();
    private static final h e;
    private static final h f;
    private static final g0 g;
    private final j a;
    private final g0 b;
    private final g0 c;
    static {
        final int i2 = 1;
        g.e = h.k(j.AD, i2, i2, i2);
        g.f = h.k(j.BC, 38, i2, i2);
        g.g = g0.J0(2000, i2);
    }

    private g() {
        super();
        this.a = j.BC;
        this.b = (g0)g0.t0().I();
        this.c = (g0)g0.t0().H();
    }

    public static g a(g0 g0Var, g0 g0Var2) {
        return new g(j.AB_URBE_CONDITA, g0Var, g0Var2);
    }

    public static g b(g0 g0Var, g0 g0Var2) {
        return new g(j.BYZANTINE, g0Var, g0Var2);
    }

    public static g c(g0 g0Var) {
        return g.b((g0)g0.t0().I(), g0Var);
    }

    public static g e(g0 g0Var, g0 g0Var2) {
        return new g(j.HISPANIC, g0Var, g0Var2);
    }

    public static g f(g0 g0Var) {
        return g.e((g0)g0.t0().I(), g0Var);
    }

    static g g(DataInput dataInput) throws java.io.IOException {
        if (dataInput.readByte() == 127) {
            final g0 g0Var = g.g;
            final z mODIFIED_JULIAN_DATE2 = z.MODIFIED_JULIAN_DATE;
            return new g(j.valueOf(dataInput.readUTF()), (g0)g0Var.F(mODIFIED_JULIAN_DATE2, dataInput.readLong()), (g0)g0Var.F(mODIFIED_JULIAN_DATE2, dataInput.readLong()));
        }
        return g.d;
    }

    j d(h hVar, g0 g0Var) {
        net.time4j.history.j aD2;
        if (this.a != null && !g0Var.S(this.b)) {
            if (!g0Var.R(this.c)) {
                if (this.a == j.HISPANIC) {
                    if (hVar.a(g.f) < 0) {
                        return j.BC;
                    }
                }
            }
            return this.a;
        }
        hVar = hVar.a(g.e) < 0 ? j.BC : j.AD;
        return (hVar.a(g.e) < 0 ? j.BC : j.AD);
    }

    public boolean equals(Object object) {
        boolean z = true;
        net.time4j.history.j jVar;
        net.time4j.history.j jVar2;
        boolean equals;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof g) {
            net.time4j.history.g gVar = g.d;
            if (this == g.d) {
                if (object != g.d) {
                }
                return z;
            }
            if (this.a == object.a) {
                if (this.b.equals(object.b)) {
                    if (!(this.c.equals(object.c))) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    void h(DataOutput dataOutput) throws java.io.IOException {
        if (this == g.d) {
            int i = 0;
            dataOutput.writeByte(i);
        } else {
            dataOutput.writeByte(127);
            dataOutput.writeUTF(this.a.name());
            mODIFIED_JULIAN_DATE2 = z.MODIFIED_JULIAN_DATE;
            dataOutput.writeLong((Long)this.b.p(mODIFIED_JULIAN_DATE2).longValue());
            dataOutput.writeLong((Long)this.c.p(mODIFIED_JULIAN_DATE2).longValue());
        }
    }

    public int hashCode() {
        return (this.a.hashCode() * 17) + (this.b.hashCode() * 31) + (this.c.hashCode() * 37);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        if (this == g.d) {
            str = "default";
            stringBuilder.append(str);
        } else {
            stringBuilder.append("era->");
            stringBuilder.append(this.a);
            stringBuilder.append(",start->");
            stringBuilder.append(this.b);
            stringBuilder.append(",end->");
            stringBuilder.append(this.c);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private g(j jVar, g0 g0Var, g0 g0Var2) {
        super();
        if (jVar.compareTo(j.AD) <= 0) {
            throw new UnsupportedOperationException(jVar.name());
        } else {
            if (g0Var2.S(g0Var)) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str = "End before start: ";
                String str2 = "/";
                g0Var = str + g0Var + str2 + g0Var2;
                throw new IllegalArgumentException(g0Var);
            } else {
                this.a = jVar;
                this.b = g0Var;
                this.c = g0Var2;
                return;
            }
        }
    }
}
