package i.b.m0.g;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ScheduledDirectTask.java */
/* loaded from: classes3.dex */
public final class j extends a implements Callable<Void> {

    private static final long serialVersionUID = 1811839108042568751L;
    public j(Runnable runnable) {
        super(runnable);
    }

    @Override // i.b.m0.g.a
    public Void b() {
        this.runner = Thread.currentThread();
        Thread thread2 = null;
        try {
            this.runnable.run();
        } finally {
            lazySet(a.a);
            this.runner = thread;
            throw th;
        }
        lazySet(a.a);
        this.runner = thread2;
        return thread2;
    }
}
