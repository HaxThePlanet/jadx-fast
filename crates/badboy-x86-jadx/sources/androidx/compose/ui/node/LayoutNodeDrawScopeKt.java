package androidx.compose.ui.node;

import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003", d2 = {"nextDrawNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutNodeDrawScopeKt {
    public static final Modifier.Node access$nextDrawNode(androidx.compose.ui.node.DelegatableNode $receiver) {
        return LayoutNodeDrawScopeKt.nextDrawNode($receiver);
    }

    private static final Modifier.Node nextDrawNode(androidx.compose.ui.node.DelegatableNode $this$nextDrawNode) {
        Modifier.Node next;
        int i;
        int i2 = 0;
        int constructor-impl = NodeKind.constructor-impl(4);
        int i4 = 0;
        Modifier.Node child$ui_release = $this$nextDrawNode.getNode().getChild$ui_release();
        final int i6 = 0;
        if (child$ui_release == null) {
            return i6;
        }
        if (aggregateChildKindSet$ui_release &= constructor-impl == 0) {
            return i6;
        }
        next = child$ui_release;
        while (next != null) {
            next = next.getChild$ui_release();
        }
        return i6;
    }
}
