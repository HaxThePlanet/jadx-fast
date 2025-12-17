package com.iterable.iterableapi;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class n {

    public final int a;
    public final int b;
    public final String c;
    public n(int i, int i2, String string3) {
        super();
        this.a = i;
        this.b = i2;
        this.c = string3;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("campaignId", this.a);
        jSONObject.put("templateId", this.b);
        jSONObject.put("messageId", this.c);
        return jSONObject;
    }
}
