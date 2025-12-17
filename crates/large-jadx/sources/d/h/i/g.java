package d.h.i;

import android.os.Handler;
import d.h.k.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class g {

    private static class a implements ThreadFactory {

        private String a;
        private int b;
        a(String string, int i2) {
            super();
            this.a = string;
            this.b = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            g.a.a aVar = new g.a.a(runnable, this.a, this.b);
            return aVar;
        }
    }

    private static class b implements Runnable {

        private Callable<T> a;
        private a<T> b;
        private Handler c;
        b(Handler handler, Callable<T> callable2, a<T> a3) {
            super();
            this.a = callable2;
            this.b = a3;
            this.c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object call;
            try {
                call = this.a.call();
                int i = 0;
                g.b.a aVar2 = new g.b.a(this, this.b, call);
                this.c.post(aVar2);
            }
        }
    }
    static ThreadPoolExecutor a(String string, int i2, int i3) {
        g.a aVar = new g.a(string, i2);
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        super(0, 1, (long)i3, obj4, TimeUnit.MILLISECONDS, linkedBlockingDeque, aVar);
        obj8.allowCoreThreadTimeOut(true);
        return obj8;
    }

    static <T> void b(Executor executor, Callable<T> callable2, a<T> a3) {
        g.b bVar = new g.b(b.a(), callable2, a3);
        executor.execute(bVar);
    }

    static <T> T c(ExecutorService executorService, Callable<T> callable2, int i3) {
        return executorService.submit(callable2).get((long)i3, i3);
    }
}
