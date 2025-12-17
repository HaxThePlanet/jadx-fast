package net.time4j.g1.z;

import net.time4j.engine.c;
import net.time4j.engine.d;

/* loaded from: classes3.dex */
final class p implements d {

    private final d a;
    private final d b;
    p(d d, d d2) {
        super();
        this.a = d;
        this.b = d2;
    }

    public <A> A a(c<A> c, A a2) {
        if (this.a.c(c)) {
            return this.a.b(c);
        }
        return this.b.a(c, a2);
    }

    public <A> A b(c<A> c) {
        if (this.a.c(c)) {
            return this.a.b(c);
        }
        return this.b.b(c);
    }

    public boolean c(c<?> c) {
        d z;
        int obj2;
        if (!this.a.c(c)) {
            if (this.b.c(c)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }
}
