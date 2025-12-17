package net.time4j.history.q;

import net.time4j.engine.p;
import net.time4j.g1.d;

/* loaded from: classes3.dex */
public class c extends d<Integer> {

    private static final long serialVersionUID = 1L;
    public static final p<Integer> w;
    private final transient char b;
    private final transient Integer c;
    private final transient Integer v;
    static {
        c cVar = new c("YEAR_OF_DISPLAY", 0, 1, 9999);
        c.w = cVar;
    }

    protected c(String string, char c2, int i3, int i4) {
        super(string);
        this.b = c2;
        this.c = Integer.valueOf(i3);
        this.v = Integer.valueOf(i4);
    }

    private Object readResolve() {
        return c.w;
    }

    @Override // net.time4j.g1.d
    public Object getDefaultMaximum() {
        return k();
    }

    @Override // net.time4j.g1.d
    public Object getDefaultMinimum() {
        return l();
    }

    @Override // net.time4j.g1.d
    public char getSymbol() {
        return this.b;
    }

    public final Class<Integer> getType() {
        return Integer.class;
    }

    @Override // net.time4j.g1.d
    public boolean isDateElement() {
        return 1;
    }

    @Override // net.time4j.g1.d
    public boolean isTimeElement() {
        return 0;
    }

    @Override // net.time4j.g1.d
    protected boolean j() {
        return 1;
    }

    @Override // net.time4j.g1.d
    public Integer k() {
        return this.v;
    }

    @Override // net.time4j.g1.d
    public Integer l() {
        return this.c;
    }
}
