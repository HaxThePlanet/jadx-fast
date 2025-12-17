package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002BE\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0005¢\u0006\u0002\u0008\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R:\u0010\u0004\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0005¢\u0006\u0002\u0008\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0011", d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscribedFlowCollector<T>  implements kotlinx.coroutines.flow.FlowCollector<T> {

    private final Function2<kotlinx.coroutines.flow.FlowCollector<? super T>, Continuation<? super Unit>, Object> action;
    private final kotlinx.coroutines.flow.FlowCollector<T> collector;
    public SubscribedFlowCollector(kotlinx.coroutines.flow.FlowCollector<? super T> collector, Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        super();
        this.collector = collector;
        this.action = action;
    }

    public Object emit(T t, Continuation<? super Unit> continuation2) {
        return this.collector.emit(t, continuation2);
    }

    public final Object onSubscription(Continuation<? super Unit> continuation) {
        boolean anon;
        int th;
        int i;
        Object safeCollector;
        int onSubscription;
        Object l$0;
        Object invoke;
        int i2;
        kotlin.coroutines.CoroutineContext context;
        Object obj8;
        anon = continuation;
        i = Integer.MIN_VALUE;
        if (continuation instanceof SubscribedFlowCollector.onSubscription.1 && label &= i != 0) {
            anon = continuation;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj8 -= i;
            } else {
                anon = new SubscribedFlowCollector.onSubscription.1(this, continuation);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (onSubscription) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                l$0 = this;
                int i4 = 0;
                safeCollector = new SafeCollector(l$0.collector, anon.getContext());
                anon.L$0 = l$0;
                anon.L$1 = safeCollector;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                safeCollector = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                break;
            case 2:
                ResultKt.throwOnFailure(obj8);
                return Unit.INSTANCE;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        safeCollector.releaseIntercepted();
        if (collector instanceof SubscribedFlowCollector) {
            int i3 = 0;
            anon.L$0 = i3;
            anon.L$1 = i3;
            anon.label = 2;
            if ((SubscribedFlowCollector)l$0.collector.onSubscription(anon) == cOROUTINE_SUSPENDED) {
                return cOROUTINE_SUSPENDED;
            }
        } else {
        }
    }
}
