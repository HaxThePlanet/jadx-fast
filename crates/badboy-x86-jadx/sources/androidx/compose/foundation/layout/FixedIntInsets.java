package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u0014\u001a\u00020\u0003H\u0016J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/layout/FixedIntInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "leftVal", "", "topVal", "rightVal", "bottomVal", "(IIII)V", "equals", "", "other", "", "getBottom", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FixedIntInsets implements androidx.compose.foundation.layout.WindowInsets {

    private final int bottomVal;
    private final int leftVal;
    private final int rightVal;
    private final int topVal;
    public FixedIntInsets(int leftVal, int topVal, int rightVal, int bottomVal) {
        super();
        this.leftVal = leftVal;
        this.topVal = topVal;
        this.rightVal = rightVal;
        this.bottomVal = bottomVal;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public boolean equals(Object other) {
        int i;
        int bottomVal2;
        int bottomVal;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof FixedIntInsets) {
            return i2;
        }
        if (this.leftVal == obj.leftVal && this.topVal == obj2.topVal && this.rightVal == obj3.rightVal && this.bottomVal == obj4.bottomVal) {
            if (this.topVal == obj2.topVal) {
                if (this.rightVal == obj3.rightVal) {
                    if (this.bottomVal == obj4.bottomVal) {
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
        return this.bottomVal;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        return this.leftVal;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        return this.rightVal;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        return this.topVal;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int hashCode() {
        return result2 += bottomVal;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Insets(left=").append(this.leftVal).append(", top=").append(this.topVal).append(", right=").append(this.rightVal).append(", bottom=").append(this.bottomVal).append(')').toString();
    }
}
