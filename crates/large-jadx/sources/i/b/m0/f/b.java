package i.b.m0.f;

import i.b.m0.c.i;
import i.b.m0.j.q;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class b<E>  extends AtomicReferenceArray<E> implements i<E> {

    private static final Integer a = null;
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;
    static {
        b.a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    }

    public b(int i) {
        super(q.a(i));
        this.mask = length--;
        AtomicLong atomicLong = new AtomicLong();
        this.producerIndex = atomicLong;
        AtomicLong atomicLong2 = new AtomicLong();
        this.consumerIndex = atomicLong2;
        this.lookAheadStep = Math.min(i /= 4, b.a.intValue());
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    int a(long l) {
        return obj1 &= obj2;
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    int b(long l, int i2) {
        return obj1 &= obj3;
    }

    E c(int i) {
        return get(i);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public void clear() {
        Object empty;
        while (poll() == null) {
            if (!isEmpty()) {
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    void d(long l) {
        this.consumerIndex.lazySet(l);
    }

    void e(int i, E e2) {
        lazySet(i, e2);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    void f(long l) {
        this.producerIndex.lazySet(l);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public boolean isEmpty() {
        int i;
        i = Long.compare(l, l2) == 0 ? 1 : 0;
        return i;
    }

    public boolean offer(E e) {
        int mask;
        int cmp;
        Objects.requireNonNull(e, "Null is not a valid element");
        mask = this.mask;
        long l = this.producerIndex.get();
        int i3 = b(l, obj2);
        if (Long.compare(l, producerLookAhead) >= 0) {
            l2 += l;
            if (c(b(cmp, obj5)) == null) {
                this.producerLookAhead = cmp;
            } else {
                if (c(i3) != null) {
                    return 0;
                }
            }
        }
        e(i3, e);
        f(l += i4);
        return 1;
    }

    public E poll() {
        long l = this.consumerIndex.get();
        final int i2 = a(l);
        final Object obj = c(i2);
        final int i3 = 0;
        if (obj == null) {
            return i3;
        }
        d(l += i4);
        e(i2, i3);
        return obj;
    }
}
