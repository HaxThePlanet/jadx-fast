package net.time4j;

import java.io.InvalidObjectException;
import java.math.BigDecimal;
import net.time4j.engine.e;

/* loaded from: classes3.dex */
final class m extends e<BigDecimal> implements net.time4j.c1<BigDecimal> {

    private static final long serialVersionUID = -4837430960549551204L;
    private final transient BigDecimal a;
    m(String string, BigDecimal bigDecimal2) {
        super(string);
        this.a = bigDecimal2;
    }

    private Object readResolve() {
        Object obj = h0.F0(name());
        if (obj == null) {
        } else {
            return obj;
        }
        InvalidObjectException invalidObjectException = new InvalidObjectException(name());
        throw invalidObjectException;
    }

    @Override // net.time4j.engine.e
    public Object getDefaultMaximum() {
        return k();
    }

    @Override // net.time4j.engine.e
    public Object getDefaultMinimum() {
        return l();
    }

    public Class<BigDecimal> getType() {
        return BigDecimal.class;
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
    public BigDecimal k() {
        return this.a;
    }

    @Override // net.time4j.engine.e
    public BigDecimal l() {
        return BigDecimal.ZERO;
    }
}
