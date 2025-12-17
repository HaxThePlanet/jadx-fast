package com.appsflyer.internal;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerClient.Builder;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class cn extends com.appsflyer.internal.cq {

    public final Map<String, Object> AFInAppEventType;
    public cn(Runnable runnable) {
        super("google", runnable);
        HashMap obj2 = new HashMap();
        this.AFInAppEventType = obj2;
    }

    private static boolean AFInAppEventType(Context context) {
        ah.AFKeystoreWrapper();
        final int i2 = 0;
        if (ah.AFInAppEventType(ah.AFKeystoreWrapper(context), "appsFlyerCount", i2) > 0) {
            AFLogger.AFKeystoreWrapper("Install referrer will not load, the counter > 1, ");
            return i2;
        }
        String str2 = "com.android.installreferrer.api.InstallReferrerClient";
        Class.forName("com.android.installreferrer.api.InstallReferrerClient");
        if (ab.AFInAppEventParameterName(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
            AFLogger.values("Install referrer is allowed");
            return 1;
        }
        AFLogger.values("Install referrer is not allowed");
        return i2;
    }

    @Override // com.appsflyer.internal.cq
    public final void values(Context context) {
        if (!cn.AFInAppEventType(context)) {
        }
        valueOf();
        InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
        AFLogger.values("Connecting to Install Referrer Library...");
        cn.1 anon = new cn.1(this, context, build);
        build.startConnection(anon);
    }
}
