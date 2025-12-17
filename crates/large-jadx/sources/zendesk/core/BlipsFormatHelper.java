package zendesk.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
class BlipsFormatHelper {

    static final String BLIPS_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String UTC_TIMEZONE = "UTC";
    private static final String VERSION_NAME_FORMAT = "%s:%s";
    static String nowAsString(Date date) {
        Date date2;
        long time;
        Date obj3;
        if (date == null) {
            obj3 = new Date();
        } else {
            date2 = new Date(date.getTime(), obj2);
            obj3 = date2;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(obj3);
    }
}
