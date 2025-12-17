package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0014", d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "getLifecycle$lifecycle_common", "()Landroidx/lifecycle/Lifecycle;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "register", "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifecycleCoroutineScopeImpl extends androidx.lifecycle.LifecycleCoroutineScope implements androidx.lifecycle.LifecycleEventObserver {

    private final CoroutineContext coroutineContext;
    private final androidx.lifecycle.Lifecycle lifecycle;
    public LifecycleCoroutineScopeImpl(androidx.lifecycle.Lifecycle lifecycle, CoroutineContext coroutineContext) {
        Object coroutineContext2;
        androidx.lifecycle.Lifecycle.State dESTROYED;
        int i;
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        super();
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            i = 0;
            JobKt.cancel$default(getCoroutineContext(), i, 1, i);
        }
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public androidx.lifecycle.Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public void onStateChanged(androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event event) {
        int coroutineContext;
        androidx.lifecycle.Lifecycle.State dESTROYED;
        int i;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo((Enum)Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver((LifecycleObserver)this);
            i = 0;
            JobKt.cancel$default(getCoroutineContext(), i, 1, i);
        }
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public final void register() {
        LifecycleCoroutineScopeImpl.register.1 anon = new LifecycleCoroutineScopeImpl.register.1(this, 0);
        BuildersKt.launch$default((CoroutineScope)this, (CoroutineContext)Dispatchers.getMain().getImmediate(), 0, (Function2)anon, 2, 0);
    }
}
