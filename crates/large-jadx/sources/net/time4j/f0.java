package net.time4j;

import java.io.Serializable;
import net.time4j.engine.f;
import net.time4j.engine.k0;
import net.time4j.engine.w;

/* loaded from: classes3.dex */
final class f0 extends f implements net.time4j.v, Serializable {

    private static final long serialVersionUID = 1988843503875912054L;
    private final int policy;
    private final net.time4j.f unit;
    f0(net.time4j.f f, int i2) {
        super();
        this.unit = f;
        this.policy = i2;
    }

    protected <T extends net.time4j.engine.q<T>> k0<T> a(w<T> w) {
        if (w.w(g0.F)) {
            f.j obj3 = new f.j(this.unit, this.policy);
            return obj3;
        }
        return 0;
    }

    @Override // net.time4j.engine.f
    public boolean equals(Object object) {
        int i;
        net.time4j.f policy;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof f0) {
            if (this.unit == object.unit && this.policy == object.policy) {
                if (this.policy == object.policy) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.engine.f
    public double getLength() {
        return this.unit.getLength();
    }

    @Override // net.time4j.engine.f
    public char getSymbol() {
        return 0;
    }

    @Override // net.time4j.engine.f
    public int hashCode() {
        return i2 += i4;
    }

    @Override // net.time4j.engine.f
    public boolean isCalendrical() {
        return 1;
    }

    @Override // net.time4j.engine.f
    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.unit.getSymbol());
        stringBuilder.append('-');
        switch (policy) {
            case 1:
                stringBuilder.append("NEXT_VALID_DATE");
                break;
            case 2:
                stringBuilder.append("END_OF_MONTH");
                break;
            case 3:
                stringBuilder.append("CARRY_OVER");
                break;
            case 4:
                stringBuilder.append("UNLESS_INVALID");
                break;
            case 5:
                stringBuilder.append("KEEPING_LAST_DATE");
                break;
            case 6:
                stringBuilder.append("JODA_METRIC");
                break;
            default:
                stringBuilder.append("PREVIOUS_VALID_DATE");
        }
        return stringBuilder.toString();
    }
}
