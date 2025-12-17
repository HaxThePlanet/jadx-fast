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
        float f6;
        int anglePerSegment;
        int eta1y;
        double d7;
        int i8;
        int i5;
        long l;
        double d2;
        float f8;
        int eta1x;
        int ep1x;
        int ep1y;
        int i10;
        double d3;
        double d;
        double d5;
        int i9;
        int i;
        int eta1y2;
        int i2;
        int i7;
        double d6;
        int i6;
        int i3;
        int i4;
        double d4;
        Object obj;
        float f2;
        float f;
        float f7;
        float f4;
        float f3;
        float f5;
        eta1 = e1x;
        eta1y = obj73;
        l = 4614256656552045848L;
        i5 = obj77;
        d2 = Math.cos(obj75);
        final double d13 = Math.sin(obj75);
        final double d14 = Math.cos(i5);
        final double d15 = Math.sin(i5);
        eta1x = i16;
        ep1x = i19;
        ep1y = i22;
        anglePerSegment = i39;
        while (anglePerSegment < i8) {
            i10 = i5 + i40;
            d3 = Math.sin(i10);
            d = Math.cos(i10);
            int i24 = i43 - i48;
            eta1y = i46 + i50;
            d5 = d7;
            i9 = i29;
            double d9 = Math.tan(i56 /= d8);
            d6 = d9;
            i59 /= d11;
            i13 += eta1x;
            i6 = i32;
            i4 = i5;
            i7 = i14;
            p.cubicTo((float)i14, (float)ep2y, (float)numSegments, (float)l, (float)i24, (float)eta1y);
            eta1x = i24;
            eta1y2 = eta1y;
            ep1x = i9;
            ep1y = i6;
            anglePerSegment = i + 1;
            i5 = i15;
            d7 = d5;
            i8 = i3;
            d2 = d4;
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
        int arcStartX2;
        int reflectiveCtrlX2;
        int i2;
        int reflectiveCtrlX;
        int reflectiveCtrlY2;
        int dy23;
        int dy2;
        int dx2;
        int dy22;
        int fillType;
        int reflectiveCtrlX3;
        int reflectiveCtrlY;
        boolean previousNode;
        Object iNSTANCE;
        int previousNode3;
        boolean z;
        int node2;
        int size;
        boolean moreThanHalf;
        boolean positiveArc;
        int i11;
        int ctrlY;
        int i10;
        int segmentY;
        int i3;
        int i9;
        Object previousNode2;
        Object obj;
        int i;
        int fillType2;
        boolean currentX;
        int arcStartX;
        int i4;
        int i5;
        int i6;
        double d;
        boolean positiveArc2;
        int i7;
        int i8;
        Object node;
        double d2;
        arcStartX2 = target;
        arcStartX2.rewind();
        arcStartX2.setFillType-oQ8Xj4U(arcStartX2.getFillType-Rg-k1Os());
        int i28 = 0;
        if ($this$toPath.isEmpty()) {
            iNSTANCE = PathNode.Close.INSTANCE;
            z = $this$toPath;
        } else {
            iNSTANCE = $this$toPath.get(0);
        }
        final int i30 = 0;
        size = $this$toPath.size();
        i11 = dy23;
        ctrlY = dy2;
        i10 = dx2;
        segmentY = dy22;
        i3 = i26;
        i9 = i27;
        previousNode2 = iNSTANCE;
        previousNode3 = node2;
        reflectiveCtrlX3 = reflectiveCtrlX;
        reflectiveCtrlY = reflectiveCtrlY2;
        while (previousNode3 < size) {
            node2 = obj;
            i = 0;
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
            reflectiveCtrlY2 = 0;
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
            arcStartX2 = target;
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
            i8 = reflectiveCtrlX3;
            i7 = reflectiveCtrlY;
            currentX = previousNode;
            i4 = previousNode3;
            arcStartX = size;
            arcStartX2 = obj102;
            if (arcStartX2 instanceof PathNode.ArcTo) {
            } else {
            }
            node = arcStartX2;
            reflectiveCtrlY = i7;
            reflectiveCtrlX3 = i8;
            previousNode2 = node;
            previousNode3 = i4 + 1;
            z = $this$toPath;
            arcStartX2 = target;
            fillType = fillType2;
            previousNode = currentX;
            size = arcStartX;
            double d8 = (double)i21;
            dy2 = i7;
            node = arcStartX2;
            PathParserKt.drawArc(target, d8, d8, (double)dy2, dy2, (double)arcStartX3, dy22, (double)arcStartY, reflectiveCtrlX3, (double)horizontalEllipseRadius2);
            arcStartX2 = (PathNode.ArcTo)node.getArcStartX();
            reflectiveCtrlX = (PathNode.ArcTo)node.getArcStartY();
            reflectiveCtrlX3 = arcStartX2;
            reflectiveCtrlY = reflectiveCtrlX;
            i11 = reflectiveCtrlY2;
            ctrlY = dy23;
            arcStartDx += reflectiveCtrlX3;
            arcStartDy += reflectiveCtrlY;
            fillType2 = fillType;
            i7 = reflectiveCtrlY;
            node = node2;
            i8 = i31;
            currentX = previousNode;
            arcStartX = size;
            i4 = previousNode3;
            PathParserKt.drawArc(target, (double)reflectiveCtrlX3, i25, (double)reflectiveCtrlY, dy2, (double)i22, dy22, (double)i25, reflectiveCtrlX3, (double)horizontalEllipseRadius);
            arcStartX2 = i5;
            reflectiveCtrlX = i6;
            reflectiveCtrlX3 = arcStartX2;
            reflectiveCtrlY = reflectiveCtrlX;
            i11 = reflectiveCtrlY2;
            ctrlY = dy23;
            if (previousNode2.isQuad()) {
            } else {
            }
            reflectiveCtrlY2 = reflectiveCtrlX3;
            reflectiveCtrlX = reflectiveCtrlY;
            arcStartX2.quadraticTo(reflectiveCtrlY2, reflectiveCtrlX, (PathNode.ReflectiveQuadTo)node2.getX(), (PathNode.ReflectiveQuadTo)node2.getY());
            i9 = reflectiveCtrlX;
            i3 = reflectiveCtrlY2;
            i11 = dy23;
            ctrlY = dy2;
            reflectiveCtrlX3 = dx2;
            reflectiveCtrlY = dy22;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            float f3 = (float)i19;
            i24 -= i11;
            i20 -= ctrlY;
            if (previousNode2.isQuad()) {
            } else {
            }
            reflectiveCtrlX = 0;
            reflectiveCtrlY2 = 0;
            arcStartX2.relativeQuadraticTo(reflectiveCtrlX, reflectiveCtrlY2, (PathNode.RelativeReflectiveQuadTo)node2.getDx(), (PathNode.RelativeReflectiveQuadTo)node2.getDy());
            reflectiveCtrlX3 += dx8;
            reflectiveCtrlY += dx2;
            i3 = reflectiveCtrlX;
            i9 = reflectiveCtrlY2;
            i11 = dy23;
            ctrlY = dy2;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            reflectiveCtrlX = reflectiveCtrlX3 - i11;
            reflectiveCtrlY2 = reflectiveCtrlY - ctrlY;
            arcStartX2.quadraticTo((PathNode.QuadTo)node2.getX1(), (PathNode.QuadTo)node2.getY1(), (PathNode.QuadTo)node2.getX2(), (PathNode.QuadTo)node2.getY2());
            i11 = reflectiveCtrlX;
            ctrlY = reflectiveCtrlY2;
            reflectiveCtrlX3 = dy23;
            reflectiveCtrlY = dy2;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            arcStartX2.relativeQuadraticTo((PathNode.RelativeQuadTo)node2.getDx1(), (PathNode.RelativeQuadTo)node2.getDy1(), (PathNode.RelativeQuadTo)node2.getDx2(), (PathNode.RelativeQuadTo)node2.getDy2());
            reflectiveCtrlX3 += dx24;
            reflectiveCtrlY += dy23;
            i11 = reflectiveCtrlX;
            ctrlY = reflectiveCtrlY2;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            if (previousNode2.isCurve()) {
            } else {
            }
            reflectiveCtrlX = reflectiveCtrlX3;
            reflectiveCtrlY2 = i2;
            target.cubicTo(reflectiveCtrlX, reflectiveCtrlY2, (PathNode.ReflectiveCurveTo)node2.getX1(), (PathNode.ReflectiveCurveTo)node2.getY1(), (PathNode.ReflectiveCurveTo)node2.getX2(), (PathNode.ReflectiveCurveTo)node2.getY2());
            i3 = reflectiveCtrlX;
            i9 = reflectiveCtrlY2;
            i11 = dy23;
            ctrlY = dy2;
            reflectiveCtrlX3 = dx2;
            reflectiveCtrlY = dy22;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            float f = (float)i19;
            i23 -= i11;
            reflectiveCtrlY2 = i2;
            if (previousNode2.isCurve()) {
            } else {
            }
            reflectiveCtrlY2 = i17;
            reflectiveCtrlX = reflectiveCtrlX2;
            target.relativeCubicTo(reflectiveCtrlX, reflectiveCtrlY2, (PathNode.RelativeReflectiveCurveTo)node2.getDx1(), (PathNode.RelativeReflectiveCurveTo)node2.getDy1(), (PathNode.RelativeReflectiveCurveTo)node2.getDx2(), (PathNode.RelativeReflectiveCurveTo)node2.getDy2());
            reflectiveCtrlX3 += dx25;
            reflectiveCtrlY += dy2;
            i11 = arcStartX2;
            i3 = reflectiveCtrlX;
            i9 = reflectiveCtrlY2;
            ctrlY = dy23;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            reflectiveCtrlY2 = i18;
            reflectiveCtrlX = reflectiveCtrlX2;
            target.cubicTo((PathNode.CurveTo)node2.getX1(), (PathNode.CurveTo)node2.getY1(), (PathNode.CurveTo)node2.getX2(), (PathNode.CurveTo)node2.getY2(), (PathNode.CurveTo)node2.getX3(), (PathNode.CurveTo)node2.getY3());
            i11 = arcStartX2;
            ctrlY = reflectiveCtrlX;
            reflectiveCtrlX3 = reflectiveCtrlY2;
            reflectiveCtrlY = dy23;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            arcStartX2.relativeCubicTo((PathNode.RelativeCurveTo)node2.getDx1(), (PathNode.RelativeCurveTo)node2.getDy1(), (PathNode.RelativeCurveTo)node2.getDx2(), (PathNode.RelativeCurveTo)node2.getDy2(), (PathNode.RelativeCurveTo)node2.getDx3(), (PathNode.RelativeCurveTo)node2.getDy3());
            reflectiveCtrlX3 += dx32;
            reflectiveCtrlY += reflectiveCtrlY2;
            i11 = arcStartX2;
            ctrlY = reflectiveCtrlX;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            arcStartX2.lineTo(reflectiveCtrlX3, (PathNode.VerticalTo)node2.getY());
            reflectiveCtrlY = reflectiveCtrlX;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            arcStartX2.relativeLineTo(reflectiveCtrlY2, (PathNode.RelativeVerticalTo)node2.getDy());
            reflectiveCtrlY += reflectiveCtrlX;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            arcStartX2.lineTo((PathNode.HorizontalTo)node2.getX(), reflectiveCtrlY);
            reflectiveCtrlX3 = reflectiveCtrlX;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            arcStartX2.relativeLineTo((PathNode.RelativeHorizontalTo)node2.getDx(), reflectiveCtrlY2);
            reflectiveCtrlX3 += reflectiveCtrlX;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            arcStartX2.lineTo((PathNode.LineTo)node2.getX(), (PathNode.LineTo)node2.getY());
            reflectiveCtrlX3 = reflectiveCtrlX;
            reflectiveCtrlY = reflectiveCtrlY2;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            arcStartX2.relativeLineTo((PathNode.RelativeLineTo)node2.getDx(), (PathNode.RelativeLineTo)node2.getDy());
            reflectiveCtrlX3 += dx3;
            reflectiveCtrlY += reflectiveCtrlX;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            reflectiveCtrlX = (PathNode.MoveTo)node2.getX();
            reflectiveCtrlY2 = (PathNode.MoveTo)node2.getY();
            arcStartX2.moveTo((PathNode.MoveTo)node2.getX(), (PathNode.MoveTo)node2.getY());
            reflectiveCtrlX3 = reflectiveCtrlX;
            reflectiveCtrlY = reflectiveCtrlY2;
            i10 = dy23;
            segmentY = dy2;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            arcStartX2.relativeMoveTo((PathNode.RelativeMoveTo)node2.getDx(), (PathNode.RelativeMoveTo)node2.getDy());
            i10 = reflectiveCtrlX;
            segmentY = reflectiveCtrlY2;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
            arcStartX2.close();
            reflectiveCtrlX3 = reflectiveCtrlX;
            reflectiveCtrlY = reflectiveCtrlY2;
            i11 = dy23;
            ctrlY = dy2;
            fillType2 = fillType;
            currentX = previousNode;
            i4 = previousNode3;
            node = node2;
            arcStartX = size;
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
