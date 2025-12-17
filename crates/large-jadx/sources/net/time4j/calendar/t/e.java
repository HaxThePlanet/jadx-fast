package net.time4j.calendar.t;

import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.d;
import net.time4j.engine.e;
import net.time4j.engine.o;
import net.time4j.engine.q;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.g1.c;
import net.time4j.g1.l;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public class e<V extends Enum<V>, T extends q<T>>  extends net.time4j.calendar.t.d<V, T> implements l<V>, t<V> {

    private static final long serialVersionUID = -2452569351302286113L;
    private final transient Class<V> c;
    private final transient String v;
    public e(String string, Class<T> class2, Class<V> class3, char c4) {
        super(string, class2, c4, e.z(c4));
        this.c = class3;
        this.v = e.n(class2);
    }

    private static String n(Class<?> class) {
        String obj1;
        obj1 = class.getAnnotation(c.class);
        if ((c)obj1 == null) {
            obj1 = "iso8601";
        } else {
            obj1 = (c)obj1.value();
        }
        return obj1;
    }

    private static boolean z(char c) {
        int obj1;
        obj1 = c == 69 ? 1 : 0;
        return obj1;
    }

    public int A(V v) {
        return obj1++;
    }

    public V B(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        int index;
        Object type;
        m sTANDALONE;
        int type2;
        Enum obj;
        boolean booleanValue;
        Boolean tRUE;
        index = parsePosition2.getIndex();
        sTANDALONE = m.FORMAT;
        type = d3.a(a.h, sTANDALONE);
        type2 = 0;
        int i = 1;
        final int i2 = -1;
        if (l(d3, (m)type, type2).d(charSequence, parsePosition2, getType(), d3) == null && x()) {
            if (x()) {
                parsePosition2.setErrorIndex(i2);
                parsePosition2.setIndex(index);
                obj = l(d3, type, i).d(charSequence, parsePosition2, getType(), d3);
            }
        }
        parsePosition2.setErrorIndex(i2);
        parsePosition2.setIndex(index);
        if (obj == null && (Boolean)d3.a(a.k, Boolean.TRUE).booleanValue() && type == sTANDALONE) {
            if ((Boolean)d3.a(a.k, Boolean.TRUE).booleanValue()) {
                parsePosition2.setErrorIndex(i2);
                parsePosition2.setIndex(index);
                if (type == sTANDALONE) {
                    sTANDALONE = m.STANDALONE;
                }
                if (l(d3, sTANDALONE, type2).d(charSequence, parsePosition2, getType(), d3) == null && x()) {
                    if (x()) {
                        parsePosition2.setErrorIndex(i2);
                        parsePosition2.setIndex(index);
                        obj = l(d3, sTANDALONE, i).d(charSequence, parsePosition2, getType(), d3);
                    }
                }
            }
        }
        return obj;
    }

    public int C(V v, o o2, d d3) {
        return A(v);
    }

    @Override // net.time4j.calendar.t.d
    public int compare(Object object, Object object2) {
        return b((o)object, (o)object2);
    }

    @Override // net.time4j.calendar.t.d
    public Object getDefaultMaximum() {
        return r();
    }

    @Override // net.time4j.calendar.t.d
    public Object getDefaultMinimum() {
        return u();
    }

    public Class<V> getType() {
        return this.c;
    }

    @Override // net.time4j.calendar.t.d
    protected s l(d d, m m2, boolean z3) {
        Object obj2 = d.a(a.g, v.WIDE);
        b obj4 = b.c(o(d), (Locale)d.a(a.c, Locale.ROOT));
        if (x() && z3) {
            if (z3) {
                return obj4.g((v)obj2, m2);
            }
            return obj4.l(obj2, m2);
        }
        if (y()) {
            return obj4.p(obj2, m2);
        }
        if (w()) {
            return obj4.b(obj2);
        }
        return obj4.n(name(), this.c, new String[0]);
    }

    @Override // net.time4j.calendar.t.d
    protected String o(d d) {
        boolean z;
        if (!x()) {
            if (w()) {
            } else {
                if (y()) {
                    return "iso8601";
                }
            }
            return this.v;
        }
        return (String)d.a(a.b, this.v);
    }

    @Override // net.time4j.calendar.t.d
    public int p(Object object, o o2, d d3) {
        return C((Enum)object, o2, d3);
    }

    @Override // net.time4j.calendar.t.d
    public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return B(charSequence, parsePosition2, d3);
    }

    @Override // net.time4j.calendar.t.d
    public void print(o o, java.lang.Appendable appendable2, d d3) {
        appendable2.append(l(d3, (m)d3.a(a.h, m.FORMAT), v(o)).g((Enum)o.p(this)));
    }

    public V r() {
        Object[] enumConstants = this.c.getEnumConstants();
        return (Enum[])enumConstants[length--];
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

    public V u() {
        return (Enum[])this.c.getEnumConstants()[0];
    }

    @Override // net.time4j.calendar.t.d
    protected boolean v(o o) {
        return 0;
    }

    @Override // net.time4j.calendar.t.d
    protected boolean w() {
        int i;
        i = getSymbol() == 71 ? 1 : 0;
        return i;
    }

    @Override // net.time4j.calendar.t.d
    protected boolean x() {
        int i;
        i = getSymbol() == 77 ? 1 : 0;
        return i;
    }

    @Override // net.time4j.calendar.t.d
    protected boolean y() {
        return e.z(getSymbol());
    }
}
