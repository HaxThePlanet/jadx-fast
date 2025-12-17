package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes2.dex */
public final class Streams {

    private static final class AppendableWriter extends Writer {

        private final java.lang.Appendable appendable;
        private final com.google.gson.internal.Streams.AppendableWriter.CurrentWrite currentWrite;
        AppendableWriter(java.lang.Appendable appendable) {
            super();
            Streams.AppendableWriter.CurrentWrite currentWrite = new Streams.AppendableWriter.CurrentWrite();
            this.currentWrite = currentWrite;
            this.appendable = appendable;
        }

        @Override // java.io.Writer
        public void close() {
        }

        @Override // java.io.Writer
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) {
            this.appendable.append((char)i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            final com.google.gson.internal.Streams.AppendableWriter.CurrentWrite currentWrite = this.currentWrite;
            currentWrite.chars = cArr;
            this.appendable.append(currentWrite, i2, i3 += i2);
        }
    }
    private Streams() {
        super();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public static JsonElement parse(JsonReader jsonReader) {
        try {
            jsonReader.peek();
            final int i = 0;
            return (JsonElement)TypeAdapters.JSON_ELEMENT.read(jsonReader);
            JsonSyntaxException jsonSyntaxException = new JsonSyntaxException(jsonReader);
            throw jsonSyntaxException;
        } catch (java.io.EOFException e) {
        } catch (com.google.gson.stream.MalformedJsonException malformedJson1) {
        } catch (java.io.IOException ioException2) {
        } catch (java.lang.NumberFormatException numberFormat3) {
        }
        if (jsonSyntaxException == null) {
        } else {
            jsonReader = JsonNull.INSTANCE;
            return jsonReader;
        }
        jsonSyntaxException = new JsonSyntaxException(jsonReader);
        throw jsonSyntaxException;
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter2) {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter2, jsonElement);
    }

    public static Writer writerForAppendable(java.lang.Appendable appendable) {
        boolean appendableWriter;
        Object obj1;
        if (appendable instanceof Writer) {
        } else {
            appendableWriter = new Streams.AppendableWriter((Writer)appendable);
            obj1 = appendableWriter;
        }
        return obj1;
    }
}
