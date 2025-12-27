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

/* compiled from: PlatformTimezone.java */
/* loaded from: classes3.dex */
final class h extends l {

    private static final long serialVersionUID = -8432968264242113551L;
    private final transient p M;
    private final k id;
    private final boolean strict;
    private final TimeZone tz;
    h() {
        super();
        final net.time4j.tz.k kVar = null;
        this.id = kVar;
        this.tz = kVar;
        this.strict = false;
        this.M = kVar;
    }

    static TimeZone R(String str) {
        if (str.equals("Z")) {
            return TimeZone.getTimeZone("GMT+00:00");
        }
        String str5 = "GMT";
        if (str.startsWith("UTC")) {
            StringBuilder stringBuilder = new StringBuilder();
            String substring = str.substring(3);
            str7 = str5 + substring;
            return TimeZone.getTimeZone(str7);
        }
        if (str.startsWith("UT")) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String substring2 = str.substring(2);
            str8 = str5 + substring2;
            return TimeZone.getTimeZone(str8);
        }
        return TimeZone.getTimeZone(str);
    }

    private static p S(int i) {
        return p.u(c.a(i, 1000));
    }

    private Object readResolve() {
        if (this.id == null) {
            return new h();
        }
        return new h(id2, this.tz, this.strict);
    }

    @Override // net.time4j.tz.l
    public p A(a aVar, g gVar) {
        int aVar2;
        int i;
        int aVar3;
        TimeZone aVar4;
        if (this.M != null) {
            return this.M;
        }
        aVar2 = aVar.m();
        i = aVar.o();
        aVar2 = gVar.s();
        final int i10 = 24;
        if (aVar2 == i10) {
            long l3 = b.l(c.f(b.k(aVar), 1L));
        } else {
        }
        aVar3 = 0;
        aVar3 = 1;
        if (this.M > 0) {
        } else {
            aVar2 = aVar2 - 1;
        }
        aVar3 = (b.c(aVar2, i, i)) + aVar3;
        int r10 = aVar3;
        if (gVar.s() != i10) {
            int i2 = 1000000;
            i3 = gVar.a() / i2;
            aVar3 = (gVar.s() * 3600) + (gVar.i() * 60) + gVar.u() * 1000 + i3;
        }
        if (this.id == null) {
            aVar4 = TimeZone.getDefault();
        } else {
        }
        return h.S(aVar4.getOffset(aVar3, aVar2, i - 1, i, aVar3, aVar3));
    }

    @Override // net.time4j.tz.l
    public p B(f fVar) {
        TimeZone _default;
        if (this.id != null) {
            if (this.M != null) {
                return this.M;
            }
        } else {
            _default = TimeZone.getDefault();
        }
        return h.S(_default.getOffset(fVar.x() * 1000L));
    }

    @Override // net.time4j.tz.l
    public o E() {
        net.time4j.tz.o oVar;
        net.time4j.tz.o r0 = this.strict ? l.v : l.c;
        return (this.strict ? l.v : l.c);
    }

    @Override // net.time4j.tz.l
    public boolean I(f fVar) {
        TimeZone _default;
        if (this.M != null) {
            return false;
        }
        if (this.id == null) {
            _default = TimeZone.getDefault();
        } else {
        }
        return _default.inDaylightTime(new Date(fVar.x() * 1000L, r3));
    }

    @Override // net.time4j.tz.l
    public boolean J() {
        boolean z = true;
        int r0 = this.M != null ? 1 : 0;
        return (this.M != null ? 1 : 0);
    }

    @Override // net.time4j.tz.l
    public boolean K(a aVar, g gVar) {
        int i;
        boolean z = false;
        TimeZone _default;
        final Object aVar2 = this;
        if (aVar2.M != null) {
            return false;
        }
        i = aVar.m();
        final int i21 = aVar.o();
        final int i3 = aVar.q();
        final int i4 = gVar.s();
        final int i5 = gVar.i();
        final int i6 = gVar.u();
        final int i22 = gVar.a() / 1000000;
        if (aVar2.id == null) {
            _default = TimeZone.getDefault();
        } else {
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(_default);
        gregorianCalendar.set(14, i22);
        gregorianCalendar.set(i, i21 - 1, i3, i4, i5, i6);
        int i2 = 1;
        if (gregorianCalendar.get(i2) == i) {
            i = gregorianCalendar.get(2) + i2;
            if (gregorianCalendar.get(2) + i2 == i21) {
                if (gregorianCalendar.get(5) == i3) {
                    if (gregorianCalendar.get(11) == i4) {
                        if (gregorianCalendar.get(12) == i5) {
                            if (gregorianCalendar.get(13) == i6) {
                                if (gregorianCalendar.get(14) != i22) {
                                } else {
                                    int i15 = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // net.time4j.tz.l
    public l Q(o oVar) {
        return this;
    }

    @Override // net.time4j.tz.l
    boolean T() {
        TimeZone _default;
        if (this.id == null) {
            _default = TimeZone.getDefault();
        } else {
        }
        return _default.getID().equals("GMT");
    }

    @Override // net.time4j.tz.l
    public boolean equals(Object object) {
        boolean z = false;
        equals = object instanceof h;
        z = false;
        if (object instanceof h) {
            int i = 1;
            if (this.id == null && object.id == null) {
                return z;
            }
            if (this.tz.equals(object.tz)) {
                if (this.strict == object.strict) {
                    if (this.M == null && object.M == null) {
                        return z;
                    }
                }
                return this.M.equals(object.M);
            }
        }
        return false;
    }

    @Override // net.time4j.tz.l
    public int hashCode() {
        int i = 0;
        if (this.id == null) {
            i = 0;
        } else {
            i = this.tz.hashCode();
        }
        return i;
    }

    @Override // net.time4j.tz.l
    public String toString() {
        Object obj;
        if (this.id == null) {
            TimeZone _default = TimeZone.getDefault();
        } else {
        }
        final StringBuilder stringBuilder = new StringBuilder(256);
        String name = h.class.getName();
        str = 256 + 91 + name + 58 + obj + 93;
        return str;
    }

    @Override // net.time4j.tz.l
    public String w(d dVar, Locale locale) {
        TimeZone _default;
        if (this.id == null) {
            _default = TimeZone.getDefault();
        } else {
        }
        return _default.getDisplayName(dVar.isDaylightSaving(), !dVar.isAbbreviation(), locale);
    }

    @Override // net.time4j.tz.l
    public m y() {
        int i = 0;
        if (this.M == null) {
            i = 0;
        } else {
            net.time4j.tz.j jVar = this.M.p();
        }
        return i;
    }

    @Override // net.time4j.tz.l
    public k z() {
        if (this.id == null) {
            return new e(TimeZone.getDefault().getID());
        }
        return this.id;
    }

    h(k kVar) {
        this(kVar, TimeZone.getDefault(), false);
    }

    h(k kVar, String str) {
        this(kVar, h.R(str), false);
    }

    private h(k kVar, TimeZone timeZone, boolean z) {
        boolean startsWith;
        int i = 1;
        super();
        this.id = kVar;
        Object clone = timeZone.clone();
        this.tz = clone;
        this.strict = z;
        final net.time4j.tz.p pVar2 = null;
        if (clone.useDaylightTime()) {
            this.M = pVar2;
        } else {
            String str = clone.getID();
            if (!str.startsWith("GMT")) {
                if (!str.startsWith("Etc/")) {
                    if (!str.equals("Greenwich")) {
                        if (!str.equals("UCT")) {
                            if (!str.equals("UTC")) {
                                if (!str.equals("Universal")) {
                                    if (str.equals("Zulu")) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i != 0) {
                this.M = h.S(clone.getOffset(System.currentTimeMillis()));
            } else {
                this.M = pVar2;
            }
        }
    }
}
