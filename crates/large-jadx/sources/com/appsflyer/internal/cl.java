package com.appsflyer.internal;

import android.content.Context;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class cl extends com.appsflyer.internal.cq {
    cl(String string, Runnable runnable2) {
        super(string, runnable2);
    }

    final void AFKeystoreWrapper(Context context, com.appsflyer.internal.av<Map<String, Object>> av2) {
        int obj3;
        Object obj4;
        ah.AFKeystoreWrapper();
        if (ah.AFInAppEventType(ah.AFKeystoreWrapper(context), "appsFlyerCount", false) <= 0) {
            if (!av2.values()) {
            } else {
                obj3 = new Thread(av2.AFInAppEventType);
                obj3.start();
                valueOf();
            }
        }
    }
}
