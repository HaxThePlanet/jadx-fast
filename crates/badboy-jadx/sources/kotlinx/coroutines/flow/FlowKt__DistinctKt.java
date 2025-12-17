package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001a\u001c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\u001aT\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\u000726\u0010\t\u001a2\u0012\u0013\u0012\u0011H\u0008¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u0013\u0012\u0011H\u0008¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u00030\u0001\u001a6\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0008\"\u0004\u0008\u0001\u0010\u000f*\u0008\u0012\u0004\u0012\u0002H\u00080\u00072\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\u000f0\u0005\u001au\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\u00072\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0008\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00052:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0002¢\u0006\u0002\u0008\u0011\"$\u0010\u0000\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"defaultAreEquivalent", "Lkotlin/Function2;", "", "", "defaultKeySelector", "Lkotlin/Function1;", "distinctUntilChanged", "Lkotlinx/coroutines/flow/Flow;", "T", "areEquivalent", "Lkotlin/ParameterName;", "name", "old", "new", "distinctUntilChangedBy", "K", "keySelector", "distinctUntilChangedBy$FlowKt__DistinctKt", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__DistinctKt {

    private static final Function2<Object, Object, Boolean> defaultAreEquivalent;
    private static final Function1<Object, Object> defaultKeySelector;
    static {
        FlowKt__DistinctKt.defaultKeySelector = (Function1)FlowKt__DistinctKt.defaultKeySelector.1.INSTANCE;
        FlowKt__DistinctKt.defaultAreEquivalent = (Function2)FlowKt__DistinctKt.defaultAreEquivalent.1.INSTANCE;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> distinctUntilChanged(kotlinx.coroutines.flow.Flow<? extends T> $this$distinctUntilChanged) {
        Object distinctUntilChangedBy$FlowKt__DistinctKt;
        Function2 defaultAreEquivalent;
        if ($this$distinctUntilChanged instanceof StateFlow) {
            distinctUntilChangedBy$FlowKt__DistinctKt = $this$distinctUntilChanged;
        } else {
            distinctUntilChangedBy$FlowKt__DistinctKt = FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt($this$distinctUntilChanged, FlowKt__DistinctKt.defaultKeySelector, FlowKt__DistinctKt.defaultAreEquivalent);
        }
        return distinctUntilChangedBy$FlowKt__DistinctKt;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> distinctUntilChanged(kotlinx.coroutines.flow.Flow<? extends T> $this$distinctUntilChanged, Function2<? super T, ? super T, Boolean> areEquivalent) {
        Intrinsics.checkNotNull(areEquivalent, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt($this$distinctUntilChanged, FlowKt__DistinctKt.defaultKeySelector, (Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(areEquivalent, 2));
    }

    public static final <T, K> kotlinx.coroutines.flow.Flow<T> distinctUntilChangedBy(kotlinx.coroutines.flow.Flow<? extends T> $this$distinctUntilChangedBy, Function1<? super T, ? extends K> keySelector) {
        return FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt($this$distinctUntilChangedBy, keySelector, FlowKt__DistinctKt.defaultAreEquivalent);
    }

    private static final <T> kotlinx.coroutines.flow.Flow<T> distinctUntilChangedBy$FlowKt__DistinctKt(kotlinx.coroutines.flow.Flow<? extends T> $this$distinctUntilChangedBy, Function1<? super T, ? extends Object> keySelector, Function2<Object, Object, Boolean> areEquivalent) {
        Object distinctFlowImpl;
        boolean areEquivalent2;
        if ($this$distinctUntilChangedBy instanceof DistinctFlowImpl && obj.keySelector == keySelector && obj2.areEquivalent == areEquivalent) {
            if (obj.keySelector == keySelector) {
                if (obj2.areEquivalent == areEquivalent) {
                    distinctFlowImpl = $this$distinctUntilChangedBy;
                } else {
                    distinctFlowImpl = new DistinctFlowImpl($this$distinctUntilChangedBy, keySelector, areEquivalent);
                }
            } else {
            }
        } else {
        }
        return distinctFlowImpl;
    }
}
