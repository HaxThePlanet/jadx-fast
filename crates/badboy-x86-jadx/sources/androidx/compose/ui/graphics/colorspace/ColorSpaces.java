package androidx.compose.ui.graphics.colorspace;

import android.text.TextPaint;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap.Empty;
import androidx.compose.foundation.lazy.layout.PrefetchMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0002\u0008\u0013\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=H\u0080\u0008¢\u0006\u0002\u0008>J\u001a\u0010?\u001a\u0004\u0018\u00010\u00102\u0008\u0008\u0001\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020%R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0006R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0006R\u0011\u0010 \u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0006R\u0011\u0010\"\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0006R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u0006R\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0011\u0010,\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u0012R\u0011\u0010.\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010\u0006R\u0011\u00100\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u0006R\u0011\u00102\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\u0006R\u0014\u00104\u001a\u00020)X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010+R\u0014\u00106\u001a\u00020%X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u0014\u00109\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010\u0006¨\u0006B", d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpaces;", "", "()V", "Aces", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "getAces", "()Landroidx/compose/ui/graphics/colorspace/Rgb;", "Acescg", "getAcescg", "AdobeRgb", "getAdobeRgb", "Bt2020", "getBt2020", "Bt709", "getBt709", "CieLab", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getCieLab", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "CieXyz", "getCieXyz", "ColorSpacesArray", "", "getColorSpacesArray$ui_graphics_release", "()[Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "[Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "DciP3", "getDciP3", "DisplayP3", "getDisplayP3", "ExtendedSrgb", "getExtendedSrgb", "LinearExtendedSrgb", "getLinearExtendedSrgb", "LinearSrgb", "getLinearSrgb", "NoneTransferParameters", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "Ntsc1953", "getNtsc1953", "Ntsc1953Primaries", "", "getNtsc1953Primaries$ui_graphics_release", "()[F", "Oklab", "getOklab", "ProPhotoRgb", "getProPhotoRgb", "SmpteC", "getSmpteC", "Srgb", "getSrgb", "SrgbPrimaries", "getSrgbPrimaries$ui_graphics_release", "SrgbTransferParameters", "getSrgbTransferParameters$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "Unspecified", "getUnspecified$ui_graphics_release", "getColorSpace", "id", "", "getColorSpace$ui_graphics_release", "match", "toXYZD50", "function", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ColorSpaces {

    private static final androidx.compose.ui.graphics.colorspace.Rgb Aces;
    private static final androidx.compose.ui.graphics.colorspace.Rgb Acescg;
    private static final androidx.compose.ui.graphics.colorspace.Rgb AdobeRgb;
    private static final androidx.compose.ui.graphics.colorspace.Rgb Bt2020;
    private static final androidx.compose.ui.graphics.colorspace.Rgb Bt709;
    private static final androidx.compose.ui.graphics.colorspace.ColorSpace CieLab;
    private static final androidx.compose.ui.graphics.colorspace.ColorSpace CieXyz;
    private static final androidx.compose.ui.graphics.colorspace.ColorSpace[] ColorSpacesArray;
    private static final androidx.compose.ui.graphics.colorspace.Rgb DciP3;
    private static final androidx.compose.ui.graphics.colorspace.Rgb DisplayP3;
    private static final androidx.compose.ui.graphics.colorspace.Rgb ExtendedSrgb;
    public static final androidx.compose.ui.graphics.colorspace.ColorSpaces INSTANCE;
    private static final androidx.compose.ui.graphics.colorspace.Rgb LinearExtendedSrgb;
    private static final androidx.compose.ui.graphics.colorspace.Rgb LinearSrgb;
    private static final androidx.compose.ui.graphics.colorspace.TransferParameters NoneTransferParameters;
    private static final androidx.compose.ui.graphics.colorspace.Rgb Ntsc1953;
    private static final float[] Ntsc1953Primaries;
    private static final androidx.compose.ui.graphics.colorspace.ColorSpace Oklab;
    private static final androidx.compose.ui.graphics.colorspace.Rgb ProPhotoRgb;
    private static final androidx.compose.ui.graphics.colorspace.Rgb SmpteC;
    private static final androidx.compose.ui.graphics.colorspace.Rgb Srgb;
    private static final float[] SrgbPrimaries;
    private static final androidx.compose.ui.graphics.colorspace.TransferParameters SrgbTransferParameters;
    private static final androidx.compose.ui.graphics.colorspace.Rgb Unspecified;
    public static double $r8$lambda$9WZGo8jxmhcanMko0p70vdir2pY(double d) {
        return ColorSpaces.ExtendedSrgb$lambda$0(d);
    }

    public static double $r8$lambda$ri4swWY4EFQdKU1W_SyLqgkcz7Q(double d) {
        return ColorSpaces.ExtendedSrgb$lambda$1(d);
    }

    static {
        ColorSpaces colorSpaces = new ColorSpaces();
        ColorSpaces.INSTANCE = colorSpaces;
        int i2 = 6;
        float[] fArr = new float[i2];
        fArr = new int[]{1059313418, 1051260355, 1050253722, 1058642330, 1041865114, 1031127695};
        ColorSpaces.SrgbPrimaries = fArr;
        float[] fArr2 = new float[i2];
        fArr2 = new int[]{1059816735, 1051260355, 1045891645, 1060487823, 1041194025, 1034147594};
        ColorSpaces.Ntsc1953Primaries = fArr2;
        int i63 = 96;
        long l3 = 4606712849170623328L;
        long l8 = 4587673935106099715L;
        long l15 = 4590241633823995264L;
        long l21 = 4585990280393462802L;
        int i45 = 0;
        int i56 = 0;
        TransferParameters transferParameters = new TransferParameters(4612586738352862003L, d, l3, obj6, l8, d2, l15, obj10, l21, obj12, i45, i50, i56, obj16, i63, 0);
        ColorSpaces.SrgbTransferParameters = transferParameters;
        int i69 = 0;
        long l18 = 4590241633823995264L;
        TransferParameters transferParameters2 = new TransferParameters(4612136378390124954L, l3, 4606712849170623328L, l8, 4587673935106099715L, l15, l18, l21, 4585990280393462802L, i45, 0, i56, 0, i63, 96, i69);
        ColorSpaces.NoneTransferParameters = transferParameters2;
        Rgb rgb7 = new Rgb("sRGB IEC61966-2.1", ColorSpaces.SrgbPrimaries, Illuminant.INSTANCE.getD65(), ColorSpaces.SrgbTransferParameters, 0);
        ColorSpaces.Srgb = rgb7;
        Rgb rgb9 = new Rgb("sRGB IEC61966-2.1 (Linear)", ColorSpaces.SrgbPrimaries, Illuminant.INSTANCE.getD65(), 4607182418800017408L, l18, 0, 1065353216, 1);
        ColorSpaces.LinearSrgb = rgb9;
        ColorSpaces$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ColorSpaces$$ExternalSyntheticLambda0();
        ColorSpaces$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ColorSpaces$$ExternalSyntheticLambda1();
        Rgb rgb12 = new Rgb("scRGB-nl IEC 61966-2-2:2003", ColorSpaces.SrgbPrimaries, Illuminant.INSTANCE.getD65(), 0, externalSyntheticLambda0, externalSyntheticLambda1, -1085502652, 1075415351, ColorSpaces.SrgbTransferParameters, 2);
        ColorSpaces.ExtendedSrgb = rgb12;
        float[] srgbPrimaries5 = ColorSpaces.SrgbPrimaries;
        long l22 = 4607182418800017408L;
        int i48 = -1090519040;
        int i57 = 3;
        Rgb rgb14 = new Rgb("scRGB IEC 61966-2-2:2003", srgbPrimaries5, Illuminant.INSTANCE.getD65(), l22, externalSyntheticLambda1, i48, 1089468367, i57);
        ColorSpaces.LinearExtendedSrgb = rgb14;
        float[] fArr3 = new float[i2];
        fArr3 = new int[]{1059313418, 1051260355, 1050253722, 1058642330, 1041865114, 1031127695};
        int i71 = 96;
        long l13 = 4606371033243857847L;
        long l19 = 4591155505112441421L;
        long l27 = 4597174419628082972L;
        long l32 = 4590501085780237091L;
        int i61 = 0;
        int i67 = 0;
        TransferParameters transferParameters3 = new TransferParameters(4612186418385984626L, rgb14, l13, srgbPrimaries5, l19, l22, l27, i48, l32, i57, i61, i63, i67, i69, i71, 0);
        Rgb rgb = new Rgb("Rec. ITU-R BT.709-5", fArr3, Illuminant.INSTANCE.getD65(), transferParameters3, 4);
        ColorSpaces.Bt709 = rgb;
        float[] fArr5 = new float[i2];
        fArr5 = new int[]{1060454269, 1049985286, 1043207291, 1061947441, 1040590045, 1027369599};
        int i75 = 96;
        long l30 = 4597174419628082972L;
        long l35 = 4590533511697554158L;
        int i64 = 0;
        int i70 = 0;
        TransferParameters transferParameters5 = new TransferParameters(4612186418385984626L, l13, 4606368796598620355L, l19, 4591173398274341353L, l27, l30, l32, l35, i61, i64, i67, i70, i71, i75, 0);
        Rgb rgb3 = new Rgb("Rec. ITU-R BT.2020-1", fArr5, Illuminant.INSTANCE.getD65(), transferParameters5, 5);
        ColorSpaces.Bt2020 = rgb3;
        float[] fArr7 = new float[i2];
        fArr7 = new int[]{1059984507, 1050924810, 1049079316, 1060152279, 1041865114, 1031127695};
        WhitePoint whitePoint = new WhitePoint(1050723484, 1051964998);
        int i41 = 6;
        Rgb rgb5 = new Rgb("SMPTE RP 431-2-2007 DCI (P3)", fArr7, whitePoint, 4613037098315599053L, l13, 0, 1065353216, i41);
        ColorSpaces.DciP3 = rgb5;
        float[] fArr9 = new float[i2];
        fArr9 = new int[]{1059984507, 1050924810, 1049079316, 1060152279, 1041865114, 1031127695};
        Rgb rgb8 = new Rgb("Display P3", fArr9, Illuminant.INSTANCE.getD65(), ColorSpaces.SrgbTransferParameters, 7);
        ColorSpaces.DisplayP3 = rgb8;
        final int i81 = 96;
        long l28 = 4606371033243857847L;
        long l33 = 4591155505112441421L;
        long l37 = 4597174419628082972L;
        long l39 = 4590501085780237091L;
        int i72 = 0;
        int i79 = 0;
        TransferParameters transferParameters6 = new TransferParameters(4612186418385984626L, i41, l28, l30, l33, l35, l37, i64, l39, i70, i72, i75, i79, obj23, i81, 0);
        Rgb rgb10 = new Rgb("NTSC (1953)", ColorSpaces.Ntsc1953Primaries, Illuminant.INSTANCE.getC(), transferParameters6, 8);
        ColorSpaces.Ntsc1953 = rgb10;
        float[] fArr10 = new float[i2];
        fArr10 = new int[]{1059145646, 1051595899, 1050589266, 1058558444, 1042200658, 1032805417};
        long l38 = 4597174419628082972L;
        long l40 = 4590501085780237091L;
        TransferParameters transferParameters7 = new TransferParameters(4612186418385984626L, l28, 4606371033243857847L, l33, 4591155505112441421L, l37, l38, l39, l40, i72, 0, i79, 0, i81, 96, 0);
        Rgb rgb13 = new Rgb("SMPTE-C RGB", fArr10, Illuminant.INSTANCE.getD65(), transferParameters7, 9);
        ColorSpaces.SmpteC = rgb13;
        float[] fArr11 = new float[i2];
        fArr11 = new int[]{1059313418, 1051260355, 1045891645, 1060487823, 1041865114, 1031127695};
        long l25 = 4612136378390124954L;
        int i49 = 0;
        int i58 = 10;
        Rgb rgb15 = new Rgb("Adobe RGB (1998)", fArr11, Illuminant.INSTANCE.getD65(), l25, l28, i49, 1065353216, i58);
        ColorSpaces.AdobeRgb = rgb15;
        float[] fArr4 = new float[i2];
        fArr4 = new int[]{1060902221, 1049089383, 1042509359, 1062675572, 1024846306, 953267991};
        TransferParameters transferParameters4 = new TransferParameters(4610785298501913805L, rgb15, 4607182418800017408L, fArr11, 0, l25, 4589168020290535424L, i49, 4584663844202412625L, i58, 0, l38, 0, l40, 96, 0);
        Rgb rgb2 = new Rgb("ROMM RGB ISO 22028-2:2013", fArr4, Illuminant.INSTANCE.getD50(), transferParameters4, 11);
        ColorSpaces.ProPhotoRgb = rgb2;
        float[] fArr6 = new float[i2];
        fArr6 = new int[]{1060902221, 1049089383, 0, 1065353216, 953267991, -1113738707};
        int i27 = -947920896;
        Rgb rgb4 = new Rgb("SMPTE ST 2065-1:2012 ACES", fArr6, Illuminant.INSTANCE.getD60(), 4607182418800017408L, rgb15, i27, 1199562752, 12);
        ColorSpaces.Aces = rgb4;
        float[] fArr8 = new float[i2];
        fArr8 = new int[]{1060538155, 1050018841, 1042871747, 1062501089, 1040388719, 1026832728};
        Rgb rgb6 = new Rgb("Academy S-2014-004 ACEScg", fArr8, Illuminant.INSTANCE.getD60(), 4607182418800017408L, i27, -947920896, 1199562752, 13);
        ColorSpaces.Acescg = rgb6;
        int i16 = 14;
        Xyz xyz = new Xyz("Generic XYZ", i16);
        ColorSpaces.CieXyz = (ColorSpace)xyz;
        int i17 = 15;
        Lab lab = new Lab("Generic L*a*b*", i17);
        ColorSpaces.CieLab = (ColorSpace)lab;
        Rgb rgb11 = new Rgb("None", ColorSpaces.SrgbPrimaries, Illuminant.INSTANCE.getD65(), ColorSpaces.NoneTransferParameters, 16);
        ColorSpaces.Unspecified = rgb11;
        int i18 = 17;
        Oklab oklab2 = new Oklab("Oklab", i18);
        ColorSpaces.Oklab = (ColorSpace)oklab2;
        androidx.compose.ui.graphics.colorspace.ColorSpace[] arr = new ColorSpace[18];
        arr[i2] = ColorSpaces.DciP3;
        arr[7] = ColorSpaces.DisplayP3;
        arr[8] = ColorSpaces.Ntsc1953;
        arr[9] = ColorSpaces.SmpteC;
        arr[10] = ColorSpaces.AdobeRgb;
        arr[11] = ColorSpaces.ProPhotoRgb;
        arr[12] = ColorSpaces.Aces;
        arr[13] = ColorSpaces.Acescg;
        arr[i16] = ColorSpaces.CieXyz;
        arr[i17] = ColorSpaces.CieLab;
        arr[16] = ColorSpaces.Unspecified;
        arr[i18] = ColorSpaces.Oklab;
        ColorSpaces.ColorSpacesArray = arr;
    }

    private static final double ExtendedSrgb$lambda$0(double x) {
        return ColorSpaceKt.absRcpResponse(x, obj1, 4606712849170623328L, obj3, 4587673935106099715L, obj5);
    }

    private static final double ExtendedSrgb$lambda$1(double x) {
        return ColorSpaceKt.absResponse(x, obj1, 4606712849170623328L, obj3, 4587673935106099715L, obj5);
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getAces() {
        return ColorSpaces.Aces;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getAcescg() {
        return ColorSpaces.Acescg;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getAdobeRgb() {
        return ColorSpaces.AdobeRgb;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getBt2020() {
        return ColorSpaces.Bt2020;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getBt709() {
        return ColorSpaces.Bt709;
    }

    public final androidx.compose.ui.graphics.colorspace.ColorSpace getCieLab() {
        return ColorSpaces.CieLab;
    }

    public final androidx.compose.ui.graphics.colorspace.ColorSpace getCieXyz() {
        return ColorSpaces.CieXyz;
    }

    public final androidx.compose.ui.graphics.colorspace.ColorSpace getColorSpace$ui_graphics_release(int id) {
        final int i = 0;
        return getColorSpacesArray$ui_graphics_release()[id];
    }

    public final androidx.compose.ui.graphics.colorspace.ColorSpace[] getColorSpacesArray$ui_graphics_release() {
        return ColorSpaces.ColorSpacesArray;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getDciP3() {
        return ColorSpaces.DciP3;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getDisplayP3() {
        return ColorSpaces.DisplayP3;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getExtendedSrgb() {
        return ColorSpaces.ExtendedSrgb;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getLinearExtendedSrgb() {
        return ColorSpaces.LinearExtendedSrgb;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getLinearSrgb() {
        return ColorSpaces.LinearSrgb;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getNtsc1953() {
        return ColorSpaces.Ntsc1953;
    }

    public final float[] getNtsc1953Primaries$ui_graphics_release() {
        return ColorSpaces.Ntsc1953Primaries;
    }

    public final androidx.compose.ui.graphics.colorspace.ColorSpace getOklab() {
        return ColorSpaces.Oklab;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getProPhotoRgb() {
        return ColorSpaces.ProPhotoRgb;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getSmpteC() {
        return ColorSpaces.SmpteC;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getSrgb() {
        return ColorSpaces.Srgb;
    }

    public final float[] getSrgbPrimaries$ui_graphics_release() {
        return ColorSpaces.SrgbPrimaries;
    }

    public final androidx.compose.ui.graphics.colorspace.TransferParameters getSrgbTransferParameters$ui_graphics_release() {
        return ColorSpaces.SrgbTransferParameters;
    }

    public final androidx.compose.ui.graphics.colorspace.Rgb getUnspecified$ui_graphics_release() {
        return ColorSpaces.Unspecified;
    }

    public final androidx.compose.ui.graphics.colorspace.ColorSpace match(float[] toXYZD50, androidx.compose.ui.graphics.colorspace.TransferParameters function) {
        int i;
        int adapt$default;
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace;
        boolean compare;
        long l;
        long rgb-xdoWZVw;
        final androidx.compose.ui.graphics.colorspace.ColorSpace[] colorSpacesArray = ColorSpaces.ColorSpacesArray;
        i = 0;
        adapt$default = 0;
        while (i < colorSpacesArray.length) {
            colorSpace = colorSpacesArray[i];
            i++;
            adapt$default = 0;
            adapt$default = ColorSpaceKt.adapt$default(colorSpace, Illuminant.INSTANCE.getD50(), adapt$default, 2, adapt$default);
            Intrinsics.checkNotNull(adapt$default, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        }
        return adapt$default;
    }
}
