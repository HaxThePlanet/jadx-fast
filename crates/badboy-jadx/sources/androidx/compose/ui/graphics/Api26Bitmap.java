package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0004H\u0001¢\u0006\u0002\u0008\u0011\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0012", d2 = {"Landroidx/compose/ui/graphics/Api26Bitmap;", "", "()V", "createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "createBitmap-x__-hDU$ui_graphics_release", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroid/graphics/Bitmap;", "composeColorSpace", "composeColorSpace$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Api26Bitmap {

    public static final androidx.compose.ui.graphics.Api26Bitmap INSTANCE;
    static {
        Api26Bitmap api26Bitmap = new Api26Bitmap();
        Api26Bitmap.INSTANCE = api26Bitmap;
    }

    @JvmStatic
    public static final ColorSpace composeColorSpace$ui_graphics_release(Bitmap $this$composeColorSpace) {
        ColorSpace composeColorSpace;
        composeColorSpace = $this$composeColorSpace.getColorSpace();
        if (composeColorSpace != null) {
            if (AndroidColorSpace_androidKt.toComposeColorSpace(composeColorSpace) == null) {
                composeColorSpace = ColorSpaces.INSTANCE.getSrgb();
            }
        } else {
        }
        return composeColorSpace;
    }

    @JvmStatic
    public static final Bitmap createBitmap-x__-hDU$ui_graphics_release(int width, int height, int bitmapConfig, boolean hasAlpha, ColorSpace colorSpace) {
        return Bitmap.createBitmap(0, width, height, AndroidImageBitmap_androidKt.toBitmapConfig-1JJdX4A(bitmapConfig), hasAlpha, AndroidColorSpace_androidKt.toAndroidColorSpace(colorSpace));
    }
}
