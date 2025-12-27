package net.time4j.calendar;

import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.Map;
import net.time4j.c0;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.g1.j;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* compiled from: EastAsianME.java */
/* loaded from: classes3.dex */
class g implements t<h>, Serializable {

    static final g a = null;
    private static final long serialVersionUID = -5874268477318061153L;
    static {
        g.a = new g();
    }

    g() {
        super();
    }

    public int a(o oVar, o oVar2) {
        return (h)oVar.p(this).a((h)oVar2.p(this));
    }

    public h b() {
        return h.f(12);
    }

    public h c() {
        return h.f(1);
    }

    public h d(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar) {
        java.lang.CharSequence charSequence2;
        net.time4j.calendar.h hVar;
        int index;
        j jVar;
        Object obj2;
        int i = 0;
        int i2 = 0;
        Enum obj;
        int i3 = 0;
        boolean decimal;
        String str2;
        charSequence2 = charSequence;
        final ParsePosition parsePosition22 = parsePosition;
        d dVar32 = dVar;
        Class<c0> obj4 = c0.class;
        obj2 = dVar32.a(a.c, Locale.ROOT);
        int length = charSequence.length();
        index = parsePosition.getIndex();
        i = 0;
        if (index >= length) {
            parsePosition22.setErrorIndex(length);
            return null;
        }
        i2 = 0;
        i2 = 1;
        if (dVar32.c(a.u)) {
            Map map = b.c("generic", obj2).m();
            Object obj5 = dVar32.a(a.l, j.ARABIC);
            char charValue2 = (Character)dVar32.a(a.m, Character.valueOf(obj5.getDigits().charAt(i2))).charValue();
            boolean booleanValue = (Boolean)dVar32.a(h.b, Boolean.valueOf("R".equals(map.get("leap-alignment")))).booleanValue();
            char charValue = (Character)dVar32.a(h.a, Character.valueOf((String)map.get("leap-indicator").charAt(i2))).charValue();
            i2 = booleanValue || charSequence2.charAt(index) != charValue ? i2 : i2;
            if (obj5.isDecimal()) {
                while (index < length) {
                    if (charSequence2.charAt(index) != charValue2) {
                        break;
                    }
                }
            }
            i2 = 12;
            while (i2 >= i2) {
            }
            if (i2 == 0) {
                parsePosition22.setErrorIndex(index);
                return null;
            }
            i2 = !booleanValue || length <= index || charSequence2.charAt(index) != charValue ? i2 : 1;
            hVar = h.f(i2);
            parsePosition22.setIndex(index);
        }
        if (i2 != 0) {
            hVar = hVar.i();
        }
        return hVar;
    }

    public Class<h> getType() {
        return h.class;
    }

    public void print(o oVar, java.lang.Appendable appendable, d dVar) throws java.io.IOException {
        net.time4j.g1.b bVar;
        s sVar;
        Object obj = dVar.a(a.c, Locale.ROOT);
        Object obj3 = oVar.p(this);
        if (dVar.c(a.u)) {
            appendable.append(obj3.c(obj, (j)dVar.a(a.l, j.ARABIC), dVar));
        } else {
            Object obj2 = dVar.a(a.g, v.WIDE);
            Object obj4 = dVar.a(a.h, m.FORMAT);
            str = "chinese";
            if (obj3.e()) {
                sVar = b.c(str, obj).g(obj2, obj4);
            } else {
                sVar = b.c(str, obj).l(obj2, obj4);
            }
            appendable.append(sVar.g(c0.valueOf(obj3.getNumber())));
        }
    }

    protected Object readResolve() {
        return g.a;
    }

    public char getSymbol() {
        return 77;
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
        return "MONTH_OF_YEAR";
    }
}
