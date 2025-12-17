package androidx.compose.ui.node;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\u0014\u0010\u0008\u001a\u00020\t*\u00020\n2\u0006\u0010\u0000\u001a\u00020\u0001H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u000b", d2 = {"useMinimumTouchTarget", "", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUseMinimumTouchTarget", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Z", "invalidateSemantics", "", "Landroidx/compose/ui/node/SemanticsModifierNode;", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/Modifier$Node;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SemanticsModifierNodeKt {
    public static final boolean getUseMinimumTouchTarget(SemanticsConfiguration $this$useMinimumTouchTarget) {
        int i;
        i = SemanticsConfigurationKt.getOrNull($this$useMinimumTouchTarget, SemanticsActions.INSTANCE.getOnClick()) != null ? 1 : 0;
        return i;
    }

    public static final void invalidateSemantics(androidx.compose.ui.node.SemanticsModifierNode $this$invalidateSemantics) {
        DelegatableNodeKt.requireLayoutNode((DelegatableNode)$this$invalidateSemantics).invalidateSemantics$ui_release();
    }

    public static final Rect touchBoundsInRoot(Modifier.Node $this$touchBoundsInRoot, boolean useMinimumTouchTarget) {
        if (!$this$touchBoundsInRoot.getNode().isAttached()) {
            return Rect.Companion.getZero();
        }
        int i = 8;
        if (!useMinimumTouchTarget) {
            int i2 = 0;
            return LayoutCoordinatesKt.boundsInRoot((LayoutCoordinates)DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)$this$touchBoundsInRoot, NodeKind.constructor-impl(i)));
        }
        int i3 = 0;
        return DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)$this$touchBoundsInRoot, NodeKind.constructor-impl(i)).touchBoundsInRoot();
    }
}
