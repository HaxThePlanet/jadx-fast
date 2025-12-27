package i.b.m0.d;

import i.b.m0.c.e;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BasicIntQueueDisposable.java */
/* loaded from: classes3.dex */
public abstract class b<T> extends AtomicInteger implements e<T> {

    private static final long serialVersionUID = -1001730202384742097L;
    @Override // java.util.concurrent.atomic.AtomicInteger
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
