package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0008\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u000c\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001c", d2 = {"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "(Landroidx/compose/ui/input/pointer/PointerIcon;Z)V", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "getOverrideDescendants", "()Z", "component1", "component2", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PointerHoverIconModifierElement extends ModifierNodeElement<androidx.compose.ui.input.pointer.PointerHoverIconModifierNode> {

    public static final int $stable;
    private final androidx.compose.ui.input.pointer.PointerIcon icon;
    private final boolean overrideDescendants;
    static {
    }

    public PointerHoverIconModifierElement(androidx.compose.ui.input.pointer.PointerIcon icon, boolean overrideDescendants) {
        super();
        this.icon = icon;
        this.overrideDescendants = overrideDescendants;
    }

    public PointerHoverIconModifierElement(androidx.compose.ui.input.pointer.PointerIcon pointerIcon, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(pointerIcon, obj2);
    }

    public static androidx.compose.ui.input.pointer.PointerHoverIconModifierElement copy$default(androidx.compose.ui.input.pointer.PointerHoverIconModifierElement pointerHoverIconModifierElement, androidx.compose.ui.input.pointer.PointerIcon pointerIcon2, boolean z3, int i4, Object object5) {
        androidx.compose.ui.input.pointer.PointerIcon obj1;
        boolean obj2;
        if (i4 & 1 != 0) {
            obj1 = pointerHoverIconModifierElement.icon;
        }
        if (i4 &= 2 != 0) {
            obj2 = pointerHoverIconModifierElement.overrideDescendants;
        }
        return pointerHoverIconModifierElement.copy(obj1, obj2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.input.pointer.PointerIcon component1() {
        return this.icon;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component2() {
        return this.overrideDescendants;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.input.pointer.PointerHoverIconModifierElement copy(androidx.compose.ui.input.pointer.PointerIcon pointerIcon, boolean z2) {
        PointerHoverIconModifierElement pointerHoverIconModifierElement = new PointerHoverIconModifierElement(pointerIcon, z2);
        return pointerHoverIconModifierElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.input.pointer.PointerHoverIconModifierNode create() {
        PointerHoverIconModifierNode pointerHoverIconModifierNode = new PointerHoverIconModifierNode(this.icon, this.overrideDescendants);
        return pointerHoverIconModifierNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof PointerHoverIconModifierElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.icon, obj.icon)) {
            return i2;
        }
        if (this.overrideDescendants != obj.overrideDescendants) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.input.pointer.PointerIcon getIcon() {
        return this.icon;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("pointerHoverIcon");
        $this$inspectableProperties.getProperties().set("icon", this.icon);
        $this$inspectableProperties.getProperties().set("overrideDescendants", Boolean.valueOf(this.overrideDescendants));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PointerHoverIconModifierElement(icon=").append(this.icon).append(", overrideDescendants=").append(this.overrideDescendants).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((PointerHoverIconModifierNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.input.pointer.PointerHoverIconModifierNode node) {
        node.setIcon(this.icon);
        node.setOverrideDescendants(this.overrideDescendants);
    }
}
