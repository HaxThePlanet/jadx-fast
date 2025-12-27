package net.time4j;

import java.text.ParsePosition;
import java.util.Locale;
import java.util.Map;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.g1.a;
import net.time4j.g1.a0.e;
import net.time4j.g1.b;
import net.time4j.g1.g;
import net.time4j.g1.m;
import net.time4j.g1.v;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.p;

/* compiled from: AmPmElement.java */
/* loaded from: classes3.dex */
enum d implements c1<a0>, e<a0> {

    AM_PM_OF_DAY;
    private net.time4j.g1.s accessor(d dVar) {
        return b.d((Locale)dVar.a(a.c, Locale.ROOT)).h((v)dVar.a(a.g, v.WIDE), (m)dVar.a(a.h, m.FORMAT));
    }

    static a0 parseAmPm(java.lang.CharSequence charSequence, ParsePosition parsePosition) {
        char c3 = 77;
        int index = parsePosition.getIndex();
        final int i2 = index + 2;
        if (charSequence.length() >= i2) {
            char charAt2 = charSequence.charAt(index + 1);
            c3 = 'M';
            parsePosition.setIndex(i2);
            return a0.AM;
        }
        return null;
    }

    @Override // java.lang.Enum
    public net.time4j.engine.s<b0, a0> at(p pVar) {
        return new d1(this, pVar);
    }

    @Override // java.lang.Enum
    public net.time4j.engine.s<b0, a0> atUTC() {
        return at(p.C);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        Object value;
        if ((String)b.d(locale).m().get("L_dayperiod") == null) {
            String name = name();
        }
        return value;
    }

    @Override // java.lang.Enum
    public Class<a0> getType() {
        return a0.class;
    }

    @Override // java.lang.Enum
    public net.time4j.engine.s<b0, a0> in(l lVar) {
        return new d1(this, lVar);
    }

    @Override // java.lang.Enum
    public net.time4j.engine.s<b0, a0> inStdTimezone() {
        return in(l.O());
    }

    @Override // java.lang.Enum
    public net.time4j.engine.s<b0, a0> inTimezone(k kVar) {
        return in(l.N(kVar));
    }

    @Override // java.lang.Enum
    public void print(o oVar, java.lang.Appendable appendable, d dVar) throws java.io.IOException {
        appendable.append(accessor(dVar).g((Enum)oVar.p(this)));
    }

    @Override // java.lang.Enum
    public int compare(o oVar, o oVar2) {
        return (a0)oVar.p(this).compareTo((Enum)oVar2.p(this));
    }

    @Override // java.lang.Enum
    public a0 getDefaultMaximum() {
        return a0.PM;
    }

    @Override // java.lang.Enum
    public a0 getDefaultMinimum() {
        return a0.AM;
    }

    @Override // java.lang.Enum
    public void print(o oVar, java.lang.Appendable appendable, Locale locale, v vVar, m mVar) throws java.io.IOException {
        appendable.append(accessor(locale, vVar, mVar).g((Enum)oVar.p(this)));
    }

    @Override // java.lang.Enum
    public a0 parse(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar) {
        net.time4j.a0 amPm;
        if (d.parseAmPm(charSequence, parsePosition) == null) {
        }
        return amPm;
    }

    private net.time4j.g1.s accessor(Locale locale, v vVar, m mVar) {
        return b.d(locale).h(vVar, mVar);
    }

    @Override // java.lang.Enum
    public a0 parse(java.lang.CharSequence charSequence, ParsePosition parsePosition, Locale locale, v vVar, m mVar, g gVar) {
        net.time4j.a0 amPm;
        if (d.parseAmPm(charSequence, parsePosition) == null) {
        }
        return amPm;
    }

    @Override // java.lang.Enum
    public char getSymbol() {
        return 97;
    }

    @Override // java.lang.Enum
    public boolean isDateElement() {
        return false;
    }

    @Override // java.lang.Enum
    public boolean isLenient() {
        return false;
    }

    @Override // java.lang.Enum
    public boolean isTimeElement() {
        return true;
    }
}
