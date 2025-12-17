package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008 \u0018\u00002\u00020\u00012\u00020\u0002:\u00043456B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001aJ\u0014\u0010\u001f\u001a\u00020\u00172\n\u0010 \u001a\u00060\u0019j\u0002`\u001aH\u0016J\u0014\u0010!\u001a\u00020\u000c2\n\u0010 \u001a\u00060\u0019j\u0002`\u001aH\u0002J\u0008\u0010\"\u001a\u00020\u0013H\u0016J\u0008\u0010#\u001a\u00020\u0017H\u0002J\u0008\u0010$\u001a\u00020\u0017H\u0004J\u0016\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(H\u0002J\u001c\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00132\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001aH\u0004J\u001e\u0010.\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00132\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u001700H\u0016J\u0010\u00101\u001a\u00020\u000c2\u0006\u0010 \u001a\u00020(H\u0002J\u0008\u00102\u001a\u00020\u0017H\u0016R\u0011\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004R\t\u0010\u0007\u001a\u00020\u0008X\u0082\u0004R\u0011\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0082\u0004R$\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c8B@BX\u0082\u000e¢\u0006\u000c\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00138TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015¨\u00067", d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "()V", "_delayed", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "_isCompleted", "Lkotlinx/atomicfu/AtomicBoolean;", "_queue", "", "value", "", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "nextTime", "", "getNextTime", "()J", "closeQueue", "", "dequeue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "enqueue", "task", "enqueueImpl", "processNextEvent", "rescheduleAllDelayed", "resetAll", "schedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "scheduleImpl", "", "scheduleInvokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "shouldUnpark", "shutdown", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class EventLoopImplBase extends kotlinx.coroutines.EventLoopImplPlatform implements kotlinx.coroutines.Delay {

    private static final AtomicReferenceFieldUpdater _delayed$FU;
    private static final AtomicIntegerFieldUpdater _isCompleted$FU;
    private static final AtomicReferenceFieldUpdater _queue$FU;
    @Volatile
    private volatile Object _delayed;
    @Volatile
    private volatile int _isCompleted = 0;
    @Volatile
    private volatile Object _queue;

    @Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008 \u0018\u00002\u00060\u0001j\u0002`\u00022\u0008\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\r\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\tJ\u0008\u0010%\u001a\u00020&H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u000e\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\r2\u000c\u0010\u000c\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u0012\u0010\u0008\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "nanoTime", "", "(J)V", "_heap", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class DelayedTask implements Runnable, Comparable<kotlinx.coroutines.EventLoopImplBase.DelayedTask>, kotlinx.coroutines.DisposableHandle, ThreadSafeHeapNode {

        private volatile Object _heap;
        private int index = -1;
        public long nanoTime;
        public DelayedTask(long nanoTime) {
            super();
            this.nanoTime = nanoTime;
            final int i = -1;
        }

        @Override // java.lang.Runnable
        public int compareTo(Object other) {
            return compareTo((EventLoopImplBase.DelayedTask)other);
        }

        @Override // java.lang.Runnable
        public int compareTo(kotlinx.coroutines.EventLoopImplBase.DelayedTask other) {
            int i;
            nanoTime -= nanoTime2;
            int i3 = 0;
            i = Long.compare(i2, i3) > 0 ? 1 : cmp < 0 ? -1 : 0;
            return i;
        }

        @Override // java.lang.Runnable
        public final void dispose() {
            Object obj;
            Object obj2;
            final int i = 0;
            final int i2 = 0;
            int i3 = 0;
            final Object _heap = this._heap;
            synchronized (this) {
            }
        }

        public ThreadSafeHeap<?> getHeap() {
            Object _heap;
            if (_heap instanceof ThreadSafeHeap) {
            } else {
                _heap = 0;
            }
            return _heap;
        }

        @Override // java.lang.Runnable
        public int getIndex() {
            return this.index;
        }

        @Override // java.lang.Runnable
        public final int scheduleTask(long now, kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue delayed, kotlinx.coroutines.EventLoopImplBase eventLoop) {
            long minTime;
            int timeNow;
            long nanoTime;
            int i;
            long l2;
            long l;
            final Object obj2 = this;
            minTime = now;
            final Object obj4 = eventLoop;
            final int i8 = 0;
            final int i9 = 0;
            final int i10 = 0;
            synchronized (this) {
                return 2;
            }
        }

        public void setHeap(ThreadSafeHeap<?> value) {
            int i;
            i = this._heap != EventLoop_commonKt.access$getDISPOSED_TASK$p() ? 1 : 0;
            if (i == 0) {
            } else {
                this._heap = value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
            throw illegalArgumentException;
        }

        @Override // java.lang.Runnable
        public void setIndex(int <set-?>) {
            this.index = <set-?>;
        }

        @Override // java.lang.Runnable
        public final boolean timeToExecute(long now) {
            int i;
            i = Long.compare(i2, i3) >= 0 ? 1 : 0;
            return i;
        }

        @Override // java.lang.Runnable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Delayed[nanos=").append(this.nanoTime).append(']').toString();
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0008\u001a\u00020\u0006H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class DelayedResumeTask extends kotlinx.coroutines.EventLoopImplBase.DelayedTask {

        private final kotlinx.coroutines.CancellableContinuation<Unit> cont;
        final kotlinx.coroutines.EventLoopImplBase this$0;
        public DelayedResumeTask(kotlinx.coroutines.EventLoopImplBase this$0, long nanoTime, kotlinx.coroutines.CancellableContinuation cont) {
            this.this$0 = this$0;
            super(nanoTime, cont);
            this.cont = obj4;
        }

        @Override // kotlinx.coroutines.EventLoopImplBase$DelayedTask
        public void run() {
            final int i = 0;
            this.cont.resumeUndispatched((CoroutineDispatcher)this.this$0, Unit.INSTANCE);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase$DelayedTask
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append(super.toString()).append(this.cont).toString();
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0008\u001a\u00020\tH\u0016J\u0008\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DelayedRunnableTask extends kotlinx.coroutines.EventLoopImplBase.DelayedTask {

        private final Runnable block;
        public DelayedRunnableTask(long nanoTime, Runnable block) {
            super(nanoTime, block);
            this.block = obj3;
        }

        @Override // kotlinx.coroutines.EventLoopImplBase$DelayedTask
        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase$DelayedTask
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append(super.toString()).append(this.block).toString();
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DelayedTaskQueue extends ThreadSafeHeap<kotlinx.coroutines.EventLoopImplBase.DelayedTask> {

        public long timeNow;
        public DelayedTaskQueue(long timeNow) {
            super();
            this.timeNow = timeNow;
        }
    }
    static {
        final Class<kotlinx.coroutines.EventLoopImplBase> obj3 = EventLoopImplBase.class;
        EventLoopImplBase._queue$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "_queue");
        EventLoopImplBase._delayed$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "_delayed");
        EventLoopImplBase._isCompleted$FU = AtomicIntegerFieldUpdater.newUpdater(obj3, "_isCompleted");
    }

    public EventLoopImplBase() {
        super();
        final int i = 0;
    }

    public static final boolean access$isCompleted(kotlinx.coroutines.EventLoopImplBase $this) {
        return $this.isCompleted();
    }

    private final void closeQueue() {
        boolean $i$a$AssertEventLoopImplBase$closeQueue$1;
        Object obj;
        int i2;
        boolean lockFreeTaskQueueCore;
        int i;
        kotlinx.coroutines.internal.Symbol symbol;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i3 = 0;
            if (!isCompleted()) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        final Object obj2 = this;
        final int i4 = 0;
        obj = EventLoopImplBase._queue$FU.get(this);
        i2 = 0;
        while (obj == null) {
            obj = _queue$FU.get(this);
            i2 = 0;
            lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, 1);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
            lockFreeTaskQueueCore.addLast((Runnable)obj);
        }
    }

    private final Runnable dequeue() {
        Object obj;
        int i;
        boolean firstOrNull;
        AtomicReferenceFieldUpdater _queue$FU;
        LockFreeTaskQueueCore next;
        final Object obj2 = this;
        final int i2 = 0;
        obj = EventLoopImplBase._queue$FU.get(this);
        i = 0;
        int i3 = 0;
        while (obj == null) {
            obj = _queue$FU2.get(this);
            i = 0;
            i3 = 0;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
            firstOrNull = (LockFreeTaskQueueCore)obj.removeFirstOrNull();
            AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase._queue$FU, this, obj, (LockFreeTaskQueueCore)obj.next());
        }
        return i3;
    }

    private final boolean enqueueImpl(Runnable task) {
        Object obj;
        int i;
        AtomicReferenceFieldUpdater _queue$FU;
        LockFreeTaskQueueCore lockFreeTaskQueueCore;
        int last;
        final Object obj2 = this;
        final int i2 = 0;
        obj = EventLoopImplBase._queue$FU.get(this);
        i = 0;
        lockFreeTaskQueueCore = 0;
        while (isCompleted()) {
            _queue$FU = 1;
            lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, _queue$FU);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
            lockFreeTaskQueueCore.addLast((Runnable)obj);
            lockFreeTaskQueueCore.addLast(task);
            obj = _queue$FU2.get(this);
            i = 0;
            lockFreeTaskQueueCore = 0;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
            AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase._queue$FU, this, obj, (LockFreeTaskQueueCore)obj.next());
        }
        return lockFreeTaskQueueCore;
    }

    private final boolean isCompleted() {
        int i;
        i = EventLoopImplBase._isCompleted$FU.get(this) != 0 ? 1 : 0;
        return i;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    private final void rescheduleAllDelayed() {
        long nanoTime;
        ThreadSafeHeapNode firstOrNull;
        kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            nanoTime = timeSource.nanoTime();
        } else {
            nanoTime = System.nanoTime();
        }
        firstOrNull = EventLoopImplBase._delayed$FU.get(this);
        while ((EventLoopImplBase.DelayedTaskQueue)firstOrNull != null) {
            firstOrNull = (EventLoopImplBase.DelayedTaskQueue)firstOrNull.removeFirstOrNull();
            if ((EventLoopImplBase.DelayedTask)firstOrNull == null) {
                break;
            } else {
            }
            reschedule(nanoTime, obj1);
            firstOrNull = EventLoopImplBase._delayed$FU.get(this);
        }
    }

    private final int scheduleImpl(long now, kotlinx.coroutines.EventLoopImplBase.DelayedTask delayedTask) {
        Object $this$scheduleImpl_u24lambda_u248;
        int i;
        Object obj;
        kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue delayedTaskQueue;
        int i2;
        if (isCompleted()) {
            return 1;
        }
        if ((EventLoopImplBase.DelayedTaskQueue)EventLoopImplBase._delayed$FU.get(this) == null) {
            Object obj2 = this;
            i = 0;
            delayedTaskQueue = new EventLoopImplBase.DelayedTaskQueue(now, delayedTask);
            AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase._delayed$FU, (EventLoopImplBase)obj2, 0, delayedTaskQueue);
            obj = EventLoopImplBase._delayed$FU.get(obj2);
            Intrinsics.checkNotNull(obj);
            $this$scheduleImpl_u24lambda_u248 = obj;
        }
        return obj8.scheduleTask(now, delayedTask, $this$scheduleImpl_u24lambda_u248);
    }

    private final void setCompleted(boolean value) {
        EventLoopImplBase._isCompleted$FU.set(this, value);
    }

    private final boolean shouldUnpark(kotlinx.coroutines.EventLoopImplBase.DelayedTask task) {
        ThreadSafeHeapNode peek;
        int i;
        Object obj = EventLoopImplBase._delayed$FU.get(this);
        if ((EventLoopImplBase.DelayedTaskQueue)obj != null) {
            peek = (EventLoopImplBase.DelayedTaskQueue)obj.peek();
        } else {
            peek = 0;
        }
        i = peek == task ? 1 : 0;
        return i;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long time, Continuation<? super Unit> $completion) {
        return Delay.DefaultImpls.delay(this, time, $completion);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public final void dispatch(CoroutineContext context, Runnable block) {
        enqueue(block);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public void enqueue(Runnable task) {
        boolean enqueueImpl;
        if (enqueueImpl(task)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(task);
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected long getNextTime() {
        boolean empty;
        Object peek;
        long nanoTime;
        int i = 0;
        if (Long.compare(nextTime, i) == 0) {
            return i;
        }
        Object obj = EventLoopImplBase._queue$FU.get(this);
        long l = Long.MAX_VALUE;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                if (!(LockFreeTaskQueueCore)obj.isEmpty()) {
                    return i;
                }
            } else {
                if (obj == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                    return l;
                }
            }
            return i;
        }
        peek = EventLoopImplBase._delayed$FU.get(this);
        if ((EventLoopImplBase.DelayedTaskQueue)peek != null) {
            peek = (EventLoopImplBase.DelayedTaskQueue)peek.peek();
            if ((EventLoopImplBase.DelayedTask)peek == null) {
            } else {
                kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
                if (timeSource != null) {
                    nanoTime = timeSource.nanoTime();
                } else {
                    nanoTime = System.nanoTime();
                }
            }
            return RangesKt.coerceAtLeast(nanoTime2 -= nanoTime, obj5);
        }
        return l;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public kotlinx.coroutines.DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        return Delay.DefaultImpls.invokeOnTimeout(this, timeMillis, block, context);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected boolean isEmpty() {
        int empty;
        boolean empty2;
        kotlinx.coroutines.internal.Symbol symbol;
        empty = 0;
        if (!isUnconfinedQueueEmpty()) {
            return empty;
        }
        Object obj = EventLoopImplBase._delayed$FU.get(this);
        if (obj != null && !(EventLoopImplBase.DelayedTaskQueue)obj.isEmpty()) {
            if (!obj.isEmpty()) {
                return empty;
            }
        }
        Object obj3 = EventLoopImplBase._queue$FU.get(this);
        final int i = 1;
        if (obj3 == null) {
            empty = i;
        } else {
            if (obj3 instanceof LockFreeTaskQueueCore) {
                empty = (LockFreeTaskQueueCore)obj3.isEmpty();
            } else {
                if (obj3 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                    empty = i;
                }
            }
        }
        return empty;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public long processNextEvent() {
        kotlinx.coroutines.AbstractTimeSource timeSource;
        int atImpl;
        int enqueueImpl;
        long nanoTime;
        Object obj;
        int i4;
        int i2;
        int i5;
        ThreadSafeHeapNode firstImpl;
        int i;
        ThreadSafeHeapNode threadSafeHeapNode;
        int i6;
        boolean timeToExecute;
        int i3;
        final Object obj2 = this;
        atImpl = 0;
        if (obj2.processUnconfinedEvent()) {
            return atImpl;
        }
        final Object obj3 = timeSource;
        if (obj3 != null && !(EventLoopImplBase.DelayedTaskQueue)obj3.isEmpty()) {
            if (!obj3.isEmpty()) {
                timeSource = AbstractTimeSourceKt.getTimeSource();
                if (timeSource != null) {
                    nanoTime = timeSource.nanoTime();
                } else {
                    nanoTime = System.nanoTime();
                }
                obj = obj3;
                i4 = 0;
                i2 = 0;
                i5 = 0;
                timeSource = null;
                firstImpl = (ThreadSafeHeap)obj.firstImpl();
                i = 0;
                synchronized (obj) {
                    i3 = atImpl;
                }
                if ((EventLoopImplBase.DelayedTask)i != 0) {
                }
            } else {
                i3 = atImpl;
            }
        } else {
        }
        Runnable dequeue = obj2.dequeue();
        if (dequeue != null) {
            int i7 = 0;
            int i8 = 0;
            dequeue.run();
            return i3;
        }
        return obj2.getNextTime();
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected final void resetAll() {
        final int i = 0;
        EventLoopImplBase._queue$FU.set(this, i);
        EventLoopImplBase._delayed$FU.set(this, i);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public final void schedule(long now, kotlinx.coroutines.EventLoopImplBase.DelayedTask delayedTask) {
        int scheduleImpl;
        switch (scheduleImpl) {
            case 0:
                unpark();
                break;
            case 1:
                reschedule(now, delayedTask);
                break;
            case 2:
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("unexpected result".toString());
                throw illegalStateException;
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected final kotlinx.coroutines.DisposableHandle scheduleInvokeOnTimeout(long timeMillis, Runnable block) {
        long iNSTANCE;
        Object delayedRunnableTask;
        kotlinx.coroutines.EventLoopImplBase.DelayedRunnableTask runnable;
        Runnable i;
        kotlinx.coroutines.EventLoopImplBase.DelayedRunnableTask runnable2;
        final long delayToNanos = EventLoop_commonKt.delayToNanos(timeMillis);
        if (Long.compare(delayToNanos, l) < 0) {
            kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                iNSTANCE = timeSource.nanoTime();
            } else {
                iNSTANCE = System.nanoTime();
            }
            delayedRunnableTask = new EventLoopImplBase.DelayedRunnableTask(iNSTANCE + delayToNanos, obj6, obj11);
            i = 0;
            schedule(iNSTANCE, obj3);
        } else {
            delayedRunnableTask = iNSTANCE;
        }
        return delayedRunnableTask;
    }

    public void scheduleResumeAfterDelay(long timeMillis, kotlinx.coroutines.CancellableContinuation<? super Unit> continuation) {
        long nanoTime;
        kotlinx.coroutines.EventLoopImplBase.DelayedResumeTask delayedResumeTask;
        int i;
        Object task;
        final long delayToNanos = EventLoop_commonKt.delayToNanos(timeMillis);
        if (Long.compare(delayToNanos, l) < 0) {
            kotlinx.coroutines.AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                nanoTime = timeSource.nanoTime();
            } else {
                nanoTime = System.nanoTime();
            }
            delayedResumeTask = new EventLoopImplBase.DelayedResumeTask(this, nanoTime + delayToNanos, obj6, obj10);
            i = 0;
            schedule(nanoTime, obj3);
            CancellableContinuationKt.disposeOnCancellation(obj10, (DisposableHandle)delayedResumeTask);
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public void shutdown() {
        int cmp;
        int i;
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        setCompleted(true);
        closeQueue();
        while (Long.compare(nextEvent, i) > 0) {
        }
        rescheduleAllDelayed();
    }
}
