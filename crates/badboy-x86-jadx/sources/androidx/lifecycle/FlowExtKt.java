package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"flowWithLifecycle", "Lkotlinx/coroutines/flow/Flow;", "T", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FlowExtKt {
    public static final <T> Flow<T> flowWithLifecycle(Flow<? extends T> $this$flowWithLifecycle, androidx.lifecycle.Lifecycle lifecycle, androidx.lifecycle.Lifecycle.State minActiveState) {
        Intrinsics.checkNotNullParameter($this$flowWithLifecycle, "<this>");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(minActiveState, "minActiveState");
        FlowExtKt.flowWithLifecycle.1 anon = new FlowExtKt.flowWithLifecycle.1(lifecycle, minActiveState, $this$flowWithLifecycle, 0);
        return FlowKt.callbackFlow((Function2)anon);
    }

    public static Flow flowWithLifecycle$default(Flow flow, androidx.lifecycle.Lifecycle lifecycle2, androidx.lifecycle.Lifecycle.State lifecycle$State3, int i4, Object object5) {
        androidx.lifecycle.Lifecycle.State obj2;
        if (i4 &= 2 != 0) {
            obj2 = Lifecycle.State.STARTED;
        }
        return FlowExtKt.flowWithLifecycle(flow, lifecycle2, obj2);
    }
}
