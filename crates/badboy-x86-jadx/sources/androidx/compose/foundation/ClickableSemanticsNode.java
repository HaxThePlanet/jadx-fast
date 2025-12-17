package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\u000eJR\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u00062\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nø\u0001\u0000¢\u0006\u0002\u0008\u0013J\u000c\u0010\u0014\u001a\u00020\u000b*\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/ClickableSemanticsNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "onLongClick", "(ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "()Z", "update", "update-UMe6uN4", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ClickableSemanticsNode extends Modifier.Node implements SemanticsModifierNode {

    private boolean enabled;
    private Function0<Unit> onClick;
    private String onClickLabel;
    private Function0<Unit> onLongClick;
    private String onLongClickLabel;
    private Role role;
    private ClickableSemanticsNode(boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick, String onLongClickLabel, Function0<Unit> onLongClick) {
        super();
        this.enabled = enabled;
        this.onClickLabel = onClickLabel;
        this.role = role;
        this.onClick = onClick;
        this.onLongClickLabel = onLongClickLabel;
        this.onLongClick = onLongClick;
    }

    public ClickableSemanticsNode(boolean z, String string2, Role role3, Function0 function04, String string5, Function0 function06, DefaultConstructorMarker defaultConstructorMarker7) {
        super(z, string2, role3, function04, string5, function06);
    }

    public static final Function0 access$getOnClick$p(androidx.compose.foundation.ClickableSemanticsNode $this) {
        return $this.onClick;
    }

    public static final Function0 access$getOnLongClick$p(androidx.compose.foundation.ClickableSemanticsNode $this) {
        return $this.onLongClick;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        Role unbox-impl;
        Object onLongClickLabel;
        kotlin.jvm.internal.Lambda anon;
        if (this.role != null) {
            Role role = this.role;
            Intrinsics.checkNotNull(role);
            SemanticsPropertiesKt.setRole-kuIjeqM($this$applySemantics, role.unbox-impl());
        }
        anon = new ClickableSemanticsNode.applySemantics.1(this);
        SemanticsPropertiesKt.onClick($this$applySemantics, this.onClickLabel, (Function0)anon);
        if (this.onLongClick != null) {
            anon = new ClickableSemanticsNode.applySemantics.2(this);
            SemanticsPropertiesKt.onLongClick($this$applySemantics, this.onLongClickLabel, (Function0)anon);
        }
        if (!this.enabled) {
            SemanticsPropertiesKt.disabled($this$applySemantics);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldMergeDescendantSemantics() {
        return 1;
    }

    public final void update-UMe6uN4(boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick, String onLongClickLabel, Function0<Unit> onLongClick) {
        this.enabled = enabled;
        this.onClickLabel = onClickLabel;
        this.role = role;
        this.onClick = onClick;
        this.onLongClickLabel = onLongClickLabel;
        this.onLongClick = onLongClick;
    }
}
