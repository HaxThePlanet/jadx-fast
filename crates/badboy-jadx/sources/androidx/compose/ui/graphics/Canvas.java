package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\u0008f\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\tJ$\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ<\u0010\n\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0008\u0010\u001b\u001a\u00020\u0003H&J0\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016JH\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J0\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J*\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J*\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\u00080\u00101JJ\u00102\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u0002062\u0008\u0008\u0002\u00107\u001a\u0002042\u0008\u0008\u0002\u00108\u001a\u0002062\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\u00089\u0010:J*\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J\u0018\u0010@\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010!\u001a\u00020\"H\u0016J0\u0010@\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&J\u0018\u0010A\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H&J0\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020D2\u000c\u0010E\u001a\u0008\u0012\u0004\u0012\u00020(0F2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\u0008G\u0010HJ*\u0010I\u001a\u00020\u00032\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020J2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJ\u0018\u0010M\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010!\u001a\u00020\"H\u0016J0\u0010M\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&J@\u0010N\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&J*\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\u0008V\u0010WJ\u0008\u0010X\u001a\u00020\u0003H&J\u0008\u0010Y\u001a\u00020\u0003H&J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0010H&J\u0008\u0010\\\u001a\u00020\u0003H&J\u0018\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u000c2\u0006\u0010!\u001a\u00020\"H&J\u001a\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00102\u0008\u0008\u0002\u0010a\u001a\u00020\u0010H&J\u0018\u0010b\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00102\u0006\u0010a\u001a\u00020\u0010H&J\u0018\u0010c\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u00102\u0006\u0010e\u001a\u00020\u0010H\u0016J\u0018\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u0010H&ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006iÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/Canvas;", "", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "clipRect-mtrdD-E", "(Landroidx/compose/ui/geometry/Rect;I)V", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawArcRad", "startAngleRad", "sweepAngleRad", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "scale", "sx", "sy", "skew", "skewRad", "sxRad", "syRad", "translate", "dx", "dy", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Canvas {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void clipPath-mtrdD-E$default(androidx.compose.ui.graphics.Canvas canvas, androidx.compose.ui.graphics.Path path2, int i3, int i4, Object object5) {
            Canvas.clipPath-mtrdD-E$default(canvas, path2, i3, i4, object5);
        }

        public static void clipRect-N_I0leg$default(androidx.compose.ui.graphics.Canvas canvas, float f2, float f3, float f4, float f5, int i6, int i7, Object object8) {
            Canvas.clipRect-N_I0leg$default(canvas, f2, f3, f4, f5, i6, i7, object8);
        }

        @Deprecated
        public static void clipRect-mtrdD-E(androidx.compose.ui.graphics.Canvas $this, Rect rect, int clipOp) {
            Canvas.access$clipRect-mtrdD-E$jd($this, rect, clipOp);
        }

        public static void clipRect-mtrdD-E$default(androidx.compose.ui.graphics.Canvas canvas, Rect rect2, int i3, int i4, Object object5) {
            Canvas.clipRect-mtrdD-E$default(canvas, rect2, i3, i4, object5);
        }

        @Deprecated
        public static void drawArc(androidx.compose.ui.graphics.Canvas $this, Rect rect, float startAngle, float sweepAngle, boolean useCenter, androidx.compose.ui.graphics.Paint paint) {
            Canvas.access$drawArc$jd($this, rect, startAngle, sweepAngle, useCenter, paint);
        }

        @Deprecated
        public static void drawArcRad(androidx.compose.ui.graphics.Canvas $this, Rect rect, float startAngleRad, float sweepAngleRad, boolean useCenter, androidx.compose.ui.graphics.Paint paint) {
            Canvas.access$drawArcRad$jd($this, rect, startAngleRad, sweepAngleRad, useCenter, paint);
        }

        public static void drawImageRect-HPBpro0$default(androidx.compose.ui.graphics.Canvas canvas, androidx.compose.ui.graphics.ImageBitmap imageBitmap2, long l3, long l4, long l5, long l6, androidx.compose.ui.graphics.Paint paint7, int i8, Object object9) {
            Canvas.drawImageRect-HPBpro0$default(canvas, imageBitmap2, l3, l4, l5, l6, paint7, i8, object9);
        }

        @Deprecated
        public static void drawOval(androidx.compose.ui.graphics.Canvas $this, Rect rect, androidx.compose.ui.graphics.Paint paint) {
            Canvas.access$drawOval$jd($this, rect, paint);
        }

        @Deprecated
        public static void drawRect(androidx.compose.ui.graphics.Canvas $this, Rect rect, androidx.compose.ui.graphics.Paint paint) {
            Canvas.access$drawRect$jd($this, rect, paint);
        }

        public static void scale$default(androidx.compose.ui.graphics.Canvas canvas, float f2, float f3, int i4, Object object5) {
            Canvas.scale$default(canvas, f2, f3, i4, object5);
        }

        @Deprecated
        public static void skewRad(androidx.compose.ui.graphics.Canvas $this, float sxRad, float syRad) {
            Canvas.access$skewRad$jd($this, sxRad, syRad);
        }
    }
    public static void access$clipRect-mtrdD-E$jd(androidx.compose.ui.graphics.Canvas $this, Rect rect, int clipOp) {
        super.clipRect-mtrdD-E(rect, clipOp);
    }

    public static void access$drawArc$jd(androidx.compose.ui.graphics.Canvas $this, Rect rect, float startAngle, float sweepAngle, boolean useCenter, androidx.compose.ui.graphics.Paint paint) {
        super.drawArc(rect, startAngle, sweepAngle, useCenter, paint);
    }

    public static void access$drawArcRad$jd(androidx.compose.ui.graphics.Canvas $this, Rect rect, float startAngleRad, float sweepAngleRad, boolean useCenter, androidx.compose.ui.graphics.Paint paint) {
        super.drawArcRad(rect, startAngleRad, sweepAngleRad, useCenter, paint);
    }

    public static void access$drawOval$jd(androidx.compose.ui.graphics.Canvas $this, Rect rect, androidx.compose.ui.graphics.Paint paint) {
        super.drawOval(rect, paint);
    }

    public static void access$drawRect$jd(androidx.compose.ui.graphics.Canvas $this, Rect rect, androidx.compose.ui.graphics.Paint paint) {
        super.drawRect(rect, paint);
    }

    public static void access$skewRad$jd(androidx.compose.ui.graphics.Canvas $this, float sxRad, float syRad) {
        super.skewRad(sxRad, syRad);
    }

    public static void clipPath-mtrdD-E$default(androidx.compose.ui.graphics.Canvas canvas, androidx.compose.ui.graphics.Path path2, int i3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = ClipOp.Companion.getIntersect-rtfAjoo();
            }
            canvas.clipPath-mtrdD-E(path2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        throw obj0;
    }

    public static void clipRect-N_I0leg$default(androidx.compose.ui.graphics.Canvas canvas, float f2, float f3, float f4, float f5, int i6, int i7, Object object8) {
        int i;
        int obj11;
        if (object8 != null) {
        } else {
            if (i7 &= 16 != 0) {
                i = obj11;
            } else {
                i = i6;
            }
            canvas.clipRect-N_I0leg(f2, f3, f4, f5, i);
        }
        UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        throw obj6;
    }

    public static void clipRect-mtrdD-E$default(androidx.compose.ui.graphics.Canvas canvas, Rect rect2, int i3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = ClipOp.Companion.getIntersect-rtfAjoo();
            }
            canvas.clipRect-mtrdD-E(rect2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        throw obj0;
    }

    public static void drawImageRect-HPBpro0$default(androidx.compose.ui.graphics.Canvas canvas, androidx.compose.ui.graphics.ImageBitmap imageBitmap2, long l3, long l4, long l5, long l6, androidx.compose.ui.graphics.Paint paint7, int i8, Object object9) {
        int zero-nOcc-ac2;
        int i;
        int zero-nOcc-ac;
        int height;
        long l;
        long l2;
        long l8;
        long l7;
        if (obj25 != null) {
        } else {
            if (obj24 & 2 != 0) {
                l = zero-nOcc-ac2;
            } else {
                l = l3;
            }
            if (obj24 & 4 != 0) {
                l2 = i;
            } else {
                l2 = l5;
            }
            if (obj24 & 8 != 0) {
                l8 = zero-nOcc-ac;
            } else {
                l8 = paint7;
            }
            l7 = obj24 & 16 != 0 ? l2 : object9;
            canvas.drawImageRect-HPBpro0(imageBitmap2, l, obj5, l2, obj7, l8);
        }
        UnsupportedOperationException obj13 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImageRect-HPBpro0");
        throw obj13;
    }

    public static void scale$default(androidx.compose.ui.graphics.Canvas canvas, float f2, float f3, int i4, Object object5) {
        float obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = f2;
            }
            canvas.scale(f2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale");
        throw obj0;
    }

    public abstract void clipPath-mtrdD-E(androidx.compose.ui.graphics.Path path, int i2);

    public abstract void clipRect-N_I0leg(float f, float f2, float f3, float f4, int i5);

    public void clipRect-mtrdD-E(Rect rect, int clipOp) {
        this.clipRect-N_I0leg(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), clipOp);
    }

    public abstract void concat-58bKbWc(float[] fArr);

    public abstract void disableZ();

    public abstract void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z7, androidx.compose.ui.graphics.Paint paint8);

    public void drawArc(Rect rect, float startAngle, float sweepAngle, boolean useCenter, androidx.compose.ui.graphics.Paint paint) {
        this.drawArc(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), startAngle, sweepAngle, useCenter, paint);
    }

    public void drawArcRad(Rect rect, float startAngleRad, float sweepAngleRad, boolean useCenter, androidx.compose.ui.graphics.Paint paint) {
        this.drawArc(rect, DegreesKt.degrees(startAngleRad), DegreesKt.degrees(sweepAngleRad), useCenter, paint);
    }

    public abstract void drawCircle-9KIMszo(long l, float f2, androidx.compose.ui.graphics.Paint paint3);

    public abstract void drawImage-d-4ec7I(androidx.compose.ui.graphics.ImageBitmap imageBitmap, long l2, androidx.compose.ui.graphics.Paint paint3);

    public abstract void drawImageRect-HPBpro0(androidx.compose.ui.graphics.ImageBitmap imageBitmap, long l2, long l3, long l4, long l5, androidx.compose.ui.graphics.Paint paint6);

    public abstract void drawLine-Wko1d7g(long l, long l2, androidx.compose.ui.graphics.Paint paint3);

    public abstract void drawOval(float f, float f2, float f3, float f4, androidx.compose.ui.graphics.Paint paint5);

    public void drawOval(Rect rect, androidx.compose.ui.graphics.Paint paint) {
        this.drawOval(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    public abstract void drawPath(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.Paint paint2);

    public abstract void drawPoints-O7TthRY(int i, List<Offset> list2, androidx.compose.ui.graphics.Paint paint3);

    public abstract void drawRawPoints-O7TthRY(int i, float[] f2Arr2, androidx.compose.ui.graphics.Paint paint3);

    public abstract void drawRect(float f, float f2, float f3, float f4, androidx.compose.ui.graphics.Paint paint5);

    public void drawRect(Rect rect, androidx.compose.ui.graphics.Paint paint) {
        this.drawRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    public abstract void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, androidx.compose.ui.graphics.Paint paint7);

    public abstract void drawVertices-TPEHhCM(androidx.compose.ui.graphics.Vertices vertices, int i2, androidx.compose.ui.graphics.Paint paint3);

    public abstract void enableZ();

    public abstract void restore();

    public abstract void rotate(float f);

    public abstract void save();

    public abstract void saveLayer(Rect rect, androidx.compose.ui.graphics.Paint paint2);

    public abstract void scale(float f, float f2);

    public abstract void skew(float f, float f2);

    public void skewRad(float sxRad, float syRad) {
        skew(DegreesKt.degrees(sxRad), DegreesKt.degrees(syRad));
    }

    public abstract void translate(float f, float f2);
}
