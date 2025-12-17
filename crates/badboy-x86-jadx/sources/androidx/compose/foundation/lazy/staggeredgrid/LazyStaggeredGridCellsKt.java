package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¨\u0006\u0006", d2 = {"calculateCellsCrossAxisSizeImpl", "", "gridSize", "", "slotCount", "spacing", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridCellsKt {
    public static final int[] access$calculateCellsCrossAxisSizeImpl(int gridSize, int slotCount, int spacing) {
        return LazyStaggeredGridCellsKt.calculateCellsCrossAxisSizeImpl(gridSize, slotCount, spacing);
    }

    private static final int[] calculateCellsCrossAxisSizeImpl(int gridSize, int slotCount, int spacing) {
        int i;
        int i3;
        int i2;
        int i6 = gridSize - i5;
        final int i7 = i6 / slotCount;
        final int[] iArr = new int[slotCount];
        final int i9 = 0;
        i = i9;
        while (i < slotCount) {
            if (i7 < 0) {
            } else {
            }
            if (i < i6 % slotCount) {
            } else {
            }
            i2 = i9;
            i2 += i7;
            iArr[i] = i3;
            i++;
            i2 = 1;
            i3 = i9;
        }
        return iArr;
    }
}
