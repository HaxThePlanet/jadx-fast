package net.time4j;

import java.text.ParsePosition;
import java.util.Locale;
import java.util.Map;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.s;
import net.time4j.g1.a;
import net.time4j.g1.a0.e;
import net.time4j.g1.b;
import net.time4j.g1.g;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
enum d implements net.time4j.c1<net.time4j.a0>, e<net.time4j.a0> {

    AM_PM_OF_DAY;
    private s accessor(Locale locale, v v2, m m3) {
        return b.d(locale).h(v2, m3);
    }

    private s accessor(d d) {
        return b.d((Locale)d.a(a.c, Locale.ROOT)).h((v)d.a(a.g, v.WIDE), (m)d.a(a.h, m.FORMAT));
    }

    static net.time4j.a0 parseAmPm(java.lang.CharSequence charSequence, ParsePosition parsePosition2) {
        int index;
        int i2;
        int charAt;
        int i;
        char obj4;
        index = parsePosition2.getIndex();
        final int i4 = index + 2;
        if (charSequence.length() >= i4) {
            charAt = charSequence.charAt(index + 1);
            if (charAt != 77) {
                obj4 = charSequence.charAt(index);
                if (charAt == 109 && obj4 != 65) {
                    obj4 = charSequence.charAt(index);
                    if (obj4 != 65) {
                        if (obj4 == 97) {
                        } else {
                            if (obj4 != 80 && obj4 == 112) {
                                if (obj4 == 112) {
                                }
                            }
                        }
                        parsePosition2.setIndex(i4);
                        return a0.PM;
                    }
                }
            } else {
            }
            parsePosition2.setIndex(i4);
            return a0.AM;
        }
        return null;
    }

    public s<net.time4j.b0, net.time4j.a0> at(p p) {
        d1 d1Var = new d1(this, p);
        return d1Var;
    }

    public s<net.time4j.b0, net.time4j.a0> atUTC() {
        return at(p.C);
    }

    @Override // java.lang.Enum
    public int compare(Object object, Object object2) {
        return compare((o)object, (o)object2);
    }

    @Override // java.lang.Enum
    public int compare(o o, o o2) {
        return (a0)o.p(this).compareTo((Enum)o2.p(this));
    }

    @Override // java.lang.Enum
    public Object getDefaultMaximum() {
        return getDefaultMaximum();
    }

    @Override // java.lang.Enum
    public net.time4j.a0 getDefaultMaximum() {
        return a0.PM;
    }

    @Override // java.lang.Enum
    public Object getDefaultMinimum() {
        return getDefaultMinimum();
    }

    @Override // java.lang.Enum
    public net.time4j.a0 getDefaultMinimum() {
        return a0.AM;
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        Object obj2;
        if ((String)b.d(locale).m().get("L_dayperiod") == null) {
            obj2 = name();
        }
        return obj2;
    }

    @Override // java.lang.Enum
    public char getSymbol() {
        return 97;
    }

    public Class<net.time4j.a0> getType() {
        return a0.class;
    }

    public s<net.time4j.b0, net.time4j.a0> in(l l) {
        d1 d1Var = new d1(this, l);
        return d1Var;
    }

    public s<net.time4j.b0, net.time4j.a0> inStdTimezone() {
        return in(l.O());
    }

    public s<net.time4j.b0, net.time4j.a0> inTimezone(k k) {
        return in(l.N(k));
    }

    @Override // java.lang.Enum
    public boolean isDateElement() {
        return 0;
    }

    @Override // java.lang.Enum
    public boolean isLenient() {
        return 0;
    }

    @Override // java.lang.Enum
    public boolean isTimeElement() {
        return 1;
    }

    @Override // java.lang.Enum
    public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Locale locale3, v v4, m m5, g g6) {
        return parse(charSequence, parsePosition2, locale3, v4, m5, g6);
    }

    @Override // java.lang.Enum
    public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return parse(charSequence, parsePosition2, d3);
    }

    @Override // java.lang.Enum
    public net.time4j.a0 parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Locale locale3, v v4, m m5, g g6) {
        Enum amPm;
        Object obj2;
        Object obj4;
        Object obj5;
        if (d.parseAmPm(charSequence, parsePosition2) == null) {
            amPm = obj2;
        }
        return amPm;
    }

    @Override // java.lang.Enum
    public net.time4j.a0 parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        Enum amPm;
        Class type;
        Object obj3;
        if (d.parseAmPm(charSequence, parsePosition2) == null) {
            amPm = obj3;
        }
        return amPm;
    }

    @Override // java.lang.Enum
    public void print(o o, java.lang.Appendable appendable2, Locale locale3, v v4, m m5) {
        appendable2.append(accessor(locale3, v4, m5).g((Enum)o.p(this)));
    }

    @Override // java.lang.Enum
    public void print(o o, java.lang.Appendable appendable2, d d3) {
        appendable2.append(accessor(d3).g((Enum)o.p(this)));
    }
}
