package net.time4j.calendar;

import net.time4j.engine.e;

/* compiled from: RelatedGregorianYearElement.java */
/* loaded from: classes3.dex */
final class l extends e<Integer> {

    static final l a = null;
    private static final long serialVersionUID = -1117064522468823402L;
    static {
        l.a = new l();
    }

    private l() {
        super("RELATED_GREGORIAN_YEAR");
    }

    @Override // net.time4j.engine.e
    public Class<Integer> getType() {
        return Integer.class;
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

    @Override // net.time4j.engine.e
    public char getSymbol() {
        return 114;
    }

    @Override // net.time4j.engine.e
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.engine.e
    public boolean isTimeElement() {
        return false;
    }

    @Override // net.time4j.engine.e
    protected boolean j() {
        return true;
    }
}
