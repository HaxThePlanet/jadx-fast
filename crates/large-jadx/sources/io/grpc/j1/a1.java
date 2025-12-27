package io.grpc.j1;

import com.google.common.base.n;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: JsonParser.java */
/* loaded from: classes3.dex */
public final class a1 {

    private static final Logger a;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[JsonToken.values().length];
            a1.a.a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a1.a.a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a1.a.a[JsonToken.STRING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a1.a.a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a1.a.a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a1.a.a[JsonToken.NULL.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        a1.a = Logger.getLogger(a1.class.getName());
    }

    private a1() {
        super();
    }

    public static Object a(String str) {
        Throwable th;
        Logger logger;
        Level wARNING2;
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        try {
        } catch (java.io.IOException ioException) {
            logger = a1.a;
            wARNING2 = Level.WARNING;
            logger.log(wARNING2, str2, ioException);
        }
        try {
            jsonReader.close();
        } catch (java.io.IOException ioException) {
            logger = a1.a;
            wARNING2 = Level.WARNING;
            logger.log(wARNING2, str2, ioException);
        }
        return a1.e(jsonReader);
    }

    private static List<?> b(JsonReader jsonReader) {
        boolean z = false;
        jsonReader.beginArray();
        final ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            arrayList.add(a1.e(jsonReader));
        }
        int r1 = jsonReader.peek() == JsonToken.END_ARRAY ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Bad token: ";
        String path = jsonReader.getPath();
        str = str2 + path;
        n.v((jsonReader.peek() == JsonToken.END_ARRAY ? 1 : 0), str2 + path);
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    private static Void c(JsonReader jsonReader) {
        jsonReader.nextNull();
        return null;
    }

    private static Map<String, ?> d(JsonReader jsonReader) {
        boolean z = false;
        jsonReader.beginObject();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (jsonReader.hasNext()) {
            linkedHashMap.put(jsonReader.nextName(), a1.e(jsonReader));
        }
        int r1 = jsonReader.peek() == JsonToken.END_OBJECT ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Bad token: ";
        String path = jsonReader.getPath();
        str = str2 + path;
        n.v((jsonReader.peek() == JsonToken.END_OBJECT ? 1 : 0), str2 + path);
        jsonReader.endObject();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static Object e(JsonReader jsonReader) {
        n.v(jsonReader.hasNext(), "unexpected end of JSON");
        int ordinal = jsonReader.peek().ordinal();
        switch (a1.a.a[ordinal]) {
            case 1:
                return a1.b(jsonReader);
            case 2:
                return a1.d(jsonReader);
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble(), ordinal);
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                return a1.c(jsonReader);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                final String str2 = "Bad token: ";
                String path = jsonReader.getPath();
                jsonReader = str2 + path;
                throw new IllegalStateException(str2 + path);
        }
    }
}
