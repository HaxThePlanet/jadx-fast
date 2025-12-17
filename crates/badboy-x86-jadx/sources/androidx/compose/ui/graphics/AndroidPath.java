package androidx.compose.ui.graphics;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Path.Op;
import android.graphics.RectF;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J \u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J\"\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001dH\u0016J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0016J\u0018\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u0002012\u0006\u0010%\u001a\u00020&H\u0016J(\u00102\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u000fH\u0016J\u0008\u00104\u001a\u00020\u001bH\u0016J8\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001fH\u0016J\u0008\u0010<\u001a\u00020\u001dH\u0016J\u0018\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001fH\u0016J\u0018\u0010@\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001fH\u0016J*\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020EH\u0016ø\u0001\u0000¢\u0006\u0004\u0008F\u0010GJ(\u0010H\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001fH\u0016J(\u0010I\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001fH\u0016J8\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020\u001fH\u0016J\u0018\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001fH\u0016J\u0018\u0010T\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001fH\u0016J(\u0010U\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001fH\u0016J(\u0010V\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001fH\u0016J\u0008\u0010W\u001a\u00020\u001bH\u0016J\u0008\u0010X\u001a\u00020\u001bH\u0016J\u001a\u0010Y\u001a\u00020\u001b2\u0006\u0010Z\u001a\u00020[H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\\\u0010]J\u001a\u0010^\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\u0008_\u0010`J\u0010\u0010a\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001dH\u0002R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\u0011\u001a\u0004\u0008\u000e\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006b", d2 = {"Landroidx/compose/ui/graphics/AndroidPath;", "Landroidx/compose/ui/graphics/Path;", "internalPath", "Landroid/graphics/Path;", "(Landroid/graphics/Path;)V", "value", "Landroidx/compose/ui/graphics/PathFillType;", "fillType", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "getInternalPath", "()Landroid/graphics/Path;", "isConvex", "", "isConvex$annotations", "()V", "()Z", "isEmpty", "mMatrix", "Landroid/graphics/Matrix;", "radii", "", "rectF", "Landroid/graphics/RectF;", "addArc", "", "oval", "Landroidx/compose/ui/geometry/Rect;", "startAngleDegrees", "", "sweepAngleDegrees", "addArcRad", "startAngleRadians", "sweepAngleRadians", "addOval", "direction", "Landroidx/compose/ui/graphics/Path$Direction;", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "addRect", "rect", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "arcTo", "forceMoveTo", "close", "cubicTo", "x1", "y1", "x2", "y2", "x3", "y3", "getBounds", "lineTo", "x", "y", "moveTo", "op", "path1", "path2", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "quadraticBezierTo", "quadraticTo", "relativeCubicTo", "dx1", "dy1", "dx2", "dy2", "dx3", "dy3", "relativeLineTo", "dx", "dy", "relativeMoveTo", "relativeQuadraticBezierTo", "relativeQuadraticTo", "reset", "rewind", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "translate", "translate-k-4lQ0M", "(J)V", "validateRectangle", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidPath implements androidx.compose.ui.graphics.Path {

    private final Path internalPath;
    private Matrix mMatrix;
    private float[] radii;
    private RectF rectF;
    public AndroidPath() {
        final int i = 0;
        super(i, 1, i);
    }

    public AndroidPath(Path internalPath) {
        super();
        this.internalPath = internalPath;
    }

    public AndroidPath(Path path, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        Path obj1;
        if (i2 &= 1 != 0) {
            obj1 = new Path();
        }
        super(obj1);
    }

    public static void isConvex$annotations() {
    }

    private final void validateRectangle(Rect rect) {
        boolean naN;
        if (!Float.isNaN(rect.getLeft()) && !Float.isNaN(rect.getTop()) && !Float.isNaN(rect.getRight())) {
            if (!Float.isNaN(rect.getTop())) {
                if (!Float.isNaN(rect.getRight())) {
                    if (Float.isNaN(rect.getBottom())) {
                        AndroidPath_androidKt.throwIllegalStateException("Invalid rectangle, make sure no value is NaN");
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addArc(Rect oval, float startAngleDegrees, float sweepAngleDegrees) {
        RectF rectF;
        validateRectangle(oval);
        if (this.rectF == null) {
            rectF = new RectF();
            this.rectF = rectF;
        }
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        rectF2.set(oval.getLeft(), oval.getTop(), oval.getRight(), oval.getBottom());
        RectF rectF3 = this.rectF;
        Intrinsics.checkNotNull(rectF3);
        this.internalPath.addArc(rectF3, startAngleDegrees, sweepAngleDegrees);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addArcRad(Rect oval, float startAngleRadians, float sweepAngleRadians) {
        addArc(oval, DegreesKt.degrees(startAngleRadians), DegreesKt.degrees(sweepAngleRadians));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addOval(Rect oval) {
        addOval(oval, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addOval(Rect oval, androidx.compose.ui.graphics.Path.Direction direction) {
        RectF rectF;
        if (this.rectF == null) {
            rectF = new RectF();
            this.rectF = rectF;
        }
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        rectF2.set(oval.getLeft(), oval.getTop(), oval.getRight(), oval.getBottom());
        RectF rectF3 = this.rectF;
        Intrinsics.checkNotNull(rectF3);
        this.internalPath.addOval(rectF3, AndroidPath_androidKt.access$toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addPath-Uv8p0NA(androidx.compose.ui.graphics.Path path, long offset) {
        Object obj = path;
        int i = 0;
        if (obj instanceof AndroidPath == null) {
        } else {
            this.internalPath.addPath((AndroidPath)obj.getInternalPath(), Offset.getX-impl(offset), Offset.getY-impl(offset));
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRect(Rect rect) {
        addRect(rect, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRect(Rect rect, androidx.compose.ui.graphics.Path.Direction direction) {
        RectF rectF;
        validateRectangle(rect);
        if (this.rectF == null) {
            rectF = new RectF();
            this.rectF = rectF;
        }
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        rectF2.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        RectF rectF3 = this.rectF;
        Intrinsics.checkNotNull(rectF3);
        this.internalPath.addRect(rectF3, AndroidPath_androidKt.access$toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRoundRect(RoundRect roundRect) {
        addRoundRect(roundRect, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRoundRect(RoundRect roundRect, androidx.compose.ui.graphics.Path.Direction direction) {
        RectF rectF;
        float[] fArr;
        if (this.rectF == null) {
            rectF = new RectF();
            this.rectF = rectF;
        }
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        float right = roundRect.getRight();
        rectF2.set(roundRect.getLeft(), roundRect.getTop(), right, roundRect.getBottom());
        if (this.radii == null) {
            this.radii = new float[8];
        }
        float[] radii = this.radii;
        Intrinsics.checkNotNull(radii);
        int i2 = 0;
        int i3 = 0;
        radii[i3] = CornerRadius.getX-impl(roundRect.getTopLeftCornerRadius-kKHJgLs());
        int i4 = 1;
        radii[i4] = CornerRadius.getY-impl(roundRect.getTopLeftCornerRadius-kKHJgLs());
        int i5 = 2;
        radii[i5] = CornerRadius.getX-impl(roundRect.getTopRightCornerRadius-kKHJgLs());
        int i6 = 3;
        radii[i6] = CornerRadius.getY-impl(roundRect.getTopRightCornerRadius-kKHJgLs());
        int i7 = 4;
        radii[i7] = CornerRadius.getX-impl(roundRect.getBottomRightCornerRadius-kKHJgLs());
        int i8 = 5;
        radii[i8] = CornerRadius.getY-impl(roundRect.getBottomRightCornerRadius-kKHJgLs());
        int i9 = 6;
        radii[i9] = CornerRadius.getX-impl(roundRect.getBottomLeftCornerRadius-kKHJgLs());
        radii[7] = CornerRadius.getY-impl(roundRect.getBottomLeftCornerRadius-kKHJgLs());
        RectF rectF3 = this.rectF;
        Intrinsics.checkNotNull(rectF3);
        float[] radii2 = this.radii;
        Intrinsics.checkNotNull(radii2);
        this.internalPath.addRoundRect(rectF3, radii2, AndroidPath_androidKt.access$toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void arcTo(Rect rect, float startAngleDegrees, float sweepAngleDegrees, boolean forceMoveTo) {
        RectF rectF;
        if (this.rectF == null) {
            rectF = new RectF();
            this.rectF = rectF;
        }
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        rectF2.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        final RectF rectF3 = this.rectF;
        Intrinsics.checkNotNull(rectF3);
        this.internalPath.arcTo(rectF3, startAngleDegrees, sweepAngleDegrees, forceMoveTo);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void close() {
        this.internalPath.close();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        this.internalPath.cubicTo(x1, y1, x2, y2, x3, y3);
    }

    @Override // androidx.compose.ui.graphics.Path
    public Rect getBounds() {
        RectF rectF;
        if (this.rectF == null) {
            rectF = new RectF();
            this.rectF = rectF;
        }
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        final int i = 0;
        this.internalPath.computeBounds(rectF2, true);
        Rect rect = new Rect(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom);
        return rect;
    }

    @Override // androidx.compose.ui.graphics.Path
    public int getFillType-Rg-k1Os() {
        int evenOdd-Rg-k1Os;
        if (this.internalPath.getFillType() == Path.FillType.EVEN_ODD) {
            evenOdd-Rg-k1Os = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        } else {
            evenOdd-Rg-k1Os = PathFillType.Companion.getNonZero-Rg-k1Os();
        }
        return evenOdd-Rg-k1Os;
    }

    @Override // androidx.compose.ui.graphics.Path
    public final Path getInternalPath() {
        return this.internalPath;
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void lineTo(float x, float y) {
        this.internalPath.lineTo(x, y);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void moveTo(float x, float y) {
        this.internalPath.moveTo(x, y);
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean op-N5in7k0(androidx.compose.ui.graphics.Path path1, androidx.compose.ui.graphics.Path path2, int operation) {
        Path.Op rEVERSE_DIFFERENCE;
        rEVERSE_DIFFERENCE = PathOperation.equals-impl0(operation, PathOperation.Companion.getDifference-b3I0S0c()) ? Path.Op.DIFFERENCE : equals-impl02 ? Path.Op.INTERSECT : equals-impl03 ? Path.Op.REVERSE_DIFFERENCE : equals-impl04 ? Path.Op.UNION : Path.Op.XOR;
        Object obj = path1;
        int i = 0;
        String str = "Unable to obtain android.graphics.Path";
        if (obj instanceof AndroidPath == null) {
        } else {
            Object $this$asAndroidPath$iv = path2;
            int i2 = 0;
            if ($this$asAndroidPath$iv instanceof AndroidPath == null) {
            } else {
                return this.internalPath.op((AndroidPath)obj.getInternalPath(), (AndroidPath)$this$asAndroidPath$iv.getInternalPath(), rEVERSE_DIFFERENCE);
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(str);
            throw unsupportedOperationException;
        }
        UnsupportedOperationException unsupportedOperationException2 = new UnsupportedOperationException(str);
        throw unsupportedOperationException2;
    }

    @Override // androidx.compose.ui.graphics.Path
    public void quadraticBezierTo(float x1, float y1, float x2, float y2) {
        this.internalPath.quadTo(x1, y1, x2, y2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void quadraticTo(float x1, float y1, float x2, float y2) {
        this.internalPath.quadTo(x1, y1, x2, y2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeCubicTo(float dx1, float dy1, float dx2, float dy2, float dx3, float dy3) {
        this.internalPath.rCubicTo(dx1, dy1, dx2, dy2, dx3, dy3);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeLineTo(float dx, float dy) {
        this.internalPath.rLineTo(dx, dy);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeMoveTo(float dx, float dy) {
        this.internalPath.rMoveTo(dx, dy);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeQuadraticBezierTo(float dx1, float dy1, float dx2, float dy2) {
        this.internalPath.rQuadTo(dx1, dy1, dx2, dy2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeQuadraticTo(float dx1, float dy1, float dx2, float dy2) {
        this.internalPath.rQuadTo(dx1, dy1, dx2, dy2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void reset() {
        this.internalPath.reset();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void rewind() {
        this.internalPath.rewind();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void setFillType-oQ8Xj4U(int value) {
        Path.FillType eVEN_ODD;
        eVEN_ODD = PathFillType.equals-impl0(value, PathFillType.Companion.getEvenOdd-Rg-k1Os()) ? Path.FillType.EVEN_ODD : Path.FillType.WINDING;
        this.internalPath.setFillType(eVEN_ODD);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void transform-58bKbWc(float[] matrix) {
        Matrix mMatrix;
        if (this.mMatrix == null) {
            mMatrix = new Matrix();
            this.mMatrix = mMatrix;
        }
        Matrix mMatrix2 = this.mMatrix;
        Intrinsics.checkNotNull(mMatrix2);
        AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(mMatrix2, matrix);
        final Matrix mMatrix3 = this.mMatrix;
        Intrinsics.checkNotNull(mMatrix3);
        this.internalPath.transform(mMatrix3);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void translate-k-4lQ0M(long offset) {
        Matrix mMatrix;
        if (this.mMatrix == null) {
            mMatrix = new Matrix();
            this.mMatrix = mMatrix;
        } else {
            mMatrix = this.mMatrix;
            Intrinsics.checkNotNull(mMatrix);
            mMatrix.reset();
        }
        Matrix mMatrix3 = this.mMatrix;
        Intrinsics.checkNotNull(mMatrix3);
        mMatrix3.setTranslate(Offset.getX-impl(offset), Offset.getY-impl(offset));
        Matrix mMatrix4 = this.mMatrix;
        Intrinsics.checkNotNull(mMatrix4);
        this.internalPath.transform(mMatrix4);
    }
}
