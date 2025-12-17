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
            int i18;
            int incr2;
            int incr;
            int i2;
            int reflectiveCtrlPointX;
            int i9;
            int k3;
            int ctrlPointX;
            int currentX;
            int i;
            int currentY2;
            int reflectiveCtrlPointY2;
            int reflectiveCtrlPointY;
            int ctrlPointX2;
            int ctrlPointY2;
            int i19;
            int currentSegmentStartY;
            int k;
            int k2;
            int currentY;
            int currentX2;
            int currentX3;
            int i16;
            int i6;
            int i17;
            int i14;
            int i15;
            int i13;
            int i3;
            int k4;
            int currentY3;
            int i4;
            int ctrlPointY;
            int i10;
            int i12;
            int i5;
            int i11;
            int i8;
            int i7;
            i18 = path;
            final int[] iArr = val;
            incr2 = 2;
            currentX = current[0];
            currentY2 = current[1];
            ctrlPointX2 = current[2];
            final int i195 = 3;
            ctrlPointY2 = current[i195];
            final int i196 = 4;
            i19 = current[i196];
            final int i197 = 5;
            int i187 = current[i197];
            switch (cmd) {
                case 65:
                    i3 = incr2;
                    break;
                case 67:
                    i3 = incr2;
                    break;
                case 72:
                    i3 = incr2;
                    break;
                case 76:
                    i3 = incr2;
                    break;
                case 77:
                    i3 = incr2;
                    break;
                case 81:
                    i18.close();
                    ctrlPointX2 = i19;
                    ctrlPointY2 = i187;
                    i18.moveTo(i19, i187);
                    i3 = incr2;
                    break;
                default:
                    i3 = incr2;
            }
            k = incr;
            currentX2 = currentX;
            k4 = currentY2;
            i4 = ctrlPointX2;
            ctrlPointY = ctrlPointY2;
            i10 = i19;
            i12 = i187;
            currentSegmentStartY = previousCmd;
            while (k < iArr.length) {
                i2 = 84;
                currentX = 83;
                currentY2 = 81;
                ctrlPointX2 = 67;
                ctrlPointY2 = 116;
                i19 = 115;
                i5 = i6;
                int i191 = 113;
                i11 = i14;
                int i193 = 99;
                i8 = 1073741824;
                i13 = 0;
                i17 = currentSegmentStartY;
                int i51 = currentX2;
                currentY3 = k;
                incr = currentX;
                currentSegmentStartY = cmd;
                k = currentY3 + i3;
                i18 = path;
                k4 = incr;
                i6 = i5;
                i14 = i11;
                i15 = i7;
                i18.rLineTo(i13, iArr[k + 0]);
                i17 = currentSegmentStartY;
                incr = currentY8;
                currentY3 = k;
                currentX = 0;
                ctrlPointX2 = 0;
                if (currentSegmentStartY != i191 && currentSegmentStartY != ctrlPointY2 && currentSegmentStartY != currentY2) {
                } else {
                }
                currentX = currentX2 - i4;
                ctrlPointX2 = k4 - ctrlPointY;
                i18.rQuadTo(currentX, ctrlPointX2, iArr[k + 0], iArr[k + 1]);
                currentX2 += i173;
                i4 = i94;
                ctrlPointY = currentY2;
                i17 = currentSegmentStartY;
                incr = currentY12;
                currentY3 = k;
                if (currentSegmentStartY != ctrlPointY2) {
                } else {
                }
                if (currentSegmentStartY != currentY2) {
                } else {
                }
                if (currentSegmentStartY == i2) {
                }
                ctrlPointX = 0;
                if (currentSegmentStartY != i193 && currentSegmentStartY != i19 && currentSegmentStartY != ctrlPointX2) {
                } else {
                }
                ctrlPointX = currentX2 - i4;
                currentX = reflectiveCtrlPointY;
                i18.rCubicTo(ctrlPointX, currentX, iArr[k + 0], iArr[k + 1], iArr[k + 2], iArr[k + 3]);
                currentX2 += i178;
                i4 = currentY2;
                ctrlPointY = ctrlPointX2;
                i17 = currentSegmentStartY;
                incr = currentY13;
                currentY3 = k;
                if (currentSegmentStartY != i19) {
                } else {
                }
                if (currentSegmentStartY != ctrlPointX2) {
                } else {
                }
                if (currentSegmentStartY == currentX) {
                } else {
                }
                currentX = reflectiveCtrlPointY;
                i18.rQuadTo(iArr[k + 0], iArr[k + 1], iArr[k + 2], iArr[k + 3]);
                currentX2 += i142;
                i4 = i82;
                ctrlPointY = currentX;
                i17 = currentSegmentStartY;
                incr = currentY10;
                currentY3 = k;
                k4 += i68;
                if (k > 0) {
                } else {
                }
                i18.rMoveTo(iArr[k + 0], iArr[k + 1]);
                i10 = i71;
                i12 = currentX;
                i17 = currentSegmentStartY;
                incr = currentY9;
                currentY3 = k;
                i18.rLineTo(iArr[k + 0], iArr[k + 1]);
                i17 = currentSegmentStartY;
                incr = currentY9;
                currentY3 = k;
                i18.rLineTo(iArr[k + 0], iArr[k + 1]);
                currentX2 += i38;
                i17 = currentSegmentStartY;
                incr = currentY7;
                currentY3 = k;
                i18.rLineTo(iArr[k + 0], i13);
                currentX2 += i91;
                i17 = currentSegmentStartY;
                incr = k4;
                currentY3 = k;
                i18.rCubicTo(iArr[k + 0], iArr[k + 1], iArr[k + 2], iArr[k + 3], iArr[k + 4], iArr[k + 5]);
                currentX2 += i124;
                i4 = i18;
                ctrlPointY = i87;
                i17 = currentSegmentStartY;
                incr = currentY11;
                currentY3 = k;
                if (Float.compare(i75, i13) != 0) {
                } else {
                }
                i9 = k;
                k2 = i5;
                if (Float.compare(i116, i13) != 0) {
                } else {
                }
                i = i9;
                k3 = currentX2;
                currentX3 = i5;
                currentY3 = i;
                int k5 = i194;
                PathParser.PathDataNode.drawArc(path, k3, k5, i21 + currentX2, i23 + k4, iArr[k + 0], iArr[k + 1], iArr[k + 2], k2, currentX3);
                i4 = currentX;
                ctrlPointY = currentY2;
                i17 = i13;
                i = i9;
                k3 = currentX2;
                currentX3 = i11;
                i9 = k;
                k2 = i11;
                currentY3 = k;
                k = previousCmd10;
                i18.lineTo(currentX2, iArr[currentY3 + 0]);
                incr = iArr[currentY3 + 0];
                i17 = i13;
                currentY3 = k;
                k = previousCmd7;
                i13 = currentSegmentStartY;
                currentSegmentStartY = currentX2;
                currentX = currentSegmentStartY;
                ctrlPointX2 = k;
                if (i13 != i191 && i13 != ctrlPointY2 && i13 != currentY2) {
                } else {
                }
                currentX = currentX2 - i4;
                ctrlPointX2 = i2 - ctrlPointY;
                i18.quadTo(currentX, ctrlPointX2, iArr[currentY3 + 0], iArr[currentY3 + 1]);
                i4 = i58;
                ctrlPointY = currentY2;
                currentX2 = ctrlPointY2;
                incr = i19;
                i17 = i13;
                if (i13 != ctrlPointY2) {
                } else {
                }
                if (i13 != currentY2) {
                } else {
                }
                if (i13 == i2) {
                }
                currentY3 = k;
                k = previousCmd8;
                i13 = currentSegmentStartY;
                currentSegmentStartY = currentX2;
                reflectiveCtrlPointX = currentSegmentStartY;
                if (i13 != i193 && i13 != i19 && i13 != ctrlPointX2) {
                } else {
                }
                reflectiveCtrlPointX = currentX2 - i4;
                currentX = reflectiveCtrlPointY2;
                i18.cubicTo(reflectiveCtrlPointX, currentX, iArr[currentY3 + 0], iArr[currentY3 + 1], iArr[currentY3 + 2], iArr[currentY3 + 3]);
                i4 = currentY2;
                ctrlPointY = ctrlPointX2;
                currentX2 = ctrlPointY2;
                incr = i19;
                i17 = i13;
                if (i13 != i19) {
                } else {
                }
                if (i13 != ctrlPointX2) {
                } else {
                }
                if (i13 == currentX) {
                } else {
                }
                currentX = reflectiveCtrlPointY2;
                currentY3 = k;
                k = previousCmd4;
                currentSegmentStartY = currentX2;
                i18.quadTo(iArr[currentY3 + 0], iArr[currentY3 + 1], iArr[currentY3 + 2], iArr[currentY3 + 3]);
                i4 = i47;
                ctrlPointY = currentX;
                currentX2 = currentY2;
                incr = ctrlPointX2;
                i17 = i13;
                currentY3 = k;
                int k7 = previousCmd11;
                i13 = currentSegmentStartY;
                currentSegmentStartY = currentX2;
                int i96 = iArr[currentY3 + 0];
                currentX = iArr[currentY3 + 1];
                if (currentY3 > 0) {
                } else {
                }
                i18.moveTo(iArr[currentY3 + 0], iArr[currentY3 + 1]);
                currentX2 = i96;
                incr = currentX;
                i10 = currentY2;
                i12 = ctrlPointX2;
                i17 = i13;
                i18.lineTo(iArr[currentY3 + 0], iArr[currentY3 + 1]);
                currentX2 = i96;
                incr = currentX;
                i17 = i13;
                currentY3 = k;
                k = previousCmd9;
                currentSegmentStartY = currentX2;
                i18.lineTo(iArr[currentY3 + 0], iArr[currentY3 + 1]);
                currentX2 = i62;
                incr = currentX;
                i17 = i13;
                currentY3 = k;
                k = previousCmd6;
                currentSegmentStartY = currentX2;
                i18.lineTo(iArr[currentY3 + 0], k);
                currentX2 = i55;
                incr = k;
                i17 = i13;
                currentY3 = k;
                int k6 = previousCmd5;
                currentSegmentStartY = currentX2;
                i18.cubicTo(iArr[currentY3 + 0], iArr[currentY3 + 1], iArr[currentY3 + 2], iArr[currentY3 + 3], iArr[currentY3 + 4], iArr[currentY3 + 5]);
                incr = iArr[currentY3 + 5];
                currentX2 = i18;
                i4 = currentX;
                ctrlPointY = currentY2;
                i17 = i13;
                currentY3 = k;
                i17 = currentSegmentStartY;
                if (Float.compare(i98, i13) != 0) {
                } else {
                }
                currentY = i5;
                if (Float.compare(i100, i13) != 0) {
                } else {
                }
                i16 = i5;
                PathParser.PathDataNode.drawArc(path, currentX2, k4, iArr[currentY3 + 5], iArr[currentY3 + 6], iArr[currentY3 + 0], iArr[currentY3 + 1], iArr[currentY3 + 2], currentY, i16);
                i18 = iArr[currentY3 + 5];
                currentX2 = i18;
                i4 = currentX;
                ctrlPointY = currentY2;
                i16 = i11;
                currentY = i11;
            }
            current[i6] = currentX2;
            current[i14] = k4;
            current[i15] = i4;
            current[i195] = ctrlPointY;
            current[i196] = i10;
            current[i197] = i12;
        }

        private static void arcToBezier(Path p, double cx, double cy, double a, double b, double e1x, double e1y, double theta, double start, double sweep) {
            int e1x2;
            float f7;
            int i3;
            int i11;
            int eta1;
            long ep2y;
            double d7;
            int i4;
            double d8;
            int i10;
            double d3;
            float f4;
            double d11;
            float f2;
            int i9;
            int i2;
            long ep1x2;
            int ep1y;
            int ep1x;
            int eta12;
            int i5;
            double d5;
            double d9;
            double d;
            double d4;
            int i6;
            int i;
            double d2;
            int i8;
            double d6;
            double d10;
            Object obj;
            float f;
            float f3;
            float f9;
            float f8;
            float f5;
            float f6;
            int i7;
            int obj67;
            int obj69;
            e1x2 = e1x;
            long l = 4616189618054758400L;
            ep2y = 4614256656552045848L;
            int i23 = obj73;
            d7 = Math.cos(obj71);
            d8 = Math.sin(obj71);
            d3 = Math.cos(i23);
            d11 = Math.sin(i23);
            ep1y = i20;
            i3 = obj75 / ep1y2;
            eta12 = i23;
            i9 = i37;
            eta1 = sweep;
            ep1x = i34;
            ep1x2 = obj69;
            while (i9 < i11) {
                i5 = eta12 + i3;
                d5 = Math.sin(i5);
                d9 = Math.cos(i5);
                int anglePerSegment = i40 - i45;
                int numSegments = i43 + i47;
                d = d7;
                obj69 = i27;
                d4 = Math.tan(i52 /= l4);
                long l5 = 4613937818241073152L;
                i55 /= l5;
                int i12 = obj67 + i56;
                i8 = i30;
                int i31 = 0;
                Object sinEta1 = p;
                sinEta1.rLineTo(i31, i31);
                i7 = i12;
                sinEta1.cubicTo((float)i12, (float)ep2y, (float)i4, (float)i10, (float)anglePerSegment, (float)numSegments);
                eta12 = i5;
                ep1x2 = numSegments;
                ep1x = obj69;
                ep1y = i8;
                i9++;
                eta1 = i13;
                i11 = i2;
                d7 = d;
                i3 = i6;
                d11 = d2;
                d8 = d6;
                d3 = d10;
                e1x2 = e1x;
            }
        }

        private static void drawArc(Path p, float x0, float y0, float x1, float y1, float a, float b, float theta, boolean isMoreThanHalf, boolean isPositiveArc) {
            int cmp;
            int sweep;
            int cx;
            int i4;
            long i;
            int i3;
            int i2;
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
            i4 = isMoreThanHalf == i35 ? i53 + i29 : i53 - i29;
            i = i22;
            final double d26 = sqrt;
            final double atan22 = Math.atan2(i47 - i4, obj6);
            double atan2 = Math.atan2(i49 - i4, f2);
            sweep = atan2 - atan22;
            i3 = Double.compare(sweep, i) >= 0 ? 1 : 0;
            if (i35 != i3) {
                i = 4618760256179416344L;
                i2 = Double.compare(sweep, i) > 0 ? sweep : sweep;
            } else {
                i2 = sweep;
            }
            cx *= sweep2;
            i4 *= d9;
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
            int i2;
            float[] mParams;
            int i3;
            int i;
            this.mType = nodeFrom.mType;
            i2 = 0;
            while (i2 < mParams2.length) {
                this.mParams[i2] = i4 += i;
                i2++;
            }
        }
    }
    private static void addNode(ArrayList<androidx.core.graphics.PathParser.PathDataNode> arrayList, char cmd, float[] val) {
        PathParser.PathDataNode pathDataNode = new PathParser.PathDataNode(cmd, val);
        arrayList.add(pathDataNode);
    }

    public static boolean canMorph(androidx.core.graphics.PathParser.PathDataNode[] nodesFrom, androidx.core.graphics.PathParser.PathDataNode[] nodesTo) {
        int i;
        int length;
        int length2;
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
        int charAt2;
        int charAt;
        boolean floats;
        int fArr;
        start = 0;
        end = 1;
        ArrayList arrayList = new ArrayList();
        charAt = 0;
        while (end < pathData.length()) {
            int end2 = PathParser.nextStart(pathData, end);
            trim = pathData.substring(start, end2).trim();
            if (!trim.isEmpty()) {
            }
            start = end2;
            end2++;
            charAt = 0;
            PathParser.addNode(arrayList, trim.charAt(charAt), PathParser.getFloats(trim));
        }
        if (end - start == 1 && start < pathData.length()) {
            if (start < pathData.length()) {
                PathParser.addNode(arrayList, pathData.charAt(start), new float[charAt]);
            }
        }
        return (PathParser.PathDataNode[])arrayList.toArray(new PathParser.PathDataNode[charAt]);
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
        int i2;
        int i;
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
                i2 = 0;
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
                    fArr[i2] = Float.parseFloat(s.substring(startPosition, endPosition));
                    i2 = mEndPosition;
                }
            }
            return PathParser.copyOfRange(fArr, i3, i2);
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
        androidx.core.graphics.PathParser.PathDataNode pathDataNode2;
        androidx.core.graphics.PathParser.PathDataNode pathDataNode;
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
        int i2;
        int i;
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
