package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0006\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u000c\u0010\u0010\u001a\u00020\u000e*\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "requester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;)V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BringIntoViewRequesterElement extends ModifierNodeElement<androidx.compose.foundation.relocation.BringIntoViewRequesterNode> {

    private final androidx.compose.foundation.relocation.BringIntoViewRequester requester;
    public BringIntoViewRequesterElement(androidx.compose.foundation.relocation.BringIntoViewRequester requester) {
        super();
        this.requester = requester;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.relocation.BringIntoViewRequesterNode create() {
        BringIntoViewRequesterNode bringIntoViewRequesterNode = new BringIntoViewRequesterNode(this.requester);
        return bringIntoViewRequesterNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        boolean equal;
        int i;
        androidx.compose.foundation.relocation.BringIntoViewRequester requester;
        if (this != other) {
            if (other instanceof BringIntoViewRequesterElement && Intrinsics.areEqual(this.requester, obj.requester)) {
                if (Intrinsics.areEqual(this.requester, obj.requester)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.requester.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        final String str = "bringIntoViewRequester";
        $this$inspectableProperties.setName(str);
        $this$inspectableProperties.getProperties().set(str, this.requester);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.relocation.BringIntoViewRequesterNode node) {
        node.updateRequester(this.requester);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((BringIntoViewRequesterNode)node);
    }
}
