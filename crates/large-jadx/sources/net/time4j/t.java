package net.time4j;

import java.io.InvalidObjectException;
import net.time4j.engine.e;

/* compiled from: IntegerDateElement.java */
/* loaded from: classes3.dex */
final class t extends a<Integer> implements l0<Integer, g0> {

    private static final long serialVersionUID = -1337148214680014674L;
    private final transient int b;
    private final transient Integer c;
    private final transient Integer v;
    private final transient char w;
    private t(String str, int i, Integer integer, Integer integer2, char c) {
        super(str);
        this.b = i;
        this.c = integer;
        this.v = integer2;
        this.w = c;
    }

    static t l(String str, int i, int i2, int i3, char c) {
        t tVar = new t(str, i, Integer.valueOf(i2), Integer.valueOf(i3), c);
        return tVar;
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
        return this.w;
    }

    @Override // net.time4j.a
    public Class<Integer> getType() {
        return Integer.class;
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
