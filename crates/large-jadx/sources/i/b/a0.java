package i.b;

import i.b.m0.e.e.f3;
import i.b.m0.e.f.a0;
import i.b.m0.e.f.b0;
import i.b.m0.e.f.c0;
import i.b.m0.e.f.d0;
import i.b.m0.e.f.e0;
import i.b.m0.e.f.f0;
import i.b.m0.e.f.g0;
import i.b.m0.e.f.h0;
import i.b.m0.e.f.i0;
import i.b.m0.e.f.j0;
import i.b.m0.e.f.l0;
import i.b.m0.e.f.m0;
import i.b.m0.e.f.n0;
import i.b.m0.e.f.o0;
import i.b.m0.e.f.p0;
import i.b.m0.e.f.q0;
import i.b.m0.e.f.r;
import i.b.m0.e.f.r0;
import i.b.m0.e.f.s;
import i.b.m0.e.f.s0;
import i.b.m0.e.f.t;
import i.b.m0.e.f.t0;
import i.b.m0.e.f.u0;
import i.b.m0.e.f.v;
import i.b.m0.e.f.v0;
import i.b.m0.e.f.w;
import i.b.m0.e.f.w0;
import i.b.m0.e.f.x;
import i.b.m0.e.f.x0;
import i.b.m0.e.f.y;
import i.b.m0.e.f.y0;
import i.b.m0.e.f.z;
import i.b.m0.e.f.z0;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Single.java */
/* loaded from: classes3.dex */
public abstract class a0<T> implements g0<T> {
    public static <T> a0<T> amb(Iterable<? extends g0<? extends T>> iterable) {
        b.e(iterable, "sources is null");
        return a.o(new a(null, iterable));
    }

    public static <T> a0<T> ambArray(g0<? extends T>... g0VarArr) {
        if (g0VarArr.length == 0) {
            return a0.error(h0.a());
        }
        if (g0VarArr.length == 1) {
            return a0.wrap(g0VarArr[0]);
        }
        return a.o(new a(g0VarArr, null));
    }

    public static <T> h<T> concat(Iterable<? extends g0<? extends T>> iterable) {
        return a0.concat(h.A(iterable));
    }

    public static <T> h<T> concatArray(g0<? extends T>... g0VarArr) {
        return a.l(new b(h.v(g0VarArr), h0.b(), 2, j.BOUNDARY));
    }

    public static <T> h<T> concatArrayEager(g0<? extends T>... g0VarArr) {
        return h.v(g0VarArr).f(h0.b());
    }

    public static <T> h<T> concatEager(m.c.a<? extends g0<? extends T>> aVar) {
        return h.B(aVar).f(h0.b());
    }

    public static <T> a0<T> create(e0<T> e0Var) {
        b.e(e0Var, "source is null");
        return a.o(new d(e0Var));
    }

    public static <T> a0<T> defer(Callable<? extends g0<? extends T>> callable) {
        b.e(callable, "singleSupplier is null");
        return a.o(new e(callable));
    }

    public static <T> a0<Boolean> equals(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        b.e(g0Var, "first is null");
        b.e(g0Var2, "second is null");
        return a.o(new v(g0Var, g0Var2));
    }

    public static <T> a0<T> error(Callable<? extends Throwable> callable) {
        b.e(callable, "errorSupplier is null");
        return a.o(new w(callable));
    }

    public static <T> a0<T> fromCallable(Callable<? extends T> callable) {
        b.e(callable, "callable is null");
        return a.o(new d0(callable));
    }

    public static <T> a0<T> fromFuture(Future<? extends T> future) {
        return a0.toSingle(h.w(future));
    }

    public static <T> a0<T> fromObservable(w<? extends T> wVar) {
        b.e(wVar, "observableSource is null");
        return a.o(new f3(wVar, null));
    }

    public static <T> a0<T> fromPublisher(m.c.a<? extends T> aVar) {
        b.e(aVar, "publisher is null");
        return a.o(new e0(aVar));
    }

    public static <T> a0<T> just(T t) {
        b.e(t, "item is null");
        return a.o(new i0(t));
    }

    public static <T> h<T> merge(Iterable<? extends g0<? extends T>> iterable) {
        return a0.merge(h.A(iterable));
    }

    public static <T> h<T> mergeDelayError(Iterable<? extends g0<? extends T>> iterable) {
        return a0.mergeDelayError(h.A(iterable));
    }

    public static <T> a0<T> never() {
        return a.o(m0.a);
    }

    private a0<T> timeout0(long j, TimeUnit timeUnit, z zVar, g0<? extends T> g0Var) {
        b.e(timeUnit, "unit is null");
        b.e(zVar, "scheduler is null");
        s0 s0Var = new s0(this, j, timeUnit, timeUnit, zVar, g0Var);
        return a.o(s0Var);
    }

    public static a0<Long> timer(long j, TimeUnit timeUnit) {
        return a0.timer(j, timeUnit, a.a());
    }

    private static <T> a0<T> toSingle(h<T> hVar) {
        return a.o(new k0(hVar, null));
    }

    public static <T> a0<T> unsafeCreate(g0<T> g0Var) {
        b.e(g0Var, "onSubscribe is null");
        if (g0Var instanceof a0) {
            throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        } else {
            return a.o(new f0(g0Var));
        }
    }

    public static <T, U> a0<T> using(Callable<U> callable, i.b.l0.n<? super U, ? extends g0<? extends T>> nVar, i.b.l0.f<? super U> fVar) {
        return a0.using(callable, nVar, fVar, true);
    }

    public static <T> a0<T> wrap(g0<T> g0Var) {
        b.e(g0Var, "source is null");
        if (g0Var instanceof a0) {
            return a.o(g0Var);
        }
        return a.o(new f0(g0Var));
    }

    public static <T, R> a0<R> zip(Iterable<? extends g0<? extends T>> iterable, i.b.l0.n<? super Object[], ? extends R> nVar) {
        b.e(nVar, "zipper is null");
        b.e(iterable, "sources is null");
        return a.o(new z0(iterable, nVar));
    }

    public static <T, R> a0<R> zipArray(i.b.l0.n<? super Object[], ? extends R> nVar, g0<? extends T>... g0VarArr) {
        b.e(nVar, "zipper is null");
        b.e(g0VarArr, "sources is null");
        if (g0VarArr.length == 0) {
            return a0.error(new NoSuchElementException());
        }
        return a.o(new y0(g0VarArr, nVar));
    }

    public final a0<T> ambWith(g0<? extends T> g0Var) {
        b.e(g0Var, "other is null");
        i.b.g0[] arr = new g0[2];
        return a0.ambArray(this, g0Var);
    }

    public final <R> R as(b0<T, ? extends R> b0Var) {
        b.e(b0Var, "converter is null");
        return b0Var.a(this);
    }

    public final T blockingGet() {
        i.b.m0.d.h hVar = new h();
        subscribe(hVar);
        return hVar.a();
    }

    public final a0<T> cache() {
        return a.o(new b(this));
    }

    public final <U> a0<U> cast(Class<? extends U> cls) {
        b.e(cls, "clazz is null");
        return map(a.d(cls));
    }

    public final <R> a0<R> compose(h0<? super T, ? extends R> h0Var) {
        b.e(h0Var, "transformer is null");
        return a0.wrap(h0Var.a(this));
    }

    public final h<T> concatWith(g0<? extends T> g0Var) {
        return a0.concat(this, g0Var);
    }

    public final a0<Boolean> contains(Object object) {
        return contains(object, b.d());
    }

    public final a0<T> delay(long j, TimeUnit timeUnit) {
        return this.delay(j, timeUnit, a.a(), false);
    }

    public final a0<T> delaySubscription(f fVar) {
        b.e(fVar, "other is null");
        return a.o(new g(this, fVar));
    }

    public final <R> l<R> dematerialize(i.b.l0.n<? super T, q<R>> nVar) {
        b.e(nVar, "selector is null");
        return a.m(new k(this, nVar));
    }

    public final a0<T> doAfterSuccess(i.b.l0.f<? super T> fVar) {
        b.e(fVar, "onAfterSuccess is null");
        return a.o(new m(this, fVar));
    }

    public final a0<T> doAfterTerminate(i.b.l0.a aVar) {
        b.e(aVar, "onAfterTerminate is null");
        return a.o(new n(this, aVar));
    }

    public final a0<T> doFinally(i.b.l0.a aVar) {
        b.e(aVar, "onFinally is null");
        return a.o(new o(this, aVar));
    }

    public final a0<T> doOnDispose(i.b.l0.a aVar) {
        b.e(aVar, "onDispose is null");
        return a.o(new p(this, aVar));
    }

    public final a0<T> doOnError(i.b.l0.f<? super Throwable> fVar) {
        b.e(fVar, "onError is null");
        return a.o(new q(this, fVar));
    }

    public final a0<T> doOnEvent(i.b.l0.b<? super T, ? super Throwable> bVar) {
        b.e(bVar, "onEvent is null");
        return a.o(new r(this, bVar));
    }

    public final a0<T> doOnSubscribe(i.b.l0.f<? super i.b.j0.b> fVar) {
        b.e(fVar, "onSubscribe is null");
        return a.o(new s(this, fVar));
    }

    public final a0<T> doOnSuccess(i.b.l0.f<? super T> fVar) {
        b.e(fVar, "onSuccess is null");
        return a.o(new t(this, fVar));
    }

    public final a0<T> doOnTerminate(i.b.l0.a aVar) {
        b.e(aVar, "onTerminate is null");
        return a.o(new u(this, aVar));
    }

    public final l<T> filter(i.b.l0.o<? super T> oVar) {
        b.e(oVar, "predicate is null");
        return a.m(new f(this, oVar));
    }

    public final <R> a0<R> flatMap(i.b.l0.n<? super T, ? extends g0<? extends R>> nVar) {
        b.e(nVar, "mapper is null");
        return a.o(new x(this, nVar));
    }

    public final b flatMapCompletable(i.b.l0.n<? super T, ? extends f> nVar) {
        b.e(nVar, "mapper is null");
        return a.k(new y(this, nVar));
    }

    public final <R> l<R> flatMapMaybe(i.b.l0.n<? super T, ? extends p<? extends R>> nVar) {
        b.e(nVar, "mapper is null");
        return a.m(new b0(this, nVar));
    }

    public final <R> r<R> flatMapObservable(i.b.l0.n<? super T, ? extends w<? extends R>> nVar) {
        b.e(nVar, "mapper is null");
        return a.n(new j(this, nVar));
    }

    public final <R> h<R> flatMapPublisher(i.b.l0.n<? super T, ? extends m.c.a<? extends R>> nVar) {
        b.e(nVar, "mapper is null");
        return a.l(new c0(this, nVar));
    }

    public final <U> h<U> flattenAsFlowable(i.b.l0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        b.e(nVar, "mapper is null");
        return a.l(new z(this, nVar));
    }

    public final <U> r<U> flattenAsObservable(i.b.l0.n<? super T, ? extends Iterable<? extends U>> nVar) {
        b.e(nVar, "mapper is null");
        return a.n(new a0(this, nVar));
    }

    public final a0<T> hide() {
        return a.o(new g0(this));
    }

    public final b ignoreElement() {
        return a.k(new h(this));
    }

    public final <R> a0<R> lift(f0<? extends R, ? super T> f0Var) {
        b.e(f0Var, "lift is null");
        return a.o(new j0(this, f0Var));
    }

    public final <R> a0<R> map(i.b.l0.n<? super T, ? extends R> nVar) {
        b.e(nVar, "mapper is null");
        return a.o(new k0(this, nVar));
    }

    public final a0<q<T>> materialize() {
        return a.o(new l0(this));
    }

    public final h<T> mergeWith(g0<? extends T> g0Var) {
        return a0.merge(this, g0Var);
    }

    public final a0<T> observeOn(z zVar) {
        b.e(zVar, "scheduler is null");
        return a.o(new n0(this, zVar));
    }

    public final a0<T> onErrorResumeNext(a0<? extends T> a0Var) {
        b.e(a0Var, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(a.l(a0Var));
    }

    public final a0<T> onErrorReturn(i.b.l0.n<Throwable, ? extends T> nVar) {
        b.e(nVar, "resumeFunction is null");
        return a.o(new o0(this, nVar, null));
    }

    public final a0<T> onErrorReturnItem(T t) {
        b.e(t, "value is null");
        return a.o(new o0(this, null, t));
    }

    public final a0<T> onTerminateDetach() {
        return a.o(new l(this));
    }

    public final h<T> repeat() {
        return toFlowable().N();
    }

    public final h<T> repeatUntil(i.b.l0.e eVar) {
        return toFlowable().P(eVar);
    }

    public final h<T> repeatWhen(i.b.l0.n<? super h<Object>, ? extends m.c.a<?>> nVar) {
        return toFlowable().Q(nVar);
    }

    public final a0<T> retry() {
        return a0.toSingle(toFlowable().R());
    }

    public final a0<T> retryWhen(i.b.l0.n<? super h<Throwable>, ? extends m.c.a<?>> nVar) {
        return a0.toSingle(toFlowable().W(nVar));
    }

    public final i.b.j0.b subscribe() {
        return subscribe(a.g(), a.e);
    }

    public final a0<T> subscribeOn(z zVar) {
        b.e(zVar, "scheduler is null");
        return a.o(new q0(this, zVar));
    }

    public final <E extends d0<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final a0<T> takeUntil(f fVar) {
        b.e(fVar, "other is null");
        return takeUntil(new p(fVar));
    }

    public final i.b.o0.f<T> test() {
        final i.b.o0.f fVar = new f();
        subscribe(fVar);
        return fVar;
    }

    public final a0<T> timeout(long j, TimeUnit timeUnit) {
        return this.timeout0(j, timeUnit, a.a(), null);
    }

    public final <R> R to(i.b.l0.n<? super a0<T>, R> nVar) {
        try {
            b.e(nVar, "convert is null");
        } finally {
            a.b(nVar);
            nVar = k.e(nVar);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) nVar;
        }
        return nVar.apply(this);
    }

    @Deprecated
    public final b toCompletable() {
        return a.k(new h(this));
    }

    public final h<T> toFlowable() {
        if (this instanceof b) {
            return (b)this.c();
        }
        return a.l(new u0(this));
    }

    public final Future<T> toFuture() {
        return (Future)subscribeWith(new q());
    }

    public final l<T> toMaybe() {
        if (this instanceof c) {
            return (c)this.b();
        }
        return a.m(new k(this));
    }

    public final r<T> toObservable() {
        if (this instanceof d) {
            return (d)this.a();
        }
        return a.n(new v0(this));
    }

    public final a0<T> unsubscribeOn(z zVar) {
        b.e(zVar, "scheduler is null");
        return a.o(new w0(this, zVar));
    }

    public final <U, R> a0<R> zipWith(g0<U> g0Var, i.b.l0.c<? super T, ? super U, ? extends R> cVar) {
        return a0.zip(this, g0Var, cVar);
    }

    public static <T> r<T> concat(w<? extends g0<? extends T>> wVar) {
        b.e(wVar, "sources is null");
        return a.n(new u(wVar, h0.c(), 2, j.IMMEDIATE));
    }

    public static <T> h<T> concatEager(Iterable<? extends g0<? extends T>> iterable) {
        return h.A(iterable).f(h0.b());
    }

    public static <T> a0<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return a0.toSingle(h.x(future, j, timeUnit));
    }

    public static <T> h<T> merge(m.c.a<? extends g0<? extends T>> aVar) {
        b.e(aVar, "sources is null");
        m mVar = new m(aVar, h0.b(), false, Integer.MAX_VALUE, h.b());
        return a.l(mVar);
    }

    public static <T> h<T> mergeDelayError(m.c.a<? extends g0<? extends T>> aVar) {
        b.e(aVar, "sources is null");
        m mVar = new m(aVar, h0.b(), true, Integer.MAX_VALUE, h.b());
        return a.l(mVar);
    }

    public static a0<Long> timer(long j, TimeUnit timeUnit, z zVar) {
        b.e(timeUnit, "unit is null");
        b.e(zVar, "scheduler is null");
        return a.o(new t0(j, r2, timeUnit, zVar));
    }

    public static <T, U> a0<T> using(Callable<U> callable, i.b.l0.n<? super U, ? extends g0<? extends T>> nVar, i.b.l0.f<? super U> fVar, boolean z) {
        b.e(callable, "resourceSupplier is null");
        b.e(nVar, "singleFunction is null");
        b.e(fVar, "disposer is null");
        return a.o(new x0(callable, nVar, fVar, z));
    }

    public final a0<Boolean> contains(Object object, i.b.l0.d<Object, Object> dVar) {
        b.e(object, "value is null");
        b.e(dVar, "comparer is null");
        return a.o(new c(this, object, dVar));
    }

    public final a0<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return this.delay(j, timeUnit, a.a(), z);
    }

    public final h<T> repeat(long j) {
        return toFlowable().O(j);
    }

    public final a0<T> retry(long j) {
        return a0.toSingle(toFlowable().S(j));
    }

    public final i.b.j0.b subscribe(i.b.l0.b<? super T, ? super Throwable> bVar) {
        b.e(bVar, "onCallback is null");
        i.b.m0.d.d dVar = new d(bVar);
        subscribe(dVar);
        return dVar;
    }

    public final a0<T> timeout(long j, TimeUnit timeUnit, z zVar) {
        return this.timeout0(j, timeUnit, zVar, null);
    }

    public static <T> a0<T> error(Throwable th) {
        b.e(th, "exception is null");
        return a0.error(a.k(th));
    }

    public static <T> a0<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, z zVar) {
        return a0.toSingle(h.y(future, j, timeUnit, zVar));
    }

    public final a0<T> delay(long j, TimeUnit timeUnit, z zVar) {
        return this.delay(j, timeUnit, zVar, false);
    }

    public final <U> a0<T> delaySubscription(g0<U> g0Var) {
        b.e(g0Var, "other is null");
        return a.o(new j(this, g0Var));
    }

    public final a0<T> onErrorResumeNext(i.b.l0.n<? super Throwable, ? extends g0<? extends T>> nVar) {
        b.e(nVar, "resumeFunctionInCaseOfError is null");
        return a.o(new p0(this, nVar));
    }

    public final a0<T> retry(i.b.l0.d<? super Integer, ? super Throwable> dVar) {
        return a0.toSingle(toFlowable().U(dVar));
    }

    public final <E> a0<T> takeUntil(m.c.a<E> aVar) {
        b.e(aVar, "other is null");
        return a.o(new r0(this, aVar));
    }

    public final i.b.o0.f<T> test(boolean z) {
        final i.b.o0.f fVar = new f();
        if (z) {
            fVar.a();
        }
        subscribe(fVar);
        return fVar;
    }

    public final a0<T> timeout(long j, TimeUnit timeUnit, z zVar, g0<? extends T> g0Var) {
        b.e(g0Var, "other is null");
        return timeout0(j, timeUnit, zVar, g0Var);
    }

    public static <T> h<T> concat(m.c.a<? extends g0<? extends T>> aVar) {
        return a0.concat(aVar, 2);
    }

    public static <T> a0<T> fromFuture(Future<? extends T> future, z zVar) {
        return a0.toSingle(h.z(future, zVar));
    }

    public static <T> a0<T> merge(g0<? extends g0<? extends T>> g0Var) {
        b.e(g0Var, "source is null");
        return a.o(new x(g0Var, a.i()));
    }

    public static <T> h<T> mergeDelayError(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        i.b.g0[] arr = new g0[2];
        return a0.mergeDelayError(h.v(g0Var, g0Var2));
    }

    public static <T1, T2, R> a0<R> zip(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, i.b.l0.c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        i.b.g0[] arr = new g0[2];
        return a0.zipArray(a.v(cVar), g0Var, g0Var2);
    }

    public final a0<T> delay(long j, TimeUnit timeUnit, z zVar, boolean z) {
        b.e(timeUnit, "unit is null");
        b.e(zVar, "scheduler is null");
        f fVar = new f(this, j, timeUnit, timeUnit, zVar, z);
        return a.o(fVar);
    }

    public final a0<T> retry(long j, i.b.l0.o<? super Throwable> oVar) {
        return a0.toSingle(toFlowable().T(j, oVar));
    }

    public static <T> h<T> concat(m.c.a<? extends g0<? extends T>> aVar, int i) {
        b.e(aVar, "sources is null");
        b.f(i, "prefetch");
        return a.l(new d(aVar, h0.b(), i, j.IMMEDIATE));
    }

    public final <U> a0<T> delaySubscription(w<U> wVar) {
        b.e(wVar, "other is null");
        return a.o(new h(this, wVar));
    }

    public final a0<T> retry(i.b.l0.o<? super Throwable> oVar) {
        return a0.toSingle(toFlowable().V(oVar));
    }

    public final i.b.j0.b subscribe(i.b.l0.f<? super T> fVar) {
        return subscribe(fVar, a.e);
    }

    public final <E> a0<T> takeUntil(g0<? extends E> g0Var) {
        b.e(g0Var, "other is null");
        return takeUntil(new u0(g0Var));
    }

    public final a0<T> timeout(long j, TimeUnit timeUnit, g0<? extends T> g0Var) {
        b.e(g0Var, "other is null");
        return this.timeout0(j, timeUnit, a.a(), g0Var);
    }

    public static <T> h<T> merge(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        i.b.g0[] arr = new g0[2];
        return a0.merge(h.v(g0Var, g0Var2));
    }

    public final i.b.j0.b subscribe(i.b.l0.f<? super T> fVar, i.b.l0.f<? super Throwable> fVar2) {
        b.e(fVar, "onSuccess is null");
        b.e(fVar2, "onError is null");
        i.b.m0.d.k kVar = new k(fVar, fVar2);
        subscribe(kVar);
        return kVar;
    }

    public static <T> h<T> mergeDelayError(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        i.b.g0[] arr = new g0[3];
        return a0.mergeDelayError(h.v(g0Var, g0Var2, g0Var3));
    }

    public static <T1, T2, T3, R> a0<R> zip(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, i.b.l0.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        i.b.g0[] arr = new g0[3];
        return a0.zipArray(a.w(gVar), g0Var, g0Var2, g0Var3);
    }

    public final <U> a0<T> delaySubscription(m.c.a<U> aVar) {
        b.e(aVar, "other is null");
        return a.o(new i(this, aVar));
    }

    public static <T> h<T> concat(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        i.b.g0[] arr = new g0[2];
        return a0.concat(h.v(g0Var, g0Var2));
    }

    public static <T> h<T> merge(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        i.b.g0[] arr = new g0[3];
        return a0.merge(h.v(g0Var, g0Var2, g0Var3));
    }

    public final a0<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, a.a());
    }

    public final a0<T> delaySubscription(long j, TimeUnit timeUnit, z zVar) {
        return delaySubscription(r.timer(j, timeUnit, zVar));
    }

    public final void subscribe(d0<? super T> d0Var) {
        b.e(d0Var, "observer is null");
        final i.b.d0 d0Var2 = a.A(this, d0Var);
        b.e(d0Var2, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(d0Var2);
        } catch (java.lang.NullPointerException npe) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) npe;
        } finally {
            a.b(npe);
            java.lang.NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(npe);
            throw nullPointerException;
        }
    }

    public static <T> h<T> concat(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        i.b.g0[] arr = new g0[3];
        return a0.concat(h.v(g0Var, g0Var2, g0Var3));
    }

    public static <T> h<T> mergeDelayError(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3, g0<? extends T> g0Var4) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        b.e(g0Var4, "source4 is null");
        i.b.g0[] arr = new g0[4];
        return a0.mergeDelayError(h.v(g0Var, g0Var2, g0Var3, g0Var4));
    }

    public static <T1, T2, T3, T4, R> a0<R> zip(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, i.b.l0.h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        b.e(g0Var4, "source4 is null");
        i.b.g0[] arr = new g0[4];
        return a0.zipArray(a.x(hVar), g0Var, g0Var2, g0Var3, g0Var4);
    }

    public static <T> h<T> merge(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3, g0<? extends T> g0Var4) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        b.e(g0Var4, "source4 is null");
        i.b.g0[] arr = new g0[4];
        return a0.merge(h.v(g0Var, g0Var2, g0Var3, g0Var4));
    }

    public static <T> h<T> concat(g0<? extends T> g0Var, g0<? extends T> g0Var2, g0<? extends T> g0Var3, g0<? extends T> g0Var4) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        b.e(g0Var4, "source4 is null");
        i.b.g0[] arr = new g0[4];
        return a0.concat(h.v(g0Var, g0Var2, g0Var3, g0Var4));
    }

    public static <T1, T2, T3, T4, T5, R> a0<R> zip(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, i.b.l0.i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> iVar) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        b.e(g0Var4, "source4 is null");
        b.e(g0Var5, "source5 is null");
        i.b.g0[] arr = new g0[5];
        return a0.zipArray(a.y(iVar), g0Var, g0Var2, g0Var3, g0Var4, g0Var5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> a0<R> zip(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, i.b.l0.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> jVar) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        b.e(g0Var4, "source4 is null");
        b.e(g0Var5, "source5 is null");
        b.e(g0Var6, "source6 is null");
        i.b.g0[] arr = new g0[6];
        return a0.zipArray(a.z(jVar), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> a0<R> zip(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, i.b.l0.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> kVar) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        b.e(g0Var4, "source4 is null");
        b.e(g0Var5, "source5 is null");
        b.e(g0Var6, "source6 is null");
        b.e(g0Var7, "source7 is null");
        i.b.g0[] arr = new g0[7];
        return a0.zipArray(a.A(kVar), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> a0<R> zip(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g0<? extends T8> g0Var8, i.b.l0.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> lVar) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        b.e(g0Var4, "source4 is null");
        b.e(g0Var5, "source5 is null");
        b.e(g0Var6, "source6 is null");
        b.e(g0Var7, "source7 is null");
        b.e(g0Var8, "source8 is null");
        i.b.g0[] arr = new g0[8];
        return a0.zipArray(a.B(lVar), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a0<R> zip(g0<? extends T1> g0Var, g0<? extends T2> g0Var2, g0<? extends T3> g0Var3, g0<? extends T4> g0Var4, g0<? extends T5> g0Var5, g0<? extends T6> g0Var6, g0<? extends T7> g0Var7, g0<? extends T8> g0Var8, g0<? extends T9> g0Var9, i.b.l0.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> mVar) {
        b.e(g0Var, "source1 is null");
        b.e(g0Var2, "source2 is null");
        b.e(g0Var3, "source3 is null");
        b.e(g0Var4, "source4 is null");
        b.e(g0Var5, "source5 is null");
        b.e(g0Var6, "source6 is null");
        b.e(g0Var7, "source7 is null");
        b.e(g0Var8, "source8 is null");
        b.e(g0Var9, "source9 is null");
        i.b.g0[] arr = new g0[9];
        return a0.zipArray(a.C(mVar), g0Var, g0Var2, g0Var3, g0Var4, g0Var5, g0Var6, g0Var7, g0Var8, g0Var9);
    }

    protected abstract void subscribeActual(d0<? super T> d0Var);
}
