package com.iterable.iterableapi;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableAttributionInfo.java */
/* loaded from: classes2.dex */
public class n {

    public final int a;
    public final int b;
    public final String c;
    public n(int i, int i2, String str) {
        super();
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public JSONObject a() {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("campaignId", this.a);
            jSONObject.put("templateId", this.b);
            jSONObject.put("messageId", this.c);
        } catch (org.json.JSONException unused) {
            return jSONObject;
        }
    }
}
