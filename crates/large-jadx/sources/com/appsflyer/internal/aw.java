package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class aw {

    public final Application AFInAppEventParameterName;
    public final Map<String, Object> AFInAppEventType;
    public final SharedPreferences AFKeystoreWrapper;
    public aw(Context context) {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.AFInAppEventType = concurrentHashMap;
        Context obj2 = context.getApplicationContext();
        this.AFInAppEventParameterName = (Application)obj2;
        this.AFKeystoreWrapper = ah.AFKeystoreWrapper(obj2);
    }

    public final boolean values() {
        ah.AFKeystoreWrapper();
        final int i3 = 0;
        if (ah.AFInAppEventType(this.AFKeystoreWrapper, "appsFlyerCount", i3) == 0) {
            return 1;
        }
        return i3;
    }
}
