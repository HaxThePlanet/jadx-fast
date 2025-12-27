package i.b.m0.e.e;

import i.b.g;
import i.b.l0.c;
import i.b.l0.f;
import i.b.l0.n;
import i.b.r;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableInternalHelper.java */
/* loaded from: classes3.dex */
public final class n1 {

    static final class a<T> implements Callable<i.b.n0.a<T>> {

        private final r<T> a;
        private final int b;
        a(r<T> rVar, int i) {
            super();
            this.a = rVar;
            this.b = i;
        }

        public i.b.n0.a<T> a() {
            return this.a.replay(this.b);
        }
    }

    static final class b<T> implements Callable<i.b.n0.a<T>> {

        private final r<T> a;
        private final int b;
        private final long c;
        private final TimeUnit v;
        private final z w;
        b(r<T> rVar, int i, long j, TimeUnit timeUnit, z zVar) {
            super();
            this.a = rVar;
            this.b = i;
            this.c = j;
            this.v = timeUnit;
            this.w = zVar;
        }

        public i.b.n0.a<T> a() {
            return this.a.replay(this.b, this.c, this.v, this.w);
        }
    }

    static final class j<T> implements Callable<i.b.n0.a<T>> {

        private final r<T> a;
        j(r<T> rVar) {
            super();
            this.a = rVar;
        }

        public i.b.n0.a<T> a() {
            return this.a.replay();
        }
    }

    static final class n<T> implements Callable<i.b.n0.a<T>> {

        private final r<T> a;
        private final long b;
        private final TimeUnit c;
        private final z v;
        n(r<T> rVar, long j, TimeUnit timeUnit, z zVar) {
            super();
            this.a = rVar;
            this.b = j;
            this.c = timeUnit;
            this.v = zVar;
        }

        public i.b.n0.a<T> a() {
            return this.a.replay(this.b, this.c, this.v);
        }
    }

    static final class c<T, U> implements n<T, w<U>> {

        private final n<? super T, ? extends Iterable<? extends U>> a;
        c(n<? super T, ? extends Iterable<? extends U>> nVar) {
            super();
            this.a = nVar;
        }

        public w<U> a(T t) {
            final Object apply = this.a.apply(t);
            b.e(apply, "The mapper returned a null Iterable");
            return new e1(apply);
        }
    }

    static final class d<U, R, T> implements n<U, R> {

        private final c<? super T, ? super U, ? extends R> a;
        private final T b;
        d(c<? super T, ? super U, ? extends R> cVar, T t) {
            super();
            this.a = cVar;
            this.b = t;
        }

        public R apply(U u) {
            return this.a.apply(this.b, u);
        }
    }

    static final class e<T, R, U> implements n<T, w<R>> {

        private final c<? super T, ? super U, ? extends R> a;
        private final n<? super T, ? extends w<? extends U>> b;
        e(c<? super T, ? super U, ? extends R> cVar, n<? super T, ? extends w<? extends U>> nVar) {
            super();
            this.a = cVar;
            this.b = nVar;
        }

        public w<R> a(T t) {
            Object apply = this.b.apply(t);
            b.e(apply, "The mapper returned a null ObservableSource");
            return new v1(apply, new n1.d(this.a, t));
        }
    }

    static final class f<T, U> implements n<T, w<T>> {

        final n<? super T, ? extends w<U>> a;
        f(n<? super T, ? extends w<U>> nVar) {
            super();
            this.a = nVar;
        }

        public w<T> a(T t) {
            Object apply = this.a.apply(t);
            b.e(apply, "The itemDelay returned a null ObservableSource");
            return new o3(apply, 1L, r3).map(a.l(t)).defaultIfEmpty(t);
        }
    }

    static final class g<T> implements i.b.l0.a {

        final y<T> a;
        g(y<T> yVar) {
            super();
            this.a = yVar;
        }

        public void run() {
            this.a.onComplete();
        }
    }

    static final class h<T> implements f<Throwable> {

        final y<T> a;
        h(y<T> yVar) {
            super();
            this.a = yVar;
        }

        public void a(Throwable th) {
            this.a.onError(th);
        }
    }

    static final class i<T> implements f<T> {

        final y<T> a;
        i(y<T> yVar) {
            super();
            this.a = yVar;
        }

        public void accept(T t) {
            this.a.onNext(t);
        }
    }

    static final class k<T, R> implements n<r<T>, w<R>> {

        private final n<? super r<T>, ? extends w<R>> a;
        private final z b;
        k(n<? super r<T>, ? extends w<R>> nVar, z zVar) {
            super();
            this.a = nVar;
            this.b = zVar;
        }

        public w<R> a(r<T> rVar) {
            Object apply = this.a.apply(rVar);
            b.e(apply, "The selector returned a null ObservableSource");
            return r.wrap(apply).observeOn(this.b);
        }
    }

    static final class l<T, S> implements c<S, g<T>, S> {

        final i.b.l0.b<S, g<T>> a;
        l(i.b.l0.b<S, g<T>> bVar) {
            super();
            this.a = bVar;
        }

        public S a(S s, g<T> gVar) {
            this.a.a(s, gVar);
            return s;
        }
    }

    static final class m<T, S> implements c<S, g<T>, S> {

        final f<g<T>> a;
        m(f<g<T>> fVar) {
            super();
            this.a = fVar;
        }

        public S a(S s, g<T> gVar) {
            this.a.accept(gVar);
            return s;
        }
    }

    static final class o<T, R> implements n<List<w<? extends T>>, w<? extends R>> {

        private final n<? super Object[], ? extends R> a;
        o(n<? super Object[], ? extends R> nVar) {
            super();
            this.a = nVar;
        }

        public w<? extends R> a(List<w<? extends T>> list) {
            return r.zipIterable(list, this.a, false, r.bufferSize());
        }
    }
    public static <T, U> n<T, w<U>> a(n<? super T, ? extends Iterable<? extends U>> nVar) {
        return new n1.c(nVar);
    }

    public static <T, U, R> n<T, w<R>> b(n<? super T, ? extends w<? extends U>> nVar, c<? super T, ? super U, ? extends R> cVar) {
        return new n1.e(cVar, nVar);
    }

    public static <T, U> n<T, w<T>> c(n<? super T, ? extends w<U>> nVar) {
        return new n1.f(nVar);
    }

    public static <T> i.b.l0.a d(y<T> yVar) {
        return new n1.g(yVar);
    }

    public static <T> f<Throwable> e(y<T> yVar) {
        return new n1.h(yVar);
    }

    public static <T> f<T> f(y<T> yVar) {
        return new n1.i(yVar);
    }

    public static <T> Callable<i.b.n0.a<T>> g(r<T> rVar) {
        return new n1.j(rVar);
    }

    public static <T> Callable<i.b.n0.a<T>> h(r<T> rVar, int i) {
        return new n1.a(rVar, i);
    }

    public static <T> Callable<i.b.n0.a<T>> i(r<T> rVar, int i, long j, TimeUnit timeUnit, z zVar) {
        n1.b bVar = new n1.b(rVar, i, j, timeUnit, timeUnit, zVar);
        return bVar;
    }

    public static <T> Callable<i.b.n0.a<T>> j(r<T> rVar, long j, TimeUnit timeUnit, z zVar) {
        n1.n nVar = new n1.n(rVar, j, timeUnit, timeUnit, zVar);
        return nVar;
    }

    public static <T, R> n<r<T>, w<R>> k(n<? super r<T>, ? extends w<R>> nVar, z zVar) {
        return new n1.k(nVar, zVar);
    }

    public static <T, S> c<S, g<T>, S> l(i.b.l0.b<S, g<T>> bVar) {
        return new n1.l(bVar);
    }

    public static <T, S> c<S, g<T>, S> m(f<g<T>> fVar) {
        return new n1.m(fVar);
    }

    public static <T, R> n<List<w<? extends T>>, w<? extends R>> n(n<? super Object[], ? extends R> nVar) {
        return new n1.o(nVar);
    }
}
