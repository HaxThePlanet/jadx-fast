package io.jsonwebtoken.orgjson.io;

import io.jsonwebtoken.io.DeserializationException;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: OrgJsonDeserializer.java */
/* loaded from: classes3.dex */
public class OrgJsonDeserializer implements Deserializer<Object> {
    private Object convertIfNecessary(Object object) {
        int i = 0;
        if (JSONObject.NULL.equals(object)) {
            i = 0;
        } else {
            equals = object instanceof JSONArray;
            if (object instanceof JSONArray) {
                List result = toList(object);
            } else {
                equals = object instanceof JSONObject;
                if (object instanceof JSONObject) {
                    Map map = toMap(object);
                }
            }
        }
        return i;
    }

    private Object parse(String str) throws org.json.JSONException {
        final JSONTokener jSONTokener = new JSONTokener(str);
        char nextClean = jSONTokener.nextClean();
        jSONTokener.back();
        if (nextClean == 123) {
            return toMap(new JSONObject(jSONTokener));
        }
        if (nextClean == 91) {
            return toList(new JSONArray(jSONTokener));
        }
        return convertIfNecessary(jSONTokener.nextValue());
    }

    private List<Object> toList(JSONArray jSONArray) throws org.json.JSONException {
        int i = 0;
        final int length = jSONArray.length();
        final ArrayList arrayList = new ArrayList(length);
        i = 0;
        while (i < length) {
            arrayList.add(convertIfNecessary(jSONArray.get(i)));
            i = i + 1;
        }
        return arrayList;
    }

    private Map<String, Object> toMap(JSONObject jSONObject) throws org.json.JSONException {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object item = keys.next();
            linkedHashMap.put(item, convertIfNecessary(jSONObject.get(item)));
        }
        return linkedHashMap;
    }

    public Object deserialize(byte[] bArr) throws java.io.UnsupportedEncodingException, DeserializationException {
        Assert.notNull(bArr, "JSON byte array cannot be null");
        if (bArr.length == 0) {
            throw new DeserializationException("Invalid JSON: zero length byte array.");
        } else {
            try {
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder();
                String deserializationException = "Invalid JSON: ";
                deserializationException = e.getMessage();
                stringBuilder = deserializationException + deserializationException;
                deserializationException = new DeserializationException(stringBuilder, e);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) deserializationException;
            }
            return parse(new String(bArr, Strings.UTF_8));
        }
    }
}
