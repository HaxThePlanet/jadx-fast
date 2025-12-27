package com.bumptech.glide.s;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.bumptech.glide.load.f;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ApplicationVersionSignature.java */
/* loaded from: classes.dex */
public final class b {

    private static final ConcurrentMap<String, f> a = new ConcurrentHashMap<>();

    private static PackageInfo a(Context context) {
        try {
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
            StringBuilder str = new StringBuilder();
            String str2 = "Cannot resolve info for";
            context = context.getPackageName();
            context = str2 + context;
            str = "AppVersionSignature";
            Log.e(str, context, nameNotFound);
            context = null;
            return context;
        }
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
    }

    private static String b(PackageInfo packageInfo) {
        String uuid;
        if (packageInfo != null) {
            uuid = String.valueOf(packageInfo.versionCode);
        } else {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

    public static f c(Context context) {
        Object context2;
        final String packageName = context.getPackageName();
        final ConcurrentMap concurrentMap = b.a;
        if ((f)concurrentMap.get(packageName) == null) {
            context2 = b.a.putIfAbsent(packageName, b.d(context));
            if (context2 != null) {
            }
        }
        return context2;
    }

    private static f d(Context context) {
        return new d(b.b(b.a(context)));
    }
}
