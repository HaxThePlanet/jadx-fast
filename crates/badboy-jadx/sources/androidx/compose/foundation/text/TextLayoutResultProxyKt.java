package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0006", d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextLayoutResultProxyKt {
    public static final long access$coerceIn-3MmeM6k(long $receiver, Rect rect) {
        return TextLayoutResultProxyKt.coerceIn-3MmeM6k($receiver, rect);
    }

    private static final long coerceIn-3MmeM6k(long $this$coerceIn_u2d3MmeM6k, Rect rect) {
        float x-impl;
        float right;
        float y-impl;
        float bottom;
        if (Float.compare(x-impl2, right) < 0) {
            x-impl = obj6.getLeft();
        } else {
            if (Float.compare(x-impl3, right) > 0) {
                x-impl = obj6.getRight();
            } else {
                x-impl = Offset.getX-impl($this$coerceIn_u2d3MmeM6k);
            }
        }
        if (Float.compare(y-impl2, bottom) < 0) {
            y-impl = obj6.getTop();
        } else {
            if (Float.compare(y-impl3, bottom) > 0) {
                y-impl = obj6.getBottom();
            } else {
                y-impl = Offset.getY-impl($this$coerceIn_u2d3MmeM6k);
            }
        }
        return OffsetKt.Offset(x-impl, y-impl);
    }
}
