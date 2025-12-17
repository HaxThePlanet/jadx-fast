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

/* loaded from: classes3.dex */
public final class a1 {

    private static final Logger a;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a1.a.a = iArr;
            iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            a1.a.a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            a1.a.a[JsonToken.STRING.ordinal()] = 3;
            a1.a.a[JsonToken.NUMBER.ordinal()] = 4;
            a1.a.a[JsonToken.BOOLEAN.ordinal()] = 5;
            a1.a.a[JsonToken.NULL.ordinal()] = 6;
        }
    }
    static {
        a1.a = Logger.getLogger(a1.class.getName());
    }

    public static Object a(String string) {
        Throwable th;
        JsonReader jsonReader;
        Logger logger;
        StringReader stringReader;
        Level wARNING;
        final String str = "Failed to close";
        stringReader = new StringReader(string);
        jsonReader = new JsonReader(stringReader);
        jsonReader.close();
        return a1.e(jsonReader);
    }

    private static List<?> b(JsonReader jsonReader) {
        Object obj;
        int i;
        jsonReader.beginArray();
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            arrayList.add(a1.e(jsonReader));
        }
        i = jsonReader.peek() == JsonToken.END_ARRAY ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad token: ");
        stringBuilder.append(jsonReader.getPath());
        n.v(i, stringBuilder.toString());
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    private static Void c(JsonReader jsonReader) {
        jsonReader.nextNull();
        return null;
    }

    private static Map<String, ?> d(JsonReader jsonReader) {
        String nextName;
        int i;
        Object obj;
        jsonReader.beginObject();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (jsonReader.hasNext()) {
            linkedHashMap.put(jsonReader.nextName(), a1.e(jsonReader));
        }
        i = jsonReader.peek() == JsonToken.END_OBJECT ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad token: ");
        stringBuilder.append(jsonReader.getPath());
        n.v(i, stringBuilder.toString());
        jsonReader.endObject();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static Object e(JsonReader jsonReader) {
        int i;
        n.v(jsonReader.hasNext(), "unexpected end of JSON");
        int ordinal = jsonReader.peek().ordinal();
        switch (i2) {
            case 1:
                return a1.b(jsonReader);
            case 2:
                return a1.d(jsonReader);
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                return a1.c(jsonReader);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bad token: ");
                stringBuilder.append(jsonReader.getPath());
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                throw illegalStateException;
        }
    }
}
