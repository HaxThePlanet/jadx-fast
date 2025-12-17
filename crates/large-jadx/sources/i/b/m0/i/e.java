package i.b.m0.i;

import i.b.m0.c.g;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.b;

/* loaded from: classes3.dex */
public final class e<T>  extends AtomicInteger implements g<T> {

    private static final long serialVersionUID = -3830916580126663321L;
    final b<? super T> subscriber;
    final T value;
    public e(b<? super T> b, T t2) {
        super();
        this.subscriber = b;
        this.value = t2;
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
        int i;
        i = get() != 0 ? 1 : 0;
        return i;
    }

    public boolean offer(T t) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Should not be called!");
        throw obj2;
    }

    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.value;
        }
        return 0;
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void request(long l) {
        int i;
        boolean obj2;
        int obj3;
        if (!g.validate(l)) {
        }
        obj2 = this.subscriber;
        obj2.onNext(this.value);
        if (compareAndSet(0, 1) && get() != 2) {
            obj2 = this.subscriber;
            obj2.onNext(this.value);
            if (get() != 2) {
                obj2.onComplete();
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public int requestFusion(int i) {
        return i &= 1;
    }
}
