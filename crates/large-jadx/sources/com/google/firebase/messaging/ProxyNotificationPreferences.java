package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* loaded from: classes2.dex */
final class ProxyNotificationPreferences {
    private static SharedPreferences getPreference(Context context) {
        Context obj2;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            obj2 = applicationContext;
        }
        return obj2.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    static boolean isProxyNotificationInitialized(Context context) {
        return ProxyNotificationPreferences.getPreference(context).getBoolean("proxy_notification_initialized", false);
    }

    static void setProxyNotificationsInitialized(Context context, boolean z2) {
        SharedPreferences.Editor obj1 = ProxyNotificationPreferences.getPreference(context).edit();
        obj1.putBoolean("proxy_notification_initialized", true);
        obj1.apply();
    }
}
