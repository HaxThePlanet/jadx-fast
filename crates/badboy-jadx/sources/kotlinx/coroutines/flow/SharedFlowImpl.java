package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000f\n\u0002\u0010 \n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0012\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u00042\u0008\u0012\u0004\u0012\u0002H\u00010\u00052\u0008\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001hB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J\u0008\u00102\u001a\u00020,H\u0002J\u001f\u00103\u001a\u0002042\u000c\u00105\u001a\u0008\u0012\u0004\u0012\u00028\u000006H\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002J\u0008\u0010:\u001a\u00020\u0003H\u0014J\u001d\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u0010<\u001a\u00020\u0008H\u0014¢\u0006\u0002\u0010=J\u0008\u0010>\u001a\u00020,H\u0002J\u0019\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0019\u0010B\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0012\u0010C\u001a\u00020,2\u0008\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010E\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0014\u0010G\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000eH\u0002¢\u0006\u0002\u0010HJ&\u0010I\u001a\u0008\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010\u000f2\u0006\u0010O\u001a\u00020\u0012H\u0002J7\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010Q\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010R\u001a\u00020\u00082\u0006\u0010S\u001a\u00020\u0008H\u0002¢\u0006\u0002\u0010TJ\u0008\u0010U\u001a\u00020,H\u0016J\u0015\u0010V\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Z\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0010\u0010[\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u0003H\u0002J(\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012H\u0002J%\u0010b\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0006\u0010c\u001a\u00020\u0012H\u0000¢\u0006\u0004\u0008d\u0010eJ\r\u0010f\u001a\u00020\u0012H\u0000¢\u0006\u0002\u0008gR\u001a\u0010\r\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u000c\u0012\u0004\u0008\u0019\u0010\u001a\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0014R\u000e\u0010 \u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u0008\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010(R\u0014\u0010)\u001a\u00020\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010(\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006i", d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SharedFlowImpl<T>  extends AbstractSharedFlow<kotlinx.coroutines.flow.SharedFlowSlot> implements kotlinx.coroutines.flow.MutableSharedFlow<T>, kotlinx.coroutines.flow.CancellableFlow<T>, FusibleFlow<T> {

    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u000c\u001a\u00020\nH\u0016R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Emitter implements DisposableHandle {

        public final Continuation<Unit> cont;
        public final kotlinx.coroutines.flow.SharedFlowImpl<?> flow;
        public long index;
        public final Object value;
        public Emitter(kotlinx.coroutines.flow.SharedFlowImpl<?> flow, long index, Object value, Continuation<? super Unit> cont) {
            super();
            this.flow = flow;
            this.index = index;
            this.value = cont;
            this.cont = obj5;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            SharedFlowImpl.access$cancelEmitter(this.flow, this);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal3;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            SharedFlowImpl.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public SharedFlowImpl(int replay, int bufferCapacity, BufferOverflow onBufferOverflow) {
        super();
        this.replay = replay;
        this.bufferCapacity = bufferCapacity;
        this.onBufferOverflow = onBufferOverflow;
    }

    public static final Object access$awaitValue(kotlinx.coroutines.flow.SharedFlowImpl $this, kotlinx.coroutines.flow.SharedFlowSlot slot, Continuation $completion) {
        return $this.awaitValue(slot, $completion);
    }

    public static final void access$cancelEmitter(kotlinx.coroutines.flow.SharedFlowImpl $this, kotlinx.coroutines.flow.SharedFlowImpl.Emitter emitter) {
        $this.cancelEmitter(emitter);
    }

    public static final Object access$emitSuspend(kotlinx.coroutines.flow.SharedFlowImpl $this, Object value, Continuation $completion) {
        return $this.emitSuspend(value, $completion);
    }

    public static final void access$enqueueLocked(kotlinx.coroutines.flow.SharedFlowImpl $this, Object item) {
        $this.enqueueLocked(item);
    }

    public static final Continuation[] access$findSlotsToResumeLocked(kotlinx.coroutines.flow.SharedFlowImpl $this, Continuation[] resumesIn) {
        return $this.findSlotsToResumeLocked(resumesIn);
    }

    public static final int access$getBufferCapacity$p(kotlinx.coroutines.flow.SharedFlowImpl $this) {
        return $this.bufferCapacity;
    }

    public static final long access$getHead(kotlinx.coroutines.flow.SharedFlowImpl $this) {
        return $this.getHead();
    }

    public static final int access$getQueueSize$p(kotlinx.coroutines.flow.SharedFlowImpl $this) {
        return $this.queueSize;
    }

    public static final int access$getTotalSize(kotlinx.coroutines.flow.SharedFlowImpl $this) {
        return $this.getTotalSize();
    }

    public static final void access$setQueueSize$p(kotlinx.coroutines.flow.SharedFlowImpl $this, int <set-?>) {
        $this.queueSize = <set-?>;
    }

    public static final boolean access$tryEmitLocked(kotlinx.coroutines.flow.SharedFlowImpl $this, Object value) {
        return $this.tryEmitLocked(value);
    }

    public static final long access$tryPeekLocked(kotlinx.coroutines.flow.SharedFlowImpl $this, kotlinx.coroutines.flow.SharedFlowSlot slot) {
        return $this.tryPeekLocked(slot);
    }

    private final Object awaitValue(kotlinx.coroutines.flow.SharedFlowSlot slot, Continuation<? super Unit> $completion) {
        CancellableContinuationImpl cancellableContinuationImpl;
        Object constructor-impl;
        int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl2.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
        int i4 = 0;
        final int i5 = 0;
        final int i6 = 0;
        int i7 = 0;
        synchronized (this) {
            slot.cont = (Continuation)(CancellableContinuation)cancellableContinuationImpl3;
            slot.cont = (Continuation)cancellableContinuationImpl3;
            Unit $i$a$SynchronizedSharedFlowImpl$awaitValue$2$1 = Unit.INSTANCE;
            Object uCont$iv = cancellableContinuationImpl2.getResult();
            if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return uCont$iv;
            }
            return Unit.INSTANCE;
        }
        DebugProbesKt.probeCoroutineSuspended($completion);
    }

    private final void cancelEmitter(kotlinx.coroutines.flow.SharedFlowImpl.Emitter emitter) {
        final int i = 0;
        final int i2 = 0;
        int i3 = 0;
        final long head = getHead();
        synchronized (this) {
        }
    }

    private final void cleanupTailLocked() {
        int bufferCapacity;
        int i;
        int queueSize;
        long nO_VALUE;
        int i2;
        if (this.bufferCapacity == 0 && this.queueSize <= 1) {
            if (this.queueSize <= 1) {
            }
        }
        Object[] buffer = this.buffer;
        Intrinsics.checkNotNull(buffer);
        while (this.queueSize > 0) {
            nO_VALUE = SharedFlowKt.NO_VALUE;
            if (SharedFlowKt.access$getBufferAt(buffer, i3 -= i2) == nO_VALUE) {
            }
            this.queueSize = queueSize2--;
            SharedFlowKt.access$setBufferAt(buffer, head2 += l2, nO_VALUE);
        }
    }

    static <T> Object collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl<T> sharedFlowImpl, kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector2, Continuation<?> continuation3) {
        boolean anon;
        int abstractSharedFlowSlot;
        int i;
        kotlin.coroutines.CoroutineContext.Element collector;
        Object onSubscription;
        Object collectorJob;
        Object l$0;
        CoroutineContext tryTakeValue;
        kotlinx.coroutines.internal.Symbol nO_VALUE;
        Object obj;
        Object obj7;
        Object obj8;
        Object obj9;
        anon = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof SharedFlowImpl.collect.1 && label &= i != 0) {
            anon = continuation3;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj9 -= i;
            } else {
                anon = new SharedFlowImpl.collect.1(sharedFlowImpl, continuation3);
            }
        } else {
        }
        obj9 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                l$0 = sharedFlowImpl;
                obj7 = flowCollector2;
                anon.L$0 = l$0;
                anon.L$1 = obj7;
                anon.L$2 = (SharedFlowSlot)l$0.allocateSlot();
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                int i2 = 0;
                collector = anon.getContext().get((CoroutineContext.Key)Job.Key);
                collectorJob = obj7;
                obj7 = obj;
                tryTakeValue = l$0.tryTakeValue(obj8);
                anon.L$0 = l$0;
                anon.L$1 = collectorJob;
                anon.L$2 = obj8;
                anon.L$3 = obj7;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                JobKt.ensureActive(obj7);
                anon.L$0 = l$0;
                anon.L$1 = collectorJob;
                anon.L$2 = obj8;
                anon.L$3 = obj7;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                collector = obj7;
                obj7 = obj;
                break;
            case 1:
                obj8 = obj7;
                obj7 = anon.L$1;
                l$0 = onSubscription;
                ResultKt.throwOnFailure(obj9);
                break;
            case 2:
                obj7 = anon.L$3;
                obj8 = anon.L$2;
                collectorJob = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                collectorJob = obj7;
                obj7 = obj;
                tryTakeValue = l$0.tryTakeValue(obj8);
                anon.L$0 = l$0;
                anon.L$1 = collectorJob;
                anon.L$2 = obj8;
                anon.L$3 = obj7;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                JobKt.ensureActive(obj7);
                anon.L$0 = l$0;
                anon.L$1 = collectorJob;
                anon.L$2 = obj8;
                anon.L$3 = obj7;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                collector = obj7;
                obj7 = obj;
                break;
            case 3:
                obj8 = anon.L$2;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                collector = obj7;
                obj7 = obj;
                collectorJob = obj7;
                obj7 = obj;
                tryTakeValue = l$0.tryTakeValue(obj8);
                anon.L$0 = l$0;
                anon.L$1 = collectorJob;
                anon.L$2 = obj8;
                anon.L$3 = obj7;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                JobKt.ensureActive(obj7);
                anon.L$0 = l$0;
                anon.L$1 = collectorJob;
                anon.L$2 = obj8;
                anon.L$3 = obj7;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                collector = obj7;
                obj7 = obj;
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long newHead) {
        int i5;
        int i6;
        int length;
        int i;
        AbstractSharedFlowSlot abstractSharedFlowSlot3;
        AbstractSharedFlowSlot abstractSharedFlowSlot;
        int i4;
        AbstractSharedFlowSlot abstractSharedFlowSlot2;
        int i2;
        int cmp;
        int i3;
        final Object obj = this;
        final long l = newHead;
        final AbstractSharedFlow abstractSharedFlow = obj;
        final int i7 = 0;
        i5 = AbstractSharedFlow.access$getSlots(abstractSharedFlow);
        if (AbstractSharedFlow.access$getNCollectors((AbstractSharedFlow)abstractSharedFlow) != 0 && i5 != null) {
            i5 = AbstractSharedFlow.access$getSlots(abstractSharedFlow);
            if (i5 != null) {
                i6 = 0;
                i = 0;
                while (i < i5.length) {
                    abstractSharedFlowSlot = abstractSharedFlowSlot3;
                    i4 = 0;
                    abstractSharedFlowSlot2 = abstractSharedFlowSlot;
                    i2 = 0;
                    if (abstractSharedFlowSlot != null && Long.compare(index, i3) >= 0 && Long.compare(index2, l) < 0) {
                    }
                    i++;
                    abstractSharedFlowSlot2 = abstractSharedFlowSlot;
                    i2 = 0;
                    if (Long.compare(index, i3) >= 0) {
                    }
                    if (Long.compare(index2, l) < 0) {
                    }
                    abstractSharedFlowSlot2.index = l;
                }
            }
        }
        obj.minCollectorIndex = l;
    }

    private final void dropOldestLocked() {
        boolean aSSERTIONS_ENABLED;
        int i;
        Object[] buffer = this.buffer;
        Intrinsics.checkNotNull(buffer);
        final long head2 = getHead();
        SharedFlowKt.access$setBufferAt(buffer, head2, obj2);
        this.bufferSize = bufferSize--;
        head += i4;
        if (Long.compare(replayIndex, i3) < 0) {
            this.replayIndex = i3;
        }
        if (Long.compare(minCollectorIndex, i3) < 0) {
            correctCollectorIndexesOnDropOldest(i3);
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i = Long.compare(head3, i3) == 0 ? 1 : 0;
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
    }

    static <T> Object emit$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl<T> $this, T value, Continuation<? super Unit> $completion) {
        if ($this.tryEmit(value)) {
            return Unit.INSTANCE;
        }
        Object emitSuspend = $this.emitSuspend(value, $completion);
        if (emitSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return emitSuspend;
        }
        return Unit.INSTANCE;
    }

    private final Object emitSuspend(T value, Continuation<? super Unit> $completion) {
        Continuation[] objArr;
        int it;
        Object i2;
        int i;
        int i3;
        CancellableContinuationImpl cancellableContinuationImpl;
        int constructor-impl;
        Continuation[] resumes;
        final kotlinx.coroutines.flow.SharedFlowImpl sharedFlowImpl = this;
        final int i9 = 0;
        final int i10 = 0;
        constructor-impl = 1;
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), constructor-impl);
        final CancellableContinuationImpl cancellableContinuationImpl4 = cancellableContinuationImpl2;
        cancellableContinuationImpl4.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl5 = cancellableContinuationImpl4;
        final int i11 = 0;
        int i4 = 0;
        resumes = AbstractSharedFlowKt.EMPTY_RESUMES;
        final int i12 = 0;
        final int i13 = 0;
        final int i14 = 0;
        synchronized (this) {
            kotlin.Result.Companion companion = Result.Companion;
            (Continuation)(CancellableContinuation)cancellableContinuationImpl5.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            objArr = SharedFlowImpl.access$findSlotsToResumeLocked(sharedFlowImpl, resumes);
            it = 0;
            if (it != 0) {
            }
            i3 = 0;
            while (i3 < objArr.length) {
                cancellableContinuationImpl = objArr[i3];
                if (cancellableContinuationImpl != null) {
                }
                i3++;
                kotlin.Result.Companion companion2 = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }
            Object result = cancellableContinuationImpl4.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended($completion);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }
        i = 0;
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl5, (DisposableHandle)it);
    }

    private final void enqueueLocked(Object item) {
        Object[] curBuffer;
        Object[] growBuffer;
        int length;
        int i;
        final int totalSize = getTotalSize();
        curBuffer = this.buffer;
        growBuffer = 2;
        if (curBuffer == null) {
            curBuffer = growBuffer;
        } else {
            if (totalSize >= curBuffer.length) {
                curBuffer = growBuffer;
            }
        }
        SharedFlowKt.access$setBufferAt(curBuffer, head += l, length);
    }

    private final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] resumesIn) {
        int abstractSharedFlow;
        Object[] copyOf;
        Object[] resumes;
        int resumeCount2;
        int i2;
        int i6;
        int length;
        int i4;
        AbstractSharedFlowSlot abstractSharedFlowSlot3;
        AbstractSharedFlowSlot abstractSharedFlowSlot;
        int i5;
        AbstractSharedFlowSlot abstractSharedFlowSlot2;
        int i3;
        Continuation cont;
        int cmp;
        int resumeCount;
        int i;
        int i9 = 0;
        resumes = resumesIn;
        int i10 = 0;
        resumeCount2 = objArr3.length;
        final AbstractSharedFlow abstractSharedFlow2 = abstractSharedFlow;
        final int i11 = 0;
        i2 = AbstractSharedFlow.access$getSlots(abstractSharedFlow2);
        if (AbstractSharedFlow.access$getNCollectors((AbstractSharedFlow)abstractSharedFlow2) != 0 && i2 != null) {
            i2 = AbstractSharedFlow.access$getSlots(abstractSharedFlow2);
            if (i2 != null) {
                i6 = 0;
                i4 = 0;
                while (i4 < i2.length) {
                    abstractSharedFlowSlot = abstractSharedFlowSlot3;
                    i5 = 0;
                    if (abstractSharedFlowSlot != null) {
                    } else {
                    }
                    resumeCount = resumeCount2;
                    i4++;
                    abstractSharedFlow = this;
                    abstractSharedFlowSlot2 = abstractSharedFlowSlot;
                    i3 = 0;
                    cont = abstractSharedFlowSlot2.cont;
                    if (cont == null) {
                    } else {
                    }
                    if (Long.compare(tryPeekLocked, i) >= 0) {
                    } else {
                    }
                    resumeCount = resumeCount2;
                    resumeCount2 = resumeCount;
                    if (resumeCount2 >= resumes.length) {
                    } else {
                    }
                    resumeCount = resumeCount2;
                    resumeCount2 = resumeCount + 1;
                    (Continuation[])resumes[resumeCount] = cont;
                    abstractSharedFlowSlot2.cont = 0;
                    resumeCount = resumeCount2;
                    copyOf = Arrays.copyOf(resumes, Math.max(2, cmp * 2));
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    resumes = copyOf;
                    resumeCount = resumeCount2;
                }
                resumeCount = resumeCount2;
            }
        }
        return (Continuation[])resumes;
    }

    private final long getBufferEndIndex() {
        return head += l;
    }

    private final long getHead() {
        return Math.min(this.minCollectorIndex, obj1);
    }

    protected static void getLastReplayedLocked$annotations() {
    }

    private final Object getPeekedValueLockedAt(long index) {
        Object item;
        Object value;
        Object[] buffer = this.buffer;
        Intrinsics.checkNotNull(buffer);
        item = SharedFlowKt.access$getBufferAt(buffer, index);
        if (item instanceof SharedFlowImpl.Emitter) {
            item = value;
        } else {
        }
        return item;
    }

    private final long getQueueEndIndex() {
        return i += l2;
    }

    private final int getReplaySize() {
        return (int)i2;
    }

    private final int getTotalSize() {
        return bufferSize += queueSize;
    }

    private final Object[] growBuffer(Object[] curBuffer, int curSize, int newSize) {
        int i;
        int i3;
        int i2;
        Object obj;
        i = newSize > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            Object[] arr = new Object[newSize];
            final int i4 = 0;
            this.buffer = arr;
            if (curBuffer == null) {
                return arr;
            }
            long head = getHead();
            i3 = 0;
            while (i3 < curSize) {
                SharedFlowKt.access$setBufferAt(arr, l += head, obj5);
                i3++;
            }
            return arr;
        }
        int newBuffer = 0;
        IllegalStateException $i$a$CheckSharedFlowImpl$growBuffer$1 = new IllegalStateException("Buffer size overflow".toString());
        throw $i$a$CheckSharedFlowImpl$growBuffer$1;
    }

    private final boolean tryEmitLocked(T value) {
        int bufferSize;
        int replayIndex;
        int bufferCapacity;
        long replayIndex2;
        Object obj;
        int i;
        long minCollectorIndex;
        long bufferEndIndex;
        long queueEndIndex;
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(value);
        }
        final int i4 = 1;
        if (this.bufferSize >= this.bufferCapacity && Long.compare(minCollectorIndex2, replayIndex2) <= 0) {
            if (Long.compare(minCollectorIndex2, replayIndex2) <= 0) {
                switch (bufferSize) {
                    case 1:
                        return 0;
                    case 2:
                        return i4;
                    default:
                }
            }
        }
        enqueueLocked(value);
        this.bufferSize = bufferSize2 += i4;
        if (this.bufferSize > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            this.updateBufferLocked(replayIndex + replayIndex2, obj7, this.minCollectorIndex, obj9);
        }
        return i4;
    }

    private final boolean tryEmitNoCollectorsLocked(T value) {
        boolean aSSERTIONS_ENABLED;
        int i;
        final int i3 = 1;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i = getNCollectors() == 0 ? i3 : 0;
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (this.replay == 0) {
            return i3;
        }
        enqueueLocked(value);
        this.bufferSize = bufferSize += i3;
        if (this.bufferSize > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = head += l;
        return i3;
    }

    private final long tryPeekLocked(kotlinx.coroutines.flow.SharedFlowSlot slot) {
        final long index = slot.index;
        if (Long.compare(index, bufferEndIndex) < 0) {
            return index;
        }
        final int i = -1;
        if (this.bufferCapacity > 0) {
            return i;
        }
        if (Long.compare(index, head) > 0) {
            return i;
        }
        if (this.queueSize == 0) {
            return i;
        }
        return index;
    }

    private final Object tryTakeValue(kotlinx.coroutines.flow.SharedFlowSlot slot) {
        Continuation[] resumes;
        int i2;
        int i;
        long tryPeekLocked;
        Object oldIndex;
        Object peekedValueLockedAt;
        Continuation[] collectorIndexLocked$kotlinx_coroutines_core;
        int i3 = 0;
        resumes = AbstractSharedFlowKt.EMPTY_RESUMES;
        int i4 = 0;
        int i5 = 0;
        i = 0;
        tryPeekLocked = tryPeekLocked(slot);
        synchronized (this) {
            oldIndex = SharedFlowKt.NO_VALUE;
            i2 = 0;
        }
        while (i2 < resumes.length) {
            i = resumes[i2];
            if (i != 0) {
            }
            i2++;
            kotlin.Result.Companion companion = Result.Companion;
            i.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
        try {
            return oldIndex;
            throw th;
        }
    }

    private final void updateBufferLocked(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        int $i$a$AssertSharedFlowImpl$updateBufferLocked$1;
        int $i$a$AssertSharedFlowImpl$updateBufferLocked$2;
        int $i$a$AssertSharedFlowImpl$updateBufferLocked$3;
        boolean aSSERTIONS_ENABLED;
        int i2;
        int cmp;
        long index;
        int bufferSize;
        int i;
        long l;
        final Object obj = this;
        final long l2 = newReplayIndex;
        final long l3 = newBufferEndIndex;
        final long l4 = Math.min(l3, obj4);
        i2 = 1;
        final int i8 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i3 = 0;
            $i$a$AssertSharedFlowImpl$updateBufferLocked$1 = Long.compare(l4, head) >= 0 ? i2 : i8;
            if ($i$a$AssertSharedFlowImpl$updateBufferLocked$1 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        index = obj.getHead();
        while (Long.compare(index, l4) < 0) {
            $i$a$AssertSharedFlowImpl$updateBufferLocked$1 = obj.buffer;
            Intrinsics.checkNotNull($i$a$AssertSharedFlowImpl$updateBufferLocked$1);
            SharedFlowKt.access$setBufferAt($i$a$AssertSharedFlowImpl$updateBufferLocked$1, index, obj11);
            index += i;
        }
        obj.replayIndex = l2;
        obj.minCollectorIndex = l3;
        obj.bufferSize = (int)i9;
        obj.queueSize = (int)bufferSize;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i6 = 0;
            $i$a$AssertSharedFlowImpl$updateBufferLocked$2 = obj.bufferSize >= 0 ? i2 : i8;
            if ($i$a$AssertSharedFlowImpl$updateBufferLocked$2 == 0) {
            } else {
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i7 = 0;
            $i$a$AssertSharedFlowImpl$updateBufferLocked$3 = obj.queueSize >= 0 ? i2 : i8;
            if ($i$a$AssertSharedFlowImpl$updateBufferLocked$3 == 0) {
            } else {
            }
            AssertionError assertionError3 = new AssertionError();
            throw assertionError3;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (Long.compare(replayIndex, i) <= 0) {
            } else {
                i2 = i8;
            }
            if (i2 == 0) {
            } else {
            }
            AssertionError assertionError4 = new AssertionError();
            throw assertionError4;
        }
    }

    public Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, Continuation<?> continuation2) {
        return SharedFlowImpl.collect$suspendImpl(this, flowCollector, continuation2);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    protected kotlinx.coroutines.flow.SharedFlowSlot createSlot() {
        SharedFlowSlot sharedFlowSlot = new SharedFlowSlot();
        return sharedFlowSlot;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public AbstractSharedFlowSlot createSlot() {
        return (AbstractSharedFlowSlot)createSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    protected kotlinx.coroutines.flow.SharedFlowSlot[] createSlotArray(int size) {
        return new SharedFlowSlot[size];
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public AbstractSharedFlowSlot[] createSlotArray(int size) {
        return (AbstractSharedFlowSlot[])createSlotArray(size);
    }

    public Object emit(T t, Continuation<? super Unit> continuation2) {
        return SharedFlowImpl.emit$suspendImpl(this, t, continuation2);
    }

    public kotlinx.coroutines.flow.Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return SharedFlowKt.fuseSharedFlow((SharedFlow)this, context, capacity, onBufferOverflow);
    }

    protected final T getLastReplayedLocked() {
        Object[] buffer = this.buffer;
        Intrinsics.checkNotNull(buffer);
        return SharedFlowKt.access$getBufferAt(buffer, i -= i3);
    }

    public List<T> getReplayCache() {
        int i;
        ArrayList list;
        Object obj;
        long l;
        int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        final int replaySize = getReplaySize();
        synchronized (this) {
            return CollectionsKt.emptyList();
        }
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public void resetReplayCache() {
        Object obj;
        final int i2 = 0;
        final int i3 = 0;
        int i = 0;
        this.updateBufferLocked(getBufferEndIndex(), obj5, this.minCollectorIndex, obj7);
        Unit $i$a$SynchronizedSharedFlowImpl$resetReplayCache$1 = Unit.INSTANCE;
        return;
        synchronized (this) {
            i2 = 0;
            i3 = 0;
            i = 0;
            this.updateBufferLocked(getBufferEndIndex(), obj5, this.minCollectorIndex, obj7);
            $i$a$SynchronizedSharedFlowImpl$resetReplayCache$1 = Unit.INSTANCE;
        }
    }

    public boolean tryEmit(T value) {
        Continuation[] resumes;
        int i3;
        int constructor-impl;
        int i;
        int i2;
        int i4 = 0;
        int i5 = 0;
        i3 = 0;
        constructor-impl = 0;
        synchronized (this) {
            resumes = slotsToResumeLocked;
            i = 1;
        }
        while (i2 < resumes.length) {
            i3 = resumes[i2];
            if (i3 != 0) {
            }
            i2++;
            kotlin.Result.Companion companion = Result.Companion;
            i3.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
        try {
            return i;
            throw th;
        }
    }

    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long oldIndex) {
        int $i$a$AssertSharedFlowImpl$updateCollectorIndexLocked$1;
        int newMinCollectorIndex2;
        int $i$a$AssertSharedFlowImpl$updateCollectorIndexLocked$3;
        long newBufferEndIndex;
        long newBufferEndIndex2;
        int cmp3;
        int cmp2;
        int newMinCollectorIndex4;
        long newMinCollectorIndex3;
        Object value;
        int minCollectorIndex;
        int newBufferSize0;
        Continuation[] resumes2;
        long newReplayIndex;
        int queueSize;
        long l;
        int i5;
        int i6;
        int cmp;
        Continuation[] resumes;
        int curEmitterIndex;
        int i;
        int bufferCapacity;
        AbstractSharedFlowSlot nO_VALUE;
        AbstractSharedFlowSlot newMinCollectorIndex;
        int i8;
        int i7;
        int i3;
        int i4;
        int i2;
        long l2;
        final Object obj = this;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i9 = 0;
            $i$a$AssertSharedFlowImpl$updateCollectorIndexLocked$1 = Long.compare(oldIndex, minCollectorIndex4) >= 0 ? 1 : 0;
            if ($i$a$AssertSharedFlowImpl$updateCollectorIndexLocked$1 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (Long.compare(oldIndex, minCollectorIndex2) > 0) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        final long head = obj.getHead();
        int i10 = 0;
        minCollectorIndex = 1;
        if (obj.bufferCapacity == 0 && obj.queueSize > 0) {
            if (obj.queueSize > 0) {
                newMinCollectorIndex4 += minCollectorIndex;
            }
        }
        Object obj2 = obj;
        cmp2 = 0;
        if (AbstractSharedFlow.access$getNCollectors((AbstractSharedFlow)obj2) != 0) {
            i5 = AbstractSharedFlow.access$getSlots(obj2);
            if (i5 != null) {
                i6 = 0;
                i = 0;
                while (i < i5.length) {
                    newMinCollectorIndex = nO_VALUE;
                    i8 = 0;
                    if (newMinCollectorIndex != null) {
                    } else {
                    }
                    i3 = minCollectorIndex;
                    i++;
                    minCollectorIndex = i3;
                    i3 = minCollectorIndex;
                    minCollectorIndex = newMinCollectorIndex;
                    queueSize = 0;
                    if (Long.compare(index, i2) >= 0 && Long.compare(index2, newMinCollectorIndex4) < 0) {
                    }
                    if (Long.compare(index2, newMinCollectorIndex4) < 0) {
                    }
                    newMinCollectorIndex4 = minCollectorIndex.index;
                }
                i7 = minCollectorIndex;
            } else {
                i7 = minCollectorIndex;
            }
        } else {
            i7 = minCollectorIndex;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i11 = 0;
            $i$a$AssertSharedFlowImpl$updateCollectorIndexLocked$3 = Long.compare(newMinCollectorIndex4, minCollectorIndex) >= 0 ? 1 : 0;
            if ($i$a$AssertSharedFlowImpl$updateCollectorIndexLocked$3 == 0) {
            } else {
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
        if (Long.compare(newMinCollectorIndex4, minCollectorIndex3) <= 0) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        newBufferEndIndex = obj.getBufferEndIndex();
        if (obj.getNCollectors() > 0) {
            newBufferSize0 = Math.min(obj.queueSize, bufferCapacity2 -= i14);
        } else {
            newBufferSize0 = obj.queueSize;
        }
        int i16 = newBufferSize0;
        int i15 = newBufferEndIndex + l;
        if (i16 > 0) {
            resumes2 = new Continuation[i16];
            l = 0;
            Object[] buffer = obj.buffer;
            Intrinsics.checkNotNull(buffer);
            curEmitterIndex = newBufferEndIndex;
            while (Long.compare(curEmitterIndex, i15) < 0) {
                nO_VALUE = SharedFlowKt.access$getBufferAt(buffer, curEmitterIndex);
                curEmitterIndex += i7;
                newMinCollectorIndex4 = newMinCollectorIndex;
                Intrinsics.checkNotNull(nO_VALUE, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                Object obj3 = nO_VALUE;
                newMinCollectorIndex4 = l + 1;
                resumes2[l] = obj4.cont;
                SharedFlowKt.access$setBufferAt(buffer, curEmitterIndex, i);
                SharedFlowKt.access$setBufferAt(buffer, newBufferEndIndex, cmp2);
                newBufferEndIndex += i7;
                l = newMinCollectorIndex4;
            }
            newMinCollectorIndex = newMinCollectorIndex4;
            resumes = resumes2;
        } else {
            newMinCollectorIndex = newMinCollectorIndex4;
            resumes = resumes2;
        }
        newMinCollectorIndex3 = obj.getNCollectors() == 0 ? newBufferEndIndex : newMinCollectorIndex;
        long l4 = Math.max(obj.replayIndex, l);
        Object[] buffer2 = obj.buffer;
        Intrinsics.checkNotNull(buffer2);
        if (obj.bufferCapacity == 0 && Long.compare(l4, i15) < 0 && Intrinsics.areEqual(SharedFlowKt.access$getBufferAt(buffer2, l4), SharedFlowKt.NO_VALUE)) {
            if (Long.compare(l4, i15) < 0) {
                buffer2 = obj.buffer;
                Intrinsics.checkNotNull(buffer2);
                if (Intrinsics.areEqual(SharedFlowKt.access$getBufferAt(buffer2, l4), SharedFlowKt.NO_VALUE)) {
                    newReplayIndex = newBufferEndIndex3;
                    newBufferEndIndex2 = l2;
                } else {
                    newReplayIndex = newBufferEndIndex;
                    newBufferEndIndex2 = l2;
                }
            } else {
            }
        } else {
        }
        obj.updateBufferLocked(newBufferEndIndex2, cmp2, newMinCollectorIndex3, value);
        obj.cleanupTailLocked();
        i4 = resumes.length == 0 ? 1 : 0;
        if (i4 == 0) {
            resumes = obj.findSlotsToResumeLocked(resumes);
        }
        return resumes;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        final long replayIndex = this.replayIndex;
        if (Long.compare(replayIndex, minCollectorIndex) < 0) {
            this.minCollectorIndex = replayIndex;
        }
        return replayIndex;
    }
}
