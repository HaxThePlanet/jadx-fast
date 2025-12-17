package kotlinx.coroutines.stream;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0008\u001a\u00020\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000cR\t\u0010\u0006\u001a\u00020\u0007X\u0082\u0004R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\r", d2 = {"Lkotlinx/coroutines/stream/StreamFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "stream", "Ljava/util/stream/Stream;", "(Ljava/util/stream/Stream;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StreamFlow<T>  implements Flow<T> {

    private static final AtomicIntegerFieldUpdater consumed$FU;
    @Volatile
    private volatile int consumed = 0;
    private final Stream<T> stream;
    static {
        StreamFlow.consumed$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed");
    }

    public StreamFlow(Stream<T> stream) {
        super();
        this.stream = stream;
        final int i = 0;
    }

    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation2) {
        boolean anon;
        int stream;
        int i;
        Object l$1;
        Object l$0;
        int next;
        Object emit;
        Iterator it;
        Object obj9;
        Object obj10;
        anon = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof StreamFlow.collect.1 && label &= i != 0) {
            anon = continuation2;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj10 -= i;
            } else {
                anon = new StreamFlow.collect.1(this, continuation2);
            }
        } else {
        }
        obj10 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i2 = 1;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                l$0 = this;
                l$1 = flowCollector;
                obj9 = it;
                obj9 = new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
                throw obj9;
            case 1:
                obj9 = anon.L$2;
                l$1 = anon.L$1;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        if (obj9.hasNext()) {
            anon.L$0 = l$0;
            anon.L$1 = l$1;
            anon.L$2 = obj9;
            anon.label = i2;
            if (l$1.emit(obj9.next(), anon) == cOROUTINE_SUSPENDED) {
                return cOROUTINE_SUSPENDED;
            } else {
            }
        }
        l$0.stream.close();
        return Unit.INSTANCE;
    }
}
