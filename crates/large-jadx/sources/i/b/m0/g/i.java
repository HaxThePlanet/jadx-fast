package i.b.m0.g;

import i.b.p0.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class i extends i.b.m0.g.a implements Runnable {

    private static final long serialVersionUID = 1811839108042568751L;
    public i(Runnable runnable) {
        super(runnable);
    }

    @Override // i.b.m0.g.a
    public void run() {
        int i;
        Runnable runnable;
        this.runner = Thread.currentThread();
        this.runnable.run();
        this.runner = 0;
    }
}
