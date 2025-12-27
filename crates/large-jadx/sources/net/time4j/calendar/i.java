package net.time4j.calendar;

import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.y;
import net.time4j.g1.a;
import net.time4j.g1.t;

/* compiled from: EastAsianST.java */
/* loaded from: classes3.dex */
class i<D extends f<?, D>> implements t<o>, y<D, o>, Serializable {

    private static final i a = null;
    private static final long serialVersionUID = 4572549754637955194L;
    static {
        i.a = new i();
    }

    i() {
        super();
    }

    static <D extends f<?, D>> i<D> h() {
        return i.a;
    }

    public int b(o oVar, o oVar2) {
        return (o)oVar.p(this).compareTo((Enum)oVar2.p(this));
    }

    public p<?> d(D d) throws java.lang.AbstractMethodError {
        throw new AbstractMethodError();
    }

    public p<?> e(D d) throws java.lang.AbstractMethodError {
        throw new AbstractMethodError();
    }

    public o f() {
        return o.MAJOR_12_DAHAN_300;
    }

    public o g() {
        return o.MINOR_01_LICHUN_315;
    }

    public Class<o> getType() {
        return o.class;
    }

    public o j(D d) {
        final net.time4j.calendar.d dVar = d.X();
        int number = d.i0().getNumber();
        return o.of(dVar.n((dVar.q(d.Y(), number)) + (long)d.m0()));
    }

    public o k(D d) {
        final net.time4j.calendar.d dVar = d.X();
        return o.of(dVar.n((dVar.q(d.Y(), d.i0().getNumber())) + 1L));
    }

    public o l(D d) {
        return o.of(d.X().n(d.c() + 1L));
    }

    public o o(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar) {
        int length = charSequence.length();
        if (parsePosition.getIndex() >= length) {
            parsePosition.setErrorIndex(length);
            return null;
        }
        return o.parse(charSequence, (Locale)dVar.a(a.c, Locale.ROOT), parsePosition);
    }

    public void print(o oVar, java.lang.Appendable appendable, d dVar) throws java.io.IOException {
        appendable.append((o)oVar.p(this).getDisplayName((Locale)dVar.a(a.c, Locale.ROOT)));
    }

    public D r(D d, o oVar, boolean z) {
        if (oVar == null) {
            throw new IllegalArgumentException("Missing solar term.");
        } else {
            return (f)d.H(oVar.sinceNewYear());
        }
    }

    protected Object readResolve() {
        return i.a;
    }

    public char getSymbol() {
        return 0;
    }

    public boolean isDateElement() {
        return true;
    }

    public boolean isLenient() {
        return false;
    }

    public boolean isTimeElement() {
        return false;
    }

    public boolean n(D d, o oVar) {
        boolean z = true;
        d = oVar != null ? 1 : 0;
        return (oVar != null ? 1 : 0);
    }

    public String name() {
        return "SOLAR_TERM";
    }
}
