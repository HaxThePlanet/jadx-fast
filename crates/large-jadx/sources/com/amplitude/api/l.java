package com.amplitude.api;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l {

    private static final String c = "com.amplitude.api.l";
    protected JSONObject a;
    protected Set<String> b;
    static {
    }

    public l() {
        super();
        JSONObject jSONObject = new JSONObject();
        this.a = jSONObject;
        HashSet hashSet = new HashSet();
        this.b = hashSet;
    }

    private void a(String string, String string2, Object object3) {
        boolean z;
        int jSONObject;
        Set obj6;
        String obj7;
        Object obj8;
        jSONObject = 0;
        final int i2 = 1;
        if (n.d(string2)) {
            Object[] arr4 = new Object[i2];
            arr4[jSONObject] = string;
            g.d().e(l.c, String.format("Attempting to perform operation %s with a null or empty string property, ignoring", arr4));
        }
        int i = 2;
        if (object3 == null) {
            Object[] arr = new Object[i];
            arr[jSONObject] = string;
            arr[i2] = string2;
            g.d().e(l.c, String.format("Attempting to perform operation %s with null value for property %s, ignoring", arr));
        }
        if (this.a.has("$clearAll")) {
            Object[] arr3 = new Object[i2];
            arr3[jSONObject] = string;
            g.d().e(l.c, String.format("This Identify already contains a $clearAll operation, ignoring operation %s", arr3));
        }
        if (this.b.contains(string2)) {
            Object[] arr2 = new Object[i];
            arr2[jSONObject] = string2;
            arr2[i2] = string;
            g.d().e(l.c, String.format("Already used property %s in previous operation, ignoring operation %s", arr2));
        }
        if (!this.a.has(string)) {
            jSONObject = new JSONObject();
            this.a.put(string, jSONObject);
        }
        this.a.getJSONObject(string).put(string2, object3);
        this.b.add(string2);
    }

    private JSONArray e(String[] stringArr) {
        int i;
        Object obj;
        JSONArray jSONArray = new JSONArray();
        i = 0;
        while (i < stringArr.length) {
            jSONArray.put(stringArr[i]);
            i++;
        }
        return jSONArray;
    }

    public com.amplitude.api.l b(String string, String string2) {
        a("$set", string, string2);
        return this;
    }

    public com.amplitude.api.l c(String string, JSONObject jSONObject2) {
        a("$set", string, jSONObject2);
        return this;
    }

    public com.amplitude.api.l d(String string, String[] string2Arr2) {
        a("$set", string, e(string2Arr2));
        return this;
    }

    public com.amplitude.api.l f(String string) {
        a("$unset", string, "-");
        return this;
    }
}
