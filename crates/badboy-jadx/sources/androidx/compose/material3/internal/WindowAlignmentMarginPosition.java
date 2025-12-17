package androidx.compose.material3.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\u0008Á\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005", d2 = {"Landroidx/compose/material3/internal/WindowAlignmentMarginPosition;", "", "()V", "Horizontal", "Vertical", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WindowAlignmentMarginPosition {

    public static final int $stable;
    public static final androidx.compose.material3.internal.WindowAlignmentMarginPosition INSTANCE;

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0008\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J2\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/material3/internal/WindowAlignmentMarginPosition$Horizontal;", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "margin", "", "(Landroidx/compose/ui/Alignment$Horizontal;I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Horizontal implements androidx.compose.material3.internal.MenuPosition.Horizontal {

        public static final int $stable;
        private final Alignment.Horizontal alignment;
        private final int margin;
        static {
        }

        public Horizontal(Alignment.Horizontal alignment, int margin) {
            super();
            this.alignment = alignment;
            this.margin = margin;
        }

        private final Alignment.Horizontal component1() {
            return this.alignment;
        }

        private final int component2() {
            return this.margin;
        }

        public static androidx.compose.material3.internal.WindowAlignmentMarginPosition.Horizontal copy$default(androidx.compose.material3.internal.WindowAlignmentMarginPosition.Horizontal windowAlignmentMarginPosition$Horizontal, Alignment.Horizontal alignment$Horizontal2, int i3, int i4, Object object5) {
            Alignment.Horizontal obj1;
            int obj2;
            if (i4 & 1 != 0) {
                obj1 = horizontal.alignment;
            }
            if (i4 &= 2 != 0) {
                obj2 = horizontal.margin;
            }
            return horizontal.copy(obj1, obj2);
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
        public final androidx.compose.material3.internal.WindowAlignmentMarginPosition.Horizontal copy(Alignment.Horizontal alignment$Horizontal, int i2) {
            WindowAlignmentMarginPosition.Horizontal horizontal2 = new WindowAlignmentMarginPosition.Horizontal(horizontal, i2);
            return horizontal2;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof WindowAlignmentMarginPosition.Horizontal) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.alignment, obj.alignment)) {
                return i2;
            }
            if (this.margin != obj.margin) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
        public int position-95KtPRI(IntRect anchorBounds, long windowSize, int menuWidth, LayoutDirection layoutDirection) {
            if (layoutDirection >= width-impl -= i2) {
                return Alignment.Companion.getCenterHorizontally().align(layoutDirection, IntSize.getWidth-impl(windowSize), obj9);
            }
            return RangesKt.coerceIn(this.alignment.align(layoutDirection, IntSize.getWidth-impl(windowSize), obj9), this.margin, i3 -= layoutDirection);
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Horizontal(alignment=").append(this.alignment).append(", margin=").append(this.margin).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0008\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J*\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"Landroidx/compose/material3/internal/WindowAlignmentMarginPosition$Vertical;", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "margin", "", "(Landroidx/compose/ui/Alignment$Vertical;I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Vertical implements androidx.compose.material3.internal.MenuPosition.Vertical {

        public static final int $stable;
        private final Alignment.Vertical alignment;
        private final int margin;
        static {
        }

        public Vertical(Alignment.Vertical alignment, int margin) {
            super();
            this.alignment = alignment;
            this.margin = margin;
        }

        private final Alignment.Vertical component1() {
            return this.alignment;
        }

        private final int component2() {
            return this.margin;
        }

        public static androidx.compose.material3.internal.WindowAlignmentMarginPosition.Vertical copy$default(androidx.compose.material3.internal.WindowAlignmentMarginPosition.Vertical windowAlignmentMarginPosition$Vertical, Alignment.Vertical alignment$Vertical2, int i3, int i4, Object object5) {
            Alignment.Vertical obj1;
            int obj2;
            if (i4 & 1 != 0) {
                obj1 = vertical.alignment;
            }
            if (i4 &= 2 != 0) {
                obj2 = vertical.margin;
            }
            return vertical.copy(obj1, obj2);
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Vertical
        public final androidx.compose.material3.internal.WindowAlignmentMarginPosition.Vertical copy(Alignment.Vertical alignment$Vertical, int i2) {
            WindowAlignmentMarginPosition.Vertical vertical2 = new WindowAlignmentMarginPosition.Vertical(vertical, i2);
            return vertical2;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Vertical
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof WindowAlignmentMarginPosition.Vertical) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.alignment, obj.alignment)) {
                return i2;
            }
            if (this.margin != obj.margin) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Vertical
        public int hashCode() {
            return i2 += i4;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Vertical
        public int position-JVtK1S4(IntRect anchorBounds, long windowSize, int menuHeight) {
            if (obj8 >= height-impl -= i2) {
                return Alignment.Companion.getCenterVertically().align(obj8, IntSize.getHeight-impl(windowSize));
            }
            return RangesKt.coerceIn(this.alignment.align(obj8, IntSize.getHeight-impl(windowSize)), this.margin, i3 -= obj8);
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Vertical
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Vertical(alignment=").append(this.alignment).append(", margin=").append(this.margin).append(')').toString();
        }
    }
    static {
        WindowAlignmentMarginPosition windowAlignmentMarginPosition = new WindowAlignmentMarginPosition();
        WindowAlignmentMarginPosition.INSTANCE = windowAlignmentMarginPosition;
    }
}
