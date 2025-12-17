package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0000¨\u0006\u000c", d2 = {"getSelectionHandleCoordinates", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", "", "isStart", "", "areHandlesCrossed", "(Landroidx/compose/ui/text/TextLayoutResult;IZZ)J", "getHorizontalPosition", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextSelectionDelegateKt {
    public static final float getHorizontalPosition(TextLayoutResult $this$getHorizontalPosition, int offset, boolean isStart, boolean areHandlesCrossed) {
        int i2;
        int i;
        if (isStart) {
            if (areHandlesCrossed) {
                if (!isStart && areHandlesCrossed) {
                    if (areHandlesCrossed) {
                        i = offset;
                    } else {
                        i = Math.max(offset + -1, 0);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if ($this$getHorizontalPosition.getBidiRunDirection(i) == $this$getHorizontalPosition.getParagraphDirection(offset)) {
            i2 = 1;
        }
        return $this$getHorizontalPosition.getHorizontalPosition(offset, i2);
    }

    public static final long getSelectionHandleCoordinates(TextLayoutResult textLayoutResult, int offset, boolean isStart, boolean areHandlesCrossed) {
        final int lineForOffset = textLayoutResult.getLineForOffset(offset);
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        int i = 0;
        return OffsetKt.Offset(RangesKt.coerceIn(TextSelectionDelegateKt.getHorizontalPosition(textLayoutResult, offset, isStart, areHandlesCrossed), i, (float)width-impl), RangesKt.coerceIn(textLayoutResult.getLineBottom(lineForOffset), i, (float)height-impl));
    }
}
