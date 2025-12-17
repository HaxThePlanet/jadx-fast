package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\t\u001a\u00020\n*\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\u0005¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/layout/FillCrossAxisSizeNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "fraction", "", "(F)V", "getFraction", "()F", "setFraction", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FillCrossAxisSizeNode extends Modifier.Node implements ParentDataModifierNode {

    public static final int $stable = 8;
    private float fraction;
    static {
        final int i = 8;
    }

    public FillCrossAxisSizeNode(float fraction) {
        super();
        this.fraction = fraction;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getFraction() {
        return this.fraction;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public androidx.compose.foundation.layout.RowColumnParentData modifyParentData(Density $this$modifyParentData, Object parentData) {
        int i2;
        androidx.compose.foundation.layout.RowColumnParentData rowColumnParentData;
        int i5;
        int i4;
        androidx.compose.foundation.layout.FlowLayoutData flowLayoutData;
        int fraction;
        int i3;
        int i;
        int i6;
        if (parentData instanceof RowColumnParentData != null) {
            i2 = parentData;
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            rowColumnParentData = new RowColumnParentData(0, 0, 0, 0, 15, 0);
            i2 = rowColumnParentData;
        }
        int i7 = i2;
        int i8 = 0;
        if (i7.getFlowLayoutData() == null) {
            flowLayoutData = new FlowLayoutData(this.fraction);
        }
        i7.setFlowLayoutData(flowLayoutData);
        androidx.compose.foundation.layout.FlowLayoutData flowLayoutData2 = i7.getFlowLayoutData();
        Intrinsics.checkNotNull(flowLayoutData2);
        flowLayoutData2.setFillCrossAxisFraction(this.fraction);
        return i2;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
        return modifyParentData($this$modifyParentData, parentData);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFraction(float <set-?>) {
        this.fraction = <set-?>;
    }
}
