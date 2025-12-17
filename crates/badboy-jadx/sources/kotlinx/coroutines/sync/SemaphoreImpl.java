package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\u0008\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0016\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017Jb\u0010\u0016\u001a\u00020\u0014\"\u0004\u0008\u0000\u0010\u00182\u0006\u0010\u0019\u001a\u0002H\u00182!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\u000c\u0008\u001b\u0012\u0008\u0008\u001c\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u001d0\u00122!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\u000c\u0008\u001b\u0012\u0008\u0008\u001c\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00140\u0012H\u0083\u0008¢\u0006\u0002\u0010\u001fJ\u0016\u0010\u0016\u001a\u00020\u00142\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00140 H\u0005J\u0011\u0010!\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020#H\u0002J\u0008\u0010$\u001a\u00020\u0014H\u0002J\u0008\u0010%\u001a\u00020\u0003H\u0002J\u001e\u0010&\u001a\u00020\u00142\n\u0010'\u001a\u0006\u0012\u0002\u0008\u00030(2\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0004J\u0008\u0010+\u001a\u00020\u0014H\u0016J\u0008\u0010,\u001a\u00020\u001dH\u0016J\u0008\u0010-\u001a\u00020\u001dH\u0002J\u000c\u0010.\u001a\u00020\u001d*\u00020*H\u0002R\t\u0010\u0006\u001a\u00020\u0007X\u0082\u0004R\u0014\u0010\u0008\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\t\u0010\u000b\u001a\u00020\u000cX\u0082\u0004R\t\u0010\r\u001a\u00020\u000cX\u0082\u0004R\u000f\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006/", d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "", "acquiredPermits", "(II)V", "_availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "availablePermits", "getAvailablePermits", "()I", "deqIdx", "Lkotlinx/atomicfu/AtomicLong;", "enqIdx", "head", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "onCancellationRelease", "Lkotlin/Function1;", "", "", "tail", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "W", "waiter", "suspend", "Lkotlin/ParameterName;", "name", "", "onAcquired", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancellableContinuation;", "acquireSlowPath", "addAcquireToQueue", "Lkotlinx/coroutines/Waiter;", "coerceAvailablePermitsAtMaximum", "decPermits", "onAcquireRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "", "release", "tryAcquire", "tryResumeNextFromQueue", "tryResumeAcquire", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SemaphoreImpl implements kotlinx.coroutines.sync.Semaphore {

    private static final AtomicIntegerFieldUpdater _availablePermits$FU;
    private static final AtomicLongFieldUpdater deqIdx$FU;
    private static final AtomicLongFieldUpdater enqIdx$FU;
    private static final AtomicReferenceFieldUpdater head$FU;
    private static final AtomicReferenceFieldUpdater tail$FU;
    @Volatile
    private volatile int _availablePermits;
    @Volatile
    private volatile long deqIdx;
    @Volatile
    private volatile long enqIdx;
    @Volatile
    private volatile Object head;
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;
    @Volatile
    private volatile Object tail;
    static {
        final Class<kotlinx.coroutines.sync.SemaphoreImpl> obj3 = SemaphoreImpl.class;
        SemaphoreImpl.head$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "head");
        SemaphoreImpl.deqIdx$FU = AtomicLongFieldUpdater.newUpdater(obj3, "deqIdx");
        SemaphoreImpl.tail$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "tail");
        SemaphoreImpl.enqIdx$FU = AtomicLongFieldUpdater.newUpdater(obj3, "enqIdx");
        SemaphoreImpl._availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(obj3, "_availablePermits");
    }

    public SemaphoreImpl(int permits, int acquiredPermits) {
        int permits2;
        int i;
        super();
        this.permits = permits;
        int i6 = 0;
        permits2 = this.permits > 0 ? i : i6;
        if (permits2 == 0) {
        } else {
            if (acquiredPermits >= 0 && acquiredPermits <= this.permits) {
                if (acquiredPermits <= this.permits) {
                } else {
                    i = i6;
                }
            } else {
            }
            if (i == 0) {
            } else {
                SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0, obj4, 0, 2);
                this.head = semaphoreSegment;
                this.tail = semaphoreSegment;
                this._availablePermits = permits4 -= acquiredPermits;
                SemaphoreImpl.onCancellationRelease.1 anon = new SemaphoreImpl.onCancellationRelease.1(this);
                this.onCancellationRelease = (Function1)anon;
            }
            int i3 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("The number of acquired permits should be in 0..").append(this.permits).toString().toString());
            throw illegalArgumentException2;
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Semaphore should have at least 1 permit, but had ").append(this.permits).toString().toString());
        throw illegalArgumentException;
    }

    public static final Object access$acquireSlowPath(kotlinx.coroutines.sync.SemaphoreImpl $this, Continuation $completion) {
        return $this.acquireSlowPath($completion);
    }

    public static final boolean access$addAcquireToQueue(kotlinx.coroutines.sync.SemaphoreImpl $this, Waiter waiter) {
        return $this.addAcquireToQueue(waiter);
    }

    private final <W> void acquire(W waiter, Function1<? super W, Boolean> suspend, Function1<? super W, Unit> onAcquired) {
        int decPermits;
        boolean booleanValue;
        final int i = 0;
        while (decPermits() > 0) {
        }
        onAcquired.invoke(waiter);
    }

    static Object acquire$suspendImpl(kotlinx.coroutines.sync.SemaphoreImpl $this, Continuation<? super Unit> $completion) {
        if ($this.decPermits() > 0) {
            return Unit.INSTANCE;
        }
        Object slowPath = $this.acquireSlowPath($completion);
        if (slowPath == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return slowPath;
        }
        return Unit.INSTANCE;
    }

    private final Object acquireSlowPath(Continuation<? super Unit> $completion) {
        boolean z;
        int i = 0;
        int i2 = 0;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted($completion));
        final CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
        final int i3 = 0;
        if (!SemaphoreImpl.access$addAcquireToQueue(this, (Waiter)cancellableContinuationImpl)) {
            acquire((CancellableContinuation)cancellableContinuationImpl);
        }
        Object uCont$iv = orCreateCancellableContinuation.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return uCont$iv;
        }
        return Unit.INSTANCE;
    }

    private final boolean addAcquireToQueue(Waiter waiter) {
        Object obj3;
        long andIncrement;
        Object obj2;
        boolean aSSERTIONS_ENABLED;
        Unit iNSTANCE;
        Object this_$iv;
        Object onCancellationRelease;
        int acquirers;
        Object segmentInternal;
        Segment segment-impl;
        Object obj;
        long l2;
        int i4;
        int i;
        int i3;
        int i2;
        int i5;
        int i6;
        Object curTail;
        long l;
        final Object obj4 = this;
        final Object obj5 = waiter;
        obj3 = SemaphoreImpl.tail$FU.get(obj4);
        AtomicReferenceFieldUpdater tail$FU2 = SemaphoreImpl.tail$FU;
        int i15 = 0;
        segmentInternal = ConcurrentLinkedListKt.findSegmentInternal((Segment)obj3, andIncrement / l4, obj8);
        while (!SegmentOrClosed.isClosed-impl(segmentInternal)) {
            segment-impl = SegmentOrClosed.getSegment-impl(segmentInternal);
            i4 = 0;
            i = 0;
            obj = obj8;
            i3 = 0;
            i5 = 1;
            curTail = obj3;
            l = andIncrement;
            while (Long.compare(l2, curTail2) >= 0) {
                if (segment-impl.decPointers$kotlinx_coroutines_core()) {
                }
                i4 = i6;
                obj3 = curTail;
                andIncrement = l;
                obj = obj8;
                i3 = 0;
                i5 = 1;
                curTail = obj3;
                l = andIncrement;
                segment-impl.remove();
            }
            if (!segment-impl.tryIncPointers$kotlinx_coroutines_core()) {
            } else {
            }
            if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(tail$FU2, obj4, (Segment)obj, segment-impl)) {
            } else {
            }
            if (segment-impl.decPointers$kotlinx_coroutines_core()) {
            }
            i4 = i6;
            obj3 = curTail;
            andIncrement = l;
            segment-impl.remove();
            if (obj.decPointers$kotlinx_coroutines_core()) {
            }
            obj3 = i5;
            obj3 = curTail;
            andIncrement = l;
            segmentInternal = ConcurrentLinkedListKt.findSegmentInternal((Segment)obj3, i12, obj8);
            obj.remove();
            obj3 = i2;
            obj3 = i5;
        }
        curTail = obj3;
        l = andIncrement;
        i2 = 0;
        i5 = 1;
        Segment segment-impl2 = SegmentOrClosed.getSegment-impl(segmentInternal);
        int i9 = (int)i8;
        int i13 = 0;
        if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m((SemaphoreSegment)segment-impl2.getAcquirers(), i9, 0, obj5)) {
            obj5.invokeOnCancellation((Segment)segment-impl2, i9);
            return i5;
        }
        acquirers = 0;
        if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(segment-impl2.getAcquirers(), i9, SemaphoreKt.access$getPERMIT$p(), SemaphoreKt.access$getTAKEN$p())) {
            if (obj5 instanceof CancellableContinuation) {
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                Object obj6 = obj5;
                (CancellableContinuation)obj5.resume(Unit.INSTANCE, obj4.onCancellationRelease);
                return i5;
            } else {
                if (obj5 instanceof SelectInstance == null) {
                } else {
                    (SelectInstance)obj5.selectInRegistrationPhase(Unit.INSTANCE);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("unexpected: ").append(obj5).toString().toString());
            throw illegalStateException;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            int i14 = 0;
            l2 = segment-impl2.getAcquirers().get(i9) == SemaphoreKt.access$getBROKEN$p() ? i5 : i2;
            if (l2 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        return i2;
    }

    private final void coerceAvailablePermitsAtMaximum() {
        int i;
        boolean compareAndSet;
        int permits;
        i = SemaphoreImpl._availablePermits$FU.get(this);
        while (i > this.permits) {
            if (!SemaphoreImpl._availablePermits$FU.compareAndSet(this, i, this.permits)) {
            }
            i = SemaphoreImpl._availablePermits$FU.get(this);
        }
    }

    private final int decPermits() {
        int andDecrement;
        int permits;
        andDecrement = SemaphoreImpl._availablePermits$FU.getAndDecrement(this);
        while (andDecrement <= this.permits) {
            andDecrement = SemaphoreImpl._availablePermits$FU.getAndDecrement(this);
        }
        return andDecrement;
    }

    private final boolean tryResumeAcquire(Object $this$tryResumeAcquire) {
        Object tryResume;
        int trySelect;
        int i;
        Function1 onCancellationRelease;
        if ($this$tryResumeAcquire instanceof CancellableContinuation) {
            Intrinsics.checkNotNull($this$tryResumeAcquire, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            Object obj = $this$tryResumeAcquire;
            tryResume = (CancellableContinuation)$this$tryResumeAcquire.tryResume(Unit.INSTANCE, 0, this.onCancellationRelease);
            if (tryResume != null) {
                (CancellableContinuation)$this$tryResumeAcquire.completeResume(tryResume);
                trySelect = 1;
            } else {
                trySelect = 0;
            }
            return trySelect;
        } else {
            if ($this$tryResumeAcquire instanceof SelectInstance == null) {
            } else {
                trySelect = (SelectInstance)$this$tryResumeAcquire.trySelect(this, Unit.INSTANCE);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("unexpected: ").append($this$tryResumeAcquire).toString().toString());
        throw illegalStateException;
    }

    private final boolean tryResumeNextFromQueue() {
        Object obj;
        long andIncrement;
        int i5;
        Object segmentInternal;
        AtomicReferenceArray acquirers2;
        Segment this_$iv;
        long l2;
        int i6;
        kotlinx.coroutines.internal.Symbol symbol;
        int acquirers;
        int i3;
        Object obj2;
        int i4;
        int i;
        int i2;
        Object curHead;
        long l;
        final Object obj3 = this;
        obj = SemaphoreImpl.head$FU.get(obj3);
        int i11 = andIncrement / l5;
        AtomicReferenceFieldUpdater head$FU2 = SemaphoreImpl.head$FU;
        int i13 = 0;
        segmentInternal = ConcurrentLinkedListKt.findSegmentInternal((Segment)obj, i11, obj5);
        while (!SegmentOrClosed.isClosed-impl(segmentInternal)) {
            this_$iv = SegmentOrClosed.getSegment-impl(segmentInternal);
            acquirers = 0;
            i3 = 0;
            obj2 = head$FU2.get(obj3);
            i4 = 0;
            i2 = 1;
            curHead = obj;
            l = andIncrement;
            while (Long.compare(l2, curHead2) >= 0) {
                if (this_$iv.decPointers$kotlinx_coroutines_core()) {
                }
                obj = curHead;
                andIncrement = l;
                obj2 = head$FU2.get(obj3);
                i4 = 0;
                i2 = 1;
                curHead = obj;
                l = andIncrement;
                this_$iv.remove();
            }
            if (!this_$iv.tryIncPointers$kotlinx_coroutines_core()) {
            } else {
            }
            if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(head$FU2, obj3, (Segment)obj2, this_$iv)) {
            } else {
            }
            if (this_$iv.decPointers$kotlinx_coroutines_core()) {
            }
            obj = curHead;
            andIncrement = l;
            this_$iv.remove();
            if (obj2.decPointers$kotlinx_coroutines_core()) {
            }
            obj = i2;
            obj = curHead;
            andIncrement = l;
            segmentInternal = ConcurrentLinkedListKt.findSegmentInternal((Segment)obj, i11, obj5);
            obj2.remove();
            obj = i;
            obj = i2;
        }
        curHead = obj;
        l = andIncrement;
        i = 0;
        i2 = 1;
        Segment segment-impl = SegmentOrClosed.getSegment-impl(segmentInternal);
        (SemaphoreSegment)segment-impl.cleanPrev();
        if (Long.compare(l3, i11) > 0) {
            return i;
        }
        int i9 = (int)i8;
        i5 = 0;
        Object value$iv = segment-impl.getAcquirers().getAndSet(i9, SemaphoreKt.access$getPERMIT$p());
        if (value$iv == null) {
            i6 = i;
            while (i6 < SemaphoreKt.access$getMAX_SPIN_CYCLES$p()) {
                i5 = i6;
                acquirers2 = null;
                int i15 = 0;
                i6++;
            }
            int i14 = 0;
            return expected$iv ^= 1;
        }
        if (value$iv == SemaphoreKt.access$getCANCELLED$p()) {
            return i;
        }
        return obj3.tryResumeAcquire(value$iv);
    }

    public Object acquire(Continuation<? super Unit> continuation) {
        return SemaphoreImpl.acquire$suspendImpl(this, continuation);
    }

    protected final void acquire(CancellableContinuation<? super Unit> waiter) {
        int decPermits;
        boolean cont;
        int i;
        Object iNSTANCE;
        Function1 onCancellationRelease;
        final int i2 = 0;
        while (this.decPermits() > 0) {
            Object obj2 = waiter;
            i = 0;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (!addAcquireToQueue((Waiter)obj2)) {
                break;
            }
        }
        i = 0;
        waiter.resume(Unit.INSTANCE, this.onCancellationRelease);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(SemaphoreImpl._availablePermits$FU.get(this), 0);
    }

    protected final void onAcquireRegFunction(SelectInstance<?> select, Object ignoredParam) {
        int decPermits;
        boolean s;
        int i;
        Object iNSTANCE;
        final int i2 = 0;
        while (this.decPermits() > 0) {
            Object obj2 = select;
            i = 0;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (!addAcquireToQueue((Waiter)obj2)) {
                break;
            }
        }
        i = 0;
        select.selectInRegistrationPhase(Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        int andIncrement;
        boolean tryResumeNextFromQueue;
        andIncrement = SemaphoreImpl._availablePermits$FU.getAndIncrement(this);
        while (andIncrement < this.permits) {
            andIncrement = SemaphoreImpl._availablePermits$FU.getAndIncrement(this);
        }
        coerceAvailablePermitsAtMaximum();
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("The number of released permits cannot be greater than ").append(this.permits).toString().toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        int i;
        boolean compareAndSet;
        int i2;
        i = SemaphoreImpl._availablePermits$FU.get(this);
        while (i > this.permits) {
            coerceAvailablePermitsAtMaximum();
            i = SemaphoreImpl._availablePermits$FU.get(this);
        }
        return 0;
    }
}
