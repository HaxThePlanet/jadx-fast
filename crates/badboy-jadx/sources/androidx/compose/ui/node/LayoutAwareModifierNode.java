package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "onPlaced", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onRemeasured", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "(J)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LayoutAwareModifierNode extends androidx.compose.ui.node.DelegatableNode {
    @Override // androidx.compose.ui.node.DelegatableNode
    public void onPlaced(LayoutCoordinates coordinates) {
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public void onRemeasured-ozmzZPI(long size) {
    }
}
