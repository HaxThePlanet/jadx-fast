package net.time4j.calendar;

import java.util.Collections;
import java.util.Map;
import net.time4j.engine.k;
import net.time4j.engine.m0;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.y;
import net.time4j.engine.z;
import net.time4j.f1.c;

/* loaded from: classes3.dex */
final class m<T extends q<T>>  implements y<T, Integer> {

    private final Map<String, ? extends k<T>> a;
    private final p<Integer> b;
    m(k<T> k, p<Integer> p2) {
        super();
        this.a = Collections.singletonMap("calendrical", k);
        this.b = p2;
    }

    private k<T> b(T t) {
        if (t instanceof l) {
            return (k)this.a.get((l)l.class.cast(t).k());
        }
        return (k)this.a.get("calendrical");
    }

    private static Integer j(long l) {
        int i3;
        int i4;
        int i5;
        int i2;
        int i;
        int obj8;
        int obj9;
        z uTC = z.UTC;
        obj8 = c.f(z.MODIFIED_JULIAN_DATE.transform(l, obj9), obj9);
        i3 = 146097;
        long l2 = c.b(obj8, obj9);
        obj8 = c.d(obj8, obj9);
        i5 = 1;
        i2 = 400;
        if (obj8 == 146096) {
            i8 *= i2;
        } else {
            obj9 = 36524;
            int i7 = obj8 / obj9;
            obj8 %= obj9;
            obj9 = obj8 / 1461;
            obj8 %= 1461;
            if (obj8 == 1460) {
                i10 += obj8;
            } else {
                if (obj8 += 2 > 12) {
                    i4 += i5;
                }
            }
        }
        return Integer.valueOf(c.g(i4));
    }

    public p<?> d(T t) {
        return 0;
    }

    public p<?> e(T t) {
        return 0;
    }

    public Integer f(T t) {
        k obj4 = b(t);
        final p pVar = this.b;
        return m.j(obj4.b((q)obj4.a(obj4.c()).E(pVar, 1)));
    }

    public Integer g(T t) {
        k obj4 = b(t);
        final p pVar = this.b;
        return m.j(obj4.b((q)obj4.a(obj4.d()).E(pVar, 1)));
    }

    @Override // net.time4j.engine.y
    public p getChildAtCeiling(Object object) {
        return d((q)object);
    }

    @Override // net.time4j.engine.y
    public p getChildAtFloor(Object object) {
        return e((q)object);
    }

    @Override // net.time4j.engine.y
    public Object getMaximum(Object object) {
        return f((q)object);
    }

    @Override // net.time4j.engine.y
    public Object getMinimum(Object object) {
        return g((q)object);
    }

    @Override // net.time4j.engine.y
    public Object getValue(Object object) {
        return h((q)object);
    }

    public Integer h(T t) {
        final p pVar = this.b;
        return m.j(b(t).b(t.E(pVar, 1)));
    }

    public boolean i(T t, Integer integer2) {
        return h(t).equals(integer2);
    }

    @Override // net.time4j.engine.y
    public boolean isValid(Object object, Object object2) {
        return i((q)object, (Integer)object2);
    }

    public T k(T t, Integer integer2, boolean z3) {
        if (!i(t, integer2)) {
        } else {
            return t;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("The related gregorian year is read-only.");
        throw obj1;
    }

    @Override // net.time4j.engine.y
    public Object withValue(Object object, Object object2, boolean z3) {
        k((q)object, (Integer)object2, z3);
        return object;
    }
}
