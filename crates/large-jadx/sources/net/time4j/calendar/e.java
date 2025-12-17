package net.time4j.calendar;

import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.g1.a;
import net.time4j.g1.g;
import net.time4j.g1.t;

/* loaded from: classes3.dex */
class e implements t<net.time4j.calendar.c>, Serializable {

    static final net.time4j.calendar.e a = null;
    private static final long serialVersionUID = -4211396220263977858L;
    static {
        e eVar = new e();
        e.a = eVar;
    }

    @Override // net.time4j.g1.t
    public int a(o o, o o2) {
        return (c)o.p(this).i((n)o2.p(this));
    }

    @Override // net.time4j.g1.t
    public net.time4j.calendar.c b() {
        return c.s(60);
    }

    @Override // net.time4j.g1.t
    public net.time4j.calendar.c c() {
        return c.s(1);
    }

    @Override // net.time4j.g1.t
    public int compare(Object object, Object object2) {
        return a((o)object, (o)object2);
    }

    @Override // net.time4j.g1.t
    public net.time4j.calendar.c d(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return c.t(charSequence, parsePosition2, (Locale)d3.a(a.c, Locale.ROOT), obj6 ^= 1);
    }

    @Override // net.time4j.g1.t
    public Object getDefaultMaximum() {
        return b();
    }

    @Override // net.time4j.g1.t
    public Object getDefaultMinimum() {
        return c();
    }

    @Override // net.time4j.g1.t
    public char getSymbol() {
        return 85;
    }

    public Class<net.time4j.calendar.c> getType() {
        return c.class;
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
    public String name() {
        return "CYCLIC_YEAR";
    }

    @Override // net.time4j.g1.t
    public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return d(charSequence, parsePosition2, d3);
    }

    @Override // net.time4j.g1.t
    public void print(o o, java.lang.Appendable appendable2, d d3) {
        appendable2.append((c)o.p(this).k((Locale)d3.a(a.c, Locale.ROOT)));
    }

    @Override // net.time4j.g1.t
    protected Object readResolve() {
        return e.a;
    }
}
