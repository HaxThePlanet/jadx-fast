package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appsflyer.internal.ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppsFlyerProperties {

    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    private static final com.appsflyer.AppsFlyerProperties AFInAppEventType = null;
    public static final String AF_WAITFOR_CUSTOMERID = "waitForCustomerId";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_ANDROID_ID_FORCE_BY_USER = "collectAndroidIdForceByUser";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_IMEI_FORCE_BY_USER = "collectIMEIForceByUser";
    public static final String COLLECT_OAID = "collectOAID";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_KEYSTORE = "keyPropDisableAFKeystore";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String DPM = "disableProxy";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String EXTENSION = "sdkExtension";
    public static final String HTTP_CACHE = "http_cache";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String LAUNCH_PROTECT_ENABLED = "launchProtectEnabled";
    public static final String NEW_REFERRER_SENT = "newGPReferrerSent";
    public static final String ONELINK_DOMAIN = "onelinkDomain";
    public static final String ONELINK_ID = "oneLinkSlug";
    public static final String ONELINK_SCHEME = "onelinkScheme";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_EMAILS = "userEmails";
    public static final String USE_HTTP_FALLBACK = "useHttpFallback";
    public boolean AFInAppEventParameterName;
    private String AFKeystoreWrapper;
    private boolean AFLogger$LogLevel = false;
    public String valueOf;
    private final Map<String, Object> values;

    public static enum EmailsCryptType {

        NONE(false),
        SHA256(3);

        private final int values;
        @Override // java.lang.Enum
        public final int getValue() {
            return this.values;
        }
    }
    static {
        AppsFlyerProperties appsFlyerProperties = new AppsFlyerProperties();
        AppsFlyerProperties.AFInAppEventType = appsFlyerProperties;
    }

    private AppsFlyerProperties() {
        super();
        HashMap hashMap = new HashMap();
        this.values = hashMap;
        int i = 0;
    }

    private boolean AFInAppEventParameterName() {
        return this.AFLogger$LogLevel;
    }

    public static com.appsflyer.AppsFlyerProperties getInstance() {
        return AppsFlyerProperties.AFInAppEventType;
    }

    public final boolean AFInAppEventType() {
        return this.AFInAppEventParameterName;
    }

    public boolean getBoolean(String string, boolean z2) {
        String obj1 = getString(string);
        if (obj1 == null) {
            return z2;
        }
        return Boolean.parseBoolean(obj1);
    }

    public String getDevKey() {
        return this.AFKeystoreWrapper;
    }

    public int getInt(String string, int i2) {
        String obj1 = getString(string);
        if (obj1 == null) {
            return i2;
        }
        return Integer.parseInt(obj1);
    }

    public long getLong(String string, long l2) {
        String obj1 = getString(string);
        if (obj1 == null) {
            return l2;
        }
        return Long.parseLong(obj1);
    }

    public Object getObject(String string) {
        return this.values.get(string);
        synchronized (this) {
            return this.values.get(string);
        }
    }

    public String getReferrer(Context context) {
        String valueOf = this.valueOf;
        if (valueOf != null) {
            return valueOf;
        }
        String str = "AF_REFERRER";
        if (getString(str) != null) {
            return getString(str);
        }
        int i = 0;
        if (context == null) {
            return i;
        }
        return ah.AFKeystoreWrapper(context).getString("referrer", i);
    }

    public String getString(String string) {
        return (String)this.values.get(string);
        synchronized (this) {
            return (String)this.values.get(string);
        }
    }

    public boolean isEnableLog() {
        com.appsflyer.AFLogger.LogLevel nONE = AFLogger.LogLevel.NONE;
        if (getInt("logLevel", nONE.getLevel()) > nONE.getLevel()) {
            return 1;
        }
        return 0;
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean("disableLogs", false);
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean("disableOtherSdk", false);
    }

    public void loadProperties(Context context) {
        boolean values;
        String aFLogger$LogLevel;
        String str;
        Object next;
        Object values2;
        String string;
        int obj6;
        synchronized (this) {
            try {
                obj6 = ah.AFKeystoreWrapper(context);
                aFLogger$LogLevel = obj6.getString("savedProperties", 0);
                if (aFLogger$LogLevel != null) {
                }
                AFLogger.values("Loading properties..");
                JSONObject jSONObject = new JSONObject(aFLogger$LogLevel);
                Iterator keys = jSONObject.keys();
            } catch (org.json.JSONException jSON) {
            } catch (Throwable th1) {
            }
        }
    }

    public void remove(String string) {
        this.values.remove(string);
        return;
        synchronized (this) {
            this.values.remove(string);
        }
    }

    public void saveProperties(SharedPreferences sharedPreferences) {
        this.values.remove("AppsFlyerKey");
        JSONObject jSONObject = new JSONObject(this.values);
        sharedPreferences.edit().putString("savedProperties", jSONObject.toString()).apply();
        return;
        synchronized (this) {
            this.values.remove("AppsFlyerKey");
            jSONObject = new JSONObject(this.values);
            sharedPreferences.edit().putString("savedProperties", jSONObject.toString()).apply();
        }
    }

    public void set(String string, int i2) {
        this.values.put(string, Integer.toString(i2));
        return;
        synchronized (this) {
            this.values.put(string, Integer.toString(i2));
        }
    }

    public void set(String string, long l2) {
        this.values.put(string, Long.toString(l2));
        return;
        synchronized (this) {
            this.values.put(string, Long.toString(l2));
        }
    }

    public void set(String string, String string2) {
        this.values.put(string, string2);
        return;
        synchronized (this) {
            this.values.put(string, string2);
        }
    }

    public void set(String string, boolean z2) {
        this.values.put(string, Boolean.toString(z2));
        return;
        synchronized (this) {
            this.values.put(string, Boolean.toString(z2));
        }
    }

    public void set(String string, String[] string2Arr2) {
        this.values.put(string, string2Arr2);
        return;
        synchronized (this) {
            this.values.put(string, string2Arr2);
        }
    }

    public void setCustomData(String string) {
        this.values.put("additionalCustomData", string);
        return;
        synchronized (this) {
            this.values.put("additionalCustomData", string);
        }
    }

    public void setDevKey(String string) {
        this.AFKeystoreWrapper = string;
    }

    public void setUserEmails(String string) {
        this.values.put("userEmails", string);
        return;
        synchronized (this) {
            this.values.put("userEmails", string);
        }
    }
}
