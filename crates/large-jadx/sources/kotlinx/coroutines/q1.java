package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0008\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0004*\u00020\u0005H\u0007¢\u0006\u0002\u0008\u0003\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0007", d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "from", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/ExecutorService;", "asExecutor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class q1 {
    public static final kotlinx.coroutines.h0 a(Executor executor) {
        Object obj;
        kotlinx.coroutines.h0 p1Var;
        if (executor instanceof b1) {
            obj = executor;
        } else {
            obj = 0;
        }
        if (obj == null) {
            p1Var = new p1(executor);
        } else {
            p1Var = obj.a;
        }
        return p1Var;
    }
}
