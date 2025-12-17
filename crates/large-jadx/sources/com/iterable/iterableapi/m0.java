package com.iterable.iterableapi;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class m0 {

    private int a;
    private int b;
    private String c;
    private boolean d;
    private com.iterable.iterableapi.e e;
    private List<com.iterable.iterableapi.m0.a> f;

    public static class a {

        public final String a;
        public final String b;
        public final String c;
        public final boolean d;
        public final String e;
        public final com.iterable.iterableapi.e f;
        a(JSONObject jSONObject) {
            super();
            this.a = jSONObject.optString("identifier");
            this.b = jSONObject.optString("title");
            this.c = jSONObject.optString("buttonType", "default");
            int i = 1;
            this.d = jSONObject.optBoolean("openApp", i);
            jSONObject.optBoolean("requiresUnlock", i);
            jSONObject.optInt("icon", 0);
            this.e = jSONObject.optString("inputPlaceholder");
            jSONObject.optString("inputTitle");
            this.f = e.c(jSONObject.optJSONObject("action"));
        }
    }
    m0(Bundle bundle) {
        super(bundle.getString("itbl"));
    }

    m0(String string) {
        JSONObject jSONObject;
        int jSONObject2;
        List list;
        com.iterable.iterableapi.m0.a aVar;
        JSONArray obj5;
        super();
        jSONObject = new JSONObject(string);
        this.a = jSONObject.optInt("campaignId");
        this.b = jSONObject.optInt("templateId");
        this.c = jSONObject.optString("messageId");
        this.d = jSONObject.optBoolean("isGhostPush");
        this.e = e.c(jSONObject.optJSONObject("defaultAction"));
        obj5 = jSONObject.optJSONArray("actionButtons");
        if (obj5 != null) {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            jSONObject = 0;
            while (jSONObject < obj5.length()) {
                aVar = new m0.a(obj5.getJSONObject(jSONObject));
                this.f.add(aVar);
                jSONObject++;
            }
        }
    }

    public com.iterable.iterableapi.m0.a a(String string) {
        Object next;
        boolean equals;
        Iterator iterator = this.f.iterator();
        for (m0.a next : iterator) {
        }
        return null;
    }

    public List<com.iterable.iterableapi.m0.a> b() {
        return this.f;
    }

    public int c() {
        return this.a;
    }

    public com.iterable.iterableapi.e d() {
        return this.e;
    }

    public boolean e() {
        return this.d;
    }

    public String f() {
        return this.c;
    }

    public int g() {
        return this.b;
    }
}
