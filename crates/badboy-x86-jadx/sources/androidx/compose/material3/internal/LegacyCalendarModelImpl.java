package androidx.compose.material3.internal;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u0014\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u0018\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0007H\u0016J\u001a\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0018\u0010*\u001a\u00020!2\u0006\u0010'\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0008\u0010,\u001a\u00020\u0011H\u0016J\u0014\u0010-\u001a\u00020#*\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0002J\u000c\u0010-\u001a\u00020#*\u00020!H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR&\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u00061", d2 = {"Landroidx/compose/material3/internal/LegacyCalendarModelImpl;", "Landroidx/compose/material3/internal/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/util/Locale;)V", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "today", "Landroidx/compose/material3/internal/CalendarDate;", "getToday", "()Landroidx/compose/material3/internal/CalendarDate;", "weekdayNames", "", "Lkotlin/Pair;", "", "getWeekdayNames", "()Ljava/util/List;", "dayInISO8601", "day", "formatWithPattern", "utcTimeMillis", "", "pattern", "getCanonicalDate", "timeInMillis", "getDateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "getDayOfWeek", "date", "getMonth", "Landroidx/compose/material3/internal/CalendarMonth;", "firstDayCalendar", "Ljava/util/Calendar;", "year", "month", "minusMonths", "from", "subtractedMonthsCount", "parse", "plusMonths", "addedMonthsCount", "toString", "toCalendar", "timeZone", "Ljava/util/TimeZone;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyCalendarModelImpl extends androidx.compose.material3.internal.CalendarModel {

    public static final int $stable = 8;
    public static final androidx.compose.material3.internal.LegacyCalendarModelImpl.Companion Companion;
    private static final TimeZone utcTimeZone;
    private final int firstDayOfWeek;
    private final List<Pair<String, String>> weekdayNames;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00082\n\u0010\u000c\u001a\u00060\rj\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00010\u0010J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00082\n\u0010\u000c\u001a\u00060\rj\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00010\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0013", d2 = {"Landroidx/compose/material3/internal/LegacyCalendarModelImpl$Companion;", "", "()V", "utcTimeZone", "Ljava/util/TimeZone;", "getUtcTimeZone$material3_release", "()Ljava/util/TimeZone;", "formatWithPattern", "", "utcTimeMillis", "", "pattern", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "cache", "", "getCachedSimpleDateFormat", "Ljava/text/SimpleDateFormat;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private final SimpleDateFormat getCachedSimpleDateFormat(String pattern, Locale locale, Map<String, Object> cache) {
            int i;
            Object simpleDateFormat;
            TimeZone utcTimeZone$material3_release;
            StringBuilder stringBuilder = new StringBuilder();
            String string = stringBuilder.append(pattern).append(locale.toLanguageTag()).toString();
            Object obj = cache;
            final int i2 = 0;
            final Object obj2 = obj.get(string);
            if (obj2 == null) {
                i = 0;
                simpleDateFormat = new SimpleDateFormat(pattern, locale);
                simpleDateFormat.setTimeZone(LegacyCalendarModelImpl.Companion.getUtcTimeZone$material3_release());
                obj.put(string, simpleDateFormat);
            } else {
                simpleDateFormat = obj2;
            }
            return (SimpleDateFormat)simpleDateFormat;
        }

        public final String formatWithPattern(long utcTimeMillis, String pattern, Locale locale, Map<String, Object> cache) {
            Calendar instance = Calendar.getInstance(getUtcTimeZone$material3_release());
            instance.setTimeInMillis(utcTimeMillis);
            return getCachedSimpleDateFormat(locale, cache, obj9).format(Long.valueOf(instance.getTimeInMillis()));
        }

        public final TimeZone getUtcTimeZone$material3_release() {
            return LegacyCalendarModelImpl.access$getUtcTimeZone$cp();
        }
    }
    static {
        LegacyCalendarModelImpl.Companion companion = new LegacyCalendarModelImpl.Companion(0);
        LegacyCalendarModelImpl.Companion = companion;
        int i = 8;
        LegacyCalendarModelImpl.utcTimeZone = TimeZone.getTimeZone("UTC");
    }

    public LegacyCalendarModelImpl(Locale locale) {
        Locale locale2;
        int index$iv;
        Object obj2;
        Object obj;
        int i2;
        int i;
        Pair pair;
        int i3;
        final Object obj3 = this;
        locale2 = locale;
        super(locale);
        obj3.firstDayOfWeek = obj3.dayInISO8601(Calendar.getInstance(locale2).getFirstDayOfWeek());
        List listBuilder = CollectionsKt.createListBuilder();
        final List list = listBuilder;
        final int i4 = 0;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale2);
        String[] weekdays = dateFormatSymbols.getWeekdays();
        DateFormatSymbols dateFormatSymbols2 = new DateFormatSymbols(locale2);
        String[] shortWeekdays = dateFormatSymbols2.getShortWeekdays();
        List drop = ArraysKt.drop(weekdays, 2);
        int i7 = 0;
        index$iv = 0;
        while (index$iv < drop.size()) {
            i = 0;
            pair = new Pair((String)drop.get(index$iv), shortWeekdays[i2 + 2]);
            list.add(pair);
            index$iv++;
            locale2 = locale;
        }
        int i6 = 1;
        Pair pair2 = new Pair(weekdays[i6], shortWeekdays[i6]);
        list.add(pair2);
        obj3.weekdayNames = CollectionsKt.build(listBuilder);
    }

    public static final TimeZone access$getUtcTimeZone$cp() {
        return LegacyCalendarModelImpl.utcTimeZone;
    }

    private final int dayInISO8601(int day) {
        final int i3 = 7;
        i %= i3;
        if (i2 == 0) {
            return i3;
        }
        return i2;
    }

    private final androidx.compose.material3.internal.CalendarMonth getMonth(Calendar firstDayCalendar) {
        int i;
        dayInISO8601 -= firstDayOfWeek;
        i = i4 < 0 ? i4 + 7 : i4;
        int i5 = 1;
        CalendarMonth calendarMonth = new CalendarMonth(firstDayCalendar.get(i5), i9 += i5, firstDayCalendar.getActualMaximum(5), i, firstDayCalendar.getTimeInMillis(), obj8);
        return calendarMonth;
    }

    private final Calendar toCalendar(androidx.compose.material3.internal.CalendarDate $this$toCalendar, TimeZone timeZone) {
        final Calendar instance = Calendar.getInstance(timeZone);
        instance.clear();
        int i3 = 1;
        instance.set(i3, $this$toCalendar.getYear());
        instance.set(2, month -= i3);
        instance.set(5, $this$toCalendar.getDayOfMonth());
        return instance;
    }

    private final Calendar toCalendar(androidx.compose.material3.internal.CalendarMonth $this$toCalendar) {
        Calendar instance = Calendar.getInstance(LegacyCalendarModelImpl.utcTimeZone);
        instance.setTimeInMillis($this$toCalendar.getStartUtcTimeMillis());
        return instance;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public String formatWithPattern(long utcTimeMillis, String pattern, Locale locale) {
        return LegacyCalendarModelImpl.Companion.formatWithPattern(utcTimeMillis, obj2, locale, obj10);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarDate getCanonicalDate(long timeInMillis) {
        Calendar instance = Calendar.getInstance(LegacyCalendarModelImpl.utcTimeZone);
        instance.setTimeInMillis(timeInMillis);
        int i7 = 0;
        instance.set(11, i7);
        instance.set(12, i7);
        instance.set(13, i7);
        instance.set(14, i7);
        CalendarDate calendarDate = new CalendarDate(instance.get(1), i9 + 1, instance.get(5), instance.getTimeInMillis(), obj8);
        return calendarDate;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.DateInputFormat getDateInputFormat(Locale locale) {
        DateFormat dateInstance = DateFormat.getDateInstance(3, locale);
        Intrinsics.checkNotNull(dateInstance, "null cannot be cast to non-null type java.text.SimpleDateFormat");
        return CalendarModelKt.datePatternAsInputFormat((SimpleDateFormat)dateInstance.toPattern());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int getDayOfWeek(androidx.compose.material3.internal.CalendarDate date) {
        return dayInISO8601(toCalendar(date, TimeZone.getDefault()).get(7));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarMonth getMonth(int year, int month) {
        Calendar instance = Calendar.getInstance(LegacyCalendarModelImpl.utcTimeZone);
        instance.clear();
        int i = 1;
        instance.set(i, year);
        instance.set(2, month + -1);
        instance.set(5, i);
        return getMonth(instance);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarMonth getMonth(long timeInMillis) {
        Calendar instance = Calendar.getInstance(LegacyCalendarModelImpl.utcTimeZone);
        instance.setTimeInMillis(timeInMillis);
        instance.set(5, 1);
        int i7 = 0;
        instance.set(11, i7);
        instance.set(12, i7);
        instance.set(13, i7);
        instance.set(14, i7);
        return getMonth(instance);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarMonth getMonth(androidx.compose.material3.internal.CalendarDate date) {
        return getMonth(date.getYear(), date.getMonth());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarDate getToday() {
        final Calendar instance = Calendar.getInstance();
        int i8 = 0;
        instance.set(11, i8);
        instance.set(12, i8);
        instance.set(13, i8);
        instance.set(14, i8);
        int i13 = i11;
        CalendarDate calendarDate = new CalendarDate(instance.get(i13), i13 += i16, instance.get(5), timeInMillis += l, obj7);
        return calendarDate;
    }

    public List<Pair<String, String>> getWeekdayNames() {
        return this.weekdayNames;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarMonth minusMonths(androidx.compose.material3.internal.CalendarMonth from, int subtractedMonthsCount) {
        if (subtractedMonthsCount <= 0) {
            return from;
        }
        final Calendar calendar = toCalendar(from);
        calendar.add(2, -subtractedMonthsCount);
        return getMonth(calendar);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarDate parse(String date, String pattern) {
        java.util.Date parse;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        final SimpleDateFormat date2 = simpleDateFormat;
        date2.setTimeZone(LegacyCalendarModelImpl.utcTimeZone);
        date2.setLenient(false);
        parse = date2.parse(date);
        if (parse == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance(LegacyCalendarModelImpl.utcTimeZone);
        instance.setTime(parse);
        int i5 = i3;
        CalendarDate calendarDate = new CalendarDate(instance.get(i5), i5 += i8, instance.get(5), instance.getTimeInMillis(), obj9);
        return calendarDate;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarMonth plusMonths(androidx.compose.material3.internal.CalendarMonth from, int addedMonthsCount) {
        if (addedMonthsCount <= 0) {
            return from;
        }
        final Calendar calendar = toCalendar(from);
        calendar.add(2, addedMonthsCount);
        return getMonth(calendar);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public String toString() {
        return "LegacyCalendarModel";
    }
}
