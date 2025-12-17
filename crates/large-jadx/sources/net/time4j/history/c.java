package net.time4j.history;

import net.time4j.f1.b;

/* loaded from: classes3.dex */
enum c implements net.time4j.history.b {

    GREGORIAN,
    JULIAN,
    SWEDISH;

    static enum a extends net.time4j.history.c {
        @Override // net.time4j.history.c
        public net.time4j.history.h fromMJD(long l) {
            int i;
            net.time4j.history.j jVar;
            long obj4 = b.l(l);
            i = b.i(obj4);
            jVar = i <= 0 ? j.BC : j.AD;
            if (i <= 0) {
                i = i - 1;
            }
            h obj5 = new h(jVar, i, b.h(obj4), b.g(obj4));
            return obj5;
        }

        @Override // net.time4j.history.c
        public int getMaximumDayOfMonth(net.time4j.history.h h) {
            return b.d(c.access$100(h), h.f());
        }

        @Override // net.time4j.history.c
        public boolean isValid(net.time4j.history.h h) {
            return b.f(c.access$100(h), h.f(), h.c());
        }

        @Override // net.time4j.history.c
        public long toMJD(net.time4j.history.h h) {
            return b.j(c.access$100(h), h.f(), h.c());
        }
    }

    static enum b extends net.time4j.history.c {
        @Override // net.time4j.history.c
        public net.time4j.history.h fromMJD(long l) {
            int i;
            net.time4j.history.j jVar;
            long obj4 = m.i(l);
            i = m.g(obj4);
            jVar = i <= 0 ? j.BC : j.AD;
            if (i <= 0) {
                i = i - 1;
            }
            h obj5 = new h(jVar, i, m.f(obj4), m.e(obj4));
            return obj5;
        }

        @Override // net.time4j.history.c
        public int getMaximumDayOfMonth(net.time4j.history.h h) {
            return m.b(c.access$100(h), h.f());
        }

        @Override // net.time4j.history.c
        public boolean isValid(net.time4j.history.h h) {
            return m.d(c.access$100(h), h.f(), h.c());
        }

        @Override // net.time4j.history.c
        public long toMJD(net.time4j.history.h h) {
            return m.h(c.access$100(h), h.f(), h.c());
        }
    }

    static enum c extends net.time4j.history.c {
        @Override // net.time4j.history.c
        public net.time4j.history.h fromMJD(long l) {
            if (Long.compare(l, i) == 0) {
                h obj4 = new h(j.AD, 1712, 2, 30);
                return obj4;
            }
            return c.JULIAN.fromMJD(l += i4);
        }

        @Override // net.time4j.history.c
        public int getMaximumDayOfMonth(net.time4j.history.h h) {
            int i;
            final int i2 = c.access$100(h);
            if (h.f() == 2 && i2 == 1712) {
                if (i2 == 1712) {
                    return 30;
                }
            }
            return m.b(i2, h.f());
        }

        @Override // net.time4j.history.c
        public boolean isValid(net.time4j.history.h h) {
            int i;
            int i2;
            final int i3 = c.access$100(h);
            if (h.c() == 30 && h.f() == 2 && i3 == 1712) {
                if (h.f() == 2) {
                    if (i3 == 1712) {
                        return 1;
                    }
                }
            }
            return m.d(i3, h.f(), h.c());
        }

        @Override // net.time4j.history.c
        public long toMJD(net.time4j.history.h h) {
            int i;
            int i2;
            int i3 = c.access$100(h);
            if (h.c() == 30 && h.f() == 2 && i3 == 1712) {
                if (h.f() == 2) {
                    if (i3 == 1712) {
                        return -53576;
                    }
                }
            }
            return l -= i7;
        }
    }
    static int access$100(net.time4j.history.h h) {
        return c.getProlepticYear(h);
    }

    private static int getProlepticYear(net.time4j.history.h h) {
        return h.e().annoDomini(h.i());
    }

    @Override // java.lang.Enum
    public abstract net.time4j.history.h fromMJD(long l);

    @Override // java.lang.Enum
    public abstract int getMaximumDayOfMonth(net.time4j.history.h h);

    @Override // java.lang.Enum
    public abstract boolean isValid(net.time4j.history.h h);

    @Override // java.lang.Enum
    public abstract long toMJD(net.time4j.history.h h);
}
