package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\u000c\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u0010\"\u0004\u0008\u0013\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0010\"\u0004\u0008\u0015\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/ScrollSemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "state", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "isScrollable", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZZ)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "setFlingBehavior", "(Landroidx/compose/foundation/gestures/FlingBehavior;)V", "()Z", "setScrollable", "(Z)V", "setVertical", "getReverseScrolling", "setReverseScrolling", "getState", "()Landroidx/compose/foundation/ScrollState;", "setState", "(Landroidx/compose/foundation/ScrollState;)V", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ScrollSemanticsModifierNode extends Modifier.Node implements SemanticsModifierNode {

    private FlingBehavior flingBehavior;
    private boolean isScrollable;
    private boolean isVertical;
    private boolean reverseScrolling;
    private androidx.compose.foundation.ScrollState state;
    public ScrollSemanticsModifierNode(androidx.compose.foundation.ScrollState state, boolean reverseScrolling, FlingBehavior flingBehavior, boolean isScrollable, boolean isVertical) {
        super();
        this.state = state;
        this.reverseScrolling = reverseScrolling;
        this.flingBehavior = flingBehavior;
        this.isScrollable = isScrollable;
        this.isVertical = isVertical;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        SemanticsPropertiesKt.setTraversalGroup($this$applySemantics, true);
        ScrollSemanticsModifierNode.applySemantics.accessibilityScrollState.1 anon = new ScrollSemanticsModifierNode.applySemantics.accessibilityScrollState.1(this);
        ScrollSemanticsModifierNode.applySemantics.accessibilityScrollState.2 anon2 = new ScrollSemanticsModifierNode.applySemantics.accessibilityScrollState.2(this);
        ScrollAxisRange scrollAxisRange = new ScrollAxisRange((Function0)anon, (Function0)anon2, this.reverseScrolling);
        if (this.isVertical) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange($this$applySemantics, scrollAxisRange);
        } else {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange($this$applySemantics, scrollAxisRange);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.foundation.ScrollState getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean isScrollable() {
        return this.isScrollable;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFlingBehavior(FlingBehavior <set-?>) {
        this.flingBehavior = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setReverseScrolling(boolean <set-?>) {
        this.reverseScrolling = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setScrollable(boolean <set-?>) {
        this.isScrollable = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setState(androidx.compose.foundation.ScrollState <set-?>) {
        this.state = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setVertical(boolean <set-?>) {
        this.isVertical = <set-?>;
    }
}
