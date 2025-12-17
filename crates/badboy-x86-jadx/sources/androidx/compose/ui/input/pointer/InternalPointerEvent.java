package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "", "changes", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "(Landroidx/collection/LongSparseArray;Landroidx/compose/ui/input/pointer/PointerInputEvent;)V", "getChanges", "()Landroidx/collection/LongSparseArray;", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent", "()Landroid/view/MotionEvent;", "getPointerInputEvent", "()Landroidx/compose/ui/input/pointer/PointerInputEvent;", "suppressMovementConsumption", "", "getSuppressMovementConsumption", "()Z", "setSuppressMovementConsumption", "(Z)V", "activeHoverEvent", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "activeHoverEvent-0FcD4WY", "(J)Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InternalPointerEvent {

    public static final int $stable = 8;
    private final LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> changes;
    private final androidx.compose.ui.input.pointer.PointerInputEvent pointerInputEvent;
    private boolean suppressMovementConsumption;
    static {
        final int i = 8;
    }

    public InternalPointerEvent(LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> changes, androidx.compose.ui.input.pointer.PointerInputEvent pointerInputEvent) {
        super();
        this.changes = changes;
        this.pointerInputEvent = pointerInputEvent;
    }

    public final boolean activeHoverEvent-0FcD4WY(long pointerId) {
        boolean activeHover;
        int index$iv$iv;
        Object obj2;
        Object obj;
        int i;
        boolean it;
        int i2;
        long id-J3iCeTQ;
        final int i3 = 0;
        final List list = pointers;
        final int i4 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i = 0;
            i2 = 0;
            index$iv$iv++;
        }
        obj = 0;
        if ((PointerInputEventData)obj != null) {
            activeHover = (PointerInputEventData)obj.getActiveHover();
        } else {
            activeHover = 0;
        }
        return activeHover;
    }

    public final LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> getChanges() {
        return this.changes;
    }

    public final MotionEvent getMotionEvent() {
        return this.pointerInputEvent.getMotionEvent();
    }

    public final androidx.compose.ui.input.pointer.PointerInputEvent getPointerInputEvent() {
        return this.pointerInputEvent;
    }

    public final boolean getSuppressMovementConsumption() {
        return this.suppressMovementConsumption;
    }

    public final void setSuppressMovementConsumption(boolean <set-?>) {
        this.suppressMovementConsumption = <set-?>;
    }
}
