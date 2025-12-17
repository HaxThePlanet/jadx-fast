package net.time4j.calendar;

import net.time4j.engine.g;
import net.time4j.engine.k;
import net.time4j.engine.p;
import net.time4j.engine.s;
import net.time4j.engine.y;
import net.time4j.f1.c;
import net.time4j.x0;
import net.time4j.z0;

/* loaded from: classes3.dex */
class r<D extends g>  implements y<D, x0> {

    private final z0 a;
    private final s<D, k<D>> b;
    r(z0 z0, s<D, k<D>> s2) {
        super();
        this.a = z0;
        this.b = s2;
    }

    private static x0 h(long l) {
        return x0.valueOf(obj2++);
    }

    public p<?> b(D d) {
        return 0;
    }

    public p<?> d(D d) {
        return 0;
    }

    public x0 e(D d) {
        Object apply = this.b.apply(d);
        int value = g(d).getValue(this.a);
        if (Long.compare(i3, l4) > 0) {
            return r.h(apply.c());
        }
        return this.a.f().roll(6);
    }

    public x0 f(D d) {
        Object apply = this.b.apply(d);
        int value = g(d).getValue(this.a);
        if (Long.compare(i2, l4) < 0) {
            return r.h(apply.d());
        }
        return this.a.f();
    }

    public x0 g(D d) {
        return r.h(d.c());
    }

    @Override // net.time4j.engine.y
    public p getChildAtCeiling(Object object) {
        return b((g)object);
    }

    @Override // net.time4j.engine.y
    public p getChildAtFloor(Object object) {
        return d((g)object);
    }

    @Override // net.time4j.engine.y
    public Object getMaximum(Object object) {
        return e((g)object);
    }

    @Override // net.time4j.engine.y
    public Object getMinimum(Object object) {
        return f((g)object);
    }

    @Override // net.time4j.engine.y
    public Object getValue(Object object) {
        return g((g)object);
    }

    public boolean i(D d, x0 x02) {
        int i;
        Object obj7;
        if (x02 == null) {
            return 0;
        }
        i2 -= l3;
        obj7 = this.b.apply(d);
        if (Long.compare(i3, l4) >= 0 && Long.compare(i3, obj7) <= 0) {
            if (Long.compare(i3, obj7) <= 0) {
                i = 1;
            }
        }
        return i;
    }

    @Override // net.time4j.engine.y
    public boolean isValid(Object object, Object object2) {
        return i((g)object, (x0)object2);
    }

    public D j(D d, x0 x02, boolean z3) {
        int obj6;
        if (x02 == null) {
        } else {
            i -= obj6;
            Object obj5 = this.b.apply(d);
            if (Long.compare(i2, obj6) < 0) {
            } else {
                if (Long.compare(i2, obj6) > 0) {
                } else {
                    return (g)obj5.a(i2);
                }
            }
            obj5 = new IllegalArgumentException("New day out of supported range.");
            throw obj5;
        }
        obj5 = new IllegalArgumentException("Missing weekday.");
        throw obj5;
    }

    @Override // net.time4j.engine.y
    public Object withValue(Object object, Object object2, boolean z3) {
        return j((g)object, (x0)object2, z3);
    }
}
