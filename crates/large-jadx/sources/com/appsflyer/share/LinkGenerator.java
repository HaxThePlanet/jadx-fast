package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.CreateOneLinkHttpTask.ResponseListener;
import com.appsflyer.internal.ah;
import com.appsflyer.internal.cr;
import com.appsflyer.internal.k;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class LinkGenerator {

    private String AFInAppEventParameterName;
    private final String AFInAppEventType;
    String AFKeystoreWrapper;
    private String AFLogger$LogLevel;
    private String AFVersionDeclaration;
    private String AppsFlyer2dXConversionCallback;
    private String getLevel;
    private String init;
    private String onAppOpenAttributionNative;
    private final Map<String, String> onAttributionFailureNative;
    private String onDeepLinkingNative;
    private final Map<String, String> onInstallConversionDataLoadedNative;
    String valueOf;
    private String values;
    public LinkGenerator(String string) {
        super();
        HashMap hashMap = new HashMap();
        this.onAttributionFailureNative = hashMap;
        HashMap hashMap2 = new HashMap();
        this.onInstallConversionDataLoadedNative = hashMap2;
        this.AFInAppEventType = string;
    }

    private static String AFInAppEventParameterName(Map<String, String> map) {
        Object value;
        int i2;
        int i;
        Object key;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator obj4 = map.entrySet().iterator();
        while (obj4.hasNext()) {
            Object next2 = obj4.next();
            if (stringBuilder.length() == 0) {
            } else {
            }
            stringBuilder.append('&');
            stringBuilder.append(LinkGenerator.valueOf((String)(Map.Entry)next2.getKey(), (String)next2.getKey()));
            stringBuilder.append('=');
            stringBuilder.append((String)next2.getValue());
            stringBuilder.append('?');
        }
        return stringBuilder.toString();
    }

    private Map<String, String> AFKeystoreWrapper() {
        String aFVersionDeclaration;
        String aFInAppEventParameterName;
        String appsFlyer2dXConversionCallback;
        String valueOf3;
        String valueOf2;
        String getLevel;
        String onAppOpenAttributionNative;
        String valueOf;
        String aFLogger$LogLevel;
        String str;
        String value2;
        Object value;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.onInstallConversionDataLoadedNative.clear();
        str = "pid";
        this.onInstallConversionDataLoadedNative.put(str, this.AFInAppEventType);
        linkedHashMap.put(str, LinkGenerator.valueOf(this.AFInAppEventType, "media source"));
        aFVersionDeclaration = this.AFVersionDeclaration;
        if (aFVersionDeclaration != null) {
            str = "af_referrer_uid";
            this.onInstallConversionDataLoadedNative.put(str, aFVersionDeclaration);
            linkedHashMap.put(str, LinkGenerator.valueOf(this.AFVersionDeclaration, "referrerUID"));
        }
        aFInAppEventParameterName = this.AFInAppEventParameterName;
        if (aFInAppEventParameterName != null) {
            str = "af_channel";
            this.onInstallConversionDataLoadedNative.put(str, aFInAppEventParameterName);
            linkedHashMap.put(str, LinkGenerator.valueOf(this.AFInAppEventParameterName, "channel"));
        }
        appsFlyer2dXConversionCallback = this.AppsFlyer2dXConversionCallback;
        if (appsFlyer2dXConversionCallback != null) {
            str = "af_referrer_customer_id";
            this.onInstallConversionDataLoadedNative.put(str, appsFlyer2dXConversionCallback);
            linkedHashMap.put(str, LinkGenerator.valueOf(this.AppsFlyer2dXConversionCallback, "referrerCustomerId"));
        }
        valueOf3 = this.values;
        if (valueOf3 != null) {
            str = "c";
            this.onInstallConversionDataLoadedNative.put(str, valueOf3);
            linkedHashMap.put(str, LinkGenerator.valueOf(this.values, "campaign"));
        }
        valueOf2 = this.init;
        if (valueOf2 != null) {
            str = "af_referrer_name";
            this.onInstallConversionDataLoadedNative.put(str, valueOf2);
            linkedHashMap.put(str, LinkGenerator.valueOf(this.init, "referrerName"));
        }
        getLevel = this.getLevel;
        if (getLevel != null) {
            str = "af_referrer_image_url";
            this.onInstallConversionDataLoadedNative.put(str, getLevel);
            linkedHashMap.put(str, LinkGenerator.valueOf(this.getLevel, "referrerImageURL"));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.onAppOpenAttributionNative);
        aFLogger$LogLevel = this.AFLogger$LogLevel;
        this.AFLogger$LogLevel = aFLogger$LogLevel.replaceFirst("^[/]", "");
        str = "/";
        if (this.onAppOpenAttributionNative != null && aFLogger$LogLevel != null && !this.onAppOpenAttributionNative.endsWith(str)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.onAppOpenAttributionNative);
            aFLogger$LogLevel = this.AFLogger$LogLevel;
            if (aFLogger$LogLevel != null) {
                this.AFLogger$LogLevel = aFLogger$LogLevel.replaceFirst("^[/]", "");
                str = "/";
                if (!this.onAppOpenAttributionNative.endsWith(str)) {
                    value2 = str;
                }
                stringBuilder.append(value2);
                stringBuilder.append(this.AFLogger$LogLevel);
            }
            String string = stringBuilder.toString();
            str = "af_dp";
            this.onInstallConversionDataLoadedNative.put(str, string);
            linkedHashMap.put(str, LinkGenerator.valueOf(string, "deepLink"));
        }
        Iterator iterator = this.onAttributionFailureNative.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            this.onInstallConversionDataLoadedNative.put(next2.getKey(), next2.getValue());
            linkedHashMap.put(next2.getKey(), LinkGenerator.valueOf((String)next2.getValue(), (String)next2.getKey()));
        }
        return linkedHashMap;
    }

    private static String valueOf(String string, String string2) {
        final String str = "";
        return URLEncoder.encode(string, "utf8");
    }

    public com.appsflyer.share.LinkGenerator addParameter(String string, String string2) {
        this.onAttributionFailureNative.put(string, string2);
        return this;
    }

    public com.appsflyer.share.LinkGenerator addParameters(Map<String, String> map) {
        Map onAttributionFailureNative;
        if (map != null) {
            this.onAttributionFailureNative.putAll(map);
        }
        return this;
    }

    public String generateLink() {
        String aFKeystoreWrapper;
        String aFKeystoreWrapper2;
        String valueOf;
        String arr;
        int i;
        String hostName;
        StringBuilder stringBuilder = new StringBuilder();
        aFKeystoreWrapper = this.AFKeystoreWrapper;
        if (aFKeystoreWrapper != null && aFKeystoreWrapper.startsWith("http")) {
            if (aFKeystoreWrapper.startsWith("http")) {
                stringBuilder.append(this.AFKeystoreWrapper);
            } else {
                arr = new Object[2];
                stringBuilder.append(String.format(cr.valueOf, AppsFlyerLib.getInstance().getHostPrefix(), ah.AFKeystoreWrapper().getHostName()));
            }
        } else {
        }
        if (this.valueOf != null) {
            stringBuilder.append('/');
            stringBuilder.append(this.valueOf);
        }
        stringBuilder.append(LinkGenerator.AFInAppEventParameterName(AFKeystoreWrapper()));
        return stringBuilder.toString();
    }

    public void generateLink(Context context, CreateOneLinkHttpTask.ResponseListener createOneLinkHttpTask$ResponseListener2) {
        k obj7;
        AFKeystoreWrapper();
        if (AppsFlyerProperties.getInstance().getBoolean("waitForCustomerId", false)) {
            AFLogger.valueOf("CustomerUserId not set, generate User Invite Link is disabled", true);
        }
        CreateOneLinkHttpTask createOneLinkHttpTask = new CreateOneLinkHttpTask(AppsFlyerProperties.getInstance().getString("oneLinkSlug"), this.onInstallConversionDataLoadedNative, ah.AFKeystoreWrapper(), context);
        createOneLinkHttpTask.values = responseListener2;
        createOneLinkHttpTask.valueOf = this.onDeepLinkingNative;
        if (k.AFKeystoreWrapper == null) {
            obj7 = new k();
            k.AFKeystoreWrapper = obj7;
        }
        k.AFKeystoreWrapper.AFKeystoreWrapper().execute(createOneLinkHttpTask);
    }

    public String getBrandDomain() {
        return this.onDeepLinkingNative;
    }

    public String getCampaign() {
        return this.values;
    }

    public String getChannel() {
        return this.AFInAppEventParameterName;
    }

    public String getMediaSource() {
        return this.AFInAppEventType;
    }

    public Map<String, String> getUserParams() {
        HashMap hashMap = new HashMap(this.onAttributionFailureNative);
        return hashMap;
    }

    public com.appsflyer.share.LinkGenerator setBaseDeeplink(String string) {
        this.onAppOpenAttributionNative = string;
        return this;
    }

    public com.appsflyer.share.LinkGenerator setBaseURL(String string, String string2, String string3) {
        String str;
        int length;
        String obj6;
        String obj7;
        int obj8;
        final String str2 = "https://%s/%s";
        final int i = 1;
        final int i2 = 0;
        str = 2;
        if (string != null) {
            if (string.length() <= 0) {
                obj6 = new Object[str];
                obj7 = new Object[str];
                obj7[i2] = AppsFlyerLib.getInstance().getHostPrefix();
                obj7[i] = ah.AFKeystoreWrapper().getHostName();
                obj6[i2] = String.format("%sapp.%s", obj7);
                obj6[i] = string3;
                this.AFKeystoreWrapper = String.format(str2, obj6);
            } else {
                if (string2 != null) {
                    if (string2.length() < 5) {
                        obj7 = "go.onelink.me";
                    }
                } else {
                }
                obj8 = new Object[str];
                obj8[i2] = obj7;
                obj8[i] = string;
                this.AFKeystoreWrapper = String.format(str2, obj8);
            }
        } else {
        }
        return this;
    }

    public com.appsflyer.share.LinkGenerator setBrandDomain(String string) {
        this.onDeepLinkingNative = string;
        return this;
    }

    public com.appsflyer.share.LinkGenerator setCampaign(String string) {
        this.values = string;
        return this;
    }

    public com.appsflyer.share.LinkGenerator setChannel(String string) {
        this.AFInAppEventParameterName = string;
        return this;
    }

    public com.appsflyer.share.LinkGenerator setDeeplinkPath(String string) {
        this.AFLogger$LogLevel = string;
        return this;
    }

    public com.appsflyer.share.LinkGenerator setReferrerCustomerId(String string) {
        this.AppsFlyer2dXConversionCallback = string;
        return this;
    }

    public com.appsflyer.share.LinkGenerator setReferrerImageURL(String string) {
        this.getLevel = string;
        return this;
    }

    public com.appsflyer.share.LinkGenerator setReferrerName(String string) {
        this.init = string;
        return this;
    }

    public com.appsflyer.share.LinkGenerator setReferrerUID(String string) {
        this.AFVersionDeclaration = string;
        return this;
    }
}
