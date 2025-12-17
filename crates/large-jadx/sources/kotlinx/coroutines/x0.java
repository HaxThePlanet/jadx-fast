package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.e;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a!\u0010\u0000\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\rH\u0087@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u000e\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\rH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\u0008\u0019\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0012", d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class x0 {
    public static final Object a(long l, d<? super w> d2) {
        int cmp;
        if (Long.compare(l, i) <= 0) {
            return w.a;
        }
        q qVar = new q(b.c(obj5), 1);
        qVar.B();
        if (Long.compare(l, l2) < 0) {
            x0.b(qVar.getContext()).j(l, d2);
        }
        Object obj3 = qVar.y();
        if (obj3 == b.d()) {
            h.c(obj5);
        }
        if (obj3 == b.d()) {
            return obj3;
        }
        return w.a;
    }

    public static final kotlinx.coroutines.w0 b(g g) {
        kotlin.b0.g.b obj1;
        if (obj1 instanceof w0) {
        } else {
            obj1 = 0;
        }
        if (obj1 == null) {
            obj1 = t0.a();
        }
        return obj1;
    }
}
