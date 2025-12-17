package com.google.firebase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {

    private static final String ANDROID_INSTALLER = "android-installer";
    private static final String ANDROID_PLATFORM = "android-platform";
    private static final String DEVICE_BRAND = "device-brand";
    private static final String DEVICE_MODEL = "device-model";
    private static final String DEVICE_NAME = "device-name";
    private static final String FIREBASE_ANDROID = "fire-android";
    private static final String FIREBASE_COMMON = "fire-core";
    private static final String KOTLIN = "kotlin";
    private static final String MIN_SDK = "android-min-sdk";
    private static final String TARGET_SDK = "android-target-sdk";
    static String a(Context context) {
        android.content.pm.ApplicationInfo obj0 = context.getApplicationInfo();
        if (obj0 != null) {
            return String.valueOf(obj0.targetSdkVersion);
        }
        return "";
    }

    static String b(Context context) {
        int sDK_INT;
        int i;
        android.content.pm.ApplicationInfo obj2 = context.getApplicationInfo();
        if (obj2 != null && Build.VERSION.SDK_INT >= 24) {
            if (Build.VERSION.SDK_INT >= 24) {
                return String.valueOf(obj2.minSdkVersion);
            }
        }
        return "";
    }

    static String c(Context context) {
        int sDK_INT;
        int systemFeature;
        int systemFeature2;
        int systemFeature3;
        String str;
        boolean obj3;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 16 && context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                return "tv";
            }
        }
        if (sDK_INT >= 20 && context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                return "watch";
            }
        }
        if (sDK_INT >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                return "auto";
            }
        }
        if (sDK_INT >= 26 && context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                return "embedded";
            }
        }
        return "";
    }

    static String d(Context context) {
        String obj1;
        obj1 = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (obj1 != null) {
            obj1 = FirebaseCommonRegistrar.safeValue(obj1);
        } else {
            obj1 = "";
        }
        return obj1;
    }

    private static String safeValue(String string) {
        final int i3 = 95;
        return string.replace(' ', i3).replace('/', i3);
    }

    public List<Component<?>> getComponents() {
        Object detectVersion;
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(DefaultUserAgentPublisher.component());
        arrayList.add(DefaultHeartBeatInfo.component());
        arrayList.add(LibraryVersionComponent.create("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(LibraryVersionComponent.create("fire-core", "20.0.0"));
        arrayList.add(LibraryVersionComponent.create("device-name", FirebaseCommonRegistrar.safeValue(Build.PRODUCT)));
        arrayList.add(LibraryVersionComponent.create("device-model", FirebaseCommonRegistrar.safeValue(Build.DEVICE)));
        arrayList.add(LibraryVersionComponent.create("device-brand", FirebaseCommonRegistrar.safeValue(Build.BRAND)));
        arrayList.add(LibraryVersionComponent.fromContext("android-target-sdk", c.a));
        arrayList.add(LibraryVersionComponent.fromContext("android-min-sdk", d.a));
        arrayList.add(LibraryVersionComponent.fromContext("android-platform", e.a));
        arrayList.add(LibraryVersionComponent.fromContext("android-installer", b.a));
        detectVersion = KotlinDetector.detectVersion();
        if (detectVersion != null) {
            arrayList.add(LibraryVersionComponent.create("kotlin", detectVersion));
        }
        return arrayList;
    }
}
