package net.time4j.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public final class f0<U, T extends net.time4j.engine.i0<U, T>>  extends net.time4j.engine.w<T> implements net.time4j.engine.g0<T> {

    private final Map<U, Double> A;
    private final Map<U, Set<U>> B;
    private final Map<net.time4j.engine.p<?>, U> C;
    private final T D;
    private final T E;
    private final net.time4j.engine.k<T> F;
    private final net.time4j.engine.p<T> G;
    private final Map<U, net.time4j.engine.k0<T>> z;

    class a implements Comparator<U> {

        final Map a;
        a(net.time4j.engine.f0 f0, Map map2) {
            this.a = map2;
            super();
        }

        public int compare(U u, U u2) {
            return Double.compare(f0.B(this.a, u), obj1);
        }
    }

    public static final class b extends net.time4j.engine.w.a<T> {

        private final Class<U> f;
        private final Map<U, net.time4j.engine.k0<T>> g;
        private final Map<U, Double> h;
        private final Map<U, Set<U>> i;
        private final Map<net.time4j.engine.p<?>, U> j;
        private final T k;
        private final T l;
        private final net.time4j.engine.k<T> m;
        private net.time4j.engine.g0<T> n = null;
        private b(Class<U> class, Class<T> class2, net.time4j.engine.t<T> t3, T t4, T t5, net.time4j.engine.k<T> k6, net.time4j.engine.g0<T> g07) {
            boolean obj2;
            super(class2, t3);
            int obj3 = 0;
            Objects.requireNonNull(class, "Missing unit type.");
            Objects.requireNonNull(t4, "Missing minimum of range.");
            Objects.requireNonNull(t5, "Missing maximum of range.");
            if (m.class.isAssignableFrom(class2)) {
                Objects.requireNonNull(k6, "Missing calendar system.");
            }
            this.f = class;
            HashMap obj1 = new HashMap();
            this.g = obj1;
            obj1 = new HashMap();
            this.h = obj1;
            obj1 = new HashMap();
            this.i = obj1;
            obj1 = new HashMap();
            this.j = obj1;
            this.k = t4;
            this.l = t5;
            this.m = k6;
            this.n = g07;
        }

        private void i(U u) {
            boolean iterator;
            boolean equals2;
            boolean equals;
            String str;
            boolean z;
            Object obj6;
            Class<Enum> obj = Enum.class;
            if (this.b) {
            }
            Iterator iterator2 = this.g.keySet().iterator();
            str = "Unit duplicate found: ";
            for (Object next : iterator2) {
                str = "Unit duplicate found: ";
            }
            if (u instanceof Enum) {
                obj6 = (Enum)obj.cast(u).name();
                iterator = this.g.keySet().iterator();
                for (Object equals : iterator) {
                }
            }
        }

        public static <U, D extends net.time4j.engine.m<U, D>> net.time4j.engine.f0.b<U, D> j(Class<U> class, Class<D> class2, net.time4j.engine.t<D> t3, net.time4j.engine.k<D> k4) {
            net.time4j.engine.f0.b bVar;
            Class derive;
            int obj11;
            super(class, class2, t3, (i0)k4.a(k4.d()), (i0)k4.a(k4.c()), k4, 0);
            final net.time4j.engine.z[] obj9 = z.values();
            obj11 = 0;
            while (obj11 < obj9.length) {
                bVar = obj9[obj11];
                bVar2.d(bVar, bVar.derive(k4));
                obj11++;
            }
            return bVar2;
        }

        public static <U, T extends net.time4j.engine.i0<U, T>> net.time4j.engine.f0.b<U, T> k(Class<U> class, Class<T> class2, net.time4j.engine.t<T> t3, T t4, T t5) {
            super(class, class2, t3, t4, t5, 0, 0);
            return bVar2;
        }

        public <V> net.time4j.engine.f0.b<U, T> d(net.time4j.engine.p<V> p, net.time4j.engine.y<T, V> y2) {
            super.a(p, y2);
            return this;
        }

        public <V> net.time4j.engine.f0.b<U, T> e(net.time4j.engine.p<V> p, net.time4j.engine.y<T, V> y2, U u3) {
            Objects.requireNonNull(u3, "Missing base unit.");
            super.a(p, y2);
            this.j.put(p, u3);
            return this;
        }

        public net.time4j.engine.f0.b<U, T> f(net.time4j.engine.r r) {
            super.b(r);
            return this;
        }

        public net.time4j.engine.f0.b<U, T> g(U u, net.time4j.engine.k0<T> k02, double d3, Set<? extends U> set4) {
            Object next;
            String str;
            Objects.requireNonNull(u, "Missing time unit.");
            Objects.requireNonNull(k02, "Missing unit rule.");
            i(u);
            Iterator iterator = obj8.iterator();
            for (Object next : iterator) {
                Objects.requireNonNull(next, "Found convertible unit which is null.");
            }
            if (Double.isNaN(d3)) {
            } else {
                if (Double.isInfinite(d3)) {
                } else {
                    this.g.put(u, k02);
                    this.h.put(u, Double.valueOf(d3));
                    HashSet obj5 = new HashSet(obj8);
                    obj5.remove(u);
                    this.i.put(u, obj5);
                    return this;
                }
                obj5 = new StringBuilder();
                obj5.append("Infinite: ");
                obj5.append(d3);
                IllegalArgumentException obj4 = new IllegalArgumentException(obj5.toString());
                throw obj4;
            }
            obj5 = new StringBuilder();
            obj5.append("Not a number: ");
            obj5.append(d3);
            obj4 = new IllegalArgumentException(obj5.toString());
            throw obj4;
        }

        public net.time4j.engine.f0<U, T> h() {
            final Object obj = this;
            if (obj.g.isEmpty()) {
            } else {
                super(obj.a, obj.f, obj.c, obj.d, obj.g, obj.h, obj.i, obj.e, obj.j, obj.k, obj.l, obj.m, obj.n, 0);
                w.A(f0Var);
                return f0Var;
            }
            IllegalStateException illegalStateException = new IllegalStateException("No time unit was registered.");
            throw illegalStateException;
        }

        public net.time4j.engine.f0.b<U, T> l(net.time4j.engine.g0<T> g0) {
            Objects.requireNonNull(g0, "Missing time line.");
            this.n = g0;
            return this;
        }
    }

    private static class c extends net.time4j.engine.e<T> implements net.time4j.engine.y<T, T> {

        private static final long serialVersionUID = 4777240530511579802L;
        private final T max;
        private final T min;
        private final Class<T> type;
        private c(Class<T> class, T t2, T t3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(class.getName());
            stringBuilder.append("-AXIS");
            super(stringBuilder.toString());
            this.type = class;
            this.min = t2;
            this.max = t3;
        }

        c(Class class, net.time4j.engine.i0 i02, net.time4j.engine.i0 i03, net.time4j.engine.f0.a f0$a4) {
            super(class, i02, i03);
        }

        protected <X extends net.time4j.engine.q<X>> net.time4j.engine.y<X, T> d(net.time4j.engine.w<X> w) {
            if (w.l().equals(this.type)) {
                return this;
            }
            return 0;
        }

        protected String g(net.time4j.engine.w<?> w) {
            return null;
        }

        @Override // net.time4j.engine.e
        public net.time4j.engine.p getChildAtCeiling(Object object) {
            k((i0)object);
            throw 0;
        }

        @Override // net.time4j.engine.e
        public net.time4j.engine.p getChildAtFloor(Object object) {
            l((i0)object);
            throw 0;
        }

        @Override // net.time4j.engine.e
        public Object getDefaultMaximum() {
            return n();
        }

        @Override // net.time4j.engine.e
        public Object getDefaultMinimum() {
            return o();
        }

        @Override // net.time4j.engine.e
        public Object getMaximum(Object object) {
            return r((i0)object);
        }

        @Override // net.time4j.engine.e
        public Object getMinimum(Object object) {
            return u((i0)object);
        }

        public Class<T> getType() {
            return this.type;
        }

        @Override // net.time4j.engine.e
        public Object getValue(Object object) {
            v((i0)object);
            return object;
        }

        @Override // net.time4j.engine.e
        public boolean isDateElement() {
            return 0;
        }

        @Override // net.time4j.engine.e
        public boolean isTimeElement() {
            return 0;
        }

        @Override // net.time4j.engine.e
        public boolean isValid(Object object, Object object2) {
            return w((i0)object, (i0)object2);
        }

        @Override // net.time4j.engine.e
        protected boolean j() {
            return 1;
        }

        public net.time4j.engine.p<?> k(T t) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        public net.time4j.engine.p<?> l(T t) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException();
            throw obj1;
        }

        public T n() {
            return this.max;
        }

        public T o() {
            return this.min;
        }

        public T r(T t) {
            return n();
        }

        public T u(T t) {
            return o();
        }

        public T v(T t) {
            return t;
        }

        public boolean w(T t, T t2) {
            int obj1;
            obj1 = t2 != 0 ? 1 : 0;
            return obj1;
        }

        @Override // net.time4j.engine.e
        public Object withValue(Object object, Object object2, boolean z3) {
            x((i0)object, (i0)object2, z3);
            return object2;
        }

        public T x(T t, T t2, boolean z3) {
            if (t2 == 0) {
            } else {
                return t2;
            }
            IllegalArgumentException obj1 = new IllegalArgumentException("Missing value.");
            throw obj1;
        }
    }
    private f0(Class<T> class, Class<U> class2, net.time4j.engine.t<T> t3, Map<net.time4j.engine.p<?>, net.time4j.engine.y<T, ?>> map4, Map<U, net.time4j.engine.k0<T>> map5, Map<U, Double> map6, Map<U, Set<U>> map7, List<net.time4j.engine.r> list8, Map<net.time4j.engine.p<?>, U> map9, T t10, T t11, net.time4j.engine.k<T> k12, net.time4j.engine.g0<T> g013) {
        Object obj1;
        net.time4j.engine.f0.c obj2;
        super(class, t3, map4, list8);
        this.z = Collections.unmodifiableMap(map5);
        this.A = Collections.unmodifiableMap(map6);
        this.B = Collections.unmodifiableMap(map7);
        this.C = Collections.unmodifiableMap(map9);
        this.D = t10;
        this.E = t11;
        this.F = k12;
        obj2 = new f0.c(class, t10, t11, 0);
        this.G = obj2;
        if (g013 == null) {
            obj1 = new ArrayList(map5.keySet());
            obj2 = new f0.a(this, map6);
            Collections.sort(obj1, obj2);
            obj1.get(0);
        }
    }

    f0(Class class, Class class2, net.time4j.engine.t t3, Map map4, Map map5, Map map6, Map map7, List list8, Map map9, net.time4j.engine.i0 i010, net.time4j.engine.i0 i011, net.time4j.engine.k k12, net.time4j.engine.g0 g013, net.time4j.engine.f0.a f0$a14) {
        super(class, class2, t3, map4, map5, map6, map7, list8, map9, i010, i011, k12, g013);
    }

    static double B(Map map, Object object2) {
        return f0.G(map, object2);
    }

    private static <U> double G(Map<U, Double> map, U u2) {
        Object obj0 = map.get(u2);
        if ((Double)obj0 == null && u2 instanceof v) {
            if (u2 instanceof v) {
                return (v)v.class.cast(u2).getLength();
            }
            return 9221120237041090560L;
        }
        return (Double)obj0.doubleValue();
    }

    public int C(T t, T t2) {
        return t.I(t2);
    }

    public T D(net.time4j.engine.q<?> q, net.time4j.engine.d d2, boolean z3, boolean z4) {
        if (q.v(this.G)) {
            return (i0)q.p(this.G);
        }
        return (i0)super.c(q, d2, z3, z4);
    }

    public net.time4j.engine.p<T> E() {
        return this.G;
    }

    public U F(net.time4j.engine.p<?> p) {
        Object obj;
        boolean z;
        Objects.requireNonNull(p, "Missing element.");
        if (this.C.get(p) == null && p instanceof e) {
            if (p instanceof e) {
                obj = this.C.get((e)p.f());
            }
        }
        if (obj == null) {
        } else {
            return obj;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Base unit not found for: ");
        stringBuilder.append(p.name());
        ChronoException chronoException = new ChronoException(stringBuilder.toString());
        throw chronoException;
    }

    public T H() {
        return this.E;
    }

    public T I() {
        return this.D;
    }

    net.time4j.engine.k0<T> J(U u) {
        boolean k0Var;
        Objects.requireNonNull(u, "Missing chronological unit.");
        if (K(u)) {
            return (k0)this.z.get(u);
        }
        if (!u instanceof f) {
        } else {
            k0Var = (f)f.class.cast(u).a(this);
            if (k0Var == null) {
            } else {
                return k0Var;
            }
        }
        RuleNotFoundException ruleNotFoundException = new RuleNotFoundException(this, u);
        throw ruleNotFoundException;
    }

    public boolean K(U u) {
        return this.z.containsKey(u);
    }

    @Override // net.time4j.engine.w
    public Object c(net.time4j.engine.q q, net.time4j.engine.d d2, boolean z3, boolean z4) {
        return D(q, d2, z3, z4);
    }

    @Override // net.time4j.engine.w
    public int compare(Object object, Object object2) {
        return C((i0)object, (i0)object2);
    }

    public net.time4j.engine.k<T> j() {
        net.time4j.engine.k kVar = this.F;
        if (kVar == null) {
        } else {
            return kVar;
        }
        super.j();
        throw 0;
    }

    public net.time4j.engine.k<T> k(String string) {
        if (!string.isEmpty()) {
        } else {
            return j();
        }
        super.k(string);
        throw 0;
    }
}
