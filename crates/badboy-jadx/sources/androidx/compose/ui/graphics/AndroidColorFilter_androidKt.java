package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001e\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u00042\n\u0010\u0008\u001a\u00060\u0001j\u0002`\u0002H\u0000¢\u0006\u0002\u0010\t\u001a&\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a&\u0010\u0010\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0011\u001a\u00020\u000c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001a\u0008\u0010\u0016\u001a\u00020\u0017H\u0000\u001a\u0008\u0010\u0018\u001a\u00020\u0017H\u0000\u001a\n\u0010\u0019\u001a\u00020\u0001*\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u001a*\u00020\u0001*\u000c\u0008\u0000\u0010\u001c\"\u00020\u00012\u00020\u0001\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"actualColorMatrixColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "actualColorMatrixColorFilter-jHG-Opc", "([F)Landroid/graphics/ColorFilter;", "actualColorMatrixFromFilter", "filter", "(Landroid/graphics/ColorFilter;)[F", "actualLightingColorFilter", "multiply", "Landroidx/compose/ui/graphics/Color;", "add", "actualLightingColorFilter--OWjLjI", "(JJ)Landroid/graphics/ColorFilter;", "actualTintColorFilter", "color", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "actualTintColorFilter-xETnrds", "(JI)Landroid/graphics/ColorFilter;", "supportsColorMatrixQuery", "", "supportsLightingColorFilterQuery", "asAndroidColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "asComposeColorFilter", "NativeColorFilter", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidColorFilter_androidKt {
    public static final ColorFilter actualColorMatrixColorFilter-jHG-Opc(float[] colorMatrix) {
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        return (ColorFilter)colorMatrixColorFilter;
    }

    public static final float[] actualColorMatrixFromFilter(ColorFilter filter) {
        boolean supportsColorMatrixQuery;
        if (!filter instanceof ColorMatrixColorFilter) {
        } else {
            if (!AndroidColorFilter_androidKt.supportsColorMatrixQuery()) {
            } else {
                return ColorMatrixFilterHelper.INSTANCE.getColorMatrix-8unuwjk((ColorMatrixColorFilter)filter);
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to obtain ColorMatrix from Android ColorMatrixColorFilter. This method was invoked on an unsupported Android version");
        throw illegalArgumentException;
    }

    public static final ColorFilter actualLightingColorFilter--OWjLjI(long multiply, long add) {
        LightingColorFilter lightingColorFilter = new LightingColorFilter(ColorKt.toArgb-8_81llA(multiply), ColorKt.toArgb-8_81llA(obj5));
        return (ColorFilter)lightingColorFilter;
    }

    public static final ColorFilter actualTintColorFilter-xETnrds(long color, int blendMode) {
        return (ColorFilter)BlendModeColorFilterHelper.INSTANCE.BlendModeColorFilter-xETnrds(color, blendMode);
    }

    public static final ColorFilter asAndroidColorFilter(androidx.compose.ui.graphics.ColorFilter $this$asAndroidColorFilter) {
        return $this$asAndroidColorFilter.getNativeColorFilter$ui_graphics_release();
    }

    public static final androidx.compose.ui.graphics.ColorFilter asComposeColorFilter(ColorFilter $this$asComposeColorFilter) {
        boolean supportsLightingColorFilterQuery;
        androidx.compose.ui.graphics.ColorFilter blendModeColorFilter;
        Object lightingColorFilter;
        long l2;
        long l;
        Object $this$asComposeColorFilter2;
        int i;
        boolean obj8;
        if ($this$asComposeColorFilter instanceof BlendModeColorFilter) {
            blendModeColorFilter = BlendModeColorFilterHelper.INSTANCE.createBlendModeColorFilter((BlendModeColorFilter)$this$asComposeColorFilter);
            $this$asComposeColorFilter2 = $this$asComposeColorFilter;
        } else {
            if ($this$asComposeColorFilter instanceof LightingColorFilter && AndroidColorFilter_androidKt.supportsLightingColorFilterQuery()) {
                if (AndroidColorFilter_androidKt.supportsLightingColorFilterQuery()) {
                    lightingColorFilter = new LightingColorFilter(ColorKt.Color((LightingColorFilter)$this$asComposeColorFilter.getColorMultiply()), obj3, ColorKt.Color((LightingColorFilter)$this$asComposeColorFilter.getColorAdd()), obj5, $this$asComposeColorFilter, 0);
                    blendModeColorFilter = lightingColorFilter;
                } else {
                    $this$asComposeColorFilter2 = $this$asComposeColorFilter;
                    if ($this$asComposeColorFilter2 instanceof ColorMatrixColorFilter && AndroidColorFilter_androidKt.supportsColorMatrixQuery()) {
                        if (AndroidColorFilter_androidKt.supportsColorMatrixQuery()) {
                            int i2 = 0;
                            obj8 = new ColorMatrixColorFilter(i2, $this$asComposeColorFilter2, i2);
                            blendModeColorFilter = obj8;
                        } else {
                            blendModeColorFilter = new ColorFilter($this$asComposeColorFilter2);
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        return blendModeColorFilter;
    }

    public static final boolean supportsColorMatrixQuery() {
        return 1;
    }

    public static final boolean supportsLightingColorFilterQuery() {
        return 1;
    }
}
