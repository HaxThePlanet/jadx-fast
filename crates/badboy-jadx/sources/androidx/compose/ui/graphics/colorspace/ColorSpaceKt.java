package androidx.compose.ui.graphics.colorspace;

import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0008\n\u0002\u0010\u0014\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0007\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a8\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0000\u001a\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00102\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0010H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0000\u001a*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001a\u001a\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0000\u001a\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0000\u001a\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0000\u001a\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0000\u001a)\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#H\u0080\u0008\u001a)\u0010'\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#H\u0080\u0008\u001a)\u0010(\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#H\u0080\u0008\u001a8\u0010)\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001aH\u0010)\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a8\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001aH\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u001e\u0010-\u001a\u00020\u0015*\u00020\u00152\u0006\u0010.\u001a\u00020\u00112\u0008\u0008\u0002\u0010/\u001a\u000200H\u0007\u001a(\u00101\u001a\u00020\u0013*\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000¢\u0006\u0004\u00082\u0010\u001a\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00063", d2 = {"absRcpResponse", "", "x", "a", "b", "c", "d", "g", "absResponse", "chromaticAdaptation", "", "matrix", "srcWhitePoint", "dstWhitePoint", "compare", "", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "createConnector", "Landroidx/compose/ui/graphics/colorspace/Connector;", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "createConnector-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)Landroidx/compose/ui/graphics/colorspace/Connector;", "inverse3x3", "m", "mul3x3", "lhs", "rhs", "mul3x3Diag", "mul3x3Float3", "mul3x3Float3_0", "", "r0", "r1", "r2", "mul3x3Float3_1", "mul3x3Float3_2", "rcpResponse", "e", "f", "response", "adapt", "whitePoint", "adaptation", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "connect", "connect-YBCOT_4", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorSpaceKt {
    public static final double absRcpResponse(double x, double a, double b, double c, double d, double g) {
        int cmp;
        int i;
        final int i2 = x;
        i = Double.compare(i2, i3) < 0 ? cmp : i2;
        return Math.copySign(ColorSpaceKt.rcpResponse(i, obj5, b, obj7, d, obj9), obj3);
    }

    public static final double absResponse(double x, double a, double b, double c, double d, double g) {
        int cmp;
        int i;
        final int i2 = x;
        i = Double.compare(i2, i3) < 0 ? cmp : i2;
        return Math.copySign(ColorSpaceKt.response(i, obj5, b, obj7, d, obj9), obj3);
    }

    public static final androidx.compose.ui.graphics.colorspace.ColorSpace adapt(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint2) {
        int i = 0;
        return ColorSpaceKt.adapt$default(colorSpace, whitePoint2, i, 2, i);
    }

    public static final androidx.compose.ui.graphics.colorspace.ColorSpace adapt(androidx.compose.ui.graphics.colorspace.ColorSpace $this$adapt, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint, androidx.compose.ui.graphics.colorspace.Adaptation adaptation) {
        Intrinsics.checkNotNull($this$adapt, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        Object obj = $this$adapt;
        if (ColorModel.equals-impl0($this$adapt.getModel-xdoWZVw(), obj1) && ColorSpaceKt.compare((Rgb)obj.getWhitePoint(), whitePoint)) {
            Intrinsics.checkNotNull($this$adapt, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            obj = $this$adapt;
            if (ColorSpaceKt.compare((Rgb)obj.getWhitePoint(), whitePoint)) {
                return $this$adapt;
            }
            Rgb rgb = new Rgb(obj, ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(adaptation.getTransform$ui_graphics_release(), obj.getWhitePoint().toXyz$ui_graphics_release(), whitePoint.toXyz$ui_graphics_release()), obj.getTransform$ui_graphics_release()), whitePoint);
            return (ColorSpace)rgb;
        }
        return $this$adapt;
    }

    public static androidx.compose.ui.graphics.colorspace.ColorSpace adapt$default(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint2, androidx.compose.ui.graphics.colorspace.Adaptation adaptation3, int i4, Object object5) {
        androidx.compose.ui.graphics.colorspace.Adaptation obj2;
        if (i4 &= 2 != 0) {
            obj2 = Adaptation.Companion.getBradford();
        }
        return ColorSpaceKt.adapt(colorSpace, whitePoint2, obj2);
    }

    public static final float[] chromaticAdaptation(float[] matrix, float[] srcWhitePoint, float[] dstWhitePoint) {
        final float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(matrix, srcWhitePoint);
        final float[] mul3x3Float32 = ColorSpaceKt.mul3x3Float3(matrix, dstWhitePoint);
        int i = 0;
        int i3 = 1;
        int i5 = 2;
        float[] fArr = new float[3];
        fArr[i] = f /= f2;
        fArr[i3] = f3 /= f4;
        fArr[i5] = f5 /= f6;
        return ColorSpaceKt.mul3x3(ColorSpaceKt.inverse3x3(matrix), ColorSpaceKt.mul3x3Diag(fArr, matrix));
    }

    public static final boolean compare(androidx.compose.ui.graphics.colorspace.TransferParameters a, androidx.compose.ui.graphics.colorspace.TransferParameters b) {
        int i;
        int cmp;
        long l;
        double gamma;
        l = 4562254508917369340L;
        if (b != null && Double.compare(d2, l) < 0 && Double.compare(d4, l) < 0 && Double.compare(d6, l) < 0 && Double.compare(d8, gamma) < 0 && Double.compare(d10, l) < 0 && Double.compare(d12, l) < 0 && Double.compare(d13, l) < 0) {
            l = 4562254508917369340L;
            if (Double.compare(d2, l) < 0) {
                if (Double.compare(d4, l) < 0) {
                    if (Double.compare(d6, l) < 0) {
                        if (Double.compare(d8, gamma) < 0) {
                            if (Double.compare(d10, l) < 0) {
                                if (Double.compare(d12, l) < 0) {
                                    i = Double.compare(d13, l) < 0 ? 1 : 0;
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final boolean compare(androidx.compose.ui.graphics.colorspace.WhitePoint a, androidx.compose.ui.graphics.colorspace.WhitePoint b) {
        int i;
        int cmp;
        float f;
        if (a == b) {
            return 1;
        }
        int i4 = 981668463;
        if (Float.compare(f3, i4) < 0 && Float.compare(f5, i4) < 0) {
            if (Float.compare(f5, i4) < 0) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final boolean compare(float[] a, float[] b) {
        int i;
        int compare;
        int i2;
        int i3 = 1;
        if (a == b) {
            return i3;
        }
        i = 0;
        while (i < a.length) {
            i++;
        }
        return i3;
    }

    public static final androidx.compose.ui.graphics.colorspace.Connector connect-YBCOT_4(androidx.compose.ui.graphics.colorspace.ColorSpace $this$connect_u2dYBCOT_4, androidx.compose.ui.graphics.colorspace.ColorSpace destination, int intent) {
        Object this_$iv;
        int $i$f$connectorKeyYBCOT_4;
        int i;
        Object $i$a$GetOrPutColorSpaceKt$connect$1;
        androidx.compose.ui.graphics.colorspace.Connector connector;
        int i2;
        final int id$ui_graphics_release = $this$connect_u2dYBCOT_4.getId$ui_graphics_release();
        final int id$ui_graphics_release2 = destination.getId$ui_graphics_release();
        if (id$ui_graphics_release | id$ui_graphics_release2 < 0) {
            this_$iv = ColorSpaceKt.createConnector-YBCOT_4($this$connect_u2dYBCOT_4, destination, intent);
        } else {
            MutableIntObjectMap connectors = ConnectorKt.getConnectors();
            int i4 = 0;
            $i$f$connectorKeyYBCOT_4 = i6 | i7;
            i = 0;
            if (connectors.get($i$f$connectorKeyYBCOT_4) == null) {
                int i8 = 0;
                i2 = 0;
                connectors.set($i$f$connectorKeyYBCOT_4, ColorSpaceKt.createConnector-YBCOT_4($this$connect_u2dYBCOT_4, destination, intent));
            }
            this_$iv = $i$a$GetOrPutColorSpaceKt$connect$1;
        }
        return this_$iv;
    }

    public static androidx.compose.ui.graphics.colorspace.Connector connect-YBCOT_4$default(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace, androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace2, int i3, int i4, Object object5) {
        androidx.compose.ui.graphics.colorspace.Rgb obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = ColorSpaces.INSTANCE.getSrgb();
        }
        if (i4 &= 2 != 0) {
            obj2 = RenderIntent.Companion.getPerceptual-uksYyKA();
        }
        return ColorSpaceKt.connect-YBCOT_4(colorSpace, obj1, obj2);
    }

    private static final androidx.compose.ui.graphics.colorspace.Connector createConnector-YBCOT_4(androidx.compose.ui.graphics.colorspace.ColorSpace source, androidx.compose.ui.graphics.colorspace.ColorSpace destination, int intent) {
        androidx.compose.ui.graphics.colorspace.Connector identity$ui_graphics_release;
        boolean equals-impl0;
        long l2;
        Object model-xdoWZVw;
        long l;
        long rgb-xdoWZVw;
        if (source == destination) {
            identity$ui_graphics_release = Connector.Companion.identity$ui_graphics_release(source);
        } else {
            l2 = 0;
            if (ColorModel.equals-impl0(source.getModel-xdoWZVw(), obj1) && ColorModel.equals-impl0(destination.getModel-xdoWZVw(), obj3)) {
                if (ColorModel.equals-impl0(destination.getModel-xdoWZVw(), obj3)) {
                    String str = "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb";
                    Intrinsics.checkNotNull(source, str);
                    Intrinsics.checkNotNull(destination, str);
                    identity$ui_graphics_release = new Connector.RgbConnector((Rgb)source, (Rgb)destination, intent, l2);
                } else {
                    identity$ui_graphics_release = new Connector(source, destination, intent, l2);
                }
            } else {
            }
        }
        return identity$ui_graphics_release;
    }

    public static final float[] inverse3x3(float[] m) {
        final int[] iArr = m;
        int i = 0;
        final int i2 = iArr[i];
        int i3 = 3;
        final int i19 = iArr[i3];
        int i20 = 6;
        final int i23 = iArr[i20];
        int i24 = 1;
        final int i32 = iArr[i24];
        final int i33 = 4;
        final int i34 = iArr[i33];
        final int i35 = 7;
        final int i36 = iArr[i35];
        int i37 = 2;
        final int i39 = iArr[i37];
        final int i40 = 5;
        final int i41 = iArr[i40];
        final int i42 = 8;
        final int i43 = iArr[i42];
        i44 -= i46;
        i47 -= i49;
        i50 -= i52;
        i54 += i57;
        float[] fArr = new float[iArr.length];
        fArr[i] = i45 / i55;
        fArr[i24] = i48 / i55;
        fArr[i37] = i51 / i55;
        fArr[i3] = i27 /= i55;
        fArr[i33] = i5 /= i55;
        fArr[i40] = i8 /= i55;
        fArr[i20] = i11 /= i55;
        fArr[i35] = i14 /= i55;
        fArr[i42] = i17 /= i55;
        return fArr;
    }

    public static final float[] mul3x3(float[] lhs, float[] rhs) {
        float[] fArr = new float[9];
        int i2 = 0;
        int i55 = 3;
        final int i65 = 1;
        int i64 = 6;
        final int i71 = 2;
        fArr[i2] = i17 += i68;
        int i70 = 4;
        int i75 = 7;
        fArr[i65] = i21 += i78;
        int i80 = 5;
        int i84 = 8;
        fArr[i71] = i25 += i87;
        fArr[i55] = i29 += i92;
        fArr[i70] = i33 += i97;
        fArr[i80] = i37 += i102;
        fArr[i64] = i5 += i43;
        fArr[i75] = i9 += i48;
        fArr[i84] = i13 += i53;
        return fArr;
    }

    public static final float[] mul3x3Diag(float[] lhs, float[] rhs) {
        int i = 0;
        int i6 = 1;
        int i10 = 2;
        final int i16 = 3;
        final int i20 = 4;
        final int i24 = 5;
        final int i28 = 6;
        final int i32 = 7;
        final int i36 = 8;
        float[] fArr = new float[9];
        fArr[i] = i3 *= i5;
        fArr[i6] = i7 *= i9;
        fArr[i10] = i11 *= i13;
        fArr[i16] = i14 *= i17;
        fArr[i20] = i18 *= i21;
        fArr[i24] = i22 *= i25;
        fArr[i28] = i26 *= i29;
        fArr[i32] = i30 *= i33;
        fArr[i36] = i34 *= i37;
        return fArr;
    }

    public static final float[] mul3x3Float3(float[] lhs, float[] rhs) {
        int i = 0;
        final int i10 = rhs[i];
        int i11 = 1;
        final int i18 = rhs[i11];
        final int i19 = 2;
        final int i20 = rhs[i19];
        rhs[i] = i23 += i36;
        rhs[i11] = i4 += i30;
        rhs[i19] = i8 += i17;
        return rhs;
    }

    public static final float mul3x3Float3_0(float[] lhs, float r0, float r1, float r2) {
        final int i = 0;
        return i5 += i12;
    }

    public static final float mul3x3Float3_1(float[] lhs, float r0, float r1, float r2) {
        final int i = 0;
        return i5 += i12;
    }

    public static final float mul3x3Float3_2(float[] lhs, float r0, float r1, float r2) {
        final int i = 0;
        return i5 += i12;
    }

    public static final double rcpResponse(double x, double a, double b, double c, double d, double g) {
        int i;
        if (Double.compare(x, i2) >= 0) {
            i4 /= b;
        } else {
            i = x / obj8;
        }
        return i;
    }

    public static final double rcpResponse(double x, double a, double b, double c, double d, double e, double f, double g) {
        int i;
        int i2;
        if (Double.compare(x, i3) >= 0) {
            i5 /= b;
        } else {
            i6 /= f;
        }
        return i;
    }

    public static final double response(double x, double a, double b, double c, double d, double g) {
        double d2;
        if (Double.compare(x, obj10) >= 0) {
            d2 = Math.pow(i += d, obj1);
        } else {
            d2 = obj8 * x;
        }
        return d2;
    }

    public static final double response(double x, double a, double b, double c, double d, double e, double f, double g) {
        int i;
        double d2;
        if (Double.compare(x, obj12) >= 0) {
            d3 += obj14;
        } else {
            d2 = obj18;
            i4 += obj16;
        }
        return i;
    }
}
