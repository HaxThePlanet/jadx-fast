package net.time4j.g1.z;

import net.time4j.engine.c;
import net.time4j.engine.d;

/* compiled from: MergedAttributes.java */
/* loaded from: classes3.dex */
final class p implements d {

    private final d a;
    private final d b;
    p(d dVar, d dVar2) {
        super();
        this.a = dVar;
        this.b = dVar2;
    }

    public <A> A a(c<A> cVar, A a) {
        if (this.a.c(cVar)) {
            return this.a.b(cVar);
        }
        return this.b.a(cVar, a);
    }

    public <A> A b(c<A> cVar) {
        if (this.a.c(cVar)) {
            return this.a.b(cVar);
        }
        return this.b.b(cVar);
    }

    public boolean c(c<?> cVar) {
        boolean z;
        boolean z3 = false;
        if (!this.a.c(cVar)) {
            if (this.b.c(cVar)) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z3;
    }
}
