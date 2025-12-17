package androidx.compose.animation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0008\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0008\u0010\n\u001a\u00020\u0002H\u0016J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u000c\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0018", d2 = {"Landroidx/compose/animation/SharedBoundsNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SharedBoundsNode;", "sharedElementState", "Landroidx/compose/animation/SharedElementInternalState;", "(Landroidx/compose/animation/SharedElementInternalState;)V", "getSharedElementState", "()Landroidx/compose/animation/SharedElementInternalState;", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SharedBoundsNodeElement extends ModifierNodeElement<androidx.compose.animation.SharedBoundsNode> {

    public static final int $stable;
    private final androidx.compose.animation.SharedElementInternalState sharedElementState;
    static {
    }

    public SharedBoundsNodeElement(androidx.compose.animation.SharedElementInternalState sharedElementState) {
        super();
        this.sharedElementState = sharedElementState;
    }

    public static androidx.compose.animation.SharedBoundsNodeElement copy$default(androidx.compose.animation.SharedBoundsNodeElement sharedBoundsNodeElement, androidx.compose.animation.SharedElementInternalState sharedElementInternalState2, int i3, Object object4) {
        androidx.compose.animation.SharedElementInternalState obj1;
        if (i3 &= 1 != 0) {
            obj1 = sharedBoundsNodeElement.sharedElementState;
        }
        return sharedBoundsNodeElement.copy(obj1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.SharedElementInternalState component1() {
        return this.sharedElementState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.SharedBoundsNodeElement copy(androidx.compose.animation.SharedElementInternalState sharedElementInternalState) {
        SharedBoundsNodeElement sharedBoundsNodeElement = new SharedBoundsNodeElement(sharedElementInternalState);
        return sharedBoundsNodeElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.animation.SharedBoundsNode create() {
        SharedBoundsNode sharedBoundsNode = new SharedBoundsNode(this.sharedElementState);
        return sharedBoundsNode;
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
        if (!object instanceof SharedBoundsNodeElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.sharedElementState, obj.sharedElementState)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.SharedElementInternalState getSharedElementState() {
        return this.sharedElementState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.sharedElementState.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("sharedBounds");
        $this$inspectableProperties.getProperties().set("sharedElementState", this.sharedElementState);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SharedBoundsNodeElement(sharedElementState=").append(this.sharedElementState).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.animation.SharedBoundsNode node) {
        node.setState$animation_release(this.sharedElementState);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((SharedBoundsNode)node);
    }
}
