package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n¨\u0006 ", d2 = {"Landroidx/compose/material3/internal/CalendarDate;", "", "year", "", "month", "dayOfMonth", "utcTimeMillis", "", "(IIIJ)V", "getDayOfMonth", "()I", "getMonth", "getUtcTimeMillis", "()J", "getYear", "compareTo", "other", "component1", "component2", "component3", "component4", "copy", "equals", "", "", "format", "", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "skeleton", "hashCode", "toString", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CalendarDate implements Comparable<androidx.compose.material3.internal.CalendarDate> {

    public static final int $stable;
    private final int dayOfMonth;
    private final int month;
    private final long utcTimeMillis;
    private final int year;
    static {
    }

    public CalendarDate(int year, int month, int dayOfMonth, long utcTimeMillis) {
        super();
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.utcTimeMillis = utcTimeMillis;
    }

    public static androidx.compose.material3.internal.CalendarDate copy$default(androidx.compose.material3.internal.CalendarDate calendarDate, int i2, int i3, int i4, long l5, int i6, Object object7) {
        int obj1;
        int obj2;
        int obj3;
        long obj4;
        if (object7 & 1 != 0) {
            obj1 = calendarDate.year;
        }
        if (object7 & 2 != 0) {
            obj2 = calendarDate.month;
        }
        int obj7 = object7 & 4;
        if (obj7 != null) {
            obj3 = calendarDate.dayOfMonth;
        }
        if (object7 &= 8 != 0) {
            obj4 = calendarDate.utcTimeMillis;
        }
        return calendarDate.copy(obj1, obj2, obj3, obj4);
    }

    @Override // java.lang.Comparable
    public int compareTo(androidx.compose.material3.internal.CalendarDate other) {
        return Intrinsics.compare(this.utcTimeMillis, obj1);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        return compareTo((CalendarDate)other);
    }

    @Override // java.lang.Comparable
    public final int component1() {
        return this.year;
    }

    @Override // java.lang.Comparable
    public final int component2() {
        return this.month;
    }

    @Override // java.lang.Comparable
    public final int component3() {
        return this.dayOfMonth;
    }

    @Override // java.lang.Comparable
    public final long component4() {
        return this.utcTimeMillis;
    }

    @Override // java.lang.Comparable
    public final androidx.compose.material3.internal.CalendarDate copy(int i, int i2, int i3, long l4) {
        CalendarDate calendarDate = new CalendarDate(i, i2, i3, l4, obj5);
        return calendarDate;
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof CalendarDate) {
            return i2;
        }
        Object obj = object;
        if (this.year != obj.year) {
            return i2;
        }
        if (this.month != obj.month) {
            return i2;
        }
        if (this.dayOfMonth != obj.dayOfMonth) {
            return i2;
        }
        if (Long.compare(utcTimeMillis, utcTimeMillis2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public final String format(androidx.compose.material3.internal.CalendarModel calendarModel, String skeleton) {
        return calendarModel.formatWithSkeleton(this, skeleton, calendarModel.getLocale());
    }

    @Override // java.lang.Comparable
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    @Override // java.lang.Comparable
    public final int getMonth() {
        return this.month;
    }

    @Override // java.lang.Comparable
    public final long getUtcTimeMillis() {
        return this.utcTimeMillis;
    }

    @Override // java.lang.Comparable
    public final int getYear() {
        return this.year;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return i6 += i10;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CalendarDate(year=").append(this.year).append(", month=").append(this.month).append(", dayOfMonth=").append(this.dayOfMonth).append(", utcTimeMillis=").append(this.utcTimeMillis).append(')').toString();
    }
}
