package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.deeplink.DeepLinkResult.Error;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ar {
    public static void AFInAppEventType(String string, DeepLinkResult.Error deepLinkResult$Error2) {
        if (hVar.values != null) {
            AFLogger.values("[DDL] Error occurred: ".concat(String.valueOf(string)));
            DeepLinkResult obj1 = new DeepLinkResult(0, error2);
            ar.AFKeystoreWrapper(obj1);
        }
        ar.valueOf(string);
    }

    private static void AFInAppEventType(Map<String, String> map) {
        AppsFlyerConversionListener aFInAppEventType;
        Map obj2;
        if (ah.AFInAppEventType != null) {
            StringBuilder stringBuilder = new StringBuilder("Calling onAppOpenAttribution with:\n");
            stringBuilder.append(map.toString());
            AFLogger.values(stringBuilder.toString());
            ah.AFInAppEventType.onAppOpenAttribution(map);
        }
    }

    static void AFKeystoreWrapper(DeepLinkResult deepLinkResult) {
        if (hVar.values != null) {
            StringBuilder stringBuilder = new StringBuilder("[DDL] Calling onDeepLinking with:\n");
            stringBuilder.append(deepLinkResult.toString());
            AFLogger.values(stringBuilder.toString());
            hVar2.values.onDeepLinking(deepLinkResult);
        }
        AFLogger.values("[DDL] skipping, no callback registered");
    }

    private static void valueOf(String string) {
        AppsFlyerConversionListener aFInAppEventType;
        Object obj2;
        if (ah.AFInAppEventType != null) {
            AFLogger.values("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(string)));
            ah.AFInAppEventType.onAttributionFailure(string);
        }
    }

    public static void valueOf(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        DeepLink obj4;
        if (hVar.values != null) {
            obj4 = DeepLink.AFKeystoreWrapper(map);
            obj4.values.put("is_deferred", false);
            deepLinkResult = new DeepLinkResult(obj4, 0);
            ar.AFKeystoreWrapper(deepLinkResult);
        }
        ar.AFInAppEventType(map);
    }
}
