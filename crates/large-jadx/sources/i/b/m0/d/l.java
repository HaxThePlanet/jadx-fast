package i.b.m0.d;

import i.b.p0.a;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class l<T>  extends i.b.m0.d.b<T> {

    private static final long serialVersionUID = -5502432239815349361L;
    protected final y<? super T> downstream;
    protected T value;
    public l(y<? super T> y) {
        super();
        this.downstream = y;
    }

    @Override // i.b.m0.d.b
    public final void a() {
        if (i &= 54 != 0) {
        }
        lazySet(2);
        this.downstream.onComplete();
    }

    public final void b(T t) {
        int i;
        int obj4;
        i = get();
        if (i & 54 != 0) {
        }
        y downstream = this.downstream;
        if (i == 8) {
            this.value = t;
            lazySet(16);
            downstream.onNext(0);
        } else {
            lazySet(2);
            downstream.onNext(t);
        }
        if (get() != 4) {
            downstream.onComplete();
        }
    }

    @Override // i.b.m0.d.b
    public final void c(Throwable throwable) {
        if (i &= 54 != 0) {
            a.t(throwable);
        }
        lazySet(2);
        this.downstream.onError(throwable);
    }

    @Override // i.b.m0.d.b
    public final void clear() {
        lazySet(32);
        this.value = 0;
    }

    @Override // i.b.m0.d.b
    public void dispose() {
        set(4);
        this.value = 0;
    }

    @Override // i.b.m0.d.b
    public final boolean isDisposed() {
        int i;
        i = get() == 4 ? 1 : 0;
        return i;
    }

    @Override // i.b.m0.d.b
    public final boolean isEmpty() {
        int i;
        i = get() != 16 ? 1 : 0;
        return i;
    }

    public final T poll() {
        int i2 = 0;
        if (get() == 16) {
            this.value = i2;
            lazySet(32);
            return this.value;
        }
        return i2;
    }

    @Override // i.b.m0.d.b
    public final int requestFusion(int i) {
        final int i2 = 2;
        if (i &= i2 != 0) {
            lazySet(8);
            return i2;
        }
        return 0;
    }
}
