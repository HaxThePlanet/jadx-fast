package kotlinx.coroutines.b3;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.d0.c.p;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B7\u0012-\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0004¢\u0006\u0002\u0008\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001f\u0010\u000c\u001a\u00020\u00072\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR:\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0004¢\u0006\u0002\u0008\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"Lkotlinx/coroutines/flow/SafeFlow;", "T", "Lkotlinx/coroutines/flow/AbstractFlow;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "collectSafely", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class l<T>  extends kotlinx.coroutines.b3.a<T> {

    private final p<kotlinx.coroutines.b3.e<? super T>, d<? super w>, Object> a;
    public l(p<? super kotlinx.coroutines.b3.e<? super T>, ? super d<? super w>, ? extends Object> p) {
        super();
        this.a = p;
    }

    public Object b(kotlinx.coroutines.b3.e<? super T> e, d<? super w> d2) {
        Object obj2 = this.a.invoke(e, d2);
        if (obj2 == b.d()) {
            return obj2;
        }
        return w.a;
    }
}
