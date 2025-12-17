package i.b.m0.i;

import i.b.m0.c.g;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public abstract class b<T>  extends AtomicLong implements g<T> {

    private static final long serialVersionUID = -6671519529404341862L;
    public final boolean offer(T t) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Should not be called!");
        throw obj2;
    }
}
