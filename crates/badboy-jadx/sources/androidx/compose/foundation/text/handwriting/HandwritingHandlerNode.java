package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/text/handwriting/HandwritingHandlerNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "getComposeImm", "()Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "composeImm$delegate", "Lkotlin/Lazy;", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onFocusEvent", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class HandwritingHandlerNode extends Modifier.Node implements FocusEventModifierNode {

    private final Lazy composeImm$delegate;
    private FocusState focusState;
    public HandwritingHandlerNode() {
        super();
        HandwritingHandlerNode.composeImm.2 anon = new HandwritingHandlerNode.composeImm.2(this);
        this.composeImm$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)anon);
    }

    public static final ComposeInputMethodManager access$getComposeImm(androidx.compose.foundation.text.handwriting.HandwritingHandlerNode $this) {
        return $this.getComposeImm();
    }

    private final ComposeInputMethodManager getComposeImm() {
        return (ComposeInputMethodManager)this.composeImm$delegate.getValue();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onFocusEvent(FocusState focusState) {
        boolean hasFocus;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i;
        int i4;
        androidx.compose.foundation.text.handwriting.HandwritingHandlerNode.onFocusEvent.1 handler;
        int i3;
        int i2;
        this.focusState = focusState;
        if (!Intrinsics.areEqual(this.focusState, focusState) && focusState.getHasFocus()) {
            this.focusState = focusState;
            if (focusState.getHasFocus()) {
                i = 0;
                hasFocus = new HandwritingHandlerNode.onFocusEvent.1(this, i);
                BuildersKt.launch$default(getCoroutineScope(), i, 0, (Function2)hasFocus, 3, 0);
            }
        }
    }
}
