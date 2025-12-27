package net.time4j;

import net.time4j.engine.e;

/* compiled from: DateElement.java */
/* loaded from: classes3.dex */
final class i extends e<g0> implements e {

    static final i a = null;
    private static final long serialVersionUID = -6519899440006935829L;
    static {
        i.a = new i();
    }

    private i() {
        super("CALENDAR_DATE");
    }

    private Object readResolve() {
        return i.a;
    }

    @Override // net.time4j.engine.e
    public Class<g0> getType() {
        return g0.class;
    }

    @Override // net.time4j.engine.e
    public g0 k() {
        return g0.w;
    }

    @Override // net.time4j.engine.e
    public g0 l() {
        return g0.v;
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
