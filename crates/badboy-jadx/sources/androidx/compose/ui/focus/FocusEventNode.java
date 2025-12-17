package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u0007¨\u0006\u000c", d2 = {"Landroidx/compose/ui/focus/FocusEventNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onFocusEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnFocusEvent", "()Lkotlin/jvm/functions/Function1;", "setOnFocusEvent", "focusState", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusEventNode extends Modifier.Node implements androidx.compose.ui.focus.FocusEventModifierNode {

    private Function1<? super androidx.compose.ui.focus.FocusState, Unit> onFocusEvent;
    public FocusEventNode(Function1<? super androidx.compose.ui.focus.FocusState, Unit> onFocusEvent) {
        super();
        this.onFocusEvent = onFocusEvent;
    }

    public final Function1<androidx.compose.ui.focus.FocusState, Unit> getOnFocusEvent() {
        return this.onFocusEvent;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onFocusEvent(androidx.compose.ui.focus.FocusState focusState) {
        this.onFocusEvent.invoke(focusState);
    }

    public final void setOnFocusEvent(Function1<? super androidx.compose.ui.focus.FocusState, Unit> <set-?>) {
        this.onFocusEvent = <set-?>;
    }
}
