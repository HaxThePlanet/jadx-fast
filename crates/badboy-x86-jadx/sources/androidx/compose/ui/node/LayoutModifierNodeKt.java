package androidx.compose.ui.node;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u000c\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0007", d2 = {"invalidateLayer", "", "Landroidx/compose/ui/node/LayoutModifierNode;", "invalidateMeasurement", "invalidatePlacement", "remeasureSync", "requestRemeasure", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutModifierNodeKt {
    public static final void invalidateLayer(androidx.compose.ui.node.LayoutModifierNode $this$invalidateLayer) {
        int i = 0;
        DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)$this$invalidateLayer, NodeKind.constructor-impl(2)).invalidateLayer();
    }

    public static final void invalidateMeasurement(androidx.compose.ui.node.LayoutModifierNode $this$invalidateMeasurement) {
        DelegatableNodeKt.requireLayoutNode((DelegatableNode)$this$invalidateMeasurement).invalidateMeasurements$ui_release();
    }

    public static final void invalidatePlacement(androidx.compose.ui.node.LayoutModifierNode $this$invalidatePlacement) {
        LayoutNode.requestRelayout$ui_release$default(DelegatableNodeKt.requireLayoutNode((DelegatableNode)$this$invalidatePlacement), false, 1, 0);
    }

    public static final void remeasureSync(androidx.compose.ui.node.LayoutModifierNode $this$remeasureSync) {
        DelegatableNodeKt.requireLayoutNode((DelegatableNode)$this$remeasureSync).forceRemeasure();
    }

    public static final void requestRemeasure(androidx.compose.ui.node.LayoutModifierNode $this$requestRemeasure) {
        LayoutNode.requestRemeasure$ui_release$default(DelegatableNodeKt.requireLayoutNode((DelegatableNode)$this$requestRemeasure), false, false, false, 7, 0);
    }
}
