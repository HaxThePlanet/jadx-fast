package i.b.m0.g;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class j extends i.b.m0.g.a implements Callable<Void> {

    private static final long serialVersionUID = 1811839108042568751L;
    public j(Runnable runnable) {
        super(runnable);
    }

    @Override // i.b.m0.g.a
    public Void b() {
        this.runner = Thread.currentThread();
        int i = 0;
        this.runnable.run();
        lazySet(a.a);
        this.runner = i;
        return i;
    }

    @Override // i.b.m0.g.a
    public Object call() {
        return b();
    }
}
