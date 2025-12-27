package net.time4j;

import net.time4j.engine.q;
import net.time4j.engine.u;

/* compiled from: FractionOperator.java */
/* loaded from: classes3.dex */
final class r<T extends q<T>> implements u<T> {

    private final char a;
    private final boolean b;
    r(char c, boolean z) {
        super();
        this.a = c;
        this.b = z;
    }

    public T a(T t) {
        int i = 0;
        if (this.a == 57) {
            return t;
        }
        net.time4j.l0 l0Var = h0.U;
        int value = (Integer)t.p(l0Var).intValue();
        int value2 = (Integer)t.r(l0Var).intValue();
        i = 0;
        if (this.a != 51 && this.a == 54) {
            if (this.b) {
                i = 999;
            }
            return t.E(h0.U, Math.min(value2, (value / 1000) * 1000 + i));
        }
        int i9 = 1000000;
        if (this.b) {
            i = 999999;
        }
        return t.E(h0.U, Math.min(value2, (value / i9) * i9 + i));
    }
}
