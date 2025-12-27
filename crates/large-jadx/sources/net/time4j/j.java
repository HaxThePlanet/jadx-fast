package net.time4j;

import net.time4j.engine.e0;
import net.time4j.engine.p;
import net.time4j.engine.u;

/* compiled from: DateOperator.java */
/* loaded from: classes3.dex */
final class j extends p<g0> {

    private final Object c;
    j(p<?> pVar, int i) {
        this(pVar, i, null);
    }

    private static <V> Object c(p<V> pVar, Object object) {
        return t0.a(e0.o(pVar.getType().cast(object), pVar), object);
    }

    private static <V> Object d(p<V> pVar, Object object) {
        return t0.a(e0.n(pVar.getType().cast(object), pVar), object);
    }

    @Override // net.time4j.p
    public g0 b(g0 g0Var) {
        return (g0)(u)this.c.apply(g0Var);
    }

    j(p<?> pVar, int i, Object object) {
        super(pVar, i);
        switch (i) {
            case -1:
                this.c = j.d(pVar, object);
                break;
            case 0:
                this.c = e0.l(pVar);
                break;
            case 1:
                this.c = e0.j(pVar);
                break;
            case 2:
                this.c = e0.f(pVar);
                break;
            case 3:
                this.c = e0.h(pVar);
                break;
            case 4:
                this.c = e0.d(pVar);
                break;
            case 5:
                this.c = e0.c(pVar);
                break;
            case 6:
                this.c = j.c(pVar, object);
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Unknown: ";
                i = a();
                i = str + i;
                throw new AssertionError(str + i);
        }
    }
}
