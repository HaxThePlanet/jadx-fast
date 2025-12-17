package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0008\u0016\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u001f\u0008\u0000\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0015\u0010\u001f\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008 \u0010\u000cJ\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003J\u001e\u0010\"\u001a\u00020\u00002\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000cR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u0014\u0010\u000cR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R,\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@@X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\u0008\u001c\u0010\u000c\"\u0004\u0008\u001d\u0010\u001e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006#", d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Ljava/util/List;)V", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "buttons", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getButtons-ry648PA", "()I", "I", "getChanges", "()Ljava/util/List;", "getInternalPointerEvent$ui_release", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent$ui_release", "()Landroid/view/MotionEvent;", "<set-?>", "Landroidx/compose/ui/input/pointer/PointerEventType;", "type", "getType-7fucELk", "setType-EhbLWgg$ui_release", "(I)V", "calculatePointerEventType", "calculatePointerEventType-7fucELk", "component1", "copy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PointerEvent {

    public static final int $stable = 8;
    private final int buttons;
    private final List<androidx.compose.ui.input.pointer.PointerInputChange> changes;
    private final androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;
    static {
        final int i = 8;
    }

    public PointerEvent(List<androidx.compose.ui.input.pointer.PointerInputChange> changes) {
        super(changes, 0);
    }

    public PointerEvent(List<androidx.compose.ui.input.pointer.PointerInputChange> changes, androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent) {
        int buttonState;
        int metaState;
        super();
        this.changes = changes;
        this.internalPointerEvent = internalPointerEvent;
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        if (motionEvent$ui_release != null) {
            buttonState = motionEvent$ui_release.getButtonState();
        } else {
            buttonState = metaState;
        }
        this.buttons = PointerButtons.constructor-impl(buttonState);
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        if (motionEvent$ui_release2 != null) {
            metaState = motionEvent$ui_release2.getMetaState();
        }
        this.keyboardModifiers = PointerKeyboardModifiers.constructor-impl(metaState);
        this.type = calculatePointerEventType-7fucELk();
    }

    private final int calculatePointerEventType-7fucELk() {
        int release-7fucELk;
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        boolean changedToDownIgnoreConsumed;
        final MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        if (motionEvent$ui_release != null) {
            switch (actionMasked) {
                case 0:
                    release-7fucELk = PointerEventType.Companion.getPress-7fucELk();
                    break;
                case 1:
                    release-7fucELk = PointerEventType.Companion.getRelease-7fucELk();
                    break;
                case 2:
                    release-7fucELk = PointerEventType.Companion.getMove-7fucELk();
                    break;
                case 3:
                    release-7fucELk = PointerEventType.Companion.getUnknown-7fucELk();
                    break;
                case 4:
                    release-7fucELk = PointerEventType.Companion.getScroll-7fucELk();
                    break;
                case 5:
                    release-7fucELk = PointerEventType.Companion.getEnter-7fucELk();
                    break;
                default:
                    release-7fucELk = PointerEventType.Companion.getExit-7fucELk();
            }
            return release-7fucELk;
        }
        List changes = this.changes;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < changes.size()) {
            obj2 = obj;
            i = 0;
            index$iv++;
        }
        return PointerEventType.Companion.getMove-7fucELk();
    }

    public final List<androidx.compose.ui.input.pointer.PointerInputChange> component1() {
        return this.changes;
    }

    public final androidx.compose.ui.input.pointer.PointerEvent copy(List<androidx.compose.ui.input.pointer.PointerInputChange> changes, MotionEvent motionEvent) {
        androidx.compose.ui.input.pointer.PointerEvent changesArray;
        ArrayList arrayList;
        boolean pointerEventData2;
        androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent;
        int list2;
        androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent2;
        int i;
        androidx.compose.ui.input.pointer.PointerEvent pointerEvent;
        int index$iv;
        ArrayList list3;
        int size;
        Object obj;
        Object obj2;
        int i7;
        ArrayList list;
        Object pointerInputEventData;
        long id-J3iCeTQ;
        long uptimeMillis;
        long position-F1C5BW02;
        long position-F1C5BW0;
        boolean pressed;
        float pressure;
        int type-T8wyACA;
        int i4;
        int i8;
        int i9;
        int i6;
        int i5;
        int i2;
        ArrayList pointerEventData;
        int $this$fastForEach$iv;
        int i3;
        final Object obj3 = this;
        final List list4 = changes;
        final Object obj4 = motionEvent;
        if (obj4 == null) {
            changesArray = new PointerEvent(list4, 0);
        } else {
            if (Intrinsics.areEqual(obj4, obj3.getMotionEvent$ui_release())) {
                changesArray = new PointerEvent(list4, obj3.internalPointerEvent);
            } else {
                LongSparseArray longSparseArray = new LongSparseArray(list4.size());
                arrayList = new ArrayList(list4.size());
                i = 0;
                index$iv = 0;
                while (index$iv < changes.size()) {
                    obj2 = obj;
                    i7 = 0;
                    longSparseArray.put((PointerInputChange)obj2.getId-J3iCeTQ(), pointerInputEventData);
                    pointerEventData2 = obj3.internalPointerEvent;
                    i4 = 0;
                    if (pointerEventData2 != null) {
                    } else {
                    }
                    $this$fastForEach$iv = list2;
                    i3 = i;
                    pointerInputEventData = new PointerInputEventData(obj2.getId-J3iCeTQ(), obj15, obj2.getUptimeMillis(), obj17, obj2.getPosition-F1C5BW0(), obj19, obj2.getPosition-F1C5BW0(), obj21, obj2.getPressed(), obj2.getPressure(), obj2.getType-T8wyACA(), i4, 0, 0, obj28, 0, obj30, 1792, 0);
                    (Collection)arrayList.add(pointerInputEventData);
                    index$iv++;
                    arrayList = pointerEventData;
                    list2 = $this$fastForEach$iv;
                    i = i3;
                    $this$fastForEach$iv = list2;
                    i3 = i;
                    list2 = 1;
                    if (pointerEventData2.activeHoverEvent-0FcD4WY(obj2.getId-J3iCeTQ()) == list2) {
                    }
                    i4 = list2;
                }
                $this$fastForEach$iv = list2;
                i3 = i;
                internalPointerEvent = new PointerInputEvent(obj4.getEventTime(), i, (List)arrayList, obj4);
                internalPointerEvent2 = new InternalPointerEvent(longSparseArray, internalPointerEvent);
                pointerEvent = new PointerEvent(list4, internalPointerEvent2);
                changesArray = pointerEvent;
            }
        }
        return changesArray;
    }

    public final int getButtons-ry648PA() {
        return this.buttons;
    }

    public final List<androidx.compose.ui.input.pointer.PointerInputChange> getChanges() {
        return this.changes;
    }

    public final androidx.compose.ui.input.pointer.InternalPointerEvent getInternalPointerEvent$ui_release() {
        return this.internalPointerEvent;
    }

    public final int getKeyboardModifiers-k7X9c1A() {
        return this.keyboardModifiers;
    }

    public final MotionEvent getMotionEvent$ui_release() {
        MotionEvent motionEvent;
        androidx.compose.ui.input.pointer.InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
        if (internalPointerEvent != null) {
            motionEvent = internalPointerEvent.getMotionEvent();
        } else {
            motionEvent = 0;
        }
        return motionEvent;
    }

    public final int getType-7fucELk() {
        return this.type;
    }

    public final void setType-EhbLWgg$ui_release(int <set-?>) {
        this.type = <set-?>;
    }
}
