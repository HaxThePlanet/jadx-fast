package io.grpc.j1;

import com.google.common.base.n;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: SerializingExecutor.java */
/* loaded from: classes3.dex */
public final class d2 implements Executor, Runnable {

    private static final Logger v;
    private static final d2.b w;
    private Executor a;
    private final Queue<Runnable> b = new ConcurrentLinkedQueue<>();
    private volatile int c = 0;

    static class a {
    }

    private static abstract class b {
        private b() {
            super();
        }

        /* synthetic */ b(d2.a aVar) {
            this();
        }

        public abstract boolean a(d2 d2Var, int i, int i2);

        public abstract void b(d2 d2Var, int i);
    }

    private static final class c extends d2.b {

        private final AtomicIntegerFieldUpdater<d2> a;
        /* synthetic */ c(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, d2.a aVar) {
            this(atomicIntegerFieldUpdater);
        }

        @Override // io.grpc.j1.d2$b
        public boolean a(d2 d2Var, int i, int i2) {
            return this.a.compareAndSet(d2Var, i, i2);
        }

        @Override // io.grpc.j1.d2$b
        public void b(d2 d2Var, int i) {
            this.a.set(d2Var, i);
        }

        private c(AtomicIntegerFieldUpdater<d2> atomicIntegerFieldUpdater) {
            super(null);
            this.a = atomicIntegerFieldUpdater;
        }
    }

    private static final class d extends d2.b {
        private d() {
            super(null);
        }

        @Override // io.grpc.j1.d2$b
        public boolean a(d2 d2Var, int i, int i2) {
            synchronized (d2Var) {
                try {
                    if (d2Var.c == i) {
                        d2Var.c = i2;
                        return true;
                    }
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        @Override // io.grpc.j1.d2$b
        public void b(d2 d2Var, int i) {
            synchronized (d2Var) {
                try {
                    d2Var.c = i;
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        /* synthetic */ d(d2.a aVar) {
            this();
        }
    }
    static {
        d2.v = Logger.getLogger(d2.class.getName());
        d2.w = d2.c();
    }

    public d2(Executor executor) {
        super();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        n.p(executor, "'executor' must not be null.");
        this.a = executor;
    }

    static /* synthetic */ int a(d2 d2Var) {
        return d2Var.c;
    }

    static /* synthetic */ int b(d2 d2Var, int i) {
        d2Var.c = i;
        return i;
    }

    private static d2.b c() {
        io.grpc.j1.d2.c cVar;
        try {
            str = "c";
            cVar = new d2.c(AtomicIntegerFieldUpdater.newUpdater(d2.class, str), null);
        } catch (Throwable th) {
            d2.v.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
        }
        return cVar;
    }

    private void d(Runnable runnable) {
        Queue queue;
        if (d2.w.a(this, 0, -1)) {
            try {
                this.a.execute(this);
            } catch (Throwable th) {
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        n.p(runnable, "'r' must not be null.");
        this.b.add(runnable);
        d(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Object poll = this.b.poll();
        } catch (RuntimeException e) {
        } finally {
            String str = d2.w;
            str.b(this, i);
            throw th;
        }
        d2.w.b(this, 0);
        if (!this.b.isEmpty()) {
            d(null);
        }
    }
}
