package net.time4j.tz;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import net.time4j.f1.a;
import net.time4j.f1.b;
import net.time4j.f1.c;
import net.time4j.f1.f;
import net.time4j.f1.g;

/* loaded from: classes3.dex */
final class h extends net.time4j.tz.l {

    private static final long serialVersionUID = -8432968264242113551L;
    private final transient net.time4j.tz.p M;
    private final net.time4j.tz.k id;
    private final boolean strict;
    private final TimeZone tz;
    h() {
        super();
        final int i = 0;
        this.id = i;
        this.tz = i;
        this.strict = false;
        this.M = i;
    }

    h(net.time4j.tz.k k) {
        super(k, TimeZone.getDefault(), 0);
    }

    h(net.time4j.tz.k k, String string2) {
        super(k, h.R(string2), 0);
    }

    private h(net.time4j.tz.k k, TimeZone timeZone2, boolean z3) {
        boolean startsWith;
        Object obj2;
        boolean obj3;
        super();
        this.id = k;
        obj2 = timeZone2.clone();
        this.tz = (TimeZone)obj2;
        this.strict = z3;
        final int obj4 = 0;
        if (obj2.useDaylightTime()) {
            this.M = obj4;
        } else {
            obj3 = obj2.getID();
            if (!obj3.startsWith("GMT") && !obj3.startsWith("Etc/") && !obj3.equals("Greenwich") && !obj3.equals("UCT") && !obj3.equals("UTC") && !obj3.equals("Universal")) {
                if (!obj3.startsWith("Etc/")) {
                    if (!obj3.equals("Greenwich")) {
                        if (!obj3.equals("UCT")) {
                            if (!obj3.equals("UTC")) {
                                if (!obj3.equals("Universal")) {
                                    if (obj3.equals("Zulu")) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = 0;
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (obj3 != null) {
                this.M = h.S(obj2.getOffset(System.currentTimeMillis()));
            } else {
                this.M = obj4;
            }
        }
    }

    static TimeZone R(String string) {
        if (string.equals("Z")) {
            return TimeZone.getTimeZone("GMT+00:00");
        }
        String str4 = "GMT";
        if (string.startsWith("UTC")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str4);
            stringBuilder.append(string.substring(3));
            return TimeZone.getTimeZone(stringBuilder.toString());
        }
        if (string.startsWith("UT")) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str4);
            stringBuilder2.append(string.substring(2));
            return TimeZone.getTimeZone(stringBuilder2.toString());
        }
        return TimeZone.getTimeZone(string);
    }

    private static net.time4j.tz.p S(int i) {
        return p.u(c.a(i, 1000));
    }

    private Object readResolve() {
        net.time4j.tz.k kVar = this.id;
        if (kVar == null) {
            h hVar = new h();
            return hVar;
        }
        h hVar2 = new h(kVar, this.tz, this.strict);
        return hVar2;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.p A(a a, g g2) {
        int i8;
        int i5;
        int i;
        int i3;
        int i4;
        int i7;
        int i2;
        int i6;
        int i9;
        int obj13;
        int obj14;
        net.time4j.tz.p pVar = this.M;
        if (pVar != null) {
            return pVar;
        }
        i8 = a.m();
        i = a.o();
        i4 = g2.s();
        final int i19 = 24;
        if (i4 == i19) {
            long l3 = b.l(c.f(b.k(a), i));
            i6 = i10;
            i = i3;
            i8 = obj13;
        } else {
            i6 = i3;
        }
        int i17 = 1;
        if (i8 > 0) {
            i2 = i8;
            i7 = i17;
        } else {
            i7 = obj13;
            i2 = i4;
        }
        i11 += i17;
        i9 = i12 == 8 ? i17 : i12;
        if (g2.s() == i19) {
        } else {
            obj13 += obj14;
        }
        if (this.id == null) {
            obj13 = TimeZone.getDefault();
        } else {
            obj13 = this.tz;
        }
        return h.S(obj13.getOffset(i7, i2, i + -1, i6, i9, obj13));
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.p B(f f) {
        TimeZone default;
        if (this.id == null) {
            default = TimeZone.getDefault();
        } else {
            net.time4j.tz.p pVar = this.M;
            if (pVar != null) {
                return pVar;
            }
            default = this.tz;
        }
        return h.S(default.getOffset(l *= i2));
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.o E() {
        net.time4j.tz.o oVar;
        oVar = this.strict ? l.v : l.c;
        return oVar;
    }

    @Override // net.time4j.tz.l
    public boolean I(f f) {
        TimeZone default;
        if (this.M != null) {
            return 0;
        }
        if (this.id == null) {
            default = TimeZone.getDefault();
        } else {
            default = this.tz;
        }
        Date date = new Date(l *= i2, obj3);
        return default.inDaylightTime(date);
    }

    @Override // net.time4j.tz.l
    public boolean J() {
        int i;
        i = this.M != null ? 1 : 0;
        return i;
    }

    @Override // net.time4j.tz.l
    public boolean K(a a, g g2) {
        int i;
        int i2;
        TimeZone default;
        final Object obj = this;
        if (obj.M != null) {
            return 0;
        }
        i = a.m();
        final int i23 = a.o();
        final int i24 = a.q();
        final int i25 = g2.s();
        final int i26 = g2.i();
        final int i27 = g2.u();
        final int i28 = i12 / i14;
        if (obj.id == null) {
            default = TimeZone.getDefault();
        } else {
            default = obj.tz;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(default);
        int i20 = 14;
        gregorianCalendar.set(i20, i28);
        int i11 = i20;
        GregorianCalendar calendar = gregorianCalendar;
        gregorianCalendar.set(i, i23 + -1, i24, i25, i26, i27);
        int i13 = 1;
        if (calendar.get(i13) == i && i4 += i13 == i23 && calendar.get(5) == i24 && calendar.get(11) == i25 && calendar.get(12) == i26 && calendar.get(13) == i27) {
            if (i4 += i13 == i23) {
                if (calendar.get(5) == i24) {
                    if (calendar.get(11) == i25) {
                        if (calendar.get(12) == i26) {
                            if (calendar.get(13) == i27) {
                                if (calendar.get(14) != i28) {
                                    i2 = i13;
                                } else {
                                    i2 = 0;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.l Q(net.time4j.tz.o o) {
        Object kVar;
        if (this.id != null) {
            if (E() == o) {
            } else {
                if (o == l.c) {
                    h obj4 = new h(this.id, this.tz, 0);
                    return obj4;
                }
                if (o != l.v) {
                } else {
                    obj4 = new h(this.id, this.tz, 1);
                    return obj4;
                }
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(o.toString());
            throw unsupportedOperationException;
        }
        return this;
    }

    @Override // net.time4j.tz.l
    boolean T() {
        TimeZone default;
        if (this.id == null) {
            default = TimeZone.getDefault();
        } else {
            default = this.tz;
        }
        return default.getID().equals("GMT");
    }

    @Override // net.time4j.tz.l
    public boolean equals(Object object) {
        boolean equals;
        int i2;
        int i;
        TimeZone strict;
        i = 1;
        if (object instanceof h && this.id == null && object.id == null) {
            i = 1;
            if (this.id == null) {
                if (object.id == null) {
                    i2 = i;
                }
                return i2;
            }
            if (this.tz.equals(object.tz)) {
                if (this.strict != object.strict) {
                } else {
                    net.time4j.tz.p pVar = this.M;
                    if (pVar == null && object.M == null) {
                        if (object.M == null) {
                            i2 = i;
                        }
                        return i2;
                    }
                }
                return pVar.equals(object.M);
            }
        }
        return 0;
    }

    @Override // net.time4j.tz.l
    public int hashCode() {
        int i;
        if (this.id == null) {
            i = 0;
        } else {
            i = this.tz.hashCode();
        }
        return i;
    }

    @Override // net.time4j.tz.l
    public String toString() {
        TimeZone default;
        if (this.id == null) {
            default = TimeZone.getDefault();
        } else {
            default = this.tz;
        }
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append('[');
        stringBuilder.append(h.class.getName());
        stringBuilder.append(':');
        stringBuilder.append(default);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override // net.time4j.tz.l
    public String w(net.time4j.tz.d d, Locale locale2) {
        TimeZone default;
        if (this.id == null) {
            default = TimeZone.getDefault();
        } else {
            default = this.tz;
        }
        return default.getDisplayName(d.isDaylightSaving(), obj3 ^= 1, locale2);
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.m y() {
        int i;
        net.time4j.tz.p pVar = this.M;
        if (pVar == null) {
            i = 0;
        } else {
            i = pVar.p();
        }
        return i;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.k z() {
        net.time4j.tz.k kVar = this.id;
        if (kVar == null) {
            e eVar = new e(TimeZone.getDefault().getID());
            return eVar;
        }
        return kVar;
    }
}
