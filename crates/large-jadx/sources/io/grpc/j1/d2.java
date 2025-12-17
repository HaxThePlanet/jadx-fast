package io.grpc.j1;

import com.google.common.base.n;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class d2 implements Executor, Runnable {

    private static final Logger v;
    private static final io.grpc.j1.d2.b w;
    private Executor a;
    private final Queue<Runnable> b;
    private volatile int c = 0;

    static class a {
    }

    private static abstract class b {
        b(io.grpc.j1.d2.a d2$a) {
            super();
        }

        public abstract boolean a(io.grpc.j1.d2 d2, int i2, int i3);

        public abstract void b(io.grpc.j1.d2 d2, int i2);
    }

    private static final class c extends io.grpc.j1.d2.b {

        private final AtomicIntegerFieldUpdater<io.grpc.j1.d2> a;
        private c(AtomicIntegerFieldUpdater<io.grpc.j1.d2> atomicIntegerFieldUpdater) {
            super(0);
            this.a = atomicIntegerFieldUpdater;
        }

        c(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, io.grpc.j1.d2.a d2$a2) {
            super(atomicIntegerFieldUpdater);
        }

        @Override // io.grpc.j1.d2$b
        public boolean a(io.grpc.j1.d2 d2, int i2, int i3) {
            return this.a.compareAndSet(d2, i2, i3);
        }

        @Override // io.grpc.j1.d2$b
        public void b(io.grpc.j1.d2 d2, int i2) {
            this.a.set(d2, i2);
        }
    }

    private static final class d extends io.grpc.j1.d2.b {
        private d() {
            super(0);
        }

        d(io.grpc.j1.d2.a d2$a) {
            super();
        }

        @Override // io.grpc.j1.d2$b
        public boolean a(io.grpc.j1.d2 d2, int i2, int i3) {
            synchronized (d2) {
                try {
                    d2.b(d2, i3);
                    return 1;
                    return 0;
                    throw i2;
                }
            }
        }

        @Override // io.grpc.j1.d2$b
        public void b(io.grpc.j1.d2 d2, int i2) {
            d2.b(d2, i2);
            return;
            synchronized (d2) {
                d2.b(d2, i2);
            }
        }
    }
    static {
        d2.v = Logger.getLogger(d2.class.getName());
        d2.w = d2.c();
    }

    public d2(Executor executor) {
        super();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.b = concurrentLinkedQueue;
        int i = 0;
        n.p(executor, "'executor' must not be null.");
        this.a = executor;
    }

    static int a(io.grpc.j1.d2 d2) {
        return d2.c;
    }

    static int b(io.grpc.j1.d2 d2, int i2) {
        d2.c = i2;
        return i2;
    }

    private static io.grpc.j1.d2.b c() {
        io.grpc.j1.d2.c cVar;
        AtomicIntegerFieldUpdater updater;
        String str;
        String str2;
        cVar = new d2.c(AtomicIntegerFieldUpdater.newUpdater(d2.class, "c"), 0);
        return cVar;
    }

    private void d(Runnable runnable) {
        boolean z;
        Queue queue;
        if (d2.w.a(this, 0, -1)) {
            this.a.execute(this);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        n.p(runnable, "'r' must not be null.");
        this.b.add(runnable);
        d(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void run() {
        boolean empty;
        Object poll;
        Throwable th;
        Logger logger;
        Level sEVERE;
        StringBuilder stringBuilder;
        String str;
        try {
            while (this.a == this.a) {
                poll = this.b.poll();
                if ((Runnable)poll != null) {
                }
                (Runnable)poll.run();
            }
            poll = this.b.poll();
            if ((Runnable)poll != null) {
            }
            (Runnable)poll.run();
            stringBuilder = new StringBuilder();
            stringBuilder.append("Exception while executing runnable ");
            stringBuilder.append(poll);
            poll = stringBuilder.toString();
            d2.v.log(Level.SEVERE, poll, th);
            d2.w.b(this, 0);
            if (!this.b.isEmpty()) {
            }
            d(0);
            poll = d2.w;
            poll.b(this, obj0);
            throw th2;
        } catch (RuntimeException e) {
        } catch (Throwable th1) {
        }
    }
}
