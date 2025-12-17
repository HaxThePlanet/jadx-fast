package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0008\u0003\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0010#\n\u0002\u0008\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0010\u0008\u0001\u0010\u0001*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a7\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a7\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000c\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"toCollection", "C", "T", "", "Lkotlinx/coroutines/flow/Flow;", "destination", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CollectionKt {
    public static final <T, C extends java.util.Collection<? super T>> Object toCollection(kotlinx.coroutines.flow.Flow<? extends T> flow, C c2, Continuation<? super C> continuation3) {
        boolean anon;
        int i;
        int i3;
        kotlinx.coroutines.flow.FlowKt__CollectionKt.toCollection.2 label;
        int i2;
        Object obj4;
        Object obj6;
        anon = continuation3;
        i3 = Integer.MIN_VALUE;
        if (continuation3 instanceof FlowKt__CollectionKt.toCollection.1 && label2 &= i3 != 0) {
            anon = continuation3;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = obj6 -= i3;
            } else {
                anon = new FlowKt__CollectionKt.toCollection.1(continuation3);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                label = new FlowKt__CollectionKt.toCollection.2(c2);
                anon.L$0 = c2;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj4 = c2;
                break;
            case 1:
                obj4 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                break;
            default:
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
        }
        return obj4;
    }

    public static final <T> Object toList(kotlinx.coroutines.flow.Flow<? extends T> $this$toList, List<T> destination, Continuation<? super List<? extends T>> $completion) {
        return FlowKt.toCollection($this$toList, (Collection)destination, $completion);
    }

    public static Object toList$default(kotlinx.coroutines.flow.Flow flow, List list2, Continuation continuation3, int i4, Object object5) {
        ArrayList obj1;
        if (i4 &= 1 != 0) {
            obj1 = new ArrayList();
        }
        return FlowKt.toList(flow, obj1, continuation3);
    }

    public static final <T> Object toSet(kotlinx.coroutines.flow.Flow<? extends T> $this$toSet, Set<T> destination, Continuation<? super Set<? extends T>> $completion) {
        return FlowKt.toCollection($this$toSet, (Collection)destination, $completion);
    }

    public static Object toSet$default(kotlinx.coroutines.flow.Flow flow, Set set2, Continuation continuation3, int i4, Object object5) {
        LinkedHashSet obj1;
        if (i4 &= 1 != 0) {
            obj1 = new LinkedHashSet();
        }
        return FlowKt.toSet(flow, obj1, continuation3);
    }
}
