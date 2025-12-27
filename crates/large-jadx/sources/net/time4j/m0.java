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

/* compiled from: Quarter.java */
/* loaded from: classes3.dex */
public enum m0 implements n<a>, u<g0> {

    Q1,
    Q2,
    Q3,
    Q4;
    public static m0 parse(java.lang.CharSequence charSequence, Locale locale, v vVar, m mVar) throws ParseException {
        final ParsePosition parsePosition = new ParsePosition(0);
        Enum obj = b.d(locale).k(vVar, mVar).c(charSequence, parsePosition, m0.class);
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
    public int getValue() {
        return ordinal() + 1;
    }

    @Override // java.lang.Enum
    public m0 next() {
        return roll(1);
    }

    @Override // java.lang.Enum
    public m0 previous() {
        return roll(-1);
    }

    @Override // java.lang.Enum
    public m0 roll(int i) {
        return m0.valueOf((ordinal() + (i % 4) + 4) % 4 + 1);
    }

    public static m0 valueOf(int i) {
        int i3 = 1;
        if (i < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 4;
            if (i <= 4) {
                return m0.ENUMS[i - i3];
            }
        }
    }

    @Override // java.lang.Enum
    public g0 apply(g0 g0Var) {
        return (g0)g0Var.G(g0.J, this);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v vVar, m mVar) {
        return b.d(locale).k(vVar, mVar).g(this);
    }

    @Override // java.lang.Enum
    public boolean test(a aVar) {
        boolean z = true;
        int i = 1;
        if (getValue() != (aVar.o() - i) / 3 + i) {
            int i2 = 0;
        }
        return z;
    }
}
