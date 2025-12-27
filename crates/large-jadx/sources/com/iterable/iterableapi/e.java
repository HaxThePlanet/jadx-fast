package com.iterable.iterableapi;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableAction.java */
/* loaded from: classes2.dex */
public class e {

    private final JSONObject a = new JSONObject();
    public String b;
    private e(JSONObject jSONObject) throws JSONException {
        super();
        if (jSONObject != null) {
            this.a = jSONObject;
        } else {
            JSONObject jSONObject2 = new JSONObject();
        }
    }

    static e a(String str) {
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", str);
        } catch (org.json.JSONException unused) {
            str = null;
            return str;
        }
        return new e(jSONObject);
    }

    static e b(String str) {
        if (str != null) {
            try {
                final JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "openUrl");
                jSONObject.put("data", str);
            } catch (org.json.JSONException unused) {
                return null;
            }
            return new e(jSONObject);
        }
    }

    static e c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return new e(jSONObject);
        }
        return null;
    }

    public String d() {
        return this.a.optString("data", null);
    }

    public String e() {
        return this.a.optString("type", null);
    }

    public boolean f(String str) {
        String str2;
        boolean z = false;
        if (e() != null) {
            str = e().equals(str) ? 1 : 0;
        }
        return (e().equals(str) ? 1 : 0);
    }
}
