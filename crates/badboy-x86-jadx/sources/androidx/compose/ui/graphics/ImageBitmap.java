package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0006\u0008f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u0008\u0010\u0013\u001a\u00020\u0014H&JL\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\tR\u0012\u0010\u0011\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\tø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u001dÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/ImageBitmap;", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getConfig-_sVssgQ", "()I", "hasAlpha", "", "getHasAlpha", "()Z", "height", "", "getHeight", "width", "getWidth", "prepareToDraw", "", "readPixels", "buffer", "", "startX", "startY", "bufferOffset", "stride", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ImageBitmap {

    public static final androidx.compose.ui.graphics.ImageBitmap.Companion Companion;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/ImageBitmap$Companion;", "", "()V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.graphics.ImageBitmap.Companion $$INSTANCE;
        static {
            ImageBitmap.Companion companion = new ImageBitmap.Companion();
            ImageBitmap.Companion.$$INSTANCE = companion;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void readPixels$default(androidx.compose.ui.graphics.ImageBitmap imageBitmap, int[] i2Arr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object object10) {
            ImageBitmap.readPixels$default(imageBitmap, i2Arr2, i3, i4, i5, i6, i7, i8, i9, object10);
        }
    }
    static {
        ImageBitmap.Companion = ImageBitmap.Companion.$$INSTANCE;
    }

    public static void readPixels$default(androidx.compose.ui.graphics.ImageBitmap imageBitmap, int[] i2Arr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object object10) {
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        int obj7;
        int obj8;
        if (object10 != null) {
        } else {
            final int i = 0;
            if (i9 & 2 != 0) {
                obj3 = i;
            }
            if (i9 & 4 != 0) {
                obj4 = i;
            }
            if (i9 & 8 != 0) {
                obj5 = imageBitmap.getWidth();
            }
            if (i9 & 16 != 0) {
                obj6 = imageBitmap.getHeight();
            }
            if (i9 & 32 != 0) {
                obj7 = i;
            }
            if (i9 &= 64 != 0) {
                obj8 = obj5;
            }
            imageBitmap.readPixels(i2Arr2, obj3, obj4, obj5, obj6, obj7, obj8);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readPixels");
        throw obj1;
    }

    public abstract ColorSpace getColorSpace();

    public abstract int getConfig-_sVssgQ();

    public abstract boolean getHasAlpha();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract void prepareToDraw();

    public abstract void readPixels(int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7);
}
