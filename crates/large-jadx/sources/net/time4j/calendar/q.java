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

/* compiled from: WeekdayInMonthElement.java */
/* loaded from: classes3.dex */
final class q<T extends q<T> & g> extends f<T> implements p {

    private static final long serialVersionUID = 4275169663905222176L;
    private final transient p<Integer> y;
    private final transient p<x0> z;

    private static class b<T extends q<T> & g> implements u<T> {

        private final q<T> a;
        private final long b;
        private final x0 c;
        b(q<T> qVar, int i, x0 x0Var) {
            super();
            Objects.requireNonNull(x0Var, "Missing value.");
            this.a = qVar;
            this.b = (long)i;
            this.c = x0Var;
        }

        public T a(T t) {
            int i;
            int i2;
            long l2;
            Object obj = t.p(this.a.z);
            int i6 = t.e(this.a.y);
            final long l8 = 7L;
            int i11 = 7;
            if (this.b == 0x7fffffff /* Unknown resource */) {
                int i9 = (Integer)t.r(this.a.y).intValue() - i6;
                i = obj.getValue() + (i9 % 7);
                if (this.a > i11) {
                    i = i - 7;
                }
                i2 = this.c.getValue() - i;
                i3 = i9 + i2;
                l2 = (long)i3;
                if (this.a > 0) {
                    l2 = (long)i9 + i2 - 7L;
                }
            } else {
                i3 = this.c.getValue() - obj.getValue();
                i2 = (i6 + i3) - 1;
                l3 = (this.b - (long)(c.a(i2, i11)) + 1) * 7L;
                l = (long)i3;
                l2 = l3 + l;
            }
            return t.F(z.UTC, (g)t.c() + l2);
        }
    }

    private static class c<T extends q<T>> implements u<T> {

        private final boolean a;
        c(boolean z) {
            super();
            this.a = z;
        }

        public T a(T t) {
            long l;
            final z uTC2 = z.UTC;
            long value = (Long)t.p(uTC2).longValue();
            final long l2 = 7L;
            long r1 = this.a ? value - l2 : value + l2;
            return t.F(z.UTC, (this.a ? value - l2 : value + l2), obj2);
        }
    }

    private static class a<T extends q<T> & g> implements b0<T> {

        private final q<T> a;
        a(q<T> qVar) {
            super();
            this.a = qVar;
        }

        private int f(T t) {
            int i;
            i = t.e(this.a.y);
            pVar = i + 7;
            while (this.a.y <= (Integer)t.r(this.a.y).intValue()) {
                i = pVar;
                pVar = i + 7;
            }
            return (c.a(i - 1, 7)) + 1;
        }

        public int e(T t) {
            return (c.a(t.e(this.a.y) - 1, 7)) + 1;
        }

        public Integer g(T t) {
            return Integer.valueOf(f(t));
        }

        public Integer h(T t) {
            return 1;
        }

        public Integer i(T t) {
            return Integer.valueOf(e(t));
        }

        public boolean j(T t, int i) {
            boolean z = false;
            if (i < 1 || i > this.f(t)) {
                int i4 = 0;
            }
            return z;
        }

        public boolean k(T t, Integer integer) {
            boolean z2 = false;
            int value;
            if (integer != null) {
                t = j(t, integer.intValue()) ? 1 : 0;
            }
            return (j(t, integer.intValue()) ? 1 : 0);
        }

        public T l(T t, int i, boolean z) {
            if (!j(t, i)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Invalid value: ";
                i = str + i;
                throw new IllegalArgumentException(i);
            } else {
                return t.H(this.a.v(i, (x0)t.p(this.a.z)));
            }
        }

        public T m(T t, Integer integer, boolean z) {
            if (integer == null) {
                throw new IllegalArgumentException("Missing value.");
            } else {
                return l(t, integer.intValue(), z);
            }
        }

        public p<?> b(T t) {
            return null;
        }

        public p<?> d(T t) {
            return null;
        }
    }
    q(Class<T> cls, p<Integer> pVar, p<x0> pVar2) {
        super("WEEKDAY_IN_MONTH", cls, 1, (Integer)pVar.getDefaultMaximum().intValue() / 7, 'F', new q.c(true), new q.c(false));
        this.y = pVar;
        this.z = pVar2;
    }

    static /* synthetic */ p o(q qVar) {
        return qVar.z;
    }

    static /* synthetic */ p r(q qVar) {
        return qVar.y;
    }

    static <T extends q<T> & g> y<T, Integer> u(q<T> qVar) {
        return new q.a(qVar);
    }

    @Override // net.time4j.calendar.t.f
    public u<T> v(int i, x0 x0Var) {
        return new q.b(this, i, x0Var);
    }
}
