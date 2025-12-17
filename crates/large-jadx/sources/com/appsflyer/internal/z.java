package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class z implements Runnable {

    private static String AFInAppEventType = "https://%ssdk-services.%s/validate-android-signature";
    private static String values;
    private WeakReference<Context> AFInAppEventParameterName;
    private String AFKeystoreWrapper;
    private String AFLogger$LogLevel;
    private String AFVersionDeclaration;
    private String AppsFlyer2dXConversionCallback;
    private Map<String, String> getLevel;
    private String init;
    private String valueOf;
    static {
        StringBuilder stringBuilder = new StringBuilder("https://%svalidate.%s/api/v");
        stringBuilder.append(ah.values);
        stringBuilder.append("/androidevent?buildnumber=6.5.0&app_id=");
        z.values = stringBuilder.toString();
    }

    z(Context context, String string2, String string3, String string4, String string5, String string6, String string7, Map<String, String> map8) {
        super();
        WeakReference weakReference = new WeakReference(context);
        this.AFInAppEventParameterName = weakReference;
        this.AFKeystoreWrapper = string2;
        this.valueOf = string3;
        this.init = string5;
        this.AppsFlyer2dXConversionCallback = string6;
        this.AFVersionDeclaration = string7;
        this.getLevel = map8;
        this.AFLogger$LogLevel = string4;
    }

    static void AFInAppEventParameterName(com.appsflyer.internal.z z, Map map2, Map map3, WeakReference weakReference4) {
        Object str4;
        String str;
        String[] strArr;
        String valueOf;
        String str3;
        int i2;
        int i;
        String str2;
        String obj8;
        com.appsflyer.internal.an obj9;
        Object obj10;
        com.appsflyer.internal.an obj11;
        aa.AFInAppEventType((Context)weakReference4.get()).valueOf();
        StringBuilder stringBuilder = new StringBuilder();
        int i3 = 2;
        Object[] arr = new Object[i3];
        i2 = 0;
        arr[i2] = AppsFlyerLib.getInstance().getHostPrefix();
        i = 1;
        arr[i] = ah.AFKeystoreWrapper().getHostName();
        stringBuilder.append(String.format(z.values, arr));
        stringBuilder.append((Context)weakReference4.get().getPackageName());
        String string = stringBuilder.toString();
        cj cjVar = new cj((Context)weakReference4.get());
        cjVar.AFLogger$LogLevel = z.AFKeystoreWrapper;
        cjVar.AppsFlyer2dXConversionCallback = ah.AFKeystoreWrapper((Context)weakReference4.get()).getString("referrer", "");
        obj11 = ah.AFKeystoreWrapper();
        Map map = obj11.AFInAppEventType(cjVar);
        map.put("price", z.AppsFlyer2dXConversionCallback);
        map.put("currency", z.AFVersionDeclaration);
        map.put("receipt_data", map2);
        if (weakReference4.get() != null && map3 != null) {
            aa.AFInAppEventType((Context)weakReference4.get()).valueOf();
            stringBuilder = new StringBuilder();
            i3 = 2;
            arr = new Object[i3];
            i2 = 0;
            arr[i2] = AppsFlyerLib.getInstance().getHostPrefix();
            i = 1;
            arr[i] = ah.AFKeystoreWrapper().getHostName();
            stringBuilder.append(String.format(z.values, arr));
            stringBuilder.append((Context)weakReference4.get().getPackageName());
            string = stringBuilder.toString();
            cjVar = new cj((Context)weakReference4.get());
            cjVar.AFLogger$LogLevel = z.AFKeystoreWrapper;
            cjVar.AppsFlyer2dXConversionCallback = ah.AFKeystoreWrapper((Context)weakReference4.get()).getString("referrer", "");
            obj11 = ah.AFKeystoreWrapper();
            map = obj11.AFInAppEventType(cjVar);
            map.put("price", z.AppsFlyer2dXConversionCallback);
            map.put("currency", z.AFVersionDeclaration);
            map.put("receipt_data", map2);
            if (map3 != null) {
                map.put("extra_prms", map3);
            }
            map.putAll(obj11.AFInAppEventType());
            obj8 = new JSONObject(map);
            if (an.values == null) {
                obj9 = new an();
                an.values = obj9;
            }
            obj10 = new String[i];
            obj10[i2] = obj8.toString();
            an.values.AFInAppEventType("server_request", string, obj10);
            obj8 = 0;
            obj8 = z.values((ch)cjVar.values(map).values(string));
            obj9 = -1;
            if (obj8 != null) {
                obj9 = obj8.getResponseCode();
            }
            obj10 = ah.valueOf(obj8);
            if (an.values == null) {
                obj11 = new an();
                an.values = obj11;
            }
            strArr = new String[i3];
            strArr[i2] = String.valueOf(obj9);
            strArr[i] = obj10;
            an.values.AFInAppEventType("server_response", string, strArr);
            obj11 = new StringBuilder("Validate-WH response - ");
            obj11.append(obj9);
            obj11.append(": ");
            obj9 = new JSONObject(obj10);
            obj11.append(obj9.toString());
            AFLogger.AFInAppEventType(obj11.toString());
            if (obj8 != null) {
                obj8.disconnect();
            }
        }
    }

    private static void AFInAppEventParameterName(boolean z, String string2, String string3, String string4, String string5) {
        Object aFInAppEventParameterName;
        String str;
        AppsFlyerInAppPurchaseValidatorListener obj2;
        String obj3;
        Object obj6;
        aFInAppEventParameterName = new StringBuilder("Validate callback parameters: ");
        aFInAppEventParameterName.append(string2);
        obj3 = " ";
        aFInAppEventParameterName.append(obj3);
        aFInAppEventParameterName.append(string3);
        aFInAppEventParameterName.append(obj3);
        aFInAppEventParameterName.append(string4);
        AFLogger.values(aFInAppEventParameterName.toString());
        if (ah.AFInAppEventParameterName != null && z != null) {
            aFInAppEventParameterName = new StringBuilder("Validate callback parameters: ");
            aFInAppEventParameterName.append(string2);
            obj3 = " ";
            aFInAppEventParameterName.append(obj3);
            aFInAppEventParameterName.append(string3);
            aFInAppEventParameterName.append(obj3);
            aFInAppEventParameterName.append(string4);
            AFLogger.values(aFInAppEventParameterName.toString());
            if (z != null) {
                AFLogger.values("Validate in app purchase success: ".concat(String.valueOf(string5)));
                ah.AFInAppEventParameterName.onValidateInApp();
            }
            AFLogger.values("Validate in app purchase failed: ".concat(String.valueOf(string5)));
            if (string5 == null) {
                obj6 = "Failed validating";
            }
            ah.AFInAppEventParameterName.onValidateInAppFailure(obj6);
        }
    }

    static Map AFKeystoreWrapper(com.appsflyer.internal.z z) {
        return z.getLevel;
    }

    static WeakReference values(com.appsflyer.internal.z z) {
        return z.AFInAppEventParameterName;
    }

    private static HttpURLConnection values(com.appsflyer.internal.ch ch) {
        StringBuilder stringBuilder = new StringBuilder("Calling ");
        stringBuilder.append(ch.onInstallConversionDataLoadedNative);
        AFLogger.values(stringBuilder.toString());
        ch.onResponseErrorNative = AppsFlyerLib.getInstance().isStopped();
        ak.a aVar = new ak.a(ch);
        return aVar.AFKeystoreWrapper();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int responseCode;
        String optBoolean;
        String aFKeystoreWrapper;
        int i;
        AppsFlyerInAppPurchaseValidatorListener init;
        String string;
        String appsFlyer2dXConversionCallback;
        String appsFlyer2dXConversionCallback2;
        String aFVersionDeclaration2;
        String aFVersionDeclaration;
        String message;
        com.appsflyer.internal.an anVar;
        com.appsflyer.internal.an anVar2;
        Object aFVersionDeclaration3;
        String str = "advertiserId";
        aFKeystoreWrapper = this.AFKeystoreWrapper;
        if (aFKeystoreWrapper != null) {
            if (aFKeystoreWrapper.length() == 0) {
            } else {
                if (AppsFlyerLib.getInstance().isStopped()) {
                }
                int i2 = 0;
                i = 0;
                Object obj = this.AFInAppEventParameterName.get();
                if ((Context)obj == null) {
                }
                HashMap hashMap = new HashMap();
                hashMap.put("public-key", this.valueOf);
                hashMap.put("sig-data", this.init);
                hashMap.put("signature", this.AFLogger$LogLevel);
                HashMap hashMap2 = new HashMap(hashMap);
                z.2 anon = new z.2(this, hashMap2);
                Thread thread = new Thread(anon);
                thread.start();
                hashMap.put("dev_key", this.AFKeystoreWrapper);
                hashMap.put("app_id", (Context)obj.getPackageName());
                hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(obj));
                String string4 = AppsFlyerProperties.getInstance().getString(str);
                if (string4 != null) {
                    hashMap.put(str, string4);
                }
                JSONObject jSONObject = new JSONObject(hashMap);
                int i4 = 2;
                Object[] arr = new Object[i4];
                arr[i] = AppsFlyerLib.getInstance().getHostPrefix();
                final int i5 = 1;
                arr[i5] = ah.AFKeystoreWrapper().getHostName();
                String format = String.format(z.AFInAppEventType, arr);
                if (an.values == null) {
                    anVar = new an();
                    an.values = anVar;
                }
                String[] strArr2 = new String[i5];
                strArr2[i] = jSONObject.toString();
                an.values.AFInAppEventType("server_request", format, strArr2);
                ck ckVar = new ck();
                HttpURLConnection values3 = z.values((ch)ckVar.values(hashMap).values(format));
                responseCode = -1;
                if (values3 != null) {
                    responseCode = values3.getResponseCode();
                }
                ah.AFKeystoreWrapper();
                String valueOf = ah.valueOf(values3);
                if (an.values == null) {
                    anVar2 = new an();
                    an.values = anVar2;
                }
                String[] strArr = new String[i4];
                strArr[i] = String.valueOf(responseCode);
                strArr[i5] = valueOf;
                an.values.AFInAppEventType("server_response", format, strArr);
                JSONObject jSONObject2 = new JSONObject(valueOf);
                jSONObject2.put("code", responseCode);
                if (responseCode == 200) {
                    StringBuilder stringBuilder = new StringBuilder("Validate response 200 ok: ");
                    stringBuilder.append(jSONObject2.toString());
                    AFLogger.AFInAppEventType(stringBuilder.toString());
                    z.AFInAppEventParameterName(jSONObject2.optBoolean("result"), this.init, this.AppsFlyer2dXConversionCallback, this.AFVersionDeclaration, jSONObject2.toString());
                } else {
                    AFLogger.AFInAppEventType("Failed Validate request");
                    z.AFInAppEventParameterName(i, this.init, this.AppsFlyer2dXConversionCallback, this.AFVersionDeclaration, jSONObject2.toString());
                }
                if (values3 != null) {
                    values3.disconnect();
                }
            }
        }
    }
}
