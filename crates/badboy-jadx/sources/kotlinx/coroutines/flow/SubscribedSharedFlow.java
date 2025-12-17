package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0002\u0008\u0003\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002BE\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\u0008\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R:\u0010\u0004\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\u0008\nX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000cR\u0018\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0015", d2 = {"Lkotlinx/coroutines/flow/SubscribedSharedFlow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "sharedFlow", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "collect", "", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SubscribedSharedFlow<T>  implements kotlinx.coroutines.flow.SharedFlow<T> {

    private final Function2<kotlinx.coroutines.flow.FlowCollector<? super T>, Continuation<? super Unit>, Object> action;
    private final kotlinx.coroutines.flow.SharedFlow<T> sharedFlow;
    public SubscribedSharedFlow(kotlinx.coroutines.flow.SharedFlow<? extends T> sharedFlow, Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        super();
        this.sharedFlow = sharedFlow;
        this.action = action;
    }

    public Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, Continuation<?> continuation2) {
        boolean anon;
        int i;
        int i3;
        kotlinx.coroutines.flow.SubscribedSharedFlow label;
        kotlinx.coroutines.flow.SharedFlow sharedFlow;
        kotlinx.coroutines.flow.SubscribedFlowCollector subscribedFlowCollector;
        int i2;
        Object obj7;
        Object obj8;
        anon = continuation2;
        i3 = Integer.MIN_VALUE;
        if (continuation2 instanceof SubscribedSharedFlow.collect.1 && label2 &= i3 != 0) {
            anon = continuation2;
            i3 = Integer.MIN_VALUE;
            if (label2 &= i3 != 0) {
                anon.label = obj8 -= i3;
            } else {
                anon = new SubscribedSharedFlow.collect.1(this, continuation2);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                label = this;
                subscribedFlowCollector = new SubscribedFlowCollector(flowCollector, label.action);
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj8);
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        obj7 = new KotlinNothingValueException();
        throw obj7;
    }

    public List<T> getReplayCache() {
        return this.sharedFlow.getReplayCache();
    }
}
