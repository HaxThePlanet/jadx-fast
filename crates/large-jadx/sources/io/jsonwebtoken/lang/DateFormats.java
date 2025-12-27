package io.jsonwebtoken.lang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: DateFormats.java */
/* loaded from: classes3.dex */
public class DateFormats {

    private static final java.lang.ThreadLocal<DateFormat> ISO_8601 = null;
    private static final java.lang.ThreadLocal<DateFormat> ISO_8601_MILLIS = null;
    private static final String ISO_8601_MILLIS_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    static {
        DateFormats.ISO_8601 = new DateFormats.AnonymousClass1();
        DateFormats.ISO_8601_MILLIS = new DateFormats.AnonymousClass2();
    }

    public static String formatIso8601(Date date) {
        return DateFormats.formatIso8601(date, true);
    }

    public static Date parseIso8601Date(String str) throws java.text.ParseException {
        Assert.notNull(str, "String argument cannot be null.");
        if (str.lastIndexOf(46) > -1) {
            return (DateFormat)DateFormats.ISO_8601_MILLIS.get().parse(str);
        }
        return (DateFormat)DateFormats.ISO_8601.get().parse(str);
    }

    public static String formatIso8601(Date date, boolean z) {
        if (z) {
            return (DateFormat)DateFormats.ISO_8601_MILLIS.get().format(date);
        }
        return (DateFormat)DateFormats.ISO_8601.get().format(date);
    }
}
