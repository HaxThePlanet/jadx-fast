package i.b.m0.i;

import i.b.m0.c.g;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.b;

/* compiled from: ScalarSubscription.java */
/* loaded from: classes3.dex */
public final class e<T> extends AtomicInteger implements g<T> {

    private static final long serialVersionUID = -3830916580126663321L;
    final b<? super T> subscriber;
    final T value;
    public e(b<? super T> bVar, T t) {
        super();
        this.subscriber = bVar;
        this.value = t;
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void cancel() {
        lazySet(2);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void clear() {
        lazySet(1);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean isEmpty() {
        boolean z = true;
        int r0 = get() != 0 ? 1 : 0;
        return (get() != 0 ? 1 : 0);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.value;
        }
        return null;
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void request(long j) {
        if (!g.validate(j)) {
            return;
        }
        int i2 = 1;
        if (compareAndSet(0, i2)) {
            this.subscriber.onNext(this.value);
            int i = 2;
            if (get() != 2) {
                this.subscriber.onComplete();
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public int requestFusion(int i) {
        return i & 1;
    }
}
