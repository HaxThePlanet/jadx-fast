package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerProperties;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class an {

    public static com.appsflyer.internal.an values;
    boolean AFInAppEventParameterName = true;
    private Map<String, Object> AFInAppEventType;
    private List<String> AFKeystoreWrapper;
    private String AFLogger$LogLevel;
    private int AFVersionDeclaration = 0;
    private boolean AppsFlyer2dXConversionCallback = false;
    private boolean valueOf = true;
    public an() {
        super();
        ArrayList arrayList = new ArrayList();
        this.AFKeystoreWrapper = arrayList;
        this.AFLogger$LogLevel = "-1";
        i ^= boolean;
    }

    private void AFInAppEventParameterName(String string, String string2, String string3, String string4) {
        int aFInAppEventType;
        String str;
        Object obj3;
        Object obj4;
        synchronized (this) {
            if (string.length() > 0) {
                this.AFInAppEventType.put("app_id", string);
            }
            try {
                if (string2 != null && string2.length() > 0) {
                }
                if (string2.length() > 0) {
                }
                this.AFInAppEventType.put("app_version", string2);
                if (string3 != null && string3.length() > 0) {
                }
                if (string3.length() > 0) {
                }
                this.AFInAppEventType.put("channel", string3);
                if (string4 != null && string4.length() > 0) {
                }
                if (string4.length() > 0) {
                }
                this.AFInAppEventType.put("preInstall", string4);
            }
        }
    }

    private boolean getLevel() {
        boolean aFInAppEventParameterName;
        if (this.AFInAppEventParameterName && !this.valueOf && this.AppsFlyer2dXConversionCallback != null) {
            if (!this.valueOf) {
                if (this.AppsFlyer2dXConversionCallback != null) {
                }
            }
            return 1;
        }
        return 0;
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        this.AFKeystoreWrapper = arrayList;
        this.AFVersionDeclaration = 0;
        return;
        synchronized (this) {
            arrayList = new ArrayList();
            this.AFKeystoreWrapper = arrayList;
            this.AFVersionDeclaration = 0;
        }
    }

    private void values(String string, String string2, String string3) {
        Map aFInAppEventType;
        String str;
        Object obj4;
        Object obj5;
        this.AFInAppEventType.put("brand", Build.BRAND);
        this.AFInAppEventType.put("model", Build.MODEL);
        this.AFInAppEventType.put("platform", "Android");
        this.AFInAppEventType.put("platform_version", Build.VERSION.RELEASE);
        synchronized (this) {
            try {
                if (string.length() > 0) {
                }
                this.AFInAppEventType.put("advertiserId", string);
                if (string2 != null && string2.length() > 0) {
                }
                if (string2.length() > 0) {
                }
                this.AFInAppEventType.put("imei", string2);
                if (string3 != null && string3.length() > 0) {
                }
                if (string3.length() > 0) {
                }
                this.AFInAppEventType.put("android_id", string3);
            }
        }
    }

    private void values(String string, String string2, String string3, String string4) {
        Object aFInAppEventType;
        Object obj3;
        Object obj4;
        this.AFInAppEventType.put("sdk_version", string);
        synchronized (this) {
            try {
                if (string2.length() > 0) {
                }
                this.AFInAppEventType.put("devkey", string2);
                if (string3 != null && string3.length() > 0) {
                }
                if (string3.length() > 0) {
                }
                this.AFInAppEventType.put("originalAppsFlyerId", string3);
                if (string4 != null && string4.length() > 0) {
                }
                if (string4.length() > 0) {
                }
                this.AFInAppEventType.put("uid", string4);
            }
        }
    }

    public static String[] values(String string, java.lang.StackTraceElement[] stackTraceElement2Arr2) {
        int i;
        String obj3;
        final int i2 = 0;
        i = 1;
        if (stackTraceElement2Arr2 == null) {
            final String[] obj4 = new String[i];
            obj4[i2] = string;
            return obj4;
        }
        String[] strArr = new String[length += i];
        strArr[i2] = string;
        for (Object obj3 : stackTraceElement2Arr2) {
            strArr[i] = obj3.toString();
        }
        return strArr;
    }

    final void AFInAppEventParameterName() {
        Locale eNGLISH = Locale.ENGLISH;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", eNGLISH);
        int i = 0;
        AFInAppEventType("r_debugging_off", simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())), new String[i]);
        this.AppsFlyer2dXConversionCallback = i;
        this.valueOf = i;
        return;
        synchronized (this) {
            eNGLISH = Locale.ENGLISH;
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", eNGLISH);
            i = 0;
            AFInAppEventType("r_debugging_off", simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())), new String[i]);
            this.AppsFlyer2dXConversionCallback = i;
            this.valueOf = i;
        }
    }

    final Map<String, Object> AFInAppEventType() {
        this.AFInAppEventType.put("data", this.AFKeystoreWrapper);
        init();
        return this.AFInAppEventType;
        synchronized (this) {
            this.AFInAppEventType.put("data", this.AFKeystoreWrapper);
            init();
            return this.AFInAppEventType;
        }
    }

    public final void AFInAppEventType(String string, String string2, String... string3Arr3) {
        String str;
        boolean aFVersionDeclaration;
        int i;
        Object stringBuilder;
        String obj4;
        String obj5;
        synchronized (this) {
            try {
                i = 98304;
                if (this.AFVersionDeclaration >= i) {
                } else {
                }
                long currentTimeMillis = System.currentTimeMillis();
                final String obj6 = TextUtils.join(", ", string3Arr3);
                if (string != null) {
                } else {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(currentTimeMillis);
                stringBuilder.append(" ");
                stringBuilder.append(Thread.currentThread().getId());
                stringBuilder.append(" _/AppsFlyer_6.5.0 [");
                stringBuilder.append(string);
                stringBuilder.append("] ");
                stringBuilder.append(string2);
                stringBuilder.append(" ");
                stringBuilder.append(obj6);
                obj4 = stringBuilder.toString();
                obj4 = new StringBuilder();
                obj4.append(currentTimeMillis);
                obj4.append(" ");
                obj4.append(Thread.currentThread().getId());
                obj4.append(" ");
                obj4.append(string2);
                obj4.append("/AppsFlyer_6.5.0 ");
                obj4.append(obj6);
                obj4 = obj4.toString();
                this.AFKeystoreWrapper.add(obj4);
                this.AFVersionDeclaration = obj5 += obj4;
            } catch (Throwable th) {
            }
        }
    }

    final void AFKeystoreWrapper() {
        final int i = 0;
        this.AFInAppEventType = i;
        an.values = i;
        return;
        synchronized (this) {
            i = 0;
            this.AFInAppEventType = i;
            an.values = i;
        }
    }

    final boolean AFLogger$LogLevel() {
        return this.AppsFlyer2dXConversionCallback;
    }

    final void valueOf() {
        this.AppsFlyer2dXConversionCallback = true;
        final Locale eNGLISH = Locale.ENGLISH;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", eNGLISH);
        AFInAppEventType("r_debugging_on", simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        return;
        synchronized (this) {
            this.AppsFlyer2dXConversionCallback = true;
            eNGLISH = Locale.ENGLISH;
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", eNGLISH);
            AFInAppEventType("r_debugging_on", simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        }
    }

    final void valueOf(String string, PackageManager packageManager2) {
        String string4;
        String string5;
        String string2;
        String string3;
        Object obj7;
        Map obj8;
        AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
        final String str = "remote_debug_static_data";
        string4 = instance.getString(str);
        synchronized (this) {
            try {
                obj7 = new JSONObject(string4);
                this.AFInAppEventType = n.AFInAppEventType(obj7);
                HashMap hashMap = new HashMap();
                this.AFInAppEventType = hashMap;
                com.appsflyer.internal.ah ahVar = ah.AFKeystoreWrapper();
                values(instance.getString("advertiserId"), ahVar.init, ahVar.AFVersionDeclaration);
                StringBuilder stringBuilder = new StringBuilder("6.5.0.");
                stringBuilder.append(ah.AFKeystoreWrapper);
                values(stringBuilder.toString(), instance.getDevKey(), instance.getString("KSAppsFlyerId"), instance.getString("uid"));
                AFInAppEventParameterName(string, String.valueOf(obj8.versionCode), instance.getString("channel"), instance.getString("preInstallName"));
                obj7 = new JSONObject(this.AFInAppEventType);
                instance.set(str, obj7.toString());
                this.AFInAppEventType.put("launch_counter", this.AFLogger$LogLevel);
                throw string;
            } catch (Throwable th) {
            }
        }
    }

    final void values() {
        this.valueOf = false;
        init();
        return;
        synchronized (this) {
            this.valueOf = false;
            init();
        }
    }

    final void values(String string) {
        this.AFLogger$LogLevel = string;
        return;
        synchronized (this) {
            this.AFLogger$LogLevel = string;
        }
    }
}
