package net.time4j.calendar;

import java.util.Objects;
import net.time4j.calendar.t.f;
import net.time4j.engine.b0;
import net.time4j.engine.g;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.u;
import net.time4j.engine.y;
import net.time4j.engine.z;
import net.time4j.f1.c;
import net.time4j.x0;

/* loaded from: classes3.dex */
final class q<T extends q<T> & g>  extends f<T> implements net.time4j.calendar.p {

    private static final long serialVersionUID = 4275169663905222176L;
    private final transient p<Integer> y;
    private final transient p<x0> z;

    private static class b implements u<T> {

        private final net.time4j.calendar.q<T> a;
        private final long b;
        private final x0 c;
        b(net.time4j.calendar.q<T> q, int i2, x0 x03) {
            super();
            Objects.requireNonNull(x03, "Missing value.");
            this.a = q;
            this.b = (long)i2;
            this.c = x03;
        }

        public T a(T t) {
            int i;
            int i2;
            int i4;
            int i3;
            int i5;
            Object obj = t.p(q.o(this.a));
            int i9 = t.e(q.r(this.a));
            final int i13 = 7;
            int i15 = 7;
            if (Long.compare(l3, i14) == 0) {
                intValue -= i9;
                value2 += i11;
                if (i > i15) {
                    i += -7;
                }
                value3 -= i;
                if (i2 > 0) {
                    i3 -= i13;
                }
            } else {
                value4 -= value;
                i3 = i5 + i;
            }
            return t.F(z.UTC, l2 += i3);
        }

        @Override // net.time4j.engine.u
        public Object apply(Object object) {
            return a((q)object);
        }
    }

    private static class c implements u<T> {

        private final boolean a;
        c(boolean z) {
            super();
            this.a = z;
        }

        public T a(T t) {
            int i;
            final z uTC = z.UTC;
            long longValue = (Long)t.p(uTC).longValue();
            final int i2 = 7;
            i = this.a ? longValue - i2 : longValue + i2;
            return t.F(uTC, i);
        }

        @Override // net.time4j.engine.u
        public Object apply(Object object) {
            return a((q)object);
        }
    }

    private static class a implements b0<T> {

        private final net.time4j.calendar.q<T> a;
        a(net.time4j.calendar.q<T> q) {
            super();
            this.a = q;
        }

        private int f(T t) {
            int i;
            p pVar;
            i = t.e(q.r(this.a));
            pVar = i + 7;
            while (pVar <= (Integer)t.r(q.r(this.a)).intValue()) {
                i = pVar;
                pVar = i + 7;
            }
            return obj3++;
        }

        @Override // net.time4j.engine.b0
        public Object a(Object object, int i2, boolean z3) {
            return l((q)object, i2, z3);
        }

        public p<?> b(T t) {
            return 0;
        }

        @Override // net.time4j.engine.b0
        public int c(Object object) {
            return e((q)object);
        }

        public p<?> d(T t) {
            return 0;
        }

        public int e(T t) {
            return obj2++;
        }

        public Integer g(T t) {
            return Integer.valueOf(f(t));
        }

        @Override // net.time4j.engine.b0
        public p getChildAtCeiling(Object object) {
            return b((q)object);
        }

        @Override // net.time4j.engine.b0
        public p getChildAtFloor(Object object) {
            return d((q)object);
        }

        @Override // net.time4j.engine.b0
        public Object getMaximum(Object object) {
            return g((q)object);
        }

        @Override // net.time4j.engine.b0
        public Object getMinimum(Object object) {
            return h((q)object);
        }

        @Override // net.time4j.engine.b0
        public Object getValue(Object object) {
            return i((q)object);
        }

        public Integer h(T t) {
            return 1;
        }

        public Integer i(T t) {
            return Integer.valueOf(e(t));
        }

        @Override // net.time4j.engine.b0
        public boolean isValid(Object object, Object object2) {
            return k((q)object, (Integer)object2);
        }

        public boolean j(T t, int i2) {
            int i;
            q obj2;
            if (i2 >= 1 && i2 <= f(t)) {
                if (i2 <= f(t)) {
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public boolean k(T t, Integer integer2) {
            q obj1;
            int obj2;
            if (integer2 != 0 && j(t, integer2.intValue())) {
                obj1 = j(t, integer2.intValue()) ? 1 : 0;
            } else {
            }
            return obj1;
        }

        public T l(T t, int i2, boolean z3) {
            if (!j(t, i2)) {
            } else {
                return t.H(this.a.v(i2, (x0)t.p(q.o(this.a))));
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Invalid value: ");
            obj4.append(i2);
            IllegalArgumentException obj2 = new IllegalArgumentException(obj4.toString());
            throw obj2;
        }

        public T m(T t, Integer integer2, boolean z3) {
            if (integer2 == null) {
            } else {
                return l(t, integer2.intValue(), z3);
            }
            IllegalArgumentException obj1 = new IllegalArgumentException("Missing value.");
            throw obj1;
        }

        @Override // net.time4j.engine.b0
        public Object withValue(Object object, Object object2, boolean z3) {
            return m((q)object, (Integer)object2, z3);
        }
    }
    q(Class<T> class, p<Integer> p2, p<x0> p3) {
        q.c cVar = new q.c(1);
        q.c cVar2 = new q.c(0);
        super("WEEKDAY_IN_MONTH", class, 1, intValue / 7, 70, cVar, cVar2);
        this.y = p2;
        this.z = p3;
    }

    static p o(net.time4j.calendar.q q) {
        return q.z;
    }

    static p r(net.time4j.calendar.q q) {
        return q.y;
    }

    static <T extends q<T> & g> y<T, Integer> u(net.time4j.calendar.q<T> q) {
        q.a aVar = new q.a(q);
        return aVar;
    }

    public u<T> v(int i, x0 x02) {
        q.b bVar = new q.b(this, i, x02);
        return bVar;
    }
}
