package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007", d2 = {"installForLifecycle", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewCompositionStrategy_androidKt {
    public static void $r8$lambda$D5Cf8m1NCNtbpusdZlfnNWwNV-M(androidx.compose.ui.platform.AbstractComposeView abstractComposeView, LifecycleOwner lifecycleOwner2, Lifecycle.Event lifecycle$Event3) {
        ViewCompositionStrategy_androidKt.installForLifecycle$lambda$1(abstractComposeView, lifecycleOwner2, event3);
    }

    public static final Function0 access$installForLifecycle(androidx.compose.ui.platform.AbstractComposeView view, Lifecycle lifecycle) {
        return ViewCompositionStrategy_androidKt.installForLifecycle(view, lifecycle);
    }

    private static final Function0<Unit> installForLifecycle(androidx.compose.ui.platform.AbstractComposeView view, Lifecycle lifecycle) {
        int i;
        i = lifecycle.getCurrentState().compareTo((Enum)Lifecycle.State.DESTROYED) > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0(view);
            lifecycle.addObserver((LifecycleObserver)externalSyntheticLambda0);
            ViewCompositionStrategy_androidKt.installForLifecycle.2 anon = new ViewCompositionStrategy_androidKt.installForLifecycle.2(lifecycle, externalSyntheticLambda0);
            return (Function0)anon;
        }
        int observer = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Cannot configure ").append(view).append(" to disposeComposition at Lifecycle ON_DESTROY: ").append(lifecycle).append("is already destroyed").toString().toString());
        throw illegalStateException;
    }

    private static final void installForLifecycle$lambda$1(androidx.compose.ui.platform.AbstractComposeView $view, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            $view.disposeComposition();
        }
    }
}
