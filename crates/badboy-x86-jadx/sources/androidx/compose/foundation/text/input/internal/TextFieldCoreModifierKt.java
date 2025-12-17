package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a$\u0010\u0007\u001a\u00020\u0008*\u00020\t2\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\rH\u0002\u001a\u000c\u0010\u000e\u001a\u00020\u000f*\u00020\u000fH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0006¨\u0006\u0010", d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", "F", "isSpecified", "", "Landroidx/compose/ui/graphics/Brush;", "(Landroidx/compose/ui/graphics/Brush;)Z", "getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorRect", "rtl", "textLayoutSize", "", "roundToNext", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldCoreModifierKt {

    private static final float DefaultCursorThickness;
    static {
        final int i2 = 0;
        TextFieldCoreModifierKt.DefaultCursorThickness = Dp.constructor-impl((float)i);
    }

    public static final Rect access$getCursorRectInScroller(Density $receiver, Rect cursorRect, boolean rtl, int textLayoutSize) {
        return TextFieldCoreModifierKt.getCursorRectInScroller($receiver, cursorRect, rtl, textLayoutSize);
    }

    public static final boolean access$isSpecified(Brush $receiver) {
        return TextFieldCoreModifierKt.isSpecified($receiver);
    }

    public static final float access$roundToNext(float $receiver) {
        return TextFieldCoreModifierKt.roundToNext($receiver);
    }

    private static final Rect getCursorRectInScroller(Density $this$getCursorRectInScroller, Rect cursorRect, boolean rtl, int textLayoutSize) {
        int left;
        int i2;
        float right;
        float f;
        int i;
        int roundToPx-0680j_4 = $this$getCursorRectInScroller.roundToPx-0680j_4(TextFieldCoreModifierKt.DefaultCursorThickness);
        if (rtl) {
            f3 -= right;
        } else {
            left = cursorRect.getLeft();
        }
        if (rtl) {
            i = i2;
        } else {
            i = i2;
        }
        return Rect.copy$default(cursorRect, left, 0, i, 0, 10, 0);
    }

    private static final boolean isSpecified(Brush $this$isSpecified) {
        boolean z;
        int i2;
        long value-0d7_KjU;
        int cmp;
        int i;
        if ($this$isSpecified instanceof SolidColor) {
            int i3 = 0;
            i = 0;
            z = Long.compare(value-0d7_KjU, i4) == 0 ? i2 : i;
            if (z == 0) {
            } else {
                i2 = i;
            }
        } else {
        }
        return i2;
    }

    private static final float roundToNext(float $this$roundToNext) {
        float f;
        boolean naN;
        if (!Float.isNaN($this$roundToNext)) {
            if (Float.isInfinite($this$roundToNext)) {
                f = $this$roundToNext;
            } else {
                if (Float.compare($this$roundToNext, i) > 0) {
                    f = (float)ceil;
                } else {
                    f = (float)floor;
                }
            }
        } else {
        }
        return f;
    }
}
