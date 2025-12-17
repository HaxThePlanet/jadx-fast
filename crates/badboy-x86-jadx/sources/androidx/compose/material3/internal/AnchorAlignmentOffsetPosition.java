package androidx.compose.material3.internal;

import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\u0008Á\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005", d2 = {"Landroidx/compose/material3/internal/AnchorAlignmentOffsetPosition;", "", "()V", "Horizontal", "Vertical", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnchorAlignmentOffsetPosition {

    public static final int $stable;
    public static final androidx.compose.material3.internal.AnchorAlignmentOffsetPosition INSTANCE;

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0008\u001a\u00020\u0003HÂ\u0003J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0006HÂ\u0003J'\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÖ\u0001J2\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"Landroidx/compose/material3/internal/AnchorAlignmentOffsetPosition$Horizontal;", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "menuAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "anchorAlignment", "offset", "", "(Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Horizontal implements androidx.compose.material3.internal.MenuPosition.Horizontal {

        public static final int $stable;
        private final Alignment.Horizontal anchorAlignment;
        private final Alignment.Horizontal menuAlignment;
        private final int offset;
        static {
        }

        public Horizontal(Alignment.Horizontal menuAlignment, Alignment.Horizontal anchorAlignment, int offset) {
            super();
            this.menuAlignment = menuAlignment;
            this.anchorAlignment = anchorAlignment;
            this.offset = offset;
        }

        private final Alignment.Horizontal component1() {
            return this.menuAlignment;
        }

        private final Alignment.Horizontal component2() {
            return this.anchorAlignment;
        }

        private final int component3() {
            return this.offset;
        }

        public static androidx.compose.material3.internal.AnchorAlignmentOffsetPosition.Horizontal copy$default(androidx.compose.material3.internal.AnchorAlignmentOffsetPosition.Horizontal anchorAlignmentOffsetPosition$Horizontal, Alignment.Horizontal alignment$Horizontal2, Alignment.Horizontal alignment$Horizontal3, int i4, int i5, Object object6) {
            Alignment.Horizontal obj1;
            Alignment.Horizontal obj2;
            int obj3;
            if (i5 & 1 != 0) {
                obj1 = horizontal.menuAlignment;
            }
            if (i5 & 2 != 0) {
                obj2 = horizontal.anchorAlignment;
            }
            if (i5 &= 4 != 0) {
                obj3 = horizontal.offset;
            }
            return horizontal.copy(obj1, obj2, obj3);
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
        public final androidx.compose.material3.internal.AnchorAlignmentOffsetPosition.Horizontal copy(Alignment.Horizontal alignment$Horizontal, Alignment.Horizontal alignment$Horizontal2, int i3) {
            AnchorAlignmentOffsetPosition.Horizontal horizontal3 = new AnchorAlignmentOffsetPosition.Horizontal(horizontal, horizontal2, i3);
            return horizontal3;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof AnchorAlignmentOffsetPosition.Horizontal) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.menuAlignment, obj.menuAlignment)) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.anchorAlignment, obj.anchorAlignment)) {
                return i2;
            }
            if (this.offset != obj.offset) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
        public int hashCode() {
            return i2 += i7;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
        public int position-95KtPRI(IntRect anchorBounds, long windowSize, int menuWidth, LayoutDirection layoutDirection) {
            int offset;
            int i2 = 0;
            offset = obj9 == LayoutDirection.Ltr ? this.offset : -offset2;
            return i4 += offset;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Horizontal
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Horizontal(menuAlignment=").append(this.menuAlignment).append(", anchorAlignment=").append(this.anchorAlignment).append(", offset=").append(this.offset).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0008\u001a\u00020\u0003HÂ\u0003J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0006HÂ\u0003J'\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÖ\u0001J*\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/material3/internal/AnchorAlignmentOffsetPosition$Vertical;", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "menuAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "anchorAlignment", "offset", "", "(Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Vertical;I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Vertical implements androidx.compose.material3.internal.MenuPosition.Vertical {

        public static final int $stable;
        private final Alignment.Vertical anchorAlignment;
        private final Alignment.Vertical menuAlignment;
        private final int offset;
        static {
        }

        public Vertical(Alignment.Vertical menuAlignment, Alignment.Vertical anchorAlignment, int offset) {
            super();
            this.menuAlignment = menuAlignment;
            this.anchorAlignment = anchorAlignment;
            this.offset = offset;
        }

        private final Alignment.Vertical component1() {
            return this.menuAlignment;
        }

        private final Alignment.Vertical component2() {
            return this.anchorAlignment;
        }

        private final int component3() {
            return this.offset;
        }

        public static androidx.compose.material3.internal.AnchorAlignmentOffsetPosition.Vertical copy$default(androidx.compose.material3.internal.AnchorAlignmentOffsetPosition.Vertical anchorAlignmentOffsetPosition$Vertical, Alignment.Vertical alignment$Vertical2, Alignment.Vertical alignment$Vertical3, int i4, int i5, Object object6) {
            Alignment.Vertical obj1;
            Alignment.Vertical obj2;
            int obj3;
            if (i5 & 1 != 0) {
                obj1 = vertical.menuAlignment;
            }
            if (i5 & 2 != 0) {
                obj2 = vertical.anchorAlignment;
            }
            if (i5 &= 4 != 0) {
                obj3 = vertical.offset;
            }
            return vertical.copy(obj1, obj2, obj3);
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Vertical
        public final androidx.compose.material3.internal.AnchorAlignmentOffsetPosition.Vertical copy(Alignment.Vertical alignment$Vertical, Alignment.Vertical alignment$Vertical2, int i3) {
            AnchorAlignmentOffsetPosition.Vertical vertical3 = new AnchorAlignmentOffsetPosition.Vertical(vertical, vertical2, i3);
            return vertical3;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Vertical
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof AnchorAlignmentOffsetPosition.Vertical) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.menuAlignment, obj.menuAlignment)) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.anchorAlignment, obj.anchorAlignment)) {
                return i2;
            }
            if (this.offset != obj.offset) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Vertical
        public int hashCode() {
            return i2 += i7;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Vertical
        public int position-JVtK1S4(IntRect anchorBounds, long windowSize, int menuHeight) {
            int i2 = 0;
            return i4 += offset;
        }

        @Override // androidx.compose.material3.internal.MenuPosition$Vertical
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Vertical(menuAlignment=").append(this.menuAlignment).append(", anchorAlignment=").append(this.anchorAlignment).append(", offset=").append(this.offset).append(')').toString();
        }
    }
    static {
        AnchorAlignmentOffsetPosition anchorAlignmentOffsetPosition = new AnchorAlignmentOffsetPosition();
        AnchorAlignmentOffsetPosition.INSTANCE = anchorAlignmentOffsetPosition;
    }
}
