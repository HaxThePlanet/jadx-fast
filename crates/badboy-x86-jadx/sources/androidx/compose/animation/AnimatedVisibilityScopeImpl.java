package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0008\u0000\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR \u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u0005¨\u0006\u000e", d2 = {"Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "(Landroidx/compose/animation/core/Transition;)V", "targetSize", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/IntSize;", "getTargetSize$animation_release", "()Landroidx/compose/runtime/MutableState;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimatedVisibilityScopeImpl implements androidx.compose.animation.AnimatedVisibilityScope {

    public static final int $stable = 8;
    private final MutableState<IntSize> targetSize;
    private Transition<androidx.compose.animation.EnterExitState> transition;
    static {
        final int i = 8;
    }

    public AnimatedVisibilityScopeImpl(Transition<androidx.compose.animation.EnterExitState> transition) {
        super();
        this.transition = transition;
        final int i = 0;
        this.targetSize = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), i, 2, i);
    }

    public final MutableState<IntSize> getTargetSize$animation_release() {
        return this.targetSize;
    }

    public Transition<androidx.compose.animation.EnterExitState> getTransition() {
        return this.transition;
    }

    public void setTransition(Transition<androidx.compose.animation.EnterExitState> <set-?>) {
        this.transition = <set-?>;
    }
}
