package com.iterable.iterableapi;

import android.content.Context;
import android.os.AsyncTask;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OnlineRequestProcessor.java */
/* loaded from: classes2.dex */
class d1 implements h1 {
    d1() {
        super();
    }

    public void a(String str, String str2, JSONObject jSONObject, String str3, x xVar, u uVar) {
        d(jSONObject);
        l lVar = new l(str, str2, jSONObject, "POST", str3, xVar, uVar);
        com.iterable.iterableapi.l[] arr = new l[1];
        new t0().execute(new l[] { lVar });
    }

    public void b(String str, String str2, JSONObject jSONObject, String str3, v vVar) {
        d(jSONObject);
        l lVar = new l(str, str2, jSONObject, "GET", str3, vVar);
        com.iterable.iterableapi.l[] arr = new l[1];
        new t0().execute(new l[] { lVar });
    }

    JSONObject d(JSONObject jSONObject) {
        try {
            str = "createdAt";
            l = (new Date().getTime()) / 1000L;
            jSONObject.put(str, l);
        } catch (org.json.JSONException unused) {
            j0.c("OnlineRequestProcessor", "Could not add createdAt timestamp to json object");
        }
        return jSONObject;
    }

    public void c(Context context) {
    }
}
