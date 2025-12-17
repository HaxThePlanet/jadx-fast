package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0008\u0010\u0008\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u000c\u0010\u0013\u001a\u00020\u0011*\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Landroidx/compose/ui/layout/LayoutIdElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/LayoutIdModifier;", "layoutId", "", "(Ljava/lang/Object;)V", "component1", "copy", "create", "equals", "", "other", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LayoutIdElement extends ModifierNodeElement<androidx.compose.ui.layout.LayoutIdModifier> {

    private final Object layoutId;
    public LayoutIdElement(Object layoutId) {
        super();
        this.layoutId = layoutId;
    }

    private final Object component1() {
        return this.layoutId;
    }

    public static androidx.compose.ui.layout.LayoutIdElement copy$default(androidx.compose.ui.layout.LayoutIdElement layoutIdElement, Object object2, int i3, Object object4) {
        Object obj1;
        if (i3 &= 1 != 0) {
            obj1 = layoutIdElement.layoutId;
        }
        return layoutIdElement.copy(obj1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.layout.LayoutIdElement copy(Object object) {
        LayoutIdElement layoutIdElement = new LayoutIdElement(object);
        return layoutIdElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.layout.LayoutIdModifier create() {
        LayoutIdModifier layoutIdModifier = new LayoutIdModifier(this.layoutId);
        return layoutIdModifier;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof LayoutIdElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.layoutId, obj.layoutId)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.layoutId.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("layoutId");
        $this$inspectableProperties.setValue(this.layoutId);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LayoutIdElement(layoutId=").append(this.layoutId).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((LayoutIdModifier)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.layout.LayoutIdModifier node) {
        node.setLayoutId$ui_release(this.layoutId);
    }
}
