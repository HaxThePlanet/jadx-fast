package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class JsonStreamParser implements Iterator<com.google.gson.JsonElement> {

    private final Object lock;
    private final JsonReader parser;
    public JsonStreamParser(Reader reader) {
        super();
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        Object obj2 = new Object();
        this.lock = obj2;
    }

    public JsonStreamParser(String string) {
        StringReader stringReader = new StringReader(string);
        super(stringReader);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        final Object lock = this.lock;
        synchronized (lock) {
            i = 1;
            try {
                return i;
                JsonIOException jsonSyntaxException = new JsonIOException(th);
                throw jsonSyntaxException;
                jsonSyntaxException = new JsonSyntaxException(th);
                throw jsonSyntaxException;
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    @Override // java.util.Iterator
    public com.google.gson.JsonElement next() {
        Throwable th;
        String str = "Failed parsing JSON source to Json";
        if (!hasNext()) {
        } else {
            return Streams.parse(this.parser);
        }
        NoSuchElementException noSuchElementException2 = new NoSuchElementException();
        throw noSuchElementException2;
    }

    @Override // java.util.Iterator
    public Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
