package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0008\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u000c\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001c", d2 = {"Landroidx/compose/material3/ThumbElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ThumbNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "checked", "", "(Landroidx/compose/foundation/interaction/InteractionSource;Z)V", "getChecked", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "component1", "component2", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ThumbElement extends ModifierNodeElement<androidx.compose.material3.ThumbNode> {

    private final boolean checked;
    private final InteractionSource interactionSource;
    public ThumbElement(InteractionSource interactionSource, boolean checked) {
        super();
        this.interactionSource = interactionSource;
        this.checked = checked;
    }

    public static androidx.compose.material3.ThumbElement copy$default(androidx.compose.material3.ThumbElement thumbElement, InteractionSource interactionSource2, boolean z3, int i4, Object object5) {
        InteractionSource obj1;
        boolean obj2;
        if (i4 & 1 != 0) {
            obj1 = thumbElement.interactionSource;
        }
        if (i4 &= 2 != 0) {
            obj2 = thumbElement.checked;
        }
        return thumbElement.copy(obj1, obj2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final InteractionSource component1() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component2() {
        return this.checked;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.material3.ThumbElement copy(InteractionSource interactionSource, boolean z2) {
        ThumbElement thumbElement = new ThumbElement(interactionSource, z2);
        return thumbElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.material3.ThumbNode create() {
        ThumbNode thumbNode = new ThumbNode(this.interactionSource, this.checked);
        return thumbNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ThumbElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.interactionSource, obj.interactionSource)) {
            return i2;
        }
        if (this.checked != obj.checked) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getChecked() {
        return this.checked;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("switchThumb");
        $this$inspectableProperties.getProperties().set("interactionSource", this.interactionSource);
        $this$inspectableProperties.getProperties().set("checked", Boolean.valueOf(this.checked));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ThumbElement(interactionSource=").append(this.interactionSource).append(", checked=").append(this.checked).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.material3.ThumbNode node) {
        boolean checked;
        node.setInteractionSource(this.interactionSource);
        if (node.getChecked() != this.checked) {
            LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode)node);
        }
        node.setChecked(this.checked);
        node.update();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((ThumbNode)node);
    }
}
