package net.time4j;

import net.time4j.engine.e;

/* compiled from: TimeElement.java */
/* loaded from: classes3.dex */
final class q0 extends e<h0> implements u0 {

    static final q0 a = null;
    private static final long serialVersionUID = -3712256393866098916L;
    static {
        q0.a = new q0();
    }

    private q0() {
        super("WALL_TIME");
    }

    private Object readResolve() {
        return q0.a;
    }

    @Override // net.time4j.engine.e
    public Class<h0> getType() {
        return h0.class;
    }

    @Override // net.time4j.engine.e
    public h0 k() {
        final int i2 = 59;
        return h0.L0(23, i2, i2, 999999999);
    }

    @Override // net.time4j.engine.e
    public h0 l() {
        return h0.E;
    }

    @Override // net.time4j.engine.e
    public boolean isDateElement() {
        return false;
    }

    @Override // net.time4j.engine.e
    public boolean isTimeElement() {
        return true;
    }

    @Override // net.time4j.engine.e
    protected boolean j() {
        return true;
    }
}
