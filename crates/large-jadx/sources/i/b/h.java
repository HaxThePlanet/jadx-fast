package i.b;

import i.b.l0.d;
import i.b.m0.e.b.a0;
import i.b.m0.e.b.b0;
import i.b.m0.e.b.c0;
import i.b.m0.e.b.d0;
import i.b.m0.e.b.e0;
import i.b.m0.e.b.f0;
import i.b.m0.e.b.g0;
import i.b.m0.e.b.h0;
import i.b.m0.e.b.i;
import i.b.m0.e.b.i0;
import i.b.m0.e.b.k;
import i.b.m0.e.b.l;
import i.b.m0.e.b.l0;
import i.b.m0.e.b.n0;
import i.b.m0.e.b.p;
import i.b.m0.e.b.q;
import i.b.m0.e.b.s;
import i.b.m0.e.b.t;
import i.b.m0.e.b.u;
import i.b.m0.e.b.v;
import i.b.m0.e.b.w;
import i.b.m0.e.b.x;
import i.b.m0.e.b.y;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Flowable.java */
/* loaded from: classes3.dex */
public abstract class h<T> implements m.c.a<T> {

    static final int a = 0;
    static {
        h.a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
    }

    public static <T> h<T> A(Iterable<? extends T> iterable) {
        b.e(iterable, "source is null");
        return a.l(new q(iterable));
    }

    public static <T> h<T> B(m.c.a<? extends T> aVar) {
        if (aVar instanceof h) {
            return a.l(aVar);
        }
        b.e(aVar, "source is null");
        return a.l(new s(aVar));
    }

    public static <T> h<T> C(T t) {
        b.e(t, "item is null");
        return a.l(new u(t));
    }

    public static <T> h<T> E(m.c.a<? extends T> aVar, m.c.a<? extends T> aVar2, m.c.a<? extends T> aVar3) {
        b.e(aVar, "source1 is null");
        b.e(aVar2, "source2 is null");
        b.e(aVar3, "source3 is null");
        int i = 3;
        final m.c.a[] arr = new a[i];
        final int i2 = 0;
        arr[i2] = aVar;
        arr[1] = aVar2;
        arr[2] = aVar3;
        return h.v(arr).p(a.i(), false, i);
    }

    public static int b() {
        return h.a;
    }

    public static <T> h<T> h(j<T> jVar, a aVar) {
        b.e(jVar, "source is null");
        b.e(aVar, "mode is null");
        return a.l(new e(jVar, aVar));
    }

    private h<T> i(i.b.l0.f<? super T> fVar, i.b.l0.f<? super Throwable> fVar2, i.b.l0.a aVar, i.b.l0.a aVar2) {
        b.e(fVar, "onNext is null");
        b.e(fVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(aVar2, "onAfterTerminate is null");
        f fVar3 = new f(this, fVar, fVar2, aVar, aVar2);
        return a.l(fVar3);
    }

    public static <T> h<T> l() {
        return a.l(i.b);
    }

    public static <T> h<T> v(T... tArr) {
        b.e(tArr, "items is null");
        if (tArr.length == 0) {
            return h.l();
        }
        if (tArr.length == 1) {
            return h.C(tArr[0]);
        }
        return a.l(new o(tArr));
    }

    public static <T> h<T> w(Future<? extends T> future) {
        b.e(future, "future is null");
        return a.l(new p(future, 0L, r2, 0));
    }

    public static <T> h<T> x(Future<? extends T> future, long j, TimeUnit timeUnit) {
        b.e(future, "future is null");
        b.e(timeUnit, "unit is null");
        return a.l(new p(future, j, r3, timeUnit));
    }

    public static <T> h<T> y(Future<? extends T> future, long j, TimeUnit timeUnit, z zVar) {
        b.e(zVar, "scheduler is null");
        return h.x(future, j, timeUnit).d0(zVar);
    }

    public static <T> h<T> z(Future<? extends T> future, z zVar) {
        b.e(zVar, "scheduler is null");
        return h.w(future).d0(zVar);
    }

    public final <R> h<R> D(i.b.l0.n<? super T, ? extends R> nVar) {
        b.e(nVar, "mapper is null");
        return a.l(new v(this, nVar));
    }

    public final h<T> F(z zVar) {
        return G(zVar, false, h.b());
    }

    public final h<T> G(z zVar, boolean z, int i) {
        b.e(zVar, "scheduler is null");
        b.f(i, "bufferSize");
        return a.l(new w(this, zVar, z, i));
    }

    public final h<T> H() {
        return I(h.b(), false, true);
    }

    public final h<T> I(int i, boolean z, boolean z2) {
        b.f(i, "capacity");
        x xVar = new x(this, i, z2, z, a.c);
        return a.l(xVar);
    }

    public final h<T> J() {
        return a.l(new y(this));
    }

    public final h<T> K() {
        return a.l(new a0(this));
    }

    public final i.b.k0.a<T> L() {
        return M(h.b());
    }

    public final i.b.k0.a<T> M(int i) {
        b.f(i, "bufferSize");
        return b0.i0(this, i);
    }

    public final h<T> N() {
        return O(Long.MAX_VALUE);
    }

    public final h<T> O(long j) {
        if (j < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "times >= 0 required but it was ";
            j = str + j;
            throw new IllegalArgumentException(j);
        } else {
            if (j == 0) {
                return h.l();
            }
            return a.l(new c0(this, j, r5));
        }
    }

    public final h<T> P(i.b.l0.e eVar) {
        b.e(eVar, "stop is null");
        return a.l(new d0(this, eVar));
    }

    public final h<T> Q(i.b.l0.n<? super h<Object>, ? extends m.c.a<?>> nVar) {
        b.e(nVar, "handler is null");
        return a.l(new e0(this, nVar));
    }

    public final h<T> R() {
        return T(Long.MAX_VALUE, a.c());
    }

    public final h<T> S(long j) {
        return T(j, a.c());
    }

    public final h<T> T(long j, i.b.l0.o<? super Throwable> oVar) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "times >= 0 required but it was ";
            j = str2 + j;
            throw new IllegalArgumentException(j);
        } else {
            b.e(oVar, "predicate is null");
            return a.l(new g0(this, j, r4, oVar));
        }
    }

    public final h<T> U(d<? super Integer, ? super Throwable> dVar) {
        b.e(dVar, "predicate is null");
        return a.l(new f0(this, dVar));
    }

    public final h<T> V(i.b.l0.o<? super Throwable> oVar) {
        return T(Long.MAX_VALUE, oVar);
    }

    public final h<T> W(i.b.l0.n<? super h<Throwable>, ? extends m.c.a<?>> nVar) {
        b.e(nVar, "handler is null");
        return a.l(new h0(this, nVar));
    }

    public final h<T> X(Comparator<? super T> comparator) {
        b.e(comparator, "sortFunction");
        return f0().toFlowable().D(a.m(comparator)).r(a.i());
    }

    public final i.b.j0.b Y(i.b.l0.f<? super T> fVar) {
        return a0(fVar, a.e, a.c, t.INSTANCE);
    }

    public final i.b.j0.b Z(i.b.l0.f<? super T> fVar, i.b.l0.f<? super Throwable> fVar2, i.b.l0.a aVar) {
        return a0(fVar, fVar2, aVar, t.INSTANCE);
    }

    public final void a(m.c.b<? super T> bVar) {
        z = bVar instanceof k;
        if (bVar instanceof k) {
            b0(bVar);
        } else {
            b.e(bVar, "s is null");
            b0(new f(bVar));
        }
    }

    public final i.b.j0.b a0(i.b.l0.f<? super T> fVar, i.b.l0.f<? super Throwable> fVar2, i.b.l0.a aVar, i.b.l0.f<? super m.c.c> fVar3) {
        b.e(fVar, "onNext is null");
        b.e(fVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(fVar3, "onSubscribe is null");
        i.b.m0.h.e eVar = new e(fVar, fVar2, aVar, fVar3);
        b0(eVar);
        return eVar;
    }

    public final void b0(k<? super T> kVar) {
        b.e(kVar, "s is null");
        try {
            final m.c.b bVar = a.B(this, kVar);
            b.e(bVar, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            c0(bVar);
        } catch (java.lang.NullPointerException npe) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) npe;
        } finally {
            a.b(npe);
            a.t(npe);
            java.lang.NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(npe);
            throw nullPointerException;
        }
    }

    public final <R> h<R> d(i.b.l0.n<? super T, ? extends m.c.a<? extends R>> nVar) {
        return e(nVar, 2);
    }

    public final h<T> d0(z zVar) {
        b.e(zVar, "scheduler is null");
        return e0(zVar, !(this instanceof e));
    }

    public final <R> h<R> e(i.b.l0.n<? super T, ? extends m.c.a<? extends R>> nVar, int i) {
        b.e(nVar, "mapper is null");
        b.f(i, "prefetch");
        if (this instanceof h) {
            Object call = (h)this.call();
            if (call == null) {
                return h.l();
            }
            return i0.a(call, nVar);
        }
        return a.l(new b(this, nVar, i, j.IMMEDIATE));
    }

    public final h<T> e0(z zVar, boolean z) {
        b.e(zVar, "scheduler is null");
        return a.l(new l0(this, zVar, z));
    }

    public final <R> h<R> f(i.b.l0.n<? super T, ? extends m.c.a<? extends R>> nVar) {
        return g(nVar, h.b(), h.b());
    }

    public final a0<List<T>> f0() {
        return a.o(new n0(this));
    }

    public final <R> h<R> g(i.b.l0.n<? super T, ? extends m.c.a<? extends R>> nVar, int i, int i2) {
        b.e(nVar, "mapper is null");
        b.f(i, "maxConcurrency");
        b.f(i2, "prefetch");
        c cVar = new c(this, nVar, i, i2, j.IMMEDIATE);
        return a.l(cVar);
    }

    public final h<T> j(i.b.l0.f<? super T> fVar) {
        final i.b.l0.a aVar = a.c;
        return i(fVar, a.g(), aVar, aVar);
    }

    public final l<T> k(long j) {
        if (j < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "index >= 0 required but it was ";
            j = str + j;
            throw new IndexOutOfBoundsException(j);
        } else {
            return a.m(new h(this, j, r5));
        }
    }

    public final h<T> m(i.b.l0.o<? super T> oVar) {
        b.e(oVar, "predicate is null");
        return a.l(new j(this, oVar));
    }

    public final l<T> n() {
        return k(0L);
    }

    public final <R> h<R> o(i.b.l0.n<? super T, ? extends m.c.a<? extends R>> nVar) {
        return q(nVar, false, h.b(), h.b());
    }

    public final <R> h<R> p(i.b.l0.n<? super T, ? extends m.c.a<? extends R>> nVar, boolean z, int i) {
        return q(nVar, z, i, h.b());
    }

    public final <R> h<R> q(i.b.l0.n<? super T, ? extends m.c.a<? extends R>> nVar, boolean z, int i, int i2) {
        b.e(nVar, "mapper is null");
        b.f(i, "maxConcurrency");
        b.f(i2, "bufferSize");
        if (this instanceof h) {
            Object call = (h)this.call();
            if (call == null) {
                return h.l();
            }
            return i0.a(call, nVar);
        }
        k kVar = new k(this, nVar, z, i, i2);
        return a.l(kVar);
    }

    public final <U> h<U> r(i.b.l0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        return s(nVar, h.b());
    }

    public final <U> h<U> s(i.b.l0.n<? super T, ? extends Iterable<? extends U>> nVar, int i) {
        b.e(nVar, "mapper is null");
        b.f(i, "bufferSize");
        return a.l(new n(this, nVar, i));
    }

    public final <R> h<R> t(i.b.l0.n<? super T, ? extends p<? extends R>> nVar) {
        return u(nVar, false, Integer.MAX_VALUE);
    }

    public final <R> h<R> u(i.b.l0.n<? super T, ? extends p<? extends R>> nVar, boolean z, int i) {
        b.e(nVar, "mapper is null");
        b.f(i, "maxConcurrency");
        return a.l(new l(this, nVar, z, i));
    }

    protected abstract void c0(m.c.b<? super T> bVar);
}
