package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Shader;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0008\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u0006*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0010\u0010\u0008\u001a\u00020\t*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00060\u0003j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\u000c\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00060\u0003j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u0011*\u00060\u0003j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0012\u001a\u00020\u0013*\u00060\u0003j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\u000f\u001a\u0010\u0010\u0014\u001a\u00020\u0006*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0010\u0010\u0015\u001a\u00020\u0006*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0015\u0010\u0016\u001a\u00020\u0017*\u00060\u0003j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u0018\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u001b\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\tH\u0000\u001a\"\u0010\u001c\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 \u001a\"\u0010!\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#\u001a\u001a\u0010$\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0008\u0010\u001a\u001a\u0004\u0018\u00010%H\u0000\u001a\"\u0010&\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\u0008'\u0010 \u001a\u001a\u0010(\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0008\u0010\u001a\u001a\u0004\u0018\u00010)H\u0000\u001a \u0010*\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u000e\u0010\u001a\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,H\u0000\u001a\"\u0010-\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0011H\u0000ø\u0001\u0000¢\u0006\u0004\u0008.\u0010 \u001a\"\u0010/\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\u00080\u0010 \u001a\u0018\u00101\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0000\u001a\u0018\u00102\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0000\u001a\"\u00103\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\u00084\u0010 *\n\u00105\"\u00020\u00032\u00020\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00066", d2 = {"Paint", "Landroidx/compose/ui/graphics/Paint;", "makeNativePaint", "Landroid/graphics/Paint;", "asComposePaint", "getNativeAlpha", "", "Landroidx/compose/ui/graphics/NativePaint;", "getNativeAntiAlias", "", "getNativeColor", "Landroidx/compose/ui/graphics/Color;", "(Landroid/graphics/Paint;)J", "getNativeFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "(Landroid/graphics/Paint;)I", "getNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getNativeStrokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getNativeStrokeMiterLimit", "getNativeStrokeWidth", "getNativeStyle", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeAlpha", "", "value", "setNativeAntiAlias", "setNativeBlendMode", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeColor", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "setNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativePathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "setNativeShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativeStrokeCap", "setNativeStrokeCap-CSYIeUk", "setNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "setNativeStrokeMiterLimit", "setNativeStrokeWidth", "setNativeStyle", "setNativeStyle--5YerkU", "NativePaint", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidPaint_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;
        public static final int[] $EnumSwitchMapping$2;
        static {
            int i;
            int ordinal6;
            int ordinal;
            int ordinal2;
            int ordinal3;
            int ordinal4;
            int ordinal5;
            int[] iArr = new int[values.length];
            i = 1;
            iArr[Paint.Style.STROKE.ordinal()] = i;
            AndroidPaint_androidKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[Paint.Cap.BUTT.ordinal()] = i;
            int i2 = 2;
            iArr2[Paint.Cap.ROUND.ordinal()] = i2;
            int i3 = 3;
            iArr2[Paint.Cap.SQUARE.ordinal()] = i3;
            try {
                AndroidPaint_androidKt.WhenMappings.$EnumSwitchMapping$1 = iArr2;
                int[] iArr3 = new int[values3.length];
                iArr3[Paint.Join.MITER.ordinal()] = i;
                iArr3[Paint.Join.BEVEL.ordinal()] = i2;
                iArr3[Paint.Join.ROUND.ordinal()] = i3;
                AndroidPaint_androidKt.WhenMappings.$EnumSwitchMapping$2 = iArr3;
            } catch (java.lang.NoSuchFieldError e) {
            }
        }
    }
    public static final androidx.compose.ui.graphics.Paint Paint() {
        AndroidPaint androidPaint = new AndroidPaint();
        return (Paint)androidPaint;
    }

    public static final androidx.compose.ui.graphics.Paint asComposePaint(Paint $this$asComposePaint) {
        AndroidPaint androidPaint = new AndroidPaint($this$asComposePaint);
        return (Paint)androidPaint;
    }

    public static final float getNativeAlpha(Paint $this$getNativeAlpha) {
        return f /= i2;
    }

    public static final boolean getNativeAntiAlias(Paint $this$getNativeAntiAlias) {
        return $this$getNativeAntiAlias.isAntiAlias();
    }

    public static final long getNativeColor(Paint $this$getNativeColor) {
        return ColorKt.Color($this$getNativeColor.getColor());
    }

    public static final int getNativeFilterQuality(Paint $this$getNativeFilterQuality) {
        int none-f-v9h1I;
        if (!$this$getNativeFilterQuality.isFilterBitmap()) {
            none-f-v9h1I = FilterQuality.Companion.getNone-f-v9h1I();
        } else {
            none-f-v9h1I = FilterQuality.Companion.getLow-f-v9h1I();
        }
        return none-f-v9h1I;
    }

    public static final int getNativeStrokeCap(Paint $this$getNativeStrokeCap) {
        int i;
        int square-KaPHkGw;
        int[] $EnumSwitchMapping$1;
        Paint.Cap strokeCap = $this$getNativeStrokeCap.getStrokeCap();
        if (strokeCap == null) {
            i = -1;
        } else {
            i = AndroidPaint_androidKt.WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        }
        switch (i) {
            case 1:
                square-KaPHkGw = StrokeCap.Companion.getButt-KaPHkGw();
                break;
            case 2:
                square-KaPHkGw = StrokeCap.Companion.getRound-KaPHkGw();
                break;
            case 3:
                square-KaPHkGw = StrokeCap.Companion.getSquare-KaPHkGw();
                break;
            default:
                square-KaPHkGw = StrokeCap.Companion.getButt-KaPHkGw();
        }
        return square-KaPHkGw;
    }

    public static final int getNativeStrokeJoin(Paint $this$getNativeStrokeJoin) {
        int i;
        int miter-LxFBmk8;
        int[] $EnumSwitchMapping$2;
        Paint.Join strokeJoin = $this$getNativeStrokeJoin.getStrokeJoin();
        if (strokeJoin == null) {
            i = -1;
        } else {
            i = AndroidPaint_androidKt.WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        }
        switch (i) {
            case 1:
                miter-LxFBmk8 = StrokeJoin.Companion.getMiter-LxFBmk8();
                break;
            case 2:
                miter-LxFBmk8 = StrokeJoin.Companion.getBevel-LxFBmk8();
                break;
            case 3:
                miter-LxFBmk8 = StrokeJoin.Companion.getRound-LxFBmk8();
                break;
            default:
                miter-LxFBmk8 = StrokeJoin.Companion.getMiter-LxFBmk8();
        }
        return miter-LxFBmk8;
    }

    public static final float getNativeStrokeMiterLimit(Paint $this$getNativeStrokeMiterLimit) {
        return $this$getNativeStrokeMiterLimit.getStrokeMiter();
    }

    public static final float getNativeStrokeWidth(Paint $this$getNativeStrokeWidth) {
        return $this$getNativeStrokeWidth.getStrokeWidth();
    }

    public static final int getNativeStyle(Paint $this$getNativeStyle) {
        int i;
        int stroke-TiuSbCo;
        int[] $EnumSwitchMapping$0;
        Paint.Style style = $this$getNativeStyle.getStyle();
        if (style == null) {
            i = -1;
        } else {
            i = AndroidPaint_androidKt.WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
        }
        if (i == 1) {
            stroke-TiuSbCo = PaintingStyle.Companion.getStroke-TiuSbCo();
        } else {
            stroke-TiuSbCo = PaintingStyle.Companion.getFill-TiuSbCo();
        }
        return stroke-TiuSbCo;
    }

    public static final Paint makeNativePaint() {
        Paint paint = new Paint(7);
        return paint;
    }

    public static final void setNativeAlpha(Paint $this$setNativeAlpha, float value) {
        $this$setNativeAlpha.setAlpha((int)f);
    }

    public static final void setNativeAntiAlias(Paint $this$setNativeAntiAlias, boolean value) {
        $this$setNativeAntiAlias.setAntiAlias(value);
    }

    public static final void setNativeBlendMode-GB0RdKg(Paint $this$setNativeBlendMode_u2dGB0RdKg, int mode) {
        WrapperVerificationHelperMethods.INSTANCE.setBlendMode-GB0RdKg($this$setNativeBlendMode_u2dGB0RdKg, mode);
    }

    public static final void setNativeColor-4WTKRHQ(Paint $this$setNativeColor_u2d4WTKRHQ, long value) {
        $this$setNativeColor_u2d4WTKRHQ.setColor(ColorKt.toArgb-8_81llA(value));
    }

    public static final void setNativeColorFilter(Paint $this$setNativeColorFilter, androidx.compose.ui.graphics.ColorFilter value) {
        android.graphics.ColorFilter androidColorFilter;
        if (value != null) {
            androidColorFilter = AndroidColorFilter_androidKt.asAndroidColorFilter(value);
        } else {
            androidColorFilter = 0;
        }
        $this$setNativeColorFilter.setColorFilter(androidColorFilter);
    }

    public static final void setNativeFilterQuality-50PEsBU(Paint $this$setNativeFilterQuality_u2d50PEsBU, int value) {
        $this$setNativeFilterQuality_u2d50PEsBU.setFilterBitmap(equals-impl0 ^= 1);
    }

    public static final void setNativePathEffect(Paint $this$setNativePathEffect, androidx.compose.ui.graphics.PathEffect value) {
        android.graphics.PathEffect nativePathEffect;
        androidx.compose.ui.graphics.AndroidPathEffect androidPathEffect = value;
        if ((AndroidPathEffect)androidPathEffect != null) {
            nativePathEffect = (AndroidPathEffect)androidPathEffect.getNativePathEffect();
        } else {
            nativePathEffect = 0;
        }
        $this$setNativePathEffect.setPathEffect(nativePathEffect);
    }

    public static final void setNativeShader(Paint $this$setNativeShader, Shader value) {
        $this$setNativeShader.setShader(value);
    }

    public static final void setNativeStrokeCap-CSYIeUk(Paint $this$setNativeStrokeCap_u2dCSYIeUk, int value) {
        Paint.Cap sQUARE;
        sQUARE = StrokeCap.equals-impl0(value, StrokeCap.Companion.getSquare-KaPHkGw()) ? Paint.Cap.SQUARE : equals-impl02 ? Paint.Cap.ROUND : equals-impl03 ? Paint.Cap.BUTT : Paint.Cap.BUTT;
        $this$setNativeStrokeCap_u2dCSYIeUk.setStrokeCap(sQUARE);
    }

    public static final void setNativeStrokeJoin-kLtJ_vA(Paint $this$setNativeStrokeJoin_u2dkLtJ_vA, int value) {
        Paint.Join bEVEL;
        bEVEL = StrokeJoin.equals-impl0(value, StrokeJoin.Companion.getMiter-LxFBmk8()) ? Paint.Join.MITER : equals-impl02 ? Paint.Join.BEVEL : equals-impl03 ? Paint.Join.ROUND : Paint.Join.MITER;
        $this$setNativeStrokeJoin_u2dkLtJ_vA.setStrokeJoin(bEVEL);
    }

    public static final void setNativeStrokeMiterLimit(Paint $this$setNativeStrokeMiterLimit, float value) {
        $this$setNativeStrokeMiterLimit.setStrokeMiter(value);
    }

    public static final void setNativeStrokeWidth(Paint $this$setNativeStrokeWidth, float value) {
        $this$setNativeStrokeWidth.setStrokeWidth(value);
    }

    public static final void setNativeStyle--5YerkU(Paint $this$setNativeStyle_u2d_u2d5YerkU, int value) {
        Paint.Style sTROKE;
        sTROKE = PaintingStyle.equals-impl0(value, PaintingStyle.Companion.getStroke-TiuSbCo()) ? Paint.Style.STROKE : Paint.Style.FILL;
        $this$setNativeStyle_u2d_u2d5YerkU.setStyle(sTROKE);
    }
}
