package i.b;

import i.b.l0.f;
import i.b.m0.e.c.d;
import i.b.m0.e.c.e;
import i.b.m0.e.c.g;
import i.b.m0.e.c.i;
import i.b.m0.e.c.m;
import i.b.m0.e.c.p;
import i.b.m0.e.c.q;
import i.b.m0.e.c.r;
import i.b.m0.e.c.s;
import i.b.m0.e.c.t;
import i.b.m0.e.c.u;
import i.b.m0.e.c.w;
import java.util.concurrent.Callable;

/* compiled from: Maybe.java */
/* loaded from: classes3.dex */
public abstract class l<T> implements p<T> {
    public static <T1, T2, R> l<R> B(p<? extends T1> pVar, p<? extends T2> pVar2, i.b.l0.c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(pVar, "source1 is null");
        b.e(pVar2, "source2 is null");
        i.b.p[] arr = new p[2];
        return l.C(a.v(cVar), pVar, pVar2);
    }

    public static <T, R> l<R> C(i.b.l0.n<? super Object[], ? extends R> nVar, p<? extends T>... pVarArr) {
        b.e(pVarArr, "sources is null");
        if (pVarArr.length == 0) {
            return l.i();
        }
        b.e(nVar, "zipper is null");
        return a.m(new w(pVarArr, nVar));
    }

    public static <T> l<T> e(o<T> oVar) {
        b.e(oVar, "onSubscribe is null");
        return a.m(new c(oVar));
    }

    public static <T> l<T> i() {
        return a.m(d.a);
    }

    public static <T> l<T> n(Callable<? extends T> callable) {
        b.e(callable, "callable is null");
        return a.m(new i(callable));
    }

    public static <T> l<T> p(T t) {
        b.e(t, "item is null");
        return a.m(new n(t));
    }

    public final h<T> A() {
        if (this instanceof b) {
            return (b)this.c();
        }
        return a.l(new u(this));
    }

    public final void b(n<? super T> nVar) {
        b.e(nVar, "observer is null");
        final i.b.n nVar2 = a.y(this, nVar);
        b.e(nVar2, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            w(nVar2);
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

    public final T d() {
        i.b.m0.d.h hVar = new h();
        b(hVar);
        return hVar.a();
    }

    public final l<T> f(T t) {
        b.e(t, "defaultItem is null");
        return z(l.p(t));
    }

    public final l<T> g(f<? super Throwable> fVar) {
        b.e(fVar, "onError is null");
        final i.b.l0.a aVar = a.c;
        r rVar = new r(this, a.g(), a.g(), (f)fVar, aVar, aVar, aVar);
        return a.m(rVar);
    }

    public final l<T> h(f<? super T> fVar) {
        b.e(fVar, "onSuccess is null");
        final i.b.l0.a aVar = a.c;
        r rVar = new r(this, a.g(), (f)fVar, a.g(), aVar, aVar, aVar);
        return a.m(rVar);
    }

    public final l<T> j(i.b.l0.o<? super T> oVar) {
        b.e(oVar, "predicate is null");
        return a.m(new e(this, oVar));
    }

    public final <R> l<R> k(i.b.l0.n<? super T, ? extends p<? extends R>> nVar) {
        b.e(nVar, "mapper is null");
        return a.m(new h(this, nVar));
    }

    public final b l(i.b.l0.n<? super T, ? extends f> nVar) {
        b.e(nVar, "mapper is null");
        return a.k(new g(this, nVar));
    }

    public final <R> r<R> m(i.b.l0.n<? super T, ? extends w<? extends R>> nVar) {
        b.e(nVar, "mapper is null");
        return a.n(new b(this, nVar));
    }

    public final a0<Boolean> o() {
        return a.o(new m(this));
    }

    public final <R> l<R> q(i.b.l0.n<? super T, ? extends R> nVar) {
        b.e(nVar, "mapper is null");
        return a.m(new o(this, nVar));
    }

    public final l<T> r(z zVar) {
        b.e(zVar, "scheduler is null");
        return a.m(new p(this, zVar));
    }

    public final l<T> s(p<? extends T> pVar) {
        b.e(pVar, "next is null");
        return t(a.l(pVar));
    }

    public final l<T> t(i.b.l0.n<? super Throwable, ? extends p<? extends T>> nVar) {
        b.e(nVar, "resumeFunction is null");
        return a.m(new q(this, nVar, true));
    }

    public final i.b.j0.b u() {
        return v(a.g(), a.e, a.c);
    }

    public final i.b.j0.b v(f<? super T> fVar, f<? super Throwable> fVar2, i.b.l0.a aVar) {
        b.e(fVar, "onSuccess is null");
        b.e(fVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        i.b.m0.e.c.b bVar = new b(fVar, fVar2, aVar);
        y(bVar);
        return bVar;
    }

    public final l<T> x(z zVar) {
        b.e(zVar, "scheduler is null");
        return a.m(new s(this, zVar));
    }

    public final <E extends n<? super T>> E y(E e) {
        b(e);
        return e;
    }

    public final l<T> z(p<? extends T> pVar) {
        b.e(pVar, "other is null");
        return a.m(new t(this, pVar));
    }

    protected abstract void w(n<? super T> nVar);
}
