package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.ColorSpace.Rgb;
import android.graphics.ColorSpace.Rgb.TransferParameters;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import java.util.function.DoubleUnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000c\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007J\u000c\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¨\u0006\u0007", d2 = {"Landroidx/compose/ui/graphics/ColorSpaceVerificationHelper;", "", "()V", "androidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "composeColorSpace", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ColorSpaceVerificationHelper {

    public static final androidx.compose.ui.graphics.ColorSpaceVerificationHelper INSTANCE;
    public static double $r8$lambda$Irw4oKyb7XtLgnYIGuQJGbarVTU(ColorSpace colorSpace, double d2) {
        return ColorSpaceVerificationHelper.composeColorSpace$lambda$3(colorSpace, d2);
    }

    public static double $r8$lambda$MCOmJu2vENBCibZhFN9r_u-vJk0(Function1 function1, double d2) {
        return ColorSpaceVerificationHelper.androidColorSpace$lambda$0(function1, d2);
    }

    public static double $r8$lambda$YYrMr3f_0vhPsnRJrur1NVokAtM(Function1 function1, double d2) {
        return ColorSpaceVerificationHelper.androidColorSpace$lambda$1(function1, d2);
    }

    public static double $r8$lambda$gD9Boogs5cOtsMRjJW8JLOajuN4(ColorSpace colorSpace, double d2) {
        return ColorSpaceVerificationHelper.composeColorSpace$lambda$2(colorSpace, d2);
    }

    static {
        ColorSpaceVerificationHelper colorSpaceVerificationHelper = new ColorSpaceVerificationHelper();
        ColorSpaceVerificationHelper.INSTANCE = colorSpaceVerificationHelper;
    }

    @JvmStatic
    public static final ColorSpace androidColorSpace(ColorSpace $this$androidColorSpace) {
        Object transferParams;
        ColorSpace.Rgb rgb;
        String name;
        float[] primaries$ui_graphics_release;
        float[] xyz$ui_graphics_release;
        ColorSpace.Rgb.TransferParameters transferParameters;
        double externalSyntheticLambda1;
        double minValue;
        double d4;
        double transferParameters2;
        double d2;
        double d;
        double d3;
        double d5;
        double gamma;
        androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda0 externalSyntheticLambda0;
        final Object obj = $this$androidColorSpace;
        if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getSrgb())) {
            transferParams = ColorSpace.get(ColorSpace.Named.SRGB);
        } else {
            if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getAces())) {
                transferParams = ColorSpace.get(ColorSpace.Named.ACES);
            } else {
                if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getAcescg())) {
                    transferParams = ColorSpace.get(ColorSpace.Named.ACESCG);
                } else {
                    if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getAdobeRgb())) {
                        transferParams = ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
                    } else {
                        if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getBt2020())) {
                            transferParams = ColorSpace.get(ColorSpace.Named.BT2020);
                        } else {
                            if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getBt709())) {
                                transferParams = ColorSpace.get(ColorSpace.Named.BT709);
                            } else {
                                if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getCieLab())) {
                                    transferParams = ColorSpace.get(ColorSpace.Named.CIE_LAB);
                                } else {
                                    if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getCieXyz())) {
                                        transferParams = ColorSpace.get(ColorSpace.Named.CIE_XYZ);
                                    } else {
                                        if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getDciP3())) {
                                            transferParams = ColorSpace.get(ColorSpace.Named.DCI_P3);
                                        } else {
                                            if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getDisplayP3())) {
                                                transferParams = ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
                                            } else {
                                                if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getExtendedSrgb())) {
                                                    transferParams = ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
                                                } else {
                                                    if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getLinearExtendedSrgb())) {
                                                        transferParams = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
                                                    } else {
                                                        if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getLinearSrgb())) {
                                                            transferParams = ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
                                                        } else {
                                                            if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getNtsc1953())) {
                                                                transferParams = ColorSpace.get(ColorSpace.Named.NTSC_1953);
                                                            } else {
                                                                if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getProPhotoRgb())) {
                                                                    transferParams = ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
                                                                } else {
                                                                    if (Intrinsics.areEqual(obj, ColorSpaces.INSTANCE.getSmpteC())) {
                                                                        transferParams = ColorSpace.get(ColorSpace.Named.SMPTE_C);
                                                                    } else {
                                                                        if (obj instanceof Rgb) {
                                                                            xyz$ui_graphics_release = (Rgb)obj.getWhitePoint().toXyz$ui_graphics_release();
                                                                            TransferParameters transferParameters3 = (Rgb)obj.getTransferParameters();
                                                                            if (transferParameters3 != null) {
                                                                                transferParameters = new ColorSpace.Rgb.TransferParameters(transferParameters3.getA(), obj8, transferParameters3.getB(), obj10, transferParameters3.getC(), obj12, transferParameters3.getD(), obj14, transferParameters3.getE(), obj16, transferParameters3.getF(), obj18, transferParameters3.getGamma(), obj20);
                                                                            } else {
                                                                                transferParameters = 0;
                                                                            }
                                                                            transferParameters2 = transferParameters;
                                                                            if (transferParameters2 != null) {
                                                                                rgb = new ColorSpace.Rgb(obj.getName(), (Rgb)obj.getPrimaries$ui_graphics_release(), xyz$ui_graphics_release, transferParameters2);
                                                                            } else {
                                                                                ColorSpaceVerificationHelper$$ExternalSyntheticLambda0 externalSyntheticLambda02 = new ColorSpaceVerificationHelper$$ExternalSyntheticLambda0((Rgb)obj.getOetf());
                                                                                externalSyntheticLambda1 = new ColorSpaceVerificationHelper$$ExternalSyntheticLambda1((Rgb)obj.getEotf());
                                                                                int i = 0;
                                                                                rgb = new ColorSpace.Rgb(obj.getName(), (Rgb)obj.getPrimaries$ui_graphics_release(), xyz$ui_graphics_release, externalSyntheticLambda02, externalSyntheticLambda1, obj.getMinValue(i), obj.getMaxValue(i));
                                                                            }
                                                                            transferParams = rgb;
                                                                        } else {
                                                                            transferParams = ColorSpace.get(ColorSpace.Named.SRGB);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return transferParams;
    }

    private static final double androidColorSpace$lambda$0(Function1 $tmp0, double p0) {
        return (Number)$tmp0.invoke(Double.valueOf(p0)).doubleValue();
    }

    private static final double androidColorSpace$lambda$1(Function1 $tmp0, double p0) {
        return (Number)$tmp0.invoke(Double.valueOf(p0)).doubleValue();
    }

    @JvmStatic
    public static final ColorSpace composeColorSpace(ColorSpace $this$composeColorSpace) {
        Object transferParameters3;
        ColorSpace linearExtendedSrgb;
        WhitePoint whitePoint2;
        int ordinal;
        float f;
        float f2;
        int i;
        double i2;
        float whitePoint3;
        Rgb srgb;
        int name;
        float[] primaries;
        WhitePoint whitePoint;
        TransferParameters transferParameters;
        float[] transform;
        double externalSyntheticLambda2;
        double externalSyntheticLambda3;
        double minValue;
        double maxValue;
        TransferParameters transferParameters2;
        double d2;
        double d4;
        double d5;
        double d3;
        double d;
        final Object obj = $this$composeColorSpace;
        int id = obj.getId();
        if (id == ColorSpace.Named.SRGB.ordinal()) {
            linearExtendedSrgb = ColorSpaces.INSTANCE.getSrgb();
        } else {
            if (id == ColorSpace.Named.ACES.ordinal()) {
                linearExtendedSrgb = ColorSpaces.INSTANCE.getAces();
            } else {
                if (id == ColorSpace.Named.ACESCG.ordinal()) {
                    linearExtendedSrgb = ColorSpaces.INSTANCE.getAcescg();
                } else {
                    if (id == ColorSpace.Named.ADOBE_RGB.ordinal()) {
                        linearExtendedSrgb = ColorSpaces.INSTANCE.getAdobeRgb();
                    } else {
                        if (id == ColorSpace.Named.BT2020.ordinal()) {
                            linearExtendedSrgb = ColorSpaces.INSTANCE.getBt2020();
                        } else {
                            if (id == ColorSpace.Named.BT709.ordinal()) {
                                linearExtendedSrgb = ColorSpaces.INSTANCE.getBt709();
                            } else {
                                if (id == ColorSpace.Named.CIE_LAB.ordinal()) {
                                    linearExtendedSrgb = ColorSpaces.INSTANCE.getCieLab();
                                } else {
                                    if (id == ColorSpace.Named.CIE_XYZ.ordinal()) {
                                        linearExtendedSrgb = ColorSpaces.INSTANCE.getCieXyz();
                                    } else {
                                        if (id == ColorSpace.Named.DCI_P3.ordinal()) {
                                            linearExtendedSrgb = ColorSpaces.INSTANCE.getDciP3();
                                        } else {
                                            if (id == ColorSpace.Named.DISPLAY_P3.ordinal()) {
                                                linearExtendedSrgb = ColorSpaces.INSTANCE.getDisplayP3();
                                            } else {
                                                if (id == ColorSpace.Named.EXTENDED_SRGB.ordinal()) {
                                                    linearExtendedSrgb = ColorSpaces.INSTANCE.getExtendedSrgb();
                                                } else {
                                                    if (id == ColorSpace.Named.LINEAR_EXTENDED_SRGB.ordinal()) {
                                                        linearExtendedSrgb = ColorSpaces.INSTANCE.getLinearExtendedSrgb();
                                                    } else {
                                                        if (id == ColorSpace.Named.LINEAR_SRGB.ordinal()) {
                                                            linearExtendedSrgb = ColorSpaces.INSTANCE.getLinearSrgb();
                                                        } else {
                                                            if (id == ColorSpace.Named.NTSC_1953.ordinal()) {
                                                                linearExtendedSrgb = ColorSpaces.INSTANCE.getNtsc1953();
                                                            } else {
                                                                if (id == ColorSpace.Named.PRO_PHOTO_RGB.ordinal()) {
                                                                    linearExtendedSrgb = ColorSpaces.INSTANCE.getProPhotoRgb();
                                                                } else {
                                                                    if (id == ColorSpace.Named.SMPTE_C.ordinal()) {
                                                                        linearExtendedSrgb = ColorSpaces.INSTANCE.getSmpteC();
                                                                    } else {
                                                                        if (obj instanceof ColorSpace.Rgb) {
                                                                            transferParameters3 = (ColorSpace.Rgb)obj.getTransferParameters();
                                                                            int i4 = 1;
                                                                            i2 = 0;
                                                                            if (whitePoint4.length == 3) {
                                                                                whitePoint2 = new WhitePoint((ColorSpace.Rgb)obj.getWhitePoint()[i2], (ColorSpace.Rgb)obj.getWhitePoint()[i4], (ColorSpace.Rgb)obj.getWhitePoint()[2]);
                                                                            } else {
                                                                                whitePoint2 = new WhitePoint((ColorSpace.Rgb)obj.getWhitePoint()[i2], (ColorSpace.Rgb)obj.getWhitePoint()[i4]);
                                                                            }
                                                                            if (transferParameters3 != null) {
                                                                                transferParameters = new TransferParameters(transferParameters3.g, obj12, transferParameters3.a, obj14, transferParameters3.b, obj16, transferParameters3.c, obj18, transferParameters3.d, obj20, transferParameters3.e, obj22, transferParameters3.f, obj24);
                                                                                transferParameters2 = transferParameters;
                                                                            } else {
                                                                                transferParameters2 = transferParameters;
                                                                            }
                                                                            externalSyntheticLambda2 = new ColorSpaceVerificationHelper$$ExternalSyntheticLambda2(obj);
                                                                            externalSyntheticLambda3 = new ColorSpaceVerificationHelper$$ExternalSyntheticLambda3(obj);
                                                                            i = 0;
                                                                            srgb = new Rgb((ColorSpace.Rgb)obj.getName(), (ColorSpace.Rgb)obj.getPrimaries(), whitePoint2, (ColorSpace.Rgb)obj.getTransform(), externalSyntheticLambda2, externalSyntheticLambda3, obj.getMinValue(i), obj.getMaxValue(i), transferParameters2, (ColorSpace.Rgb)obj.getId());
                                                                        } else {
                                                                            srgb = ColorSpaces.INSTANCE.getSrgb();
                                                                        }
                                                                        linearExtendedSrgb = srgb;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return linearExtendedSrgb;
    }

    private static final double composeColorSpace$lambda$2(ColorSpace $this_composeColorSpace, double x) {
        return (ColorSpace.Rgb)$this_composeColorSpace.getOetf().applyAsDouble(x);
    }

    private static final double composeColorSpace$lambda$3(ColorSpace $this_composeColorSpace, double x) {
        return (ColorSpace.Rgb)$this_composeColorSpace.getEotf().applyAsDouble(x);
    }
}
