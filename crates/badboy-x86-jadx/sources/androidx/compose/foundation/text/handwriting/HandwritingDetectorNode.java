package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0014\u001a\u00020\u0005H\u0016J*\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dR \u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\u0006R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/text/handwriting/HandwritingDetectorNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "callback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "getComposeImm", "()Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "composeImm$delegate", "Lkotlin/Lazy;", "pointerInputNode", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "getPointerInputNode", "()Landroidx/compose/foundation/text/handwriting/StylusHandwritingNodeWithNegativePadding;", "onCancelPointerInput", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class HandwritingDetectorNode extends DelegatingNode implements PointerInputModifierNode {

    private Function0<Unit> callback;
    private final Lazy composeImm$delegate;
    private final androidx.compose.foundation.text.handwriting.StylusHandwritingNodeWithNegativePadding pointerInputNode;
    public HandwritingDetectorNode(Function0<Unit> callback) {
        super();
        this.callback = callback;
        HandwritingDetectorNode.composeImm.2 anon = new HandwritingDetectorNode.composeImm.2(this);
        this.composeImm$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)anon);
        HandwritingDetectorNode.pointerInputNode.1 anon2 = new HandwritingDetectorNode.pointerInputNode.1(this);
        StylusHandwritingNodeWithNegativePadding stylusHandwritingNodeWithNegativePadding = new StylusHandwritingNodeWithNegativePadding((Function0)anon2);
        this.pointerInputNode = (StylusHandwritingNodeWithNegativePadding)delegate((DelegatableNode)stylusHandwritingNodeWithNegativePadding);
    }

    public static final ComposeInputMethodManager access$getComposeImm(androidx.compose.foundation.text.handwriting.HandwritingDetectorNode $this) {
        return $this.getComposeImm();
    }

    private final ComposeInputMethodManager getComposeImm() {
        return (ComposeInputMethodManager)this.composeImm$delegate.getValue();
    }

    public final Function0<Unit> getCallback() {
        return this.callback;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final androidx.compose.foundation.text.handwriting.StylusHandwritingNodeWithNegativePadding getPointerInputNode() {
        return this.pointerInputNode;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onPointerEvent-H0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.pointerInputNode.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
    }

    public final void setCallback(Function0<Unit> <set-?>) {
        this.callback = <set-?>;
    }
}
