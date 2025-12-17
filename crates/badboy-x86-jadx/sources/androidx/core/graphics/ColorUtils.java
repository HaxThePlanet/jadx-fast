package androidx.core.graphics;

import android.app.Notification.Action;
import android.graphics.Color;
import androidx.core.content.res.CamColor;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class ColorUtils {

    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final java.lang.ThreadLocal<double[]> TEMP_ARRAY = null;
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    static class Api26Impl {
        static Color compositeColors(Color foreground, Color background) {
            Color convert;
            float sa;
            int da;
            int cmp;
            int i2;
            int i3;
            int i;
            if (!Objects.equals(foreground.getModel(), background.getModel())) {
            } else {
                if (Objects.equals(background.getColorSpace(), foreground.getColorSpace())) {
                    convert = foreground;
                } else {
                    convert = foreground.convert(background.getColorSpace());
                }
                float[] components2 = background.getComponents();
                sa = convert.alpha();
                alpha *= i5;
                componentCount--;
                components2[i6] = sa + da;
                if (Float.compare(f, i3) > 0) {
                    sa /= f2;
                    da /= cmp;
                }
                i2 = 0;
                while (i2 < i6) {
                    components2[i2] = i8 += i;
                    i2++;
                }
                return Color.valueOf(components2, background.getColorSpace());
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException s = new IllegalArgumentException(stringBuilder.append("Color models must match (").append(foreground.getModel()).append(" vs. ").append(background.getModel()).append(")").toString());
            throw s;
        }
    }
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        ColorUtils.TEMP_ARRAY = threadLocal;
    }

    public static int HSLToColor(float[] hsl) {
        int r;
        int g;
        int b;
        int i;
        int i2;
        int i3 = 0;
        final int i4 = hsl[i3];
        int i8 = hsl[2];
        int i9 = 1073741824;
        int i16 = 1065353216;
        i14 *= i6;
        int i21 = i8 - i20;
        i17 *= i15;
        r = 0;
        g = 0;
        b = 0;
        i = 1132396544;
        switch (i11) {
            case 0:
                r = Math.round(i28 *= i);
                g = Math.round(i30 *= i);
                b = Math.round(i *= i21);
                break;
            case 1:
                r = Math.round(i35 *= i);
                g = Math.round(i37 *= i);
                b = Math.round(i *= i21);
                break;
            case 2:
                r = Math.round(i21 * i);
                g = Math.round(i43 *= i);
                b = Math.round(i45 *= i);
                break;
            case 3:
                r = Math.round(i21 * i);
                g = Math.round(i47 *= i);
                b = Math.round(i49 *= i);
                break;
            case 4:
                r = Math.round(i31 *= i);
                g = Math.round(i21 * i);
                b = Math.round(i34 *= i);
                break;
            case 5:
                r = Math.round(i38 *= i);
                g = Math.round(i21 * i);
                b = Math.round(i41 *= i);
                break;
            default:
        }
        int i27 = 255;
        return Color.rgb(ColorUtils.constrain(r, i3, i27), ColorUtils.constrain(g, i3, i27), ColorUtils.constrain(b, i3, i27));
    }

    public static int LABToColor(double l, double a, double b) {
        final double[] tempDouble3Array = ColorUtils.getTempDouble3Array();
        ColorUtils.LABToXYZ(l, obj1, b, obj3);
        return ColorUtils.XYZToColor(tempDouble3Array[0], obj8, tempDouble3Array[1]);
    }

    public static void LABToXYZ(double l, double a, double b, double[] outXyz) {
        double d;
        int i2;
        int i;
        long l2 = 4625196817309499392L;
        long l6 = 4637863191261478912L;
        i6 /= l6;
        i10 += i7;
        int i13 = i7 - i12;
        long l9 = 4613937818241073152L;
        double d3 = Math.pow(i11, obj7);
        final long l10 = 4576258758203452558L;
        final long l11 = 4651156726645941862L;
        if (Double.compare(d3, l10) > 0) {
            i2 = d3;
        } else {
            i18 /= l11;
        }
        if (Double.compare(l, l12) > 0) {
            i = Math.pow(i7, obj3);
        } else {
            i = l / l11;
        }
        double d2 = Math.pow(i13, obj9);
        if (Double.compare(d2, l10) > 0) {
            d = d2;
        } else {
            i9 /= l11;
        }
        obj29[0] = l3 *= i2;
        obj29[1] = l4 *= i;
        obj29[2] = l5 *= d;
    }

    public static int M3HCTToColor(float hue, float chroma, float tone) {
        return CamColor.toColor(hue, chroma, tone);
    }

    public static void RGBToHSL(int r, int g, int b, float[] outHsl) {
        int i2;
        int i3;
        int i;
        int h;
        int i5 = 1132396544;
        f /= i5;
        f4 /= i5;
        f5 /= i5;
        float f3 = Math.max(i4, Math.max(i6, i7));
        float f7 = Math.min(i4, Math.min(i6, i7));
        final int i8 = f3 - f7;
        int i11 = 1073741824;
        i9 /= i11;
        int i23 = 1065353216;
        final int i24 = 0;
        if (Float.compare(f3, f7) == 0) {
            i2 = i24;
            i3 = i24;
        } else {
            if (Float.compare(f3, i4) == 0) {
                i16 %= i;
            } else {
                if (Float.compare(f3, i6) == 0) {
                    i19 += i11;
                } else {
                    i17 += i;
                }
            }
            i2 = i8 / i14;
        }
        int i27 = 1135869952;
        i26 %= i27;
        if (Float.compare(h, i24) < 0) {
            h += i27;
        }
        outHsl[0] = ColorUtils.constrain(h, i24, i27);
        outHsl[1] = ColorUtils.constrain(i2, i24, i23);
        outHsl[2] = ColorUtils.constrain(i10, i24, i23);
    }

    public static void RGBToLAB(int r, int g, int b, double[] outLab) {
        ColorUtils.RGBToXYZ(r, g, b, outLab);
        ColorUtils.XYZToLAB(outLab[0], obj2, outLab[1], obj4);
    }

    public static void RGBToXYZ(int r, int g, int b, double[] outXyz) {
        int l3;
        int l2;
        double d;
        int l;
        double d3;
        long l5;
        double d2;
        long l4;
        final int[] iArr = outXyz;
        if (iArr.length != 3) {
        } else {
            l3 = 4643176031446892544L;
            d4 /= l3;
            l2 = 4585990280393462802L;
            final long l11 = 4623462931452961751L;
            final long l16 = 4612586738352862003L;
            final long l17 = 4607430116779522785L;
            l = 4588087156379966505L;
            if (Double.compare(i2, l2) < 0) {
                d3 = i2 / l11;
                l5 = l3;
            } else {
                l5 = l3;
                d3 = Math.pow(i27 / l17, obj5);
            }
            d5 /= l5;
            if (Double.compare(i3, l2) < 0) {
                d2 = i3 / l11;
                l4 = l2;
            } else {
                l4 = l2;
                d2 = Math.pow(i28 / l17, obj7);
            }
            d6 /= l5;
            if (Double.compare(i4, l4) < 0) {
                d = i4 / l11;
            } else {
                d = Math.pow(l / l17, obj7);
            }
            long l10 = 4636737291354636288L;
            iArr[0] = i7 *= l10;
            iArr[1] = i11 *= l10;
            iArr[2] = i15 *= l10;
        }
        Object obj = r;
        Object obj3 = g;
        Object obj4 = b;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("outXyz must have a length of 3.");
        throw illegalArgumentException;
    }

    public static int XYZToColor(double x, double y, double z) {
        int i;
        int i2;
        int i3;
        long l4 = 4636737291354636288L;
        i6 /= l4;
        i14 /= l4;
        i23 /= l4;
        long l5 = 4569365555819558681L;
        long l13 = 4588087156379966505L;
        final long l14 = 4601177619296856747L;
        final long l15 = 4607430116779522785L;
        final long l16 = 4623462931452961751L;
        if (Double.compare(i7, l5) > 0) {
            i33 -= l13;
        } else {
            i3 = i7 * l16;
        }
        if (Double.compare(i15, l5) > 0) {
            i8 -= l13;
        } else {
            i = i15 * l16;
        }
        if (Double.compare(i24, l5) > 0) {
            i11 -= l13;
        } else {
            i2 = i24 * l16;
        }
        long l7 = 4643176031446892544L;
        final int i27 = 0;
        int i30 = 255;
        return Color.rgb(ColorUtils.constrain((int)round2, i27, i30), ColorUtils.constrain((int)round3, i27, i30), ColorUtils.constrain((int)round, i27, i30));
    }

    public static void XYZToLAB(double x, double y, double z, double[] outLab) {
        int i8 = 3;
        if (obj10.length != i8) {
        } else {
            final double obj6 = ColorUtils.pivotXyzComponent(z / l2);
            obj10[0] = Math.max(0, obj3);
            obj10[1] = i11 *= l5;
            obj10[2] = i13 *= l6;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("outLab must have a length of 3.");
        throw illegalArgumentException;
    }

    public static int blendARGB(int color1, int color2, float ratio) {
        i -= ratio;
        return Color.argb((int)i4, (int)i8, (int)i12, (int)i15);
    }

    public static void blendHSL(float[] hsl1, float[] hsl2, float ratio, float[] outResult) {
        if (outResult.length != 3) {
        } else {
            i -= ratio;
            int i4 = 0;
            outResult[i4] = ColorUtils.circularInterpolate(hsl1[i4], hsl2[i4], ratio);
            int i5 = 1;
            outResult[i5] = i9 += i16;
            int i6 = 2;
            outResult[i6] = i12 += i18;
        }
        IllegalArgumentException inverseRatio = new IllegalArgumentException("result must have a length of 3.");
        throw inverseRatio;
    }

    public static void blendLAB(double[] lab1, double[] lab2, double ratio, double[] outResult) {
        if (obj11.length != 3) {
        } else {
            l -= ratio;
            int i3 = 0;
            obj11[i3] = i6 += i12;
            int i4 = 1;
            obj11[i4] = i8 += i13;
            int i5 = 2;
            obj11[i5] = i10 += i14;
        }
        IllegalArgumentException inverseRatio = new IllegalArgumentException("outResult must have a length of 3.");
        throw inverseRatio;
    }

    public static double calculateContrast(int foreground, int background) {
        int obj8;
        int i2 = 255;
        if (Color.alpha(background) != i2) {
        } else {
            if (Color.alpha(foreground) < i2) {
                obj8 = ColorUtils.compositeColors(foreground, background);
            }
            long l = 4587366580439587226L;
            luminance += l;
            luminance2 += l;
            return d /= d2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException luminance1 = new IllegalArgumentException(stringBuilder.append("background can not be translucent: #").append(Integer.toHexString(background)).toString());
        throw luminance1;
    }

    public static double calculateLuminance(int color) {
        final double[] tempDouble3Array = ColorUtils.getTempDouble3Array();
        ColorUtils.colorToXYZ(color, tempDouble3Array);
        return d /= l;
    }

    public static int calculateMinimumAlpha(int foreground, int background, float minContrastRatio) {
        int testForeground;
        double testRatio;
        int numIterations;
        int minAlpha;
        int maxAlpha;
        int i;
        int i2;
        int cmp;
        int i3 = 255;
        if (Color.alpha(background) != i3) {
        } else {
            if (Double.compare(testRatio, d) < 0) {
                return -1;
            }
            numIterations = 0;
            minAlpha = 0;
            maxAlpha = 255;
            while (numIterations <= 10) {
                if (maxAlpha - minAlpha > 1) {
                }
                i5 /= 2;
                if (Double.compare(testRatio, d2) < 0) {
                } else {
                }
                maxAlpha = i;
                numIterations++;
                minAlpha = i;
            }
            return maxAlpha;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException testForeground2 = new IllegalArgumentException(stringBuilder.append("background can not be translucent: #").append(Integer.toHexString(background)).toString());
        throw testForeground2;
    }

    static float circularInterpolate(float a, float b, float f) {
        int cmp;
        int obj2;
        int obj3;
        int i7 = 1135869952;
        if (Float.compare(f2, i6) > 0) {
            if (Float.compare(b, a) > 0) {
                a += i7;
            } else {
                b += i7;
            }
        }
        return i4 %= i7;
    }

    public static void colorToHSL(int color, float[] outHsl) {
        ColorUtils.RGBToHSL(Color.red(color), Color.green(color), Color.blue(color), outHsl);
    }

    public static void colorToLAB(int color, double[] outLab) {
        ColorUtils.RGBToLAB(Color.red(color), Color.green(color), Color.blue(color), outLab);
    }

    public static void colorToM3HCT(int color, float[] outM3HCT) {
        CamColor.getM3HCTfromColor(color, outM3HCT);
    }

    public static void colorToXYZ(int color, double[] outXyz) {
        ColorUtils.RGBToXYZ(Color.red(color), Color.green(color), Color.blue(color), outXyz);
    }

    private static int compositeAlpha(int foregroundAlpha, int backgroundAlpha) {
        return i3 - 255;
    }

    public static int compositeColors(int foreground, int background) {
        final int alpha = Color.alpha(background);
        final int alpha2 = Color.alpha(foreground);
        final int compositeAlpha = ColorUtils.compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, ColorUtils.compositeComponent(Color.red(foreground), alpha2, Color.red(background), alpha, compositeAlpha), ColorUtils.compositeComponent(Color.green(foreground), alpha2, Color.green(background), alpha, compositeAlpha), ColorUtils.compositeComponent(Color.blue(foreground), alpha2, Color.blue(background), alpha, compositeAlpha));
    }

    public static Color compositeColors(Color foreground, Color background) {
        return ColorUtils.Api26Impl.compositeColors(foreground, background);
    }

    private static int compositeComponent(int fgC, int fgA, int bgC, int bgA, int a) {
        if (a == 0) {
            return 0;
        }
        return i4 /= i8;
    }

    private static float constrain(float amount, float low, float high) {
        float f;
        if (Float.compare(amount, low) < 0) {
            f = low;
        } else {
            f = Math.min(amount, high);
        }
        return f;
    }

    private static int constrain(int amount, int low, int high) {
        int i;
        if (amount < low) {
            i = low;
        } else {
            i = Math.min(amount, high);
        }
        return i;
    }

    public static double distanceEuclidean(double[] labX, double[] labY) {
        int i = 0;
        l -= l2;
        long l3 = 4611686018427387904L;
        int i5 = 1;
        int i6 = 2;
        return Math.sqrt(i2 += d2);
    }

    private static double[] getTempDouble3Array() {
        Object result;
        java.lang.ThreadLocal tEMP_ARRAY;
        if ((double[])ColorUtils.TEMP_ARRAY.get() == null) {
            ColorUtils.TEMP_ARRAY.set(new double[3]);
        }
        return result;
    }

    private static double pivotXyzComponent(double component) {
        double d;
        long l;
        if (Double.compare(component, l2) > 0) {
            d = Math.pow(component, obj5);
        } else {
            i2 /= l;
        }
        return d;
    }

    public static int setAlphaComponent(int color, int alpha) {
        int i;
        if (alpha < 0) {
        } else {
            if (alpha > 255) {
            } else {
                return i3 |= i5;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("alpha must be between 0 and 255.");
        throw illegalArgumentException;
    }
}
