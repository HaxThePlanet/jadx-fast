package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Display;
import android.view.WindowManager;
import com.appsflyer.AFKeystoreWrapper;
import com.appsflyer.AFLogger;
import com.appsflyer.AFLogger.LogLevel;
import com.appsflyer.AFVersionDeclaration;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.AppsFlyerProperties.EmailsCryptType;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult.Error;
import com.google.android.gms.common.e;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ah extends AppsFlyerLib {

    static AppsFlyerInAppPurchaseValidatorListener AFInAppEventParameterName = null;
    public static AppsFlyerConversionListener AFInAppEventType = null;
    static final String AFKeystoreWrapper = "137";
    private static String onAppOpenAttribution = null;
    private static String onAppOpenAttributionNative = null;
    private static final String onAttributionFailureNative = null;
    private static com.appsflyer.internal.ah onConversionDataFail = null;
    private static String onConversionDataSuccess = null;
    private static String onInstallConversionDataLoadedNative = "https://%sstats.%s/stats";
    private static String onResponseErrorNative = null;
    private static String onResponseNative = null;
    public static final String valueOf = null;
    public static final String values = "6.5";
    public com.appsflyer.internal.cq[] AFLogger$LogLevel;
    String AFVersionDeclaration;
    public com.appsflyer.internal.aw AppsFlyer2dXConversionCallback;
    private long AppsFlyerConversionListener = -1;
    private boolean AppsFlyerInAppPurchaseValidatorListener = false;
    private long AppsFlyerLib;
    private Map<String, Object> enableLocationCollection;
    private Map<Long, String> getInstance;
    long getLevel;
    private final Executor getOutOfStore;
    private final com.appsflyer.internal.am getSdkVersion;
    String init;
    private long onAttributionFailure = -1;
    private boolean onDeepLinking = false;
    public com.appsflyer.internal.m onDeepLinkingNative;
    final com.appsflyer.internal.bd onInstallConversionFailureNative;
    private boolean onPause = false;
    private ScheduledExecutorService onResponse = null;
    private long onResponseError;
    private String onValidateInApp;
    private long onValidateInAppFailure;
    private boolean setAndroidIdData = false;
    private com.appsflyer.internal.ba setCustomerIdAndLogSession;
    private Application setCustomerUserId;
    private boolean setDebugLog;
    private boolean setImeiData = false;
    private Map<String, Object> setOaidData;
    private String setOutOfStore;
    private SharedPreferences setPhoneNumber;
    private boolean stop;
    private boolean updateServerUninstallToken = false;
    private com.appsflyer.internal.cs waitForCustomerUserId;

    class a implements Runnable {

        private final com.appsflyer.internal.i AFKeystoreWrapper;
        private com.appsflyer.internal.ah valueOf;
        private a(com.appsflyer.internal.ah ah, com.appsflyer.internal.i i2) {
            this.valueOf = ah;
            super();
            this.AFKeystoreWrapper = i2;
        }

        a(com.appsflyer.internal.ah ah, com.appsflyer.internal.i i2, byte b3) {
            super(ah, i2);
        }

        @Override // java.lang.Runnable
        public final void run() {
            ah.valueOf(this.valueOf, this.AFKeystoreWrapper);
        }
    }

    class b implements Runnable {

        private com.appsflyer.internal.ah AFInAppEventParameterName;
        private final com.appsflyer.internal.i values;
        private b(com.appsflyer.internal.ah ah, com.appsflyer.internal.i i2) {
            this.AFInAppEventParameterName = ah;
            super();
            this.values = i2;
        }

        b(com.appsflyer.internal.ah ah, com.appsflyer.internal.i i2, byte b3) {
            super(ah, i2);
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object str;
            boolean valueOf;
            boolean z;
            String nETWORK_FAILURE;
            Map sTOP_TRACKING;
            int message;
            boolean stopped;
            int singletonList;
            int aFKeystoreWrapper;
            String outputStreamWriter;
            Throwable fileOutputStream;
            Object obj;
            byte[] aFInAppEventParameterName;
            com.appsflyer.internal.cq[] sharedPreferences;
            int length;
            Throwable th;
            com.appsflyer.internal.cq coVar;
            boolean str2;
            int[] valueOf2;
            final Object obj2 = this;
            sTOP_TRACKING = obj2.values.AFKeystoreWrapper();
            com.appsflyer.internal.i values9 = obj2.values;
            final String onInstallConversionDataLoadedNative = values9.onInstallConversionDataLoadedNative;
            int onDeepLinkingNative = values9.onDeepLinkingNative;
            final Application aFInAppEventType = values9.AFInAppEventType;
            AppsFlyerRequestListener aFInAppEventParameterName3 = values3.AFInAppEventParameterName;
            if (obj2.AFInAppEventParameterName.isStopped() && aFInAppEventParameterName3 != null) {
                aFInAppEventParameterName3 = values3.AFInAppEventParameterName;
                if (aFInAppEventParameterName3 != null) {
                    aFInAppEventParameterName3.onError(RequestError.STOP_TRACKING, bc.values);
                }
            }
            singletonList = 0;
            final byte[] bArr = new byte[singletonList];
            final int i3 = 2;
            final int i4 = 1;
            ArrayList arrayList = new ArrayList();
            if (obj2.values.valueOf() && onDeepLinkingNative <= i3 && ah.AppsFlyer2dXConversionCallback(obj2.AFInAppEventParameterName) != null) {
                if (onDeepLinkingNative <= i3) {
                    arrayList = new ArrayList();
                    if (ah.AppsFlyer2dXConversionCallback(obj2.AFInAppEventParameterName) != null) {
                        sharedPreferences = ah.AppsFlyer2dXConversionCallback(obj2.AFInAppEventParameterName);
                        th = singletonList;
                        while (th < sharedPreferences.length) {
                            coVar = sharedPreferences[th];
                            str2 = coVar instanceof cn;
                            aFKeystoreWrapper = ah.10.valueOf[coVar.valueOf.ordinal()];
                            if (aFKeystoreWrapper != i4) {
                            } else {
                            }
                            if (str2 != null) {
                            }
                            arrayList.add(coVar.AFKeystoreWrapper);
                            th++;
                            singletonList = 0;
                            sTOP_TRACKING.put("rfr", cqVar.AFInAppEventType);
                            ah.AFKeystoreWrapper(aFInAppEventType).edit().putBoolean("newGPReferrerSent", i4).apply();
                            if (aFKeystoreWrapper != i3) {
                            } else {
                            }
                            if (onDeepLinkingNative == i3 && str2 == null) {
                            }
                            if (str2 == null) {
                            }
                            aFKeystoreWrapper = new HashMap();
                            aFKeystoreWrapper.put("source", coVar.values);
                            aFKeystoreWrapper.put("response", "TIMEOUT");
                            coVar = new co();
                            aFKeystoreWrapper.putAll(coVar);
                            arrayList.add(aFKeystoreWrapper);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        sTOP_TRACKING.put("referrers", arrayList);
                    }
                    if (ah.AFInAppEventParameterName(obj2.AFInAppEventParameterName) != null) {
                        sTOP_TRACKING.put("fb_ddl", ah.AFInAppEventParameterName(obj2.AFInAppEventParameterName));
                    }
                    if (ah.init(obj2.AFInAppEventParameterName) != null) {
                        if (ah.init(obj2.AFInAppEventParameterName).valueOf()) {
                            valueOf = ah.init(obj2.AFInAppEventParameterName).AFInAppEventParameterName();
                            if (valueOf != null && !valueOf.isEmpty()) {
                                if (!valueOf.isEmpty()) {
                                    sTOP_TRACKING.put("preload_id", valueOf);
                                }
                            }
                        } else {
                            sTOP_TRACKING.put("preload_id", Collections.singletonList("timeout"));
                        }
                    }
                }
            }
            if (!values4 instanceof bz) {
                a.d dVar = new a.d(sTOP_TRACKING, aFInAppEventType);
                sTOP_TRACKING.putAll(dVar);
                sTOP_TRACKING.putAll(obj2.AFInAppEventParameterName.AFInAppEventType());
            }
            com.appsflyer.internal.i values5 = obj2.values;
            if (values5 instanceof bz) {
                obj = sTOP_TRACKING.get("af_key");
            } else {
                obj = sTOP_TRACKING.get("appsflyerKey");
            }
            values5.AFLogger$LogLevel = obj;
            Object[] arr = new Object[i4];
            int i5 = 0;
            arr[i5] = obj2.values;
            Class[] arr2 = new Class[i4];
            arr2[0] = i.class;
            com.appsflyer.internal.i values8 = obj2.values;
            values8.init = (byte[])(Class)c.values(trimmedLength - 48, (char)i7, i8 += 24).getDeclaredMethod("AFKeystoreWrapper", arr2).invoke(0, arr);
            ah.values(obj2.AFInAppEventParameterName, values8);
            return;
            synchronized (sTOP_TRACKING) {
                values5.AFLogger$LogLevel = obj;
                arr = new Object[i4];
                i5 = 0;
                arr[i5] = obj2.values;
                arr2 = new Class[i4];
                arr2[0] = i.class;
                values8 = obj2.values;
                values8.init = (byte[])(Class)c.values(trimmedLength - 48, (char)i7, i8 += 24).getDeclaredMethod("AFKeystoreWrapper", arr2).invoke(i2, arr);
                ah.values(obj2.AFInAppEventParameterName, values8);
            }
        }
    }

    class d implements Runnable {

        private final Application AFInAppEventParameterName;
        private com.appsflyer.internal.ah values;
        public d(com.appsflyer.internal.ah ah, Context context2) {
            this.values = ah;
            super();
            this.AFInAppEventParameterName = (Application)context2.getApplicationContext();
        }

        @Override // java.lang.Runnable
        public final void run() {
            String devKey;
            Iterator iterator;
            Object aFInAppEventParameterName2;
            Object values2;
            Application aFInAppEventParameterName;
            int i;
            int i2;
            com.appsflyer.internal.ah values;
            com.appsflyer.internal.ce ceVar;
            StringBuilder stringBuilder;
            String str;
            if (ah.getLevel(this.values)) {
            }
            values4.getLevel = System.currentTimeMillis();
            ah.valueOf(this.values, true);
            int i3 = 0;
            ae.AFInAppEventType();
            iterator = ae.valueOf(this.AFInAppEventParameterName).iterator();
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                StringBuilder stringBuilder2 = new StringBuilder("resending request: ");
                String valueOf2 = next2.valueOf;
                stringBuilder2.append(valueOf2);
                AFLogger.AFInAppEventType(stringBuilder2.toString());
                ceVar = new ce();
                stringBuilder = new StringBuilder();
                stringBuilder.append(next2.valueOf);
                stringBuilder.append("&isCachedRequest=true&timeincache=");
                stringBuilder.append(i5 /= i);
                values2 = ceVar.values(stringBuilder.toString());
                values2.init = (f)next2.AFKeystoreWrapper();
                values2.AFLogger$LogLevel = AppsFlyerProperties.getInstance().getDevKey();
                aFInAppEventParameterName = this.AFInAppEventParameterName;
                if (aFInAppEventParameterName != null) {
                }
                values2.getLevel = next2.AFInAppEventParameterName;
                values2.onInstallConversionFailureNative = i3;
                ah.values(this.values, values2);
                values2.AFInAppEventType = (Application)aFInAppEventParameterName.getApplicationContext();
            }
            ah.valueOf(this.values, i3);
            ah.AFLogger$LogLevel(this.values).shutdown();
            ah.AFVersionDeclaration(this.values);
        }
    }
    static {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "6.5";
        stringBuilder.append(str);
        stringBuilder.append("/androidevent?buildnumber=6.5.0&app_id=");
        ah.valueOf = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder("https://%sadrevenue.%s/api/v");
        stringBuilder2.append(str);
        stringBuilder2.append("/android?buildnumber=6.5.0&app_id=");
        ah.onAppOpenAttributionNative = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append("/androidevent?app_id=");
        String string3 = stringBuilder3.toString();
        ah.onAttributionFailureNative = string3;
        StringBuilder stringBuilder4 = new StringBuilder("https://%sconversions.%s/api/v");
        stringBuilder4.append(string3);
        ah.onAppOpenAttribution = stringBuilder4.toString();
        StringBuilder stringBuilder5 = new StringBuilder("https://%slaunches.%s/api/v");
        stringBuilder5.append(string3);
        ah.onResponseNative = stringBuilder5.toString();
        StringBuilder stringBuilder6 = new StringBuilder("https://%sinapps.%s/api/v");
        stringBuilder6.append(string3);
        ah.onConversionDataSuccess = stringBuilder6.toString();
        StringBuilder stringBuilder7 = new StringBuilder("https://%sattr.%s/api/v");
        stringBuilder7.append(string3);
        ah.onResponseErrorNative = stringBuilder7.toString();
        int i = 0;
        ah.AFInAppEventParameterName = i;
        ah.AFInAppEventType = i;
        ah ahVar = new ah();
        ah.onConversionDataFail = ahVar;
    }

    public ah() {
        super();
        int i = -1;
        this.onResponseError = TimeUnit.SECONDS.toMillis(5);
        int i2 = 0;
        int i4 = 0;
        am amVar = new am();
        this.getSdkVersion = amVar;
        this.getOutOfStore = Executors.newSingleThreadExecutor();
        AFVersionDeclaration.init();
        bd bdVar = new bd();
        this.onInstallConversionFailureNative = bdVar;
    }

    static long AFInAppEventParameterName(com.appsflyer.internal.ah ah, long l2) {
        ah.AppsFlyerLib = l2;
        return l2;
    }

    private String AFInAppEventParameterName(Context context, String string2) {
        if (context == null) {
            return null;
        }
        onInstallConversionFailureNative.AFKeystoreWrapper = context.getApplicationContext();
        return this.onInstallConversionFailureNative.AFInAppEventType().AFKeystoreWrapper(string2);
    }

    private static String AFInAppEventParameterName(String string) {
        Method method;
        Object obj7;
        final int i2 = 1;
        final Class[] arr2 = new Class[i2];
        final int i3 = 0;
        arr2[i3] = String.class;
        Object[] arr = new Object[i2];
        arr[i3] = string;
        return (String)Class.forName("android.os.SystemProperties").getMethod("get", arr2).invoke(0, arr);
    }

    public static String AFInAppEventParameterName(SimpleDateFormat simpleDateFormat, long l2) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = new Date(l2, obj3);
        return simpleDateFormat.format(date);
    }

    static Map AFInAppEventParameterName(com.appsflyer.internal.ah ah) {
        return ah.setOaidData;
    }

    private void AFInAppEventParameterName(com.appsflyer.internal.i i) {
        boolean boolean;
        int rESPONSE_CODE_FAILURE;
        com.appsflyer.internal.k aFKeystoreWrapper;
        byte[] str3;
        String valueOf2;
        String onResponse;
        Object values;
        boolean valueOf;
        Object aFInAppEventParameterName;
        int currentTimeMillis2;
        com.appsflyer.internal.an anVar;
        int aFInAppEventType;
        String currentTimeMillis;
        int onDeepLinkingNative;
        int i3;
        com.appsflyer.internal.aw appsFlyer2dXConversionCallback;
        int str;
        String str2;
        int i2;
        final Object obj2 = this;
        Object obj = i;
        URL url = new URL(obj.onInstallConversionDataLoadedNative);
        str3 = i.AFInAppEventType();
        onResponse = obj.getLevel;
        valueOf = i.valueOf();
        Application aFInAppEventType3 = obj.AFInAppEventType;
        aFInAppEventParameterName = obj.AFInAppEventParameterName;
        aFInAppEventType = 1;
        if (valueOf && obj.onDeepLinkingNative == aFInAppEventType) {
            i3 = obj.onDeepLinkingNative == aFInAppEventType ? aFInAppEventType : 0;
        } else {
        }
        if (obj2.AppsFlyer2dXConversionCallback == null) {
            appsFlyer2dXConversionCallback = new aw(aFInAppEventType3);
            obj2.AppsFlyer2dXConversionCallback = appsFlyer2dXConversionCallback;
        }
        com.appsflyer.internal.aw appsFlyer2dXConversionCallback2 = obj2.AppsFlyer2dXConversionCallback;
        if (i3 != 0) {
            appsFlyer2dXConversionCallback2.AFInAppEventType.put("from_fg", Long.valueOf(currentTimeMillis4 -= appsFlyerLib));
            currentTimeMillis2 = System.currentTimeMillis();
        } else {
            currentTimeMillis2 = 0;
        }
        Object instrument = FirebasePerfUrlConnection.instrument(url.openConnection());
        (HttpURLConnection)(URLConnection)instrument.setRequestMethod("POST");
        instrument.setRequestProperty("Content-Length", String.valueOf(str3.length));
        str2 = i.AFInAppEventParameterName() ? "application/octet-stream" : "application/json";
        instrument.setRequestProperty("Content-Type", str2);
        instrument.setConnectTimeout(10000);
        int i8 = 1;
        instrument.setDoOutput(i8);
        if (!AppsFlyerProperties.getInstance().getBoolean("http_cache", i8)) {
            instrument.setUseCaches(false);
        }
        DataOutputStream dataOutputStream = new DataOutputStream(instrument.getOutputStream());
        dataOutputStream.write(str3);
        dataOutputStream.close();
        int responseCode = instrument.getResponseCode();
        if (i3 != 0) {
            appsFlyer2dXConversionCallback2.AFInAppEventType.put("net", Long.valueOf(currentTimeMillis5 -= currentTimeMillis2));
        }
        valueOf2 = ah.valueOf(instrument);
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[2];
        an.values.AFInAppEventType("server_response", url.toString(), String.valueOf(responseCode), valueOf2);
        AFLogger.AFInAppEventType("response code: ".concat(String.valueOf(responseCode)));
        if (responseCode == 200) {
            if (aFInAppEventType3 != null && valueOf) {
                if (valueOf) {
                    obj2.AppsFlyerConversionListener = System.currentTimeMillis();
                    obj2.onInstallConversionFailureNative.values();
                }
            }
            if (aFInAppEventParameterName != null) {
                aFInAppEventParameterName.onSuccess();
            }
            if (onResponse != null) {
                ae.AFInAppEventType();
                ae.values(onResponse, aFInAppEventType3);
            } else {
                valueOf = ah.AFKeystoreWrapper(aFInAppEventType3).edit();
                valueOf.putString("sentSuccessfully", "true");
                valueOf.apply();
                if (!obj2.onDeepLinking) {
                    if (Long.compare(onResponse, currentTimeMillis) < 0) {
                    } else {
                        if (obj2.onResponse == null && k.AFKeystoreWrapper == null) {
                            if (k.AFKeystoreWrapper == null) {
                                aFKeystoreWrapper = new k();
                                k.AFKeystoreWrapper = aFKeystoreWrapper;
                            }
                            obj2.onResponse = k.AFKeystoreWrapper.AFInAppEventParameterName();
                            rESPONSE_CODE_FAILURE = new ah.d(obj2, aFInAppEventType3);
                            ah.values(obj2.onResponse, rESPONSE_CODE_FAILURE, 1, strArr);
                        }
                    }
                }
            }
            bv bvVar = new bv(aFInAppEventType3);
            values = bvVar.values();
            if (values != null && values.values()) {
                if (values.values()) {
                    values = values.values;
                    AFLogger.values("Resending Uninstall token to AF servers: ".concat(String.valueOf(values)));
                    bvVar.AFKeystoreWrapper(values);
                }
            }
            obj2.onPause = ao.values(valueOf2).optBoolean("send_background", false);
        } else {
            if (aFInAppEventParameterName != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bc.AFInAppEventType);
                stringBuilder.append(" ");
                stringBuilder.append(responseCode);
                aFInAppEventParameterName.onError(RequestError.RESPONSE_CODE_FAILURE, stringBuilder.toString());
            }
        }
        bx.AFKeystoreWrapper(this, i, obj.AFLogger$LogLevel, aFInAppEventType3, ah.AFKeystoreWrapper(aFInAppEventType3), Integer.valueOf(responseCode), 0);
        if (instrument != null) {
            instrument.disconnect();
        }
    }

    private boolean AFInAppEventParameterName() {
        boolean stopped3;
        int i;
        Locale locale;
        String format;
        int stopped2;
        boolean stopped;
        int i2;
        int i3;
        int i4;
        final int i5 = 0;
        if (Long.compare(onAttributionFailure, i) > 0) {
            currentTimeMillis -= onAttributionFailure2;
            locale = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", locale);
            String str4 = "UTC";
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str4));
            Date date2 = new Date(this.onAttributionFailure, obj6);
            format = simpleDateFormat.format(date2);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str4));
            Date date = new Date(this.AppsFlyerConversionListener, obj9);
            stopped3 = simpleDateFormat.format(date);
            i2 = 2;
            i3 = 3;
            i4 = 1;
            if (Long.compare(i, onResponseError2) < 0 && !isStopped()) {
                if (!isStopped()) {
                    Object[] arr = new Object[4];
                    arr[i5] = format;
                    arr[i4] = stopped3;
                    arr[i2] = Long.valueOf(i);
                    arr[i3] = Long.valueOf(this.onResponseError);
                    AFLogger.AFInAppEventType(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", arr));
                    return i4;
                }
            }
            if (!isStopped()) {
                stopped = new Object[i3];
                stopped[i5] = format;
                stopped[i4] = stopped3;
                stopped[i2] = Long.valueOf(i);
                AFLogger.AFInAppEventType(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", stopped));
            }
        } else {
            if (!isStopped()) {
                AFLogger.AFInAppEventType("Sending first launch for this session!");
            }
        }
        return i5;
    }

    public static int AFInAppEventType(SharedPreferences sharedPreferences, String string2, boolean z3) {
        int int;
        SharedPreferences.Editor obj1;
        String obj2;
        if (z3) {
            obj1 = sharedPreferences.edit();
            obj1.putInt(string2, int++);
            obj1.apply();
        }
        if (an.values == null) {
            obj1 = new an();
            an.values = obj1;
        }
        if (an.values.AFLogger$LogLevel() && an.values == null) {
            if (an.values == null) {
                obj1 = new an();
                an.values = obj1;
            }
            an.values.values(String.valueOf(int));
        }
        return int;
    }

    static Application AFInAppEventType(com.appsflyer.internal.ah ah) {
        return ah.setCustomerUserId;
    }

    public static void AFInAppEventType(Context context, String string2) {
        SharedPreferences.Editor obj1 = ah.AFKeystoreWrapper(context).edit();
        obj1.putBoolean(string2, true);
        obj1.apply();
    }

    private void AFInAppEventType(Context context, String string2, Map<String, Object> map3) {
        Context applicationContext;
        Object obj3;
        cg cgVar = new cg();
        if (context != null) {
            cgVar.AFInAppEventType = (Application)context.getApplicationContext();
        }
        cgVar.AFVersionDeclaration = string2;
        cgVar.valueOf = map3;
        if (context instanceof Activity != null) {
        } else {
            obj3 = 0;
        }
        AFKeystoreWrapper(cgVar, obj3);
    }

    public static boolean AFInAppEventType(Context context) {
        if (!ah.AFKeystoreWrapper(context).contains("appsFlyerCount")) {
            return 1;
        }
        return 0;
    }

    public static boolean AFInAppEventType(SharedPreferences sharedPreferences) {
        return Boolean.parseBoolean(sharedPreferences.getString("sentSuccessfully", 0));
    }

    private boolean AFInAppEventType(com.appsflyer.internal.i i, SharedPreferences sharedPreferences2) {
        Object obj5;
        int obj6;
        final int i3 = 0;
        int i2 = ah.AFInAppEventType(sharedPreferences2, "appsFlyerCount", i3);
        final int i4 = 1;
        if (i2 == i4 && !i instanceof ca) {
            obj5 = !i instanceof ca ? i4 : i3;
        } else {
        }
        if (!sharedPreferences2.getBoolean("newGPReferrerSent", i3) && i2 == i4) {
            obj6 = i2 == i4 ? i4 : i3;
        } else {
        }
        if (obj6 == null && obj5 != null) {
            if (obj5 != null) {
            }
            return i3;
        }
        return i4;
    }

    static long AFKeystoreWrapper(com.appsflyer.internal.ah ah) {
        return ah.onValidateInAppFailure;
    }

    public static SharedPreferences AFKeystoreWrapper(Context context) {
        SharedPreferences setPhoneNumber;
        String str;
        SharedPreferences obj3;
        final com.appsflyer.internal.ah onConversionDataFail = ah.onConversionDataFail;
        if (onConversionDataFail.setPhoneNumber == null) {
            onConversionDataFail.setPhoneNumber = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
        }
        return obj3.setPhoneNumber;
    }

    public static com.appsflyer.internal.ah AFKeystoreWrapper() {
        return ah.onConversionDataFail;
    }

    private static String AFKeystoreWrapper(Activity activity) {
        Object extras;
        int string;
        Intent intent;
        Bundle extras2;
        String concat;
        String valueOf;
        Throwable obj6;
        extras = "af";
        string = 0;
        intent = activity.getIntent();
        extras2 = intent.getExtras();
        string = extras2.getString(extras);
        if (activity != null && intent != null && extras2 != null && string != null) {
            intent = activity.getIntent();
            if (intent != null) {
                extras2 = intent.getExtras();
                if (extras2 != null) {
                    string = extras2.getString(extras);
                    if (string != null) {
                        AFLogger.AFInAppEventType("Push Notification received af payload = ".concat(String.valueOf(string)));
                        extras2.remove(extras);
                        activity.setIntent(intent.putExtras(extras2));
                    }
                }
            }
        }
        return string;
    }

    private static String AFKeystoreWrapper(File file, String string2) {
        int i;
        String str2;
        String str;
        String obj5;
        i = 0;
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(file);
        properties.load(fileReader);
        AFLogger.AFInAppEventType("Found PreInstall property!");
        fileReader.close();
        return properties.getProperty(string2);
    }

    private static String AFKeystoreWrapper(String string) {
        boolean matches;
        String substring;
        ArrayList arrayList;
        Iterator iterator;
        String str;
        boolean contains;
        StringBuilder stringBuilder;
        Object next;
        boolean contains2;
        boolean startsWith;
        String obj8;
        if (string == null) {
            return null;
        }
        matches = "access_token";
        if (string.matches("fb\\d*?://authorize.*") && string.contains(matches)) {
            matches = "access_token";
            if (string.contains(matches)) {
                int indexOf = string.indexOf(63);
                if (indexOf == -1) {
                    substring = "";
                } else {
                    substring = string.substring(indexOf);
                }
                if (substring.length() == 0) {
                    return string;
                }
                arrayList = new ArrayList();
                str = "&";
                if (substring.contains(str)) {
                    arrayList = new ArrayList(Arrays.asList(substring.split(str)));
                } else {
                    arrayList.add(substring);
                }
                stringBuilder = new StringBuilder();
                iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if ((String)next.contains(matches)) {
                    } else {
                    }
                    if (stringBuilder.length() != 0) {
                    } else {
                    }
                    contains2 = "?";
                    if (!next.startsWith(contains2)) {
                    }
                    stringBuilder.append(next);
                    stringBuilder.append(contains2);
                    stringBuilder.append(str);
                    iterator.remove();
                }
                obj8 = string.replace(substring, stringBuilder.toString());
            }
        }
        return obj8;
    }

    private String AFKeystoreWrapper(SimpleDateFormat simpleDateFormat, Context context2) {
        boolean date;
        String string;
        String obj4;
        final String str2 = "appsFlyerFirstInstall";
        if (ah.AFKeystoreWrapper(context2).getString(str2, 0) == null) {
            if (ah.AFInAppEventType(context2)) {
                AFLogger.values("AppsFlyer: first launch detected");
                date = new Date();
                obj4 = simpleDateFormat.format(date);
            } else {
                obj4 = "";
            }
            obj4 = ah.AFKeystoreWrapper(context2).edit();
            obj4.putString(str2, obj4);
            obj4.apply();
        }
        AFLogger.AFInAppEventType("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    public static void AFKeystoreWrapper(Context context, Map<String, ? super String> map2) {
        String aFKeystoreWrapper;
        String str;
        com.appsflyer.internal.y values = y.e.values;
        com.appsflyer.internal.y.a obj2 = y.AFKeystoreWrapper(context);
        map2.put("network", obj2.values);
        aFKeystoreWrapper = obj2.AFKeystoreWrapper;
        if (aFKeystoreWrapper != null) {
            map2.put("operator", aFKeystoreWrapper);
        }
        obj2 = obj2.AFInAppEventType;
        if (obj2 != null) {
            map2.put("carrier", obj2);
        }
    }

    private void AFKeystoreWrapper(com.appsflyer.internal.i i) {
        int eVENT_TIMEOUT;
        com.appsflyer.internal.k aFKeystoreWrapper;
        int aFInAppEventParameterName;
        int currentTimeMillis;
        boolean valueOf;
        aFInAppEventParameterName = 0;
        currentTimeMillis = 1;
        eVENT_TIMEOUT = i.AFVersionDeclaration == null ? currentTimeMillis : aFInAppEventParameterName;
        if (valueOf()) {
            AFLogger.valueOf("CustomerUserId not set, reporting is disabled", currentTimeMillis);
        }
        if (eVENT_TIMEOUT != 0) {
            if (AppsFlyerProperties.getInstance().getBoolean("launchProtectEnabled", currentTimeMillis)) {
                AppsFlyerRequestListener obj6 = i.AFInAppEventParameterName;
                if (AFInAppEventParameterName() && obj6 != null) {
                    obj6 = i.AFInAppEventParameterName;
                    if (obj6 != null) {
                        obj6.onError(RequestError.EVENT_TIMEOUT, bc.AFInAppEventParameterName);
                    }
                }
            } else {
                AFLogger.AFInAppEventType("Allowing multiple launches within a 5 second time window.");
            }
            this.onAttributionFailure = System.currentTimeMillis();
        }
        if (k.AFKeystoreWrapper == null) {
            aFKeystoreWrapper = new k();
            k.AFKeystoreWrapper = aFKeystoreWrapper;
        }
        ah.a aVar = new ah.a(this, i, aFInAppEventParameterName);
        ah.values(k.AFKeystoreWrapper.AFInAppEventParameterName(), aVar, 0, obj4);
    }

    private static void AFKeystoreWrapper(JSONObject jSONObject) {
        int length;
        Object valueOf;
        int i2;
        JSONArray jSONArray;
        long long;
        long jSONArray2;
        int i;
        int length2;
        long longValue2;
        long longValue;
        ArrayList arrayList = new ArrayList();
        Iterator keys = jSONObject.keys();
        i2 = 0;
        for (String next2 : keys) {
            jSONArray = new JSONArray((String)jSONObject.get(next2));
            while (i2 < jSONArray.length()) {
                arrayList.add(Long.valueOf(jSONArray.getLong(i2)));
                i2++;
            }
            i2 = 0;
            arrayList.add(Long.valueOf(jSONArray.getLong(i2)));
            i2++;
        }
        Collections.sort(arrayList);
        Iterator keys2 = jSONObject.keys();
        while (/* condition */) {
            while (keys2.hasNext()) {
                if (jSONArray == null) {
                }
                long = keys2.next();
                jSONArray2 = new JSONArray((String)jSONObject.get((String)long));
                i = i2;
                while (i < jSONArray2.length()) {
                    longValue2 = 1;
                    i++;
                    jSONArray = long;
                }
                longValue2 = 1;
                i++;
                jSONArray = long;
            }
            if (jSONArray == null) {
            }
            long = keys2.next();
            jSONArray2 = new JSONArray((String)jSONObject.get((String)long));
            i = i2;
            while (i < jSONArray2.length()) {
                longValue2 = 1;
                i++;
                jSONArray = long;
            }
            if (Long.compare(long2, longValue2) != 0) {
            } else {
            }
            jSONArray = i3;
            longValue2 = 1;
            if (Long.compare(long3, longValue) != 0) {
            } else {
            }
            if (Long.compare(length2, longValue2) == 0) {
            } else {
            }
            i++;
            jSONArray = long;
        }
        if (jSONArray != null) {
            jSONObject.remove(jSONArray);
        }
    }

    static ScheduledExecutorService AFLogger$LogLevel(com.appsflyer.internal.ah ah) {
        return ah.onResponse;
    }

    private static boolean AFLogger$LogLevel(Context context) {
        int sDK_INT;
        int next;
        String str;
        boolean z;
        int i;
        NetworkCapabilities networkCapabilities;
        boolean transport;
        Throwable obj7;
        final int i2 = 0;
        sDK_INT = Build.VERSION.SDK_INT;
        str = "Failed collecting ivc data";
        if (context != null && sDK_INT >= 23) {
            sDK_INT = Build.VERSION.SDK_INT;
            str = "Failed collecting ivc data";
            if (sDK_INT >= 23) {
                obj7 = context.getSystemService("connectivity");
                android.net.Network[] allNetworks = (ConnectivityManager)obj7.getAllNetworks();
                i = i2;
                while (i < allNetworks.length) {
                    networkCapabilities = obj7.getNetworkCapabilities(allNetworks[i]);
                    i++;
                }
                return i2;
            }
            if (sDK_INT >= 16) {
                try {
                    obj7 = new ArrayList();
                    Iterator iterator = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        if ((NetworkInterface)next.isUp()) {
                        }
                        obj7.add(next.getName());
                    }
                    next = iterator.next();
                    if ((NetworkInterface)next.isUp()) {
                    }
                    obj7.add(next.getName());
                    return obj7.contains("tun0");
                    AFLogger.AFKeystoreWrapper(obj3, context);
                    return i2;
                } catch (Exception e) {
                }
            }
        }
    }

    static ScheduledExecutorService AFVersionDeclaration(com.appsflyer.internal.ah ah) {
        final int i = 0;
        ah.onResponse = i;
        return i;
    }

    private static boolean AppsFlyer2dXConversionCallback(Context context) {
        int i;
        boolean boolean;
        String str;
        Context obj4;
        final int i3 = 0;
        int i2 = 1;
        if (!AppsFlyerProperties.getInstance().getBoolean("collectAndroidIdForceByUser", i3)) {
            if (AppsFlyerProperties.getInstance().getBoolean("collectIMEIForceByUser", i3)) {
                i = i2;
            } else {
                i = i3;
            }
        } else {
        }
        if (i == 0 && !ah.init(context)) {
            if (!ah.init(context)) {
            }
            return i3;
        }
        return i2;
    }

    static com.appsflyer.internal.cq[] AppsFlyer2dXConversionCallback(com.appsflyer.internal.ah ah) {
        return ah.AFLogger$LogLevel;
    }

    private static float getLevel(Context context) {
        int i;
        int obj3;
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            obj3 = context.getApplicationContext().registerReceiver(0, intentFilter);
            int i4 = -1;
            int intExtra = obj3.getIntExtra("level", i4);
            obj3 = obj3.getIntExtra("scale", i4);
            if (intExtra != i4 && obj3 == i4) {
            }
            if (obj3 == i4) {
            }
            i3 *= obj3;
            return 1112014848;
            AFLogger.AFKeystoreWrapper(context.getMessage(), context);
            return i;
        }
    }

    private boolean getLevel() {
        Map enableLocationCollection;
        enableLocationCollection = this.enableLocationCollection;
        if (enableLocationCollection != null && !enableLocationCollection.isEmpty()) {
            if (!enableLocationCollection.isEmpty()) {
                return 1;
            }
        }
        return 0;
    }

    static boolean getLevel(com.appsflyer.internal.ah ah) {
        return ah.onDeepLinking;
    }

    static com.appsflyer.internal.cs init(com.appsflyer.internal.ah ah) {
        return ah.waitForCustomerUserId;
    }

    private static boolean init(Context context) {
        int i;
        String str;
        final int i2 = 1;
        if (e.o().g(context) == 0) {
            try {
                return i2;
                AFLogger.AFKeystoreWrapper("WARNING:  Google play services is unavailable. ", th);
                context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
                return i2;
                AFLogger.AFKeystoreWrapper("WARNING:  Google Play Services is unavailable. ", context);
                return th;
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
            }
        }
    }

    public static String valueOf(HttpURLConnection httpURLConnection) {
        Throwable str;
        int i;
        Object valueOf;
        Throwable th2;
        java.io.InputStream errorStream;
        BufferedReader bufferedReader;
        Throwable th3;
        InputStreamReader inputStreamReader;
        StringBuilder stringBuilder;
        String str2;
        Throwable th;
        Throwable obj7;
        StringBuilder stringBuilder2 = new StringBuilder();
        int i2 = 0;
        if (httpURLConnection.getErrorStream() == null) {
            errorStream = httpURLConnection.getInputStream();
        }
        inputStreamReader = new InputStreamReader(errorStream);
        bufferedReader = new BufferedReader(inputStreamReader);
        i = 0;
        stringBuilder = bufferedReader.readLine();
        while (stringBuilder != null) {
            if (i != 0) {
            } else {
            }
            valueOf = "";
            stringBuilder2.append(valueOf);
            stringBuilder2.append(stringBuilder);
            i = 1;
            stringBuilder = bufferedReader.readLine();
            valueOf = '\u000a';
        }
        bufferedReader.close();
        inputStreamReader.close();
        obj7 = stringBuilder2.toString();
        JSONObject jSONObject2 = new JSONObject(obj7);
        return obj7;
    }

    static Map valueOf(com.appsflyer.internal.ah ah) {
        return ah.enableLocationCollection;
    }

    private static void valueOf(Context context) {
        int values;
        String str;
        Object aFKeystoreWrapper;
        StringBuilder aFKeystoreWrapper2;
        KeyStore aFInAppEventParameterName;
        String obj4;
        if (ab.AFInAppEventParameterName()) {
            values = 23;
            AFLogger.AFKeystoreWrapper("OPPO device found");
        } else {
            values = 18;
        }
        int sDK_INT = Build.VERSION.SDK_INT;
        aFKeystoreWrapper2 = 1;
        if (sDK_INT >= values && !ah.values("keyPropDisableAFKeystore", aFKeystoreWrapper2)) {
            aFKeystoreWrapper2 = 1;
            if (!ah.values("keyPropDisableAFKeystore", aFKeystoreWrapper2)) {
                StringBuilder stringBuilder = new StringBuilder("OS SDK is=");
                stringBuilder.append(sDK_INT);
                stringBuilder.append("; use KeyStore");
                AFLogger.AFKeystoreWrapper(stringBuilder.toString());
                AFKeystoreWrapper aFKeystoreWrapper3 = new AFKeystoreWrapper(context);
                if (!aFKeystoreWrapper3.AFInAppEventParameterName()) {
                    aFKeystoreWrapper = new WeakReference(context);
                    aFKeystoreWrapper3.AFInAppEventType = al.AFInAppEventType(aFKeystoreWrapper);
                    aFKeystoreWrapper3.valueOf = 0;
                    aFKeystoreWrapper3.AFInAppEventParameterName(aFKeystoreWrapper3.AFInAppEventType());
                } else {
                    obj4 = aFKeystoreWrapper3.AFInAppEventType();
                    aFKeystoreWrapper = aFKeystoreWrapper3.AFKeystoreWrapper;
                    aFKeystoreWrapper3.valueOf = valueOf3 += aFKeystoreWrapper2;
                    AFLogger.AFInAppEventType("Deleting key with alias: ".concat(String.valueOf(obj4)));
                    aFKeystoreWrapper2 = aFKeystoreWrapper3.AFKeystoreWrapper;
                    aFKeystoreWrapper3.AFInAppEventParameterName.deleteEntry(obj4);
                    synchronized (aFKeystoreWrapper) {
                        obj4 = aFKeystoreWrapper3.AFInAppEventType();
                        aFKeystoreWrapper = aFKeystoreWrapper3.AFKeystoreWrapper;
                        aFKeystoreWrapper3.valueOf = valueOf3 += aFKeystoreWrapper2;
                        AFLogger.AFInAppEventType("Deleting key with alias: ".concat(String.valueOf(obj4)));
                        aFKeystoreWrapper2 = aFKeystoreWrapper3.AFKeystoreWrapper;
                        aFKeystoreWrapper3.AFInAppEventParameterName.deleteEntry(obj4);
                    }
                    aFKeystoreWrapper3.AFInAppEventParameterName(aFKeystoreWrapper3.AFInAppEventType());
                }
                AppsFlyerProperties.getInstance().set("KSAppsFlyerId", aFKeystoreWrapper3.valueOf());
                AppsFlyerProperties.getInstance().set("KSAppsFlyerRICounter", String.valueOf(aFKeystoreWrapper3.AFKeystoreWrapper()));
            }
        }
        obj4 = new StringBuilder("OS SDK is=");
        obj4.append(sDK_INT);
        obj4.append("; no KeyStore usage");
        AFLogger.AFKeystoreWrapper(obj4.toString());
    }

    public static void valueOf(Context context, String string2, String string3) {
        SharedPreferences.Editor obj0 = ah.AFKeystoreWrapper(context).edit();
        obj0.putString(string2, string3);
        obj0.apply();
    }

    private static void valueOf(Context context, Map<String, Object> map2) {
        String str;
        Object obj1;
        obj1 = context.getSystemService("window");
        if ((WindowManager)obj1 != null) {
            obj1 = (WindowManager)obj1.getDefaultDisplay().getRotation();
            if (obj1 != null) {
                if (obj1 != 1) {
                    if (obj1 != 2) {
                        obj1 = obj1 != 3 ? "" : "lr";
                    } else {
                        obj1 = "pr";
                    }
                } else {
                    obj1 = "l";
                }
            } else {
                obj1 = "p";
            }
            map2.put("sc_o", obj1);
        }
    }

    static void valueOf(com.appsflyer.internal.ah ah, com.appsflyer.internal.i i2) {
        Object aFInAppEventType;
        int remove;
        boolean remove2;
        boolean boolean;
        int length;
        int i4;
        int i3;
        boolean stopped;
        int i5;
        String name;
        int i;
        String format;
        String string;
        Object[] arr;
        StringBuilder stringBuilder;
        String valueOf;
        Map values;
        Object length2;
        boolean stopped2;
        String hostName;
        Object obj9;
        Object obj10;
        aFInAppEventType = i2.AFInAppEventType;
        if (aFInAppEventType == null) {
            AFLogger.values("sendWithEvent - got null context. skipping event/launch.");
        }
        SharedPreferences sharedPreferences = ah.AFKeystoreWrapper(aFInAppEventType);
        AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
        if (!ah.isStopped()) {
            StringBuilder stringBuilder3 = new StringBuilder("sendWithEvent from activity: ");
            stringBuilder3.append(aFInAppEventType.getClass().getName());
            AFLogger.AFInAppEventType(stringBuilder3.toString());
        }
        i5 = 1;
        i = 0;
        length = i2.AFVersionDeclaration == null ? i5 : i;
        i2.onInstallConversionFailureNative = length;
        values = ah.AFInAppEventType(i2);
        length2 = values.get("appsflyerKey");
        if ((String)length2 != null) {
            if ((String)length2.length() == 0) {
            } else {
                if (!ah.isStopped()) {
                    AFLogger.AFInAppEventType("AppsFlyerLib.sendWithEvent");
                }
                i3 = ah.AFInAppEventType(sharedPreferences, "appsFlyerCount", i);
                int i6 = 2;
                if (!i2 instanceof ca) {
                    if (i2 instanceof cf) {
                        arr = new Object[i6];
                        arr[i] = AppsFlyerLib.getInstance().getHostPrefix();
                        arr[i5] = ah.onConversionDataFail.getHostName();
                        format = String.format(ah.onResponseErrorNative, arr);
                    } else {
                        if (length != 0) {
                            if (i3 < i6) {
                                arr = new Object[i6];
                                arr[i] = AppsFlyerLib.getInstance().getHostPrefix();
                                arr[i5] = ah.onConversionDataFail.getHostName();
                                format = String.format(ah.onAppOpenAttribution, arr);
                            } else {
                                arr = new Object[i6];
                                arr[i] = AppsFlyerLib.getInstance().getHostPrefix();
                                arr[i5] = ah.onConversionDataFail.getHostName();
                                format = String.format(ah.onResponseNative, arr);
                            }
                        } else {
                            arr = new Object[i6];
                            arr[i] = AppsFlyerLib.getInstance().getHostPrefix();
                            arr[i5] = ah.onConversionDataFail.getHostName();
                            format = String.format(ah.onConversionDataSuccess, arr);
                        }
                    }
                } else {
                }
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(format);
                stringBuilder4.append(aFInAppEventType.getPackageName());
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder4.toString());
                stringBuilder.append("&buildnumber=6.5.0");
                String str = ah.AFInAppEventParameterName(aFInAppEventType);
                if (str != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder.toString());
                    stringBuilder.append("&channel=");
                    stringBuilder.append(str);
                    string = stringBuilder.toString();
                }
                if (!AppsFlyerProperties.getInstance().getBoolean("collectAndroidIdForceByUser", i)) {
                    if (AppsFlyerProperties.getInstance().getBoolean("collectIMEIForceByUser", i)) {
                        remove = i5;
                    } else {
                        remove = i;
                    }
                } else {
                }
                if (remove == 0 && values.get("advertiserId") != null && TextUtils.isEmpty(ah.AFVersionDeclaration) && values.remove("android_id") != null) {
                    if (values.get("advertiserId") != null) {
                        if (TextUtils.isEmpty(ah.AFVersionDeclaration)) {
                            if (values.remove("android_id") != null) {
                                AFLogger.AFInAppEventType("validateGaidAndIMEI :: removing: android_id");
                            }
                        }
                        if (TextUtils.isEmpty(ah.init) && values.remove("imei") != null) {
                            if (values.remove("imei") != null) {
                                AFLogger.AFInAppEventType("validateGaidAndIMEI :: removing: imei");
                            }
                        }
                    }
                }
                obj10 = i2.values(string).values(values);
                obj10.onDeepLinkingNative = i3;
                ah.b bVar = new ah.b(ah, obj10, i);
                if (length != 0) {
                    obj10 = ah.AFLogger$LogLevel;
                    if (obj10 != null) {
                        i3 = i;
                        while (i < obj10.length) {
                            string = obj10[i];
                            if (string.valueOf == cq.b.values) {
                            }
                            i++;
                            StringBuilder stringBuilder2 = new StringBuilder("Failed to get ");
                            stringBuilder2.append(string.values);
                            stringBuilder2.append(" referrer, wait ...");
                            AFLogger.values(stringBuilder2.toString());
                            i3 = i5;
                        }
                        i = i3;
                    }
                    if (ah.setImeiData != null && !ah.values()) {
                        if (!ah.values()) {
                            AFLogger.values("fetching Facebook deferred AppLink data, wait ...");
                            i = i5;
                        }
                    }
                    if (ah.setAndroidIdData != null && !ah.getLevel()) {
                        if (!ah.getLevel()) {
                        } else {
                            i5 = i;
                        }
                    } else {
                    }
                } else {
                }
                if (h.AFKeystoreWrapper) {
                    AFLogger.AFKeystoreWrapper("ESP deeplink: execute launch on SerialExecutor");
                    if (k.AFKeystoreWrapper == null) {
                        obj9 = new k();
                        k.AFKeystoreWrapper = obj9;
                    }
                    obj9 = k.AFKeystoreWrapper;
                    if (obj9.AFInAppEventType == null) {
                        obj9.AFInAppEventType = Executors.newSingleThreadScheduledExecutor(obj9.values);
                    }
                    obj9 = obj9.AFInAppEventType;
                } else {
                    if (k.AFKeystoreWrapper == null) {
                        obj9 = new k();
                        k.AFKeystoreWrapper = obj9;
                    }
                    obj9 = k.AFKeystoreWrapper.AFInAppEventParameterName();
                }
                i4 = i5 != 0 ? 500 : 0;
            }
            ah.values(obj9, bVar, i4, i3);
        }
        AFLogger.values("Not sending data yet, waiting for dev key");
        obj9 = i2.AFInAppEventParameterName;
        if (obj9 != null) {
            obj9.onError(RequestError.NO_DEV_KEY, bc.valueOf);
        }
    }

    static boolean valueOf(com.appsflyer.internal.ah ah, com.appsflyer.internal.i i2, SharedPreferences sharedPreferences3) {
        return ah.AFInAppEventType(i2, sharedPreferences3);
    }

    static boolean valueOf(com.appsflyer.internal.ah ah, boolean z2) {
        ah.onDeepLinking = z2;
        return z2;
    }

    static long values(com.appsflyer.internal.ah ah) {
        return ah.AppsFlyerLib;
    }

    static long values(com.appsflyer.internal.ah ah, long l2) {
        ah.onValidateInAppFailure = l2;
        return l2;
    }

    private static File values(String string) {
        String message;
        Throwable obj1;
        if (string != null && string.trim().length() > 0) {
            if (string.trim().length() > 0) {
                try {
                    File file = new File(string.trim());
                    return file;
                    AFLogger.AFKeystoreWrapper(string.getMessage(), string);
                    return null;
                }
            }
        }
    }

    public static Map<String, Object> values(Map<String, Object> map) {
        boolean hashMap;
        Object obj2;
        final String str = "meta";
        if (map.containsKey(str)) {
            obj2 = map.get(str);
        } else {
            hashMap = new HashMap();
            map.put(str, hashMap);
            obj2 = hashMap;
        }
        return obj2;
    }

    static void values(com.appsflyer.internal.ah ah, com.appsflyer.internal.i i2) {
        String encodeToString;
        String concat;
        com.appsflyer.internal.an anVar;
        String str;
        StringBuilder stringBuilder = new StringBuilder("url: ");
        stringBuilder.append(i2.onInstallConversionDataLoadedNative);
        AFLogger.AFInAppEventType(stringBuilder.toString());
        if (i2.getLevel != null) {
            AFLogger.AFInAppEventType("cached data: ".concat(String.valueOf(Base64.encodeToString(i2.AFInAppEventType(), 2))));
        } else {
            JSONObject jSONObject = new JSONObject(i2.AFKeystoreWrapper());
            encodeToString = jSONObject.toString();
            String replaceAll = encodeToString.replaceAll("\\p{C}", "*Non-printing character*");
            if (!replaceAll.equals(encodeToString)) {
                AFLogger.init("Payload contains non-printing characters");
                encodeToString = replaceAll;
            }
            aj.valueOf("data: ".concat(String.valueOf(encodeToString)));
        }
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("server_request", i2.onInstallConversionDataLoadedNative, encodeToString);
        ah.AFInAppEventParameterName(i2);
    }

    public static void values(ScheduledExecutorService scheduledExecutorService, Runnable runnable2, long l3, TimeUnit timeUnit4) {
        boolean terminated;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
            if (!scheduledExecutorService.isShutdown()) {
                try {
                    if (!scheduledExecutorService.isTerminated()) {
                    }
                    scheduledExecutorService.schedule(runnable2, l3, timeUnit4);
                    AFLogger.init("scheduler is null, shut downed or terminated");
                    runnable2 = "scheduleJob failed with Exception";
                    AFLogger.AFKeystoreWrapper(runnable2, scheduledExecutorService);
                    runnable2 = "scheduleJob failed with RejectedExecutionException Exception";
                    AFLogger.AFKeystoreWrapper(runnable2, scheduledExecutorService);
                }
            }
        }
    }

    private boolean values() {
        Map setOaidData;
        setOaidData = this.setOaidData;
        if (setOaidData != null && !setOaidData.isEmpty()) {
            if (!setOaidData.isEmpty()) {
                return 1;
            }
        }
        return 0;
    }

    private boolean values(Context context) {
        Method method;
        Object obj13;
        String str = "com.appsflyer.lvl.AppsFlyerLVL";
        final int i = 0;
        Class.forName(str);
        long currentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.enableLocationCollection = concurrentHashMap;
        ah.5 anon = new ah.5(this, currentTimeMillis, obj3);
        final int i2 = 1;
        Class forName2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
        int i4 = 3;
        Class[] arr2 = new Class[i4];
        arr2[i] = Long.TYPE;
        arr2[i2] = Context.class;
        int i5 = 2;
        arr2[i5] = forName2;
        w.1 anon2 = new w.1(anon);
        final Class[] arr3 = new Class[i2];
        arr3[i] = forName2;
        Object[] arr = new Object[i4];
        arr[i] = Long.valueOf(currentTimeMillis);
        arr[i2] = context;
        arr[i5] = Proxy.newProxyInstance(forName2.getClassLoader(), arr3, anon2);
        Class.forName(str).getMethod("checkLicense", arr2).invoke(0, arr);
        return i2;
    }

    private static boolean values(File file) {
        boolean obj0;
        if (file != null && file.exists() == null) {
            if (file.exists() == null) {
            }
            return 0;
        }
        return 1;
    }

    private static boolean values(String string, boolean z2) {
        return AppsFlyerProperties.getInstance().getBoolean(string, z2);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String AFInAppEventParameterName(Context context) {
        String string;
        Context obj3;
        if (AppsFlyerProperties.getInstance().getString("channel") == null) {
            string = AFInAppEventParameterName(context, "CHANNEL");
        }
        if (string != null && string.equals("")) {
            if (string.equals("")) {
                return null;
            }
        }
        return string;
    }

    final Map<String, Object> AFInAppEventType() {
        Map enableLocationCollection;
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        final String str3 = "lvl";
        if (getLevel()) {
            hashMap.put(str3, this.enableLocationCollection);
        } else {
            if (this.setAndroidIdData != null) {
                HashMap hashMap2 = new HashMap();
                this.enableLocationCollection = hashMap2;
                hashMap2.put("error", "operation timed out.");
                hashMap.put(str3, this.enableLocationCollection);
            }
        }
        return hashMap;
    }

    final Map<String, Object> AFInAppEventType(com.appsflyer.internal.i i) {
        Throwable th3;
        String lowerCase3;
        boolean str6;
        File values3;
        String instance3;
        String str25;
        String lowerCase2;
        String str10;
        boolean stop;
        boolean contains2;
        com.appsflyer.internal.m onDeepLinkingNative;
        String onValidateInApp;
        String localizedMessage;
        Object str9;
        String str19;
        int i7;
        String string13;
        String valueOf5;
        int statFs;
        String string9;
        String string11;
        Object string;
        int cmp2;
        Object aFKeystoreWrapper2;
        String string6;
        boolean exists;
        boolean contains4;
        String str24;
        boolean fALSE;
        String string2;
        Object valueOf11;
        Object i3;
        String str28;
        int blockSizeLong;
        int i8;
        Throwable stringBuilder;
        Object valueOf6;
        com.appsflyer.internal.aw long;
        long currentTimeMillis;
        String installerPackageName;
        String valueOf3;
        String str16;
        boolean values;
        String packageName2;
        String lowerCase;
        Object length;
        String devKey;
        String string12;
        String string7;
        boolean attributionId;
        String aFVersionDeclaration;
        boolean boolean2;
        Object values4;
        String str12;
        String str4;
        String str18;
        String str11;
        Object concurrentHashMap2;
        Object valueOf2;
        Object valueOf10;
        boolean appsFlyerInAppPurchaseValidatorListener;
        boolean concurrentHashMap;
        long l;
        int i6;
        int str13;
        boolean empty2;
        boolean valueOf7;
        String string5;
        Object instance4;
        String packageName;
        String contains5;
        SharedPreferences.Editor edit;
        Object applicationContext2;
        Object instance5;
        Object instance2;
        Object instance6;
        Object instance;
        long lastUpdateTime;
        Object hashMap3;
        Object hashMap;
        Object valueOf4;
        boolean values2;
        Object string10;
        int length2;
        Throwable th5;
        Object invoke;
        String str;
        int hashMap4;
        String str14;
        com.appsflyer.internal.aw awVar;
        long l2;
        Object aFInAppEventParameterName;
        String str21;
        Object valueOf8;
        AppsFlyerProperties applicationContext;
        String valueOf9;
        String displayLanguage;
        String language;
        String country;
        String str22;
        int i4;
        int string4;
        int hashMap2;
        Object aFKeystoreWrapper4;
        Object aFKeystoreWrapper3;
        boolean empty;
        String message;
        String aFInAppEventType;
        String boolean;
        String aFLogger$LogLevel;
        long aFInAppEventType2;
        long valueOf;
        int aFKeystoreWrapper;
        int string8;
        SharedPreferences aFKeystoreWrapper5;
        String str8;
        int empty3;
        Object currentModeType;
        Object str2;
        String str7;
        Object aFInAppEventParameterName2;
        String format;
        int int;
        Object simpleDateFormat;
        boolean otherSdkStringDisabled;
        String message2;
        Object aFLogger$LogLevel2;
        long time;
        boolean contains;
        boolean contains3;
        String str3;
        String string3;
        long firstInstallTime;
        int str5;
        int i5;
        com.appsflyer.internal.aw appsFlyer2dXConversionCallback;
        Object appsFlyer2dXConversionCallback2;
        Throwable th;
        String str17;
        String str26;
        String str15;
        Throwable th2;
        AppsFlyerProperties appsFlyerProperties;
        String cmp;
        String str23;
        String str27;
        boolean booleanValue;
        String str20;
        boolean z;
        int i2;
        Throwable th4;
        com.appsflyer.internal.aw awVar2;
        long long2;
        final Object obj = this;
        Object obj2 = i;
        String str30 = "sdkExtension";
        String str54 = "AppsFlyerTimePassedSincePrevLaunch";
        String str117 = "gcd";
        str7 = "preInstallName";
        final Application aFInAppEventType8 = obj2.AFInAppEventType;
        aFLogger$LogLevel2 = obj2.AFLogger$LogLevel;
        String aFVersionDeclaration3 = obj2.AFVersionDeclaration;
        if (obj2.valueOf == null) {
            valueOf6 = new HashMap();
        }
        JSONObject jSONObject2 = new JSONObject(valueOf6);
        String appsFlyer2dXConversionCallback5 = obj2.AppsFlyer2dXConversionCallback;
        SharedPreferences sharedPreferences3 = ah.AFKeystoreWrapper(aFInAppEventType8);
        valueOf7 = i.valueOf();
        Map values5 = obj2.values;
        ac.valueOf(aFInAppEventType8, values5);
        Boolean aFInAppEventParameterName11 = ac.AFInAppEventParameterName;
        if (aFInAppEventParameterName11 != null && !aFInAppEventParameterName11.booleanValue()) {
            if (!aFInAppEventParameterName11.booleanValue()) {
                int i31 = 1;
                str27 = aFLogger$LogLevel2;
                str23 = str7;
                ah.values(values5).put("ad_ids_disabled", Boolean.valueOf(booleanValue2 ^= 1));
            } else {
                str23 = str7;
                str27 = aFLogger$LogLevel2;
            }
        } else {
        }
        Date date2 = new Date();
        String str139 = aFVersionDeclaration3;
        time = date2.getTime();
        String str111 = "af_timestamp";
        values5.put(str111, Long.toString(time));
        String str66 = a.AFKeystoreWrapper(aFInAppEventType8, time);
        if (str66 != null) {
            values5.put("cksm_v1", str66);
        }
        if (!isStopped()) {
            StringBuilder stringBuilder8 = new StringBuilder("******* sendTrackingWithEvent: ");
            time = valueOf7 ? "Launch" : str139;
            stringBuilder8.append(time);
            AFLogger.AFInAppEventType(stringBuilder8.toString());
        } else {
            AFLogger.AFInAppEventType("Reporting has been stopped");
        }
        ae.AFInAppEventType();
        if (!ae.AFKeystoreWrapper(aFInAppEventType8).exists()) {
            ae.AFKeystoreWrapper(aFInAppEventType8).mkdir();
        }
        List list = Arrays.asList(packageInfo.requestedPermissions);
        if (!list.contains("android.permission.INTERNET")) {
            AFLogger.init("Permission android.permission.INTERNET is missing in the AndroidManifest.xml");
        }
        if (!list.contains("android.permission.ACCESS_NETWORK_STATE")) {
            AFLogger.init("Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml");
        }
        if (!list.contains("android.permission.ACCESS_WIFI_STATE")) {
            AFLogger.init("Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml");
        }
        values5.put("af_events_api", "1");
        values5.put("brand", Build.BRAND);
        values5.put("device", Build.DEVICE);
        values5.put("product", Build.PRODUCT);
        int sDK_INT2 = Build.VERSION.SDK_INT;
        values5.put("sdk", Integer.toString(sDK_INT2));
        values5.put("model", Build.MODEL);
        values5.put("deviceType", Build.TYPE);
        ah.valueOf(aFInAppEventType8, values5);
        AppsFlyerProperties instance10 = AppsFlyerProperties.getInstance();
        if (obj.AppsFlyer2dXConversionCallback == null) {
            appsFlyer2dXConversionCallback = new aw(aFInAppEventType8);
            obj.AppsFlyer2dXConversionCallback = appsFlyer2dXConversionCallback;
        }
        appsFlyer2dXConversionCallback2 = obj.AppsFlyer2dXConversionCallback;
        invoke = "phone";
        final String str158 = str139;
        if (valueOf7) {
            if (ah.AFInAppEventType(aFInAppEventType8) && !instance10.isOtherSdkStringDisabled()) {
                if (!instance10.isOtherSdkStringDisabled()) {
                    values5.put("batteryLevel", String.valueOf(ah.getLevel(aFInAppEventType8)));
                }
                ah.valueOf(aFInAppEventType8);
                if (sDK_INT2 >= 23) {
                    currentModeType = aFInAppEventType8.getSystemService(UiModeManager.class);
                } else {
                    currentModeType = aFInAppEventType8.getSystemService("uimode");
                }
                if (currentModeType != null && currentModeType.getCurrentModeType() == 4) {
                    if (currentModeType.getCurrentModeType() == 4) {
                        values5.put("tv", Boolean.TRUE);
                    }
                }
                if (cb.AFInAppEventParameterName(aFInAppEventType8)) {
                    values5.put("inst_app", Boolean.TRUE);
                }
            }
            long2 = ah.AFKeystoreWrapper(aFInAppEventType8).getLong(str54, 0);
            long currentTimeMillis3 = System.currentTimeMillis();
            obj.AFInAppEventType(aFInAppEventType8, str54, currentTimeMillis3);
            if (Long.compare(long2, i2) > 0) {
                i28 /= long2;
            } else {
                i5 = -1;
            }
            values5.put("timepassedsincelastlaunch", Long.toString(i5));
            string11 = AppsFlyerProperties.getInstance().getString("oneLinkSlug");
            String string36 = AppsFlyerProperties.getInstance().getString("onelinkVersion");
            if (string11 != null) {
                values5.put("onelink_id", string11);
            }
            if (string36 != null) {
                values5.put("onelink_ver", string36);
            }
            string = appsFlyer2dXConversionCallback3.AFKeystoreWrapper.getString(str117, 0);
            JSONObject jSONObject4 = new JSONObject(string);
            string = n.AFInAppEventType(jSONObject4);
            if (string != null && !string.isEmpty()) {
                jSONObject4 = new JSONObject(string);
                string = n.AFInAppEventType(jSONObject4);
                if (!string.isEmpty()) {
                    ah.values(values5).put(str117, string);
                    appsFlyer2dXConversionCallback4.AFKeystoreWrapper.edit().putString(str117, 0).apply();
                }
            }
            String setOutOfStore = obj.setOutOfStore;
            if (setOutOfStore != null) {
                values5.put(invoke, setOutOfStore);
            }
            String str132 = "referrer";
            if (!TextUtils.isEmpty(appsFlyer2dXConversionCallback5)) {
                values5.put(str132, appsFlyer2dXConversionCallback5);
            }
            String string22 = sharedPreferences3.getString("extraReferrers", 0);
            if (string22 != null) {
                values5.put("extraReferrers", string22);
            }
            String referrer = instance10.getReferrer(aFInAppEventType8);
            if (!TextUtils.isEmpty(referrer) && values5.get(str132) == null) {
                if (values5.get(str132) == null) {
                    values5.put(str132, referrer);
                }
            }
            currentTimeMillis = awVar3;
            int i21 = 0;
            string3 = currentTimeMillis.AFKeystoreWrapper.getLong("prev_session_dur", i21);
            if (Long.compare(string3, i21) != 0) {
                values5.put("prev_session_dur", Long.valueOf(string3));
            }
            aFKeystoreWrapper3 = bb.AFKeystoreWrapper;
            if (aFKeystoreWrapper3 == null) {
                aFInAppEventType = -1;
            } else {
                aFInAppEventType = ah.AFKeystoreWrapper(aFKeystoreWrapper3).getLong("exception_number", 0);
            }
            values5.put("exception_number", Long.valueOf(aFInAppEventType));
            com.appsflyer.internal.ba setCustomerIdAndLogSession = obj.setCustomerIdAndLogSession;
            if (setCustomerIdAndLogSession != null && !setCustomerIdAndLogSession.AFInAppEventType.isEmpty()) {
                if (!setCustomerIdAndLogSession.AFInAppEventType.isEmpty()) {
                    values5.put("partner_data", setCustomerIdAndLogSession.AFInAppEventType);
                }
                if (!setCustomerIdAndLogSession.AFInAppEventParameterName.isEmpty()) {
                    ah.values(values5).put("partner_data", setCustomerIdAndLogSession.AFInAppEventParameterName);
                    valueOf8 = new HashMap();
                    setCustomerIdAndLogSession.AFInAppEventParameterName = valueOf8;
                }
            }
            awVar2 = currentTimeMillis;
            z = valueOf7;
            str19 = str158;
        } else {
            long = appsFlyer2dXConversionCallback2;
            str9 = ah.AFKeystoreWrapper(aFInAppEventType8);
            valueOf8 = str9.edit();
            aFInAppEventType = str157;
            string3 = str9.getString(aFInAppEventType, 0);
            aFInAppEventParameterName2 = "prev_event_timestamp";
            if (string3 != null) {
                appsFlyer2dXConversionCallback2 = new JSONObject();
                awVar2 = long;
                z = valueOf7;
                appsFlyer2dXConversionCallback2.put(aFInAppEventParameterName2, str9.getLong(aFInAppEventParameterName2, -1));
                appsFlyer2dXConversionCallback2.put(aFInAppEventType, string3);
                values5.put("prev_event", appsFlyer2dXConversionCallback2);
            } else {
                awVar2 = long;
                z = valueOf7;
            }
            valueOf8.putString(aFInAppEventType, str158);
            valueOf8.putLong(aFInAppEventParameterName2, System.currentTimeMillis());
            valueOf8.apply();
        }
        String string26 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
        string5 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerRICounter");
        if (string26 != null && string5 != null && Integer.valueOf(string5).intValue() > 0) {
            if (string5 != null) {
                if (Integer.valueOf(string5).intValue() > 0) {
                    values5.put("reinstallCounter", string5);
                    values5.put("originalAppsflyerId", string26);
                }
            }
        }
        String string27 = AppsFlyerProperties.getInstance().getString("additionalCustomData");
        if (string27 != null) {
            values5.put("customData", string27);
        }
        installerPackageName = aFInAppEventType8.getPackageManager().getInstallerPackageName(aFInAppEventType8.getPackageName());
        if (installerPackageName != null) {
            values5.put("installer_package", installerPackageName);
        }
        String string28 = instance10.getString(str30);
        if (string28 != null && string28.length() > 0) {
            if (string28.length() > 0) {
                values5.put(str30, string28);
            }
        }
        String str31 = obj.AFInAppEventParameterName(aFInAppEventType8);
        valueOf3 = obj.valueOf(aFInAppEventType8, str31);
        if (valueOf3 != null) {
            if (valueOf3.equals(str31)) {
                if (valueOf3 == null && str31 != null) {
                    if (str31 != null) {
                        values5.put("af_latestchannel", str31);
                    }
                }
            } else {
            }
        } else {
        }
        SharedPreferences sharedPreferences = ah.AFKeystoreWrapper(aFInAppEventType8);
        str16 = str155;
        if (sharedPreferences.contains(str16)) {
            lowerCase3 = sharedPreferences.getString(str16, 0);
        } else {
            if (ah.AFInAppEventType(aFInAppEventType8)) {
                if (AppsFlyerProperties.getInstance().getString("api_store_value") != null) {
                } else {
                    if (aFInAppEventType8 != null) {
                        onInstallConversionFailureNative7.AFKeystoreWrapper = aFInAppEventType8.getApplicationContext();
                        lowerCase3 = obj.onInstallConversionFailureNative.AFInAppEventType().AFKeystoreWrapper("AF_STORE");
                    } else {
                        lowerCase3 = 0;
                    }
                }
            } else {
            }
            edit = ah.AFKeystoreWrapper(aFInAppEventType8).edit();
            edit.putString(str16, lowerCase3);
            edit.apply();
        }
        if (lowerCase3 != null) {
            values5.put("af_installstore", lowerCase3.toLowerCase());
        }
        instance3 = ah.AFKeystoreWrapper(aFInAppEventType8);
        applicationContext2 = str23;
        if (AppsFlyerProperties.getInstance().getString(applicationContext2) == null) {
            if (instance3.contains(applicationContext2)) {
                lowerCase = instance3;
            } else {
                if (ah.AFInAppEventType(aFInAppEventType8) && ah.values(ah.values(ah.AFInAppEventParameterName("ro.appsflyer.preinstall.path")))) {
                    if (ah.values(ah.values(ah.AFInAppEventParameterName("ro.appsflyer.preinstall.path")))) {
                        if (aFInAppEventType8 == null) {
                            str25 = 0;
                        } else {
                            onInstallConversionFailureNative3.AFKeystoreWrapper = aFInAppEventType8.getApplicationContext();
                            str25 = obj.onInstallConversionFailureNative.AFInAppEventType().AFKeystoreWrapper("AF_PRE_INSTALL_PATH");
                        }
                        values3 = ah.values(str25);
                    }
                    if (ah.values(values3)) {
                        values3 = ah.values("/data/local/tmp/pre_install.appsflyer");
                    }
                    if (ah.values(values3)) {
                        values3 = ah.values("/etc/pre_install.appsflyer");
                    }
                    if (ah.values(values3)) {
                        instance3 = 0;
                    } else {
                        instance3 = ah.AFKeystoreWrapper(values3, aFInAppEventType8.getPackageName());
                    }
                    if (instance3 != null) {
                    } else {
                        if (aFInAppEventType8 == null) {
                            instance3 = 0;
                        } else {
                            onInstallConversionFailureNative.AFKeystoreWrapper = aFInAppEventType8.getApplicationContext();
                            instance3 = obj.onInstallConversionFailureNative.AFInAppEventType().AFKeystoreWrapper("AF_PRE_INSTALL_NAME");
                        }
                    }
                    lowerCase = instance3;
                }
                if (lowerCase != null) {
                    instance3 = ah.AFKeystoreWrapper(aFInAppEventType8).edit();
                    instance3.putString(applicationContext2, lowerCase);
                    instance3.apply();
                }
            }
            if (lowerCase != null) {
                AppsFlyerProperties.getInstance().set(applicationContext2, lowerCase);
            }
        }
        if (lowerCase != null) {
            values5.put("af_preinstall_name", lowerCase.toLowerCase());
        }
        if (AppsFlyerProperties.getInstance().getString("api_store_value") != null) {
        } else {
            if (aFInAppEventType8 == null) {
                lowerCase2 = 0;
            } else {
                onInstallConversionFailureNative5.AFKeystoreWrapper = aFInAppEventType8.getApplicationContext();
                lowerCase2 = obj.onInstallConversionFailureNative.AFInAppEventType().AFKeystoreWrapper("AF_STORE");
            }
        }
        if (lowerCase2 != null) {
            values5.put("af_currentstore", lowerCase2.toLowerCase());
        }
        String str38 = "appsflyerKey";
        if (str27 != null && str27.length() > 0) {
            if (str27.length() > 0) {
                values5.put(str38, str27);
                String string29 = AppsFlyerProperties.getInstance().getString("AppUserId");
                if (string29 != null) {
                    try {
                        values5.put("appUserId", string29);
                        string12 = instance10.getString("userEmails");
                        if (string12 != null) {
                        } else {
                        }
                        values5.put("user_emails", string12);
                        string12 = AppsFlyerProperties.getInstance().getString("userEmail");
                        if (string12 != null) {
                        }
                        values5.put("sha1_el", ag.values(string12));
                        if (str19 != null) {
                        }
                        values5.put("eventName", str19);
                        values5.put("eventValue", jSONObject2.toString());
                        String str101 = str153;
                        if (AppsFlyerProperties.getInstance().getString(str101) != null) {
                        }
                        values5.put(str101, AppsFlyerProperties.getInstance().getString(str101));
                        String string30 = AppsFlyerProperties.getInstance().getString("currencyCode");
                        if (string30 != null && string30.length() != 3) {
                        }
                        if (string30.length() != 3) {
                        }
                        StringBuilder stringBuilder10 = new StringBuilder("WARNING: currency code should be 3 characters!!! '");
                        stringBuilder10.append(string30);
                        stringBuilder10.append("' is not a legal value.");
                        AFLogger.init(stringBuilder10.toString());
                        values5.put("currency", string30);
                        String string31 = AppsFlyerProperties.getInstance().getString("IS_UPDATE");
                        if (string31 != null) {
                        }
                        values5.put("isUpdate", string31);
                        values5.put("af_preinstalled", Boolean.toString(obj.isPreInstalledApp(aFInAppEventType8)));
                        int i18 = 0;
                        if (instance10.getBoolean("collectFacebookAttrId", true)) {
                        }
                        aFInAppEventType8.getPackageManager().getApplicationInfo("com.facebook.katana", i18);
                        attributionId = obj.getAttributionId(aFInAppEventType8);
                        stringBuilder = th3;
                        str21 = "Exception while collecting facebook's attribution ID. ";
                        AFLogger.AFKeystoreWrapper(str21, stringBuilder);
                        stringBuilder = null;
                        stringBuilder = "Exception while collecting facebook's attribution ID. ";
                        AFLogger.init(stringBuilder);
                        if (attributionId != null) {
                        }
                        values5.put("fb", attributionId);
                        AppsFlyerProperties instance13 = AppsFlyerProperties.getInstance();
                        values5.put("deviceTrackingDisabled", "true");
                        valueOf9 = ah.AFKeystoreWrapper(aFInAppEventType8);
                        aFInAppEventParameterName2 = valueOf9.getString("imeiCached", 0);
                        Object systemService = aFInAppEventType8.getSystemService(invoke);
                        AFLogger.values("use cached IMEI: ".concat(String.valueOf(aFInAppEventParameterName2)));
                        message = str26;
                        th5 = th3;
                        if (str2 != null) {
                        } else {
                        }
                        message2 = String.valueOf(str2);
                        message = message.concat(message2);
                        AFLogger.values(message);
                        str2 = null;
                        message2 = "WARNING: Can't collect IMEI: other reason: ";
                        message = new StringBuilder(message2);
                        message2 = th5.getMessage();
                        message.append(message2);
                        message = message.toString();
                        AFLogger.AFKeystoreWrapper(message, th5);
                    } catch (Exception e) {
                        hashMap4 = 0;
                        aFVersionDeclaration = hashMap4;
                        valueOf9 = ah.AFKeystoreWrapper(aFInAppEventType8).edit();
                        valueOf9.putString("androidIdCached", aFVersionDeclaration);
                        valueOf9.apply();
                        values5.put("android_id", aFVersionDeclaration);
                        AFLogger.AFInAppEventType("Android ID was not collected.");
                        values4 = ac.values(aFInAppEventType8);
                        hashMap4 = new HashMap();
                        hashMap4.put("isManual", values4.AFInAppEventType);
                        hashMap4.put("val", values4.valueOf);
                        Boolean aFInAppEventParameterName6 = values4.AFInAppEventParameterName;
                        hashMap4.put("isLat", aFInAppEventParameterName6);
                        values5.put("oaid", hashMap4);
                        WeakReference weakReference = new WeakReference(aFInAppEventType8);
                        str12 = al.AFInAppEventType(weakReference);
                        values5.put("uid", str12);
                        values5.put("lang", Locale.getDefault().getDisplayLanguage());
                        values5.put("lang_code", Locale.getDefault().getLanguage());
                        values5.put("country", Locale.getDefault().getCountry());
                        values5.put("platformextension", obj.getSdkVersion.AFInAppEventParameterName());
                        ah.AFKeystoreWrapper(aFInAppEventType8, values5);
                        aFLogger$LogLevel = str150;
                        concurrentHashMap2 = new SimpleDateFormat(aFLogger$LogLevel, Locale.US);
                        concurrentHashMap2.setTimeZone(TimeZone.getTimeZone("UTC"));
                        Date date4 = new Date(packageInfo2.firstInstallTime, appsFlyer2dXConversionCallback2);
                        values5.put("installDate", concurrentHashMap2.format(date4));
                        android.content.pm.PackageInfo packageInfo3 = aFInAppEventType8.getPackageManager().getPackageInfo(aFInAppEventType8.getPackageName(), i18);
                        int versionCode = packageInfo3.versionCode;
                        appsFlyer2dXConversionCallback2 = ah.AFKeystoreWrapper(aFInAppEventType8).edit();
                        appsFlyer2dXConversionCallback2.putInt("versionCode", versionCode);
                        appsFlyer2dXConversionCallback2.apply();
                        values5.put("app_version_code", Integer.toString(packageInfo3.versionCode));
                        values5.put("app_version_name", packageInfo3.versionName);
                        str17 = str14;
                        str15 = str38;
                        Locale uS = Locale.US;
                        simpleDateFormat = new SimpleDateFormat(aFLogger$LogLevel, uS);
                        appsFlyerProperties = instance10;
                        Date date3 = new Date(packageInfo3.firstInstallTime, appsFlyer2dXConversionCallback2);
                        values5.put("date1", simpleDateFormat.format(date3));
                        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(aFLogger$LogLevel, uS);
                        Date date = new Date(packageInfo3.lastUpdateTime, str14);
                        values5.put("date2", simpleDateFormat2.format(date));
                        values5.put("firstLaunchDate", obj.AFKeystoreWrapper(concurrentHashMap2, aFInAppEventType8));
                        obj.stop = bv.AFKeystoreWrapper(aFInAppEventType8);
                        StringBuilder stringBuilder2 = new StringBuilder("didConfigureTokenRefreshService=");
                        stringBuilder2.append(obj.stop);
                        AFLogger.values(stringBuilder2.toString());
                        values5.put("tokenRefreshConfigured", Boolean.FALSE);
                        AFLogger.values("Skip 'af' payload as deeplink was found by path");
                        JSONObject jSONObject = new JSONObject(obj.onValidateInApp);
                        jSONObject.put("isPush", "true");
                        values5.put("af_deeplink", jSONObject.toString());
                        obj.onValidateInApp = 0;
                        values5.put("open_referrer", obj2.AFKeystoreWrapper);
                        String str39 = "sensors";
                        concurrentHashMap2 = new ConcurrentHashMap();
                        List list2 = aa.AFInAppEventType(aFInAppEventType8).AFInAppEventParameterName();
                        lastUpdateTime = new j();
                        concurrentHashMap2.put(str39, lastUpdateTime.AFInAppEventParameterName(list2));
                        concurrentHashMap2.put(str39, "na");
                        values5.putAll(concurrentHashMap2);
                        ac.valueOf(aFInAppEventType8, values5);
                        i6 = 1;
                        i6 = 0;
                        values5.put("GAID_retry", String.valueOf(i6));
                        valueOf11 = ac.AFInAppEventType(aFInAppEventType8.getContentResolver());
                        values5.put("amazon_aid", valueOf11.valueOf);
                        values5.put("amazon_aid_limit", String.valueOf(valueOf11.AFInAppEventParameterName));
                        values5.put("registeredUninstall", Boolean.valueOf(bv.AFInAppEventType(sharedPreferences3)));
                        concurrentHashMap = z;
                        i3 = ah.AFInAppEventType(sharedPreferences3, "appsFlyerCount", concurrentHashMap);
                        values5.put("counter", Integer.toString(i3));
                        i7 = 1;
                        i7 = 0;
                        values5.put("iaecounter", Integer.toString(ah.AFInAppEventType(sharedPreferences3, "appsFlyerInAppEventCount", i7)));
                        Map values8 = ah.values(values5);
                        valueOf4 = obj.onInstallConversionFailureNative.valueOf();
                        aFInAppEventParameterName = valueOf4.AFInAppEventParameterName;
                        valueOf4.AFInAppEventParameterName = 0;
                        hashMap2 = new HashMap();
                        hashMap2.put("cdn_token", aFInAppEventParameterName.valueOf);
                        String aFInAppEventParameterName10 = aFInAppEventParameterName.AFInAppEventParameterName;
                        hashMap2.put("c_ver", aFInAppEventParameterName10);
                        aFInAppEventType2 = aFInAppEventParameterName.AFInAppEventType;
                        hashMap2.put("latency", Long.valueOf(aFInAppEventType2));
                        valueOf = aFInAppEventParameterName.values;
                        hashMap2.put("delay", Long.valueOf(valueOf));
                        aFKeystoreWrapper = aFInAppEventParameterName.AFKeystoreWrapper;
                        hashMap2.put("res_code", Integer.valueOf(aFKeystoreWrapper));
                        simpleDateFormat = new StringBuilder();
                        simpleDateFormat.append(aFInAppEventParameterName.AFLogger$LogLevel.getClass().getSimpleName());
                        simpleDateFormat.append(": ");
                        simpleDateFormat.append(aFInAppEventParameterName.AFLogger$LogLevel.getMessage());
                        hashMap2.put("error", simpleDateFormat.toString());
                        values8.put("rc", hashMap2);
                        int i20 = 1;
                        awVar = awVar2;
                        i4 = 1;
                        hashMap3 = new HashMap(awVar.AFInAppEventType);
                        values8.put("first_launch", hashMap3);
                        i4 = i20;
                        awVar = awVar2;
                        appsFlyerProperties2.AFInAppEventParameterName = i4;
                        values5.put("wait_cid", Boolean.toString(i4));
                        string10 = awVar.AFKeystoreWrapper.getString("ddl", 0);
                        JSONObject jSONObject3 = new JSONObject(string10);
                        string10 = n.AFInAppEventType(jSONObject3);
                        values8.put("ddl", string10);
                        hashMap3 = new HashMap(awVar.AFInAppEventType);
                        values8.put("first_launch", hashMap3);
                        values5.remove("meta");
                        awVar = awVar2;
                        i4 = 1;
                        i4 = 0;
                        values5.put("isFirstCall", Boolean.toString(i4));
                        HashMap hashMap6 = new HashMap();
                        hashMap6.put("cpu_abi", ah.AFInAppEventParameterName("ro.product.cpu.abi"));
                        hashMap6.put("cpu_abi2", ah.AFInAppEventParameterName("ro.product.cpu.abi2"));
                        hashMap6.put("arch", ah.AFInAppEventParameterName("os.arch"));
                        hashMap6.put("build_display_id", ah.AFInAppEventParameterName("ro.build.display.id"));
                        valueOf10 = u.d.AFInAppEventParameterName.AFKeystoreWrapper(aFInAppEventType8);
                        hashMap = new HashMap(3);
                        hashMap.put("lat", String.valueOf(valueOf10.getLatitude()));
                        hashMap.put("lon", String.valueOf(valueOf10.getLongitude()));
                        hashMap.put("ts", String.valueOf(valueOf10.getTime()));
                        hashMap6.put("loc", hashMap);
                        com.appsflyer.internal.b.b valueOf18 = b.d.valueOf.valueOf(aFInAppEventType8);
                        hashMap6.put("btl", Float.toString(valueOf18.AFInAppEventParameterName));
                        String aFInAppEventType3 = valueOf18.AFInAppEventType;
                        hashMap6.put("btch", aFInAppEventType3);
                        i3 = aa.AFInAppEventType(aFInAppEventType8);
                        concurrentHashMap = new ConcurrentHashMap();
                        hashMap = i3.AFInAppEventType();
                        concurrentHashMap.put(str39, hashMap);
                        i3 = i3.AFInAppEventParameterName();
                        concurrentHashMap.put(str39, i3);
                        hashMap6.putAll(concurrentHashMap);
                        hashMap6.put("dim", x.AFKeystoreWrapper(aFInAppEventType8));
                        values5.put("deviceData", hashMap6);
                        String str41 = str15;
                        str28 = str156;
                        Object obj11 = values5.get(str28);
                        String str107 = str17;
                        StringBuilder stringBuilder11 = new StringBuilder();
                        int i25 = 7;
                        int i24 = 0;
                        stringBuilder11.append((String)values5.get(str41).substring(i24, i25));
                        stringBuilder11.append((String)values5.get(str107).substring(i24, i25));
                        stringBuilder11.append(obj11.substring(length3 -= i25));
                        values5.put("af_v", ag.values(stringBuilder11.toString()));
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append((String)values5.get(str41));
                        stringBuilder3.append(values5.get(str28));
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(stringBuilder3.toString());
                        stringBuilder4.append(values5.get(str107));
                        StringBuilder stringBuilder5 = new StringBuilder();
                        stringBuilder5.append(stringBuilder4.toString());
                        stringBuilder5.append(values5.get("installDate"));
                        StringBuilder stringBuilder6 = new StringBuilder();
                        stringBuilder6.append(stringBuilder5.toString());
                        stringBuilder6.append(values5.get("counter"));
                        StringBuilder stringBuilder7 = new StringBuilder();
                        stringBuilder7.append(stringBuilder6.toString());
                        stringBuilder7.append(values5.get("iaecounter"));
                        values5.put("af_v2", ag.values(ag.AFInAppEventParameterName(stringBuilder7.toString())));
                        values5.put("ivc", Boolean.valueOf(ah.AFLogger$LogLevel(aFInAppEventType8)));
                        values5.put("istu", String.valueOf(sharedPreferences3.getBoolean("is_stop_tracking_used", false)));
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("mcc", Integer.valueOf(configuration.mcc));
                        hashMap5.put("mnc", Integer.valueOf(configuration2.mnc));
                        values5.put("cell", hashMap5);
                        String packageName3 = awVar.AFInAppEventParameterName.getPackageName();
                        values5.put("sig", ab.AFInAppEventParameterName(awVar.AFInAppEventParameterName.getPackageManager(), packageName3));
                        values5.put("last_boot_time", Long.valueOf(currentTimeMillis2 -= elapsedRealtime));
                        statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
                        blockSizeLong = statFs.getBlockSizeLong();
                        availableBlocksLong *= blockSizeLong;
                        blockCountLong *= blockSizeLong;
                        blockSizeLong = statFs.getBlockSize();
                        l = (long)i8;
                        l2 = (long)statFs;
                        double d = Math.pow(4611686018427387904L, blockSizeLong);
                        StringBuilder stringBuilder9 = new StringBuilder();
                        stringBuilder9.append((long)i14);
                        stringBuilder9.append("/");
                        stringBuilder9.append((long)i19);
                        values5.put("disk", stringBuilder9.toString());
                        onDeepLinkingNative = obj.onDeepLinkingNative;
                        onDeepLinkingNative = onDeepLinkingNative.AFInAppEventType;
                        values5.put("sharing_filter", onDeepLinkingNative);
                        return values5;
                    } catch (Throwable th1) {
                    }
                    aFInAppEventParameterName2 = obj.init != null ? invoke : 0;
                    if (aFInAppEventParameterName2 != null) {
                        boolean = ah.AFKeystoreWrapper(aFInAppEventType8).edit();
                        boolean.putString("imeiCached", aFInAppEventParameterName2);
                        boolean.apply();
                        values5.put("imei", aFInAppEventParameterName2);
                    } else {
                        AFLogger.AFInAppEventType("IMEI was not collected.");
                    }
                    hashMap4 = valueOf9.getString("androidIdCached", 0);
                    if (instance13.getBoolean("collectAndroidId", i18) && TextUtils.isEmpty(obj.AFVersionDeclaration)) {
                        if (TextUtils.isEmpty(obj.AFVersionDeclaration)) {
                            if (ah.AppsFlyer2dXConversionCallback(aFInAppEventType8)) {
                                if (Settings.Secure.getString(aFInAppEventType8.getContentResolver(), "android_id") != null) {
                                } else {
                                    if (hashMap4 != null) {
                                        AFLogger.values("use cached AndroidId: ".concat(String.valueOf(hashMap4)));
                                    } else {
                                    }
                                }
                            } else {
                                aFVersionDeclaration = 0;
                            }
                        } else {
                            if (obj.AFVersionDeclaration != null) {
                                try {
                                    aFVersionDeclaration = 0;
                                    if (aFVersionDeclaration != 0) {
                                    } else {
                                    }
                                    valueOf9 = ah.AFKeystoreWrapper(aFInAppEventType8).edit();
                                    valueOf9.putString("androidIdCached", aFVersionDeclaration);
                                    valueOf9.apply();
                                    values5.put("android_id", aFVersionDeclaration);
                                    AFLogger.AFInAppEventType("Android ID was not collected.");
                                    values4 = ac.values(aFInAppEventType8);
                                    hashMap4 = new HashMap();
                                    hashMap4.put("isManual", values4.AFInAppEventType);
                                    hashMap4.put("val", values4.valueOf);
                                    aFInAppEventParameterName6 = values4.AFInAppEventParameterName;
                                    if (values4 != null && aFInAppEventParameterName6 != null) {
                                    }
                                    hashMap4 = new HashMap();
                                    hashMap4.put("isManual", values4.AFInAppEventType);
                                    hashMap4.put("val", values4.valueOf);
                                    aFInAppEventParameterName6 = values4.AFInAppEventParameterName;
                                    if (aFInAppEventParameterName6 != null) {
                                    }
                                    hashMap4.put("isLat", aFInAppEventParameterName6);
                                    values5.put("oaid", hashMap4);
                                    weakReference = new WeakReference(aFInAppEventType8);
                                    str12 = al.AFInAppEventType(weakReference);
                                    if (str12 != null) {
                                    }
                                    values5.put(str151, str12);
                                    th5 = th;
                                    stringBuilder = th3;
                                    message = "ERROR: could not get uid ";
                                    str21 = new StringBuilder(message);
                                    message = stringBuilder.getMessage();
                                    str21.append(message);
                                    str21 = str21.toString();
                                    AFLogger.AFKeystoreWrapper(str21, stringBuilder);
                                    values5.put("lang", Locale.getDefault().getDisplayLanguage());
                                    stringBuilder = th3;
                                    str21 = "Exception while collecting display language name. ";
                                    AFLogger.AFKeystoreWrapper(str21, stringBuilder);
                                    values5.put("lang_code", Locale.getDefault().getLanguage());
                                    stringBuilder = th3;
                                    str21 = "Exception while collecting display language code. ";
                                    AFLogger.AFKeystoreWrapper(str21, stringBuilder);
                                    values5.put("country", Locale.getDefault().getCountry());
                                    stringBuilder = th3;
                                    str21 = "Exception while collecting country name. ";
                                    AFLogger.AFKeystoreWrapper(str21, stringBuilder);
                                    values5.put("platformextension", obj.getSdkVersion.AFInAppEventParameterName());
                                    ah.AFKeystoreWrapper(aFInAppEventType8, values5);
                                    aFLogger$LogLevel = str150;
                                    concurrentHashMap2 = new SimpleDateFormat(aFLogger$LogLevel, Locale.US);
                                    concurrentHashMap2.setTimeZone(TimeZone.getTimeZone("UTC"));
                                    date4 = new Date(packageInfo2.firstInstallTime, appsFlyer2dXConversionCallback2);
                                    values5.put("installDate", concurrentHashMap2.format(date4));
                                    str21 = th3;
                                    str2 = "Exception while collecting install date. ";
                                    AFLogger.AFKeystoreWrapper(str2, str21);
                                    packageInfo3 = aFInAppEventType8.getPackageManager().getPackageInfo(aFInAppEventType8.getPackageName(), i18);
                                    versionCode = packageInfo3.versionCode;
                                    if (versionCode > sharedPreferences3.getInt("versionCode", i18)) {
                                    }
                                    appsFlyer2dXConversionCallback2 = ah.AFKeystoreWrapper(aFInAppEventType8).edit();
                                    appsFlyer2dXConversionCallback2.putInt("versionCode", versionCode);
                                    appsFlyer2dXConversionCallback2.apply();
                                    values5.put("app_version_code", Integer.toString(packageInfo3.versionCode));
                                    values5.put("app_version_name", packageInfo3.versionName);
                                    str17 = str14;
                                    str15 = str38;
                                    uS = Locale.US;
                                    simpleDateFormat = new SimpleDateFormat(aFLogger$LogLevel, uS);
                                    appsFlyerProperties = instance10;
                                    date3 = new Date(packageInfo3.firstInstallTime, appsFlyer2dXConversionCallback2);
                                    values5.put("date1", simpleDateFormat.format(date3));
                                    simpleDateFormat2 = new SimpleDateFormat(aFLogger$LogLevel, uS);
                                    date = new Date(packageInfo3.lastUpdateTime, str14);
                                    values5.put("date2", simpleDateFormat2.format(date));
                                    values5.put("firstLaunchDate", obj.AFKeystoreWrapper(concurrentHashMap2, aFInAppEventType8));
                                    str26 = str29;
                                    th2 = string23;
                                    str26 = str29;
                                    th2 = string23;
                                    String str29 = th3;
                                    Throwable string23 = "Exception while collecting app version data ";
                                    AFLogger.AFKeystoreWrapper(string23, str29);
                                    obj.stop = bv.AFKeystoreWrapper(aFInAppEventType8);
                                    stringBuilder2 = new StringBuilder("didConfigureTokenRefreshService=");
                                    stringBuilder2.append(obj.stop);
                                    AFLogger.values(stringBuilder2.toString());
                                    if (!obj.stop) {
                                    }
                                    values5.put("tokenRefreshConfigured", Boolean.FALSE);
                                    if (z && obj.onValidateInApp != null) {
                                    }
                                    if (obj.onValidateInApp != null) {
                                    }
                                    if (values5.get("af_deeplink") != null) {
                                    } else {
                                    }
                                    AFLogger.values("Skip 'af' payload as deeplink was found by path");
                                    jSONObject = new JSONObject(obj.onValidateInApp);
                                    jSONObject.put("isPush", "true");
                                    values5.put("af_deeplink", jSONObject.toString());
                                    obj.onValidateInApp = 0;
                                    values5.put("open_referrer", str154);
                                    str39 = "sensors";
                                    if (!z) {
                                    }
                                    concurrentHashMap2 = new ConcurrentHashMap();
                                    list2 = aa.AFInAppEventType(aFInAppEventType8).AFInAppEventParameterName();
                                    if (!list2.isEmpty()) {
                                    } else {
                                    }
                                    lastUpdateTime = new j();
                                    concurrentHashMap2.put(str39, lastUpdateTime.AFInAppEventParameterName(list2));
                                    concurrentHashMap2.put(str39, "na");
                                    values5.putAll(concurrentHashMap2);
                                    string23 = th3;
                                    String str98 = "Unexpected exception from AFSensorManager: ";
                                    stringBuilder = new StringBuilder(str98);
                                    string23 = string23.getMessage();
                                    stringBuilder.append(string23);
                                    string23 = stringBuilder.toString();
                                    AFLogger.AFKeystoreWrapper(string23);
                                    if (AppsFlyerProperties.getInstance().getString("advertiserId") == null) {
                                    }
                                    ac.valueOf(aFInAppEventType8, values5);
                                    if (AppsFlyerProperties.getInstance().getString("advertiserId") != null) {
                                    } else {
                                    }
                                    i6 = 1;
                                    i6 = 0;
                                    values5.put("GAID_retry", String.valueOf(i6));
                                    valueOf11 = ac.AFInAppEventType(aFInAppEventType8.getContentResolver());
                                    if (valueOf11 != null) {
                                    }
                                    values5.put("amazon_aid", valueOf11.valueOf);
                                    values5.put("amazon_aid_limit", String.valueOf(valueOf11.AFInAppEventParameterName));
                                    values5.put("registeredUninstall", Boolean.valueOf(bv.AFInAppEventType(sharedPreferences3)));
                                    concurrentHashMap = z;
                                    i3 = ah.AFInAppEventType(sharedPreferences3, "appsFlyerCount", concurrentHashMap);
                                    values5.put("counter", Integer.toString(i3));
                                    if (str19 != null) {
                                    } else {
                                    }
                                    i7 = 1;
                                    i7 = 0;
                                    values5.put("iaecounter", Integer.toString(ah.AFInAppEventType(sharedPreferences3, "appsFlyerInAppEventCount", i7)));
                                    values8 = ah.values(values5);
                                    valueOf4 = obj.onInstallConversionFailureNative.valueOf();
                                    aFInAppEventParameterName = valueOf4.AFInAppEventParameterName;
                                    valueOf4.AFInAppEventParameterName = 0;
                                    hashMap2 = new HashMap();
                                    hashMap2.put("cdn_token", aFInAppEventParameterName.valueOf);
                                    aFInAppEventParameterName10 = aFInAppEventParameterName.AFInAppEventParameterName;
                                    if (aFInAppEventParameterName10 != null) {
                                    }
                                    hashMap2.put("c_ver", aFInAppEventParameterName10);
                                } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
                                } catch (Exception e1) {
                                } catch (Throwable th2) {
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
                devKey = AppsFlyerProperties.getInstance().getDevKey();
                if (devKey != null && devKey.length() > 0) {
                    if (devKey.length() > 0) {
                        values5.put(str38, devKey);
                    }
                }
            }
        } else {
        }
        AFLogger.AFInAppEventType("AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. ");
        AFLogger.AFInAppEventType("AppsFlyer will not track this event.");
        return 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void AFInAppEventType(Context context, String string2, long l3) {
        SharedPreferences.Editor obj1 = ah.AFKeystoreWrapper(context).edit();
        obj1.putLong(string2, l3);
        obj1.apply();
    }

    protected final void AFInAppEventType(Context context, Map<String, Object> map2, Uri uri3) {
        boolean string;
        Object encodedQuery;
        boolean valueOf;
        String aFLogger$LogLevel;
        Map value2;
        Object key;
        Object value;
        com.appsflyer.internal.k obj8;
        String str = "af_deeplink";
        string = ah.AFKeystoreWrapper(uri3.toString());
        encodedQuery = h.AFKeystoreWrapper();
        aFLogger$LogLevel = encodedQuery.AFLogger$LogLevel;
        if (!map2.containsKey(str) && aFLogger$LogLevel != null && encodedQuery.init != null && string.contains(aFLogger$LogLevel)) {
            string = ah.AFKeystoreWrapper(uri3.toString());
            encodedQuery = h.AFKeystoreWrapper();
            aFLogger$LogLevel = encodedQuery.AFLogger$LogLevel;
            if (aFLogger$LogLevel != null) {
                if (encodedQuery.init != null) {
                    if (string.contains(aFLogger$LogLevel)) {
                        Uri.Builder upon = Uri.parse(string).buildUpon();
                        Uri.Builder upon2 = Uri.EMPTY.buildUpon();
                        Iterator iterator = encodedQuery.init.entrySet().iterator();
                        for (Map.Entry next : iterator) {
                            upon.appendQueryParameter((String)next.getKey(), (String)next.getValue());
                            upon2.appendQueryParameter((String)next.getKey(), (String)next.getValue());
                        }
                        string = upon.build().toString();
                        map2.put("appended_query_params", upon2.build().getEncodedQuery());
                    }
                }
            }
            map2.put(str, string);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("link", uri3.toString());
        as asVar = new as(uri3, this, context);
        if (asVar.valueOf) {
            map2.put("isBrandedDomain", Boolean.TRUE);
        }
        ab.valueOf(context, hashMap, uri3);
        obj8 = new ah.9(hashMap);
        asVar.values = obj8;
        if (asVar.values() && k.AFKeystoreWrapper == null) {
            obj8 = new ah.9(hashMap);
            asVar.values = obj8;
            if (k.AFKeystoreWrapper == null) {
                obj8 = new k();
                k.AFKeystoreWrapper = obj8;
            }
            k.AFKeystoreWrapper.AFKeystoreWrapper().execute(asVar);
        }
        ar.valueOf(hashMap);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void AFKeystoreWrapper(Context context, String string2) {
        JSONObject jSONObject;
        JSONArray jSONArray2;
        JSONArray jSONArray;
        Object obj;
        JSONObject jSONObject2;
        final String str = "extraReferrers";
        final String str3 = "received a new (extra) referrer: ";
        AFLogger.values(str3.concat(String.valueOf(string2)));
        String string4 = ah.AFKeystoreWrapper(context).getString(str, 0);
        if (string4 == null) {
            jSONObject = new JSONObject();
            jSONArray = new JSONArray();
        } else {
            JSONObject jSONObject3 = new JSONObject(string4);
            if (jSONObject3.has(string2)) {
                jSONArray2 = new JSONArray((String)jSONObject3.get(string2));
            } else {
                jSONArray2 = new JSONArray();
            }
            jSONArray = jSONArray2;
            jSONObject = jSONObject2;
        }
        if (Long.compare(l2, i3) < 0) {
            jSONArray.put(System.currentTimeMillis());
        }
        if (Long.compare(l, i2) >= 0) {
            ah.AFKeystoreWrapper(jSONObject);
        }
        jSONObject.put(string2, jSONArray.toString());
        SharedPreferences.Editor obj11 = ah.AFKeystoreWrapper(context).edit();
        obj11.putString(str, jSONObject.toString());
        obj11.apply();
    }

    @Override // com.appsflyer.AppsFlyerLib
    final void AFKeystoreWrapper(com.appsflyer.internal.i i, Activity activity2) {
        Object aFInAppEventType;
        String str;
        Intent intent;
        String obj5;
        obj5 = aq.values(activity2);
        if (activity2 != null && activity2.getIntent() != null && obj5 != null) {
            if (activity2.getIntent() != null) {
                obj5 = aq.values(activity2);
                if (obj5 != null) {
                    obj5 = obj5.toString();
                } else {
                    obj5 = str;
                }
            } else {
            }
        } else {
        }
        AFLogger.init("[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
        final AppsFlyerRequestListener obj4 = i.AFInAppEventParameterName;
        if (AppsFlyerProperties.getInstance().getDevKey() == null && obj4 != null) {
            AFLogger.init("[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
            obj4 = i.AFInAppEventParameterName;
            if (obj4 != null) {
                obj4.onError(RequestError.NO_DEV_KEY, bc.valueOf);
            }
        }
        String referrer = AppsFlyerProperties.getInstance().getReferrer(i.AFInAppEventType);
        if (referrer == null) {
        } else {
            str = referrer;
        }
        i.AppsFlyer2dXConversionCallback = str;
        i.AFKeystoreWrapper = obj5;
        AFKeystoreWrapper(i);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void addPushNotificationDeepLinkPath(String... stringArr) {
        final List obj3 = Arrays.asList(stringArr);
        List getLevel = hVar.getLevel;
        if (!getLevel.contains(obj3)) {
            getLevel.add(obj3);
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void anonymizeUser(boolean z) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "anonymizeUser", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("deviceTrackingDisabled", z);
    }

    public final void appendParametersToDeepLinkingURL(String string, Map<String, String> map2) {
        final com.appsflyer.internal.h hVar = h.AFKeystoreWrapper();
        hVar.AFLogger$LogLevel = string;
        hVar.init = map2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void enableFacebookDeferredApplinks(boolean z) {
        this.setImeiData = z;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final AppsFlyerLib enableLocationCollection(boolean z) {
        this.AppsFlyerInAppPurchaseValidatorListener = z;
        return this;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getAppsFlyerUID(Context context) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        an.values.AFInAppEventType("public_api_call", "getAppsFlyerUID", new String[0]);
        if (context == null) {
            return null;
        }
        n nVar = new n(context);
        WeakReference obj5 = new WeakReference(nVar.AFKeystoreWrapper);
        return al.AFInAppEventType(obj5);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getAttributionId(Context context) {
        try {
            af afVar = new af(context);
            return afVar.AFInAppEventParameterName();
            AFLogger.AFKeystoreWrapper("Could not collect facebook attribution id. ", context);
            context = null;
            return context;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getHostName() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host");
        if (string != null) {
            return string;
        }
        return "appsflyer.com";
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getHostPrefix() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host_prefix");
        if (string != null) {
            return string;
        }
        return "";
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getOutOfStore(Context context) {
        String str;
        int obj3;
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        int i = 0;
        if (context == null) {
            obj3 = i;
        } else {
            onInstallConversionFailureNative.AFKeystoreWrapper = context.getApplicationContext();
            obj3 = this.onInstallConversionFailureNative.AFInAppEventType().AFKeystoreWrapper("AF_STORE");
        }
        if (obj3 != null) {
            return obj3;
        }
        AFLogger.AFInAppEventType("No out-of-store value set");
        return i;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getSdkVersion() {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        an.values.AFInAppEventType("public_api_call", "getSdkVersion", new String[0]);
        StringBuilder stringBuilder = new StringBuilder("version: 6.5.0 (build ");
        stringBuilder.append(ah.AFKeystoreWrapper);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final AppsFlyerLib init(String string, AppsFlyerConversionListener appsFlyerConversionListener2, Context context3) {
        com.appsflyer.internal.aw appsFlyer2dXConversionCallback;
        Object appsFlyer2dXConversionCallback2;
        int aFInAppEventParameterName;
        boolean currentTimeMillis;
        int i;
        String str;
        com.appsflyer.internal.cq[] arr;
        String str2;
        Application setCustomerUserId;
        String obj9;
        Object obj11;
        if (this.setDebugLog) {
            return this;
        }
        int i2 = 1;
        this.setDebugLog = i2;
        AppsFlyerProperties.getInstance().setDevKey(string);
        aj.AFInAppEventParameterName(string);
        int i3 = 2;
        final int i4 = 0;
        if (context3 != null) {
            if (this.AppsFlyer2dXConversionCallback == null) {
                appsFlyer2dXConversionCallback = new aw(context3);
                this.AppsFlyer2dXConversionCallback = appsFlyer2dXConversionCallback;
            }
            appsFlyer2dXConversionCallback2 = this.AppsFlyer2dXConversionCallback;
            if (appsFlyer2dXConversionCallback2.values()) {
                appsFlyer2dXConversionCallback2.AFKeystoreWrapper.edit().putLong("init_ts", System.currentTimeMillis()).apply();
            }
            this.setCustomerUserId = (Application)context3.getApplicationContext();
            onInstallConversionFailureNative.AFKeystoreWrapper = context3.getApplicationContext();
            com.appsflyer.internal.bs valueOf = this.onInstallConversionFailureNative.valueOf();
            bs.4 anon3 = new bs.4(valueOf, 0);
            valueOf.values.execute(anon3);
            ah.4 anon = new ah.4(this);
            cn cnVar = new cn(anon);
            ah.2 anon2 = new ah.2(this, cnVar);
            arr = new cq[3];
            arr[i4] = cnVar;
            cp cpVar = new cp(anon2);
            arr[i2] = cpVar;
            cm cmVar = new cm(anon2);
            arr[i3] = cmVar;
            this.AFLogger$LogLevel = arr;
            i = i4;
            while (i < arr.length) {
                arr[i].values(this.setCustomerUserId);
                i++;
            }
            this.setAndroidIdData = values(context3);
            bb.AFKeystoreWrapper = this.setCustomerUserId;
            if (ah.AFInAppEventType(ah.AFKeystoreWrapper(context3), "appsFlyerCount", i4) == 0 && Build.VERSION.SDK_INT >= 29) {
                if (Build.VERSION.SDK_INT >= 29) {
                    cs csVar = new cs(context3);
                    this.waitForCustomerUserId = csVar;
                    obj11 = new Thread(csVar.AFInAppEventParameterName);
                    obj11.start();
                }
            }
        } else {
            AFLogger.init("context is null, Google Install Referrer will be not initialized");
        }
        if (an.values == null) {
            obj11 = new an();
            an.values = obj11;
        }
        String[] strArr = new String[i3];
        strArr[i4] = string;
        obj9 = appsFlyerConversionListener2 == null ? "null" : "conversionDataListener";
        strArr[i2] = obj9;
        an.values.AFInAppEventType("public_api_call", "init", strArr);
        obj9 = new Object[i3];
        obj9[i4] = "6.5.0";
        obj9[i2] = ah.AFKeystoreWrapper;
        AFLogger.valueOf(String.format("Initializing AppsFlyer SDK: (v%s.%s)", obj9));
        ah.AFInAppEventType = appsFlyerConversionListener2;
        return this;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final boolean isPreInstalledApp(Context context) {
        int i;
        int obj3;
        final int i2 = 0;
        i = 1;
        if (obj3 &= i != 0) {
            try {
                return i;
                AFLogger.AFKeystoreWrapper("Could not check if app is pre installed", context);
                return i2;
            }
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final boolean isStopped() {
        return this.updateServerUninstallToken;
    }

    public final void logEvent(Context context, String string2, Map<String, Object> map3) {
        logEvent(context, string2, map3, 0);
    }

    public final void logEvent(Context context, String string2, Map<String, Object> map3, AppsFlyerRequestListener appsFlyerRequestListener4) {
        Context applicationContext;
        int i;
        int hashMap;
        Object valueOf;
        Object obj7;
        com.appsflyer.internal.an obj8;
        cg cgVar = new cg();
        if (context != null) {
            cgVar.AFInAppEventType = (Application)context.getApplicationContext();
        }
        cgVar.AFVersionDeclaration = string2;
        if (map3 == null) {
            hashMap = i;
        } else {
            hashMap = new HashMap(map3);
        }
        cgVar.valueOf = hashMap;
        cgVar.AFInAppEventParameterName = appsFlyerRequestListener4;
        if (an.values == null) {
            obj8 = new an();
            an.values = obj8;
        }
        String[] obj9 = new String[2];
        if (cgVar.valueOf == null) {
            valueOf = new HashMap();
        }
        JSONObject jSONObject = new JSONObject(valueOf);
        an.values.AFInAppEventType("public_api_call", "logEvent", string2, jSONObject.toString());
        if (string2 != null) {
            aa.AFInAppEventType(context).valueOf();
        }
        if (context instanceof Activity != null) {
            i = context;
        }
        AFKeystoreWrapper(cgVar, i);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logLocation(Context context, double d2, double d3) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[2];
        an.values.AFInAppEventType("public_api_call", "logLocation", String.valueOf(d2), String.valueOf(obj8));
        HashMap hashMap = new HashMap();
        hashMap.put("af_long", Double.toString(obj8));
        hashMap.put("af_lat", Double.toString(d2));
        AFInAppEventType(context, "af_location_coordinates", hashMap);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logSession(Context context) {
        com.appsflyer.internal.an anVar;
        com.appsflyer.internal.an anVar2;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        final int i2 = 0;
        an.values.AFInAppEventType("public_api_call", "logSession", new String[i2]);
        if (an.values == null) {
            anVar2 = new an();
            an.values = anVar2;
        }
        values2.AFInAppEventParameterName = i2;
        int i = 0;
        AFInAppEventType(context, i, i);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void onPause(Context context) {
        final com.appsflyer.internal.ai.c aFKeystoreWrapper = ai.AFKeystoreWrapper;
        if (aFKeystoreWrapper != null) {
            aFKeystoreWrapper.AFInAppEventType(context);
        }
    }

    @Deprecated
    public final void performOnAppAttribution(Context context, URI uRI2) {
        boolean empty;
        String str = "\"";
        if (uRI2 != null) {
            if (uRI2.toString().isEmpty()) {
            } else {
                if (context == null) {
                    StringBuilder obj4 = new StringBuilder("Context is \"");
                    obj4.append(context);
                    obj4.append(str);
                    ar.AFInAppEventType(obj4.toString(), DeepLinkResult.Error.NETWORK);
                }
            }
            HashMap hashMap = new HashMap();
            h.AFKeystoreWrapper().valueOf(context, hashMap, Uri.parse(uRI2.toString()));
        }
        StringBuilder obj3 = new StringBuilder("Link is \"");
        obj3.append(uRI2);
        obj3.append(str);
        ar.AFInAppEventType(obj3.toString(), DeepLinkResult.Error.NETWORK);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void performOnDeepLinking(Intent intent, Context context2) {
        if (intent == null) {
            ar.AFInAppEventType("performOnDeepLinking was called with null intent", DeepLinkResult.Error.DEVELOPER_ERROR);
        }
        if (context2 == null) {
            ar.AFInAppEventType("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
        }
        ah.1 anon = new ah.1(this, intent, context2.getApplicationContext());
        this.getOutOfStore.execute(anon);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener2) {
        com.appsflyer.internal.an obj4;
        if (an.values == null) {
            obj4 = new an();
            an.values = obj4;
        }
        an.values.AFInAppEventType("public_api_call", "registerConversionListener", new String[0]);
        if (appsFlyerConversionListener2 != null) {
            ah.AFInAppEventType = appsFlyerConversionListener2;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener2) {
        com.appsflyer.internal.an obj4;
        if (an.values == null) {
            obj4 = new an();
            an.values = obj4;
        }
        an.values.AFInAppEventType("public_api_call", "registerValidatorListener", new String[0]);
        AFLogger.values("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener2 == null) {
            AFLogger.values("registerValidatorListener null listener");
        }
        ah.AFInAppEventParameterName = appsFlyerInAppPurchaseValidatorListener2;
    }

    public final void sendAdRevenue(Context context, Map<String, Object> map2) {
        String string;
        Object obj12;
        com.appsflyer.internal.k obj13;
        bz bzVar = new bz();
        if (context != null) {
            bzVar.AFInAppEventType = (Application)context.getApplicationContext();
        }
        bzVar.valueOf = map2;
        obj12 = bzVar.AFInAppEventType;
        Object[] arr = new Object[2];
        final int i4 = 0;
        arr[i4] = AppsFlyerLib.getInstance().getHostPrefix();
        int i5 = 1;
        arr[i5] = ah.onConversionDataFail.getHostName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(ah.onAppOpenAttributionNative, arr));
        stringBuilder.append(obj12.getPackageName());
        SharedPreferences sharedPreferences = ah.AFKeystoreWrapper(obj12);
        int i3 = ah.AFInAppEventType(sharedPreferences, "appsFlyerCount", i4);
        HashMap hashMap = new HashMap();
        hashMap.put("ad_network", bzVar.valueOf);
        hashMap.put("adrevenue_counter", Integer.valueOf(ah.AFInAppEventType(sharedPreferences, "appsFlyerAdRevenueCount", i5)));
        String devKey = AppsFlyerProperties.getInstance().getDevKey();
        hashMap.put("af_key", devKey);
        String str9 = "launch_counter";
        hashMap.put(str9, Integer.valueOf(i3));
        Date date = new Date();
        hashMap.put("af_timestamp", Long.toString(date.getTime()));
        WeakReference weakReference = new WeakReference(obj12);
        hashMap.put("uid", al.AFInAppEventType(weakReference));
        String str12 = "advertiserId";
        String string3 = AppsFlyerProperties.getInstance().getString(str12);
        String str16 = "advertiserIdEnabled";
        String string4 = AppsFlyerProperties.getInstance().getString(str16);
        if (string4 != null) {
            hashMap.put(str16, string4);
        }
        if (string3 != null) {
            hashMap.put(str12, string3);
        }
        hashMap.put("device", Build.DEVICE);
        ah.valueOf(obj12, hashMap);
        android.content.pm.PackageInfo packageInfo = obj12.getPackageManager().getPackageInfo(obj12.getPackageName(), i4);
        hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
        String str15 = "yyyy-MM-dd_HHmmssZ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str15, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date2 = new Date(packageInfo.firstInstallTime, str15);
        hashMap.put("install_date", simpleDateFormat.format(date2));
        if (sharedPreferences.getString("appsFlyerFirstInstall", 0) == null) {
            string = AFKeystoreWrapper(simpleDateFormat, obj12);
        }
        hashMap.put("first_launch_date", string);
        obj13 = bzVar.values(stringBuilder.toString()).values(hashMap);
        obj13.onDeepLinkingNative = i3;
        obj13.AFLogger$LogLevel = devKey;
        obj12 = new ah.b(this, obj13, i4);
        if (k.AFKeystoreWrapper == null) {
            obj13 = new k();
            k.AFKeystoreWrapper = obj13;
        }
        ah.values(k.AFKeystoreWrapper.AFInAppEventParameterName(), obj12, 1, string);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendPushNotificationData(Activity activity) {
        Object concurrentHashMap;
        int getInstance;
        Object valueOf;
        int valueOf2;
        int values;
        String onValidateInApp;
        com.appsflyer.internal.an anVar;
        String strArr;
        int i;
        boolean equals;
        int getInstance2;
        Object getInstance3;
        String str;
        Object values2;
        com.appsflyer.internal.an anVar2;
        com.appsflyer.internal.an anVar3;
        String[] strArr2;
        String localClassName;
        boolean next;
        long longValue;
        JSONObject jSONObject;
        Object obj;
        final Object obj2 = this;
        concurrentHashMap = "c";
        valueOf = "pid";
        values = 1;
        int i3 = 0;
        i = 2;
        getInstance3 = "public_api_call";
        str = "sendPushNotificationData";
        if (activity != null && activity.getIntent() != null) {
            if (activity.getIntent() != null) {
                if (an.values == null) {
                    anVar3 = new an();
                    an.values = anVar3;
                }
                strArr2 = new String[i];
                strArr2[i3] = activity.getLocalClassName();
                StringBuilder stringBuilder3 = new StringBuilder("activity_intent_");
                stringBuilder3.append(activity.getIntent().toString());
                strArr2[values] = stringBuilder3.toString();
                an.values.AFInAppEventType(getInstance3, str, strArr2);
            } else {
                if (activity != null) {
                    if (an.values == null) {
                        anVar2 = new an();
                        an.values = anVar2;
                    }
                    strArr2 = new String[i];
                    strArr2[i3] = activity.getLocalClassName();
                    strArr2[values] = "activity_intent_null";
                    an.values.AFInAppEventType(getInstance3, str, strArr2);
                } else {
                    if (an.values == null) {
                        anVar = new an();
                        an.values = anVar;
                    }
                    an.values.AFInAppEventType(getInstance3, str, /* result */);
                }
            }
        } else {
        }
        onValidateInApp = ah.AFKeystoreWrapper(activity);
        obj2.onValidateInApp = onValidateInApp;
        if (onValidateInApp != null) {
            long currentTimeMillis = System.currentTimeMillis();
            str = ")";
            if (obj2.getInstance == null) {
                AFLogger.AFInAppEventType("pushes: initializing pushes history..");
                concurrentHashMap = new ConcurrentHashMap();
                obj2.getInstance = concurrentHashMap;
                localClassName = currentTimeMillis;
            } else {
                getInstance3 = obj2.getInstance.keySet().iterator();
                localClassName = currentTimeMillis;
                for (Long next : getInstance3) {
                    JSONObject jSONObject2 = new JSONObject(obj2.onValidateInApp);
                    jSONObject = new JSONObject((String)obj2.getInstance.get(next));
                    if (Long.compare(i4, values2) > 0) {
                    }
                    if (Long.compare(longValue, localClassName) <= 0) {
                    }
                    i = 2;
                    localClassName = next.longValue();
                    obj2.getInstance.remove(next);
                }
            }
            if (obj2.getInstance.size() == AppsFlyerProperties.getInstance().getInt("pushPayloadHistorySize", 2)) {
                StringBuilder stringBuilder = new StringBuilder("pushes: removing oldest overflowing push (oldest push:");
                stringBuilder.append(localClassName);
                stringBuilder.append(str);
                AFLogger.AFInAppEventType(stringBuilder.toString());
                obj2.getInstance.remove(Long.valueOf(localClassName));
            }
            obj2.getInstance.put(Long.valueOf(currentTimeMillis), obj2.onValidateInApp);
            start(activity);
        }
    }

    public final void setAdditionalData(Map<String, Object> map) {
        com.appsflyer.internal.an anVar;
        String string;
        String[] strArr;
        String str2;
        String str;
        Object obj5;
        if (map != null && an.values == null) {
            if (an.values == null) {
                anVar = new an();
                an.values = anVar;
            }
            strArr = new String[1];
            an.values.AFInAppEventType("public_api_call", "setAdditionalData", map.toString());
            JSONObject jSONObject = new JSONObject(map);
            AppsFlyerProperties.getInstance().setCustomData(jSONObject.toString());
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAndroidIdData(String string) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setAndroidIdData", string);
        this.AFVersionDeclaration = string;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAppId(String string) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setAppId", string);
        AppsFlyerProperties.getInstance().set("appid", string);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAppInviteOneLink(String string) {
        com.appsflyer.internal.an anVar;
        boolean instance;
        String str;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setAppInviteOneLink", string);
        AFLogger.AFInAppEventType("setAppInviteOneLink = ".concat(String.valueOf(string)));
        String str2 = "oneLinkSlug";
        if (string != null) {
            if (!string.equals(AppsFlyerProperties.getInstance().getString(str2))) {
                AppsFlyerProperties.getInstance().remove("onelinkDomain");
                AppsFlyerProperties.getInstance().remove("onelinkVersion");
                AppsFlyerProperties.getInstance().remove("onelinkScheme");
            }
        } else {
        }
        AppsFlyerProperties.getInstance().set(str2, string);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCollectAndroidID(boolean z) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setCollectAndroidID", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("collectAndroidId", Boolean.toString(z));
        AppsFlyerProperties.getInstance().set("collectAndroidIdForceByUser", Boolean.toString(z));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCollectIMEI(boolean z) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setCollectIMEI", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("collectIMEI", Boolean.toString(z));
        AppsFlyerProperties.getInstance().set("collectIMEIForceByUser", Boolean.toString(z));
    }

    @Deprecated
    public final void setCollectOaid(boolean z) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setCollectOaid", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("collectOAID", Boolean.toString(z));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCurrencyCode(String string) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setCurrencyCode", string);
        AppsFlyerProperties.getInstance().set("currencyCode", string);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCustomerIdAndLogSession(String string, Context context2) {
        boolean valueOf;
        int i;
        boolean z;
        String obj4;
        Object obj5;
        i = 1;
        setCustomerUserId(string);
        StringBuilder stringBuilder = new StringBuilder("CustomerUserId set: ");
        stringBuilder.append(string);
        stringBuilder.append(" - Initializing AppsFlyer Tacking");
        AFLogger.valueOf(stringBuilder.toString(), i);
        if (context2 != null && valueOf() && AppsFlyerProperties.getInstance().getReferrer(context2) == null) {
            i = 1;
            if (valueOf()) {
                setCustomerUserId(string);
                stringBuilder = new StringBuilder("CustomerUserId set: ");
                stringBuilder.append(string);
                stringBuilder.append(" - Initializing AppsFlyer Tacking");
                AFLogger.valueOf(stringBuilder.toString(), i);
                if (AppsFlyerProperties.getInstance().getReferrer(context2) == null) {
                    obj4 = "";
                }
                if (context2 instanceof Activity != null) {
                    (Activity)context2.getIntent();
                }
                cc ccVar = new cc();
                if (context2 != null) {
                    ccVar.AFInAppEventType = (Application)context2.getApplicationContext();
                }
                obj5 = 0;
                ccVar.AFVersionDeclaration = obj5;
                ccVar.AFLogger$LogLevel = AppsFlyerProperties.getInstance().getDevKey();
                ccVar.valueOf = obj5;
                ccVar.AppsFlyer2dXConversionCallback = obj4;
                ccVar.AFKeystoreWrapper = obj5;
                AFKeystoreWrapper(ccVar);
            }
            setCustomerUserId(string);
            AFLogger.valueOf("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(string)), i);
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCustomerUserId(String string) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        final int i2 = 0;
        strArr[i2] = string;
        an.values.AFInAppEventType("public_api_call", "setCustomerUserId", strArr);
        AFLogger.AFInAppEventType("setCustomerUserId = ".concat(String.valueOf(string)));
        AppsFlyerProperties.getInstance().set("AppUserId", string);
        AppsFlyerProperties.getInstance().set("waitForCustomerId", i2);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDebugLog(boolean z) {
        AFLogger.LogLevel obj1;
        obj1 = z ? AFLogger.LogLevel.DEBUG : AFLogger.LogLevel.NONE;
        setLogLevel(obj1);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDisableAdvertisingIdentifiers(boolean z) {
        AFLogger.values("setDisableAdvertisingIdentifiers: ".concat(String.valueOf(z)));
        ac.AFInAppEventParameterName = Boolean.valueOf(z ^= 1);
        AppsFlyerProperties.getInstance().remove("advertiserIdEnabled");
        AppsFlyerProperties.getInstance().remove("advertiserId");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setExtension(String string) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setExtension", string);
        AppsFlyerProperties.getInstance().set("sdkExtension", string);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setHost(String string, String string2) {
        AppsFlyerProperties instance;
        String str;
        String obj3;
        if (string != null) {
            AppsFlyerProperties.getInstance().set("custom_host_prefix", string);
        }
        if (string2 != null && !string2.isEmpty()) {
            if (!string2.isEmpty()) {
                AppsFlyerProperties.getInstance().set("custom_host", string2);
            }
        }
        AFLogger.init("hostName cannot be null or empty");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setImeiData(String string) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setImeiData", string);
        this.init = string;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setIsUpdate(boolean z) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("IS_UPDATE", z);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setLogLevel(AFLogger.LogLevel aFLogger$LogLevel) {
        int i;
        com.appsflyer.internal.an anVar;
        int i2 = 1;
        int i3 = 0;
        i = logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel() ? i2 : i3;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[i2];
        strArr[i3] = String.valueOf(i);
        an.values.AFInAppEventType("public_api_call", "log", strArr);
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setMinTimeBetweenSessions(int i) {
        this.onResponseError = TimeUnit.SECONDS.toMillis((long)i);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOaidData(String string) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        String[] strArr = new String[1];
        an.values.AFInAppEventType("public_api_call", "setOaidData", string);
        ac.AFInAppEventType = string;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOneLinkCustomDomain(String... stringArr) {
        Object[] arr = new Object[1];
        AFLogger.values(String.format("setOneLinkCustomDomain %s", Arrays.toString(stringArr)));
        h.AppsFlyer2dXConversionCallback = stringArr;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOutOfStore(String string) {
        if (string != null) {
            String obj3 = string.toLowerCase();
            AppsFlyerProperties.getInstance().set("api_store_value", obj3);
            AFLogger.valueOf("Store API set with value: ".concat(String.valueOf(obj3)), true);
        }
        AFLogger.AFInAppEventParameterName("Cannot set setOutOfStore with null");
    }

    public final void setPartnerData(String string, Map<String, Object> map2) {
        com.appsflyer.internal.ba setCustomerIdAndLogSession;
        boolean empty;
        String obj4;
        Object obj5;
        if (this.setCustomerIdAndLogSession == null) {
            setCustomerIdAndLogSession = new ba();
            this.setCustomerIdAndLogSession = setCustomerIdAndLogSession;
        }
        com.appsflyer.internal.ba setCustomerIdAndLogSession2 = this.setCustomerIdAndLogSession;
        if (string != null) {
            if (string.isEmpty()) {
            } else {
                if (map2 != null) {
                    if (map2.isEmpty()) {
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Setting partner data for ");
                        stringBuilder.append(string);
                        stringBuilder.append(": ");
                        stringBuilder.append(map2);
                        AFLogger.values(stringBuilder.toString());
                        JSONObject jSONObject = new JSONObject(map2);
                        int length = jSONObject.toString().length();
                        if (length > 1000) {
                            AFLogger.init("Partner data 1000 characters limit exceeded");
                            obj5 = new HashMap();
                            obj5.put("error", "limit exceeded: ".concat(String.valueOf(length)));
                            setCustomerIdAndLogSession2.AFInAppEventParameterName.put(string, obj5);
                        }
                    }
                    setCustomerIdAndLogSession2.AFInAppEventType.put(string, map2);
                    setCustomerIdAndLogSession2.AFInAppEventParameterName.remove(string);
                }
                if (setCustomerIdAndLogSession2.AFInAppEventType.remove(string) == null) {
                    obj4 = "Partner data is missing or `null`";
                } else {
                    obj4 = "Cleared partner data for ".concat(String.valueOf(string));
                }
            }
            AFLogger.init(obj4);
        }
        AFLogger.init("Partner ID is missing or `null`");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPhoneNumber(String string) {
        this.setOutOfStore = ag.valueOf(string);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPreinstallAttribution(String string, String string2, String string3) {
        Object obj3;
        Object obj4;
        AFLogger.values("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        final String str2 = "pid";
        if (string != null) {
            jSONObject.put(str2, string);
        }
        if (string2 != null) {
            jSONObject.put("c", string2);
        }
        if (string3 != null) {
            jSONObject.put("af_siteid", string3);
        }
        if (jSONObject.has(str2)) {
            AppsFlyerProperties.getInstance().set("preInstallName", jSONObject.toString());
        }
        AFLogger.init("Cannot set preinstall attribution data without a media source");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setResolveDeepLinkURLs(String... stringArr) {
        Object[] arr = new Object[1];
        AFLogger.values(String.format("setResolveDeepLinkURLs %s", Arrays.toString(stringArr)));
        h.AFInAppEventType = stringArr;
    }

    @Deprecated
    public final void setSharingFilter(String... stringArr) {
        setSharingFilterForPartners(stringArr);
    }

    @Deprecated
    public final void setSharingFilterForAllPartners() {
        setSharingFilterForPartners(/* result */);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setSharingFilterForPartners(String... stringArr) {
        m mVar = new m(stringArr);
        this.onDeepLinkingNative = mVar;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setUserEmails(AppsFlyerProperties.EmailsCryptType appsFlyerProperties$EmailsCryptType, String... string2Arr2) {
        com.appsflyer.internal.an anVar;
        int str;
        int i3;
        int i;
        int i2;
        ArrayList arrayList = new ArrayList(length++);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(string2Arr2));
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        an.values.AFInAppEventType("public_api_call", "setUserEmails", (String[])arrayList.toArray(new String[length2++]));
        AppsFlyerProperties.getInstance().set("userEmailsCryptType", emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        str = 0;
        ArrayList arrayList2 = new ArrayList();
        i3 = 0;
        while (i3 < string2Arr2.length) {
            Object obj = string2Arr2[i3];
            if (ah.10.AFInAppEventType[emailsCryptType.ordinal()] != 2) {
            } else {
            }
            arrayList2.add(obj);
            str = "plain_el_arr";
            i3++;
            arrayList2.add(ag.valueOf(obj));
            str = "sha256_el_arr";
        }
        hashMap.put(str, arrayList2);
        JSONObject obj8 = new JSONObject(hashMap);
        AppsFlyerProperties.getInstance().setUserEmails(obj8.toString());
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setUserEmails(String... stringArr) {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        an.values.AFInAppEventType("public_api_call", "setUserEmails", stringArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, stringArr);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context) {
        start(context, 0);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context, String string2) {
        start(context, string2, 0);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(Context context, String string2, AppsFlyerRequestListener appsFlyerRequestListener3) {
        String setDebugLog;
        com.appsflyer.internal.aw appsFlyer2dXConversionCallback;
        String str;
        com.appsflyer.internal.an anVar;
        boolean instance;
        Object baseContext;
        boolean applicationContext;
        String nO_DEV_KEY;
        Object valueOf;
        int i;
        int string;
        int proxyInstance;
        int empty;
        int str2;
        String anon;
        Method method;
        int i2;
        String str3;
        Class<String> obj;
        final Object obj2 = this;
        valueOf = context;
        String str4 = string2;
        final AppsFlyerRequestListener list = appsFlyerRequestListener3;
        if (ai.AFKeystoreWrapper != null) {
        }
        AFLogger.init("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
        if (!obj2.setDebugLog && str4 == null && list != null) {
            AFLogger.init("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
            if (str4 == null) {
                if (list != null) {
                    list.onError(RequestError.NO_DEV_KEY, bc.valueOf);
                }
            }
        }
        onInstallConversionFailureNative.AFKeystoreWrapper = context.getApplicationContext();
        if (obj2.AppsFlyer2dXConversionCallback == null) {
            appsFlyer2dXConversionCallback = new aw(valueOf);
            obj2.AppsFlyer2dXConversionCallback = appsFlyer2dXConversionCallback;
        }
        com.appsflyer.internal.aw appsFlyer2dXConversionCallback2 = obj2.AppsFlyer2dXConversionCallback;
        str = valueOf instanceof Activity != null ? "activity" : z2 ? "application" : "other";
        appsFlyer2dXConversionCallback2.AFInAppEventType.put("start_with", str);
        obj2.setCustomerUserId = (Application)context.getApplicationContext();
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        i = 1;
        String[] strArr = new String[i];
        final int i4 = 0;
        strArr[i4] = str4;
        an.values.AFInAppEventType("public_api_call", "start", strArr);
        string = 2;
        Object[] arr = new Object[string];
        arr[i4] = "6.5.0";
        String aFKeystoreWrapper2 = ah.AFKeystoreWrapper;
        arr[i] = aFKeystoreWrapper2;
        AFLogger.AFInAppEventType(String.format("Starting AppsFlyer: (v%s.%s)", arr));
        StringBuilder stringBuilder = new StringBuilder("Build Number: ");
        stringBuilder.append(aFKeystoreWrapper2);
        AFLogger.AFInAppEventType(stringBuilder.toString());
        AppsFlyerProperties.getInstance().loadProperties(obj2.setCustomerUserId.getApplicationContext());
        if (!TextUtils.isEmpty(string2)) {
            AppsFlyerProperties.getInstance().setDevKey(str4);
            aj.AFInAppEventParameterName(string2);
        } else {
            AFLogger.init("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
            if (TextUtils.isEmpty(AppsFlyerProperties.getInstance().getDevKey()) && list != null) {
                AFLogger.init("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
                if (list != null) {
                    list.onError(RequestError.NO_DEV_KEY, bc.valueOf);
                }
            }
        }
        com.appsflyer.internal.bs valueOf2 = obj2.onInstallConversionFailureNative.valueOf();
        str2 = 0;
        bs.4 anon3 = new bs.4(valueOf2, str2);
        valueOf2.values.execute(anon3);
        baseContext = obj2.setCustomerUserId.getBaseContext();
        if (flags &= empty != 0) {
            if (baseContext.getResources().getIdentifier("appsflyer_backup_rules", "xml", baseContext.getPackageName()) != 0) {
                AFLogger.valueOf("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", i);
            } else {
                AFLogger.AFInAppEventParameterName("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
            }
        }
        if (obj2.setImeiData != null) {
            applicationContext = obj2.setCustomerUserId.getApplicationContext();
            HashMap hashMap = new HashMap();
            obj2.setOaidData = hashMap;
            anon = new ah.3(obj2, System.currentTimeMillis(), empty);
            Class[] arr4 = new Class[i];
            arr4[i4] = Context.class;
            Object[] arr2 = new Object[i];
            arr2[i4] = applicationContext;
            Class.forName("com.facebook.o").getMethod("sdkInitialize", arr4).invoke(str2, arr2);
            Class forName2 = Class.forName("com.facebook.applinks.a");
            Class forName3 = Class.forName("com.facebook.applinks.a$b");
            i2 = 3;
            Class[] arr5 = new Class[i2];
            arr5[i4] = Context.class;
            arr5[i] = String.class;
            arr5[string] = forName3;
            m.3 anon4 = new m.3(forName2, anon);
            Class[] arr3 = new Class[i];
            arr3[i4] = forName3;
            string = applicationContext.getString(applicationContext.getResources().getIdentifier("facebook_app_id", "string", applicationContext.getPackageName()));
            if (TextUtils.isEmpty(string)) {
                anon.AFInAppEventType("Facebook app id not defined in resources");
            } else {
                empty = new Object[i2];
                empty[i4] = applicationContext;
                empty[i] = string;
                empty[2] = Proxy.newProxyInstance(forName3.getClassLoader(), arr3, anon4);
                forName2.getMethod("fetchDeferredAppLinkData", arr5).invoke(0, empty);
            }
        }
        ah.7 anon2 = new ah.7(obj2, appsFlyer2dXConversionCallback2, str4, list);
        ai.AFInAppEventType(valueOf, anon2, obj2.getOutOfStore);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void stop(boolean z, Context context2) {
        int exists;
        int i;
        String aFInAppEventParameterName;
        String string;
        String name;
        File[] obj6;
        Object obj7;
        this.updateServerUninstallToken = z;
        ae.AFInAppEventType();
        obj6 = ae.AFKeystoreWrapper(context2);
        if (!obj6.exists()) {
            obj6.mkdir();
        } else {
            obj6 = obj6.listFiles();
            i = 0;
            while (i < obj6.length) {
                File file = obj6[i];
                StringBuilder stringBuilder = new StringBuilder("Found cached request");
                stringBuilder.append(file.getName());
                AFLogger.AFInAppEventType(stringBuilder.toString());
                ae.values(fVar.AFInAppEventParameterName, context2);
                i++;
            }
        }
        if (this.updateServerUninstallToken) {
            obj6 = ah.AFKeystoreWrapper(context2).edit();
            obj6.putBoolean("is_stop_tracking_used", true);
            obj6.apply();
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener) {
        final int i = 3;
        subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(i));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void subscribeForDeepLink(DeepLinkListener deepLinkListener, long l2) {
        hVar.values = deepLinkListener;
        ap.onAttributionFailureNative = l2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void unregisterConversionListener() {
        com.appsflyer.internal.an anVar;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        an.values.AFInAppEventType("public_api_call", "unregisterConversionListener", new String[0]);
        ah.AFInAppEventType = 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void updateServerUninstallToken(Context context, String string2) {
        bv bvVar = new bv(context);
        bvVar.valueOf(string2);
    }

    public final void validateAndLogInAppPurchase(Context context, String string2, String string3, String string4, String string5, String string6, Map<String, String> map7) {
        Object aFInAppEventParameterName;
        com.appsflyer.internal.an anVar;
        boolean applicationContext;
        String[] strArr;
        String str3;
        String string;
        String str;
        String str5;
        String str4;
        String str2;
        Map map;
        Thread thread;
        com.appsflyer.internal.z zVar;
        Object obj = context;
        str5 = string4;
        str4 = string5;
        str2 = string6;
        if (an.values == null) {
            anVar = new an();
            an.values = anVar;
        }
        strArr = new String[6];
        if (map7 == null) {
            string = "";
        } else {
            string = map7.toString();
        }
        an.values.AFInAppEventType("public_api_call", "validateAndTrackInAppPurchase", string2, string3, str5, str4, str2, string);
        if (!isStopped()) {
            StringBuilder stringBuilder = new StringBuilder("Validate in app called with parameters: ");
            stringBuilder.append(string4);
            strArr = " ";
            stringBuilder.append(strArr);
            stringBuilder.append(str4);
            stringBuilder.append(strArr);
            stringBuilder.append(str2);
            AFLogger.AFInAppEventType(stringBuilder.toString());
        }
        if (string2 != null && str4 != null && string3 != null && str2 != null) {
            if (str4 != null) {
                if (string3 != null) {
                    if (str2 != null) {
                        if (str5 == null) {
                            aFInAppEventParameterName = ah.AFInAppEventParameterName;
                            if (aFInAppEventParameterName != null) {
                                aFInAppEventParameterName.onValidateInAppFailure("Please provide purchase parameters");
                            }
                        } else {
                            if (obj instanceof Activity != null) {
                                (Activity)obj.getIntent();
                            }
                            super(context.getApplicationContext(), AppsFlyerProperties.getInstance().getDevKey(), string2, string3, string4, string5, string6, map7);
                            thread = new Thread(zVar);
                            thread.start();
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String valueOf(Context context, String string2) {
        final SharedPreferences sharedPreferences = ah.AFKeystoreWrapper(context);
        final String str = "CACHED_CHANNEL";
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getString(str, 0);
        }
        SharedPreferences.Editor obj4 = ah.AFKeystoreWrapper(context).edit();
        obj4.putString(str, string2);
        obj4.apply();
        return string2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void valueOf(Context context, Intent intent2) {
        String stringExtra2;
        String cfVar;
        String stringExtra;
        Object applicationContext;
        Object instance;
        Object mILLISECONDS;
        com.appsflyer.internal.k obj4;
        String obj5;
        stringExtra2 = "appsflyer_preinstall";
        if (intent2.getStringExtra(stringExtra2) != null) {
            stringExtra2 = intent2.getStringExtra(stringExtra2);
            JSONObject jSONObject = new JSONObject(stringExtra2);
            if (jSONObject.has("pid")) {
                AppsFlyerProperties.getInstance().set("preInstallName", stringExtra2);
            } else {
                AFLogger.init("Cannot set preinstall attribution data without a media source");
            }
        }
        AFLogger.AFInAppEventType("****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        cfVar = "referrer";
        obj5 = intent2.getStringExtra(cfVar);
        AFLogger.AFInAppEventType("Play store referrer: ".concat(String.valueOf(obj5)));
        SharedPreferences.Editor edit = ah.AFKeystoreWrapper(context).edit();
        edit.putString(cfVar, obj5);
        edit.apply();
        AppsFlyerProperties instance2 = AppsFlyerProperties.getInstance();
        instance2.set("AF_REFERRER", obj5);
        instance2.valueOf = obj5;
        AFLogger.AFInAppEventType("onReceive: isLaunchCalled");
        cfVar = new cf();
        if (obj5 != null && AppsFlyerProperties.getInstance().AFInAppEventType() && context != null) {
            edit = ah.AFKeystoreWrapper(context).edit();
            edit.putString(cfVar, obj5);
            edit.apply();
            instance2 = AppsFlyerProperties.getInstance();
            instance2.set("AF_REFERRER", obj5);
            instance2.valueOf = obj5;
            if (AppsFlyerProperties.getInstance().AFInAppEventType()) {
                AFLogger.AFInAppEventType("onReceive: isLaunchCalled");
                cfVar = new cf();
                if (context != null) {
                    cfVar.AFInAppEventType = (Application)context.getApplicationContext();
                }
                cfVar.AppsFlyer2dXConversionCallback = obj5;
                if (obj5 != null && obj5.length() > 5 && AFInAppEventType(cfVar, ah.AFKeystoreWrapper(context)) && k.AFKeystoreWrapper == null) {
                    if (obj5.length() > 5) {
                        if (AFInAppEventType(cfVar, ah.AFKeystoreWrapper(context))) {
                            try {
                                if (k.AFKeystoreWrapper == null) {
                                }
                                obj4 = new k();
                                k.AFKeystoreWrapper = obj4;
                                applicationContext = 0;
                                obj5 = new ah.a(this, cfVar, applicationContext);
                                ah.values(k.AFKeystoreWrapper.AFInAppEventParameterName(), obj5, 5, applicationContext);
                            }
                        }
                    }
                }
            }
        }
    }

    final void valueOf(WeakReference<Context> weakReference) {
        String string;
        boolean boolean;
        Object valueOf;
        String str2;
        String str;
        if (weakReference.get() == null) {
        }
        AFLogger.AFInAppEventType("app went to background");
        SharedPreferences sharedPreferences = ah.AFKeystoreWrapper((Context)weakReference.get());
        AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
        HashMap hashMap = new HashMap();
        String devKey = AppsFlyerProperties.getInstance().getDevKey();
        if (devKey == null) {
            AFLogger.init("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
        }
        str2 = "deviceTrackingDisabled";
        final int i7 = 0;
        if (AppsFlyerProperties.getInstance().getBoolean(str2, i7)) {
            hashMap.put(str2, "true");
        }
        valueOf = ac.AFInAppEventType((Context)weakReference.get().getContentResolver());
        if (valueOf != null) {
            hashMap.put("amazon_aid", valueOf.valueOf);
            hashMap.put("amazon_aid_limit", String.valueOf(valueOf.AFInAppEventParameterName));
        }
        String str17 = "advertiserId";
        String string3 = AppsFlyerProperties.getInstance().getString(str17);
        if (string3 != null) {
            hashMap.put(str17, string3);
        }
        hashMap.put("app_id", (Context)weakReference.get().getPackageName());
        hashMap.put("devkey", devKey);
        hashMap.put("uid", al.AFInAppEventType(weakReference));
        hashMap.put("time_in_app", String.valueOf(i2 /= i6));
        hashMap.put("statType", "user_closed_app");
        hashMap.put("platform", "Android");
        hashMap.put("launch_counter", Integer.toString(ah.AFInAppEventType(sharedPreferences, "appsFlyerCount", i7)));
        hashMap.put("channel", AFInAppEventParameterName((Context)weakReference.get()));
        if (AppsFlyerProperties.getInstance().getString("KSAppsFlyerId") != null) {
        } else {
            string = "";
        }
        hashMap.put("originalAppsflyerId", string);
        if (this.onPause) {
            AFLogger.values("Running callStats task");
            ci ciVar = new ci();
            ciVar.onResponseErrorNative = isStopped();
            Object[] arr = new Object[2];
            arr[i7] = AppsFlyerLib.getInstance().getHostPrefix();
            arr[1] = ah.onConversionDataFail.getHostName();
            ak.a obj11 = new ak.a((cd)ciVar.values(hashMap).values(String.format(ah.onInstallConversionDataLoadedNative, arr)));
            Thread thread = new Thread(obj11);
            thread.start();
        }
        AFLogger.values("Stats call is disabled, ignore ...");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final boolean valueOf() {
        boolean values;
        String str;
        final int i2 = 0;
        if (ah.values("waitForCustomerId", i2) && AppsFlyerProperties.getInstance().getString("AppUserId") == null) {
            if (AppsFlyerProperties.getInstance().getString("AppUserId") == null) {
                return 1;
            }
        }
        return i2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void waitForCustomerUserId(boolean z) {
        AFLogger.valueOf("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        AppsFlyerProperties.getInstance().set("waitForCustomerId", z);
    }
}
