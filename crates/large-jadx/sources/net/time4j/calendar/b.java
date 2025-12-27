package net.time4j.calendar;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import net.time4j.calendar.t.f;
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

/* compiled from: CommonElements.java */
/* loaded from: classes3.dex */
public class b {

    public static final p<Integer> a;

    static class a {
    }

    private static class b<D extends q<D>> implements y<D, Integer> {

        private final b.d<?> a;
        /* synthetic */ b(b.d dVar, b.a aVar) {
            this(dVar);
        }

        private p<?> b(D d, boolean z) {
            net.time4j.calendar.b.f fVar = b.f.H(d.getClass(), this.a.model);
            final z uTC2 = z.UTC;
            long value = (Long)d.p(uTC2).longValue();
            int i3 = d.e(this.a.dayElement);
            if (z) {
                long l6 = (long)(Integer)d.r(this.a.dayElement).intValue();
                value = (long)i3 + (Long)d.G(fVar, d.r(fVar)).p(z.UTC).longValue() - value;
                if (l6 < value) {
                    return this.a.dayElement;
                }
            } else {
                int i2 = 1;
                if (k(d) <= 1) {
                    value = value - (Long)d.G(fVar, d.w(fVar)).p(z.UTC).longValue();
                    long l5 = (long)(Integer)d.w(this.a.dayElement).intValue();
                    long l2 = (long)i3 - value;
                    if (this.a > this.a.model) {
                        return this.a.dayElement;
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

        private int l(D d, int i) {
            int value;
            int value3 = (Long)d.p(z.UTC).longValue() - (long)d.e(this.a.dayElement) + 1L.c(l3).getValue(this.a.model);
            int r1 = value3 <= this.a.model.g() - 8 ? value3 - 2 : value3 - 9;
            value = 1;
            if (i == -1) {
            } else {
                if (i != 0 && i == value) {
                    value = (Integer)d.r(this.a.dayElement).intValue();
                }
            }
            return (c.a(value - i, 7)) + value;
        }

        private D n(D d, int i) {
            i = k(d);
            if (i == i) {
                return d;
            }
            z uTC2 = z.UTC;
            return d.F(uTC2, (Long)d.p(uTC2).longValue() + (long)(i - i) * 7);
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

        public Integer i(D d) {
            return Integer.valueOf(h(d));
        }

        public Integer j(D d) {
            return Integer.valueOf(k(d));
        }

        public boolean m(D d, Integer integer) {
            boolean z = false;
            z = false;
            if (integer == null) {
                return false;
            }
            final int value = integer.intValue();
            if (value >= h(d) && value <= this.f(d)) {
                int i2 = 1;
            }
            return z;
        }

        public D o(D d, Integer integer, boolean z) {
            if (integer == null) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "Invalid value: ";
                String str3 = " (context=";
                String str2 = ")";
                d = str + integer + str3 + d + str2;
                throw new IllegalArgumentException(d);
            } else {
                return n(d, integer.intValue());
            }
        }

        private b(b.d<?> dVar) {
            super();
            this.a = dVar;
        }
    }

    private static class c<D extends q<D>> implements y<D, Integer> {

        private final b.d<?> a;
        /* synthetic */ c(b.d dVar, b.a aVar) {
            this(dVar);
        }

        private int b(D d) {
            int i;
            int i6 = d.e(this.a.dayElement);
            int i2 = 0;
            int i3 = g(d, i2);
            final int i11 = 1;
            if (i3 <= i6) {
                i4 = (g(d, i11)) + (h(d, i2));
                if (this.g(d, i11) + this.h(d, i2) <= i6) {
                    return i11;
                }
                i = (i6 - i3) / 7;
            } else {
                i2 = -1;
                i = (i6 + (h(d, i2))) - (g(d, i2)) / 7;
            }
            return i + i11;
        }

        private p<?> d(Object object) {
            return new b.f(object, this.a.model);
        }

        private int g(D d, int i) {
            z0 z0Var = this.a.model;
            int value = m(d, i).getValue(z0Var);
            d = value <= z0Var.g() - 8 ? value - 2 : value - 9;
            return (value <= z0Var.g() - 8 ? value - 2 : value - 9);
        }

        private int h(D d, int i) {
            i = d.e(this.a.dayElement);
            if (i != -1 && i != 0) {
                if (i != 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Unexpected: ";
                    i = str + i;
                    throw new AssertionError(i);
                } else {
                    z uTC22 = z.UTC;
                    return b.d(this.a.dayElement, d.F(uTC22, (Long)d.p(uTC22).longValue() + (long)(b.d(this.a.dayElement, d)) + 1L - (long)i));
                }
            }
            z uTC2 = z.UTC;
            return b.d(this.a.dayElement, d.F(uTC2, (Long)d.p(uTC2).longValue() - (long)i));
        }

        private int i(D d) {
            int i;
            int i3;
            i = d.e(this.a.dayElement);
            int i6 = 0;
            i = g(d, i6);
            if (i <= i) {
                final int i11 = 1;
                i3 = (g(d, i11)) + (h(d, i6));
                if (this.g(d, i11) + this.h(d, i6) <= i) {
                    try {
                        z uTC2 = z.UTC;
                        long l2 = 7L;
                        l = (Long)d.p(uTC2).longValue() + l2;
                    } catch (RuntimeException unused) {
                    }
                    i3 = (g(d.F(uTC2, l), i11)) + (h(d, i11));
                }
                return (i3 - i) / 7;
            }
            int i5 = -1;
            return (i + (h(d, i5))) - (g(d, i5)) / 7;
        }

        private x0 m(D d, int i) {
            i = d.e(this.a.dayElement);
            final long l3 = 1L;
            if (i != -1 && i != 0) {
                if (i != 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Unexpected: ";
                    i = str + i;
                    throw new AssertionError(i);
                } else {
                    return (Long)d.p(z.UTC).longValue() + (long)(b.d(this.a.dayElement, d)) + 1L - (long)i.c(l10);
                }
            }
            z uTC23 = z.UTC;
            long l7 = (Long)d.p(uTC23).longValue() - (long)i;
            return (l7 - (long)(d.F(uTC23, l7).e(this.a.dayElement))) + 1L.c(l10);
        }

        private D o(D d, int i) {
            i = b(d);
            if (i == i) {
                return d;
            }
            final z uTC2 = z.UTC;
            return d.F(uTC2, (Long)d.p(uTC2).longValue() + (long)(i - i) * 7);
        }

        public p<?> e(D d) {
            return d(d.getClass());
        }

        public p<?> f(D d) {
            return d(d.getClass());
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

        public boolean n(D d, Integer integer) {
            boolean z = false;
            z = false;
            if (integer == null) {
                return false;
            }
            final int value = integer.intValue();
            final int i = 1;
            if (value >= i && value <= this.i(d)) {
            }
            return z;
        }

        public D p(D d, Integer integer, boolean z) {
            int value = integer.intValue();
            return o(d, value);
        }

        private c(b.d<?> dVar) {
            super();
            this.a = dVar;
        }
    }

    private static class e<T extends q<T>> implements y<T, x0> {

        private final b.f<?> a;
        /* synthetic */ e(b.f fVar, b.a aVar) {
            this(fVar);
        }

        public x0 e(T t) {
            long l;
            long l2;
            w wVar = w.y(t.getClass());
            if (t instanceof l) {
                l = wVar.k((l)l.class.cast(t).k()).c();
            } else {
                l = wVar.j().c();
            }
            long value = (Long)t.p(z.UTC).longValue();
            long l4 = (value + 7L) - (long)value.c(l5).getValue(this.a.model);
            if (z.UTC > l) {
                return l.c(l2);
            }
            return this.a.E();
        }

        public x0 f(T t) {
            long l;
            long l2;
            w wVar = w.y(t.getClass());
            if (t instanceof l) {
                l = wVar.k((l)l.class.cast(t).k()).d();
            } else {
                l = wVar.j().d();
            }
            long value = (Long)t.p(z.UTC).longValue();
            long l4 = (value + 1L) - (long)value.c(l5).getValue(this.a.model);
            if (z.UTC < l) {
                return l.c(l2);
            }
            return this.a.F();
        }

        public x0 g(T t) {
            return (Long)t.p(z.UTC).longValue().c(l);
        }

        public boolean h(T t, x0 x0Var) {
            final boolean z2 = false;
            if (x0Var == null) {
                return false;
            }
            try {
                i(t, x0Var, z2);
            } catch (java.lang.ArithmeticException | java.lang.IllegalArgumentException unused) {
                return z;
            }
            return true;
        }

        public T i(T t, x0 x0Var, boolean z) {
            final z uTC2 = z.UTC;
            long value = (Long)t.p(uTC2).longValue();
            x0Var = value.c(l3);
            if (x0Var == x0Var) {
                return t;
            }
            return t.F(z.UTC, (value + (long)x0Var.getValue(this.a.model)) - (long)x0Var.getValue(this.a.model));
        }

        private e(b.f<?> fVar) {
            super();
            this.a = fVar;
        }

        public p<?> b(T t) {
            return null;
        }

        public p<?> d(T t) {
            return null;
        }
    }

    static class g implements r {

        private final Class<? extends q> a;
        private final p<Integer> b;
        private final p<Integer> c;
        private final z0 d;
        g(Class<? extends q> cls, p<Integer> pVar, p<Integer> pVar2, z0 z0Var) {
            super();
            this.a = cls;
            this.b = pVar;
            this.c = pVar2;
            this.d = z0Var;
        }

        public Set<p<?>> c(Locale locale, net.time4j.engine.d dVar) {
            z0 locale2;
            if (locale.getCountry().isEmpty()) {
            } else {
                locale2 = z0.j(locale);
            }
            HashSet hashSet = new HashSet();
            hashSet.add(b.f.H(this.a, locale2));
            final int i = 1;
            boolean z = false;
            hashSet.add(b.d.u("WEEK_OF_MONTH", this.a, i, 5, 'W', locale2, this.b, z));
            hashSet.add(b.d.u("WEEK_OF_YEAR", this.a, i, 52, 'w', locale2, this.c, z));
            char c = '\0';
            boolean z2 = true;
            hashSet.add(b.d.u("BOUNDED_WEEK_OF_MONTH", this.a, i, 5, c, locale2, this.b, z2));
            hashSet.add(b.d.u("BOUNDED_WEEK_OF_YEAR", this.a, i, 52, c, locale2, this.c, z2));
            return Collections.unmodifiableSet(hashSet);
        }

        public boolean d(Class<?> cls) {
            return this.a.equals(cls);
        }

        public boolean a(p<?> pVar) {
            return false;
        }

        public q<?> b(q<?> qVar, Locale locale, net.time4j.engine.d dVar) {
            return qVar;
        }
    }

    private static class d<T extends q<T>> extends f<T> {

        private static final long serialVersionUID = -7471192143785466686L;
        private final boolean bounded;
        private final p<Integer> dayElement;
        private final z0 model;
        d(String str, Class<T> cls, int i, int i2, char c, z0 z0Var, p<Integer> pVar, boolean z) {
            super(str, cls, i, i2, c);
            Objects.requireNonNull(z0Var, "Missing week model.");
            this.model = z0Var;
            this.dayElement = pVar;
            this.bounded = z;
        }

        static /* synthetic */ z0 o(b.d dVar) {
            return dVar.model;
        }

        static /* synthetic */ p r(b.d dVar) {
            return dVar.dayElement;
        }

        static <T extends q<T>> b.d<T> u(String str, Class<T> cls, int i, int i2, char c, z0 z0Var, p<Integer> pVar, boolean z) {
            b.d dVar = new b.d(str, cls, i, i2, c, z0Var, pVar, z);
            return dVar;
        }

        @Override // net.time4j.calendar.t.f
        protected <D extends q<D>> y<D, Integer> d(w<D> wVar) {
            net.time4j.calendar.b.c cVar;
            net.time4j.calendar.b.a aVar = null;
            if (k().equals(wVar.l()) && this.bounded) {
                net.time4j.calendar.b.b bVar = new b.b(this, aVar);
                return cVar;
            }
            return aVar;
        }

        @Override // net.time4j.calendar.t.f
        protected boolean e(net.time4j.engine.e<?> eVar) {
            boolean z = false;
            int i = 0;
            if (super.e(eVar)) {
                Object cast = b.d.class.cast(eVar);
                if (this.model.equals(cast.model)) {
                    if (this.bounded == cast.bounded) {
                        int i2 = 1;
                    }
                }
            }
            return z;
        }

        @Override // net.time4j.calendar.t.f
        public boolean isLenient() {
            return true;
        }

        @Override // net.time4j.calendar.t.f
        protected Object readResolve() {
            return this;
        }
    }

    private static class f<T extends q<T>> extends net.time4j.calendar.t.e<x0, T> {

        private static final long serialVersionUID = 5613494586572932860L;
        private final z0 model;
        f(Class<T> cls, z0 z0Var) {
            super("LOCAL_DAY_OF_WEEK", cls, x0.class, 'e');
            this.model = z0Var;
        }

        static /* synthetic */ z0 D(b.f fVar) {
            return fVar.model;
        }

        static <T extends q<T>> b.f<T> H(Class<T> cls, z0 z0Var) {
            return new b.f(cls, z0Var);
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
        public int G(x0 x0Var) {
            return x0Var.getValue(this.model);
        }

        @Override // net.time4j.calendar.t.e
        public int b(o oVar, o oVar2) {
            int i = -1;
            int value = (x0)oVar.p(this).getValue(this.model);
            int value2 = (x0)oVar2.p(this).getValue(this.model);
            if (value < value2) {
                i = -1;
            } else {
                oVar = value == value2 ? 0 : 1;
            }
            return (value == value2 ? 0 : 1);
        }

        @Override // net.time4j.calendar.t.e
        protected <D extends q<D>> y<D, x0> d(w<D> wVar) {
            net.time4j.calendar.b.a aVar = null;
            if (k().equals(wVar.l())) {
                return new b.e(this, aVar);
            }
            return aVar;
        }

        @Override // net.time4j.calendar.t.e
        protected boolean e(net.time4j.engine.e<?> eVar) {
            if (super.e(eVar)) {
                return this.model.equals((b.f)b.f.class.cast(eVar).model);
            }
            return false;
        }

        @Override // net.time4j.calendar.t.e
        protected Object readResolve() {
            return this;
        }

        @Override // net.time4j.calendar.t.e
        protected boolean y() {
            return true;
        }
    }
    static {
        b.a = l.a;
    }

    static /* synthetic */ x0 a(long j) {
        return b.c(j);
    }

    static /* synthetic */ int b(p pVar, q qVar) {
        return b.d(pVar, qVar);
    }

    private static x0 c(long j) {
        return x0.valueOf((c.d(j + 5L, 7)) + 1);
    }

    private static <D extends q<D>> int d(p<?> pVar, D d) {
        return (Integer)Integer.class.cast(d.r(pVar)).intValue();
    }
}
