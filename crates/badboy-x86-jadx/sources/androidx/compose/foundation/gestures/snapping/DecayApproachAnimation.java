package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006JU\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/gestures/snapping/DecayApproachAnimation;", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "approachAnimation", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "scope", "Landroidx/compose/foundation/gestures/ScrollScope;", "offset", "velocity", "onAnimationStep", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delta", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DecayApproachAnimation implements androidx.compose.foundation.gestures.snapping.ApproachAnimation<Float, AnimationVector1D> {

    private final DecayAnimationSpec<Float> decayAnimationSpec;
    public DecayApproachAnimation(DecayAnimationSpec<Float> decayAnimationSpec) {
        super();
        this.decayAnimationSpec = decayAnimationSpec;
    }

    public Object approachAnimation(ScrollScope scope, float offset, float velocity, Function1<? super Float, Unit> onAnimationStep, Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<Float, AnimationVector1D>> $completion) {
        int i2 = 0;
        Object obj = SnapFlingBehaviorKt.access$animateDecay(scope, offset, AnimationStateKt.AnimationState$default(0, velocity, 0, obj3, false, obj5, 0), this.decayAnimationSpec, onAnimationStep, $completion);
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj;
        }
        return (AnimationResult)obj;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public Object approachAnimation(ScrollScope scope, Object offset, Object velocity, Function1 onAnimationStep, Continuation $completion) {
        return this.approachAnimation(scope, (Number)offset.floatValue(), (Number)velocity.floatValue(), onAnimationStep, $completion);
    }
}
