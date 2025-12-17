package net.time4j;

import net.time4j.engine.e0;
import net.time4j.engine.p;
import net.time4j.engine.u;

/* loaded from: classes3.dex */
final class r0 extends net.time4j.p<net.time4j.h0> {

    private final Object c;
    r0(p<?> p, int i2) {
        super(p, i2, 0);
    }

    r0(p<?> p, int i2, Object object3) {
        Object obj1;
        int obj2;
        super(p, i2);
        switch (i2) {
            case -1:
                this.c = r0.e(p, object3);
                break;
            case 0:
                this.c = e0.l(p);
                break;
            case 1:
                this.c = e0.j(p);
                break;
            case 2:
                this.c = e0.f(p);
                break;
            case 3:
                this.c = e0.h(p);
                break;
            case 4:
                this.c = r0.c(p, false);
                break;
            case 5:
                this.c = r0.c(p, true);
                break;
            case 6:
                this.c = r0.d(p, object3);
                break;
            default:
                obj2 = new StringBuilder();
                obj2.append("Unknown: ");
                obj2.append(a());
                obj1 = new AssertionError(obj2.toString());
                throw obj1;
        }
    }

    private static <V, T extends net.time4j.engine.q<T>> u<T> c(p<V> p, boolean z2) {
        String equals3;
        boolean equals4;
        boolean equals2;
        boolean equals;
        equals3 = p.name();
        if (!equals3.equals("MILLI_OF_SECOND")) {
            if (equals3.equals("MILLI_OF_DAY")) {
            } else {
                if (!equals3.equals("MICRO_OF_SECOND")) {
                    if (equals3.equals("MICRO_OF_DAY")) {
                    } else {
                        if (!equals3.equals("NANO_OF_SECOND")) {
                            if (equals3.equals("NANO_OF_DAY")) {
                            } else {
                                if (z2) {
                                    return e0.c(p);
                                }
                            }
                            return e0.d(p);
                        }
                    }
                    r obj2 = new r(57, z2);
                    return obj2;
                }
            }
            obj2 = new r(54, z2);
            return obj2;
        }
        obj2 = new r(51, z2);
        return obj2;
    }

    private static <V> Object d(p<V> p, Object object2) {
        return t0.a(e0.o(p.getType().cast(object2), p), object2);
    }

    private static <V> Object e(p<V> p, Object object2) {
        return t0.a(e0.n(p.getType().cast(object2), p), object2);
    }

    @Override // net.time4j.p
    public Object apply(Object object) {
        return b((h0)object);
    }

    @Override // net.time4j.p
    public net.time4j.h0 b(net.time4j.h0 h0) {
        return (h0)(u)this.c.apply(h0);
    }
}
