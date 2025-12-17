package androidx.compose.ui.input.key;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier.Node;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000f\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0008J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0012R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\n\"\u0004\u0008\u000e\u0010\u000c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0015", d2 = {"Landroidx/compose/ui/input/key/KeyInputNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "onEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreEvent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnEvent", "()Lkotlin/jvm/functions/Function1;", "setOnEvent", "(Lkotlin/jvm/functions/Function1;)V", "getOnPreEvent", "setOnPreEvent", "onKeyEvent", "event", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class KeyInputNode extends Modifier.Node implements androidx.compose.ui.input.key.KeyInputModifierNode {

    private Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> onEvent;
    private Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> onPreEvent;
    public KeyInputNode(Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> onEvent, Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> onPreEvent) {
        super();
        this.onEvent = onEvent;
        this.onPreEvent = onPreEvent;
    }

    public final Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> getOnEvent() {
        return this.onEvent;
    }

    public final Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> getOnPreEvent() {
        return this.onPreEvent;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean onKeyEvent-ZmokQxo(KeyEvent event) {
        boolean booleanValue;
        androidx.compose.ui.input.key.KeyEvent box-impl;
        Function1 onEvent = this.onEvent;
        if (onEvent != null) {
            booleanValue = (Boolean)onEvent.invoke(KeyEvent.box-impl(event)).booleanValue();
        } else {
            booleanValue = 0;
        }
        return booleanValue;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean onPreKeyEvent-ZmokQxo(KeyEvent event) {
        boolean booleanValue;
        androidx.compose.ui.input.key.KeyEvent box-impl;
        Function1 onPreEvent = this.onPreEvent;
        if (onPreEvent != null) {
            booleanValue = (Boolean)onPreEvent.invoke(KeyEvent.box-impl(event)).booleanValue();
        } else {
            booleanValue = 0;
        }
        return booleanValue;
    }

    public final void setOnEvent(Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> <set-?>) {
        this.onEvent = <set-?>;
    }

    public final void setOnPreEvent(Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> <set-?>) {
        this.onPreEvent = <set-?>;
    }
}
