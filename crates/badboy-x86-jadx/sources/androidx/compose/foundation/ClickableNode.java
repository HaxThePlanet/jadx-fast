package androidx.compose.foundation;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0010\u0018\u00002\u00020\u0001BC\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJL\u0010\u0010\u001a\u00020\u000e2\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\u0002\u0008\u0011J\u0012\u0010\u0012\u001a\u00020\u000e*\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/ClickableNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "update", "update-QzZPfjk", "clickPointerInput", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ClickableNode extends androidx.compose.foundation.AbstractClickableNode {

    public static final int $stable;
    static {
    }

    private ClickableNode(MutableInteractionSource interactionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        super(interactionSource, indicationNodeFactory, enabled, onClickLabel, role, onClick, 0);
    }

    public ClickableNode(MutableInteractionSource mutableInteractionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory2, boolean z3, String string4, Role role5, Function0 function06, DefaultConstructorMarker defaultConstructorMarker7) {
        super(mutableInteractionSource, indicationNodeFactory2, z3, string4, role5, function06);
    }

    static Object clickPointerInput$suspendImpl(androidx.compose.foundation.ClickableNode $this, PointerInputScope $receiver, Continuation<? super Unit> $completion) {
        ClickableNode.clickPointerInput.2 anon = new ClickableNode.clickPointerInput.2($this, 0);
        ClickableNode.clickPointerInput.3 anon2 = new ClickableNode.clickPointerInput.3($this);
        Object detectTapAndPress = TapGestureDetectorKt.detectTapAndPress($receiver, (Function3)anon, (Function1)anon2, $completion);
        if (detectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return detectTapAndPress;
        }
        return Unit.INSTANCE;
    }

    public Object clickPointerInput(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation2) {
        return ClickableNode.clickPointerInput$suspendImpl(this, pointerInputScope, continuation2);
    }

    public final void update-QzZPfjk(MutableInteractionSource interactionSource, androidx.compose.foundation.IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        updateCommon-QzZPfjk(interactionSource, indicationNodeFactory, enabled, onClickLabel, role, onClick);
    }
}
