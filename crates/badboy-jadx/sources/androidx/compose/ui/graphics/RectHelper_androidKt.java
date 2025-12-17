package androidx.compose.ui.graphics;

import android.graphics.Rect;
import android.graphics.RectF;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.IntRect;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0005¨\u0006\u0008", d2 = {"toAndroidRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/IntRect;", "toAndroidRectF", "Landroid/graphics/RectF;", "toComposeIntRect", "toComposeRect", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RectHelper_androidKt {
    @Deprecated(message = "Converting Rect to android.graphics.Rect is lossy, and requires rounding. The behavior of toAndroidRect() truncates to an integral Rect, but you should choose the method of rounding most suitable for your use case.", replaceWith = @ReplaceWith(...))
    public static final Rect toAndroidRect(Rect $this$toAndroidRect) {
        Rect rect = new Rect((int)left, (int)top, (int)right, (int)bottom);
        return rect;
    }

    public static final Rect toAndroidRect(IntRect $this$toAndroidRect) {
        Rect rect = new Rect($this$toAndroidRect.getLeft(), $this$toAndroidRect.getTop(), $this$toAndroidRect.getRight(), $this$toAndroidRect.getBottom());
        return rect;
    }

    public static final RectF toAndroidRectF(Rect $this$toAndroidRectF) {
        RectF rectF = new RectF($this$toAndroidRectF.getLeft(), $this$toAndroidRectF.getTop(), $this$toAndroidRectF.getRight(), $this$toAndroidRectF.getBottom());
        return rectF;
    }

    public static final IntRect toComposeIntRect(Rect $this$toComposeIntRect) {
        IntRect intRect = new IntRect($this$toComposeIntRect.left, $this$toComposeIntRect.top, $this$toComposeIntRect.right, $this$toComposeIntRect.bottom);
        return intRect;
    }

    public static final Rect toComposeRect(Rect $this$toComposeRect) {
        Rect rect = new Rect((float)left, (float)top, (float)right, (float)bottom);
        return rect;
    }

    public static final Rect toComposeRect(RectF $this$toComposeRect) {
        Rect rect = new Rect($this$toComposeRect.left, $this$toComposeRect.top, $this$toComposeRect.right, $this$toComposeRect.bottom);
        return rect;
    }
}
