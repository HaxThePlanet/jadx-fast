package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0003\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001aP\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0015", d2 = {"ImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "width", "", "height", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "toPixelMap", "Landroidx/compose/ui/graphics/PixelMap;", "startX", "startY", "buffer", "", "bufferOffset", "stride", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ImageBitmapKt {
    public static final androidx.compose.ui.graphics.ImageBitmap ImageBitmap-x__-hDU(int width, int height, int config, boolean hasAlpha, ColorSpace colorSpace) {
        return AndroidImageBitmap_androidKt.ActualImageBitmap-x__-hDU(width, height, config, hasAlpha, colorSpace);
    }

    public static androidx.compose.ui.graphics.ImageBitmap ImageBitmap-x__-hDU$default(int i, int i2, int i3, boolean z4, ColorSpace colorSpace5, int i6, Object object7) {
        int obj2;
        int obj3;
        androidx.compose.ui.graphics.colorspace.Rgb obj4;
        if (i6 & 4 != 0) {
            obj2 = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        }
        if (i6 & 8 != 0) {
            obj3 = 1;
        }
        if (i6 &= 16 != 0) {
            obj4 = ColorSpaces.INSTANCE.getSrgb();
        }
        return ImageBitmapKt.ImageBitmap-x__-hDU(i, i2, obj2, obj3, obj4);
    }

    public static final androidx.compose.ui.graphics.PixelMap toPixelMap(androidx.compose.ui.graphics.ImageBitmap $this$toPixelMap, int startX, int startY, int width, int height, int[] buffer, int bufferOffset, int stride) {
        final int[] obj8 = buffer;
        final int obj12 = height;
        final int obj11 = width;
        $this$toPixelMap.readPixels(obj8, startX, startY, obj11, obj12, bufferOffset, stride);
        PixelMap pixelMap = new PixelMap(obj8, obj11, obj12, bufferOffset, stride);
        return pixelMap;
    }

    public static androidx.compose.ui.graphics.PixelMap toPixelMap$default(androidx.compose.ui.graphics.ImageBitmap imageBitmap, int i2, int i3, int i4, int i5, int[] i6Arr6, int i7, int i8, int i9, Object object10) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        int[] obj6;
        int obj7;
        int obj8;
        final int i = 0;
        if (i9 & 1 != 0) {
            obj2 = i;
        }
        if (i9 & 2 != 0) {
            obj3 = i;
        }
        if (i9 & 4 != 0) {
            obj4 = imageBitmap.getWidth();
        }
        if (i9 & 8 != 0) {
            obj5 = imageBitmap.getHeight();
        }
        if (i9 & 16 != 0) {
            obj6 = new int[obj4 * obj5];
        }
        if (i9 & 32 != 0) {
            obj7 = i;
        }
        if (i9 &= 64 != 0) {
            obj8 = obj4;
        }
        return ImageBitmapKt.toPixelMap(imageBitmap, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }
}
