package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class JsonTreeWriter extends JsonWriter {

    private static final JsonPrimitive SENTINEL_CLOSED;
    private static final Writer UNWRITABLE_WRITER;
    private String pendingName;
    private JsonElement product;
    private final List<JsonElement> stack;
    static {
        JsonTreeWriter.1 anon = new JsonTreeWriter.1();
        JsonTreeWriter.UNWRITABLE_WRITER = anon;
        JsonPrimitive jsonPrimitive = new JsonPrimitive("closed");
        JsonTreeWriter.SENTINEL_CLOSED = jsonPrimitive;
    }

    public JsonTreeWriter() {
        super(JsonTreeWriter.UNWRITABLE_WRITER);
        ArrayList arrayList = new ArrayList();
        this.stack = arrayList;
        this.product = JsonNull.INSTANCE;
    }

    private JsonElement peek() {
        List stack = this.stack;
        return (JsonElement)stack.get(size--);
    }

    private void put(JsonElement jsonElement) {
        JsonElement serializeNulls;
        boolean pendingName;
        JsonElement obj3;
        if (this.pendingName != null) {
            if (jsonElement.isJsonNull()) {
                if (getSerializeNulls()) {
                    (JsonObject)peek().add(this.pendingName, jsonElement);
                }
            } else {
            }
            this.pendingName = 0;
        } else {
            if (this.stack.isEmpty()) {
                this.product = jsonElement;
            } else {
                serializeNulls = peek();
                if (serializeNulls instanceof JsonArray == null) {
                } else {
                    (JsonArray)serializeNulls.add(jsonElement);
                }
            }
        }
        obj3 = new IllegalStateException();
        throw obj3;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() {
        JsonArray jsonArray = new JsonArray();
        put(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() {
        JsonObject jsonObject = new JsonObject();
        put(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public void close() {
        if (!this.stack.isEmpty()) {
        } else {
            this.stack.add(JsonTreeWriter.SENTINEL_CLOSED);
        }
        IOException iOException = new IOException("Incomplete document");
        throw iOException;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() {
        boolean pendingName;
        if (this.stack.isEmpty()) {
        } else {
            if (this.pendingName != null) {
            } else {
                if (peek instanceof JsonArray == null) {
                } else {
                    List stack2 = this.stack;
                    stack2.remove(size--);
                    return this;
                }
                IllegalStateException illegalStateException2 = new IllegalStateException();
                throw illegalStateException2;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() {
        boolean pendingName;
        if (this.stack.isEmpty()) {
        } else {
            if (this.pendingName != null) {
            } else {
                if (peek instanceof JsonObject == null) {
                } else {
                    List stack2 = this.stack;
                    stack2.remove(size--);
                    return this;
                }
                IllegalStateException illegalStateException2 = new IllegalStateException();
                throw illegalStateException2;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.stream.JsonWriter
    public void flush() {
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonElement get() {
        if (!this.stack.isEmpty()) {
        } else {
            return this.product;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected one JSON element but was ");
        stringBuilder.append(this.stack);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String string) {
        boolean pendingName;
        Objects.requireNonNull(string, "name == null");
        if (this.stack.isEmpty()) {
        } else {
            if (this.pendingName != null) {
            } else {
                if (peek instanceof JsonObject == null) {
                } else {
                    this.pendingName = string;
                    return this;
                }
                IllegalStateException obj2 = new IllegalStateException();
                throw obj2;
            }
        }
        obj2 = new IllegalStateException();
        throw obj2;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() {
        put(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d) {
        boolean naN;
        if (!isLenient()) {
            if (Double.isNaN(d)) {
            } else {
                if (Double.isInfinite(d)) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        JsonPrimitive jsonPrimitive = new JsonPrimitive(Double.valueOf(d));
        put(jsonPrimitive);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long l) {
        JsonPrimitive jsonPrimitive = new JsonPrimitive(Long.valueOf(l));
        put(jsonPrimitive);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean boolean) {
        if (boolean == null) {
            return nullValue();
        }
        JsonPrimitive jsonPrimitive = new JsonPrimitive(boolean);
        put(jsonPrimitive);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) {
        boolean doubleValue;
        boolean naN;
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue)) {
            } else {
                if (Double.isInfinite(doubleValue)) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(number);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        JsonPrimitive jsonPrimitive = new JsonPrimitive(number);
        put(jsonPrimitive);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String string) {
        if (string == null) {
            return nullValue();
        }
        JsonPrimitive jsonPrimitive = new JsonPrimitive(string);
        put(jsonPrimitive);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z) {
        JsonPrimitive jsonPrimitive = new JsonPrimitive(Boolean.valueOf(z));
        put(jsonPrimitive);
        return this;
    }
}
