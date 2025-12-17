package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.Random;

/* loaded from: classes.dex */
public final class al {

    private static String valueOf;
    static {
    }

    public static String AFInAppEventType(WeakReference<Context> weakReference) {
        Object valueOf2;
        Object string;
        int valueOf;
        boolean exists;
        String stringBuilder;
        Object obj4;
        final Class<com.appsflyer.internal.al> obj = al.class;
        synchronized (obj) {
            return al.valueOf;
        }
    }

    private static String AFKeystoreWrapper(File file) {
        String str;
        Throwable th;
        byte[] bArr;
        Throwable th2;
        RandomAccessFile randomAccessFile;
        String str2;
        long length;
        Throwable th3;
        int obj6;
        str = "Exception while trying to close the InstallationFile";
        int i = 0;
        randomAccessFile = new RandomAccessFile(file, "r");
        randomAccessFile.readFully(new byte[(int)length]);
        randomAccessFile.close();
        randomAccessFile.close();
        try {
            if (bArr != null) {
            } else {
            }
            bArr = new byte[0];
            obj6 = new String(bArr);
            return obj6;
            if (th == null) {
            } else {
            }
            th.close();
            AFLogger.AFKeystoreWrapper(obj0, th);
            throw file;
        }
    }
}
