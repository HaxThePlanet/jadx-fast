package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0080\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0008HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001dJ\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000b¨\u0006&", d2 = {"Landroidx/compose/material3/internal/CalendarMonth;", "", "year", "", "month", "numberOfDays", "daysFromStartOfWeekToFirstOfMonth", "startUtcTimeMillis", "", "(IIIIJ)V", "getDaysFromStartOfWeekToFirstOfMonth", "()I", "endUtcTimeMillis", "getEndUtcTimeMillis", "()J", "getMonth", "getNumberOfDays", "getStartUtcTimeMillis", "getYear", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "format", "", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "skeleton", "hashCode", "indexIn", "years", "Lkotlin/ranges/IntRange;", "toString", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CalendarMonth {

    public static final int $stable;
    private final int daysFromStartOfWeekToFirstOfMonth;
    private final long endUtcTimeMillis;
    private final int month;
    private final int numberOfDays;
    private final long startUtcTimeMillis;
    private final int year;
    static {
    }

    public CalendarMonth(int year, int month, int numberOfDays, int daysFromStartOfWeekToFirstOfMonth, long startUtcTimeMillis) {
        super();
        this.year = year;
        this.month = month;
        this.numberOfDays = numberOfDays;
        this.daysFromStartOfWeekToFirstOfMonth = daysFromStartOfWeekToFirstOfMonth;
        this.startUtcTimeMillis = startUtcTimeMillis;
        this.endUtcTimeMillis = i -= i4;
    }

    public static androidx.compose.material3.internal.CalendarMonth copy$default(androidx.compose.material3.internal.CalendarMonth calendarMonth, int i2, int i3, int i4, int i5, long l6, int i7, Object object8) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        long obj5;
        if (object8 & 1 != 0) {
            obj1 = calendarMonth.year;
        }
        if (object8 & 2 != 0) {
            obj2 = calendarMonth.month;
        }
        if (object8 & 4 != 0) {
            obj3 = calendarMonth.numberOfDays;
        }
        int obj8 = object8 & 8;
        if (obj8 != null) {
            obj4 = calendarMonth.daysFromStartOfWeekToFirstOfMonth;
        }
        if (object8 &= 16 != 0) {
            obj5 = calendarMonth.startUtcTimeMillis;
        }
        return calendarMonth.copy(obj1, obj2, obj3, obj4, obj5);
    }

    public final int component1() {
        return this.year;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.numberOfDays;
    }

    public final int component4() {
        return this.daysFromStartOfWeekToFirstOfMonth;
    }

    public final long component5() {
        return this.startUtcTimeMillis;
    }

    public final androidx.compose.material3.internal.CalendarMonth copy(int i, int i2, int i3, int i4, long l5) {
        CalendarMonth calendarMonth = new CalendarMonth(i, i2, i3, i4, l5, obj6);
        return calendarMonth;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof CalendarMonth) {
            return i2;
        }
        Object obj = object;
        if (this.year != obj.year) {
            return i2;
        }
        if (this.month != obj.month) {
            return i2;
        }
        if (this.numberOfDays != obj.numberOfDays) {
            return i2;
        }
        if (this.daysFromStartOfWeekToFirstOfMonth != obj.daysFromStartOfWeekToFirstOfMonth) {
            return i2;
        }
        if (Long.compare(startUtcTimeMillis, startUtcTimeMillis2) != 0) {
            return i2;
        }
        return i;
    }

    public final String format(androidx.compose.material3.internal.CalendarModel calendarModel, String skeleton) {
        return calendarModel.formatWithSkeleton(this, skeleton, calendarModel.getLocale());
    }

    public final int getDaysFromStartOfWeekToFirstOfMonth() {
        return this.daysFromStartOfWeekToFirstOfMonth;
    }

    public final long getEndUtcTimeMillis() {
        return this.endUtcTimeMillis;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getNumberOfDays() {
        return this.numberOfDays;
    }

    public final long getStartUtcTimeMillis() {
        return this.startUtcTimeMillis;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return i4 += i13;
    }

    public final int indexIn(IntRange years) {
        return i3--;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CalendarMonth(year=").append(this.year).append(", month=").append(this.month).append(", numberOfDays=").append(this.numberOfDays).append(", daysFromStartOfWeekToFirstOfMonth=").append(this.daysFromStartOfWeekToFirstOfMonth).append(", startUtcTimeMillis=").append(this.startUtcTimeMillis).append(')').toString();
    }
}
