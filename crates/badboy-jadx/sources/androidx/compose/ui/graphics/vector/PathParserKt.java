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
        float f;
        int anglePerSegment;
        int eta1y2;
        double d;
        int i3;
        int i;
        long l;
        double d2;
        float f2;
        int eta1x;
        int ep1x;
        int ep1y;
        int i8;
        double d4;
        double d3;
        double d5;
        int i10;
        int i9;
        int eta1y;
        int i4;
        int i2;
        double d7;
        int i7;
        int i5;
        int i6;
        double d6;
        Object obj;
        float f8;
        float f6;
        float f4;
        float f7;
        float f5;
        float f3;
        eta1 = e1x;
        eta1y2 = obj73;
        l = 4614256656552045848L;
        i = obj77;
        d2 = Math.cos(obj75);
        final double d13 = Math.sin(obj75);
        final double d14 = Math.cos(i);
        final double d15 = Math.sin(i);
        eta1x = i16;
        ep1x = i19;
        ep1y = i22;
        anglePerSegment = i39;
        while (anglePerSegment < i3) {
            i8 = i + i40;
            d4 = Math.sin(i8);
            d3 = Math.cos(i8);
            int i24 = i43 - i48;
            eta1y2 = i46 + i50;
            d5 = d;
            i10 = i29;
            double d9 = Math.tan(i56 /= d8);
            d7 = d9;
            i59 /= d11;
            i13 += eta1x;
            i7 = i32;
            i6 = i;
            i2 = i14;
            p.cubicTo((float)i14, (float)ep2y, (float)numSegments, (float)l, (float)i24, (float)eta1y2);
            eta1x = i24;
            eta1y = eta1y2;
            ep1x = i10;
            ep1y = i7;
            anglePerSegment = i9 + 1;
            i = i15;
            d = d5;
            i3 = i5;
            d2 = d6;
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
        int reflectiveCtrlX;
        int i3;
        int reflectiveCtrlX2;
        int reflectiveCtrlY;
        int dy23;
        int dy2;
        int dx2;
        int dy22;
        int fillType2;
        int reflectiveCtrlX3;
        int reflectiveCtrlY2;
        boolean previousNode3;
        Object iNSTANCE;
        int previousNode2;
        boolean z;
        int node;
        int size;
        boolean moreThanHalf;
        boolean positiveArc2;
        int i10;
        int ctrlY;
        int i8;
        int segmentY;
        int i11;
        int i4;
        Object previousNode;
        Object obj;
        int i6;
        int fillType;
        boolean currentX;
        int arcStartX2;
        int i2;
        int i7;
        int i5;
        double d;
        boolean positiveArc;
        int i;
        int i9;
        Object node2;
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
        i10 = dy23;
        ctrlY = dy2;
        i8 = dx2;
        segmentY = dy22;
        i11 = i26;
        i4 = i27;
        previousNode = iNSTANCE;
        previousNode2 = node;
        reflectiveCtrlX3 = reflectiveCtrlX2;
        reflectiveCtrlY2 = reflectiveCtrlY;
        while (previousNode2 < size) {
            node = obj;
            i6 = 0;
            if (node instanceof PathNode.Close) {
            } else {
            }
            if (node instanceof PathNode.RelativeMoveTo) {
            } else {
            }
            if (node instanceof PathNode.MoveTo) {
            } else {
            }
            if (node instanceof PathNode.RelativeLineTo) {
            } else {
            }
            if (node instanceof PathNode.LineTo) {
            } else {
            }
            reflectiveCtrlY = 0;
            if (node instanceof PathNode.RelativeHorizontalTo) {
            } else {
            }
            if (node instanceof PathNode.HorizontalTo) {
            } else {
            }
            if (node instanceof PathNode.RelativeVerticalTo) {
            } else {
            }
            if (node instanceof PathNode.VerticalTo) {
            } else {
            }
            if (node instanceof PathNode.RelativeCurveTo) {
            } else {
            }
            if (node instanceof PathNode.CurveTo) {
            } else {
            }
            if (node instanceof PathNode.RelativeReflectiveCurveTo) {
            } else {
            }
            int i19 = 2;
            if (node instanceof PathNode.ReflectiveCurveTo) {
            } else {
            }
            arcStartX = target;
            if (node instanceof PathNode.RelativeQuadTo) {
            } else {
            }
            if (node instanceof PathNode.QuadTo) {
            } else {
            }
            if (node instanceof PathNode.RelativeReflectiveQuadTo) {
            } else {
            }
            if (node instanceof PathNode.ReflectiveQuadTo) {
            } else {
            }
            if (node instanceof PathNode.RelativeArcTo) {
            } else {
            }
            fillType = fillType2;
            i9 = reflectiveCtrlX3;
            i = reflectiveCtrlY2;
            currentX = previousNode3;
            i2 = previousNode2;
            arcStartX2 = size;
            arcStartX = obj102;
            if (arcStartX instanceof PathNode.ArcTo) {
            } else {
            }
            node2 = arcStartX;
            reflectiveCtrlY2 = i;
            reflectiveCtrlX3 = i9;
            previousNode = node2;
            previousNode2 = i2 + 1;
            z = $this$toPath;
            arcStartX = target;
            fillType2 = fillType;
            previousNode3 = currentX;
            size = arcStartX2;
            double d8 = (double)i21;
            dy2 = i;
            node2 = arcStartX;
            PathParserKt.drawArc(target, d8, d8, (double)dy2, dy2, (double)arcStartX3, dy22, (double)arcStartY, reflectiveCtrlX3, (double)horizontalEllipseRadius2);
            arcStartX = (PathNode.ArcTo)node2.getArcStartX();
            reflectiveCtrlX2 = (PathNode.ArcTo)node2.getArcStartY();
            reflectiveCtrlX3 = arcStartX;
            reflectiveCtrlY2 = reflectiveCtrlX2;
            i10 = reflectiveCtrlY;
            ctrlY = dy23;
            arcStartDx += reflectiveCtrlX3;
            arcStartDy += reflectiveCtrlY2;
            fillType = fillType2;
            i = reflectiveCtrlY2;
            node2 = node;
            i9 = i31;
            currentX = previousNode3;
            arcStartX2 = size;
            i2 = previousNode2;
            PathParserKt.drawArc(target, (double)reflectiveCtrlX3, i25, (double)reflectiveCtrlY2, dy2, (double)i22, dy22, (double)i25, reflectiveCtrlX3, (double)horizontalEllipseRadius);
            arcStartX = i7;
            reflectiveCtrlX2 = i5;
            reflectiveCtrlX3 = arcStartX;
            reflectiveCtrlY2 = reflectiveCtrlX2;
            i10 = reflectiveCtrlY;
            ctrlY = dy23;
            if (previousNode.isQuad()) {
            } else {
            }
            reflectiveCtrlY = reflectiveCtrlX3;
            reflectiveCtrlX2 = reflectiveCtrlY2;
            arcStartX.quadraticTo(reflectiveCtrlY, reflectiveCtrlX2, (PathNode.ReflectiveQuadTo)node.getX(), (PathNode.ReflectiveQuadTo)node.getY());
            i4 = reflectiveCtrlX2;
            i11 = reflectiveCtrlY;
            i10 = dy23;
            ctrlY = dy2;
            reflectiveCtrlX3 = dx2;
            reflectiveCtrlY2 = dy22;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            float f3 = (float)i19;
            i24 -= i10;
            i20 -= ctrlY;
            if (previousNode.isQuad()) {
            } else {
            }
            reflectiveCtrlX2 = 0;
            reflectiveCtrlY = 0;
            arcStartX.relativeQuadraticTo(reflectiveCtrlX2, reflectiveCtrlY, (PathNode.RelativeReflectiveQuadTo)node.getDx(), (PathNode.RelativeReflectiveQuadTo)node.getDy());
            reflectiveCtrlX3 += dx8;
            reflectiveCtrlY2 += dx2;
            i11 = reflectiveCtrlX2;
            i4 = reflectiveCtrlY;
            i10 = dy23;
            ctrlY = dy2;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            reflectiveCtrlX2 = reflectiveCtrlX3 - i10;
            reflectiveCtrlY = reflectiveCtrlY2 - ctrlY;
            arcStartX.quadraticTo((PathNode.QuadTo)node.getX1(), (PathNode.QuadTo)node.getY1(), (PathNode.QuadTo)node.getX2(), (PathNode.QuadTo)node.getY2());
            i10 = reflectiveCtrlX2;
            ctrlY = reflectiveCtrlY;
            reflectiveCtrlX3 = dy23;
            reflectiveCtrlY2 = dy2;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            arcStartX.relativeQuadraticTo((PathNode.RelativeQuadTo)node.getDx1(), (PathNode.RelativeQuadTo)node.getDy1(), (PathNode.RelativeQuadTo)node.getDx2(), (PathNode.RelativeQuadTo)node.getDy2());
            reflectiveCtrlX3 += dx24;
            reflectiveCtrlY2 += dy23;
            i10 = reflectiveCtrlX2;
            ctrlY = reflectiveCtrlY;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            if (previousNode.isCurve()) {
            } else {
            }
            reflectiveCtrlX2 = reflectiveCtrlX3;
            reflectiveCtrlY = i3;
            target.cubicTo(reflectiveCtrlX2, reflectiveCtrlY, (PathNode.ReflectiveCurveTo)node.getX1(), (PathNode.ReflectiveCurveTo)node.getY1(), (PathNode.ReflectiveCurveTo)node.getX2(), (PathNode.ReflectiveCurveTo)node.getY2());
            i11 = reflectiveCtrlX2;
            i4 = reflectiveCtrlY;
            i10 = dy23;
            ctrlY = dy2;
            reflectiveCtrlX3 = dx2;
            reflectiveCtrlY2 = dy22;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            float f = (float)i19;
            i23 -= i10;
            reflectiveCtrlY = i3;
            if (previousNode.isCurve()) {
            } else {
            }
            reflectiveCtrlY = i17;
            reflectiveCtrlX2 = reflectiveCtrlX;
            target.relativeCubicTo(reflectiveCtrlX2, reflectiveCtrlY, (PathNode.RelativeReflectiveCurveTo)node.getDx1(), (PathNode.RelativeReflectiveCurveTo)node.getDy1(), (PathNode.RelativeReflectiveCurveTo)node.getDx2(), (PathNode.RelativeReflectiveCurveTo)node.getDy2());
            reflectiveCtrlX3 += dx25;
            reflectiveCtrlY2 += dy2;
            i10 = arcStartX;
            i11 = reflectiveCtrlX2;
            i4 = reflectiveCtrlY;
            ctrlY = dy23;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            reflectiveCtrlY = i18;
            reflectiveCtrlX2 = reflectiveCtrlX;
            target.cubicTo((PathNode.CurveTo)node.getX1(), (PathNode.CurveTo)node.getY1(), (PathNode.CurveTo)node.getX2(), (PathNode.CurveTo)node.getY2(), (PathNode.CurveTo)node.getX3(), (PathNode.CurveTo)node.getY3());
            i10 = arcStartX;
            ctrlY = reflectiveCtrlX2;
            reflectiveCtrlX3 = reflectiveCtrlY;
            reflectiveCtrlY2 = dy23;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            arcStartX.relativeCubicTo((PathNode.RelativeCurveTo)node.getDx1(), (PathNode.RelativeCurveTo)node.getDy1(), (PathNode.RelativeCurveTo)node.getDx2(), (PathNode.RelativeCurveTo)node.getDy2(), (PathNode.RelativeCurveTo)node.getDx3(), (PathNode.RelativeCurveTo)node.getDy3());
            reflectiveCtrlX3 += dx32;
            reflectiveCtrlY2 += reflectiveCtrlY;
            i10 = arcStartX;
            ctrlY = reflectiveCtrlX2;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            arcStartX.lineTo(reflectiveCtrlX3, (PathNode.VerticalTo)node.getY());
            reflectiveCtrlY2 = reflectiveCtrlX2;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            arcStartX.relativeLineTo(reflectiveCtrlY, (PathNode.RelativeVerticalTo)node.getDy());
            reflectiveCtrlY2 += reflectiveCtrlX2;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            arcStartX.lineTo((PathNode.HorizontalTo)node.getX(), reflectiveCtrlY2);
            reflectiveCtrlX3 = reflectiveCtrlX2;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            arcStartX.relativeLineTo((PathNode.RelativeHorizontalTo)node.getDx(), reflectiveCtrlY);
            reflectiveCtrlX3 += reflectiveCtrlX2;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            arcStartX.lineTo((PathNode.LineTo)node.getX(), (PathNode.LineTo)node.getY());
            reflectiveCtrlX3 = reflectiveCtrlX2;
            reflectiveCtrlY2 = reflectiveCtrlY;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            arcStartX.relativeLineTo((PathNode.RelativeLineTo)node.getDx(), (PathNode.RelativeLineTo)node.getDy());
            reflectiveCtrlX3 += dx3;
            reflectiveCtrlY2 += reflectiveCtrlX2;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            reflectiveCtrlX2 = (PathNode.MoveTo)node.getX();
            reflectiveCtrlY = (PathNode.MoveTo)node.getY();
            arcStartX.moveTo((PathNode.MoveTo)node.getX(), (PathNode.MoveTo)node.getY());
            reflectiveCtrlX3 = reflectiveCtrlX2;
            reflectiveCtrlY2 = reflectiveCtrlY;
            i8 = dy23;
            segmentY = dy2;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            arcStartX.relativeMoveTo((PathNode.RelativeMoveTo)node.getDx(), (PathNode.RelativeMoveTo)node.getDy());
            i8 = reflectiveCtrlX2;
            segmentY = reflectiveCtrlY;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
            arcStartX2 = size;
            arcStartX.close();
            reflectiveCtrlX3 = reflectiveCtrlX2;
            reflectiveCtrlY2 = reflectiveCtrlY;
            i10 = dy23;
            ctrlY = dy2;
            fillType = fillType2;
            currentX = previousNode3;
            i2 = previousNode2;
            node2 = node;
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
