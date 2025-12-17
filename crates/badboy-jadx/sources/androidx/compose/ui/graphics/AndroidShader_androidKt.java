package androidx.compose.ui.graphics;

import android.graphics.BitmapShader;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001a.\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u001aL\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001aL\u0010\u0016\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\u0018\u001a\u00020\u00122\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001a\u001a<\u0010\u001b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\u000c2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a\u0016\u0010\u001e\u001a\u00020\u001f2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fH\u0001\u001a\u001e\u0010 \u001a\u00020!2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\"\u001a\u00020\u001fH\u0001\u001a0\u0010#\u001a\u0004\u0018\u00010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\"\u001a\u00020\u001fH\u0001\u001a&\u0010&\u001a\u00020'2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fH\u0002*\n\u0010(\"\u00020\u00012\u00020\u0001\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006)", d2 = {"ActualImageShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "Landroidx/compose/ui/graphics/TileMode;", "tileModeY", "ActualImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "ActualLinearGradientShader", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "ActualLinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualRadialGradientShader", "center", "radius", "ActualRadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualSweepGradientShader", "ActualSweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "countTransparentColors", "", "makeTransparentColors", "", "numTransparentColors", "makeTransparentStops", "", "stops", "validateColorStops", "", "Shader", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidShader_androidKt {
    public static final Shader ActualImageShader-F49vj9s(androidx.compose.ui.graphics.ImageBitmap image, int tileModeX, int tileModeY) {
        BitmapShader bitmapShader = new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(image), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(tileModeX), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(tileModeY));
        return (Shader)bitmapShader;
    }

    public static final Shader ActualLinearGradientShader-VjE6UOU(long from, long to, List<androidx.compose.ui.graphics.Color> colors, List<Float> colorStops, int tileMode) {
        AndroidShader_androidKt.validateColorStops(tileMode, obj14);
        final int countTransparentColors = AndroidShader_androidKt.countTransparentColors(tileMode);
        LinearGradient linearGradient = new LinearGradient(Offset.getX-impl(from), Offset.getY-impl(from), Offset.getX-impl(colors), Offset.getY-impl(colors), AndroidShader_androidKt.makeTransparentColors(tileMode, countTransparentColors), AndroidShader_androidKt.makeTransparentStops(obj14, tileMode, countTransparentColors), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(obj15));
        return (Shader)linearGradient;
    }

    public static final Shader ActualRadialGradientShader-8uybcMk(long center, float radius, List<androidx.compose.ui.graphics.Color> colors, List<Float> colorStops, int tileMode) {
        AndroidShader_androidKt.validateColorStops(colorStops, tileMode);
        final int countTransparentColors = AndroidShader_androidKt.countTransparentColors(colorStops);
        RadialGradient radialGradient = new RadialGradient(Offset.getX-impl(center), Offset.getY-impl(center), colors, AndroidShader_androidKt.makeTransparentColors(colorStops, countTransparentColors), AndroidShader_androidKt.makeTransparentStops(tileMode, colorStops, countTransparentColors), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(obj13));
        return (Shader)radialGradient;
    }

    public static final Shader ActualSweepGradientShader-9KIMszo(long center, List<androidx.compose.ui.graphics.Color> colors, List<Float> colorStops) {
        AndroidShader_androidKt.validateColorStops(colorStops, obj9);
        final int countTransparentColors = AndroidShader_androidKt.countTransparentColors(colorStops);
        SweepGradient sweepGradient = new SweepGradient(Offset.getX-impl(center), Offset.getY-impl(center), AndroidShader_androidKt.makeTransparentColors(colorStops, countTransparentColors), AndroidShader_androidKt.makeTransparentStops(obj9, colorStops, countTransparentColors));
        return (Shader)sweepGradient;
    }

    public static final int countTransparentColors(List<androidx.compose.ui.graphics.Color> colors) {
        return 0;
    }

    public static final int[] makeTransparentColors(List<androidx.compose.ui.graphics.Color> colors, int numTransparentColors) {
        int i;
        int argb-8_81llA;
        final int size = colors.size();
        final int[] iArr = new int[size];
        i = 0;
        while (i < size) {
            iArr[i] = ColorKt.toArgb-8_81llA((Color)colors.get(i).unbox-impl());
            i++;
        }
        return iArr;
    }

    public static final float[] makeTransparentStops(List<Float> stops, List<androidx.compose.ui.graphics.Color> colors, int numTransparentColors) {
        int floatArray;
        int floatValue;
        float floatValue2;
        int newStopsIndex;
        int i;
        int i3;
        long unbox-impl;
        float floatValue3;
        int i2;
        if (numTransparentColors == 0) {
            if (stops != null) {
                floatArray = CollectionsKt.toFloatArray((Collection)stops);
            } else {
                floatArray = 0;
            }
            return floatArray;
        }
        float[] fArr = new float[size += numTransparentColors];
        int i5 = 0;
        final int i6 = 0;
        if (stops != null) {
            floatValue2 = (Number)stops.get(i6).floatValue();
        } else {
            floatValue2 = i5;
        }
        fArr[i6] = floatValue2;
        newStopsIndex = 1;
        i3 = 1;
        while (i3 < CollectionsKt.getLastIndex(colors)) {
            if (stops != null) {
            } else {
            }
            f /= i2;
            i2 = newStopsIndex + 1;
            fArr[newStopsIndex] = floatValue3;
            if (Float.compare(alpha-impl, i5) == 0) {
            } else {
            }
            i = i6;
            if (i != 0) {
            } else {
            }
            newStopsIndex = i2;
            i3++;
            newStopsIndex = i2 + 1;
            fArr[i2] = floatValue3;
            i = 1;
            floatValue3 = (Number)stops.get(i3).floatValue();
        }
        if (stops != null) {
            floatValue = (Number)stops.get(CollectionsKt.getLastIndex(colors)).floatValue();
        } else {
            floatValue = 1065353216;
        }
        fArr[newStopsIndex] = floatValue;
        return fArr;
    }

    private static final void validateColorStops(List<androidx.compose.ui.graphics.Color> colors, List<Float> colorStops) {
        int size;
        int size2;
        if (colorStops == null) {
            if (colors.size() < 2) {
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            throw illegalArgumentException;
        }
        if (colors.size() != colorStops.size()) {
        } else {
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        throw illegalArgumentException2;
    }
}
