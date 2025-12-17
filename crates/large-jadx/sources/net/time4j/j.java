package net.time4j;

import net.time4j.engine.e0;
import net.time4j.engine.p;
import net.time4j.engine.u;

/* loaded from: classes3.dex */
final class j extends net.time4j.p<net.time4j.g0> {

    private final Object c;
    j(p<?> p, int i2) {
        super(p, i2, 0);
    }

    j(p<?> p, int i2, Object object3) {
        Object obj1;
        super(p, i2);
        switch (i2) {
            case -1:
                this.c = j.d(p, object3);
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
                this.c = e0.d(p);
                break;
            case 5:
                this.c = e0.c(p);
                break;
            case 6:
                this.c = j.c(p, object3);
                break;
            default:
                StringBuilder obj2 = new StringBuilder();
                obj2.append("Unknown: ");
                obj2.append(a());
                obj1 = new AssertionError(obj2.toString());
                throw obj1;
        }
    }

    private static <V> Object c(p<V> p, Object object2) {
        return t0.a(e0.o(p.getType().cast(object2), p), object2);
    }

    private static <V> Object d(p<V> p, Object object2) {
        return t0.a(e0.n(p.getType().cast(object2), p), object2);
    }

    @Override // net.time4j.p
    public Object apply(Object object) {
        return b((g0)object);
    }

    @Override // net.time4j.p
    public net.time4j.g0 b(net.time4j.g0 g0) {
        return (g0)(u)this.c.apply(g0);
    }
}
