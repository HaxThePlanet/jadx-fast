package androidx.compose.ui;

import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001f", d2 = {"Landroidx/compose/ui/BiasAlignment;", "Landroidx/compose/ui/Alignment;", "horizontalBias", "", "verticalBias", "(FF)V", "getHorizontalBias", "()F", "getVerticalBias", "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Horizontal", "Vertical", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BiasAlignment implements androidx.compose.ui.Alignment {

    public static final int $stable;
    private final float horizontalBias;
    private final float verticalBias;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0008HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0016", d2 = {"Landroidx/compose/ui/BiasAlignment$Horizontal;", "Landroidx/compose/ui/Alignment$Horizontal;", "bias", "", "(F)V", "getBias", "()F", "align", "", "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Horizontal implements androidx.compose.ui.Alignment.Horizontal {

        public static final int $stable;
        private final float bias;
        static {
        }

        public Horizontal(float bias) {
            super();
            this.bias = bias;
        }

        public static androidx.compose.ui.BiasAlignment.Horizontal copy$default(androidx.compose.ui.BiasAlignment.Horizontal biasAlignment$Horizontal, float f2, int i3, Object object4) {
            float obj1;
            if (i3 &= 1 != 0) {
                obj1 = horizontal.bias;
            }
            return horizontal.copy(obj1);
        }

        @Override // androidx.compose.ui.Alignment$Horizontal
        public int align(int size, int space, LayoutDirection layoutDirection) {
            float bias;
            float bias2;
            if (layoutDirection == LayoutDirection.Ltr) {
                bias = this.bias;
            } else {
                f2 *= bias2;
            }
            final int i8 = 0;
            return Math.round(i6 *= i2);
        }

        @Override // androidx.compose.ui.Alignment$Horizontal
        public final float component1() {
            return this.bias;
        }

        @Override // androidx.compose.ui.Alignment$Horizontal
        public final androidx.compose.ui.BiasAlignment.Horizontal copy(float f) {
            BiasAlignment.Horizontal horizontal = new BiasAlignment.Horizontal(f);
            return horizontal;
        }

        @Override // androidx.compose.ui.Alignment$Horizontal
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof BiasAlignment.Horizontal) {
                return i2;
            }
            if (Float.compare(this.bias, obj.bias) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.Alignment$Horizontal
        public final float getBias() {
            return this.bias;
        }

        @Override // androidx.compose.ui.Alignment$Horizontal
        public int hashCode() {
            return Float.hashCode(this.bias);
        }

        @Override // androidx.compose.ui.Alignment$Horizontal
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Horizontal(bias=").append(this.bias).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u0008H\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0008HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0014", d2 = {"Landroidx/compose/ui/BiasAlignment$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "bias", "", "(F)V", "getBias", "()F", "align", "", "size", "space", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Vertical implements androidx.compose.ui.Alignment.Vertical {

        public static final int $stable;
        private final float bias;
        static {
        }

        public Vertical(float bias) {
            super();
            this.bias = bias;
        }

        public static androidx.compose.ui.BiasAlignment.Vertical copy$default(androidx.compose.ui.BiasAlignment.Vertical biasAlignment$Vertical, float f2, int i3, Object object4) {
            float obj1;
            if (i3 &= 1 != 0) {
                obj1 = vertical.bias;
            }
            return vertical.copy(obj1);
        }

        @Override // androidx.compose.ui.Alignment$Vertical
        public int align(int size, int space) {
            int i7 = 0;
            return Math.round(i5 *= i2);
        }

        @Override // androidx.compose.ui.Alignment$Vertical
        public final float component1() {
            return this.bias;
        }

        @Override // androidx.compose.ui.Alignment$Vertical
        public final androidx.compose.ui.BiasAlignment.Vertical copy(float f) {
            BiasAlignment.Vertical vertical = new BiasAlignment.Vertical(f);
            return vertical;
        }

        @Override // androidx.compose.ui.Alignment$Vertical
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof BiasAlignment.Vertical) {
                return i2;
            }
            if (Float.compare(this.bias, obj.bias) != 0) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.Alignment$Vertical
        public final float getBias() {
            return this.bias;
        }

        @Override // androidx.compose.ui.Alignment$Vertical
        public int hashCode() {
            return Float.hashCode(this.bias);
        }

        @Override // androidx.compose.ui.Alignment$Vertical
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Vertical(bias=").append(this.bias).append(')').toString();
        }
    }
    static {
    }

    public BiasAlignment(float horizontalBias, float verticalBias) {
        super();
        this.horizontalBias = horizontalBias;
        this.verticalBias = verticalBias;
    }

    public static androidx.compose.ui.BiasAlignment copy$default(androidx.compose.ui.BiasAlignment biasAlignment, float f2, float f3, int i4, Object object5) {
        float obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = biasAlignment.horizontalBias;
        }
        if (i4 &= 2 != 0) {
            obj2 = biasAlignment.verticalBias;
        }
        return biasAlignment.copy(obj1, obj2);
    }

    @Override // androidx.compose.ui.Alignment
    public long align-KFBX0sM(long size, long space, LayoutDirection layoutDirection) {
        float horizontalBias;
        int horizontalBias2;
        int i3 = 1073741824;
        if (obj13 == LayoutDirection.Ltr) {
            horizontalBias = this.horizontalBias;
        } else {
            f2 *= horizontalBias2;
        }
        float f4 = (float)i7;
        int i13 = 0;
        final int i14 = 0;
        return IntOffsetKt.IntOffset(Math.round(i10 *= i2), Math.round(i8 *= i6));
    }

    @Override // androidx.compose.ui.Alignment
    public final float component1() {
        return this.horizontalBias;
    }

    @Override // androidx.compose.ui.Alignment
    public final float component2() {
        return this.verticalBias;
    }

    @Override // androidx.compose.ui.Alignment
    public final androidx.compose.ui.BiasAlignment copy(float f, float f2) {
        BiasAlignment biasAlignment = new BiasAlignment(f, f2);
        return biasAlignment;
    }

    @Override // androidx.compose.ui.Alignment
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof BiasAlignment) {
            return i2;
        }
        Object obj = object;
        if (Float.compare(this.horizontalBias, obj.horizontalBias) != 0) {
            return i2;
        }
        if (Float.compare(this.verticalBias, obj.verticalBias) != 0) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.Alignment
    public final float getHorizontalBias() {
        return this.horizontalBias;
    }

    @Override // androidx.compose.ui.Alignment
    public final float getVerticalBias() {
        return this.verticalBias;
    }

    @Override // androidx.compose.ui.Alignment
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.Alignment
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BiasAlignment(horizontalBias=").append(this.horizontalBias).append(", verticalBias=").append(this.verticalBias).append(')').toString();
    }
}
