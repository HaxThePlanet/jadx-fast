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

/* loaded from: classes3.dex */
public class OrgJsonSerializer<T>  implements Serializer<T> {

    private static final Class JSON_STRING_CLASS = null;
    private static final String JSON_STRING_CLASS_NAME = "org.json.JSONString";
    private static final String JSON_WRITER_CLASS_NAME = "org.json.JSONWriter";
    private static final Class[] VALUE_TO_STRING_ARG_TYPES;
    static {
        Class forName;
        Class[] arr = new Class[1];
        OrgJsonSerializer.VALUE_TO_STRING_ARG_TYPES = arr;
        String str = "org.json.JSONString";
        if (Classes.isAvailable(str)) {
            OrgJsonSerializer.JSON_STRING_CLASS = Classes.forName(str);
        } else {
            OrgJsonSerializer.JSON_STRING_CLASS = 0;
        }
    }

    private static boolean isJSONString(Object object) {
        final Class jSON_STRING_CLASS = OrgJsonSerializer.JSON_STRING_CLASS;
        if (jSON_STRING_CLASS != null) {
            return jSON_STRING_CLASS.isInstance(object);
        }
        return 0;
    }

    private JSONArray toJSONArray(Collection collection) {
        Object jSONInstance;
        JSONArray jSONArray = new JSONArray();
        final Iterator obj3 = collection.iterator();
        for (Object next2 : obj3) {
            jSONArray.put(toJSONInstance(next2));
        }
        return jSONArray;
    }

    private Object toJSONInstance(Object object) {
        boolean jSONString;
        Object obj3;
        if (object == null) {
            return JSONObject.NULL;
        }
        if (object instanceof JSONObject == null && object instanceof JSONArray == null && !JSONObject.NULL.equals(object) && !OrgJsonSerializer.isJSONString(object) && !object instanceof Byte && !object instanceof Character && !object instanceof Short && !object instanceof Integer && !object instanceof Long && !object instanceof Boolean && !object instanceof Float && !object instanceof Double && object instanceof String == null && !object instanceof BigInteger && !object instanceof BigDecimal) {
            if (object instanceof JSONArray == null) {
                if (!JSONObject.NULL.equals(object)) {
                    if (!OrgJsonSerializer.isJSONString(object)) {
                        if (!object instanceof Byte) {
                            if (!object instanceof Character) {
                                if (!object instanceof Short) {
                                    if (!object instanceof Integer) {
                                        if (!object instanceof Long) {
                                            if (!object instanceof Boolean) {
                                                if (!object instanceof Float) {
                                                    if (!object instanceof Double) {
                                                        if (object instanceof String == null) {
                                                            if (!object instanceof BigInteger) {
                                                                if (!object instanceof BigDecimal) {
                                                                    if (object instanceof Enum) {
                                                                    } else {
                                                                        if (object instanceof Calendar) {
                                                                            obj3 = (Calendar)object.getTime();
                                                                        }
                                                                        if (obj3 instanceof Date) {
                                                                            return DateFormats.formatIso8601((Date)obj3);
                                                                        }
                                                                        if (obj3 instanceof byte[]) {
                                                                            return Encoders.BASE64.encode((byte[])obj3);
                                                                        }
                                                                        if (obj3 instanceof char[]) {
                                                                            String string = new String((char[])obj3);
                                                                            return string;
                                                                        }
                                                                        if (obj3 instanceof Map != null) {
                                                                            return toJSONObject((Map)obj3);
                                                                        }
                                                                        if (obj3 instanceof Collection != null) {
                                                                            return toJSONArray((Collection)obj3);
                                                                        }
                                                                        if (!Objects.isArray(obj3)) {
                                                                        } else {
                                                                            return toJSONArray(Collections.arrayToList(obj3));
                                                                        }
                                                                    }
                                                                    StringBuilder stringBuilder = new StringBuilder();
                                                                    stringBuilder.append("Unable to serialize object of type ");
                                                                    stringBuilder.append(obj3.getClass().getName());
                                                                    stringBuilder.append(" to JSON using known heuristics.");
                                                                    SerializationException serializationException = new SerializationException(stringBuilder.toString());
                                                                    throw serializationException;
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
        }
        return object;
    }

    private JSONObject toJSONObject(Map<?, ?> map) {
        Object jSONInstance;
        String valueOf;
        JSONObject jSONObject = new JSONObject();
        Iterator obj4 = map.entrySet().iterator();
        for (Map.Entry next2 : obj4) {
            jSONObject.put(String.valueOf(next2.getKey()), toJSONInstance(next2.getValue()));
        }
        return jSONObject;
    }

    public byte[] serialize(T t) {
        try {
            return toBytes(toJSONInstance(t));
            StringBuilder serializationException = new StringBuilder();
            serializationException.append("Unable to serialize object of type ");
            t = t.getClass();
            t = t.getName();
            serializationException.append(t);
            t = " to JSON: ";
            serializationException.append(t);
            t = th.getMessage();
            serializationException.append(t);
            t = serializationException.toString();
            serializationException = new SerializationException(t, th);
            throw serializationException;
            throw t;
        }
    }

    @Override // io.jsonwebtoken.io.Serializer
    protected byte[] toBytes(Object object) {
        boolean vALUE_TO_STRING_ARG_TYPES;
        Object[] arr;
        String str;
        Object obj4;
        if (object instanceof JSONObject != null) {
            obj4 = object.toString();
        } else {
            arr = new Object[1];
            obj4 = Classes.invokeStatic("org.json.JSONWriter", "valueToString", OrgJsonSerializer.VALUE_TO_STRING_ARG_TYPES, object);
        }
        return obj4.getBytes(Strings.UTF_8);
    }
}
