package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aA\u0010\u0007\u001a\u00020\u0008*\u000c\u0012\u0004\u0012\u00020\u0002\u0012\u0002\u0008\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000cH\u0080@ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0010", d2 = {"DefaultIncomingSpec", "Landroidx/compose/animation/core/TweenSpec;", "Landroidx/compose/ui/unit/Dp;", "DefaultOutgoingSpec", "HoveredOutgoingSpec", "OutgoingSpecEasing", "Landroidx/compose/animation/core/Easing;", "animateElevation", "", "Landroidx/compose/animation/core/Animatable;", "target", "from", "Landroidx/compose/foundation/interaction/Interaction;", "to", "animateElevation-rAjV9yQ", "(Landroidx/compose/animation/core/Animatable;FLandroidx/compose/foundation/interaction/Interaction;Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ElevationKt {

    private static final TweenSpec<Dp> DefaultIncomingSpec;
    private static final TweenSpec<Dp> DefaultOutgoingSpec;
    private static final TweenSpec<Dp> HoveredOutgoingSpec;
    private static final Easing OutgoingSpecEasing;
    static {
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(1053609165, 0, 1058642330, 1065353216);
        ElevationKt.OutgoingSpecEasing = (Easing)cubicBezierEasing;
        TweenSpec tweenSpec = new TweenSpec(120, 0, EasingKt.getFastOutSlowInEasing(), 2, 0);
        ElevationKt.DefaultIncomingSpec = tweenSpec;
        TweenSpec tweenSpec2 = new TweenSpec(150, 0, ElevationKt.OutgoingSpecEasing, 2, 0);
        ElevationKt.DefaultOutgoingSpec = tweenSpec2;
        TweenSpec tweenSpec3 = new TweenSpec(120, 0, ElevationKt.OutgoingSpecEasing, 2, 0);
        ElevationKt.HoveredOutgoingSpec = tweenSpec3;
    }

    public static final TweenSpec access$getDefaultIncomingSpec$p() {
        return ElevationKt.DefaultIncomingSpec;
    }

    public static final TweenSpec access$getDefaultOutgoingSpec$p() {
        return ElevationKt.DefaultOutgoingSpec;
    }

    public static final TweenSpec access$getHoveredOutgoingSpec$p() {
        return ElevationKt.HoveredOutgoingSpec;
    }

    public static final Object animateElevation-rAjV9yQ(Animatable<Dp, ?> $this$animateElevation_u2drAjV9yQ, float target, Interaction from, Interaction to, Continuation<? super Unit> $completion) {
        androidx.compose.animation.core.AnimationSpec outgoingAnimationSpecForInteraction;
        if (to != null) {
            outgoingAnimationSpecForInteraction = ElevationDefaults.INSTANCE.incomingAnimationSpecForInteraction(to);
        } else {
            if (from != null) {
                outgoingAnimationSpecForInteraction = ElevationDefaults.INSTANCE.outgoingAnimationSpecForInteraction(from);
            } else {
                outgoingAnimationSpecForInteraction = 0;
            }
        }
        final androidx.compose.animation.core.AnimationSpec animationSpec = outgoingAnimationSpecForInteraction;
        Object obj9 = Animatable.animateTo$default($this$animateElevation_u2drAjV9yQ, Dp.box-impl(target), animationSpec, 0, 0, $completion, 12, 0);
        if (animationSpec != null && obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            obj9 = Animatable.animateTo$default($this$animateElevation_u2drAjV9yQ, Dp.box-impl(target), animationSpec, 0, 0, $completion, 12, 0);
            if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return obj9;
            }
            return Unit.INSTANCE;
        }
        obj9 = $this$animateElevation_u2drAjV9yQ.snapTo(Dp.box-impl(target), $completion);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    public static Object animateElevation-rAjV9yQ$default(Animatable animatable, float f2, Interaction interaction3, Interaction interaction4, Continuation continuation5, int i6, Object object7) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i6 & 2 != 0) {
            obj3 = i;
        }
        if (i6 &= 4 != 0) {
            obj4 = i;
        }
        return ElevationKt.animateElevation-rAjV9yQ(animatable, f2, obj3, obj4, continuation5);
    }
}
