package i.b.m0.b;

import i.b.l0.a;
import i.b.l0.b;
import i.b.l0.c;
import i.b.l0.e;
import i.b.l0.f;
import i.b.l0.g;
import i.b.l0.h;
import i.b.l0.i;
import i.b.l0.j;
import i.b.l0.k;
import i.b.l0.l;
import i.b.l0.m;
import i.b.l0.n;
import i.b.l0.o;
import i.b.p0.a;
import i.b.q;
import i.b.s0.b;
import i.b.z;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class a {

    static final n<Object, Object> a;
    public static final Runnable b;
    public static final a c;
    static final f<Object> d;
    public static final f<Throwable> e;
    static final o<Object> f;
    static final o<Object> g;
    static final Callable<Object> h;
    static final Comparator<Object> i;

    static final class b0 implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    static final class j implements Callable<List<T>> {

        final int a;
        j(int i) {
            super();
            this.a = i;
        }

        public List<T> a() {
            ArrayList arrayList = new ArrayList(this.a);
            return arrayList;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    static final class p implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        @Override // java.lang.Runnable
        public String toString() {
            return "EmptyRunnable";
        }
    }

    static enum s implements Callable<Set<Object>> {

        INSTANCE;
        @Override // java.lang.Enum
        public Object call() {
            return call();
        }

        public Set<Object> call() {
            HashSet hashSet = new HashSet();
            return hashSet;
        }
    }

    static enum w implements Comparator<Object> {

        INSTANCE;
        @Override // java.lang.Enum
        public int compare(Object object, Object object2) {
            return (Comparable)object.compareTo(object2);
        }
    }

    static final class x implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return (Comparable)object.compareTo(object2);
        }
    }

    static final class a0 implements f<T> {

        final f<? super q<T>> a;
        a0(f<? super q<T>> f) {
            super();
            this.a = f;
        }

        public void accept(T t) {
            this.a.accept(q.c(t));
        }
    }

    static final class a implements f<T> {

        final a a;
        a(a a) {
            super();
            this.a = a;
        }

        public void accept(T t) {
            this.a.run();
        }
    }

    static final class b implements n<Object[], R> {

        final c<? super T1, ? super T2, ? extends R> a;
        b(c<? super T1, ? super T2, ? extends R> c) {
            super();
            this.a = c;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 2) {
            } else {
                return this.a.apply(objectArr[0], objectArr[1]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 2 expected but got ");
            stringBuilder.append(objectArr.length);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((Object[])object);
        }
    }

    static final class c0 implements f<Throwable> {
        @Override // i.b.l0.f
        public void a(Throwable throwable) {
            OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
            a.t(onErrorNotImplementedException);
        }

        @Override // i.b.l0.f
        public void accept(Object object) {
            a((Throwable)object);
        }
    }

    static final class c implements n<Object[], R> {

        final g<T1, T2, T3, R> a;
        c(g<T1, T2, T3, R> g) {
            super();
            this.a = g;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 3) {
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 3 expected but got ");
            stringBuilder.append(objectArr.length);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((Object[])object);
        }
    }

    static final class d0 implements n<T, b<T>> {

        final TimeUnit a;
        final z b;
        d0(TimeUnit timeUnit, z z2) {
            super();
            this.a = timeUnit;
            this.b = z2;
        }

        public b<T> a(T t) {
            final TimeUnit time = this.a;
            b bVar = new b(t, this.b.b(time), time, this.a);
            return bVar;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a(object);
        }
    }

    static final class d implements n<Object[], R> {

        final h<T1, T2, T3, T4, R> a;
        d(h<T1, T2, T3, T4, R> h) {
            super();
            this.a = h;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 4) {
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 4 expected but got ");
            stringBuilder.append(objectArr.length);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((Object[])object);
        }
    }

    static final class e0 implements b<Map<K, T>, T> {

        private final n<? super T, ? extends K> a;
        e0(n<? super T, ? extends K> n) {
            super();
            this.a = n;
        }

        @Override // i.b.l0.b
        public void a(Object object, Object object2) {
            b((Map)object, object2);
        }

        public void b(Map<K, T> map, T t2) {
            map.put(this.a.apply(t2), t2);
        }
    }

    static final class e implements n<Object[], R> {

        private final i<T1, T2, T3, T4, T5, R> a;
        e(i<T1, T2, T3, T4, T5, R> i) {
            super();
            this.a = i;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 5) {
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3], objectArr[4]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 5 expected but got ");
            stringBuilder.append(objectArr.length);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((Object[])object);
        }
    }

    static final class f0 implements b<Map<K, V>, T> {

        private final n<? super T, ? extends V> a;
        private final n<? super T, ? extends K> b;
        f0(n<? super T, ? extends V> n, n<? super T, ? extends K> n2) {
            super();
            this.a = n;
            this.b = n2;
        }

        @Override // i.b.l0.b
        public void a(Object object, Object object2) {
            b((Map)object, object2);
        }

        public void b(Map<K, V> map, T t2) {
            map.put(this.b.apply(t2), this.a.apply(t2));
        }
    }

    static final class f implements n<Object[], R> {

        final j<T1, T2, T3, T4, T5, T6, R> a;
        f(j<T1, T2, T3, T4, T5, T6, R> j) {
            super();
            this.a = j;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 6) {
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3], objectArr[4], objectArr[5]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 6 expected but got ");
            stringBuilder.append(objectArr.length);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((Object[])object);
        }
    }

    static final class g0 implements b<Map<K, Collection<V>>, T> {

        private final n<? super K, ? extends Collection<? super V>> a;
        private final n<? super T, ? extends V> b;
        private final n<? super T, ? extends K> c;
        g0(n<? super K, ? extends Collection<? super V>> n, n<? super T, ? extends V> n2, n<? super T, ? extends K> n3) {
            super();
            this.a = n;
            this.b = n2;
            this.c = n3;
        }

        @Override // i.b.l0.b
        public void a(Object object, Object object2) {
            b((Map)object, object2);
        }

        public void b(Map<K, Collection<V>> map, T t2) {
            Object apply;
            Object apply2 = this.c.apply(t2);
            if ((Collection)map.get(apply2) == null) {
                map.put(apply2, (Collection)this.a.apply(apply2));
            }
            apply.add(this.b.apply(t2));
        }
    }

    static final class g implements n<Object[], R> {

        final k<T1, T2, T3, T4, T5, T6, T7, R> a;
        g(k<T1, T2, T3, T4, T5, T6, T7, R> k) {
            super();
            this.a = k;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 7) {
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3], objectArr[4], objectArr[5], objectArr[6]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 7 expected but got ");
            stringBuilder.append(objectArr.length);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((Object[])object);
        }
    }

    static final class h0 implements o<Object> {
        @Override // i.b.l0.o
        public boolean test(Object object) {
            return 1;
        }
    }

    static final class h implements n<Object[], R> {

        final l<T1, T2, T3, T4, T5, T6, T7, T8, R> a;
        h(l<T1, T2, T3, T4, T5, T6, T7, T8, R> l) {
            super();
            this.a = l;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 8) {
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3], objectArr[4], objectArr[5], objectArr[6], objectArr[7]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 8 expected but got ");
            stringBuilder.append(objectArr.length);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((Object[])object);
        }
    }

    static final class i implements n<Object[], R> {

        final m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a;
        i(m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> m) {
            super();
            this.a = m;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 9) {
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3], objectArr[4], objectArr[5], objectArr[6], objectArr[7], objectArr[8]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Array of size 9 expected but got ");
            stringBuilder.append(objectArr.length);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((Object[])object);
        }
    }

    static final class k implements o<T> {

        final e a;
        k(e e) {
            super();
            this.a = e;
        }

        public boolean test(T t) {
            return obj1 ^= 1;
        }
    }

    static final class l implements n<T, U> {

        final Class<U> a;
        l(Class<U> class) {
            super();
            this.a = class;
        }

        public U apply(T t) {
            return this.a.cast(t);
        }
    }

    static final class m implements o<T> {

        final Class<U> a;
        m(Class<U> class) {
            super();
            this.a = class;
        }

        public boolean test(T t) {
            return this.a.isInstance(t);
        }
    }

    static final class n implements a {
        @Override // i.b.l0.a
        public void run() {
        }

        @Override // i.b.l0.a
        public String toString() {
            return "EmptyAction";
        }
    }

    static final class o implements f<Object> {
        @Override // i.b.l0.f
        public void accept(Object object) {
        }

        @Override // i.b.l0.f
        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class q implements o<T> {

        final T a;
        q(T t) {
            super();
            this.a = t;
        }

        public boolean test(T t) {
            return b.c(t, this.a);
        }
    }

    static final class r implements o<Object> {
        @Override // i.b.l0.o
        public boolean test(Object object) {
            return 0;
        }
    }

    static final class t implements n<Object, Object> {
        @Override // i.b.l0.n
        public Object apply(Object object) {
            return object;
        }

        @Override // i.b.l0.n
        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class u implements Callable<U>, n<T, U> {

        final U a;
        u(U u) {
            super();
            this.a = u;
        }

        public U apply(T t) {
            return this.a;
        }

        public U call() {
            return this.a;
        }
    }

    static final class v implements n<List<T>, List<T>> {

        final Comparator<? super T> a;
        v(Comparator<? super T> comparator) {
            super();
            this.a = comparator;
        }

        public List<T> a(List<T> list) {
            Collections.sort(list, this.a);
            return list;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            a((List)object);
            return object;
        }
    }

    static final class y implements a {

        final f<? super q<T>> a;
        y(f<? super q<T>> f) {
            super();
            this.a = f;
        }

        @Override // i.b.l0.a
        public void run() {
            this.a.accept(q.a());
        }
    }

    static final class z implements f<Throwable> {

        final f<? super q<T>> a;
        z(f<? super q<T>> f) {
            super();
            this.a = f;
        }

        @Override // i.b.l0.f
        public void a(Throwable throwable) {
            this.a.accept(q.b(throwable));
        }

        @Override // i.b.l0.f
        public void accept(Object object) {
            a((Throwable)object);
        }
    }
    static {
        a.t tVar = new a.t();
        a.a = tVar;
        a.p pVar = new a.p();
        a.b = pVar;
        a.n nVar = new a.n();
        a.c = nVar;
        a.o oVar = new a.o();
        a.d = oVar;
        a.c0 c0Var = new a.c0();
        a.e = c0Var;
        a.h0 h0Var = new a.h0();
        a.f = h0Var;
        a.r rVar = new a.r();
        a.g = rVar;
        a.b0 b0Var = new a.b0();
        a.h = b0Var;
        a.x xVar = new a.x();
        a.i = xVar;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> n<Object[], R> A(k<T1, T2, T3, T4, T5, T6, T7, R> k) {
        b.e(k, "f is null");
        a.g gVar = new a.g(k);
        return gVar;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> n<Object[], R> B(l<T1, T2, T3, T4, T5, T6, T7, T8, R> l) {
        b.e(l, "f is null");
        a.h hVar = new a.h(l);
        return hVar;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> n<Object[], R> C(m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> m) {
        b.e(m, "f is null");
        a.i iVar = new a.i(m);
        return iVar;
    }

    public static <T, K> b<Map<K, T>, T> D(n<? super T, ? extends K> n) {
        a.e0 e0Var = new a.e0(n);
        return e0Var;
    }

    public static <T, K, V> b<Map<K, V>, T> E(n<? super T, ? extends K> n, n<? super T, ? extends V> n2) {
        a.f0 f0Var = new a.f0(n2, n);
        return f0Var;
    }

    public static <T, K, V> b<Map<K, Collection<V>>, T> F(n<? super T, ? extends K> n, n<? super T, ? extends V> n2, n<? super K, ? extends Collection<? super V>> n3) {
        a.g0 g0Var = new a.g0(n3, n2, n);
        return g0Var;
    }

    public static <T> f<T> a(a a) {
        a.a aVar = new a.a(a);
        return aVar;
    }

    public static <T> o<T> b() {
        return a.g;
    }

    public static <T> o<T> c() {
        return a.f;
    }

    public static <T, U> n<T, U> d(Class<U> class) {
        a.l lVar = new a.l(class);
        return lVar;
    }

    public static <T> Callable<List<T>> e(int i) {
        a.j jVar = new a.j(i);
        return jVar;
    }

    public static <T> Callable<Set<T>> f() {
        return a.s.INSTANCE;
    }

    public static <T> f<T> g() {
        return a.d;
    }

    public static <T> o<T> h(T t) {
        a.q qVar = new a.q(t);
        return qVar;
    }

    public static <T> n<T, T> i() {
        return a.a;
    }

    public static <T, U> o<T> j(Class<U> class) {
        a.m mVar = new a.m(class);
        return mVar;
    }

    public static <T> Callable<T> k(T t) {
        a.u uVar = new a.u(t);
        return uVar;
    }

    public static <T, U> n<T, U> l(U u) {
        a.u uVar = new a.u(u);
        return uVar;
    }

    public static <T> n<List<T>, List<T>> m(Comparator<? super T> comparator) {
        a.v vVar = new a.v(comparator);
        return vVar;
    }

    public static <T> Comparator<T> n() {
        return a.w.INSTANCE;
    }

    public static <T> Comparator<T> o() {
        return a.i;
    }

    public static <T> a p(f<? super q<T>> f) {
        a.y yVar = new a.y(f);
        return yVar;
    }

    public static <T> f<Throwable> q(f<? super q<T>> f) {
        a.z zVar = new a.z(f);
        return zVar;
    }

    public static <T> f<T> r(f<? super q<T>> f) {
        a.a0 a0Var = new a.a0(f);
        return a0Var;
    }

    public static <T> Callable<T> s() {
        return a.h;
    }

    public static <T> o<T> t(e e) {
        a.k kVar = new a.k(e);
        return kVar;
    }

    public static <T> n<T, b<T>> u(TimeUnit timeUnit, z z2) {
        a.d0 d0Var = new a.d0(timeUnit, z2);
        return d0Var;
    }

    public static <T1, T2, R> n<Object[], R> v(c<? super T1, ? super T2, ? extends R> c) {
        b.e(c, "f is null");
        a.b bVar = new a.b(c);
        return bVar;
    }

    public static <T1, T2, T3, R> n<Object[], R> w(g<T1, T2, T3, R> g) {
        b.e(g, "f is null");
        a.c cVar = new a.c(g);
        return cVar;
    }

    public static <T1, T2, T3, T4, R> n<Object[], R> x(h<T1, T2, T3, T4, R> h) {
        b.e(h, "f is null");
        a.d dVar = new a.d(h);
        return dVar;
    }

    public static <T1, T2, T3, T4, T5, R> n<Object[], R> y(i<T1, T2, T3, T4, T5, R> i) {
        b.e(i, "f is null");
        a.e eVar = new a.e(i);
        return eVar;
    }

    public static <T1, T2, T3, T4, T5, T6, R> n<Object[], R> z(j<T1, T2, T3, T4, T5, T6, R> j) {
        b.e(j, "f is null");
        a.f fVar = new a.f(j);
        return fVar;
    }
}
