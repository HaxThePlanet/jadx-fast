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
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008\u0003\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%BG\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f¢\u0006\u0002\u0010\u0010J!\u0010 \u001a\u00020!2\u0008\u0010\"\u001a\u0004\u0018\u00010\u00042\u0008\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010$R\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u001d\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006&", d2 = {"Landroidx/compose/material3/DateRangePickerStateImpl;", "Landroidx/compose/material3/BaseDatePickerStateImpl;", "Landroidx/compose/material3/DateRangePickerState;", "initialSelectedStartDateMillis", "", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Ljava/util/Locale;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_displayMode", "Landroidx/compose/runtime/MutableState;", "_selectedEndDate", "Landroidx/compose/material3/internal/CalendarDate;", "_selectedStartDate", "displayMode", "getDisplayMode-jFl-4v0", "()I", "setDisplayMode-vCnGnXg", "(I)V", "selectedEndDateMillis", "getSelectedEndDateMillis", "()Ljava/lang/Long;", "selectedStartDateMillis", "getSelectedStartDateMillis", "setSelection", "", "startDateMillis", "endDateMillis", "(Ljava/lang/Long;Ljava/lang/Long;)V", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DateRangePickerStateImpl extends androidx.compose.material3.BaseDatePickerStateImpl implements androidx.compose.material3.DateRangePickerState {

    public static final androidx.compose.material3.DateRangePickerStateImpl.Companion Companion;
    private MutableState<androidx.compose.material3.DisplayMode> _displayMode;
    private MutableState<CalendarDate> _selectedEndDate;
    private MutableState<CalendarDate> _selectedStartDate;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\u0008\u001a\u00060\tj\u0002`\n¨\u0006\u000b", d2 = {"Landroidx/compose/material3/DateRangePickerStateImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DateRangePickerStateImpl;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material3.DateRangePickerStateImpl, Object> Saver(androidx.compose.material3.SelectableDates selectableDates, Locale locale) {
            DateRangePickerStateImpl.Companion.Saver.2 anon = new DateRangePickerStateImpl.Companion.Saver.2(selectableDates, locale);
            return ListSaverKt.listSaver((Function2)DateRangePickerStateImpl.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        DateRangePickerStateImpl.Companion companion = new DateRangePickerStateImpl.Companion(0);
        DateRangePickerStateImpl.Companion = companion;
    }

    private DateRangePickerStateImpl(Long initialSelectedStartDateMillis, Long initialSelectedEndDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, androidx.compose.material3.SelectableDates selectableDates, Locale locale) {
        super(initialDisplayedMonthMillis, yearRange, selectableDates, locale);
        int i = 0;
        final int i2 = 2;
        this._selectedStartDate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        this._selectedEndDate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        setSelection(initialSelectedStartDateMillis, initialSelectedEndDateMillis);
        this._displayMode = SnapshotStateKt.mutableStateOf$default(DisplayMode.box-impl(initialDisplayMode), i, i2, i);
    }

    public DateRangePickerStateImpl(Long long, Long long2, Long long3, IntRange intRange4, int i5, androidx.compose.material3.SelectableDates selectableDates6, Locale locale7, DefaultConstructorMarker defaultConstructorMarker8) {
        super(long, long2, long3, intRange4, i5, selectableDates6, locale7);
    }

    @Override // androidx.compose.material3.BaseDatePickerStateImpl
    public int getDisplayMode-jFl-4v0() {
        return (DisplayMode)this._displayMode.getValue().unbox-impl();
    }

    @Override // androidx.compose.material3.BaseDatePickerStateImpl
    public Long getSelectedEndDateMillis() {
        Long valueOf;
        Object value = this._selectedEndDate.getValue();
        if ((CalendarDate)value != null) {
            valueOf = Long.valueOf((CalendarDate)value.getUtcTimeMillis());
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    @Override // androidx.compose.material3.BaseDatePickerStateImpl
    public Long getSelectedStartDateMillis() {
        Long valueOf;
        Object value = this._selectedStartDate.getValue();
        if ((CalendarDate)value != null) {
            valueOf = Long.valueOf((CalendarDate)value.getUtcTimeMillis());
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    @Override // androidx.compose.material3.BaseDatePickerStateImpl
    public void setDisplayMode-vCnGnXg(int displayMode) {
        Long selectedStartDateMillis;
        int i;
        long startUtcTimeMillis;
        selectedStartDateMillis = getSelectedStartDateMillis();
        if (selectedStartDateMillis != null) {
            i = 0;
            setDisplayedMonthMillis(getCalendarModel().getMonth((Number)selectedStartDateMillis.longValue()).getStartUtcTimeMillis());
        }
        this._displayMode.setValue(DisplayMode.box-impl(displayMode));
    }

    @Override // androidx.compose.material3.BaseDatePickerStateImpl
    public void setSelection(Long startDateMillis, Long endDateMillis) {
        CalendarDate canonicalDate;
        CalendarDate canonicalDate2;
        long longValue;
        int i2;
        CalendarDate utcTimeMillis;
        int i;
        boolean contains;
        int year;
        if (startDateMillis != null) {
            canonicalDate2 = getCalendarModel().getCanonicalDate(startDateMillis.longValue());
        } else {
            canonicalDate2 = canonicalDate;
        }
        if (endDateMillis != null) {
            canonicalDate = getCalendarModel().getCanonicalDate(endDateMillis.longValue());
        } else {
        }
        i2 = 46;
        String str = ") is out of the years range of ";
        if (canonicalDate2 != null) {
            utcTimeMillis = canonicalDate2;
            i = 0;
            if (!getYearRange().contains(utcTimeMillis.getYear())) {
            } else {
            }
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder.append("The provided start date year (").append(utcTimeMillis.getYear()).append(str).append(getYearRange()).append(i2).toString().toString());
            throw illegalArgumentException3;
        }
        if (canonicalDate != null) {
            utcTimeMillis = canonicalDate;
            i = 0;
            if (!getYearRange().contains(utcTimeMillis.getYear())) {
            } else {
            }
            int i6 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(stringBuilder2.append("The provided end date year (").append(utcTimeMillis.getYear()).append(str).append(getYearRange()).append(i2).toString().toString());
            throw illegalArgumentException4;
        }
        if (canonicalDate != null) {
            if (canonicalDate2 == null) {
            } else {
                i2 = Long.compare(utcTimeMillis2, utcTimeMillis) <= 0 ? 1 : 0;
                if (i2 == 0) {
                } else {
                }
                int i4 = 0;
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("The provided end date appears before the start date.".toString());
                throw illegalArgumentException2;
            }
            int i3 = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("An end date was provided without a start date.".toString());
            throw illegalArgumentException;
        }
        this._selectedStartDate.setValue(canonicalDate2);
        this._selectedEndDate.setValue(canonicalDate);
    }
}
