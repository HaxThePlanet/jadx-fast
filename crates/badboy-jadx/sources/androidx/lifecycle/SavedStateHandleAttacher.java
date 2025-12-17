package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Landroidx/lifecycle/SavedStateHandleAttacher;", "Landroidx/lifecycle/LifecycleEventObserver;", "provider", "Landroidx/lifecycle/SavedStateHandlesProvider;", "<init>", "(Landroidx/lifecycle/SavedStateHandlesProvider;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandleAttacher implements androidx.lifecycle.LifecycleEventObserver {

    private final androidx.lifecycle.SavedStateHandlesProvider provider;
    public SavedStateHandleAttacher(androidx.lifecycle.SavedStateHandlesProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        super();
        this.provider = provider;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(androidx.lifecycle.LifecycleOwner source, androidx.lifecycle.Lifecycle.Event event) {
        int i;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        i = event == Lifecycle.Event.ON_CREATE ? 1 : 0;
        if (i == 0) {
        } else {
            source.getLifecycle().removeObserver((LifecycleObserver)this);
            this.provider.performRestore();
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Next event must be ON_CREATE, it was ").append(event).toString().toString());
        throw illegalStateException;
    }
}
