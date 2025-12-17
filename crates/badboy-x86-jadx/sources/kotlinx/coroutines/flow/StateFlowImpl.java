package kotlinx.coroutines.flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u00042\u0008\u0012\u0004\u0012\u0002H\u00010\u00052\u0008\u0012\u0004\u0012\u0002H\u00010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u001f\u0010\u0018\u001a\u00020\u00192\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u0008\u0010\"\u001a\u00020\u0003H\u0014J\u001d\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030$2\u0006\u0010%\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020(2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J&\u0010*\u001a\u0008\u0012\u0004\u0012\u00028\u00000+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u000200H\u0016J\u0008\u00101\u001a\u00020(H\u0016J\u0015\u00102\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u001a\u00104\u001a\u00020\u001e2\u0008\u00105\u001a\u0004\u0018\u00010\u00082\u0006\u00106\u001a\u00020\u0008H\u0002R\u000f\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000bX\u0082\u0004R\u001a\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\t\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00067", d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "", "(Ljava/lang/Object;)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "sequence", "", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "setValue", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compareAndSet", "", "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "createSlot", "createSlotArray", "", "size", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "resetReplayCache", "tryEmit", "(Ljava/lang/Object;)Z", "updateState", "expectedState", "newState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StateFlowImpl<T>  extends AbstractSharedFlow<kotlinx.coroutines.flow.StateFlowSlot> implements kotlinx.coroutines.flow.MutableStateFlow<T>, kotlinx.coroutines.flow.CancellableFlow<T>, FusibleFlow<T> {

    private static final AtomicReferenceFieldUpdater _state$FU;
    @Volatile
    private volatile Object _state;
    private int sequence;
    static {
        StateFlowImpl._state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    }

    public StateFlowImpl(Object initialState) {
        super();
        this._state = initialState;
    }

    public static void getValue$annotations() {
    }

    private final boolean updateState(Object expectedState, Object newState) {
        int curSequence;
        AbstractSharedFlowSlot[] curSlots;
        int $this$forEach$iv;
        int i;
        Unit iNSTANCE;
        Object slots;
        boolean equal;
        AbstractSharedFlowSlot[] slots2;
        AbstractSharedFlowSlot[] objArr;
        int i2;
        int i3 = 0;
        int i4 = 0;
        $this$forEach$iv = 0;
        i = 0;
        int i5 = 0;
        slots = StateFlowImpl._state$FU.get(this);
        int i8 = 0;
        synchronized (this) {
            if (!Intrinsics.areEqual(slots, expectedState)) {
                return i8;
            }
            final int i11 = 1;
            if (Intrinsics.areEqual(slots, newState)) {
                return i11;
            }
            StateFlowImpl._state$FU.set(this, newState);
            int curSequence2 = sequence3;
            if (curSequence2 & 1 == 0) {
                this.sequence = curSequence2++;
                curSlots = slots2;
                iNSTANCE = Unit.INSTANCE;
            }
            this.sequence = curSequence2 + 2;
            return i11;
        }
        try {
            AbstractSharedFlowSlot[] objArr2 = curSlots;
            while ((StateFlowSlot[])objArr2 != null) {
                i = 0;
                slots = i8;
                while (slots < objArr2.length) {
                    objArr = slots2;
                    i2 = 0;
                    if (objArr != null) {
                    }
                    slots++;
                    objArr.makePending();
                }
                $this$forEach$iv = 0;
                i = 0;
                int i6 = 0;
                if (this.sequence != curSequence) {
                }
                curSequence = sequence2;
                curSlots = slots;
                iNSTANCE = Unit.INSTANCE;
                objArr2 = curSlots;
                objArr = slots2;
                i2 = 0;
                if (objArr != null) {
                }
                slots++;
                objArr.makePending();
            }
            i = 0;
            slots = i8;
            while (slots < objArr2.length) {
                objArr = slots2;
                i2 = 0;
                if (objArr != null) {
                }
                slots++;
                objArr.makePending();
            }
            objArr = slots2;
            i2 = 0;
            if (objArr != null) {
            }
            objArr.makePending();
            slots++;
            $this$forEach$iv = 0;
            i = 0;
            i6 = 0;
            if (this.sequence != curSequence) {
            }
            this.sequence = curSequence + 1;
            return i11;
            curSequence = sequence2;
            curSlots = slots;
            iNSTANCE = Unit.INSTANCE;
            throw th;
            this.sequence = curSequence2 + 2;
            return i11;
            throw th;
        } catch (Throwable th) {
        }
    }

    public Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, Continuation<?> continuation2) {
        boolean anon;
        int abstractSharedFlowSlot;
        int i2;
        Object l$3;
        Object onSubscription;
        Object l$2;
        Object collector;
        int i;
        Object l$1;
        Object l$0;
        Object newState;
        int equal;
        Object obj2;
        Object obj;
        Object obj11;
        Object obj12;
        anon = continuation2;
        i2 = Integer.MIN_VALUE;
        if (continuation2 instanceof StateFlowImpl.collect.1 && label &= i2 != 0) {
            anon = continuation2;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj12 -= i2;
            } else {
                anon = new StateFlowImpl.collect.1(this, continuation2);
            }
        } else {
        }
        obj12 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                l$0 = this;
                anon.L$0 = l$0;
                anon.L$1 = flowCollector;
                anon.L$2 = (StateFlowSlot)l$0.allocateSlot();
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                int i3 = 0;
                l$3 = anon.getContext().get((CoroutineContext.Key)Job.Key);
                collector = 0;
                newState = StateFlowImpl._state$FU.get(l$0);
                JobKt.ensureActive(l$3);
                equal = 0;
                obj2 = 0;
                obj2 = newState;
                anon.L$0 = l$0;
                anon.L$1 = obj11;
                anon.L$2 = l$2;
                anon.L$3 = l$3;
                anon.L$4 = newState;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                l$1 = obj11;
                obj11 = newState;
                obj11 = l$1;
                collector = newState;
                anon.L$0 = l$0;
                anon.L$1 = obj11;
                anon.L$2 = l$2;
                anon.L$3 = l$3;
                anon.L$4 = collector;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                break;
            case 1:
                l$2 = obj11;
                obj11 = anon.L$1;
                l$0 = onSubscription;
                ResultKt.throwOnFailure(obj12);
                break;
            case 2:
                obj11 = anon.L$4;
                l$3 = anon.L$3;
                l$2 = anon.L$2;
                l$1 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj12);
                newState = StateFlowImpl._state$FU.get(l$0);
                JobKt.ensureActive(l$3);
                equal = 0;
                obj2 = 0;
                obj2 = newState;
                anon.L$0 = l$0;
                anon.L$1 = obj11;
                anon.L$2 = l$2;
                anon.L$3 = l$3;
                anon.L$4 = newState;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                l$1 = obj11;
                obj11 = newState;
                obj11 = l$1;
                collector = newState;
                anon.L$0 = l$0;
                anon.L$1 = obj11;
                anon.L$2 = l$2;
                anon.L$3 = l$3;
                anon.L$4 = collector;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                break;
            case 3:
                l$3 = anon.L$3;
                l$2 = anon.L$2;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj12);
                collector = obj11;
                obj11 = obj;
                newState = StateFlowImpl._state$FU.get(l$0);
                JobKt.ensureActive(l$3);
                equal = 0;
                obj2 = 0;
                obj2 = newState;
                anon.L$0 = l$0;
                anon.L$1 = obj11;
                anon.L$2 = l$2;
                anon.L$3 = l$3;
                anon.L$4 = newState;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                l$1 = obj11;
                obj11 = newState;
                obj11 = l$1;
                collector = newState;
                anon.L$0 = l$0;
                anon.L$1 = obj11;
                anon.L$2 = l$2;
                anon.L$3 = l$3;
                anon.L$4 = collector;
                anon.label = 3;
                return cOROUTINE_SUSPENDED;
                break;
            default:
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
        }
    }

    public boolean compareAndSet(T expect, T update) {
        kotlinx.coroutines.internal.Symbol nULL;
        kotlinx.coroutines.internal.Symbol nULL2;
        nULL = expect == null ? NullSurrogateKt.NULL : expect;
        nULL2 = update == null ? NullSurrogateKt.NULL : update;
        return updateState(nULL, nULL2);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    protected kotlinx.coroutines.flow.StateFlowSlot createSlot() {
        StateFlowSlot stateFlowSlot = new StateFlowSlot();
        return stateFlowSlot;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public AbstractSharedFlowSlot createSlot() {
        return (AbstractSharedFlowSlot)createSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    protected kotlinx.coroutines.flow.StateFlowSlot[] createSlotArray(int size) {
        return new StateFlowSlot[size];
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public AbstractSharedFlowSlot[] createSlotArray(int size) {
        return (AbstractSharedFlowSlot[])createSlotArray(size);
    }

    public Object emit(T value, Continuation<? super Unit> $completion) {
        setValue(value);
        return Unit.INSTANCE;
    }

    public kotlinx.coroutines.flow.Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return StateFlowKt.fuseStateFlow((StateFlow)this, context, capacity, onBufferOverflow);
    }

    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    public T getValue() {
        Object value$iv;
        int i;
        final int i2 = 0;
        if (StateFlowImpl._state$FU.get(this) == NullSurrogateKt.NULL) {
            value$iv = i;
        }
        return value$iv;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public void resetReplayCache() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
        throw unsupportedOperationException;
    }

    public void setValue(T value) {
        kotlinx.coroutines.internal.Symbol nULL;
        nULL = value == null ? NullSurrogateKt.NULL : value;
        updateState(0, nULL);
    }

    public boolean tryEmit(T value) {
        setValue(value);
        return 1;
    }
}
