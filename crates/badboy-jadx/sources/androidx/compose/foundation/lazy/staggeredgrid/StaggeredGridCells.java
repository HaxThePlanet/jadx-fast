package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008g\u0018\u00002\u00020\u0001:\u0003\u0008\t\nJ\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "", "spacing", "Adaptive", "Fixed", "FixedSize", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface StaggeredGridCells {

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u000c\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells$Adaptive;", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "minSize", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", "", "other", "", "hashCode", "", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Adaptive implements androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells {

        public static final int $stable;
        private final float minSize;
        static {
        }

        private Adaptive(float minSize) {
            int i;
            super();
            this.minSize = minSize;
            final int i4 = 0;
            i = Dp.compareTo-0680j_4(this.minSize, Dp.constructor-impl((float)i3)) > 0 ? 1 : 0;
            if (i == 0) {
            } else {
            }
            int i2 = 0;
            IllegalArgumentException $i$a$RequireStaggeredGridCells$Adaptive$1 = new IllegalArgumentException("invalid minSize".toString());
            throw $i$a$RequireStaggeredGridCells$Adaptive$1;
        }

        public Adaptive(float f, DefaultConstructorMarker defaultConstructorMarker2) {
            super(f);
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int[] calculateCrossAxisCellSizes(Density $this$calculateCrossAxisCellSizes, int availableSize, int spacing) {
            return LazyStaggeredGridCellsKt.access$calculateCellsCrossAxisSizeImpl(availableSize, Math.max(i /= i4, 1), spacing);
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public boolean equals(Object other) {
            boolean equals-impl0;
            int i;
            float minSize;
            if (other instanceof StaggeredGridCells.Adaptive && Dp.equals-impl0(this.minSize, obj.minSize)) {
                i = Dp.equals-impl0(this.minSize, obj.minSize) ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int hashCode() {
            return Dp.hashCode-impl(this.minSize);
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\u0003H\u0016J\u001c\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells$Fixed;", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "count", "", "(I)V", "equals", "", "other", "", "hashCode", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Fixed implements androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells {

        public static final int $stable;
        private final int count;
        static {
        }

        public Fixed(int count) {
            int i;
            super();
            this.count = count;
            i = this.count > 0 ? 1 : 0;
            if (i == 0) {
            } else {
            }
            int i2 = 0;
            IllegalArgumentException $i$a$RequireStaggeredGridCells$Fixed$1 = new IllegalArgumentException("grid with no rows/columns".toString());
            throw $i$a$RequireStaggeredGridCells$Fixed$1;
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int[] calculateCrossAxisCellSizes(Density $this$calculateCrossAxisCellSizes, int availableSize, int spacing) {
            return LazyStaggeredGridCellsKt.access$calculateCellsCrossAxisSizeImpl(availableSize, this.count, spacing);
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public boolean equals(Object other) {
            boolean count;
            int i;
            int count2;
            if (other instanceof StaggeredGridCells.Fixed && this.count == obj.count) {
                i = this.count == obj.count ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int hashCode() {
            return -count;
        }
    }

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u000c\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells$FixedSize;", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "size", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", "", "other", "", "hashCode", "", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FixedSize implements androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells {

        public static final int $stable;
        private final float size;
        static {
        }

        private FixedSize(float size) {
            super();
            this.size = size;
        }

        public FixedSize(float f, DefaultConstructorMarker defaultConstructorMarker2) {
            super(f);
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int[] calculateCrossAxisCellSizes(Density $this$calculateCrossAxisCellSizes, int availableSize, int spacing) {
            int i2;
            int[] iArr;
            int i;
            int roundToPx-0680j_4 = $this$calculateCrossAxisCellSizes.roundToPx-0680j_4(this.size);
            i = 0;
            if (roundToPx-0680j_4 + spacing < availableSize + spacing) {
                i4 /= i6;
                while (i < i2) {
                    new int[i2][i] = roundToPx-0680j_4;
                    i++;
                }
            } else {
                i2 = 1;
                while (i < i2) {
                    new int[i2][i] = availableSize;
                    i++;
                }
            }
            return iArr;
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public boolean equals(Object other) {
            boolean equals-impl0;
            int i;
            float size;
            if (other instanceof StaggeredGridCells.FixedSize && Dp.equals-impl0(this.size, obj.size)) {
                i = Dp.equals-impl0(this.size, obj.size) ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int hashCode() {
            return Dp.hashCode-impl(this.size);
        }
    }
    public abstract int[] calculateCrossAxisCellSizes(Density density, int i2, int i3);
}
