package androidx.compose.ui.graphics;

import _COROUTINE.CoroutineDebuggingKt;
import android.graphics.BlendMode;
import android.graphics.PorterDuff.Mode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0003\u0010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008\u001a\u0011\u0010\t\u001a\u00020\u0002*\u00020\u0006H\u0001¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u000c*\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000f", d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidBlendMode_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal8;
            int ordinal10;
            int ordinal12;
            int ordinal15;
            int ordinal13;
            int ordinal11;
            int ordinal4;
            int ordinal17;
            int ordinal26;
            int ordinal2;
            int ordinal;
            int ordinal28;
            int ordinal18;
            int ordinal7;
            int ordinal20;
            int ordinal21;
            int ordinal6;
            int ordinal19;
            int ordinal29;
            int ordinal25;
            int ordinal16;
            int ordinal9;
            int ordinal22;
            int ordinal14;
            int ordinal23;
            int ordinal24;
            int ordinal27;
            int ordinal5;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[BlendMode.CLEAR.ordinal()] = 1;
            iArr[BlendMode.SRC.ordinal()] = 2;
            iArr[BlendMode.DST.ordinal()] = 3;
            iArr[BlendMode.SRC_OVER.ordinal()] = 4;
            iArr[BlendMode.DST_OVER.ordinal()] = 5;
            iArr[BlendMode.SRC_IN.ordinal()] = 6;
            iArr[BlendMode.DST_IN.ordinal()] = 7;
            iArr[BlendMode.SRC_OUT.ordinal()] = 8;
            iArr[BlendMode.DST_OUT.ordinal()] = 9;
            try {
                iArr[BlendMode.SRC_ATOP.ordinal()] = 10;
                iArr[BlendMode.DST_ATOP.ordinal()] = 11;
                iArr[BlendMode.XOR.ordinal()] = 12;
                iArr[BlendMode.PLUS.ordinal()] = 13;
                iArr[BlendMode.MODULATE.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError e) {
            }
            iArr[BlendMode.SCREEN.ordinal()] = 15;
            iArr[BlendMode.OVERLAY.ordinal()] = 16;
            iArr[BlendMode.DARKEN.ordinal()] = 17;
            iArr[BlendMode.LIGHTEN.ordinal()] = 18;
            iArr[BlendMode.COLOR_DODGE.ordinal()] = 19;
            iArr[BlendMode.COLOR_BURN.ordinal()] = 20;
            try {
                iArr[BlendMode.HARD_LIGHT.ordinal()] = 21;
                iArr[BlendMode.SOFT_LIGHT.ordinal()] = 22;
                iArr[BlendMode.DIFFERENCE.ordinal()] = 23;
                iArr[BlendMode.EXCLUSION.ordinal()] = 24;
                iArr[BlendMode.MULTIPLY.ordinal()] = 25;
            } catch (java.lang.NoSuchFieldError e) {
            }
            iArr[BlendMode.HUE.ordinal()] = 26;
            iArr[BlendMode.SATURATION.ordinal()] = 27;
            iArr[BlendMode.COLOR.ordinal()] = 28;
            iArr[BlendMode.LUMINOSITY.ordinal()] = 29;
            AndroidBlendMode_androidKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final boolean isSupported-s9anfk8(int $this$isSupported_u2ds9anfk8) {
        return 1;
    }

    public static final BlendMode toAndroidBlendMode-s9anfk8(int $this$toAndroidBlendMode_u2ds9anfk8) {
        BlendMode cOLOR_DODGE;
        cOLOR_DODGE = BlendMode.equals-impl0($this$toAndroidBlendMode_u2ds9anfk8, BlendMode.Companion.getClear-0nO6VwU()) ? BlendMode.CLEAR : equals-impl02 ? BlendMode.SRC : equals-impl03 ? BlendMode.DST : equals-impl04 ? BlendMode.SRC_OVER : equals-impl05 ? BlendMode.DST_OVER : equals-impl06 ? BlendMode.SRC_IN : equals-impl07 ? BlendMode.DST_IN : equals-impl08 ? BlendMode.SRC_OUT : equals-impl09 ? BlendMode.DST_OUT : equals-impl010 ? BlendMode.SRC_ATOP : equals-impl011 ? BlendMode.DST_ATOP : equals-impl012 ? BlendMode.XOR : equals-impl013 ? BlendMode.PLUS : equals-impl014 ? BlendMode.MODULATE : equals-impl015 ? BlendMode.SCREEN : equals-impl016 ? BlendMode.OVERLAY : equals-impl017 ? BlendMode.DARKEN : equals-impl018 ? BlendMode.LIGHTEN : equals-impl019 ? BlendMode.COLOR_DODGE : equals-impl020 ? BlendMode.COLOR_BURN : equals-impl021 ? BlendMode.HARD_LIGHT : equals-impl022 ? BlendMode.SOFT_LIGHT : equals-impl023 ? BlendMode.DIFFERENCE : equals-impl024 ? BlendMode.EXCLUSION : equals-impl025 ? BlendMode.MULTIPLY : equals-impl026 ? BlendMode.HUE : equals-impl027 ? BlendMode.SATURATION : equals-impl028 ? BlendMode.COLOR : equals-impl029 ? BlendMode.LUMINOSITY : BlendMode.SRC_OVER;
        return cOLOR_DODGE;
    }

    public static final int toComposeBlendMode(BlendMode $this$toComposeBlendMode) {
        int colorDodge-0nO6VwU;
        switch (i2) {
            case 1:
                colorDodge-0nO6VwU = BlendMode.Companion.getClear-0nO6VwU();
                break;
            case 2:
                colorDodge-0nO6VwU = BlendMode.Companion.getSrc-0nO6VwU();
                break;
            case 3:
                colorDodge-0nO6VwU = BlendMode.Companion.getDst-0nO6VwU();
                break;
            case 4:
                colorDodge-0nO6VwU = BlendMode.Companion.getSrcOver-0nO6VwU();
                break;
            case 5:
                colorDodge-0nO6VwU = BlendMode.Companion.getDstOver-0nO6VwU();
                break;
            case 6:
                colorDodge-0nO6VwU = BlendMode.Companion.getSrcIn-0nO6VwU();
                break;
            case 7:
                colorDodge-0nO6VwU = BlendMode.Companion.getDstIn-0nO6VwU();
                break;
            case 8:
                colorDodge-0nO6VwU = BlendMode.Companion.getSrcOut-0nO6VwU();
                break;
            case 9:
                colorDodge-0nO6VwU = BlendMode.Companion.getDstOut-0nO6VwU();
                break;
            case 10:
                colorDodge-0nO6VwU = BlendMode.Companion.getSrcAtop-0nO6VwU();
                break;
            case 11:
                colorDodge-0nO6VwU = BlendMode.Companion.getDstAtop-0nO6VwU();
                break;
            case 12:
                colorDodge-0nO6VwU = BlendMode.Companion.getXor-0nO6VwU();
                break;
            case 13:
                colorDodge-0nO6VwU = BlendMode.Companion.getPlus-0nO6VwU();
                break;
            case 14:
                colorDodge-0nO6VwU = BlendMode.Companion.getModulate-0nO6VwU();
                break;
            case 15:
                colorDodge-0nO6VwU = BlendMode.Companion.getScreen-0nO6VwU();
                break;
            case 16:
                colorDodge-0nO6VwU = BlendMode.Companion.getOverlay-0nO6VwU();
                break;
            case 17:
                colorDodge-0nO6VwU = BlendMode.Companion.getDarken-0nO6VwU();
                break;
            case 18:
                colorDodge-0nO6VwU = BlendMode.Companion.getLighten-0nO6VwU();
                break;
            case 19:
                colorDodge-0nO6VwU = BlendMode.Companion.getColorDodge-0nO6VwU();
                break;
            case 20:
                colorDodge-0nO6VwU = BlendMode.Companion.getColorBurn-0nO6VwU();
                break;
            case 21:
                colorDodge-0nO6VwU = BlendMode.Companion.getHardlight-0nO6VwU();
                break;
            case 22:
                colorDodge-0nO6VwU = BlendMode.Companion.getSoftlight-0nO6VwU();
                break;
            case 23:
                colorDodge-0nO6VwU = BlendMode.Companion.getDifference-0nO6VwU();
                break;
            case 24:
                colorDodge-0nO6VwU = BlendMode.Companion.getExclusion-0nO6VwU();
                break;
            case 25:
                colorDodge-0nO6VwU = BlendMode.Companion.getMultiply-0nO6VwU();
                break;
            case 26:
                colorDodge-0nO6VwU = BlendMode.Companion.getHue-0nO6VwU();
                break;
            case 27:
                colorDodge-0nO6VwU = BlendMode.Companion.getSaturation-0nO6VwU();
                break;
            case 28:
                colorDodge-0nO6VwU = BlendMode.Companion.getColor-0nO6VwU();
                break;
            case 29:
                colorDodge-0nO6VwU = BlendMode.Companion.getLuminosity-0nO6VwU();
                break;
            default:
                colorDodge-0nO6VwU = BlendMode.Companion.getSrcOver-0nO6VwU();
        }
        return colorDodge-0nO6VwU;
    }

    public static final PorterDuff.Mode toPorterDuffMode-s9anfk8(int $this$toPorterDuffMode_u2ds9anfk8) {
        PorterDuff.Mode dST_OVER;
        dST_OVER = BlendMode.equals-impl0($this$toPorterDuffMode_u2ds9anfk8, BlendMode.Companion.getClear-0nO6VwU()) ? PorterDuff.Mode.CLEAR : equals-impl02 ? PorterDuff.Mode.SRC : equals-impl03 ? PorterDuff.Mode.DST : equals-impl04 ? PorterDuff.Mode.SRC_OVER : equals-impl05 ? PorterDuff.Mode.DST_OVER : equals-impl06 ? PorterDuff.Mode.SRC_IN : equals-impl07 ? PorterDuff.Mode.DST_IN : equals-impl08 ? PorterDuff.Mode.SRC_OUT : equals-impl09 ? PorterDuff.Mode.DST_OUT : equals-impl010 ? PorterDuff.Mode.SRC_ATOP : equals-impl011 ? PorterDuff.Mode.DST_ATOP : equals-impl012 ? PorterDuff.Mode.XOR : equals-impl013 ? PorterDuff.Mode.ADD : equals-impl014 ? PorterDuff.Mode.SCREEN : equals-impl015 ? PorterDuff.Mode.OVERLAY : equals-impl016 ? PorterDuff.Mode.DARKEN : equals-impl017 ? PorterDuff.Mode.LIGHTEN : equals-impl018 ? PorterDuff.Mode.MULTIPLY : PorterDuff.Mode.SRC_OVER;
        return dST_OVER;
    }
}
