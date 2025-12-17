package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\u0008\u0010\u0011\u001a\u00020\u0002H\u0016J\u0013\u0010\u0012\u001a\u00020\u00082\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u000c\u0010\u0019\u001a\u00020\u000f*\u00020\u001aH\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/ClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ClickableElement extends ModifierNodeElement<androidx.compose.foundation.ClickableNode> {

    private final boolean enabled;
    private final androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final String onClickLabel;
    private final Role role;
    private ClickableElement(MutableInteractionSource interactionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        super();
        this.interactionSource = interactionSource;
        this.indicationNodeFactory = indicationNodeFactory;
        this.enabled = enabled;
        this.onClickLabel = onClickLabel;
        this.role = role;
        this.onClick = onClick;
    }

    public ClickableElement(MutableInteractionSource mutableInteractionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory2, boolean z3, String string4, Role role5, Function0 function06, DefaultConstructorMarker defaultConstructorMarker7) {
        super(mutableInteractionSource, indicationNodeFactory2, z3, string4, role5, function06);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.ClickableNode create() {
        ClickableNode clickableNode = new ClickableNode(this.interactionSource, this.indicationNodeFactory, this.enabled, this.onClickLabel, this.role, this.onClick, 0);
        return clickableNode;
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
        if (!Intrinsics.areEqual(this.interactionSource, obj2.interactionSource)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.indicationNodeFactory, obj3.indicationNodeFactory)) {
            return i2;
        }
        if (this.enabled != obj4.enabled) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onClickLabel, obj5.onClickLabel)) {
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
        int i3;
        int i;
        int i2;
        int i4;
        MutableInteractionSource interactionSource = this.interactionSource;
        i = 0;
        if (interactionSource != null) {
            i3 = interactionSource.hashCode();
        } else {
            i3 = i;
        }
        androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory = this.indicationNodeFactory;
        if (indicationNodeFactory != null) {
            i2 = indicationNodeFactory.hashCode();
        } else {
            i2 = i;
        }
        String onClickLabel = this.onClickLabel;
        if (onClickLabel != null) {
            i4 = onClickLabel.hashCode();
        } else {
            i4 = i;
        }
        Role role = this.role;
        if (role != null) {
            i = Role.hashCode-impl(role.unbox-impl());
        }
        return i7 += i12;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("clickable");
        $this$inspectableProperties.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        $this$inspectableProperties.getProperties().set("onClick", this.onClick);
        $this$inspectableProperties.getProperties().set("onClickLabel", this.onClickLabel);
        $this$inspectableProperties.getProperties().set("role", this.role);
        $this$inspectableProperties.getProperties().set("interactionSource", this.interactionSource);
        $this$inspectableProperties.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.ClickableNode node) {
        node.update-QzZPfjk(this.interactionSource, this.indicationNodeFactory, this.enabled, this.onClickLabel, this.role, this.onClick);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((ClickableNode)node);
    }
}
