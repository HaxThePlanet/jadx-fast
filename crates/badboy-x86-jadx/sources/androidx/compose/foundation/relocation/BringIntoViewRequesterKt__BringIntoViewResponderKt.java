package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000\u001a!\u0010\u0007\u001a\u00020\u0008*\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0008H\u0002¢\u0006\u0002\u0008\u000c¨\u0006\r", d2 = {"bringIntoViewResponder", "Landroidx/compose/ui/Modifier;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "findBringIntoViewParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "Landroidx/compose/ui/node/DelegatableNode;", "localRectOf", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "sourceCoordinates", "rect", "localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt", "foundation_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/foundation/relocation/BringIntoViewRequesterKt")
final class BringIntoViewRequesterKt__BringIntoViewResponderKt {
    public static final Rect access$localRectOf(LayoutCoordinates $receiver, LayoutCoordinates sourceCoordinates, Rect rect) {
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt($receiver, sourceCoordinates, rect);
    }

    public static final Modifier bringIntoViewResponder(Modifier $this$bringIntoViewResponder, androidx.compose.foundation.relocation.BringIntoViewResponder responder) {
        BringIntoViewResponderElement bringIntoViewResponderElement = new BringIntoViewResponderElement(responder);
        return $this$bringIntoViewResponder.then((Modifier)bringIntoViewResponderElement);
    }

    public static final androidx.compose.foundation.relocation.BringIntoViewParent findBringIntoViewParent(DelegatableNode $this$findBringIntoViewParent) {
        Object defaultBringIntoViewParent;
        if (!$this$findBringIntoViewParent.getNode().isAttached()) {
            return null;
        }
        if ((BringIntoViewParent)TraversableNodeKt.findNearestAncestor($this$findBringIntoViewParent, BringIntoViewResponderNode.TraverseKey) == null) {
            defaultBringIntoViewParent = BringIntoViewResponder_androidKt.defaultBringIntoViewParent($this$findBringIntoViewParent);
        }
        return defaultBringIntoViewParent;
    }

    private static final Rect localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt(LayoutCoordinates $this$localRectOf, LayoutCoordinates sourceCoordinates, Rect rect) {
        return rect.translate-k-4lQ0M($this$localRectOf.localBoundingBoxOf(sourceCoordinates, false).getTopLeft-F1C5BW0());
    }
}
