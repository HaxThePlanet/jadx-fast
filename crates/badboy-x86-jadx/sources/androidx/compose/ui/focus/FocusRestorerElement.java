package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\u0008\u0010\u000b\u001a\u00020\u0002H\u0016J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u000c\u0010\u0017\u001a\u00020\u0015*\u00020\u0018H\u0016R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Landroidx/compose/ui/focus/FocusRestorerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusRestorerNode;", "onRestoreFailed", "Lkotlin/Function0;", "Landroidx/compose/ui/focus/FocusRequester;", "(Lkotlin/jvm/functions/Function0;)V", "getOnRestoreFailed", "()Lkotlin/jvm/functions/Function0;", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusRestorerElement extends ModifierNodeElement<androidx.compose.ui.focus.FocusRestorerNode> {

    private final Function0<androidx.compose.ui.focus.FocusRequester> onRestoreFailed;
    public FocusRestorerElement(Function0<androidx.compose.ui.focus.FocusRequester> onRestoreFailed) {
        super();
        this.onRestoreFailed = onRestoreFailed;
    }

    public static androidx.compose.ui.focus.FocusRestorerElement copy$default(androidx.compose.ui.focus.FocusRestorerElement focusRestorerElement, Function0 function02, int i3, Object object4) {
        Function0 obj1;
        if (i3 &= 1 != 0) {
            obj1 = focusRestorerElement.onRestoreFailed;
        }
        return focusRestorerElement.copy(obj1);
    }

    public final Function0<androidx.compose.ui.focus.FocusRequester> component1() {
        return this.onRestoreFailed;
    }

    public final androidx.compose.ui.focus.FocusRestorerElement copy(Function0<androidx.compose.ui.focus.FocusRequester> function0) {
        FocusRestorerElement focusRestorerElement = new FocusRestorerElement(function0);
        return focusRestorerElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.focus.FocusRestorerNode create() {
        FocusRestorerNode focusRestorerNode = new FocusRestorerNode(this.onRestoreFailed);
        return focusRestorerNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof FocusRestorerElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onRestoreFailed, obj.onRestoreFailed)) {
            return i2;
        }
        return i;
    }

    public final Function0<androidx.compose.ui.focus.FocusRequester> getOnRestoreFailed() {
        return this.onRestoreFailed;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        if (this.onRestoreFailed == null) {
            i = 0;
        } else {
            i = this.onRestoreFailed.hashCode();
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("focusRestorer");
        $this$inspectableProperties.getProperties().set("onRestoreFailed", this.onRestoreFailed);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FocusRestorerElement(onRestoreFailed=").append(this.onRestoreFailed).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((FocusRestorerNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.focus.FocusRestorerNode node) {
        node.setOnRestoreFailed(this.onRestoreFailed);
    }
}
