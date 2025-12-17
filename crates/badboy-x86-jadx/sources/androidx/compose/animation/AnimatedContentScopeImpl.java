package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J+\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011H\u0096\u0001R\u0018\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0012", d2 = {"Landroidx/compose/animation/AnimatedContentScopeImpl;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "animatedVisibilityScope", "(Landroidx/compose/animation/AnimatedVisibilityScope;)V", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "animateEnterExit", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "label", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AnimatedContentScopeImpl implements androidx.compose.animation.AnimatedContentScope, androidx.compose.animation.AnimatedVisibilityScope {

    private final androidx.compose.animation.AnimatedVisibilityScope $$delegate_0;
    public AnimatedContentScopeImpl(androidx.compose.animation.AnimatedVisibilityScope animatedVisibilityScope) {
        super();
        this.$$delegate_0 = animatedVisibilityScope;
    }

    @Override // androidx.compose.animation.AnimatedContentScope
    public Modifier animateEnterExit(Modifier modifier, androidx.compose.animation.EnterTransition enterTransition2, androidx.compose.animation.ExitTransition exitTransition3, String string4) {
        return this.$$delegate_0.animateEnterExit(modifier, enterTransition2, exitTransition3, string4);
    }

    public Transition<androidx.compose.animation.EnterExitState> getTransition() {
        return this.$$delegate_0.getTransition();
    }
}
