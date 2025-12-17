package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "onResume", "onPause", "onStop", "onDestroy", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DefaultLifecycleObserver extends androidx.lifecycle.LifecycleObserver {
    @Override // androidx.lifecycle.LifecycleObserver
    public void onCreate(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.LifecycleObserver
    public void onDestroy(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.LifecycleObserver
    public void onPause(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.LifecycleObserver
    public void onResume(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.LifecycleObserver
    public void onStart(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    @Override // androidx.lifecycle.LifecycleObserver
    public void onStop(androidx.lifecycle.LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
    }
}
