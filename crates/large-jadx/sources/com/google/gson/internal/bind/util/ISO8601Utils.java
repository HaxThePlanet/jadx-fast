package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class ISO8601Utils {

    private static final TimeZone TIMEZONE_UTC = null;
    private static final String UTC_ID = "UTC";
    static {
        ISO8601Utils.TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
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
        return ISO8601Utils.format(date, false, ISO8601Utils.TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z2) {
        return ISO8601Utils.format(date, z2, ISO8601Utils.TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z2, TimeZone timeZone3) {
        int gregorianCalendar;
        int i;
        int i2;
        int i3;
        int obj6;
        int obj7;
        int obj8;
        gregorianCalendar = new GregorianCalendar(timeZone3, Locale.US);
        gregorianCalendar.setTime(date);
        obj6 = 4;
        i = z2 != 0 ? obj6 : 0;
        int i10 = 1;
        i2 = timeZone3.getRawOffset() == 0 ? i10 : 6;
        StringBuilder stringBuilder = new StringBuilder(i6 += i2);
        ISO8601Utils.padInt(stringBuilder, gregorianCalendar.get(i10), obj6);
        obj6 = 45;
        stringBuilder.append(obj6);
        int i9 = 2;
        ISO8601Utils.padInt(stringBuilder, i17 += i10, i9);
        stringBuilder.append(obj6);
        ISO8601Utils.padInt(stringBuilder, gregorianCalendar.get(5), i9);
        stringBuilder.append('T');
        ISO8601Utils.padInt(stringBuilder, gregorianCalendar.get(11), i9);
        int i16 = 58;
        stringBuilder.append(i16);
        ISO8601Utils.padInt(stringBuilder, gregorianCalendar.get(12), i9);
        stringBuilder.append(i16);
        ISO8601Utils.padInt(stringBuilder, gregorianCalendar.get(13), i9);
        if (z2 != 0) {
            stringBuilder.append('.');
            ISO8601Utils.padInt(stringBuilder, gregorianCalendar.get(14), 3);
        }
        obj7 = timeZone3.getOffset(gregorianCalendar.getTimeInMillis());
        if (obj7 != null) {
            obj8 = obj7 / obj8;
            if (obj7 < 0) {
            } else {
                obj6 = 43;
            }
            stringBuilder.append(obj6);
            ISO8601Utils.padInt(stringBuilder, Math.abs(obj8 / 60), i9);
            stringBuilder.append(i16);
            ISO8601Utils.padInt(stringBuilder, Math.abs(obj8 %= 60), i9);
        } else {
            stringBuilder.append('Z');
        }
        return stringBuilder.toString();
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

    public static Date parse(String string, ParsePosition parsePosition2) {
        int string3;
        StringBuilder string2;
        int i7;
        int parseException;
        TimeZone tIMEZONE_UTC;
        String substring;
        int i2;
        int i3;
        int i5;
        int i;
        int i9;
        int length;
        boolean timeZone;
        StringBuilder stringBuilder;
        int equals;
        int i10;
        int str;
        int charAt;
        int i6;
        int i8;
        int int;
        int i4;
        int indexOfNonDigit;
        char charAt2;
        int int2;
        final String str2 = string;
        final int obj = parsePosition2;
        int index = parsePosition2.getIndex();
        i7 = index + 4;
        int int3 = ISO8601Utils.parseInt(str2, index, i7);
        int i19 = 45;
        if (ISO8601Utils.checkOffset(str2, i7, i19)) {
            i7++;
        }
        i2 = i7 + 2;
        int int4 = ISO8601Utils.parseInt(str2, i7, i2);
        if (ISO8601Utils.checkOffset(str2, i2, i19)) {
            i2++;
        }
        try {
            i3 = i2 + 2;
            int int5 = ISO8601Utils.parseInt(str2, i2, i3);
            boolean checkOffset3 = ISO8601Utils.checkOffset(str2, i3, 'T');
            final int i23 = 1;
            if (!checkOffset3 && string.length() <= i3) {
            }
            if (string.length() <= i3) {
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(int3, int4 -= i23, int5);
            obj.setIndex(i3);
            return gregorianCalendar.getTime();
            timeZone = 43;
            equals = 90;
            if (checkOffset3) {
            } else {
            }
            i3++;
            i = i21 + 2;
            int int6 = ISO8601Utils.parseInt(str2, i21, i);
            int i28 = 58;
            if (ISO8601Utils.checkOffset(str2, i, i28)) {
            }
            i++;
            i8 = i + 2;
            int int7 = ISO8601Utils.parseInt(str2, i, i8);
            if (ISO8601Utils.checkOffset(str2, i8, i28)) {
            }
            i8++;
            charAt = str2.charAt(i8);
            if (string.length() > i8 && charAt != equals && charAt != timeZone && charAt != i19) {
            } else {
            }
            charAt = str2.charAt(i8);
            if (charAt != equals) {
            } else {
            }
            if (charAt != timeZone) {
            } else {
            }
            if (charAt != i19) {
            } else {
            }
            int i29 = i8 + 2;
            int = ISO8601Utils.parseInt(str2, i8, i29);
            if (int > 59 && int < 63) {
            }
            if (int < 63) {
            }
            int = 59;
            if (ISO8601Utils.checkOffset(str2, i29, '.')) {
            } else {
            }
            i29++;
            indexOfNonDigit = ISO8601Utils.indexOfNonDigit(str2, i30 + 1);
            int i25 = Math.min(indexOfNonDigit, i30 + 3);
            int2 = ISO8601Utils.parseInt(str2, i30, i25);
            i25 -= i30;
            if (i26 != i23) {
            } else {
            }
            if (i26 != 2) {
            } else {
            }
            int2 *= 10;
            int2 *= 100;
            i10 = int7;
            i6 = int2;
            i9 = int6;
            i3 = indexOfNonDigit;
            i10 = int7;
            i9 = int6;
            i3 = i29;
            i6 = 0;
            i10 = int7;
            i6 = 0;
            i9 = int6;
            i3 = i8;
            i9 = 0;
            i10 = 0;
            i6 = 0;
            int = 0;
            if (string.length() <= i3) {
            } else {
            }
            charAt2 = str2.charAt(i3);
            if (charAt2 == equals) {
            } else {
            }
            tIMEZONE_UTC = ISO8601Utils.TIMEZONE_UTC;
            i3 += i23;
            if (charAt2 != timeZone) {
            }
            if (charAt2 != i19) {
            } else {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Invalid time zone indicator '");
            stringBuilder2.append(charAt2);
            stringBuilder2.append("'");
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.toString());
            throw indexOutOfBoundsException;
            substring = str2.substring(i3);
            if (substring.length() >= 5) {
            } else {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(substring);
            stringBuilder.append("00");
            substring = stringBuilder.toString();
            i3 += length2;
            if (!"+0000".equals(substring)) {
            } else {
            }
            if ("+00:00".equals(substring)) {
            } else {
            }
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("GMT");
            stringBuilder5.append(substring);
            String string6 = stringBuilder5.toString();
            timeZone = TimeZone.getTimeZone(string6);
            equals = timeZone.getID();
            if (!equals.equals(string6)) {
            }
            if (!equals.replace(":", "").equals(string6)) {
            } else {
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Mismatching time zone indicator: ");
            stringBuilder3.append(string6);
            stringBuilder3.append(" given, resolves to ");
            stringBuilder3.append(timeZone.getID());
            IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder3.toString());
            throw indexOutOfBoundsException2;
            tIMEZONE_UTC = timeZone;
            tIMEZONE_UTC = ISO8601Utils.TIMEZONE_UTC;
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(tIMEZONE_UTC);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(i23, int3);
            gregorianCalendar2.set(2, int4 -= i23);
            gregorianCalendar2.set(5, int5);
            gregorianCalendar2.set(11, i9);
            gregorianCalendar2.set(12, i10);
            gregorianCalendar2.set(13, int);
            gregorianCalendar2.set(14, i6);
            obj.setIndex(i5);
            return gregorianCalendar2.getTime();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No time zone indicator");
            throw illegalArgumentException;
            if (string3 == null) {
            } else {
            }
            string3 = 0;
            string2 = new StringBuilder();
            parseException = 34;
            string2.append(parseException);
            string2.append(string3);
            string2.append(parseException);
            string3 = string2.toString();
            string2 = th.getMessage();
            parseException = string2.isEmpty();
            if (string2 != null && parseException != null) {
            } else {
            }
            parseException = string2.isEmpty();
            if (parseException == null) {
            } else {
            }
            string2 = new StringBuilder();
            parseException = "(";
            string2.append(parseException);
            parseException = th.getClass();
            parseException = parseException.getName();
            string2.append(parseException);
            parseException = ")";
            string2.append(parseException);
            string2 = string2.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Failed to parse date [");
            stringBuilder4.append(string3);
            string3 = "]: ";
            stringBuilder4.append(string3);
            stringBuilder4.append(string2);
            string3 = stringBuilder4.toString();
            parseException = new ParseException(string3, parsePosition2.getIndex());
            parseException.initCause(th);
            throw parseException;
        }
    }

    private static int parseInt(String string, int i2, int i3) {
        int length;
        int i5;
        int i;
        int i4;
        if (i2 < 0) {
        } else {
            if (i3 > string.length()) {
            } else {
                if (i2 > i3) {
                } else {
                    final String str = "Invalid number: ";
                    int i7 = 10;
                    if (i2 < i3) {
                        i5 = i2 + 1;
                        int digit2 = Character.digit(string.charAt(i2), i7);
                        if (digit2 < 0) {
                        } else {
                            i = -digit2;
                            while (i5 < i3) {
                                int digit = Character.digit(string.charAt(i5), i7);
                                i8 -= digit;
                                i5 = i4;
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
                    i5 = i2;
                }
            }
        }
        NumberFormatException obj6 = new NumberFormatException(string);
        throw obj6;
    }
}
