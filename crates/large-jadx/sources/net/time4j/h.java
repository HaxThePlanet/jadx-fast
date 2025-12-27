package net.time4j;

import java.util.List;
import net.time4j.engine.c0;
import net.time4j.engine.i0;
import net.time4j.engine.j0;
import net.time4j.engine.j0.a;
import net.time4j.f1.c;

/* compiled from: ClockUnit.java */
/* loaded from: classes3.dex */
public enum h implements w {

    HOURS,
    MICROS,
    MILLIS,
    MINUTES,
    NANOS,
    SECONDS;

    enum a extends h {
        @Override // net.time4j.h
        public double getLength() {
            return 4660134898793709568L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 72;
        }
    }

    enum b extends h {
        @Override // net.time4j.h
        public double getLength() {
            return 4633641066610819072L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 77;
        }
    }

    enum c extends h {
        @Override // net.time4j.h
        public double getLength() {
            return 4607182418800017408L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 83;
        }
    }

    enum d extends h {
        @Override // net.time4j.h
        public double getLength() {
            return 4562254508917369340L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 51;
        }
    }

    enum e extends h {
        @Override // net.time4j.h
        public double getLength() {
            return 4517329193108106637L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 54;
        }
    }

    enum f extends h {
        @Override // net.time4j.h
        public double getLength() {
            return 4472406533629990549L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 57;
        }
    }
    @Override // java.lang.Enum
    public <T extends i0<? super h, T>> long between(T t, T t2) {
        return t.N(t2, this);
    }

    @Override // java.lang.Enum
    public long convert(long j, h hVar) {
        long l = 0L;
        if (j == l) {
            return l;
        }
        int ordinal = ordinal();
        final int ordinal2 = hVar.ordinal();
        if (ordinal == ordinal2) {
            return j;
        }
        if (ordinal > ordinal2) {
            long[] fACTORS2 = h.FACTORS;
            return c.i(j, fACTORS2[ordinal] / fACTORS2[ordinal2]);
        }
        long[] fACTORS22 = h.FACTORS;
        return j / (fACTORS22[ordinal2] / fACTORS22[ordinal]);
    }

    @Override // java.lang.Enum
    public c0<h> only() {
        return g.b(this);
    }

    @Override // java.lang.Enum
    public c0<h> rounded() {
        return g.c(this);
    }

    @Override // java.lang.Enum
    public c0<h> truncated() {
        return g.d(this);
    }

    @Override // java.lang.Enum
    public long convert(j0<? extends h> j0Var) {
        int i = 0;
        int i2 = 0;
        int i3;
        long convert;
        long l2;
        i2 = 0;
        if (j0Var.isEmpty()) {
            return 0;
        }
        i = 0;
        i3 = j0Var.c().size() - 1;
        while (i3 >= 0) {
            Object item = j0Var.c().get(i3);
            Object obj = item.b();
            i3 = i3 - 1;
        }
        if (j0Var.a()) {
            long l3 = c.k(i2);
        }
        return convert(i2, i);
    }

    @Override // java.lang.Enum
    public abstract /* synthetic */ double getLength();

    @Override // java.lang.Enum
    public abstract /* synthetic */ char getSymbol();

    @Override // java.lang.Enum
    public boolean isCalendrical() {
        return false;
    }
}
