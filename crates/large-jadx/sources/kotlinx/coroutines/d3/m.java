package kotlinx.coroutines.d3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.q0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0000\u0008\u0000\u0018\u00002\u00020*B\u0007¢\u0006\u0004\u0008\u0001\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\u000b¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\u0008\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\u0008\u001a\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\r*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\u0008\u001e\u0010\u001fR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008!\u0010\"R\u0014\u0010&\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0014\u0010(\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010%¨\u0006)", d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m {

    private static final AtomicReferenceFieldUpdater b;
    private static final AtomicIntegerFieldUpdater c;
    private static final AtomicIntegerFieldUpdater d;
    private static final AtomicIntegerFieldUpdater e;
    private final AtomicReferenceArray<kotlinx.coroutines.d3.i> a;
    private volatile int blockingTasksInBuffer = 0;
    private volatile int consumerIndex = 0;
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;
    static {
        Class<kotlinx.coroutines.d3.m> obj = m.class;
        m.b = AtomicReferenceFieldUpdater.newUpdater(obj, Object.class, "lastScheduledTask");
        m.c = AtomicIntegerFieldUpdater.newUpdater(obj, "producerIndex");
        m.d = AtomicIntegerFieldUpdater.newUpdater(obj, "consumerIndex");
        m.e = AtomicIntegerFieldUpdater.newUpdater(obj, "blockingTasksInBuffer");
    }

    public m() {
        super();
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(128);
        this.a = atomicReferenceArray;
        int i = 0;
        int i2 = 0;
    }

    public static kotlinx.coroutines.d3.i b(kotlinx.coroutines.d3.m m, kotlinx.coroutines.d3.i i2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return m.a(i2, obj2);
    }

    private final kotlinx.coroutines.d3.i c(kotlinx.coroutines.d3.i i) {
        int i3;
        int i4;
        int i2;
        if (i.b.r() == 1) {
        } else {
            i4 = 0;
        }
        if (i4 != 0) {
            m.e.incrementAndGet(this);
        }
        i2 = 127;
        if (e() == i2) {
            return i;
        }
        producerIndex &= i2;
        while (this.a.get(i6) != 0) {
            Thread.yield();
        }
        this.a.lazySet(i6, i);
        m.c.incrementAndGet(this);
        return null;
    }

    private final void d(kotlinx.coroutines.d3.i i) {
        int i2;
        int i3;
        boolean z;
        Object obj4;
        if (i != null) {
            i3 = 1;
            obj4 = i.b.r() == i3 ? i3 : i2;
            if (obj4 != null && q0.a() && m.e.decrementAndGet(this) >= 0) {
                if (q0.a()) {
                    if (m.e.decrementAndGet(this) >= 0) {
                        i2 = i3;
                    }
                    if (i2 == 0) {
                    } else {
                    }
                    obj4 = new AssertionError();
                    throw obj4;
                }
            }
        }
    }

    private final kotlinx.coroutines.d3.i i() {
        boolean compareAndSet;
        int i;
        AtomicIntegerFieldUpdater num;
        int i2;
        int consumerIndex = this.consumerIndex;
        final int i4 = 0;
        while (consumerIndex - producerIndex == 0) {
            consumerIndex = this.consumerIndex;
            i4 = 0;
            compareAndSet = this.a.getAndSet(consumerIndex & 127, i4);
        }
        return i4;
    }

    private final boolean j(kotlinx.coroutines.d3.d d) {
        final kotlinx.coroutines.d3.i iVar = i();
        if (iVar == null) {
            return 0;
        }
        d.a(iVar);
        return 1;
    }

    private final long m(kotlinx.coroutines.d3.m m, boolean z2) {
        int i;
        int i2;
        final Object lastScheduledTask = m.lastScheduledTask;
        int i3 = -2;
        while ((i)lastScheduledTask == null) {
            final int i6 = 0;
            l -= l2;
            long l3 = l.a;
            final int i5 = 0;
            lastScheduledTask = m.lastScheduledTask;
            i3 = -2;
            if (lastScheduledTask.b.r() == 1) {
            } else {
            }
            i2 = i6;
        }
        return i3;
    }

    public final kotlinx.coroutines.d3.i a(kotlinx.coroutines.d3.i i, boolean z2) {
        if (z2) {
            return c(i);
        }
        Object obj1 = m.b.getAndSet(this, i);
        if ((i)obj1 == null) {
            return null;
        }
        return c((i)obj1);
    }

    public final int e() {
        return producerIndex -= consumerIndex;
    }

    public final int f() {
        int i;
        if (this.lastScheduledTask != null) {
            i2++;
        } else {
            i = e();
        }
        return i;
    }

    public final void g(kotlinx.coroutines.d3.d d) {
        Object andSet;
        andSet = m.b.getAndSet(this, 0);
        if ((i)andSet == null) {
        } else {
            d.a((i)andSet);
        }
        while (j(d)) {
        }
    }

    public final kotlinx.coroutines.d3.i h() {
        Object andSet;
        if ((i)m.b.getAndSet(this, 0) == null) {
            andSet = i();
        }
        return andSet;
    }

    public final long k(kotlinx.coroutines.d3.m m) {
        int z;
        int consumerIndex;
        int compareAndSet;
        Object blockingTasksInBuffer;
        int i;
        final int i4 = 0;
        final int i5 = 1;
        if (q0.a()) {
            z = e() == 0 ? i5 : i4;
            if (z == 0) {
            } else {
            }
            AssertionError obj9 = new AssertionError();
            throw obj9;
        }
        consumerIndex = m.consumerIndex;
        final AtomicReferenceArray atomicReferenceArray = m.a;
        while (consumerIndex != m.producerIndex) {
            compareAndSet = consumerIndex & 127;
            blockingTasksInBuffer = atomicReferenceArray.get(compareAndSet);
            consumerIndex++;
            if (blockingTasksInBuffer.b.r() == i5) {
            } else {
            }
            i = i4;
            i = 0;
            i = i5;
        }
        return m(m, i5);
    }

    public final long l(kotlinx.coroutines.d3.m m) {
        int z;
        int i;
        final int i4 = 0;
        if (q0.a()) {
            z = e() == 0 ? i : i4;
            if (z == 0) {
            } else {
            }
            AssertionError obj5 = new AssertionError();
            throw obj5;
        }
        kotlinx.coroutines.d3.i iVar = m.i();
        if (iVar != null && q0.a()) {
            if (q0.a()) {
                if (m.b(this, iVar, i4, 2, 0) == null) {
                } else {
                    i = i4;
                }
                if (i == 0) {
                } else {
                }
                obj5 = new AssertionError();
                throw obj5;
            }
            return -1;
        }
        return m(m, i4);
    }
}
