package net.time4j;

import net.time4j.engine.e0;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.u;

/* compiled from: TimeOperator.java */
/* loaded from: classes3.dex */
final class r0 extends p<h0> {

    private final Object c;
    r0(p<?> pVar, int i) {
        this(pVar, i, null);
    }

    private static <V, T extends q<T>> u<T> c(p<V> pVar, boolean z) {
        String name = pVar.name();
        if (!name.equals("MILLI_OF_SECOND")) {
            if (!name.equals("MILLI_OF_DAY")) {
                if (!name.equals("MICRO_OF_SECOND")) {
                    if (!name.equals("MICRO_OF_DAY")) {
                        if (!name.equals("NANO_OF_SECOND")) {
                            if (!name.equals("NANO_OF_DAY")) {
                                if (z) {
                                    return e0.c(pVar);
                                }
                            }
                            return e0.d(pVar);
                        }
                    }
                    return new r('9', z);
                }
            }
            return new r('6', z);
        }
        return new r('3', z);
    }

    private static <V> Object d(p<V> pVar, Object object) {
        return t0.a(e0.o(pVar.getType().cast(object), pVar), object);
    }

    private static <V> Object e(p<V> pVar, Object object) {
        return t0.a(e0.n(pVar.getType().cast(object), pVar), object);
    }

    @Override // net.time4j.p
    public h0 b(h0 h0Var) {
        return (h0)(u)this.c.apply(h0Var);
    }

    r0(p<?> pVar, int i, Object object) {
        super(pVar, i);
        switch (i) {
            case -1:
                this.c = r0.e(pVar, object);
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
                boolean z = false;
                this.c = r0.c(pVar, false);
                break;
            case 5:
                z = true;
                this.c = r0.c(pVar, true);
                break;
            case 6:
                this.c = r0.d(pVar, object);
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
