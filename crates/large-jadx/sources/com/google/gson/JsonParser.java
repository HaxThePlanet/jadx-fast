package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes2.dex */
public final class JsonParser {
    public static com.google.gson.JsonElement parseReader(JsonReader jsonReader) {
        String str = " to Json";
        final String str2 = "Failed parsing JSON source: ";
        jsonReader.setLenient(true);
        jsonReader.setLenient(jsonReader.isLenient());
        return Streams.parse(jsonReader);
    }

    public static com.google.gson.JsonElement parseReader(Reader reader) {
        Object jsonReader;
        boolean eND_DOCUMENT;
        try {
            jsonReader = new JsonReader(reader);
            com.google.gson.JsonElement obj2 = JsonParser.parseReader(jsonReader);
            if (!obj2.isJsonNull()) {
            }
            if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
            } else {
            }
            obj2 = new JsonSyntaxException("Did not consume the entire document.");
            throw obj2;
            return obj2;
            JsonSyntaxException jsonSyntaxException = new JsonSyntaxException(reader);
            throw jsonSyntaxException;
            jsonSyntaxException = new JsonIOException(reader);
            throw jsonSyntaxException;
            jsonSyntaxException = new JsonSyntaxException(reader);
            throw jsonSyntaxException;
        }
    }

    public static com.google.gson.JsonElement parseString(String string) {
        StringReader stringReader = new StringReader(string);
        return JsonParser.parseReader(stringReader);
    }

    @Deprecated
    public com.google.gson.JsonElement parse(JsonReader jsonReader) {
        return JsonParser.parseReader(jsonReader);
    }

    @Deprecated
    public com.google.gson.JsonElement parse(Reader reader) {
        return JsonParser.parseReader(reader);
    }

    @Deprecated
    public com.google.gson.JsonElement parse(String string) {
        return JsonParser.parseString(string);
    }
}
