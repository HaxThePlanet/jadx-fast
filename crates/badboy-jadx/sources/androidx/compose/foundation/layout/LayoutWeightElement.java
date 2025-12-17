package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000c\u001a\u00020\u0002H\u0016J\u0013\u0010\r\u001a\u00020\u00062\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u000c\u0010\u0015\u001a\u00020\u0013*\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/layout/LayoutWeightElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/LayoutWeightNode;", "weight", "", "fill", "", "(FZ)V", "getFill", "()Z", "getWeight", "()F", "create", "equals", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutWeightElement extends ModifierNodeElement<androidx.compose.foundation.layout.LayoutWeightNode> {

    public static final int $stable;
    private final boolean fill;
    private final float weight;
    static {
    }

    public LayoutWeightElement(float weight, boolean fill) {
        super();
        this.weight = weight;
        this.fill = fill;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.layout.LayoutWeightNode create() {
        LayoutWeightNode layoutWeightNode = new LayoutWeightNode(this.weight, this.fill);
        return layoutWeightNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        int i;
        Object obj;
        int fill;
        boolean weight;
        i = 1;
        if (this == other) {
            return i;
        }
        if (other instanceof LayoutWeightElement) {
            obj = other;
        } else {
            obj = 0;
        }
        final int i2 = 0;
        if (obj == null) {
            return i2;
        }
        fill = Float.compare(weight2, weight) == 0 ? i : i2;
        if (fill != 0 && this.fill == obj.fill) {
            if (this.fill == obj.fill) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getFill() {
        return this.fill;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getWeight() {
        return this.weight;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        String str = "weight";
        $this$inspectableProperties.setName(str);
        $this$inspectableProperties.setValue(Float.valueOf(this.weight));
        $this$inspectableProperties.getProperties().set(str, Float.valueOf(this.weight));
        $this$inspectableProperties.getProperties().set("fill", Boolean.valueOf(this.fill));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.layout.LayoutWeightNode node) {
        node.setWeight(this.weight);
        node.setFill(this.fill);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((LayoutWeightNode)node);
    }
}
