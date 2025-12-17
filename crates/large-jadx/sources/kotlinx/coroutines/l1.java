package kotlinx.coroutines;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0008\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004", d2 = {"createEventLoop", "Lkotlinx/coroutines/EventLoop;", "processNextEventInCurrentThread", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class l1 {
    public static final kotlinx.coroutines.i1 a() {
        j jVar = new j(Thread.currentThread());
        return jVar;
    }
}
