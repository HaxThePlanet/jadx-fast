package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008#\n\u0002\u0010\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B[\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000c\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011BQ\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000c\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0014Bu\u0008\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000c\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0002\u0010\u001bBa\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000c\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u001cJ\u0006\u0010<\u001a\u00020=Jt\u0010>\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010?\u001a\u00020\u00052\u0008\u0008\u0002\u0010@\u001a\u00020\u00072\u0008\u0008\u0002\u0010A\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010B\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008C\u0010DJ\u0086\u0001\u0010>\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010?\u001a\u00020\u00052\u0008\u0008\u0002\u0010@\u001a\u00020\u00072\u0008\u0008\u0002\u0010A\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010B\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\u0008\u0002\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00182\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008E\u0010FJl\u0010>\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010?\u001a\u00020\u00052\u0008\u0008\u0002\u0010@\u001a\u00020\u00072\u0008\u0008\u0002\u0010A\u001a\u00020\t2\u0008\u0008\u0002\u0010B\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008G\u0010HJt\u0010>\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010?\u001a\u00020\u00052\u0008\u0008\u0002\u0010@\u001a\u00020\u00072\u0008\u0008\u0002\u0010A\u001a\u00020\t2\u0008\u0008\u0002\u0010B\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008I\u0010JJj\u0010>\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010?\u001a\u00020\u00052\u0008\u0008\u0002\u0010@\u001a\u00020\u00072\u0008\u0008\u0002\u0010A\u001a\u00020\t2\u0008\u0008\u0002\u0010B\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJz\u0010>\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010?\u001a\u00020\u00052\u0008\u0008\u0002\u0010@\u001a\u00020\u00072\u0008\u0008\u0002\u0010A\u001a\u00020\t2\u0008\u0008\u0002\u0010B\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000c\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00182\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008M\u0010NJ\u0008\u0010O\u001a\u00020PH\u0016R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u001e\u0010\u001fR&\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00138\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\u0008!\u0010\u001f\u001a\u0004\u0008\"\u0010#R \u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00188GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008$\u0010\u001f\u001a\u0004\u0008%\u0010&R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\u0008'\u0010(R\u0017\u0010*\u001a\u00020\t8F¢\u0006\u000c\u0012\u0004\u0008+\u0010\u001f\u001a\u0004\u0008*\u0010,R\"\u0010\u001a\u001a\u00020\u0007X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\u0008-\u0010(\"\u0004\u0008.\u0010/R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\u00080\u0010(R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010,R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u00103R\u0019\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\u00084\u0010(R\u0011\u0010\u000c\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010,R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010(R\u0019\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\u00087\u0010(R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010:\u001a\u0004\u00088\u00109R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010(\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Q", d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "previousUptimeMillis", "previousPosition", "previousPressed", "isInitiallyConsumed", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "scrollDelta", "(JJJZJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "pressure", "", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "originalEventPosition", "(JJJZFJJZZILjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJZFJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_historical", "get_historical$annotations", "()V", "<set-?>", "getConsumed$annotations", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "getHistorical$annotations", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "J", "isConsumed", "isConsumed$annotations", "()Z", "getOriginalEventPosition-F1C5BW0$ui_release", "setOriginalEventPosition-k-4lQ0M$ui_release", "(J)V", "getPosition-F1C5BW0", "getPressed", "getPressure", "()F", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "getPreviousUptimeMillis", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptimeMillis", "consume", "", "copy", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-Tn9QgHE", "(JJJZFJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-wbzehF4", "(JJJZFJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-0GkPj7c", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;IJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-JKmWfYY", "(JJJZJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-OHpmEuE", "(JJJZJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PointerInputChange {

    public static final int $stable;
    private List<androidx.compose.ui.input.pointer.HistoricalChange> _historical;
    private androidx.compose.ui.input.pointer.ConsumedData consumed;
    private final long id;
    private long originalEventPosition;
    private final long position;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;
    static {
    }

    private PointerInputChange(long id, long uptimeMillis, long position, boolean pressed, float pressure, long previousUptimeMillis, long previousPosition, boolean previousPressed, boolean isInitiallyConsumed, int type, long scrollDelta) {
        final Object obj = this;
        super();
        obj.id = id;
        obj.uptimeMillis = position;
        obj.position = pressure;
        obj.pressed = previousPosition;
        obj.pressure = previousPressed;
        obj.previousUptimeMillis = isInitiallyConsumed;
        obj.previousPosition = scrollDelta;
        obj.previousPressed = obj29;
        obj.type = obj31;
        obj.scrollDelta = obj32;
        obj.originalEventPosition = Offset.Companion.getZero-F1C5BW0();
        final boolean z = obj30;
        ConsumedData consumedData = new ConsumedData(z, z);
        obj.consumed = consumedData;
    }

    public PointerInputChange(long l, long l2, long l3, boolean z4, float f5, long l6, long l7, boolean z8, boolean z9, int i10, long l11, int i12, DefaultConstructorMarker defaultConstructorMarker13) {
        int zero-F1C5BW0;
        int touch-T8wyACA;
        int i;
        long l4;
        int i2 = obj39;
        if (i2 & 512 != 0) {
            i = touch-T8wyACA;
        } else {
            i = obj36;
        }
        if (i2 &= 1024 != 0) {
            l4 = zero-F1C5BW0;
        } else {
            l4 = obj37;
        }
        super(l, obj4, l3, obj6, f5, obj8, l7, z8, z9, obj12, l11, obj14, defaultConstructorMarker13, obj35, i, l4, obj19, 0);
    }

    public PointerInputChange(long l, long l2, long l3, boolean z4, float f5, long l6, long l7, boolean z8, boolean z9, int i10, long l11, DefaultConstructorMarker defaultConstructorMarker12) {
        super(l, l2, l3, z4, f5, l6, l7, z8, z9, i10, l11, defaultConstructorMarker12, obj13, obj14, obj15, obj16, obj17);
    }

    private PointerInputChange(long id, long uptimeMillis, long position, boolean pressed, float pressure, long previousUptimeMillis, long previousPosition, boolean previousPressed, boolean isInitiallyConsumed, int type, List<androidx.compose.ui.input.pointer.HistoricalChange> historical, long scrollDelta, long originalEventPosition) {
        final Object obj = this;
        super(id, obj2, position, obj4, pressure, obj6, previousPosition, previousPressed, isInitiallyConsumed, obj10, historical, obj12, originalEventPosition, obj33, obj34, obj36, obj17, 0);
        obj._historical = obj35;
        obj.originalEventPosition = obj38;
    }

    public PointerInputChange(long l, long l2, long l3, boolean z4, float f5, long l6, long l7, boolean z8, boolean z9, int i10, List list11, long l12, long l13, DefaultConstructorMarker defaultConstructorMarker14) {
        super(l, l2, l3, z4, f5, l6, l7, z8, z9, i10, list11, l12, l13, defaultConstructorMarker14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    private PointerInputChange(long id, long uptimeMillis, long position, boolean pressed, long previousUptimeMillis, long previousPosition, boolean previousPressed, androidx.compose.ui.input.pointer.ConsumedData consumed, int type) {
        int i;
        boolean positionChange;
        if (!obj33.getDownChange()) {
            if (obj33.getPositionChange()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        super(id, obj3, position, obj5, previousUptimeMillis, obj7, previousPressed, 1065353216, consumed, obj11, obj30, obj13, obj32, i, obj34, Offset.Companion.getZero-F1C5BW0(), obj18, 0);
    }

    public PointerInputChange(long l, long l2, long l3, boolean z4, long l5, long l6, boolean z7, androidx.compose.ui.input.pointer.ConsumedData consumedData8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker11) {
        int touch-T8wyACA;
        int i;
        if (i2 &= 256 != 0) {
            i = touch-T8wyACA;
        } else {
            i = obj31;
        }
        super(l, obj3, l3, obj5, l5, obj7, z7, consumedData8, obj10, i10, obj12, obj29, obj30, i, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another constructor with `scrollDelta` and without `ConsumedData` instead", replaceWith = @ReplaceWith(...))
    public PointerInputChange(long l, long l2, long l3, boolean z4, long l5, long l6, boolean z7, androidx.compose.ui.input.pointer.ConsumedData consumedData8, int i9, DefaultConstructorMarker defaultConstructorMarker10) {
        super(l, l2, l3, z4, l5, l6, z7, consumedData8, i9, defaultConstructorMarker10, obj11, obj12, obj13, obj14);
    }

    private PointerInputChange(long id, long uptimeMillis, long position, boolean pressed, long previousUptimeMillis, long previousPosition, boolean previousPressed, boolean isInitiallyConsumed, int type, long scrollDelta) {
        super(id, obj2, position, obj4, previousUptimeMillis, obj6, previousPressed, 1065353216, isInitiallyConsumed, obj10, scrollDelta, obj12, obj31, obj32, obj33, obj34, obj17, 0);
    }

    public PointerInputChange(long l, long l2, long l3, boolean z4, long l5, long l6, boolean z7, boolean z8, int i9, long l10, int i11, DefaultConstructorMarker defaultConstructorMarker12) {
        int zero-F1C5BW0;
        int touch-T8wyACA;
        int i;
        long l4;
        int i2 = obj37;
        if (i2 & 256 != 0) {
            i = touch-T8wyACA;
        } else {
            i = obj34;
        }
        if (i2 &= 512 != 0) {
            l4 = zero-F1C5BW0;
        } else {
            l4 = obj35;
        }
        super(l, obj4, l3, obj6, l5, obj8, z7, z8, obj11, l10, obj13, defaultConstructorMarker12, obj33, i, l4, obj18, 0);
    }

    public PointerInputChange(long l, long l2, long l3, boolean z4, long l5, long l6, boolean z7, boolean z8, int i9, long l10, DefaultConstructorMarker defaultConstructorMarker11) {
        super(l, l2, l3, z4, l5, l6, z7, z8, i9, l10, defaultConstructorMarker11, obj12, obj13, obj14, obj15, obj16);
    }

    public static androidx.compose.ui.input.pointer.PointerInputChange copy-0GkPj7c$default(androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange, long l2, long l3, long l4, boolean z5, long l6, long l7, boolean z8, androidx.compose.ui.input.pointer.ConsumedData consumedData9, int i10, long l11, int i12, Object object13) {
        long scrollDelta;
        long uptimeMillis;
        long position;
        boolean pressed;
        long previousUptimeMillis;
        long previousPosition;
        boolean previousPressed;
        int type;
        int i;
        long l;
        long obj19;
        final Object obj = pointerInputChange;
        int i2 = obj35;
        scrollDelta = i2 & 1 != 0 ? obj.id : l2;
        uptimeMillis = i2 & 2 != 0 ? obj.uptimeMillis : l4;
        position = i2 & 4 != 0 ? obj.position : l6;
        pressed = i2 & 8 != 0 ? obj.pressed : z8;
        previousUptimeMillis = i2 & 16 != 0 ? obj.previousUptimeMillis : consumedData9;
        previousPosition = i2 & 32 != 0 ? obj.previousPosition : l11;
        previousPressed = i2 & 64 != 0 ? obj.previousPressed : object13;
        i = i2 & 256 != 0 ? type : obj32;
        if (i2 &= 512 != 0) {
            obj19 = scrollDelta;
            l = scrollDelta;
        } else {
            obj19 = scrollDelta;
            l = obj33;
        }
        return obj.copy-0GkPj7c(obj19, obj3, uptimeMillis, obj5, position, obj7, pressed, previousUptimeMillis, obj10, previousPosition);
    }

    public static androidx.compose.ui.input.pointer.PointerInputChange copy-Ezr-O64$default(androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange, long l2, long l3, long l4, boolean z5, long l6, long l7, boolean z8, androidx.compose.ui.input.pointer.ConsumedData consumedData9, int i10, int i11, Object object12) {
        int type;
        long l;
        long uptimeMillis;
        long position;
        boolean pressed;
        long previousUptimeMillis;
        long previousPosition;
        boolean previousPressed;
        androidx.compose.ui.input.pointer.ConsumedData consumed;
        int i = obj29;
        l = i & 1 != 0 ? pointerInputChange.id : l2;
        uptimeMillis = i & 2 != 0 ? pointerInputChange.uptimeMillis : l4;
        position = i & 4 != 0 ? pointerInputChange.position : l6;
        pressed = i & 8 != 0 ? pointerInputChange.pressed : z8;
        previousUptimeMillis = i & 16 != 0 ? pointerInputChange.previousUptimeMillis : consumedData9;
        previousPosition = i & 32 != 0 ? pointerInputChange.previousPosition : i11;
        previousPressed = i & 64 != 0 ? pointerInputChange.previousPressed : obj26;
        consumed = i & 128 != 0 ? pointerInputChange.consumed : obj27;
        type = i &= 256 != 0 ? pointerInputChange.type : obj28;
        return pointerInputChange.copy-Ezr-O64(l, l4, uptimeMillis, l6, position, z8, pressed, previousUptimeMillis, i11);
    }

    public static androidx.compose.ui.input.pointer.PointerInputChange copy-JKmWfYY$default(androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange, long l2, long l3, long l4, boolean z5, long l6, long l7, boolean z8, int i9, long l10, int i11, Object object12) {
        long scrollDelta;
        long l;
        long uptimeMillis;
        long position;
        boolean pressed;
        long previousUptimeMillis;
        long previousPosition;
        boolean previousPressed;
        int type;
        long l5;
        Object obj = pointerInputChange;
        int i = obj33;
        l = i & 1 != 0 ? obj.id : l2;
        uptimeMillis = i & 2 != 0 ? obj.uptimeMillis : l4;
        position = i & 4 != 0 ? obj.position : l6;
        pressed = i & 8 != 0 ? obj.pressed : z8;
        previousUptimeMillis = i & 16 != 0 ? obj.previousUptimeMillis : i9;
        previousPosition = i & 32 != 0 ? obj.previousPosition : i11;
        previousPressed = i & 64 != 0 ? obj.previousPressed : obj29;
        type = i & 128 != 0 ? obj.type : obj30;
        scrollDelta = i &= 256 != 0 ? obj.scrollDelta : obj31;
        return obj.copy-JKmWfYY(l5, l4, uptimeMillis, l6, position, z8, pressed, previousUptimeMillis, i11);
    }

    public static androidx.compose.ui.input.pointer.PointerInputChange copy-OHpmEuE$default(androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange, long l2, long l3, long l4, boolean z5, long l6, long l7, boolean z8, int i9, List list10, long l11, int i12, Object object13) {
        long scrollDelta;
        long uptimeMillis;
        long position;
        boolean pressed;
        long previousUptimeMillis;
        long previousPosition;
        boolean previousPressed;
        int type;
        long l;
        long obj19;
        final Object obj = pointerInputChange;
        int i = obj35;
        scrollDelta = i & 1 != 0 ? obj.id : l2;
        uptimeMillis = i & 2 != 0 ? obj.uptimeMillis : l4;
        position = i & 4 != 0 ? obj.position : l6;
        pressed = i & 8 != 0 ? obj.pressed : z8;
        previousUptimeMillis = i & 16 != 0 ? obj.previousUptimeMillis : i9;
        previousPosition = i & 32 != 0 ? obj.previousPosition : l11;
        previousPressed = i & 64 != 0 ? obj.previousPressed : object13;
        type = i & 128 != 0 ? obj.type : obj31;
        if (i &= 512 != 0) {
            obj19 = scrollDelta;
            l = scrollDelta;
        } else {
            obj19 = scrollDelta;
            l = obj33;
        }
        return obj.copy-OHpmEuE(obj19, obj3, uptimeMillis, obj5, position, obj7, pressed, previousUptimeMillis, obj10, previousPosition);
    }

    public static androidx.compose.ui.input.pointer.PointerInputChange copy-Tn9QgHE$default(androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange, long l2, long l3, long l4, boolean z5, float f6, long l7, long l8, boolean z9, int i10, long l11, int i12, Object object13) {
        long scrollDelta;
        long l5;
        long uptimeMillis;
        long position;
        boolean pressed;
        float pressure;
        long previousUptimeMillis;
        long previousPosition;
        boolean previousPressed;
        int type;
        long l;
        Object obj = pointerInputChange;
        int i = obj35;
        l5 = i & 1 != 0 ? obj.id : l2;
        uptimeMillis = i & 2 != 0 ? obj.uptimeMillis : l4;
        position = i & 4 != 0 ? obj.position : f6;
        pressed = i & 8 != 0 ? obj.pressed : l8;
        pressure = i & 16 != 0 ? obj.pressure : z9;
        previousUptimeMillis = i & 32 != 0 ? obj.previousUptimeMillis : i10;
        previousPosition = i & 64 != 0 ? obj.previousPosition : i12;
        previousPressed = i & 128 != 0 ? obj.previousPressed : obj31;
        type = i & 256 != 0 ? obj.type : obj32;
        scrollDelta = i &= 512 != 0 ? obj.scrollDelta : obj33;
        return obj.copy-Tn9QgHE(l, l4, uptimeMillis, f6, position, l8, pressed, pressure, previousUptimeMillis, i12);
    }

    public static androidx.compose.ui.input.pointer.PointerInputChange copy-wbzehF4$default(androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange, long l2, long l3, long l4, boolean z5, float f6, long l7, long l8, boolean z9, int i10, List list11, long l12, int i13, Object object14) {
        long scrollDelta;
        long l;
        List historical;
        long uptimeMillis;
        long position;
        boolean pressed;
        float pressure;
        long previousUptimeMillis;
        long previousPosition;
        boolean previousPressed;
        int type;
        List obj19;
        Object obj = pointerInputChange;
        int i = obj36;
        l = i & 1 != 0 ? obj.id : l2;
        uptimeMillis = i & 2 != 0 ? obj.uptimeMillis : l4;
        position = i & 4 != 0 ? obj.position : f6;
        pressed = i & 8 != 0 ? obj.pressed : l8;
        pressure = i & 16 != 0 ? obj.pressure : z9;
        previousUptimeMillis = i & 32 != 0 ? obj.previousUptimeMillis : i10;
        previousPosition = i & 64 != 0 ? obj.previousPosition : l12;
        previousPressed = i & 128 != 0 ? obj.previousPressed : object14;
        type = i & 256 != 0 ? obj.type : obj32;
        if (i & 512 != 0) {
            historical = obj.getHistorical();
        } else {
            historical = obj33;
        }
        scrollDelta = i &= 1024 != 0 ? obj.scrollDelta : obj34;
        return obj.copy-wbzehF4(l, l4, uptimeMillis, f6, position, l8, pressed, pressure, previousUptimeMillis, l12, previousPosition);
    }

    @Deprecated(message = "use isConsumed and consume() pair of methods instead")
    public static void getConsumed$annotations() {
    }

    public static void getHistorical$annotations() {
    }

    private static void get_historical$annotations() {
    }

    public static void isConsumed$annotations() {
    }

    public final void consume() {
        final int i = 1;
        this.consumed.setDownChange(i);
        this.consumed.setPositionChange(i);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use copy() instead without `consumed` parameter to create a shallow copy or a constructor to create a new PointerInputChange", replaceWith = @ReplaceWith(...))
    public final androidx.compose.ui.input.pointer.PointerInputChange copy-0GkPj7c(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, androidx.compose.ui.input.pointer.ConsumedData consumed, int type, long scrollDelta) {
        int i;
        boolean positionChange;
        final Object obj = this;
        if (!obj36.getDownChange()) {
            if (obj36.getPositionChange()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        PointerInputChange pointerInputChange = new PointerInputChange(id, obj3, currentPosition, obj5, previousTime, obj7, previousPressed, obj.pressure, consumed, obj11, scrollDelta, obj13, obj35, i, obj37, obj.getHistorical(), obj38, obj19, obj.originalEventPosition, obj21, 0);
        androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange2 = pointerInputChange;
        final int i2 = 0;
        obj.consumed = obj36;
        return pointerInputChange;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another copy() method with scrollDelta parameter instead", replaceWith = @ReplaceWith(...))
    public final androidx.compose.ui.input.pointer.PointerInputChange copy-Ezr-O64(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, androidx.compose.ui.input.pointer.ConsumedData consumed, int type) {
        int i;
        boolean positionChange;
        final Object obj = this;
        if (!obj36.getDownChange()) {
            if (obj36.getPositionChange()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        PointerInputChange pointerInputChange = new PointerInputChange(id, obj3, currentPosition, obj5, previousTime, obj7, previousPressed, obj.pressure, consumed, obj11, obj33, obj13, obj35, i, obj37, obj.getHistorical(), obj.scrollDelta, obj19, obj.originalEventPosition, obj21, 0);
        androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange2 = pointerInputChange;
        final int i2 = 0;
        obj.consumed = obj36;
        return pointerInputChange;
    }

    public final androidx.compose.ui.input.pointer.PointerInputChange copy-JKmWfYY(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, int type, long scrollDelta) {
        final Object obj = this;
        return obj.copy-wbzehF4(id, obj3, currentPosition, obj5, previousTime, obj7, previousPressed, obj.pressure, type, obj11, obj29);
    }

    public final androidx.compose.ui.input.pointer.PointerInputChange copy-OHpmEuE(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, int type, List<androidx.compose.ui.input.pointer.HistoricalChange> historical, long scrollDelta) {
        final Object obj = this;
        return obj.copy-wbzehF4(id, obj3, currentPosition, obj5, previousTime, obj7, previousPressed, obj.pressure, type, obj11, scrollDelta);
    }

    public final androidx.compose.ui.input.pointer.PointerInputChange copy-Tn9QgHE(long id, long currentTime, long currentPosition, boolean currentPressed, float pressure, long previousTime, long previousPosition, boolean previousPressed, int type, long scrollDelta) {
        final Object obj = this;
        PointerInputChange pointerInputChange = new PointerInputChange(id, obj3, currentPosition, obj5, pressure, obj7, previousPosition, previousPressed, type, obj11, obj34, obj13, obj36, 0, obj37, obj.getHistorical(), obj38, obj19, obj.originalEventPosition, obj21, 0);
        final int i = 0;
        pointerInputChange2.consumed = obj.consumed;
        return pointerInputChange;
    }

    public final androidx.compose.ui.input.pointer.PointerInputChange copy-wbzehF4(long id, long currentTime, long currentPosition, boolean currentPressed, float pressure, long previousTime, long previousPosition, boolean previousPressed, int type, List<androidx.compose.ui.input.pointer.HistoricalChange> historical, long scrollDelta) {
        final Object obj = this;
        PointerInputChange pointerInputChange = new PointerInputChange(id, obj3, currentPosition, obj5, pressure, obj7, previousPosition, previousPressed, type, obj11, scrollDelta, obj13, obj36, 0, obj37, obj38, obj39, obj19, obj.originalEventPosition, obj21, 0);
        final int i = 0;
        pointerInputChange2.consumed = obj.consumed;
        return pointerInputChange;
    }

    public final androidx.compose.ui.input.pointer.ConsumedData getConsumed() {
        return this.consumed;
    }

    public final List<androidx.compose.ui.input.pointer.HistoricalChange> getHistorical() {
        List emptyList;
        if (this._historical == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    public final long getId-J3iCeTQ() {
        return this.id;
    }

    public final long getOriginalEventPosition-F1C5BW0$ui_release() {
        return this.originalEventPosition;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    public final long getPreviousPosition-F1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    public final long getScrollDelta-F1C5BW0() {
        return this.scrollDelta;
    }

    public final int getType-T8wyACA() {
        return this.type;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final boolean isConsumed() {
        int i;
        boolean positionChange;
        if (!this.consumed.getDownChange()) {
            if (this.consumed.getPositionChange()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final void setOriginalEventPosition-k-4lQ0M$ui_release(long <set-?>) {
        this.originalEventPosition = <set-?>;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str12 = ",scrollDelta=";
        stringBuilder.append("PointerInputChange(id=").append(PointerId.toString-impl(this.id)).append(", uptimeMillis=").append(this.uptimeMillis).append(", position=").append(Offset.toString-impl(this.position)).append(", pressed=").append(this.pressed).append(", pressure=").append(this.pressure).append(", previousUptimeMillis=").append(this.previousUptimeMillis).append(", previousPosition=").append(Offset.toString-impl(this.previousPosition)).append(", previousPressed=").append(this.previousPressed).append(", isConsumed=").append(isConsumed()).append(", type=").append(PointerType.toString-impl(this.type)).append(", historical=").append(getHistorical()).append(str12);
        stringBuilder.append(Offset.toString-impl(this.scrollDelta)).append(')');
        return stringBuilder.toString();
    }
}
