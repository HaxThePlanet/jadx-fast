package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001a\u000c\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000\u001a\u000c\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0008", d2 = {"focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "Landroidx/compose/ui/focus/FocusTargetNode;", "getFocusTransactionManager", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTransactionManager;", "invalidateFocusTarget", "", "requireTransactionManager", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusTargetNodeKt {
    public static final androidx.compose.ui.focus.FocusTransactionManager access$getFocusTransactionManager(androidx.compose.ui.focus.FocusTargetNode $receiver) {
        return FocusTargetNodeKt.getFocusTransactionManager($receiver);
    }

    private static final androidx.compose.ui.focus.FocusTransactionManager getFocusTransactionManager(androidx.compose.ui.focus.FocusTargetNode $this$focusTransactionManager) {
        Object coordinator$ui_release;
        androidx.compose.ui.focus.FocusTransactionManager focusTransactionManager;
        coordinator$ui_release = $this$focusTransactionManager.getNode().getCoordinator$ui_release();
        coordinator$ui_release = coordinator$ui_release.getLayoutNode();
        coordinator$ui_release = coordinator$ui_release.getOwner$ui_release();
        coordinator$ui_release = coordinator$ui_release.getFocusOwner();
        if (coordinator$ui_release != null && coordinator$ui_release != null && coordinator$ui_release != null && coordinator$ui_release != null) {
            coordinator$ui_release = coordinator$ui_release.getLayoutNode();
            if (coordinator$ui_release != null) {
                coordinator$ui_release = coordinator$ui_release.getOwner$ui_release();
                if (coordinator$ui_release != null) {
                    coordinator$ui_release = coordinator$ui_release.getFocusOwner();
                    if (coordinator$ui_release != null) {
                        focusTransactionManager = coordinator$ui_release.getFocusTransactionManager();
                    } else {
                        focusTransactionManager = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return focusTransactionManager;
    }

    public static final void invalidateFocusTarget(androidx.compose.ui.focus.FocusTargetNode $this$invalidateFocusTarget) {
        DelegatableNodeKt.requireOwner((DelegatableNode)$this$invalidateFocusTarget).getFocusOwner().scheduleInvalidation($this$invalidateFocusTarget);
    }

    public static final androidx.compose.ui.focus.FocusTransactionManager requireTransactionManager(androidx.compose.ui.focus.FocusTargetNode $this$requireTransactionManager) {
        return DelegatableNodeKt.requireOwner((DelegatableNode)$this$requireTransactionManager).getFocusOwner().getFocusTransactionManager();
    }
}
