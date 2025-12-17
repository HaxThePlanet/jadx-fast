package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes2.dex */
public abstract class TypeAdapter<T>  {
    public final T fromJson(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        return read(jsonReader);
    }

    public final T fromJson(String string) {
        StringReader stringReader = new StringReader(string);
        return fromJson(stringReader);
    }

    public final T fromJsonTree(com.google.gson.JsonElement jsonElement) {
        try {
            JsonTreeReader jsonTreeReader = new JsonTreeReader(jsonElement);
            return read(jsonTreeReader);
            JsonIOException jsonIOException = new JsonIOException(jsonElement);
            throw jsonIOException;
        }
    }

    public final com.google.gson.TypeAdapter<T> nullSafe() {
        TypeAdapter.1 anon = new TypeAdapter.1(this);
        return anon;
    }

    public abstract T read(JsonReader jsonReader);

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        toJson(stringWriter, t);
        return stringWriter.toString();
    }

    public final void toJson(Writer writer, T t2) {
        JsonWriter jsonWriter = new JsonWriter(writer);
        write(jsonWriter, t2);
    }

    public final com.google.gson.JsonElement toJsonTree(T t) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, t);
            return jsonTreeWriter.get();
            JsonIOException jsonIOException = new JsonIOException(t);
            throw jsonIOException;
        }
    }

    public abstract void write(JsonWriter jsonWriter, T t2);
}
