package net.time4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.n;
import net.time4j.f1.g;
import net.time4j.g1.b;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* compiled from: Meridiem.java */
/* loaded from: classes3.dex */
public enum a0 implements n<g> {

    AM,
    PM;
    public static a0 ofHour(int i) {
        net.time4j.a0 pM2;
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Hour of day out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 24;
            if (i <= i2) {
                if (i < 12 || i == i2) {
                    pM2 = a0.AM;
                }
                return pM2;
            }
        }
    }

    public static a0 parse(java.lang.CharSequence charSequence, Locale locale, v vVar, m mVar) throws ParseException {
        final int i3 = 0;
        int i = 2;
        if (charSequence.length() == 2) {
            char charAt = charSequence.charAt(1);
            char c = 'M';
            return a0.AM;
        }
        ParsePosition parsePosition = new ParsePosition(i3);
        Enum obj = b.d(locale).h(vVar, mVar).c(charSequence, parsePosition, a0.class);
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
    public String getDisplayName(Locale locale, v vVar, m mVar) {
        return b.d(locale).h(vVar, mVar).g(this);
    }

    @Override // java.lang.Enum
    public boolean test(g gVar) {
        boolean z = true;
        final int i6 = gVar.s();
        int i = 1;
        final int i3 = 24;
        final int i5 = 12;
        if (this != a0.AM) {
            if (i6 < i5 || i6 >= i3) {
                int i2 = 0;
            }
        }
        return z;
    }
}
