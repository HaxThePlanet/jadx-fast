package androidx.compose.ui.graphics;

import _COROUTINE.CoroutineDebuggingKt;
import androidx.collection.FloatFloatPair;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008&\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0010\u0002\n\u0002\u0008\t\u001a\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0082\u0008\u001a?\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001e\u001a'\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\u0010\u001e\u001aH\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0000\u001a \u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0002\u001a0\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018H\u0000\u001a \u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0007\u001a0\u00103\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a \u00109\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a(\u0010:\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010;\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010<\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0003H\u0007\u001a\u0018\u0010=\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\u0018H\u0002\u001a(\u0010?\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a(\u0010B\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0007\u001a\u0019\u0010C\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0082\u0008\u001a \u0010D\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0002\u001a\u0018\u0010E\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0003H\u0007\u001a+\u0010G\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001aH\u0082\u0008\u001a2\u0010H\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001aH\u0002\u001a \u0010I\u001a\u00020A2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0002\u001a \u0010J\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0000\u001a(\u0010K\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0002\u001a0\u0010M\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0018H\u0002\u001a\u0018\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0002\u001a0\u0010P\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018H\u0000\u001a0\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00182\u0006\u0010U\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u0003H\u0002\u001a \u0010W\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010X\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0002\u001a \u0010Y\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a\u0015\u0010Z\u001a\u00020A*\u00020\u00012\u0006\u0010[\u001a\u00020\u0001H\u0080\u0008\u001a\u0015\u0010Z\u001a\u00020A*\u00020\u00032\u0006\u0010[\u001a\u00020\u0003H\u0080\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0005\u001a\u00020\u0003*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008\"\u0018\u0010\t\u001a\u00020\u0003*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008\"\u0019\u0010\u000b\u001a\u00020\u0003*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0008\"\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0008¨\u0006\\", d2 = {"Epsilon", "", "FloatEpsilon", "", "Tau", "endX", "Landroidx/compose/ui/graphics/PathSegment;", "getEndX", "(Landroidx/compose/ui/graphics/PathSegment;)F", "endY", "getEndY", "startX", "getStartX", "startY", "getStartY", "clampValidRootInUnitRange", "r", "computeCubicVerticalBounds", "Landroidx/collection/FloatFloatPair;", "p0y", "p1y", "p2y", "p3y", "roots", "", "index", "", "(FFFF[FI)J", "computeHorizontalBounds", "segment", "(Landroidx/compose/ui/graphics/PathSegment;[FI)J", "computeVerticalBounds", "cubicArea", "x0", "y0", "x1", "y1", "x2", "y2", "x3", "y3", "cubicToMonotonicCubics", "cubic", "dst", "tmpRoot", "cubicWinding", "points", "x", "y", "tmpCubics", "tmpRoots", "evaluateCubic", "p1", "p2", "t", "p0", "p3", "evaluateLine", "evaluateQuadratic", "evaluateX", "evaluateY", "findCubicExtremaY", "dstRoots", "findDerivativeRoots", "horizontal", "", "findFirstCubicRoot", "findFirstLineRoot", "findFirstQuadraticRoot", "findFirstRoot", "fraction", "findLineRoot", "findQuadraticRoots", "isQuadraticMonotonic", "lineWinding", "monotonicCubicWinding", "offset", "monotonicQuadraticWinding", "quadraticToMonotonicQuadratics", "quadratic", "quadraticWinding", "tmpQuadratics", "splitCubicAt", "", "src", "srcOffset", "dstOffset", "splitQuadraticAt", "unitDivide", "writeValidRootInUnitRange", "closeTo", "b", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BezierKt {

    private static final double Epsilon = 0.0000001d;
    private static final float FloatEpsilon = 0.000000834465f;
    private static final double Tau = 6.283185307179586d;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal3;
            int ordinal2;
            int ordinal4;
            int ordinal5;
            int ordinal7;
            int ordinal6;
            int[] iArr = new int[values.length];
            iArr[PathSegment.Type.Move.ordinal()] = 1;
            iArr[PathSegment.Type.Line.ordinal()] = 2;
            iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            iArr[PathSegment.Type.Conic.ordinal()] = 4;
            iArr[PathSegment.Type.Cubic.ordinal()] = 5;
            iArr[PathSegment.Type.Close.ordinal()] = 6;
            iArr[PathSegment.Type.Done.ordinal()] = 7;
            BezierKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final int access$writeValidRootInUnitRange(float r, float[] roots, int index) {
        return BezierKt.writeValidRootInUnitRange(r, roots, index);
    }

    private static final float clampValidRootInUnitRange(float r) {
        int i;
        int cmp;
        final int i2 = 0;
        final int i5 = 2143289344;
        if (Float.compare(r, i) < 0) {
            if (Float.compare(r, i3) >= 0) {
            } else {
                i = i5;
            }
        } else {
            if (Float.compare(r, i) > 0) {
                if (Float.compare(r, i4) <= 0) {
                } else {
                    i = i5;
                }
            } else {
                i = r;
            }
        }
        return i;
    }

    public static final boolean closeTo(double $this$closeTo, double b) {
        int i;
        final int i2 = 0;
        i = Double.compare(d, l) < 0 ? 1 : 0;
        return i;
    }

    public static final boolean closeTo(float $this$closeTo, float b) {
        int i;
        final int i2 = 0;
        i = Float.compare(f, i4) < 0 ? 1 : 0;
        return i;
    }

    public static final long computeCubicVerticalBounds(float p0y, float p1y, float p2y, float p3y, float[] roots, int index) {
        float[] fArr;
        float minY;
        float maxY;
        int i2;
        int i;
        final int i3 = p0y;
        final int i4 = p1y;
        final int i5 = p2y;
        final int i6 = p3y;
        fArr = roots;
        final int i7 = index;
        int i10 = 1077936128;
        i8 *= i10;
        i11 *= i10;
        i13 *= i10;
        int quadraticRoots = BezierKt.findQuadraticRoots(i9, i12, i14, fArr, i7);
        int i17 = 1073741824;
        i15 *= i17;
        int i21 = 0;
        minY = Math.min(i3, i6);
        maxY = Math.max(i3, i6);
        i2 = 0;
        while (i2 < quadraticRoots += index$iv) {
            float evaluateCubic = BezierKt.evaluateCubic(i3, i4, i5, i6, fArr[i2]);
            minY = Math.min(minY, evaluateCubic);
            maxY = Math.max(maxY, evaluateCubic);
            i2++;
            fArr = roots;
        }
        return FloatFloatPair.constructor-impl(minY, maxY);
    }

    public static long computeCubicVerticalBounds$default(float f, float f2, float f3, float f4, float[] f5Arr5, int i6, int i7, Object object8) {
        int i;
        int obj11;
        i = i7 &= 32 != 0 ? obj11 : i6;
        return BezierKt.computeCubicVerticalBounds(f, f2, f3, f4, f5Arr5, i);
    }

    public static final long computeHorizontalBounds(androidx.compose.ui.graphics.PathSegment segment, float[] roots, int index) {
        float minX;
        float maxX;
        int i;
        int i2;
        float[] evaluateX;
        int i4 = 0;
        i2 = 0;
        minX = Math.min(segment.getPoints()[i2], BezierKt.getEndX(segment));
        int i5 = 0;
        maxX = Math.max(segment.getPoints()[i2], BezierKt.getEndX(segment));
        i = 0;
        while (i < BezierKt.findDerivativeRoots(segment, true, roots, index)) {
            evaluateX = BezierKt.evaluateX(segment, roots[i]);
            minX = Math.min(minX, evaluateX);
            maxX = Math.max(maxX, evaluateX);
            i++;
        }
        return FloatFloatPair.constructor-impl(minX, maxX);
    }

    public static long computeHorizontalBounds$default(androidx.compose.ui.graphics.PathSegment pathSegment, float[] f2Arr2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 4 != 0) {
            obj2 = 0;
        }
        return BezierKt.computeHorizontalBounds(pathSegment, f2Arr2, obj2);
    }

    public static final long computeVerticalBounds(androidx.compose.ui.graphics.PathSegment segment, float[] roots, int index) {
        float minY;
        float maxY;
        int i;
        int i2;
        float[] evaluateY;
        int i4 = 0;
        i2 = 1;
        minY = Math.min(segment.getPoints()[i2], BezierKt.getEndY(segment));
        int i5 = 0;
        maxY = Math.max(segment.getPoints()[i2], BezierKt.getEndY(segment));
        i = 0;
        while (i < BezierKt.findDerivativeRoots(segment, false, roots, index)) {
            evaluateY = BezierKt.evaluateY(segment, roots[i]);
            minY = Math.min(minY, evaluateY);
            maxY = Math.max(maxY, evaluateY);
            i++;
        }
        return FloatFloatPair.constructor-impl(minY, maxY);
    }

    public static long computeVerticalBounds$default(androidx.compose.ui.graphics.PathSegment pathSegment, float[] f2Arr2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 4 != 0) {
            obj2 = 0;
        }
        return BezierKt.computeVerticalBounds(pathSegment, f2Arr2, obj2);
    }

    public static final float cubicArea(float x0, float y0, float x1, float y1, float x2, float y2, float x3, float y3) {
        int i17 = 1077936128;
        return i8 /= i18;
    }

    private static final int cubicToMonotonicCubics(float[] cubic, float[] dst, float[] tmpRoot) {
        int lastT;
        int dstOffset;
        float[] src;
        int i2;
        float f;
        int i;
        int i3;
        int i4;
        int i5;
        int $this$fastCoerceAtMost$iv$iv;
        int i6;
        int cmp;
        final int cubicExtremaY = BezierKt.findCubicExtremaY(cubic, tmpRoot);
        if (cubicExtremaY == 0) {
            dstOffset = 0;
            ArraysKt.copyInto(cubic, dst, dstOffset, dstOffset, 8);
        } else {
            lastT = 0;
            dstOffset = 0;
            src = cubic;
            i2 = 0;
            while (i2 < cubicExtremaY) {
                i3 = 0;
                i4 = 1065353216;
                i5 = 0;
                int i10 = 0;
                if (Float.compare($this$fastCoerceAtMost$iv$iv, i3) < 0) {
                }
                i6 = 0;
                if (Float.compare($this$fastCoerceAtMost$iv$iv, i4) > 0) {
                }
                lastT = $this$fastCoerceAtMost$iv$iv;
                BezierKt.splitCubicAt(src, dstOffset, dst, dstOffset, $this$fastCoerceAtMost$iv$iv);
                src = dst;
                dstOffset += 6;
                i2++;
                $this$fastCoerceAtMost$iv$iv = i4;
                $this$fastCoerceAtMost$iv$iv = i3;
            }
        }
        return cubicExtremaY;
    }

    public static final int cubicWinding(float[] points, float x, float y, float[] tmpCubics, float[] tmpRoots) {
        int winding;
        int i;
        int monotonicCubicWinding;
        final int cubicToMonotonicCubics = BezierKt.cubicToMonotonicCubics(points, tmpCubics, tmpRoots);
        winding = 0;
        if (0 <= cubicToMonotonicCubics) {
        }
        return winding;
    }

    public static final float evaluateCubic(float p1, float p2, float t) {
        return i12 *= t;
    }

    private static final float evaluateCubic(float p0, float p1, float p2, float p3, float t) {
        int i5 = 1077936128;
        return i10 += p0;
    }

    private static final float evaluateLine(float p0y, float p1y, float t) {
        return i2 += p0y;
    }

    private static final float evaluateQuadratic(float p0, float p1, float p2, float t) {
        int i3 = 1073741824;
        return i9 += p0;
    }

    private static final float evaluateX(androidx.compose.ui.graphics.PathSegment segment, float t) {
        float i3;
        float i;
        float evaluateQuadratic;
        int i2;
        final float[] points2 = segment.getPoints();
        i = 4;
        evaluateQuadratic = 2143289344;
        i2 = 2;
        final int i5 = 0;
        switch (i3) {
            case 1:
                evaluateQuadratic = points2[i5];
                break;
            case 2:
                evaluateQuadratic = BezierKt.evaluateLine(points2[i5], points2[i2], t);
                break;
            case 3:
                evaluateQuadratic = BezierKt.evaluateQuadratic(points2[i5], points2[i2], points2[i], t);
                break;
            case 4:
                break;
            case 5:
                evaluateQuadratic = BezierKt.evaluateCubic(points2[i5], points2[i2], points2[i], points2[6], t);
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return evaluateQuadratic;
    }

    public static final float evaluateY(androidx.compose.ui.graphics.PathSegment segment, float t) {
        float i2;
        float i;
        float evaluateQuadratic;
        int i3;
        final float[] points2 = segment.getPoints();
        i = 5;
        evaluateQuadratic = 2143289344;
        i3 = 3;
        final int i5 = 1;
        switch (i2) {
            case 1:
                evaluateQuadratic = points2[i5];
                break;
            case 2:
                evaluateQuadratic = BezierKt.evaluateLine(points2[i5], points2[i3], t);
                break;
            case 3:
                evaluateQuadratic = BezierKt.evaluateQuadratic(points2[i5], points2[i3], points2[i], t);
                break;
            case 4:
                break;
            case 5:
                evaluateQuadratic = BezierKt.evaluateCubic(points2[i5], points2[i3], points2[i], points2[7], t);
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return evaluateQuadratic;
    }

    private static final int findCubicExtremaY(float[] cubic, float[] dstRoots) {
        int i2 = cubic[1];
        int i4 = cubic[3];
        int i6 = cubic[5];
        return BezierKt.findQuadraticRoots(i9 += i17, i14 *= i18, i4 - i2, dstRoots, 0);
    }

    private static final int findDerivativeRoots(androidx.compose.ui.graphics.PathSegment segment, boolean horizontal, float[] roots, int index) {
        int i7;
        int d0;
        int i;
        int i2;
        int i4;
        int index$iv;
        int i6;
        int i5;
        int i3;
        int i8;
        final int i9 = horizontal ^ 1;
        final float[] points = segment.getPoints();
        d0 = 0;
        switch (i7) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                float f = (float)i10;
                i14 *= f;
                i = 0;
                d0 = BezierKt.access$writeValidRootInUnitRange(i24 /= i4, roots, index);
                break;
            case 4:
                break;
            case 5:
                int i17 = 1077936128;
                i12 *= i17;
                i22 *= i17;
                i27 *= i17;
                int quadraticRoots = BezierKt.findQuadraticRoots(i7, i, i2, roots, index);
                int i30 = 1073741824;
                i29 *= i30;
                i5 = 0;
                quadraticRoots += index$iv;
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return d0;
    }

    public static final float findFirstCubicRoot(float p0, float p1, float p2, float p3) {
        int b$iv;
        int $i$f$closeTo;
        int cmp;
        int i4;
        int i3;
        int cmp6;
        int cmp4;
        float i5;
        int cmp5;
        int cmp2;
        int cmp3;
        int i2;
        int i;
        int i6;
        int $this$fastCoerceAtMost$iv$iv;
        int i7 = p0;
        final int i9 = p1;
        int i10 = p2;
        long l2 = 4611686018427387904L;
        long l = 4613937818241073152L;
        i13 *= l;
        d8 *= l;
        double d10 = (double)i7;
        long l3 = l;
        long l5 = l2;
        i69 += d7;
        long l7 = 4502148214488346440L;
        i2 = 1;
        final int i91 = 0;
        b$iv = Double.compare(d13, l7) < 0 ? i2 : i91;
        i5 = 1065353216;
        int i87 = 0;
        final int i88 = 2143289344;
        if (b$iv != 0) {
            int i35 = 0;
            $i$f$closeTo = Double.compare(d17, l7) < 0 ? i2 : i91;
            if ($i$f$closeTo != 0) {
                int i41 = 0;
                if (Double.compare(d15, l7) < 0) {
                } else {
                    i2 = i91;
                }
                if (i2 != 0) {
                    return i88;
                }
                float f8 = (float)i47;
                int i56 = 0;
                if (Float.compare(f8, i87) < 0) {
                    i5 = Float.compare(f8, i94) >= 0 ? i87 : i88;
                } else {
                    if (Float.compare(f8, i5) > 0) {
                        if (Float.compare(f8, cmp) <= 0) {
                        } else {
                            i5 = i88;
                        }
                    } else {
                        i5 = f8;
                    }
                }
                return i5;
            }
            int i93 = -1251999744;
            double sqrt3 = Math.sqrt(i42 -= i74);
            int i75 = i14 * l5;
            int i96 = i36;
            float f6 = (float)i37;
            int i44 = 0;
            if (Float.compare(f6, i87) < 0) {
                i4 = Float.compare(f6, i93) >= 0 ? i87 : i88;
            } else {
                if (Float.compare(f6, i5) > 0) {
                    i4 = Float.compare(f6, i96) <= 0 ? i5 : i88;
                } else {
                    i4 = f6;
                }
            }
            if (!Float.isNaN(i4)) {
                return i4;
            }
            float f7 = (float)i40;
            int i45 = 0;
            if (Float.compare(f7, i87) < 0) {
                i5 = Float.compare(f7, i93) >= 0 ? i87 : i88;
            } else {
                if (Float.compare(f7, i5) > 0) {
                    if (Float.compare(f7, i96) <= 0) {
                    } else {
                        i5 = i88;
                    }
                } else {
                    i5 = f7;
                }
            }
            return i5;
        }
        int i92 = -1251999744;
        int i95 = 1065353223;
        i14 /= i70;
        i58 /= i70;
        d10 /= i70;
        long l8 = 4621256167635550208L;
        i33 /= l8;
        int i8 = i81 / l10;
        i82 += i102;
        int i11 = i103 / l3;
        int i106 = 0;
        int i108 = b;
        double sqrt = Math.sqrt(-i49);
        int i109 = c;
        long l6 = -4616189618054758400L;
        long l11 = 4607182418800017408L;
        int i118 = 0;
        if (Double.compare(i83, i106) < 0 && Double.compare($this$fastCoerceAtMost$iv$iv, l6) < 0) {
            i108 = b;
            sqrt = Math.sqrt(-i49);
            i109 = c;
            l6 = -4616189618054758400L;
            l11 = 4607182418800017408L;
            i118 = 0;
            if (Double.compare($this$fastCoerceAtMost$iv$iv, l6) < 0) {
                $this$fastCoerceAtMost$iv$iv = l6;
            }
            int i119 = 0;
            int cmp33 = Double.compare($this$fastCoerceAtMost$iv$iv, l11);
            if (cmp33 > 0) {
                $this$fastCoerceAtMost$iv$iv = l11;
            }
            double acos = Math.acos($this$fastCoerceAtMost$iv$iv);
            fastCbrt4 *= i112;
            double d16 = sqrt;
            float f = (float)i17;
            int i25 = 0;
            if (Float.compare(f, i87) < 0) {
                i = Float.compare(f, i92) >= 0 ? i87 : i88;
            } else {
                if (Float.compare(f, i5) > 0) {
                    i = Float.compare(f, i95) <= 0 ? i5 : i88;
                } else {
                    i = f;
                }
            }
            if (!Float.isNaN(i)) {
                return i;
            }
            float f2 = (float)i19;
            int i26 = 0;
            if (Float.compare(f2, i87) < 0) {
                i6 = Float.compare(f2, i92) >= 0 ? i87 : i88;
            } else {
                if (Float.compare(f2, i5) > 0) {
                    i6 = Float.compare(f2, i95) <= 0 ? i5 : i88;
                } else {
                    i6 = f2;
                }
            }
            if (!Float.isNaN(i6)) {
                return i6;
            }
            float f3 = (float)i21;
            int i27 = 0;
            if (Float.compare(f3, i87) < 0) {
                i5 = Float.compare(f3, i92) >= 0 ? i87 : i88;
            } else {
                if (Float.compare(f3, i5) > 0) {
                    if (Float.compare(f3, i95) <= 0) {
                    } else {
                        i5 = i88;
                    }
                } else {
                    i5 = f3;
                }
            }
            return i5;
        }
        int b2 = b;
        int i110 = c;
        if (Double.compare(i83, i106) == 0) {
        } else {
            i2 = i91;
        }
        if (i2 != 0) {
            int i22 = -fastCbrt;
            i51 -= f5;
            int i28 = 0;
            if (Float.compare(i52, i87) < 0) {
                i3 = Float.compare(i52, i92) >= 0 ? i87 : i88;
            } else {
                if (Float.compare(i52, i5) > 0) {
                    i3 = Float.compare(i52, i95) <= 0 ? i5 : i88;
                } else {
                    i3 = i52;
                }
            }
            if (!Float.isNaN(i3)) {
                return i3;
            }
            i29 -= f9;
            int i53 = 0;
            if (Float.compare(i30, i87) < 0) {
                i5 = Float.compare(i30, i92) >= 0 ? i87 : i88;
            } else {
                if (Float.compare(i30, i5) > 0) {
                    if (Float.compare(i30, i95) <= 0) {
                    } else {
                        i5 = i88;
                    }
                } else {
                    i5 = i30;
                }
            }
            return i5;
        }
        double sqrt2 = Math.sqrt(i83);
        float f12 = (float)i64;
        int i65 = 0;
        if (Float.compare(f12, i87) < 0) {
            i5 = Float.compare(f12, i92) >= 0 ? i87 : i88;
        } else {
            if (Float.compare(f12, i5) > 0) {
                if (Float.compare(f12, i95) <= 0) {
                } else {
                    i5 = i88;
                }
            } else {
                i5 = f12;
            }
        }
        return i5;
    }

    private static final float findFirstLineRoot(float p0, float p1) {
        int i;
        int cmp;
        final int i2 = 0;
        i3 /= i5;
        int i6 = 0;
        final int i9 = 2143289344;
        if (Float.compare(i4, i) < 0) {
            if (Float.compare(i4, i7) >= 0) {
            } else {
                i = i9;
            }
        } else {
            if (Float.compare(i4, i) > 0) {
                if (Float.compare(i4, i8) <= 0) {
                } else {
                    i = i9;
                }
            } else {
                i = i4;
            }
        }
        return i;
    }

    private static final float findFirstQuadraticRoot(float p0, float p1, float p2) {
        int cmp2;
        int i2;
        int i;
        int i3;
        int cmp;
        int i4;
        double d = (double)obj;
        final double d2 = (double)obj2;
        final double d3 = (double)obj3;
        long l = 4611686018427387904L;
        i21 += d3;
        int i29 = 0;
        i = Double.compare(i22, i23) == 0 ? i3 : i29;
        final int i30 = 1065353223;
        final int i31 = -1251999744;
        i4 = 1065353216;
        final int i32 = 0;
        final int i33 = 2143289344;
        if (i == 0) {
            int i19 = -sqrt;
            i27 += d2;
            double d4 = d;
            float f2 = (float)i10;
            int i14 = 0;
            if (Float.compare(f2, i32) < 0) {
                i2 = Float.compare(f2, i31) >= 0 ? i32 : i33;
            } else {
                if (Float.compare(f2, i4) > 0) {
                    i2 = Float.compare(f2, i30) <= 0 ? i4 : i33;
                } else {
                    i2 = f2;
                }
            }
            if (!Float.isNaN(i2)) {
                return i2;
            }
            float f3 = (float)i12;
            int i15 = 0;
            if (Float.compare(f3, i32) < 0) {
                i4 = Float.compare(f3, i31) >= 0 ? i32 : i33;
            } else {
                if (Float.compare(f3, i4) > 0) {
                    if (Float.compare(f3, i30) <= 0) {
                    } else {
                        i4 = i33;
                    }
                } else {
                    i4 = f3;
                }
            }
            return i4;
        }
        double a = d;
        if (Double.compare(d2, d3) == 0) {
        } else {
            i3 = i29;
        }
        if (i3 == 0) {
            float f = (float)i7;
            int i13 = 0;
            if (Float.compare(f, i32) < 0) {
                i4 = Float.compare(f, i31) >= 0 ? i32 : i33;
            } else {
                if (Float.compare(f, i4) > 0) {
                    if (Float.compare(f, i30) <= 0) {
                    } else {
                        i4 = i33;
                    }
                } else {
                    i4 = f;
                }
            }
            return i4;
        }
        return i33;
    }

    public static final float findFirstRoot(androidx.compose.ui.graphics.PathSegment segment, float fraction) {
        int i6;
        int i4;
        int i;
        int i5;
        int firstQuadraticRoot;
        int i2;
        int i3;
        int cmp;
        final float[] points2 = segment.getPoints();
        i4 = 4;
        i = 2;
        i5 = 0;
        firstQuadraticRoot = 2143289344;
        switch (i6) {
            case 1:
                break;
            case 2:
                f3 -= fraction;
                i = 0;
                i8 /= i9;
                i2 = 0;
                i3 = 0;
                firstQuadraticRoot = i3;
                i3 = 1065353216;
                firstQuadraticRoot = i3;
                firstQuadraticRoot = i5;
                break;
            case 3:
                firstQuadraticRoot = BezierKt.findFirstQuadraticRoot(f -= fraction, f7 -= fraction, f4 -= fraction);
                break;
            case 4:
                break;
            case 5:
                firstQuadraticRoot = BezierKt.findFirstCubicRoot(f2 -= fraction, f8 -= fraction, f5 -= fraction, f9 -= fraction);
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return firstQuadraticRoot;
    }

    private static final int findLineRoot(float p0, float p1, float[] roots, int index) {
        final int i = 0;
        return BezierKt.access$writeValidRootInUnitRange(i2 /= i5, roots, index);
    }

    static int findLineRoot$default(float p0, float p1, float[] roots, int index, int i5, Object object6) {
        int obj4;
        if (i5 &= 8 != 0) {
            obj4 = 0;
        }
        int obj5 = 0;
        return BezierKt.access$writeValidRootInUnitRange(obj6 /= i, roots, obj4);
    }

    private static final int findQuadraticRoots(float p0, float p1, float p2, float[] roots, int index) {
        int validRootInUnitRange;
        int a2;
        float f;
        int i;
        double i3;
        int cmp;
        long l2;
        int i2;
        int rootCount;
        int i4;
        long l;
        double d;
        double a;
        final float[] fArr = roots;
        final int i5 = index;
        double d2 = (double)obj;
        i3 = (double)i;
        final double d3 = (double)obj2;
        l2 = 4611686018427387904L;
        i18 += d3;
        rootCount = 0;
        l = l2;
        i2 = Double.compare(i19, i20) == 0 ? 1 : i4;
        if (i2 == 0) {
            l2 = -sqrt;
            i14 += d;
            a = d2;
            rootCount += validRootInUnitRange2;
            rootCount2 += validRootInUnitRange3;
            validRootInUnitRange = 1;
            if (rootCount > validRootInUnitRange) {
                a2 = fArr[i5];
                f = fArr[i5 + 1];
                if (Float.compare(a2, f) > 0) {
                    fArr[i5] = f;
                    fArr[i5 + 1] = a2;
                } else {
                    if (Float.compare(a2, f) == 0) {
                        i4 = validRootInUnitRange;
                    }
                    if (i4 != 0) {
                        rootCount--;
                    }
                }
            }
        } else {
            a = d2;
            d = i3;
            if (Double.compare(d, d3) == 0) {
                i4 = validRootInUnitRange;
            }
            if (i4 == 0) {
                rootCount += validRootInUnitRange;
            }
        }
        return rootCount;
    }

    static int findQuadraticRoots$default(float f, float f2, float f3, float[] f4Arr4, int i5, int i6, Object object7) {
        int obj4;
        if (i6 &= 16 != 0) {
            obj4 = 0;
        }
        return BezierKt.findQuadraticRoots(f, f2, f3, f4Arr4, obj4);
    }

    private static final float getEndX(androidx.compose.ui.graphics.PathSegment $this$endX) {
        int i;
        i = 4;
        final int i4 = 0;
        switch (i3) {
            case 1:
                i = i4;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = i4;
                break;
            case 7:
                i = i4;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return $this$endX.getPoints()[i];
    }

    private static final float getEndY(androidx.compose.ui.graphics.PathSegment $this$endY) {
        int i;
        i = 5;
        final int i4 = 0;
        switch (i3) {
            case 1:
                i = i4;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                i = 7;
                break;
            case 6:
                i = i4;
                break;
            case 7:
                i = i4;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return $this$endY.getPoints()[i];
    }

    private static final float getStartX(androidx.compose.ui.graphics.PathSegment $this$startX) {
        final int i = 0;
        return $this$startX.getPoints()[0];
    }

    private static final float getStartY(androidx.compose.ui.graphics.PathSegment $this$startY) {
        final int i = 0;
        return $this$startY.getPoints()[1];
    }

    private static final boolean isQuadraticMonotonic(float y0, float y1, float y2) {
        int i;
        int i7 = 1;
        i = Float.compare(i3, i6) == 0 ? i7 : 0;
        return i ^= i7;
    }

    public static final int lineWinding(float[] points, float x, float y) {
        int i;
        int y0;
        int y1;
        int direction;
        int cmp;
        i = 0;
        final int i2 = points[i];
        final int i3 = 1;
        y0 = points[i3];
        final int i4 = y0;
        y1 = points[3];
        direction = 1;
        if (Float.compare(y0, y1) > 0) {
            y0 = y1;
            y1 = i4;
            direction = -1;
        }
        if (Float.compare(y, y0) >= 0) {
            if (Float.compare(y, y1) >= 0) {
            } else {
                i10 -= i14;
                if (Float.compare(i11, i15) == 0) {
                    i = i3;
                }
                if (i != 0) {
                    direction = 0;
                } else {
                    if ((int)signum == direction) {
                        direction = 0;
                    }
                }
            }
            return direction;
        }
        return i;
    }

    private static final int monotonicCubicWinding(float[] points, int offset, float x, float y) {
        int y0;
        int y3;
        int direction;
        int cmp;
        int swap;
        int i2;
        int $this$closeTo$iv;
        int i;
        y0 = points[offset + 1];
        y3 = points[offset + 7];
        direction = 1;
        if (Float.compare(y0, y3) > 0) {
            y3 = y0;
            y0 = cmp;
            direction = -1;
        }
        i2 = 0;
        if (Float.compare(y, y0) >= 0) {
            if (Float.compare(y, y3) >= 0) {
            } else {
                int i6 = points[offset + 0];
                int i8 = points[offset + 2];
                int i10 = points[offset + 4];
                int i12 = points[offset + 6];
                int i13 = 0;
                if (Float.compare(x, f3) < 0) {
                    return i2;
                }
                int i14 = 0;
                if (Float.compare(x, f6) > 0) {
                    return direction;
                }
                int y32 = points[offset + 7];
                float firstCubicRoot = BezierKt.findFirstCubicRoot(y02 - y, i17 - y, i19 - y, y32 - y);
                if (Float.isNaN(firstCubicRoot)) {
                    return i2;
                }
                float evaluateCubic = BezierKt.evaluateCubic(i6, i8, i10, i12, firstCubicRoot);
                int i25 = 0;
                i = 1;
                $this$closeTo$iv = Float.compare(f8, i27) < 0 ? i : i2;
                if ($this$closeTo$iv != 0) {
                    $this$closeTo$iv = Float.compare(x, i12) == 0 ? i : i2;
                    if ($this$closeTo$iv != 0) {
                        if (Float.compare(y, y32) == 0) {
                        } else {
                            i = i2;
                        }
                        if (i == 0) {
                        }
                    }
                    return i2;
                }
                if (Float.compare(evaluateCubic, x) < 0) {
                    i2 = direction;
                }
            }
            return i2;
        }
        return i2;
    }

    private static final int monotonicQuadraticWinding(float[] points, int offset, float x, float y, float[] tmpRoots) {
        int y0;
        int y2;
        int direction;
        int cmp;
        int swap;
        int i4;
        int cmp2;
        int evaluateQuadratic;
        int i3;
        int $this$closeTo$iv;
        int i2;
        float[] fArr;
        int i;
        y0 = points[offset + 1];
        y2 = points[offset + 5];
        direction = 1;
        if (Float.compare(y0, y2) > 0) {
            y2 = y0;
            y0 = cmp;
            direction = -1;
        }
        i4 = 0;
        if (Float.compare(y, y0) >= 0) {
            if (Float.compare(y, y2) >= 0) {
            } else {
                int y02 = points[offset + 1];
                int i9 = points[offset + 3];
                int y22 = points[offset + 5];
                int i11 = 1073741824;
                cmp2 = 4;
                int i17 = 2;
                if (BezierKt.findQuadraticRoots$default(i13 + y22, i14 * i11, y02 - y, tmpRoots, 0, 16, 0) == 0) {
                    evaluateQuadratic = points[i20 *= i17];
                } else {
                    evaluateQuadratic = BezierKt.evaluateQuadratic(points[i4], points[i17], points[cmp2], tmpRoots[i4]);
                }
                int i22 = 0;
                i = 1;
                $this$closeTo$iv = Float.compare(f, i25) < 0 ? i : i4;
                if ($this$closeTo$iv != 0) {
                    cmp2 = Float.compare(x, i15) == 0 ? i : i4;
                    if (cmp2 != 0) {
                        if (Float.compare(y, y22) == 0) {
                        } else {
                            i = i4;
                        }
                        if (i == 0) {
                        }
                    }
                    return i4;
                }
                if (Float.compare(evaluateQuadratic, x) < 0) {
                    i4 = direction;
                }
            }
            return i4;
        }
        return i4;
    }

    private static final int quadraticToMonotonicQuadratics(float[] quadratic, float[] dst) {
        int i;
        int y1;
        boolean quadraticMonotonic;
        float f;
        i = 1;
        final int i4 = quadratic[i];
        final int i5 = 3;
        y1 = quadratic[i5];
        int i7 = quadratic[5];
        quadraticMonotonic = BezierKt.unitDivide(i4 - y1, i11 += i7);
        if (!BezierKt.isQuadraticMonotonic(i4, y1, i7) && !Float.isNaN(quadraticMonotonic)) {
            quadraticMonotonic = BezierKt.unitDivide(i4 - y1, i11 += i7);
            if (!Float.isNaN(quadraticMonotonic)) {
                BezierKt.splitQuadraticAt(quadratic, dst, quadraticMonotonic);
                return i;
            }
            i = Float.compare(f2, f) < 0 ? i4 : i7;
            y1 = i;
        }
        int i8 = 0;
        ArraysKt.copyInto(quadratic, dst, i8, i8, 6);
        dst[i5] = y1;
        return i8;
    }

    public static final int quadraticWinding(float[] points, float x, float y, float[] tmpQuadratics, float[] tmpRoots) {
        int winding;
        int monotonicQuadraticWinding;
        int i7 = 0;
        if (BezierKt.isQuadraticMonotonic(points[1], points[3], points[5])) {
            return BezierKt.monotonicQuadraticWinding(points, i7, x, y, tmpRoots);
        }
        if (BezierKt.quadraticToMonotonicQuadratics(points, tmpQuadratics) > 0) {
            winding += monotonicQuadraticWinding;
        }
        return winding;
    }

    private static final void splitCubicAt(float[] src, int srcOffset, float[] dst, int dstOffset, float t) {
        float[] fArr = src;
        int i = srcOffset;
        float[] fArr2 = dst;
        int i4 = dstOffset;
        final int i5 = t;
        if (Float.compare(i5, i6) >= 0) {
            ArraysKt.copyInto(fArr, fArr2, i4, i, 8);
            float f = fArr[i + 6];
            float f3 = fArr[i + 7];
            fArr2[i4 + 8] = f;
            fArr2[i4 + 9] = f3;
            fArr2[i4 + 10] = f;
            fArr2[i4 + 11] = f3;
            fArr2[i4 + 12] = f;
            fArr2[i4 + 13] = f3;
        }
        float f2 = fArr[i + 0];
        float f4 = fArr[i + 1];
        fArr2[i4 + 0] = f2;
        fArr2[i4 + 1] = f4;
        float f5 = fArr[i + 2];
        float f6 = fArr[i + 3];
        final float lerp6 = MathHelpersKt.lerp(f2, f5, i5);
        final float lerp7 = MathHelpersKt.lerp(f4, f6, i5);
        fArr2[i4 + 2] = lerp6;
        fArr2[i4 + 3] = lerp7;
        float f7 = fArr[i + 4];
        float f8 = fArr[i + 5];
        final float lerp8 = MathHelpersKt.lerp(f5, f7, i5);
        final float lerp9 = MathHelpersKt.lerp(f6, f8, i5);
        final float lerp10 = MathHelpersKt.lerp(lerp6, lerp8, i5);
        float lerp = MathHelpersKt.lerp(lerp7, lerp9, i5);
        fArr2[i4 + 4] = lerp10;
        fArr2[i4 + 5] = lerp;
        int i2 = src[i + 6];
        int i3 = src[srcOffset + 7];
        float lerp4 = MathHelpersKt.lerp(f7, i2, i5);
        float lerp2 = MathHelpersKt.lerp(f8, i3, i5);
        float lerp3 = MathHelpersKt.lerp(lerp8, lerp4, i5);
        float lerp5 = MathHelpersKt.lerp(lerp9, lerp2, i5);
        dst[dstOffset + 6] = MathHelpersKt.lerp(lerp10, lerp3, i5);
        dst[dstOffset + 7] = MathHelpersKt.lerp(lerp, lerp5, i5);
        dst[dstOffset + 8] = lerp3;
        dst[dstOffset + 9] = lerp5;
        dst[dstOffset + 10] = lerp4;
        dst[dstOffset + 11] = lerp2;
        dst[dstOffset + 12] = i2;
        dst[dstOffset + 13] = i3;
    }

    private static final void splitQuadraticAt(float[] src, float[] dst, float t) {
        final float f = t;
        int i = 0;
        final int i2 = src[i];
        int i3 = 1;
        final int i4 = src[i3];
        int i5 = 2;
        final int i6 = src[i5];
        int i7 = 3;
        final int i8 = src[i7];
        int i9 = 4;
        final int i14 = src[i9];
        final int i15 = 5;
        final int i16 = src[i15];
        final float lerp5 = MathHelpersKt.lerp(i2, i6, f);
        final float lerp6 = MathHelpersKt.lerp(i4, i8, f);
        dst[i] = i2;
        dst[i3] = i4;
        dst[i5] = lerp5;
        dst[i7] = lerp6;
        float lerp = MathHelpersKt.lerp(i6, i14, f);
        float lerp2 = MathHelpersKt.lerp(i8, i16, f);
        dst[i9] = MathHelpersKt.lerp(lerp5, lerp, f);
        dst[i15] = MathHelpersKt.lerp(lerp6, lerp2, f);
        dst[6] = lerp;
        dst[7] = lerp2;
        dst[8] = i14;
        dst[9] = i16;
    }

    private static final float unitDivide(float x, float y) {
        int n;
        int d;
        int cmp;
        int i;
        n = x;
        int i2 = 0;
        if (Float.compare(n, i2) < 0) {
            n = -n;
            d = -d;
        }
        i = 1;
        final int i4 = 0;
        cmp = Float.compare(d, i2) == 0 ? i : i4;
        final int i5 = 2143289344;
        if (cmp == 0) {
            cmp = Float.compare(n, i2) == 0 ? i : i4;
            if (cmp == 0) {
                if (Float.compare(n, d) >= 0) {
                } else {
                    int i3 = n / d;
                    if (Float.compare(i3, i2) == 0) {
                    } else {
                        i = i4;
                    }
                    if (i != 0) {
                        return i5;
                    }
                }
                return i3;
            }
        }
        return i5;
    }

    private static final int writeValidRootInUnitRange(float r, float[] roots, int index) {
        int i;
        int cmp;
        int i2 = 0;
        final int i6 = 2143289344;
        if (Float.compare(r, i) < 0) {
            if (Float.compare(r, i4) >= 0) {
            } else {
                i = i6;
            }
        } else {
            if (Float.compare(r, i) > 0) {
                if (Float.compare(r, i5) <= 0) {
                } else {
                    i = i6;
                }
            } else {
                i = r;
            }
        }
        roots[index] = i;
        return naN ^= 1;
    }
}
