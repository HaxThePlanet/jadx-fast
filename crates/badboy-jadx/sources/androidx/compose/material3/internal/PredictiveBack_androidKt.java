package androidx.compose.material3.internal;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002", d2 = {"PredictiveBackEasing", "Landroidx/compose/animation/core/Easing;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PredictiveBack_androidKt {

    private static final Easing PredictiveBackEasing;
    static {
        final int i3 = 1036831949;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(i3, i3, 0, 1065353216);
        PredictiveBack_androidKt.PredictiveBackEasing = (Easing)cubicBezierEasing;
    }

    public static final Easing access$getPredictiveBackEasing$p() {
        return PredictiveBack_androidKt.PredictiveBackEasing;
    }
}
