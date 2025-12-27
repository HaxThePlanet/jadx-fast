package net.time4j;

/* compiled from: WeekdayInMonthElement.java */
/* loaded from: classes3.dex */
final class y0 extends a<Integer> implements e0 {

    static final y0 b = null;
    private static final long serialVersionUID = -2378018589067147278L;
    static {
        y0.b = new y0();
    }

    private y0() {
        super("WEEKDAY_IN_MONTH");
    }

    private Object readResolve() {
        return y0.b;
    }

    @Override // net.time4j.a
    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override // net.time4j.a
    public Integer l() {
        return 5;
    }

    @Override // net.time4j.a
    public Integer n() {
        return 1;
    }

    @Override // net.time4j.a
    public char getSymbol() {
        return 70;
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
