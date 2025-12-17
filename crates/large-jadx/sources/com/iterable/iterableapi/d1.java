package com.iterable.iterableapi;

import android.content.Context;
import android.os.AsyncTask;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class d1 implements com.iterable.iterableapi.h1 {
    @Override // com.iterable.iterableapi.h1
    public void a(String string, String string2, JSONObject jSONObject3, String string4, com.iterable.iterableapi.x x5, com.iterable.iterableapi.u u6) {
        d(jSONObject3);
        super(string, string2, jSONObject3, "POST", string4, x5, u6);
        t0 obj10 = new t0();
        com.iterable.iterableapi.l[] obj11 = new l[1];
        obj10.execute(lVar2);
    }

    @Override // com.iterable.iterableapi.h1
    public void b(String string, String string2, JSONObject jSONObject3, String string4, com.iterable.iterableapi.v v5) {
        d(jSONObject3);
        super(string, string2, jSONObject3, "GET", string4, v5);
        t0 obj9 = new t0();
        com.iterable.iterableapi.l[] obj10 = new l[1];
        obj9.execute(lVar2);
    }

    @Override // com.iterable.iterableapi.h1
    public void c(Context context) {
    }

    @Override // com.iterable.iterableapi.h1
    JSONObject d(JSONObject jSONObject) {
        String str;
        int i;
        try {
            Date date = new Date();
            jSONObject.put("createdAt", time /= i2);
            j0.c("OnlineRequestProcessor", "Could not add createdAt timestamp to json object");
            return jSONObject;
        }
    }
}
