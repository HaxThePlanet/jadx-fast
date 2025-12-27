package i.b.m0.g;

import i.b.p0.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ScheduledDirectPeriodicTask.java */
/* loaded from: classes3.dex */
public final class i extends a implements Runnable {

    private static final long serialVersionUID = 1811839108042568751L;
    public i(Runnable runnable) {
        super(runnable);
    }

    @Override // i.b.m0.g.a
    public void run() {
        this.runner = Thread.currentThread();
        Thread thread = null;
        try {
            this.runnable.run();
            this.runner = thread;
        } catch (Throwable th) {
            this.runner = thread2;
            Thread thread2 = a.a;
            lazySet(thread2);
            a.t(th);
        }
    }
}
