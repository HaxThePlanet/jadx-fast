package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007¨\u0006\u0003", d2 = {"alpha", "Landroidx/compose/ui/Modifier;", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AlphaKt {
    public static final Modifier alpha(Modifier $this$alpha, float alpha) {
        int i10;
        Modifier graphicsLayer-Ap8cVGQ$default;
        Modifier modifier;
        int i5;
        int i6;
        int i19;
        int i4;
        int i20;
        int i2;
        int i7;
        int i;
        int i18;
        int i9;
        int i17;
        int i12;
        int i15;
        int i3;
        int i8;
        int i11;
        int i13;
        int i14;
        int i16;
        i10 = Float.compare(alpha, i21) == 0 ? 1 : 0;
        if (i10 == 0) {
            graphicsLayer-Ap8cVGQ$default = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default($this$alpha, 0, 0, alpha, 0, 0, 0, 0, 0, 0, 0, 0, obj13, false, 1, 0, 0, obj18, 0, obj20);
        } else {
            graphicsLayer-Ap8cVGQ$default = $this$alpha;
        }
        return graphicsLayer-Ap8cVGQ$default;
    }
}
