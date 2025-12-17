package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00062\u0008\u0008\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0008\u0010\u0018\u001a\u00020\u0002H\u0016J\u0013\u0010\u0019\u001a\u00020\u00062\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016J\u000c\u0010#\u001a\u00020!*\u00020$H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006%", d2 = {"Landroidx/compose/foundation/ScrollSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollSemanticsModifierNode;", "state", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "isScrollable", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZZ)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "()Z", "getReverseScrolling", "getState", "()Landroidx/compose/foundation/ScrollState;", "component1", "component2", "component3", "component4", "component5", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ScrollSemanticsElement extends ModifierNodeElement<androidx.compose.foundation.ScrollSemanticsModifierNode> {

    private final FlingBehavior flingBehavior;
    private final boolean isScrollable;
    private final boolean isVertical;
    private final boolean reverseScrolling;
    private final androidx.compose.foundation.ScrollState state;
    public ScrollSemanticsElement(androidx.compose.foundation.ScrollState state, boolean reverseScrolling, FlingBehavior flingBehavior, boolean isScrollable, boolean isVertical) {
        super();
        this.state = state;
        this.reverseScrolling = reverseScrolling;
        this.flingBehavior = flingBehavior;
        this.isScrollable = isScrollable;
        this.isVertical = isVertical;
    }

    public static androidx.compose.foundation.ScrollSemanticsElement copy$default(androidx.compose.foundation.ScrollSemanticsElement scrollSemanticsElement, androidx.compose.foundation.ScrollState scrollState2, boolean z3, FlingBehavior flingBehavior4, boolean z5, boolean z6, int i7, Object object8) {
        androidx.compose.foundation.ScrollState obj1;
        boolean obj2;
        FlingBehavior obj3;
        boolean obj4;
        boolean obj5;
        if (i7 & 1 != 0) {
            obj1 = scrollSemanticsElement.state;
        }
        if (i7 & 2 != 0) {
            obj2 = scrollSemanticsElement.reverseScrolling;
        }
        if (i7 & 4 != 0) {
            obj3 = scrollSemanticsElement.flingBehavior;
        }
        if (i7 & 8 != 0) {
            obj4 = scrollSemanticsElement.isScrollable;
        }
        if (i7 &= 16 != 0) {
            obj5 = scrollSemanticsElement.isVertical;
        }
        return scrollSemanticsElement.copy(obj1, obj2, obj3, obj4, obj5);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.ScrollState component1() {
        return this.state;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component2() {
        return this.reverseScrolling;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final FlingBehavior component3() {
        return this.flingBehavior;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component4() {
        return this.isScrollable;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component5() {
        return this.isVertical;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.ScrollSemanticsElement copy(androidx.compose.foundation.ScrollState scrollState, boolean z2, FlingBehavior flingBehavior3, boolean z4, boolean z5) {
        ScrollSemanticsElement scrollSemanticsElement = new ScrollSemanticsElement(scrollState, z2, flingBehavior3, z4, z5);
        return scrollSemanticsElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.ScrollSemanticsModifierNode create() {
        ScrollSemanticsModifierNode scrollSemanticsModifierNode = new ScrollSemanticsModifierNode(this.state, this.reverseScrolling, this.flingBehavior, this.isScrollable, this.isVertical);
        return scrollSemanticsModifierNode;
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
        if (!object instanceof ScrollSemanticsElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.state, obj.state)) {
            return i2;
        }
        if (this.reverseScrolling != obj.reverseScrolling) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.flingBehavior, obj.flingBehavior)) {
            return i2;
        }
        if (this.isScrollable != obj.isScrollable) {
            return i2;
        }
        if (this.isVertical != obj.isVertical) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.ScrollState getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        if (this.flingBehavior == null) {
            i = 0;
        } else {
            i = this.flingBehavior.hashCode();
        }
        return i5 += i13;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean isScrollable() {
        return this.isScrollable;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ScrollSemanticsElement(state=").append(this.state).append(", reverseScrolling=").append(this.reverseScrolling).append(", flingBehavior=").append(this.flingBehavior).append(", isScrollable=").append(this.isScrollable).append(", isVertical=").append(this.isVertical).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.ScrollSemanticsModifierNode node) {
        node.setState(this.state);
        node.setReverseScrolling(this.reverseScrolling);
        node.setFlingBehavior(this.flingBehavior);
        node.setScrollable(this.isScrollable);
        node.setVertical(this.isVertical);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((ScrollSemanticsModifierNode)node);
    }
}
