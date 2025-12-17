package i.b;

import i.b.j0.b;
import i.b.k0.a;
import i.b.l0.a;
import i.b.l0.d;
import i.b.l0.e;
import i.b.l0.f;
import i.b.l0.n;
import i.b.l0.o;
import i.b.m0.b.a;
import i.b.m0.b.b;
import i.b.m0.c.h;
import i.b.m0.e.b.a0;
import i.b.m0.e.b.b;
import i.b.m0.e.b.b0;
import i.b.m0.e.b.c;
import i.b.m0.e.b.c0;
import i.b.m0.e.b.d0;
import i.b.m0.e.b.e;
import i.b.m0.e.b.e0;
import i.b.m0.e.b.f;
import i.b.m0.e.b.f0;
import i.b.m0.e.b.g0;
import i.b.m0.e.b.h;
import i.b.m0.e.b.h0;
import i.b.m0.e.b.i;
import i.b.m0.e.b.i0;
import i.b.m0.e.b.j;
import i.b.m0.e.b.k;
import i.b.m0.e.b.l;
import i.b.m0.e.b.l0;
import i.b.m0.e.b.n;
import i.b.m0.e.b.n0;
import i.b.m0.e.b.o;
import i.b.m0.e.b.p;
import i.b.m0.e.b.q;
import i.b.m0.e.b.s;
import i.b.m0.e.b.t;
import i.b.m0.e.b.u;
import i.b.m0.e.b.v;
import i.b.m0.e.b.w;
import i.b.m0.e.b.x;
import i.b.m0.e.b.y;
import i.b.m0.h.e;
import i.b.m0.h.f;
import i.b.m0.j.j;
import i.b.p0.a;
import io.reactivex.exceptions.a;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public abstract class h<T>  implements a<T> {

    static final int a;
    static {
        h.a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
    }

    public static <T> i.b.h<T> A(Iterable<? extends T> iterable) {
        b.e(iterable, "source is null");
        q qVar = new q(iterable);
        return a.l(qVar);
    }

    public static <T> i.b.h<T> B(a<? extends T> a) {
        if (a instanceof h) {
            return a.l((h)a);
        }
        b.e(a, "source is null");
        s sVar = new s(a);
        return a.l(sVar);
    }

    public static <T> i.b.h<T> C(T t) {
        b.e(t, "item is null");
        u uVar = new u(t);
        return a.l(uVar);
    }

    public static <T> i.b.h<T> E(a<? extends T> a, a<? extends T> a2, a<? extends T> a3) {
        b.e(a, "source1 is null");
        b.e(a2, "source2 is null");
        b.e(a3, "source3 is null");
        int i = 3;
        final a[] arr = new a[i];
        final int i2 = 0;
        arr[i2] = a;
        arr[1] = a2;
        arr[2] = a3;
        return h.v(arr).p(a.i(), i2, i);
    }

    public static int b() {
        return h.a;
    }

    public static <T> i.b.h<T> h(i.b.j<T> j, i.b.a a2) {
        b.e(j, "source is null");
        b.e(a2, "mode is null");
        e eVar = new e(j, a2);
        return a.l(eVar);
    }

    private i.b.h<T> i(f<? super T> f, f<? super Throwable> f2, a a3, a a4) {
        b.e(f, "onNext is null");
        b.e(f2, "onError is null");
        b.e(a3, "onComplete is null");
        b.e(a4, "onAfterTerminate is null");
        super(this, f, f2, a3, a4);
        return a.l(fVar);
    }

    public static <T> i.b.h<T> l() {
        return a.l(i.b);
    }

    public static <T> i.b.h<T> v(T... tArr) {
        b.e(tArr, "items is null");
        if (tArr.length == 0) {
            return h.l();
        }
        if (tArr.length == 1) {
            return h.C(tArr[0]);
        }
        o oVar = new o(tArr);
        return a.l(oVar);
    }

    public static <T> i.b.h<T> w(Future<? extends T> future) {
        b.e(future, "future is null");
        p pVar = new p(future, 0, obj2, 0);
        return a.l(pVar);
    }

    public static <T> i.b.h<T> x(Future<? extends T> future, long l2, TimeUnit timeUnit3) {
        b.e(future, "future is null");
        b.e(obj4, "unit is null");
        p pVar = new p(future, l2, timeUnit3, obj4);
        return a.l(pVar);
    }

    public static <T> i.b.h<T> y(Future<? extends T> future, long l2, TimeUnit timeUnit3, i.b.z z4) {
        b.e(obj5, "scheduler is null");
        return h.x(future, l2, timeUnit3).d0(obj5);
    }

    public static <T> i.b.h<T> z(Future<? extends T> future, i.b.z z2) {
        b.e(z2, "scheduler is null");
        return h.w(future).d0(z2);
    }

    public final <R> i.b.h<R> D(n<? super T, ? extends R> n) {
        b.e(n, "mapper is null");
        v vVar = new v(this, n);
        return a.l(vVar);
    }

    public final i.b.h<T> F(i.b.z z) {
        return G(z, false, h.b());
    }

    public final i.b.h<T> G(i.b.z z, boolean z2, int i3) {
        b.e(z, "scheduler is null");
        b.f(i3, "bufferSize");
        w wVar = new w(this, z, z2, i3);
        return a.l(wVar);
    }

    public final i.b.h<T> H() {
        return I(h.b(), false, true);
    }

    public final i.b.h<T> I(int i, boolean z2, boolean z3) {
        b.f(i, "capacity");
        super(this, i, z3, z2, a.c);
        return a.l(xVar);
    }

    public final i.b.h<T> J() {
        y yVar = new y(this);
        return a.l(yVar);
    }

    public final i.b.h<T> K() {
        a0 a0Var = new a0(this);
        return a.l(a0Var);
    }

    public final a<T> L() {
        return M(h.b());
    }

    public final a<T> M(int i) {
        b.f(i, "bufferSize");
        return b0.i0(this, i);
    }

    public final i.b.h<T> N() {
        return O(Long.MAX_VALUE);
    }

    public final i.b.h<T> O(long l) {
        int cmp = Long.compare(l, i);
        if (cmp < 0) {
        } else {
            if (cmp == 0) {
                return h.l();
            }
            c0 c0Var = new c0(this, l, obj5);
            return a.l(c0Var);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("times >= 0 required but it was ");
        stringBuilder.append(l);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public final i.b.h<T> P(e e) {
        b.e(e, "stop is null");
        d0 d0Var = new d0(this, e);
        return a.l(d0Var);
    }

    public final i.b.h<T> Q(n<? super i.b.h<Object>, ? extends a<?>> n) {
        b.e(n, "handler is null");
        e0 e0Var = new e0(this, n);
        return a.l(e0Var);
    }

    public final i.b.h<T> R() {
        return T(Long.MAX_VALUE, obj2);
    }

    public final i.b.h<T> S(long l) {
        return T(l, obj3);
    }

    public final i.b.h<T> T(long l, o<? super Throwable> o2) {
        if (Long.compare(l, i) < 0) {
        } else {
            b.e(obj5, "predicate is null");
            g0 g0Var = new g0(this, l, o2, obj5);
            return a.l(g0Var);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("times >= 0 required but it was ");
        stringBuilder.append(l);
        IllegalArgumentException obj5 = new IllegalArgumentException(stringBuilder.toString());
        throw obj5;
    }

    public final i.b.h<T> U(d<? super Integer, ? super Throwable> d) {
        b.e(d, "predicate is null");
        f0 f0Var = new f0(this, d);
        return a.l(f0Var);
    }

    public final i.b.h<T> V(o<? super Throwable> o) {
        return T(Long.MAX_VALUE, obj1);
    }

    public final i.b.h<T> W(n<? super i.b.h<Throwable>, ? extends a<?>> n) {
        b.e(n, "handler is null");
        h0 h0Var = new h0(this, n);
        return a.l(h0Var);
    }

    public final i.b.h<T> X(Comparator<? super T> comparator) {
        b.e(comparator, "sortFunction");
        return f0().toFlowable().D(a.m(comparator)).r(a.i());
    }

    public final b Y(f<? super T> f) {
        return a0(f, a.e, a.c, t.INSTANCE);
    }

    public final b Z(f<? super T> f, f<? super Throwable> f2, a a3) {
        return a0(f, f2, a3, t.INSTANCE);
    }

    public final void a(b<? super T> b) {
        boolean fVar;
        if (b instanceof k) {
            b0((k)b);
        } else {
            b.e(b, "s is null");
            fVar = new f(b);
            b0(fVar);
        }
    }

    public final b a0(f<? super T> f, f<? super Throwable> f2, a a3, f<? super c> f4) {
        b.e(f, "onNext is null");
        b.e(f2, "onError is null");
        b.e(a3, "onComplete is null");
        b.e(f4, "onSubscribe is null");
        e eVar = new e(f, f2, a3, f4);
        b0(eVar);
        return eVar;
    }

    public final void b0(i.b.k<? super T> k) {
        b.e(k, "s is null");
        final b obj3 = a.B(this, k);
        b.e(obj3, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        c0(obj3);
    }

    protected abstract void c0(b<? super T> b);

    public final <R> i.b.h<R> d(n<? super T, ? extends a<? extends R>> n) {
        return e(n, 2);
    }

    public final i.b.h<T> d0(i.b.z z) {
        b.e(z, "scheduler is null");
        return e0(z, z2 ^= 1);
    }

    public final <R> i.b.h<R> e(n<? super T, ? extends a<? extends R>> n, int i2) {
        b.e(n, "mapper is null");
        b.f(i2, "prefetch");
        Object obj4 = (h)this.call();
        if (this instanceof h && obj4 == null) {
            obj4 = (h)this.call();
            if (obj4 == null) {
                return h.l();
            }
            return i0.a(obj4, n);
        }
        b bVar = new b(this, n, i2, j.IMMEDIATE);
        return a.l(bVar);
    }

    public final i.b.h<T> e0(i.b.z z, boolean z2) {
        b.e(z, "scheduler is null");
        l0 l0Var = new l0(this, z, z2);
        return a.l(l0Var);
    }

    public final <R> i.b.h<R> f(n<? super T, ? extends a<? extends R>> n) {
        return g(n, h.b(), h.b());
    }

    public final i.b.a0<List<T>> f0() {
        n0 n0Var = new n0(this);
        return a.o(n0Var);
    }

    public final <R> i.b.h<R> g(n<? super T, ? extends a<? extends R>> n, int i2, int i3) {
        b.e(n, "mapper is null");
        b.f(i2, "maxConcurrency");
        b.f(i3, "prefetch");
        super(this, n, i2, i3, j.IMMEDIATE);
        return a.l(cVar);
    }

    public final i.b.h<T> j(f<? super T> f) {
        final a aVar = a.c;
        return i(f, a.g(), aVar, aVar);
    }

    public final i.b.l<T> k(long l) {
        if (Long.compare(l, i) < 0) {
        } else {
            h hVar = new h(this, l, obj5);
            return a.m(hVar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
        throw indexOutOfBoundsException;
    }

    public final i.b.h<T> m(o<? super T> o) {
        b.e(o, "predicate is null");
        j jVar = new j(this, o);
        return a.l(jVar);
    }

    public final i.b.l<T> n() {
        return k(0);
    }

    public final <R> i.b.h<R> o(n<? super T, ? extends a<? extends R>> n) {
        return q(n, false, h.b(), h.b());
    }

    public final <R> i.b.h<R> p(n<? super T, ? extends a<? extends R>> n, boolean z2, int i3) {
        return q(n, z2, i3, h.b());
    }

    public final <R> i.b.h<R> q(n<? super T, ? extends a<? extends R>> n, boolean z2, int i3, int i4) {
        b.e(n, "mapper is null");
        b.f(i3, "maxConcurrency");
        b.f(i4, "bufferSize");
        Object obj9 = (h)this.call();
        if (this instanceof h && obj9 == null) {
            obj9 = (h)this.call();
            if (obj9 == null) {
                return h.l();
            }
            return i0.a(obj9, n);
        }
        super(this, n, z2, i3, i4);
        return a.l(kVar2);
    }

    public final <U> i.b.h<U> r(n<? super T, ? extends Iterable<? extends U>> n) {
        return s(n, h.b());
    }

    public final <U> i.b.h<U> s(n<? super T, ? extends Iterable<? extends U>> n, int i2) {
        b.e(n, "mapper is null");
        b.f(i2, "bufferSize");
        n nVar = new n(this, n, i2);
        return a.l(nVar);
    }

    public final <R> i.b.h<R> t(n<? super T, ? extends i.b.p<? extends R>> n) {
        return u(n, false, Integer.MAX_VALUE);
    }

    public final <R> i.b.h<R> u(n<? super T, ? extends i.b.p<? extends R>> n, boolean z2, int i3) {
        b.e(n, "mapper is null");
        b.f(i3, "maxConcurrency");
        l lVar = new l(this, n, z2, i3);
        return a.l(lVar);
    }
}
