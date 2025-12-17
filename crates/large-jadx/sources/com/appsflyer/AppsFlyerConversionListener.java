package com.appsflyer;

import java.util.Map;

/* loaded from: classes.dex */
public interface AppsFlyerConversionListener {
    public abstract void onAppOpenAttribution(Map<String, String> map);

    public abstract void onAttributionFailure(String string);

    public abstract void onConversionDataFail(String string);

    public abstract void onConversionDataSuccess(Map<String, Object> map);
}
