package androidx.compose.foundation.selection;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\u0008\u0010\u0011\u001a\u00020\u0002H\u0016J\u0013\u0010\u0012\u001a\u00020\n2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u000c\u0010\u0019\u001a\u00020\u000f*\u00020\u001aH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/selection/TriStateToggleableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/selection/TriStateToggleableNode;", "state", "Landroidx/compose/ui/state/ToggleableState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "(Landroidx/compose/ui/state/ToggleableState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLandroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TriStateToggleableElement extends ModifierNodeElement<androidx.compose.foundation.selection.TriStateToggleableNode> {

    private final boolean enabled;
    private final IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final Role role;
    private final ToggleableState state;
    private TriStateToggleableElement(ToggleableState state, MutableInteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory, boolean enabled, Role role, Function0<Unit> onClick) {
        super();
        this.state = state;
        this.interactionSource = interactionSource;
        this.indicationNodeFactory = indicationNodeFactory;
        this.enabled = enabled;
        this.role = role;
        this.onClick = onClick;
    }

    public TriStateToggleableElement(ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource2, IndicationNodeFactory indicationNodeFactory3, boolean z4, Role role5, Function0 function06, DefaultConstructorMarker defaultConstructorMarker7) {
        super(toggleableState, mutableInteractionSource2, indicationNodeFactory3, z4, role5, function06);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.selection.TriStateToggleableNode create() {
        TriStateToggleableNode triStateToggleableNode = new TriStateToggleableNode(this.state, this.interactionSource, this.indicationNodeFactory, this.enabled, this.role, this.onClick, 0);
        return triStateToggleableNode;
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
        if (other == null) {
            return i2;
        }
        if (getClass() != other.getClass()) {
            return i2;
        }
        Object obj = other;
        if (this.state != obj2.state) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.interactionSource, obj3.interactionSource)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.indicationNodeFactory, obj4.indicationNodeFactory)) {
            return i2;
        }
        if (this.enabled != obj5.enabled) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.role, obj6.role)) {
            return i2;
        }
        if (this.onClick != obj7.onClick) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i2;
        int i;
        Role unbox-impl;
        int i3;
        MutableInteractionSource interactionSource = this.interactionSource;
        i3 = 0;
        if (interactionSource != null) {
            i2 = interactionSource.hashCode();
        } else {
            i2 = i3;
        }
        IndicationNodeFactory indicationNodeFactory = this.indicationNodeFactory;
        if (indicationNodeFactory != null) {
            i = indicationNodeFactory.hashCode();
        } else {
            i = i3;
        }
        unbox-impl = this.role;
        if (unbox-impl != null) {
            i3 = Role.hashCode-impl(unbox-impl.unbox-impl());
        }
        return result4 += i12;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("triStateToggleable");
        $this$inspectableProperties.getProperties().set("state", this.state);
        $this$inspectableProperties.getProperties().set("interactionSource", this.interactionSource);
        $this$inspectableProperties.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
        $this$inspectableProperties.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        $this$inspectableProperties.getProperties().set("role", this.role);
        $this$inspectableProperties.getProperties().set("onClick", this.onClick);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.selection.TriStateToggleableNode node) {
        node.update-QzZPfjk(this.state, this.interactionSource, this.indicationNodeFactory, this.enabled, this.role, this.onClick);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((TriStateToggleableNode)node);
    }
}
