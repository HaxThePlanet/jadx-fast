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
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001Bm\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0008\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0013J\u0008\u0010\u0014\u001a\u00020\u0002H\u0016J\u0013\u0010\u0015\u001a\u00020\u00082\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u000c\u0010\u001c\u001a\u00020\u000f*\u00020\u001dH\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/CombinedClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/CombinedClickableNodeImpl;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "onLongClick", "onDoubleClick", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CombinedClickableElement extends ModifierNodeElement<androidx.compose.foundation.CombinedClickableNodeImpl> {

    private final boolean enabled;
    private final androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final String onClickLabel;
    private final Function0<Unit> onDoubleClick;
    private final Function0<Unit> onLongClick;
    private final String onLongClickLabel;
    private final Role role;
    private CombinedClickableElement(MutableInteractionSource interactionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick) {
        super();
        this.interactionSource = interactionSource;
        this.indicationNodeFactory = indicationNodeFactory;
        this.enabled = enabled;
        this.onClickLabel = onClickLabel;
        this.role = role;
        this.onClick = onClick;
        this.onLongClickLabel = onLongClickLabel;
        this.onLongClick = onLongClick;
        this.onDoubleClick = onDoubleClick;
    }

    public CombinedClickableElement(MutableInteractionSource mutableInteractionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory2, boolean z3, String string4, Role role5, Function0 function06, String string7, Function0 function08, Function0 function09, DefaultConstructorMarker defaultConstructorMarker10) {
        super(mutableInteractionSource, indicationNodeFactory2, z3, string4, role5, function06, string7, function08, function09);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.CombinedClickableNodeImpl create() {
        CombinedClickableNodeImpl combinedClickableNodeImpl = new CombinedClickableNodeImpl(this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick, this.interactionSource, this.indicationNodeFactory, this.enabled, this.onClickLabel, this.role, 0);
        return combinedClickableNodeImpl;
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
        if (!Intrinsics.areEqual(this.onLongClickLabel, obj8.onLongClickLabel)) {
            return i2;
        }
        if (this.onLongClick != obj9.onLongClick) {
            return i2;
        }
        if (this.onDoubleClick != obj10.onDoubleClick) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i6;
        int i4;
        int i3;
        int i7;
        int i;
        int i5;
        int i2;
        MutableInteractionSource interactionSource = this.interactionSource;
        i4 = 0;
        if (interactionSource != null) {
            i6 = interactionSource.hashCode();
        } else {
            i6 = i4;
        }
        androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory = this.indicationNodeFactory;
        if (indicationNodeFactory != null) {
            i3 = indicationNodeFactory.hashCode();
        } else {
            i3 = i4;
        }
        String onClickLabel = this.onClickLabel;
        if (onClickLabel != null) {
            i7 = onClickLabel.hashCode();
        } else {
            i7 = i4;
        }
        Role role = this.role;
        if (role != null) {
            i = Role.hashCode-impl(role.unbox-impl());
        } else {
            i = i4;
        }
        String onLongClickLabel = this.onLongClickLabel;
        if (onLongClickLabel != null) {
            i5 = onLongClickLabel.hashCode();
        } else {
            i5 = i4;
        }
        Function0 onLongClick = this.onLongClick;
        if (onLongClick != null) {
            i2 = onLongClick.hashCode();
        } else {
            i2 = i4;
        }
        Function0 onDoubleClick = this.onDoubleClick;
        if (onDoubleClick != null) {
            i4 = onDoubleClick.hashCode();
        }
        return result4 += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("combinedClickable");
        $this$inspectableProperties.getProperties().set("indicationNodeFactory", this.indicationNodeFactory);
        $this$inspectableProperties.getProperties().set("interactionSource", this.interactionSource);
        $this$inspectableProperties.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        $this$inspectableProperties.getProperties().set("onClickLabel", this.onClickLabel);
        $this$inspectableProperties.getProperties().set("role", this.role);
        $this$inspectableProperties.getProperties().set("onClick", this.onClick);
        $this$inspectableProperties.getProperties().set("onDoubleClick", this.onDoubleClick);
        $this$inspectableProperties.getProperties().set("onLongClick", this.onLongClick);
        $this$inspectableProperties.getProperties().set("onLongClickLabel", this.onLongClickLabel);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.CombinedClickableNodeImpl node) {
        node.update-nSzSaCc(this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick, this.interactionSource, this.indicationNodeFactory, this.enabled, this.onClickLabel, this.role);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((CombinedClickableNodeImpl)node);
    }
}
