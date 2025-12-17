package kotlin.i0.z.e.m0.k;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes3.dex */
public final class c extends kotlin.i0.z.e.m0.k.d {

    private final Runnable c;
    private final l<java.lang.InterruptedException, w> d;
    public c(Runnable runnable, l<? super java.lang.InterruptedException, w> l2) {
        n.f(runnable, "checkCancelled");
        n.f(l2, "interruptedExceptionHandler");
        ReentrantLock reentrantLock = new ReentrantLock();
        super(reentrantLock, runnable, l2);
    }

    public c(Lock lock, Runnable runnable2, l<? super java.lang.InterruptedException, w> l3) {
        n.f(lock, "lock");
        n.f(runnable2, "checkCancelled");
        n.f(l3, "interruptedExceptionHandler");
        super(lock);
        this.c = runnable2;
        this.d = l3;
    }

    @Override // kotlin.i0.z.e.m0.k.d
    public void lock() {
        boolean tryLock;
        int i;
        try {
            while (!a().tryLock(50, obj2)) {
                this.c.run();
            }
            this.c.run();
            this.d.invoke(th);
        }
    }
}
