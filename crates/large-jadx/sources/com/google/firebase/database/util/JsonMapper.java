package com.google.firebase.database.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* loaded from: classes2.dex */
public class JsonMapper {
    public static Map<String, Object> parseJson(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            return JsonMapper.unwrapJsonObject(jSONObject);
            IOException iOException = new IOException(string);
            throw iOException;
        }
    }

    public static Object parseJsonValue(String string) {
        try {
            JSONTokener jSONTokener = new JSONTokener(string);
            return JsonMapper.unwrapJson(jSONTokener.nextValue());
            IOException iOException = new IOException(string);
            throw iOException;
        }
    }

    public static String serializeJson(Map<String, Object> map) {
        return JsonMapper.serializeJsonValue(map);
    }

    public static String serializeJsonValue(Object object) {
        String obj2;
        if (object == null) {
            return "null";
        }
        if (object instanceof String != null) {
            return JSONObject.quote((String)object);
        }
        if (object instanceof Number) {
            return JSONObject.numberToString((Number)object);
        }
        if (object instanceof Boolean) {
            obj2 = (Boolean)object.booleanValue() ? "true" : "false";
            return obj2;
        }
        JSONStringer jSONStringer = new JSONStringer();
        JsonMapper.serializeJsonValue(object, jSONStringer);
        return jSONStringer.toString();
    }

    private static void serializeJsonValue(Object object, JSONStringer jSONStringer2) {
        boolean next;
        boolean value;
        Object key;
        Object obj2;
        if (object instanceof Map != null) {
            jSONStringer2.object();
            obj2 = (Map)object.entrySet().iterator();
            for (Map.Entry next2 : obj2) {
                jSONStringer2.key((String)next2.getKey());
                JsonMapper.serializeJsonValue(next2.getValue(), jSONStringer2);
            }
            jSONStringer2.endObject();
        } else {
            if (object instanceof Collection != null) {
                jSONStringer2.array();
                obj2 = (Collection)object.iterator();
                for (Object next : obj2) {
                    JsonMapper.serializeJsonValue(next, jSONStringer2);
                }
                jSONStringer2.endArray();
            } else {
                jSONStringer2.value(object);
            }
        }
    }

    private static Object unwrapJson(Object object) {
        Object obj1;
        if (object instanceof JSONObject != null) {
            return JsonMapper.unwrapJsonObject((JSONObject)object);
        }
        if (object instanceof JSONArray != null) {
            return JsonMapper.unwrapJsonArray((JSONArray)object);
        }
        if (object.equals(JSONObject.NULL)) {
            obj1 = 0;
        }
        return obj1;
    }

    private static List<Object> unwrapJsonArray(JSONArray jSONArray) {
        int i;
        Object unwrapJson;
        ArrayList arrayList = new ArrayList(jSONArray.length());
        i = 0;
        while (i < jSONArray.length()) {
            arrayList.add(JsonMapper.unwrapJson(jSONArray.get(i)));
            i++;
        }
        return arrayList;
    }

    private static Map<String, Object> unwrapJsonObject(JSONObject jSONObject) {
        Object next;
        Object unwrapJson;
        HashMap hashMap = new HashMap(jSONObject.length());
        Iterator keys = jSONObject.keys();
        for (String next : keys) {
            hashMap.put(next, JsonMapper.unwrapJson(jSONObject.get(next)));
        }
        return hashMap;
    }
}
