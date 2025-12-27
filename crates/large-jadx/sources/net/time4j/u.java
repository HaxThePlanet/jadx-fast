package net.time4j;

import java.io.InvalidObjectException;
import net.time4j.engine.e;

/* compiled from: IntegerTimeElement.java */
/* loaded from: classes3.dex */
final class u extends b<Integer> implements l0<Integer, h0> {

    private static final long serialVersionUID = -1337148214680014674L;
    private final transient int b;
    private final transient Integer c;
    private final transient Integer v;
    private final transient char w;
    private u(String str, int i, Integer integer, Integer integer2, char c) {
        super(str);
        this.b = i;
        this.c = integer;
        this.v = integer2;
        this.w = c;
        i = 5;
        if (i != 5 && i != 7 && i != 9) {
            i = 13;
        }
    }

    static u l(String str, boolean z) {
        int i2 = 12;
        int i;
        int i3 = 107;
        i = 1;
        i = z ? i : i;
        int r0 = z ? 24 : 12;
        z = z ? 107 : 104;
        u uVar = new u(str, i, 1, Integer.valueOf((z ? 24 : 12)), (z ? 107 : 104));
        return uVar;
    }

    static u n(String str, int i, int i2, int i3, char c) {
        u uVar = new u(str, i, Integer.valueOf(i2), Integer.valueOf(i3), c);
        return uVar;
    }

    private Object readResolve() throws InvalidObjectException {
        Object obj = h0.F0(name());
        if (obj == null) {
            throw new InvalidObjectException(name());
        } else {
            return obj;
        }
    }

    @Override // net.time4j.b
    public char getSymbol() {
        return this.w;
    }

    @Override // net.time4j.b
    public Class<Integer> getType() {
        return Integer.class;
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

    @Override // net.time4j.b
    public boolean isDateElement() {
        return false;
    }

    @Override // net.time4j.b
    public boolean isTimeElement() {
        return true;
    }

    @Override // net.time4j.b
    protected boolean j() {
        return true;
    }
}
