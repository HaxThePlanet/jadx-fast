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

/* loaded from: classes3.dex */
public class OrgJsonDeserializer implements Deserializer<Object> {
    private Object convertIfNecessary(Object object) {
        boolean equals;
        int obj2;
        if (JSONObject.NULL.equals(object)) {
            obj2 = 0;
        } else {
            if (object instanceof JSONArray != null) {
                obj2 = toList((JSONArray)object);
            } else {
                if (object instanceof JSONObject != null) {
                    obj2 = toMap((JSONObject)object);
                }
            }
        }
        return obj2;
    }

    private Object parse(String string) {
        JSONTokener jSONTokener = new JSONTokener(string);
        char obj3 = jSONTokener.nextClean();
        jSONTokener.back();
        if (obj3 == 123) {
            obj3 = new JSONObject(jSONTokener);
            return toMap(obj3);
        }
        if (obj3 == 91) {
            obj3 = new JSONArray(jSONTokener);
            return toList(obj3);
        }
        return convertIfNecessary(jSONTokener.nextValue());
    }

    private List<Object> toList(JSONArray jSONArray) {
        int i;
        Object convertIfNecessary;
        final int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        i = 0;
        while (i < length) {
            arrayList.add(convertIfNecessary(jSONArray.get(i)));
            i++;
        }
        return arrayList;
    }

    private Map<String, Object> toMap(JSONObject jSONObject) {
        Object next;
        Object convertIfNecessary;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Iterator keys = jSONObject.keys();
        for (String next : keys) {
            linkedHashMap.put(next, convertIfNecessary(jSONObject.get(next)));
        }
        return linkedHashMap;
    }

    @Override // io.jsonwebtoken.io.Deserializer
    public Object deserialize(byte[] bArr) {
        Assert.notNull(bArr, "JSON byte array cannot be null");
        if (bArr.length == 0) {
        } else {
            String string2 = new String(bArr, Strings.UTF_8);
            return parse(string2);
        }
        DeserializationException obj3 = new DeserializationException("Invalid JSON: zero length byte array.");
        throw obj3;
    }
}
