package com.iterable.iterableapi;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e {

    private final JSONObject a;
    public String b;
    private e(JSONObject jSONObject) {
        JSONObject obj1;
        super();
        if (jSONObject != null) {
            this.a = jSONObject;
        } else {
            obj1 = new JSONObject();
            this.a = obj1;
        }
    }

    static com.iterable.iterableapi.e a(String string) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", string);
            e obj2 = new e(jSONObject);
            return obj2;
            string = null;
            return string;
        }
    }

    static com.iterable.iterableapi.e b(String string) {
        if (string != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "openUrl");
            jSONObject.put("data", string);
            e obj3 = new e(jSONObject);
            return obj3;
        }
        try {
            return null;
        }
    }

    static com.iterable.iterableapi.e c(JSONObject jSONObject) {
        if (jSONObject != null) {
            e eVar = new e(jSONObject);
            return eVar;
        }
        return null;
    }

    public String d() {
        return this.a.optString("data", 0);
    }

    public String e() {
        return this.a.optString("type", 0);
    }

    public boolean f(String string) {
        String str;
        Object obj2;
        if (e() != null && e().equals(string)) {
            obj2 = e().equals(string) ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
