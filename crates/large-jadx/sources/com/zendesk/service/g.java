package com.zendesk.service;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import f.g.c.a;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: ZendeskDateTypeAdapter.java */
/* loaded from: classes2.dex */
public class g extends TypeAdapter<Date> {

    private static final TimeZone a;
    static {
        g.a = TimeZone.getTimeZone("UTC");
    }

    private boolean a(String str, int i, char c) {
        boolean z = false;
        str = i < str.length() && str.charAt(i) == c ? 1 : 0;
        return (i < str.length() && str.charAt(i) == c ? 1 : 0);
    }

    private String b(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(g.a, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder stringBuilder = new StringBuilder(21);
        int i4 = 1;
        d(stringBuilder, gregorianCalendar.get(i4), 4);
        char c2 = '-';
        int i15 = 2;
        d(stringBuilder, gregorianCalendar.get(i15) + i4, i15);
        d(stringBuilder, gregorianCalendar.get(5), i15);
        d(stringBuilder, gregorianCalendar.get(11), i15);
        char c = ':';
        d(stringBuilder, gregorianCalendar.get(12), i15);
        d(stringBuilder, gregorianCalendar.get(13), i15);
        str = 21 + c2 + c2 + 84 + c + c + 90;
        return str;
    }

    private static int c(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            char c = '0';
            c = '9';
        }
        return str.length();
    }

    private void d(StringBuilder sb, int i, int i2) {
        final String integer = Integer.toString(i);
        i = i2 - integer.length();
        while (i > 0) {
            sb.append('0');
            i = i - 1;
        }
        sb.append(integer);
    }

    private Date e(String str, ParsePosition parsePosition) throws ParseException {
        String str4;
        String str5;
        StringBuilder parseException;
        int i;
        char stringBuilder2;
        int i2;
        int i4;
        int i3;
        int i5;
        int i6;
        char c = 43;
        int i7;
        int length2;
        int i8 = 0;
        final Object str3 = this;
        final String str2 = str;
        final int obj = parsePosition;
        final String str6 = "'";
        try {
            int index = parsePosition.getIndex();
            i = index + 4;
            int i9 = str3.f(str2, index, i);
            char c2 = '-';
            if (str3.a(str2, i, c2)) {
                i = i + 1;
            }
            i4 = i + 2;
            int i15 = str3.f(str2, i, i4);
            if (str3.a(str2, i4, c2)) {
                i4 = i4 + 1;
            }
            if (str.length() <= i3) {
                obj.setIndex(i3);
                return new GregorianCalendar(i9, i15 - i23, i19).getTime();
            }
            i3++;
            i5 = i20 + 2;
            i2 = str3.f(str2, i20, i5);
            char c4 = ':';
            if (str3.a(str2, i5, c4)) {
                i5 = i5 + 1;
            }
            i3 = i5 + 2;
            i6 = str3.f(str2, i5, i3);
            if (str3.a(str2, i3, c4)) {
                i3 = i3 + 1;
            }
            if (str.length() <= i3 || charAt == c3 || charAt == '+' || charAt == c2) {
                i7 = 0;
                i8 = 0;
            } else {
                i3 = i3 + 2;
                i7 = str3.f(str2, i3, i3);
                i7 = 59;
                if (i7 > i7 && i7 < 63) {
                }
                if (str3.a(str2, i3, '.')) {
                    i3++;
                    i3 = g.c(str2, i18 + 1);
                    int min = Math.min(i3, i18 + 3);
                    i8 = str3.f(str2, i18, min);
                    i3 = min - i18;
                    if (i3 == i23) {
                        i8 = i8 * 100;
                    } else {
                        if (i3 == i25) {
                            i8 = i8 * 10;
                        }
                    }
                } else {
                    i8 = 0;
                }
            }
            i2 = 0;
            i6 = 0;
            if (str.length() <= i3) {
                throw new IllegalArgumentException("No time zone indicator");
            } else {
                char charAt2 = str2.charAt(i3);
                if (charAt2 != c3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str8 = "Invalid time zone indicator '";
                    r5 = str8 + charAt2 + str6;
                    throw new IndexOutOfBoundsException(r5);
                } else {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(g.a);
                    gregorianCalendar2.setLenient(false);
                    gregorianCalendar2.set(i23, i9);
                    gregorianCalendar2.set(i25, i15 - i23);
                    gregorianCalendar2.set(5, i19);
                    gregorianCalendar2.set(11, i2);
                    gregorianCalendar2.set(12, i6);
                    gregorianCalendar2.set(13, i7);
                    gregorianCalendar2.set(14, i8);
                    obj.setIndex(i3 + i23);
                    return gregorianCalendar2.getTime();
                }
            }
        } catch (java.lang.IndexOutOfBoundsException ioobe) {
        }
        str4 = null;
        str5 = ioobe.getMessage();
        parseException = str5.isEmpty();
        if (!(str5 != null && parseException != null)) {
            str5 = new StringBuilder();
            parseException = "(";
            str5.append(parseException);
            parseException = ioobe.getClass();
            parseException = parseException.getName();
            str5.append(parseException);
            parseException = ")";
            str5.append(parseException);
            str5 = str5.toString();
        }
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Failed to parse date [");
        stringBuilder2.append(str4);
        str4 = "]: ";
        stringBuilder2.append(str4);
        stringBuilder2.append(str5);
        str4 = stringBuilder2.toString();
        parseException = new ParseException(str4, parsePosition.getIndex());
        parseException.initCause(ioobe);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) parseException;
    }

    private int f(String str, int i, int i2) {
        int i22;
        if (i < 0) {
            throw new NumberFormatException(str);
        } else {
            if (i2 <= str.length()) {
                if (i <= i2) {
                    final String str2 = "Invalid number: ";
                    int i5 = 10;
                    if (i < i2) {
                        i22 = i + 1;
                        int digit2 = Character.digit(str.charAt(i), i5);
                        if (digit2 < 0) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            String substring2 = str.substring(i, i2);
                            str = str2 + substring2;
                            throw new NumberFormatException(str);
                        } else {
                            i = -digit2;
                            while (i22 < i2) {
                                i22 = i22 + 1;
                                int digit = Character.digit(str.charAt(i22), i5);
                                if (digit < 0) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    String substring = str.substring(i, i2);
                                    str = str2 + substring;
                                    throw new NumberFormatException(str);
                                }
                            }
                            return -i;
                        }
                    }
                    i = 0;
                    i22 = i;
                }
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
        } catch (java.text.ParseException parse) {
            Locale str = Locale.US;
            int arr2 = 1;
            arr2 = new Object[arr2];
            arr2[arr] = jsonReader;
            jsonReader = "Failed to parse Date from: %s";
            jsonReader = String.format(str, jsonReader, arr2);
            int arr = new Object[arr];
            str = "ZendeskDateTypeAdapter";
            a.d(str, jsonReader, parse, arr);
            return obj;
        }
        return e(jsonReader.nextString(), new ParsePosition(0));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.value(b(date));
    }
}
