package net.time4j.calendar;

import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.g1.a;
import net.time4j.g1.g;
import net.time4j.g1.t;

/* compiled from: EastAsianCY.java */
/* loaded from: classes3.dex */
class e implements t<c>, Serializable {

    static final e a = null;
    private static final long serialVersionUID = -4211396220263977858L;
    static {
        e.a = new e();
    }

    e() {
        super();
    }

    public int a(o oVar, o oVar2) {
        return (c)oVar.p(this).i((n)oVar2.p(this));
    }

    public c b() {
        return c.s(60);
    }

    public c c() {
        return c.s(1);
    }

    public c d(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar) {
        return c.t(charSequence, parsePosition, (Locale)dVar.a(a.c, Locale.ROOT), !(g)dVar.a(a.f, g.SMART).isStrict());
    }

    public Class<c> getType() {
        return c.class;
    }

    public void print(o oVar, java.lang.Appendable appendable, d dVar) throws java.io.IOException {
        appendable.append((c)oVar.p(this).k((Locale)dVar.a(a.c, Locale.ROOT)));
    }

    protected Object readResolve() {
        return e.a;
    }

    public char getSymbol() {
        return 85;
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

    public String name() {
        return "CYCLIC_YEAR";
    }
}
