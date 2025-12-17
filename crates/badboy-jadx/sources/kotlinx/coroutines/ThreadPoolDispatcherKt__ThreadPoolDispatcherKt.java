package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006", d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/ThreadPoolDispatcherKt")
final class ThreadPoolDispatcherKt__ThreadPoolDispatcherKt {
    public static Thread $r8$lambda$XFVhsA28fmYUFDEvkT7eVQ1JeFw(int i, String string2, AtomicInteger atomicInteger3, Runnable runnable4) {
        return ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.newFixedThreadPoolContext$lambda$1$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt(i, string2, atomicInteger3, runnable4);
    }

    public static final kotlinx.coroutines.ExecutorCoroutineDispatcher newFixedThreadPoolContext(int nThreads, String name) {
        int i;
        if (nThreads >= 1) {
        } else {
            i = 0;
        }
        if (i == 0) {
        } else {
            AtomicInteger atomicInteger = new AtomicInteger();
            ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0(nThreads, name, atomicInteger);
            return ExecutorsKt.from((ExecutorService)Executors.newScheduledThreadPool(nThreads, externalSyntheticLambda0));
        }
        int threadNo = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected at least one thread, but ").append(nThreads).append(" specified").toString().toString());
        throw illegalArgumentException;
    }

    private static final Thread newFixedThreadPoolContext$lambda$1$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt(int $nThreads, String $name, AtomicInteger $threadNo, Runnable runnable) {
        String string;
        int incrementAndGet;
        final int i = 1;
        if ($nThreads == i) {
            string = $name;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append($name).append('-').append($threadNo.incrementAndGet()).toString();
        }
        Thread thread = new Thread(runnable, string);
        thread.setDaemon(i);
        return thread;
    }
}
