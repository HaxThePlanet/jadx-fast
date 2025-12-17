package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.DegreesKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0003H\u0086\u0008\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003H\u0086\u0008\u001a)\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u001a)\u0010\u000c\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"inset", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "", "horizontal", "vertical", "rotateRad", "radians", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotateRad-0AR0LA0", "(Landroidx/compose/ui/graphics/drawscope/DrawTransform;FJ)V", "scale", "scale-0AR0LA0", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DrawTransformKt {
    public static final void inset(androidx.compose.ui.graphics.drawscope.DrawTransform $this$inset, float inset) {
        final int i = 0;
        final int i2 = 0;
        $this$inset.inset(inset, inset, inset, inset);
    }

    public static final void inset(androidx.compose.ui.graphics.drawscope.DrawTransform $this$inset, float horizontal, float vertical) {
        final int i = 0;
        $this$inset.inset(horizontal, vertical, horizontal, vertical);
    }

    public static void inset$default(androidx.compose.ui.graphics.drawscope.DrawTransform $this$inset_u24default, float horizontal, float vertical, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        int obj3 = 0;
        $this$inset_u24default.inset(obj1, obj2, obj1, obj2);
    }

    public static final void rotateRad-0AR0LA0(androidx.compose.ui.graphics.drawscope.DrawTransform $this$rotateRad_u2d0AR0LA0, float radians, long pivot) {
        final int i = 0;
        $this$rotateRad_u2d0AR0LA0.rotate-Uv8p0NA(DegreesKt.degrees(radians), pivot);
    }

    public static void rotateRad-0AR0LA0$default(androidx.compose.ui.graphics.drawscope.DrawTransform $this$rotateRad_u2d0AR0LA0_u24default, float radians, long pivot, int i4, Object object5) {
        long obj2;
        if (object5 &= 2 != 0) {
            obj2 = $this$rotateRad_u2d0AR0LA0_u24default.getCenter-F1C5BW0();
        }
        int obj4 = 0;
        $this$rotateRad_u2d0AR0LA0_u24default.rotate-Uv8p0NA(DegreesKt.degrees(radians), obj2);
    }

    public static final void scale-0AR0LA0(androidx.compose.ui.graphics.drawscope.DrawTransform $this$scale_u2d0AR0LA0, float scale, long pivot) {
        final int i = 0;
        $this$scale_u2d0AR0LA0.scale-0AR0LA0(scale, scale, pivot);
    }

    public static void scale-0AR0LA0$default(androidx.compose.ui.graphics.drawscope.DrawTransform $this$scale_u2d0AR0LA0_u24default, float scale, long pivot, int i4, Object object5) {
        long obj2;
        if (object5 &= 2 != 0) {
            obj2 = $this$scale_u2d0AR0LA0_u24default.getCenter-F1C5BW0();
        }
        int obj4 = 0;
        $this$scale_u2d0AR0LA0_u24default.scale-0AR0LA0(scale, scale, obj2);
    }
}
