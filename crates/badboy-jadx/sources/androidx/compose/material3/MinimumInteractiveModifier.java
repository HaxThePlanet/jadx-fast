package androidx.compose.material3;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008À\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u000c\u0010\u000e\u001a\u00020\u000c*\u00020\u000fH\u0016¨\u0006\u0010", d2 = {"Landroidx/compose/material3/MinimumInteractiveModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/MinimumInteractiveModifierNode;", "()V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MinimumInteractiveModifier extends ModifierNodeElement<androidx.compose.material3.MinimumInteractiveModifierNode> {

    public static final int $stable;
    public static final androidx.compose.material3.MinimumInteractiveModifier INSTANCE;
    static {
        MinimumInteractiveModifier minimumInteractiveModifier = new MinimumInteractiveModifier();
        MinimumInteractiveModifier.INSTANCE = minimumInteractiveModifier;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.material3.MinimumInteractiveModifierNode create() {
        MinimumInteractiveModifierNode minimumInteractiveModifierNode = new MinimumInteractiveModifierNode();
        return minimumInteractiveModifierNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        int i;
        i = other == this ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("minimumInteractiveComponentSize");
        $this$inspectableProperties.getProperties().set("README", "Reserves at least 48.dp in size to disambiguate touch interactions if the element would measure smaller");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.material3.MinimumInteractiveModifierNode node) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((MinimumInteractiveModifierNode)node);
    }
}
