package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class n {

    public final Context AFKeystoreWrapper;
    private Bundle values;
    public n(Context context) {
        super();
        this.values = 0;
        this.AFKeystoreWrapper = context.getApplicationContext();
    }

    public static Map<String, Object> AFInAppEventType(JSONObject jSONObject) {
        Object next;
        List values;
        boolean z;
        HashMap hashMap = new HashMap();
        final Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            next = keys.next();
            values = jSONObject.get((String)next);
            if (values instanceof JSONArray != null) {
            } else {
            }
            if (values instanceof JSONObject != null) {
            }
            hashMap.put(next, values);
            values = n.AFInAppEventType((JSONObject)values);
            values = n.values((JSONArray)values);
        }
        return hashMap;
    }

    private static Object AFKeystoreWrapper(Object object) {
        boolean z2;
        boolean z;
        Object obj;
        int i;
        Object obj2;
        Object obj4;
        if (object == null) {
            return JSONObject.NULL;
        }
        if (object instanceof JSONArray == null) {
            if (object instanceof JSONObject != null) {
            } else {
                if (object.equals(JSONObject.NULL)) {
                    return object;
                }
                if (object instanceof Collection != null) {
                    JSONArray jSONArray = new JSONArray();
                    obj4 = (Collection)object.iterator();
                    for (Object next2 : obj4) {
                        jSONArray.put(n.AFKeystoreWrapper(next2));
                    }
                    return jSONArray;
                }
                if (object.getClass().isArray()) {
                    JSONArray jSONArray2 = new JSONArray();
                    i = 0;
                    while (i < Array.getLength(object)) {
                        jSONArray2.put(n.AFKeystoreWrapper(Array.get(object, i)));
                        i++;
                    }
                    return jSONArray2;
                }
                if (object instanceof Map != null) {
                    return n.values((Map)object);
                }
                if (!object instanceof Boolean && !object instanceof Byte && !object instanceof Character && !object instanceof Double && !object instanceof Float && !object instanceof Integer && !object instanceof Long && !object instanceof Short) {
                    if (!object instanceof Byte) {
                        if (!object instanceof Character) {
                            if (!object instanceof Double) {
                                if (!object instanceof Float) {
                                    try {
                                        if (!object instanceof Integer) {
                                        }
                                        if (!object instanceof Long) {
                                        }
                                        if (!object instanceof Short) {
                                        }
                                        if (object instanceof String != null) {
                                        } else {
                                        }
                                        obj4 = object.toString();
                                        return obj4;
                                        object = JSONObject.NULL;
                                        return obj4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static List<Object> values(JSONArray jSONArray) {
        int i;
        List values;
        boolean z;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < jSONArray.length()) {
            values = jSONArray.get(i);
            if (values instanceof JSONArray != null) {
            } else {
            }
            if (values instanceof JSONObject != null) {
            }
            arrayList.add(values);
            i++;
            values = n.AFInAppEventType((JSONObject)values);
            values = n.values((JSONArray)values);
        }
        return arrayList;
    }

    public static JSONObject values(Map<String, ?> map) {
        Object key;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        Iterator obj3 = map.entrySet().iterator();
        for (Map.Entry next2 : obj3) {
            jSONObject.put((String)next2.getKey(), n.AFKeystoreWrapper(next2.getValue()));
        }
        return jSONObject;
    }

    public final String AFKeystoreWrapper(String string) {
        Bundle metaData;
        String packageName;
        int i;
        Object obj5;
        if (this.values == null) {
            try {
                this.values = applicationInfo.metaData;
                Bundle values = this.values;
                obj5 = values.get(string);
                if (values != null && obj5 != null) {
                }
                obj5 = values.get(string);
                if (obj5 != null) {
                }
                return obj5.toString();
                return null;
                packageName = "Could not load manifest metadata!";
                StringBuilder string2 = new StringBuilder(packageName);
                packageName = string.getMessage();
                string2.append(packageName);
                string2 = string2.toString();
                AFLogger.AFKeystoreWrapper(string2, string);
                return obj0;
            }
        }
    }
}
