package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006", d2 = {"lerp", "Landroidx/compose/ui/graphics/Shadow;", "start", "stop", "fraction", "", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShadowKt {
    public static final androidx.compose.ui.graphics.Shadow lerp(androidx.compose.ui.graphics.Shadow start, androidx.compose.ui.graphics.Shadow stop, float fraction) {
        Shadow shadow = new Shadow(ColorKt.lerp-jxsXWHM(start.getColor-0d7_KjU(), obj2, stop.getColor-0d7_KjU()), obj2, OffsetKt.lerp-Wko1d7g(start.getOffset-F1C5BW0(), obj4, stop.getOffset-F1C5BW0()), obj4, MathHelpersKt.lerp(start.getBlurRadius(), stop.getBlurRadius(), fraction), 0);
        return shadow;
    }
}
