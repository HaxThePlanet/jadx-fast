package androidx.compose.ui.node;

import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a0\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0008", d2 = {"nextUntil", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "stopType", "nextUntil-hw7D004", "(Landroidx/compose/ui/node/DelegatableNode;II)Landroidx/compose/ui/Modifier$Node;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NodeCoordinatorKt {
    public static final Modifier.Node access$nextUntil-hw7D004(androidx.compose.ui.node.DelegatableNode $receiver, int type, int stopType) {
        return NodeCoordinatorKt.nextUntil-hw7D004($receiver, type, stopType);
    }

    private static final Modifier.Node nextUntil-hw7D004(androidx.compose.ui.node.DelegatableNode $this$nextUntil_u2dhw7D004, int type, int stopType) {
        Modifier.Node next;
        int kindSet$ui_release;
        int i;
        Modifier.Node child$ui_release = $this$nextUntil_u2dhw7D004.getNode().getChild$ui_release();
        final int i2 = 0;
        if (child$ui_release == null) {
            return i2;
        }
        if (aggregateChildKindSet$ui_release &= type == 0) {
            return i2;
        }
        next = child$ui_release;
        while (next != null) {
            kindSet$ui_release = next.getKindSet$ui_release();
            next = next.getChild$ui_release();
        }
        return i2;
    }
}
