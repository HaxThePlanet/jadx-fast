package androidx.compose.material3;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.core.math.MathUtils;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u000c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0001\u001a\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002\u001a \u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0008\u0008\u0001\u0010\u0014\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"delinearized", "", "rgbComponent", "", "dynamicDarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "context", "Landroid/content/Context;", "dynamicDarkColorScheme31", "tonalPalette", "Landroidx/compose/material3/TonalPalette;", "dynamicDarkColorScheme34", "dynamicLightColorScheme", "dynamicLightColorScheme31", "dynamicLightColorScheme34", "dynamicTonalPalette", "labInvf", "ft", "setLuminance", "Landroidx/compose/ui/graphics/Color;", "newLuminance", "setLuminance-DxMtmZc", "(JF)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DynamicTonalPaletteKt {
    private static final int delinearized(float rgbComponent) {
        int i;
        long l;
        int i3 = rgbComponent / f;
        if (Double.compare(d, l2) <= 0) {
            d2 *= l;
        } else {
            i4 -= l;
        }
        return MathUtils.clamp(MathKt.roundToInt(l3 *= i), 0, 255);
    }

    public static final androidx.compose.material3.ColorScheme dynamicDarkColorScheme(Context context) {
        androidx.compose.material3.ColorScheme tonalPalette;
        int i;
        if (Build.VERSION.SDK_INT >= 34) {
            tonalPalette = DynamicTonalPaletteKt.dynamicDarkColorScheme34(context);
        } else {
            tonalPalette = i;
        }
        return tonalPalette;
    }

    public static final androidx.compose.material3.ColorScheme dynamicDarkColorScheme31(androidx.compose.material3.TonalPalette tonalPalette) {
        return ColorSchemeKt.darkColorScheme-C-Xl9yA$default(tonalPalette.getPrimary80-0d7_KjU(), obj2, tonalPalette.getPrimary20-0d7_KjU(), obj4, tonalPalette.getPrimary30-0d7_KjU(), obj6, tonalPalette.getPrimary90-0d7_KjU(), obj8, tonalPalette.getPrimary40-0d7_KjU(), obj10, tonalPalette.getSecondary80-0d7_KjU(), obj12, tonalPalette.getSecondary20-0d7_KjU(), obj14, tonalPalette.getSecondary30-0d7_KjU(), obj16, tonalPalette.getSecondary90-0d7_KjU(), obj18, tonalPalette.getTertiary80-0d7_KjU(), obj20, tonalPalette.getTertiary20-0d7_KjU(), obj22, tonalPalette.getTertiary30-0d7_KjU(), obj24, tonalPalette.getTertiary90-0d7_KjU(), obj26, tonalPalette.getNeutralVariant6-0d7_KjU(), obj28, tonalPalette.getNeutralVariant90-0d7_KjU(), obj30, tonalPalette.getNeutralVariant6-0d7_KjU(), obj32, tonalPalette.getNeutralVariant90-0d7_KjU(), obj34, tonalPalette.getNeutralVariant30-0d7_KjU(), obj36, tonalPalette.getNeutralVariant80-0d7_KjU(), obj38, tonalPalette.getPrimary80-0d7_KjU());
    }

    public static final androidx.compose.material3.ColorScheme dynamicDarkColorScheme34(Context context) {
        final Context context2 = context;
        final long l2 = color-WaAFU9c;
        final long l4 = color-WaAFU9c2;
        final long l6 = color-WaAFU9c3;
        final long l8 = color-WaAFU9c4;
        final long l10 = color-WaAFU9c5;
        final long l12 = color-WaAFU9c6;
        final long l14 = color-WaAFU9c7;
        final long l16 = color-WaAFU9c8;
        final long l18 = color-WaAFU9c9;
        final long l20 = color-WaAFU9c10;
        final long l22 = color-WaAFU9c11;
        final long l24 = color-WaAFU9c12;
        return ColorSchemeKt.darkColorScheme-C-Xl9yA$default(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170571), obj4, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170572), obj6, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170569), obj8, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170570), obj10, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170528), obj12, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170575), obj14, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170576), obj16, l2, l2, l4, l4, l6, l6, l8, l8, l10, l10, l12, l12, l14, l14, l16, l16, l18, l18, l20, l20, l22, l22, l24, l24, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170571));
    }

    public static final androidx.compose.material3.ColorScheme dynamicLightColorScheme(Context context) {
        androidx.compose.material3.ColorScheme tonalPalette;
        int i;
        if (Build.VERSION.SDK_INT >= 34) {
            tonalPalette = DynamicTonalPaletteKt.dynamicLightColorScheme34(context);
        } else {
            tonalPalette = i;
        }
        return tonalPalette;
    }

    public static final androidx.compose.material3.ColorScheme dynamicLightColorScheme31(androidx.compose.material3.TonalPalette tonalPalette) {
        return ColorSchemeKt.lightColorScheme-C-Xl9yA$default(tonalPalette.getPrimary40-0d7_KjU(), obj2, tonalPalette.getPrimary100-0d7_KjU(), obj4, tonalPalette.getPrimary90-0d7_KjU(), obj6, tonalPalette.getPrimary10-0d7_KjU(), obj8, tonalPalette.getPrimary80-0d7_KjU(), obj10, tonalPalette.getSecondary40-0d7_KjU(), obj12, tonalPalette.getSecondary100-0d7_KjU(), obj14, tonalPalette.getSecondary90-0d7_KjU(), obj16, tonalPalette.getSecondary10-0d7_KjU(), obj18, tonalPalette.getTertiary40-0d7_KjU(), obj20, tonalPalette.getTertiary100-0d7_KjU(), obj22, tonalPalette.getTertiary90-0d7_KjU(), obj24, tonalPalette.getTertiary10-0d7_KjU(), obj26, tonalPalette.getNeutralVariant98-0d7_KjU(), obj28, tonalPalette.getNeutralVariant10-0d7_KjU(), obj30, tonalPalette.getNeutralVariant98-0d7_KjU(), obj32, tonalPalette.getNeutralVariant10-0d7_KjU(), obj34, tonalPalette.getNeutralVariant90-0d7_KjU(), obj36, tonalPalette.getNeutralVariant30-0d7_KjU(), obj38, tonalPalette.getPrimary40-0d7_KjU());
    }

    public static final androidx.compose.material3.ColorScheme dynamicLightColorScheme34(Context context) {
        final Context context2 = context;
        final long l2 = color-WaAFU9c;
        final long l4 = color-WaAFU9c2;
        final long l6 = color-WaAFU9c3;
        final long l8 = color-WaAFU9c4;
        final long l10 = color-WaAFU9c5;
        final long l12 = color-WaAFU9c6;
        final long l14 = color-WaAFU9c7;
        final long l16 = color-WaAFU9c8;
        final long l18 = color-WaAFU9c9;
        final long l20 = color-WaAFU9c10;
        final long l22 = color-WaAFU9c11;
        final long l24 = color-WaAFU9c12;
        return ColorSchemeKt.lightColorScheme-C-Xl9yA$default(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170528), obj4, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170529), obj6, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170526), obj8, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170527), obj10, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170571), obj12, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170532), obj14, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170533), obj16, l2, l2, l4, l4, l6, l6, l8, l8, l10, l10, l12, l12, l14, l14, l16, l16, l18, l18, l20, l20, l22, l22, l24, l24, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170528));
    }

    public static final androidx.compose.material3.TonalPalette dynamicTonalPalette(Context context) {
        final Context context2 = context;
        long color-WaAFU9c77 = ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170462);
        int i97 = 17170469;
        long color-WaAFU9c84 = ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170463);
        final long l7 = color-WaAFU9c84;
        androidx.compose.material3.ColorResourceHelper iNSTANCE87 = ColorResourceHelper.INSTANCE;
        int i98 = 17170464;
        final androidx.compose.material3.TonalPalette tonalPalette3 = tonalPalette;
        long color-WaAFU9c78 = ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170465);
        final long l18 = luminance-DxMtmZc11;
        final long l20 = color-WaAFU9c;
        final long l22 = color-WaAFU9c2;
        final long l24 = color-WaAFU9c3;
        final long l26 = color-WaAFU9c60;
        androidx.compose.material3.ColorResourceHelper iNSTANCE13 = ColorResourceHelper.INSTANCE;
        final long l28 = color-WaAFU9c4;
        int i85 = 17170469;
        long luminance-DxMtmZc17 = DynamicTonalPaletteKt.setLuminance-DxMtmZc(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, i85), color-WaAFU9c78);
        androidx.compose.material3.ColorResourceHelper iNSTANCE81 = ColorResourceHelper.INSTANCE;
        int i15 = 17170482;
        androidx.compose.material3.ColorResourceHelper iNSTANCE14 = ColorResourceHelper.INSTANCE;
        androidx.compose.material3.ColorResourceHelper iNSTANCE15 = ColorResourceHelper.INSTANCE;
        androidx.compose.material3.ColorResourceHelper iNSTANCE17 = ColorResourceHelper.INSTANCE;
        androidx.compose.material3.ColorResourceHelper iNSTANCE23 = ColorResourceHelper.INSTANCE;
        androidx.compose.material3.ColorResourceHelper iNSTANCE24 = ColorResourceHelper.INSTANCE;
        final long l11 = luminance-DxMtmZc6;
        androidx.compose.material3.ColorResourceHelper iNSTANCE26 = ColorResourceHelper.INSTANCE;
        androidx.compose.material3.ColorResourceHelper iNSTANCE27 = ColorResourceHelper.INSTANCE;
        androidx.compose.material3.ColorResourceHelper iNSTANCE29 = ColorResourceHelper.INSTANCE;
        long color-WaAFU9c71 = iNSTANCE29.getColor-WaAFU9c(context2, 17170482);
        final long l9 = luminance-DxMtmZc10;
        androidx.compose.material3.ColorResourceHelper iNSTANCE70 = ColorResourceHelper.INSTANCE;
        androidx.compose.material3.TonalPalette tonalPalette2 = tonalPalette3;
        tonalPalette2 = new TonalPalette(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170461), iNSTANCE70, color-WaAFU9c77, iNSTANCE81, DynamicTonalPaletteKt.setLuminance-DxMtmZc(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, i97), obj9), i98, DynamicTonalPaletteKt.setLuminance-DxMtmZc(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, i97), obj11), obj9, l7, obj11, DynamicTonalPaletteKt.setLuminance-DxMtmZc(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, i97), color-WaAFU9c84), color-WaAFU9c84, DynamicTonalPaletteKt.setLuminance-DxMtmZc(iNSTANCE87.getColor-WaAFU9c(context2, i97), iNSTANCE87), iNSTANCE87, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, i98), l7, l18, l9, color-WaAFU9c78, l11, l20, tonalPalette3, l22, obj25, l24, obj27, l26, l18, l28, l20, DynamicTonalPaletteKt.setLuminance-DxMtmZc(iNSTANCE13.getColor-WaAFU9c(context2, 17170469), iNSTANCE13), l22, DynamicTonalPaletteKt.setLuminance-DxMtmZc(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, i85), color-WaAFU9c78), l24, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170471), l26, DynamicTonalPaletteKt.setLuminance-DxMtmZc(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, i85), color-WaAFU9c78), l28, DynamicTonalPaletteKt.setLuminance-DxMtmZc(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, i85), color-WaAFU9c78), obj41, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170472), obj43, luminance-DxMtmZc17, obj45, DynamicTonalPaletteKt.setLuminance-DxMtmZc(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, i85), i85), obj47, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170473), obj49, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170474), obj51, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170475), obj53, DynamicTonalPaletteKt.setLuminance-DxMtmZc(iNSTANCE81.getColor-WaAFU9c(context2, i15), luminance-DxMtmZc17), obj55, DynamicTonalPaletteKt.setLuminance-DxMtmZc(ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, i15), iNSTANCE81), obj57, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170476), obj59, DynamicTonalPaletteKt.setLuminance-DxMtmZc(iNSTANCE14.getColor-WaAFU9c(context2, 17170482), iNSTANCE14), obj61, DynamicTonalPaletteKt.setLuminance-DxMtmZc(iNSTANCE15.getColor-WaAFU9c(context2, 17170482), iNSTANCE15), obj63, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170477), obj65, DynamicTonalPaletteKt.setLuminance-DxMtmZc(iNSTANCE17.getColor-WaAFU9c(context2, 17170482), iNSTANCE17), obj67, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170478), obj69, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170479), obj71, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170480), obj73, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170481), obj75, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170482), obj77, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170483), obj79, DynamicTonalPaletteKt.setLuminance-DxMtmZc(iNSTANCE23.getColor-WaAFU9c(context2, 17170482), iNSTANCE23), obj81, l11, obj83, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170484), obj85, DynamicTonalPaletteKt.setLuminance-DxMtmZc(iNSTANCE26.getColor-WaAFU9c(context2, 17170482), iNSTANCE26), obj87, DynamicTonalPaletteKt.setLuminance-DxMtmZc(iNSTANCE27.getColor-WaAFU9c(context2, 17170482), iNSTANCE27), obj89, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170485), obj91, DynamicTonalPaletteKt.setLuminance-DxMtmZc(color-WaAFU9c71, iNSTANCE29), obj93, l9, obj95, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170486), obj97, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170487), obj99, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170488), obj101, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170489), obj103, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170490), obj105, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170491), obj107, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170492), obj109, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170493), obj111, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170494), obj113, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170495), obj115, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170496), obj117, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170497), obj119, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170498), obj121, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170499), obj123, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170500), obj125, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170501), obj127, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170502), obj129, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170503), obj131, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170504), obj133, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170505), obj135, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170506), obj137, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170507), obj139, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170508), obj141, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170509), obj143, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170510), obj145, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170511), obj147, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170512), obj149, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170513), obj151, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170514), obj153, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170515), obj155, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170516), obj157, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170517), obj159, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170518), obj161, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170519), obj163, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170520), obj165, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170521), obj167, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170522), obj169, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170523), obj171, ColorResourceHelper.INSTANCE.getColor-WaAFU9c(context2, 17170524), obj173, iNSTANCE70.getColor-WaAFU9c(context2, 17170525), obj175, 0);
        return tonalPalette2;
    }

    private static final float labInvf(float ft) {
        int i;
        float f;
        i4 *= ft;
        if (Float.compare(i5, i2) > 0) {
            i = i5;
        } else {
            i8 /= i3;
        }
        return i;
    }

    public static final long setLuminance-DxMtmZc(long $this$setLuminance_u2dDxMtmZc, float newLuminance) {
        int i;
        int i2;
        int i9 = 0;
        i = Double.compare(d, l) < 0 ? i2 : i9;
        if (Double.compare(d2, l4) > 0) {
        } else {
            i2 = i9;
        }
        if (i |= i2 != 0) {
            int delinearized = DynamicTonalPaletteKt.delinearized(f *= labInvf);
            return ColorKt.Color$default(delinearized, delinearized, delinearized, 0, 8, 0);
        }
        long convert-vNxB06k = Color.convert-vNxB06k($this$setLuminance_u2dDxMtmZc, newLuminance);
        int i12 = 0;
        int i13 = 0;
        float blue-impl = Color.getBlue-impl(convert-vNxB06k);
        return Color.convert-vNxB06k(ColorKt.Color$default(obj12, Color.getGreen-impl(convert-vNxB06k), blue-impl, 0, ColorSpaces.INSTANCE.getCieLab(), 8, 0), blue-impl);
    }
}
