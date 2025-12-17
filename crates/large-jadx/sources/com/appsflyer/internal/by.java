package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class by implements Runnable {

    private static final List<String> AFInAppEventParameterName = null;
    private static String valueOf = "https://%sgcdsdk.%s/install_data/v4.0/";
    private final String AFInAppEventType;
    final ScheduledExecutorService AFKeystoreWrapper;
    private final int AppsFlyer2dXConversionCallback;
    private final com.appsflyer.internal.ah getLevel;
    private final AtomicInteger init;
    private final Application values;
    static {
        by.AFInAppEventParameterName = Arrays.asList(/* result */);
    }

    by(com.appsflyer.internal.ah ah, Application application2, String string3) {
        com.appsflyer.internal.k aFKeystoreWrapper;
        super();
        if (k.AFKeystoreWrapper == null) {
            aFKeystoreWrapper = new k();
            k.AFKeystoreWrapper = aFKeystoreWrapper;
        }
        this.AFKeystoreWrapper = k.AFKeystoreWrapper.AFInAppEventParameterName();
        final int i = 0;
        AtomicInteger atomicInteger = new AtomicInteger(i);
        this.init = atomicInteger;
        this.getLevel = ah;
        this.values = application2;
        this.AFInAppEventType = string3;
        this.AppsFlyer2dXConversionCallback = i;
    }

    private by(com.appsflyer.internal.by by) {
        com.appsflyer.internal.k aFKeystoreWrapper;
        super();
        if (k.AFKeystoreWrapper == null) {
            aFKeystoreWrapper = new k();
            k.AFKeystoreWrapper = aFKeystoreWrapper;
        }
        this.AFKeystoreWrapper = k.AFKeystoreWrapper.AFInAppEventParameterName();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.init = atomicInteger;
        this.getLevel = by.getLevel;
        this.values = by.values;
        this.AFInAppEventType = by.AFInAppEventType;
        this.AppsFlyer2dXConversionCallback = obj3++;
    }

    public static void valueOf(String string) {
        AppsFlyerConversionListener aFInAppEventType;
        String str;
        if (ah.AFInAppEventType != null) {
            AFLogger.values("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(string)));
            ah.AFInAppEventType.onConversionDataFail(string);
        }
    }

    static void valueOf(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n");
        stringBuilder.append(map.toString());
        AFLogger.values(stringBuilder.toString());
        ah.AFInAppEventType.onConversionDataSuccess(map);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String aFInAppEventType2;
        AtomicInteger init;
        int appsFlyer2dXConversionCallback;
        String init2;
        boolean string2;
        Object string;
        Map values2;
        String aFKeystoreWrapper2;
        Object obj2;
        String aFInAppEventType;
        int responseCode;
        boolean format;
        ScheduledExecutorService aFKeystoreWrapper;
        int length;
        TimeUnit mILLISECONDS;
        int values3;
        String str4;
        int i;
        String concat;
        Object str2;
        String valueOf2;
        String valueOf;
        String str3;
        com.appsflyer.internal.an anVar;
        String currentTimeMillis;
        String lowerCase;
        Object str;
        com.appsflyer.internal.an anVar2;
        int values;
        final Object obj = this;
        aFInAppEventType2 = "is_first_launch";
        aFKeystoreWrapper2 = "af_siteid";
        aFInAppEventType = obj.AFInAppEventType;
        if (aFInAppEventType != null) {
            if (aFInAppEventType.length() == 0) {
            } else {
                if (obj.getLevel.isStopped()) {
                    AFLogger.values("[GCD-E03] 'isStopTracking' enabled");
                    by.valueOf("'isStopTracking' enabled");
                }
                obj.init.incrementAndGet();
                int i2 = 0;
                i = 2;
                Application values6 = obj.values;
                if (values6 == null) {
                    AFLogger.values("[GCD-E06] Context null");
                    by.valueOf("Context null");
                    obj.init.decrementAndGet();
                }
                com.appsflyer.internal.ah getLevel3 = obj.getLevel;
                valueOf = getLevel3.valueOf(values6, getLevel3.AFInAppEventParameterName(values6));
                String str28 = "";
                int i4 = 1;
                final int i5 = 0;
                if (valueOf != null) {
                    if (!by.AFInAppEventParameterName.contains(valueOf.toLowerCase())) {
                        concat = "-".concat(String.valueOf(valueOf));
                    } else {
                        lowerCase = new Object[i4];
                        lowerCase[i5] = valueOf;
                        AFLogger.init(String.format("AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", lowerCase));
                        concat = str28;
                    }
                } else {
                }
                StringBuilder stringBuilder4 = new StringBuilder();
                Object[] arr = new Object[i];
                arr[i5] = AppsFlyerLib.getInstance().getHostPrefix();
                arr[i4] = ah.AFKeystoreWrapper().getHostName();
                stringBuilder4.append(String.format(by.valueOf, arr));
                stringBuilder4.append(obj.values.getPackageName());
                stringBuilder4.append(concat);
                stringBuilder4.append("?devkey=");
                stringBuilder4.append(obj.AFInAppEventType);
                stringBuilder4.append("&device_id=");
                WeakReference weakReference = new WeakReference(obj.values);
                stringBuilder4.append(al.AFInAppEventType(weakReference));
                valueOf2 = stringBuilder4.toString();
                if (an.values == null) {
                    anVar = new an();
                    an.values = anVar;
                }
                str = "server_request";
                an.values.AFInAppEventType(str, valueOf2, /* result */);
                aj.valueOf("[GCD-B01] URL: ".concat(String.valueOf(valueOf2)));
                URL url = new URL(valueOf2);
                Object instrument = FirebasePerfUrlConnection.instrument(url.openConnection());
                (HttpURLConnection)(URLConnection)instrument.setRequestMethod("GET");
                instrument.setConnectTimeout(10000);
                instrument.setRequestProperty("Connection", "close");
                instrument.connect();
                responseCode = instrument.getResponseCode();
                String valueOf7 = ah.valueOf(instrument);
                if (an.values == null) {
                    anVar2 = new an();
                    an.values = anVar2;
                }
                final String str32 = "server_response";
                String[] strArr = new String[i];
                strArr[i5] = String.valueOf(responseCode);
                strArr[i4] = valueOf7;
                an.values.AFInAppEventType(str32, valueOf2, strArr);
                values3 = 404;
                if (responseCode != 200) {
                    if (responseCode == values3) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("net", currentTimeMillis2 -= currentTimeMillis);
                        jSONObject2.put("retries", obj.AppsFlyer2dXConversionCallback);
                        appsFlyer2dXConversionCallback2.AFKeystoreWrapper.edit().putString("gcd", jSONObject2.toString()).apply();
                        aj.valueOf("Attribution data: ".concat(String.valueOf(valueOf7)));
                        length = bx.AFInAppEventType(valueOf7);
                        str2 = length.get("iscache");
                        if (valueOf7.length() > 0 && responseCode == values3) {
                            length = bx.AFInAppEventType(valueOf7);
                            str2 = length.get("iscache");
                            if (responseCode == values3) {
                                length.remove("error_reason");
                                length.remove("status_code");
                                length.put("af_status", "Organic");
                                length.put("af_message", "organic install");
                            }
                            if (str2 != null && !(Boolean)(Boolean)str2.booleanValue()) {
                                if (!str2.booleanValue()) {
                                    obj.getLevel.AFInAppEventType(obj.values, "appsflyerConversionDataCacheExpiration", System.currentTimeMillis());
                                }
                            }
                            values3 = "[Invite] Detected App-Invite via channel: ";
                            valueOf2 = "af_channel";
                            if (length.containsKey(aFKeystoreWrapper2)) {
                                if (length.containsKey(valueOf2)) {
                                    StringBuilder stringBuilder3 = new StringBuilder(values3);
                                    stringBuilder3.append(length.get(valueOf2));
                                    AFLogger.values(stringBuilder3.toString());
                                } else {
                                    currentTimeMillis = new Object[i4];
                                    currentTimeMillis[i5] = length.get(aFKeystoreWrapper2);
                                    AFLogger.values(String.format("[CrossPromotion] App was installed via %s's Cross Promotion", currentTimeMillis));
                                }
                            }
                            if (length.containsKey(aFKeystoreWrapper2)) {
                                StringBuilder stringBuilder2 = new StringBuilder(values3);
                                stringBuilder2.append(length.get(valueOf2));
                                AFLogger.values(stringBuilder2.toString());
                            }
                            length.put(aFInAppEventType2, Boolean.FALSE);
                            JSONObject jSONObject = new JSONObject(length);
                            string = jSONObject.toString();
                            responseCode = "attributionId";
                            if (string != null) {
                                ah.valueOf(obj.values, responseCode, string);
                            } else {
                                ah.valueOf(obj.values, responseCode, valueOf7);
                            }
                            values2 = bx.values(obj.values);
                            if (ah.AFInAppEventType != null && obj.init.intValue() <= i4 && !ah.AFKeystoreWrapper(obj.values).getBoolean("sixtyDayConversionData", i5)) {
                                if (obj.init.intValue() <= i4) {
                                    values2 = bx.values(obj.values);
                                    if (!ah.AFKeystoreWrapper(obj.values).getBoolean("sixtyDayConversionData", i5)) {
                                        values2.put(aFInAppEventType2, Boolean.TRUE);
                                    }
                                    length = values2;
                                    StringBuilder stringBuilder = new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n");
                                    stringBuilder.append(length.toString());
                                    AFLogger.values(stringBuilder.toString());
                                    ah.AFInAppEventType.onConversionDataSuccess(length);
                                }
                            }
                        }
                    } else {
                        if (responseCode != 403) {
                            if (responseCode >= 500 && obj.AppsFlyer2dXConversionCallback < i) {
                                if (obj.AppsFlyer2dXConversionCallback < i) {
                                    aFInAppEventType2 = new by(obj);
                                    ah.values(aFInAppEventType2.AFKeystoreWrapper, aFInAppEventType2, 10, values3);
                                } else {
                                    by.valueOf("Error connection to server: ".concat(String.valueOf(responseCode)));
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
                obj.init.decrementAndGet();
                if (instrument != null) {
                    instrument.disconnect();
                }
            }
            obj.AFKeystoreWrapper.shutdown();
            AFLogger.values("[GCD-A03] Server retrieving attempt finished");
        }
        AFLogger.values("[GCD-E05] AppsFlyer dev key is missing");
        by.valueOf("AppsFlyer dev key is missing");
    }
}
