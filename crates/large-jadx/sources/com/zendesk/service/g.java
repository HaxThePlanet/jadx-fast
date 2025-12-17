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

/* loaded from: classes2.dex */
public class g extends TypeAdapter<Date> {

    private static final TimeZone a;
    static {
        g.a = TimeZone.getTimeZone("UTC");
    }

    private boolean a(String string, int i2, char c3) {
        char obj2;
        if (i2 < string.length() && string.charAt(i2) == c3) {
            obj2 = string.charAt(i2) == c3 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private String b(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(g.a, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder obj6 = new StringBuilder(21);
        int i4 = 1;
        d(obj6, gregorianCalendar.get(i4), 4);
        int i13 = 45;
        obj6.append(i13);
        int i17 = 2;
        d(obj6, i18 += i4, i17);
        obj6.append(i13);
        d(obj6, gregorianCalendar.get(5), i17);
        obj6.append('T');
        d(obj6, gregorianCalendar.get(11), i17);
        int i10 = 58;
        obj6.append(i10);
        d(obj6, gregorianCalendar.get(12), i17);
        obj6.append(i10);
        d(obj6, gregorianCalendar.get(13), i17);
        obj6.append('Z');
        return obj6.toString();
    }

    private static int c(String string, int i2) {
        int i;
        while (i2 < string.length()) {
            char charAt = string.charAt(i2);
            i2++;
        }
        return string.length();
    }

    private void d(StringBuilder stringBuilder, int i2, int i3) {
        int length;
        int obj4;
        final String obj3 = Integer.toString(i2);
        i3 -= length;
        while (obj4 > 0) {
            stringBuilder.append('0');
            obj4--;
        }
        stringBuilder.append(obj3);
    }

    private Date e(String string, ParsePosition parsePosition2) {
        int string3;
        String string2;
        StringBuilder parseException;
        int i9;
        int stringBuilder;
        int i7;
        int i10;
        int i4;
        int i;
        int i6;
        int length;
        int i12;
        int i3;
        int charAt;
        int i2;
        int i8;
        int i5;
        int i11;
        final Object obj = this;
        final String str = string;
        final int obj2 = parsePosition2;
        int index = parsePosition2.getIndex();
        i9 = index + 4;
        int i13 = obj.f(str, index, i9);
        int i22 = 45;
        if (obj.a(str, i9, i22)) {
            i9++;
        }
        i10 = i9 + 2;
        int i19 = obj.f(str, i9, i10);
        if (obj.a(str, i10, i22)) {
            i10++;
        }
        i4 = i10 + 2;
        int i25 = obj.f(str, i10, i4);
        boolean z3 = obj.a(str, i4, 'T');
        final int i30 = 1;
        if (!z3 && string.length() <= i4) {
            if (string.length() <= i4) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i13, i19 -= i30, i25);
                obj2.setIndex(i4);
                return gregorianCalendar.getTime();
            }
        }
        int i31 = 90;
        final int i33 = 2;
        if (z3) {
            try {
                i4++;
                i = i26 + 2;
                int i27 = obj.f(str, i26, i);
                int i34 = 58;
                if (obj.a(str, i, i34)) {
                }
                i++;
                i8 = i + 2;
                i6 = obj.f(str, i, i8);
                if (obj.a(str, i8, i34)) {
                }
                i8++;
                charAt = str.charAt(i8);
                if (string.length() > i8 && charAt != i31 && charAt != 43 && charAt != i22) {
                } else {
                }
                charAt = str.charAt(i8);
                if (charAt != i31) {
                } else {
                }
                if (charAt != 43) {
                } else {
                }
                if (charAt != i22) {
                } else {
                }
                int i23 = i8 + 2;
                i3 = obj.f(str, i8, i23);
                int i35 = 59;
                if (i3 > i35 && i3 < 63) {
                }
                if (i3 < 63) {
                }
                i3 = i35;
                if (obj.a(str, i23, '.')) {
                } else {
                }
                i23++;
                int i38 = g.c(str, i24 + 1);
                int i40 = Math.min(i38, i24 + 3);
                i5 = obj.f(str, i24, i40);
                i40 -= i24;
                if (i8 != i30) {
                } else {
                }
                if (i8 != i33) {
                } else {
                }
                i5 *= 10;
                i5 *= 100;
                i7 = i27;
                i4 = i38;
                i2 = i5;
                i2 = 0;
                i4 = i23;
                i7 = i11;
                i7 = i27;
                i4 = i8;
                i7 = 0;
                i6 = 0;
                i3 = 0;
                i2 = 0;
                if (string.length() <= i4) {
                } else {
                }
                char charAt2 = str.charAt(i4);
                if (charAt2 != i31) {
                } else {
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(g.a);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(i30, i13);
                gregorianCalendar2.set(i33, i19 -= i30);
                gregorianCalendar2.set(5, i25);
                gregorianCalendar2.set(11, i7);
                gregorianCalendar2.set(12, i6);
                gregorianCalendar2.set(13, i3);
                gregorianCalendar2.set(14, i2);
                obj2.setIndex(i4 += i30);
                return gregorianCalendar2.getTime();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid time zone indicator '");
                stringBuilder2.append(charAt2);
                stringBuilder2.append("'");
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.toString());
                throw indexOutOfBoundsException;
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No time zone indicator");
                throw illegalArgumentException;
                if (string3 == null) {
                } else {
                }
                string3 = 0;
                parseException = new StringBuilder();
                stringBuilder = 34;
                parseException.append(stringBuilder);
                parseException.append(string3);
                parseException.append(string2);
                string3 = parseException.toString();
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
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to parse date [");
                stringBuilder.append(string3);
                string3 = "]: ";
                stringBuilder.append(string3);
                stringBuilder.append(string2);
                string3 = stringBuilder.toString();
                parseException = new ParseException(string3, parsePosition2.getIndex());
                parseException.initCause(th);
                throw parseException;
            }
        } else {
        }
    }

    private int f(String string, int i2, int i3) {
        int length;
        int i;
        int i4;
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
                        i = i2 + 1;
                        int digit2 = Character.digit(string.charAt(i2), i7);
                        if (digit2 < 0) {
                        } else {
                            i4 = -digit2;
                            while (i < i3) {
                                int digit = Character.digit(string.charAt(i), i7);
                                i8 -= digit;
                                i = i5;
                            }
                            return -i4;
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str);
                        stringBuilder2.append(string.substring(i2, i3));
                        NumberFormatException numberFormatException2 = new NumberFormatException(stringBuilder2.toString());
                        throw numberFormatException2;
                    }
                    i4 = i6;
                    i = i2;
                }
            }
        }
        NumberFormatException obj7 = new NumberFormatException(string);
        throw obj7;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) {
        return read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        return e(jsonReader.nextString(), parsePosition);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object object2) {
        write(jsonWriter, (Date)object2);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date2) {
        if (date2 == null) {
            jsonWriter.nullValue();
        }
        jsonWriter.value(b(date2));
    }
}
