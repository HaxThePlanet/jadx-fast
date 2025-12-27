package i.b.m0.b;

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
import i.b.q;
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

/* compiled from: Functions.java */
/* loaded from: classes3.dex */
public final class a {

    static final n<Object, Object> a = new a$t<>();
    public static final Runnable b = new a$p();
    public static final i.b.l0.a c = new a$n();
    static final f<Object> d = new a$o<>();
    public static final f<Throwable> e = new a$c0<>();
    static final o<Object> f = new a$h0<>();
    static final o<Object> g = new a$r<>();
    static final Callable<Object> h = new a$b0<>();
    static final Comparator<Object> i = new a$x<>();

    static final class b0 implements Callable<Object> {
        b0() {
            super();
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    static final class j<T> implements Callable<List<T>> {

        final int a;
        j(int i) {
            super();
            this.a = i;
        }

        public List<T> a() {
            return new ArrayList(this.a);
        }
    }

    static final class p implements Runnable {
        p() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        @Override // java.lang.Object
        public String toString() {
            return "EmptyRunnable";
        }
    }

    enum s implements Callable<Set<Object>> {

        INSTANCE;
        @Override // java.lang.Enum
        public Set<Object> call() {
            return new HashSet();
        }
    }

    enum w implements Comparator<Object> {

        INSTANCE;
        @Override // java.lang.Enum
        public int compare(Object object, Object object2) {
            return object.compareTo(object2);
        }
    }

    static final class x implements Comparator<Object> {
        x() {
            super();
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return object.compareTo(object2);
        }
    }

    static final class a0<T> implements f<T> {

        final f<? super q<T>> a;
        a0(f<? super q<T>> fVar) {
            super();
            this.a = fVar;
        }

        public void accept(T t) {
            this.a.accept(q.c(t));
        }
    }

    static final class a<T> implements f<T> {

        final i.b.l0.a a;
        a(i.b.l0.a aVar) {
            super();
            this.a = aVar;
        }

        public void accept(T t) {
            this.a.run();
        }
    }

    static final class b<T1, T2, R> implements n<Object[], R> {

        final c<? super T1, ? super T2, ? extends R> a;
        b(c<? super T1, ? super T2, ? extends R> cVar) {
            super();
            this.a = cVar;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Array of size 2 expected but got ";
                int length2 = objectArr.length;
                objectArr = str + length2;
                throw new IllegalArgumentException(objectArr);
            } else {
                return this.a.apply(objectArr[0], objectArr[1]);
            }
        }
    }

    static final class c0 implements f<Throwable> {
        c0() {
            super();
        }

        public void a(Throwable th) {
            a.t(new OnErrorNotImplementedException(th));
        }
    }

    static final class c<T1, T2, T3, R> implements n<Object[], R> {

        final g<T1, T2, T3, R> a;
        c(g<T1, T2, T3, R> gVar) {
            super();
            this.a = gVar;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 3) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Array of size 3 expected but got ";
                int length2 = objectArr.length;
                objectArr = str + length2;
                throw new IllegalArgumentException(objectArr);
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2]);
            }
        }
    }

    static final class d0<T> implements n<T, i.b.s0.b<T>> {

        final TimeUnit a;
        final z b;
        d0(TimeUnit timeUnit, z zVar) {
            super();
            this.a = timeUnit;
            this.b = zVar;
        }

        public i.b.s0.b<T> a(T t) {
            return new b(t, this.b.b(this.a), timeUnit, this.a);
        }
    }

    static final class d<T1, T2, T3, T4, R> implements n<Object[], R> {

        final h<T1, T2, T3, T4, R> a;
        d(h<T1, T2, T3, T4, R> hVar) {
            super();
            this.a = hVar;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 4) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Array of size 4 expected but got ";
                int length2 = objectArr.length;
                objectArr = str + length2;
                throw new IllegalArgumentException(objectArr);
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3]);
            }
        }
    }

    static final class e0<K, T> implements i.b.l0.b<Map<K, T>, T> {

        private final n<? super T, ? extends K> a;
        e0(n<? super T, ? extends K> nVar) {
            super();
            this.a = nVar;
        }

        public void b(Map<K, T> map, T t) {
            map.put(this.a.apply(t), t);
        }
    }

    static final class e<T1, T2, T3, T4, T5, R> implements n<Object[], R> {

        private final i<T1, T2, T3, T4, T5, R> a;
        e(i<T1, T2, T3, T4, T5, R> iVar) {
            super();
            this.a = iVar;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 5) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Array of size 5 expected but got ";
                int length2 = objectArr.length;
                objectArr = str + length2;
                throw new IllegalArgumentException(objectArr);
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3], objectArr[4]);
            }
        }
    }

    static final class f0<K, V, T> implements i.b.l0.b<Map<K, V>, T> {

        private final n<? super T, ? extends V> a;
        private final n<? super T, ? extends K> b;
        f0(n<? super T, ? extends V> nVar, n<? super T, ? extends K> nVar2) {
            super();
            this.a = nVar;
            this.b = nVar2;
        }

        public void b(Map<K, V> map, T t) {
            map.put(this.b.apply(t), this.a.apply(t));
        }
    }

    static final class f<T1, T2, T3, T4, T5, T6, R> implements n<Object[], R> {

        final j<T1, T2, T3, T4, T5, T6, R> a;
        f(j<T1, T2, T3, T4, T5, T6, R> jVar) {
            super();
            this.a = jVar;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 6) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Array of size 6 expected but got ";
                int length2 = objectArr.length;
                objectArr = str + length2;
                throw new IllegalArgumentException(objectArr);
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3], objectArr[4], objectArr[5]);
            }
        }
    }

    static final class g0<K, V, T> implements i.b.l0.b<Map<K, Collection<V>>, T> {

        private final n<? super K, ? extends Collection<? super V>> a;
        private final n<? super T, ? extends V> b;
        private final n<? super T, ? extends K> c;
        g0(n<? super K, ? extends Collection<? super V>> nVar, n<? super T, ? extends V> nVar2, n<? super T, ? extends K> nVar3) {
            super();
            this.a = nVar;
            this.b = nVar2;
            this.c = nVar3;
        }

        public void b(Map<K, Collection<V>> map, T t) {
            Object value;
            Object apply = this.c.apply(t);
            if ((Collection)map.get(apply) == null) {
                map.put(apply, (Collection)this.a.apply(apply));
            }
            value.add(this.b.apply(t));
        }
    }

    static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements n<Object[], R> {

        final k<T1, T2, T3, T4, T5, T6, T7, R> a;
        g(k<T1, T2, T3, T4, T5, T6, T7, R> kVar) {
            super();
            this.a = kVar;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 7) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Array of size 7 expected but got ";
                int length2 = objectArr.length;
                objectArr = str + length2;
                throw new IllegalArgumentException(objectArr);
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3], objectArr[4], objectArr[5], objectArr[6]);
            }
        }
    }

    static final class h0 implements o<Object> {
        h0() {
            super();
        }

        public boolean test(Object object) {
            return true;
        }
    }

    static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements n<Object[], R> {

        final l<T1, T2, T3, T4, T5, T6, T7, T8, R> a;
        h(l<T1, T2, T3, T4, T5, T6, T7, T8, R> lVar) {
            super();
            this.a = lVar;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 8) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Array of size 8 expected but got ";
                int length2 = objectArr.length;
                objectArr = str + length2;
                throw new IllegalArgumentException(objectArr);
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3], objectArr[4], objectArr[5], objectArr[6], objectArr[7]);
            }
        }
    }

    static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements n<Object[], R> {

        final m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a;
        i(m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> mVar) {
            super();
            this.a = mVar;
        }

        public R a(Object[] objectArr) {
            if (objectArr.length != 9) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Array of size 9 expected but got ";
                int length2 = objectArr.length;
                objectArr = str + length2;
                throw new IllegalArgumentException(objectArr);
            } else {
                return this.a.a(objectArr[0], objectArr[1], objectArr[2], objectArr[3], objectArr[4], objectArr[5], objectArr[6], objectArr[7], objectArr[8]);
            }
        }
    }

    static final class k<T> implements o<T> {

        final e a;
        k(e eVar) {
            super();
            this.a = eVar;
        }

        public boolean test(T t) {
            return !this.a.a();
        }
    }

    static final class l<T, U> implements n<T, U> {

        final Class<U> a;
        l(Class<U> cls) {
            super();
            this.a = cls;
        }

        public U apply(T t) {
            return this.a.cast(t);
        }
    }

    static final class m<T, U> implements o<T> {

        final Class<U> a;
        m(Class<U> cls) {
            super();
            this.a = cls;
        }

        public boolean test(T t) {
            return this.a.isInstance(t);
        }
    }

    static final class n implements i.b.l0.a {
        n() {
            super();
        }

        public void run() {
        }

        @Override // java.lang.Object
        public String toString() {
            return "EmptyAction";
        }
    }

    static final class o implements f<Object> {
        o() {
            super();
        }

        public void accept(Object object) {
        }

        @Override // java.lang.Object
        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class q<T> implements o<T> {

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
        r() {
            super();
        }

        public boolean test(Object object) {
            return false;
        }
    }

    static final class t implements n<Object, Object> {
        t() {
            super();
        }

        public Object apply(Object object) {
            return object;
        }

        @Override // java.lang.Object
        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class u<T, U> implements Callable<U>, n<T, U> {

        final U a;
        u(U u) {
            super();
            this.a = u;
        }

        public U apply(T t) {
            return this.a;
        }

        @Override // java.util.concurrent.Callable
        public U call() {
            return this.a;
        }
    }

    static final class v<T> implements n<List<T>, List<T>> {

        final Comparator<? super T> a;
        v(Comparator<? super T> comparator) {
            super();
            this.a = comparator;
        }

        public List<T> a(List<T> list) {
            Collections.sort(list, this.a);
            return list;
        }
    }

    static final class y<T> implements i.b.l0.a {

        final f<? super q<T>> a;
        y(f<? super q<T>> fVar) {
            super();
            this.a = fVar;
        }

        public void run() {
            this.a.accept(q.a());
        }
    }

    static final class z<T> implements f<Throwable> {

        final f<? super q<T>> a;
        z(f<? super q<T>> fVar) {
            super();
            this.a = fVar;
        }

        public void a(Throwable th) {
            this.a.accept(q.b(th));
        }
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> n<Object[], R> A(k<T1, T2, T3, T4, T5, T6, T7, R> kVar) {
        b.e(kVar, "f is null");
        return new a.g(kVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> n<Object[], R> B(l<T1, T2, T3, T4, T5, T6, T7, T8, R> lVar) {
        b.e(lVar, "f is null");
        return new a.h(lVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> n<Object[], R> C(m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> mVar) {
        b.e(mVar, "f is null");
        return new a.i(mVar);
    }

    public static <T, K> i.b.l0.b<Map<K, T>, T> D(n<? super T, ? extends K> nVar) {
        return new a.e0(nVar);
    }

    public static <T, K, V> i.b.l0.b<Map<K, V>, T> E(n<? super T, ? extends K> nVar, n<? super T, ? extends V> nVar2) {
        return new a.f0(nVar2, nVar);
    }

    public static <T, K, V> i.b.l0.b<Map<K, Collection<V>>, T> F(n<? super T, ? extends K> nVar, n<? super T, ? extends V> nVar2, n<? super K, ? extends Collection<? super V>> nVar3) {
        return new a.g0(nVar3, nVar2, nVar);
    }

    public static <T> f<T> a(i.b.l0.a aVar) {
        return new a.a(aVar);
    }

    public static <T> o<T> b() {
        return a.g;
    }

    public static <T> o<T> c() {
        return a.f;
    }

    public static <T, U> n<T, U> d(Class<U> cls) {
        return new a.l(cls);
    }

    public static <T> Callable<List<T>> e(int i) {
        return new a.j(i);
    }

    public static <T> Callable<Set<T>> f() {
        return a.s.INSTANCE;
    }

    public static <T> f<T> g() {
        return a.d;
    }

    public static <T> o<T> h(T t) {
        return new a.q(t);
    }

    public static <T> n<T, T> i() {
        return a.a;
    }

    public static <T, U> o<T> j(Class<U> cls) {
        return new a.m(cls);
    }

    public static <T> Callable<T> k(T t) {
        return new a.u(t);
    }

    public static <T, U> n<T, U> l(U u) {
        return new a.u(u);
    }

    public static <T> n<List<T>, List<T>> m(Comparator<? super T> comparator) {
        return new a.v(comparator);
    }

    public static <T> Comparator<T> n() {
        return a.w.INSTANCE;
    }

    public static <T> Comparator<T> o() {
        return a.i;
    }

    public static <T> i.b.l0.a p(f<? super q<T>> fVar) {
        return new a.y(fVar);
    }

    public static <T> f<Throwable> q(f<? super q<T>> fVar) {
        return new a.z(fVar);
    }

    public static <T> f<T> r(f<? super q<T>> fVar) {
        return new a.a0(fVar);
    }

    public static <T> Callable<T> s() {
        return a.h;
    }

    public static <T> o<T> t(e eVar) {
        return new a.k(eVar);
    }

    public static <T> n<T, i.b.s0.b<T>> u(TimeUnit timeUnit, z zVar) {
        return new a.d0(timeUnit, zVar);
    }

    public static <T1, T2, R> n<Object[], R> v(c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(cVar, "f is null");
        return new a.b(cVar);
    }

    public static <T1, T2, T3, R> n<Object[], R> w(g<T1, T2, T3, R> gVar) {
        b.e(gVar, "f is null");
        return new a.c(gVar);
    }

    public static <T1, T2, T3, T4, R> n<Object[], R> x(h<T1, T2, T3, T4, R> hVar) {
        b.e(hVar, "f is null");
        return new a.d(hVar);
    }

    public static <T1, T2, T3, T4, T5, R> n<Object[], R> y(i<T1, T2, T3, T4, T5, R> iVar) {
        b.e(iVar, "f is null");
        return new a.e(iVar);
    }

    public static <T1, T2, T3, T4, T5, T6, R> n<Object[], R> z(j<T1, T2, T3, T4, T5, T6, R> jVar) {
        b.e(jVar, "f is null");
        return new a.f(jVar);
    }
}
