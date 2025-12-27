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

/* compiled from: StdEnumDateElement.java */
/* loaded from: classes3.dex */
public class e<V extends Enum<V>, T extends q<T>> extends d<V, T> implements l<V>, t<V> {

    private static final long serialVersionUID = -2452569351302286113L;
    private final transient Class<V> c;
    private final transient String v;
    public e(String str, Class<T> cls, Class<V> cls2, char c) {
        super(str, cls, c, e.z(c));
        this.c = cls2;
        this.v = e.n(cls);
    }

    private static String n(Class<?> cls) {
        String value;
        java.lang.annotation.Annotation annotation = cls.getAnnotation(c.class);
        if (annotation == null) {
            value = "iso8601";
        } else {
            value = annotation.value();
        }
        return value;
    }

    @Override // net.time4j.calendar.t.d
    public int A(V v) {
        return v.ordinal() + 1;
    }

    @Override // net.time4j.calendar.t.d
    public V B(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar) {
        m fORMAT2;
        Enum obj2;
        boolean booleanValue;
        int index = parsePosition.getIndex();
        fORMAT2 = m.FORMAT;
        Object obj = dVar.a(a.h, fORMAT2);
        boolean z = false;
        boolean z3 = true;
        final int i = -1;
        if (l(dVar, obj, z).d(charSequence, parsePosition, getType(), dVar) == null && this.x()) {
            parsePosition.setErrorIndex(i);
            parsePosition.setIndex(index);
            obj2 = l(dVar, obj, z3).d(charSequence, parsePosition, getType(), dVar);
        }
        if (obj2 == null) {
            if ((Boolean)dVar.a(a.k, Boolean.TRUE).booleanValue()) {
                parsePosition.setErrorIndex(i);
                parsePosition.setIndex(index);
                if (obj == m.FORMAT) {
                    fORMAT2 = m.STANDALONE;
                }
                if (l(dVar, fORMAT2, z).d(charSequence, parsePosition, getType(), dVar) == null && this.x()) {
                    parsePosition.setErrorIndex(i);
                    parsePosition.setIndex(index);
                    obj2 = l(dVar, fORMAT2, z3).d(charSequence, parsePosition, getType(), dVar);
                }
            }
        }
        return obj2;
    }

    @Override // net.time4j.calendar.t.d
    public int C(V v, o oVar, d dVar) {
        return A(v);
    }

    @Override // net.time4j.calendar.t.d
    public Class<V> getType() {
        return this.c;
    }

    @Override // net.time4j.calendar.t.d
    protected s l(d dVar, m mVar, boolean z) {
        Object obj2 = dVar.a(a.g, v.WIDE);
        b bVar = b.c(o(dVar), (Locale)dVar.a(a.c, Locale.ROOT));
        if (x()) {
            if (z) {
                return bVar.g(obj2, mVar);
            }
            return bVar.l(obj2, mVar);
        }
        if (y()) {
            return bVar.p(obj2, mVar);
        }
        if (w()) {
            return bVar.b(obj2);
        }
        return bVar.n(name(), this.c, new String[0]);
    }

    @Override // net.time4j.calendar.t.d
    protected String o(d dVar) {
        return (String)dVar.a(a.b, this.v);
    }

    @Override // net.time4j.calendar.t.d
    public void print(o oVar, java.lang.Appendable appendable, d dVar) throws java.io.IOException {
        appendable.append(l(dVar, (m)dVar.a(a.h, m.FORMAT), v(oVar)).g((Enum)oVar.p(this)));
    }

    @Override // net.time4j.calendar.t.d
    public V r() {
        Object[] enumConstants = this.c.getEnumConstants();
        return enumConstants[enumConstants.length - 1];
    }

    @Override // net.time4j.calendar.t.d
    public boolean s(q<?> qVar, int i) {
        Object[] enumConstants = getType().getEnumConstants();
        i = 0;
        for (Object obj2 : enumConstants) {
            if (A(obj2) == i) {
                qVar.G(this, obj2);
                return true;
            }
        }
        return false;
    }

    @Override // net.time4j.calendar.t.d
    public V u() {
        return (Enum[])this.c.getEnumConstants()[0];
    }

    @Override // net.time4j.calendar.t.d
    protected boolean w() {
        boolean z = true;
        int r0 = getSymbol() == 71 ? 1 : 0;
        return (getSymbol() == 71 ? 1 : 0);
    }

    @Override // net.time4j.calendar.t.d
    protected boolean x() {
        boolean z = true;
        int r0 = getSymbol() == 77 ? 1 : 0;
        return (getSymbol() == 77 ? 1 : 0);
    }

    @Override // net.time4j.calendar.t.d
    protected boolean y() {
        return e.z(getSymbol());
    }

    private static boolean z(char c) {
        boolean z = true;
        c = c == 69 ? 1 : 0;
        return (c == 69 ? 1 : 0);
    }

    @Override // net.time4j.calendar.t.d
    protected boolean v(o oVar) {
        return false;
    }
}
