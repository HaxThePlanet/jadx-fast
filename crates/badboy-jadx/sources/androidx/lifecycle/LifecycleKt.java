package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"coroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/Lifecycle;", "getCoroutineScope", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/lifecycle/Lifecycle$Event;", "getEventFlow", "(Landroidx/lifecycle/Lifecycle;)Lkotlinx/coroutines/flow/Flow;", "lifecycle-common"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LifecycleKt {
    public static final androidx.lifecycle.LifecycleCoroutineScope getCoroutineScope(androidx.lifecycle.Lifecycle $this$coroutineScope) {
        String str;
        androidx.lifecycle.LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        boolean compareAndSet;
        int i;
        MainCoroutineDispatcher immediate;
        Intrinsics.checkNotNullParameter($this$coroutineScope, "<this>");
        str = $this$coroutineScope.getInternalScopeRef().get();
        while ((LifecycleCoroutineScopeImpl)str != null) {
            i = 0;
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl($this$coroutineScope, SupervisorKt.SupervisorJob$default(i, 1, i).plus((CoroutineContext)Dispatchers.getMain().getImmediate()));
            str = $this$coroutineScope.getInternalScopeRef().get();
        }
        return (LifecycleCoroutineScope)(LifecycleCoroutineScopeImpl)(LifecycleCoroutineScopeImpl)str;
    }

    public static final Flow<androidx.lifecycle.Lifecycle.Event> getEventFlow(androidx.lifecycle.Lifecycle $this$eventFlow) {
        Intrinsics.checkNotNullParameter($this$eventFlow, "<this>");
        LifecycleKt.eventFlow.1 anon = new LifecycleKt.eventFlow.1($this$eventFlow, 0);
        return FlowKt.flowOn(FlowKt.callbackFlow((Function2)anon), (CoroutineContext)Dispatchers.getMain().getImmediate());
    }
}
