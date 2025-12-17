package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008f\u0018\u0000 ^2\u00020\u0001:\u0002^_J \u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H&J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018H&J$\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001cH&ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH'J\u001a\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H'J\u001a\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018H&J\u0011\u0010$\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0004J(\u0010%\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\tH&J(\u0010'\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\tH\u0016J\u0008\u0010(\u001a\u00020\rH&J8\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0011H&J\u0008\u00100\u001a\u00020\u000fH&J\t\u00101\u001a\u000202H\u0096\u0002J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u00020\u0011H\u0016J\u0018\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H&J\u0011\u00109\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0018\u0010:\u001a\u00020\r2\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H&J*\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?H&ø\u0001\u0000¢\u0006\u0004\u0008@\u0010AJ\u0011\u0010B\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0004J\u0011\u0010C\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J(\u0010D\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H'J(\u0010E\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0016J8\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\u0011H&J\u0018\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u0011H&J\u0018\u0010P\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u0011H&J(\u0010Q\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u0011H'J(\u0010R\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u0011H\u0016J\u0008\u0010S\u001a\u00020\rH&J\u0008\u0010T\u001a\u00020\rH\u0016J\u001a\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020WH\u0016ø\u0001\u0000¢\u0006\u0004\u0008X\u0010YJ\u001a\u0010Z\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH&ø\u0001\u0000¢\u0006\u0004\u0008[\u0010\\J\u0011\u0010]\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0004R\u001e\u0010\u0002\u001a\u00020\u0003X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0004\u0010\u0005\"\u0004\u0008\u0006\u0010\u0007R\u0012\u0010\u0008\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\nR\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\nø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006`À\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/Path;", "", "fillType", "Landroidx/compose/ui/graphics/PathFillType;", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "isConvex", "", "()Z", "isEmpty", "addArc", "", "oval", "Landroidx/compose/ui/geometry/Rect;", "startAngleDegrees", "", "sweepAngleDegrees", "addArcRad", "startAngleRadians", "sweepAngleRadians", "addOval", "direction", "Landroidx/compose/ui/graphics/Path$Direction;", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "addRect", "rect", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "and", "arcTo", "forceMoveTo", "arcToRad", "close", "cubicTo", "x1", "y1", "x2", "y2", "x3", "y3", "getBounds", "iterator", "Landroidx/compose/ui/graphics/PathIterator;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "lineTo", "x", "y", "minus", "moveTo", "op", "path1", "path2", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "or", "plus", "quadraticBezierTo", "quadraticTo", "relativeCubicTo", "dx1", "dy1", "dx2", "dy2", "dx3", "dy3", "relativeLineTo", "dx", "dy", "relativeMoveTo", "relativeQuadraticBezierTo", "relativeQuadraticTo", "reset", "rewind", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "translate", "translate-k-4lQ0M", "(J)V", "xor", "Companion", "Direction", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Path {

    public static final androidx.compose.ui.graphics.Path.Companion Companion;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000b", d2 = {"Landroidx/compose/ui/graphics/Path$Companion;", "", "()V", "combine", "Landroidx/compose/ui/graphics/Path;", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "path1", "path2", "combine-xh6zSI8", "(ILandroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.graphics.Path.Companion $$INSTANCE;
        static {
            Path.Companion companion = new Path.Companion();
            Path.Companion.$$INSTANCE = companion;
        }

        public final androidx.compose.ui.graphics.Path combine-xh6zSI8(int operation, androidx.compose.ui.graphics.Path path1, androidx.compose.ui.graphics.Path path2) {
            final androidx.compose.ui.graphics.Path path = AndroidPath_androidKt.Path();
            if (!path.op-N5in7k0(path1, path2, operation)) {
            } else {
                return path;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Path.combine() failed.  This may be due an invalid path; in particular, check for NaN values.");
            throw illegalArgumentException;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void addOval$default(androidx.compose.ui.graphics.Path path, Rect rect2, androidx.compose.ui.graphics.Path.Direction path$Direction3, int i4, Object object5) {
            Path.addOval$default(path, rect2, direction3, i4, object5);
        }

        public static void addPath-Uv8p0NA$default(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.Path path2, long l3, int i4, Object object5) {
            Path.addPath-Uv8p0NA$default(path, path2, l3, i4, object5);
        }

        public static void addRect$default(androidx.compose.ui.graphics.Path path, Rect rect2, androidx.compose.ui.graphics.Path.Direction path$Direction3, int i4, Object object5) {
            Path.addRect$default(path, rect2, direction3, i4, object5);
        }

        public static void addRoundRect$default(androidx.compose.ui.graphics.Path path, RoundRect roundRect2, androidx.compose.ui.graphics.Path.Direction path$Direction3, int i4, Object object5) {
            Path.addRoundRect$default(path, roundRect2, direction3, i4, object5);
        }

        @Deprecated
        public static androidx.compose.ui.graphics.Path and(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.Path path) {
            return Path.access$and$jd($this, path);
        }

        @Deprecated
        public static void arcToRad(androidx.compose.ui.graphics.Path $this, Rect rect, float startAngleRadians, float sweepAngleRadians, boolean forceMoveTo) {
            Path.access$arcToRad$jd($this, rect, startAngleRadians, sweepAngleRadians, forceMoveTo);
        }

        @Deprecated
        public static androidx.compose.ui.graphics.PathIterator iterator(androidx.compose.ui.graphics.Path $this) {
            return Path.access$iterator$jd($this);
        }

        @Deprecated
        public static androidx.compose.ui.graphics.PathIterator iterator(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
            return Path.access$iterator$jd($this, conicEvaluation, tolerance);
        }

        public static androidx.compose.ui.graphics.PathIterator iterator$default(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.PathIterator.ConicEvaluation pathIterator$ConicEvaluation2, float f3, int i4, Object object5) {
            return Path.iterator$default(path, conicEvaluation2, f3, i4, object5);
        }

        @Deprecated
        public static androidx.compose.ui.graphics.Path minus(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.Path path) {
            return Path.access$minus$jd($this, path);
        }

        @Deprecated
        public static androidx.compose.ui.graphics.Path or(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.Path path) {
            return Path.access$or$jd($this, path);
        }

        @Deprecated
        public static androidx.compose.ui.graphics.Path plus(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.Path path) {
            return Path.access$plus$jd($this, path);
        }

        @Deprecated
        public static void quadraticTo(androidx.compose.ui.graphics.Path $this, float x1, float y1, float x2, float y2) {
            Path.access$quadraticTo$jd($this, x1, y1, x2, y2);
        }

        @Deprecated
        public static void relativeQuadraticTo(androidx.compose.ui.graphics.Path $this, float dx1, float dy1, float dx2, float dy2) {
            Path.access$relativeQuadraticTo$jd($this, dx1, dy1, dx2, dy2);
        }

        @Deprecated
        public static void rewind(androidx.compose.ui.graphics.Path $this) {
            Path.access$rewind$jd($this);
        }

        @Deprecated
        public static void transform-58bKbWc(androidx.compose.ui.graphics.Path $this, float[] matrix) {
            Path.access$transform-58bKbWc$jd($this, matrix);
        }

        @Deprecated
        public static androidx.compose.ui.graphics.Path xor(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.Path path) {
            return Path.access$xor$jd($this, path);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Landroidx/compose/ui/graphics/Path$Direction;", "", "(Ljava/lang/String;I)V", "CounterClockwise", "Clockwise", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum Direction {

        CounterClockwise,
        Clockwise;
        private static final androidx.compose.ui.graphics.Path.Direction[] $values() {
            return /* result */;
        }
    }
    static {
        Path.Companion = Path.Companion.$$INSTANCE;
    }

    public static androidx.compose.ui.graphics.Path access$and$jd(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.Path path) {
        return super.and(path);
    }

    public static void access$arcToRad$jd(androidx.compose.ui.graphics.Path $this, Rect rect, float startAngleRadians, float sweepAngleRadians, boolean forceMoveTo) {
        super.arcToRad(rect, startAngleRadians, sweepAngleRadians, forceMoveTo);
    }

    public static androidx.compose.ui.graphics.PathIterator access$iterator$jd(androidx.compose.ui.graphics.Path $this) {
        return super.iterator();
    }

    public static androidx.compose.ui.graphics.PathIterator access$iterator$jd(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
        return super.iterator(conicEvaluation, tolerance);
    }

    public static androidx.compose.ui.graphics.Path access$minus$jd(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.Path path) {
        return super.minus(path);
    }

    public static androidx.compose.ui.graphics.Path access$or$jd(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.Path path) {
        return super.or(path);
    }

    public static androidx.compose.ui.graphics.Path access$plus$jd(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.Path path) {
        return super.plus(path);
    }

    public static void access$quadraticTo$jd(androidx.compose.ui.graphics.Path $this, float x1, float y1, float x2, float y2) {
        super.quadraticTo(x1, y1, x2, y2);
    }

    public static void access$relativeQuadraticTo$jd(androidx.compose.ui.graphics.Path $this, float dx1, float dy1, float dx2, float dy2) {
        super.relativeQuadraticTo(dx1, dy1, dx2, dy2);
    }

    public static void access$rewind$jd(androidx.compose.ui.graphics.Path $this) {
        super.rewind();
    }

    public static void access$transform-58bKbWc$jd(androidx.compose.ui.graphics.Path $this, float[] matrix) {
        super.transform-58bKbWc(matrix);
    }

    public static androidx.compose.ui.graphics.Path access$xor$jd(androidx.compose.ui.graphics.Path $this, androidx.compose.ui.graphics.Path path) {
        return super.xor(path);
    }

    public static void addOval$default(androidx.compose.ui.graphics.Path path, Rect rect2, androidx.compose.ui.graphics.Path.Direction path$Direction3, int i4, Object object5) {
        androidx.compose.ui.graphics.Path.Direction obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = Path.Direction.CounterClockwise;
            }
            path.addOval(rect2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addOval");
        throw obj0;
    }

    public static void addPath-Uv8p0NA$default(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.Path path2, long l3, int i4, Object object5) {
        long obj2;
        if (obj5 != null) {
        } else {
            if (object5 &= 2 != 0) {
                obj2 = Offset.Companion.getZero-F1C5BW0();
            }
            path.addPath-Uv8p0NA(path2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
        throw obj0;
    }

    public static void addRect$default(androidx.compose.ui.graphics.Path path, Rect rect2, androidx.compose.ui.graphics.Path.Direction path$Direction3, int i4, Object object5) {
        androidx.compose.ui.graphics.Path.Direction obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = Path.Direction.CounterClockwise;
            }
            path.addRect(rect2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRect");
        throw obj0;
    }

    public static void addRoundRect$default(androidx.compose.ui.graphics.Path path, RoundRect roundRect2, androidx.compose.ui.graphics.Path.Direction path$Direction3, int i4, Object object5) {
        androidx.compose.ui.graphics.Path.Direction obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = Path.Direction.CounterClockwise;
            }
            path.addRoundRect(roundRect2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRoundRect");
        throw obj0;
    }

    public static androidx.compose.ui.graphics.PathIterator iterator$default(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.PathIterator.ConicEvaluation pathIterator$ConicEvaluation2, float f3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 1048576000;
            }
            return path.iterator(conicEvaluation2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: iterator");
        throw obj0;
    }

    public abstract void addArc(Rect rect, float f2, float f3);

    public abstract void addArcRad(Rect rect, float f2, float f3);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addOval() with a winding direction", replaceWith = @ReplaceWith(...))
    public abstract void addOval(Rect rect);

    public abstract void addOval(Rect rect, androidx.compose.ui.graphics.Path.Direction path$Direction2);

    public abstract void addPath-Uv8p0NA(androidx.compose.ui.graphics.Path path, long l2);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addRect() with a winding direction", replaceWith = @ReplaceWith(...))
    public abstract void addRect(Rect rect);

    public abstract void addRect(Rect rect, androidx.compose.ui.graphics.Path.Direction path$Direction2);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of addRoundRect() with a winding direction", replaceWith = @ReplaceWith(...))
    public abstract void addRoundRect(RoundRect roundRect);

    public abstract void addRoundRect(RoundRect roundRect, androidx.compose.ui.graphics.Path.Direction path$Direction2);

    public androidx.compose.ui.graphics.Path and(androidx.compose.ui.graphics.Path path) {
        final androidx.compose.ui.graphics.Path path2 = AndroidPath_androidKt.Path();
        final int i = 0;
        path2.op-N5in7k0(this, path, PathOperation.Companion.getIntersect-b3I0S0c());
        return path2;
    }

    public abstract void arcTo(Rect rect, float f2, float f3, boolean z4);

    public void arcToRad(Rect rect, float startAngleRadians, float sweepAngleRadians, boolean forceMoveTo) {
        arcTo(rect, DegreesKt.degrees(startAngleRadians), DegreesKt.degrees(sweepAngleRadians), forceMoveTo);
    }

    public abstract void close();

    public abstract void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    public abstract Rect getBounds();

    public abstract int getFillType-Rg-k1Os();

    public abstract boolean isConvex();

    public abstract boolean isEmpty();

    public androidx.compose.ui.graphics.PathIterator iterator() {
        final int i3 = 0;
        return AndroidPathIterator_androidKt.PathIterator$default(this, i3, 0, 6, i3);
    }

    public androidx.compose.ui.graphics.PathIterator iterator(androidx.compose.ui.graphics.PathIterator.ConicEvaluation conicEvaluation, float tolerance) {
        return AndroidPathIterator_androidKt.PathIterator(this, conicEvaluation, tolerance);
    }

    public abstract void lineTo(float f, float f2);

    public androidx.compose.ui.graphics.Path minus(androidx.compose.ui.graphics.Path path) {
        final androidx.compose.ui.graphics.Path path2 = AndroidPath_androidKt.Path();
        final int i = 0;
        path2.op-N5in7k0(this, path, PathOperation.Companion.getDifference-b3I0S0c());
        return path2;
    }

    public abstract void moveTo(float f, float f2);

    public abstract boolean op-N5in7k0(androidx.compose.ui.graphics.Path path, androidx.compose.ui.graphics.Path path2, int i3);

    public androidx.compose.ui.graphics.Path or(androidx.compose.ui.graphics.Path path) {
        return plus(path);
    }

    public androidx.compose.ui.graphics.Path plus(androidx.compose.ui.graphics.Path path) {
        final androidx.compose.ui.graphics.Path path2 = AndroidPath_androidKt.Path();
        final int i = 0;
        path2.op-N5in7k0(this, path, PathOperation.Companion.getUnion-b3I0S0c());
        return path2;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use quadraticTo() for consistency with cubicTo()", replaceWith = @ReplaceWith(...))
    public abstract void quadraticBezierTo(float f, float f2, float f3, float f4);

    public void quadraticTo(float x1, float y1, float x2, float y2) {
        quadraticBezierTo(x1, y1, x2, y2);
    }

    public abstract void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    public abstract void relativeLineTo(float f, float f2);

    public abstract void relativeMoveTo(float f, float f2);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use relativeQuadraticTo() for consistency with relativeCubicTo()", replaceWith = @ReplaceWith(...))
    public abstract void relativeQuadraticBezierTo(float f, float f2, float f3, float f4);

    public void relativeQuadraticTo(float dx1, float dy1, float dx2, float dy2) {
        relativeQuadraticBezierTo(dx1, dy1, dx2, dy2);
    }

    public abstract void reset();

    public void rewind() {
        reset();
    }

    public abstract void setFillType-oQ8Xj4U(int i);

    public void transform-58bKbWc(float[] matrix) {
    }

    public abstract void translate-k-4lQ0M(long l);

    public androidx.compose.ui.graphics.Path xor(androidx.compose.ui.graphics.Path path) {
        final androidx.compose.ui.graphics.Path path2 = AndroidPath_androidKt.Path();
        final int i = 0;
        path2.op-N5in7k0(this, path, PathOperation.Companion.getXor-b3I0S0c());
        return path2;
    }
}
