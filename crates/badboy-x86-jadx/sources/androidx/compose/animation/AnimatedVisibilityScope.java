package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008f\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\u00020\u0008*\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eH\u0016R\u0018\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000fÀ\u0006\u0003", d2 = {"Landroidx/compose/animation/AnimatedVisibilityScope;", "", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "animateEnterExit", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "label", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AnimatedVisibilityScope {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Modifier animateEnterExit(androidx.compose.animation.AnimatedVisibilityScope $this, Modifier $receiver, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, String label) {
            return AnimatedVisibilityScope.access$animateEnterExit$jd($this, $receiver, enter, exit, label);
        }

        public static Modifier animateEnterExit$default(androidx.compose.animation.AnimatedVisibilityScope animatedVisibilityScope, Modifier modifier2, androidx.compose.animation.EnterTransition enterTransition3, androidx.compose.animation.ExitTransition exitTransition4, String string5, int i6, Object object7) {
            return AnimatedVisibilityScope.animateEnterExit$default(animatedVisibilityScope, modifier2, enterTransition3, exitTransition4, string5, i6, object7);
        }
    }
    public static Modifier access$animateEnterExit$jd(androidx.compose.animation.AnimatedVisibilityScope $this, Modifier $receiver, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, String label) {
        return super.animateEnterExit($receiver, enter, exit, label);
    }

    public static Modifier animateEnterExit$default(androidx.compose.animation.AnimatedVisibilityScope animatedVisibilityScope, Modifier modifier2, androidx.compose.animation.EnterTransition enterTransition3, androidx.compose.animation.ExitTransition exitTransition4, String string5, int i6, Object object7) {
        androidx.compose.animation.EnterTransition obj5;
        androidx.compose.animation.ExitTransition obj6;
        String obj7;
        if (object7 != null) {
        } else {
            final int i = 3;
            final int i2 = 0;
            final int i3 = 0;
            if (i6 & 1 != 0) {
                obj5 = EnterExitTransitionKt.fadeIn$default(i3, i2, i, i3);
            }
            if (i6 & 2 != 0) {
                obj6 = EnterExitTransitionKt.fadeOut$default(i3, i2, i, i3);
            }
            if (i6 &= 4 != 0) {
                obj7 = "animateEnterExit";
            }
            return animatedVisibilityScope.animateEnterExit(modifier2, obj5, obj6, obj7);
        }
        UnsupportedOperationException obj3 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateEnterExit");
        throw obj3;
    }

    public Modifier animateEnterExit(Modifier $this$animateEnterExit, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, String label) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new AnimatedVisibilityScope.animateEnterExit$$inlined.debugInspectorInfo.1(enter, exit, label);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        AnimatedVisibilityScope.animateEnterExit.2 $i$f$debugInspectorInfo = new AnimatedVisibilityScope.animateEnterExit.2(this, enter, exit, label);
        return ComposedModifierKt.composed($this$animateEnterExit, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public abstract Transition<androidx.compose.animation.EnterExitState> getTransition();
}
