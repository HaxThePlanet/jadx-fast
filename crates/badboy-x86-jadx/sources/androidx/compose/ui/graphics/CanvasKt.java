package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\"\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u001a&\u0010\n\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\u0007\u001a,\u0010\u000c\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u001a\u001b\u0010\u000f\u001a\u00020\u0005*\u00020\u00012\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0011H\u0086\u0008\u001a+\u0010\u0012\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0011H\u0086\u0008¨\u0006\u0017", d2 = {"Canvas", "Landroidx/compose/ui/graphics/Canvas;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "rotate", "", "degrees", "", "pivotX", "pivotY", "rotateRad", "radians", "scale", "sx", "sy", "withSave", "block", "Lkotlin/Function0;", "withSaveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CanvasKt {
    public static final androidx.compose.ui.graphics.Canvas Canvas(androidx.compose.ui.graphics.ImageBitmap image) {
        return AndroidCanvas_androidKt.ActualCanvas(image);
    }

    public static final void rotate(androidx.compose.ui.graphics.Canvas $this$rotate, float degrees, float pivotX, float pivotY) {
        int i;
        i = Float.compare(degrees, i2) == 0 ? 1 : 0;
        if (i != 0) {
        }
        $this$rotate.translate(pivotX, pivotY);
        $this$rotate.rotate(degrees);
        $this$rotate.translate(-pivotX, -pivotY);
    }

    public static final void rotateRad(androidx.compose.ui.graphics.Canvas $this$rotateRad, float radians, float pivotX, float pivotY) {
        CanvasKt.rotate($this$rotateRad, DegreesKt.degrees(radians), pivotX, pivotY);
    }

    public static void rotateRad$default(androidx.compose.ui.graphics.Canvas canvas, float f2, float f3, float f4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        CanvasKt.rotateRad(canvas, f2, obj3, obj4);
    }

    public static final void scale(androidx.compose.ui.graphics.Canvas $this$scale, float sx, float sy, float pivotX, float pivotY) {
        int cmp;
        int i;
        int i2;
        cmp = 1065353216;
        final int i5 = 0;
        i = Float.compare(sx, cmp) == 0 ? i2 : i5;
        if (i != 0) {
            if (Float.compare(sy, cmp) == 0) {
            } else {
                i2 = i5;
            }
            if (i2 != 0) {
            }
        }
        $this$scale.translate(pivotX, pivotY);
        $this$scale.scale(sx, sy);
        $this$scale.translate(-pivotX, -pivotY);
    }

    public static void scale$default(androidx.compose.ui.graphics.Canvas canvas, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float obj2;
        if (i6 &= 2 != 0) {
            obj2 = f2;
        }
        CanvasKt.scale(canvas, f2, obj2, f4, f5);
    }

    public static final void withSave(androidx.compose.ui.graphics.Canvas $this$withSave, Function0<Unit> block) {
        final int i = 0;
        $this$withSave.save();
        block.invoke();
        $this$withSave.restore();
    }

    public static final void withSaveLayer(androidx.compose.ui.graphics.Canvas $this$withSaveLayer, Rect bounds, androidx.compose.ui.graphics.Paint paint, Function0<Unit> block) {
        final int i = 0;
        $this$withSaveLayer.saveLayer(bounds, paint);
        block.invoke();
        $this$withSaveLayer.restore();
    }
}
