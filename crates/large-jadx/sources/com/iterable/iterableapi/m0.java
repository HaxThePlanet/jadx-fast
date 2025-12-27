package com.iterable.iterableapi;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableNotificationData.java */
/* loaded from: classes2.dex */
class m0 {

    private int a;
    private int b;
    private String c;
    private boolean d;
    private e e;
    private List<m0.a> f;

    public static class a {

        public final String a;
        public final String b;
        public final String c;
        public final boolean d;
        public final String e;
        public final e f;
        a(JSONObject jSONObject) {
            super();
            this.a = jSONObject.optString("identifier");
            this.b = jSONObject.optString("title");
            this.c = jSONObject.optString("buttonType", "default");
            boolean z = true;
            this.d = jSONObject.optBoolean("openApp", z);
            jSONObject.optBoolean("requiresUnlock", z);
            jSONObject.optInt("icon", 0);
            this.e = jSONObject.optString("inputPlaceholder");
            jSONObject.optString("inputTitle");
            this.f = e.c(jSONObject.optJSONObject("action"));
        }
    }
    m0(String str) {
        int i = 0;
        List list;
        com.iterable.iterableapi.m0.a aVar;
        super();
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optInt("campaignId");
            this.b = jSONObject.optInt("templateId");
            this.c = jSONObject.optString("messageId");
            this.d = jSONObject.optBoolean("isGhostPush");
            this.e = e.c(jSONObject.optJSONObject("defaultAction"));
            JSONArray optJSONArray = jSONObject.optJSONArray("actionButtons");
            this.f = new ArrayList();
            i = 0;
            this.f.add(new m0.a(optJSONArray.getJSONObject(i)));
        } catch (org.json.JSONException jSON) {
            jSON = jSON.toString();
            j0.c("IterableNoticationData", jSON);
        }
    }

    public m0.a a(String str) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.a.equals(str)) {
                return item;
            }
        }
        return null;
    }

    public List<m0.a> b() {
        return this.f;
    }

    public int c() {
        return this.a;
    }

    public e d() {
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

    m0(Bundle bundle) {
        this(bundle.getString("itbl"));
    }
}
