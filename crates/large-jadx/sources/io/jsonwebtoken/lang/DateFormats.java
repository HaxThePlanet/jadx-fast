package io.jsonwebtoken.lang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class DateFormats {

    private static final java.lang.ThreadLocal<DateFormat> ISO_8601 = null;
    private static final java.lang.ThreadLocal<DateFormat> ISO_8601_MILLIS = null;
    private static final String ISO_8601_MILLIS_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    static {
        DateFormats.1 anon = new DateFormats.1();
        DateFormats.ISO_8601 = anon;
        DateFormats.2 anon2 = new DateFormats.2();
        DateFormats.ISO_8601_MILLIS = anon2;
    }

    public static String formatIso8601(Date date) {
        return DateFormats.formatIso8601(date, true);
    }

    public static String formatIso8601(Date date, boolean z2) {
        if (z2) {
            return (DateFormat)DateFormats.ISO_8601_MILLIS.get().format(date);
        }
        return (DateFormat)DateFormats.ISO_8601.get().format(date);
    }

    public static Date parseIso8601Date(String string) {
        Assert.notNull(string, "String argument cannot be null.");
        if (string.lastIndexOf(46) > -1) {
            return (DateFormat)DateFormats.ISO_8601_MILLIS.get().parse(string);
        }
        return (DateFormat)DateFormats.ISO_8601.get().parse(string);
    }
}
