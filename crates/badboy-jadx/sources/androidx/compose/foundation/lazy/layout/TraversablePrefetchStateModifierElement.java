package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0083\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0008\u0010\u0008\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u000c\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/TraversablePrefetchStateNode;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;)V", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TraversablePrefetchStateModifierElement extends ModifierNodeElement<androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode> {

    private final androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState prefetchState;
    public TraversablePrefetchStateModifierElement(androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState prefetchState) {
        super();
        this.prefetchState = prefetchState;
    }

    private final androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState component1() {
        return this.prefetchState;
    }

    public static androidx.compose.foundation.lazy.layout.TraversablePrefetchStateModifierElement copy$default(androidx.compose.foundation.lazy.layout.TraversablePrefetchStateModifierElement traversablePrefetchStateModifierElement, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState lazyLayoutPrefetchState2, int i3, Object object4) {
        androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState obj1;
        if (i3 &= 1 != 0) {
            obj1 = traversablePrefetchStateModifierElement.prefetchState;
        }
        return traversablePrefetchStateModifierElement.copy(obj1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.lazy.layout.TraversablePrefetchStateModifierElement copy(androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState lazyLayoutPrefetchState) {
        TraversablePrefetchStateModifierElement traversablePrefetchStateModifierElement = new TraversablePrefetchStateModifierElement(lazyLayoutPrefetchState);
        return traversablePrefetchStateModifierElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode create() {
        TraversablePrefetchStateNode traversablePrefetchStateNode = new TraversablePrefetchStateNode(this.prefetchState);
        return traversablePrefetchStateNode;
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
        if (!object instanceof TraversablePrefetchStateModifierElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.prefetchState, obj.prefetchState)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.prefetchState.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("traversablePrefetchState");
        $this$inspectableProperties.setValue(this.prefetchState);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TraversablePrefetchStateModifierElement(prefetchState=").append(this.prefetchState).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode node) {
        node.setPrefetchState(this.prefetchState);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((TraversablePrefetchStateNode)node);
    }
}
