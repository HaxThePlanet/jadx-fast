package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003H\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\r", d2 = {"BlurEffect", "Landroidx/compose/ui/graphics/BlurEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "BlurEffect-3YTHUZs", "(FFI)Landroidx/compose/ui/graphics/BlurEffect;", "OffsetEffect", "Landroidx/compose/ui/graphics/OffsetEffect;", "offsetX", "offsetY", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RenderEffectKt {
    public static final androidx.compose.ui.graphics.BlurEffect BlurEffect-3YTHUZs(float radiusX, float radiusY, int edgeTreatment) {
        BlurEffect blurEffect = new BlurEffect(0, radiusX, radiusY, edgeTreatment, 0);
        return blurEffect;
    }

    public static androidx.compose.ui.graphics.BlurEffect BlurEffect-3YTHUZs$default(float f, float f2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 4 != 0) {
            obj2 = TileMode.Companion.getClamp-3opZhB0();
        }
        return RenderEffectKt.BlurEffect-3YTHUZs(f, f2, obj2);
    }

    public static final androidx.compose.ui.graphics.OffsetEffect OffsetEffect(float offsetX, float offsetY) {
        final int i = 0;
        OffsetEffect offsetEffect = new OffsetEffect(i, OffsetKt.Offset(offsetX, offsetY), obj3, i);
        return offsetEffect;
    }
}
