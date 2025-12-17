package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.deeplink.DeepLinkResult.Error;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class h {

    public static Intent AFInAppEventParameterName;
    static String[] AFInAppEventType;
    static volatile boolean AFKeystoreWrapper;
    private static com.appsflyer.internal.h AFVersionDeclaration;
    static String[] AppsFlyer2dXConversionCallback;
    static final int valueOf;
    public String AFLogger$LogLevel;
    public List<List<String>> getLevel;
    public Map<String, String> init;
    public DeepLinkListener values;
    static {
        h.valueOf = (int)millis;
    }

    public h() {
        super();
        ArrayList arrayList = new ArrayList();
        this.getLevel = arrayList;
    }

    private Uri AFInAppEventType(Object object, Iterator<String> iterator2) {
        String obj4;
        final int i = 0;
        while (object == JSONObject.NULL) {
            JSONObject jSONObject = new JSONObject(object.toString());
            Object obj3 = jSONObject.get((String)iterator2.next());
            i = 0;
        }
        return i;
    }

    private static boolean AFInAppEventType(String string) {
        final int i = 0;
        if (h.AFInAppEventType == null) {
            return i;
        }
        if (string.contains("af_tranid=")) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder("Validate if link ");
        stringBuilder.append(string);
        stringBuilder.append(" belongs to ESP domains: ");
        stringBuilder.append(Arrays.asList(h.AFInAppEventType));
        AFLogger.AFKeystoreWrapper(stringBuilder.toString());
        URL url = new URL(string);
        return Arrays.asList(h.AFInAppEventType).contains(url.getHost());
    }

    public static com.appsflyer.internal.h AFKeystoreWrapper() {
        com.appsflyer.internal.h aFVersionDeclaration;
        if (h.AFVersionDeclaration == null) {
            aFVersionDeclaration = new h();
            h.AFVersionDeclaration = aFVersionDeclaration;
        }
        return h.AFVersionDeclaration;
    }

    static boolean valueOf(String string) {
        return h.AFInAppEventType(string);
    }

    static Uri values(Intent intent) {
        boolean equals;
        String str;
        int obj2;
        if (intent != null && "android.intent.action.VIEW".equals(intent.getAction())) {
            if ("android.intent.action.VIEW".equals(intent.getAction())) {
                obj2 = intent.getData();
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    private boolean values(Intent intent, Context context2, Map<String, Object> map3) {
        Uri data;
        String equals;
        int i;
        boolean equals2;
        int data2;
        Object getLevel;
        String action;
        List getLevel2;
        boolean next;
        int iterator;
        String string;
        equals = "android.intent.action.VIEW";
        i = 0;
        if (intent != null && equals.equals(intent.getAction())) {
            if (equals.equals(intent.getAction())) {
                data2 = intent.getData();
            } else {
                data2 = i;
            }
        } else {
        }
        Intent aFInAppEventParameterName = h.AFInAppEventParameterName;
        if (aFInAppEventParameterName != null && equals.equals(aFInAppEventParameterName.getAction())) {
            if (equals.equals(aFInAppEventParameterName.getAction())) {
                data = aFInAppEventParameterName.getData();
            } else {
                data = i;
            }
        } else {
        }
        getLevel = intent.getExtras();
        getLevel2 = this.getLevel;
        if (getLevel2 != null && !getLevel2.isEmpty()) {
            if (!getLevel2.isEmpty()) {
                if (getLevel == null) {
                } else {
                    getLevel2 = this.getLevel.iterator();
                    while (getLevel2.hasNext()) {
                        next = getLevel2.next();
                        if ((List)next == null) {
                        } else {
                        }
                        iterator = (List)next.iterator();
                        if (!iterator.hasNext()) {
                        } else {
                        }
                        string = getLevel.getString((String)iterator.next());
                        if (string == null) {
                        } else {
                        }
                        iterator = AFInAppEventType(string, iterator);
                        if (iterator != null) {
                            break;
                        } else {
                        }
                        iterator = i;
                    }
                }
            }
        }
        int i2 = 1;
        String str2 = " w/af_consumed";
        int i3 = 0;
        String str3 = "af_consumed";
        if (data2 != null && !intent.hasExtra(str3)) {
            if (!intent.hasExtra(str3)) {
                intent.putExtra(str3, System.currentTimeMillis());
                valueOf(context2, map3, data2);
                return i2;
            }
            StringBuilder obj9 = new StringBuilder("skipping re-use of previously consumed deep link: ");
            obj9.append(data2.toString());
            obj9.append(str2);
            AFLogger.AFInAppEventType(obj9.toString());
            return i3;
        }
        if (data != null && !h.AFInAppEventParameterName.hasExtra(str3)) {
            if (!h.AFInAppEventParameterName.hasExtra(str3)) {
                h.AFInAppEventParameterName.putExtra(str3, System.currentTimeMillis());
                valueOf(context2, map3, data);
                return i2;
            }
            obj9 = new StringBuilder("skipping re-use of previously consumed trampoline deep link: ");
            obj9.append(data.toString());
            obj9.append(str2);
            AFLogger.AFInAppEventType(obj9.toString());
            return i3;
        }
        if (i != 0 && !intent.hasExtra(str3)) {
            if (!intent.hasExtra(str3)) {
                intent.putExtra(str3, System.currentTimeMillis());
                valueOf(context2, map3, i);
                return i2;
            }
            obj9 = new StringBuilder("skipping re-use of previously consumed deep link from push: ");
            obj9.append(i.toString());
            obj9.append(str2);
            AFLogger.AFInAppEventType(obj9.toString());
            return i3;
        }
        AFLogger.values("No deep link detected");
        return i3;
    }

    final void valueOf(Context context, Map<String, Object> map2, Uri uri3) {
        Object aFInAppEventType;
        com.appsflyer.internal.k aFKeystoreWrapper;
        com.appsflyer.internal.h.3 anon;
        ScheduledExecutorService singleThreadScheduledExecutor;
        if (h.AFInAppEventType(uri3.toString())) {
            h.AFKeystoreWrapper = true;
            if (k.AFKeystoreWrapper == null) {
                aFKeystoreWrapper = new k();
                k.AFKeystoreWrapper = aFKeystoreWrapper;
            }
            com.appsflyer.internal.k aFKeystoreWrapper2 = k.AFKeystoreWrapper;
            if (aFKeystoreWrapper2.AFInAppEventType == null) {
                aFKeystoreWrapper2.AFInAppEventType = Executors.newSingleThreadScheduledExecutor(aFKeystoreWrapper2.values);
            }
            anon = new h.3(this, uri3, map2, context);
            aFKeystoreWrapper2.AFInAppEventType.execute(anon);
        } else {
            ah.AFKeystoreWrapper().AFInAppEventType(context, map2, uri3);
        }
        h.AFInAppEventParameterName = 0;
    }

    final void values(Map<String, Object> map, com.appsflyer.internal.aw aw2, Intent intent3, Context context4) {
        String onAttributionFailureNative;
        TimeUnit mILLISECONDS;
        boolean obj5;
        Object obj6;
        Context obj8;
        final SharedPreferences sharedPreferences = ah.AFKeystoreWrapper(context4);
        final String obj7 = "ddl_sent";
        ah.AFKeystoreWrapper();
        onAttributionFailureNative = 0;
        if (!values(intent3, context4, map) && this.values != null && ah.AFInAppEventType(sharedPreferences, "appsFlyerCount", onAttributionFailureNative) == 0 && !sharedPreferences.getBoolean(obj7, onAttributionFailureNative)) {
            if (this.values != null) {
                ah.AFKeystoreWrapper();
                onAttributionFailureNative = 0;
                if (ah.AFInAppEventType(sharedPreferences, "appsFlyerCount", onAttributionFailureNative) == 0) {
                    if (!sharedPreferences.getBoolean(obj7, onAttributionFailureNative)) {
                        obj5 = new ap(context4, aw2);
                        AFLogger.values("[DDL] start");
                        obj8 = new ap.1(obj5);
                        obj6 = new FutureTask(obj8);
                        obj8 = new Thread(obj6);
                        obj8.start();
                        obj8 = 0;
                        obj5.AFInAppEventType((DeepLinkResult)obj6.get(ap.onAttributionFailureNative, obj2));
                    }
                }
            }
        }
        sharedPreferences.edit().putBoolean(obj7, true).apply();
    }
}
