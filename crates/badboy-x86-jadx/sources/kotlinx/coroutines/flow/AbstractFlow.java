package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008'\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractFlow<T>  implements kotlinx.coroutines.flow.Flow<T>, kotlinx.coroutines.flow.CancellableFlow<T> {
    public final Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation2) {
        boolean anon;
        int th;
        int i;
        kotlinx.coroutines.flow.AbstractFlow label;
        Object collectSafely;
        int i2;
        Object obj6;
        Object obj7;
        anon = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof AbstractFlow.collect.1 && label2 &= i != 0) {
            anon = continuation2;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj7 -= i;
            } else {
                anon = new AbstractFlow.collect.1(this, continuation2);
            }
        } else {
        }
        obj7 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj7);
                SafeCollector safeCollector = new SafeCollector(flowCollector, anon.getContext());
                obj6 = safeCollector;
                anon.L$0 = obj6;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj6 = anon.L$0;
                ResultKt.throwOnFailure(obj7);
                break;
            default:
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
        }
        obj6.releaseIntercepted();
        return Unit.INSTANCE;
    }

    public abstract Object collectSafely(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation2);
}
