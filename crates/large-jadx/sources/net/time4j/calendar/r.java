package net.time4j.calendar;

import net.time4j.engine.g;
import net.time4j.engine.k;
import net.time4j.engine.p;
import net.time4j.engine.s;
import net.time4j.engine.y;
import net.time4j.f1.c;
import net.time4j.x0;
import net.time4j.z0;

/* compiled from: WeekdayRule.java */
/* loaded from: classes3.dex */
class r<D extends g> implements y<D, x0> {

    private final z0 a;
    private final s<D, k<D>> b;
    r(z0 z0Var, s<D, k<D>> sVar) {
        super();
        this.a = z0Var;
        this.b = sVar;
    }

    private static x0 h(long j) {
        return x0.valueOf((c.d(j + 5L, 7)) + 1);
    }

    public x0 e(D d) {
        Object apply = this.b.apply(d);
        int value = g(d).getValue(this.a);
        long l4 = (d.c() + 7L) - (long)value;
        long l6 = apply.c();
        if (this.a > l6) {
            return r.h(apply.c());
        }
        return this.a.f().roll(6);
    }

    public x0 f(D d) {
        Object apply = this.b.apply(d);
        int value = g(d).getValue(this.a);
        long l4 = (d.c() + 1L) - (long)value;
        long l6 = apply.d();
        if (this.a < l6) {
            return r.h(apply.d());
        }
        return this.a.f();
    }

    public x0 g(D d) {
        return r.h(d.c());
    }

    public boolean i(D d, x0 x0Var) {
        boolean z = false;
        z = false;
        if (x0Var == null) {
            return false;
        }
        long l3 = (d.c() + (long)x0Var.getValue(this.a)) - (long)g(d).getValue(this.a);
        Object apply = this.b.apply(d);
        long l6 = apply.d();
        if (this.a >= l6) {
            long l7 = apply.c();
            if (this.a <= l7) {
                int i = 1;
            }
        }
        return z;
    }

    public D j(D d, x0 x0Var, boolean z) {
        if (x0Var == null) {
            throw new IllegalArgumentException("Missing weekday.");
        } else {
            long l3 = (d.c() + (long)x0Var.getValue(this.a)) - (long)g(d).getValue(this.a);
            Object apply = this.b.apply(d);
            long l6 = apply.d();
            if (this.a < l6) {
                throw new IllegalArgumentException("New day out of supported range.");
            } else {
                long l7 = apply.c();
                if (this.a <= l7) {
                    return (g)apply.a(l3);
                }
            }
        }
    }

    public p<?> b(D d) {
        return null;
    }

    public p<?> d(D d) {
        return null;
    }
}
