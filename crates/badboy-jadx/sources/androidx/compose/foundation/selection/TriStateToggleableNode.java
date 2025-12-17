package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJJ\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\u0002\u0008\u0011J\u000c\u0010\u0012\u001a\u00020\u000e*\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/selection/TriStateToggleableNode;", "Landroidx/compose/foundation/ClickableNode;", "state", "Landroidx/compose/ui/state/ToggleableState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "update", "update-QzZPfjk", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TriStateToggleableNode extends ClickableNode {

    private ToggleableState state;
    private TriStateToggleableNode(ToggleableState state, MutableInteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory, boolean enabled, Role role, Function0<Unit> onClick) {
        final Object obj = this;
        super(interactionSource, indicationNodeFactory, enabled, 0, role, onClick, 0);
        obj.state = state;
    }

    public TriStateToggleableNode(ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource2, IndicationNodeFactory indicationNodeFactory3, boolean z4, Role role5, Function0 function06, DefaultConstructorMarker defaultConstructorMarker7) {
        super(toggleableState, mutableInteractionSource2, indicationNodeFactory3, z4, role5, function06);
    }

    @Override // androidx.compose.foundation.ClickableNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver $this$applyAdditionalSemantics) {
        SemanticsPropertiesKt.setToggleableState($this$applyAdditionalSemantics, this.state);
    }

    public final void update-QzZPfjk(ToggleableState state, MutableInteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory, boolean enabled, Role role, Function0<Unit> onClick) {
        Object state2;
        if (this.state != state) {
            this.state = state;
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
        }
        super.update-QzZPfjk(interactionSource, indicationNodeFactory, enabled, 0, role, onClick);
    }
}
