package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class b implements ThreadFactory {

    public final AtomicInteger a;
    public b(AtomicInteger atomicInteger) {
        super();
        this.a = atomicInteger;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return y.l0(this.a, runnable);
    }
}
