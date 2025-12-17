package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u001f\u0008\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016R&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/ui/input/pointer/HistoricalChange;", "", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "originalEventPosition", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getOriginalEventPosition-F1C5BW0$ui_release", "()J", "J", "getPosition-F1C5BW0", "getUptimeMillis", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HistoricalChange {

    public static final int $stable;
    private long originalEventPosition;
    private final long position;
    private final long uptimeMillis;
    static {
    }

    private HistoricalChange(long uptimeMillis, long position) {
        super();
        this.uptimeMillis = uptimeMillis;
        this.position = obj5;
        this.originalEventPosition = Offset.Companion.getZero-F1C5BW0();
    }

    private HistoricalChange(long uptimeMillis, long position, long originalEventPosition) {
        final Object obj = this;
        super(uptimeMillis, obj2, originalEventPosition, obj4, 0);
        obj.originalEventPosition = obj11;
    }

    public HistoricalChange(long l, long l2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, l2, l3, defaultConstructorMarker4, obj5, obj6);
    }

    public HistoricalChange(long l, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(l, l2, defaultConstructorMarker3, obj4);
    }

    public final long getOriginalEventPosition-F1C5BW0$ui_release() {
        return this.originalEventPosition;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("HistoricalChange(uptimeMillis=").append(this.uptimeMillis).append(", position=").append(Offset.toString-impl(this.position)).append(')').toString();
    }
}
