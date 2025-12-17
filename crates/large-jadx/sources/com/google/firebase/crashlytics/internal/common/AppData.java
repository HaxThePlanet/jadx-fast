package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;

/* loaded from: classes2.dex */
public class AppData {

    public final String buildId;
    public final String googleAppId;
    public final String installerPackageName;
    public final String packageName;
    public final UnityVersionProvider unityVersionProvider;
    public final String versionCode;
    public final String versionName;
    public AppData(String string, String string2, String string3, String string4, String string5, String string6, UnityVersionProvider unityVersionProvider7) {
        super();
        this.googleAppId = string;
        this.buildId = string2;
        this.installerPackageName = string3;
        this.packageName = string4;
        this.versionCode = string5;
        this.versionName = string6;
        this.unityVersionProvider = unityVersionProvider7;
    }

    public static com.google.firebase.crashlytics.internal.common.AppData create(Context context, com.google.firebase.crashlytics.internal.common.IdManager idManager2, String string3, String string4, UnityVersionProvider unityVersionProvider5) {
        String obj8;
        final String packageName = context.getPackageName();
        obj8 = context.getPackageManager().getPackageInfo(packageName, 0);
        if (obj8.versionName == null) {
            obj8 = "0.0";
        }
        super(string3, string4, idManager2.getInstallerPackageName(), packageName, Integer.toString(obj8.versionCode), obj8, unityVersionProvider5);
        return obj8;
    }
}
