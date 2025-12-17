package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes2.dex */
class InstallerPackageNameProvider {

    private static final String NO_INSTALLER_PACKAGE_NAME = "";
    private String installerPackageName;
    private static String loadInstallerPackageName(Context context) {
        String obj1;
        if (context.getPackageManager().getInstallerPackageName(context.getPackageName()) == null) {
            obj1 = "";
        }
        return obj1;
    }

    String getInstallerPackageName(Context context) {
        Object obj2;
        synchronized (this) {
            try {
                this.installerPackageName = InstallerPackageNameProvider.loadInstallerPackageName(context);
                if ("".equals(this.installerPackageName)) {
                } else {
                }
                obj2 = 0;
                obj2 = this.installerPackageName;
                return obj2;
                throw context;
            }
        }
    }
}
