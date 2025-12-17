package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0005", d2 = {"scale", "Landroidx/compose/ui/Modifier;", "", "scaleX", "scaleY", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScaleKt {
    public static final Modifier scale(Modifier $this$scale, float scale) {
        return ScaleKt.scale($this$scale, scale, scale);
    }

    public static final Modifier scale(Modifier $this$scale, float scaleX, float scaleY) {
        Modifier graphicsLayer-Ap8cVGQ$default;
        int cmp;
        int i11;
        int i13;
        int i18;
        int i20;
        int i16;
        int i5;
        int i14;
        int i9;
        int i8;
        int i17;
        int i21;
        int i6;
        int i19;
        int i7;
        int i;
        int i10;
        int i3;
        int i22;
        int i15;
        int i12;
        int i2;
        int i4;
        cmp = 1065353216;
        i18 = 0;
        i11 = Float.compare(scaleX, cmp) == 0 ? i13 : i18;
        if (i11 != 0) {
            if (Float.compare(scaleY, cmp) == 0) {
            } else {
                i13 = i18;
            }
            if (i13 == 0) {
                graphicsLayer-Ap8cVGQ$default = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default($this$scale, scaleX, scaleY, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj15, false, 0, 0, 0, obj20, 0, obj22);
            } else {
                graphicsLayer-Ap8cVGQ$default = $this$scale;
            }
        } else {
        }
        return graphicsLayer-Ap8cVGQ$default;
    }
}
