package com.google.firebase.messaging;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.l;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class ProxyNotificationInitializer {
    private static boolean allowedToUse(Context context) {
        if (Binder.getCallingUid() == obj1.uid) {
            return 1;
        }
        return 0;
    }

    static void initialize(Context context) {
        if (ProxyNotificationPreferences.isProxyNotificationInitialized(context)) {
        }
        ProxyNotificationInitializer.setEnableProxyNotification(ProxyNotificationInitializer$$ExternalSyntheticLambda1.INSTANCE, context, ProxyNotificationInitializer.shouldEnableProxyNotification(context));
    }

    static boolean isProxyNotificationEnabled(Context context) {
        boolean obj4;
        int i = 3;
        final int i2 = 0;
        final String str3 = "FirebaseMessaging";
        if (!l.j() && Log.isLoggable(str3, i)) {
            if (Log.isLoggable(str3, i)) {
                Log.d(str3, "Platform doesn't support proxying.");
            }
            return i2;
        }
        if (!ProxyNotificationInitializer.allowedToUse(context)) {
            obj4 = String.valueOf(context.getPackageName());
            String str2 = "error retrieving notification delegate for package ";
            if (obj4.length() != 0) {
                obj4 = str2.concat(obj4);
            } else {
                obj4 = new String(str2);
            }
            Log.e(str3, obj4);
            return i2;
        }
        if ("com.google.android.gms".equals((NotificationManager)context.getSystemService(NotificationManager.class).getNotificationDelegate()) && Log.isLoggable(str3, i)) {
            if (Log.isLoggable(str3, i)) {
                Log.d(str3, "GMS core is set for proxying");
            }
            return 1;
        }
        return i2;
    }

    static void lambda$setEnableProxyNotification$0(Context context, boolean z2, k k3) {
        String obj3;
        boolean obj4;
        final int i = 0;
        if (!ProxyNotificationInitializer.allowedToUse(context)) {
            try {
                String str2 = "error configuring notification delegate for package ";
                obj3 = String.valueOf(context.getPackageName());
                if (obj3.length() != 0) {
                } else {
                }
                obj3 = str2.concat(obj3);
                obj3 = new String(str2);
                Log.e("FirebaseMessaging", obj3);
                k3.e(i);
                ProxyNotificationPreferences.setProxyNotificationsInitialized(context, true);
                obj3 = context.getSystemService(NotificationManager.class);
                String str = "com.google.android.gms";
                if (z2) {
                } else {
                }
                (NotificationManager)obj3.setNotificationDelegate(str);
                if (str.equals(obj3.getNotificationDelegate())) {
                }
                obj3.setNotificationDelegate(i);
                k3.e(i);
                k3.e(obj0);
                throw context;
            }
        }
    }

    static j<Void> setEnableProxyNotification(Executor executor, Context context2, boolean z3) {
        if (!l.j()) {
            return m.e(0);
        }
        k kVar = new k();
        ProxyNotificationInitializer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ProxyNotificationInitializer$$ExternalSyntheticLambda0(context2, z3, kVar);
        executor.execute(externalSyntheticLambda0);
        return kVar.a();
    }

    private static boolean shouldEnableProxyNotification(Context context) {
        PackageManager packageManager;
        int i;
        Object obj3;
        final String str = "firebase_messaging_notification_delegation_enabled";
        obj3 = context.getApplicationContext();
        packageManager = obj3.getPackageManager();
        obj3 = packageManager.getApplicationInfo(obj3.getPackageName(), 128);
        packageManager = obj3.metaData;
        if (packageManager != null && obj3 != null && packageManager != null && packageManager.containsKey(str)) {
            obj3 = packageManager.getApplicationInfo(obj3.getPackageName(), 128);
            if (obj3 != null) {
                try {
                    packageManager = obj3.metaData;
                    if (packageManager != null) {
                    }
                    if (packageManager.containsKey(str)) {
                    }
                    return obj3.metaData.getBoolean(str);
                    return 1;
                }
            }
        }
    }
}
