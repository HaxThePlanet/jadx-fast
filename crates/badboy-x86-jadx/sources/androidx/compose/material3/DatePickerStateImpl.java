package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB=\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\u0010\u000c\u001a\u00060\rj\u0002`\u000e¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00048V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 ", d2 = {"Landroidx/compose/material3/DatePickerStateImpl;", "Landroidx/compose/material3/BaseDatePickerStateImpl;", "Landroidx/compose/material3/DatePickerState;", "initialSelectedDateMillis", "", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Ljava/util/Locale;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_displayMode", "Landroidx/compose/runtime/MutableState;", "_selectedDate", "Landroidx/compose/material3/internal/CalendarDate;", "displayMode", "getDisplayMode-jFl-4v0", "()I", "setDisplayMode-vCnGnXg", "(I)V", "dateMillis", "selectedDateMillis", "getSelectedDateMillis", "()Ljava/lang/Long;", "setSelectedDateMillis", "(Ljava/lang/Long;)V", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DatePickerStateImpl extends androidx.compose.material3.BaseDatePickerStateImpl implements androidx.compose.material3.DatePickerState {

    public static final androidx.compose.material3.DatePickerStateImpl.Companion Companion;
    private MutableState<androidx.compose.material3.DisplayMode> _displayMode;
    private MutableState<CalendarDate> _selectedDate;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\u0008\u001a\u00060\tj\u0002`\n¨\u0006\u000b", d2 = {"Landroidx/compose/material3/DatePickerStateImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DatePickerStateImpl;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material3.DatePickerStateImpl, Object> Saver(androidx.compose.material3.SelectableDates selectableDates, Locale locale) {
            DatePickerStateImpl.Companion.Saver.2 anon = new DatePickerStateImpl.Companion.Saver.2(selectableDates, locale);
            return ListSaverKt.listSaver((Function2)DatePickerStateImpl.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        DatePickerStateImpl.Companion companion = new DatePickerStateImpl.Companion(0);
        DatePickerStateImpl.Companion = companion;
    }

    private DatePickerStateImpl(Long initialSelectedDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, androidx.compose.material3.SelectableDates selectableDates, Locale locale) {
        CalendarDate date;
        boolean contains;
        super(initialDisplayedMonthMillis, yearRange, selectableDates, locale);
        int i = 0;
        if (initialSelectedDateMillis != null) {
            date = getCalendarModel().getCanonicalDate(initialSelectedDateMillis.longValue());
            if (!yearRange.contains(date.getYear())) {
            } else {
                int i3 = 2;
                this._selectedDate = SnapshotStateKt.mutableStateOf$default(date, i, i3, i);
                this._displayMode = SnapshotStateKt.mutableStateOf$default(DisplayMode.box-impl(initialDisplayMode), i, i3, i);
            }
            int i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The provided initial date's year (").append(date.getYear()).append(") is out of the years range of ").append(yearRange).append('.').toString().toString());
            throw illegalArgumentException;
        }
        date = i;
    }

    public DatePickerStateImpl(Long long, Long long2, IntRange intRange3, int i4, androidx.compose.material3.SelectableDates selectableDates5, Locale locale6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(long, long2, intRange3, i4, selectableDates5, locale6);
    }

    @Override // androidx.compose.material3.BaseDatePickerStateImpl
    public int getDisplayMode-jFl-4v0() {
        return (DisplayMode)this._displayMode.getValue().unbox-impl();
    }

    @Override // androidx.compose.material3.BaseDatePickerStateImpl
    public Long getSelectedDateMillis() {
        Long valueOf;
        Object value = this._selectedDate.getValue();
        if ((CalendarDate)value != null) {
            valueOf = Long.valueOf((CalendarDate)value.getUtcTimeMillis());
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    @Override // androidx.compose.material3.BaseDatePickerStateImpl
    public void setDisplayMode-vCnGnXg(int displayMode) {
        Long selectedDateMillis;
        int i;
        long startUtcTimeMillis;
        selectedDateMillis = getSelectedDateMillis();
        if (selectedDateMillis != null) {
            i = 0;
            setDisplayedMonthMillis(getCalendarModel().getMonth((Number)selectedDateMillis.longValue()).getStartUtcTimeMillis());
        }
        this._displayMode.setValue(DisplayMode.box-impl(displayMode));
    }

    @Override // androidx.compose.material3.BaseDatePickerStateImpl
    public void setSelectedDateMillis(Long dateMillis) {
        Object date;
        MutableState _selectedDate;
        int year;
        if (dateMillis != null) {
            date = getCalendarModel().getCanonicalDate(dateMillis.longValue());
            if (!getYearRange().contains(date.getYear())) {
            } else {
                this._selectedDate.setValue(date);
            }
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The provided date's year (").append(date.getYear()).append(") is out of the years range of ").append(getYearRange()).append('.').toString().toString());
            throw illegalArgumentException;
        }
        this._selectedDate.setValue(0);
    }
}
