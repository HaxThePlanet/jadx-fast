package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Region.Op;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J:\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"J\u0008\u0010#\u001a\u00020\u000fH\u0016JH\u0010$\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J*\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\u0008/\u00100J*\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\u00085\u00106JB\u00107\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020;2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J*\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\u0008C\u0010DJ&\u0010E\u001a\u00020\u000f2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J0\u0010J\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010K\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0016J0\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\u0008O\u0010PJ\u001e\u0010L\u001a\u00020\u000f2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*H\u0002J \u0010Q\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J*\u0010S\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\u0008T\u0010UJ \u0010S\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J0\u0010V\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J@\u0010W\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J*\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\u0008_\u0010`J\u0008\u0010a\u001a\u00020\u000fH\u0016J\u0008\u0010b\u001a\u00020\u000fH\u0016J\u0010\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u0018H\u0016J\u0008\u0010e\u001a\u00020\u000fH\u0016J\u0018\u0010f\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020h2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u0018H\u0016J\u0018\u0010l\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u0018H\u0016J\u0018\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u00182\u0006\u0010o\u001a\u00020\u0018H\u0016J\u0014\u0010p\u001a\u00020q*\u00020\u0013ø\u0001\u0000¢\u0006\u0004\u0008r\u0010sR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u00060\u0006j\u0002`\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0008\u0010\u0002\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006t", d2 = {"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "()V", "dstRect", "Landroid/graphics/Rect;", "internalCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawLines", "points", "", "stepBy", "", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "", "drawRawPoints", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "scale", "sx", "sy", "skew", "translate", "dx", "dy", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidCanvas implements androidx.compose.ui.graphics.Canvas {

    private Rect dstRect;
    private Canvas internalCanvas;
    private Rect srcRect;
    public AndroidCanvas() {
        super();
        this.internalCanvas = AndroidCanvas_androidKt.access$getEmptyCanvas$p();
    }

    private final void drawLines(List<Offset> points, androidx.compose.ui.graphics.Paint paint, int stepBy) {
        int i;
        int i2;
        Canvas internalCanvas;
        float x-impl2;
        float y-impl2;
        float x-impl;
        float y-impl;
        android.graphics.Paint frameworkPaint;
        long unbox-impl;
        long unbox-impl2;
        if (points.size() >= 2) {
            i = 0;
            while (i < size--) {
                unbox-impl = (Offset)points.get(i).unbox-impl();
                unbox-impl2 = (Offset)points.get(i + 1).unbox-impl();
                this.internalCanvas.drawLine(Offset.getX-impl(unbox-impl), Offset.getY-impl(unbox-impl), Offset.getX-impl(unbox-impl2), Offset.getY-impl(unbox-impl2), paint.asFrameworkPaint());
                i += stepBy;
            }
        }
    }

    private final void drawPoints(List<Offset> points, androidx.compose.ui.graphics.Paint paint) {
        int index$iv;
        Object obj;
        long unbox-impl;
        int i;
        Canvas internalCanvas;
        float x-impl;
        float y-impl;
        android.graphics.Paint frameworkPaint;
        final Object obj2 = points;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < obj2.size()) {
            unbox-impl = (Offset)obj2.get(index$iv).unbox-impl();
            i = 0;
            this.internalCanvas.drawPoint(Offset.getX-impl(unbox-impl), Offset.getY-impl(unbox-impl), paint.asFrameworkPaint());
            index$iv++;
        }
    }

    private final void drawRawLines(float[] points, androidx.compose.ui.graphics.Paint paint, int stepBy) {
        int i6;
        int i2;
        int i3;
        int i4;
        int i;
        int i5;
        android.graphics.Paint frameworkPaint;
        if (points.length >= 4 && length %= 2 == 0) {
            if (length %= 2 == 0) {
                i6 = 0;
                while (i6 < length2 += -3) {
                    this.internalCanvas.drawLine(points[i6], points[i6 + 1], points[i6 + 2], points[i6 + 3], paint.asFrameworkPaint());
                    i6 += i2;
                }
            }
        }
    }

    private final void drawRawPoints(float[] points, androidx.compose.ui.graphics.Paint paint, int stepBy) {
        int frameworkPaint;
        int i3;
        int i;
        int i2;
        Canvas internalCanvas;
        if (length %= 2 == 0) {
            i3 = 0;
            while (i3 < length2--) {
                this.internalCanvas.drawPoint(points[i3], points[i3 + 1], paint.asFrameworkPaint());
                i3 += stepBy;
            }
        }
    }

    public static void getInternalCanvas$annotations() {
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void clipPath-mtrdD-E(androidx.compose.ui.graphics.Path path, int clipOp) {
        Object obj = path;
        final int i = 0;
        if (obj instanceof AndroidPath == null) {
        } else {
            this.internalCanvas.clipPath((AndroidPath)obj.getInternalPath(), toRegionOp--7u2Bmg(clipOp));
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void clipRect-N_I0leg(float left, float top, float right, float bottom, int clipOp) {
        this.internalCanvas.clipRect(left, top, right, bottom, toRegionOp--7u2Bmg(clipOp));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void concat-58bKbWc(float[] matrix) {
        boolean identity-58bKbWc;
        Canvas internalCanvas;
        if (!MatrixKt.isIdentity-58bKbWc(matrix)) {
            identity-58bKbWc = new Matrix();
            AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(identity-58bKbWc, matrix);
            this.internalCanvas.concat(identity-58bKbWc);
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, androidx.compose.ui.graphics.Paint paint) {
        this.internalCanvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, useCenter, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawCircle-9KIMszo(long center, float radius, androidx.compose.ui.graphics.Paint paint) {
        this.internalCanvas.drawCircle(Offset.getX-impl(center), Offset.getY-impl(center), paint, obj8.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawImage-d-4ec7I(androidx.compose.ui.graphics.ImageBitmap image, long topLeftOffset, androidx.compose.ui.graphics.Paint paint) {
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(image), Offset.getX-impl(topLeftOffset), Offset.getY-impl(topLeftOffset), obj9.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawImageRect-HPBpro0(androidx.compose.ui.graphics.ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, androidx.compose.ui.graphics.Paint paint) {
        Rect srcRect;
        if (this.srcRect == null) {
            Rect rect = new Rect();
            this.srcRect = rect;
            srcRect = new Rect();
            this.dstRect = srcRect;
        }
        final Rect srcRect2 = this.srcRect;
        Intrinsics.checkNotNull(srcRect2);
        Rect rect2 = srcRect2;
        int i = 0;
        rect2.left = IntOffset.getX-impl(srcOffset);
        rect2.top = IntOffset.getY-impl(srcOffset);
        rect2.right = x-impl2 += width-impl;
        rect2.bottom = y-impl2 += height-impl;
        Unit $this$drawImageRect_HPBpro0_u24lambda_u240 = Unit.INSTANCE;
        Rect dstRect = this.dstRect;
        Intrinsics.checkNotNull(dstRect);
        Rect rect3 = dstRect;
        int i4 = 0;
        rect3.left = IntOffset.getX-impl(paint);
        rect3.top = IntOffset.getY-impl(paint);
        rect3.right = x-impl4 += width-impl2;
        rect3.bottom = y-impl4 += height-impl2;
        Unit $this$drawImageRect_HPBpro0_u24lambda_u241 = Unit.INSTANCE;
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(image), srcRect2, dstRect, obj18.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawLine-Wko1d7g(long p1, long p2, androidx.compose.ui.graphics.Paint paint) {
        this.internalCanvas.drawLine(Offset.getX-impl(p1), Offset.getY-impl(p1), Offset.getX-impl(paint), Offset.getY-impl(paint), obj11.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawOval(float left, float top, float right, float bottom, androidx.compose.ui.graphics.Paint paint) {
        this.internalCanvas.drawOval(left, top, right, bottom, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawPath(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.Paint paint) {
        Object obj = path;
        final int i = 0;
        if (obj instanceof AndroidPath == null) {
        } else {
            this.internalCanvas.drawPath((AndroidPath)obj.getInternalPath(), paint.asFrameworkPaint());
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        throw unsupportedOperationException;
    }

    public void drawPoints-O7TthRY(int pointMode, List<Offset> points, androidx.compose.ui.graphics.Paint paint) {
        int equals-impl0;
        if (PointMode.equals-impl0(pointMode, PointMode.Companion.getLines-r_lszbg())) {
            drawLines(points, paint, 2);
        } else {
            if (PointMode.equals-impl0(pointMode, PointMode.Companion.getPolygon-r_lszbg())) {
                drawLines(points, paint, 1);
            } else {
                if (PointMode.equals-impl0(pointMode, PointMode.Companion.getPoints-r_lszbg())) {
                    drawPoints(points, paint);
                }
            }
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRawPoints-O7TthRY(int pointMode, float[] points, androidx.compose.ui.graphics.Paint paint) {
        boolean equals-impl0;
        int i2 = 2;
        if (length %= i2 != 0) {
        } else {
            if (PointMode.equals-impl0(pointMode, PointMode.Companion.getLines-r_lszbg())) {
                drawRawLines(points, paint, i2);
            } else {
                if (PointMode.equals-impl0(pointMode, PointMode.Companion.getPolygon-r_lszbg())) {
                    drawRawLines(points, paint, 1);
                } else {
                    if (PointMode.equals-impl0(pointMode, PointMode.Companion.getPoints-r_lszbg())) {
                        drawRawPoints(points, paint, i2);
                    }
                }
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("points must have an even number of values");
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRect(float left, float top, float right, float bottom, androidx.compose.ui.graphics.Paint paint) {
        this.internalCanvas.drawRect(left, top, right, bottom, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY, androidx.compose.ui.graphics.Paint paint) {
        this.internalCanvas.drawRoundRect(left, top, right, bottom, radiusX, radiusY, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawVertices-TPEHhCM(androidx.compose.ui.graphics.Vertices vertices, int blendMode, androidx.compose.ui.graphics.Paint paint) {
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.toAndroidVertexMode-JOOmi9M(vertices.getVertexMode-c2xauaI()), positions.length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, indices.length, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void restore() {
        this.internalCanvas.restore();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void rotate(float degrees) {
        this.internalCanvas.rotate(degrees);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void save() {
        this.internalCanvas.save();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void saveLayer(Rect bounds, androidx.compose.ui.graphics.Paint paint) {
        this.internalCanvas.saveLayer(bounds.getLeft(), bounds.getTop(), bounds.getRight(), bounds.getBottom(), paint.asFrameworkPaint(), 31);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void scale(float sx, float sy) {
        this.internalCanvas.scale(sx, sy);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void setInternalCanvas(Canvas <set-?>) {
        this.internalCanvas = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void skew(float sx, float sy) {
        this.internalCanvas.skew(sx, sy);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final Region.Op toRegionOp--7u2Bmg(int $this$toRegionOp_u2d_u2d7u2Bmg) {
        Region.Op dIFFERENCE;
        dIFFERENCE = ClipOp.equals-impl0($this$toRegionOp_u2d_u2d7u2Bmg, ClipOp.Companion.getDifference-rtfAjoo()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
        return dIFFERENCE;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void translate(float dx, float dy) {
        this.internalCanvas.translate(dx, dy);
    }
}
