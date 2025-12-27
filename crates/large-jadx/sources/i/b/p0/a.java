package i.b.p0;

import i.b.a0;
import i.b.d;
import i.b.d0;
import i.b.h;
import i.b.l;
import i.b.l0.c;
import i.b.l0.e;
import i.b.l0.f;
import i.b.m0.j.k;
import i.b.r;
import i.b.y;
import i.b.z;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.Callable;

/* compiled from: RxJavaPlugins.java */
/* loaded from: classes3.dex */
public final class a {

    static volatile f<? super Throwable> a;
    static volatile i.b.l0.n<? super Runnable, ? extends Runnable> b;
    static volatile i.b.l0.n<? super Callable<z>, ? extends z> c;
    static volatile i.b.l0.n<? super Callable<z>, ? extends z> d;
    static volatile i.b.l0.n<? super Callable<z>, ? extends z> e;
    static volatile i.b.l0.n<? super Callable<z>, ? extends z> f;
    static volatile i.b.l0.n<? super z, ? extends z> g;
    static volatile i.b.l0.n<? super z, ? extends z> h;
    static volatile i.b.l0.n<? super z, ? extends z> i;
    static volatile i.b.l0.n<? super h, ? extends h> j;
    static volatile i.b.l0.n<? super i.b.k0.a, ? extends i.b.k0.a> k;
    static volatile i.b.l0.n<? super r, ? extends r> l;
    static volatile i.b.l0.n<? super i.b.n0.a, ? extends i.b.n0.a> m;
    static volatile i.b.l0.n<? super l, ? extends l> n;
    static volatile i.b.l0.n<? super a0, ? extends a0> o;
    static volatile i.b.l0.n<? super i.b.b, ? extends i.b.b> p;
    static volatile c<? super h, ? super m.c.b, ? extends m.c.b> q;
    static volatile c<? super l, ? super i.b.n, ? extends i.b.n> r;
    static volatile c<? super r, ? super y, ? extends y> s;
    static volatile c<? super a0, ? super d0, ? extends d0> t;
    static volatile c<? super i.b.b, ? super d, ? extends d> u;
    static volatile e v;
    static volatile boolean w;
    static volatile boolean x;
    public static <T> d0<? super T> A(a0<T> a0Var, d0<? super T> d0Var) {
        final c cVar = a.t;
        if (a.t != null) {
            return (d0)a.a(a.t, a0Var, d0Var);
        }
        return d0Var;
    }

    public static <T> m.c.b<? super T> B(h<T> hVar, m.c.b<? super T> bVar) {
        final c cVar = a.q;
        if (a.q != null) {
            return (b)a.a(a.q, hVar, bVar);
        }
        return bVar;
    }

    public static void C(f<? super Throwable> fVar) {
        if (a.w) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        } else {
            a.a = fVar;
            return;
        }
    }

    static void D(Throwable th) {
        final Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t, U u) {
        try {
        } finally {
            cVar = k.e(cVar);
            throw cVar;
        }
        return cVar.apply(t, u);
    }

    static <T, R> R b(i.b.l0.n<T, R> nVar, T t) {
        try {
        } finally {
            nVar = k.e(nVar);
            throw nVar;
        }
        return nVar.apply(t);
    }

    static z c(i.b.l0.n<? super Callable<z>, ? extends z> nVar, Callable<z> callable) {
        final Object obj = a.b(nVar, callable);
        b.e(obj, "Scheduler Callable result can't be null");
        return obj;
    }

    static z d(Callable<z> callable) {
        try {
            final Object call = callable.call();
            b.e(call, "Scheduler Callable result can't be null");
        } finally {
            callable = k.e(callable);
            throw callable;
        }
        return call;
    }

    public static z e(Callable<z> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        i.b.l0.n nVar = a.c;
        if (a.c == null) {
            return a.d(callable);
        }
        return a.c(a.c, callable);
    }

    public static z f(Callable<z> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        i.b.l0.n nVar = a.e;
        if (a.e == null) {
            return a.d(callable);
        }
        return a.c(a.e, callable);
    }

    public static z g(Callable<z> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        i.b.l0.n nVar = a.f;
        if (a.f == null) {
            return a.d(callable);
        }
        return a.c(a.f, callable);
    }

    public static z h(Callable<z> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        i.b.l0.n nVar = a.d;
        if (a.d == null) {
            return a.d(callable);
        }
        return a.c(a.d, callable);
    }

    static boolean i(Throwable th) {
        final boolean z6 = true;
        if (th instanceof OnErrorNotImplementedException) {
            return true;
        }
        if (th instanceof MissingBackpressureException) {
            return true;
        }
        if (th instanceof IllegalStateException) {
            return true;
        }
        if (th instanceof NullPointerException) {
            return true;
        }
        if (th instanceof IllegalArgumentException) {
            return true;
        }
        if (th instanceof CompositeException) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        return a.x;
    }

    public static i.b.b k(i.b.b bVar) {
        Object obj;
        final i.b.l0.n nVar = a.p;
        if (a.p != null) {
            obj = a.b(a.p, bVar);
        }
        return obj;
    }

    public static <T> h<T> l(h<T> hVar) {
        Object obj;
        final i.b.l0.n nVar = a.j;
        if (a.j != null) {
            obj = a.b(a.j, hVar);
        }
        return obj;
    }

    public static <T> l<T> m(l<T> lVar) {
        Object obj;
        final i.b.l0.n nVar = a.n;
        if (a.n != null) {
            obj = a.b(a.n, lVar);
        }
        return obj;
    }

    public static <T> r<T> n(r<T> rVar) {
        Object obj;
        final i.b.l0.n nVar = a.l;
        if (a.l != null) {
            obj = a.b(a.l, rVar);
        }
        return obj;
    }

    public static <T> a0<T> o(a0<T> a0Var) {
        Object obj;
        final i.b.l0.n nVar = a.o;
        if (a.o != null) {
            obj = a.b(a.o, a0Var);
        }
        return obj;
    }

    public static <T> i.b.k0.a<T> p(i.b.k0.a<T> aVar) {
        Object obj;
        final i.b.l0.n nVar = a.k;
        if (a.k != null) {
            obj = a.b(a.k, aVar);
        }
        return obj;
    }

    public static <T> i.b.n0.a<T> q(i.b.n0.a<T> aVar) {
        Object obj;
        final i.b.l0.n nVar = a.m;
        if (a.m != null) {
            obj = a.b(a.m, aVar);
        }
        return obj;
    }

    public static boolean r() {
        e eVar = a.v;
        if (a.v != null) {
            try {
            } finally {
                Throwable th = k.e(th);
                throw th;
            }
            return a.v.a();
        }
        return false;
    }

    public static z s(z zVar) {
        final i.b.l0.n nVar = a.g;
        if (a.g == null) {
            return zVar;
        }
        return (z)a.b(a.g, zVar);
    }

    public static void t(Throwable th) {
        UndeliverableException undeliverableException;
        fVar = a.a;
        if (th == null) {
            java.lang.NullPointerException nullPointerException = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            if (!a.i(th)) {
            }
        }
        if (a.a != null) {
            try {
                a.a.accept(undeliverableException);
            } catch (Throwable th) {
                th.printStackTrace();
                a.D(th);
            }
            return;
        }
        undeliverableException.printStackTrace();
        a.D(undeliverableException);
    }

    public static z u(z zVar) {
        final i.b.l0.n nVar = a.h;
        if (a.h == null) {
            return zVar;
        }
        return (z)a.b(a.h, zVar);
    }

    public static z v(z zVar) {
        final i.b.l0.n nVar = a.i;
        if (a.i == null) {
            return zVar;
        }
        return (z)a.b(a.i, zVar);
    }

    public static Runnable w(Runnable runnable) {
        b.e(runnable, "run is null");
        i.b.l0.n nVar = a.b;
        if (a.b == null) {
            return runnable;
        }
        return (Runnable)a.b(a.b, runnable);
    }

    public static d x(i.b.b bVar, d dVar) {
        final c cVar = a.u;
        if (a.u != null) {
            return (d)a.a(a.u, bVar, dVar);
        }
        return dVar;
    }

    public static <T> i.b.n<? super T> y(l<T> lVar, i.b.n<? super T> nVar) {
        final c cVar = a.r;
        if (a.r != null) {
            return (n)a.a(a.r, lVar, nVar);
        }
        return nVar;
    }

    public static <T> y<? super T> z(r<T> rVar, y<? super T> yVar) {
        final c cVar = a.s;
        if (a.s != null) {
            return (y)a.a(a.s, rVar, yVar);
        }
        return yVar;
    }
}
