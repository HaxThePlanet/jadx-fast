package androidx.compose.material.ripple;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u0014", d2 = {"Landroidx/compose/material/ripple/RippleAlpha;", "", "draggedAlpha", "", "focusedAlpha", "hoveredAlpha", "pressedAlpha", "(FFFF)V", "getDraggedAlpha", "()F", "getFocusedAlpha", "getHoveredAlpha", "getPressedAlpha", "equals", "", "other", "hashCode", "", "toString", "", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RippleAlpha {

    public static final int $stable;
    private final float draggedAlpha;
    private final float focusedAlpha;
    private final float hoveredAlpha;
    private final float pressedAlpha;
    static {
    }

    public RippleAlpha(float draggedAlpha, float focusedAlpha, float hoveredAlpha, float pressedAlpha) {
        super();
        this.draggedAlpha = draggedAlpha;
        this.focusedAlpha = focusedAlpha;
        this.hoveredAlpha = hoveredAlpha;
        this.pressedAlpha = pressedAlpha;
    }

    public boolean equals(Object other) {
        int i;
        int i2;
        int i3;
        int i4;
        final int i5 = 1;
        if (this == other) {
            return i5;
        }
        final int i6 = 0;
        if (!other instanceof RippleAlpha) {
            return i6;
        }
        i = Float.compare(draggedAlpha, draggedAlpha2) == 0 ? i5 : i6;
        if (i == 0) {
            return i6;
        }
        i2 = Float.compare(focusedAlpha, focusedAlpha2) == 0 ? i5 : i6;
        if (i2 == 0) {
            return i6;
        }
        i3 = Float.compare(hoveredAlpha, hoveredAlpha2) == 0 ? i5 : i6;
        if (i3 == 0) {
            return i6;
        }
        i4 = Float.compare(pressedAlpha, pressedAlpha2) == 0 ? i5 : i6;
        if (i4 == 0) {
            return i6;
        }
        return i5;
    }

    public final float getDraggedAlpha() {
        return this.draggedAlpha;
    }

    public final float getFocusedAlpha() {
        return this.focusedAlpha;
    }

    public final float getHoveredAlpha() {
        return this.hoveredAlpha;
    }

    public final float getPressedAlpha() {
        return this.pressedAlpha;
    }

    public int hashCode() {
        return result2 += i8;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("RippleAlpha(draggedAlpha=").append(this.draggedAlpha).append(", focusedAlpha=").append(this.focusedAlpha).append(", hoveredAlpha=").append(this.hoveredAlpha).append(", pressedAlpha=").append(this.pressedAlpha).append(')').toString();
    }
}
