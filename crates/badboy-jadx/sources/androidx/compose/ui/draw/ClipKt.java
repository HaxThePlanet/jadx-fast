package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u000c\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0007¨\u0006\u0005", d2 = {"clip", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clipToBounds", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ClipKt {
    public static final Modifier clip(Modifier $this$clip, Shape shape) {
        return GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default($this$clip, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj13, shape, 1, 0, 0, obj18, 0, obj20);
    }

    public static final Modifier clipToBounds(Modifier $this$clipToBounds) {
        return GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default($this$clipToBounds, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj13, false, 1, 0, 0, obj18, 0, obj20);
    }
}
