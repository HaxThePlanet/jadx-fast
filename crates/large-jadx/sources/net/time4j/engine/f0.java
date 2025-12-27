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

/* compiled from: TimeAxis.java */
/* loaded from: classes3.dex */
public final class f0<U, T extends i0<U, T>> extends w<T> implements g0<T> {

    private final Map<U, Double> A;
    private final Map<U, Set<U>> B;
    private final Map<p<?>, U> C;
    private final T D;
    private final T E;
    private final k<T> F;
    private final p<T> G;
    private final Map<U, k0<T>> z;

    class a implements Comparator<U> {

        final /* synthetic */ Map a;
        a(Map map) {
            this.a = map;
            super();
        }

        @Override // java.util.Comparator
        public int compare(U u, U u2) {
            return Double.compare(f0.G(this.a, u), f0.G(this.a, u2));
        }
    }

    public static final class b<U, T extends i0<U, T>> extends w.a<T> {

        private final Class<U> f;
        private final Map<U, k0<T>> g = new HashMap<>();
        private final Map<U, Double> h = new HashMap<>();
        private final Map<U, Set<U>> i = new HashMap<>();
        private final Map<p<?>, U> j = new HashMap<>();
        private final T k;
        private final T l;
        private final k<T> m;
        private g0<T> n = null;
        private b(Class<U> cls, Class<T> cls2, t<T> tVar, T t, T t2, k<T> kVar, g0<T> g0Var) {
            super(cls2, tVar);
            Objects.requireNonNull(cls, "Missing unit type.");
            Objects.requireNonNull(t, "Missing minimum of range.");
            Objects.requireNonNull(t2, "Missing maximum of range.");
            if (m.class.isAssignableFrom(cls2)) {
                Objects.requireNonNull(kVar, "Missing calendar system.");
            }
            this.f = cls;
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            this.k = t;
            this.l = t2;
            this.m = kVar;
            this.n = g0Var;
        }

        private void i(U u) {
            boolean z2;
            Class<Enum> obj = Enum.class;
            if (this.b) {
                return;
            }
            Iterator it = this.g.keySet().iterator();
            str = "Unit duplicate found: ";
            while (it.hasNext()) {
                if (it.next().equals(u)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String object = u.toString();
                    u = str + object;
                    throw new IllegalArgumentException(u);
                }
            }
            z = u instanceof Enum;
            if (u instanceof Enum) {
                String name = (Enum)obj.cast(u).name();
                Iterator it2 = this.g.keySet().iterator();
                while (it2.hasNext()) {
                    Object item2 = it2.next();
                    z2 = item2 instanceof Enum;
                    if (item2 instanceof Enum) {
                    }
                }
            }
        }

        public static <U, D extends m<U, D>> f0.b<U, D> j(Class<U> cls, Class<D> cls2, t<D> tVar, k<D> kVar) {
            int i = 0;
            f0.b bVar = new f0.b(cls, cls2, tVar, (i0)kVar.a(kVar.d()), (i0)kVar.a(kVar.c()), kVar, null);
            final net.time4j.engine.z[] values = z.values();
            i = 0;
            for (Object obj3 : values) {
                bVar.d(obj3, obj3.derive(kVar));
            }
            return bVar;
        }

        public static <U, T extends i0<U, T>> f0.b<U, T> k(Class<U> cls, Class<T> cls2, t<T> tVar, T t, T t2) {
            f0.b bVar = new f0.b(cls, cls2, tVar, t, t2, null, null);
            return bVar;
        }

        @Override // net.time4j.engine.w$a
        public <V> f0.b<U, T> d(p<V> pVar, y<T, V> yVar) {
            super.a(pVar, yVar);
            return this;
        }

        @Override // net.time4j.engine.w$a
        public <V> f0.b<U, T> e(p<V> pVar, y<T, V> yVar, U u) {
            Objects.requireNonNull(u, "Missing base unit.");
            super.a(pVar, yVar);
            this.j.put(pVar, u);
            return this;
        }

        @Override // net.time4j.engine.w$a
        public f0.b<U, T> f(r rVar) {
            super.b(rVar);
            return this;
        }

        @Override // net.time4j.engine.w$a
        public f0.b<U, T> g(U u, k0<T> k0Var, double d, Set<? extends U> set) {
            Objects.requireNonNull(u, "Missing time unit.");
            Objects.requireNonNull(k0Var, "Missing unit rule.");
            i(u);
            Iterator it = set.iterator();
            while (it.hasNext()) {
                str = "Found convertible unit which is null.";
                Objects.requireNonNull(it.next(), str);
            }
            if (Double.isNaN(d)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "Not a number: ";
                k0Var = str4 + d;
                throw new IllegalArgumentException(k0Var);
            } else {
                if (Double.isInfinite(d)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str5 = "Infinite: ";
                    k0Var = str5 + d;
                    throw new IllegalArgumentException(k0Var);
                } else {
                    this.g.put(u, k0Var);
                    this.h.put(u, Double.valueOf(d));
                    HashSet hashSet = new HashSet(set);
                    hashSet.remove(u);
                    this.i.put(u, hashSet);
                    return this;
                }
            }
        }

        @Override // net.time4j.engine.w$a
        public f0<U, T> h() {
            final Object obj = this;
            if (obj.g.isEmpty()) {
                throw new IllegalStateException("No time unit was registered.");
            } else {
                f0 f0Var = new f0(obj.a, obj.f, obj.c, obj.d, obj.g, obj.h, obj.i, obj.e, obj.j, obj.k, obj.l, obj.m, obj.n, null);
                w.A(f0Var);
                return f0Var;
            }
        }

        @Override // net.time4j.engine.w$a
        public f0.b<U, T> l(g0<T> g0Var) {
            Objects.requireNonNull(g0Var, "Missing time line.");
            this.n = g0Var;
            return this;
        }
    }

    private static class c<T extends i0<?, T>> extends e<T> implements y<T, T> {

        private static final long serialVersionUID = 4777240530511579802L;
        private final T max;
        private final T min;
        private final Class<T> type;
        /* synthetic */ c(Class cls, i0 i0Var, i0 i0Var2, f0.a aVar) {
            this(cls, i0Var, i0Var2);
        }

        @Override // net.time4j.engine.e
        protected <X extends q<X>> y<X, T> d(w<X> wVar) {
            if (wVar.l().equals(this.type)) {
                return this;
            }
            return null;
        }

        @Override // net.time4j.engine.e
        public Class<T> getType() {
            return this.type;
        }

        @Override // net.time4j.engine.e
        public p<?> k(T t) {
            throw new UnsupportedOperationException();
        }

        @Override // net.time4j.engine.e
        public p<?> l(T t) {
            throw new UnsupportedOperationException();
        }

        @Override // net.time4j.engine.e
        public T n() {
            return this.max;
        }

        @Override // net.time4j.engine.e
        public T o() {
            return this.min;
        }

        @Override // net.time4j.engine.e
        public T r(T t) {
            return n();
        }

        @Override // net.time4j.engine.e
        public T u(T t) {
            return o();
        }

        @Override // net.time4j.engine.e
        public T x(T t, T t2, boolean z) {
            if (t2 == 0) {
                throw new IllegalArgumentException("Missing value.");
            } else {
                return t2;
            }
        }

        private c(Class<T> cls, T t, T t2) {
            StringBuilder stringBuilder = new StringBuilder();
            String name = cls.getName();
            String str2 = "-AXIS";
            str = name + str2;
            super(str);
            this.type = cls;
            this.min = t;
            this.max = t2;
        }

        @Override // net.time4j.engine.e
        protected String g(w<?> wVar) {
            return null;
        }

        @Override // net.time4j.engine.e
        public boolean isDateElement() {
            return false;
        }

        @Override // net.time4j.engine.e
        public boolean isTimeElement() {
            return false;
        }

        @Override // net.time4j.engine.e
        protected boolean j() {
            return true;
        }

        @Override // net.time4j.engine.e
        public T v(T t) {
            return t;
        }

        @Override // net.time4j.engine.e
        public boolean w(T t, T t2) {
            boolean z = true;
            t = t2 != 0 ? 1 : 0;
            return (t2 != 0 ? 1 : 0);
        }
    }
    /* synthetic */ f0(Class cls, Class cls2, t tVar, Map map, Map map2, Map map3, Map map4, List list, Map map5, i0 i0Var, i0 i0Var2, k kVar, g0 g0Var, f0.a aVar) {
        this(cls, cls2, tVar, map, map2, map3, map4, list, map5, i0Var, i0Var2, kVar, g0Var);
    }

    static /* synthetic */ double B(Map map, Object object) {
        return f0.G(map, object);
    }

    private static <U> double G(Map<U, Double> map, U u) {
        Object value = map.get(u);
        if (value == null) {
            if (u instanceof v) {
                return (v)v.class.cast(u).getLength();
            }
            return 9221120237041090560L;
        }
        return value.doubleValue();
    }

    @Override // net.time4j.engine.w
    public int C(T t, T t2) {
        return t.I(t2);
    }

    @Override // net.time4j.engine.w
    public T D(q<?> qVar, d dVar, boolean z, boolean z2) {
        if (qVar.v(this.G)) {
            return (i0)qVar.p(this.G);
        }
        return (i0)super.c(qVar, dVar, z, z2);
    }

    @Override // net.time4j.engine.w
    public p<T> E() {
        return this.G;
    }

    @Override // net.time4j.engine.w
    public U F(p<?> pVar) throws ChronoException {
        Object value;
        Objects.requireNonNull(pVar, "Missing element.");
        if (this.C.get(pVar) == null && pVar instanceof e) {
            value = this.C.get((e)pVar.f());
        }
        if ("Missing element." == null) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Base unit not found for: ";
            String name = pVar.name();
            pVar = str2 + name;
            throw new ChronoException(pVar);
        } else {
            return value;
        }
    }

    @Override // net.time4j.engine.w
    public T H() {
        return this.E;
    }

    @Override // net.time4j.engine.w
    public T I() {
        return this.D;
    }

    @Override // net.time4j.engine.w
    k0<T> J(U u) throws RuleNotFoundException {
        Objects.requireNonNull(u, "Missing chronological unit.");
        if (K(u)) {
            return (k0)this.z.get(u);
        }
        z = u instanceof f;
        if (!(u instanceof f)) {
            throw new RuleNotFoundException(this, u);
        } else {
            net.time4j.engine.k0 k0Var = (f)f.class.cast(u).a(this);
            if (k0Var != null) {
                return k0Var;
            }
        }
    }

    @Override // net.time4j.engine.w
    public boolean K(U u) {
        return this.z.containsKey(u);
    }

    @Override // net.time4j.engine.w
    public k<T> j() {
        if (this.F == null) {
            super.j();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.F;
        }
    }

    @Override // net.time4j.engine.w
    public k<T> k(String str) {
        if (!str.isEmpty()) {
            super.k(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return j();
        }
    }

    private f0(Class<T> cls, Class<U> cls2, t<T> tVar, Map<p<?>, y<T, ?>> map, Map<U, k0<T>> map2, Map<U, Double> map3, Map<U, Set<U>> map4, List<r> list, Map<p<?>, U> map5, T t, T t2, k<T> kVar, g0<T> g0Var) {
        super(cls, tVar, map, list);
        this.z = Collections.unmodifiableMap(map2);
        this.A = Collections.unmodifiableMap(map3);
        this.B = Collections.unmodifiableMap(map4);
        this.C = Collections.unmodifiableMap(map5);
        this.D = t;
        this.E = t2;
        this.F = kVar;
        this.G = new f0.c(cls, t, t2, null);
        if (g0Var == null) {
            ArrayList arrayList = new ArrayList(map2.keySet());
            Collections.sort(arrayList, new f0.a(this, map3));
            arrayList.get(0);
        }
    }
}
