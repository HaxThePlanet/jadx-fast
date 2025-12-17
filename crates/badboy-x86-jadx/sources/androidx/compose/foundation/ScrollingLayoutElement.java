package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000c\u001a\u00020\u0002H\u0016J\u0013\u0010\r\u001a\u00020\u00062\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u000c\u0010\u0015\u001a\u00020\u0013*\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\tR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/ScrollingLayoutElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollingLayoutNode;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "isReversed", "", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "()Z", "getScrollState", "()Landroidx/compose/foundation/ScrollState;", "create", "equals", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScrollingLayoutElement extends ModifierNodeElement<androidx.compose.foundation.ScrollingLayoutNode> {

    public static final int $stable;
    private final boolean isReversed;
    private final boolean isVertical;
    private final androidx.compose.foundation.ScrollState scrollState;
    static {
    }

    public ScrollingLayoutElement(androidx.compose.foundation.ScrollState scrollState, boolean isReversed, boolean isVertical) {
        super();
        this.scrollState = scrollState;
        this.isReversed = isReversed;
        this.isVertical = isVertical;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.ScrollingLayoutNode create() {
        ScrollingLayoutNode scrollingLayoutNode = new ScrollingLayoutNode(this.scrollState, this.isReversed, this.isVertical);
        return scrollingLayoutNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        boolean isReversed;
        int i;
        boolean scrollState;
        if (!other instanceof ScrollingLayoutElement) {
            return 0;
        }
        if (Intrinsics.areEqual(this.scrollState, obj.scrollState) && this.isReversed == obj2.isReversed && this.isVertical == obj3.isVertical) {
            if (this.isReversed == obj2.isReversed) {
                if (this.isVertical == obj3.isVertical) {
                    i = 1;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.ScrollState getScrollState() {
        return this.scrollState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return result += i6;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("layoutInScroll");
        $this$inspectableProperties.getProperties().set("state", this.scrollState);
        $this$inspectableProperties.getProperties().set("isReversed", Boolean.valueOf(this.isReversed));
        $this$inspectableProperties.getProperties().set("isVertical", Boolean.valueOf(this.isVertical));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean isReversed() {
        return this.isReversed;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.ScrollingLayoutNode node) {
        node.setScrollerState(this.scrollState);
        node.setReversed(this.isReversed);
        node.setVertical(this.isVertical);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((ScrollingLayoutNode)node);
    }
}
