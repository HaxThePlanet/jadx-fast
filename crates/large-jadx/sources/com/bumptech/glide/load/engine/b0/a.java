package com.bumptech.glide.load.engine.b0;

import android.text.TextUtils;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: GlideExecutor.java */
/* loaded from: classes.dex */
public final class a implements ExecutorService {

    private static final long b = 0L;
    private static volatile int c;
    private final ExecutorService a;

    static class a {
    }

    public static final class b {

        private final boolean a;
        private int b;
        private int c;
        private final ThreadFactory d = new a$c(0);
        private a.e e;
        private String f;
        private long g;
        b(boolean z) {
            super();
            com.bumptech.glide.load.engine.b0.a.c cVar = new a.c(null);
            this.e = a.e.b;
            this.a = z;
        }

        public a a() {
            if (TextUtils.isEmpty(this.f)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Name must be non-null and non-empty, but given: ";
                r1 = str2 + this.f;
                throw new IllegalArgumentException(r1);
            } else {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.c, this.g, timeUnit, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new a.d(this.d, this.f, this.e, this.a));
                if (this.g != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
        }

        public a.b b(String str) {
            this.f = str;
            return this;
        }

        public a.b c(int i) {
            this.b = i;
            this.c = i;
            return this;
        }
    }

    private static final class c implements ThreadFactory {
        private c() {
            super();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new a.c.a(this, runnable);
        }

        /* synthetic */ c(a.a aVar) {
            this();
        }
    }

    private static final class d implements ThreadFactory {

        private final ThreadFactory a;
        private final String b;
        final a.e c;
        final boolean v;
        private final AtomicInteger w = new AtomicInteger();
        d(ThreadFactory threadFactory, String str, a.e eVar, boolean z) {
            super();
            final AtomicInteger atomicInteger = new AtomicInteger();
            this.a = threadFactory;
            this.b = str;
            this.c = eVar;
            this.v = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            final Thread thread = this.a.newThread(new a.d.a(this, runnable));
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "glide-";
            String str4 = "-thread-";
            int andIncrement = this.w.getAndIncrement();
            str = str2 + this.b + str4 + andIncrement;
            thread.setName(str);
            return thread;
        }
    }

    public interface e {

        public static final a.e a = new a$e$a();
        public static final a.e b = new a$e$a();

        void a(Throwable th);
    }
    static {
        a.b = TimeUnit.SECONDS.toMillis(10L);
    }

    a(ExecutorService executorService) {
        super();
        this.a = executorService;
    }

    public static int a() {
        if (a.c == 0) {
            a.c = Math.min(4, b.a());
        }
        return a.c;
    }

    public static a.b b() {
        int i = 2;
        final boolean z = true;
        int r0 = a.a() >= 4 ? 2 : z;
        com.bumptech.glide.load.engine.b0.a.b bVar = new a.b(z);
        bVar.c((a.a() >= 4 ? 2 : z));
        bVar.b((a.a() >= 4 ? 2 : z));
        return bVar;
    }

    public static a c() {
        return a.b().a();
    }

    public static a.b d() {
        boolean z = true;
        final com.bumptech.glide.load.engine.b0.a.b bVar = new a.b(z);
        bVar.c(z);
        bVar.b("disk-cache");
        return bVar;
    }

    public static a e() {
        return a.d().a();
    }

    public static a.b f() {
        final com.bumptech.glide.load.engine.b0.a.b bVar = new a.b(false);
        bVar.c(a.a());
        bVar.b("source");
        return bVar;
    }

    public static a g() {
        return a.f().a();
    }

    public static a h() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, a.b, timeUnit, TimeUnit.MILLISECONDS, new SynchronousQueue(), new a.d(new a.c(null), "source-unlimited", a.e.b, false));
        return new a(threadPoolExecutor);
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws java.lang.InterruptedException {
        return this.a.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws java.lang.InterruptedException {
        return this.a.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        return this.a.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    public void shutdown() {
        this.a.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.a.submit(runnable);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a.toString();
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws java.lang.InterruptedException {
        return this.a.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        return this.a.invokeAny(collection, j, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.a.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.a.submit(callable);
    }
}
