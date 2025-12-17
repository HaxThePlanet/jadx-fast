package androidx.compose.ui.text.font;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006", d2 = {"lerp", "Landroidx/compose/ui/text/font/FontWeight;", "start", "stop", "fraction", "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FontWeightKt {
    public static final androidx.compose.ui.text.font.FontWeight lerp(androidx.compose.ui.text.font.FontWeight start, androidx.compose.ui.text.font.FontWeight stop, float fraction) {
        FontWeight fontWeight = new FontWeight(RangesKt.coerceIn(MathHelpersKt.lerp(start.getWeight(), stop.getWeight(), fraction), 1, 1000));
        return fontWeight;
    }
}
