package i.b.i0.a;

import i.b.l0.n;
import i.b.z;
import io.reactivex.exceptions.a;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class a {

    private static volatile n<Callable<z>, z> a;
    private static volatile n<z, z> b;
    static <T, R> R a(n<T, R> n, T t2) {
        try {
            return n.apply(t2);
            a.a(n);
            n = null;
            throw n;
        }
    }

    static z b(n<Callable<z>, z> n, Callable<z> callable2) {
        final Object obj0 = a.a(n, callable2);
        Objects.requireNonNull((z)obj0, "Scheduler Callable returned null");
        return obj0;
    }

    static z c(Callable<z> callable) {
        try {
            Object obj1 = callable.call();
            if ((z)obj1 == null) {
            } else {
            }
            return (z)obj1;
            obj1 = new NullPointerException("Scheduler Callable returned null");
            throw obj1;
            a.a(callable);
            callable = null;
            throw callable;
        }
    }

    public static z d(Callable<z> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        n nVar = a.a;
        if (nVar == null) {
            return a.c(callable);
        }
        return a.b(nVar, callable);
    }

    public static z e(z z) {
        Objects.requireNonNull(z, "scheduler == null");
        n nVar = a.b;
        if (nVar == null) {
            return z;
        }
        return (z)a.a(nVar, z);
    }
}
