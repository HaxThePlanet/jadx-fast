package androidx.compose.ui.input.pointer;

import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\u0008\u001bJ(\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0010J\u001d\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008%\u0010&J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010(\u001a\u00020\u001f*\u00020\u00152\u0006\u0010!\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0007\u0010\u0002\u001a\u0004\u0008\u0008\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006)", d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "()V", "activeHoverIds", "Landroid/util/SparseBooleanArray;", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui_release$annotations", "getMotionEventToComposePointerIdMap$ui_release", "()Landroid/util/SparseLongArray;", "nextId", "", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousSource", "", "previousToolType", "addFreshIds", "", "motionEvent", "Landroid/view/MotionEvent;", "clearOnDeviceChange", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui_release", "createPointerInputEventData", "index", "pressed", "", "endStream", "pointerId", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "removeStaleIds", "hasPointerId", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MotionEventAdapter {

    public static final int $stable = 8;
    private final SparseBooleanArray activeHoverIds;
    private final SparseLongArray motionEventToComposePointerIdMap;
    private long nextId;
    private final List<androidx.compose.ui.input.pointer.PointerInputEventData> pointers;
    private int previousSource = -1;
    private int previousToolType = -1;
    static {
        final int i = 8;
    }

    public MotionEventAdapter() {
        super();
        SparseLongArray sparseLongArray = new SparseLongArray();
        this.motionEventToComposePointerIdMap = sparseLongArray;
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.activeHoverIds = sparseBooleanArray;
        ArrayList arrayList = new ArrayList();
        this.pointers = (List)arrayList;
        int i = -1;
    }

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked;
        int activeHoverIds;
        int i;
        int motionEventToComposePointerIdMap2;
        long motionEventToComposePointerIdMap;
        long nextId;
        activeHoverIds = 1;
        switch (actionMasked) {
            case 0:
                actionMasked = motionEvent.getActionIndex();
                motionEventToComposePointerIdMap2 = motionEvent.getPointerId(actionMasked);
                nextId = this.nextId;
                this.nextId = activeHoverIds += nextId;
                this.motionEventToComposePointerIdMap.put(motionEventToComposePointerIdMap2, nextId);
                this.activeHoverIds.put(motionEventToComposePointerIdMap2, true);
                break;
            case 5:
                actionMasked = motionEvent.getPointerId(0);
                motionEventToComposePointerIdMap = this.nextId;
                this.nextId = activeHoverIds += motionEventToComposePointerIdMap;
                this.motionEventToComposePointerIdMap.put(actionMasked, motionEventToComposePointerIdMap);
                break;
            default:
        }
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        int motionEventToComposePointerIdMap;
        if (motionEvent.getPointerCount() != 1) {
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.previousToolType) {
            if (source != this.previousSource) {
                this.previousToolType = toolType;
                this.previousSource = source;
                this.activeHoverIds.clear();
                this.motionEventToComposePointerIdMap.clear();
            }
        } else {
        }
    }

    private final androidx.compose.ui.input.pointer.PointerInputEventData createPointerInputEventData(androidx.compose.ui.input.pointer.PositionCalculator positionCalculator, MotionEvent motionEvent, int index, boolean pressed) {
        int pos;
        float axisValue2;
        int pointerId;
        float axisValue;
        float iNSTANCE;
        int unknown-T8wyACA;
        long composePointerId-_I2yYro;
        long zero-F1C5BW0;
        int infinite;
        boolean infinite2;
        long screenToLocal-MK-Hz9U;
        long l4;
        long rawPosition;
        long l5;
        int i5;
        int i6;
        int i4;
        long l6;
        int i3;
        int i;
        long l;
        androidx.compose.ui.input.pointer.HistoricalChange historicalChange;
        long historicalEventTime;
        long l2;
        long l3;
        int i2;
        final Object obj = this;
        Object obj2 = positionCalculator;
        final MotionEvent motionEvent2 = motionEvent;
        final int i9 = index;
        composePointerId-_I2yYro = obj.getComposePointerId-_I2yYro(motionEvent.getPointerId(index));
        final int i18 = 3;
        int i17 = 0;
        int i16 = 0;
        if (i9 == 0) {
            rawPosition = OffsetKt.Offset(motionEvent2.getRawX(), motionEvent2.getRawY());
            l4 = rawPosition;
            l5 = screenToLocal-MK-Hz9U;
        } else {
            rawPosition = MotionEventHelper.INSTANCE.toRawOffset-dBAh8RU(motionEvent2, i9);
            l4 = rawPosition;
            l5 = screenToLocal-MK-Hz9U;
        }
        switch (toolType) {
            case 0:
                i5 = unknown-T8wyACA;
                break;
            case 1:
                i5 = unknown-T8wyACA;
                break;
            case 2:
                i5 = unknown-T8wyACA;
                break;
            case 3:
                i5 = unknown-T8wyACA;
                break;
            case 4:
                i5 = unknown-T8wyACA;
                break;
            default:
                i5 = unknown-T8wyACA;
        }
        ArrayList arrayList = new ArrayList(motionEvent2.getHistorySize());
        MotionEvent motionEvent3 = motionEvent;
        pos = 0;
        while (pos < motionEvent3.getHistorySize()) {
            int i20 = pos;
            i4 = 0;
            float historicalX = motionEvent3.getHistoricalX(i9, pos);
            float historicalY = motionEvent3.getHistoricalY(i9, pos);
            if (!Float.isInfinite(historicalX) && !Float.isNaN(historicalX)) {
            } else {
            }
            infinite = 0;
            if (infinite != 0) {
            }
            pos = i3 + 1;
            pointerId = i;
            composePointerId-_I2yYro = l;
            if (!Float.isInfinite(historicalY) && !Float.isNaN(historicalY)) {
            } else {
            }
            i6 = 0;
            if (i6 != 0) {
            }
            l2 = OffsetKt.Offset(historicalX, historicalY);
            historicalChange = new HistoricalChange(motionEvent3.getHistoricalEventTime(pos), obj29, l2, obj31, l2, obj33, 0);
            arrayList.add(historicalChange);
            if (!Float.isNaN(historicalY)) {
            } else {
            }
            if (!Float.isNaN(historicalX)) {
            } else {
            }
            infinite = i6;
        }
        int motionEventPointerId = pointerId;
        if (motionEvent2.getActionMasked() == 8) {
            l6 = zero-F1C5BW0;
        } else {
            l6 = zero-F1C5BW0;
        }
        PointerInputEventData historical = new PointerInputEventData(composePointerId-_I2yYro, infinite, motionEvent2.getEventTime(), 0, l4, rawPosition, l5, i18, pressed, motionEvent.getPressure(index), i5, obj.activeHoverIds.get(motionEvent.getPointerId(index), false), (List)arrayList, l6, i3, Offset.copy-dBAh8RU$default(OffsetKt.Offset(motionEvent.getX(index), motionEvent.getY(index)), obj10, 0, i17, i18), obj22, 0);
        return historical;
    }

    private final long getComposePointerId-_I2yYro(int motionEventPointerId) {
        long valueAt;
        SparseLongArray motionEventToComposePointerIdMap;
        int indexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(motionEventPointerId);
        if (indexOfKey >= 0) {
            valueAt = this.motionEventToComposePointerIdMap.valueAt(indexOfKey);
        } else {
            valueAt = this.nextId;
            this.nextId = i += valueAt;
            this.motionEventToComposePointerIdMap.put(motionEventPointerId, valueAt);
        }
        return PointerId.constructor-impl(valueAt);
    }

    public static void getMotionEventToComposePointerIdMap$ui_release$annotations() {
    }

    private final boolean hasPointerId(MotionEvent $this$hasPointerId, int pointerId) {
        int i;
        int pointerId2;
        i = 0;
        while (i < $this$hasPointerId.getPointerCount()) {
            i++;
        }
        return 0;
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked;
        int i2;
        int pointerId;
        int pointerCount;
        boolean activeHoverIds;
        int i;
        if (/* condition */) {
            pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.activeHoverIds.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.activeHoverIds.delete(pointerId);
            }
        } else {
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            size--;
            while (-1 < i2) {
                pointerCount = this.motionEventToComposePointerIdMap.keyAt(i2);
                if (!hasPointerId(motionEvent, pointerCount)) {
                }
                i2--;
                this.motionEventToComposePointerIdMap.removeAt(i2);
                this.activeHoverIds.delete(pointerCount);
            }
        }
    }

    public final androidx.compose.ui.input.pointer.PointerInputEvent convertToPointerInputEvent$ui_release(MotionEvent motionEvent, androidx.compose.ui.input.pointer.PositionCalculator positionCalculator) {
        int i2;
        int i5;
        int i;
        int pointerId;
        int actionIndex;
        SparseBooleanArray activeHoverIds;
        int i3;
        List pointers;
        androidx.compose.ui.input.pointer.PointerInputEventData pointerInputEventData;
        int i4;
        if (/* condition */) {
            this.motionEventToComposePointerIdMap.clear();
            this.activeHoverIds.clear();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        int i7 = 0;
        int i8 = 1;
        if (actionMasked != 9 && actionMasked != 7) {
            if (actionMasked != 7) {
                if (actionMasked == 10) {
                    i5 = i8;
                } else {
                    i5 = i7;
                }
            } else {
            }
        } else {
        }
        i = actionMasked == 8 ? i8 : i7;
        if (i5 != 0) {
            this.activeHoverIds.put(motionEvent.getPointerId(motionEvent.getActionIndex()), i8);
        }
        switch (actionMasked) {
            case 1:
                actionIndex = i7;
                break;
            case 6:
                actionIndex = motionEvent.getActionIndex();
                break;
            default:
                actionIndex = -1;
        }
        this.pointers.clear();
        i3 = 0;
        final int pointerCount = motionEvent.getPointerCount();
        while (i3 < pointerCount) {
            if (i5 == 0 && i3 != actionIndex) {
            } else {
            }
            i4 = i7;
            this.pointers.add(createPointerInputEventData(positionCalculator, motionEvent, i3, i4));
            i3++;
            if (i3 != actionIndex) {
            } else {
            }
            if (i != 0) {
            } else {
            }
            i4 = i8;
            if (motionEvent.getButtonState() != 0) {
            } else {
            }
        }
        removeStaleIds(motionEvent);
        PointerInputEvent pointerInputEvent = new PointerInputEvent(motionEvent.getEventTime(), pointerCount, this.pointers, motionEvent);
        return pointerInputEvent;
    }

    public final void endStream(int pointerId) {
        this.activeHoverIds.delete(pointerId);
        this.motionEventToComposePointerIdMap.delete(pointerId);
    }

    public final SparseLongArray getMotionEventToComposePointerIdMap$ui_release() {
        return this.motionEventToComposePointerIdMap;
    }
}
