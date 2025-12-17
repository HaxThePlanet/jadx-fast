package net.time4j;

import net.time4j.engine.e;

/* loaded from: classes3.dex */
final class q0 extends e<net.time4j.h0> implements net.time4j.u0 {

    static final net.time4j.q0 a = null;
    private static final long serialVersionUID = -3712256393866098916L;
    static {
        q0 q0Var = new q0();
        q0.a = q0Var;
    }

    private q0() {
        super("WALL_TIME");
    }

    private Object readResolve() {
        return q0.a;
    }

    @Override // net.time4j.engine.e
    public Object getDefaultMaximum() {
        return k();
    }

    @Override // net.time4j.engine.e
    public Object getDefaultMinimum() {
        return l();
    }

    public Class<net.time4j.h0> getType() {
        return h0.class;
    }

    @Override // net.time4j.engine.e
    public boolean isDateElement() {
        return 0;
    }

    @Override // net.time4j.engine.e
    public boolean isTimeElement() {
        return 1;
    }

    @Override // net.time4j.engine.e
    protected boolean j() {
        return 1;
    }

    @Override // net.time4j.engine.e
    public net.time4j.h0 k() {
        final int i2 = 59;
        return h0.L0(23, i2, i2, 999999999);
    }

    @Override // net.time4j.engine.e
    public net.time4j.h0 l() {
        return h0.E;
    }
}
