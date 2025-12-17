package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/BorderStroke;", "", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "(FLandroidx/compose/ui/graphics/Brush;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getWidth-D9Ej5fM", "()F", "F", "copy", "copy-D5KLDUw", "(FLandroidx/compose/ui/graphics/Brush;)Landroidx/compose/foundation/BorderStroke;", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BorderStroke {

    public static final int $stable;
    private final Brush brush;
    private final float width;
    static {
    }

    private BorderStroke(float width, Brush brush) {
        super();
        this.width = width;
        this.brush = brush;
    }

    public BorderStroke(float f, Brush brush2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(f, brush2);
    }

    public static androidx.compose.foundation.BorderStroke copy-D5KLDUw$default(androidx.compose.foundation.BorderStroke borderStroke, float f2, Brush brush3, int i4, Object object5) {
        float obj1;
        Brush obj2;
        if (i4 & 1 != 0) {
            obj1 = borderStroke.width;
        }
        if (i4 &= 2 != 0) {
            obj2 = borderStroke.brush;
        }
        return borderStroke.copy-D5KLDUw(obj1, obj2);
    }

    public final androidx.compose.foundation.BorderStroke copy-D5KLDUw(float width, Brush brush) {
        BorderStroke borderStroke = new BorderStroke(width, brush, 0);
        return borderStroke;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof BorderStroke) {
            return i2;
        }
        if (!Dp.equals-impl0(this.width, obj.width)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.brush, obj2.brush)) {
            return i2;
        }
        return i;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final float getWidth-D9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BorderStroke(width=").append(Dp.toString-impl(this.width)).append(", brush=").append(this.brush).append(')').toString();
    }
}
