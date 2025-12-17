package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0005H&J\u0008\u0010\u0006\u001a\u00020\u0005H\u0016J*\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH&ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0008\u0010\u0010\u001a\u00020\u0005H\u0016J\u0008\u0010\u0011\u001a\u00020\u0003H\u0016ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0012À\u0006\u0001", d2 = {"Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "interceptOutOfBoundsChildEvents", "", "onCancelPointerInput", "", "onDensityChange", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onViewConfigurationChange", "sharePointerInputWithSiblings", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PointerInputModifierNode extends androidx.compose.ui.node.DelegatableNode {
    @Override // androidx.compose.ui.node.DelegatableNode
    public boolean interceptOutOfBoundsChildEvents() {
        return 0;
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public abstract void onCancelPointerInput();

    @Override // androidx.compose.ui.node.DelegatableNode
    public void onDensityChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public abstract void onPointerEvent-H0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass2, long l3);

    @Override // androidx.compose.ui.node.DelegatableNode
    public void onViewConfigurationChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public boolean sharePointerInputWithSiblings() {
        return 0;
    }
}
