package androidx.compose.ui.graphics;

import android.graphics.Shader;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000c\u001a0\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u001aN\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\u0008\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001aN\u0010\u0016\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\u0018\u001a\u00020\u00122\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\u0008\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001a\u001a<\u0010\u001b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\u000c2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\u0008\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"ImageShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "Landroidx/compose/ui/graphics/TileMode;", "tileModeY", "ImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "LinearGradientShader", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "LinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "RadialGradientShader", "center", "radius", "RadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "SweepGradientShader", "SweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShaderKt {
    public static final Shader ImageShader-F49vj9s(androidx.compose.ui.graphics.ImageBitmap image, int tileModeX, int tileModeY) {
        return AndroidShader_androidKt.ActualImageShader-F49vj9s(image, tileModeX, tileModeY);
    }

    public static Shader ImageShader-F49vj9s$default(androidx.compose.ui.graphics.ImageBitmap imageBitmap, int i2, int i3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 2 != 0) {
            obj1 = TileMode.Companion.getClamp-3opZhB0();
        }
        if (i4 &= 4 != 0) {
            obj2 = TileMode.Companion.getClamp-3opZhB0();
        }
        return ShaderKt.ImageShader-F49vj9s(imageBitmap, obj1, obj2);
    }

    public static final Shader LinearGradientShader-VjE6UOU(long from, long to, List<androidx.compose.ui.graphics.Color> colors, List<Float> colorStops, int tileMode) {
        return AndroidShader_androidKt.ActualLinearGradientShader-VjE6UOU(from, to, colors, colorStops, tileMode);
    }

    public static Shader LinearGradientShader-VjE6UOU$default(long l, long l2, List list3, List list4, int i5, int i6, Object object7) {
        int i2;
        int i;
        int obj12;
        int obj13;
        i2 = obj14 & 8 != 0 ? obj12 : i6;
        if (obj14 & 16 != 0) {
            i = obj13;
        } else {
            i = object7;
        }
        return ShaderKt.LinearGradientShader-VjE6UOU(l, obj1, list3, obj3, i5);
    }

    public static final Shader RadialGradientShader-8uybcMk(long center, float radius, List<androidx.compose.ui.graphics.Color> colors, List<Float> colorStops, int tileMode) {
        return AndroidShader_androidKt.ActualRadialGradientShader-8uybcMk(center, radius, colors, colorStops, tileMode);
    }

    public static Shader RadialGradientShader-8uybcMk$default(long l, float f2, List list3, List list4, int i5, int i6, Object object7) {
        int i2;
        int i;
        int obj10;
        int obj11;
        i2 = object7 & 8 != 0 ? obj10 : i5;
        if (object7 & 16 != 0) {
            i = obj11;
        } else {
            i = i6;
        }
        return ShaderKt.RadialGradientShader-8uybcMk(l, obj1, list3, list4, i2);
    }

    public static final Shader SweepGradientShader-9KIMszo(long center, List<androidx.compose.ui.graphics.Color> colors, List<Float> colorStops) {
        return AndroidShader_androidKt.ActualSweepGradientShader-9KIMszo(center, colors, colorStops);
    }

    public static Shader SweepGradientShader-9KIMszo$default(long l, List list2, List list3, int i4, Object object5) {
        int obj3;
        if (object5 &= 4 != 0) {
            obj3 = 0;
        }
        return ShaderKt.SweepGradientShader-9KIMszo(l, list2, list3);
    }
}
