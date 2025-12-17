package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aX\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001aX\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u001a\u001a\u0010\u001a\u001a\u00020\u0007*\u0008\u0012\u0004\u0012\u00020\u001c0\u001b2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u0007\u001a\r\u0010\u001e\u001a\u00020\t*\u00020\tH\u0082\u0008\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u001f", d2 = {"EmptyArray", "", "getEmptyArray", "()[F", "arcToBezier", "", "p", "Landroidx/compose/ui/graphics/Path;", "cx", "", "cy", "a", "b", "e1x", "e1y", "theta", "start", "sweep", "drawArc", "x0", "y0", "x1", "y1", "isMoreThanHalf", "", "isPositiveArc", "toPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "target", "toRadians", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathParserKt {

    private static final float[] EmptyArray;
    static {
        PathParserKt.EmptyArray = new float[0];
    }

    private static final void arcToBezier(Path p, double cx, double cy, double a, double b, double e1x, double e1y, double theta, double start, double sweep) {
        int eta1;
        float f4;
        int anglePerSegment;
        int eta1y;
        double d5;
        int i5;
        int i10;
        long l;
        double d2;
        float f5;
        int eta1x;
        int ep1x;
        int ep1y;
        int i;
        double d3;
        double d4;
        double d;
        int i7;
        int i2;
        int eta1y2;
        int i9;
        int i8;
        double d6;
        int i4;
        int i3;
        int i6;
        double d7;
        Object obj;
        float f;
        float f2;
        float f6;
        float f8;
        float f3;
        float f7;
        eta1 = e1x;
        eta1y = obj73;
        l = 4614256656552045848L;
        i10 = obj77;
        d2 = Math.cos(obj75);
        final double d13 = Math.sin(obj75);
        final double d14 = Math.cos(i10);
        final double d15 = Math.sin(i10);
        eta1x = i16;
        ep1x = i19;
        ep1y = i22;
        anglePerSegment = i39;
        while (anglePerSegment < i5) {
            i = i10 + i40;
            d3 = Math.sin(i);
            d4 = Math.cos(i);
            int i24 = i43 - i48;
            eta1y = i46 + i50;
            d = d5;
            i7 = i29;
            double d9 = Math.tan(i56 /= d8);
            d6 = d9;
            i59 /= d11;
            i13 += eta1x;
            i4 = i32;
            i6 = i10;
            i8 = i14;
            p.cubicTo((float)i14, (float)ep2y, (float)numSegments, (float)l, (float)i24, (float)eta1y);
            eta1x = i24;
            eta1y2 = eta1y;
            ep1x = i7;
            ep1y = i4;
            anglePerSegment = i2 + 1;
            i10 = i15;
            d5 = d;
            i5 = i3;
            d2 = d7;
            eta1 = e1x;
        }
    }

    private static final void drawArc(Path p, double x0, double y0, double x1, double y1, double a, double b, double theta, boolean isMoreThanHalf, boolean isPositiveArc) {
        int i2;
        int cx;
        int cmp;
        int cy;
        int i;
        int sweep;
        int i7 = x0;
        int i28 = a;
        int i3 = 0;
        int i52 = i32 * l2;
        int i57 = i52;
        final double d6 = Math.cos(i57);
        final double d7 = Math.sin(i57);
        final int i58 = i11 / isPositiveArc;
        final int i59 = i14 / obj64;
        final int i60 = i16 / isPositiveArc;
        final int i61 = i19 / obj64;
        final int i62 = i58 - i60;
        final int i63 = i59 - i61;
        double d4 = (double)i4;
        final int i64 = i20 / d4;
        final int i65 = i21 / d4;
        final int i66 = i22 + i37;
        cmp = 0;
        final int i42 = 0;
        i2 = Double.compare(i66, cmp) == 0 ? i : i42;
        if (i2 != 0) {
        }
        long l4 = 4598175219545276416L;
        final int i67 = i43 - l4;
        if (Double.compare(i67, cmp) < 0) {
            float f = (float)i23;
            final int i56 = obj69;
            float f2 = f;
            PathParserKt.drawArc(p, i7, obj2, x1, obj4, i28, obj6, theta, i42, isPositiveArc * d);
            int i5 = i56;
        }
        int i6 = obj69;
        double sqrt2 = Math.sqrt(i67);
        final int i68 = sqrt2 * i62;
        final int i69 = sqrt2 * i63;
        int i8 = 0;
        int i29 = 0;
        cy = obj68 == i6 ? i65 + i68 : i65 - i68;
        double atan2 = Math.atan2(i59 - cy, l4);
        sweep = atan22 - atan2;
        int cmp4 = Double.compare(sweep, cmp);
        if (cmp4 >= 0) {
        } else {
            i = i42;
        }
        if (i6 != i) {
            i = 4618760256179416344L;
            sweep = Double.compare(sweep, cmp) > 0 ? sweep - i : sweep + i;
        }
        cx *= isPositiveArc;
        cy *= obj64;
        PathParserKt.arcToBezier(p, i25 - i39, obj2, i26 += i40, obj4, isPositiveArc, obj6, obj64, i42, x0);
    }

    public static final float[] getEmptyArray() {
        return PathParserKt.EmptyArray;
    }

    public static final Path toPath(List<? extends androidx.compose.ui.graphics.vector.PathNode> $this$toPath, Path target) {
        int arcStartX;
        int reflectiveCtrlX2;
        int i9;
        int reflectiveCtrlX3;
        int reflectiveCtrlY;
        int dy2;
        int dy23;
        int dx2;
        int dy22;
        int fillType;
        int reflectiveCtrlX;
        int reflectiveCtrlY2;
        boolean previousNode3;
        Object iNSTANCE;
        int previousNode2;
        boolean z;
        int node2;
        int size;
        boolean moreThanHalf;
        boolean positiveArc2;
        int i3;
        int ctrlY;
        int i;
        int segmentY;
        int i5;
        int i7;
        Object previousNode;
        Object obj;
        int i2;
        int fillType2;
        boolean currentX;
        int arcStartX2;
        int i10;
        int i4;
        int i11;
        double d;
        boolean positiveArc;
        int i8;
        int i6;
        Object node;
        double d2;
        arcStartX = target;
        arcStartX.rewind();
        arcStartX.setFillType-oQ8Xj4U(arcStartX.getFillType-Rg-k1Os());
        int i28 = 0;
        if ($this$toPath.isEmpty()) {
            iNSTANCE = PathNode.Close.INSTANCE;
            z = $this$toPath;
        } else {
            iNSTANCE = $this$toPath.get(0);
        }
        final int i30 = 0;
        size = $this$toPath.size();
        i3 = dy2;
        ctrlY = dy23;
        i = dx2;
        segmentY = dy22;
        i5 = i26;
        i7 = i27;
        previousNode = iNSTANCE;
        previousNode2 = node2;
        reflectiveCtrlX = reflectiveCtrlX3;
        reflectiveCtrlY2 = reflectiveCtrlY;
        while (previousNode2 < size) {
            node2 = obj;
            i2 = 0;
            if (node2 instanceof PathNode.Close) {
            } else {
            }
            if (node2 instanceof PathNode.RelativeMoveTo) {
            } else {
            }
            if (node2 instanceof PathNode.MoveTo) {
            } else {
            }
            if (node2 instanceof PathNode.RelativeLineTo) {
            } else {
            }
            if (node2 instanceof PathNode.LineTo) {
            } else {
            }
            reflectiveCtrlY = 0;
            if (node2 instanceof PathNode.RelativeHorizontalTo) {
            } else {
            }
            if (node2 instanceof PathNode.HorizontalTo) {
            } else {
            }
            if (node2 instanceof PathNode.RelativeVerticalTo) {
            } else {
            }
            if (node2 instanceof PathNode.VerticalTo) {
            } else {
            }
            if (node2 instanceof PathNode.RelativeCurveTo) {
            } else {
            }
            if (node2 instanceof PathNode.CurveTo) {
            } else {
            }
            if (node2 instanceof PathNode.RelativeReflectiveCurveTo) {
            } else {
            }
            int i19 = 2;
            if (node2 instanceof PathNode.ReflectiveCurveTo) {
            } else {
            }
            arcStartX = target;
            if (node2 instanceof PathNode.RelativeQuadTo) {
            } else {
            }
            if (node2 instanceof PathNode.QuadTo) {
            } else {
            }
            if (node2 instanceof PathNode.RelativeReflectiveQuadTo) {
            } else {
            }
            if (node2 instanceof PathNode.ReflectiveQuadTo) {
            } else {
            }
            if (node2 instanceof PathNode.RelativeArcTo) {
            } else {
            }
            fillType2 = fillType;
            i6 = reflectiveCtrlX;
            i8 = reflectiveCtrlY2;
            currentX = previousNode3;
            i10 = previousNode2;
            arcStartX2 = size;
            arcStartX = obj102;
            if (arcStartX instanceof PathNode.ArcTo) {
            } else {
            }
            node = arcStartX;
            reflectiveCtrlY2 = i8;
            reflectiveCtrlX = i6;
            previousNode = node;
            previousNode2 = i10 + 1;
            z = $this$toPath;
            arcStartX = target;
            fillType = fillType2;
            previousNode3 = currentX;
            size = arcStartX2;
            double d8 = (double)i21;
            dy23 = i8;
            node = arcStartX;
            PathParserKt.drawArc(target, d8, d8, (double)dy23, dy23, (double)arcStartX3, dy22, (double)arcStartY, reflectiveCtrlX, (double)horizontalEllipseRadius2);
            arcStartX = (PathNode.ArcTo)node.getArcStartX();
            reflectiveCtrlX3 = (PathNode.ArcTo)node.getArcStartY();
            reflectiveCtrlX = arcStartX;
            reflectiveCtrlY2 = reflectiveCtrlX3;
            i3 = reflectiveCtrlY;
            ctrlY = dy2;
            arcStartDx += reflectiveCtrlX;
            arcStartDy += reflectiveCtrlY2;
            fillType2 = fillType;
            i8 = reflectiveCtrlY2;
            node = node2;
            i6 = i31;
            currentX = previousNode3;
            arcStartX2 = size;
            i10 = previousNode2;
            PathParserKt.drawArc(target, (double)reflectiveCtrlX, i25, (double)reflectiveCtrlY2, dy23, (double)i22, dy22, (double)i25, reflectiveCtrlX, (double)horizontalEllipseRadius);
            arcStartX = i4;
            reflectiveCtrlX3 = i11;
            reflectiveCtrlX = arcStartX;
            reflectiveCtrlY2 = reflectiveCtrlX3;
            i3 = reflectiveCtrlY;
            ctrlY = dy2;
            if (previousNode.isQuad()) {
            } else {
            }
            reflectiveCtrlY = reflectiveCtrlX;
            reflectiveCtrlX3 = reflectiveCtrlY2;
            arcStartX.quadraticTo(reflectiveCtrlY, reflectiveCtrlX3, (PathNode.ReflectiveQuadTo)node2.getX(), (PathNode.ReflectiveQuadTo)node2.getY());
            i7 = reflectiveCtrlX3;
            i5 = reflectiveCtrlY;
            i3 = dy2;
            ctrlY = dy23;
            reflectiveCtrlX = dx2;
            reflectiveCtrlY2 = dy22;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            float f3 = (float)i19;
            i24 -= i3;
            i20 -= ctrlY;
            if (previousNode.isQuad()) {
            } else {
            }
            reflectiveCtrlX3 = 0;
            reflectiveCtrlY = 0;
            arcStartX.relativeQuadraticTo(reflectiveCtrlX3, reflectiveCtrlY, (PathNode.RelativeReflectiveQuadTo)node2.getDx(), (PathNode.RelativeReflectiveQuadTo)node2.getDy());
            reflectiveCtrlX += dx8;
            reflectiveCtrlY2 += dx2;
            i5 = reflectiveCtrlX3;
            i7 = reflectiveCtrlY;
            i3 = dy2;
            ctrlY = dy23;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            reflectiveCtrlX3 = reflectiveCtrlX - i3;
            reflectiveCtrlY = reflectiveCtrlY2 - ctrlY;
            arcStartX.quadraticTo((PathNode.QuadTo)node2.getX1(), (PathNode.QuadTo)node2.getY1(), (PathNode.QuadTo)node2.getX2(), (PathNode.QuadTo)node2.getY2());
            i3 = reflectiveCtrlX3;
            ctrlY = reflectiveCtrlY;
            reflectiveCtrlX = dy2;
            reflectiveCtrlY2 = dy23;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            arcStartX.relativeQuadraticTo((PathNode.RelativeQuadTo)node2.getDx1(), (PathNode.RelativeQuadTo)node2.getDy1(), (PathNode.RelativeQuadTo)node2.getDx2(), (PathNode.RelativeQuadTo)node2.getDy2());
            reflectiveCtrlX += dx24;
            reflectiveCtrlY2 += dy2;
            i3 = reflectiveCtrlX3;
            ctrlY = reflectiveCtrlY;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            if (previousNode.isCurve()) {
            } else {
            }
            reflectiveCtrlX3 = reflectiveCtrlX;
            reflectiveCtrlY = i9;
            target.cubicTo(reflectiveCtrlX3, reflectiveCtrlY, (PathNode.ReflectiveCurveTo)node2.getX1(), (PathNode.ReflectiveCurveTo)node2.getY1(), (PathNode.ReflectiveCurveTo)node2.getX2(), (PathNode.ReflectiveCurveTo)node2.getY2());
            i5 = reflectiveCtrlX3;
            i7 = reflectiveCtrlY;
            i3 = dy2;
            ctrlY = dy23;
            reflectiveCtrlX = dx2;
            reflectiveCtrlY2 = dy22;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            float f = (float)i19;
            i23 -= i3;
            reflectiveCtrlY = i9;
            if (previousNode.isCurve()) {
            } else {
            }
            reflectiveCtrlY = i17;
            reflectiveCtrlX3 = reflectiveCtrlX2;
            target.relativeCubicTo(reflectiveCtrlX3, reflectiveCtrlY, (PathNode.RelativeReflectiveCurveTo)node2.getDx1(), (PathNode.RelativeReflectiveCurveTo)node2.getDy1(), (PathNode.RelativeReflectiveCurveTo)node2.getDx2(), (PathNode.RelativeReflectiveCurveTo)node2.getDy2());
            reflectiveCtrlX += dx25;
            reflectiveCtrlY2 += dy23;
            i3 = arcStartX;
            i5 = reflectiveCtrlX3;
            i7 = reflectiveCtrlY;
            ctrlY = dy2;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            reflectiveCtrlY = i18;
            reflectiveCtrlX3 = reflectiveCtrlX2;
            target.cubicTo((PathNode.CurveTo)node2.getX1(), (PathNode.CurveTo)node2.getY1(), (PathNode.CurveTo)node2.getX2(), (PathNode.CurveTo)node2.getY2(), (PathNode.CurveTo)node2.getX3(), (PathNode.CurveTo)node2.getY3());
            i3 = arcStartX;
            ctrlY = reflectiveCtrlX3;
            reflectiveCtrlX = reflectiveCtrlY;
            reflectiveCtrlY2 = dy2;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            arcStartX.relativeCubicTo((PathNode.RelativeCurveTo)node2.getDx1(), (PathNode.RelativeCurveTo)node2.getDy1(), (PathNode.RelativeCurveTo)node2.getDx2(), (PathNode.RelativeCurveTo)node2.getDy2(), (PathNode.RelativeCurveTo)node2.getDx3(), (PathNode.RelativeCurveTo)node2.getDy3());
            reflectiveCtrlX += dx32;
            reflectiveCtrlY2 += reflectiveCtrlY;
            i3 = arcStartX;
            ctrlY = reflectiveCtrlX3;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            arcStartX.lineTo(reflectiveCtrlX, (PathNode.VerticalTo)node2.getY());
            reflectiveCtrlY2 = reflectiveCtrlX3;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            arcStartX.relativeLineTo(reflectiveCtrlY, (PathNode.RelativeVerticalTo)node2.getDy());
            reflectiveCtrlY2 += reflectiveCtrlX3;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            arcStartX.lineTo((PathNode.HorizontalTo)node2.getX(), reflectiveCtrlY2);
            reflectiveCtrlX = reflectiveCtrlX3;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            arcStartX.relativeLineTo((PathNode.RelativeHorizontalTo)node2.getDx(), reflectiveCtrlY);
            reflectiveCtrlX += reflectiveCtrlX3;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            arcStartX.lineTo((PathNode.LineTo)node2.getX(), (PathNode.LineTo)node2.getY());
            reflectiveCtrlX = reflectiveCtrlX3;
            reflectiveCtrlY2 = reflectiveCtrlY;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            arcStartX.relativeLineTo((PathNode.RelativeLineTo)node2.getDx(), (PathNode.RelativeLineTo)node2.getDy());
            reflectiveCtrlX += dx3;
            reflectiveCtrlY2 += reflectiveCtrlX3;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            reflectiveCtrlX3 = (PathNode.MoveTo)node2.getX();
            reflectiveCtrlY = (PathNode.MoveTo)node2.getY();
            arcStartX.moveTo((PathNode.MoveTo)node2.getX(), (PathNode.MoveTo)node2.getY());
            reflectiveCtrlX = reflectiveCtrlX3;
            reflectiveCtrlY2 = reflectiveCtrlY;
            i = dy2;
            segmentY = dy23;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            arcStartX.relativeMoveTo((PathNode.RelativeMoveTo)node2.getDx(), (PathNode.RelativeMoveTo)node2.getDy());
            i = reflectiveCtrlX3;
            segmentY = reflectiveCtrlY;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
            arcStartX.close();
            reflectiveCtrlX = reflectiveCtrlX3;
            reflectiveCtrlY2 = reflectiveCtrlY;
            i3 = dy2;
            ctrlY = dy23;
            fillType2 = fillType;
            currentX = previousNode3;
            i10 = previousNode2;
            node = node2;
            arcStartX2 = size;
        }
        return target;
    }

    public static Path toPath$default(List list, Path path2, int i3, Object object4) {
        Path obj1;
        if (i3 &= 1 != 0) {
            obj1 = AndroidPath_androidKt.Path();
        }
        return PathParserKt.toPath(list, obj1);
    }

    private static final double toRadians(double $this$toRadians) {
        final int i = 0;
        return i3 *= l;
    }
}
