package androidx.compose.ui.viewinterop;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008Â\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u000c\u0010\u000e\u001a\u00020\u000c*\u00020\u000fH\u0016¨\u0006\u0010", d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "()V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusGroupPropertiesElement extends ModifierNodeElement<androidx.compose.ui.viewinterop.FocusGroupPropertiesNode> {

    public static final androidx.compose.ui.viewinterop.FocusGroupPropertiesElement INSTANCE;
    static {
        FocusGroupPropertiesElement focusGroupPropertiesElement = new FocusGroupPropertiesElement();
        FocusGroupPropertiesElement.INSTANCE = focusGroupPropertiesElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.viewinterop.FocusGroupPropertiesNode create() {
        FocusGroupPropertiesNode focusGroupPropertiesNode = new FocusGroupPropertiesNode();
        return focusGroupPropertiesNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        int i;
        i = other == this ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return "FocusGroupProperties".hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("FocusGroupProperties");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((FocusGroupPropertiesNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.viewinterop.FocusGroupPropertiesNode node) {
    }
}
