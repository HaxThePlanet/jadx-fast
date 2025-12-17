package net.time4j;

import java.util.List;
import net.time4j.engine.c0;
import net.time4j.engine.i0;
import net.time4j.engine.j0;
import net.time4j.engine.j0.a;
import net.time4j.f1.c;

/* loaded from: classes3.dex */
public enum h implements net.time4j.w {

    HOURS,
    MINUTES,
    SECONDS,
    MILLIS,
    MICROS,
    NANOS;

    static enum a extends net.time4j.h {
        @Override // net.time4j.h
        public double getLength() {
            return 4660134898793709568L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 72;
        }
    }

    static enum b extends net.time4j.h {
        @Override // net.time4j.h
        public double getLength() {
            return 4633641066610819072L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 77;
        }
    }

    static enum c extends net.time4j.h {
        @Override // net.time4j.h
        public double getLength() {
            return 4607182418800017408L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 83;
        }
    }

    static enum d extends net.time4j.h {
        @Override // net.time4j.h
        public double getLength() {
            return 4562254508917369340L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 51;
        }
    }

    static enum e extends net.time4j.h {
        @Override // net.time4j.h
        public double getLength() {
            return 4517329193108106637L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 54;
        }
    }

    static enum f extends net.time4j.h {
        @Override // net.time4j.h
        public double getLength() {
            return 4472406533629990549L;
        }

        @Override // net.time4j.h
        public char getSymbol() {
            return 57;
        }
    }
    public <T extends i0<? super net.time4j.h, T>> long between(T t, T t2) {
        return t.N(t2, this);
    }

    @Override // java.lang.Enum
    public long convert(long l, net.time4j.h h2) {
        int i = 0;
        if (Long.compare(l, i) == 0) {
            return i;
        }
        int ordinal = ordinal();
        final int obj7 = obj7.ordinal();
        if (ordinal == obj7) {
            return l;
        }
        if (ordinal > obj7) {
            long[] fACTORS = h.FACTORS;
            return c.i(l, h2);
        }
        long[] fACTORS2 = h.FACTORS;
        return l /= i3;
    }

    public long convert(j0<? extends net.time4j.h> j0) {
        int i3;
        int i2;
        int i;
        long convert;
        Object obj;
        long l;
        if (j0.isEmpty()) {
            return 0;
        }
        i3 = 0;
        size--;
        while (i >= 0) {
            convert = j0.c().get(i);
            obj = (j0.a)convert.b();
            if (i3 == 0) {
            } else {
            }
            i2 = c.f(i2, obj2);
            i--;
            i2 = l2;
            i3 = obj;
        }
        if (j0.a()) {
            i2 = c.k(i2);
        }
        return convert(i2, obj2);
    }

    @Override // java.lang.Enum
    public abstract double getLength();

    @Override // java.lang.Enum
    public abstract char getSymbol();

    @Override // java.lang.Enum
    public boolean isCalendrical() {
        return 0;
    }

    public c0<net.time4j.h> only() {
        return g.b(this);
    }

    public c0<net.time4j.h> rounded() {
        return g.c(this);
    }

    public c0<net.time4j.h> truncated() {
        return g.d(this);
    }
}
