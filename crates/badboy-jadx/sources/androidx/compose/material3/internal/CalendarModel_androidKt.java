package androidx.compose.material3.internal;

import android.text.format.DateFormat;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0000\u001a8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000c0\u000bH\u0000¨\u0006\r", d2 = {"createCalendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "formatWithSkeleton", "", "utcTimeMillis", "", "skeleton", "cache", "", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CalendarModel_androidKt {
    public static final androidx.compose.material3.internal.CalendarModel createCalendarModel(Locale locale) {
        CalendarModelImpl calendarModelImpl = new CalendarModelImpl(locale);
        return (CalendarModel)calendarModelImpl;
    }

    public static final String formatWithSkeleton(long utcTimeMillis, String skeleton, Locale locale, Map<String, Object> cache) {
        Object $i$a$GetOrPutCalendarModel_androidKt$formatWithSkeleton$pattern$1;
        StringBuilder stringBuilder = new StringBuilder();
        String string = stringBuilder.append("S:").append(locale).append(cache.toLanguageTag()).toString();
        Object obj = obj11;
        int i = 0;
        final Object obj2 = obj.get(string);
        if (obj2 == null) {
            int i2 = 0;
            obj.put(string, DateFormat.getBestDateTimePattern(cache, locale));
        } else {
            $i$a$GetOrPutCalendarModel_androidKt$formatWithSkeleton$pattern$1 = obj2;
        }
        return CalendarModelImpl.Companion.formatWithPattern(utcTimeMillis, obj2, $i$a$GetOrPutCalendarModel_androidKt$formatWithSkeleton$pattern$1.toString(), cache);
    }
}
