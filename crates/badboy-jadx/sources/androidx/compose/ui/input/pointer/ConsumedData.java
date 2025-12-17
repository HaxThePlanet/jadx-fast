package androidx.compose.ui.input.pointer;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Deprecated(message = "Use PointerInputChange.isConsumed and PointerInputChange.consume() instead")
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000c\u0008\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R$\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u000c\u0010\u0007\u001a\u0004\u0008\r\u0010\t\"\u0004\u0008\u000e\u0010\u000b¨\u0006\u000f", d2 = {"Landroidx/compose/ui/input/pointer/ConsumedData;", "", "positionChange", "", "downChange", "(ZZ)V", "getDownChange$annotations", "()V", "getDownChange", "()Z", "setDownChange", "(Z)V", "getPositionChange$annotations", "getPositionChange", "setPositionChange", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsumedData {

    public static final int $stable = 8;
    private boolean downChange;
    private boolean positionChange;
    static {
        final int i = 8;
    }

    public ConsumedData() {
        final int i3 = 0;
        super(i3, i3, 3, 0);
    }

    public ConsumedData(boolean positionChange, boolean downChange) {
        super();
        this.positionChange = positionChange;
        this.downChange = downChange;
    }

    public ConsumedData(boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        int obj3;
        final int i = 0;
        obj2 = i3 & 1 != 0 ? i : obj2;
        obj3 = i3 &= 2 != 0 ? i : obj3;
        super(obj2, obj3);
    }

    @Deprecated(message = "Partial consumption was deprecated. Use PointerEvent.isConsumed and PointerEvent.consume() instead.")
    public static void getDownChange$annotations() {
    }

    @Deprecated(message = "Partial consumption was deprecated. Use PointerEvent.isConsumed and PointerEvent.consume() instead.")
    public static void getPositionChange$annotations() {
    }

    public final boolean getDownChange() {
        return this.downChange;
    }

    public final boolean getPositionChange() {
        return this.positionChange;
    }

    public final void setDownChange(boolean <set-?>) {
        this.downChange = <set-?>;
    }

    public final void setPositionChange(boolean <set-?>) {
        this.positionChange = <set-?>;
    }
}
