package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t", d2 = {"Landroidx/compose/material/ElevationDefaults;", "", "()V", "incomingAnimationSpecForInteraction", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/Dp;", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingAnimationSpecForInteraction", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ElevationDefaults {

    public static final androidx.compose.material.ElevationDefaults INSTANCE;
    static {
        ElevationDefaults elevationDefaults = new ElevationDefaults();
        ElevationDefaults.INSTANCE = elevationDefaults;
    }

    public final AnimationSpec<Dp> incomingAnimationSpecForInteraction(Interaction interaction) {
        androidx.compose.animation.core.TweenSpec tweenSpec;
        if (interaction instanceof PressInteraction.Press) {
            tweenSpec = ElevationKt.access$getDefaultIncomingSpec$p();
        } else {
            if (interaction instanceof DragInteraction.Start) {
                tweenSpec = ElevationKt.access$getDefaultIncomingSpec$p();
            } else {
                if (interaction instanceof HoverInteraction.Enter) {
                    tweenSpec = ElevationKt.access$getDefaultIncomingSpec$p();
                } else {
                    if (interaction instanceof FocusInteraction.Focus) {
                        tweenSpec = ElevationKt.access$getDefaultIncomingSpec$p();
                    } else {
                        tweenSpec = 0;
                    }
                }
            }
        }
        return tweenSpec;
    }

    public final AnimationSpec<Dp> outgoingAnimationSpecForInteraction(Interaction interaction) {
        androidx.compose.animation.core.TweenSpec tweenSpec;
        if (interaction instanceof PressInteraction.Press) {
            tweenSpec = ElevationKt.access$getDefaultOutgoingSpec$p();
        } else {
            if (interaction instanceof DragInteraction.Start) {
                tweenSpec = ElevationKt.access$getDefaultOutgoingSpec$p();
            } else {
                if (interaction instanceof HoverInteraction.Enter) {
                    tweenSpec = ElevationKt.access$getHoveredOutgoingSpec$p();
                } else {
                    if (interaction instanceof FocusInteraction.Focus) {
                        tweenSpec = ElevationKt.access$getDefaultOutgoingSpec$p();
                    } else {
                        tweenSpec = 0;
                    }
                }
            }
        }
        return tweenSpec;
    }
}
