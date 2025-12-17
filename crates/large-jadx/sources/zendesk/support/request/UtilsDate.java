package zendesk.support.request;

import android.text.format.DateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
class UtilsDate {
    static Date getBeginOfDay(Date date) {
        Calendar obj2 = UtilsDate.getCalendar(date);
        final int i5 = 0;
        obj2.set(11, i5);
        obj2.set(12, i5);
        obj2.set(13, i5);
        obj2.set(14, i5);
        return obj2.getTime();
    }

    private static Calendar getCalendar(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getDefault(), Locale.getDefault());
        gregorianCalendar.setTime(date);
        return gregorianCalendar;
    }

    private static Date getYesterday() {
        Date date = new Date();
        Calendar calendar = UtilsDate.getCalendar(date);
        calendar.add(5, -1);
        return calendar.getTime();
    }

    static boolean isSameDay(Date date, Date date2) {
        int i;
        int i2;
        int i3;
        int obj5;
        obj5 = UtilsDate.getCalendar(date);
        Calendar obj6 = UtilsDate.getCalendar(date2);
        i = 1;
        final int i8 = 0;
        i2 = obj5.get(i) == obj6.get(i) ? i : i8;
        int i6 = 2;
        i3 = obj5.get(i6) == obj6.get(i6) ? i : i8;
        int i10 = 5;
        obj5 = obj5.get(i10) == obj6.get(i10) ? i : i8;
        if (i2 != 0 && i3 != 0 && obj5 != null) {
            if (i3 != 0) {
                if (obj5 != null) {
                } else {
                    i = i8;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    static boolean isToday(Date date) {
        return DateUtils.isToday(date.getTime());
    }

    static boolean isYesterday(Date date) {
        return UtilsDate.isSameDay(date, UtilsDate.getYesterday());
    }
}
