package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.oaid.OaidClient;
import com.appsflyer.oaid.OaidClient.Info;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.e;
import java.util.Map;

/* loaded from: classes.dex */
public final class ac {

    static Boolean AFInAppEventParameterName;
    static String AFInAppEventType;
    public final boolean values;
    public static com.appsflyer.internal.a.d.a AFInAppEventType(ContentResolver contentResolver) {
        String fALSE;
        int aVar;
        String str2;
        String str;
        Object obj4;
        aVar = 0;
        if (!ac.AFKeystoreWrapper()) {
            return aVar;
        }
        if (contentResolver == null) {
            return aVar;
        }
        if (AppsFlyerProperties.getInstance().getString("amazon_aid") == null && "Amazon".equals(Build.MANUFACTURER)) {
            if ("Amazon".equals(Build.MANUFACTURER)) {
                str2 = 2;
                fALSE = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", str2);
                str = "advertising_id";
                if (fALSE == 0) {
                    aVar = new a.d.a(Settings.Secure.getString(contentResolver, str), Boolean.FALSE);
                } else {
                    if (fALSE == str2) {
                    } else {
                        obj4 = Settings.Secure.getString(contentResolver, str);
                        aVar = new a.d.a(obj4, Boolean.TRUE);
                    }
                }
            }
        }
        return aVar;
    }

    private static boolean AFKeystoreWrapper() {
        Boolean aFInAppEventParameterName;
        aFInAppEventParameterName = ac.AFInAppEventParameterName;
        if (aFInAppEventParameterName != null && aFInAppEventParameterName.booleanValue()) {
            if (aFInAppEventParameterName.booleanValue()) {
            }
            return 0;
        }
        return 1;
    }

    public static com.appsflyer.internal.a.d.a valueOf(Context context, Map<String, Object> map2) {
        String str;
        String valueOf;
        Throwable th2;
        int length;
        int i;
        Throwable th3;
        Boolean valueOf2;
        Object stringBuilder;
        int str2;
        Throwable string3;
        boolean limitAdTrackingEnabled;
        Throwable string2;
        String string;
        String localizedMessage;
        String str3;
        Throwable th;
        boolean obj12;
        str = "advertiserIdEnabled";
        valueOf = "advertiserId";
        if (!ac.AFKeystoreWrapper()) {
            return null;
        }
        AFLogger.AFInAppEventType("Trying to fetch GAID..");
        length = 0;
        stringBuilder = new StringBuilder();
        int i4 = -1;
        int i5 = 1;
        Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        if (advertisingIdInfo == null) {
        } else {
            string = advertisingIdInfo.getId();
            valueOf2 = Boolean.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled());
            if (string != null) {
                if (string.length() == 0) {
                    stringBuilder.append("emptyOrNull |");
                }
            } else {
            }
            i = i5;
            if (context.getClass().getName().equals("android.app.ReceiverRestrictedContext")) {
                string = AppsFlyerProperties.getInstance().getString(valueOf);
                valueOf2 = Boolean.valueOf(obj12 ^= i5);
                stringBuilder.append("context = android.app.ReceiverRestrictedContext |");
            }
            if (stringBuilder.length() > 0) {
                obj12 = new StringBuilder();
                obj12.append(e.o().g(context));
                obj12.append(": ");
                obj12.append(stringBuilder);
                map2.put("gaidError", obj12.toString());
            }
            try {
                if (string != null && valueOf2 != null) {
                }
                if (valueOf2 != null) {
                }
                map2.put(valueOf, string);
                map2.put(str, String.valueOf(obj12 ^= i5));
                AppsFlyerProperties.getInstance().set(valueOf, string);
                AppsFlyerProperties.getInstance().set(str, String.valueOf(booleanValue ^= i5));
                map2.put("isGaidWithGps", String.valueOf(i));
                obj12 = new a.d.a(string, valueOf2);
                return obj12;
            } catch (Throwable th) {
            }
        }
        stringBuilder.append("gpsAdInfo-null |");
        IllegalStateException illegalStateException = new IllegalStateException("GpsAdIndo is null");
        throw illegalStateException;
    }

    public static com.appsflyer.internal.a.d.a values(Context context) {
        Object instance;
        Object obj;
        String aFInAppEventType;
        OaidClient aFInAppEventParameterName;
        int i;
        Context obj5;
        instance = AppsFlyerProperties.getInstance();
        final int i2 = 1;
        i = ac.AFInAppEventType != null ? i2 : 0;
        final int i3 = 0;
        if (i != 0) {
            obj5 = i3;
        } else {
            aFInAppEventParameterName = ac.AFInAppEventParameterName;
            if (aFInAppEventParameterName != null) {
                if (!aFInAppEventParameterName.booleanValue()) {
                    aFInAppEventParameterName = new OaidClient(context);
                    aFInAppEventParameterName.setLogging(instance.isEnableLog());
                    obj5 = aFInAppEventParameterName.fetch();
                    if (ac.AFInAppEventParameterName == null && instance.getBoolean("collectOAID", i2) && obj5 != null) {
                        if (instance.getBoolean("collectOAID", i2)) {
                            aFInAppEventParameterName = new OaidClient(context);
                            aFInAppEventParameterName.setLogging(instance.isEnableLog());
                            obj5 = aFInAppEventParameterName.fetch();
                            if (obj5 != null) {
                                obj5 = obj5.getLat();
                                aFInAppEventType = instance;
                            } else {
                                aFInAppEventType = obj5;
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
        if (aFInAppEventType != null) {
            a.d.a aVar = new a.d.a(aFInAppEventType, obj5);
            aVar.AFInAppEventType = Boolean.valueOf(i);
            return aVar;
        }
        return i3;
    }

    public final boolean equals(Object object) {
        Class<com.appsflyer.internal.ac> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (ac.class != object.getClass()) {
            } else {
                if (this.values != object.values) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final int hashCode() {
        return values + 0;
    }
}
