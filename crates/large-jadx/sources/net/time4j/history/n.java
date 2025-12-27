package net.time4j.history;

/* compiled from: NewYearRule.java */
/* loaded from: classes3.dex */
public enum n {

    BEGIN_OF_JANUARY {
        @Override // net.time4j.history.n
        int displayedYear(o oVar, h hVar) {
            return hVar.i();
        }

        @Override // net.time4j.history.n
        h newYear(j jVar, int i) {
            i = 1;
            return h.k(jVar, i, i, i);
        }
    },
    BEGIN_OF_MARCH {
        @Override // net.time4j.history.n
        h newYear(j jVar, int i) {
            return h.k(jVar, i, 3, 1);
        }
    },
    BEGIN_OF_SEPTEMBER {
        @Override // net.time4j.history.n
        int displayedYear(o oVar, h hVar) {
            int i;
            i = hVar.i() + 1;
            if (hVar.a(oVar.d(hVar.e(), i)) >= 0) {
            }
            return i;
        }

        @Override // net.time4j.history.n
        h newYear(j jVar, int i) {
            i = 1;
            return h.k(jVar, i - i, 9, i);
        }
    },
    CHRISTMAS_STYLE {
        @Override // net.time4j.history.n
        int displayedYear(o oVar, h hVar) {
            int i;
            i = hVar.i() + 1;
            if (hVar.a(oVar.d(hVar.e(), i)) >= 0) {
            }
            return i;
        }

        @Override // net.time4j.history.n
        h newYear(j jVar, int i) {
            return h.k(jVar, i - 1, 12, 25);
        }
    },
    CALCULUS_PISANUS {
        @Override // net.time4j.history.n
        int displayedYear(o oVar, h hVar) {
            int i;
            i = hVar.i() - 1;
            if (hVar.a(newYear(hVar.e(), i)) < 0) {
                i = i - 1;
            }
            return i;
        }

        @Override // net.time4j.history.n
        h newYear(j jVar, int i) {
            return n.MARIA_ANUNCIATA.newYear(jVar, i + 1);
        }

        @Override // net.time4j.history.n
        int standardYear(boolean z, o oVar, j jVar, int i, int i2, int i3) {
            return n.MARIA_ANUNCIATA.standardYear(z, oVar, jVar, i + 1, i2, i3);
        }
    };

    enum e extends n {
        @Override // net.time4j.history.n
        h newYear(j jVar, int i) {
            int i3 = 4;
            i = e.EASTERN.marchDay(jVar.annoDomini(i)) - 1;
            if (i > 31) {
                i3 = 4;
                i = i - 31;
            } else {
                i3 = 3;
            }
            return h.k(jVar, i, i3, i);
        }
    }

    enum f extends n {
        @Override // net.time4j.history.n
        h newYear(j jVar, int i) {
            int i3 = 4;
            i = e.EASTERN.marchDay(jVar.annoDomini(i)) - 2;
            if (i > 31) {
                i3 = 4;
                i = i - 31;
            } else {
                i3 = 3;
            }
            return h.k(jVar, i, i3, i);
        }
    }

    enum g extends n {
        @Override // net.time4j.history.n
        h newYear(j jVar, int i) {
            return h.k(jVar, i, 3, 25);
        }
    }

    enum i extends n {
        @Override // net.time4j.history.n
        h newYear(j jVar, int i) {
            return h.k(jVar, i, 1, 6);
        }
    }
    @Override // java.lang.Enum
    int displayedYear(o oVar, h hVar) {
        int i;
        i = hVar.i();
        if (hVar.a(newYear(hVar.e(), i)) < 0) {
            i = i - 1;
        }
        return i;
    }

    @Override // java.lang.Enum
    int standardYear(boolean z, o oVar, j jVar, int i, int i2, int i3) {
        int i52;
        net.time4j.history.h hVar;
        i = 5;
        if (i2 >= 5 && i2 <= 8) {
            return i;
        }
        net.time4j.history.h year = newYear(jVar, i);
        i52 = i + 1;
        net.time4j.history.h hVar3 = oVar.d(jVar, i52);
        final net.time4j.history.h hVar2 = h.k(jVar, i, i2, i3);
        if (i2 <= 4) {
            i2 = hVar2.a(year) >= 0 ? i : i52;
            if (h.k(jVar, i52, i2, i3).a(hVar3) < 0) {
            }
        }
        if (i52 > i52) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Invalid date due to changing new year rule (year too short to cover month and day-of-month): ";
            oVar = str + hVar2;
            throw new IllegalArgumentException(oVar);
        } else {
            if (z) {
            }
            return i52;
        }
    }

    @Override // java.lang.Enum
    public o until(int i) {
        net.time4j.history.o oVar;
        int i2 = 567;
        if (i <= i2) {
            throw new IllegalArgumentException("Defining New-Year-strategy is not supported before Council of Tours in AD 567.");
        } else {
            net.time4j.history.n bEGIN_OF_JANUARY2 = n.BEGIN_OF_JANUARY;
            if (this != n.BEGIN_OF_JANUARY) {
                oVar = new o(n.BEGIN_OF_JANUARY, i2).b(new o(this, i));
            }
            return oVar;
        }
    }

    @Override // java.lang.Enum
    abstract h newYear(j jVar, int i);
}
