package androidx.core.graphics;

import _COROUTINE.ArtificialStackFrames;
import android.app.Notification.Action;
import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class PathParser {

    private static final String LOGTAG = "PathParser";

    private static class ExtractFloatResult {

        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    public static class PathDataNode {

        private final float[] mParams;
        private char mType;
        PathDataNode(char type, float[] params) {
            super();
            this.mType = type;
            this.mParams = params;
        }

        PathDataNode(androidx.core.graphics.PathParser.PathDataNode n) {
            super();
            this.mType = n.mType;
            this.mParams = PathParser.copyOfRange(n.mParams, 0, mParams2.length);
        }

        static char access$000(androidx.core.graphics.PathParser.PathDataNode x0) {
            return x0.mType;
        }

        static char access$002(androidx.core.graphics.PathParser.PathDataNode x0, char x1) {
            x0.mType = x1;
            return x1;
        }

        static float[] access$100(androidx.core.graphics.PathParser.PathDataNode x0) {
            return x0.mParams;
        }

        static void access$200(Path x0, float[] x1, char x2, char x3, float[] x4) {
            PathParser.PathDataNode.addCommand(x0, x1, x2, x3, x4);
        }

        private static void addCommand(Path path, float[] current, char previousCmd, char cmd, float[] val) {
            int i;
            int incr;
            int incr2;
            int i7;
            int reflectiveCtrlPointX;
            int i11;
            int k4;
            int ctrlPointX2;
            int currentX;
            int i12;
            int currentY3;
            int reflectiveCtrlPointY;
            int reflectiveCtrlPointY2;
            int ctrlPointX;
            int ctrlPointY;
            int i2;
            int currentSegmentStartY;
            int k;
            int k2;
            int currentY;
            int currentX2;
            int currentX3;
            int i17;
            int i8;
            int i5;
            int i9;
            int i14;
            int i6;
            int i10;
            int k3;
            int currentY2;
            int i3;
            int ctrlPointY2;
            int i19;
            int i15;
            int i16;
            int i4;
            int i13;
            int i18;
            i = path;
            final int[] iArr = val;
            incr = 2;
            currentX = current[0];
            currentY3 = current[1];
            ctrlPointX = current[2];
            final int i195 = 3;
            ctrlPointY = current[i195];
            final int i196 = 4;
            i2 = current[i196];
            final int i197 = 5;
            int i187 = current[i197];
            switch (cmd) {
                case 65:
                    i10 = incr;
                    break;
                case 67:
                    i10 = incr;
                    break;
                case 72:
                    i10 = incr;
                    break;
                case 76:
                    i10 = incr;
                    break;
                case 77:
                    i10 = incr;
                    break;
                case 81:
                    i.close();
                    ctrlPointX = i2;
                    ctrlPointY = i187;
                    i.moveTo(i2, i187);
                    i10 = incr;
                    break;
                default:
                    i10 = incr;
            }
            k = incr2;
            currentX2 = currentX;
            k3 = currentY3;
            i3 = ctrlPointX;
            ctrlPointY2 = ctrlPointY;
            i19 = i2;
            i15 = i187;
            currentSegmentStartY = previousCmd;
            while (k < iArr.length) {
                i7 = 84;
                currentX = 83;
                currentY3 = 81;
                ctrlPointX = 67;
                ctrlPointY = 116;
                i2 = 115;
                i16 = i8;
                int i191 = 113;
                i4 = i9;
                int i193 = 99;
                i13 = 1073741824;
                i6 = 0;
                i5 = currentSegmentStartY;
                int i51 = currentX2;
                currentY2 = k;
                incr2 = currentX;
                currentSegmentStartY = cmd;
                k = currentY2 + i10;
                i = path;
                k3 = incr2;
                i8 = i16;
                i9 = i4;
                i14 = i18;
                i.rLineTo(i6, iArr[k + 0]);
                i5 = currentSegmentStartY;
                incr2 = currentY8;
                currentY2 = k;
                currentX = 0;
                ctrlPointX = 0;
                if (currentSegmentStartY != i191 && currentSegmentStartY != ctrlPointY && currentSegmentStartY != currentY3) {
                } else {
                }
                currentX = currentX2 - i3;
                ctrlPointX = k3 - ctrlPointY2;
                i.rQuadTo(currentX, ctrlPointX, iArr[k + 0], iArr[k + 1]);
                currentX2 += i173;
                i3 = i94;
                ctrlPointY2 = currentY3;
                i5 = currentSegmentStartY;
                incr2 = currentY12;
                currentY2 = k;
                if (currentSegmentStartY != ctrlPointY) {
                } else {
                }
                if (currentSegmentStartY != currentY3) {
                } else {
                }
                if (currentSegmentStartY == i7) {
                }
                ctrlPointX2 = 0;
                if (currentSegmentStartY != i193 && currentSegmentStartY != i2 && currentSegmentStartY != ctrlPointX) {
                } else {
                }
                ctrlPointX2 = currentX2 - i3;
                currentX = reflectiveCtrlPointY2;
                i.rCubicTo(ctrlPointX2, currentX, iArr[k + 0], iArr[k + 1], iArr[k + 2], iArr[k + 3]);
                currentX2 += i178;
                i3 = currentY3;
                ctrlPointY2 = ctrlPointX;
                i5 = currentSegmentStartY;
                incr2 = currentY13;
                currentY2 = k;
                if (currentSegmentStartY != i2) {
                } else {
                }
                if (currentSegmentStartY != ctrlPointX) {
                } else {
                }
                if (currentSegmentStartY == currentX) {
                } else {
                }
                currentX = reflectiveCtrlPointY2;
                i.rQuadTo(iArr[k + 0], iArr[k + 1], iArr[k + 2], iArr[k + 3]);
                currentX2 += i142;
                i3 = i82;
                ctrlPointY2 = currentX;
                i5 = currentSegmentStartY;
                incr2 = currentY10;
                currentY2 = k;
                k3 += i68;
                if (k > 0) {
                } else {
                }
                i.rMoveTo(iArr[k + 0], iArr[k + 1]);
                i19 = i71;
                i15 = currentX;
                i5 = currentSegmentStartY;
                incr2 = currentY9;
                currentY2 = k;
                i.rLineTo(iArr[k + 0], iArr[k + 1]);
                i5 = currentSegmentStartY;
                incr2 = currentY9;
                currentY2 = k;
                i.rLineTo(iArr[k + 0], iArr[k + 1]);
                currentX2 += i38;
                i5 = currentSegmentStartY;
                incr2 = currentY7;
                currentY2 = k;
                i.rLineTo(iArr[k + 0], i6);
                currentX2 += i91;
                i5 = currentSegmentStartY;
                incr2 = k3;
                currentY2 = k;
                i.rCubicTo(iArr[k + 0], iArr[k + 1], iArr[k + 2], iArr[k + 3], iArr[k + 4], iArr[k + 5]);
                currentX2 += i124;
                i3 = i;
                ctrlPointY2 = i87;
                i5 = currentSegmentStartY;
                incr2 = currentY11;
                currentY2 = k;
                if (Float.compare(i75, i6) != 0) {
                } else {
                }
                i11 = k;
                k2 = i16;
                if (Float.compare(i116, i6) != 0) {
                } else {
                }
                i12 = i11;
                k4 = currentX2;
                currentX3 = i16;
                currentY2 = i12;
                int k5 = i194;
                PathParser.PathDataNode.drawArc(path, k4, k5, i21 + currentX2, i23 + k3, iArr[k + 0], iArr[k + 1], iArr[k + 2], k2, currentX3);
                i3 = currentX;
                ctrlPointY2 = currentY3;
                i5 = i6;
                i12 = i11;
                k4 = currentX2;
                currentX3 = i4;
                i11 = k;
                k2 = i4;
                currentY2 = k;
                k = previousCmd10;
                i.lineTo(currentX2, iArr[currentY2 + 0]);
                incr2 = iArr[currentY2 + 0];
                i5 = i6;
                currentY2 = k;
                k = previousCmd7;
                i6 = currentSegmentStartY;
                currentSegmentStartY = currentX2;
                currentX = currentSegmentStartY;
                ctrlPointX = k;
                if (i6 != i191 && i6 != ctrlPointY && i6 != currentY3) {
                } else {
                }
                currentX = currentX2 - i3;
                ctrlPointX = i7 - ctrlPointY2;
                i.quadTo(currentX, ctrlPointX, iArr[currentY2 + 0], iArr[currentY2 + 1]);
                i3 = i58;
                ctrlPointY2 = currentY3;
                currentX2 = ctrlPointY;
                incr2 = i2;
                i5 = i6;
                if (i6 != ctrlPointY) {
                } else {
                }
                if (i6 != currentY3) {
                } else {
                }
                if (i6 == i7) {
                }
                currentY2 = k;
                k = previousCmd8;
                i6 = currentSegmentStartY;
                currentSegmentStartY = currentX2;
                reflectiveCtrlPointX = currentSegmentStartY;
                if (i6 != i193 && i6 != i2 && i6 != ctrlPointX) {
                } else {
                }
                reflectiveCtrlPointX = currentX2 - i3;
                currentX = reflectiveCtrlPointY;
                i.cubicTo(reflectiveCtrlPointX, currentX, iArr[currentY2 + 0], iArr[currentY2 + 1], iArr[currentY2 + 2], iArr[currentY2 + 3]);
                i3 = currentY3;
                ctrlPointY2 = ctrlPointX;
                currentX2 = ctrlPointY;
                incr2 = i2;
                i5 = i6;
                if (i6 != i2) {
                } else {
                }
                if (i6 != ctrlPointX) {
                } else {
                }
                if (i6 == currentX) {
                } else {
                }
                currentX = reflectiveCtrlPointY;
                currentY2 = k;
                k = previousCmd4;
                currentSegmentStartY = currentX2;
                i.quadTo(iArr[currentY2 + 0], iArr[currentY2 + 1], iArr[currentY2 + 2], iArr[currentY2 + 3]);
                i3 = i47;
                ctrlPointY2 = currentX;
                currentX2 = currentY3;
                incr2 = ctrlPointX;
                i5 = i6;
                currentY2 = k;
                int k7 = previousCmd11;
                i6 = currentSegmentStartY;
                currentSegmentStartY = currentX2;
                int i96 = iArr[currentY2 + 0];
                currentX = iArr[currentY2 + 1];
                if (currentY2 > 0) {
                } else {
                }
                i.moveTo(iArr[currentY2 + 0], iArr[currentY2 + 1]);
                currentX2 = i96;
                incr2 = currentX;
                i19 = currentY3;
                i15 = ctrlPointX;
                i5 = i6;
                i.lineTo(iArr[currentY2 + 0], iArr[currentY2 + 1]);
                currentX2 = i96;
                incr2 = currentX;
                i5 = i6;
                currentY2 = k;
                k = previousCmd9;
                currentSegmentStartY = currentX2;
                i.lineTo(iArr[currentY2 + 0], iArr[currentY2 + 1]);
                currentX2 = i62;
                incr2 = currentX;
                i5 = i6;
                currentY2 = k;
                k = previousCmd6;
                currentSegmentStartY = currentX2;
                i.lineTo(iArr[currentY2 + 0], k);
                currentX2 = i55;
                incr2 = k;
                i5 = i6;
                currentY2 = k;
                int k6 = previousCmd5;
                currentSegmentStartY = currentX2;
                i.cubicTo(iArr[currentY2 + 0], iArr[currentY2 + 1], iArr[currentY2 + 2], iArr[currentY2 + 3], iArr[currentY2 + 4], iArr[currentY2 + 5]);
                incr2 = iArr[currentY2 + 5];
                currentX2 = i;
                i3 = currentX;
                ctrlPointY2 = currentY3;
                i5 = i6;
                currentY2 = k;
                i5 = currentSegmentStartY;
                if (Float.compare(i98, i6) != 0) {
                } else {
                }
                currentY = i16;
                if (Float.compare(i100, i6) != 0) {
                } else {
                }
                i17 = i16;
                PathParser.PathDataNode.drawArc(path, currentX2, k3, iArr[currentY2 + 5], iArr[currentY2 + 6], iArr[currentY2 + 0], iArr[currentY2 + 1], iArr[currentY2 + 2], currentY, i17);
                i = iArr[currentY2 + 5];
                currentX2 = i;
                i3 = currentX;
                ctrlPointY2 = currentY3;
                i17 = i4;
                currentY = i4;
            }
            current[i8] = currentX2;
            current[i9] = k3;
            current[i14] = i3;
            current[i195] = ctrlPointY2;
            current[i196] = i19;
            current[i197] = i15;
        }

        private static void arcToBezier(Path p, double cx, double cy, double a, double b, double e1x, double e1y, double theta, double start, double sweep) {
            int e1x2;
            float f2;
            int i3;
            int i9;
            int eta1;
            long ep2y;
            double d10;
            int i2;
            double d6;
            int i;
            double d8;
            float f9;
            double d;
            float f4;
            int i4;
            int i5;
            long ep1x2;
            int ep1y;
            int ep1x;
            int eta12;
            int i7;
            double d9;
            double d3;
            double d2;
            double d7;
            int i6;
            int i8;
            double d5;
            int i10;
            double d4;
            double d11;
            Object obj;
            float f5;
            float f6;
            float f;
            float f8;
            float f7;
            float f3;
            int i11;
            int obj67;
            int obj69;
            e1x2 = e1x;
            long l = 4616189618054758400L;
            ep2y = 4614256656552045848L;
            int i23 = obj73;
            d10 = Math.cos(obj71);
            d6 = Math.sin(obj71);
            d8 = Math.cos(i23);
            d = Math.sin(i23);
            ep1y = i20;
            i3 = obj75 / ep1y2;
            eta12 = i23;
            i4 = i37;
            eta1 = sweep;
            ep1x = i34;
            ep1x2 = obj69;
            while (i4 < i9) {
                i7 = eta12 + i3;
                d9 = Math.sin(i7);
                d3 = Math.cos(i7);
                int anglePerSegment = i40 - i45;
                int numSegments = i43 + i47;
                d2 = d10;
                obj69 = i27;
                d7 = Math.tan(i52 /= l4);
                long l5 = 4613937818241073152L;
                i55 /= l5;
                int i12 = obj67 + i56;
                i10 = i30;
                int i31 = 0;
                Object sinEta1 = p;
                sinEta1.rLineTo(i31, i31);
                i11 = i12;
                sinEta1.cubicTo((float)i12, (float)ep2y, (float)i2, (float)i, (float)anglePerSegment, (float)numSegments);
                eta12 = i7;
                ep1x2 = numSegments;
                ep1x = obj69;
                ep1y = i10;
                i4++;
                eta1 = i13;
                i9 = i5;
                d10 = d2;
                i3 = i6;
                d = d5;
                d6 = d4;
                d8 = d11;
                e1x2 = e1x;
            }
        }

        private static void drawArc(Path p, float x0, float y0, float x1, float y1, float a, float b, float theta, boolean isMoreThanHalf, boolean isPositiveArc) {
            int cmp;
            int sweep;
            int cx;
            int i;
            long i4;
            int i2;
            int i3;
            final int i8 = x0;
            final float f = y0;
            int i9 = x1;
            final float f2 = y1;
            final int i36 = a;
            final int i37 = b;
            float f3 = theta;
            final double radians = Math.toRadians((double)f3);
            final double d24 = Math.cos(radians);
            final double d25 = Math.sin(radians);
            final int i46 = i12 / d11;
            final int i47 = i14 / d13;
            final int i48 = i16 / d15;
            final int i49 = i18 / d17;
            final int i50 = i46 - i48;
            final int i51 = i47 - i49;
            long l = 4611686018427387904L;
            final int i52 = i19 / l;
            final int i53 = i20 / l;
            int i38 = i21 + i34;
            int i22 = 0;
            String str3 = "PathParser";
            if (Double.compare(i38, i22) == 0) {
                Log.w(str3, " Points are coincident");
            }
            final int i54 = i40 - l4;
            if (Double.compare(i54, i22) < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                Log.w(str3, stringBuilder.append("Points are too far apart ").append(i38).toString());
                float f4 = (float)i23;
                PathParser.PathDataNode.drawArc(p, i8, f, i9, f2, i36 * f4, i37 * f4, f3, isMoreThanHalf, isPositiveArc);
            }
            int i35 = isPositiveArc;
            double sqrt = Math.sqrt(i54);
            int i29 = sqrt * i50;
            final int i55 = sqrt * i51;
            i = isMoreThanHalf == i35 ? i53 + i29 : i53 - i29;
            i4 = i22;
            final double d26 = sqrt;
            final double atan22 = Math.atan2(i47 - i, obj6);
            double atan2 = Math.atan2(i49 - i, f2);
            sweep = atan2 - atan22;
            i2 = Double.compare(sweep, i4) >= 0 ? 1 : 0;
            if (i35 != i2) {
                i4 = 4618760256179416344L;
                i3 = Double.compare(sweep, i4) > 0 ? sweep : sweep;
            } else {
                i3 = sweep;
            }
            cx *= sweep2;
            i *= d9;
            i42 -= i44;
            int cx3 = i27 * d25;
            final double d27 = atan2;
            double d20 = eta1;
            final double d22 = d2;
            int i7 = i56;
            PathParser.PathDataNode.arcToBezier(p, i43, cx3, cx3 + i45, cy, d20, i43, d22, d20, (double)i8);
        }

        @Deprecated
        public static void nodesToPath(androidx.core.graphics.PathParser.PathDataNode[] node, Path path) {
            PathParser.nodesToPath(node, path);
        }

        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(androidx.core.graphics.PathParser.PathDataNode nodeFrom, androidx.core.graphics.PathParser.PathDataNode nodeTo, float fraction) {
            int i3;
            float[] mParams;
            int i2;
            int i;
            this.mType = nodeFrom.mType;
            i3 = 0;
            while (i3 < mParams2.length) {
                this.mParams[i3] = i4 += i;
                i3++;
            }
        }
    }
    private static void addNode(ArrayList<androidx.core.graphics.PathParser.PathDataNode> arrayList, char cmd, float[] val) {
        PathParser.PathDataNode pathDataNode = new PathParser.PathDataNode(cmd, val);
        arrayList.add(pathDataNode);
    }

    public static boolean canMorph(androidx.core.graphics.PathParser.PathDataNode[] nodesFrom, androidx.core.graphics.PathParser.PathDataNode[] nodesTo) {
        int i;
        int length2;
        int length;
        int i2 = 0;
        if (nodesFrom != null) {
            if (nodesTo == null) {
            } else {
                if (nodesFrom.length != nodesTo.length) {
                    return i2;
                }
                i = 0;
                for (Object obj2 : nodesFrom) {
                }
            }
            return 1;
        }
        return i2;
    }

    static float[] copyOfRange(float[] original, int start, int end) {
        if (start > end) {
        } else {
            int length = original.length;
            if (start < 0) {
            } else {
                if (start > length) {
                } else {
                    int i = end - start;
                    final float[] fArr = new float[i];
                    System.arraycopy(original, start, fArr, 0, Math.min(i, length - start));
                    return fArr;
                }
            }
            ArrayIndexOutOfBoundsException resultLength = new ArrayIndexOutOfBoundsException();
            throw resultLength;
        }
        IllegalArgumentException originalLength = new IllegalArgumentException();
        throw originalLength;
    }

    public static androidx.core.graphics.PathParser.PathDataNode[] createNodesFromPathData(String pathData) {
        int start;
        int end;
        String trim;
        int charAt;
        int charAt2;
        boolean floats;
        int fArr;
        start = 0;
        end = 1;
        ArrayList arrayList = new ArrayList();
        charAt2 = 0;
        while (end < pathData.length()) {
            int end2 = PathParser.nextStart(pathData, end);
            trim = pathData.substring(start, end2).trim();
            if (!trim.isEmpty()) {
            }
            start = end2;
            end2++;
            charAt2 = 0;
            PathParser.addNode(arrayList, trim.charAt(charAt2), PathParser.getFloats(trim));
        }
        if (end - start == 1 && start < pathData.length()) {
            if (start < pathData.length()) {
                PathParser.addNode(arrayList, pathData.charAt(start), new float[charAt2]);
            }
        }
        return (PathParser.PathDataNode[])arrayList.toArray(new PathParser.PathDataNode[charAt2]);
    }

    public static Path createPathFromPathData(String pathData) {
        Path path = new Path();
        PathParser.PathDataNode.nodesToPath(PathParser.createNodesFromPathData(pathData), path);
        return path;
    }

    public static androidx.core.graphics.PathParser.PathDataNode[] deepCopyNodes(androidx.core.graphics.PathParser.PathDataNode[] source) {
        int i;
        androidx.core.graphics.PathParser.PathDataNode pathDataNode;
        Object obj;
        androidx.core.graphics.PathParser.PathDataNode[] arr = new PathParser.PathDataNode[source.length];
        i = 0;
        for (Object obj : source) {
            pathDataNode = new PathParser.PathDataNode(obj);
            arr[i] = pathDataNode;
        }
        return arr;
    }

    private static void extract(String s, int start, androidx.core.graphics.PathParser.ExtractFloatResult result) {
        int currentIndex;
        int foundSeparator;
        int secondDot;
        int isExponential;
        int length;
        char charAt;
        int i;
        currentIndex = start;
        foundSeparator = 0;
        result.mEndWithNegOrDot = false;
        secondDot = 0;
        isExponential = 0;
        while (currentIndex < s.length()) {
            isExponential = 0;
            i = 1;
            if (foundSeparator != 0) {
                break;
            } else {
            }
            currentIndex++;
            isExponential = 1;
            if (secondDot == 0) {
            } else {
            }
            foundSeparator = 1;
            result.mEndWithNegOrDot = i;
            secondDot = 1;
            if (currentIndex != start && isExponential == 0) {
            }
            if (isExponential == 0) {
            }
            foundSeparator = 1;
            result.mEndWithNegOrDot = i;
            foundSeparator = 1;
        }
        result.mEndPosition = currentIndex;
    }

    private static float[] getFloats(String s) {
        char charAt;
        int i;
        int i2;
        int startPosition;
        int endPosition;
        boolean count;
        int mEndPosition;
        float float;
        int i3 = 0;
        if (s.charAt(i3) != 122) {
            if (s.charAt(i3) == 90) {
            } else {
                float[] fArr = new float[s.length()];
                i = 0;
                startPosition = 1;
                endPosition = 0;
                PathParser.ExtractFloatResult extractFloatResult = new PathParser.ExtractFloatResult();
                while (startPosition < s.length()) {
                    PathParser.extract(s, startPosition, extractFloatResult);
                    endPosition = mEndPosition;
                    if (startPosition < endPosition) {
                    }
                    if (extractFloatResult.mEndWithNegOrDot) {
                    } else {
                    }
                    startPosition = endPosition + 1;
                    startPosition = endPosition;
                    fArr[i] = Float.parseFloat(s.substring(startPosition, endPosition));
                    i = mEndPosition;
                }
            }
            return PathParser.copyOfRange(fArr, i3, i);
        }
        return new float[i3];
    }

    public static void interpolatePathDataNodes(androidx.core.graphics.PathParser.PathDataNode[] target, float fraction, androidx.core.graphics.PathParser.PathDataNode[] from, androidx.core.graphics.PathParser.PathDataNode[] to) {
        if (!PathParser.interpolatePathDataNodes(target, from, to, fraction)) {
        } else {
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        throw illegalArgumentException;
    }

    @Deprecated
    public static boolean interpolatePathDataNodes(androidx.core.graphics.PathParser.PathDataNode[] target, androidx.core.graphics.PathParser.PathDataNode[] from, androidx.core.graphics.PathParser.PathDataNode[] to, float fraction) {
        int i;
        int length;
        int length2;
        androidx.core.graphics.PathParser.PathDataNode pathDataNode;
        androidx.core.graphics.PathParser.PathDataNode pathDataNode2;
        if (target.length != from.length) {
        } else {
            if (from.length != to.length) {
            } else {
                if (!PathParser.canMorph(from, to)) {
                    return 0;
                }
                i = 0;
                for (Object length2 : target) {
                    length2.interpolatePathDataNode(from[i], to[i], fraction);
                }
                return 1;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        throw illegalArgumentException;
    }

    private static int nextStart(String s, int end) {
        char charAt;
        int i;
        int i2;
        int obj4;
        while (obj4 < s.length()) {
            charAt = s.charAt(obj4);
            obj4++;
        }
        return obj4;
    }

    public static void nodesToPath(androidx.core.graphics.PathParser.PathDataNode[] node, Path path) {
        int previousCommand;
        int i;
        Object obj;
        char c;
        float[] fArr;
        previousCommand = 109;
        i = 0;
        while (i < node.length) {
            obj = node[i];
            PathParser.PathDataNode.access$200(path, new float[6], previousCommand, PathParser.PathDataNode.access$000(obj), PathParser.PathDataNode.access$100(obj));
            previousCommand = PathParser.PathDataNode.access$000(obj);
            i++;
        }
    }

    public static void updateNodes(androidx.core.graphics.PathParser.PathDataNode[] target, androidx.core.graphics.PathParser.PathDataNode[] source) {
        int i;
        int j;
        int length;
        char c;
        float f;
        i = 0;
        for (Object obj5 : source) {
            PathParser.PathDataNode.access$002(target[i], PathParser.PathDataNode.access$000(source[i]));
            j = 0;
            while (j < fArr.length) {
                PathParser.PathDataNode.access$100(target[i])[j] = PathParser.PathDataNode.access$100(obj5)[j];
                j++;
            }
            PathParser.PathDataNode.access$100(target[i])[j] = PathParser.PathDataNode.access$100(obj5)[j];
            j++;
        }
    }
}
