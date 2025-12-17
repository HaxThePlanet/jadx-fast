package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class JsonObject extends com.google.gson.JsonElement {

    private final LinkedTreeMap<String, com.google.gson.JsonElement> members;
    public JsonObject() {
        super();
        LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
        this.members = linkedTreeMap;
    }

    @Override // com.google.gson.JsonElement
    public void add(String string, com.google.gson.JsonElement jsonElement2) {
        com.google.gson.JsonNull obj3;
        if (jsonElement2 == null) {
            obj3 = JsonNull.INSTANCE;
        }
        this.members.put(string, obj3);
    }

    @Override // com.google.gson.JsonElement
    public void addProperty(String string, Boolean boolean2) {
        com.google.gson.JsonPrimitive jsonPrimitive;
        com.google.gson.JsonElement obj3;
        if (boolean2 == null) {
            obj3 = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(boolean2);
            obj3 = jsonPrimitive;
        }
        add(string, obj3);
    }

    @Override // com.google.gson.JsonElement
    public void addProperty(String string, Character character2) {
        com.google.gson.JsonPrimitive jsonPrimitive;
        com.google.gson.JsonElement obj3;
        if (character2 == null) {
            obj3 = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(character2);
            obj3 = jsonPrimitive;
        }
        add(string, obj3);
    }

    @Override // com.google.gson.JsonElement
    public void addProperty(String string, Number number2) {
        com.google.gson.JsonPrimitive jsonPrimitive;
        com.google.gson.JsonElement obj3;
        if (number2 == null) {
            obj3 = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(number2);
            obj3 = jsonPrimitive;
        }
        add(string, obj3);
    }

    @Override // com.google.gson.JsonElement
    public void addProperty(String string, String string2) {
        com.google.gson.JsonPrimitive jsonPrimitive;
        com.google.gson.JsonElement obj3;
        if (string2 == null) {
            obj3 = JsonNull.INSTANCE;
        } else {
            jsonPrimitive = new JsonPrimitive(string2);
            obj3 = jsonPrimitive;
        }
        add(string, obj3);
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonElement deepCopy() {
        return deepCopy();
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonObject deepCopy() {
        com.google.gson.JsonElement deepCopy;
        Object key;
        JsonObject jsonObject = new JsonObject();
        Iterator iterator = this.members.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            jsonObject.add((String)next2.getKey(), (JsonElement)next2.getValue().deepCopy());
        }
        return jsonObject;
    }

    public Set<Map.Entry<String, com.google.gson.JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    @Override // com.google.gson.JsonElement
    public boolean equals(Object object) {
        boolean members;
        Object obj2;
        if (object != this) {
            if (object instanceof JsonObject != null && object.members.equals(this.members)) {
                if (object.members.equals(this.members)) {
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
    public com.google.gson.JsonElement get(String string) {
        return (JsonElement)this.members.get(string);
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonArray getAsJsonArray(String string) {
        return (JsonArray)this.members.get(string);
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonObject getAsJsonObject(String string) {
        return (JsonObject)this.members.get(string);
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonPrimitive getAsJsonPrimitive(String string) {
        return (JsonPrimitive)this.members.get(string);
    }

    @Override // com.google.gson.JsonElement
    public boolean has(String string) {
        return this.members.containsKey(string);
    }

    @Override // com.google.gson.JsonElement
    public int hashCode() {
        return this.members.hashCode();
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonElement remove(String string) {
        return (JsonElement)this.members.remove(string);
    }

    @Override // com.google.gson.JsonElement
    public int size() {
        return this.members.size();
    }
}
