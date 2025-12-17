package com.appsflyer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.internal.ah;
import java.net.URI;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AppsFlyerLib {
    public static com.appsflyer.AppsFlyerLib getInstance() {
        return ah.AFKeystoreWrapper();
    }

    public abstract void addPushNotificationDeepLinkPath(String... stringArr);

    public abstract void anonymizeUser(boolean z);

    public abstract void appendParametersToDeepLinkingURL(String string, Map<String, String> map2);

    public abstract void enableFacebookDeferredApplinks(boolean z);

    public abstract com.appsflyer.AppsFlyerLib enableLocationCollection(boolean z);

    public abstract String getAppsFlyerUID(Context context);

    public abstract String getAttributionId(Context context);

    public abstract String getHostName();

    public abstract String getHostPrefix();

    public abstract String getOutOfStore(Context context);

    public abstract String getSdkVersion();

    public abstract com.appsflyer.AppsFlyerLib init(String string, com.appsflyer.AppsFlyerConversionListener appsFlyerConversionListener2, Context context3);

    public abstract boolean isPreInstalledApp(Context context);

    public abstract boolean isStopped();

    public abstract void logEvent(Context context, String string2, Map<String, Object> map3);

    public abstract void logEvent(Context context, String string2, Map<String, Object> map3, AppsFlyerRequestListener appsFlyerRequestListener4);

    public abstract void logLocation(Context context, double d2, double d3);

    public abstract void logSession(Context context);

    public abstract void onPause(Context context);

    @Deprecated
    public abstract void performOnAppAttribution(Context context, URI uRI2);

    public abstract void performOnDeepLinking(Intent intent, Context context2);

    public abstract void registerConversionListener(Context context, com.appsflyer.AppsFlyerConversionListener appsFlyerConversionListener2);

    public abstract void registerValidatorListener(Context context, com.appsflyer.AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener2);

    public abstract void sendAdRevenue(Context context, Map<String, Object> map2);

    public abstract void sendPushNotificationData(Activity activity);

    public abstract void setAdditionalData(Map<String, Object> map);

    public abstract void setAndroidIdData(String string);

    public abstract void setAppId(String string);

    public abstract void setAppInviteOneLink(String string);

    public abstract void setCollectAndroidID(boolean z);

    public abstract void setCollectIMEI(boolean z);

    @Deprecated
    public abstract void setCollectOaid(boolean z);

    public abstract void setCurrencyCode(String string);

    public abstract void setCustomerIdAndLogSession(String string, Context context2);

    public abstract void setCustomerUserId(String string);

    public abstract void setDebugLog(boolean z);

    public abstract void setDisableAdvertisingIdentifiers(boolean z);

    public abstract void setExtension(String string);

    public abstract void setHost(String string, String string2);

    public abstract void setImeiData(String string);

    public abstract void setIsUpdate(boolean z);

    public abstract void setLogLevel(com.appsflyer.AFLogger.LogLevel aFLogger$LogLevel);

    public abstract void setMinTimeBetweenSessions(int i);

    public abstract void setOaidData(String string);

    public abstract void setOneLinkCustomDomain(String... stringArr);

    public abstract void setOutOfStore(String string);

    public abstract void setPartnerData(String string, Map<String, Object> map2);

    public abstract void setPhoneNumber(String string);

    public abstract void setPreinstallAttribution(String string, String string2, String string3);

    public abstract void setResolveDeepLinkURLs(String... stringArr);

    @Deprecated
    public abstract void setSharingFilter(String... stringArr);

    @Deprecated
    public abstract void setSharingFilterForAllPartners();

    public abstract void setSharingFilterForPartners(String... stringArr);

    public abstract void setUserEmails(com.appsflyer.AppsFlyerProperties.EmailsCryptType appsFlyerProperties$EmailsCryptType, String... string2Arr2);

    public abstract void setUserEmails(String... stringArr);

    public abstract void start(Context context);

    public abstract void start(Context context, String string2);

    public abstract void start(Context context, String string2, AppsFlyerRequestListener appsFlyerRequestListener3);

    public abstract void stop(boolean z, Context context2);

    public abstract void subscribeForDeepLink(DeepLinkListener deepLinkListener);

    public abstract void subscribeForDeepLink(DeepLinkListener deepLinkListener, long l2);

    public abstract void unregisterConversionListener();

    public abstract void updateServerUninstallToken(Context context, String string2);

    public abstract void validateAndLogInAppPurchase(Context context, String string2, String string3, String string4, String string5, String string6, Map<String, String> map7);

    public abstract void waitForCustomerUserId(boolean z);
}
