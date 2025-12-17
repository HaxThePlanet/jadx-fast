package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0008\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/material3/SelectedRangeInfo;", "", "gridStartCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "gridEndCoordinates", "firstIsSelectionStart", "", "lastIsSelectionEnd", "(JJZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstIsSelectionStart", "()Z", "getGridEndCoordinates-nOcc-ac", "()J", "J", "getGridStartCoordinates-nOcc-ac", "getLastIsSelectionEnd", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectedRangeInfo {

    public static final int $stable;
    public static final androidx.compose.material3.SelectedRangeInfo.Companion Companion;
    private final boolean firstIsSelectionStart;
    private final long gridEndCoordinates;
    private final long gridStartCoordinates;
    private final boolean lastIsSelectionEnd;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008¨\u0006\n", d2 = {"Landroidx/compose/material3/SelectedRangeInfo$Companion;", "", "()V", "calculateRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "month", "Landroidx/compose/material3/internal/CalendarMonth;", "startDate", "Landroidx/compose/material3/internal/CalendarDate;", "endDate", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.material3.SelectedRangeInfo calculateRangeInfo(CalendarMonth month, CalendarDate startDate, CalendarDate endDate) {
            int i;
            int daysFromStartOfWeekToFirstOfMonth;
            int cmp;
            int dayOfMonth;
            int i2;
            long startUtcTimeMillis;
            int numberOfDays;
            int i3;
            if (Long.compare(utcTimeMillis, startUtcTimeMillis) <= 0) {
                if (Long.compare(utcTimeMillis2, startUtcTimeMillis) < 0) {
                } else {
                    dayOfMonth = 0;
                    int i7 = 1;
                    i = Long.compare(utcTimeMillis3, startUtcTimeMillis2) >= 0 ? i7 : dayOfMonth;
                    final int i12 = i;
                    final long endUtcTimeMillis = month.getEndUtcTimeMillis();
                    i3 = Long.compare(utcTimeMillis4, endUtcTimeMillis) <= 0 ? i7 : dayOfMonth;
                    if (i12 != 0) {
                        i4 -= i7;
                    } else {
                        daysFromStartOfWeekToFirstOfMonth = month.getDaysFromStartOfWeekToFirstOfMonth();
                    }
                    if (i3 != 0) {
                        i6 -= i7;
                    } else {
                        i5 -= i7;
                    }
                }
                SelectedRangeInfo selectedRangeInfo = new SelectedRangeInfo(IntOffsetKt.IntOffset(daysFromStartOfWeekToFirstOfMonth % 7, daysFromStartOfWeekToFirstOfMonth / 7), endUtcTimeMillis, IntOffsetKt.IntOffset(i2 % 7, i2 / 7), obj7, i12, i3, 0);
                return selectedRangeInfo;
            }
            return null;
        }
    }
    static {
        SelectedRangeInfo.Companion companion = new SelectedRangeInfo.Companion(0);
        SelectedRangeInfo.Companion = companion;
    }

    private SelectedRangeInfo(long gridStartCoordinates, long gridEndCoordinates, boolean firstIsSelectionStart, boolean lastIsSelectionEnd) {
        super();
        this.gridStartCoordinates = gridStartCoordinates;
        this.gridEndCoordinates = firstIsSelectionStart;
        this.firstIsSelectionStart = obj5;
        this.lastIsSelectionEnd = obj6;
    }

    public SelectedRangeInfo(long l, long l2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(l, l2, z3, z4, defaultConstructorMarker5, obj6);
    }

    public final boolean getFirstIsSelectionStart() {
        return this.firstIsSelectionStart;
    }

    public final long getGridEndCoordinates-nOcc-ac() {
        return this.gridEndCoordinates;
    }

    public final long getGridStartCoordinates-nOcc-ac() {
        return this.gridStartCoordinates;
    }

    public final boolean getLastIsSelectionEnd() {
        return this.lastIsSelectionEnd;
    }
}
