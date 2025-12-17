package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ao {
    static JSONObject values(String string) {
        int optString;
        String str3;
        JSONObject jSONObject;
        boolean optBoolean;
        Object instance;
        String str2;
        com.appsflyer.internal.an obj5;
        optString = 0;
        jSONObject = new JSONObject(string);
        instance = 0;
        if (jSONObject.optBoolean("monitor", instance) && !AppsFlyerProperties.getInstance().getBoolean("disableProxy", instance)) {
            try {
                if (an.values == null) {
                }
                obj5 = new an();
                an.values = obj5;
                an.values.valueOf();
            } catch (Throwable th) {
            }
        } else {
        }
        obj5 = jSONObject.optString("ol_scheme", optString);
        optBoolean = jSONObject.optString("ol_domain", optString);
        optString = jSONObject.optString("ol_ver", optString);
        if (jSONObject.has("ol_id") && obj5 != null) {
            obj5 = jSONObject.optString("ol_scheme", optString);
            optBoolean = jSONObject.optString("ol_domain", optString);
            optString = jSONObject.optString("ol_ver", optString);
            if (obj5 != null) {
                AppsFlyerProperties.getInstance().set("onelinkScheme", obj5);
            }
            if (optBoolean != null) {
                AppsFlyerProperties.getInstance().set("onelinkDomain", optBoolean);
            }
            if (optString != null) {
                AppsFlyerProperties.getInstance().set("onelinkVersion", optString);
            }
        }
        return jSONObject;
    }
}
