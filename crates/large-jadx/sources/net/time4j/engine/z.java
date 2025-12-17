package net.time4j.engine;

import java.util.Locale;
import net.time4j.f1.c;

/* loaded from: classes3.dex */
public enum z implements net.time4j.engine.p<Long> {

    UTC(2441317),
    UNIX(2440587),
    MODIFIED_JULIAN_DATE(2400000),
    EXCEL(2415019),
    ANSI(2305812),
    RATA_DIE(1721424),
    JULIAN_DAY_NUMBER(-1),
    LILIAN_DAY_NUMBER(5);

    private final int offset;

    private static class a implements net.time4j.engine.y<D, Long> {

        private final net.time4j.engine.z a;
        private final net.time4j.engine.k<D> b;
        a(net.time4j.engine.z z, net.time4j.engine.k<D> k2) {
            super();
            this.a = z;
            this.b = k2;
        }

        public net.time4j.engine.p<?> b(D d) {
            return 0;
        }

        public net.time4j.engine.p<?> d(D d) {
            return 0;
        }

        public Long e(D d) {
            return Long.valueOf(this.a.transform(l += i2, obj1));
        }

        public Long f(D d) {
            return Long.valueOf(this.a.transform(l += i2, obj1));
        }

        public Long g(D d) {
            l += i2;
            return Long.valueOf(this.a.transform(i, obj2));
        }

        @Override // net.time4j.engine.y
        public net.time4j.engine.p getChildAtCeiling(Object object) {
            return b((q)object);
        }

        @Override // net.time4j.engine.y
        public net.time4j.engine.p getChildAtFloor(Object object) {
            return d((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return g((q)object);
        }

        public boolean h(D d, Long long2) {
            long l;
            int obj5;
            int obj6;
            if (long2 == null) {
                return 0;
            }
            final long longValue = long2.longValue();
            long l2 = c.m(z.UNIX.transform(longValue, obj2), longValue);
            if (Long.compare(l2, l) <= 0 && Long.compare(l2, l) >= 0) {
                if (Long.compare(l2, l) >= 0) {
                    try {
                        obj5 = 1;
                        return obj5;
                    }
                }
            }
        }

        public D i(D d, Long long2, boolean z3) {
            if (long2 == null) {
            } else {
                long obj4 = long2.longValue();
                return (q)this.b.a(c.m(z.UNIX.transform(obj4, z3), obj4));
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("Missing epoch day value.");
            throw obj3;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((q)object, (Long)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return i((q)object, (Long)object2, z3);
        }
    }
    @Override // java.lang.Enum
    public int compare(Object object, Object object2) {
        return compare((o)object, (o)object2);
    }

    @Override // java.lang.Enum
    public int compare(net.time4j.engine.o o, net.time4j.engine.o o2) {
        return (Long)o.p(this).compareTo((Long)o2.p(this));
    }

    <D extends net.time4j.engine.q<D>> net.time4j.engine.y<D, Long> derive(net.time4j.engine.k<D> k) {
        z.a aVar = new z.a(this, k);
        return aVar;
    }

    @Override // java.lang.Enum
    public Long getDefaultMaximum() {
        return Long.valueOf(l2 -= l);
    }

    @Override // java.lang.Enum
    public Object getDefaultMaximum() {
        return getDefaultMaximum();
    }

    @Override // java.lang.Enum
    public Long getDefaultMinimum() {
        return Long.valueOf(l2 -= l);
    }

    @Override // java.lang.Enum
    public Object getDefaultMinimum() {
        return getDefaultMinimum();
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return name();
    }

    @Override // java.lang.Enum
    public char getSymbol() {
        int i;
        i = this == z.MODIFIED_JULIAN_DATE ? 103 : 0;
        return i;
    }

    public Class<Long> getType() {
        return Long.class;
    }

    @Override // java.lang.Enum
    public boolean isDateElement() {
        return 1;
    }

    @Override // java.lang.Enum
    public boolean isLenient() {
        return 0;
    }

    @Override // java.lang.Enum
    public boolean isTimeElement() {
        return 0;
    }

    @Override // java.lang.Enum
    public long transform(long l, net.time4j.engine.z z2) {
        try {
            return c.f(l, z2);
            z2 = new IllegalArgumentException(l);
            throw z2;
        }
    }
}
