package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0001\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u0006\u001c", d2 = {"Landroidx/compose/ui/input/pointer/PointerInteropFilter;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "()V", "disallowIntercept", "", "getDisallowIntercept$ui_release", "()Z", "setDisallowIntercept$ui_release", "(Z)V", "onTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "getOnTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setOnTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "pointerInputFilter", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "value", "Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "requestDisallowInterceptTouchEvent", "getRequestDisallowInterceptTouchEvent", "()Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "setRequestDisallowInterceptTouchEvent", "(Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;)V", "DispatchToViewState", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PointerInteropFilter implements androidx.compose.ui.input.pointer.PointerInputModifier {

    public static final int $stable;
    private boolean disallowIntercept;
    public Function1<? super MotionEvent, Boolean> onTouchEvent;
    private final androidx.compose.ui.input.pointer.PointerInputFilter pointerInputFilter;
    private androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "", "(Ljava/lang/String;I)V", "Unknown", "Dispatching", "NotDispatching", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static enum DispatchToViewState {

        Unknown,
        Dispatching,
        NotDispatching;
        private static final androidx.compose.ui.input.pointer.PointerInteropFilter.DispatchToViewState[] $values() {
            return /* result */;
        }
    }
    static {
    }

    public PointerInteropFilter() {
        super();
        PointerInteropFilter.pointerInputFilter.1 anon = new PointerInteropFilter.pointerInputFilter.1(this);
        this.pointerInputFilter = (PointerInputFilter)anon;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputModifier
    public final boolean getDisallowIntercept$ui_release() {
        return this.disallowIntercept;
    }

    public final Function1<MotionEvent, Boolean> getOnTouchEvent() {
        Function1 onTouchEvent = this.onTouchEvent;
        if (onTouchEvent != null) {
            return onTouchEvent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onTouchEvent");
        return 0;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputModifier
    public androidx.compose.ui.input.pointer.PointerInputFilter getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputModifier
    public final androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent getRequestDisallowInterceptTouchEvent() {
        return this.requestDisallowInterceptTouchEvent;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputModifier
    public final void setDisallowIntercept$ui_release(boolean <set-?>) {
        this.disallowIntercept = <set-?>;
    }

    public final void setOnTouchEvent(Function1<? super MotionEvent, Boolean> <set-?>) {
        this.onTouchEvent = <set-?>;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputModifier
    public final void setRequestDisallowInterceptTouchEvent(androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent value) {
        int i;
        androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent = this.requestDisallowInterceptTouchEvent;
        if (requestDisallowInterceptTouchEvent == null) {
        } else {
            requestDisallowInterceptTouchEvent.setPointerInteropFilter$ui_release(0);
        }
        this.requestDisallowInterceptTouchEvent = value;
        androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent2 = this.requestDisallowInterceptTouchEvent;
        if (requestDisallowInterceptTouchEvent2 == null) {
        } else {
            requestDisallowInterceptTouchEvent2.setPointerInteropFilter$ui_release(this);
        }
    }
}
