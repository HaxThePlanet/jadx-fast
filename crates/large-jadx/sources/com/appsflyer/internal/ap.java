package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.deeplink.DeepLinkResult.Error;
import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ap extends com.appsflyer.internal.cd {

    public static long onAttributionFailureNative = 0L;
    private static String onResponseNative = "https://%sdlsdk.%s/v1.0/android/";
    private final com.appsflyer.internal.aw onAppOpenAttribution;
    public int onAppOpenAttributionNative;
    private int onAttributionFailure;
    private final CountDownLatch onConversionDataFail;
    private final List<com.appsflyer.internal.cq> onConversionDataSuccess;
    private int onDeepLinking;
    private boolean onResponse;
    private final JSONObject onResponseError;
    static {
    }

    public ap(Context context, com.appsflyer.internal.aw aw2) {
        super(0, ap.onResponseNative, Boolean.FALSE, Boolean.TRUE, 0, context);
        ArrayList obj8 = new ArrayList();
        this.onConversionDataSuccess = obj8;
        obj8 = new CountDownLatch(1);
        this.onConversionDataFail = obj8;
        obj8 = new JSONObject();
        this.onResponseError = obj8;
        this.onAppOpenAttribution = aw2;
    }

    static Application AFInAppEventParameterName(com.appsflyer.internal.ap ap) {
        return ap.AFInAppEventType;
    }

    static DeepLinkResult AFInAppEventParameterName(com.appsflyer.internal.ap ap, Context context2) {
        int i2;
        int onAppOpenAttributionNative2;
        JSONObject jSONObject;
        int onAppOpenAttributionNative;
        Object str2;
        int i;
        JSONArray optJSONArray;
        int i3;
        String str;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        int i7 = 1;
        while (ap.onAppOpenAttributionNative == i7) {
            i3 = 0;
            ap.onResponseError.put("from_fg", currentTimeMillis - long);
            ak.a aVar = new ak.a(ap);
            str2 = aVar.AFKeystoreWrapper();
            String str9 = "net";
            if (ap.onResponseError.optJSONArray(str9) == null) {
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            optJSONArray.put(onAppOpenAttributionNative3 -= i7, currentTimeMillis3 - currentTimeMillis);
            ap.onResponseError.put(str9, optJSONArray);
            int i8 = 0;
            ah.AFKeystoreWrapper();
            jSONObject = new JSONObject(ah.valueOf(str2));
            ap.onResponse = jSONObject.optBoolean("is_second_ping", i7);
            if (!jSONObject.optBoolean("found")) {
            } else {
            }
            i2.values.put("is_deferred", i7);
            AFLogger.values("[DDL] Waiting for referrers...");
            ap.onConversionDataFail.await();
            ap.onResponseError.put("rfr_wait", currentTimeMillis2 -= currentTimeMillis3);
            ap.AFInAppEventParameterName(context2);
            currentTimeMillis = System.currentTimeMillis();
            i7 = 1;
            i2 = i8;
            optJSONArray = new JSONArray();
        }
        StringBuilder obj9 = new StringBuilder("[DDL] Error occurred. Server response code = ");
        obj9.append(str2.getResponseCode());
        AFLogger.values(obj9.toString());
        obj9 = new DeepLinkResult(i8, DeepLinkResult.Error.HTTP_STATUS_CODE);
        return obj9;
    }

    private void AFInAppEventParameterName(Context context) {
        com.appsflyer.internal.m onDeepLinkingNative;
        int onAppOpenAttributionNative2;
        Map values2;
        int onAppOpenAttributionNative;
        boolean values;
        String appsFlyerUID;
        String str2;
        String next2;
        boolean next;
        Date valueOf;
        Object aFInAppEventParameterName;
        String str;
        int i2 = 1;
        this.onAppOpenAttributionNative = onAppOpenAttributionNative3 += i2;
        StringBuilder stringBuilder = new StringBuilder("[DDL] Preparing request ");
        stringBuilder.append(this.onAppOpenAttributionNative);
        AFLogger.values(stringBuilder.toString());
        com.appsflyer.internal.ah ahVar = ah.AFKeystoreWrapper();
        this.values.put("is_first", Boolean.valueOf(ah.AFInAppEventType(context)));
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(Locale.getDefault().getLanguage());
        stringBuilder3.append("-");
        stringBuilder3.append(Locale.getDefault().getCountry());
        this.values.put("lang", stringBuilder3.toString());
        this.values.put("os", Build.VERSION.RELEASE);
        this.values.put("type", Build.MODEL);
        this.values.put("request_id", ahVar.getAppsFlyerUID(context));
        onDeepLinkingNative = ahVar.onDeepLinkingNative;
        onDeepLinkingNative = onDeepLinkingNative.AFInAppEventType;
        if (this.onAppOpenAttributionNative == i2 && onDeepLinkingNative != null && onDeepLinkingNative != null) {
            ahVar = ah.AFKeystoreWrapper();
            this.values.put("is_first", Boolean.valueOf(ah.AFInAppEventType(context)));
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(Locale.getDefault().getLanguage());
            stringBuilder3.append("-");
            stringBuilder3.append(Locale.getDefault().getCountry());
            this.values.put("lang", stringBuilder3.toString());
            this.values.put("os", Build.VERSION.RELEASE);
            this.values.put("type", Build.MODEL);
            this.values.put("request_id", ahVar.getAppsFlyerUID(context));
            onDeepLinkingNative = ahVar.onDeepLinkingNative;
            if (onDeepLinkingNative != null) {
                onDeepLinkingNative = onDeepLinkingNative.AFInAppEventType;
                if (onDeepLinkingNative != null) {
                    this.values.put("sharing_filter", onDeepLinkingNative);
                }
            }
            HashMap hashMap = new HashMap();
            onAppOpenAttributionNative2 = AFKeystoreWrapper(ac.valueOf(context, hashMap));
            onAppOpenAttributionNative = AFKeystoreWrapper(ac.values(context));
            if (onAppOpenAttributionNative2 != null) {
                this.values.put("gaid", onAppOpenAttributionNative2);
            }
            if (onAppOpenAttributionNative != null) {
                this.values.put("oaid", onAppOpenAttributionNative);
            }
        }
        String str13 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str13, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        valueOf = new Date(System.currentTimeMillis(), str13);
        String str7 = "timestamp";
        this.values.put(str7, simpleDateFormat.format(valueOf));
        this.values.put("request_count", Integer.valueOf(this.onAppOpenAttributionNative));
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.onConversionDataSuccess.iterator();
        while (iterator.hasNext()) {
            next2 = iterator.next();
            valueOf = new HashMap();
            aFInAppEventParameterName = next2.AFKeystoreWrapper.get("referrer");
            if (next2.valueOf == cq.b.AFInAppEventParameterName && (String)aFInAppEventParameterName != null) {
            } else {
            }
            valueOf = 0;
            if (valueOf != null) {
            }
            arrayList.add(valueOf);
            valueOf = new HashMap();
            aFInAppEventParameterName = next2.AFKeystoreWrapper.get("referrer");
            if ((String)(String)aFInAppEventParameterName != null) {
            } else {
            }
            str = "source";
            valueOf.put(str, (String)next2.AFKeystoreWrapper.get(str));
            valueOf.put("value", (String)(String)aFInAppEventParameterName);
        }
        if (!arrayList.isEmpty()) {
            this.values.put("referrers", arrayList);
        }
        String devKey = AppsFlyerProperties.getInstance().getDevKey();
        Object[] arr = new Object[2];
        arr[i2] = ah.AFKeystoreWrapper().getHostName();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.values.get(str7));
        stringBuilder2.append(devKey);
        values(Uri.parse(String.format(this.onInstallConversionDataLoadedNative, arr)).buildUpon().appendPath(context.getPackageName()).appendQueryParameter("af_sig", ag.AFKeystoreWrapper(stringBuilder2.toString(), devKey)).appendQueryParameter("sdk_version", ah.values).build().toString());
    }

    private void AFInAppEventType(com.appsflyer.internal.cq cq) {
        int obj3;
        if (ap.valueOf(cq)) {
            this.onConversionDataSuccess.add(cq);
            this.onConversionDataFail.countDown();
            StringBuilder stringBuilder = new StringBuilder("[DDL] Added non-organic ");
            stringBuilder.append(cq.getClass().getSimpleName());
            AFLogger.values(stringBuilder.toString());
        }
        obj3++;
        this.onAttributionFailure = obj3;
        if (obj3 == this.onDeepLinking) {
            this.onConversionDataFail.countDown();
        }
    }

    private Map<String, Object> AFKeystoreWrapper(com.appsflyer.internal.a.d.a a$d$a) {
        int i;
        String aFInAppEventParameterName;
        i = 0;
        if (a != null && a.valueOf != null) {
            if (a.valueOf != null) {
                aFInAppEventParameterName = a.AFInAppEventParameterName;
                if (aFInAppEventParameterName != null) {
                    if (!aFInAppEventParameterName.booleanValue()) {
                        i = 1;
                    }
                } else {
                }
            }
        }
        if (i != 0) {
            ap.3 anon = new ap.3(a);
            return anon;
        }
        return 0;
    }

    static void AFKeystoreWrapper(com.appsflyer.internal.ap ap, com.appsflyer.internal.cq cq2) {
        ap.AFInAppEventType(cq2);
    }

    static void valueOf(com.appsflyer.internal.ap ap) {
        int size;
        int length;
        int str;
        com.appsflyer.internal.cq str2;
        com.appsflyer.internal.cq.b valueOf;
        com.appsflyer.internal.cq.b aFKeystoreWrapper;
        ArrayList arrayList = new ArrayList();
        com.appsflyer.internal.cq[] aFLogger$LogLevel = ahVar.AFLogger$LogLevel;
        str = 0;
        while (str < aFLogger$LogLevel.length) {
            str2 = aFLogger$LogLevel[str];
            if (str2 != null && str2.valueOf != cq.b.AFKeystoreWrapper) {
            }
            str++;
            if (str2.valueOf != cq.b.AFKeystoreWrapper) {
            }
            arrayList.add(str2);
        }
        ap.onDeepLinking = arrayList.size();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            size = iterator.next();
            length = ap.4.valueOf[size.valueOf.ordinal()];
            if (length != 1) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder("[DDL] ");
            stringBuilder.append(size.AFKeystoreWrapper.get("source"));
            stringBuilder.append(" referrer collected earlier");
            AFLogger.values(stringBuilder.toString());
            ap.AFInAppEventType((cq)size);
            if (length != 2) {
            } else {
            }
            length = new ap.2(ap, size);
            size.addObserver(length);
        }
    }

    static void valueOf(com.appsflyer.internal.ap ap, Context context2) {
        ap.AFInAppEventParameterName(context2);
    }

    private static boolean valueOf(com.appsflyer.internal.cq cq) {
        Object obj6 = cq.AFKeystoreWrapper.get("click_ts");
        int i = 0;
        if ((Long)obj6 == null) {
            return i;
        }
        final long longValue = (Long)obj6.longValue();
        if (Long.compare(i2, millis2) < 0) {
            return 1;
        }
        return i;
    }

    private boolean values() {
        int size;
        final String str = "referrers";
        Object obj = this.values.get(str);
        final int i2 = 0;
        if ((List)obj != null) {
            size = (List)obj.size();
        } else {
            size = i2;
        }
        if (size < this.onDeepLinking && !this.values.containsKey(str)) {
            if (!this.values.containsKey(str)) {
                return 1;
            }
        }
        return i2;
    }

    @Override // com.appsflyer.internal.cd
    public final void AFInAppEventType(DeepLinkResult deepLinkResult) {
        try {
            this.onResponseError.put("status", deepLinkResult.getStatus().toString());
            this.onResponseError.put("timeout_value", ap.onAttributionFailureNative);
            onAppOpenAttribution.AFKeystoreWrapper.edit().putString("ddl", this.onResponseError.toString()).apply();
            ar.AFKeystoreWrapper(deepLinkResult);
        }
    }
}
