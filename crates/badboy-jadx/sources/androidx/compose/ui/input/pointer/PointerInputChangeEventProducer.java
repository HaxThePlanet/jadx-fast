package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rR\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "", "()V", "previousPointerInputData", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "clear", "", "produce", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "PointerInputData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PointerInputChangeEventProducer {

    private final LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChangeEventProducer.PointerInputData> previousPointerInputData;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "down", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "(JJZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDown", "()Z", "getPositionOnScreen-F1C5BW0", "()J", "J", "getType-T8wyACA", "()I", "I", "getUptime", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PointerInputData {

        private final boolean down;
        private final long positionOnScreen;
        private final int type;
        private final long uptime;
        private PointerInputData(long uptime, long positionOnScreen, boolean down, int type) {
            super();
            this.uptime = uptime;
            this.positionOnScreen = down;
            this.down = obj5;
            this.type = obj6;
        }

        public PointerInputData(long l, long l2, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
            super(l, l2, z3, i4, defaultConstructorMarker5, obj6);
        }

        public final boolean getDown() {
            return this.down;
        }

        public final long getPositionOnScreen-F1C5BW0() {
            return this.positionOnScreen;
        }

        public final int getType-T8wyACA() {
            return this.type;
        }

        public final long getUptime() {
            return this.uptime;
        }
    }
    public PointerInputChangeEventProducer() {
        super();
        LongSparseArray longSparseArray = new LongSparseArray(0, 1, 0);
        this.previousPointerInputData = longSparseArray;
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    public final androidx.compose.ui.input.pointer.InternalPointerEvent produce(androidx.compose.ui.input.pointer.PointerInputEvent pointerInputEvent, androidx.compose.ui.input.pointer.PositionCalculator positionCalculator) {
        List pointers;
        Object previousData;
        int i4;
        int down3;
        LongSparseArray previousPointerInputData2;
        int index$iv;
        Object obj3;
        Object obj2;
        int i6;
        long id-J3iCeTQ;
        long previousTime;
        long previousPosition;
        int screenToLocal-MK-Hz9U;
        LongSparseArray previousPointerInputData;
        List list;
        int i;
        Object obj;
        androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange;
        long id-J3iCeTQ2;
        long uptime;
        long down;
        long type-T8wyACA;
        boolean down2;
        float pressure;
        long l2;
        long l;
        int i5;
        int i3;
        int type-T8wyACA2;
        List historical;
        long scrollDelta-F1C5BW0;
        long originalEventPosition-F1C5BW0;
        int i2;
        final Object obj4 = this;
        LongSparseArray longSparseArray = new LongSparseArray(pointerInputEvent.getPointers().size());
        i4 = 0;
        index$iv = 0;
        while (index$iv < pointerInputEvent.getPointers().size()) {
            obj2 = obj3;
            i6 = 0;
            int i7 = 0;
            int i8 = 0;
            screenToLocal-MK-Hz9U = 0;
            previousPointerInputData = obj4.previousPointerInputData;
            Object obj5 = previousPointerInputData.get((PointerInputEventData)obj2.getId-J3iCeTQ());
            if ((PointerInputChangeEventProducer.PointerInputData)obj5 == null) {
            } else {
            }
            obj = obj5;
            i5 = down3;
            l2 = previousTime;
            l = previousPosition;
            pointerInputChange = new PointerInputChange(obj2.getId-J3iCeTQ(), obj20, obj2.getUptime(), obj22, obj2.getPosition-F1C5BW0(), type-T8wyACA, obj2.getDown(), obj2.getPressure(), l2, obj28, l, obj30, i5, 0, obj2.getType-T8wyACA(), obj2.getHistorical(), obj2.getScrollDelta-F1C5BW0(), obj36, obj2.getOriginalEventPosition-F1C5BW0(), obj38, 0);
            longSparseArray.put(obj2.getId-J3iCeTQ(), obj10);
            if (obj2.getDown()) {
            } else {
            }
            obj4.previousPointerInputData.remove(obj2.getId-J3iCeTQ());
            index$iv++;
            pointers = list;
            i4 = i;
            pointerInputChange = new PointerInputChangeEventProducer.PointerInputData(obj2.getUptime(), obj20, obj2.getPositionOnScreen-F1C5BW0(), obj22, obj2.getDown(), obj2.getType-T8wyACA(), 0);
            obj4.previousPointerInputData.put(obj2.getId-J3iCeTQ(), obj10);
            obj = obj5;
            previousData = positionCalculator;
            i5 = down3;
            l2 = previousTime;
            l = previousPosition;
        }
        int $i$f$fastForEach = i4;
        InternalPointerEvent internalPointerEvent = new InternalPointerEvent(longSparseArray, pointerInputEvent);
        return internalPointerEvent;
    }
}
