package com.google.firebase.iid;

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
public class Metadata {

    private String appVersionCode;
    private String appVersionName;
    private final Context context;
    private int gmsVersionCode;
    private int iidImplementation = 0;
    public Metadata(Context context) {
        super();
        final int i = 0;
        this.context = context;
    }

    public static String getDefaultSenderId(FirebaseApp firebaseApp) {
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
            string = String.valueOf(string);
            String str = String.valueOf(string);
            str = str.length();
            str += 23;
            StringBuilder stringBuilder = new StringBuilder(str);
            str = "Failed to find package ";
            stringBuilder.append(str);
            stringBuilder.append(string);
            string = stringBuilder.toString();
            str = "FirebaseInstanceId";
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

    public String getAppVersionCode() {
        synchronized (this) {
            try {
                populateAppVersionInfo();
                return this.appVersionCode;
                throw th;
            }
        }
    }

    public String getAppVersionName() {
        synchronized (this) {
            try {
                populateAppVersionInfo();
                return this.appVersionName;
                throw th;
            }
        }
    }

    public int getGmsVersionCode() {
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

    public int getIidImplementation() {
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
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return i4;
        }
    }

    public boolean isGmscorePresent() {
        if (getIidImplementation() != 0) {
            return 1;
        }
        return 0;
    }
}
