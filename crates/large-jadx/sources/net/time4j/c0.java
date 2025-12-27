package net.time4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.n;
import net.time4j.engine.q;
import net.time4j.engine.u;
import net.time4j.f1.a;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* compiled from: Month.java */
/* loaded from: classes3.dex */
public enum c0 implements n<a>, u<g0> {

    APRIL,
    AUGUST,
    DECEMBER,
    FEBRUARY,
    JANUARY,
    JULY,
    JUNE,
    MARCH,
    MAY,
    NOVEMBER,
    OCTOBER,
    SEPTEMBER;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[m0.values().length];
            c0.a.b = iArr;
            int i2 = 1;
            try {
                iArr[m0.Q1.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int[] iArr12 = new int[c0.values().length];
                c0.a.a = iArr12;
                return;
            }
            int i = 2;
            try {
                c0.a.b[m0.Q2.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public static c0 atEndOfQuarterYear(m0 m0Var) {
        int i4 = c0.a.b[m0Var.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 != 3) {
                return c0.DECEMBER;
            }
            return c0.SEPTEMBER;
        }
        return c0.MARCH;
    }

    public static c0 atStartOfQuarterYear(m0 m0Var) {
        int i4 = c0.a.b[m0Var.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 != 3) {
                return c0.OCTOBER;
            }
            return c0.JULY;
        }
        return c0.JANUARY;
    }

    public static c0 parse(java.lang.CharSequence charSequence, Locale locale, v vVar, m mVar) throws ParseException {
        final ParsePosition parsePosition = new ParsePosition(0);
        Enum obj = b.d(locale).l(vVar, mVar).c(charSequence, parsePosition, c0.class);
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Cannot parse: ";
            charSequence = str + charSequence;
            throw new ParseException(charSequence, parsePosition.getErrorIndex());
        } else {
            return obj;
        }
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, v.WIDE, m.FORMAT);
    }

    @Override // java.lang.Enum
    public int getLength(int i) {
        return b.d(i, getValue());
    }

    @Override // java.lang.Enum
    public m0 getQuarterOfYear() {
        switch (c0.a.a[ordinal()]) {
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
        return ordinal() + 1;
    }

    @Override // java.lang.Enum
    public c0 next() {
        return roll(1);
    }

    @Override // java.lang.Enum
    public c0 previous() {
        return roll(-1);
    }

    @Override // java.lang.Enum
    public c0 roll(int i) {
        return c0.valueOf((ordinal() + (i % 12) + 12) % 12 + 1);
    }

    public static c0 valueOf(int i) {
        int i3 = 1;
        if (i < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 12;
            if (i <= 12) {
                return c0.ENUMS[i - i3];
            }
        }
    }

    @Override // java.lang.Enum
    public g0 apply(g0 g0Var) {
        return (g0)g0Var.G(g0.K, this);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v vVar, m mVar) {
        return b.d(locale).l(vVar, mVar).g(this);
    }

    @Override // java.lang.Enum
    public boolean test(a aVar) {
        boolean z = true;
        aVar = aVar.o() == getValue() ? 1 : 0;
        return (aVar.o() == getValue() ? 1 : 0);
    }
}
