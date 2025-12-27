package i.b.m0.f;

import i.b.m0.c.i;
import i.b.m0.j.q;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscArrayQueue.java */
/* loaded from: classes3.dex */
public final class b<E> extends AtomicReferenceArray<E> implements i<E> {

    private static final Integer a;
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex = new AtomicLong();
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;
    static {
        b.a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    }

    public b(int i) {
        super(q.a(i));
        this.mask = length() - 1;
        AtomicLong atomicLong = new AtomicLong();
        AtomicLong atomicLong2 = new AtomicLong();
        this.lookAheadStep = Math.min(i / 4, b.a.intValue());
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    int a(long j) {
        return (int)j & this.mask;
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    E c(int i) {
        return get(i);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public void clear() {
        while (poll() == null) {
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    void d(long j) {
        this.consumerIndex.lazySet(j);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    void e(int i, E e) {
        lazySet(i, e);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    void f(long j) {
        this.producerIndex.lazySet(j);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public boolean isEmpty() {
        boolean z = true;
        long l = this.producerIndex.get();
        long l2 = this.consumerIndex.get();
        int r0 = l == l2 ? 1 : 0;
        return (l == l2 ? 1 : 0);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public boolean offer(E e) {
        Objects.requireNonNull(e, "Null is not a valid element");
        long l = this.producerIndex.get();
        int i3 = b(l, this.mask);
        if (l >= this.producerLookAhead) {
            long l4 = (long)this.lookAheadStep + l;
            if (c(b(l4, this.mask)) != null) {
                if (c(i3) != null) {
                    return false;
                }
            } else {
                this.producerLookAhead = l4;
            }
        }
        e(i3, e);
        f(l + 1L);
        return true;
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public E poll() {
        long l = this.consumerIndex.get();
        final int i = a(l);
        final Object obj2 = c(i);
        final Object obj3 = null;
        if (obj2 == null) {
            return obj3;
        }
        d(l + 1L);
        e(i, obj3);
        return obj2;
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    int b(long j, int i) {
        return (int)j & i;
    }
}
