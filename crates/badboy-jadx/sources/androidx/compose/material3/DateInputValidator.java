package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.DateInputFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J.\u0010\u001a\u001a\u00020\u000b2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060 j\u0002`!ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\u0008\u0018\u0010\u0014\"\u0004\u0008\u0019\u0010\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006$", d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "currentStartDateMillis", "", "currentEndDateMillis", "(Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCurrentEndDateMillis$material3_release", "()Ljava/lang/Long;", "setCurrentEndDateMillis$material3_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCurrentStartDateMillis$material3_release", "setCurrentStartDateMillis$material3_release", "validate", "dateToValidate", "Landroidx/compose/material3/internal/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "validate-XivgLIo", "(Landroidx/compose/material3/internal/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DateInputValidator {

    public static final int $stable;
    private Long currentEndDateMillis;
    private Long currentStartDateMillis;
    private final androidx.compose.material3.DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final androidx.compose.material3.SelectableDates selectableDates;
    private final IntRange yearRange;
    static {
    }

    public DateInputValidator(IntRange yearRange, androidx.compose.material3.SelectableDates selectableDates, DateInputFormat dateInputFormat, androidx.compose.material3.DatePickerFormatter dateFormatter, String errorDatePattern, String errorDateOutOfYearRange, String errorInvalidNotAllowed, String errorInvalidRangeInput, Long currentStartDateMillis, Long currentEndDateMillis) {
        super();
        this.yearRange = yearRange;
        this.selectableDates = selectableDates;
        this.dateInputFormat = dateInputFormat;
        this.dateFormatter = dateFormatter;
        this.errorDatePattern = errorDatePattern;
        this.errorDateOutOfYearRange = errorDateOutOfYearRange;
        this.errorInvalidNotAllowed = errorInvalidNotAllowed;
        this.errorInvalidRangeInput = errorInvalidRangeInput;
        this.currentStartDateMillis = currentStartDateMillis;
        this.currentEndDateMillis = currentEndDateMillis;
    }

    public DateInputValidator(IntRange intRange, androidx.compose.material3.SelectableDates selectableDates2, DateInputFormat dateInputFormat3, androidx.compose.material3.DatePickerFormatter datePickerFormatter4, String string5, String string6, String string7, String string8, Long long9, Long long10, int i11, DefaultConstructorMarker defaultConstructorMarker12) {
        int obj10;
        int obj12;
        final int i = 0;
        obj10 = i11 & 256 != 0 ? i : obj10;
        obj12 = i11 &= 512 != 0 ? i : long10;
        super(intRange, selectableDates2, dateInputFormat3, datePickerFormatter4, string5, string6, string7, string8, obj10, obj12);
    }

    public final Long getCurrentEndDateMillis$material3_release() {
        return this.currentEndDateMillis;
    }

    public final Long getCurrentStartDateMillis$material3_release() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentEndDateMillis$material3_release(Long <set-?>) {
        this.currentEndDateMillis = <set-?>;
    }

    public final void setCurrentStartDateMillis$material3_release(Long <set-?>) {
        this.currentStartDateMillis = <set-?>;
    }

    public final String validate-XivgLIo(CalendarDate dateToValidate, int inputIdentifier, Locale locale) {
        int cmp;
        long selectableDates;
        boolean selectableYear;
        int i = 1;
        final String str2 = "format(this, *args)";
        if (dateToValidate == null) {
            String upperCase = this.dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            String format = String.format(this.errorDatePattern, Arrays.copyOf(/* result */, i));
            Intrinsics.checkNotNullExpressionValue(format, str2);
            return format;
        }
        if (!this.yearRange.contains(dateToValidate.getYear())) {
            int i5 = 0;
            int i6 = 0;
            String format2 = String.format(this.errorDateOutOfYearRange, Arrays.copyOf(/* result */, 2));
            Intrinsics.checkNotNullExpressionValue(format2, str2);
            return format2;
        }
        selectableDates = this.selectableDates;
        int i3 = 0;
        if (selectableDates.isSelectableYear(dateToValidate.getYear())) {
            if (!selectableDates.isSelectableDate(dateToValidate.getUtcTimeMillis())) {
            } else {
                if (InputIdentifier.equals-impl0(inputIdentifier, InputIdentifier.Companion.getStartDateInput-J2x2o4M())) {
                    Long currentEndDateMillis = this.currentEndDateMillis;
                    if (currentEndDateMillis != null) {
                        selectableDates = currentEndDateMillis.longValue();
                    } else {
                        selectableDates = Long.MAX_VALUE;
                    }
                    if (Long.compare(utcTimeMillis2, selectableDates) < 0 && InputIdentifier.equals-impl0(inputIdentifier, InputIdentifier.Companion.getEndDateInput-J2x2o4M())) {
                        if (InputIdentifier.equals-impl0(inputIdentifier, InputIdentifier.Companion.getEndDateInput-J2x2o4M())) {
                            Long currentStartDateMillis = this.currentStartDateMillis;
                            if (currentStartDateMillis != null) {
                                selectableDates = currentStartDateMillis.longValue();
                            } else {
                                selectableDates = Long.MIN_VALUE;
                            }
                            if (Long.compare(utcTimeMillis, selectableDates) < 0) {
                            }
                        }
                    }
                    return this.errorInvalidRangeInput;
                } else {
                }
            }
            return "";
        }
        String obj14 = String.format(this.errorInvalidNotAllowed, Arrays.copyOf(/* result */, i));
        Intrinsics.checkNotNullExpressionValue(obj14, str2);
        return obj14;
    }
}
