package net.time4j.history.q;

import net.time4j.engine.p;
import net.time4j.g1.d;

/* compiled from: StdHistoricalElement.java */
/* loaded from: classes3.dex */
public class c extends d<Integer> {

    private static final long serialVersionUID = 1L;
    public static final p<Integer> w = new c<>("YEAR_OF_DISPLAY", 0, 1, 9999);
    private final transient char b;
    private final transient Integer c;
    private final transient Integer v;

    protected c(String str, char c, int i, int i2) {
        super(str);
        this.b = c;
        this.c = Integer.valueOf(i);
        this.v = Integer.valueOf(i2);
    }

    private Object readResolve() {
        return c.w;
    }

    @Override // net.time4j.g1.d
    public char getSymbol() {
        return this.b;
    }

    @Override // net.time4j.g1.d
    public final Class<Integer> getType() {
        return Integer.class;
    }

    @Override // net.time4j.g1.d
    public Integer k() {
        return this.v;
    }

    @Override // net.time4j.g1.d
    public Integer l() {
        return this.c;
    }

    @Override // net.time4j.g1.d
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.g1.d
    public boolean isTimeElement() {
        return false;
    }

    @Override // net.time4j.g1.d
    protected boolean j() {
        return true;
    }
}
