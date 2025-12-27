package net.time4j;

import java.io.InvalidObjectException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.q;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.g1.g;
import net.time4j.g1.l;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.v;

/* compiled from: EnumElement.java */
/* loaded from: classes3.dex */
final class q<V extends Enum<V>> extends a<V> implements d0<V>, l<V>, net.time4j.g1.a0.e<V> {

    private static final long serialVersionUID = 2055272540517425102L;
    private final transient Class<V> b;
    private final transient V c;
    private final transient V v;
    private final transient int w;
    private final transient char x;
    q(String str, Class<V> cls, V v, V v2, int i, char c) {
        super(str);
        this.b = cls;
        this.c = v;
        this.v = v2;
        this.w = i;
        this.x = c;
    }

    private s l(Locale locale, v vVar, m mVar) {
        switch (this.w) {
            case 101:
                return b.d(locale).l(vVar, mVar);
            case 102:
                return b.d(locale).p(vVar, mVar);
            case 103:
                return b.d(locale).k(vVar, mVar);
            default:
                throw new UnsupportedOperationException(this.name());
        }
    }

    private Object readResolve() throws InvalidObjectException {
        Object obj = g0.I0(name());
        if (obj == null) {
            throw new InvalidObjectException(name());
        } else {
            return obj;
        }
    }

    @Override // net.time4j.a
    public char getSymbol() {
        return this.x;
    }

    @Override // net.time4j.a
    public Class<V> getType() {
        return this.b;
    }

    @Override // net.time4j.a
    public V n() {
        return this.v;
    }

    @Override // net.time4j.a
    public V o() {
        return this.c;
    }

    @Override // net.time4j.a
    public void print(o oVar, java.lang.Appendable appendable, d dVar) throws java.io.IOException {
        appendable.append(l((Locale)dVar.a(a.c, Locale.ROOT), (v)dVar.a(a.g, v.WIDE), (m)dVar.a(a.h, m.FORMAT)).g((Enum)oVar.p(this)));
    }

    @Override // net.time4j.a
    int r() {
        return this.w;
    }

    @Override // net.time4j.a
    public boolean s(q<?> qVar, int i) {
        Object[] enumConstants = getType().getEnumConstants();
        i = 0;
        for (Object obj2 : enumConstants) {
            if (u(obj2) == i) {
                qVar.G(this, obj2);
                return true;
            }
        }
        return false;
    }

    @Override // net.time4j.a
    public int u(V v) {
        return v.ordinal() + 1;
    }

    @Override // net.time4j.a
    public V v(java.lang.CharSequence charSequence, ParsePosition parsePosition, Locale locale, v vVar, m mVar, g gVar) {
        m fORMAT2;
        Enum obj;
        if (l(locale, vVar, mVar).e(charSequence, parsePosition, getType(), gVar) == null && !gVar.isStrict()) {
            parsePosition.setErrorIndex(-1);
            parsePosition.setIndex(parsePosition.getIndex());
            if (mVar == m.FORMAT) {
                fORMAT2 = m.STANDALONE;
            }
            obj = l(locale, vVar, fORMAT2).e(charSequence, parsePosition, getType(), gVar);
        }
        return obj;
    }

    @Override // net.time4j.a
    public V w(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar) {
        m fORMAT2;
        Enum obj2;
        Object obj = dVar.a(a.c, Locale.ROOT);
        Object obj3 = dVar.a(a.g, v.WIDE);
        fORMAT2 = m.FORMAT;
        Object obj4 = dVar.a(a.h, fORMAT2);
        if (l(obj, obj3, obj4).d(charSequence, parsePosition, getType(), dVar) == null) {
            if ((Boolean)dVar.a(a.k, Boolean.TRUE).booleanValue()) {
                parsePosition.setErrorIndex(-1);
                parsePosition.setIndex(parsePosition.getIndex());
                if (obj4 == m.FORMAT) {
                    fORMAT2 = m.STANDALONE;
                }
                obj2 = l(obj, obj3, fORMAT2).d(charSequence, parsePosition, getType(), dVar);
            }
        }
        return obj2;
    }

    @Override // net.time4j.a
    public int x(V v, o oVar, d dVar) {
        return v.ordinal() + 1;
    }

    @Override // net.time4j.a
    public void print(o oVar, java.lang.Appendable appendable, Locale locale, v vVar, m mVar) throws java.io.IOException {
        appendable.append(l(locale, vVar, mVar).g((Enum)oVar.p(this)));
    }

    @Override // net.time4j.a
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.a
    public boolean isTimeElement() {
        return false;
    }

    @Override // net.time4j.a
    protected boolean j() {
        return true;
    }
}
