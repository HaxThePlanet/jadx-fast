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

/* compiled from: ISO8601.java */
@Deprecated
/* loaded from: classes2.dex */
public class ISO8601 {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat();
    static {
    }

    public static String fromDate(Date date) {
        String format = ISO8601.dateFormat.format(date);
        StringBuilder stringBuilder = new StringBuilder();
        final int i2 = 22;
        String substring = format.substring(0, i2);
        String str = ":";
        String substring2 = format.substring(i2);
        str2 = substring + str + substring2;
        return str2;
    }

    public static JsonDeserializer<Date> getDateDeserializer() {
        return new ISO8601.AnonymousClass2();
    }

    public static JsonSerializer<Date> getDateSerializer() {
        return new ISO8601.AnonymousClass1();
    }

    public static String now() {
        return ISO8601.fromDate(new Date());
    }

    public static Date toDate(String str) throws ParseException {
        String replaced = str.replace("Z", "+00:00");
        int i = 22;
        int i3 = 0;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String substring = replaced.substring(i3, i);
            String substring2 = replaced.substring(23);
            str6 = substring + substring2;
        } catch (java.lang.IndexOutOfBoundsException unused) {
            str = new ParseException("Invalid length", r1);
            throw str;
        }
        try {
            throw new ParseException("Invalid ISO 8601 format", i3);
        } catch (java.lang.IndexOutOfBoundsException unused) {
            str = new ParseException("Invalid length", r1);
            throw str;
        }
    }
}
