package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0002\u0010\u000eJP\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\u00032\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u000cø\u0001\u0000¢\u0006\u0002\u0008\u0014J\u000c\u0010\u0015\u001a\u00020\r*\u00020\u0016H\u0016R\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/selection/ToggleableNode;", "Landroidx/compose/foundation/ClickableNode;", "value", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_onClick", "Lkotlin/Function0;", "get_onClick", "()Lkotlin/jvm/functions/Function0;", "update", "update-QzZPfjk", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ToggleableNode extends ClickableNode {

    private final Function0<Unit> _onClick;
    private Function1<? super Boolean, Unit> onValueChange;
    private boolean value;
    private ToggleableNode(boolean value, MutableInteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory, boolean enabled, Role role, Function1<? super Boolean, Unit> onValueChange) {
        ToggleableNode.1 anon = new ToggleableNode.1(onValueChange, value);
        final Object obj = this;
        super(interactionSource, indicationNodeFactory, enabled, 0, role, (Function0)anon, 0);
        obj.value = value;
        obj.onValueChange = onValueChange;
        ToggleableNode._onClick.1 obj11 = new ToggleableNode._onClick.1(this);
        obj._onClick = (Function0)obj11;
    }

    public ToggleableNode(boolean z, MutableInteractionSource mutableInteractionSource2, IndicationNodeFactory indicationNodeFactory3, boolean z4, Role role5, Function1 function16, DefaultConstructorMarker defaultConstructorMarker7) {
        super(z, mutableInteractionSource2, indicationNodeFactory3, z4, role5, function16);
    }

    public static final Function1 access$getOnValueChange$p(androidx.compose.foundation.selection.ToggleableNode $this) {
        return $this.onValueChange;
    }

    public static final boolean access$getValue$p(androidx.compose.foundation.selection.ToggleableNode $this) {
        return $this.value;
    }

    @Override // androidx.compose.foundation.ClickableNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver $this$applyAdditionalSemantics) {
        SemanticsPropertiesKt.setToggleableState($this$applyAdditionalSemantics, ToggleableStateKt.ToggleableState(this.value));
    }

    public final Function0<Unit> get_onClick() {
        return this._onClick;
    }

    public final void update-QzZPfjk(boolean value, MutableInteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory, boolean enabled, Role role, Function1<? super Boolean, Unit> onValueChange) {
        boolean value2;
        if (this.value != value) {
            this.value = value;
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
        }
        this.onValueChange = onValueChange;
        super.update-QzZPfjk(interactionSource, indicationNodeFactory, enabled, 0, role, this._onClick);
    }
}
