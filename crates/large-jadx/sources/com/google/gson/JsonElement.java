package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public abstract class JsonElement {
    public abstract com.google.gson.JsonElement deepCopy();

    public BigDecimal getAsBigDecimal() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public BigInteger getAsBigInteger() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public boolean getAsBoolean() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public byte getAsByte() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    @Deprecated
    public char getAsCharacter() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public double getAsDouble() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public float getAsFloat() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public int getAsInt() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public com.google.gson.JsonArray getAsJsonArray() {
        if (!isJsonArray()) {
        } else {
            return (JsonArray)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a JSON Array: ");
        stringBuilder.append(this);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public com.google.gson.JsonNull getAsJsonNull() {
        if (!isJsonNull()) {
        } else {
            return (JsonNull)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a JSON Null: ");
        stringBuilder.append(this);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public com.google.gson.JsonObject getAsJsonObject() {
        if (!isJsonObject()) {
        } else {
            return (JsonObject)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a JSON Object: ");
        stringBuilder.append(this);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public com.google.gson.JsonPrimitive getAsJsonPrimitive() {
        if (!isJsonPrimitive()) {
        } else {
            return (JsonPrimitive)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a JSON Primitive: ");
        stringBuilder.append(this);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public long getAsLong() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public Number getAsNumber() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public short getAsShort() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public String getAsString() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException;
    }

    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            Streams.write(this, jsonWriter);
            return stringWriter.toString();
            AssertionError assertionError = new AssertionError(th);
            throw assertionError;
        }
    }
}
