package net.time4j;

import java.util.Comparator;
import net.time4j.engine.c0;
import net.time4j.engine.j0.a;
import net.time4j.engine.v;

/* loaded from: classes3.dex */
class o0<U extends net.time4j.x>  implements c0<U>, Comparator<j0.a<? extends v>> {
    private o0(boolean z) {
        super();
    }

    static Comparator<j0.a<? extends v>> a() {
        o0 o0Var = new o0(0);
        return o0Var;
    }

    static int b(v v, v v2) {
        boolean obj4;
        int compare = Double.compare(v2.getLength(), obj1);
        if (compare == 0) {
            if (!v.equals(v2)) {
            } else {
            }
            obj4 = new IllegalArgumentException("Mixing different units of same length not allowed.");
            throw obj4;
        }
        return compare;
    }

    static net.time4j.o0<net.time4j.f> d() {
        o0 o0Var = new o0(0);
        return o0Var;
    }

    static net.time4j.o0<net.time4j.h> e() {
        o0 o0Var = new o0(0);
        return o0Var;
    }

    static net.time4j.o0<net.time4j.x> f() {
        o0 o0Var = new o0(1);
        return o0Var;
    }

    public int c(j0.a<? extends v> j0$a, j0.a<? extends v> j0$a2) {
        return o0.b((v)a.b(), (v)a2.b());
    }

    @Override // net.time4j.engine.c0
    public int compare(Object object, Object object2) {
        return c((j0.a)object, (j0.a)object2);
    }
}
