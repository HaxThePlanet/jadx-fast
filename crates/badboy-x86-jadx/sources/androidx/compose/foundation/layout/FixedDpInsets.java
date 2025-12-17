package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0096\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0016\u001a\u00020\u000eH\u0016J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/layout/FixedDpInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "leftDp", "Landroidx/compose/ui/unit/Dp;", "topDp", "rightDp", "bottomDp", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FixedDpInsets implements androidx.compose.foundation.layout.WindowInsets {

    private final float bottomDp;
    private final float leftDp;
    private final float rightDp;
    private final float topDp;
    private FixedDpInsets(float leftDp, float topDp, float rightDp, float bottomDp) {
        super();
        this.leftDp = leftDp;
        this.topDp = topDp;
        this.rightDp = rightDp;
        this.bottomDp = bottomDp;
    }

    public FixedDpInsets(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(f, f2, f3, f4);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public boolean equals(Object other) {
        int i;
        boolean equals-impl0;
        float bottomDp;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof FixedDpInsets) {
            return i2;
        }
        if (Dp.equals-impl0(this.leftDp, obj.leftDp) && Dp.equals-impl0(this.topDp, obj2.topDp) && Dp.equals-impl0(this.rightDp, obj3.rightDp) && Dp.equals-impl0(this.bottomDp, obj4.bottomDp)) {
            if (Dp.equals-impl0(this.topDp, obj2.topDp)) {
                if (Dp.equals-impl0(this.rightDp, obj3.rightDp)) {
                    if (Dp.equals-impl0(this.bottomDp, obj4.bottomDp)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        final int i = 0;
        return density.roundToPx-0680j_4(this.bottomDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        final int i = 0;
        return density.roundToPx-0680j_4(this.leftDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        final int i = 0;
        return density.roundToPx-0680j_4(this.rightDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        final int i = 0;
        return density.roundToPx-0680j_4(this.topDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int hashCode() {
        return result2 += i8;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Insets(left=").append(Dp.toString-impl(this.leftDp)).append(", top=").append(Dp.toString-impl(this.topDp)).append(", right=").append(Dp.toString-impl(this.rightDp)).append(", bottom=").append(Dp.toString-impl(this.bottomDp)).append(')').toString();
    }
}
