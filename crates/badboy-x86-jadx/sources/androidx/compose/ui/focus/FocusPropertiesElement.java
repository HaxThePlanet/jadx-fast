package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0008\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0008\u0010\n\u001a\u00020\u0002H\u0016J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u000c\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0018", d2 = {"Landroidx/compose/ui/focus/FocusPropertiesElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusPropertiesNode;", "scope", "Landroidx/compose/ui/focus/FocusPropertiesScope;", "(Landroidx/compose/ui/focus/FocusPropertiesScope;)V", "getScope", "()Landroidx/compose/ui/focus/FocusPropertiesScope;", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusPropertiesElement extends ModifierNodeElement<androidx.compose.ui.focus.FocusPropertiesNode> {

    private final androidx.compose.ui.focus.FocusPropertiesScope scope;
    public FocusPropertiesElement(androidx.compose.ui.focus.FocusPropertiesScope scope) {
        super();
        this.scope = scope;
    }

    public static androidx.compose.ui.focus.FocusPropertiesElement copy$default(androidx.compose.ui.focus.FocusPropertiesElement focusPropertiesElement, androidx.compose.ui.focus.FocusPropertiesScope focusPropertiesScope2, int i3, Object object4) {
        androidx.compose.ui.focus.FocusPropertiesScope obj1;
        if (i3 &= 1 != 0) {
            obj1 = focusPropertiesElement.scope;
        }
        return focusPropertiesElement.copy(obj1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.focus.FocusPropertiesScope component1() {
        return this.scope;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.focus.FocusPropertiesElement copy(androidx.compose.ui.focus.FocusPropertiesScope focusPropertiesScope) {
        FocusPropertiesElement focusPropertiesElement = new FocusPropertiesElement(focusPropertiesScope);
        return focusPropertiesElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.focus.FocusPropertiesNode create() {
        FocusPropertiesNode focusPropertiesNode = new FocusPropertiesNode(this.scope);
        return focusPropertiesNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof FocusPropertiesElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.scope, obj.scope)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.focus.FocusPropertiesScope getScope() {
        return this.scope;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.scope.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("focusProperties");
        $this$inspectableProperties.getProperties().set("scope", this.scope);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FocusPropertiesElement(scope=").append(this.scope).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((FocusPropertiesNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.focus.FocusPropertiesNode node) {
        node.setFocusPropertiesScope(this.scope);
    }
}
