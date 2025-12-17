package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u000b\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0013", d2 = {"Landroidx/compose/material/TabPosition;", "", "left", "Landroidx/compose/ui/unit/Dp;", "width", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM", "()F", "F", "right", "getRight-D9Ej5fM", "getWidth-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabPosition {

    public static final int $stable;
    private final float left;
    private final float width;
    static {
    }

    private TabPosition(float left, float width) {
        super();
        this.left = left;
        this.width = width;
    }

    public TabPosition(float f, float f2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(f, f2);
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof TabPosition) {
            return i2;
        }
        if (!Dp.equals-impl0(this.left, obj.left)) {
            return i2;
        }
        if (!Dp.equals-impl0(this.width, obj2.width)) {
            return i2;
        }
        return i;
    }

    public final float getLeft-D9Ej5fM() {
        return this.left;
    }

    public final float getRight-D9Ej5fM() {
        final int i = 0;
        return Dp.constructor-impl(left + width);
    }

    public final float getWidth-D9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TabPosition(left=").append(Dp.toString-impl(this.left)).append(", right=").append(Dp.toString-impl(getRight-D9Ej5fM())).append(", width=").append(Dp.toString-impl(this.width)).append(')').toString();
    }
}
