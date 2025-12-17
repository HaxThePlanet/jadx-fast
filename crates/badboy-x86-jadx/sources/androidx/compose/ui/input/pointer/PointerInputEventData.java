package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008,\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\n\u0012\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0002\u0010\u0015J\u0016\u0010(\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008)\u0010\u001cJ\u0016\u0010*\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008+\u0010\u001cJ\u0016\u0010,\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008-\u0010\u001cJ\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u0016\u0010/\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00080\u0010\u001cJ\u0016\u00101\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00082\u0010\u001cJ\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\u000cHÆ\u0003J\u0016\u00105\u001a\u00020\u000eHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00086\u0010%J\t\u00107\u001a\u00020\nHÆ\u0003J\u000f\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\u0087\u0001\u00109\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\n2\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008:\u0010;J\u0013\u0010<\u001a\u00020\n2\u0008\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020AHÖ\u0001R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0017R\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\u0008\u001b\u0010\u001cR\u0019\u0010\u0014\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\u0008\u001e\u0010\u001cR\u0019\u0010\u0008\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\u0008\u001f\u0010\u001cR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\u0008 \u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0019\u0010\u0013\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\u0008#\u0010\u001cR\u0019\u0010\r\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010&\u001a\u0004\u0008$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006B", d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventData;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "position", "down", "", "pressure", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "activeHover", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "scrollDelta", "originalEventPosition", "(JJJJZFIZLjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveHover", "()Z", "getDown", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "J", "getOriginalEventPosition-F1C5BW0", "getPosition-F1C5BW0", "getPositionOnScreen-F1C5BW0", "getPressure", "()F", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptime", "component1", "component1-J3iCeTQ", "component10", "component10-F1C5BW0", "component11", "component11-F1C5BW0", "component2", "component3", "component3-F1C5BW0", "component4", "component4-F1C5BW0", "component5", "component6", "component7", "component7-T8wyACA", "component8", "component9", "copy", "copy-rc8HELY", "(JJJJZFIZLjava/util/List;JJ)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "equals", "other", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PointerInputEventData {

    public static final int $stable = 8;
    private final boolean activeHover;
    private final boolean down;
    private final List<androidx.compose.ui.input.pointer.HistoricalChange> historical;
    private final long id;
    private final long originalEventPosition;
    private final long position;
    private final long positionOnScreen;
    private final float pressure;
    private final long scrollDelta;
    private final int type;
    private final long uptime;
    static {
        final int i = 8;
    }

    private PointerInputEventData(long id, long uptime, long positionOnScreen, long position, boolean down, float pressure, int type, boolean activeHover, List<androidx.compose.ui.input.pointer.HistoricalChange> historical, long scrollDelta, long originalEventPosition) {
        final Object obj = this;
        super();
        obj.id = id;
        obj.uptime = positionOnScreen;
        obj.positionOnScreen = down;
        obj.position = type;
        obj.down = historical;
        obj.pressure = scrollDelta;
        obj.type = originalEventPosition;
        obj.activeHover = obj28;
        obj.historical = obj29;
        obj.scrollDelta = obj30;
        obj.originalEventPosition = obj32;
    }

    public PointerInputEventData(long l, long l2, long l3, long l4, boolean z5, float f6, int i7, boolean z8, List list9, long l10, long l11, int i12, DefaultConstructorMarker defaultConstructorMarker13) {
        int zero-F1C5BW0;
        int i;
        int arrayList;
        long zero-F1C5BW02;
        int i2;
        ArrayList list;
        long l5;
        long l6;
        int i3 = obj39;
        i2 = i3 & 128 != 0 ? i : i12;
        if (i3 & 256 != 0) {
            arrayList = new ArrayList();
            list = arrayList;
        } else {
            list = defaultConstructorMarker13;
        }
        if (i3 & 512 != 0) {
            l5 = zero-F1C5BW02;
        } else {
            l5 = obj35;
        }
        if (i3 &= 1024 != 0) {
            l6 = zero-F1C5BW0;
        } else {
            l6 = obj37;
        }
        super(l, obj4, l3, obj6, z5, obj8, i7, obj10, list9, l10, l11, i2, list, l5, obj17, l6, obj19, 0);
    }

    public PointerInputEventData(long l, long l2, long l3, long l4, boolean z5, float f6, int i7, boolean z8, List list9, long l10, long l11, DefaultConstructorMarker defaultConstructorMarker12) {
        super(l, l2, l3, l4, z5, f6, i7, z8, list9, l10, l11, defaultConstructorMarker12, obj13, obj14, obj15, obj16, obj17);
    }

    public static androidx.compose.ui.input.pointer.PointerInputEventData copy-rc8HELY$default(androidx.compose.ui.input.pointer.PointerInputEventData pointerInputEventData, long l2, long l3, long l4, long l5, boolean z6, float f7, int i8, boolean z9, List list10, long l11, long l12, int i13, Object object14) {
        long originalEventPosition;
        long l;
        long scrollDelta;
        long uptime;
        long positionOnScreen;
        long position;
        boolean down;
        float pressure;
        int type;
        boolean activeHover;
        List historical;
        long l6;
        long obj18;
        long obj32;
        long obj34;
        Object obj = pointerInputEventData;
        int i = obj35;
        l = i & 1 != 0 ? obj.id : l2;
        uptime = i & 2 != 0 ? obj.uptime : l4;
        positionOnScreen = i & 4 != 0 ? obj.positionOnScreen : z6;
        position = i & 8 != 0 ? obj.position : i8;
        down = i & 16 != 0 ? obj.down : list10;
        pressure = i & 32 != 0 ? obj.pressure : l11;
        type = i & 64 != 0 ? obj.type : l12;
        activeHover = i & 128 != 0 ? obj.activeHover : i13;
        historical = i & 256 != 0 ? obj.historical : object14;
        scrollDelta = i & 512 != 0 ? obj.scrollDelta : obj31;
        if (i &= 1024 != 0) {
            obj32 = obj18;
            obj34 = originalEventPosition;
        } else {
            obj34 = obj33;
            obj32 = scrollDelta;
        }
        return obj.copy-rc8HELY(l6, l4, uptime, z6, positionOnScreen, i8, position, list10, down, pressure, type);
    }

    public final long component1-J3iCeTQ() {
        return this.id;
    }

    public final long component10-F1C5BW0() {
        return this.scrollDelta;
    }

    public final long component11-F1C5BW0() {
        return this.originalEventPosition;
    }

    public final long component2() {
        return this.uptime;
    }

    public final long component3-F1C5BW0() {
        return this.positionOnScreen;
    }

    public final long component4-F1C5BW0() {
        return this.position;
    }

    public final boolean component5() {
        return this.down;
    }

    public final float component6() {
        return this.pressure;
    }

    public final int component7-T8wyACA() {
        return this.type;
    }

    public final boolean component8() {
        return this.activeHover;
    }

    public final List<androidx.compose.ui.input.pointer.HistoricalChange> component9() {
        return this.historical;
    }

    public final androidx.compose.ui.input.pointer.PointerInputEventData copy-rc8HELY(long l, long l2, long l3, long l4, boolean z5, float f6, int i7, boolean z8, List<androidx.compose.ui.input.pointer.HistoricalChange> list9, long l10, long l11) {
        PointerInputEventData pointerInputEventData = new PointerInputEventData(l, obj2, l3, obj4, z5, obj6, i7, obj8, list9, l10, l11, obj31, obj32, obj33, obj15, obj35, obj17, 0);
        return pointerInputEventData;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof PointerInputEventData == null) {
            return i2;
        }
        Object obj = object;
        if (!PointerId.equals-impl0(this.id, obj4)) {
            return i2;
        }
        if (Long.compare(uptime, uptime2) != 0) {
            return i2;
        }
        if (!Offset.equals-impl0(this.positionOnScreen, obj4)) {
            return i2;
        }
        if (!Offset.equals-impl0(this.position, obj4)) {
            return i2;
        }
        if (this.down != obj.down) {
            return i2;
        }
        if (Float.compare(this.pressure, obj.pressure) != 0) {
            return i2;
        }
        if (!PointerType.equals-impl0(this.type, obj.type)) {
            return i2;
        }
        if (this.activeHover != obj.activeHover) {
            return i2;
        }
        List historical2 = obj.historical;
        if (!Intrinsics.areEqual(this.historical, historical2)) {
            return i2;
        }
        if (!Offset.equals-impl0(this.scrollDelta, historical2)) {
            return i2;
        }
        if (!Offset.equals-impl0(this.originalEventPosition, historical2)) {
            return i2;
        }
        return i;
    }

    public final boolean getActiveHover() {
        return this.activeHover;
    }

    public final boolean getDown() {
        return this.down;
    }

    public final List<androidx.compose.ui.input.pointer.HistoricalChange> getHistorical() {
        return this.historical;
    }

    public final long getId-J3iCeTQ() {
        return this.id;
    }

    public final long getOriginalEventPosition-F1C5BW0() {
        return this.originalEventPosition;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final long getPositionOnScreen-F1C5BW0() {
        return this.positionOnScreen;
    }

    public final float getPressure() {
        return this.pressure;
    }

    public final long getScrollDelta-F1C5BW0() {
        return this.scrollDelta;
    }

    public final int getType-T8wyACA() {
        return this.type;
    }

    public final long getUptime() {
        return this.uptime;
    }

    public int hashCode() {
        return i10 += i31;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PointerInputEventData(id=").append(PointerId.toString-impl(this.id)).append(", uptime=").append(this.uptime).append(", positionOnScreen=").append(Offset.toString-impl(this.positionOnScreen)).append(", position=").append(Offset.toString-impl(this.position)).append(", down=").append(this.down).append(", pressure=").append(this.pressure).append(", type=").append(PointerType.toString-impl(this.type)).append(", activeHover=").append(this.activeHover).append(", historical=").append(this.historical).append(", scrollDelta=").append(Offset.toString-impl(this.scrollDelta)).append(", originalEventPosition=").append(Offset.toString-impl(this.originalEventPosition)).append(')');
        return stringBuilder.toString();
    }
}
