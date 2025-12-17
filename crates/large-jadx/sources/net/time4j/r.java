package net.time4j;

import net.time4j.engine.q;
import net.time4j.engine.u;

/* loaded from: classes3.dex */
final class r<T extends q<T>>  implements u<T> {

    private final char a;
    private final boolean b;
    r(char c, boolean z2) {
        super();
        this.a = c;
        this.b = z2;
    }

    public T a(T t) {
        int i;
        if (this.a == 57) {
            return t;
        }
        net.time4j.l0 l0Var = h0.U;
        int intValue = (Integer)t.p(l0Var).intValue();
        int intValue2 = (Integer)t.r(l0Var).intValue();
        char c3 = this.a;
        i = 0;
        if (c3 != 51) {
            if (c3 != 54) {
            } else {
                if (this.b) {
                    i = 999;
                }
                return t.E(l0Var, Math.min(intValue2, i4 += i));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown: ");
            stringBuilder.append(this.a);
            UnsupportedOperationException obj7 = new UnsupportedOperationException(stringBuilder.toString());
            throw obj7;
        }
        int i11 = 1000000;
        if (this.b) {
            i = 999999;
        }
        return t.E(l0Var, Math.min(intValue2, i8 += i));
    }

    @Override // net.time4j.engine.u
    public Object apply(Object object) {
        return a((q)object);
    }
}
