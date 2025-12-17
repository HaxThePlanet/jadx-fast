package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"currentValueOf", "T", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "local", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CompositionLocalConsumerModifierNodeKt {
    public static final <T> T currentValueOf(androidx.compose.ui.node.CompositionLocalConsumerModifierNode $this$currentValueOf, CompositionLocal<T> local) {
        String $i$a$CheckPreconditionCompositionLocalConsumerModifierNodeKt$currentValueOf$1;
        final int i = 0;
        if (!$this$currentValueOf.getNode().isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("Cannot read CompositionLocal because the Modifier node is not currently attached.");
        }
        return DelegatableNodeKt.requireLayoutNode((DelegatableNode)$this$currentValueOf).getCompositionLocalMap().get(local);
    }
}
