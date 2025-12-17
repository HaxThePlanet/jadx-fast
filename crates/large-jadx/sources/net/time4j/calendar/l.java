package net.time4j.calendar;

import net.time4j.engine.e;

/* loaded from: classes3.dex */
final class l extends e<Integer> {

    static final net.time4j.calendar.l a = null;
    private static final long serialVersionUID = -1117064522468823402L;
    static {
        l lVar = new l();
        l.a = lVar;
    }

    private l() {
        super("RELATED_GREGORIAN_YEAR");
    }

    @Override // net.time4j.engine.e
    public Object getDefaultMaximum() {
        return k();
    }

    @Override // net.time4j.engine.e
    public Object getDefaultMinimum() {
        return l();
    }

    @Override // net.time4j.engine.e
    public char getSymbol() {
        return 114;
    }

    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override // net.time4j.engine.e
    public boolean isDateElement() {
        return 1;
    }

    @Override // net.time4j.engine.e
    public boolean isTimeElement() {
        return 0;
    }

    @Override // net.time4j.engine.e
    protected boolean j() {
        return 1;
    }

    @Override // net.time4j.engine.e
    public Integer k() {
        return 999999999;
    }

    @Override // net.time4j.engine.e
    public Integer l() {
        return -999999999;
    }

    @Override // net.time4j.engine.e
    protected Object readResolve() {
        return l.a;
    }
}
