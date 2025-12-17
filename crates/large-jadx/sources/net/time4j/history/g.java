package net.time4j.history;

import java.io.DataInput;
import java.io.DataOutput;
import net.time4j.engine.f0;
import net.time4j.engine.m;
import net.time4j.engine.q;
import net.time4j.engine.z;
import net.time4j.g0;

/* loaded from: classes3.dex */
public final class g {

    static final net.time4j.history.g d;
    private static final net.time4j.history.h e;
    private static final net.time4j.history.h f;
    private static final g0 g;
    private final net.time4j.history.j a;
    private final g0 b;
    private final g0 c;
    static {
        g gVar = new g();
        g.d = gVar;
        final int i2 = 1;
        g.e = h.k(j.AD, i2, i2, i2);
        g.f = h.k(j.BC, 38, i2, i2);
        g.g = g0.J0(2000, i2);
    }

    private g() {
        super();
        this.a = 0;
        this.b = (g0)g0.t0().I();
        this.c = (g0)g0.t0().H();
    }

    private g(net.time4j.history.j j, g0 g02, g0 g03) {
        super();
        if (j.compareTo(j.AD) <= 0) {
        } else {
            if (g03.S(g02)) {
            } else {
                this.a = j;
                this.b = g02;
                this.c = g03;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("End before start: ");
            stringBuilder.append(g02);
            stringBuilder.append("/");
            stringBuilder.append(g03);
            IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
            throw obj3;
        }
        UnsupportedOperationException obj4 = new UnsupportedOperationException(j.name());
        throw obj4;
    }

    public static net.time4j.history.g a(g0 g0, g0 g02) {
        g gVar = new g(j.AB_URBE_CONDITA, g0, g02);
        return gVar;
    }

    public static net.time4j.history.g b(g0 g0, g0 g02) {
        g gVar = new g(j.BYZANTINE, g0, g02);
        return gVar;
    }

    public static net.time4j.history.g c(g0 g0) {
        return g.b((g0)g0.t0().I(), g0);
    }

    public static net.time4j.history.g e(g0 g0, g0 g02) {
        g gVar = new g(j.HISPANIC, g0, g02);
        return gVar;
    }

    public static net.time4j.history.g f(g0 g0) {
        return g.e((g0)g0.t0().I(), g0);
    }

    static net.time4j.history.g g(DataInput dataInput) {
        if (dataInput.readByte() == 127) {
            final g0 g0Var = g.g;
            final z mODIFIED_JULIAN_DATE = z.MODIFIED_JULIAN_DATE;
            g obj7 = new g(j.valueOf(dataInput.readUTF()), (g0)g0Var.F(mODIFIED_JULIAN_DATE, dataInput.readLong()), (g0)g0Var.F(mODIFIED_JULIAN_DATE, dataInput.readLong()));
            return obj7;
        }
        return g.d;
    }

    net.time4j.history.j d(net.time4j.history.h h, g0 g02) {
        net.time4j.history.j jVar;
        int obj2;
        Object obj3;
        if (this.a != null && !g02.S(this.b)) {
            if (!g02.S(this.b)) {
                if (g02.R(this.c)) {
                } else {
                    if (this.a == j.HISPANIC && h.a(g.f) < 0) {
                        if (h.a(g.f) < 0) {
                            return j.BC;
                        }
                    }
                }
                return this.a;
            }
        }
        obj2 = h.a(g.e) < 0 ? j.BC : j.AD;
        return obj2;
    }

    public boolean equals(Object object) {
        int i;
        net.time4j.history.j equals;
        Object jVar;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        net.time4j.history.g gVar = g.d;
        if (object instanceof g && this == gVar) {
            gVar = g.d;
            if (this == gVar) {
                if ((g)(g)object == gVar) {
                } else {
                    i = i2;
                }
                return i;
            }
            if (this.a == object.a && this.b.equals(object.b) && this.c.equals(object.c)) {
                if (this.b.equals(object.b)) {
                    if (this.c.equals(object.c)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    void h(DataOutput dataOutput) {
        int longValue;
        z mODIFIED_JULIAN_DATE;
        long longValue2;
        if (this == g.d) {
            dataOutput.writeByte(0);
        } else {
            dataOutput.writeByte(127);
            dataOutput.writeUTF(this.a.name());
            mODIFIED_JULIAN_DATE = z.MODIFIED_JULIAN_DATE;
            dataOutput.writeLong((Long)this.b.p(mODIFIED_JULIAN_DATE).longValue());
            dataOutput.writeLong((Long)this.c.p(mODIFIED_JULIAN_DATE).longValue());
        }
    }

    public int hashCode() {
        return i3 += i8;
    }

    public String toString() {
        Object str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        if (this == g.d) {
            stringBuilder.append("default");
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
}
