package net.time4j;

import net.time4j.engine.e;

/* loaded from: classes3.dex */
final class i extends e<net.time4j.g0> implements net.time4j.e {

    static final net.time4j.i a = null;
    private static final long serialVersionUID = -6519899440006935829L;
    static {
        i iVar = new i();
        i.a = iVar;
    }

    private i() {
        super("CALENDAR_DATE");
    }

    private Object readResolve() {
        return i.a;
    }

    @Override // net.time4j.engine.e
    public Object getDefaultMaximum() {
        return k();
    }

    @Override // net.time4j.engine.e
    public Object getDefaultMinimum() {
        return l();
    }

    public Class<net.time4j.g0> getType() {
        return g0.class;
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
    public net.time4j.g0 k() {
        return g0.w;
    }

    @Override // net.time4j.engine.e
    public net.time4j.g0 l() {
        return g0.v;
    }
}
