package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.b0.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\u001a\u0019\u0010\u0008\u001a\u00020\t2\u000e\u0008\u0004\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bH\u0087\u0008\u001a\u0012\u0010\r\u001a\u00020\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u001a\u0019\u0010\u0010\u001a\u00020\u00052\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0008\r\u001a\u000c\u0010\u0011\u001a\u00020\u000c*\u00020\u0002H\u0007\u001a\u0018\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007\u001a\u001c\u0010\u0011\u001a\u00020\u000c*\u00020\u00022\u0010\u0008\u0002\u0010\u0012\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015\u001a\u001e\u0010\u0011\u001a\u00020\u000c*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u001a\u0015\u0010\u0018\u001a\u00020\u000c*\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u000c\u0010\u001a\u001a\u00020\u000c*\u00020\u0002H\u0007\u001a\u0018\u0010\u001a\u001a\u00020\u000c*\u00020\u00022\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007\u001a\u001c\u0010\u001a\u001a\u00020\u000c*\u00020\u00022\u0010\u0008\u0002\u0010\u0012\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015\u001a\u000c\u0010\u001a\u001a\u00020\u000c*\u00020\u0005H\u0007\u001a\u0018\u0010\u001a\u001a\u00020\u000c*\u00020\u00052\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007\u001a\u001c\u0010\u001a\u001a\u00020\u000c*\u00020\u00052\u0010\u0008\u0002\u0010\u0012\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015\u001a\u0014\u0010\u001b\u001a\u00020\t*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\tH\u0000\u001a\n\u0010\u001d\u001a\u00020\u000c*\u00020\u0002\u001a\n\u0010\u001d\u001a\u00020\u000c*\u00020\u0005\u001a\u001b\u0010\u001e\u001a\u00020\u0013*\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0008\u001f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006 ", d2 = {"isActive", "", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "job", "Lkotlinx/coroutines/Job;", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "DisposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "block", "Lkotlin/Function0;", "", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Job0", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "disposeOnCompletion", "handle", "ensureActive", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/JobKt")
final class d2 {
    public static final kotlinx.coroutines.z a(kotlinx.coroutines.y1 y1) {
        a2 a2Var = new a2(y1);
        return a2Var;
    }

    public static kotlinx.coroutines.z b(kotlinx.coroutines.y1 y1, int i2, Object object3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return b2.a(obj0);
    }

    public static final void c(g g, CancellationException cancellationException2) {
        final kotlin.b0.g.b obj1 = g.get(y1.s);
        if ((y1)obj1 == null) {
        } else {
            (y1)obj1.c(cancellationException2);
        }
    }

    public static void d(g g, CancellationException cancellationException2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        b2.c(g, obj1);
    }

    public static final kotlinx.coroutines.e1 e(kotlinx.coroutines.y1 y1, kotlinx.coroutines.e1 e12) {
        g1 g1Var = new g1(e12);
        return y1.w(g1Var);
    }

    public static final void f(g g) {
        final kotlin.b0.g.b obj1 = g.get(y1.s);
        if ((y1)obj1 == null) {
        } else {
            b2.h((y1)obj1);
        }
    }

    public static final void g(kotlinx.coroutines.y1 y1) {
        if (!y1.a()) {
        } else {
        }
        throw y1.n();
    }
}
