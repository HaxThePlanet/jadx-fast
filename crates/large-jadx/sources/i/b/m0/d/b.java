package i.b.m0.d;

import i.b.m0.c.e;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class b<T>  extends AtomicInteger implements e<T> {

    private static final long serialVersionUID = -1001730202384742097L;
    public final boolean offer(T t) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Should not be called");
        throw obj2;
    }
}
