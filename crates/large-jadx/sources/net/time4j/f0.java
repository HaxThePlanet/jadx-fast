package net.time4j;

import java.io.Serializable;
import net.time4j.engine.f;
import net.time4j.engine.k0;
import net.time4j.engine.q;
import net.time4j.engine.w;

/* compiled from: OverflowUnit.java */
/* loaded from: classes3.dex */
final class f0 extends f implements v, Serializable {

    private static final long serialVersionUID = 1988843503875912054L;
    private final int policy;
    private final f unit;
    f0(f fVar, int i) {
        super();
        this.unit = fVar;
        this.policy = i;
    }

    @Override // net.time4j.engine.f
    protected <T extends q<T>> k0<T> a(w<T> wVar) {
        if (wVar.w(g0.F)) {
            return new f.j(this.unit, this.policy);
        }
        return null;
    }

    @Override // net.time4j.engine.f
    public boolean equals(Object object) {
        boolean z = true;
        net.time4j.f unit2;
        int policy2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof f0) {
            if (this.unit == object.unit) {
                if (this.policy != object.policy) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.engine.f
    public double getLength() {
        return this.unit.getLength();
    }

    @Override // net.time4j.engine.f
    public int hashCode() {
        return (this.unit.hashCode() * 23) + (this.policy * 37);
    }

    @Override // net.time4j.engine.f
    public String toString() throws StringBuilder {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.unit.getSymbol());
        stringBuilder.append('-');
        switch (this.policy) {
            case 1:
                str = "NEXT_VALID_DATE";
                stringBuilder.append("NEXT_VALID_DATE");
                break;
            case 2:
                str = "END_OF_MONTH";
                stringBuilder.append("END_OF_MONTH");
                break;
            case 3:
                str = "CARRY_OVER";
                stringBuilder.append("CARRY_OVER");
                break;
            case 4:
                str = "UNLESS_INVALID";
                stringBuilder.append("UNLESS_INVALID");
                break;
            case 5:
                str = "KEEPING_LAST_DATE";
                stringBuilder.append("KEEPING_LAST_DATE");
                break;
            case 6:
                str = "JODA_METRIC";
                stringBuilder.append("JODA_METRIC");
                break;
            default:
                str = "PREVIOUS_VALID_DATE";
                stringBuilder.append("PREVIOUS_VALID_DATE");
        }
        return stringBuilder.toString();
    }

    @Override // net.time4j.engine.f
    public char getSymbol() {
        return 0;
    }

    @Override // net.time4j.engine.f
    public boolean isCalendrical() {
        return true;
    }
}
