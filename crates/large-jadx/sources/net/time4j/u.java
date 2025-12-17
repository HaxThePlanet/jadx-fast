package net.time4j;

import java.io.InvalidObjectException;
import net.time4j.engine.e;

/* loaded from: classes3.dex */
final class u extends net.time4j.b<Integer> implements net.time4j.l0<Integer, net.time4j.h0> {

    private static final long serialVersionUID = -1337148214680014674L;
    private final transient int b;
    private final transient Integer c;
    private final transient Integer v;
    private final transient char w;
    private u(String string, int i2, Integer integer3, Integer integer4, char c5) {
        int obj1;
        super(string);
        this.b = i2;
        this.c = integer3;
        this.v = integer4;
        this.w = c5;
        if (i2 != 5 && i2 != 7 && i2 != 9) {
            if (i2 != 7) {
                obj1 = i2 != 9 ? 13 : obj1;
            }
        }
    }

    static net.time4j.u l(String string, boolean z2) {
        int i;
        int i3;
        int i2;
        int obj8;
        int i4 = 1;
        i2 = z2 ? i3 : i4;
        i = z2 ? 24 : 12;
        obj8 = z2 ? 107 : 104;
        super(string, i2, Integer.valueOf(i4), Integer.valueOf(i), obj8);
        return uVar2;
    }

    static net.time4j.u n(String string, int i2, int i3, int i4, char c5) {
        super(string, i2, Integer.valueOf(i3), Integer.valueOf(i4), c5);
        return uVar2;
    }

    private Object readResolve() {
        Object obj = h0.F0(name());
        if (obj == null) {
        } else {
            return obj;
        }
        InvalidObjectException invalidObjectException = new InvalidObjectException(name());
        throw invalidObjectException;
    }

    @Override // net.time4j.b
    public Object getDefaultMaximum() {
        return o();
    }

    @Override // net.time4j.b
    public Object getDefaultMinimum() {
        return r();
    }

    @Override // net.time4j.b
    public char getSymbol() {
        return this.w;
    }

    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override // net.time4j.b
    public net.time4j.p i(Number number) {
        return super.k((Integer)number);
    }

    @Override // net.time4j.b
    public boolean isDateElement() {
        return 0;
    }

    @Override // net.time4j.b
    public boolean isTimeElement() {
        return 1;
    }

    @Override // net.time4j.b
    protected boolean j() {
        return 1;
    }

    @Override // net.time4j.b
    public Integer o() {
        return this.v;
    }

    @Override // net.time4j.b
    public Integer r() {
        return this.c;
    }

    @Override // net.time4j.b
    int u() {
        return this.b;
    }
}
