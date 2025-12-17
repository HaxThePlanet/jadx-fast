package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003", d2 = {"DefaultBoundsAnimation", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Rect;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BoundsAnimationKt {

    private static final SpringSpec<Rect> DefaultBoundsAnimation;
    static {
        BoundsAnimationKt.DefaultBoundsAnimation = AnimationSpecKt.spring$default(0, 1137180672, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 1, 0);
    }

    public static final SpringSpec access$getDefaultBoundsAnimation$p() {
        return BoundsAnimationKt.DefaultBoundsAnimation;
    }
}
