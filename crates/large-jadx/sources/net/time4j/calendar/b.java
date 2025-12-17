package net.time4j.calendar;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import net.time4j.calendar.t.d;
import net.time4j.calendar.t.e;
import net.time4j.calendar.t.f;
import net.time4j.engine.d;
import net.time4j.engine.e;
import net.time4j.engine.k;
import net.time4j.engine.m0;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.r;
import net.time4j.engine.w;
import net.time4j.engine.y;
import net.time4j.engine.z;
import net.time4j.f1.c;
import net.time4j.x0;
import net.time4j.z0;

/* loaded from: classes3.dex */
public class b {

    public static final p<Integer> a;

    static class a {
    }

    private static class b implements y<D, Integer> {

        private final net.time4j.calendar.b.d<?> a;
        private b(net.time4j.calendar.b.d<?> b$d) {
            super();
            this.a = d;
        }

        b(net.time4j.calendar.b.d b$d, net.time4j.calendar.b.a b$a2) {
            super(d);
        }

        private p<?> b(D d, boolean z2) {
            int i;
            long longValue;
            q obj7;
            int obj8;
            net.time4j.calendar.b.f fVar = b.f.H(d.getClass(), b.d.o(this.a));
            final z uTC = z.UTC;
            longValue = (Long)d.p(uTC).longValue();
            int i2 = d.e(b.d.r(this.a));
            if (z2) {
                if (Long.compare(obj7, longValue) < 0) {
                    return b.d.r(this.a);
                }
            } else {
                if (k(d) <= 1 && Long.compare(obj7, i) > 0) {
                    if (Long.compare(obj7, i) > 0) {
                        return b.d.r(this.a);
                    }
                }
            }
            return fVar;
        }

        private int f(D d) {
            return l(d, 1);
        }

        private int h(D d) {
            return l(d, -1);
        }

        private int k(D d) {
            return l(d, 0);
        }

        private int l(D d, int i2) {
            int intValue;
            int i;
            Object obj6;
            int obj7;
            int value = b.a(i4 += i9).getValue(b.d.o(this.a));
            i = value <= i6 - 8 ? value - 2 : value - 9;
            int i10 = 1;
            if (i2 != -1) {
                if (i2 != 0) {
                    if (i2 != i10) {
                    } else {
                        intValue = (Integer)d.r(b.d.r(this.a)).intValue();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected: ");
                    stringBuilder.append(i2);
                    obj6 = new AssertionError(stringBuilder.toString());
                    throw obj6;
                }
            } else {
                intValue = i10;
            }
            return obj6 += i10;
        }

        private D n(D d, int i2) {
            int i = k(d);
            if (i2 == i) {
                return d;
            }
            z uTC = z.UTC;
            return d.F(uTC, longValue += l);
        }

        public p<?> d(D d) {
            return b(d, true);
        }

        public p<?> e(D d) {
            return b(d, false);
        }

        public Integer g(D d) {
            return Integer.valueOf(f(d));
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
            return g((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return i((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return j((q)object);
        }

        public Integer i(D d) {
            return Integer.valueOf(h(d));
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return m((q)object, (Integer)object2);
        }

        public Integer j(D d) {
            return Integer.valueOf(k(d));
        }

        public boolean m(D d, Integer integer2) {
            int i;
            q obj3;
            if (integer2 == null) {
                return 0;
            }
            final int obj4 = integer2.intValue();
            if (obj4 >= h(d) && obj4 <= f(d)) {
                if (obj4 <= f(d)) {
                    i = 1;
                }
            }
            return i;
        }

        public D o(D d, Integer integer2, boolean z3) {
            boolean obj5;
            if (integer2 == null) {
            } else {
                if (!z3) {
                    if (!m(d, integer2)) {
                    } else {
                    }
                }
                return n(d, integer2.intValue());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid value: ");
            stringBuilder.append(integer2);
            stringBuilder.append(" (context=");
            stringBuilder.append(d);
            stringBuilder.append(")");
            obj5 = new IllegalArgumentException(stringBuilder.toString());
            throw obj5;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return o((q)object, (Integer)object2, z3);
        }
    }

    private static class c implements y<D, Integer> {

        private final net.time4j.calendar.b.d<?> a;
        private c(net.time4j.calendar.b.d<?> b$d) {
            super();
            this.a = d;
        }

        c(net.time4j.calendar.b.d b$d, net.time4j.calendar.b.a b$a2) {
            super(d);
        }

        private int b(D d) {
            int i;
            int i2;
            int i4;
            int i3;
            int obj6;
            int i5 = d.e(b.d.r(this.a));
            i2 = 0;
            i4 = g(d, i2);
            final int i10 = 1;
            if (i4 <= i5) {
                if (i11 += obj6 <= i5) {
                    return i10;
                }
                i8 /= 7;
            } else {
                i2 = -1;
                i7 /= 7;
            }
            return i += i10;
        }

        private p<?> d(Object object) {
            b.f fVar = new b.f((Class)object, b.d.o(this.a));
            return fVar;
        }

        private int g(D d, int i2) {
            int obj1;
            z0 obj2 = b.d.o(this.a);
            obj1 = m(d, i2).getValue(obj2);
            obj1 = obj1 <= obj2 - 8 ? obj1 - 2 : obj1 - 9;
            return obj1;
        }

        private int h(D d, int i2) {
            int i = d.e(b.d.r(this.a));
            if (i2 != -1 && i2 != 0) {
                if (i2 != 0) {
                    if (i2 != 1) {
                    } else {
                        z uTC2 = z.UTC;
                        return b.b(b.d.r(this.a), d.F(uTC2, i7 -= l3));
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected: ");
                    stringBuilder.append(i2);
                    AssertionError obj8 = new AssertionError(stringBuilder.toString());
                    throw obj8;
                }
                return b.b(b.d.r(this.a), d);
            }
            z uTC = z.UTC;
            return b.b(b.d.r(this.a), d.F(uTC, longValue -= l));
        }

        private int i(D d) {
            int i;
            int i5;
            int i3;
            int i2;
            int i4;
            int i6;
            q obj10;
            i = d.e(b.d.r(this.a));
            int i8 = 0;
            i3 = g(d, i8);
            final int i13 = 1;
            if (i3 <= i && i15 += i5 <= i) {
                i13 = 1;
                if (i15 += i5 <= i) {
                    z uTC = z.UTC;
                    i2 = i5 + obj10;
                    i3 = i;
                }
                return i16 /= 7;
            }
            int i7 = -1;
            return i11 /= 7;
        }

        private x0 m(D d, int i2) {
            int i = d.e(b.d.r(this.a));
            final int i5 = 1;
            if (i2 != -1 && i2 != 0) {
                if (i2 != 0) {
                    if (i2 != 1) {
                    } else {
                        return b.a(i7 -= obj7);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected: ");
                    stringBuilder.append(i2);
                    AssertionError obj7 = new AssertionError(stringBuilder.toString());
                    throw obj7;
                }
                z obj8 = z.UTC;
                return b.a(obj7 += i5);
            }
            obj8 = z.UTC;
            longValue2 -= l2;
            return b.a(i10 += i5);
        }

        private D o(D d, int i2) {
            final int i = b(d);
            if (i2 == i) {
                return d;
            }
            final z uTC = z.UTC;
            return d.F(uTC, longValue += l);
        }

        public p<?> e(D d) {
            return d(d.getClass());
        }

        public p<?> f(D d) {
            return d(d.getClass());
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return e((q)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return f((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return j((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return k((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return l((q)object);
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return n((q)object, (Integer)object2);
        }

        public Integer j(D d) {
            return Integer.valueOf(i(d));
        }

        public Integer k(D d) {
            return 1;
        }

        public Integer l(D d) {
            return Integer.valueOf(b(d));
        }

        public boolean n(D d, Integer integer2) {
            int i;
            q obj3;
            if (integer2 == null) {
                return 0;
            }
            final int obj4 = integer2.intValue();
            final int i2 = 1;
            if (obj4 >= i2 && obj4 <= i(d)) {
                if (obj4 <= i(d)) {
                    i = i2;
                }
            }
            return i;
        }

        public D p(D d, Integer integer2, boolean z3) {
            Integer obj4;
            int intValue = integer2.intValue();
            if (!z3) {
                if (!n(d, integer2)) {
                } else {
                }
                StringBuilder obj5 = new StringBuilder();
                obj5.append("Invalid value: ");
                obj5.append(intValue);
                obj5.append(" (context=");
                obj5.append(d);
                obj5.append(")");
                obj4 = new IllegalArgumentException(obj5.toString());
                throw obj4;
            }
            return o(d, intValue);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return p((q)object, (Integer)object2, z3);
        }
    }

    private static class e implements y<T, x0> {

        private final net.time4j.calendar.b.f<?> a;
        private e(net.time4j.calendar.b.f<?> b$f) {
            super();
            this.a = f;
        }

        e(net.time4j.calendar.b.f b$f, net.time4j.calendar.b.a b$a2) {
            super(f);
        }

        public p<?> b(T t) {
            return 0;
        }

        public p<?> d(T t) {
            return 0;
        }

        public x0 e(T t) {
            long l;
            String str;
            w wVar = w.y(t.getClass());
            if (t instanceof l) {
                l = wVar.k((l)l.class.cast(t).k()).c();
            } else {
                l = wVar.j().c();
            }
            long longValue = (Long)t.p(z.UTC).longValue();
            if (Long.compare(i2, l) > 0) {
                return b.a(l);
            }
            return this.a.E();
        }

        public x0 f(T t) {
            long l;
            String str;
            w wVar = w.y(t.getClass());
            if (t instanceof l) {
                l = wVar.k((l)l.class.cast(t).k()).d();
            } else {
                l = wVar.j().d();
            }
            long longValue = (Long)t.p(z.UTC).longValue();
            if (Long.compare(i2, l) < 0) {
                return b.a(l);
            }
            return this.a.F();
        }

        public x0 g(T t) {
            return b.a((Long)t.p(z.UTC).longValue());
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return b((q)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return d((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return g((q)object);
        }

        public boolean h(T t, x0 x02) {
            final int i = 0;
            if (x02 == null) {
                return i;
            }
            i(t, x02, i);
            return 1;
        }

        public T i(T t, x0 x02, boolean z3) {
            final z obj8 = z.UTC;
            long longValue = (Long)t.p(obj8).longValue();
            x0 x0Var = b.a(longValue);
            if (x02 == x0Var) {
                return t;
            }
            return t.F(obj8, i -= l);
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((q)object, (x0)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return i((q)object, (x0)object2, z3);
        }
    }

    static class g implements r {

        private final Class<? extends q> a;
        private final p<Integer> b;
        private final p<Integer> c;
        private final z0 d;
        g(Class<? extends q> class, p<Integer> p2, p<Integer> p3, z0 z04) {
            super();
            this.a = class;
            this.b = p2;
            this.c = p3;
            this.d = z04;
        }

        public boolean a(p<?> p) {
            return 0;
        }

        public q<?> b(q<?> q, Locale locale2, d d3) {
            return q;
        }

        public Set<p<?>> c(Locale locale, d d2) {
            z0 obj9;
            if (locale.getCountry().isEmpty()) {
                obj9 = this.d;
            } else {
                obj9 = z0.j(locale);
            }
            HashSet obj10 = new HashSet();
            obj10.add(b.f.H(this.a, obj9));
            final int i = 1;
            int i9 = 0;
            final z0 z0Var = obj9;
            obj10.add(b.d.u("WEEK_OF_MONTH", this.a, i, 5, 'W', z0Var, this.b, i9));
            obj10.add(b.d.u("WEEK_OF_YEAR", this.a, i, 52, 'w', z0Var, this.c, i9));
            int i8 = 0;
            int i10 = 1;
            obj10.add(b.d.u("BOUNDED_WEEK_OF_MONTH", this.a, i, 5, i8, z0Var, this.b, i10));
            obj10.add(b.d.u("BOUNDED_WEEK_OF_YEAR", this.a, i, 52, i8, z0Var, this.c, i10));
            return Collections.unmodifiableSet(obj10);
        }

        public boolean d(Class<?> class) {
            return this.a.equals(class);
        }
    }

    private static class d extends f<T> {

        private static final long serialVersionUID = -7471192143785466686L;
        private final boolean bounded;
        private final p<Integer> dayElement;
        private final z0 model;
        d(String string, Class<T> class2, int i3, int i4, char c5, z0 z06, p<Integer> p7, boolean z8) {
            super(string, class2, i3, i4, c5);
            Objects.requireNonNull(z06, "Missing week model.");
            this.model = z06;
            this.dayElement = p7;
            this.bounded = z8;
        }

        static z0 o(net.time4j.calendar.b.d b$d) {
            return d.model;
        }

        static p r(net.time4j.calendar.b.d b$d) {
            return d.dayElement;
        }

        static <T extends q<T>> net.time4j.calendar.b.d<T> u(String string, Class<T> class2, int i3, int i4, char c5, z0 z06, p<Integer> p7, boolean z8) {
            super(string, class2, i3, i4, c5, z06, p7, z8);
            return dVar2;
        }

        protected <D extends q<D>> y<D, Integer> d(w<D> w) {
            Object obj2;
            int i = 0;
            if (k().equals(w.l())) {
                if (this.bounded) {
                    obj2 = new b.b(this, i);
                } else {
                    obj2 = new b.c(this, i);
                }
                return obj2;
            }
            return i;
        }

        protected boolean e(e<?> e) {
            boolean bounded;
            int i;
            z0 model;
            e obj4;
            i = 0;
            obj4 = b.d.class.cast(e);
            if (super.e(e) && this.model.equals(obj4.model) && this.bounded == obj4.bounded) {
                obj4 = b.d.class.cast(e);
                if (this.model.equals(obj4.model)) {
                    if (this.bounded == obj4.bounded) {
                        i = 1;
                    }
                }
            }
            return i;
        }

        @Override // net.time4j.calendar.t.f
        public boolean isLenient() {
            return 1;
        }

        @Override // net.time4j.calendar.t.f
        protected Object readResolve() {
            return this;
        }
    }

    private static class f extends e<x0, T> {

        private static final long serialVersionUID = 5613494586572932860L;
        private final z0 model;
        f(Class<T> class, z0 z02) {
            super("LOCAL_DAY_OF_WEEK", class, x0.class, 101);
            this.model = z02;
        }

        static z0 D(net.time4j.calendar.b.f b$f) {
            return f.model;
        }

        static <T extends q<T>> net.time4j.calendar.b.f<T> H(Class<T> class, z0 z02) {
            b.f fVar = new b.f(class, z02);
            return fVar;
        }

        @Override // net.time4j.calendar.t.e
        public int A(Enum enum) {
            return G((x0)enum);
        }

        @Override // net.time4j.calendar.t.e
        public x0 E() {
            return this.model.f().roll(6);
        }

        @Override // net.time4j.calendar.t.e
        public x0 F() {
            return this.model.f();
        }

        @Override // net.time4j.calendar.t.e
        public int G(x0 x0) {
            return x0.getValue(this.model);
        }

        @Override // net.time4j.calendar.t.e
        public int b(o o, o o2) {
            int obj2;
            obj2 = (x0)o.p(this).getValue(this.model);
            int obj3 = (x0)o2.p(this).getValue(this.model);
            obj2 = obj2 < obj3 ? -1 : obj2 == obj3 ? 0 : 1;
            return obj2;
        }

        protected <D extends q<D>> y<D, x0> d(w<D> w) {
            int i = 0;
            if (k().equals(w.l())) {
                b.e obj2 = new b.e(this, i);
                return obj2;
            }
            return i;
        }

        protected boolean e(e<?> e) {
            if (super.e(e)) {
                return this.model.equals(obj2.model);
            }
            return 0;
        }

        @Override // net.time4j.calendar.t.e
        public Object getDefaultMaximum() {
            return E();
        }

        @Override // net.time4j.calendar.t.e
        public Object getDefaultMinimum() {
            return F();
        }

        @Override // net.time4j.calendar.t.e
        public Enum r() {
            return E();
        }

        @Override // net.time4j.calendar.t.e
        protected Object readResolve() {
            return this;
        }

        @Override // net.time4j.calendar.t.e
        public Enum u() {
            return F();
        }

        @Override // net.time4j.calendar.t.e
        protected boolean y() {
            return 1;
        }
    }
    static {
        b.a = l.a;
    }

    static x0 a(long l) {
        return b.c(l);
    }

    static int b(p p, q q2) {
        return b.d(p, q2);
    }

    private static x0 c(long l) {
        return x0.valueOf(obj2++);
    }

    private static <D extends q<D>> int d(p<?> p, D d2) {
        return (Integer)Integer.class.cast(d2.r(p)).intValue();
    }
}
