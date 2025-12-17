package com.revenuecat.purchases.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class Iso8601Utils {

    private static final String GMT_ID = "GMT";
    private static final TimeZone TIMEZONE_Z;
    static {
        Iso8601Utils.TIMEZONE_Z = TimeZone.getTimeZone("GMT");
    }

    private static boolean checkOffset(String string, int i2, char c3) {
        char obj1;
        if (i2 < string.length() && string.charAt(i2) == c3) {
            obj1 = string.charAt(i2) == c3 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(Iso8601Utils.TIMEZONE_Z, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder obj5 = new StringBuilder(24);
        int i4 = 1;
        Iso8601Utils.padInt(obj5, gregorianCalendar.get(i4), 4);
        int i17 = 45;
        obj5.append(i17);
        int i21 = 2;
        Iso8601Utils.padInt(obj5, i22 += i4, i21);
        obj5.append(i17);
        Iso8601Utils.padInt(obj5, gregorianCalendar.get(5), i21);
        obj5.append('T');
        Iso8601Utils.padInt(obj5, gregorianCalendar.get(11), i21);
        int i10 = 58;
        obj5.append(i10);
        Iso8601Utils.padInt(obj5, gregorianCalendar.get(12), i21);
        obj5.append(i10);
        Iso8601Utils.padInt(obj5, gregorianCalendar.get(13), i21);
        obj5.append('.');
        Iso8601Utils.padInt(obj5, gregorianCalendar.get(14), 3);
        obj5.append('Z');
        return obj5.toString();
    }

    private static int indexOfNonDigit(String string, int i2) {
        int i;
        while (i2 < string.length()) {
            char charAt = string.charAt(i2);
            i2++;
        }
        return string.length();
    }

    private static void padInt(StringBuilder stringBuilder, int i2, int i3) {
        int length;
        int obj3;
        final String obj2 = Integer.toString(i2);
        i3 -= length;
        while (obj3 > 0) {
            stringBuilder.append('0');
            obj3--;
        }
        stringBuilder.append(obj2);
    }

    public static Date parse(String string) {
        int i9;
        int i7;
        int i10;
        int i8;
        TimeZone tIMEZONE_Z;
        int i4;
        int timeZone;
        int equals2;
        int equals;
        int int2;
        int i5;
        int length;
        int str;
        int charAt;
        int int;
        int i;
        boolean indexOfNonDigit;
        int i3;
        int i6;
        int i2;
        final String str2 = string;
        i9 = 4;
        int int4 = Iso8601Utils.parseInt(str2, 0, i9);
        i8 = 45;
        if (Iso8601Utils.checkOffset(str2, i9, i8)) {
            i9 = 5;
        }
        i4 = i9 + 2;
        int int3 = Iso8601Utils.parseInt(str2, i9, i4);
        if (Iso8601Utils.checkOffset(str2, i4, i8)) {
            i4++;
        }
        try {
            equals = i4 + 2;
            timeZone = Iso8601Utils.parseInt(str2, i4, equals);
            boolean checkOffset3 = Iso8601Utils.checkOffset(str2, equals, 'T');
            final int i26 = 1;
            if (!checkOffset3 && string.length() <= equals) {
            }
            if (string.length() <= equals) {
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(int4, int3 -= i26, timeZone);
            return gregorianCalendar.getTime();
            str = 43;
            final int i27 = 90;
            if (checkOffset3) {
            } else {
            }
            equals++;
            i5 = i24 + 2;
            int int5 = Iso8601Utils.parseInt(str2, i24, i5);
            int i28 = 58;
            if (Iso8601Utils.checkOffset(str2, i5, i28)) {
            }
            i5++;
            i = i5 + 2;
            int2 = Iso8601Utils.parseInt(str2, i5, i);
            if (Iso8601Utils.checkOffset(str2, i, i28)) {
            }
            i++;
            charAt = str2.charAt(i);
            if (string.length() > i && charAt != i27 && charAt != str && charAt != i8) {
            } else {
            }
            charAt = str2.charAt(i);
            if (charAt != i27) {
            } else {
            }
            if (charAt != str) {
            } else {
            }
            if (charAt != i8) {
            } else {
            }
            charAt = i + 2;
            int = Iso8601Utils.parseInt(str2, i, charAt);
            int i30 = 59;
            if (int > i30 && int < 63) {
            }
            if (int < 63) {
            }
            int = i30;
            if (Iso8601Utils.checkOffset(str2, charAt, '.')) {
            } else {
            }
            charAt++;
            indexOfNonDigit = Iso8601Utils.indexOfNonDigit(str2, i29 + 1);
            int i34 = Math.min(indexOfNonDigit, i29 + 3);
            i6 = int4;
            i2 = timeZone;
            i7 = (int)i19;
            i10 = int5;
            equals = indexOfNonDigit;
            i6 = int4;
            i2 = timeZone;
            i10 = int5;
            equals = charAt;
            i7 = 0;
            i6 = int4;
            i2 = timeZone;
            i10 = int5;
            equals = i;
            i7 = 0;
            i6 = int4;
            i2 = timeZone;
            i7 = 0;
            i10 = 0;
            int2 = 0;
            int = 0;
            if (string.length() <= equals) {
            } else {
            }
            char charAt2 = str2.charAt(equals);
            if (charAt2 == i27) {
            } else {
            }
            tIMEZONE_Z = Iso8601Utils.TIMEZONE_Z;
            if (charAt2 != str) {
            }
            if (charAt2 != 45) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid time zone indicator '");
            stringBuilder.append(charAt2);
            stringBuilder.append("'");
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.toString());
            throw indexOutOfBoundsException;
            String substring = str2.substring(equals);
            if (!"+0000".equals(substring)) {
            } else {
            }
            if ("+00:00".equals(substring)) {
            } else {
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("GMT");
            stringBuilder4.append(substring);
            String string5 = stringBuilder4.toString();
            timeZone = TimeZone.getTimeZone(string5);
            equals2 = timeZone.getID();
            if (!equals2.equals(string5)) {
            }
            if (!equals2.replace(":", "").equals(string5)) {
            } else {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Mismatching time zone indicator: ");
            stringBuilder2.append(string5);
            stringBuilder2.append(" given, resolves to ");
            stringBuilder2.append(timeZone.getID());
            IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder2.toString());
            throw indexOutOfBoundsException2;
            tIMEZONE_Z = timeZone;
            tIMEZONE_Z = Iso8601Utils.TIMEZONE_Z;
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(tIMEZONE_Z);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(i26, i6);
            gregorianCalendar2.set(2, int3 -= i26);
            gregorianCalendar2.set(5, i2);
            gregorianCalendar2.set(11, i10);
            gregorianCalendar2.set(12, int2);
            gregorianCalendar2.set(13, int);
            gregorianCalendar2.set(14, i7);
            return gregorianCalendar2.getTime();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No time zone indicator");
            throw illegalArgumentException;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Not an RFC 3339 date: ");
            stringBuilder3.append(string2);
            String string2 = stringBuilder3.toString();
            SerializationException serializationException = new SerializationException(string2, th);
            throw serializationException;
        }
    }

    private static int parseInt(String string, int i2, int i3) {
        int length;
        int i4;
        int i;
        int i5;
        if (i2 < 0) {
        } else {
            if (i3 > string.length()) {
            } else {
                if (i2 > i3) {
                } else {
                    final String str = "Invalid number: ";
                    int i7 = 10;
                    if (i2 < i3) {
                        i4 = i2 + 1;
                        int digit2 = Character.digit(string.charAt(i2), i7);
                        if (digit2 < 0) {
                        } else {
                            i = -digit2;
                            while (i4 < i3) {
                                int digit = Character.digit(string.charAt(i4), i7);
                                i8 -= digit;
                                i4 = i5;
                            }
                            return -i;
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str);
                        stringBuilder2.append(string.substring(i2, i3));
                        NumberFormatException numberFormatException2 = new NumberFormatException(stringBuilder2.toString());
                        throw numberFormatException2;
                    }
                    i = i6;
                    i4 = i2;
                }
            }
        }
        NumberFormatException obj6 = new NumberFormatException(string);
        throw obj6;
    }
}
