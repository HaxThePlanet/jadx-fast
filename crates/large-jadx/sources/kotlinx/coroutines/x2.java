package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\u0008j\u0002`\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class x2 extends kotlinx.coroutines.h0 {

    public static final kotlinx.coroutines.x2 b;
    static {
        x2 x2Var = new x2();
        x2.b = x2Var;
    }

    @Override // kotlinx.coroutines.h0
    public void K(g g, Runnable runnable2) {
        kotlin.b0.g.b obj1 = g.get(a3.b);
        if ((a3)obj1 == null) {
        } else {
            obj1.a = true;
        }
        obj1 = new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        throw obj1;
    }

    @Override // kotlinx.coroutines.h0
    public boolean L(g g) {
        return 0;
    }

    @Override // kotlinx.coroutines.h0
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
