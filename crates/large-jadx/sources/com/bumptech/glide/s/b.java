package com.bumptech.glide.s;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.f;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class b {

    private static final ConcurrentMap<String, f> a;
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        b.a = concurrentHashMap;
    }

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder str = new StringBuilder();
            str.append("Cannot resolve info for");
            context = context.getPackageName();
            str.append(context);
            context = str.toString();
            str = "AppVersionSignature";
            Log.e(str, context, th);
            context = null;
            return context;
        }
    }

    private static String b(PackageInfo packageInfo) {
        String obj0;
        if (packageInfo != null) {
            obj0 = String.valueOf(packageInfo.versionCode);
        } else {
            obj0 = UUID.randomUUID().toString();
        }
        return obj0;
    }

    public static f c(Context context) {
        Object obj;
        Object obj3;
        final String packageName = context.getPackageName();
        final ConcurrentMap map = b.a;
        if ((f)map.get(packageName) == null) {
            obj3 = map.putIfAbsent(packageName, b.d(context));
            if ((f)obj3 == null) {
            } else {
                obj = obj3;
            }
        }
        return obj;
    }

    private static f d(Context context) {
        d dVar = new d(b.b(b.a(context)));
        return dVar;
    }
}
