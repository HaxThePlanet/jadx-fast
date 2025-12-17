package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.IntRef;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u001a!\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000b", d2 = {"count", "", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CountKt {
    public static final <T> Object count(kotlinx.coroutines.flow.Flow<? extends T> flow, Continuation<? super Integer> continuation2) {
        boolean anon;
        int i3;
        int i2;
        Ref.IntRef intRef;
        kotlinx.coroutines.flow.FlowKt__CountKt.count.2 anon2;
        int i;
        Object obj5;
        Object obj6;
        anon = continuation2;
        i2 = Integer.MIN_VALUE;
        if (continuation2 instanceof FlowKt__CountKt.count.1 && label &= i2 != 0) {
            anon = continuation2;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj6 -= i2;
            } else {
                anon = new FlowKt__CountKt.count.1(continuation2);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (intRef) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                intRef = new Ref.IntRef();
                anon2 = new FlowKt__CountKt.count.2(intRef);
                anon.L$0 = intRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = intRef;
                break;
            case 1:
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        return Boxing.boxInt(obj5.element);
    }

    public static final <T> Object count(kotlinx.coroutines.flow.Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22, Continuation<? super Integer> continuation3) {
        boolean anon;
        int i;
        int i3;
        Ref.IntRef intRef;
        kotlinx.coroutines.flow.FlowKt__CountKt.count.4 anon2;
        int i2;
        Object obj5;
        Object obj7;
        anon = continuation3;
        i3 = Integer.MIN_VALUE;
        if (continuation3 instanceof FlowKt__CountKt.count.3 && label &= i3 != 0) {
            anon = continuation3;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj7 -= i3;
            } else {
                anon = new FlowKt__CountKt.count.3(continuation3);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (intRef) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                intRef = new Ref.IntRef();
                anon2 = new FlowKt__CountKt.count.4(function22, intRef);
                anon.L$0 = intRef;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj5 = intRef;
                break;
            case 1:
                obj5 = anon.L$0;
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
        }
        return Boxing.boxInt(obj5.element);
    }
}
