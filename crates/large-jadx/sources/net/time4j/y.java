package net.time4j;

import java.io.InvalidObjectException;
import net.time4j.engine.e;
import net.time4j.engine.p;

/* loaded from: classes3.dex */
final class y extends net.time4j.b<Long> implements net.time4j.l0<Long, net.time4j.h0> {

    private static final long serialVersionUID = 5930990958663061693L;
    static final p<Long> v;
    private final transient Long b;
    private final transient Long c;
    static {
        y yVar = new y();
        y.v = yVar;
    }

    private y() {
        super("DAY_OVERFLOW", Long.MIN_VALUE, obj3, Long.MAX_VALUE, obj5);
    }

    private y(String string, long l2, long l3) {
        super(string);
        this.b = Long.valueOf(l2);
        this.c = Long.valueOf(obj4);
    }

    static net.time4j.y l(String string, long l2, long l3) {
        super(string, l2, obj3, obj10, obj5);
        return yVar2;
    }

    private Object readResolve() {
        Object obj = h0.F0(name());
        if (obj == null) {
            if (!name().equals("DAY_OVERFLOW")) {
            } else {
                return y.v;
            }
            InvalidObjectException invalidObjectException = new InvalidObjectException(name());
            throw invalidObjectException;
        }
        return obj;
    }

    @Override // net.time4j.b
    public Object getDefaultMaximum() {
        return n();
    }

    @Override // net.time4j.b
    public Object getDefaultMinimum() {
        return o();
    }

    public Class<Long> getType() {
        return Long.class;
    }

    @Override // net.time4j.b
    public net.time4j.p i(Number number) {
        return super.k((Long)number);
    }

    @Override // net.time4j.b
    public boolean isDateElement() {
        return 0;
    }

    @Override // net.time4j.b
    public boolean isTimeElement() {
        return 1;
    }

    @Override // net.time4j.b
    public Long n() {
        return this.c;
    }

    @Override // net.time4j.b
    public Long o() {
        return this.b;
    }
}
