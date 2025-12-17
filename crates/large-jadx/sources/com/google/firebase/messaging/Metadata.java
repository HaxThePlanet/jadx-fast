package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.l;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.List;

/* loaded from: classes2.dex */
class Metadata {

    private String appVersionCode;
    private String appVersionName;
    private final Context context;
    private int gmsVersionCode;
    private int iidImplementation = 0;
    Metadata(Context context) {
        super();
        final int i = 0;
        this.context = context;
    }

    static String getDefaultSenderId(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String obj3 = firebaseApp.getOptions().getApplicationId();
        if (!obj3.startsWith("1:")) {
            return obj3;
        }
        obj3 = obj3.split(":");
        final int i3 = 0;
        if (obj3.length < 2) {
            return i3;
        }
        obj3 = obj3[1];
        if (obj3.isEmpty()) {
            return i3;
        }
        return obj3;
    }

    private PackageInfo getPackageInfo(String string) {
        try {
            return this.context.getPackageManager().getPackageInfo(string, 0);
            string = string.toString();
            String str = "Failed to find package ";
            string = str.concat(string);
            str = "FirebaseMessaging";
            Log.w(str, string);
            string = null;
            return string;
        }
    }

    private void populateAppVersionInfo() {
        PackageInfo packageInfo = getPackageInfo(this.context.getPackageName());
        synchronized (this) {
            try {
                this.appVersionCode = Integer.toString(packageInfo.versionCode);
                this.appVersionName = packageInfo.versionName;
                throw th;
            }
        }
    }

    String getAppVersionCode() {
        synchronized (this) {
            try {
                populateAppVersionInfo();
                return this.appVersionCode;
                throw th;
            }
        }
    }

    String getAppVersionName() {
        synchronized (this) {
            try {
                populateAppVersionInfo();
                return this.appVersionName;
                throw th;
            }
        }
    }

    int getGmsVersionCode() {
        int gmsVersionCode;
        synchronized (this) {
            try {
                gmsVersionCode = getPackageInfo("com.google.android.gms");
                if (gmsVersionCode != null) {
                }
                this.gmsVersionCode = gmsVersionCode.versionCode;
                return this.gmsVersionCode;
                throw th;
            }
        }
    }

    int getIidImplementation() {
        List broadcastReceivers;
        boolean intentServices;
        int i;
        String str;
        int iidImplementation = this.iidImplementation;
        synchronized (this) {
            try {
                return iidImplementation;
                PackageManager packageManager = this.context.getPackageManager();
                int i4 = 0;
            }
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return i4;
        }
    }

    boolean isGmscorePresent() {
        if (getIidImplementation() != 0) {
            return 1;
        }
        return 0;
    }
}
