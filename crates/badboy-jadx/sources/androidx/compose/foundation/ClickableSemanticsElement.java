package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0008\u0012\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00042\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u000c\u0010\u0017\u001a\u00020\u000b*\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/ClickableSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ClickableSemanticsNode;", "enabled", "", "role", "Landroidx/compose/ui/semantics/Role;", "onLongClickLabel", "", "onLongClick", "Lkotlin/Function0;", "", "onClickLabel", "onClick", "(ZLandroidx/compose/ui/semantics/Role;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ClickableSemanticsElement extends ModifierNodeElement<androidx.compose.foundation.ClickableSemanticsNode> {

    private final boolean enabled;
    private final Function0<Unit> onClick;
    private final String onClickLabel;
    private final Function0<Unit> onLongClick;
    private final String onLongClickLabel;
    private final Role role;
    private ClickableSemanticsElement(boolean enabled, Role role, String onLongClickLabel, Function0<Unit> onLongClick, String onClickLabel, Function0<Unit> onClick) {
        super();
        this.enabled = enabled;
        this.role = role;
        this.onLongClickLabel = onLongClickLabel;
        this.onLongClick = onLongClick;
        this.onClickLabel = onClickLabel;
        this.onClick = onClick;
    }

    public ClickableSemanticsElement(boolean z, Role role2, String string3, Function0 function04, String string5, Function0 function06, DefaultConstructorMarker defaultConstructorMarker7) {
        super(z, role2, string3, function04, string5, function06);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.ClickableSemanticsNode create() {
        ClickableSemanticsNode clickableSemanticsNode = new ClickableSemanticsNode(this.enabled, this.onClickLabel, this.role, this.onClick, this.onLongClickLabel, this.onLongClick, 0);
        return clickableSemanticsNode;
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
        if (!other instanceof ClickableSemanticsElement) {
            return i2;
        }
        if (this.enabled != obj.enabled) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.role, obj2.role)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onLongClickLabel, obj3.onLongClickLabel)) {
            return i2;
        }
        if (this.onLongClick != obj4.onLongClick) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onClickLabel, obj5.onClickLabel)) {
            return i2;
        }
        if (this.onClick != obj6.onClick) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i2;
        int i3;
        int i;
        int i4;
        Role role = this.role;
        i4 = 0;
        if (role != null) {
            i2 = role.hashCode();
        } else {
            i2 = i4;
        }
        String onLongClickLabel = this.onLongClickLabel;
        if (onLongClickLabel != null) {
            i3 = onLongClickLabel.hashCode();
        } else {
            i3 = i4;
        }
        Function0 onLongClick = this.onLongClick;
        if (onLongClick != null) {
            i = onLongClick.hashCode();
        } else {
            i = i4;
        }
        String onClickLabel = this.onClickLabel;
        if (onClickLabel != null) {
            i4 = onClickLabel.hashCode();
        }
        return result4 += i12;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.ClickableSemanticsNode node) {
        node.update-UMe6uN4(this.enabled, this.onClickLabel, this.role, this.onClick, this.onLongClickLabel, this.onLongClick);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((ClickableSemanticsNode)node);
    }
}
