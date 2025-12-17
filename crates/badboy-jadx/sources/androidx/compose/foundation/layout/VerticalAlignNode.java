package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\t\u001a\u00020\n*\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\u0005¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/layout/VerticalAlignNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Alignment$Vertical;)V", "getVertical", "()Landroidx/compose/ui/Alignment$Vertical;", "setVertical", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerticalAlignNode extends Modifier.Node implements ParentDataModifierNode {

    public static final int $stable = 8;
    private Alignment.Vertical vertical;
    static {
        final int i = 8;
    }

    public VerticalAlignNode(Alignment.Vertical vertical) {
        super();
        this.vertical = vertical;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final Alignment.Vertical getVertical() {
        return this.vertical;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public androidx.compose.foundation.layout.RowColumnParentData modifyParentData(Density $this$modifyParentData, Object parentData) {
        Object obj;
        androidx.compose.foundation.layout.RowColumnParentData rowColumnParentData;
        int i4;
        int i2;
        int i3;
        int i;
        int i6;
        int i5;
        if (parentData instanceof RowColumnParentData != null) {
            obj = parentData;
        } else {
            obj = 0;
        }
        if (obj == null) {
            rowColumnParentData = new RowColumnParentData(0, 0, 0, 0, 15, 0);
            obj = rowColumnParentData;
        }
        int i7 = 0;
        obj.setCrossAxisAlignment(CrossAxisAlignment.Companion.vertical$foundation_layout_release(this.vertical));
        return obj;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
        return modifyParentData($this$modifyParentData, parentData);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setVertical(Alignment.Vertical <set-?>) {
        this.vertical = <set-?>;
    }
}
