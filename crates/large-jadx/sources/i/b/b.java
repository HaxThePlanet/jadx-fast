package i.b;

import i.b.m0.d.h;
import i.b.m0.e.a.d;
import i.b.m0.e.a.e;
import i.b.m0.e.a.i;
import i.b.m0.e.a.k;
import i.b.m0.e.a.l;
import i.b.m0.e.a.m;
import i.b.m0.e.a.q;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: Completable.java */
/* loaded from: classes3.dex */
public abstract class b implements f {
    private static java.lang.NullPointerException A(Throwable th) {
        final java.lang.NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static b C(f fVar) {
        b.e(fVar, "source is null");
        if (fVar instanceof b) {
            return a.k(fVar);
        }
        return a.k(new i(fVar));
    }

    public static b f() {
        return a.k(d.a);
    }

    public static b g(e eVar) {
        b.e(eVar, "source is null");
        return a.k(new b(eVar));
    }

    private b l(i.b.l0.f<? super i.b.j0.b> fVar, i.b.l0.f<? super Throwable> fVar2, i.b.l0.a aVar, i.b.l0.a aVar2, i.b.l0.a aVar3, i.b.l0.a aVar4) {
        b.e(fVar, "onSubscribe is null");
        b.e(fVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(aVar2, "onTerminate is null");
        b.e(aVar3, "onAfterTerminate is null");
        b.e(aVar4, "onDispose is null");
        m mVar = new m(this, fVar, fVar2, aVar, aVar2, aVar3, aVar4);
        return a.k(mVar);
    }

    public static b m(Throwable th) {
        b.e(th, "error is null");
        return a.k(new e(th));
    }

    public static b n(i.b.l0.a aVar) {
        b.e(aVar, "run is null");
        return a.k(new f(aVar));
    }

    public static b o(Callable<?> callable) {
        b.e(callable, "callable is null");
        return a.k(new g(callable));
    }

    public static b p(f... fVarArr) {
        b.e(fVarArr, "sources is null");
        if (fVarArr.length == 0) {
            return b.f();
        }
        if (fVarArr.length == 1) {
            return b.C(fVarArr[0]);
        }
        return a.k(new j(fVarArr));
    }

    public final <T> a0<T> B(Callable<? extends T> callable) {
        b.e(callable, "completionValueSupplier is null");
        return a.o(new q(this, callable, null));
    }

    public final void b(d dVar) {
        b.e(dVar, "observer is null");
        try {
            final i.b.d dVar2 = a.x(this, dVar);
            b.e(dVar2, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            x(dVar2);
        } catch (java.lang.NullPointerException npe) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) npe;
        } finally {
            a.b(npe);
            a.t(npe);
            npe = b.A(npe);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) npe;
        }
    }

    public final b c(f fVar) {
        b.e(fVar, "next is null");
        return a.k(new a(this, fVar));
    }

    public final <T> a0<T> d(g0<T> g0Var) {
        b.e(g0Var, "next is null");
        return a.o(new g(g0Var, this));
    }

    public final void e() {
        final h hVar = new h();
        b(hVar);
        hVar.a();
    }

    public final b h(long j, TimeUnit timeUnit) {
        return this.i(j, timeUnit, a.a(), false);
    }

    public final b i(long j, TimeUnit timeUnit, z zVar, boolean z) {
        b.e(timeUnit, "unit is null");
        b.e(zVar, "scheduler is null");
        c cVar = new c(this, j, timeUnit, timeUnit, zVar, z);
        return a.k(cVar);
    }

    public final b j(i.b.l0.a aVar) {
        final i.b.l0.a aVar3 = a.c;
        return this.l(a.g(), a.g(), aVar, aVar3, aVar3, aVar3);
    }

    public final b k(i.b.l0.f<? super Throwable> fVar) {
        final i.b.l0.a aVar = a.c;
        return this.l(a.g(), fVar, aVar, aVar, aVar, aVar);
    }

    public final b q(z zVar) {
        b.e(zVar, "scheduler is null");
        return a.k(new k(this, zVar));
    }

    public final b r() {
        return s(a.c());
    }

    public final b s(i.b.l0.o<? super Throwable> oVar) {
        b.e(oVar, "predicate is null");
        return a.k(new l(this, oVar));
    }

    public final b t(i.b.l0.n<? super Throwable, ? extends f> nVar) {
        b.e(nVar, "errorMapper is null");
        return a.k(new n(this, nVar));
    }

    public final i.b.j0.b u() {
        final i.b.m0.d.n nVar = new n();
        b(nVar);
        return nVar;
    }

    public final i.b.j0.b v(i.b.l0.a aVar) {
        b.e(aVar, "onComplete is null");
        i.b.m0.d.j jVar = new j(aVar);
        b(jVar);
        return jVar;
    }

    public final i.b.j0.b w(i.b.l0.a aVar, i.b.l0.f<? super Throwable> fVar) {
        b.e(fVar, "onError is null");
        b.e(aVar, "onComplete is null");
        i.b.m0.d.j jVar = new j(fVar, aVar);
        b(jVar);
        return jVar;
    }

    public final b y(z zVar) {
        b.e(zVar, "scheduler is null");
        return a.k(new o(this, zVar));
    }

    public final <T> l<T> z() {
        if (this instanceof c) {
            return (c)this.b();
        }
        return a.m(new j(this));
    }

    protected abstract void x(d dVar);
}
