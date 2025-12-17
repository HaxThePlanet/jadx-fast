package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008¢\u0006\u0002\u0008\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0013\u001a\u00020\u0002H\u0016J\u0013\u0010\u0014\u001a\u00020\u00062\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u000c\u0010\u001b\u001a\u00020\n*\u00020\tH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\"\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008¢\u0006\u0002\u0008\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001c", d2 = {"Landroidx/compose/foundation/layout/IntrinsicWidthElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/IntrinsicWidthNode;", "width", "Landroidx/compose/foundation/layout/IntrinsicSize;", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/IntrinsicSize;ZLkotlin/jvm/functions/Function1;)V", "getEnforceIncoming", "()Z", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "getWidth", "()Landroidx/compose/foundation/layout/IntrinsicSize;", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class IntrinsicWidthElement extends ModifierNodeElement<androidx.compose.foundation.layout.IntrinsicWidthNode> {

    private final boolean enforceIncoming;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final androidx.compose.foundation.layout.IntrinsicSize width;
    public IntrinsicWidthElement(androidx.compose.foundation.layout.IntrinsicSize width, boolean enforceIncoming, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super();
        this.width = width;
        this.enforceIncoming = enforceIncoming;
        this.inspectorInfo = inspectorInfo;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.layout.IntrinsicWidthNode create() {
        IntrinsicWidthNode intrinsicWidthNode = new IntrinsicWidthNode(this.width, this.enforceIncoming);
        return intrinsicWidthNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        int i;
        Object obj;
        androidx.compose.foundation.layout.IntrinsicSize enforceIncoming2;
        androidx.compose.foundation.layout.IntrinsicSize enforceIncoming;
        if (this == other) {
            return 1;
        }
        if (other instanceof IntrinsicWidthElement) {
            obj = other;
        } else {
            obj = 0;
        }
        final int i2 = 0;
        if (obj == null) {
            return i2;
        }
        if (this.width == obj.width && this.enforceIncoming == obj.enforceIncoming) {
            if (this.enforceIncoming == obj.enforceIncoming) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.layout.IntrinsicSize getWidth() {
        return this.width;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        this.inspectorInfo.invoke($this$inspectableProperties);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.layout.IntrinsicWidthNode node) {
        node.setWidth(this.width);
        node.setEnforceIncoming(this.enforceIncoming);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((IntrinsicWidthNode)node);
    }
}
