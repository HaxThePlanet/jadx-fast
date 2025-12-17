package i.b;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.c;
import i.b.l0.f;
import i.b.l0.n;
import i.b.l0.o;
import i.b.m0.b.a;
import i.b.m0.b.b;
import i.b.m0.c.b;
import i.b.m0.d.h;
import i.b.m0.e.c.b;
import i.b.m0.e.c.c;
import i.b.m0.e.c.d;
import i.b.m0.e.c.e;
import i.b.m0.e.c.g;
import i.b.m0.e.c.h;
import i.b.m0.e.c.i;
import i.b.m0.e.c.m;
import i.b.m0.e.c.n;
import i.b.m0.e.c.o;
import i.b.m0.e.c.p;
import i.b.m0.e.c.q;
import i.b.m0.e.c.r;
import i.b.m0.e.c.s;
import i.b.m0.e.c.t;
import i.b.m0.e.c.u;
import i.b.m0.e.c.w;
import i.b.m0.e.d.b;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public abstract class l<T>  implements i.b.p<T> {
    public static <T1, T2, R> i.b.l<R> B(i.b.p<? extends T1> p, i.b.p<? extends T2> p2, c<? super T1, ? super T2, ? extends R> c3) {
        b.e(p, "source1 is null");
        b.e(p2, "source2 is null");
        i.b.p[] arr = new p[2];
        return l.C(a.v(c3), p, p2);
    }

    public static <T, R> i.b.l<R> C(n<? super Object[], ? extends R> n, i.b.p<? extends T>... p2Arr2) {
        b.e(p2Arr2, "sources is null");
        if (p2Arr2.length == 0) {
            return l.i();
        }
        b.e(n, "zipper is null");
        w wVar = new w(p2Arr2, n);
        return a.m(wVar);
    }

    public static <T> i.b.l<T> e(i.b.o<T> o) {
        b.e(o, "onSubscribe is null");
        c cVar = new c(o);
        return a.m(cVar);
    }

    public static <T> i.b.l<T> i() {
        return a.m(d.a);
    }

    public static <T> i.b.l<T> n(Callable<? extends T> callable) {
        b.e(callable, "callable is null");
        i iVar = new i(callable);
        return a.m(iVar);
    }

    public static <T> i.b.l<T> p(T t) {
        b.e(t, "item is null");
        n nVar = new n(t);
        return a.m(nVar);
    }

    public final i.b.h<T> A() {
        if (this instanceof b) {
            return (b)this.c();
        }
        u uVar = new u(this);
        return a.l(uVar);
    }

    public final void b(i.b.n<? super T> n) {
        b.e(n, "observer is null");
        final i.b.n obj3 = a.y(this, n);
        b.e(obj3, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        w(obj3);
    }

    public final T d() {
        h hVar = new h();
        b(hVar);
        return hVar.a();
    }

    public final i.b.l<T> f(T t) {
        b.e(t, "defaultItem is null");
        return z(l.p(t));
    }

    public final i.b.l<T> g(f<? super Throwable> f) {
        b.e(f, "onError is null");
        final a aVar3 = a.c;
        super(this, a.g(), a.g(), (f)f, aVar3, aVar3, aVar3);
        return a.m(rVar2);
    }

    public final i.b.l<T> h(f<? super T> f) {
        b.e(f, "onSuccess is null");
        final a aVar3 = a.c;
        super(this, a.g(), (f)f, a.g(), aVar3, aVar3, aVar3);
        return a.m(rVar2);
    }

    public final i.b.l<T> j(o<? super T> o) {
        b.e(o, "predicate is null");
        e eVar = new e(this, o);
        return a.m(eVar);
    }

    public final <R> i.b.l<R> k(n<? super T, ? extends i.b.p<? extends R>> n) {
        b.e(n, "mapper is null");
        h hVar = new h(this, n);
        return a.m(hVar);
    }

    public final i.b.b l(n<? super T, ? extends i.b.f> n) {
        b.e(n, "mapper is null");
        g gVar = new g(this, n);
        return a.k(gVar);
    }

    public final <R> i.b.r<R> m(n<? super T, ? extends i.b.w<? extends R>> n) {
        b.e(n, "mapper is null");
        b bVar = new b(this, n);
        return a.n(bVar);
    }

    public final i.b.a0<Boolean> o() {
        m mVar = new m(this);
        return a.o(mVar);
    }

    public final <R> i.b.l<R> q(n<? super T, ? extends R> n) {
        b.e(n, "mapper is null");
        o oVar = new o(this, n);
        return a.m(oVar);
    }

    public final i.b.l<T> r(i.b.z z) {
        b.e(z, "scheduler is null");
        p pVar = new p(this, z);
        return a.m(pVar);
    }

    public final i.b.l<T> s(i.b.p<? extends T> p) {
        b.e(p, "next is null");
        return t(a.l(p));
    }

    public final i.b.l<T> t(n<? super Throwable, ? extends i.b.p<? extends T>> n) {
        b.e(n, "resumeFunction is null");
        q qVar = new q(this, n, 1);
        return a.m(qVar);
    }

    @Override // i.b.p
    public final b u() {
        return v(a.g(), a.e, a.c);
    }

    public final b v(f<? super T> f, f<? super Throwable> f2, a a3) {
        b.e(f, "onSuccess is null");
        b.e(f2, "onError is null");
        b.e(a3, "onComplete is null");
        b bVar = new b(f, f2, a3);
        y(bVar);
        return (b)bVar;
    }

    protected abstract void w(i.b.n<? super T> n);

    public final i.b.l<T> x(i.b.z z) {
        b.e(z, "scheduler is null");
        s sVar = new s(this, z);
        return a.m(sVar);
    }

    public final <E extends i.b.n<? super T>> E y(E e) {
        b(e);
        return e;
    }

    public final i.b.l<T> z(i.b.p<? extends T> p) {
        b.e(p, "other is null");
        t tVar = new t(this, p);
        return a.m(tVar);
    }
}
