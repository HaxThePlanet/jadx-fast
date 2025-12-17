package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.Image;
import android.media.Image.Plane;
import androidx.compose.ui.graphics.ColorKt;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003", d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/media/Image;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayerSnapshot_androidKt {
    public static final Bitmap access$toBitmap(Image $receiver) {
        return LayerSnapshot_androidKt.toBitmap($receiver);
    }

    private static final Bitmap toBitmap(Image $this$toBitmap) {
        int i2;
        int i4;
        int i3;
        int i;
        int i5;
        int i6;
        int argb-8_81llA;
        final Image.Plane[] planes = $this$toBitmap.getPlanes();
        Intrinsics.checkNotNull(planes);
        final int i7 = 0;
        width *= height;
        int[] iArr = new int[i9];
        planes[0].getBuffer().asIntBuffer().get(iArr);
        i2 = 0;
        while (i2 < i9) {
            i4 = iArr[i2];
            iArr[i2] = ColorKt.toArgb-8_81llA(ColorKt.Color(i4 & 255, i10 &= 255, i11 &= 255, i12 &= 255));
            i2++;
        }
        return Bitmap.createBitmap(iArr, $this$toBitmap.getWidth(), $this$toBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }
}
