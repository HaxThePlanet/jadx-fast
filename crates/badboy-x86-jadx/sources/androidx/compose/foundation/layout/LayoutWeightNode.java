package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000f¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/layout/LayoutWeightNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "weight", "", "fill", "", "(FZ)V", "getFill", "()Z", "setFill", "(Z)V", "getWeight", "()F", "setWeight", "(F)V", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutWeightNode extends Modifier.Node implements ParentDataModifierNode {

    public static final int $stable = 8;
    private boolean fill;
    private float weight;
    static {
        final int i = 8;
    }

    public LayoutWeightNode(float weight, boolean fill) {
        super();
        this.weight = weight;
        this.fill = fill;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getFill() {
        return this.fill;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getWeight() {
        return this.weight;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public androidx.compose.foundation.layout.RowColumnParentData modifyParentData(Density $this$modifyParentData, Object parentData) {
        Object obj;
        androidx.compose.foundation.layout.RowColumnParentData rowColumnParentData;
        int i3;
        int i4;
        int i6;
        int i5;
        int i;
        int i2;
        if (parentData instanceof RowColumnParentData != null) {
            obj = parentData;
        } else {
            obj = 0;
        }
        if (obj == null) {
            rowColumnParentData = new RowColumnParentData(0, 0, 0, 0, 15, 0);
            obj = rowColumnParentData;
        }
        Object obj2 = obj;
        int i7 = 0;
        obj2.setWeight(this.weight);
        obj2.setFill(this.fill);
        return obj;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
        return modifyParentData($this$modifyParentData, parentData);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFill(boolean <set-?>) {
        this.fill = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setWeight(float <set-?>) {
        this.weight = <set-?>;
    }
}
