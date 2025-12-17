package kotlinx.coroutines;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.k0.l;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0004\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0004\u0008\u0000\u0010\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u0014H\u0082\u0008¢\u0006\u0002\u0010\u0015J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0002J\u0008\u0010\u001a\u001a\u00020\u0019H\u0002J\u001c\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0013\u001a\u00060\u001ej\u0002`\u001fH\u0016J\u0008\u0010 \u001a\u00020\u0006H\u0002J!\u0010!\u001a\u00020\u00102\n\u0010\"\u001a\u0006\u0012\u0002\u0008\u00030#2\u0006\u0010\u0005\u001a\u00020\u0019H\u0000¢\u0006\u0002\u0008$J\r\u0010%\u001a\u00020\u0017H\u0000¢\u0006\u0002\u0008&J\u0015\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\u0008*J\u0008\u0010+\u001a\u00020\u0004H\u0016J\r\u0010\u000f\u001a\u00020\u0017H\u0000¢\u0006\u0002\u0008,R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Lkotlinx/coroutines/CommonPool;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "parallelism", "", "getParallelism", "()I", "pool", "requestedParallelism", "usePrivatePool", "", "Try", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "createPlainPool", "Ljava/util/concurrent/ExecutorService;", "createPool", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getOrCreatePoolSync", "isGoodCommonPool", "fjpClass", "Ljava/lang/Class;", "isGoodCommonPool$kotlinx_coroutines_core", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "", "shutdown$kotlinx_coroutines_core", "toString", "usePrivatePool$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class y extends kotlinx.coroutines.o1 {

    public static final kotlinx.coroutines.y b;
    private static final int c;
    private static volatile Executor pool;
    private static boolean v;
    static {
        String property;
        int intValue;
        Integer num;
        int intValue2;
        int i;
        y yVar = new y();
        y.b = yVar;
        property = System.getProperty("kotlinx.coroutines.default.parallelism");
        if (property == null) {
            intValue = -1;
            try {
                y.c = intValue;
                IllegalStateException illegalStateException = new IllegalStateException(n.o("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", property).toString());
                throw illegalStateException;
            }
        } else {
            num = l.m(property);
            if (num == null) {
            } else {
                if (num.intValue() < 1) {
                } else {
                    intValue = num.intValue();
                }
            }
        }
    }

    private final ExecutorService M() {
        AtomicInteger atomicInteger = new AtomicInteger();
        b bVar = new b(atomicInteger);
        return Executors.newFixedThreadPool(Y(), bVar);
    }

    private static final Thread T(AtomicInteger atomicInteger, Runnable runnable2) {
        Thread thread = new Thread(runnable2, n.o("CommonPool-worker-", Integer.valueOf(atomicInteger.incrementAndGet())));
        thread.setDaemon(true);
        return thread;
    }

    private final ExecutorService U() {
        int i;
        Class forName;
        Object invoke;
        boolean z;
        if (System.getSecurityManager() != null) {
            return M();
        }
        i = 0;
        forName = Class.forName("java.util.concurrent.ForkJoinPool");
        if (forName == null) {
            return M();
        }
        final int i3 = 0;
        if (!y.v && y.c < 0) {
            if (y.c < 0) {
                if (invoke instanceof ExecutorService != null) {
                } else {
                    invoke = i;
                }
                if (invoke == null) {
                    try {
                        if (y.b.e0(forName, invoke)) {
                        } else {
                        }
                        invoke = i;
                    } catch (Throwable th) {
                    }
                } else {
                }
                return invoke;
            }
        }
        int i2 = 1;
        Class[] arr4 = new Class[i2];
        arr4[i3] = Integer.TYPE;
        Object[] arr = new Object[i2];
        arr[i3] = Integer.valueOf(y.b.Y());
        Object instance = forName.getConstructor(arr4).newInstance(arr);
        if (instance instanceof ExecutorService != null) {
            i = instance;
        }
        if (i == 0) {
            i = M();
        }
        return i;
    }

    private final Executor V() {
        Object pool;
        synchronized (this) {
            try {
                y.pool = U();
                return pool;
                throw th;
            }
        }
    }

    private final int Y() {
        int valueOf;
        int intValue;
        int i;
        final int i4 = 1;
        i = Integer.valueOf(y.c).intValue() > 0 ? i4 : 0;
        if (i != 0) {
        } else {
            valueOf = 0;
        }
        if (valueOf == 0) {
            intValue = g.b(availableProcessors -= i4, i4);
        } else {
            intValue = valueOf.intValue();
        }
        return intValue;
    }

    private static final void g0() {
    }

    public static void j0() {
        y.g0();
    }

    public static Thread l0(AtomicInteger atomicInteger, Runnable runnable2) {
        return y.T(atomicInteger, runnable2);
    }

    @Override // kotlinx.coroutines.o1
    public void K(g g, Runnable runnable2) {
        Runnable runnable;
        Executor obj2;
        try {
            if (y.pool == null) {
            }
            obj2 = V();
            kotlinx.coroutines.d dVar = e.a();
            if (dVar == null) {
            } else {
            }
            runnable = runnable2;
            runnable = dVar.h(runnable2);
            obj2.execute(runnable);
            g = e.a();
            if (g == null) {
            } else {
            }
            g.e();
            g = s0.y;
            g.G0(runnable2);
        }
    }

    @Override // kotlinx.coroutines.o1
    public void close() {
        IllegalStateException illegalStateException = new IllegalStateException("Close cannot be invoked on CommonPool".toString());
        throw illegalStateException;
    }

    public final boolean e0(Class<?> class, ExecutorService executorService2) {
        int i2;
        int i;
        executorService2.submit(a.a);
        i2 = 0;
        i = 0;
        Object obj5 = class.getMethod("getPoolSize", new Class[i]).invoke(executorService2, new Object[i]);
        if (obj5 instanceof Integer) {
            i2 = obj5;
        }
        if (i2 == 0) {
            return i;
        }
        int obj6 = 1;
        if (i2.intValue() >= obj6) {
            i = obj6;
        }
        return i;
    }

    @Override // kotlinx.coroutines.o1
    public String toString() {
        return "CommonPool";
    }
}
