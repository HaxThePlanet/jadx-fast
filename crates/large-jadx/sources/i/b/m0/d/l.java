package i.b.m0.d;

import i.b.p0.a;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DeferredScalarDisposable.java */
/* loaded from: classes3.dex */
public class l<T> extends b<T> {

    private static final long serialVersionUID = -5502432239815349361L;
    protected final y<? super T> downstream;
    protected T value;
    public l(y<? super T> yVar) {
        super();
        this.downstream = yVar;
    }

    @Override // i.b.m0.d.b
    public final void a() {
        if (get() & 54 != 0) {
            return;
        }
        lazySet(2);
        this.downstream.onComplete();
    }

    @Override // i.b.m0.d.b
    public final void b(T t) {
        int i = get();
        if (i & 54 != 0) {
            return;
        }
        if (i == 8) {
            this.value = t;
            lazySet(16);
            Object obj = null;
            this.downstream.onNext(obj);
        } else {
            i = 2;
            lazySet(i);
            this.downstream.onNext(t);
        }
        if (get() != 4) {
            this.downstream.onComplete();
        }
    }

    @Override // i.b.m0.d.b
    public final void c(Throwable th) {
        if (get() & 54 != 0) {
            a.t(th);
            return;
        }
        lazySet(2);
        this.downstream.onError(th);
    }

    @Override // i.b.m0.d.b
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    @Override // i.b.m0.d.b
    public void dispose() {
        set(4);
        this.value = null;
    }

    @Override // i.b.m0.d.b
    public final boolean isDisposed() {
        boolean z = true;
        int r0 = get() == 4 ? 1 : 0;
        return (get() == 4 ? 1 : 0);
    }

    @Override // i.b.m0.d.b
    public final boolean isEmpty() {
        boolean z = true;
        int r0 = get() != 16 ? 1 : 0;
        return (get() != 16 ? 1 : 0);
    }

    @Override // i.b.m0.d.b
    public final T poll() {
        Object obj = null;
        if (get() == 16) {
            this.value = obj;
            lazySet(32);
            return this.value;
        }
        return obj;
    }

    @Override // i.b.m0.d.b
    public final int requestFusion(int i) {
        final int i2 = 2;
        if (i & i2 != 0) {
            lazySet(8);
            return i2;
        }
        return 0;
    }
}
