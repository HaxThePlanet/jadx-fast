package androidx.compose.ui.input.rotary;

import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000c\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0008J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\n\"\u0004\u0008\u000e\u0010\u000c¨\u0006\u0012", d2 = {"Landroidx/compose/ui/input/rotary/RotaryInputNode;", "Landroidx/compose/ui/input/rotary/RotaryInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "", "onPreEvent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnEvent", "()Lkotlin/jvm/functions/Function1;", "setOnEvent", "(Lkotlin/jvm/functions/Function1;)V", "getOnPreEvent", "setOnPreEvent", "onPreRotaryScrollEvent", "event", "onRotaryScrollEvent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RotaryInputNode extends Modifier.Node implements androidx.compose.ui.input.rotary.RotaryInputModifierNode {

    private Function1<? super androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> onEvent;
    private Function1<? super androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> onPreEvent;
    public RotaryInputNode(Function1<? super androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> onEvent, Function1<? super androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> onPreEvent) {
        super();
        this.onEvent = onEvent;
        this.onPreEvent = onPreEvent;
    }

    public final Function1<androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> getOnEvent() {
        return this.onEvent;
    }

    public final Function1<androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> getOnPreEvent() {
        return this.onPreEvent;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean onPreRotaryScrollEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent event) {
        boolean booleanValue;
        Function1 onPreEvent = this.onPreEvent;
        if (onPreEvent != null) {
            booleanValue = (Boolean)onPreEvent.invoke(event).booleanValue();
        } else {
            booleanValue = 0;
        }
        return booleanValue;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean onRotaryScrollEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent event) {
        boolean booleanValue;
        Function1 onEvent = this.onEvent;
        if (onEvent != null) {
            booleanValue = (Boolean)onEvent.invoke(event).booleanValue();
        } else {
            booleanValue = 0;
        }
        return booleanValue;
    }

    public final void setOnEvent(Function1<? super androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> <set-?>) {
        this.onEvent = <set-?>;
    }

    public final void setOnPreEvent(Function1<? super androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> <set-?>) {
        this.onPreEvent = <set-?>;
    }
}
