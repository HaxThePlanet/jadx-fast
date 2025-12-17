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

/* loaded from: classes3.dex */
class i<D extends net.time4j.calendar.f<?, D>>  implements t<net.time4j.calendar.o>, y<D, net.time4j.calendar.o>, Serializable {

    private static final net.time4j.calendar.i a = null;
    private static final long serialVersionUID = 4572549754637955194L;
    static {
        i iVar = new i();
        i.a = iVar;
    }

    static <D extends net.time4j.calendar.f<?, D>> net.time4j.calendar.i<D> h() {
        return i.a;
    }

    @Override // net.time4j.g1.t
    public int b(o o, o o2) {
        return (o)o.p(this).compareTo((Enum)o2.p(this));
    }

    @Override // net.time4j.g1.t
    public int compare(Object object, Object object2) {
        return b((o)object, (o)object2);
    }

    public p<?> d(D d) {
        AbstractMethodError obj1 = new AbstractMethodError();
        throw obj1;
    }

    public p<?> e(D d) {
        AbstractMethodError obj1 = new AbstractMethodError();
        throw obj1;
    }

    @Override // net.time4j.g1.t
    public net.time4j.calendar.o f() {
        return o.MAJOR_12_DAHAN_300;
    }

    @Override // net.time4j.g1.t
    public net.time4j.calendar.o g() {
        return o.MINOR_01_LICHUN_315;
    }

    @Override // net.time4j.g1.t
    public p getChildAtCeiling(Object object) {
        d((f)object);
        throw 0;
    }

    @Override // net.time4j.g1.t
    public p getChildAtFloor(Object object) {
        e((f)object);
        throw 0;
    }

    @Override // net.time4j.g1.t
    public Object getDefaultMaximum() {
        return f();
    }

    @Override // net.time4j.g1.t
    public Object getDefaultMinimum() {
        return g();
    }

    @Override // net.time4j.g1.t
    public Object getMaximum(Object object) {
        return j((f)object);
    }

    @Override // net.time4j.g1.t
    public Object getMinimum(Object object) {
        return k((f)object);
    }

    @Override // net.time4j.g1.t
    public char getSymbol() {
        return 0;
    }

    public Class<net.time4j.calendar.o> getType() {
        return o.class;
    }

    @Override // net.time4j.g1.t
    public Object getValue(Object object) {
        return l((f)object);
    }

    @Override // net.time4j.g1.t
    public boolean isDateElement() {
        return 1;
    }

    @Override // net.time4j.g1.t
    public boolean isLenient() {
        return 0;
    }

    @Override // net.time4j.g1.t
    public boolean isTimeElement() {
        return 0;
    }

    @Override // net.time4j.g1.t
    public boolean isValid(Object object, Object object2) {
        return n((f)object, (o)object2);
    }

    public net.time4j.calendar.o j(D d) {
        final net.time4j.calendar.d dVar = d.X();
        int number = d.i0().getNumber();
        return o.of(dVar.n(l += l2));
    }

    public net.time4j.calendar.o k(D d) {
        final net.time4j.calendar.d dVar = d.X();
        return o.of(dVar.n(l += i3));
    }

    public net.time4j.calendar.o l(D d) {
        return o.of(d.X().n(l += i2));
    }

    public boolean n(D d, net.time4j.calendar.o o2) {
        int obj1;
        obj1 = o2 != null ? 1 : 0;
        return obj1;
    }

    @Override // net.time4j.g1.t
    public String name() {
        return "SOLAR_TERM";
    }

    @Override // net.time4j.g1.t
    public net.time4j.calendar.o o(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        int length = charSequence.length();
        if (parsePosition2.getIndex() >= length) {
            parsePosition2.setErrorIndex(length);
            return null;
        }
        return o.parse(charSequence, (Locale)d3.a(a.c, Locale.ROOT), parsePosition2);
    }

    @Override // net.time4j.g1.t
    public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return o(charSequence, parsePosition2, d3);
    }

    @Override // net.time4j.g1.t
    public void print(o o, java.lang.Appendable appendable2, d d3) {
        appendable2.append((o)o.p(this).getDisplayName((Locale)d3.a(a.c, Locale.ROOT)));
    }

    public D r(D d, net.time4j.calendar.o o2, boolean z3) {
        if (o2 == null) {
        } else {
            return (f)d.H(o2.sinceNewYear());
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Missing solar term.");
        throw obj1;
    }

    @Override // net.time4j.g1.t
    protected Object readResolve() {
        return i.a;
    }

    @Override // net.time4j.g1.t
    public Object withValue(Object object, Object object2, boolean z3) {
        return r((f)object, (o)object2, z3);
    }
}
