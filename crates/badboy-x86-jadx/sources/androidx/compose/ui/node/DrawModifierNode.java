package androidx.compose.ui.node;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u000c\u0010\u0004\u001a\u00020\u0003*\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0006À\u0006\u0001", d2 = {"Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "onMeasureResultChanged", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DrawModifierNode extends androidx.compose.ui.node.DelegatableNode {
    @Override // androidx.compose.ui.node.DelegatableNode
    public abstract void draw(ContentDrawScope contentDrawScope);

    @Override // androidx.compose.ui.node.DelegatableNode
    public void onMeasureResultChanged() {
    }
}
