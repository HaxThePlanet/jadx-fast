package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¨\u0006\u0007", d2 = {"checkLifecycleStateTransition", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "current", "Landroidx/lifecycle/Lifecycle$State;", "next", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LifecycleRegistryKt {
    public static final void checkLifecycleStateTransition(androidx.lifecycle.LifecycleOwner owner, androidx.lifecycle.Lifecycle.State current, androidx.lifecycle.Lifecycle.State next) {
        androidx.lifecycle.Lifecycle.State iNITIALIZED;
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(next, "next");
        if (current == Lifecycle.State.INITIALIZED) {
            if (next == Lifecycle.State.DESTROYED) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("State must be at least '").append(Lifecycle.State.CREATED).append("' to be moved to '").append(next).append("' in component ").append(owner).toString().toString());
            throw illegalStateException;
        }
        if (current == Lifecycle.State.DESTROYED) {
            if (current != next) {
            } else {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder2.append("State is '").append(Lifecycle.State.DESTROYED).append("' and cannot be moved to `").append(next).append("` in component ").append(owner).toString().toString());
            throw illegalStateException2;
        }
    }
}
