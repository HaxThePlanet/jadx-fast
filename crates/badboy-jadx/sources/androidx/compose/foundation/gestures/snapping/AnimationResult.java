package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B!\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\u0008J\u000e\u0010\u000e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000cJ\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0086\u0002R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0010", d2 = {"Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "remainingOffset", "currentAnimationState", "Landroidx/compose/animation/core/AnimationState;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationState;)V", "getCurrentAnimationState", "()Landroidx/compose/animation/core/AnimationState;", "getRemainingOffset", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AnimationResult<T, V extends androidx.compose.animation.core.AnimationVector>  {

    private final AnimationState<T, V> currentAnimationState;
    private final T remainingOffset;
    public AnimationResult(T remainingOffset, AnimationState<T, V> currentAnimationState) {
        super();
        this.remainingOffset = remainingOffset;
        this.currentAnimationState = currentAnimationState;
    }

    public final T component1() {
        return this.remainingOffset;
    }

    public final AnimationState<T, V> component2() {
        return this.currentAnimationState;
    }

    public final AnimationState<T, V> getCurrentAnimationState() {
        return this.currentAnimationState;
    }

    public final T getRemainingOffset() {
        return this.remainingOffset;
    }
}
