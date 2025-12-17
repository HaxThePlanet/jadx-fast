package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class i {

    AppsFlyerRequestListener AFInAppEventParameterName;
    public Application AFInAppEventType;
    String AFKeystoreWrapper;
    public String AFLogger$LogLevel;
    String AFVersionDeclaration;
    String AppsFlyer2dXConversionCallback;
    String getLevel;
    byte[] init;
    private final boolean onAppOpenAttributionNative;
    public int onDeepLinkingNative;
    public String onInstallConversionDataLoadedNative;
    boolean onInstallConversionFailureNative;
    Map<String, Object> valueOf;
    public final Map<String, Object> values;
    public i() {
        final int i = 0;
        super(i, i, i, i);
    }

    public i(String string, String string2, Boolean boolean3, Context context4) {
        boolean obj2;
        super();
        HashMap hashMap = new HashMap();
        this.values = hashMap;
        this.AFVersionDeclaration = string;
        this.onInstallConversionDataLoadedNative = string2;
        if (boolean3 != null) {
            obj2 = boolean3.booleanValue();
        } else {
            obj2 = 1;
        }
        this.onAppOpenAttributionNative = obj2;
        if (context4 != null) {
            this.AFInAppEventType = (Application)context4.getApplicationContext();
        }
    }

    public final boolean AFInAppEventParameterName() {
        return this.onAppOpenAttributionNative;
    }

    protected final String AFInAppEventType(String string) {
        Object aFInAppEventType;
        String obj3;
        String str = ah.AFKeystoreWrapper().AFInAppEventParameterName(this.AFInAppEventType);
        if (str != null) {
            obj3 = Uri.parse(string).buildUpon().appendQueryParameter("channel", str).build().toString();
        }
        return obj3;
    }

    final byte[] AFInAppEventType() {
        return this.init;
    }

    public final Map<String, Object> AFKeystoreWrapper() {
        return this.values;
    }

    public final boolean valueOf() {
        return this.onInstallConversionFailureNative;
    }

    public com.appsflyer.internal.i values(String string) {
        this.onInstallConversionDataLoadedNative = string;
        return this;
    }

    protected final com.appsflyer.internal.i values(Map<String, ?> map) {
        this.values.putAll(map);
        return this;
    }
}
