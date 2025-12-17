package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class PreJava9DateFormatProvider {
    private static String getDateFormatPattern(int i) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                    } else {
                        return "M/d/yy";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown DateFormat style: ");
                    stringBuilder.append(i);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
                return "MMM d, y";
            }
            return "MMMM d, y";
        }
        return "EEEE, MMMM d, y";
    }

    private static String getDatePartOfDateTimePattern(int i) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                    } else {
                        return "M/d/yy";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown DateFormat style: ");
                    stringBuilder.append(i);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
                return "MMM d, yyyy";
            }
            return "MMMM d, yyyy";
        }
        return "EEEE, MMMM d, yyyy";
    }

    private static String getTimePartOfDateTimePattern(int i) {
        int i2;
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                    } else {
                        return "h:mm a";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown DateFormat style: ");
                    stringBuilder.append(i);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
                return "h:mm:ss a";
            }
        }
        return "h:mm:ss a z";
    }

    public static DateFormat getUSDateFormat(int i) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PreJava9DateFormatProvider.getDateFormatPattern(i), Locale.US);
        return simpleDateFormat;
    }

    public static DateFormat getUSDateTimeFormat(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PreJava9DateFormatProvider.getDatePartOfDateTimePattern(i));
        stringBuilder.append(" ");
        stringBuilder.append(PreJava9DateFormatProvider.getTimePartOfDateTimePattern(i2));
        SimpleDateFormat obj2 = new SimpleDateFormat(stringBuilder.toString(), Locale.US);
        return obj2;
    }
}
