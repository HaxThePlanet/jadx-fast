package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

/* loaded from: classes.dex */
public final class cb {
    public static boolean AFInAppEventParameterName(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return context.getPackageManager().isInstantApp();
        }
        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
        return 1;
    }
}
