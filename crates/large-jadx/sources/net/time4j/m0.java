package net.time4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.n;
import net.time4j.engine.q;
import net.time4j.engine.u;
import net.time4j.f1.a;
import net.time4j.g1.b;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public enum m0 implements n<a>, u<net.time4j.g0> {

    Q1,
    Q2,
    Q3,
    Q4;
    public static net.time4j.m0 parse(java.lang.CharSequence charSequence, Locale locale2, v v3, m m4) {
        ParsePosition parsePosition = new ParsePosition(0);
        Enum obj3 = b.d(locale2).k(v3, m4).c(charSequence, parsePosition, m0.class);
        if ((m0)obj3 == null) {
        } else {
            return (m0)obj3;
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Cannot parse: ");
        obj4.append(charSequence);
        obj3 = new ParseException(obj4.toString(), parsePosition.getErrorIndex());
        throw obj3;
    }

    public static net.time4j.m0 valueOf(int i) {
        int i2;
        int i3 = 1;
        if (i < i3) {
        } else {
            if (i > 4) {
            } else {
                return m0.ENUMS[i -= i3];
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
        return (g0)g0.G(g0.J, this);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, v.WIDE, m.FORMAT);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v v2, m m3) {
        return b.d(locale).k(v2, m3).g(this);
    }

    @Override // java.lang.Enum
    public int getValue() {
        return ordinal++;
    }

    @Override // java.lang.Enum
    public net.time4j.m0 next() {
        return roll(1);
    }

    @Override // java.lang.Enum
    public net.time4j.m0 previous() {
        return roll(-1);
    }

    @Override // java.lang.Enum
    public net.time4j.m0 roll(int i) {
        return m0.valueOf(i3++);
    }

    @Override // java.lang.Enum
    public boolean test(Object object) {
        return test((a)object);
    }

    @Override // java.lang.Enum
    public boolean test(a a) {
        int i;
        i = 1;
        if (getValue() == obj3 += i) {
        } else {
            i = 0;
        }
        return i;
    }
}
