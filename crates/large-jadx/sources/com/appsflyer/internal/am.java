package com.appsflyer.internal;

import com.appsflyer.AFLogger;

/* loaded from: classes.dex */
final class am {

    private final com.appsflyer.internal.am.a AFKeystoreWrapper;

    interface a {
        public abstract Class<?> valueOf(String string);
    }

    static enum e {

        ADOBE_AIR("android_adobe_air", "com.appsflyer.adobeair.AppsFlyerExtension"),
        ADOBE_MOBILE_SDK("com.appsflyer.adobeair.AppsFlyerExtension", "com.appsflyer.adobeextension.AppsFlyerAdobeExtension"),
        COCOS2DX("com.appsflyer.adobeextension.AppsFlyerAdobeExtension", "org.cocos2dx.lib.Cocos2dxActivity"),
        CORDOVA("org.cocos2dx.lib.Cocos2dxActivity", "com.appsflyer.cordova.plugin.AppsFlyerPlugin"),
        DEFAULT("com.appsflyer.cordova.plugin.AppsFlyerPlugin", "com.appsflyer.cordova.plugin.AppsFlyerPlugin"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin"),
        M_PARTICLE("com.appsflyer.appsflyersdk.AppsflyerSdkPlugin", "com.mparticle.kits.AppsFlyerKit"),
        NATIVE_SCRIPT("com.mparticle.kits.AppsFlyerKit", "com.tns.NativeScriptActivity"),
        REACT_NATIVE("com.tns.NativeScriptActivity", "com.appsflyer.reactnative.RNAppsFlyerModule"),
        SEGMENT("com.appsflyer.reactnative.RNAppsFlyerModule", "com.segment.analytics.android.integrations.appsflyer.AppsflyerIntegration"),
        UNITY("com.segment.analytics.android.integrations.appsflyer.AppsflyerIntegration", "com.appsflyer.unity.AppsFlyerAndroidWrapper"),
        UNREAL_ENGINE("com.appsflyer.unity.AppsFlyerAndroidWrapper", "com.appsflyer.reactnative.RNAppsFlyerModule"),
        XAMARIN("com.appsflyer.unity.AppsFlyerAndroidWrapper", "com.segment.analytics.android.integrations.appsflyer.AppsflyerIntegration"),
        CAPACITOR("com.appsflyer.unity.AppsFlyerAndroidWrapper", "com.appsflyer.reactnative.RNAppsFlyerModule");

        private final String onAppOpenAttribution;
        private final String onAttributionFailureNative;
        static String AFInAppEventType(com.appsflyer.internal.am.e am$e) {
            return e.onAppOpenAttribution;
        }

        static String valueOf(com.appsflyer.internal.am.e am$e) {
            return e.onAttributionFailureNative;
        }
    }
    am() {
        super();
        am.1 anon = new am.1();
        this.AFKeystoreWrapper = anon;
    }

    private boolean AFInAppEventType(String string) {
        final int i = 0;
        this.AFKeystoreWrapper.valueOf(string);
        StringBuilder stringBuilder = new StringBuilder("Class: ");
        stringBuilder.append(string);
        stringBuilder.append(" is found.");
        AFLogger.AFKeystoreWrapper(stringBuilder.toString());
        return 1;
    }

    final String AFInAppEventParameterName() {
        int i;
        com.appsflyer.internal.am.e eVar;
        boolean z;
        com.appsflyer.internal.am.e[] values = am.e.values();
        i = 0;
        while (i < values.length) {
            eVar = values[i];
            i++;
        }
        return am.e.valueOf(am.e.AFInAppEventType);
    }
}
