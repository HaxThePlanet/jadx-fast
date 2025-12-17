package kotlinx.coroutines.b3;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.flow.internal.e;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008'\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class a<T>  implements kotlinx.coroutines.b3.d<T> {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = 212, m = "collect")
    static final class a extends d {

        Object L$0;
        int label;
        Object result;
        final kotlinx.coroutines.b3.a<T> this$0;
        a(kotlinx.coroutines.b3.a<T> a, d<? super kotlinx.coroutines.b3.a.a> d2) {
            this.this$0 = a;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.a(0, this);
        }
    }
    public final Object a(kotlinx.coroutines.b3.e<? super T> e, d<? super w> d2) {
        boolean aVar;
        int label;
        int i2;
        kotlin.b0.g context;
        int i;
        Object obj;
        Object obj6;
        Object obj7;
        aVar = d2;
        label = aVar.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof a.a && label & i2 != 0) {
            aVar = d2;
            label = aVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                aVar.label = label -= i2;
            } else {
                aVar = new a.a(this, d2);
            }
        } else {
        }
        obj7 = aVar.result;
        Object obj2 = b.d();
        context = aVar.label;
        int i3 = 1;
        if (context != null) {
            if (context != i3) {
            } else {
                obj6 = aVar.L$0;
                q.b(obj7);
                obj6.releaseIntercepted();
                return w.a;
            }
            obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj6;
        }
        q.b(obj7);
        obj7 = new e(e, aVar.getContext());
        aVar.L$0 = obj7;
        aVar.label = i3;
        if (b(obj7, aVar) == obj2) {
            return obj2;
        }
        obj6 = obj7;
    }

    public abstract Object b(kotlinx.coroutines.b3.e<? super T> e, d<? super w> d2);
}
