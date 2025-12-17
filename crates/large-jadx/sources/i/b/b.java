package i.b;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.l0.n;
import i.b.l0.o;
import i.b.m0.b.a;
import i.b.m0.b.b;
import i.b.m0.c.c;
import i.b.m0.d.h;
import i.b.m0.d.j;
import i.b.m0.d.n;
import i.b.m0.e.a.a;
import i.b.m0.e.a.b;
import i.b.m0.e.a.c;
import i.b.m0.e.a.d;
import i.b.m0.e.a.e;
import i.b.m0.e.a.f;
import i.b.m0.e.a.g;
import i.b.m0.e.a.i;
import i.b.m0.e.a.j;
import i.b.m0.e.a.k;
import i.b.m0.e.a.l;
import i.b.m0.e.a.m;
import i.b.m0.e.a.n;
import i.b.m0.e.a.o;
import i.b.m0.e.a.q;
import i.b.m0.e.c.j;
import i.b.m0.e.f.g;
import i.b.p0.a;
import i.b.s0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class b implements i.b.f {
    private static java.lang.NullPointerException A(Throwable throwable) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(throwable);
        return nullPointerException;
    }

    public static i.b.b C(i.b.f f) {
        b.e(f, "source is null");
        if (f instanceof b) {
            return a.k((b)f);
        }
        i iVar = new i(f);
        return a.k(iVar);
    }

    public static i.b.b f() {
        return a.k(d.a);
    }

    public static i.b.b g(i.b.e e) {
        b.e(e, "source is null");
        b bVar = new b(e);
        return a.k(bVar);
    }

    private i.b.b l(f<? super b> f, f<? super Throwable> f2, a a3, a a4, a a5, a a6) {
        b.e(f, "onSubscribe is null");
        b.e(f2, "onError is null");
        b.e(a3, "onComplete is null");
        b.e(a4, "onTerminate is null");
        b.e(a5, "onAfterTerminate is null");
        b.e(a6, "onDispose is null");
        super(this, f, f2, a3, a4, a5, a6);
        return a.k(mVar);
    }

    public static i.b.b m(Throwable throwable) {
        b.e(throwable, "error is null");
        e eVar = new e(throwable);
        return a.k(eVar);
    }

    public static i.b.b n(a a) {
        b.e(a, "run is null");
        f fVar = new f(a);
        return a.k(fVar);
    }

    public static i.b.b o(Callable<?> callable) {
        b.e(callable, "callable is null");
        g gVar = new g(callable);
        return a.k(gVar);
    }

    public static i.b.b p(i.b.f... fArr) {
        b.e(fArr, "sources is null");
        if (fArr.length == 0) {
            return b.f();
        }
        if (fArr.length == 1) {
            return b.C(fArr[0]);
        }
        j jVar = new j(fArr);
        return a.k(jVar);
    }

    public final <T> i.b.a0<T> B(Callable<? extends T> callable) {
        b.e(callable, "completionValueSupplier is null");
        q qVar = new q(this, callable, 0);
        return a.o(qVar);
    }

    @Override // i.b.f
    public final void b(i.b.d d) {
        b.e(d, "observer is null");
        final i.b.d obj2 = a.x(this, d);
        b.e(obj2, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        x(obj2);
    }

    @Override // i.b.f
    public final i.b.b c(i.b.f f) {
        b.e(f, "next is null");
        a aVar = new a(this, f);
        return a.k(aVar);
    }

    public final <T> i.b.a0<T> d(i.b.g0<T> g0) {
        b.e(g0, "next is null");
        g gVar = new g(g0, this);
        return a.o(gVar);
    }

    @Override // i.b.f
    public final void e() {
        h hVar = new h();
        b(hVar);
        hVar.a();
    }

    @Override // i.b.f
    public final i.b.b h(long l, TimeUnit timeUnit2) {
        return this.i(l, obj2, obj9, a.a());
    }

    @Override // i.b.f
    public final i.b.b i(long l, TimeUnit timeUnit2, i.b.z z3, boolean z4) {
        b.e(z3, "unit is null");
        b.e(z4, "scheduler is null");
        super(this, l, obj4, z3, z4, obj13);
        return a.k(cVar);
    }

    @Override // i.b.f
    public final i.b.b j(a a) {
        final a aVar4 = a.c;
        return this.l(a.g(), a.g(), a, aVar4, aVar4, aVar4);
    }

    public final i.b.b k(f<? super Throwable> f) {
        final a aVar4 = a.c;
        return this.l(a.g(), f, aVar4, aVar4, aVar4, aVar4);
    }

    @Override // i.b.f
    public final i.b.b q(i.b.z z) {
        b.e(z, "scheduler is null");
        k kVar = new k(this, z);
        return a.k(kVar);
    }

    @Override // i.b.f
    public final i.b.b r() {
        return s(a.c());
    }

    public final i.b.b s(o<? super Throwable> o) {
        b.e(o, "predicate is null");
        l lVar = new l(this, o);
        return a.k(lVar);
    }

    public final i.b.b t(n<? super Throwable, ? extends i.b.f> n) {
        b.e(n, "errorMapper is null");
        n nVar = new n(this, n);
        return a.k(nVar);
    }

    @Override // i.b.f
    public final b u() {
        n nVar = new n();
        b(nVar);
        return nVar;
    }

    @Override // i.b.f
    public final b v(a a) {
        b.e(a, "onComplete is null");
        j jVar = new j(a);
        b(jVar);
        return jVar;
    }

    public final b w(a a, f<? super Throwable> f2) {
        b.e(f2, "onError is null");
        b.e(a, "onComplete is null");
        j jVar = new j(f2, a);
        b(jVar);
        return jVar;
    }

    @Override // i.b.f
    protected abstract void x(i.b.d d);

    @Override // i.b.f
    public final i.b.b y(i.b.z z) {
        b.e(z, "scheduler is null");
        o oVar = new o(this, z);
        return a.k(oVar);
    }

    public final <T> i.b.l<T> z() {
        if (this instanceof c) {
            return (c)this.b();
        }
        j jVar = new j(this);
        return a.m(jVar);
    }
}
