package com.vimeo.networking.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
@Deprecated
public class ISO8601 {

    private static final SimpleDateFormat dateFormat;
    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
        ISO8601.dateFormat = simpleDateFormat;
    }

    public static String fromDate(Date date) {
        String obj3 = ISO8601.dateFormat.format(date);
        StringBuilder stringBuilder = new StringBuilder();
        final int i2 = 22;
        stringBuilder.append(obj3.substring(0, i2));
        stringBuilder.append(":");
        stringBuilder.append(obj3.substring(i2));
        return stringBuilder.toString();
    }

    public static JsonDeserializer<Date> getDateDeserializer() {
        ISO8601.2 anon = new ISO8601.2();
        return anon;
    }

    public static JsonSerializer<Date> getDateSerializer() {
        ISO8601.1 anon = new ISO8601.1();
        return anon;
    }

    public static String now() {
        Date date = new Date();
        return ISO8601.fromDate(date);
    }

    public static Date toDate(String string) {
        String obj4 = string.replace("Z", "+00:00");
        int i = 22;
        int i3 = 0;
        if (obj4.charAt(i) != 58) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj4.substring(i3, i));
            stringBuilder.append(obj4.substring(23));
            return ISO8601.dateFormat.parse(stringBuilder.toString());
        }
        obj4 = new ParseException("Invalid ISO 8601 format", i3);
        throw obj4;
    }
}
