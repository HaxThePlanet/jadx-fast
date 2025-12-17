package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0000*\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000f¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/layout/BoxChildDataNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "", "(Landroidx/compose/ui/Alignment;Z)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getMatchParentSize", "()Z", "setMatchParentSize", "(Z)V", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BoxChildDataNode extends Modifier.Node implements ParentDataModifierNode {

    private Alignment alignment;
    private boolean matchParentSize;
    public BoxChildDataNode(Alignment alignment, boolean matchParentSize) {
        super();
        this.alignment = alignment;
        this.matchParentSize = matchParentSize;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getMatchParentSize() {
        return this.matchParentSize;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public androidx.compose.foundation.layout.BoxChildDataNode modifyParentData(Density $this$modifyParentData, Object parentData) {
        return this;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
        return modifyParentData($this$modifyParentData, parentData);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setAlignment(Alignment <set-?>) {
        this.alignment = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setMatchParentSize(boolean <set-?>) {
        this.matchParentSize = <set-?>;
    }
}
