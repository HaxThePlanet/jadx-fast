package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class JsonArray extends com.google.gson.JsonElement implements Iterable<com.google.gson.JsonElement> {

    private final List<com.google.gson.JsonElement> elements;
    public JsonArray() {
        super();
        ArrayList arrayList = new ArrayList();
        this.elements = arrayList;
    }

    public JsonArray(int i) {
        super();
        ArrayList arrayList = new ArrayList(i);
        this.elements = arrayList;
    }

    @Override // com.google.gson.JsonElement
    public void add(com.google.gson.JsonElement jsonElement) {
        com.google.gson.JsonNull obj2;
        if (jsonElement == null) {
            obj2 = JsonNull.INSTANCE;
        }
        this.elements.add(obj2);
    }

    @Override // com.google.gson.JsonElement
    public void add(Boolean boolean) {
        com.google.gson.JsonPrimitive jsonPrimitive;
        com.google.gson.JsonElement obj3;
        if (boolean == null) {
            obj3 = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(boolean);
            obj3 = jsonPrimitive;
        }
        this.elements.add(obj3);
    }

    @Override // com.google.gson.JsonElement
    public void add(Character character) {
        com.google.gson.JsonPrimitive jsonPrimitive;
        com.google.gson.JsonElement obj3;
        if (character == null) {
            obj3 = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(character);
            obj3 = jsonPrimitive;
        }
        this.elements.add(obj3);
    }

    @Override // com.google.gson.JsonElement
    public void add(Number number) {
        com.google.gson.JsonPrimitive jsonPrimitive;
        com.google.gson.JsonElement obj3;
        if (number == null) {
            obj3 = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(number);
            obj3 = jsonPrimitive;
        }
        this.elements.add(obj3);
    }

    @Override // com.google.gson.JsonElement
    public void add(String string) {
        com.google.gson.JsonPrimitive jsonPrimitive;
        com.google.gson.JsonElement obj3;
        if (string == null) {
            obj3 = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(string);
            obj3 = jsonPrimitive;
        }
        this.elements.add(obj3);
    }

    @Override // com.google.gson.JsonElement
    public void addAll(com.google.gson.JsonArray jsonArray) {
        this.elements.addAll(jsonArray.elements);
    }

    @Override // com.google.gson.JsonElement
    public boolean contains(com.google.gson.JsonElement jsonElement) {
        return this.elements.contains(jsonElement);
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonArray deepCopy() {
        com.google.gson.JsonElement deepCopy;
        if (!this.elements.isEmpty()) {
            JsonArray jsonArray2 = new JsonArray(this.elements.size());
            Iterator iterator = this.elements.iterator();
            for (JsonElement next2 : iterator) {
                jsonArray2.add(next2.deepCopy());
            }
            return jsonArray2;
        }
        JsonArray jsonArray = new JsonArray();
        return jsonArray;
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonElement deepCopy() {
        return deepCopy();
    }

    @Override // com.google.gson.JsonElement
    public boolean equals(Object object) {
        boolean elements;
        Object obj2;
        if (object != this) {
            if (object instanceof JsonArray != null && object.elements.equals(this.elements)) {
                if (object.elements.equals(this.elements)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonElement get(int i) {
        return (JsonElement)this.elements.get(i);
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsBigDecimal();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsBigInteger();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsBoolean();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsByte();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsCharacter();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsDouble();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsFloat();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsInt();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsLong();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsNumber();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsShort();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        if (this.elements.size() != 1) {
        } else {
            return (JsonElement)this.elements.get(0).getAsString();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    @Override // com.google.gson.JsonElement
    public int hashCode() {
        return this.elements.hashCode();
    }

    @Override // com.google.gson.JsonElement
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public Iterator<com.google.gson.JsonElement> iterator() {
        return this.elements.iterator();
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonElement remove(int i) {
        return (JsonElement)this.elements.remove(i);
    }

    @Override // com.google.gson.JsonElement
    public boolean remove(com.google.gson.JsonElement jsonElement) {
        return this.elements.remove(jsonElement);
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonElement set(int i, com.google.gson.JsonElement jsonElement2) {
        return (JsonElement)this.elements.set(i, jsonElement2);
    }

    @Override // com.google.gson.JsonElement
    public int size() {
        return this.elements.size();
    }
}
