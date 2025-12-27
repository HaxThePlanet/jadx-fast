package com.amplitude.api;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Identify.java */
/* loaded from: classes.dex */
public class l {

    private static final String c = "com.amplitude.api.l";
    protected JSONObject a = new JSONObject();
    protected Set<String> b = new HashSet<>();
    public l() throws JSONException {
        super();
        JSONObject jSONObject = new JSONObject();
        HashSet hashSet = new HashSet();
    }

    private void a(String str, String str2, Object object) {
        int i = 0;
        final int i3 = 1;
        if (n.d(str2)) {
            Object[] arr4 = new Object[i3];
            g.d().e(l.c, String.format("Attempting to perform operation %s with a null or empty string property, ignoring", new Object[] { str }));
            return;
        }
        int i2 = 2;
        if (l.c == null) {
            Object[] arr = new Object[i2];
            g.d().e(l.c, String.format("Attempting to perform operation %s with null value for property %s, ignoring", new Object[] { str, str2 }));
            return;
        }
        if (this.a.has("$clearAll")) {
            Object[] arr3 = new Object[i3];
            g.d().e(l.c, String.format("This Identify already contains a $clearAll operation, ignoring operation %s", new Object[] { str }));
            return;
        }
        if (this.b.contains(str2)) {
            Object[] arr2 = new Object[i2];
            g.d().e(l.c, String.format("Already used property %s in previous operation, ignoring operation %s", new Object[] { str2, str }));
            return;
        }
        try {
            if (!this.a.has(str)) {
                this.a.put(str, new JSONObject());
            }
            this.a.getJSONObject(str).put(str2, object);
            this.b.add(str2);
        } catch (org.json.JSONException jSON) {
            str2 = g.d();
            object = l.c;
            jSON = jSON.toString();
            str2.b(object, jSON);
        }
    }

    private JSONArray e(String[] strArr) throws JSONException {
        int i = 0;
        final JSONArray jSONArray = new JSONArray();
        i = 0;
        for (Object obj : strArr) {
            jSONArray.put(obj);
        }
        return jSONArray;
    }

    public l b(String str, String str2) {
        a("$set", str, str2);
        return this;
    }

    public l c(String str, JSONObject jSONObject) {
        a("$set", str, jSONObject);
        return this;
    }

    public l d(String str, String[] strArr) {
        a("$set", str, e(strArr));
        return this;
    }

    public l f(String str) {
        a("$unset", str, "-");
        return this;
    }

}
