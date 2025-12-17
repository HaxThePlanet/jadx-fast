package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.FilterQuality.Companion;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"BitmapPainter", "Landroidx/compose/ui/graphics/painter/BitmapPainter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "BitmapPainter-QZhYCtY", "(Landroidx/compose/ui/graphics/ImageBitmap;JJI)Landroidx/compose/ui/graphics/painter/BitmapPainter;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BitmapPainterKt {
    public static final androidx.compose.ui.graphics.painter.BitmapPainter BitmapPainter-QZhYCtY(ImageBitmap image, long srcOffset, long srcSize, int filterQuality) {
        BitmapPainter bitmapPainter = new BitmapPainter(image, srcOffset, obj3, filterQuality, obj5, 0);
        final int obj8 = 0;
        bitmapPainter.setFilterQuality-vDHp3xo$ui_graphics_release(obj12);
        return bitmapPainter;
    }

    public static androidx.compose.ui.graphics.painter.BitmapPainter BitmapPainter-QZhYCtY$default(ImageBitmap imageBitmap, long l2, long l3, int i4, int i5, Object object6) {
        long l4;
        long l;
        int i;
        long obj7;
        int obj8;
        long obj9;
        int obj11;
        if (obj12 & 2 != 0) {
            l4 = obj7;
        } else {
            l4 = l2;
        }
        if (obj12 & 4 != 0) {
            l = obj9;
        } else {
            l = i4;
        }
        if (obj12 & 8 != 0) {
            i = obj11;
        } else {
            i = object6;
        }
        return BitmapPainterKt.BitmapPainter-QZhYCtY(imageBitmap, l4, obj2, l);
    }
}
