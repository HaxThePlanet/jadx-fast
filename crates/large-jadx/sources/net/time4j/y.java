package net.time4j;

import java.io.InvalidObjectException;
import net.time4j.engine.e;
import net.time4j.engine.p;

/* compiled from: LongElement.java */
/* loaded from: classes3.dex */
final class y extends b<Long> implements l0<Long, h0> {

    private static final long serialVersionUID = 5930990958663061693L;
    static final p<Long> v = new y<>();
    private final transient Long b;
    private final transient Long c;

    private y() {
        this("DAY_OVERFLOW", Long.MIN_VALUE, l2, 9223372036854775807L, obj2);
    }

    static y l(String str, long j, long j2) {
        y yVar = new y(str, j, l, j2, obj2);
        return yVar;
    }

    private Object readResolve() throws InvalidObjectException {
        Object obj = h0.F0(name());
        if (obj == null) {
            if (!name().equals("DAY_OVERFLOW")) {
                throw new InvalidObjectException(name());
            } else {
                return y.v;
            }
        }
        return obj;
    }

    @Override // net.time4j.b
    public Class<Long> getType() {
        return Long.class;
    }

    @Override // net.time4j.b
    public Long n() {
        return this.c;
    }

    @Override // net.time4j.b
    public Long o() {
        return this.b;
    }

    private y(String str, long j, long j2) {
        super(str);
        this.b = Long.valueOf(j);
        this.c = Long.valueOf(j2);
    }

    @Override // net.time4j.b
    public boolean isDateElement() {
        return false;
    }

    @Override // net.time4j.b
    public boolean isTimeElement() {
        return true;
    }
}
