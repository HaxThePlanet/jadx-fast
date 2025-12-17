package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0008\u0010\"\u001a\u00020\u0002H\u0016J\u0013\u0010#\u001a\u00020\n2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\u0008\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0002H\u0016J\u000c\u0010+\u001a\u00020)*\u00020,H\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0013\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!¨\u0006-", d2 = {"Landroidx/compose/foundation/gestures/ScrollableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/ScrollableNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "enabled", "", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "getBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getEnabled", "()Z", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getReverseDirection", "getState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "create", "equals", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ScrollableElement extends ModifierNodeElement<androidx.compose.foundation.gestures.ScrollableNode> {

    private final androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec;
    private final boolean enabled;
    private final androidx.compose.foundation.gestures.FlingBehavior flingBehavior;
    private final MutableInteractionSource interactionSource;
    private final androidx.compose.foundation.gestures.Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final androidx.compose.foundation.gestures.ScrollableState state;
    public ScrollableElement(androidx.compose.foundation.gestures.ScrollableState state, androidx.compose.foundation.gestures.Orientation orientation, OverscrollEffect overscrollEffect, boolean enabled, boolean reverseDirection, androidx.compose.foundation.gestures.FlingBehavior flingBehavior, MutableInteractionSource interactionSource, androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec) {
        super();
        this.state = state;
        this.orientation = orientation;
        this.overscrollEffect = overscrollEffect;
        this.enabled = enabled;
        this.reverseDirection = reverseDirection;
        this.flingBehavior = flingBehavior;
        this.interactionSource = interactionSource;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.gestures.ScrollableNode create() {
        ScrollableNode scrollableNode = new ScrollableNode(this.state, this.overscrollEffect, this.flingBehavior, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.bringIntoViewSpec);
        return scrollableNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof ScrollableElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.state, obj.state)) {
            return i2;
        }
        if (this.orientation != obj2.orientation) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.overscrollEffect, obj3.overscrollEffect)) {
            return i2;
        }
        if (this.enabled != obj4.enabled) {
            return i2;
        }
        if (this.reverseDirection != obj5.reverseDirection) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.flingBehavior, obj6.flingBehavior)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.interactionSource, obj7.interactionSource)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.bringIntoViewSpec, obj8.bringIntoViewSpec)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.gestures.BringIntoViewSpec getBringIntoViewSpec() {
        return this.bringIntoViewSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getEnabled() {
        return this.enabled;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.gestures.FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.gestures.Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.gestures.ScrollableState getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i4;
        int i;
        int i2;
        int i3;
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        i3 = 0;
        if (overscrollEffect != null) {
            i4 = overscrollEffect.hashCode();
        } else {
            i4 = i3;
        }
        androidx.compose.foundation.gestures.FlingBehavior flingBehavior = this.flingBehavior;
        if (flingBehavior != null) {
            i = flingBehavior.hashCode();
        } else {
            i = i3;
        }
        MutableInteractionSource interactionSource = this.interactionSource;
        if (interactionSource != null) {
            i2 = interactionSource.hashCode();
        } else {
            i2 = i3;
        }
        androidx.compose.foundation.gestures.BringIntoViewSpec bringIntoViewSpec = this.bringIntoViewSpec;
        if (bringIntoViewSpec != null) {
            i3 = bringIntoViewSpec.hashCode();
        }
        return result6 += i3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("scrollable");
        $this$inspectableProperties.getProperties().set("orientation", this.orientation);
        $this$inspectableProperties.getProperties().set("state", this.state);
        $this$inspectableProperties.getProperties().set("overscrollEffect", this.overscrollEffect);
        $this$inspectableProperties.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        $this$inspectableProperties.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        $this$inspectableProperties.getProperties().set("flingBehavior", this.flingBehavior);
        $this$inspectableProperties.getProperties().set("interactionSource", this.interactionSource);
        $this$inspectableProperties.getProperties().set("bringIntoViewSpec", this.bringIntoViewSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.gestures.ScrollableNode node) {
        node.update(this.state, this.orientation, this.overscrollEffect, this.enabled, this.reverseDirection, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((ScrollableNode)node);
    }
}
