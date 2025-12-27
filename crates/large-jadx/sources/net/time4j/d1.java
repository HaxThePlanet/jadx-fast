package net.time4j;

import java.util.Objects;
import net.time4j.engine.q;
import net.time4j.engine.s;
import net.time4j.tz.l;

/* compiled from: ZonalQuery.java */
/* loaded from: classes3.dex */
class d1<V> implements s<b0, V> {

    private final net.time4j.engine.p<V> a;
    private final l b;
    private final net.time4j.tz.p c;
    d1(net.time4j.engine.p<V> pVar, l lVar) {
        super();
        Objects.requireNonNull(lVar, "Missing timezone.");
        this.a = pVar;
        this.b = lVar;
        this.c = null;
    }

    public V a(b0 b0Var) {
        net.time4j.tz.p pVar;
        if (this.c == null) {
            pVar = this.b.B(b0Var);
        }
        if (this.a == h0.Q && b0Var.m0() && this.b.n() == 0) {
            int i4 = 60;
            if (pVar.m() % i4 == 0) {
                return this.a.getType().cast(60);
            }
        }
        return i0.W(b0Var, pVar).p(this.a);
    }

    d1(net.time4j.engine.p<V> pVar, net.time4j.tz.p pVar2) {
        super();
        Objects.requireNonNull(pVar2, "Missing timezone offset.");
        this.a = pVar;
        this.b = null;
        this.c = pVar2;
    }
}
