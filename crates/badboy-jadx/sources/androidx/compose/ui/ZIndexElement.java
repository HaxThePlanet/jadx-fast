package androidx.compose.ui;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0008\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0008\u0010\n\u001a\u00020\u0002H\u0016J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u000c\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0018", d2 = {"Landroidx/compose/ui/ZIndexElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/ZIndexNode;", "zIndex", "", "(F)V", "getZIndex", "()F", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ZIndexElement extends ModifierNodeElement<androidx.compose.ui.ZIndexNode> {

    public static final int $stable;
    private final float zIndex;
    static {
    }

    public ZIndexElement(float zIndex) {
        super();
        this.zIndex = zIndex;
    }

    public static androidx.compose.ui.ZIndexElement copy$default(androidx.compose.ui.ZIndexElement zIndexElement, float f2, int i3, Object object4) {
        float obj1;
        if (i3 &= 1 != 0) {
            obj1 = zIndexElement.zIndex;
        }
        return zIndexElement.copy(obj1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component1() {
        return this.zIndex;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.ZIndexElement copy(float f) {
        ZIndexElement zIndexElement = new ZIndexElement(f);
        return zIndexElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.ZIndexNode create() {
        ZIndexNode zIndexNode = new ZIndexNode(this.zIndex);
        return zIndexNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ZIndexElement) {
            return i2;
        }
        if (Float.compare(this.zIndex, obj.zIndex) != 0) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getZIndex() {
        return this.zIndex;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return Float.hashCode(this.zIndex);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        final String str = "zIndex";
        $this$inspectableProperties.setName(str);
        $this$inspectableProperties.getProperties().set(str, Float.valueOf(this.zIndex));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ZIndexElement(zIndex=").append(this.zIndex).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.Modifier.Node node) {
        update((ZIndexNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.ZIndexNode node) {
        node.setZIndex(this.zIndex);
    }
}
