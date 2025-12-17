package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001a\u001f\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0007\u001a6\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\t\"\u0004\u0008\u0000\u0010\u0005*\u0008\u0012\u0004\u0012\u0002H\u00050\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a2\u0010\u0011\u001a\u0002H\u0005\"\u0004\u0008\u0000\u0010\u0005*\u0008\u0012\u0004\u0012\u0002H\u00050\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0013H\u0086\u0008¢\u0006\u0002\u0010\u0014\u001a-\u0010\u0015\u001a\u00020\u0016\"\u0004\u0008\u0000\u0010\u0005*\u0008\u0012\u0004\u0012\u0002H\u00050\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0013H\u0086\u0008\u001a2\u0010\u0017\u001a\u0002H\u0005\"\u0004\u0008\u0000\u0010\u0005*\u0008\u0012\u0004\u0012\u0002H\u00050\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\u0013H\u0086\u0008¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"NONE", "Lkotlinx/coroutines/internal/Symbol;", "PENDING", "MutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "fuseStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/StateFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "getAndUpdate", "function", "Lkotlin/Function1;", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "update", "", "updateAndGet", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StateFlowKt {

    private static final Symbol NONE;
    private static final Symbol PENDING;
    static {
        Symbol symbol = new Symbol("NONE");
        StateFlowKt.NONE = symbol;
        Symbol symbol2 = new Symbol("PENDING");
        StateFlowKt.PENDING = symbol2;
    }

    public static final <T> kotlinx.coroutines.flow.MutableStateFlow<T> MutableStateFlow(T value) {
        Symbol nULL;
        nULL = value == null ? NullSurrogateKt.NULL : value;
        StateFlowImpl stateFlowImpl = new StateFlowImpl(nULL);
        return (MutableStateFlow)stateFlowImpl;
    }

    public static final Symbol access$getNONE$p() {
        return StateFlowKt.NONE;
    }

    public static final Symbol access$getPENDING$p() {
        return StateFlowKt.PENDING;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> fuseStateFlow(kotlinx.coroutines.flow.StateFlow<? extends T> $this$fuseStateFlow, CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        int $i$a$AssertStateFlowKt$fuseStateFlow$1;
        int i;
        int i2;
        final int i4 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i3 = 0;
            $i$a$AssertStateFlowKt$fuseStateFlow$1 = capacity != -1 ? i : i4;
            if ($i$a$AssertStateFlowKt$fuseStateFlow$1 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (capacity >= 0 && capacity < 2) {
            if (capacity < 2) {
            } else {
                i = i4;
            }
        } else {
        }
        if (i == 0) {
            if (capacity == -2 && onBufferOverflow == BufferOverflow.DROP_OLDEST) {
                if (onBufferOverflow == BufferOverflow.DROP_OLDEST) {
                    return (Flow)$this$fuseStateFlow;
                }
            }
        } else {
        }
        return SharedFlowKt.fuseSharedFlow((SharedFlow)$this$fuseStateFlow, context, capacity, onBufferOverflow);
    }

    public static final <T> T getAndUpdate(kotlinx.coroutines.flow.MutableStateFlow<T> $this$getAndUpdate, Function1<? super T, ? extends T> function) {
        Object value;
        Object invoke;
        boolean compareAndSet;
        final int i = 0;
        value = $this$getAndUpdate.getValue();
        while ($this$getAndUpdate.compareAndSet(value, function.invoke(value))) {
            value = $this$getAndUpdate.getValue();
        }
        return value;
    }

    public static final <T> void update(kotlinx.coroutines.flow.MutableStateFlow<T> $this$update, Function1<? super T, ? extends T> function) {
        Object value;
        Object invoke;
        boolean compareAndSet;
        final int i = 0;
        value = $this$update.getValue();
        while ($this$update.compareAndSet(value, function.invoke(value))) {
            value = $this$update.getValue();
        }
    }

    public static final <T> T updateAndGet(kotlinx.coroutines.flow.MutableStateFlow<T> $this$updateAndGet, Function1<? super T, ? extends T> function) {
        Object value;
        Object invoke;
        boolean compareAndSet;
        final int i = 0;
        value = $this$updateAndGet.getValue();
        invoke = function.invoke(value);
        while ($this$updateAndGet.compareAndSet(value, invoke)) {
            value = $this$updateAndGet.getValue();
            invoke = function.invoke(value);
        }
        return invoke;
    }
}
