package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0004\u0008\n\u0010\u000bJ\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0008\u001a\u00020\tH\u0082\u0008J\u0008\u0010\u0010\u001a\u00020\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/lifecycle/LifecycleController;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "parentJob", "Lkotlinx/coroutines/Job;", "<init>", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "handleDestroy", "", "finish", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifecycleController {

    private final androidx.lifecycle.DispatchQueue dispatchQueue;
    private final androidx.lifecycle.Lifecycle lifecycle;
    private final androidx.lifecycle.Lifecycle.State minState;
    private final androidx.lifecycle.LifecycleEventObserver observer;
    public static void $r8$lambda$oWRpCg8vH8nSBgktHTqCr-ANl8M(androidx.lifecycle.LifecycleController lifecycleController, Job job2, androidx.lifecycle.LifecycleOwner lifecycleOwner3, androidx.lifecycle.Lifecycle.Event lifecycle$Event4) {
        LifecycleController.observer$lambda$0(lifecycleController, job2, lifecycleOwner3, event4);
    }

    public LifecycleController(androidx.lifecycle.Lifecycle lifecycle, androidx.lifecycle.Lifecycle.State minState, androidx.lifecycle.DispatchQueue dispatchQueue, Job parentJob) {
        Object lifecycle2;
        int observer;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(minState, "minState");
        Intrinsics.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        Intrinsics.checkNotNullParameter(parentJob, "parentJob");
        super();
        this.lifecycle = lifecycle;
        this.minState = minState;
        this.dispatchQueue = dispatchQueue;
        LifecycleController$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LifecycleController$$ExternalSyntheticLambda0(this, parentJob);
        this.observer = externalSyntheticLambda0;
        if (this.lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            observer = 0;
            i2 = 0;
            Job.DefaultImpls.cancel$default(parentJob, i2, 1, i2);
            this.finish();
        } else {
            this.lifecycle.addObserver((LifecycleObserver)this.observer);
        }
    }

    private final void handleDestroy(Job parentJob) {
        final int i = 0;
        final int i2 = 0;
        Job.DefaultImpls.cancel$default(parentJob, i2, 1, i2);
        finish();
    }

    private static final void observer$lambda$0(androidx.lifecycle.LifecycleController this$0, Job $parentJob, androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event lifecycle$Event4) {
        int minState;
        int i2;
        int i;
        Object obj6;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event4, "<unused var>");
        if (source.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            minState = 0;
            i = 0;
            Job.DefaultImpls.cancel$default($parentJob, i, 1, i);
            this$0.finish();
        } else {
            if (source.getLifecycle().getCurrentState().compareTo((Enum)this$0.minState) < 0) {
                this$0.dispatchQueue.pause();
            } else {
                this$0.dispatchQueue.resume();
            }
        }
    }

    public final void finish() {
        this.lifecycle.removeObserver((LifecycleObserver)this.observer);
        this.dispatchQueue.finish();
    }
}
