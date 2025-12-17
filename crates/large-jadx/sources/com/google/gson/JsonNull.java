package com.google.gson;

/* loaded from: classes2.dex */
public final class JsonNull extends com.google.gson.JsonElement {

    public static final com.google.gson.JsonNull INSTANCE;
    static {
        JsonNull jsonNull = new JsonNull();
        JsonNull.INSTANCE = jsonNull;
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonElement deepCopy() {
        return deepCopy();
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonNull deepCopy() {
        return JsonNull.INSTANCE;
    }

    @Override // com.google.gson.JsonElement
    public boolean equals(Object object) {
        int obj1;
        if (this != object) {
            if (object instanceof JsonNull) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    @Override // com.google.gson.JsonElement
    public int hashCode() {
        return JsonNull.class.hashCode();
    }
}
