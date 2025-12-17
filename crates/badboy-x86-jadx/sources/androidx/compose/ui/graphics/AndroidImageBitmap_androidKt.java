package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0001\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u000e\u001a\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\u0006*\u00020\u0011H\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"ActualImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "width", "", "height", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ActualImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "asAndroidBitmap", "Landroid/graphics/Bitmap;", "asImageBitmap", "toBitmapConfig", "Landroid/graphics/Bitmap$Config;", "toBitmapConfig-1JJdX4A", "(I)Landroid/graphics/Bitmap$Config;", "toImageConfig", "(Landroid/graphics/Bitmap$Config;)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidImageBitmap_androidKt {
    public static final androidx.compose.ui.graphics.ImageBitmap ActualImageBitmap-x__-hDU(int width, int height, int config, boolean hasAlpha, ColorSpace colorSpace) {
        final Bitmap.Config bitmapConfig-1JJdX4A = AndroidImageBitmap_androidKt.toBitmapConfig-1JJdX4A(config);
        int i = 0;
        AndroidImageBitmap androidImageBitmap = new AndroidImageBitmap(Api26Bitmap.createBitmap-x__-hDU$ui_graphics_release(width, height, config, hasAlpha, colorSpace));
        return (ImageBitmap)androidImageBitmap;
    }

    public static final Bitmap asAndroidBitmap(androidx.compose.ui.graphics.ImageBitmap $this$asAndroidBitmap) {
        if ($this$asAndroidBitmap instanceof AndroidImageBitmap == null) {
        } else {
            return (AndroidImageBitmap)$this$asAndroidBitmap.getBitmap$ui_graphics_release();
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
        throw unsupportedOperationException;
    }

    public static final androidx.compose.ui.graphics.ImageBitmap asImageBitmap(Bitmap $this$asImageBitmap) {
        AndroidImageBitmap androidImageBitmap = new AndroidImageBitmap($this$asImageBitmap);
        return (ImageBitmap)androidImageBitmap;
    }

    public static final Bitmap.Config toBitmapConfig-1JJdX4A(int $this$toBitmapConfig_u2d1JJdX4A) {
        Bitmap.Config hARDWARE;
        hARDWARE = ImageBitmapConfig.equals-impl0($this$toBitmapConfig_u2d1JJdX4A, ImageBitmapConfig.Companion.getArgb8888-_sVssgQ()) ? Bitmap.Config.ARGB_8888 : equals-impl02 ? Bitmap.Config.ALPHA_8 : equals-impl03 ? Bitmap.Config.RGB_565 : equals-impl04 ? Bitmap.Config.RGBA_F16 : equals-impl05 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
        return hARDWARE;
    }

    public static final int toImageConfig(Bitmap.Config $this$toImageConfig) {
        int argb8888-_sVssgQ;
        if ($this$toImageConfig == Bitmap.Config.ALPHA_8) {
            argb8888-_sVssgQ = ImageBitmapConfig.Companion.getAlpha8-_sVssgQ();
        } else {
            if ($this$toImageConfig == Bitmap.Config.RGB_565) {
                argb8888-_sVssgQ = ImageBitmapConfig.Companion.getRgb565-_sVssgQ();
            } else {
                if ($this$toImageConfig == Bitmap.Config.ARGB_4444) {
                    argb8888-_sVssgQ = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
                } else {
                    if ($this$toImageConfig == Bitmap.Config.RGBA_F16) {
                        argb8888-_sVssgQ = ImageBitmapConfig.Companion.getF16-_sVssgQ();
                    } else {
                        if ($this$toImageConfig == Bitmap.Config.HARDWARE) {
                            argb8888-_sVssgQ = ImageBitmapConfig.Companion.getGpu-_sVssgQ();
                        } else {
                            argb8888-_sVssgQ = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
                        }
                    }
                }
            }
        }
        return argb8888-_sVssgQ;
    }
}
