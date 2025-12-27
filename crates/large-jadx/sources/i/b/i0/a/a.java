package i.b.i0.a;

import i.b.l0.n;
import i.b.z;
import io.reactivex.exceptions.a;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes3.dex */
public final class a {

    private static volatile n<Callable<z>, z> a;
    private static volatile n<z, z> b;
    static <T, R> R a(n<T, R> nVar, T t) {
        try {
        } finally {
            a.a(nVar);
            nVar = null;
            throw nVar;
        }
        return nVar.apply(t);
    }

    static z b(n<Callable<z>, z> nVar, Callable<z> callable) {
        final Object obj = a.a(nVar, callable);
        Objects.requireNonNull(obj, "Scheduler Callable returned null");
        return obj;
    }

    static z c(Callable<z> callable) {
        try {
            Object call = callable.call();
            if (call == null) {
                throw new NullPointerException("Scheduler Callable returned null");
            } else {
                return call;
            }
        } finally {
            a.a(callable);
            callable = null;
            throw callable;
        }
    }

    public static z d(Callable<z> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        n nVar = a.a;
        if (a.a == null) {
            return a.c(callable);
        }
        return a.b(a.a, callable);
    }

    public static z e(z zVar) {
        Objects.requireNonNull(zVar, "scheduler == null");
        n nVar = a.b;
        if (a.b == null) {
            return zVar;
        }
        return (z)a.a(a.b, zVar);
    }
}
