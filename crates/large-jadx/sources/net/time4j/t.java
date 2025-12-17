package net.time4j;

import java.io.InvalidObjectException;
import net.time4j.engine.e;

/* loaded from: classes3.dex */
final class t extends net.time4j.a<Integer> implements net.time4j.l0<Integer, net.time4j.g0> {

    private static final long serialVersionUID = -1337148214680014674L;
    private final transient int b;
    private final transient Integer c;
    private final transient Integer v;
    private final transient char w;
    private t(String string, int i2, Integer integer3, Integer integer4, char c5) {
        super(string);
        this.b = i2;
        this.c = integer3;
        this.v = integer4;
        this.w = c5;
    }

    static net.time4j.t l(String string, int i2, int i3, int i4, char c5) {
        super(string, i2, Integer.valueOf(i3), Integer.valueOf(i4), c5);
        return tVar2;
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
        return this.w;
    }

    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override // net.time4j.a
    public net.time4j.p i(Number number) {
        return super.k((Integer)number);
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

    @Override // net.time4j.a
    public Integer n() {
        return this.v;
    }

    @Override // net.time4j.a
    public Integer o() {
        return this.c;
    }

    @Override // net.time4j.a
    int r() {
        return this.b;
    }
}
