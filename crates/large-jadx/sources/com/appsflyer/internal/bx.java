package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class bx {
    static Map<String, Object> AFInAppEventType(String string) {
        Object next;
        boolean equals;
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(string);
        final Iterator obj5 = jSONObject.keys();
        while (obj5.hasNext()) {
            next = obj5.next();
            if (!(String)next.equals("is_cache")) {
            }
            if (jSONObject.isNull(next)) {
            } else {
            }
            equals = jSONObject.get(next);
            hashMap.put(next, equals);
            equals = i;
        }
        return hashMap;
    }

    public static void AFKeystoreWrapper(com.appsflyer.internal.ah ah, com.appsflyer.internal.i i2, String string3, Context context4, SharedPreferences sharedPreferences5, Integer integer6, Throwable throwable7) {
        boolean fALSE;
        long long;
        int i;
        com.appsflyer.internal.ah ahVar = ah;
        Context context = context4;
        SharedPreferences sharedPreferences = sharedPreferences5;
        String str4 = "is_first_launch";
        if (!i2.valueOf()) {
        }
        if (ah.AFInAppEventType == null) {
            AFLogger.values("[GCD-E01] AppsFlyerConversionListener is null - skip gcd");
        }
        StringBuilder stringBuilder2 = new StringBuilder("[GCD-A01] Loading conversion data. Counter: ");
        stringBuilder2.append(obj.onDeepLinkingNative);
        AFLogger.values(stringBuilder2.toString());
        String str6 = "appsflyerConversionDataCacheExpiration";
        int i8 = 0;
        long = sharedPreferences.getLong(str6, i8);
        final int i9 = 0;
        final String str10 = "attributionId";
        if (Long.compare(long, i8) != 0 && Long.compare(i, l) > 0) {
            if (Long.compare(i, l) > 0) {
                AFLogger.values("[GCD-E02] Cached conversion data expired");
                ah.AFInAppEventType(context, "sixtyDayConversionData");
                ah.valueOf(context, str10, i9);
                ah.AFInAppEventType(context, str6, i8);
            }
        }
        String string4 = sharedPreferences.getString(str10, i9);
        if (string4 != null && ah.AFInAppEventType(sharedPreferences, "appsFlyerCount", false) <= 1) {
            if (ah.AFInAppEventType(sharedPreferences, "appsFlyerCount", false) <= 1) {
            }
            Map values = bx.values(context4);
            if (values == null) {
            }
            if (!values.containsKey(str4)) {
                values.put(str4, Boolean.FALSE);
            }
            by.valueOf(values);
        }
        if (throwable7 != null) {
            StringBuilder stringBuilder = new StringBuilder("Launch exception: ");
            stringBuilder.append(throwable7.getMessage());
            by.valueOf(stringBuilder.toString());
        }
        if (integer6.intValue() != 200) {
            by.valueOf("Launch status code: ".concat(String.valueOf(integer6)));
        }
        by byVar = new by(ah, (Application)context4.getApplicationContext(), string3);
        ah.values(byVar.AFKeystoreWrapper, byVar, 10, string4);
    }

    static Map<String, Object> values(Context context) {
        String length;
        String obj2 = ah.AFKeystoreWrapper(context).getString("attributionId", 0);
        if (obj2 == null) {
        } else {
            if (obj2.length() <= 0) {
            } else {
                return bx.AFInAppEventType(obj2);
            }
        }
        obj2 = new bu();
        throw obj2;
    }
}
