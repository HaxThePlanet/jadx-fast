package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000c\u0010\u001b\u001a\u00020\u0016*\u00020\u001cH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/FocusableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "focusState", "Landroidx/compose/ui/focus/FocusState;", "focusableInteractionNode", "Landroidx/compose/foundation/FocusableInteractionNode;", "focusablePinnableContainer", "Landroidx/compose/foundation/FocusablePinnableContainerNode;", "focusedBoundsNode", "Landroidx/compose/foundation/FocusedBoundsNode;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "onFocusEvent", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "update", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusableNode extends DelegatingNode implements FocusEventModifierNode, SemanticsModifierNode, GlobalPositionAwareModifierNode, FocusRequesterModifierNode {

    public static final int $stable = 8;
    private FocusState focusState;
    private final androidx.compose.foundation.FocusableInteractionNode focusableInteractionNode;
    private final androidx.compose.foundation.FocusablePinnableContainerNode focusablePinnableContainer;
    private final androidx.compose.foundation.FocusedBoundsNode focusedBoundsNode;
    private final boolean shouldAutoInvalidate;
    static {
        final int i = 8;
    }

    public FocusableNode(MutableInteractionSource interactionSource) {
        super();
        FocusableInteractionNode focusableInteractionNode = new FocusableInteractionNode(interactionSource);
        this.focusableInteractionNode = (FocusableInteractionNode)delegate((DelegatableNode)focusableInteractionNode);
        FocusablePinnableContainerNode focusablePinnableContainerNode = new FocusablePinnableContainerNode();
        this.focusablePinnableContainer = (FocusablePinnableContainerNode)delegate((DelegatableNode)focusablePinnableContainerNode);
        FocusedBoundsNode focusedBoundsNode = new FocusedBoundsNode();
        this.focusedBoundsNode = (FocusedBoundsNode)delegate((DelegatableNode)focusedBoundsNode);
        delegate((DelegatableNode)FocusTargetModifierNodeKt.FocusTargetModifierNode());
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        FocusState focusState;
        int i;
        focusState = this.focusState;
        i = 0;
        final int i3 = 1;
        if (focusState != null && focusState.isFocused() == i3) {
            if (focusState.isFocused() == i3) {
                i = i3;
            }
        }
        SemanticsPropertiesKt.setFocused($this$applySemantics, i);
        FocusableNode.applySemantics.1 anon = new FocusableNode.applySemantics.1(this);
        int i2 = 0;
        SemanticsPropertiesKt.requestFocus$default($this$applySemantics, i2, (Function0)anon, i3, i2);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onFocusEvent(FocusState focusState) {
        boolean focused;
        kotlinx.coroutines.CoroutineScope focusablePinnableContainer;
        boolean attached;
        int i4;
        int i3;
        androidx.compose.foundation.FocusableNode.onFocusEvent.1 anon;
        int i2;
        int i;
        focused = focusState.isFocused();
        if (!Intrinsics.areEqual(this.focusState, focusState) && focused) {
            focused = focusState.isFocused();
            if (focused) {
                i3 = 0;
                FocusableNode.onFocusEvent.1 anon2 = new FocusableNode.onFocusEvent.1(this, i3);
                BuildersKt.launch$default(getCoroutineScope(), 0, i3, (Function2)anon2, 3, 0);
            }
            if (isAttached()) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
            }
            this.focusableInteractionNode.setFocus(focused);
            this.focusedBoundsNode.setFocus(focused);
            this.focusablePinnableContainer.setFocus(focused);
            this.focusState = focusState;
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.focusedBoundsNode.onGloballyPositioned(coordinates);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void update(MutableInteractionSource interactionSource) {
        this.focusableInteractionNode.update(interactionSource);
    }
}
