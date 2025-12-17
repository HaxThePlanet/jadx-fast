package androidx.compose.foundation;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002Bm\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Jx\u0010\u0014\u001a\u00020\u00052\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016ø\u0001\u0000¢\u0006\u0002\u0008\u0015J\u000c\u0010\u0016\u001a\u00020\u0005*\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u0005*\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/CombinedClickableNodeImpl;", "Landroidx/compose/foundation/CombinedClickableNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "update", "update-nSzSaCc", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "clickPointerInput", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CombinedClickableNodeImpl extends androidx.compose.foundation.AbstractClickableNode implements androidx.compose.foundation.CombinedClickableNode {

    private Function0<Unit> onDoubleClick;
    private Function0<Unit> onLongClick;
    private String onLongClickLabel;
    private CombinedClickableNodeImpl(Function0<Unit> onClick, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, MutableInteractionSource interactionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role) {
        super(interactionSource, indicationNodeFactory, enabled, onClickLabel, role, onClick, 0);
        this.onLongClickLabel = onLongClickLabel;
        this.onLongClick = onLongClick;
        this.onDoubleClick = onDoubleClick;
    }

    public CombinedClickableNodeImpl(Function0 function0, String string2, Function0 function03, Function0 function04, MutableInteractionSource mutableInteractionSource5, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory6, boolean z7, String string8, Role role9, DefaultConstructorMarker defaultConstructorMarker10) {
        super(function0, string2, function03, function04, mutableInteractionSource5, indicationNodeFactory6, z7, string8, role9);
    }

    public static final Function0 access$getOnDoubleClick$p(androidx.compose.foundation.CombinedClickableNodeImpl $this) {
        return $this.onDoubleClick;
    }

    public static final Function0 access$getOnLongClick$p(androidx.compose.foundation.CombinedClickableNodeImpl $this) {
        return $this.onLongClick;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver $this$applyAdditionalSemantics) {
        Object onLongClickLabel;
        androidx.compose.foundation.CombinedClickableNodeImpl.applyAdditionalSemantics.1 anon;
        if (this.onLongClick != null) {
            anon = new CombinedClickableNodeImpl.applyAdditionalSemantics.1(this);
            SemanticsPropertiesKt.onLongClick($this$applyAdditionalSemantics, this.onLongClickLabel, (Function0)anon);
        }
    }

    public Object clickPointerInput(PointerInputScope $this$clickPointerInput, Continuation<? super Unit> $completion) {
        boolean onDoubleClick;
        boolean onLongClick;
        int i;
        int i2;
        final int i3 = 0;
        if (getEnabled() && this.onDoubleClick != null) {
            if (this.onDoubleClick != null) {
                onDoubleClick = new CombinedClickableNodeImpl.clickPointerInput.2(this);
                i = onDoubleClick;
            } else {
                i = i3;
            }
        } else {
        }
        if (getEnabled() && this.onLongClick != null) {
            if (this.onLongClick != null) {
                onLongClick = new CombinedClickableNodeImpl.clickPointerInput.3(this);
                i2 = onLongClick;
            } else {
                i2 = i3;
            }
        } else {
        }
        CombinedClickableNodeImpl.clickPointerInput.4 anon = new CombinedClickableNodeImpl.clickPointerInput.4(this, i3);
        CombinedClickableNodeImpl.clickPointerInput.5 anon2 = new CombinedClickableNodeImpl.clickPointerInput.5(this);
        Object obj9 = TapGestureDetectorKt.detectTapGestures($this$clickPointerInput, i, i2, (Function3)anon, (Function1)anon2, $completion);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    public void update-nSzSaCc(Function0<Unit> onClick, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, MutableInteractionSource interactionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role) {
        int resetPointerInputHandling;
        boolean equal;
        int i2;
        int i3;
        int i4;
        int i;
        resetPointerInputHandling = 0;
        if (!Intrinsics.areEqual(this.onLongClickLabel, onLongClickLabel)) {
            this.onLongClickLabel = onLongClickLabel;
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
        }
        i4 = 1;
        int i5 = 0;
        i2 = this.onLongClick == null ? i4 : i5;
        i = onLongClick == null ? i4 : i5;
        if (i2 != i) {
            disposeInteractions();
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
            resetPointerInputHandling = 1;
        }
        this.onLongClick = onLongClick;
        i3 = this.onDoubleClick == null ? i4 : i5;
        if (onDoubleClick == null) {
        } else {
            i4 = i5;
        }
        if (i3 != i4) {
            resetPointerInputHandling = 1;
        }
        this.onDoubleClick = onDoubleClick;
        if (getEnabled() != enabled) {
            resetPointerInputHandling = 1;
        }
        this.updateCommon-QzZPfjk(interactionSource, indicationNodeFactory, enabled, onClickLabel, role, onClick);
        if (resetPointerInputHandling != 0) {
            resetPointerInputHandler();
        }
    }
}
