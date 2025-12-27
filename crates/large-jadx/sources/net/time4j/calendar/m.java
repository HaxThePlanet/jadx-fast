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

/* compiled from: RelatedGregorianYearRule.java */
/* loaded from: classes3.dex */
final class m<T extends q<T>> implements y<T, Integer> {

    private final Map<String, ? extends k<T>> a;
    private final p<Integer> b;
    m(k<T> kVar, p<Integer> pVar) {
        super();
        this.a = Collections.singletonMap("calendrical", kVar);
        this.b = pVar;
    }

    private k<T> b(T t) {
        if (t instanceof l) {
            return (k)this.a.get((l)l.class.cast(t).k());
        }
        return (k)this.a.get("calendrical");
    }

    private static Integer j(long j) {
        long l;
        z uTC2 = z.UTC;
        long l14 = c.f(z.MODIFIED_JULIAN_DATE.transform(j, uTC2), 678881L);
        int i = 146097;
        long l4 = c.b(l14, i);
        int i3 = c.d(l14, i);
        long l2 = 1L;
        long l3 = 400L;
        int i4 = 146096;
        if (i3 == 146096) {
            l = (l4 + 1L) * 400L;
        } else {
            int i14 = 36524;
            int i6 = i3 / i14;
            i3 %= i14;
            int i15 = i8 / 1461;
            int i9 = i8 % 1461;
            int i2 = 1460;
            if (i9 == 1460) {
                i = i6 * 100;
                l2 = (long)i;
                i4 = (i15 + 1) * 4;
                l = (l4 * 400L) + l2 + (long)i4;
            } else {
                i2 = i9 / 365;
                i = i6 * 100;
                l3 = (long)i2;
                l = (l4 * 400L) + (long)i + (long)(i15 * 4) + l3;
                i3 = (i9 % 365) + 31 * 5 / 153 + 2;
                i4 = 12;
                if (i9 % 365 + 31 * 5 / 153 + 2 > 12) {
                    l = (l4 * l3 + (long)i6 * 100 + (long)i15 * 4 + (long)i9 / 365) + 1L;
                }
            }
        }
        return Integer.valueOf(c.g(l));
    }

    public Integer f(T t) {
        k kVar = b(t);
        return m.j(kVar.b((q)kVar.a(kVar.c()).E(this.b, 1)));
    }

    public Integer g(T t) {
        k kVar = b(t);
        return m.j(kVar.b((q)kVar.a(kVar.d()).E(this.b, 1)));
    }

    public Integer h(T t) {
        return m.j(b(t).b(t.E(this.b, 1)));
    }

    public boolean i(T t, Integer integer) {
        return h(t).equals(integer);
    }

    public T k(T t, Integer integer, boolean z) {
        if (!i(t, integer)) {
            throw new IllegalArgumentException("The related gregorian year is read-only.");
        } else {
            return t;
        }
    }

    public p<?> d(T t) {
        return null;
    }

    public p<?> e(T t) {
        return null;
    }
}
