package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008g\u0018\u00002\u00020\u0001:\u0003\u0008\t\nJ\"\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells;", "", "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "Adaptive", "Fixed", "FixedSize", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface GridCells {

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$Adaptive;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "minSize", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", "", "other", "", "hashCode", "", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Adaptive implements androidx.compose.foundation.lazy.grid.GridCells {

        public static final int $stable;
        private final float minSize;
        static {
        }

        private Adaptive(float minSize) {
            int i;
            super();
            this.minSize = minSize;
            int i4 = 0;
            i = Dp.compareTo-0680j_4(this.minSize, Dp.constructor-impl((float)i3)) > 0 ? 1 : 0;
            if (i == 0) {
            } else {
            }
            int i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Provided min size ").append(Dp.toString-impl(this.minSize)).append(" should be larger than zero.").toString().toString());
            throw illegalArgumentException;
        }

        public Adaptive(float f, DefaultConstructorMarker defaultConstructorMarker2) {
            super(f);
        }

        public List<Integer> calculateCrossAxisCellSizes(Density $this$calculateCrossAxisCellSizes, int availableSize, int spacing) {
            return LazyGridDslKt.access$calculateCellsCrossAxisSizeImpl(availableSize, Math.max(i /= i4, 1), spacing);
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public boolean equals(Object other) {
            boolean equals-impl0;
            int i;
            float minSize;
            if (other instanceof GridCells.Adaptive && Dp.equals-impl0(this.minSize, obj.minSize)) {
                i = Dp.equals-impl0(this.minSize, obj.minSize) ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public int hashCode() {
            return Dp.hashCode-impl(this.minSize);
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\u0003H\u0016J\"\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$Fixed;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "count", "", "(I)V", "equals", "", "other", "", "hashCode", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Fixed implements androidx.compose.foundation.lazy.grid.GridCells {

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
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Provided count ").append(this.count).append(" should be larger than zero").toString().toString());
            throw illegalArgumentException;
        }

        public List<Integer> calculateCrossAxisCellSizes(Density $this$calculateCrossAxisCellSizes, int availableSize, int spacing) {
            return LazyGridDslKt.access$calculateCellsCrossAxisSizeImpl(availableSize, this.count, spacing);
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public boolean equals(Object other) {
            boolean count;
            int i;
            int count2;
            if (other instanceof GridCells.Fixed && this.count == obj.count) {
                i = this.count == obj.count ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public int hashCode() {
            return -count;
        }
    }

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$FixedSize;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "size", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", "", "other", "", "hashCode", "", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FixedSize implements androidx.compose.foundation.lazy.grid.GridCells {

        public static final int $stable;
        private final float size;
        static {
        }

        private FixedSize(float size) {
            int i;
            super();
            this.size = size;
            int i4 = 0;
            i = Dp.compareTo-0680j_4(this.size, Dp.constructor-impl((float)i3)) > 0 ? 1 : 0;
            if (i == 0) {
            } else {
            }
            int i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Provided size ").append(Dp.toString-impl(this.size)).append(" should be larger than zero.").toString().toString());
            throw illegalArgumentException;
        }

        public FixedSize(float f, DefaultConstructorMarker defaultConstructorMarker2) {
            super(f);
        }

        public List<Integer> calculateCrossAxisCellSizes(Density $this$calculateCrossAxisCellSizes, int availableSize, int spacing) {
            ArrayList arrayList;
            ArrayList arrayList2;
            int i;
            Integer valueOf;
            int i2;
            int roundToPx-0680j_4 = $this$calculateCrossAxisCellSizes.roundToPx-0680j_4(this.size);
            i = 0;
            if (roundToPx-0680j_4 + spacing < availableSize + spacing) {
                i4 /= i7;
                arrayList2 = new ArrayList(arrayList);
                while (i < arrayList) {
                    int i9 = i;
                    i2 = 0;
                    arrayList2.add(Integer.valueOf(roundToPx-0680j_4));
                    i++;
                }
            } else {
                int i6 = 1;
                arrayList = new ArrayList(i6);
                while (i < i6) {
                    int i8 = i;
                    i2 = 0;
                    arrayList.add(Integer.valueOf(availableSize));
                    i++;
                }
                arrayList2 = arrayList;
            }
            return arrayList2;
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public boolean equals(Object other) {
            boolean equals-impl0;
            int i;
            float size;
            if (other instanceof GridCells.FixedSize && Dp.equals-impl0(this.size, obj.size)) {
                i = Dp.equals-impl0(this.size, obj.size) ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public int hashCode() {
            return Dp.hashCode-impl(this.size);
        }
    }
    public abstract List<Integer> calculateCrossAxisCellSizes(Density density, int i2, int i3);
}
