package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u0008\u0010\u0017\u001a\u00020\u0002H\u0016J\u0013\u0010\u0018\u001a\u00020\u000b2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\u000c\u0010 \u001a\u00020\u001e*\u00020!H\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u000c\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0013¨\u0006\"", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifierNode;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZ)V", "getItemProviderLambda", "()Lkotlin/jvm/functions/Function0;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getReverseScrolling", "()Z", "getState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "getUserScrollEnabled", "create", "equals", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LazyLayoutSemanticsModifier extends ModifierNodeElement<androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode> {

    private final Function0<androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> itemProviderLambda;
    private final Orientation orientation;
    private final boolean reverseScrolling;
    private final androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState state;
    private final boolean userScrollEnabled;
    public LazyLayoutSemanticsModifier(Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> itemProviderLambda, androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState state, Orientation orientation, boolean userScrollEnabled, boolean reverseScrolling) {
        super();
        this.itemProviderLambda = itemProviderLambda;
        this.state = state;
        this.orientation = orientation;
        this.userScrollEnabled = userScrollEnabled;
        this.reverseScrolling = reverseScrolling;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode create() {
        LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode = new LazyLayoutSemanticsModifierNode(this.itemProviderLambda, this.state, this.orientation, this.userScrollEnabled, this.reverseScrolling);
        return lazyLayoutSemanticsModifierNode;
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
        if (!other instanceof LazyLayoutSemanticsModifier) {
            return i2;
        }
        if (this.itemProviderLambda != obj.itemProviderLambda) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.state, obj2.state)) {
            return i2;
        }
        if (this.orientation != obj3.orientation) {
            return i2;
        }
        if (this.userScrollEnabled != obj4.userScrollEnabled) {
            return i2;
        }
        if (this.reverseScrolling != obj5.reverseScrolling) {
            return i2;
        }
        return i;
    }

    public final Function0<androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> getItemProviderLambda() {
        return this.itemProviderLambda;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getUserScrollEnabled() {
        return this.userScrollEnabled;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return result2 += i10;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode node) {
        node.update(this.itemProviderLambda, this.state, this.orientation, this.userScrollEnabled, this.reverseScrolling);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((LazyLayoutSemanticsModifierNode)node);
    }
}
