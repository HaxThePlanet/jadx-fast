package com.iterable.iterableapi;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableRequestTask.java */
/* loaded from: classes2.dex */
class l {

    final String a;
    final String b = null;
    final String c;
    final JSONObject d;
    final String e;
    final String f;
    private l.b g;
    v h;
    x i;
    u j;

    static class a {
    }

    enum b {

        OFFLINE,
        ONLINE;
    }
    l(String str, String str2, JSONObject jSONObject, String str3, String str4, x xVar, u uVar) {
        super();
        this.g = l.b.ONLINE;
        this.a = str;
        this.c = str2;
        this.d = jSONObject;
        this.e = str3;
        this.f = str4;
        this.i = xVar;
        this.j = uVar;
    }

    static l a(JSONObject jSONObject, x xVar, u uVar) {
        String string;
        string = "authToken";
        try {
            string = jSONObject.has(string) ? string : string;
            l jSONObject2 = new l(jSONObject.getString("apiKey"), jSONObject.getString("resourcePath"), jSONObject.getJSONObject("data"), jSONObject.getString("requestType"), string, xVar, uVar);
        } catch (org.json.JSONException unused) {
            jSONObject = "IterableApiRequest";
            xVar = "Failed to create Iterable request from JSON";
            j0.c(jSONObject, xVar);
            jSONObject = null;
            return jSONObject;
        }
        return jSONObject2;
    }

    public l.b b() {
        return this.g;
    }

    void c(l.b bVar) {
        this.g = bVar;
    }

    public JSONObject d() throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("apiKey", this.a);
        jSONObject.put("resourcePath", this.c);
        jSONObject.put("authToken", this.f);
        jSONObject.put("requestType", this.e);
        jSONObject.put("data", this.d);
        return jSONObject;
    }

    l(String str, String str2, JSONObject jSONObject, String str3, String str4, v vVar) {
        super();
        this.g = l.b.ONLINE;
        this.a = str;
        this.c = str2;
        this.d = jSONObject;
        this.e = str3;
        this.f = str4;
        this.h = vVar;
    }
}
