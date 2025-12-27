package d.p.b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ModernAsyncTask.java */
/* loaded from: classes.dex */
abstract class c<Params, Progress, Result> {

    private static c.f A;
    private static final ThreadFactory x = new c$a();
    private static final BlockingQueue<Runnable> y = new LinkedBlockingQueue<>(10);
    public static final Executor z;
    private final c.h<Params, Result> a = new c$b<>();
    private final FutureTask<Result> b = new c$c<>();
    private volatile c.g c;
    final AtomicBoolean v = new AtomicBoolean();
    final AtomicBoolean w = new AtomicBoolean();

    static class a implements ThreadFactory {

        private final AtomicInteger a = new AtomicInteger(1);
        a() {
            super();
            final AtomicInteger atomicInteger = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "ModernAsyncTask #";
            int andIncrement = this.a.getAndIncrement();
            r1 = str + andIncrement;
            return new Thread(runnable, r1);
        }
    }

    class c extends FutureTask<Result> {

        final /* synthetic */ c a;
        c(Callable callable) {
            this.a = cVar;
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            str = "An error occurred while executing doInBackground()";
            try {
                this.a.m(get());
            } catch (java.util.concurrent.CancellationException unused) {
                Throwable str3 = null;
                this.a.m(str3);
            } catch (java.util.concurrent.ExecutionException execution1) {
                execution1 = execution1.getCause();
                RuntimeException runtimeException = new RuntimeException(str2, execution1);
                throw runtimeException;
            } catch (java.lang.InterruptedException interrupted2) {
                execution1 = "AsyncTask";
                Log.w(execution1, this.a);
            } finally {
                runtimeException = new RuntimeException(interrupted2, execution1);
                throw runtimeException;
            }
        }
    }

    static class d {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[c.g.values().length];
            c.d.a = iArr;
            try {
                iArr[c.g.RUNNING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c.d.a[c.g.FINISHED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private static class e<Data> {

        final c a;
        final Data[] b;
        e(Data... dataArr) {
            super();
            this.a = cVar;
            this.b = dataArr;
        }
    }

    private static class f extends Handler {
        f() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = 0;
                obj2.a.d(obj2.b[i]);
            } else {
                i = 2;
                if (message.what == 2) {
                    obj2.a.k(obj2.b);
                }
            }
        }
    }

    public enum g {

        FINISHED,
        PENDING,
        RUNNING;
    }

    private static abstract class h<Params, Result> implements Callable<Result> {

        Params[] a;
        h() {
            super();
        }
    }

    class b extends c.h<Params, Result> {

        final /* synthetic */ c b;
        b() {
            this.b = cVar;
            super();
        }

        @Override // d.p.b.c$h
        public Result call() {
            this.b.w.set(true);
            try {
                Process.setThreadPriority(10);
                Object obj2 = this.b.b(this.a);
                Binder.flushPendingCommands();
            } finally {
                this.b.l(obj);
                throw th;
            }
            this.b.l(obj2);
            return obj2;
        }
    }
    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, timeUnit, TimeUnit.SECONDS, threadFactory, obj);
        c.z = threadPoolExecutor;
    }

    c() {
        super();
        this.c = c.g.PENDING;
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        final d.p.b.c.c cVar = new c.c(this, new c.b(this));
    }

    private static Handler e() {
        final Class<d.p.b.c> obj2 = c.class;
        synchronized (obj2) {
            try {
                if (c.A == null) {
                    c.A = new c.f();
                }
                return c.A;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public final boolean a(boolean z) {
        this.v.set(true);
        return this.b.cancel(z);
    }

    public final c<Params, Progress, Result> c(Executor executor, Params... paramsArr) {
        if (this.c != c.g.PENDING) {
            int i = c.d.a[this.c.ordinal()];
            if (c.d.a == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else {
                if (c.d.a != 2) {
                    throw new IllegalStateException("We should never reach this state");
                }
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.c = c.g.RUNNING;
        j();
        this.a.a = paramsArr;
        executor.execute(this.b);
        return this;
    }

    void d(Result result) {
        if (f()) {
            h(result);
        } else {
            i(result);
        }
        this.c = c.g.FINISHED;
    }

    public final boolean f() {
        return this.v.get();
    }

    protected void h(Result result) {
        g();
    }

    Result l(Result result) {
        final int i = 1;
        final Object[] arr = new Object[i];
        arr[0] = result;
        c.e().obtainMessage(i, new c.e(this, arr)).sendToTarget();
        return result;
    }

    void m(Result result) {
        if (!this.w.get()) {
            l(result);
        }
    }

    protected abstract Result b(Params... paramsArr);

    protected void g() {
    }

    protected void i(Result result) {
    }

    protected void j() {
    }

    protected void k(Progress... progressArr) {
    }
}
