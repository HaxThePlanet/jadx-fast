package com.appsflyer;

import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppsFlyer2dXConversionCallback implements com.appsflyer.AppsFlyerConversionListener, com.appsflyer.CreateOneLinkHttpTask.ResponseListener, DeepLinkListener {
    private void AFKeystoreWrapper(String string, String string2) {
        String str;
        int i;
        boolean obj5;
        int obj6;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", "failure");
            jSONObject.put("data", string2);
            obj6 = -1;
            str = string.hashCode();
            final int i2 = 1;
            if (str != -1390007222) {
            } else {
            }
            if (str != 1050716216) {
            } else {
            }
            if (string.equals("onInstallConversionFailure")) {
            }
            obj6 = 0;
            if (string.equals("onAttributionFailure")) {
            }
            obj6 = i2;
            if (obj6 != null) {
            }
            if (obj6 != i2) {
            } else {
            }
            onAttributionFailureNative(jSONObject);
            onInstallConversionFailureNative(jSONObject);
            string.printStackTrace();
        }
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        onAppOpenAttributionNative(map);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public native void onAppOpenAttributionNative(Object object);

    @Override // com.appsflyer.AppsFlyerConversionListener
    public void onAttributionFailure(String string) {
        AFKeystoreWrapper("onInstallConversionFailure", string);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public native void onAttributionFailureNative(Object object);

    @Override // com.appsflyer.AppsFlyerConversionListener
    public void onConversionDataFail(String string) {
        AFKeystoreWrapper("onAttributionFailure", string);
    }

    public void onConversionDataSuccess(Map<String, Object> map) {
        onInstallConversionDataLoadedNative(map);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public void onDeepLinking(DeepLinkResult deepLinkResult) {
        onDeepLinkingNative(deepLinkResult);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public native void onDeepLinkingNative(DeepLinkResult deepLinkResult);

    @Override // com.appsflyer.AppsFlyerConversionListener
    public native void onInstallConversionDataLoadedNative(Object object);

    @Override // com.appsflyer.AppsFlyerConversionListener
    public native void onInstallConversionFailureNative(Object object);

    @Override // com.appsflyer.AppsFlyerConversionListener
    public void onResponse(String string) {
        onResponseNative(string);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public void onResponseError(String string) {
        onResponseErrorNative(string);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public native void onResponseErrorNative(String string);

    @Override // com.appsflyer.AppsFlyerConversionListener
    public native void onResponseNative(String string);
}
