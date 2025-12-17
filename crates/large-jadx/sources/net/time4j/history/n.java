package net.time4j.history;

/* loaded from: classes3.dex */
public enum n {

    BEGIN_OF_JANUARY,
    BEGIN_OF_MARCH,
    BEGIN_OF_SEPTEMBER,
    CHRISTMAS_STYLE,
    EASTER_STYLE,
    GOOD_FRIDAY,
    MARIA_ANUNCIATA,
    CALCULUS_PISANUS,
    EPIPHANY;

    static enum a extends net.time4j.history.n {
        @Override // net.time4j.history.n
        int displayedYear(net.time4j.history.o o, net.time4j.history.h h2) {
            return h2.i();
        }

        @Override // net.time4j.history.n
        net.time4j.history.h newYear(net.time4j.history.j j, int i2) {
            final int i = 1;
            return h.k(j, i2, i, i);
        }
    }

    static enum b extends net.time4j.history.n {
        @Override // net.time4j.history.n
        net.time4j.history.h newYear(net.time4j.history.j j, int i2) {
            return h.k(j, i2, 3, 1);
        }
    }

    static enum c extends net.time4j.history.n {
        @Override // net.time4j.history.n
        int displayedYear(net.time4j.history.o o, net.time4j.history.h h2) {
            int i;
            final int i2 = i + 1;
            if (h2.a(o.d(h2.e(), i2)) >= 0) {
                i = i2;
            }
            return i;
        }

        @Override // net.time4j.history.n
        net.time4j.history.h newYear(net.time4j.history.j j, int i2) {
            final int i = 1;
            return h.k(j, i2 -= i, 9, i);
        }
    }

    static enum d extends net.time4j.history.n {
        @Override // net.time4j.history.n
        int displayedYear(net.time4j.history.o o, net.time4j.history.h h2) {
            int i;
            final int i2 = i + 1;
            if (h2.a(o.d(h2.e(), i2)) >= 0) {
                i = i2;
            }
            return i;
        }

        @Override // net.time4j.history.n
        net.time4j.history.h newYear(net.time4j.history.j j, int i2) {
            return h.k(j, i2--, 12, 25);
        }
    }

    static enum e extends net.time4j.history.n {
        @Override // net.time4j.history.n
        net.time4j.history.h newYear(net.time4j.history.j j, int i2) {
            int i3;
            int i;
            marchDay--;
            if (i3 > 31) {
                i = 4;
                i3 += -31;
            } else {
                i = 3;
            }
            return h.k(j, i2, i, i3);
        }
    }

    static enum f extends net.time4j.history.n {
        @Override // net.time4j.history.n
        net.time4j.history.h newYear(net.time4j.history.j j, int i2) {
            int i;
            int i3;
            marchDay += -2;
            if (i > 31) {
                i3 = 4;
                i += -31;
            } else {
                i3 = 3;
            }
            return h.k(j, i2, i3, i);
        }
    }

    static enum g extends net.time4j.history.n {
        @Override // net.time4j.history.n
        net.time4j.history.h newYear(net.time4j.history.j j, int i2) {
            return h.k(j, i2, 3, 25);
        }
    }

    static enum h extends net.time4j.history.n {
        @Override // net.time4j.history.n
        int displayedYear(net.time4j.history.o o, net.time4j.history.h h2) {
            int obj2;
            obj2--;
            if (h2.a(newYear(h2.e(), obj2)) < 0) {
                obj2--;
            }
            return obj2;
        }

        @Override // net.time4j.history.n
        net.time4j.history.h newYear(net.time4j.history.j j, int i2) {
            return n.MARIA_ANUNCIATA.newYear(j, i2++);
        }

        @Override // net.time4j.history.n
        int standardYear(boolean z, net.time4j.history.o o2, net.time4j.history.j j3, int i4, int i5, int i6) {
            return n.MARIA_ANUNCIATA.standardYear(z, o2, j3, i4 + 1, i5, i6);
        }
    }

    static enum i extends net.time4j.history.n {
        @Override // net.time4j.history.n
        net.time4j.history.h newYear(net.time4j.history.j j, int i2) {
            return h.k(j, i2, 1, 6);
        }
    }
    @Override // java.lang.Enum
    int displayedYear(net.time4j.history.o o, net.time4j.history.h h2) {
        int obj2;
        obj2 = h2.i();
        if (h2.a(newYear(h2.e(), obj2)) < 0) {
            obj2--;
        }
        return obj2;
    }

    @Override // java.lang.Enum
    abstract net.time4j.history.h newYear(net.time4j.history.j j, int i2);

    @Override // java.lang.Enum
    int standardYear(boolean z, net.time4j.history.o o2, net.time4j.history.j j3, int i4, int i5, int i6) {
        int i;
        int i2;
        int obj6;
        net.time4j.history.h obj7;
        int obj8;
        int obj9;
        if (i5 >= 5 && i5 <= 8) {
            if (i5 <= 8) {
                return i4;
            }
        }
        net.time4j.history.h year = newYear(j3, i4);
        i2 = i4 + 1;
        obj6 = o2.d(j3, i2);
        final net.time4j.history.h hVar = h.k(j3, i4, i5, i6);
        if (i5 <= 4) {
            obj9 = hVar.a(year) >= 0 ? i4 : i2;
            if (h.k(j3, i2, i5, i6).a(obj6) >= 0) {
            } else {
                obj8 = i2;
            }
        } else {
        }
        if (obj9 > obj8) {
        } else {
            if (z) {
                obj8 = obj9;
            }
            return obj8;
        }
        obj6 = new StringBuilder();
        obj6.append("Invalid date due to changing new year rule (year too short to cover month and day-of-month): ");
        obj6.append(hVar);
        IllegalArgumentException obj5 = new IllegalArgumentException(obj6.toString());
        throw obj5;
    }

    @Override // java.lang.Enum
    public net.time4j.history.o until(int i) {
        net.time4j.history.o oVar2;
        net.time4j.history.o oVar;
        int i2 = 567;
        if (i <= i2) {
        } else {
            oVar2 = new o(this, i);
            net.time4j.history.n obj4 = n.BEGIN_OF_JANUARY;
            if (this != obj4) {
                oVar = new o(obj4, i2);
                oVar2 = oVar.b(oVar2);
            }
            return oVar2;
        }
        obj4 = new IllegalArgumentException("Defining New-Year-strategy is not supported before Council of Tours in AD 567.");
        throw obj4;
    }
}
