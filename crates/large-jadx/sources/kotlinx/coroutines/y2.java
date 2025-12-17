package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.w;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.x;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\nH\u0014J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u000c2\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0011\u001a\u0004\u0018\u00010\nR\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "savedContext", "savedOldValue", "", "afterResume", "", "state", "clearThreadContext", "", "saveThreadContext", "oldValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class y2<T>  extends x<T> {

    private g v;
    private Object w;
    public y2(g g, d<? super T> d2) {
        g obj3;
        final kotlinx.coroutines.z2 z2Var = z2.a;
        if (g.get(z2Var) == null) {
            obj3 = g.plus(z2Var);
        }
        super(obj3, d2);
    }

    @Override // kotlinx.coroutines.internal.x
    protected void G0(Object object) {
        int i;
        Object obj;
        w obj6;
        g gVar = this.v;
        i = 0;
        if (gVar == null) {
        } else {
            d0.a(gVar, this.w);
            this.v = i;
            this.w = i;
        }
        d dVar2 = this.c;
        g context = dVar2.getContext();
        final Object obj2 = d0.c(context, i);
        if (obj2 != d0.a) {
            i = g0.e(dVar2, context, obj2);
        }
        this.c.resumeWith(e0.a(object, this.c));
        obj6 = w.a;
        if (i != 0) {
            if (i.L0()) {
                d0.a(context, obj2);
            }
        } else {
        }
    }

    @Override // kotlinx.coroutines.internal.x
    public final boolean L0() {
        if (this.v == null) {
            return 0;
        }
        int i2 = 0;
        this.v = i2;
        this.w = i2;
        return 1;
    }

    @Override // kotlinx.coroutines.internal.x
    public final void M0(g g, Object object2) {
        this.v = g;
        this.w = object2;
    }
}
