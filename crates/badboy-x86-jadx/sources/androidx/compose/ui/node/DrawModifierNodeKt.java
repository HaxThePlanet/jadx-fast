package androidx.compose.ui.node;

import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"invalidateDraw", "", "Landroidx/compose/ui/node/DrawModifierNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DrawModifierNodeKt {
    public static final void invalidateDraw(androidx.compose.ui.node.DrawModifierNode $this$invalidateDraw) {
        boolean requireCoordinator-64DMado;
        int constructor-impl;
        int i;
        if ($this$invalidateDraw.getNode().isAttached()) {
            int i2 = 0;
            DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)$this$invalidateDraw, NodeKind.constructor-impl(1)).invalidateLayer();
        }
    }
}
