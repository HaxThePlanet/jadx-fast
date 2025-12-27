package io.jsonwebtoken.orgjson.io;

import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.io.SerializationException;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Classes;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.DateFormats;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: OrgJsonSerializer.java */
/* loaded from: classes3.dex */
public class OrgJsonSerializer<T> implements Serializer<T> {

    private static final Class JSON_STRING_CLASS;
    private static final String JSON_STRING_CLASS_NAME = "org.json.JSONString";
    private static final String JSON_WRITER_CLASS_NAME = "org.json.JSONWriter";
    private static final Class[] VALUE_TO_STRING_ARG_TYPES;
    static {
        Class[] arr = new Class[1];
        OrgJsonSerializer.VALUE_TO_STRING_ARG_TYPES = new Class[] { Object.class };
        String str = "org.json.JSONString";
        if (Classes.isAvailable(str)) {
            OrgJsonSerializer.JSON_STRING_CLASS = Classes.forName("org.json.JSONString");
        } else {
            Class cls = null;
            OrgJsonSerializer.JSON_STRING_CLASS = cls;
        }
    }

    private static boolean isJSONString(Object object) {
        final Class jSON_STRING_CLASS2 = OrgJsonSerializer.JSON_STRING_CLASS;
        if (OrgJsonSerializer.JSON_STRING_CLASS != null) {
            return OrgJsonSerializer.JSON_STRING_CLASS.isInstance(object);
        }
        return false;
    }

    private JSONArray toJSONArray(Collection list) throws org.json.JSONException {
        final JSONArray jSONArray = new JSONArray();
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(toJSONInstance(it.next()));
        }
        return jSONArray;
    }

    private Object toJSONInstance(Object object) throws java.io.UnsupportedEncodingException, SerializationException {
        java.util.Date time;
        if (object == null) {
            return JSONObject.NULL;
        }
        jSONString = object instanceof JSONObject;
        if (!(object instanceof JSONObject)) {
            jSONString = object instanceof JSONArray;
            if (!(object instanceof JSONArray)) {
                if (!JSONObject.NULL.equals(object) && !OrgJsonSerializer.isJSONString(JSONObject.NULL)) {
                    jSONString = object instanceof Byte;
                    if (!(object instanceof Byte)) {
                        jSONString = object instanceof Character;
                        if (!(object instanceof Character)) {
                            jSONString = object instanceof Short;
                            if (!(object instanceof Short)) {
                                jSONString = object instanceof Integer;
                                if (!(object instanceof Integer)) {
                                    jSONString = object instanceof Long;
                                    if (!(object instanceof ong)) {
                                        jSONString = object instanceof Boolean;
                                        if (!(object instanceof Boolean)) {
                                            jSONString = object instanceof Float;
                                            if (!(object instanceof Float)) {
                                                jSONString = object instanceof Double;
                                                if (!(object instanceof Double)) {
                                                    jSONString = object instanceof String;
                                                    if (!(object instanceof String)) {
                                                        jSONString = object instanceof BigInteger;
                                                        if (!(object instanceof BigInteger)) {
                                                            jSONString = object instanceof BigDecimal;
                                                            if (!(object instanceof BigDecimal)) {
                                                                jSONString = object instanceof Enum;
                                                                if (!(object instanceof Enum)) {
                                                                    if (object instanceof Calendar) {
                                                                        time = object.getTime();
                                                                    }
                                                                    if (time instanceof Date) {
                                                                        return DateFormats.formatIso8601(time);
                                                                    }
                                                                    if (time instanceof byte[]) {
                                                                        return Encoders.BASE64.encode(time);
                                                                    }
                                                                    if (time instanceof char[]) {
                                                                        return new String(time);
                                                                    }
                                                                    if (time instanceof Map) {
                                                                        return toJSONObject(time);
                                                                    }
                                                                    if (time instanceof Collection) {
                                                                        return toJSONArray(time);
                                                                    }
                                                                    if (Objects.isArray(time)) {
                                                                        return toJSONArray(Collections.arrayToList(time));
                                                                    }
                                                                }
                                                                StringBuilder stringBuilder = new StringBuilder();
                                                                final String str = "Unable to serialize object of type ";
                                                                String name = time.getClass().getName();
                                                                String str2 = " to JSON using known heuristics.";
                                                                object = str + name + str2;
                                                                throw new SerializationException(object);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return object;
    }

    private JSONObject toJSONObject(Map<?, ?> map) throws org.json.JSONException {
        final JSONObject jSONObject = new JSONObject();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            jSONObject.put(String.valueOf(item.getKey()), toJSONInstance(item.getValue()));
        }
        return jSONObject;
    }

    public byte[] serialize(T t) {
        try {
        } catch (Exception e) {
            StringBuilder serializationException = new SerializationException();
            String str = "Unable to serialize object of type ";
            t = t.getClass();
            t = t.getName();
            t = " to JSON: ";
            t = e.getMessage();
            t = str + t + t + t;
            serializationException = new SerializationException(t, e);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) serializationException;
        } catch (io.jsonwebtoken.io.SerializationException serialization1) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) serialization1;
        }
        return toBytes(toJSONInstance(t));
    }

    protected byte[] toBytes(Object object) throws java.io.UnsupportedEncodingException {
        String object2;
        z = object instanceof JSONObject;
        if (object instanceof JSONObject) {
            object2 = object.toString();
        } else {
            Object[] arr = new Object[1];
            str = "valueToString";
            Object _static = Classes.invokeStatic("org.json.JSONWriter", str, OrgJsonSerializer.VALUE_TO_STRING_ARG_TYPES, object);
        }
        return object2.getBytes(Strings.UTF_8);
    }
}
