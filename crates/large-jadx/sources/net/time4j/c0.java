package net.time4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.n;
import net.time4j.engine.q;
import net.time4j.engine.u;
import net.time4j.f1.a;
import net.time4j.f1.b;
import net.time4j.g1.b;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public enum c0 implements n<a>, u<net.time4j.g0> {

    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            c0.a.b = iArr;
            int i2 = 1;
            iArr[m0.Q1.ordinal()] = i2;
            int i = 2;
            c0.a.b[m0.Q2.ordinal()] = i;
            int i3 = 3;
            c0.a.b[m0.Q3.ordinal()] = i3;
            int[] iArr12 = new int[values2.length];
            c0.a.a = iArr12;
            iArr12[c0.JANUARY.ordinal()] = i2;
            c0.a.a[c0.FEBRUARY.ordinal()] = i;
            c0.a.a[c0.MARCH.ordinal()] = i3;
            c0.a.a[c0.APRIL.ordinal()] = 4;
            c0.a.a[c0.MAY.ordinal()] = 5;
            c0.a.a[c0.JUNE.ordinal()] = 6;
            c0.a.a[c0.JULY.ordinal()] = 7;
            c0.a.a[c0.AUGUST.ordinal()] = 8;
            c0.a.a[c0.SEPTEMBER.ordinal()] = 9;
        }
    }
    public static net.time4j.c0 atEndOfQuarterYear(net.time4j.m0 m0) {
        int obj1 = c0.a.b[m0.ordinal()];
        if (obj1 != 1 && obj1 != 2 && obj1 != 3) {
            if (obj1 != 2) {
                if (obj1 != 3) {
                    return c0.DECEMBER;
                }
                return c0.SEPTEMBER;
            }
            return c0.JUNE;
        }
        return c0.MARCH;
    }

    public static net.time4j.c0 atStartOfQuarterYear(net.time4j.m0 m0) {
        int obj1 = c0.a.b[m0.ordinal()];
        if (obj1 != 1 && obj1 != 2 && obj1 != 3) {
            if (obj1 != 2) {
                if (obj1 != 3) {
                    return c0.OCTOBER;
                }
                return c0.JULY;
            }
            return c0.APRIL;
        }
        return c0.JANUARY;
    }

    public static net.time4j.c0 parse(java.lang.CharSequence charSequence, Locale locale2, v v3, m m4) {
        ParsePosition parsePosition = new ParsePosition(0);
        Enum obj3 = b.d(locale2).l(v3, m4).c(charSequence, parsePosition, c0.class);
        if ((c0)obj3 == null) {
        } else {
            return (c0)obj3;
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Cannot parse: ");
        obj4.append(charSequence);
        obj3 = new ParseException(obj4.toString(), parsePosition.getErrorIndex());
        throw obj3;
    }

    public static net.time4j.c0 valueOf(int i) {
        int i2;
        int i3 = 1;
        if (i < i3) {
        } else {
            if (i > 12) {
            } else {
                return c0.ENUMS[i -= i3];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // java.lang.Enum
    public Object apply(Object object) {
        return apply((g0)object);
    }

    @Override // java.lang.Enum
    public net.time4j.g0 apply(net.time4j.g0 g0) {
        return (g0)g0.G(g0.K, this);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, v.WIDE, m.FORMAT);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v v2, m m3) {
        return b.d(locale).l(v2, m3).g(this);
    }

    @Override // java.lang.Enum
    public int getLength(int i) {
        return b.d(i, getValue());
    }

    @Override // java.lang.Enum
    public net.time4j.m0 getQuarterOfYear() {
        switch (i) {
            case 1:
                return m0.Q1;
            case 2:
                return m0.Q2;
            case 3:
                return m0.Q3;
            default:
                return m0.Q4;
        }
    }

    @Override // java.lang.Enum
    public int getValue() {
        return ordinal++;
    }

    @Override // java.lang.Enum
    public net.time4j.c0 next() {
        return roll(1);
    }

    @Override // java.lang.Enum
    public net.time4j.c0 previous() {
        return roll(-1);
    }

    @Override // java.lang.Enum
    public net.time4j.c0 roll(int i) {
        return c0.valueOf(i3++);
    }

    @Override // java.lang.Enum
    public boolean test(Object object) {
        return test((a)object);
    }

    @Override // java.lang.Enum
    public boolean test(a a) {
        int obj2;
        obj2 = a.o() == getValue() ? 1 : 0;
        return obj2;
    }
}
