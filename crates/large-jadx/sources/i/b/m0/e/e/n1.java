package i.b.m0.e.e;

import i.b.g;
import i.b.l0.a;
import i.b.l0.b;
import i.b.l0.c;
import i.b.l0.f;
import i.b.l0.n;
import i.b.m0.b.a;
import i.b.m0.b.b;
import i.b.n0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class n1 {

    static final class a implements Callable<a<T>> {

        private final r<T> a;
        private final int b;
        a(r<T> r, int i2) {
            super();
            this.a = r;
            this.b = i2;
        }

        public a<T> a() {
            return this.a.replay(this.b);
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    static final class b implements Callable<a<T>> {

        private final r<T> a;
        private final int b;
        private final long c;
        private final TimeUnit v;
        private final z w;
        b(r<T> r, int i2, long l3, TimeUnit timeUnit4, z z5) {
            super();
            this.a = r;
            this.b = i2;
            this.c = l3;
            this.v = z5;
            this.w = obj6;
        }

        public a<T> a() {
            return this.a.replay(this.b, this.c, obj3, this.v);
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    static final class j implements Callable<a<T>> {

        private final r<T> a;
        j(r<T> r) {
            super();
            this.a = r;
        }

        public a<T> a() {
            return this.a.replay();
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    static final class n implements Callable<a<T>> {

        private final r<T> a;
        private final long b;
        private final TimeUnit c;
        private final z v;
        n(r<T> r, long l2, TimeUnit timeUnit3, z z4) {
            super();
            this.a = r;
            this.b = l2;
            this.c = z4;
            this.v = obj5;
        }

        public a<T> a() {
            return this.a.replay(this.b, obj2, this.c);
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    static final class c implements n<T, w<U>> {

        private final n<? super T, ? extends Iterable<? extends U>> a;
        c(n<? super T, ? extends Iterable<? extends U>> n) {
            super();
            this.a = n;
        }

        public w<U> a(T t) {
            final Object obj3 = this.a.apply(t);
            b.e(obj3, "The mapper returned a null Iterable");
            e1 e1Var = new e1((Iterable)obj3);
            return e1Var;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a(object);
        }
    }

    static final class d implements n<U, R> {

        private final c<? super T, ? super U, ? extends R> a;
        private final T b;
        d(c<? super T, ? super U, ? extends R> c, T t2) {
            super();
            this.a = c;
            this.b = t2;
        }

        public R apply(U u) {
            return this.a.apply(this.b, u);
        }
    }

    static final class e implements n<T, w<R>> {

        private final c<? super T, ? super U, ? extends R> a;
        private final n<? super T, ? extends w<? extends U>> b;
        e(c<? super T, ? super U, ? extends R> c, n<? super T, ? extends w<? extends U>> n2) {
            super();
            this.a = c;
            this.b = n2;
        }

        public w<R> a(T t) {
            Object apply = this.b.apply(t);
            b.e(apply, "The mapper returned a null ObservableSource");
            n1.d dVar = new n1.d(this.a, t);
            v1 v1Var = new v1((w)apply, dVar);
            return v1Var;
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a(object);
        }
    }

    static final class f implements n<T, w<T>> {

        final n<? super T, ? extends w<U>> a;
        f(n<? super T, ? extends w<U>> n) {
            super();
            this.a = n;
        }

        public w<T> a(T t) {
            Object apply = this.a.apply(t);
            b.e(apply, "The itemDelay returned a null ObservableSource");
            o3 o3Var = new o3((w)apply, 1, obj3);
            return o3Var.map(a.l(t)).defaultIfEmpty(t);
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a(object);
        }
    }

    static final class g implements a {

        final y<T> a;
        g(y<T> y) {
            super();
            this.a = y;
        }

        @Override // i.b.l0.a
        public void run() {
            this.a.onComplete();
        }
    }

    static final class h implements f<Throwable> {

        final y<T> a;
        h(y<T> y) {
            super();
            this.a = y;
        }

        @Override // i.b.l0.f
        public void a(Throwable throwable) {
            this.a.onError(throwable);
        }

        @Override // i.b.l0.f
        public void accept(Object object) {
            a((Throwable)object);
        }
    }

    static final class i implements f<T> {

        final y<T> a;
        i(y<T> y) {
            super();
            this.a = y;
        }

        public void accept(T t) {
            this.a.onNext(t);
        }
    }

    static final class k implements n<r<T>, w<R>> {

        private final n<? super r<T>, ? extends w<R>> a;
        private final z b;
        k(n<? super r<T>, ? extends w<R>> n, z z2) {
            super();
            this.a = n;
            this.b = z2;
        }

        public w<R> a(r<T> r) {
            Object obj2 = this.a.apply(r);
            b.e(obj2, "The selector returned a null ObservableSource");
            return r.wrap((w)obj2).observeOn(this.b);
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((r)object);
        }
    }

    static final class l implements c<S, g<T>, S> {

        final b<S, g<T>> a;
        l(b<S, g<T>> b) {
            super();
            this.a = b;
        }

        public S a(S s, g<T> g2) {
            this.a.a(s, g2);
            return s;
        }

        @Override // i.b.l0.c
        public Object apply(Object object, Object object2) {
            a(object, (g)object2);
            return object;
        }
    }

    static final class m implements c<S, g<T>, S> {

        final f<g<T>> a;
        m(f<g<T>> f) {
            super();
            this.a = f;
        }

        public S a(S s, g<T> g2) {
            this.a.accept(g2);
            return s;
        }

        @Override // i.b.l0.c
        public Object apply(Object object, Object object2) {
            a(object, (g)object2);
            return object;
        }
    }

    static final class o implements n<List<w<? extends T>>, w<? extends R>> {

        private final n<? super Object[], ? extends R> a;
        o(n<? super Object[], ? extends R> n) {
            super();
            this.a = n;
        }

        public w<? extends R> a(List<w<? extends T>> list) {
            return r.zipIterable(list, this.a, false, r.bufferSize());
        }

        @Override // i.b.l0.n
        public Object apply(Object object) {
            return a((List)object);
        }
    }
    public static <T, U> n<T, w<U>> a(n<? super T, ? extends Iterable<? extends U>> n) {
        n1.c cVar = new n1.c(n);
        return cVar;
    }

    public static <T, U, R> n<T, w<R>> b(n<? super T, ? extends w<? extends U>> n, c<? super T, ? super U, ? extends R> c2) {
        n1.e eVar = new n1.e(c2, n);
        return eVar;
    }

    public static <T, U> n<T, w<T>> c(n<? super T, ? extends w<U>> n) {
        n1.f fVar = new n1.f(n);
        return fVar;
    }

    public static <T> a d(y<T> y) {
        n1.g gVar = new n1.g(y);
        return gVar;
    }

    public static <T> f<Throwable> e(y<T> y) {
        n1.h hVar = new n1.h(y);
        return hVar;
    }

    public static <T> f<T> f(y<T> y) {
        n1.i iVar = new n1.i(y);
        return iVar;
    }

    public static <T> Callable<a<T>> g(r<T> r) {
        n1.j jVar = new n1.j(r);
        return jVar;
    }

    public static <T> Callable<a<T>> h(r<T> r, int i2) {
        n1.a aVar = new n1.a(r, i2);
        return aVar;
    }

    public static <T> Callable<a<T>> i(r<T> r, int i2, long l3, TimeUnit timeUnit4, z z5) {
        super(r, i2, l3, obj4, z5, obj13);
        return bVar2;
    }

    public static <T> Callable<a<T>> j(r<T> r, long l2, TimeUnit timeUnit3, z z4) {
        super(r, l2, obj3, z4, obj11);
        return nVar2;
    }

    public static <T, R> n<r<T>, w<R>> k(n<? super r<T>, ? extends w<R>> n, z z2) {
        n1.k kVar = new n1.k(n, z2);
        return kVar;
    }

    public static <T, S> c<S, g<T>, S> l(b<S, g<T>> b) {
        n1.l lVar = new n1.l(b);
        return lVar;
    }

    public static <T, S> c<S, g<T>, S> m(f<g<T>> f) {
        n1.m mVar = new n1.m(f);
        return mVar;
    }

    public static <T, R> n<List<w<? extends T>>, w<? extends R>> n(n<? super Object[], ? extends R> n) {
        n1.o oVar = new n1.o(n);
        return oVar;
    }
}
