package com.iterable.iterableapi;

import org.json.JSONObject;

/* loaded from: classes2.dex */
class l {

    final String a;
    final String b = null;
    final String c;
    final JSONObject d;
    final String e;
    final String f;
    private com.iterable.iterableapi.l.b g;
    com.iterable.iterableapi.v h;
    com.iterable.iterableapi.x i;
    com.iterable.iterableapi.u j;

    static class a {
    }

    static enum b {

        ONLINE,
        OFFLINE;
    }
    l(String string, String string2, JSONObject jSONObject3, String string4, String string5, com.iterable.iterableapi.v v6) {
        super();
        this.g = l.b.ONLINE;
        this.a = string;
        final int obj2 = 0;
        this.c = string2;
        this.d = jSONObject3;
        this.e = string4;
        this.f = string5;
        this.h = v6;
    }

    l(String string, String string2, JSONObject jSONObject3, String string4, String string5, com.iterable.iterableapi.x x6, com.iterable.iterableapi.u u7) {
        super();
        this.g = l.b.ONLINE;
        this.a = string;
        final int obj2 = 0;
        this.c = string2;
        this.d = jSONObject3;
        this.e = string4;
        this.f = string5;
        this.i = x6;
        this.j = u7;
    }

    static com.iterable.iterableapi.l a(JSONObject jSONObject, com.iterable.iterableapi.x x2, com.iterable.iterableapi.u u3) {
        String string;
        String str;
        string = "authToken";
        if (jSONObject.has(string)) {
            str = string;
        } else {
            try {
                str = str6;
                super(jSONObject.getString("apiKey"), jSONObject.getString("resourcePath"), jSONObject.getJSONObject("data"), jSONObject.getString("requestType"), str, x2, u3);
                return obj10;
                jSONObject = "IterableApiRequest";
                x2 = "Failed to create Iterable request from JSON";
                j0.c(jSONObject, x2);
                jSONObject = null;
                return jSONObject;
            }
        }
    }

    public com.iterable.iterableapi.l.b b() {
        return this.g;
    }

    void c(com.iterable.iterableapi.l.b l$b) {
        this.g = b;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("apiKey", this.a);
        jSONObject.put("resourcePath", this.c);
        jSONObject.put("authToken", this.f);
        jSONObject.put("requestType", this.e);
        jSONObject.put("data", this.d);
        return jSONObject;
    }
}
