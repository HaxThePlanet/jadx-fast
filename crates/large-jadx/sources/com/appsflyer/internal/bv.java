package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class bv extends com.appsflyer.internal.cd {

    private static String onAttributionFailureNative;
    private final SharedPreferences onAppOpenAttributionNative;
    static {
        StringBuilder stringBuilder = new StringBuilder("https://%sregister.%s/api/v");
        stringBuilder.append(ah.valueOf);
        bv.onAttributionFailureNative = stringBuilder.toString();
    }

    public bv(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] arr = new Object[2];
        stringBuilder.append(String.format(bv.onAttributionFailureNative, AppsFlyerLib.getInstance().getHostPrefix(), ah.AFKeystoreWrapper().getHostName()));
        stringBuilder.append(context.getPackageName());
        super(0, stringBuilder.toString(), 0, 0, 0, context);
        this.onAppOpenAttributionNative = ah.AFKeystoreWrapper(context);
    }

    static void AFInAppEventType(com.appsflyer.internal.bv bv) {
        bv.onAppOpenAttributionNative.edit().putBoolean("sentRegisterRequestToAF", true).apply();
        AFLogger.values("Successfully registered for Uninstall Tracking");
    }

    public static boolean AFInAppEventType(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean("sentRegisterRequestToAF", false);
    }

    public static boolean AFKeystoreWrapper(Context context) {
        Intent intent;
        boolean obj5;
        final int i = 0;
        if (AppsFlyerLib.getInstance().isStopped()) {
            return i;
        }
        Class.forName("com.google.firebase.messaging.FirebaseMessagingService");
        intent = new Intent("com.google.firebase.MESSAGING_EVENT", 0, context, FirebaseMessagingServiceListener.class);
        if (ab.AFKeystoreWrapper(context, intent)) {
            return 1;
        }
        return i;
    }

    private void valueOf(com.appsflyer.internal.ad ad) {
        final String str2 = "afUninstallToken";
        this.onAppOpenAttributionNative.edit().putString(str2, ad.values).putLong("afUninstallToken_received_time", ad.AFInAppEventType).putBoolean("afUninstallToken_queued", ad.values()).apply();
    }

    @Override // com.appsflyer.internal.cd
    public void AFKeystoreWrapper(String string) {
        Object aFInAppEventType;
        String string2;
        String str2;
        Map values4;
        boolean boolean;
        Object valueOf;
        android.content.pm.PackageInfo packageInfo;
        Object values2;
        String str;
        Object values;
        Object values3;
        String bRAND;
        Object simpleDateFormat;
        aFInAppEventType = this.AFInAppEventType;
        final com.appsflyer.internal.ah ahVar = ah.AFKeystoreWrapper();
        if (ahVar.valueOf()) {
            AFLogger.valueOf("CustomerUserId not set, Tracking is disabled", true);
        }
        String devKey = AppsFlyerProperties.getInstance().getDevKey();
        if (devKey == null) {
            AFLogger.init("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
        }
        PackageManager packageManager = aFInAppEventType.getPackageManager();
        final int i = 0;
        packageInfo = packageManager.getPackageInfo(aFInAppEventType.getPackageName(), i);
        this.values.put("app_version_code", Integer.toString(packageInfo.versionCode));
        this.values.put("app_version_name", packageInfo.versionName);
        this.values.put("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
        this.values.put("installDate", ah.AFInAppEventParameterName(simpleDateFormat, packageInfo.firstInstallTime));
        ah.AFKeystoreWrapper(aFInAppEventType, this.values);
        String string4 = AppsFlyerProperties.getInstance().getString("AppUserId");
        if (string4 != null) {
            this.values.put("appUserId", string4);
        }
        this.values.put("model", Build.MODEL);
        this.values.put("brand", Build.BRAND);
        values = "deviceTrackingDisabled";
        if (AppsFlyerProperties.getInstance().getBoolean(values, i)) {
            this.values.put(values, "true");
        }
        valueOf = ac.AFInAppEventType(aFInAppEventType.getContentResolver());
        if (valueOf != null) {
            this.values.put("amazon_aid", valueOf.valueOf);
            this.values.put("amazon_aid_limit", String.valueOf(valueOf.AFInAppEventParameterName));
        }
        String str11 = "advertiserId";
        String string5 = AppsFlyerProperties.getInstance().getString(str11);
        if (string5 != null) {
            this.values.put(str11, string5);
        }
        this.values.put("devkey", devKey);
        WeakReference weakReference = new WeakReference(aFInAppEventType);
        this.values.put("uid", al.AFInAppEventType(weakReference));
        this.values.put("af_gcm_token", string);
        this.values.put("launch_counter", Integer.toString(ah.AFInAppEventType(this.onAppOpenAttributionNative, "appsFlyerCount", i)));
        this.values.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        String obj10 = ahVar.AFInAppEventParameterName(aFInAppEventType);
        if (obj10 != null) {
            this.values.put("channel", obj10);
        }
        bv.4 anon = new bv.4(this, ahVar);
        obj10 = new Thread(anon);
        obj10.start();
    }

    @Override // com.appsflyer.internal.cd
    public final void valueOf(String string) {
        int values;
        long currentTimeMillis;
        com.appsflyer.internal.ad adVar;
        boolean z;
        int i;
        long millis;
        if (string != null) {
            AFLogger.AFInAppEventType("Firebase Refreshed Token = ".concat(String.valueOf(string)));
            values = values();
            if (values != null) {
                if (!string.equals(values.values)) {
                    currentTimeMillis = System.currentTimeMillis();
                    if (ah.AFInAppEventType(this.onAppOpenAttributionNative)) {
                        if (values != null) {
                            values = Long.compare(z, millis) > 0 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    adVar = new ad(string, currentTimeMillis, obj2, values ^ 1);
                    valueOf(adVar);
                    if (values != 0) {
                        AFKeystoreWrapper(string);
                    }
                }
            } else {
            }
        }
    }

    @Override // com.appsflyer.internal.cd
    public com.appsflyer.internal.ad values() {
        String string;
        String string2;
        long long;
        int instance;
        int i;
        int string3;
        string2 = "afUninstallToken";
        final int i2 = 0;
        final String str = "afUninstallToken_received_time";
        int i3 = 0;
        String str2 = "afUninstallToken_queued";
        string3 = 0;
        this.onAppOpenAttributionNative.edit().putBoolean(str2, string3).apply();
        String str3 = ",";
        string3 = AppsFlyerProperties.getInstance().getString(string2);
        if (this.onAppOpenAttributionNative.getString(string2, i2) == null && string3 != null) {
            string3 = AppsFlyerProperties.getInstance().getString(string2);
            if (string3 != null) {
                String[] split = string3.split(str3);
                string = split[length2--];
            }
        }
        string2 = AppsFlyerProperties.getInstance().getString(string2);
        string2 = string2.split(str3);
        i = 2;
        if (Long.compare(long, i3) == 0 && string2 != null && string2.length >= i) {
            string2 = AppsFlyerProperties.getInstance().getString(string2);
            if (string2 != null) {
                string2 = string2.split(str3);
                i = 2;
                if (string2.length >= i) {
                    long = Long.parseLong(string2[length -= i]);
                }
            }
        }
        if (string != null) {
            ad adVar = new ad(string, long, str, this.onAppOpenAttributionNative.getBoolean(str2, string3));
            return adVar;
        }
        return i2;
    }
}
