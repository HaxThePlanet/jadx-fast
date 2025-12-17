package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0007J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002J\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0016\u0010#\u001a\u0004\u0018\u00010\u00072\n\u0010$\u001a\u00060\tj\u0002`%H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\"\u0010(\u001a\u00020)2\n\u0010$\u001a\u00060\tj\u0002`%2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+J$\u0010,\u001a\u00020)2\n\u0010$\u001a\u00060\tj\u0002`%2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+H\u0002J\u000e\u0010-\u001a\u00020\u0018*\u0004\u0018\u00010\u0007H\u0002R\t\u0010\u0003\u001a\u00020\u0004X\u0082\u0004R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\t\u0010\u000c\u001a\u00020\u0004X\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eX\u0082\u0004R\t\u0010\u000f\u001a\u00020\u0004X\u0082\u0004R\u0014\u0010\u0010\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000b¨\u0006.", d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "()V", "blockingTasksInBuffer", "Lkotlinx/atomicfu/AtomicInt;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "bufferSize", "", "getBufferSize", "()I", "consumerIndex", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", "size", "getSize$kotlinx_coroutines_core", "add", "task", "fair", "", "addLast", "offloadAllWorkTo", "", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "poll", "pollBlocking", "pollBuffer", "pollCpu", "pollTo", "queue", "pollWithExclusiveMode", "onlyBlocking", "stealWithExclusiveMode", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "tryExtractFromTheMiddle", "index", "trySteal", "", "stolenTaskRef", "Lkotlin/jvm/internal/Ref$ObjectRef;", "tryStealLastScheduled", "decrementIfBlocking", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WorkQueue {

    private static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU;
    private static final AtomicIntegerFieldUpdater consumerIndex$FU;
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU;
    private static final AtomicIntegerFieldUpdater producerIndex$FU;
    @Volatile
    private volatile int blockingTasksInBuffer;
    private final AtomicReferenceArray<kotlinx.coroutines.scheduling.Task> buffer;
    @Volatile
    private volatile int consumerIndex;
    @Volatile
    private volatile Object lastScheduledTask;
    @Volatile
    private volatile int producerIndex;
    static {
        final Class<kotlinx.coroutines.scheduling.WorkQueue> obj2 = WorkQueue.class;
        WorkQueue.lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(obj2, Object.class, "lastScheduledTask");
        WorkQueue.producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(obj2, "producerIndex");
        WorkQueue.consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(obj2, "consumerIndex");
        WorkQueue.blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(obj2, "blockingTasksInBuffer");
    }

    public WorkQueue() {
        super();
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(128);
        this.buffer = atomicReferenceArray;
    }

    public static kotlinx.coroutines.scheduling.Task add$default(kotlinx.coroutines.scheduling.WorkQueue workQueue, kotlinx.coroutines.scheduling.Task task2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return workQueue.add(task2, obj2);
    }

    private final kotlinx.coroutines.scheduling.Task addLast(kotlinx.coroutines.scheduling.Task task) {
        Object blockingTasksInBuffer$FU;
        int i2;
        int i;
        i2 = 127;
        if (getBufferSize() == i2) {
            return task;
        }
        final int i6 = 0;
        if (blockingTasksInBuffer$FU.taskContext.getTaskMode() == 1) {
        } else {
            i = 0;
        }
        if (i != 0) {
            WorkQueue.blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        i3 &= i2;
        while (this.buffer.get(i4) != 0) {
            Thread.yield();
        }
        this.buffer.lazySet(i4, task);
        WorkQueue.producerIndex$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(kotlinx.coroutines.scheduling.Task $this$decrementIfBlocking) {
        int $this$isBlocking$iv;
        int aSSERTIONS_ENABLED;
        int taskMode;
        int i;
        int i2;
        if ($this$decrementIfBlocking != null) {
            aSSERTIONS_ENABLED = 0;
            i2 = 1;
            $this$isBlocking$iv = obj.taskContext.getTaskMode() == i2 ? i2 : i;
            aSSERTIONS_ENABLED = 0;
            if ($this$isBlocking$iv != 0 && DebugKt.getASSERTIONS_ENABLED() && WorkQueue.blockingTasksInBuffer$FU.decrementAndGet(this) >= 0) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    aSSERTIONS_ENABLED = 0;
                    if (WorkQueue.blockingTasksInBuffer$FU.decrementAndGet(this) >= 0) {
                        i = i2;
                    }
                    if (i == 0) {
                    } else {
                    }
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
            }
        }
    }

    private final int getBufferSize() {
        return i -= i3;
    }

    private final kotlinx.coroutines.scheduling.Task pollBuffer() {
        int i;
        int i2;
        int andSet;
        boolean compareAndSet;
        int i3;
        i = WorkQueue.consumerIndex$FU.get(this);
        andSet = 0;
        while (i - i4 == 0) {
            i = WorkQueue.consumerIndex$FU.get(this);
            andSet = 0;
            andSet = this.buffer.getAndSet(i & 127, andSet);
        }
        return andSet;
    }

    private final boolean pollTo(kotlinx.coroutines.scheduling.GlobalQueue queue) {
        kotlinx.coroutines.scheduling.Task pollBuffer = pollBuffer();
        if (pollBuffer == null) {
            return 0;
        }
        queue.addLast(pollBuffer);
        return 1;
    }

    private final kotlinx.coroutines.scheduling.Task pollWithExclusiveMode(boolean onlyBlocking) {
        Object obj;
        boolean z;
        Object lastScheduledTask$FU;
        int end;
        int tryExtractFromTheMiddle;
        int taskMode;
        int i;
        obj = WorkQueue.lastScheduledTask$FU.get(this);
        int i3 = 0;
        while ((Task)obj == null) {
            tryExtractFromTheMiddle = 0;
            if (lastScheduledTask$FU.taskContext.getTaskMode() == 1) {
            } else {
            }
            i = 0;
            obj = WorkQueue.lastScheduledTask$FU.get(this);
            i3 = 0;
        }
        end = WorkQueue.producerIndex$FU.get(this);
        while (WorkQueue.consumerIndex$FU.get(this) != end) {
            tryExtractFromTheMiddle = tryExtractFromTheMiddle(end--, onlyBlocking);
        }
        return i3;
    }

    private final kotlinx.coroutines.scheduling.Task stealWithExclusiveMode(int stealingMode) {
        int i;
        int i4;
        int i2;
        int i3;
        i = WorkQueue.consumerIndex$FU.get(this);
        if (stealingMode == 1) {
        } else {
            i4 = 0;
        }
        int i6 = 0;
        while (i != WorkQueue.producerIndex$FU.get(this)) {
            kotlinx.coroutines.scheduling.Task tryExtractFromTheMiddle = tryExtractFromTheMiddle(i, i4);
            i = i2;
            i6 = 0;
        }
        return i6;
    }

    private final kotlinx.coroutines.scheduling.Task tryExtractFromTheMiddle(int index, boolean onlyBlocking) {
        int blockingTasksInBuffer$FU;
        Object obj;
        int i2;
        int taskMode;
        int i;
        final int i3 = index & 127;
        Object obj2 = this.buffer.get(i3);
        blockingTasksInBuffer$FU = 0;
        if ((Task)obj2 != null) {
            i2 = 0;
            if (obj.taskContext.getTaskMode() == 1) {
            } else {
                i = 0;
            }
            if (i == onlyBlocking && ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.buffer, i3, obj2, blockingTasksInBuffer$FU) && onlyBlocking != 0) {
                if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this.buffer, i3, obj2, blockingTasksInBuffer$FU)) {
                    if (onlyBlocking != 0) {
                        WorkQueue.blockingTasksInBuffer$FU.decrementAndGet(this);
                    }
                    return obj2;
                }
            }
        }
        return blockingTasksInBuffer$FU;
    }

    private final long tryStealLastScheduled(int stealingMode, Ref.ObjectRef<kotlinx.coroutines.scheduling.Task> stolenTaskRef) {
        Object obj;
        long nanoTime;
        int i;
        int i3;
        boolean z;
        int i5;
        int i4;
        int i2;
        obj = WorkQueue.lastScheduledTask$FU.get(this);
        int i6 = -2;
        while ((Task)obj == null) {
            i3 = 0;
            int i9 = 0;
            i2 = 1;
            if (obj3.taskContext.getTaskMode() == i2) {
            } else {
            }
            i4 = 0;
            if (i4 != 0) {
            } else {
            }
            i2 = 2;
            i = nanoTime - submissionTime;
            obj = WorkQueue.lastScheduledTask$FU.get(this);
            i6 = -2;
            i4 = i2;
        }
        return i6;
    }

    public final kotlinx.coroutines.scheduling.Task add(kotlinx.coroutines.scheduling.Task task, boolean fair) {
        if (fair) {
            return addLast(task);
        }
        Object andSet = WorkQueue.lastScheduledTask$FU.getAndSet(this, task);
        if ((Task)andSet == null) {
            return null;
        }
        return addLast((Task)andSet);
    }

    public final int getSize$kotlinx_coroutines_core() {
        int bufferSize;
        if (WorkQueue.lastScheduledTask$FU.get(this) != null) {
            bufferSize2++;
        } else {
            bufferSize = getBufferSize();
        }
        return bufferSize;
    }

    public final void offloadAllWorkTo(kotlinx.coroutines.scheduling.GlobalQueue globalQueue) {
        Object andSet;
        int i;
        andSet = WorkQueue.lastScheduledTask$FU.getAndSet(this, 0);
        if ((Task)andSet != null) {
            i = 0;
            globalQueue.addLast((Task)andSet);
        }
        while (pollTo(globalQueue) == null) {
        }
    }

    public final kotlinx.coroutines.scheduling.Task poll() {
        Object pollBuffer;
        if ((Task)WorkQueue.lastScheduledTask$FU.getAndSet(this, 0) == null) {
            pollBuffer = pollBuffer();
        }
        return pollBuffer;
    }

    public final kotlinx.coroutines.scheduling.Task pollBlocking() {
        return pollWithExclusiveMode(true);
    }

    public final kotlinx.coroutines.scheduling.Task pollCpu() {
        return pollWithExclusiveMode(false);
    }

    public final long trySteal(int stealingMode, Ref.ObjectRef<kotlinx.coroutines.scheduling.Task> stolenTaskRef) {
        kotlinx.coroutines.scheduling.Task stealWithExclusiveMode;
        if (stealingMode == 3) {
            stealWithExclusiveMode = pollBuffer();
        } else {
            stealWithExclusiveMode = stealWithExclusiveMode(stealingMode);
        }
        if (stealWithExclusiveMode != null) {
            stolenTaskRef.element = stealWithExclusiveMode;
            return -1;
        }
        return tryStealLastScheduled(stealingMode, stolenTaskRef);
    }
}
