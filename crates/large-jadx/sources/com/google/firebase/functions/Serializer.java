package com.google.firebase.functions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class Serializer {

    static final String LONG_TYPE = "type.googleapis.com/google.protobuf.Int64Value";
    static final String UNSIGNED_LONG_TYPE = "type.googleapis.com/google.protobuf.UInt64Value";
    private final DateFormat dateFormat;
    public Serializer() {
        super();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        this.dateFormat = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public Object decode(Object object) {
        String equals;
        int i;
        boolean optString;
        Object decode;
        String length;
        if (object instanceof Number) {
            return object;
        }
        if (object instanceof String != null) {
            return object;
        }
        if (object instanceof Boolean) {
            return object;
        }
        equals = "@type";
        String optString2 = object.optString(equals);
        optString = object.optString("value");
        length = "Invalid Long format:";
        if (object instanceof JSONObject != null && (JSONObject)object.has(equals) && optString2.equals("type.googleapis.com/google.protobuf.Int64Value")) {
            equals = "@type";
            if ((JSONObject)object.has(equals)) {
                optString2 = object.optString(equals);
                optString = object.optString("value");
                length = "Invalid Long format:";
                if (optString2.equals("type.googleapis.com/google.protobuf.Int64Value")) {
                    return Long.valueOf(Long.parseLong(optString));
                }
                if (optString2.equals("type.googleapis.com/google.protobuf.UInt64Value")) {
                    return Long.valueOf(Long.parseLong(optString));
                }
            }
            HashMap hashMap = new HashMap();
            Iterator keys = object.keys();
            for (String decode : keys) {
                hashMap.put(decode, decode(object.opt(decode)));
            }
            return hashMap;
        }
        if (object instanceof JSONArray != null) {
            ArrayList arrayList = new ArrayList();
            i = 0;
            Object obj = object;
            while (i < (JSONArray)obj.length()) {
                arrayList.add(decode(obj.opt(i)));
                i++;
                obj = object;
            }
            return arrayList;
        }
        if (object != JSONObject.NULL) {
        } else {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Object cannot be decoded from JSON: ");
        stringBuilder.append(object);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public Object encode(Object object) {
        Object runtimeException;
        boolean encode3;
        int i;
        boolean encode2;
        boolean encode;
        Object encode4;
        if (object != null) {
            if (object == JSONObject.NULL) {
            } else {
                if (object instanceof Long) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("@type", "type.googleapis.com/google.protobuf.Int64Value");
                    jSONObject3.put("value", object.toString());
                    return jSONObject3;
                }
                if (object instanceof Number) {
                    return object;
                }
                if (object instanceof String != null) {
                    return object;
                }
                if (object instanceof Boolean) {
                    return object;
                }
                boolean z5 = object instanceof JSONObject;
                if (z5) {
                    return object;
                }
                encode3 = object instanceof JSONArray;
                if (encode3) {
                    return object;
                }
                if (object instanceof Map != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        Iterator iterator = (Map)object.keySet().iterator();
                        for (Object next5 : iterator) {
                            jSONObject2.put((String)next5, encode(object.get(next5)));
                        }
                        Object next5 = iterator.next();
                        if (next5 instanceof String == null) {
                        } else {
                        }
                        jSONObject2.put((String)next5, encode(object.get(next5)));
                        runtimeException = new RuntimeException(object);
                        throw runtimeException;
                        IllegalArgumentException obj5 = new IllegalArgumentException("Object keys must be strings.");
                        throw obj5;
                        return jSONObject2;
                        if (object instanceof List != null) {
                        }
                        JSONArray jSONArray = new JSONArray();
                        obj5 = (List)object.iterator();
                        for (Object next2 : obj5) {
                            jSONArray.put(encode(next2));
                        }
                        jSONArray.put(encode(obj5.next()));
                        return jSONArray;
                        if (z5) {
                        }
                        JSONObject jSONObject = new JSONObject();
                        Iterator keys = (JSONObject)object.keys();
                        encode2 = keys.next();
                    } catch (org.json.JSONException jSON) {
                    }
                    if (!encode3) {
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        i = 0;
                        while (i < (JSONArray)object.length()) {
                            jSONArray2.put(encode(object.opt(i)));
                            i++;
                        }
                        return jSONArray2;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Object cannot be encoded in JSON: ");
            stringBuilder.append(object);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        return JSONObject.NULL;
    }
}
