package d.h.i;

import android.os.Handler;
import d.h.k.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestExecutor.java */
/* loaded from: classes.dex */
class g {

    private static class a implements ThreadFactory {

        private String a;
        private int b;
        a(String str, int i) {
            super();
            this.a = str;
            this.b = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new g.a.a(runnable, this.a, this.b);
        }
    }

    private static class b<T> implements Runnable {

        private Callable<T> a;
        private a<T> b;
        private Handler c;
        b(Handler handler, Callable<T> callable, a<T> aVar) {
            super();
            this.a = callable;
            this.b = aVar;
            this.c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object call;
            try {
                call = this.a.call();
            } catch (Exception unused) {
            }
            this.c.post(new g.b.a(this, this.b, call));
        }
    }
    static ThreadPoolExecutor a(String str, int i, int i2) {
        ThreadPoolExecutor str2 = new ThreadPoolExecutor(0, 1, (long)i2, timeUnit, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new g.a(str, i));
        str2.allowCoreThreadTimeOut(true);
        return str2;
    }

    static <T> void b(Executor executor, Callable<T> callable, a<T> aVar) {
        executor.execute(new g.b(b.a(), callable, aVar));
    }

    static <T> T c(ExecutorService executorService, Callable<T> callable, int i) {
        try {
        } catch (java.util.concurrent.TimeoutException unused) {
            callable = "timeout";
            executorService = new InterruptedException(callable);
            throw executorService;
        } catch (java.lang.InterruptedException interrupted1) {
            throw interrupted1;
        } catch (java.util.concurrent.ExecutionException execution2) {
            callable = new RuntimeException(execution2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) callable;
        }
        return executorService.submit(callable).get((long)i, TimeUnit.MILLISECONDS);
    }
}
