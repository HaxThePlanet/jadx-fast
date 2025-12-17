package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.snapping.SnapPosition;
import java.util.List;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0000¨\u0006\n", d2 = {"KeylineSnapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageSize", "Landroidx/compose/material3/carousel/CarouselPageSize;", "getSnapPositionOffset", "", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "itemIndex", "itemCount", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeylineSnapPositionKt {
    public static final SnapPosition KeylineSnapPosition(androidx.compose.material3.carousel.CarouselPageSize pageSize) {
        KeylineSnapPositionKt.KeylineSnapPosition.1 anon = new KeylineSnapPositionKt.KeylineSnapPosition.1(pageSize);
        return (SnapPosition)anon;
    }

    public static final int getSnapPositionOffset(androidx.compose.material3.carousel.Strategy strategy, int itemIndex, int itemCount) {
        int endIndex;
        int offset;
        int startIndex;
        int startIndex2;
        int roundToInt;
        Object obj;
        int roundToInt2;
        int i;
        endIndex = 0;
        if (!strategy.isValid()) {
            return endIndex;
        }
        lastFocalIndex -= firstFocalIndex;
        size += i2;
        size2 += i2;
        roundToInt = 1073741824;
        offset = MathKt.roundToInt(unadjustedOffset -= startIndex);
        if (itemIndex < i4) {
            offset = roundToInt2;
        }
        if (itemCount > i2 + 1 && itemIndex >= itemCount - i5) {
            if (itemIndex >= itemCount - i5) {
                offset = roundToInt;
            }
        }
        return offset;
    }
}
