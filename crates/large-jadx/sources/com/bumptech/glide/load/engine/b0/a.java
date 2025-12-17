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

/* loaded from: classes.dex */
public final class a implements ExecutorService {

    private static final long b;
    private static volatile int c;
    private final ExecutorService a;

    static class a {
    }

    public static final class b {

        private final boolean a;
        private int b;
        private int c;
        private final ThreadFactory d;
        private com.bumptech.glide.load.engine.b0.a.e e;
        private String f;
        private long g;
        b(boolean z) {
            super();
            a.c cVar = new a.c(0);
            this.d = cVar;
            this.e = a.e.b;
            this.a = z;
        }

        public com.bumptech.glide.load.engine.b0.a a() {
            int cmp;
            if (TextUtils.isEmpty(this.f)) {
            } else {
                PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
                a.d dVar = new a.d(this.d, this.f, this.e, this.a);
                super(this.b, this.c, this.g, obj5, TimeUnit.MILLISECONDS, priorityBlockingQueue, dVar);
                if (Long.compare(l, i3) != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                a aVar = new a(threadPoolExecutor);
                return aVar;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Name must be non-null and non-empty, but given: ");
            stringBuilder.append(this.f);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        public com.bumptech.glide.load.engine.b0.a.b b(String string) {
            this.f = string;
            return this;
        }

        public com.bumptech.glide.load.engine.b0.a.b c(int i) {
            this.b = i;
            this.c = i;
            return this;
        }
    }

    private static final class c implements ThreadFactory {
        c(com.bumptech.glide.load.engine.b0.a.a a$a) {
            super();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            a.c.a aVar = new a.c.a(this, runnable);
            return aVar;
        }
    }

    private static final class d implements ThreadFactory {

        private final ThreadFactory a;
        private final String b;
        final com.bumptech.glide.load.engine.b0.a.e c;
        final boolean v;
        private final AtomicInteger w;
        d(ThreadFactory threadFactory, String string2, com.bumptech.glide.load.engine.b0.a.e a$e3, boolean z4) {
            super();
            AtomicInteger atomicInteger = new AtomicInteger();
            this.w = atomicInteger;
            this.a = threadFactory;
            this.b = string2;
            this.c = e3;
            this.v = z4;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            a.d.a aVar = new a.d.a(this, runnable);
            final Thread obj3 = this.a.newThread(aVar);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("glide-");
            stringBuilder.append(this.b);
            stringBuilder.append("-thread-");
            stringBuilder.append(this.w.getAndIncrement());
            obj3.setName(stringBuilder.toString());
            return obj3;
        }
    }

    public interface e {

        public static final com.bumptech.glide.load.engine.b0.a.e a;
        public static final com.bumptech.glide.load.engine.b0.a.e b;
        static {
            a.e.a aVar = new a.e.a();
            a.e.a = aVar;
            a.e.b = aVar;
        }

        public abstract void a(Throwable throwable);
    }
    static {
        a.b = TimeUnit.SECONDS.toMillis(10);
    }

    a(ExecutorService executorService) {
        super();
        this.a = executorService;
    }

    public static int a() {
        int i2;
        int i;
        if (a.c == 0) {
            a.c = Math.min(4, b.a());
        }
        return a.c;
    }

    public static com.bumptech.glide.load.engine.b0.a.b b() {
        int i;
        final int i3 = 1;
        i = a.a() >= 4 ? 2 : i3;
        a.b bVar = new a.b(i3);
        bVar.c(i);
        bVar.b("animation");
        return bVar;
    }

    public static com.bumptech.glide.load.engine.b0.a c() {
        return a.b().a();
    }

    public static com.bumptech.glide.load.engine.b0.a.b d() {
        int i = 1;
        a.b bVar = new a.b(i);
        bVar.c(i);
        bVar.b("disk-cache");
        return bVar;
    }

    public static com.bumptech.glide.load.engine.b0.a e() {
        return a.d().a();
    }

    public static com.bumptech.glide.load.engine.b0.a.b f() {
        a.b bVar = new a.b(0);
        bVar.c(a.a());
        bVar.b("source");
        return bVar;
    }

    public static com.bumptech.glide.load.engine.b0.a g() {
        return a.f().a();
    }

    public static com.bumptech.glide.load.engine.b0.a h() {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        a.c cVar = new a.c(0);
        a.d dVar = new a.d(cVar, "source-unlimited", a.e.b, 0);
        super(0, Integer.MAX_VALUE, a.b, obj5, TimeUnit.MILLISECONDS, synchronousQueue, dVar);
        a aVar = new a(threadPoolExecutor2);
        return aVar;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long l, TimeUnit timeUnit2) {
        return this.a.awaitTermination(l, timeUnit2);
    }

    @Override // java.util.concurrent.ExecutorService
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.a.invokeAll(collection);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long l2, TimeUnit timeUnit3) {
        return this.a.invokeAll(collection, l2, timeUnit3);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return this.a.invokeAny(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long l2, TimeUnit timeUnit3) {
        return this.a.invokeAny(collection, l2, timeUnit3);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.a.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.a.submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t2) {
        return this.a.submit(runnable, t2);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.a.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public String toString() {
        return this.a.toString();
    }
}
