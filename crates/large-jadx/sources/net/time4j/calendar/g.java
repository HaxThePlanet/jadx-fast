package net.time4j.calendar;

import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.Map;
import net.time4j.c0;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.g1.a;
import net.time4j.g1.a0.a;
import net.time4j.g1.a0.b;
import net.time4j.g1.b;
import net.time4j.g1.j;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
class g implements t<net.time4j.calendar.h>, Serializable {

    static final net.time4j.calendar.g a = null;
    private static final long serialVersionUID = -5874268477318061153L;
    static {
        g gVar = new g();
        g.a = gVar;
    }

    @Override // net.time4j.g1.t
    public int a(o o, o o2) {
        return (h)o.p(this).a((h)o2.p(this));
    }

    @Override // net.time4j.g1.t
    public net.time4j.calendar.h b() {
        return h.f(12);
    }

    @Override // net.time4j.g1.t
    public net.time4j.calendar.h c() {
        return h.f(1);
    }

    @Override // net.time4j.g1.t
    public int compare(Object object, Object object2) {
        return a((o)object, (o)object2);
    }

    @Override // net.time4j.g1.t
    public net.time4j.calendar.h d(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        char charAt4;
        net.time4j.calendar.h hVar;
        char charValue2;
        Character valueOf;
        int obj2;
        Object charAt;
        int length;
        int charAt3;
        char charValue;
        int i7;
        int i4;
        int i3;
        int i8;
        boolean booleanValue;
        int i2;
        boolean charAt2;
        int i;
        int i6;
        String str;
        int i5;
        Object obj;
        charAt4 = charSequence;
        final ParsePosition parsePosition = parsePosition2;
        charValue2 = d3;
        obj2 = c0.class;
        charAt = charValue2.a(a.c, Locale.ROOT);
        length = charSequence.length();
        final int index = parsePosition2.getIndex();
        if (index >= length) {
            parsePosition.setErrorIndex(length);
            return null;
        }
        i7 = 0;
        if (charValue2.c(a.u)) {
            Map map = b.c("generic", (Locale)charAt).m();
            charAt = charValue2.a(a.l, j.ARABIC);
            charValue = (Character)charValue2.a(a.m, Character.valueOf((j)charAt.getDigits().charAt(i7))).charValue();
            booleanValue = (Boolean)charValue2.a(h.b, Boolean.valueOf("R".equals(map.get("leap-alignment")))).booleanValue();
            charValue2 = (Character)charValue2.a(h.a, Character.valueOf((String)map.get("leap-indicator").charAt(i7))).charValue();
            if (!booleanValue && charAt4.charAt(index) == charValue2) {
                i2 = charAt4.charAt(index) == charValue2 ? i4 : i7;
            } else {
            }
            if (charAt.isDecimal()) {
            }
            i = 12;
            i6 = i7;
            while (i >= i4) {
                if (i6 == 0) {
                }
                str = b.a(charAt, charValue, i);
                int length2 = str.length();
                i8 = 0;
                charAt3 = obj2 + i8;
                while (length > charAt3) {
                    obj = charAt;
                    charAt = obj;
                    charAt3 = obj2 + i8;
                    obj = charAt;
                }
                obj = charAt;
                if (i8++ == length2) {
                } else {
                }
                charAt = obj;
                obj2 += length2;
                i6 = i;
                i--;
                charAt = obj;
                charAt3 = 0;
                i7 = 0;
                i4 = 1;
                obj = charAt;
                if (charAt4.charAt(charAt3) != str.charAt(i8)) {
                } else {
                }
            }
            if (i6 == 0) {
                parsePosition.setErrorIndex(index);
                return null;
            }
            if (booleanValue && length > obj2 && charAt4.charAt(obj2) == charValue2) {
                if (length > obj2) {
                    i3 = charAt4.charAt(obj2) == charValue2 ? 1 : i2;
                } else {
                }
            } else {
            }
            hVar = h.f(i6);
            parsePosition.setIndex(obj2);
        } else {
        }
        if (i3 != 0) {
            hVar = hVar.i();
        }
        return hVar;
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
        return 77;
    }

    public Class<net.time4j.calendar.h> getType() {
        return h.class;
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
        return "MONTH_OF_YEAR";
    }

    @Override // net.time4j.g1.t
    public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return d(charSequence, parsePosition2, d3);
    }

    @Override // net.time4j.g1.t
    public void print(o o, java.lang.Appendable appendable2, d d3) {
        Object obj;
        Object obj2;
        j aRABIC;
        String str;
        String obj5;
        Object obj7;
        obj = d3.a(a.c, Locale.ROOT);
        obj5 = o.p(this);
        if (d3.c(a.u)) {
            appendable2.append((h)obj5.c((Locale)obj, (j)d3.a(a.l, j.ARABIC), d3));
        } else {
            obj2 = d3.a(a.g, v.WIDE);
            obj7 = d3.a(a.h, m.FORMAT);
            str = "chinese";
            if (obj5.e()) {
                obj7 = b.c(str, obj).g((v)obj2, (m)obj7);
            } else {
                obj7 = b.c(str, obj).l(obj2, obj7);
            }
            appendable2.append(obj7.g(c0.valueOf(obj5.getNumber())));
        }
    }

    @Override // net.time4j.g1.t
    protected Object readResolve() {
        return g.a;
    }
}
