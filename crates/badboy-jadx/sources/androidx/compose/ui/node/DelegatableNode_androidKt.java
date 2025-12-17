package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"requireView", "Landroid/view/View;", "Landroidx/compose/ui/node/DelegatableNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DelegatableNode_androidKt {
    public static final View requireView(androidx.compose.ui.node.DelegatableNode $this$requireView) {
        String $i$a$CheckPreconditionDelegatableNode_androidKt$requireView$1;
        int i = 0;
        if (!$this$requireView.getNode().isAttached()) {
            int i2 = 0;
            InlineClassHelperKt.throwIllegalStateException("Cannot get View because the Modifier node is not currently attached.");
        }
        androidx.compose.ui.node.Owner requireOwner = LayoutNodeKt.requireOwner(DelegatableNodeKt.requireLayoutNode($this$requireView));
        Intrinsics.checkNotNull(requireOwner, "null cannot be cast to non-null type android.view.View");
        return (View)requireOwner;
    }
}
