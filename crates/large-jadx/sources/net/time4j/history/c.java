package net.time4j.history;

import net.time4j.f1.b;

/* compiled from: CalendarAlgorithm.java */
/* loaded from: classes3.dex */
enum c implements b {

    GREGORIAN,
    JULIAN,
    SWEDISH;

    enum a extends c {
        @Override // net.time4j.history.c
        public h fromMJD(long j) {
            int i;
            net.time4j.history.j bC2;
            long l = b.l(j);
            i = b.i(l);
            net.time4j.history.j r2 = i <= 0 ? j.BC : j.AD;
            if (i <= 0) {
                i = i - 1;
            }
            h hVar = new h(bC2, i, b.h(l), b.g(l));
            return hVar;
        }

        @Override // net.time4j.history.c
        public int getMaximumDayOfMonth(h hVar) {
            return b.d(c.getProlepticYear(hVar), hVar.f());
        }

        @Override // net.time4j.history.c
        public boolean isValid(h hVar) {
            return b.f(c.getProlepticYear(hVar), hVar.f(), hVar.c());
        }

        @Override // net.time4j.history.c
        public long toMJD(h hVar) {
            return b.j(c.getProlepticYear(hVar), hVar.f(), hVar.c());
        }
    }

    enum b extends c {
        @Override // net.time4j.history.c
        public h fromMJD(long j) {
            int i;
            net.time4j.history.j bC2;
            long l = m.i(j);
            i = m.g(l);
            net.time4j.history.j r2 = i <= 0 ? j.BC : j.AD;
            if (i <= 0) {
                i = i - 1;
            }
            h hVar = new h(bC2, i, m.f(l), m.e(l));
            return hVar;
        }

        @Override // net.time4j.history.c
        public int getMaximumDayOfMonth(h hVar) {
            return m.b(c.getProlepticYear(hVar), hVar.f());
        }

        @Override // net.time4j.history.c
        public boolean isValid(h hVar) {
            return m.d(c.getProlepticYear(hVar), hVar.f(), hVar.c());
        }

        @Override // net.time4j.history.c
        public long toMJD(h hVar) {
            return m.h(c.getProlepticYear(hVar), hVar.f(), hVar.c());
        }
    }

    enum c extends c {
        @Override // net.time4j.history.c
        public h fromMJD(long j) {
            if (j == -53576) {
                return new h(j.AD, 1712, 2, 30);
            }
            return c.JULIAN.fromMJD(j + 1L);
        }

        @Override // net.time4j.history.c
        public int getMaximumDayOfMonth(h hVar) {
            final int i2 = c.getProlepticYear(hVar);
            if (hVar.f() == 2 && i2 == 1712) {
                return 30;
            }
            return m.b(i2, hVar.f());
        }

        @Override // net.time4j.history.c
        public boolean isValid(h hVar) {
            final int i3 = c.getProlepticYear(hVar);
            int i2 = 30;
            if (hVar.c() == 30) {
                i2 = 2;
                if (hVar.f() == 2 && i3 == 1712) {
                    return true;
                }
            }
            return m.d(i3, hVar.f(), hVar.c());
        }

        @Override // net.time4j.history.c
        public long toMJD(h hVar) {
            int i3 = c.getProlepticYear(hVar);
            int i2 = 30;
            if (hVar.c() == 30) {
                i2 = 2;
                if (hVar.f() == 2 && i3 == 1712) {
                    return -53576;
                }
            }
            return (m.h(i3, hVar.f(), hVar.c())) - 1L;
        }
    }
    static /* synthetic */ int access$100(h hVar) {
        return c.getProlepticYear(hVar);
    }

    private static int getProlepticYear(h hVar) {
        return hVar.e().annoDomini(hVar.i());
    }

    @Override // java.lang.Enum
    public abstract /* synthetic */ h fromMJD(long j);

    @Override // java.lang.Enum
    public abstract /* synthetic */ int getMaximumDayOfMonth(h hVar);

    @Override // java.lang.Enum
    public abstract /* synthetic */ boolean isValid(h hVar);

    @Override // java.lang.Enum
    public abstract /* synthetic */ long toMJD(h hVar);
}
