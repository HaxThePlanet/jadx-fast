package androidx.compose.material3.internal;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0001\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J$\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0014\u0010\u001a\u001a\u00020\u001b2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0007H\u0016J\u001a\u0010'\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0018\u0010(\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0007H\u0016J\u0008\u0010*\u001a\u00020\u0011H\u0016J\u000c\u0010+\u001a\u00020!*\u00020\u000bH\u0002J\u000c\u0010+\u001a\u00020!*\u00020\u001fH\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR&\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006-", d2 = {"Landroidx/compose/material3/internal/CalendarModelImpl;", "Landroidx/compose/material3/internal/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/util/Locale;)V", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "today", "Landroidx/compose/material3/internal/CalendarDate;", "getToday", "()Landroidx/compose/material3/internal/CalendarDate;", "weekdayNames", "", "Lkotlin/Pair;", "", "getWeekdayNames", "()Ljava/util/List;", "formatWithPattern", "utcTimeMillis", "", "pattern", "getCanonicalDate", "timeInMillis", "getDateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "getDayOfWeek", "date", "getMonth", "Landroidx/compose/material3/internal/CalendarMonth;", "firstDayLocalDate", "Ljava/time/LocalDate;", "year", "month", "minusMonths", "from", "subtractedMonthsCount", "parse", "plusMonths", "addedMonthsCount", "toString", "toLocalDate", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CalendarModelImpl extends androidx.compose.material3.internal.CalendarModel {

    public static final int $stable = 8;
    public static final androidx.compose.material3.internal.CalendarModelImpl.Companion Companion;
    private static final ZoneId utcTimeZoneId;
    private final int firstDayOfWeek;
    private final List<Pair<String, String>> weekdayNames;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00082\n\u0010\u000c\u001a\u00060\rj\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00010\u0010J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00082\n\u0010\u000c\u001a\u00060\rj\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00010\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0013", d2 = {"Landroidx/compose/material3/internal/CalendarModelImpl$Companion;", "", "()V", "utcTimeZoneId", "Ljava/time/ZoneId;", "getUtcTimeZoneId$material3_release", "()Ljava/time/ZoneId;", "formatWithPattern", "", "utcTimeMillis", "", "pattern", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "cache", "", "getCachedDateTimeFormatter", "Ljava/time/format/DateTimeFormatter;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private final DateTimeFormatter getCachedDateTimeFormatter(String pattern, Locale locale, Map<String, Object> cache) {
            Object $i$a$GetOrPutCalendarModelImpl$Companion$getCachedDateTimeFormatter$1;
            DateTimeFormatter pattern2;
            DecimalStyle decimalStyle;
            StringBuilder stringBuilder = new StringBuilder();
            String string = stringBuilder.append("P:").append(pattern).append(locale.toLanguageTag()).toString();
            Object obj = cache;
            final int i = 0;
            final Object obj2 = obj.get(string);
            if (obj2 == null) {
                int i2 = 0;
                obj.put(string, DateTimeFormatter.ofPattern(pattern, locale).withDecimalStyle(DecimalStyle.of(locale)));
            } else {
                $i$a$GetOrPutCalendarModelImpl$Companion$getCachedDateTimeFormatter$1 = obj2;
            }
            Intrinsics.checkNotNull($i$a$GetOrPutCalendarModelImpl$Companion$getCachedDateTimeFormatter$1, "null cannot be cast to non-null type java.time.format.DateTimeFormatter");
            return (DateTimeFormatter)$i$a$GetOrPutCalendarModelImpl$Companion$getCachedDateTimeFormatter$1;
        }

        public final String formatWithPattern(long utcTimeMillis, String pattern, Locale locale, Map<String, Object> cache) {
            return Instant.ofEpochMilli(utcTimeMillis).atZone(getUtcTimeZoneId$material3_release()).toLocalDate().format(getCachedDateTimeFormatter(locale, cache, obj8));
        }

        public final ZoneId getUtcTimeZoneId$material3_release() {
            return CalendarModelImpl.access$getUtcTimeZoneId$cp();
        }
    }
    static {
        CalendarModelImpl.Companion companion = new CalendarModelImpl.Companion(0);
        CalendarModelImpl.Companion = companion;
        int i = 8;
        CalendarModelImpl.utcTimeZoneId = ZoneId.of("UTC");
    }

    public CalendarModelImpl(Locale locale) {
        int i;
        DayOfWeek dayOfWeek;
        Pair it;
        int i2;
        String displayName2;
        String displayName;
        super(locale);
        this.firstDayOfWeek = WeekFields.of(locale).getFirstDayOfWeek().getValue();
        Locale locale2 = locale;
        final int i3 = 0;
        final DayOfWeek[] values = DayOfWeek.values();
        final int i4 = 0;
        ArrayList arrayList = new ArrayList(values.length);
        DayOfWeek[] objArr = values;
        final int i5 = 0;
        i = 0;
        while (i < objArr.length) {
            DayOfWeek dayOfWeek2 = dayOfWeek;
            i2 = 0;
            (Collection)arrayList.add(TuplesKt.to(dayOfWeek2.getDisplayName(TextStyle.FULL, locale2), dayOfWeek2.getDisplayName(TextStyle.NARROW, locale2)));
            i++;
        }
        this.weekdayNames = (List)arrayList;
    }

    public static final ZoneId access$getUtcTimeZoneId$cp() {
        return CalendarModelImpl.utcTimeZoneId;
    }

    private final androidx.compose.material3.internal.CalendarMonth getMonth(LocalDate firstDayLocalDate) {
        int i;
        value -= firstDayOfWeek;
        i = i2 < 0 ? i2 + 7 : i2;
        CalendarMonth calendarMonth = new CalendarMonth(firstDayLocalDate.getYear(), firstDayLocalDate.getMonthValue(), firstDayLocalDate.lengthOfMonth(), i, firstDayLocalDate.atTime(LocalTime.MIDNIGHT).atZone(CalendarModelImpl.utcTimeZoneId).toInstant().toEpochMilli(), obj8);
        return calendarMonth;
    }

    private final LocalDate toLocalDate(androidx.compose.material3.internal.CalendarDate $this$toLocalDate) {
        return LocalDate.of($this$toLocalDate.getYear(), $this$toLocalDate.getMonth(), $this$toLocalDate.getDayOfMonth());
    }

    private final LocalDate toLocalDate(androidx.compose.material3.internal.CalendarMonth $this$toLocalDate) {
        return Instant.ofEpochMilli($this$toLocalDate.getStartUtcTimeMillis()).atZone(CalendarModelImpl.utcTimeZoneId).toLocalDate();
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public String formatWithPattern(long utcTimeMillis, String pattern, Locale locale) {
        return CalendarModelImpl.Companion.formatWithPattern(utcTimeMillis, obj2, locale, obj10);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarDate getCanonicalDate(long timeInMillis) {
        LocalDate localDate = Instant.ofEpochMilli(timeInMillis).atZone(CalendarModelImpl.utcTimeZoneId).toLocalDate();
        final ZoneOffset uTC = ZoneOffset.UTC;
        CalendarDate calendarDate = new CalendarDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), epochSecond *= l, uTC);
        return calendarDate;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.DateInputFormat getDateInputFormat(Locale locale) {
        return CalendarModelKt.datePatternAsInputFormat(DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.SHORT, 0, Chronology.ofLocale(locale), locale));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int getDayOfWeek(androidx.compose.material3.internal.CalendarDate date) {
        return toLocalDate(date).getDayOfWeek().getValue();
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarMonth getMonth(int year, int month) {
        return getMonth(LocalDate.of(year, month, 1));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarMonth getMonth(long timeInMillis) {
        return getMonth(Instant.ofEpochMilli(timeInMillis).atZone(CalendarModelImpl.utcTimeZoneId).withDayOfMonth(1).toLocalDate());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarMonth getMonth(androidx.compose.material3.internal.CalendarDate date) {
        return getMonth(LocalDate.of(date.getYear(), date.getMonth(), 1));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarDate getToday() {
        final LocalDate date = LocalDate.now();
        final ZoneId utcTimeZoneId = CalendarModelImpl.utcTimeZoneId;
        CalendarDate calendarDate = new CalendarDate(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli(), utcTimeZoneId);
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
        return getMonth(toLocalDate(from).minusMonths((long)subtractedMonthsCount));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarDate parse(String date, String pattern) {
        LocalDate parse;
        androidx.compose.material3.internal.CalendarDate calendarDate;
        parse = LocalDate.parse((CharSequence)date, DateTimeFormatter.ofPattern(pattern));
        final ZoneId utcTimeZoneId = CalendarModelImpl.utcTimeZoneId;
        calendarDate = new CalendarDate(parse.getYear(), parse.getMonth().getValue(), parse.getDayOfMonth(), parse.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli(), utcTimeZoneId);
        return calendarDate;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public androidx.compose.material3.internal.CalendarMonth plusMonths(androidx.compose.material3.internal.CalendarMonth from, int addedMonthsCount) {
        if (addedMonthsCount <= 0) {
            return from;
        }
        return getMonth(toLocalDate(from).plusMonths((long)addedMonthsCount));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public String toString() {
        return "CalendarModel";
    }
}
