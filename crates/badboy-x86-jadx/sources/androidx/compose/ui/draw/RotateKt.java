package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004", d2 = {"rotate", "Landroidx/compose/ui/Modifier;", "degrees", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RotateKt {
    public static final Modifier rotate(Modifier $this$rotate, float degrees) {
        int i;
        Modifier graphicsLayer-Ap8cVGQ$default;
        Modifier modifier;
        int i6;
        int i2;
        int i3;
        int i15;
        int i12;
        int i9;
        int i4;
        int i19;
        int i13;
        int i14;
        int i17;
        int i8;
        int i18;
        int i7;
        int i16;
        int i10;
        int i5;
        int i11;
        int i20;
        i = Float.compare(degrees, i21) == 0 ? 1 : 0;
        if (i == 0) {
            graphicsLayer-Ap8cVGQ$default = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default($this$rotate, 0, 0, 0, 0, 0, 0, 0, 0, degrees, 0, 0, obj13, false, 0, 0, 0, obj18, 0, obj20);
        } else {
            graphicsLayer-Ap8cVGQ$default = $this$rotate;
        }
        return graphicsLayer-Ap8cVGQ$default;
    }
}
