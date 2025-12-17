package androidx.compose.material3.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008 \u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J$\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000c2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&J$\u0010\u001e\u001a\u00020\u000c2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u000c2\u000c\u0008\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004J$\u0010\u001e\u001a\u00020\u000c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u000c2\u000c\u0008\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001cH&J\u0016\u0010%\u001a\u00020&2\u000c\u0008\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0012H&J\u0010\u0010(\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0012H&J\u0018\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H&J\u0010\u0010(\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001cH&J\u0018\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u0007H&J\u001a\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u000c2\u0006\u0010\u001d\u001a\u00020\u000cH&J\u0018\u0010.\u001a\u00020\"2\u0006\u0010+\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u0007H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00010\u000bX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R$\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u000c0\u00170\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019¨\u00060", d2 = {"Landroidx/compose/material3/internal/CalendarModel;", "", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/util/Locale;)V", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "formatterCache", "", "", "getFormatterCache$material3_release", "()Ljava/util/Map;", "getLocale", "()Ljava/util/Locale;", "today", "Landroidx/compose/material3/internal/CalendarDate;", "getToday", "()Landroidx/compose/material3/internal/CalendarDate;", "weekdayNames", "", "Lkotlin/Pair;", "getWeekdayNames", "()Ljava/util/List;", "formatWithPattern", "utcTimeMillis", "", "pattern", "formatWithSkeleton", "date", "skeleton", "month", "Landroidx/compose/material3/internal/CalendarMonth;", "getCanonicalDate", "timeInMillis", "getDateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "getDayOfWeek", "getMonth", "year", "minusMonths", "from", "subtractedMonthsCount", "parse", "plusMonths", "addedMonthsCount", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CalendarModel {

    public static final int $stable = 8;
    private final Map<String, Object> formatterCache;
    private final Locale locale;
    static {
        final int i = 8;
    }

    public CalendarModel(Locale locale) {
        super();
        this.locale = locale;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.formatterCache = (Map)linkedHashMap;
    }

    public static String formatWithSkeleton$default(androidx.compose.material3.internal.CalendarModel calendarModel, androidx.compose.material3.internal.CalendarDate calendarDate2, String string3, Locale locale4, int i5, Object object6) {
        Locale obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 4 != 0) {
                obj3 = calendarModel.locale;
            }
            return calendarModel.formatWithSkeleton(calendarDate2, string3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatWithSkeleton");
        throw obj0;
    }

    public static String formatWithSkeleton$default(androidx.compose.material3.internal.CalendarModel calendarModel, androidx.compose.material3.internal.CalendarMonth calendarMonth2, String string3, Locale locale4, int i5, Object object6) {
        Locale obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 4 != 0) {
                obj3 = calendarModel.locale;
            }
            return calendarModel.formatWithSkeleton(calendarMonth2, string3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatWithSkeleton");
        throw obj0;
    }

    public static androidx.compose.material3.internal.DateInputFormat getDateInputFormat$default(androidx.compose.material3.internal.CalendarModel calendarModel, Locale locale2, int i3, Object object4) {
        Locale obj1;
        if (object4 != null) {
        } else {
            if (i3 &= 1 != 0) {
                obj1 = calendarModel.locale;
            }
            return calendarModel.getDateInputFormat(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDateInputFormat");
        throw obj0;
    }

    public abstract String formatWithPattern(long l, String string2, Locale locale3);

    public final String formatWithSkeleton(androidx.compose.material3.internal.CalendarDate date, String skeleton, Locale locale) {
        return CalendarModel_androidKt.formatWithSkeleton(date.getUtcTimeMillis(), obj1, skeleton, locale);
    }

    public final String formatWithSkeleton(androidx.compose.material3.internal.CalendarMonth month, String skeleton, Locale locale) {
        return CalendarModel_androidKt.formatWithSkeleton(month.getStartUtcTimeMillis(), obj1, skeleton, locale);
    }

    public abstract androidx.compose.material3.internal.CalendarDate getCanonicalDate(long l);

    public abstract androidx.compose.material3.internal.DateInputFormat getDateInputFormat(Locale locale);

    public abstract int getDayOfWeek(androidx.compose.material3.internal.CalendarDate calendarDate);

    public abstract int getFirstDayOfWeek();

    public final Map<String, Object> getFormatterCache$material3_release() {
        return this.formatterCache;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public abstract androidx.compose.material3.internal.CalendarMonth getMonth(int i, int i2);

    public abstract androidx.compose.material3.internal.CalendarMonth getMonth(long l);

    public abstract androidx.compose.material3.internal.CalendarMonth getMonth(androidx.compose.material3.internal.CalendarDate calendarDate);

    public abstract androidx.compose.material3.internal.CalendarDate getToday();

    public abstract List<Pair<String, String>> getWeekdayNames();

    public abstract androidx.compose.material3.internal.CalendarMonth minusMonths(androidx.compose.material3.internal.CalendarMonth calendarMonth, int i2);

    public abstract androidx.compose.material3.internal.CalendarDate parse(String string, String string2);

    public abstract androidx.compose.material3.internal.CalendarMonth plusMonths(androidx.compose.material3.internal.CalendarMonth calendarMonth, int i2);
}
