package net.time4j;

import java.io.InvalidObjectException;
import java.math.BigDecimal;
import net.time4j.engine.e;

/* compiled from: DecimalTimeElement.java */
/* loaded from: classes3.dex */
final class m extends e<BigDecimal> implements c1<BigDecimal> {

    private static final long serialVersionUID = -4837430960549551204L;
    private final transient BigDecimal a;
    m(String str, BigDecimal bigDecimal) {
        super(str);
        this.a = bigDecimal;
    }

    private Object readResolve() throws InvalidObjectException {
        Object obj = h0.F0(name());
        if (obj == null) {
            throw new InvalidObjectException(name());
        } else {
            return obj;
        }
    }

    @Override // net.time4j.engine.e
    public Class<BigDecimal> getType() {
        return BigDecimal.class;
    }

    @Override // net.time4j.engine.e
    public BigDecimal k() {
        return this.a;
    }

    @Override // net.time4j.engine.e
    public BigDecimal l() {
        return BigDecimal.ZERO;
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
