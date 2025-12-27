package net.time4j.engine;

import java.util.Locale;
import net.time4j.f1.c;

/* compiled from: EpochDays.java */
/* loaded from: classes3.dex */
public enum z implements p<Long> {

    ANSI,
    EXCEL,
    JULIAN_DAY_NUMBER,
    LILIAN_DAY_NUMBER,
    MODIFIED_JULIAN_DATE,
    RATA_DIE,
    UNIX,
    UTC;

    private final int offset;

    private static class a<D extends q<D>> implements y<D, Long> {

        private final z a;
        private final k<D> b;
        a(k<D> kVar) {
            super();
            this.a = zVar;
            this.b = kVar;
        }

        public Long e(D d) {
            return Long.valueOf(this.a.transform(this.b.c() + 730L, z.UNIX));
        }

        public Long f(D d) {
            return Long.valueOf(this.a.transform(this.b.d() + 730L, z.UNIX));
        }

        public Long g(D d) {
            long l2 = this.b.b(d) + 730L;
            return Long.valueOf(this.a.transform(l2, z.UNIX));
        }

        public boolean h(D d, Long long) {
            if (long == null) {
                return false;
            }
            try {
                final long value = long.longValue();
                long l2 = c.m(z.UNIX.transform(value, this.a), 730L);
                long l = this.b.c();
                l = this.b.d();
            } catch (java.lang.ArithmeticException | java.lang.IllegalArgumentException unused) {
                return z;
            }
            if (z.UNIX >= l) {
                int i2 = 1;
            }
        }

        public D i(D d, Long long, boolean z) {
            if (long == null) {
                throw new IllegalArgumentException("Missing epoch day value.");
            } else {
                long value = long.longValue();
                return (q)this.b.a(c.m(z.UNIX.transform(value, this.a), 730L));
            }
        }

        public p<?> b(D d) {
            return null;
        }

        public p<?> d(D d) {
            return null;
        }
    }
    @Override // java.lang.Enum
    <D extends q<D>> y<D, Long> derive(k<D> kVar) {
        return new z.a(this, kVar);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return name();
    }

    @Override // java.lang.Enum
    public char getSymbol() {
        char c = 103;
        int r0 = this == z.MODIFIED_JULIAN_DATE ? 103 : 0;
        return (this == z.MODIFIED_JULIAN_DATE ? 103 : 0);
    }

    @Override // java.lang.Enum
    public Class<Long> getType() {
        return Long.class;
    }

    @Override // java.lang.Enum
    public long transform(long j, z zVar) {
        try {
        } catch (java.lang.ArithmeticException arithmetic) {
            r4 = new IllegalArgumentException(arithmetic);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) r4;
        }
        return c.f(j, (long)(zVar.offset - this.offset));
    }

    @Override // java.lang.Enum
    public int compare(o oVar, o oVar2) {
        return (Long)oVar.p(this).compareTo((Long)oVar2.p(this));
    }

    @Override // java.lang.Enum
    public Long getDefaultMaximum() {
        return Long.valueOf(365241779741L - (long)this.offset);
    }

    @Override // java.lang.Enum
    public Long getDefaultMinimum() {
        return Long.valueOf(-365243219892L - (long)this.offset);
    }

    @Override // java.lang.Enum
    public boolean isDateElement() {
        return true;
    }

    @Override // java.lang.Enum
    public boolean isLenient() {
        return false;
    }

    @Override // java.lang.Enum
    public boolean isTimeElement() {
        return false;
    }
}
