package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008!\u0018\u00002\u00020\u0001B+\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\u0008\u001a\u00060\tj\u0002`\n¢\u0006\u0002\u0010\u000bR\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006\u001d", d2 = {"Landroidx/compose/material3/BaseDatePickerStateImpl;", "", "initialDisplayedMonthMillis", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/lang/Long;Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Ljava/util/Locale;)V", "_displayedMonth", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/internal/CalendarMonth;", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "getCalendarModel", "()Landroidx/compose/material3/internal/CalendarModel;", "monthMillis", "displayedMonthMillis", "getDisplayedMonthMillis", "()J", "setDisplayedMonthMillis", "(J)V", "getSelectableDates", "()Landroidx/compose/material3/SelectableDates;", "getYearRange", "()Lkotlin/ranges/IntRange;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseDatePickerStateImpl {

    public static final int $stable;
    private MutableState<CalendarMonth> _displayedMonth;
    private final CalendarModel calendarModel;
    private final androidx.compose.material3.SelectableDates selectableDates;
    private final IntRange yearRange;
    static {
    }

    public BaseDatePickerStateImpl(Long initialDisplayedMonthMillis, IntRange yearRange, androidx.compose.material3.SelectableDates selectableDates, Locale locale) {
        CalendarMonth month;
        boolean contains;
        int year;
        super();
        this.yearRange = yearRange;
        this.selectableDates = selectableDates;
        this.calendarModel = CalendarModel_androidKt.createCalendarModel(locale);
        if (initialDisplayedMonthMillis != null) {
            month = this.calendarModel.getMonth(initialDisplayedMonthMillis.longValue());
            if (!this.yearRange.contains(month.getYear())) {
            } else {
                int i3 = 0;
                this._displayedMonth = SnapshotStateKt.mutableStateOf$default(month, i3, 2, i3);
            }
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The initial display month's year (").append(month.getYear()).append(") is out of the years range of ").append(this.yearRange).append('.').toString().toString());
            throw illegalArgumentException;
        }
        month = this.calendarModel.getMonth(this.calendarModel.getToday());
    }

    public final CalendarModel getCalendarModel() {
        return this.calendarModel;
    }

    public final long getDisplayedMonthMillis() {
        return (CalendarMonth)this._displayedMonth.getValue().getStartUtcTimeMillis();
    }

    public final androidx.compose.material3.SelectableDates getSelectableDates() {
        return this.selectableDates;
    }

    public final IntRange getYearRange() {
        return this.yearRange;
    }

    public final void setDisplayedMonthMillis(long monthMillis) {
        CalendarMonth month = this.calendarModel.getMonth(monthMillis);
        if (!this.yearRange.contains(month.getYear())) {
        } else {
            this._displayedMonth.setValue(month);
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The display month's year (").append(month.getYear()).append(") is out of the years range of ").append(this.yearRange).append('.').toString().toString());
        throw illegalArgumentException;
    }
}
