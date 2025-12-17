package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class y4 extends com.google.android.gms.measurement.internal.w5 {

    private static final AtomicLong l;
    private com.google.android.gms.measurement.internal.x4 c;
    private com.google.android.gms.measurement.internal.x4 d;
    private final PriorityBlockingQueue<com.google.android.gms.measurement.internal.w4<?>> e;
    private final BlockingQueue<com.google.android.gms.measurement.internal.w4<?>> f;
    private final java.lang.Thread.UncaughtExceptionHandler g;
    private final java.lang.Thread.UncaughtExceptionHandler h;
    private final Object i;
    private final Semaphore j;
    private volatile boolean k;
    static {
        AtomicLong atomicLong = new AtomicLong(Long.MIN_VALUE, obj2);
        y4.l = atomicLong;
    }

    y4(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        Object obj2 = new Object();
        this.i = obj2;
        obj2 = new Semaphore(2);
        this.j = obj2;
        obj2 = new PriorityBlockingQueue();
        this.e = obj2;
        obj2 = new LinkedBlockingQueue();
        this.f = obj2;
        obj2 = new v4(this, "Thread death: Uncaught exception on worker thread");
        this.g = obj2;
        obj2 = new v4(this, "Thread death: Uncaught exception on network thread");
        this.h = obj2;
    }

    static boolean B(com.google.android.gms.measurement.internal.y4 y4) {
        boolean obj0 = y4.k;
        return 0;
    }

    private final void D(com.google.android.gms.measurement.internal.w4<?> w4) {
        Object queue2;
        PriorityBlockingQueue queue;
        com.google.android.gms.measurement.internal.x4 obj4;
        final Object obj = this.i;
        this.e.add(w4);
        obj4 = this.c;
        synchronized (obj) {
            obj4 = new x4(this, "Measurement Worker", this.e);
            this.c = obj4;
            obj4.setUncaughtExceptionHandler(this.g);
            this.c.start();
            try {
                throw w4;
            }
        }
    }

    static com.google.android.gms.measurement.internal.x4 o(com.google.android.gms.measurement.internal.y4 y4) {
        return y4.d;
    }

    static com.google.android.gms.measurement.internal.x4 p(com.google.android.gms.measurement.internal.y4 y4) {
        return y4.c;
    }

    static Object q(com.google.android.gms.measurement.internal.y4 y4) {
        return y4.i;
    }

    static Semaphore u(com.google.android.gms.measurement.internal.y4 y4) {
        return y4.j;
    }

    static AtomicLong v() {
        return y4.l;
    }

    static void w(com.google.android.gms.measurement.internal.y4 y4, com.google.android.gms.measurement.internal.x4 x42) {
        y4.d = 0;
    }

    static void x(com.google.android.gms.measurement.internal.y4 y4, com.google.android.gms.measurement.internal.x4 x42) {
        y4.c = 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void A(Runnable runnable) {
        k();
        r.j(runnable);
        w4 w4Var = new w4(this, runnable, 1, "Task exception on worker thread");
        D(w4Var);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final boolean C() {
        if (Thread.currentThread() == this.c) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void g() {
        if (Thread.currentThread() != this.d) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Call expected from network thread");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void h() {
        if (Thread.currentThread() != this.c) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Call expected from worker thread");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean j() {
        return 0;
    }

    final <T> T r(AtomicReference<T> atomicReference, long l2, String string3, Runnable runnable4) {
        long obj3;
        String obj4;
        String obj5;
        Runnable obj6;
        this.a.a().z(obj6);
        atomicReference.wait(l2);
        final Object obj2 = atomicReference.get();
        synchronized (atomicReference) {
            this.a.a().z(obj6);
            atomicReference.wait(l2);
            obj2 = atomicReference.get();
        }
        try {
            obj4 = "Timed out waiting for ";
            if (runnable4.length() != 0) {
            } else {
            }
            obj4 = obj4.concat(runnable4);
            obj5 = new String(obj4);
            obj4 = obj5;
            this.a.b().w().a(obj4);
            return obj2;
            l2 = this.a;
            l2 = l2.b();
            l2 = l2.w();
            string3 = "Interrupted waiting for ";
            obj6 = runnable4.length();
            if (obj6 != null) {
            } else {
            }
            string3 = string3.concat(runnable4);
            runnable4 = new String(string3);
            string3 = runnable4;
            l2.a(string3);
            atomicReference = 0;
            return atomicReference;
        } catch (java.lang.InterruptedException interrupted) {
        } catch (Throwable th1) {
        }
    }

    public final <V> Future<V> s(Callable<V> callable) {
        Object str;
        boolean obj4;
        k();
        r.j(callable);
        w4 w4Var = new w4(this, callable, 0, "Task exception on worker thread");
        if (Thread.currentThread() == this.c) {
            if (!this.e.isEmpty()) {
                this.a.b().w().a("Callable skipped the worker queue.");
            }
            w4Var.run();
        } else {
            D(w4Var);
        }
        return w4Var;
    }

    public final <V> Future<V> t(Callable<V> callable) {
        k();
        r.j(callable);
        w4 w4Var = new w4(this, callable, 1, "Task exception on worker thread");
        if (Thread.currentThread() == this.c) {
            w4Var.run();
        } else {
            D(w4Var);
        }
        return w4Var;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void y(Runnable runnable) {
        com.google.android.gms.measurement.internal.x4 x4Var;
        Object queue;
        BlockingQueue i;
        k();
        r.j(runnable);
        w4 w4Var = new w4(this, runnable, 0, "Task exception on network thread");
        final Object obj4 = this.i;
        this.f.add(w4Var);
        x4Var = this.d;
        synchronized (obj4) {
            x4 x4Var2 = new x4(this, "Measurement Network", this.f);
            this.d = x4Var2;
            x4Var2.setUncaughtExceptionHandler(this.h);
            this.d.start();
        }
    }

    @Override // com.google.android.gms.measurement.internal.w5
    public final void z(Runnable runnable) {
        k();
        r.j(runnable);
        w4 w4Var = new w4(this, runnable, 0, "Task exception on worker thread");
        D(w4Var);
    }
}
