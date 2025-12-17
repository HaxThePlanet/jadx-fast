package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0012\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0011\u0010\r\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010JH\u0010\u0011\u001a\u00020\u0012\"\u0004\u0008\u0001\u0010\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u00152\"\u0010\u0016\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00130\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u001a\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
class v0<T>  extends kotlinx.coroutines.c<T> implements kotlinx.coroutines.u0<T> {
    public v0(g g, boolean z2) {
        super(g, 1, z2);
    }

    static Object K0(kotlinx.coroutines.v0 v0, d d2) {
        return v0.D(d2);
    }

    public T f() {
        return V();
    }

    public Object o(d<? super T> d) {
        return v0.K0(this, d);
    }
}
