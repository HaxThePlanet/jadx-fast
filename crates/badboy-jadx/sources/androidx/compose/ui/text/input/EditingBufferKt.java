package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0006", d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EditingBufferKt {
    public static final long updateRangeAfterDelete-pWDy79M(long target, long deleted) {
        int targetMin;
        int targetMax;
        boolean contains-impl;
        targetMin = TextRange.getMin-impl(target);
        targetMax = TextRange.getMax-impl(target);
        if (TextRange.intersects-5zc-tL8(obj6, obj7)) {
            if (TextRange.contains-5zc-tL8(obj6, obj7)) {
                targetMax = targetMin;
            } else {
                if (TextRange.contains-5zc-tL8(target, deleted)) {
                    targetMax -= contains-impl;
                } else {
                    if (TextRange.contains-impl(obj6, obj7)) {
                        targetMin = TextRange.getMin-impl(obj6);
                        targetMax -= contains-impl;
                    } else {
                        targetMax = TextRange.getMin-impl(obj6);
                    }
                }
            }
        } else {
            if (targetMax > TextRange.getMin-impl(obj6)) {
                targetMin -= length-impl;
                targetMax -= contains-impl;
            }
        }
        return TextRangeKt.TextRange(targetMin, targetMax);
    }
}
