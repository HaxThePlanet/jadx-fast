package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel_androidKt;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0096\u0002J-\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u00132\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016H\u0016¢\u0006\u0002\u0010\u001bJ\u0008\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000b¨\u0006\u001e", d2 = {"Landroidx/compose/material3/DatePickerFormatterImpl;", "Landroidx/compose/material3/DatePickerFormatter;", "yearSelectionSkeleton", "", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "formatterCache", "", "", "getSelectedDateDescriptionSkeleton", "()Ljava/lang/String;", "getSelectedDateSkeleton", "getYearSelectionSkeleton", "equals", "", "other", "formatDate", "dateMillis", "", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "forContentDescription", "(Ljava/lang/Long;Ljava/util/Locale;Z)Ljava/lang/String;", "formatMonthYear", "monthMillis", "(Ljava/lang/Long;Ljava/util/Locale;)Ljava/lang/String;", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DatePickerFormatterImpl implements androidx.compose.material3.DatePickerFormatter {

    private final Map<String, Object> formatterCache;
    private final String selectedDateDescriptionSkeleton;
    private final String selectedDateSkeleton;
    private final String yearSelectionSkeleton;
    public DatePickerFormatterImpl(String yearSelectionSkeleton, String selectedDateSkeleton, String selectedDateDescriptionSkeleton) {
        super();
        this.yearSelectionSkeleton = yearSelectionSkeleton;
        this.selectedDateSkeleton = selectedDateSkeleton;
        this.selectedDateDescriptionSkeleton = selectedDateDescriptionSkeleton;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.formatterCache = (Map)linkedHashMap;
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public boolean equals(Object other) {
        final int i2 = 0;
        if (!other instanceof DatePickerFormatterImpl) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.yearSelectionSkeleton, obj.yearSelectionSkeleton)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.selectedDateSkeleton, obj2.selectedDateSkeleton)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.selectedDateDescriptionSkeleton, obj3.selectedDateDescriptionSkeleton)) {
            return i2;
        }
        return 1;
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public String formatDate(Long dateMillis, Locale locale, boolean forContentDescription) {
        String selectedDateDescriptionSkeleton;
        if (dateMillis == null) {
            return null;
        }
        selectedDateDescriptionSkeleton = forContentDescription ? this.selectedDateDescriptionSkeleton : this.selectedDateSkeleton;
        return CalendarModel_androidKt.formatWithSkeleton(dateMillis.longValue(), obj1, selectedDateDescriptionSkeleton, locale);
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public String formatMonthYear(Long monthMillis, Locale locale) {
        if (monthMillis == null) {
            return null;
        }
        return CalendarModel_androidKt.formatWithSkeleton(monthMillis.longValue(), obj1, this.yearSelectionSkeleton, locale);
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public final String getSelectedDateDescriptionSkeleton() {
        return this.selectedDateDescriptionSkeleton;
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public final String getSelectedDateSkeleton() {
        return this.selectedDateSkeleton;
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public final String getYearSelectionSkeleton() {
        return this.yearSelectionSkeleton;
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public int hashCode() {
        return result += i6;
    }
}
