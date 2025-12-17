package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0002H\u0096\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\n¨\u0006\r", d2 = {"Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "Lkotlin/Function1;", "", "", "()V", "pointerInteropFilter", "Landroidx/compose/ui/input/pointer/PointerInteropFilter;", "getPointerInteropFilter$ui_release", "()Landroidx/compose/ui/input/pointer/PointerInteropFilter;", "setPointerInteropFilter$ui_release", "(Landroidx/compose/ui/input/pointer/PointerInteropFilter;)V", "invoke", "disallowIntercept", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RequestDisallowInterceptTouchEvent implements Function1<Boolean, Unit> {

    public static final int $stable = 8;
    private androidx.compose.ui.input.pointer.PointerInteropFilter pointerInteropFilter;
    static {
        final int i = 8;
    }

    @Override // kotlin.jvm.functions.Function1
    public final androidx.compose.ui.input.pointer.PointerInteropFilter getPointerInteropFilter$ui_release() {
        return this.pointerInteropFilter;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object p1) {
        invoke((Boolean)p1.booleanValue());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public void invoke(boolean disallowIntercept) {
        final androidx.compose.ui.input.pointer.PointerInteropFilter pointerInteropFilter = this.pointerInteropFilter;
        if (pointerInteropFilter == null) {
        } else {
            pointerInteropFilter.setDisallowIntercept$ui_release(disallowIntercept);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final void setPointerInteropFilter$ui_release(androidx.compose.ui.input.pointer.PointerInteropFilter <set-?>) {
        this.pointerInteropFilter = <set-?>;
    }
}
