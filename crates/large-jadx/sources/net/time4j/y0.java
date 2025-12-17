package net.time4j;

/* loaded from: classes3.dex */
final class y0 extends net.time4j.a<Integer> implements net.time4j.e0 {

    static final net.time4j.y0 b = null;
    private static final long serialVersionUID = -2378018589067147278L;
    static {
        y0 y0Var = new y0();
        y0.b = y0Var;
    }

    private y0() {
        super("WEEKDAY_IN_MONTH");
    }

    private Object readResolve() {
        return y0.b;
    }

    @Override // net.time4j.a
    public Object getDefaultMaximum() {
        return l();
    }

    @Override // net.time4j.a
    public Object getDefaultMinimum() {
        return n();
    }

    @Override // net.time4j.a
    public char getSymbol() {
        return 70;
    }

    public Class<Integer> getType() {
        return Integer.class;
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
    public Integer l() {
        return 5;
    }

    @Override // net.time4j.a
    public Integer n() {
        return 1;
    }
}
