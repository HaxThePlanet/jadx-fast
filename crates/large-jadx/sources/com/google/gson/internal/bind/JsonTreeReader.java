package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class JsonTreeReader extends JsonReader {

    private static final Object SENTINEL_CLOSED;
    private static final Reader UNREADABLE_READER;
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize = 0;
    static {
        JsonTreeReader.1 anon = new JsonTreeReader.1();
        JsonTreeReader.UNREADABLE_READER = anon;
        Object object = new Object();
        JsonTreeReader.SENTINEL_CLOSED = object;
    }

    public JsonTreeReader(JsonElement jsonElement) {
        super(JsonTreeReader.UNREADABLE_READER);
        int i = 32;
        this.stack = new Object[i];
        int i2 = 0;
        this.pathNames = new String[i];
        this.pathIndices = new int[i];
        push(jsonElement);
    }

    private void expect(JsonToken jsonToken) {
        if (peek() != jsonToken) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected ");
        stringBuilder.append(jsonToken);
        stringBuilder.append(" but was ");
        stringBuilder.append(peek());
        stringBuilder.append(locationString());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    private String locationString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        return stringBuilder.toString();
    }

    private Object peekStack() {
        return this.stack[stackSize--];
    }

    private Object popStack() {
        final Object[] stack = this.stack;
        stackSize--;
        this.stackSize = i;
        stack[i] = 0;
        return stack[i];
    }

    private void push(Object object) {
        int stackSize;
        Object[] pathNames;
        stackSize = this.stackSize;
        pathNames = this.stack;
        if (stackSize == pathNames.length) {
            stackSize *= 2;
            this.stack = Arrays.copyOf(pathNames, i);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i);
            this.pathNames = (String[])Arrays.copyOf(this.pathNames, i);
        }
        int stackSize2 = this.stackSize;
        this.stackSize = stackSize2 + 1;
        this.stack[stackSize2] = object;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() {
        expect(JsonToken.BEGIN_ARRAY);
        push((JsonArray)peekStack().iterator());
        this.pathIndices[stackSize--] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() {
        expect(JsonToken.BEGIN_OBJECT);
        push((JsonObject)peekStack().entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader
    public void close() {
        final int i = 1;
        final Object[] arr = new Object[i];
        arr[0] = JsonTreeReader.SENTINEL_CLOSED;
        this.stack = arr;
        this.stackSize = i;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() {
        int stackSize;
        int[] pathIndices;
        int i;
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
        stackSize = this.stackSize;
        if (stackSize > 0) {
            pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[stackSize] = i2++;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() {
        int stackSize;
        int[] pathIndices;
        int i;
        expect(JsonToken.END_OBJECT);
        popStack();
        popStack();
        stackSize = this.stackSize;
        if (stackSize > 0) {
            pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[stackSize] = i2++;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        int i;
        boolean pathNames;
        boolean z;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        i = 0;
        while (i < this.stackSize) {
            pathNames = this.stack;
            if (obj3 instanceof JsonArray != null) {
            } else {
            }
            i++;
            stringBuilder.append('.');
            pathNames = this.pathNames;
            if (obj4 instanceof JsonObject != null && obj2 instanceof Iterator && pathNames[i] != null) {
            }
            i++;
            i++;
            if (obj2 instanceof Iterator) {
            }
            stringBuilder.append('.');
            pathNames = this.pathNames;
            if (pathNames[i] != null) {
            }
            stringBuilder.append(pathNames[i]);
            i++;
            if (obj instanceof Iterator) {
            }
            stringBuilder.append('[');
            stringBuilder.append(this.pathIndices[i]);
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() {
        int i;
        JsonToken eND_OBJECT;
        JsonToken peek = peek();
        if (peek != JsonToken.END_OBJECT && peek != JsonToken.END_ARRAY) {
            i = peek != JsonToken.END_ARRAY ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() {
        int stackSize;
        int[] pathIndices;
        int i;
        expect(JsonToken.BOOLEAN);
        stackSize = this.stackSize;
        if (stackSize > 0) {
            pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[stackSize] = i2++;
        }
        return (JsonPrimitive)popStack().getAsBoolean();
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() {
        JsonToken sTRING;
        boolean naN;
        int stackSize;
        int[] pathIndices;
        int i;
        JsonToken peek = peek();
        JsonToken nUMBER = JsonToken.NUMBER;
        if (peek != nUMBER) {
            if (peek != JsonToken.STRING) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append(nUMBER);
            stringBuilder.append(" but was ");
            stringBuilder.append(peek);
            stringBuilder.append(locationString());
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        double asDouble = (JsonPrimitive)peekStack().getAsDouble();
        if (!isLenient()) {
            if (Double.isNaN(asDouble)) {
            } else {
                if (Double.isInfinite(asDouble)) {
                } else {
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("JSON forbids NaN and infinities: ");
            stringBuilder2.append(asDouble);
            NumberFormatException numberFormatException = new NumberFormatException(stringBuilder2.toString());
            throw numberFormatException;
        }
        popStack();
        stackSize = this.stackSize;
        if (stackSize > 0) {
            pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[stackSize] = i2++;
        }
        return asDouble;
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() {
        int stackSize;
        JsonToken pathIndices;
        int i;
        JsonToken peek = peek();
        JsonToken nUMBER = JsonToken.NUMBER;
        if (peek != nUMBER) {
            if (peek != JsonToken.STRING) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append(nUMBER);
            stringBuilder.append(" but was ");
            stringBuilder.append(peek);
            stringBuilder.append(locationString());
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        popStack();
        stackSize = this.stackSize;
        if (stackSize > 0) {
            pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[stackSize] = i2++;
        }
        return (JsonPrimitive)peekStack().getAsInt();
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() {
        JsonToken sTRING;
        int stackSize;
        int[] pathIndices;
        int i;
        JsonToken peek = peek();
        JsonToken nUMBER = JsonToken.NUMBER;
        if (peek != nUMBER) {
            if (peek != JsonToken.STRING) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append(nUMBER);
            stringBuilder.append(" but was ");
            stringBuilder.append(peek);
            stringBuilder.append(locationString());
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        popStack();
        stackSize = this.stackSize;
        if (stackSize > 0) {
            pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[stackSize] = i2++;
        }
        return (JsonPrimitive)peekStack().getAsLong();
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() {
        expect(JsonToken.NAME);
        Object next = (Iterator)peekStack().next();
        final Object key = (Map.Entry)next.getKey();
        this.pathNames[stackSize--] = (String)key;
        push(next.getValue());
        return key;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() {
        int stackSize;
        int[] pathIndices;
        int i;
        expect(JsonToken.NULL);
        popStack();
        stackSize = this.stackSize;
        if (stackSize > 0) {
            pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[stackSize] = i2++;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() {
        int stackSize;
        JsonToken pathIndices;
        int i;
        JsonToken peek = peek();
        JsonToken sTRING = JsonToken.STRING;
        if (peek != sTRING) {
            if (peek != JsonToken.NUMBER) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append(sTRING);
            stringBuilder.append(" but was ");
            stringBuilder.append(peek);
            stringBuilder.append(locationString());
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        stackSize = this.stackSize;
        if (stackSize > 0) {
            pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[stackSize] = i2++;
        }
        return (JsonPrimitive)popStack().getAsString();
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() {
        JsonToken eND_OBJECT;
        if (this.stackSize == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object peekStack = peekStack();
        boolean z6 = obj instanceof JsonObject;
        if (peekStack instanceof Iterator && (Iterator)peekStack.hasNext() && z6) {
            z6 = obj instanceof JsonObject;
            if ((Iterator)peekStack.hasNext()) {
                if (z6) {
                    return JsonToken.NAME;
                }
                push(peekStack.next());
                return peek();
            }
            eND_OBJECT = z6 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            return eND_OBJECT;
        }
        if (peekStack instanceof JsonObject != null) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (peekStack instanceof JsonArray != null) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (peekStack instanceof JsonPrimitive && (JsonPrimitive)peekStack.isString()) {
            if ((JsonPrimitive)peekStack.isString()) {
                return JsonToken.STRING;
            }
            if (peekStack.isBoolean()) {
                return JsonToken.BOOLEAN;
            }
            if (!peekStack.isNumber()) {
            } else {
                return JsonToken.NUMBER;
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
        if (peekStack instanceof JsonNull) {
            return JsonToken.NULL;
        }
        if (peekStack == JsonTreeReader.SENTINEL_CLOSED) {
            IllegalStateException illegalStateException = new IllegalStateException("JsonReader is closed");
            throw illegalStateException;
        }
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    @Override // com.google.gson.stream.JsonReader
    public void promoteNameToValue() {
        expect(JsonToken.NAME);
        Object next = (Iterator)peekStack().next();
        push((Map.Entry)next.getValue());
        JsonPrimitive jsonPrimitive = new JsonPrimitive((String)next.getKey());
        push(jsonPrimitive);
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() {
        String[] pathNames;
        int stackSize;
        int pathIndices;
        String str;
        str = "null";
        if (peek() == JsonToken.NAME) {
            nextName();
            this.pathNames[stackSize2 += -2] = str;
        } else {
            popStack();
            pathNames = this.stackSize;
            if (pathNames > 0) {
                this.pathNames[pathNames--] = str;
            }
        }
        stackSize = this.stackSize;
        if (stackSize > 0) {
            pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[stackSize] = i++;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return JsonTreeReader.class.getSimpleName();
    }
}
