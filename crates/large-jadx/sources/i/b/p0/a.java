package i.b.p0;

import i.b.a0;
import i.b.b;
import i.b.d;
import i.b.d0;
import i.b.h;
import i.b.k0.a;
import i.b.l;
import i.b.l0.c;
import i.b.l0.e;
import i.b.l0.f;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.j.k;
import i.b.n;
import i.b.n0.a;
import i.b.r;
import i.b.y;
import i.b.z;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.Callable;
import m.c.b;

/* loaded from: classes3.dex */
public final class a {

    static volatile f<? super Throwable> a;
    static volatile n<? super Runnable, ? extends Runnable> b;
    static volatile n<? super Callable<z>, ? extends z> c;
    static volatile n<? super Callable<z>, ? extends z> d;
    static volatile n<? super Callable<z>, ? extends z> e;
    static volatile n<? super Callable<z>, ? extends z> f;
    static volatile n<? super z, ? extends z> g;
    static volatile n<? super z, ? extends z> h;
    static volatile n<? super z, ? extends z> i;
    static volatile n<? super h, ? extends h> j;
    static volatile n<? super a, ? extends a> k;
    static volatile n<? super r, ? extends r> l;
    static volatile n<? super a, ? extends a> m;
    static volatile n<? super l, ? extends l> n;
    static volatile n<? super a0, ? extends a0> o;
    static volatile n<? super b, ? extends b> p;
    static volatile c<? super h, ? super b, ? extends b> q;
    static volatile c<? super l, ? super n, ? extends n> r;
    static volatile c<? super r, ? super y, ? extends y> s;
    static volatile c<? super a0, ? super d0, ? extends d0> t;
    static volatile c<? super b, ? super d, ? extends d> u;
    static volatile e v;
    static volatile boolean w;
    static volatile boolean x;
    public static <T> d0<? super T> A(a0<T> a0, d0<? super T> d02) {
        final c cVar = a.t;
        if (cVar != null) {
            return (d0)a.a(cVar, a0, d02);
        }
        return d02;
    }

    public static <T> b<? super T> B(h<T> h, b<? super T> b2) {
        final c cVar = a.q;
        if (cVar != null) {
            return (b)a.a(cVar, h, b2);
        }
        return b2;
    }

    public static void C(f<? super Throwable> f) {
        if (a.w) {
        } else {
            a.a = f;
        }
        IllegalStateException obj1 = new IllegalStateException("Plugins can't be changed anymore");
        throw obj1;
    }

    static void D(Throwable throwable) {
        final Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, throwable);
    }

    static <T, U, R> R a(c<T, U, R> c, T t2, U u3) {
        try {
            return c.apply(t2, u3);
            c = k.e(c);
            throw c;
        }
    }

    static <T, R> R b(n<T, R> n, T t2) {
        try {
            return n.apply(t2);
            n = k.e(n);
            throw n;
        }
    }

    static z c(n<? super Callable<z>, ? extends z> n, Callable<z> callable2) {
        final Object obj0 = a.b(n, callable2);
        b.e(obj0, "Scheduler Callable result can't be null");
        return (z)obj0;
    }

    static z d(Callable<z> callable) {
        try {
            final Object obj1 = callable.call();
            b.e(obj1, "Scheduler Callable result can't be null");
            return (z)obj1;
            callable = k.e(callable);
            throw callable;
        }
    }

    public static z e(Callable<z> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        n nVar = a.c;
        if (nVar == null) {
            return a.d(callable);
        }
        return a.c(nVar, callable);
    }

    public static z f(Callable<z> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        n nVar = a.e;
        if (nVar == null) {
            return a.d(callable);
        }
        return a.c(nVar, callable);
    }

    public static z g(Callable<z> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        n nVar = a.f;
        if (nVar == null) {
            return a.d(callable);
        }
        return a.c(nVar, callable);
    }

    public static z h(Callable<z> callable) {
        b.e(callable, "Scheduler Callable can't be null");
        n nVar = a.d;
        if (nVar == null) {
            return a.d(callable);
        }
        return a.c(nVar, callable);
    }

    static boolean i(Throwable throwable) {
        final int i = 1;
        if (throwable instanceof OnErrorNotImplementedException != null) {
            return i;
        }
        if (throwable instanceof MissingBackpressureException != null) {
            return i;
        }
        if (throwable instanceof IllegalStateException != null) {
            return i;
        }
        if (throwable instanceof NullPointerException != null) {
            return i;
        }
        if (throwable instanceof IllegalArgumentException != null) {
            return i;
        }
        if (throwable instanceof CompositeException != null) {
            return i;
        }
        return 0;
    }

    public static boolean j() {
        return a.x;
    }

    public static b k(b b) {
        Object obj1;
        final n nVar = a.p;
        if (nVar != null) {
            obj1 = a.b(nVar, b);
        }
        return obj1;
    }

    public static <T> h<T> l(h<T> h) {
        Object obj1;
        final n nVar = a.j;
        if (nVar != null) {
            obj1 = a.b(nVar, h);
        }
        return obj1;
    }

    public static <T> l<T> m(l<T> l) {
        Object obj1;
        final n nVar = a.n;
        if (nVar != null) {
            obj1 = a.b(nVar, l);
        }
        return obj1;
    }

    public static <T> r<T> n(r<T> r) {
        Object obj1;
        final n nVar = a.l;
        if (nVar != null) {
            obj1 = a.b(nVar, r);
        }
        return obj1;
    }

    public static <T> a0<T> o(a0<T> a0) {
        Object obj1;
        final n nVar = a.o;
        if (nVar != null) {
            obj1 = a.b(nVar, a0);
        }
        return obj1;
    }

    public static <T> a<T> p(a<T> a) {
        Object obj1;
        final n nVar = a.k;
        if (nVar != null) {
            obj1 = a.b(nVar, a);
        }
        return obj1;
    }

    public static <T> a<T> q(a<T> a) {
        Object obj1;
        final n nVar = a.m;
        if (nVar != null) {
            obj1 = a.b(nVar, a);
        }
        return obj1;
    }

    public static boolean r() {
        e eVar = a.v;
        if (eVar != null) {
            return eVar.a();
        }
        return 0;
    }

    public static z s(z z) {
        final n nVar = a.g;
        if (nVar == null) {
            return z;
        }
        return (z)a.b(nVar, z);
    }

    public static void t(Throwable throwable) {
        f fVar;
        String undeliverableException;
        Object obj2;
        fVar = a.a;
        if (throwable == null) {
            obj2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            if (!a.i(throwable)) {
                undeliverableException = new UndeliverableException(throwable);
                obj2 = undeliverableException;
            }
        }
        if (fVar != null) {
            fVar.accept(obj2);
        }
        obj2.printStackTrace();
        a.D(obj2);
    }

    public static z u(z z) {
        final n nVar = a.h;
        if (nVar == null) {
            return z;
        }
        return (z)a.b(nVar, z);
    }

    public static z v(z z) {
        final n nVar = a.i;
        if (nVar == null) {
            return z;
        }
        return (z)a.b(nVar, z);
    }

    public static Runnable w(Runnable runnable) {
        b.e(runnable, "run is null");
        n nVar = a.b;
        if (nVar == null) {
            return runnable;
        }
        return (Runnable)a.b(nVar, runnable);
    }

    public static d x(b b, d d2) {
        final c cVar = a.u;
        if (cVar != null) {
            return (d)a.a(cVar, b, d2);
        }
        return d2;
    }

    public static <T> n<? super T> y(l<T> l, n<? super T> n2) {
        final c cVar = a.r;
        if (cVar != null) {
            return (n)a.a(cVar, l, n2);
        }
        return n2;
    }

    public static <T> y<? super T> z(r<T> r, y<? super T> y2) {
        final c cVar = a.s;
        if (cVar != null) {
            return (y)a.a(cVar, r, y2);
        }
        return y2;
    }
}
