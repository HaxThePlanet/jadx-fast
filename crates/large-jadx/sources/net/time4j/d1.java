package net.time4j;

import java.util.Objects;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.s;
import net.time4j.tz.l;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
class d1<V>  implements s<net.time4j.b0, V> {

    private final p<V> a;
    private final l b;
    private final p c;
    d1(p<V> p, l l2) {
        super();
        Objects.requireNonNull(l2, "Missing timezone.");
        this.a = p;
        this.b = l2;
        this.c = 0;
    }

    d1(p<V> p, p p2) {
        super();
        Objects.requireNonNull(p2, "Missing timezone offset.");
        this.a = p;
        this.b = 0;
        this.c = p2;
    }

    public V a(net.time4j.b0 b0) {
        p pVar;
        p pVar2;
        net.time4j.l0 l0Var;
        if (this.c == null) {
            pVar = this.b.B(b0);
        }
        l0Var = 60;
        if (this.a == h0.Q && b0.m0() && pVar.n() == 0 && i %= l0Var == 0) {
            if (b0.m0()) {
                if (pVar.n() == 0) {
                    l0Var = 60;
                    if (i %= l0Var == 0) {
                        return this.a.getType().cast(Integer.valueOf(l0Var));
                    }
                }
            }
        }
        return i0.W(b0, pVar).p(this.a);
    }

    @Override // net.time4j.engine.s
    public Object apply(Object object) {
        return a((b0)object);
    }
}
