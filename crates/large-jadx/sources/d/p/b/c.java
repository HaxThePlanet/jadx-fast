package d.p.b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
abstract class c<Params, Progress, Result>  {

    private static d.p.b.c.f A;
    private static final ThreadFactory x;
    private static final BlockingQueue<Runnable> y;
    public static final Executor z;
    private final d.p.b.c.h<Params, Result> a;
    private final FutureTask<Result> b;
    private volatile d.p.b.c.g c;
    final AtomicBoolean v;
    final AtomicBoolean w;

    static class a implements ThreadFactory {

        private final AtomicInteger a;
        a() {
            super();
            AtomicInteger atomicInteger = new AtomicInteger(1);
            this.a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ModernAsyncTask #");
            stringBuilder.append(this.a.getAndIncrement());
            Thread thread = new Thread(runnable, stringBuilder.toString());
            return thread;
        }
    }

    class c extends FutureTask<Result> {

        final d.p.b.c a;
        c(d.p.b.c c, Callable callable2) {
            this.a = c;
            super(callable2);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            String str;
            Object obj;
            str = "An error occurred while executing doInBackground()";
            this.a.m(get());
        }
    }

    static class d {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            c.d.a = iArr;
            iArr[c.g.RUNNING.ordinal()] = 1;
            c.d.a[c.g.FINISHED.ordinal()] = 2;
        }
    }

    private static class e {

        final d.p.b.c a;
        final Data[] b;
        e(d.p.b.c c, Data... data2Arr2) {
            super();
            this.a = c;
            this.b = data2Arr2;
        }
    }

    private static class f extends Handler {
        f() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object[] obj;
            int i;
            d.p.b.c obj3;
            obj = message.obj;
            obj3 = message.what;
            if (obj3 != 1) {
                if (obj3 != 2) {
                } else {
                    obj.a.k(obj.b);
                }
            } else {
                obj.a.d(obj.b[0]);
            }
        }
    }

    public static enum g {

        PENDING,
        RUNNING,
        FINISHED;
    }

    private static abstract class h implements Callable<Result> {

        Params[] a;
    }

    class b extends d.p.b.c.h<Params, Result> {

        final d.p.b.c b;
        b(d.p.b.c c) {
            this.b = c;
            super();
        }

        public Result call() {
            cVar.w.set(true);
            int i3 = 0;
            Process.setThreadPriority(10);
            Object obj = this.b.b(this.a);
            Binder.flushPendingCommands();
            this.b.l(obj);
            return obj;
        }
    }
    static {
        c.a aVar = new c.a();
        c.x = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        c.y = linkedBlockingQueue;
        super(5, 128, 1, obj4, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        c.z = threadPoolExecutor2;
    }

    c() {
        super();
        this.c = c.g.PENDING;
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.v = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        this.w = atomicBoolean2;
        c.b bVar = new c.b(this);
        this.a = bVar;
        c.c cVar = new c.c(this, bVar);
        this.b = cVar;
    }

    private static Handler e() {
        d.p.b.c.f fVar;
        final Class<d.p.b.c> obj = c.class;
        synchronized (obj) {
            fVar = new c.f();
            c.A = fVar;
            return c.A;
        }
    }

    public final boolean a(boolean z) {
        this.v.set(true);
        return this.b.cancel(z);
    }

    protected abstract Result b(Params... paramsArr);

    public final d.p.b.c<Params, Progress, Result> c(Executor executor, Params... params2Arr2) {
        if (this.c != c.g.PENDING) {
            int obj3 = c.d.a[this.c.ordinal()];
            if (obj3 == 1) {
            } else {
                if (obj3 != 2) {
                    obj3 = new IllegalStateException("We should never reach this state");
                    throw obj3;
                }
                obj3 = new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                throw obj3;
            }
            obj3 = new IllegalStateException("Cannot execute task: the task is already running.");
            throw obj3;
        }
        this.c = c.g.RUNNING;
        j();
        hVar.a = params2Arr2;
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

    protected void g() {
    }

    protected void h(Result result) {
        g();
    }

    protected void i(Result result) {
    }

    protected void j() {
    }

    protected void k(Progress... progressArr) {
    }

    Result l(Result result) {
        final int i = 1;
        final Object[] arr = new Object[i];
        arr[0] = result;
        c.e eVar = new c.e(this, arr);
        c.e().obtainMessage(i, eVar).sendToTarget();
        return result;
    }

    void m(Result result) {
        if (!this.w.get()) {
            l(result);
        }
    }
}
