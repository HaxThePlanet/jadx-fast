package i.b;

import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.b;
import i.b.l0.c;
import i.b.l0.d;
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
import i.b.m0.b.a;
import i.b.m0.b.b;
import i.b.m0.c.b;
import i.b.m0.c.c;
import i.b.m0.c.d;
import i.b.m0.d.d;
import i.b.m0.d.h;
import i.b.m0.d.k;
import i.b.m0.d.q;
import i.b.m0.e.a.h;
import i.b.m0.e.a.p;
import i.b.m0.e.b.b;
import i.b.m0.e.b.d;
import i.b.m0.e.b.k0;
import i.b.m0.e.b.m;
import i.b.m0.e.c.f;
import i.b.m0.e.c.k;
import i.b.m0.e.d.j;
import i.b.m0.e.e.f3;
import i.b.m0.e.e.u;
import i.b.m0.e.f.a;
import i.b.m0.e.f.a0;
import i.b.m0.e.f.b;
import i.b.m0.e.f.b0;
import i.b.m0.e.f.c;
import i.b.m0.e.f.c0;
import i.b.m0.e.f.d;
import i.b.m0.e.f.d0;
import i.b.m0.e.f.e;
import i.b.m0.e.f.e0;
import i.b.m0.e.f.f;
import i.b.m0.e.f.f0;
import i.b.m0.e.f.g;
import i.b.m0.e.f.g0;
import i.b.m0.e.f.h;
import i.b.m0.e.f.h0;
import i.b.m0.e.f.i;
import i.b.m0.e.f.i0;
import i.b.m0.e.f.j;
import i.b.m0.e.f.j0;
import i.b.m0.e.f.k;
import i.b.m0.e.f.k0;
import i.b.m0.e.f.l;
import i.b.m0.e.f.l0;
import i.b.m0.e.f.m;
import i.b.m0.e.f.m0;
import i.b.m0.e.f.n;
import i.b.m0.e.f.n0;
import i.b.m0.e.f.o;
import i.b.m0.e.f.o0;
import i.b.m0.e.f.p;
import i.b.m0.e.f.p0;
import i.b.m0.e.f.q;
import i.b.m0.e.f.q0;
import i.b.m0.e.f.r;
import i.b.m0.e.f.r0;
import i.b.m0.e.f.s;
import i.b.m0.e.f.s0;
import i.b.m0.e.f.t;
import i.b.m0.e.f.t0;
import i.b.m0.e.f.u;
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
import i.b.m0.j.j;
import i.b.m0.j.k;
import i.b.o0.f;
import i.b.p0.a;
import i.b.s0.a;
import io.reactivex.exceptions.a;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import m.c.a;

/* loaded from: classes3.dex */
public abstract class a0<T>  implements i.b.g0<T> {
    public static <T> i.b.a0<T> amb(Iterable<? extends i.b.g0<? extends T>> iterable) {
        b.e(iterable, "sources is null");
        a aVar = new a(0, iterable);
        return a.o(aVar);
    }

    public static <T> i.b.a0<T> ambArray(i.b.g0<? extends T>... g0Arr) {
        if (g0Arr.length == 0) {
            return a0.error(h0.a());
        }
        if (g0Arr.length == 1) {
            return a0.wrap(g0Arr[0]);
        }
        a aVar = new a(g0Arr, 0);
        return a.o(aVar);
    }

    public static <T> i.b.h<T> concat(i.b.g0<? extends T> g0, i.b.g0<? extends T> g02) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        i.b.g0[] arr = new g0[2];
        return a0.concat(h.v(g0, g02));
    }

    public static <T> i.b.h<T> concat(i.b.g0<? extends T> g0, i.b.g0<? extends T> g02, i.b.g0<? extends T> g03) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        i.b.g0[] arr = new g0[3];
        return a0.concat(h.v(g0, g02, g03));
    }

    public static <T> i.b.h<T> concat(i.b.g0<? extends T> g0, i.b.g0<? extends T> g02, i.b.g0<? extends T> g03, i.b.g0<? extends T> g04) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        b.e(g04, "source4 is null");
        i.b.g0[] arr = new g0[4];
        return a0.concat(h.v(g0, g02, g03, g04));
    }

    public static <T> i.b.h<T> concat(Iterable<? extends i.b.g0<? extends T>> iterable) {
        return a0.concat(h.A(iterable));
    }

    public static <T> i.b.h<T> concat(a<? extends i.b.g0<? extends T>> a) {
        return a0.concat(a, 2);
    }

    public static <T> i.b.h<T> concat(a<? extends i.b.g0<? extends T>> a, int i2) {
        b.e(a, "sources is null");
        b.f(i2, "prefetch");
        d dVar = new d(a, h0.b(), i2, j.IMMEDIATE);
        return a.l(dVar);
    }

    public static <T> i.b.r<T> concat(i.b.w<? extends i.b.g0<? extends T>> w) {
        b.e(w, "sources is null");
        u uVar = new u(w, h0.c(), 2, j.IMMEDIATE);
        return a.n(uVar);
    }

    public static <T> i.b.h<T> concatArray(i.b.g0<? extends T>... g0Arr) {
        b bVar = new b(h.v(g0Arr), h0.b(), 2, j.BOUNDARY);
        return a.l(bVar);
    }

    public static <T> i.b.h<T> concatArrayEager(i.b.g0<? extends T>... g0Arr) {
        return h.v(g0Arr).f(h0.b());
    }

    public static <T> i.b.h<T> concatEager(Iterable<? extends i.b.g0<? extends T>> iterable) {
        return h.A(iterable).f(h0.b());
    }

    public static <T> i.b.h<T> concatEager(a<? extends i.b.g0<? extends T>> a) {
        return h.B(a).f(h0.b());
    }

    public static <T> i.b.a0<T> create(i.b.e0<T> e0) {
        b.e(e0, "source is null");
        d dVar = new d(e0);
        return a.o(dVar);
    }

    public static <T> i.b.a0<T> defer(Callable<? extends i.b.g0<? extends T>> callable) {
        b.e(callable, "singleSupplier is null");
        e eVar = new e(callable);
        return a.o(eVar);
    }

    public static <T> i.b.a0<Boolean> equals(i.b.g0<? extends T> g0, i.b.g0<? extends T> g02) {
        b.e(g0, "first is null");
        b.e(g02, "second is null");
        v vVar = new v(g0, g02);
        return a.o(vVar);
    }

    public static <T> i.b.a0<T> error(Throwable throwable) {
        b.e(throwable, "exception is null");
        return a0.error(a.k(throwable));
    }

    public static <T> i.b.a0<T> error(Callable<? extends Throwable> callable) {
        b.e(callable, "errorSupplier is null");
        w wVar = new w(callable);
        return a.o(wVar);
    }

    public static <T> i.b.a0<T> fromCallable(Callable<? extends T> callable) {
        b.e(callable, "callable is null");
        d0 d0Var = new d0(callable);
        return a.o(d0Var);
    }

    public static <T> i.b.a0<T> fromFuture(Future<? extends T> future) {
        return a0.toSingle(h.w(future));
    }

    public static <T> i.b.a0<T> fromFuture(Future<? extends T> future, long l2, TimeUnit timeUnit3) {
        return a0.toSingle(h.x(future, l2, timeUnit3));
    }

    public static <T> i.b.a0<T> fromFuture(Future<? extends T> future, long l2, TimeUnit timeUnit3, i.b.z z4) {
        return a0.toSingle(h.y(future, l2, timeUnit3, z4));
    }

    public static <T> i.b.a0<T> fromFuture(Future<? extends T> future, i.b.z z2) {
        return a0.toSingle(h.z(future, z2));
    }

    public static <T> i.b.a0<T> fromObservable(i.b.w<? extends T> w) {
        b.e(w, "observableSource is null");
        f3 f3Var = new f3(w, 0);
        return a.o(f3Var);
    }

    public static <T> i.b.a0<T> fromPublisher(a<? extends T> a) {
        b.e(a, "publisher is null");
        e0 e0Var = new e0(a);
        return a.o(e0Var);
    }

    public static <T> i.b.a0<T> just(T t) {
        b.e(t, "item is null");
        i0 i0Var = new i0(t);
        return a.o(i0Var);
    }

    public static <T> i.b.a0<T> merge(i.b.g0<? extends i.b.g0<? extends T>> g0) {
        b.e(g0, "source is null");
        x xVar = new x(g0, a.i());
        return a.o(xVar);
    }

    public static <T> i.b.h<T> merge(i.b.g0<? extends T> g0, i.b.g0<? extends T> g02) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        i.b.g0[] arr = new g0[2];
        return a0.merge(h.v(g0, g02));
    }

    public static <T> i.b.h<T> merge(i.b.g0<? extends T> g0, i.b.g0<? extends T> g02, i.b.g0<? extends T> g03) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        i.b.g0[] arr = new g0[3];
        return a0.merge(h.v(g0, g02, g03));
    }

    public static <T> i.b.h<T> merge(i.b.g0<? extends T> g0, i.b.g0<? extends T> g02, i.b.g0<? extends T> g03, i.b.g0<? extends T> g04) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        b.e(g04, "source4 is null");
        i.b.g0[] arr = new g0[4];
        return a0.merge(h.v(g0, g02, g03, g04));
    }

    public static <T> i.b.h<T> merge(Iterable<? extends i.b.g0<? extends T>> iterable) {
        return a0.merge(h.A(iterable));
    }

    public static <T> i.b.h<T> merge(a<? extends i.b.g0<? extends T>> a) {
        b.e(a, "sources is null");
        super(a, h0.b(), 0, Integer.MAX_VALUE, h.b());
        return a.l(mVar);
    }

    public static <T> i.b.h<T> mergeDelayError(i.b.g0<? extends T> g0, i.b.g0<? extends T> g02) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        i.b.g0[] arr = new g0[2];
        return a0.mergeDelayError(h.v(g0, g02));
    }

    public static <T> i.b.h<T> mergeDelayError(i.b.g0<? extends T> g0, i.b.g0<? extends T> g02, i.b.g0<? extends T> g03) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        i.b.g0[] arr = new g0[3];
        return a0.mergeDelayError(h.v(g0, g02, g03));
    }

    public static <T> i.b.h<T> mergeDelayError(i.b.g0<? extends T> g0, i.b.g0<? extends T> g02, i.b.g0<? extends T> g03, i.b.g0<? extends T> g04) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        b.e(g04, "source4 is null");
        i.b.g0[] arr = new g0[4];
        return a0.mergeDelayError(h.v(g0, g02, g03, g04));
    }

    public static <T> i.b.h<T> mergeDelayError(Iterable<? extends i.b.g0<? extends T>> iterable) {
        return a0.mergeDelayError(h.A(iterable));
    }

    public static <T> i.b.h<T> mergeDelayError(a<? extends i.b.g0<? extends T>> a) {
        b.e(a, "sources is null");
        super(a, h0.b(), 1, Integer.MAX_VALUE, h.b());
        return a.l(mVar);
    }

    public static <T> i.b.a0<T> never() {
        return a.o(m0.a);
    }

    private i.b.a0<T> timeout0(long l, TimeUnit timeUnit2, i.b.z z3, i.b.g0<? extends T> g04) {
        b.e(z3, "unit is null");
        b.e(g04, "scheduler is null");
        super(this, l, obj4, z3, g04, obj13);
        return a.o(s0Var);
    }

    public static i.b.a0<Long> timer(long l, TimeUnit timeUnit2) {
        return a0.timer(l, timeUnit2, obj3);
    }

    public static i.b.a0<Long> timer(long l, TimeUnit timeUnit2, i.b.z z3) {
        b.e(z3, "unit is null");
        b.e(obj4, "scheduler is null");
        t0 t0Var = new t0(l, timeUnit2, z3, obj4);
        return a.o(t0Var);
    }

    private static <T> i.b.a0<T> toSingle(i.b.h<T> h) {
        k0 k0Var = new k0(h, 0);
        return a.o(k0Var);
    }

    public static <T> i.b.a0<T> unsafeCreate(i.b.g0<T> g0) {
        b.e(g0, "onSubscribe is null");
        if (g0 instanceof a0) {
        } else {
            f0 f0Var = new f0(g0);
            return a.o(f0Var);
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        throw obj1;
    }

    public static <T, U> i.b.a0<T> using(Callable<U> callable, n<? super U, ? extends i.b.g0<? extends T>> n2, f<? super U> f3) {
        return a0.using(callable, n2, f3, true);
    }

    public static <T, U> i.b.a0<T> using(Callable<U> callable, n<? super U, ? extends i.b.g0<? extends T>> n2, f<? super U> f3, boolean z4) {
        b.e(callable, "resourceSupplier is null");
        b.e(n2, "singleFunction is null");
        b.e(f3, "disposer is null");
        x0 x0Var = new x0(callable, n2, f3, z4);
        return a.o(x0Var);
    }

    public static <T> i.b.a0<T> wrap(i.b.g0<T> g0) {
        b.e(g0, "source is null");
        if (g0 instanceof a0) {
            return a.o((a0)g0);
        }
        f0 f0Var = new f0(g0);
        return a.o(f0Var);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> i.b.a0<R> zip(i.b.g0<? extends T1> g0, i.b.g0<? extends T2> g02, i.b.g0<? extends T3> g03, i.b.g0<? extends T4> g04, i.b.g0<? extends T5> g05, i.b.g0<? extends T6> g06, i.b.g0<? extends T7> g07, i.b.g0<? extends T8> g08, i.b.g0<? extends T9> g09, m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> m10) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        b.e(g04, "source4 is null");
        b.e(g05, "source5 is null");
        b.e(g06, "source6 is null");
        b.e(g07, "source7 is null");
        b.e(g08, "source8 is null");
        b.e(g09, "source9 is null");
        i.b.g0[] arr = new g0[9];
        return a0.zipArray(a.C(m10), g0, g02, g03, g04, g05, g06, g07, g08, g09);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> i.b.a0<R> zip(i.b.g0<? extends T1> g0, i.b.g0<? extends T2> g02, i.b.g0<? extends T3> g03, i.b.g0<? extends T4> g04, i.b.g0<? extends T5> g05, i.b.g0<? extends T6> g06, i.b.g0<? extends T7> g07, i.b.g0<? extends T8> g08, l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> l9) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        b.e(g04, "source4 is null");
        b.e(g05, "source5 is null");
        b.e(g06, "source6 is null");
        b.e(g07, "source7 is null");
        b.e(g08, "source8 is null");
        i.b.g0[] arr = new g0[8];
        return a0.zipArray(a.B(l9), g0, g02, g03, g04, g05, g06, g07, g08);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> i.b.a0<R> zip(i.b.g0<? extends T1> g0, i.b.g0<? extends T2> g02, i.b.g0<? extends T3> g03, i.b.g0<? extends T4> g04, i.b.g0<? extends T5> g05, i.b.g0<? extends T6> g06, i.b.g0<? extends T7> g07, k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> k8) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        b.e(g04, "source4 is null");
        b.e(g05, "source5 is null");
        b.e(g06, "source6 is null");
        b.e(g07, "source7 is null");
        i.b.g0[] arr = new g0[7];
        return a0.zipArray(a.A(k8), g0, g02, g03, g04, g05, g06, g07);
    }

    public static <T1, T2, T3, T4, T5, T6, R> i.b.a0<R> zip(i.b.g0<? extends T1> g0, i.b.g0<? extends T2> g02, i.b.g0<? extends T3> g03, i.b.g0<? extends T4> g04, i.b.g0<? extends T5> g05, i.b.g0<? extends T6> g06, j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> j7) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        b.e(g04, "source4 is null");
        b.e(g05, "source5 is null");
        b.e(g06, "source6 is null");
        i.b.g0[] arr = new g0[6];
        return a0.zipArray(a.z(j7), g0, g02, g03, g04, g05, g06);
    }

    public static <T1, T2, T3, T4, T5, R> i.b.a0<R> zip(i.b.g0<? extends T1> g0, i.b.g0<? extends T2> g02, i.b.g0<? extends T3> g03, i.b.g0<? extends T4> g04, i.b.g0<? extends T5> g05, i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> i6) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        b.e(g04, "source4 is null");
        b.e(g05, "source5 is null");
        i.b.g0[] arr = new g0[5];
        return a0.zipArray(a.y(i6), g0, g02, g03, g04, g05);
    }

    public static <T1, T2, T3, T4, R> i.b.a0<R> zip(i.b.g0<? extends T1> g0, i.b.g0<? extends T2> g02, i.b.g0<? extends T3> g03, i.b.g0<? extends T4> g04, h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> h5) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        b.e(g04, "source4 is null");
        i.b.g0[] arr = new g0[4];
        return a0.zipArray(a.x(h5), g0, g02, g03, g04);
    }

    public static <T1, T2, T3, R> i.b.a0<R> zip(i.b.g0<? extends T1> g0, i.b.g0<? extends T2> g02, i.b.g0<? extends T3> g03, g<? super T1, ? super T2, ? super T3, ? extends R> g4) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        b.e(g03, "source3 is null");
        i.b.g0[] arr = new g0[3];
        return a0.zipArray(a.w(g4), g0, g02, g03);
    }

    public static <T1, T2, R> i.b.a0<R> zip(i.b.g0<? extends T1> g0, i.b.g0<? extends T2> g02, c<? super T1, ? super T2, ? extends R> c3) {
        b.e(g0, "source1 is null");
        b.e(g02, "source2 is null");
        i.b.g0[] arr = new g0[2];
        return a0.zipArray(a.v(c3), g0, g02);
    }

    public static <T, R> i.b.a0<R> zip(Iterable<? extends i.b.g0<? extends T>> iterable, n<? super Object[], ? extends R> n2) {
        b.e(n2, "zipper is null");
        b.e(iterable, "sources is null");
        z0 z0Var = new z0(iterable, n2);
        return a.o(z0Var);
    }

    public static <T, R> i.b.a0<R> zipArray(n<? super Object[], ? extends R> n, i.b.g0<? extends T>... g02Arr2) {
        b.e(n, "zipper is null");
        b.e(g02Arr2, "sources is null");
        if (g02Arr2.length == 0) {
            NoSuchElementException obj1 = new NoSuchElementException();
            return a0.error(obj1);
        }
        y0 y0Var = new y0(g02Arr2, n);
        return a.o(y0Var);
    }

    public final i.b.a0<T> ambWith(i.b.g0<? extends T> g0) {
        b.e(g0, "other is null");
        i.b.g0[] arr = new g0[2];
        return a0.ambArray(this, g0);
    }

    public final <R> R as(i.b.b0<T, ? extends R> b0) {
        b.e(b0, "converter is null");
        return (b0)b0.a(this);
    }

    public final T blockingGet() {
        h hVar = new h();
        subscribe(hVar);
        return hVar.a();
    }

    public final i.b.a0<T> cache() {
        b bVar = new b(this);
        return a.o(bVar);
    }

    public final <U> i.b.a0<U> cast(Class<? extends U> class) {
        b.e(class, "clazz is null");
        return map(a.d(class));
    }

    public final <R> i.b.a0<R> compose(i.b.h0<? super T, ? extends R> h0) {
        b.e(h0, "transformer is null");
        return a0.wrap((h0)h0.a(this));
    }

    public final i.b.h<T> concatWith(i.b.g0<? extends T> g0) {
        return a0.concat(this, g0);
    }

    public final i.b.a0<Boolean> contains(Object object) {
        return contains(object, b.d());
    }

    public final i.b.a0<Boolean> contains(Object object, d<Object, Object> d2) {
        b.e(object, "value is null");
        b.e(d2, "comparer is null");
        c cVar = new c(this, object, d2);
        return a.o(cVar);
    }

    public final i.b.a0<T> delay(long l, TimeUnit timeUnit2) {
        return this.delay(l, obj2, obj9, a.a());
    }

    public final i.b.a0<T> delay(long l, TimeUnit timeUnit2, i.b.z z3) {
        return this.delay(l, obj2, z3, obj10);
    }

    public final i.b.a0<T> delay(long l, TimeUnit timeUnit2, i.b.z z3, boolean z4) {
        b.e(z3, "unit is null");
        b.e(z4, "scheduler is null");
        super(this, l, obj4, z3, z4, obj13);
        return a.o(fVar);
    }

    public final i.b.a0<T> delay(long l, TimeUnit timeUnit2, boolean z3) {
        return this.delay(l, obj2, z3, a.a());
    }

    public final i.b.a0<T> delaySubscription(long l, TimeUnit timeUnit2) {
        return delaySubscription(l, timeUnit2, obj4);
    }

    public final i.b.a0<T> delaySubscription(long l, TimeUnit timeUnit2, i.b.z z3) {
        return delaySubscription(r.timer(l, timeUnit2, z3));
    }

    public final i.b.a0<T> delaySubscription(i.b.f f) {
        b.e(f, "other is null");
        g gVar = new g(this, f);
        return a.o(gVar);
    }

    public final <U> i.b.a0<T> delaySubscription(i.b.g0<U> g0) {
        b.e(g0, "other is null");
        j jVar = new j(this, g0);
        return a.o(jVar);
    }

    public final <U> i.b.a0<T> delaySubscription(i.b.w<U> w) {
        b.e(w, "other is null");
        h hVar = new h(this, w);
        return a.o(hVar);
    }

    public final <U> i.b.a0<T> delaySubscription(a<U> a) {
        b.e(a, "other is null");
        i iVar = new i(this, a);
        return a.o(iVar);
    }

    public final <R> i.b.l<R> dematerialize(n<? super T, i.b.q<R>> n) {
        b.e(n, "selector is null");
        k kVar = new k(this, n);
        return a.m(kVar);
    }

    public final i.b.a0<T> doAfterSuccess(f<? super T> f) {
        b.e(f, "onAfterSuccess is null");
        m mVar = new m(this, f);
        return a.o(mVar);
    }

    public final i.b.a0<T> doAfterTerminate(a a) {
        b.e(a, "onAfterTerminate is null");
        n nVar = new n(this, a);
        return a.o(nVar);
    }

    public final i.b.a0<T> doFinally(a a) {
        b.e(a, "onFinally is null");
        o oVar = new o(this, a);
        return a.o(oVar);
    }

    public final i.b.a0<T> doOnDispose(a a) {
        b.e(a, "onDispose is null");
        p pVar = new p(this, a);
        return a.o(pVar);
    }

    public final i.b.a0<T> doOnError(f<? super Throwable> f) {
        b.e(f, "onError is null");
        q qVar = new q(this, f);
        return a.o(qVar);
    }

    public final i.b.a0<T> doOnEvent(b<? super T, ? super Throwable> b) {
        b.e(b, "onEvent is null");
        r rVar = new r(this, b);
        return a.o(rVar);
    }

    public final i.b.a0<T> doOnSubscribe(f<? super b> f) {
        b.e(f, "onSubscribe is null");
        s sVar = new s(this, f);
        return a.o(sVar);
    }

    public final i.b.a0<T> doOnSuccess(f<? super T> f) {
        b.e(f, "onSuccess is null");
        t tVar = new t(this, f);
        return a.o(tVar);
    }

    public final i.b.a0<T> doOnTerminate(a a) {
        b.e(a, "onTerminate is null");
        u uVar = new u(this, a);
        return a.o(uVar);
    }

    public final i.b.l<T> filter(o<? super T> o) {
        b.e(o, "predicate is null");
        f fVar = new f(this, o);
        return a.m(fVar);
    }

    public final <R> i.b.a0<R> flatMap(n<? super T, ? extends i.b.g0<? extends R>> n) {
        b.e(n, "mapper is null");
        x xVar = new x(this, n);
        return a.o(xVar);
    }

    public final i.b.b flatMapCompletable(n<? super T, ? extends i.b.f> n) {
        b.e(n, "mapper is null");
        y yVar = new y(this, n);
        return a.k(yVar);
    }

    public final <R> i.b.l<R> flatMapMaybe(n<? super T, ? extends i.b.p<? extends R>> n) {
        b.e(n, "mapper is null");
        b0 b0Var = new b0(this, n);
        return a.m(b0Var);
    }

    public final <R> i.b.r<R> flatMapObservable(n<? super T, ? extends i.b.w<? extends R>> n) {
        b.e(n, "mapper is null");
        j jVar = new j(this, n);
        return a.n(jVar);
    }

    public final <R> i.b.h<R> flatMapPublisher(n<? super T, ? extends a<? extends R>> n) {
        b.e(n, "mapper is null");
        c0 c0Var = new c0(this, n);
        return a.l(c0Var);
    }

    public final <U> i.b.h<U> flattenAsFlowable(n<? super T, ? extends Iterable<? extends U>> n) {
        b.e(n, "mapper is null");
        z zVar = new z(this, n);
        return a.l(zVar);
    }

    public final <U> i.b.r<U> flattenAsObservable(n<? super T, ? extends Iterable<? extends U>> n) {
        b.e(n, "mapper is null");
        a0 a0Var = new a0(this, n);
        return a.n(a0Var);
    }

    public final i.b.a0<T> hide() {
        g0 g0Var = new g0(this);
        return a.o(g0Var);
    }

    @Override // i.b.g0
    public final i.b.b ignoreElement() {
        h hVar = new h(this);
        return a.k(hVar);
    }

    public final <R> i.b.a0<R> lift(i.b.f0<? extends R, ? super T> f0) {
        b.e(f0, "lift is null");
        j0 j0Var = new j0(this, f0);
        return a.o(j0Var);
    }

    public final <R> i.b.a0<R> map(n<? super T, ? extends R> n) {
        b.e(n, "mapper is null");
        k0 k0Var = new k0(this, n);
        return a.o(k0Var);
    }

    public final i.b.a0<i.b.q<T>> materialize() {
        l0 l0Var = new l0(this);
        return a.o(l0Var);
    }

    public final i.b.h<T> mergeWith(i.b.g0<? extends T> g0) {
        return a0.merge(this, g0);
    }

    public final i.b.a0<T> observeOn(i.b.z z) {
        b.e(z, "scheduler is null");
        n0 n0Var = new n0(this, z);
        return a.o(n0Var);
    }

    public final i.b.a0<T> onErrorResumeNext(i.b.a0<? extends T> a0) {
        b.e(a0, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(a.l(a0));
    }

    public final i.b.a0<T> onErrorResumeNext(n<? super Throwable, ? extends i.b.g0<? extends T>> n) {
        b.e(n, "resumeFunctionInCaseOfError is null");
        p0 p0Var = new p0(this, n);
        return a.o(p0Var);
    }

    public final i.b.a0<T> onErrorReturn(n<Throwable, ? extends T> n) {
        b.e(n, "resumeFunction is null");
        o0 o0Var = new o0(this, n, 0);
        return a.o(o0Var);
    }

    public final i.b.a0<T> onErrorReturnItem(T t) {
        b.e(t, "value is null");
        o0 o0Var = new o0(this, 0, t);
        return a.o(o0Var);
    }

    public final i.b.a0<T> onTerminateDetach() {
        l lVar = new l(this);
        return a.o(lVar);
    }

    public final i.b.h<T> repeat() {
        return toFlowable().N();
    }

    public final i.b.h<T> repeat(long l) {
        return toFlowable().O(l);
    }

    public final i.b.h<T> repeatUntil(e e) {
        return toFlowable().P(e);
    }

    public final i.b.h<T> repeatWhen(n<? super i.b.h<Object>, ? extends a<?>> n) {
        return toFlowable().Q(n);
    }

    public final i.b.a0<T> retry() {
        return a0.toSingle(toFlowable().R());
    }

    public final i.b.a0<T> retry(long l) {
        return a0.toSingle(toFlowable().S(l));
    }

    public final i.b.a0<T> retry(long l, o<? super Throwable> o2) {
        return a0.toSingle(toFlowable().T(l, o2));
    }

    public final i.b.a0<T> retry(d<? super Integer, ? super Throwable> d) {
        return a0.toSingle(toFlowable().U(d));
    }

    public final i.b.a0<T> retry(o<? super Throwable> o) {
        return a0.toSingle(toFlowable().V(o));
    }

    public final i.b.a0<T> retryWhen(n<? super i.b.h<Throwable>, ? extends a<?>> n) {
        return a0.toSingle(toFlowable().W(n));
    }

    @Override // i.b.g0
    public final b subscribe() {
        return subscribe(a.g(), a.e);
    }

    public final b subscribe(b<? super T, ? super Throwable> b) {
        b.e(b, "onCallback is null");
        d dVar = new d(b);
        subscribe(dVar);
        return dVar;
    }

    public final b subscribe(f<? super T> f) {
        return subscribe(f, a.e);
    }

    public final b subscribe(f<? super T> f, f<? super Throwable> f2) {
        b.e(f, "onSuccess is null");
        b.e(f2, "onError is null");
        k kVar = new k(f, f2);
        subscribe(kVar);
        return kVar;
    }

    public final void subscribe(i.b.d0<? super T> d0) {
        b.e(d0, "observer is null");
        final i.b.d0 obj3 = a.A(this, d0);
        b.e(obj3, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        subscribeActual(obj3);
    }

    protected abstract void subscribeActual(i.b.d0<? super T> d0);

    public final i.b.a0<T> subscribeOn(i.b.z z) {
        b.e(z, "scheduler is null");
        q0 q0Var = new q0(this, z);
        return a.o(q0Var);
    }

    public final <E extends i.b.d0<? super T>> E subscribeWith(E e) {
        subscribe(e);
        return e;
    }

    public final i.b.a0<T> takeUntil(i.b.f f) {
        b.e(f, "other is null");
        p pVar = new p(f);
        return takeUntil(pVar);
    }

    public final <E> i.b.a0<T> takeUntil(i.b.g0<? extends E> g0) {
        b.e(g0, "other is null");
        u0 u0Var = new u0(g0);
        return takeUntil(u0Var);
    }

    public final <E> i.b.a0<T> takeUntil(a<E> a) {
        b.e(a, "other is null");
        r0 r0Var = new r0(this, a);
        return a.o(r0Var);
    }

    public final f<T> test() {
        f fVar = new f();
        subscribe(fVar);
        return fVar;
    }

    public final f<T> test(boolean z) {
        f fVar = new f();
        if (z) {
            fVar.a();
        }
        subscribe(fVar);
        return fVar;
    }

    public final i.b.a0<T> timeout(long l, TimeUnit timeUnit2) {
        return this.timeout0(l, obj2, obj9, a.a());
    }

    public final i.b.a0<T> timeout(long l, TimeUnit timeUnit2, i.b.g0<? extends T> g03) {
        b.e(obj11, "other is null");
        return this.timeout0(l, obj3, g03, a.a());
    }

    public final i.b.a0<T> timeout(long l, TimeUnit timeUnit2, i.b.z z3) {
        return this.timeout0(l, obj2, z3, obj10);
    }

    public final i.b.a0<T> timeout(long l, TimeUnit timeUnit2, i.b.z z3, i.b.g0<? extends T> g04) {
        b.e(obj6, "other is null");
        return timeout0(l, timeUnit2, z3, g04);
    }

    public final <R> R to(n<? super i.b.a0<T>, R> n) {
        try {
            b.e(n, "convert is null");
            return (n)n.apply(this);
            a.b(n);
            n = k.e(n);
            throw n;
        }
    }

    @Deprecated
    public final i.b.b toCompletable() {
        h hVar = new h(this);
        return a.k(hVar);
    }

    public final i.b.h<T> toFlowable() {
        if (this instanceof b) {
            return (b)this.c();
        }
        u0 u0Var = new u0(this);
        return a.l(u0Var);
    }

    public final Future<T> toFuture() {
        q qVar = new q();
        return (Future)subscribeWith(qVar);
    }

    public final i.b.l<T> toMaybe() {
        if (this instanceof c) {
            return (c)this.b();
        }
        k kVar = new k(this);
        return a.m(kVar);
    }

    public final i.b.r<T> toObservable() {
        if (this instanceof d) {
            return (d)this.a();
        }
        v0 v0Var = new v0(this);
        return a.n(v0Var);
    }

    public final i.b.a0<T> unsubscribeOn(i.b.z z) {
        b.e(z, "scheduler is null");
        w0 w0Var = new w0(this, z);
        return a.o(w0Var);
    }

    public final <U, R> i.b.a0<R> zipWith(i.b.g0<U> g0, c<? super T, ? super U, ? extends R> c2) {
        return a0.zip(this, g0, c2);
    }
}
