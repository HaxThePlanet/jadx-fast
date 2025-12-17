package net.time4j;

import java.io.InvalidObjectException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.d;
import net.time4j.engine.e;
import net.time4j.engine.o;
import net.time4j.engine.q;
import net.time4j.g1.a;
import net.time4j.g1.a0.e;
import net.time4j.g1.b;
import net.time4j.g1.g;
import net.time4j.g1.l;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
final class q<V extends Enum<V>>  extends net.time4j.a<V> implements net.time4j.d0<V>, l<V>, e<V> {

    private static final long serialVersionUID = 2055272540517425102L;
    private final transient Class<V> b;
    private final transient V c;
    private final transient V v;
    private final transient int w;
    private final transient char x;
    q(String string, Class<V> class2, V v3, V v4, int i5, char c6) {
        super(string);
        this.b = class2;
        this.c = v3;
        this.v = v4;
        this.w = i5;
        this.x = c6;
    }

    private s l(Locale locale, v v2, m m3) {
        switch (i2) {
            case 101:
                return b.d(locale).l(v2, m3);
            case 102:
                return b.d(locale).p(v2, m3);
            case 103:
                return b.d(locale).k(v2, m3);
            default:
                UnsupportedOperationException obj2 = new UnsupportedOperationException(name());
                throw obj2;
        }
    }

    private Object readResolve() {
        Object obj = g0.I0(name());
        if (obj == null) {
        } else {
            return obj;
        }
        InvalidObjectException invalidObjectException = new InvalidObjectException(name());
        throw invalidObjectException;
    }

    @Override // net.time4j.a
    public Object getDefaultMaximum() {
        return n();
    }

    @Override // net.time4j.a
    public Object getDefaultMinimum() {
        return o();
    }

    @Override // net.time4j.a
    public char getSymbol() {
        return this.x;
    }

    public Class<V> getType() {
        return this.b;
    }

    @Override // net.time4j.a
    public boolean isDateElement() {
        return 1;
    }

    @Override // net.time4j.a
    public boolean isTimeElement() {
        return 0;
    }

    @Override // net.time4j.a
    protected boolean j() {
        return 1;
    }

    public V n() {
        return this.v;
    }

    public V o() {
        return this.c;
    }

    @Override // net.time4j.a
    public int p(Object object, o o2, d d3) {
        return x((Enum)object, o2, d3);
    }

    @Override // net.time4j.a
    public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Locale locale3, v v4, m m5, g g6) {
        return v(charSequence, parsePosition2, locale3, v4, m5, g6);
    }

    @Override // net.time4j.a
    public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return w(charSequence, parsePosition2, d3);
    }

    @Override // net.time4j.a
    public void print(o o, java.lang.Appendable appendable2, Locale locale3, v v4, m m5) {
        appendable2.append(l(locale3, v4, m5).g((Enum)o.p(this)));
    }

    @Override // net.time4j.a
    public void print(o o, java.lang.Appendable appendable2, d d3) {
        appendable2.append(l((Locale)d3.a(a.c, Locale.ROOT), (v)d3.a(a.g, v.WIDE), (m)d3.a(a.h, m.FORMAT)).g((Enum)o.p(this)));
    }

    @Override // net.time4j.a
    int r() {
        return this.w;
    }

    public boolean s(q<?> q, int i2) {
        int i3;
        Object obj;
        int i;
        Object[] enumConstants = getType().getEnumConstants();
        final int i4 = 0;
        i3 = i4;
        while (i3 < enumConstants.length) {
            obj = (Enum[])enumConstants[i3];
            i3++;
        }
        return i4;
    }

    public int u(V v) {
        return obj1++;
    }

    public V v(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Locale locale3, v v4, m m5, g g6) {
        m sTANDALONE;
        Enum obj;
        Class strict;
        Object obj6;
        Object obj7;
        parsePosition2.setErrorIndex(-1);
        parsePosition2.setIndex(parsePosition2.getIndex());
        if (l(locale3, v4, m5).e(charSequence, parsePosition2, getType(), g6) == null && !g6.isStrict() && m5 == m.FORMAT) {
            if (!g6.isStrict()) {
                parsePosition2.setErrorIndex(-1);
                parsePosition2.setIndex(sTANDALONE);
                if (m5 == m.FORMAT) {
                    sTANDALONE = m.STANDALONE;
                }
                obj = l(locale3, v4, sTANDALONE).e(charSequence, parsePosition2, getType(), g6);
            }
        }
        return obj;
    }

    public V w(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        int index;
        Object type;
        m sTANDALONE;
        Enum obj;
        Class booleanValue;
        Boolean tRUE;
        type = d3.a(a.c, Locale.ROOT);
        Object obj2 = d3.a(a.g, v.WIDE);
        sTANDALONE = m.FORMAT;
        Object obj3 = d3.a(a.h, sTANDALONE);
        parsePosition2.setErrorIndex(-1);
        parsePosition2.setIndex(parsePosition2.getIndex());
        if (l((Locale)type, (v)obj2, (m)obj3).d(charSequence, parsePosition2, getType(), d3) == null && (Boolean)d3.a(a.k, Boolean.TRUE).booleanValue() && obj3 == sTANDALONE) {
            if ((Boolean)d3.a(a.k, Boolean.TRUE).booleanValue()) {
                parsePosition2.setErrorIndex(-1);
                parsePosition2.setIndex(index);
                if (obj3 == sTANDALONE) {
                    sTANDALONE = m.STANDALONE;
                }
                obj = l(type, obj2, sTANDALONE).d(charSequence, parsePosition2, getType(), d3);
            }
        }
        return obj;
    }

    public int x(V v, o o2, d d3) {
        return obj1++;
    }
}
